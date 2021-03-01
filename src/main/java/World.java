import java.util.Random;
import java.util.Scanner;

public class World {
    private static final Random RANDOM = new Random();
    Player player = createPlayer();

    public static void main(String[] args) {
        World world =  new World();
        world.choice();
    }

    public void choice(){
        Scanner s = new Scanner(System.in);
        System.out.println("Выберите действие: " +
                "1)К торговцу" + " 2)В темный лес" + " 3)На выход");
        switch (s.nextInt()) {
            case 1:
                Dealer dealer = new Dealer();
                dealer.potion();
                break;
            case 2:
                Battle battle = new Battle(createMonster(), createPlayer());
                battle.start();
                System.out.println("Бой начинается");
                break;
            case 3:
                System.out.println("Всего доброго!");
                break;
        }
    }

    private static Player createPlayer(){
        return new Player("Anna", 100, 30, 40, 0, 2);
    }

    private static Monsters createMonster(){
        if(RANDOM.nextBoolean()){
            return new Goblin("Putin", 100, 0,40,60,2 );
        } else {
            return new Skeleton("Afonya", 100,0, 35, 10, 2);
        }
    }
}
