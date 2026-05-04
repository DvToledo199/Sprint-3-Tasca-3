package level1;

public interface AfterCoffeeStep {
    AfterDrinkStep withDrink(String drink);

    Menu build();
}
