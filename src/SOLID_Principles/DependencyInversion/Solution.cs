class OnlineStore
        {
            private IPaymentProcessor paymentProcessor;

            public OnlineStore(IPaymentProcessor paymentProcessor)
            {
                this.paymentProcessor = paymentProcessor;
            }

            public void makeAPaymentForAComputer(int quantity)
            {
                this.paymentProcessor.makeAPayment(quantity * 10);
            }
        }

        interface IPaymentProcessor
        {
            public void makeAPayment(int total);
        }

        class Paypal : IPaymentProcessor
        {
            public void makeAPayment(int total)
            {
                this.makeAPaymentWithPaypal(total);
            }

            public void makeAPaymentWithPaypal(int val)
            {

            }
        }
        class Stripe : IPaymentProcessor
        {
            public void makeAPayment(int total)
            {
                this.makeAPaymentWithStripe(total);
            }

            public void makeAPaymentWithStripe(int val)
            {

            }
        }
