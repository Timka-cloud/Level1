package lesson5.classwork.Classwork;

import java.util.Random;

public class Monster {
    private MonsterClass monsterClass;
    private int hp;
    private int maxHp;
    private int attack;

    public int getAttack() {
        return attack;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public Monster(){
        this.monsterClass = MonsterClass.values()[new Random().nextInt(1)];
        switch (monsterClass){
            case GOBLIN:
                maxHp = 4;
                attack = 2;
                break;
//            case ORC:
//                maxHp = 5;
//                attack = 2;
//                break;
//            case TROLL:
//                maxHp = 7;
//                attack = 3;
//                break;
        }
        hp = maxHp;
    }

    public void printInfo(){
        System.out.printf("Тип: %s\n", monsterClass);
        System.out.printf("HP: %d/%d Attack: %d\n", hp,maxHp , attack);
    }

    public void takeDamage(int amount){
        hp -= amount;
        System.out.printf("%s получил %d ед. урона \n", monsterClass, amount);
    }

    public boolean isAlive(){
        return hp > 0;
    }
}
