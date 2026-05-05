package level3;

public class Flavor extends BubbleTeaDecorator {

    private String flavorName;

    public Flavor(BubbleTea tea, String flavorName) {
        super(tea);
        this.flavorName = flavorName;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + " + flavorName;
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.60;
    }
}
