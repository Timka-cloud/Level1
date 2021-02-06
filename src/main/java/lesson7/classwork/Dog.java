package lesson7.classwork;

public class Dog {
    private String name;
    private Ball capturedBall;

    public Dog(String name) {
        this.name = name;
    }

    public void play(Ball ball){
        if(capturedBall == ball){
            System.out.println(name + " is already playing with this " + ball.getColor() + " ball");
            return;
        }
        if(capturedBall != null){
            System.out.println(name + " is already playing, don't need other balls");
            return;
        }
        if(!ball.isBusy()){
            ball.setBusy(true);
            capturedBall = ball;
            System.out.println(name  + " started playing with " + ball.getColor() + " ball");
        } else{
            System.out.println(name + " ball " + ball.getColor() + " is busy");
        }
    }

    public void stop(){
        if(capturedBall != null){
            System.out.println(name + " stopped playing with " + capturedBall.getColor() + " ball");
            capturedBall.setBusy(false);
            capturedBall = null;
        }
        else {
            System.out.println("This " + name + " doesn't have a ball");
        }


    }
}
