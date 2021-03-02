import java.util.Random;
import java.util.concurrent.Callable;

public class Battle implements Callable<BattleState> {
    private static final Random RANDOM = new Random();

    Monsters monsters;
    Player player;

    public Battle(Monsters monsters, Player player) {
        this.monsters = monsters;
        this.player = player;
    }

    public BattleState call() {
        return hit(monsters, player);
    }

    public BattleState hit(Monsters monsters, Player player) {
        boolean isPlayerAttack = RANDOM.nextBoolean();

        while (true) {
            isPlayerAttack = !isPlayerAttack;
            if (isPlayerAttack) {
                int playerAttack = player.attack();
                if (playerAttack != 0) {
                    int newHpMonster = monsters.getHp() - playerAttack;
                    if (newHpMonster <= 0) {
                        System.out.println("Бой выигран");
                        player.setGold(player.getGold() + monsters.getGold());
                        player.setExperience(player.getExperience() + monsters.getExperience());
                        return BattleState.WIN;
                    } else {
                        System.out.println("Отняли " + playerAttack + " hp у монстра");
                        monsters.setHp(newHpMonster);
                    }
                } else {
                    System.out.println("Промах");
                }
            } else {
                int monsterAttack = monsters.attack();
                if (monsterAttack != 0) {
                    int newHpPlayer = player.getHp() - monsterAttack;
                    if (newHpPlayer <= 0) {
                        System.out.println("Бой проигран");
                        return BattleState.LOSE;
                    } else {
                        System.out.println("Отняли " + monsterAttack + " hp у игрока");
                        player.setHp(newHpPlayer);
                    }
                } else {
                    System.out.println("Промах");
                }
            }
        }

    }
}
