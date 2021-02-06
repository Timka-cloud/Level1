package lesson7.ownPractice;

public class Person {
    private String name;
    private int waterConsumption;
    private boolean thirsty;


    public Person(String name, int waterConsumption) {
        this.name = name;
        this.waterConsumption = waterConsumption;
        this.thirsty = false;
    }

    public boolean isThirsty() {
        return thirsty;
    }

    public void drink(Water water){
        if(waterConsumption > water.getVolume()){
            water.decrease(waterConsumption);
            System.out.println(name + " напился воды " + thirsty);
            int remainder = Math.abs(water.getVolume());
            System.out.println("Нехватило для полного счастье " + remainder + "л");
            waterConsumption = remainder;
            water.setVolume(0);
            return;
        }else {
            water.decrease(waterConsumption);
            thirsty = true;
            System.out.println(name + " напился воды " + thirsty);
        }
    }
}
