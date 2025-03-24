interface TaxVisitor {
    void visit(Food food);
    void visit(Electronics electronics);
}

class TaxCalculator implements TaxVisitor {
    public void visit(Food food) {
        System.out.println("Tax for food item: $" + food.getPrice() * 0.05);
    }

    public void visit(Electronics electronics) {
        System.out.println("Tax for electronics item: $" + electronics.getPrice() * 0.18);
    }
}

interface Product {
    void accept(TaxVisitor visitor);
    double getPrice();
}

class Food implements Product {
    private double price;

    Food(double price) {
        this.price = price;
    }

    public void accept(TaxVisitor visitor) {
        visitor.visit(this);
    }

    public double getPrice() {
        return price;
    }
}

class Electronics implements Product {
    private double price;

    Electronics(double price) {
        this.price = price;
    }

    public void accept(TaxVisitor visitor) {
        visitor.visit(this);
    }

    public double getPrice() {
        return price;
    }
}

public class VisitorP {
    public static void main(String[] args) {
        Product apple = new Food(10);
        Product laptop = new Electronics(1000);

        TaxVisitor taxCalculator = new TaxCalculator();

        apple.accept(taxCalculator);
        laptop.accept(taxCalculator);
    }
}
