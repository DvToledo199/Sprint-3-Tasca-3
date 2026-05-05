package level3;

public class LatteBase implements BubbleTea {
    @Override
    public String getDescription() {
        return "Latte";
    }

    @Override
    public double getCost() {
        return 3.50;
    }
}
