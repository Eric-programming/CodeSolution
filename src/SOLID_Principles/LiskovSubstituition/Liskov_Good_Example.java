public class Liskov_Good_Example {
    public static void main(String[] args) {
        Swimming_Bird p = new Good_Example_Peguin();
        Flying_Bird e = new Good_Example_Eagle();

        p.Swim();

        e.Fly();
    }
}

class Flying_Bird {
    public void Fly() {
        System.out.println("I can fly...");
    }
}

class Swimming_Bird {
    public void Swim() {
        System.out.println("I can Swim...");
    }
}

class Good_Example_Peguin extends Swimming_Bird {
}

class Good_Example_Eagle extends Flying_Bird {

}