package level1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MenuBuilderTest {

    @Test
    void shouldCreateFullMenu() {
        Menu menu = new MenuBuilder()
                .withEntrant("Salad")
                .isVegan()
                .goToMainCourse()
                .withMainCourse("Steak")
                .withSupplement("Fries")
                .finishMainOptions()
                .withDessert("Cake")
                .withDrink("Water")
                .build();

        assertEquals("Salad", menu.getEntrant());
        assertEquals("Steak", menu.getMainCourse());
        assertEquals("Cake", menu.getDessert());
        assertEquals("Water", menu.getDrink());
        assertTrue(menu.isVegan());
        assertEquals("Fries", menu.getSupplement());
    }

    @Test
    void shouldCreateHalfMenu() {
        Menu menu = new MenuBuilder()
                .skipEntrant()
                .withMainCourse("Chicken")
                .finishMainOptions()
                .withDrink("Juice")
                .build();

        assertNull(menu.getEntrant());
        assertEquals("Chicken", menu.getMainCourse());
        assertEquals("Juice", menu.getDrink());
    }

    @Test
    void shouldCreateKidsMenu() {
        Menu menu = new MenuBuilder()
                .skipEntrant()
                .withMainCourse("Burger")
                .finishMainOptions()
                .withDessert("Ice Cream")
                .withDrink("Soda")
                .build();

        assertEquals("Burger", menu.getMainCourse());
        assertEquals("Ice Cream", menu.getDessert());
        assertEquals("Soda", menu.getDrink());
    }

    @Test
    void shouldAllowCoffeeInsteadOfDessert() {
        Menu menu = new MenuBuilder()
                .skipEntrant()
                .withMainCourse("Fish")
                .finishMainOptions()
                .withCoffee("Espresso")
                .build();

        assertEquals("Fish", menu.getMainCourse());
        assertEquals("Espresso", menu.getCoffee());
        assertNull(menu.getDessert());
    }

    @Test
    void shouldCreateMenuWithoutDrink() {
        Menu menu = new MenuBuilder()
                .skipEntrant()
                .withMainCourse("Pasta")
                .finishMainOptions()
                .build();

        assertEquals("Pasta", menu.getMainCourse());
        assertNull(menu.getDrink());
    }

    @Test
    void shouldApplyVeganAndGlutenFree() {
        Menu menu = new MenuBuilder()
                .withEntrant("Soup")
                .isVegan()
                .isGlutenFree()
                .goToMainCourse()
                .withMainCourse("Rice")
                .isVegan()
                .finishMainOptions()
                .build();

        assertTrue(menu.isVegan());
        assertTrue(menu.isGlutenFree());
    }

    @Test
    void shouldApplySupplementToMainCourse() {
        Menu menu = new MenuBuilder()
                .skipEntrant()
                .withMainCourse("Steak")
                .withSupplement("Extra sauce")
                .finishMainOptions()
                .build();

        assertEquals("Extra sauce", menu.getSupplement());
    }
}