

import java.util.ArrayList;
import java.util.List;

public class Abstraction {
    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Bird());
        animals.add(new Fish());
        for (Animal eachAnimal : animals) {
            eachAnimal.move();
            eachAnimal.eat();
            eachAnimal.sleep();
        }
    }

    static abstract class Animal {
        // abstract methods
        abstract void move();

        abstract void eat();

        // concrete method
        void sleep() {
            System.out.println("Sleeping....");
        }

        abstract String getName();

        void intro() {
            System.out.println("Hi! I am a " + getName());
        }
    }

    static class Bird extends Animal {
        private static final String NAME = "Bird";

        void move() {
            System.out.println("Moves by flying.");
        }

        void eat() {
            System.out.println("Eats birdfood.");
        }

        String getName() {
            return NAME;
        }

    }

    static class Fish extends Animal {
        private static final String NAME = "Fish";

        void move() {
            System.out.println("Moves by swimming.");
        }

        void eat() {
            System.out.println("Eats seafood.");
        }

        String getName() {
            return NAME;
        }
    }
}
