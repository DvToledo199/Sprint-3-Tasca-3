package level3;

public class TeaBase implements BubbleTea {
    @Override
    public String getDescription() {
        return "Tea";
    }

    @Override
    public double getCost() {
        return 3.00;
    }
}
