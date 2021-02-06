package lesson6.classwork;

public class Box {
    private String color;
    private int size;

    public Box(String color, int size) {
        this.color = color;
        this.size = size;
    }

    @Override
    public String toString(){
        return String.format("Box [color: %s, size: %d]", color,size);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){  // this это ссылка на обьект который вызывает метод equals
            return true;
        }
        if(!(obj instanceof Box)){
            return false;
        }
        Box another = (Box) obj;
        return this.color.equals(another.color) && this.size == another.size;

    }

    public static void main(String[] args) {
        Box box1 = new Box("Red",5);
        Box box2 = new Box("Red",5);
        String s = "Hi";
        String s2 = "Hi";
        System.out.println(box1);
        System.out.println(box2);
        System.out.println(s.equals(s2));
        System.out.println(box1.equals(box2));
    }
}
