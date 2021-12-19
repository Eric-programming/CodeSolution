public class SingleResponsibility_Good_Example {
    public static void main(String[] args) {
        ProductManipulator_Good p = new ProductManipulator_Good(123, "product");
        p.edit_price(321);

        Calculation c = new Calculation();
        c.calculateGST(p.price, 7);
    }
}

class ProductManipulator_Good {
    public int price;
    public String product;

    public ProductManipulator_Good(int price, String product) {
        super();
        this.price = price;
        this.product = product;
    }

    public void edit_price(int price) {
        this.price = price;
    }

    public void edit_product(String product) {
        this.product = product;
    }
}

class Calculation {
    public int calculatePST(int pstPercentage, int price) {
        return price * (pstPercentage / 100);
    }

    public int calculateGST(int gstPercentage, int price) {
        return price * (gstPercentage / 100);
    }
}