

public class Interface {
    interface Animal {
        public void eat();

        public void sound();

        public void printNoLegs();

    }

    interface Bird {
        static int NUMBEROFLEGS = 2;

        public void fly();

    }

    static class Eagle implements Animal, Bird {
        public void eat() {
            System.out.println("Eats reptiles and animals.");
        }

        public void sound() {
            System.out.println("Has a high-pitched whistling sound.");
        }

        public void fly() {
            System.out.println("Flies up to 10,000 feet.");
        }

        public void printNoLegs() {
            System.out.println(NUMBEROFLEGS);
        }
    }

    public static void main(String[] args) {
        Eagle myEagle = new Eagle();
        myEagle.eat();
        myEagle.sound();
        myEagle.fly();
        myEagle.printNoLegs();

    }
}
