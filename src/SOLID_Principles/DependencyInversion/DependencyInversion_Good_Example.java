public class DependencyInversion_Good_Example {
    public static void main(String[] args) {

    }
}

class Online_Store_Good_Example {
    private IPaymentProcessor paymentProcessor;

    public Online_Store_Good_Example(IPaymentProcessor paymentProcessor) {
        super();
        this.paymentProcessor = paymentProcessor;
    }

    public void makeAPaymentForAComputer(int quantity) {
        this.paymentProcessor.makeAPayment(quantity * 10);
    }
}

interface IPaymentProcessor {
    public void makeAPayment(int total);
}

class Paypal_GoodExample implements IPaymentProcessor {
    public Paypal_GoodExample() {
        super();
    }

    public void makeAPaymentWithPaypal(int total) {
        System.out.println("Paid => " + total + " by Paypal");
    }

    @Override
    public void makeAPayment(int total) {

        makeAPaymentWithPaypal(total);
    }
}

class Stripe_GoodExample implements IPaymentProcessor {
    public Stripe_GoodExample() {
        super();
    }

    public void makeAPaymentWithStripe(int total) {
        System.out.println("Paid => " + total + " by Stripe");
    }

    @Override
    public void makeAPayment(int total) {

        makeAPaymentWithStripe(total);
    }
}