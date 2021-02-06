package lesson7.classwork;

public class Ball {
    private String color;
    private boolean busy;

    public Ball(String color) {
        this.color = color;
        this.busy = false;
    }

    public String getColor() {
        return color;
    }

    public boolean isBusy() {
        return busy;
    }


    public void setColor(String color) {
        this.color = color;
    }

    public void setBusy(boolean busy) {
        this.busy = busy;
    }
}
