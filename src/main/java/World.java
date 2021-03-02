import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class World {
    private static final Random RANDOM = new Random();
    Player player = createPlayer();
    static ExecutorService executor = Executors.newFixedThreadPool(1);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        World world = new World();
        world.choice();
        executor.shutdown();
    }

    public void choice() throws ExecutionException, InterruptedException {
        do {
            Scanner s = new Scanner(System.in);
            System.out.println("Выберите действие: " +
                    "1)К торговцу" + " 2)В темный лес" + " 3)На выход");
            switch (s.nextInt()) {
                case 1:
                    Dealer dealer = new Dealer(player);
                    dealer.potion();
                    break;
                case 2:
                    player.setHp(100);
                    Battle battle = new Battle(createMonster(), player);
                    System.out.println("Бой начинается");
                    Future<BattleState> future = executor.submit(battle);
                    BattleState battleState = future.get();
                    if(battleState == BattleState.LOSE){
                        return;
                    }
                    break;
                case 3:
                    System.out.println("Всего доброго!");
                    return;
            }
        } while (true);
    }

    private static Player createPlayer() {
        return new Player("Anna", 0, 30, 40, 0, 2);
    }

    private static Monsters createMonster() {
        if (RANDOM.nextBoolean()) {
            return new Goblin("Putin", 100, 0, 40, 60, 2);
        } else {
            return new Skeleton("Afonya", 100, 0, 35, 10, 2);
        }
    }
}
