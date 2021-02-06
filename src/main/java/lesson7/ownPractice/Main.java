package lesson7.ownPractice;

public class Main {
        private static int counts = 0;
    public static void main(String[] args) {
        System.out.println("У нас три бутылки");
        Water[] waters = {
                new Water(),
                new Water(),
                new Water()
        };

        Person[] persons = {
                new Person("Aleks", 9),
                new Person("Dan", 3),
                new Person("Lina", 4),
                new Person("Maks", 5)
        };
        for(Person p : persons){

            for(Water w : waters){
                drinking(w,p);

            }


//            if(!(p.isThirsty()) && water1.getVolume() > 0) {
//                System.out.println("Первая бутылка: ");
//                water1.info();
//                p.drink(water1);
//                water1.info();
//                System.out.println("====");
//            }
//
//            if(!(p.isThirsty()) && water2.getVolume() > 0){
//                System.out.println("Вторая бутылка: ");
//                water2.info();
//                p.drink(water2);
//                water2.info();
//                System.out.println("====");
//            }
//
//            if(!(p.isThirsty()) && water3.getVolume() > 0){
//                System.out.println("Третья бутылка: ");
//                water3.info();
//                p.drink(water3);
//                water3.info();
//                System.out.println("====");
//            }






//            if(water.getVolume() <= 0){
//                water.add(5);
//                if(!(p.isThirsty())){
//                    p.drink(water);
//                    water.info();
//                    System.out.println("====");
//
//                }
//
//            }



        }

    }
    public static void drinking(Water water, Person person){
        if(!(person.isThirsty()) && water.getVolume() > 0) {

            water.info();
            person.drink(water);
            water.info();
            System.out.println("====");
        }

    }
}
