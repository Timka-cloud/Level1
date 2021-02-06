package lesson7.homework;

public class Cat {
    private String name;
    private int appetite;
    private boolean satiety;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = false;
    }

    public int getAppetite() {
        return appetite;
    }

    public boolean getSatiety(){
        return satiety;
    }

    public void eat(Plate p) {
        if(appetite > p.getFood()){
            System.out.println("Кот собираетя сьесть больше чем есть в миске, отказано");
            System.out.println(name + " кот сытость " + satiety);
            return;
        } else{
            p.decreaseFood(appetite);
            satiety = true;
            System.out.println(name + " кот сытость " + satiety);
        }

    }

}
