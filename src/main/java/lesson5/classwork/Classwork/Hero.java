package lesson5.classwork.Classwork;

import java.util.Random;

public class Hero {
    private HeroClass heroClass;
    private String name;
    private int hp;
    private int maxHp;
    private int attack;
    private int avoidChance;
    private Random random  = new Random();

//    private int exp;
//    private int expTo;
//    private int level;

    public Hero(String name, HeroClass heroClass){
//        this.level = 1;
//        this.expTo = 10;
        this.name = name;
        this.heroClass = heroClass;
        switch (heroClass){
            case BARBARIAN:
                maxHp = 4;
                attack = 4;
                avoidChance = 30;
                break;
            case KNIGHT:
                maxHp = 8;
                attack = 2;
                avoidChance = 20;
                break;
            case ROGUE:
                maxHp = 4;
                attack = 3;
                avoidChance = 30;
                break;
        }
        hp = maxHp;
    }

//    public void addExp(int amount){
//        exp += amount;
//        if(exp >= expTo){
//            exp = 0;
//            level++;
//            System.out.println(name + " повысил уровень");
//        }
//    }

    public int getAttack() {
        return attack;
    }

    public void printInfo(){
        System.out.printf("Класс: %s Имя: %s\n", heroClass, name);
        System.out.printf("HP: %d/%d Attack: %d\n", hp,maxHp , attack);
    }

    public void defenceYourself(){
        if(random.nextInt(100) < avoidChance){
            hp += 2;
            if(hp > maxHp){
                hp = maxHp;
            }
            System.out.println("Герой восстановил здоровье");
        }
        else{
            System.out.println("Герою не удалось залечиться");
        }



    }

    public void takeDamage(int amount){
        hp -= amount;
        System.out.printf("%s получил %d ед. урона \n", name, amount);
    }

    public boolean isAlive(){
        return hp > 0;
    }
}
