package level2;

import java.util.ArrayList;
import java.util.List;

public class StockAgent {
    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
    public void stockMarketUp(double value) {
        String message = "Stock market UP. New value: " + value;
        notifyObservers(message);
    }

    public void stockMarketDown(double value) {
        String message = "Stock market DOWN. New value: " + value;
        notifyObservers(message);
    }
}
