import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(float price);
}

class Investor implements Observer {
    private String name;

    Investor(String name) {
        this.name = name;
    }

    public void update(float price) {
        System.out.println(name + " received stock price update: $" + price);
    }
}

class Stock {
    private List<Observer> observers = new ArrayList<>();
    private float price;

    void addObserver(Observer observer) {
        observers.add(observer);
    }

    void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    void setPrice(float price) {
        this.price = price;
        notifyObservers();
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(price);
        }
    }
}

public class ObserverP{
    public static void main(String[] args) {
        Stock stock = new Stock();
        Investor investor1 = new Investor("Alice");
        Investor investor2 = new Investor("Bob");

        stock.addObserver(investor1);
        stock.addObserver(investor2);

        stock.setPrice(150.5f);
        stock.setPrice(155.0f);
    }
}
