package level1;

public interface AfterMainStep {

    AfterDessertStep withDessert(String dessert);

    AfterCoffeeStep withCoffee(String coffee);

    AfterDrinkStep withDrink(String drink);

    Menu build();
}