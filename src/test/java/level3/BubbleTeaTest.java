package level3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BubbleTeaTest {

    @Test
    void shouldCreateBaseLatte() {
        BubbleTea tea = new LatteBase();

        assertEquals(3.50, tea.getCost());
        assertEquals("Latte", tea.getDescription());
    }

    @Test
    void shouldAddSingleDecorator() {
        BubbleTea tea = new LatteBase();
        tea = new Sugar(tea);

        assertEquals(3.80, tea.getCost());
        assertEquals("Latte + Sugar", tea.getDescription());
    }

    @Test
    void shouldAddMultipleDecorators() {
        BubbleTea tea = new LatteBase();
        tea = new Tapioca(tea);
        tea = new Sugar(tea);

        assertEquals(4.30, tea.getCost());
        assertEquals("Latte + Tapioca + Sugar", tea.getDescription());
    }

    @Test
    void shouldSupportMultipleFlavors() {
        BubbleTea tea = new MatchaBase();
        tea = new Flavor(tea, "Mango");
        tea = new Flavor(tea, "Strawberry");

        assertEquals(4.40, tea.getCost());
        assertEquals("Matcha + Mango + Strawberry", tea.getDescription());
    }

    @Test
    void shouldCombineAllExtras() {
        BubbleTea tea = new TeaBase();
        tea = new Ice(tea);
        tea = new Sugar(tea);
        tea = new Tapioca(tea);
        tea = new Flavor(tea, "Peach");

        assertEquals(4.65, tea.getCost());
        assertEquals("Tea + Ice + Sugar + Tapioca + Peach", tea.getDescription());
    }
}
