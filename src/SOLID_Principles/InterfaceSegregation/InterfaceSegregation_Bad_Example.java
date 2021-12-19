/**
 * When we create a interface and implement this interface. We should have use
 * all the features that are inside that interface
 */
public class InterfaceSegregation_Bad_Example {
    public static void main(String[] args) {

    }
}

interface Ifeatures_Bad_Examples {
    public void read();

    public void write();

    public void run();

    public void sleep();
}

class Person1_Bad_Example implements Ifeatures_Bad_Examples {
    @Override
    public void read() {
        System.out.println("I am reading");

    }

    @Override
    public void write() {

    }

    @Override
    public void run() {

    }

    @Override
    public void sleep() {

    };

}

class Person2_Bad_Example implements Ifeatures_Bad_Examples {
    @Override
    public void read() {
        System.out.println("I am reading");

    }

    @Override
    public void write() {
        System.out.println("I am writing");

    }

    @Override
    public void run() {

    }

    @Override
    public void sleep() {

    };

}