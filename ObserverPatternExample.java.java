public interface Observer {
    void update(double stockPrice);
}

public interface Stock {
    void register(Observer observer);
    void deregister(Observer observer);
    void notifyObservers();
}
import java.util.ArrayList;
import java.util.List;
public class StockMarket implements Stock {
    private List<Observer> observers = new ArrayList<>();
    private double stockPrice;
    public void setStockPrice(double stockPrice) {
        this.stockPrice = stockPrice;
        notifyObservers();
    }
    @Override
    public void register(Observer observer) {
        observers.add(observer);
    }
    @Override
    public void deregister(Observer observer) {
        observers.remove(observer);
    }
    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(stockPrice);
        }
    }
}
public class MobileApp implements Observer {
    @Override
    public void update(double stockPrice) {
        System.out.println("MobileApp Notification: Stock price changed to $" + stockPrice);
    }
}
public class WebApp implements Observer {
    @Override
    public void update(double stockPrice) {
        System.out.println("WebApp Notification: Stock price changed to $" + stockPrice);
    }
}
public class ObserverTest {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();
        Observer mobileApp = new MobileApp();
        Observer webApp = new WebApp();
        stockMarket.register(mobileApp);
        stockMarket.register(webApp);
        System.out.println("Setting stock price to 100.50");
        stockMarket.setStockPrice(100.50);

        stockMarket.deregister(mobileApp);

        System.out.println("\nSetting stock price to 105.00");
        stockMarket.setStockPrice(105.00);
    }
}