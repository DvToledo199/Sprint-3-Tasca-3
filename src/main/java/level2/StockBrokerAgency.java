package level2;

public class StockBrokerAgency implements Observer {

    private String lastMessage;

    @Override
    public void update(String message) {
        this.lastMessage = message;
        System.out.println("Agency received: " + message);
    }

    public String getLastMessage() {
        return lastMessage;
    }
}
