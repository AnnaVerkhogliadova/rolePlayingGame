import java.util.Random;

public class Battle extends Thread {
    private static final Random RANDOM = new Random();

    Monsters monsters;
    Player player;

    public Battle(Monsters monsters, Player player) {
        this.monsters = monsters;
        this.player = player;
    }

    public void run() {
        hit(monsters, player);
    }

    public void hit(Monsters monsters, Player player) {
        boolean isPlayerAttack = RANDOM.nextBoolean();
        World world = new World();
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
                        world.choice();
                        break;
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
                        break;
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
