package level2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StockAgentTest {

    @Test
    void shouldNotifyAllObserversWhenStockGoesUp() {
        StockAgent agent = new StockAgent();

        StockBrokerAgency agency1 = new StockBrokerAgency();
        StockBrokerAgency agency2 = new StockBrokerAgency();

        agent.addObserver(agency1);
        agent.addObserver(agency2);

        agent.stockMarketUp(150);

        assertEquals("Stock market UP. New value: 150.0", agency1.getLastMessage());
        assertEquals("Stock market UP. New value: 150.0", agency2.getLastMessage());
    }

    @Test
    void shouldNotifyAllObserversWhenStockGoesDown() {
        StockAgent agent = new StockAgent();

        StockBrokerAgency agency = new StockBrokerAgency();

        agent.addObserver(agency);

        agent.stockMarketDown(100);

        assertEquals("Stock market DOWN. New value: 100.0", agency.getLastMessage());
    }

    @Test
    void shouldNotNotifyRemovedObserver() {
        StockAgent agent = new StockAgent();

        StockBrokerAgency agency = new StockBrokerAgency();

        agent.addObserver(agency);
        agent.removeObserver(agency);

        agent.stockMarketUp(200);

        assertNull(agency.getLastMessage());
    }

    @Test
    void shouldAllowMultipleObservers() {
        StockAgent agent = new StockAgent();

        StockBrokerAgency agency1 = new StockBrokerAgency();
        StockBrokerAgency agency2 = new StockBrokerAgency();
        StockBrokerAgency agency3 = new StockBrokerAgency();

        agent.addObserver(agency1);
        agent.addObserver(agency2);
        agent.addObserver(agency3);

        agent.stockMarketUp(300);

        assertNotNull(agency1.getLastMessage());
        assertNotNull(agency2.getLastMessage());
        assertNotNull(agency3.getLastMessage());
    }
}
