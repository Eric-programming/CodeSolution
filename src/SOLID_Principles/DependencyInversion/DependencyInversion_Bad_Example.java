/**
 * If we have a class that has a dependency, and that dependency must have
 * predefined interface. So if we ever want to change our dependency, we will
 * depend on the interface that we create instead of the dependency
 */
public class DependencyInversion_Bad_Example {
    public static void main(String[] args) {
        Online_Store_Bad_Example o = new Online_Store_Bad_Example(new Paypal_BadExample());
        o.makeAPaymentForAComputer(12);
    }
}

class Online_Store_Bad_Example {
    private Paypal_BadExample paymentProcessor;

    public Online_Store_Bad_Example(Paypal_BadExample paymentProcessor) {
        super();
        this.paymentProcessor = paymentProcessor;
    }

    public void makeAPaymentForAComputer(int quantity) {
        this.paymentProcessor.makeAPaymentWithPaypal(quantity * 10);
    }
}

class Paypal_BadExample {
    public Paypal_BadExample() {
        super();
    }

    public void makeAPaymentWithPaypal(int total) {
        System.out.println("Paid => " + total + " by Paypal");
    }
}

class Stripe_BadExample {
    public Stripe_BadExample() {
        super();
    }

    public void makeAPaymentWithStripe(int total) {
        System.out.println("Paid => " + total + " by Stripe");
    }
}
