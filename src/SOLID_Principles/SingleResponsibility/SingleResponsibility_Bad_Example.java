/**
 * Each class & module should only have one purpose
 */
public class SingleResponsibility_Bad_Example {

    public static void main(String[] args) {
        ProductManipulator_Bad p = new ProductManipulator_Bad(12, "product");

        p.edit_price(1234);

        System.out.println(p.calculateGST(7));
    }
}

class ProductManipulator_Bad {
    public int price;
    public String product;

    public ProductManipulator_Bad(int price, String product) {
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

    public int calculatePST(int pstPercentage) {
        return price * (pstPercentage / 100);// We are breaking the SRP because this class we have more than 1
                                             // responsibility
    }

    public int calculateGST(int gstPercentage) {
        return price * (gstPercentage / 100);
    }

}