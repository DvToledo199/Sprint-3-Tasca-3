package level1;

public class MenuBuilder implements StartStep, EntrantStep<MenuBuilder>, MainCourseStep, MainCourseStepOptions<MenuBuilder>, AfterMainStep, AfterDessertStep, AfterCoffeeStep, AfterDrinkStep {

    private String entrant;
    private String mainCourse;
    private String dessert;
    private String coffee;
    private String drink;
    private boolean vegan;
    private boolean glutenFree;
    private String supplement;

    public MenuBuilder() {
    }

    // StartStep
    @Override
    public EntrantStep<MenuBuilder> withEntrant(String entrant) {
        this.entrant = entrant;
        return this;
    }

    @Override
    public MainCourseStep skipEntrant() {
        return this;
    }

    // EntrantStep
    @Override
    public MenuBuilder isVegan() {
        this.vegan = true;
        return this;
    }

    @Override
    public MenuBuilder isGlutenFree() {
        this.glutenFree = true;
        return this;
    }

    @Override
    public MainCourseStep goToMainCourse() {
        return this;
    }

    // MainCourseStep
    @Override
    public MainCourseStepOptions<MenuBuilder> withMainCourse(String mainCourse) {
        this.mainCourse = mainCourse;
        return this;
    }

    // MainCourseStepOptions
    @Override
    public MenuBuilder withSupplement(String supplement) {
        this.supplement = supplement;
        return this;
    }

    @Override
    public AfterMainStep finishMainOptions() {
        return this;
    }

    // AfterMainStep
    @Override
    public AfterDessertStep withDessert(String dessert) {
        this.dessert = dessert;
        return this;
    }

    @Override
    public AfterCoffeeStep withCoffee(String coffee) {
        this.coffee = coffee;
        return this;
    }

    @Override
    public AfterDrinkStep withDrink(String drink) {
        this.drink = drink;
        return this;
    }

    @Override
    public Menu build() {
        return new Menu(
                entrant,
                mainCourse,
                dessert,
                coffee,
                drink,
                vegan,
                glutenFree,
                supplement
        );
    }
}
