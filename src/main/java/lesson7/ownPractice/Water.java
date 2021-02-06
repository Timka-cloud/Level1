package lesson7.ownPractice;

public class Water {
    private int volume;
    private int count = 0;
    public Water() {
        this.volume = 10;


    }

    public int getCount() {
        count++;
        return count;
    }


    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public void decrease(int n){
        volume -= n;
    }

    public void add(int amount){
        volume += amount;
        System.out.println("Добавили воды " + amount + "л");
    }

    public void info(){
        System.out.println("volume: " + volume + "л");
    }
}
