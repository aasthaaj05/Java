interface PaymentStrategy {
    void pay(int amount);
}

class CreditCardPayment implements PaymentStrategy {
    public void pay(int amount) {
        System.out.println("Paid $" + amount + " using Credit Card.");
    }
}

class PayPalPayment implements PaymentStrategy {
    public void pay(int amount) {
        System.out.println("Paid $" + amount + " using PayPal.");
    }
}

class PaymentContext {
    private PaymentStrategy strategy;

    void setPaymentStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    void makePayment(int amount) {
        strategy.pay(amount);
    }
}

public class StrategyP{
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        context.setPaymentStrategy(new CreditCardPayment());
        context.makePayment(100);

        context.setPaymentStrategy(new PayPalPayment());
        context.makePayment(200);
    }
}
