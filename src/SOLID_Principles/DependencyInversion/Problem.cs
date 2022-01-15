class OnlineStore
{
    private Paypal paymentProcessor;

    public OnlineStore(Paypal paymentProcessor)
    {
        this.paymentProcessor = paymentProcessor;
    }

    public void makeAPaymentForAComputer(int quantity)
    {
        this.paymentProcessor.makeAPaymentWithPaypal(quantity * 10);
    }
}
class Paypal
{
    public void makeAPaymentWithPaypal(int val)
    {

    }
}
class Stripe
{
    public void makeAPaymentWithStripe(int val)
    {

    }
}
