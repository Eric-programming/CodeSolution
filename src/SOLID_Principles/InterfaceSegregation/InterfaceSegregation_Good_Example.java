public class InterfaceSegregation_Good_Example {
    public static void main(String[] args) {

    }
}

interface Ifeatures_Good_Examples {
    public void read();

    public void write();

    public abstract void run();

    public abstract void sleep();
}

interface Ifeatures_Writing_Good_Examples {
    public void write();

}

interface Ifeatures_Reading_Good_Examples {
    public void read();

}

interface ITogether {
    public void read();

    public void write();

}

class Person1_Good_Example implements Ifeatures_Reading_Good_Examples {
    @Override
    public void read() {
        System.out.println("I am reading");
    }
}

class Person2_Good_Example implements ITogether {
    @Override
    public void read() {
        System.out.println("I am reading");
    }

    @Override
    public void write() {
        System.out.println("I am writing");
    }
}