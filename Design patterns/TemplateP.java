abstract class OrderProcessTemplate {
    public final void processOrder() {
        selectItem();
        makePayment();
        shipItem();
    }

    abstract void selectItem();
    abstract void makePayment();

    void shipItem() {
        System.out.println("Item shipped to the customer.");
    }
}

class CreditCardOrder extends OrderProcessTemplate {
    void selectItem() {
        System.out.println("Item selected from online store.");
    }

    void makePayment() {
        System.out.println("Payment made using Credit Card.");
    }
}

class PayPalOrder extends OrderProcessTemplate {
    void selectItem() {
        System.out.println("Item selected from online store.");
    }

    void makePayment() {
        System.out.println("Payment made using PayPal.");
    }
}

public class TemplateP{
    public static void main(String[] args) {
        OrderProcessTemplate order1 = new CreditCardOrder();
        order1.processOrder();

        System.out.println();

        OrderProcessTemplate order2 = new PayPalOrder();
        order2.processOrder();
    }
}
