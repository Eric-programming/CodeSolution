public class OpenClosed_Good_Example {
    public static void main(String[] args) {

    }
}

// Good Example
abstract class Product_Delivery {
    String name;
    int price;

    public Product_Delivery(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public abstract int calculate_delivery();
}

class LargeProduct extends Product_Delivery {
    public LargeProduct(String name, int price) {
        super(name, price);
    }

    public int calculate_delivery() {
        return this.price + 5;
    };
}

class SmallProduct extends Product_Delivery {
    public SmallProduct(String name, int price) {
        super(name, price);
    }

    public int calculate_delivery() {
        return this.price + 10;
    };
}