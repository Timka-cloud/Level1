package lesson5.classwork.Classwork;

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Hero player;
    static Monster monster;
    static int travelDirection;
    static int i = 0;

    public static void main(String[] args) {
        startYourJourney();
        player.printInfo();
        System.out.println("Чтобы пройти игру нужно пройти все местности, выберите местность: ");
        travelPhase();
        if (travelDirection == 2 || travelDirection == 1 || travelDirection == 3) {
            battlePhase();
        }

        System.out.println("Игра закончена.");
    }


    public static void startYourJourney() {
        System.out.println("Вы начинаете свое путешествие. Введи свое имя, отважный Герой!");
        String heroName = sc.nextLine();
        int classIndex = showUserAction("Представься пожалуйста, каково твое призвание?", HeroClass.values()[0].toString(), HeroClass.values()[1].toString(), HeroClass.values()[2].toString());
        player = new Hero(heroName, HeroClass.values()[classIndex - 1]);
        System.out.println("Ваше приключение начинается!");
    }

    public static void battlePhase() {
        i++;
        System.out.println("Вы встречаете злобного монстра");
        monster = new Monster();
        monster.printInfo();
        do {
            int playerAction = showUserAction("Ход игрока. Выберите действие", "Атака", "Защита");
            if(playerAction == 1){
                monster.takeDamage(player.getAttack());
            }
            if(checkWin()){
                /**
                 * есть ошибка в коде, после прохождение всех местностей он все ровно продолжает выполнять
                 * где закоменттировано там проблема
                 */
//                if(i < 3){
//                    battlePhase();
//                }
//                System.out.println("Вы прошли все местности, молодец");
                break;

            }

            else if(playerAction == 2){
                player.defenceYourself();
            }

            System.out.println("Ход монстра");
            player.takeDamage(monster.getAttack());
            if(checkMonsterWin()){
                break;
            }

            System.out.println("Состояние участников боя:");
            player.printInfo();
            monster.printInfo();


        } while (player.isAlive() && monster.isAlive()) ;

    }





    public static void travelPhase() {

        travelDirection = showUserAction("Куда Вы хотите отправиться?", "Лес", "Пещера", "Горы");
    }

    public static boolean checkMonsterWin(){
        if(!player.isAlive()){
            System.out.println("Вы проиграли, монстр победил");
            return true;
        }
        return false;
    }

    public static boolean checkWin(){

        if(!monster.isAlive()){
            System.out.println("Вы выиграли, монстр побежден");
            return true;
        }

        return false;
    }


    public static int showUserAction(String question, String... variants) {
        int userInput;
        do {
            System.out.println(question);
            for (int i = 0; i < variants.length; i++) {
                System.out.println((i + 1) + ". " + variants[i]);
            }
            userInput = sc.nextInt();
        } while (userInput < 1 || userInput > variants.length);
        return userInput;
    }
}
