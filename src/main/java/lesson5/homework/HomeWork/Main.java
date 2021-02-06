package lesson5.homework.HomeWork;

public class Main {
    public static void main(String[] args) {
        Employees[] employees = {
                new Employees("Sergey", "CEO", "sergey@mail.ru", "87546", 10000,47),
                new Employees("Aleks", "manager", "aleks@mail.ru", "823446", 87000,35),
                new Employees("Marina", "HR", "marina@mail.ru", "45345", 77899,50),
                new Employees("Vanya", "programmer", "vanya@mail.ru", "345345", 90000,30),
                new Employees("Linda", "designer", "linda@mail.ru", "234646", 60000,34)
        };
        for(Employees e : employees){
            if(e.getAge() >= 40){
                e.printInfo();
                System.out.println();
            }
        }
    }
}
