package level1;

public interface AfterDessertStep {
    AfterDrinkStep withDrink(String drink);

    Menu build();
}
