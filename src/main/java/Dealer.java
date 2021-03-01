public class Dealer extends World {
    public void potion() {
        if (player.getGold() >= 10) {
            player.setHp(player.getHp() + 20);
            player.setGold(player.getGold() - 10);
        } else {
            System.out.println("У вас недостаточно золота для покупки зелья");
        }
    }
}
