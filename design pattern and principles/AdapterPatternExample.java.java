public interface PaymentProcessor {
    void processPayment(double amount);
}
public class PayPalGateway {
    public void makePayment(double amount) {
        System.out.println("Processing $" + amount + " via PayPal.");
    }
}
public class StripeGateway {
    public void chargeCard(double amount) {
        System.out.println("Charging $" + amount + " via Stripe.");
    }
}
public class PayPalAdapter implements PaymentProcessor {
    private PayPalGateway payPalGateway;

    public PayPalAdapter(PayPalGateway payPalGateway) {
        this.payPalGateway = payPalGateway;
    }

    @Override
    public void processPayment(double amount) {
        payPalGateway.makePayment(amount);
    }
}
public class StripeAdapter implements PaymentProcessor {
    private StripeGateway stripeGateway;
    public StripeAdapter(StripeGateway stripeGateway) {
        this.stripeGateway = stripeGateway;
    }
    @Override
    public void processPayment(double amount) {
        stripeGateway.chargeCard(amount);
    }
}
public class AdapterTest {
    public static void main(String[] args) {
        PaymentProcessor payPalProcessor = new PayPalAdapter(new PayPalGateway());
        payPalProcessor.processPayment(150.00);
        PaymentProcessor stripeProcessor = new StripeAdapter(new StripeGateway());
        stripeProcessor.processPayment(200.50);
    }
}