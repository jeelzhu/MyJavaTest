package other;

import java.util.concurrent.Callable;


public class MathUtils {
    public static double average(int a, int b) {
        return a + b / 2;
    }

}


interface Bird {
    Egg lay();
}

class Chicken implements Bird{
    public Chicken() {
    }

    public static void main(String[] args) throws Exception {
        Chicken chicken = new Chicken();
        Egg egg = chicken.lay();
        System.out.println(egg.hatch() instanceof Bird);
    }

    @Override
    public Egg lay() {
        return new Egg(new HatchedBird<>(this));
    }
}

 class HatchedBird<T extends Bird> implements Callable<Bird> {

    private T t;
    public HatchedBird(T t){
        this.t = t;

    }
     @Override
     public Bird call() {
         return t;
     }
 }

class Egg {
    private Callable<Bird> createBird;
    public Egg(Callable<Bird> createBird) {
        this.createBird = createBird;
    }

    public Bird hatch() throws Exception {
        return this.createBird.call();
    }
}