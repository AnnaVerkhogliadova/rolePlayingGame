import java.util.Random;

public abstract class Сharacters {
    private String name;
    private int hp;
    private int gold;
    private int dexterity; //ловкость
    private int experience; //опыт
    private int strength;  //сила

    public Сharacters(String name, int hp, int gold, int dexterity, int experience, int strength) {
        this.name = name;
        this.hp = hp;
        this.gold = gold;
        this.dexterity = dexterity;
        this.experience = experience;
        this.strength = strength;
    }

    public int attack() {
        int hit = dexterity * 3;
        if (hit > RandomV()) {
            return strength;
        } else {
            return 0;
        }
    }

    protected int RandomV() {
        Random random = new Random();
        return random.nextInt(100);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }
}
