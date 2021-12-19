/**
 * Derived Class or element should be able to substitute their base Class or
 * element.(Child class should be able to substitute its parent class)
 */
public class Liskov_Bad_Example {
    public static void main(String[] args) {
        Bird p = new Bad_Example_Peguin();
        Bird e = new Bad_Example_Eagle();

        p.Fly();

        e.Fly();
    }
}

class Bird {
    public void Fly() {
        System.out.println("I can fly...");
    }
}

class Bad_Example_Peguin extends Bird {
    public void Fly() {
        System.out.println("I can't fly...");// It works differently compare to its parent class
    }

    public void Swim() {
        System.out.println("I can swim...");
    }
}

class Bad_Example_Eagle extends Bird {
}