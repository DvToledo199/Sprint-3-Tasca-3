package level3;

public abstract class BubbleTeaDecorator implements BubbleTea {

    protected BubbleTea tea;

    public BubbleTeaDecorator(BubbleTea tea) {
        this.tea = tea;
    }

    @Override
    public String getDescription() {
        return tea.getDescription();
    }

    @Override
    public double getCost() {
        return tea.getCost();
    }
}
