package level1;

public class Menu {

    private String entrant;
    private String mainCourse;
    private String dessert;
    private String coffee;
    private String drink;
    private boolean vegan;
    private boolean glutenFree;
    private String supplement;

    public Menu(String entrant, String mainCourse, String dessert, String coffee, String drink, boolean vegan, boolean glutenFree, String supplement) {
        this.entrant = entrant;
        this.mainCourse = mainCourse;
        this.dessert = dessert;
        this.coffee = coffee;
        this.drink = drink;
        this.vegan = vegan;
        this.glutenFree = glutenFree;
        this.supplement = supplement;
    }

    public String getEntrant() {
        return entrant;
    }

    public String getMainCourse() {
        return mainCourse;
    }

    public String getDessert() {
        return dessert;
    }

    public String getCoffee() {
        return coffee;
    }

    public String getDrink() {
        return drink;
    }

    public boolean isVegan() {
        return vegan;
    }

    public boolean isGlutenFree() {
        return glutenFree;
    }

    public String getSupplement() {
        return supplement;
    }
}
