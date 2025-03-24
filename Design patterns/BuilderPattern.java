class Meal {
    private String burger;
    private String drink;
    private String fries;

    public void setBurger(String burger) {
        this.burger = burger;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }

    public void setFries(String fries) {
        this.fries = fries;
    }

    @Override
    public String toString() {
        return "Meal{burger='" + burger + "', drink='" + drink + "', fries='" + fries + "'}";
    }
}

interface MealBuilder {
    void buildBurger();
    void buildDrink();
    void buildFries();
    Meal getMeal();
}

class VegMealBuilder implements MealBuilder {
    private Meal meal;

    public VegMealBuilder() {
        this.meal = new Meal();
    }

    @Override
    public void buildBurger() {
        meal.setBurger("Veg Burger");
    }

    @Override
    public void buildDrink() {
        meal.setDrink("Coke");
    }

    @Override
    public void buildFries() {
        meal.setFries("Cheese Fries");
    }

    @Override
    public Meal getMeal() {
        return meal;
    }
}

class NonVegMealBuilder implements MealBuilder {
    private Meal meal;

    public NonVegMealBuilder() {
        this.meal = new Meal();
    }

    @Override
    public void buildBurger() {
        meal.setBurger("Chicken Burger");
    }

    @Override
    public void buildDrink() {
        meal.setDrink("Pepsi");
    }

    @Override
    public void buildFries() {
        meal.setFries("Spicy Fries");
    }

    @Override
    public Meal getMeal() {
        return meal;
    }
}

class MealDirector {
    private MealBuilder mealBuilder;

    public MealDirector(MealBuilder mealBuilder) {
        this.mealBuilder = mealBuilder;
    }

    public void constructMeal() {
        mealBuilder.buildBurger();
        mealBuilder.buildDrink();
        mealBuilder.buildFries();
    }

    public Meal getMeal() {
        return mealBuilder.getMeal();
    }
}

public class BuilderPattern {
    public static void main(String[] args) {
        MealBuilder vegMealBuilder = new VegMealBuilder();
        MealDirector director = new MealDirector(vegMealBuilder);
        director.constructMeal();
        Meal vegMeal = director.getMeal();
        System.out.println("Veg Meal: " + vegMeal);

        MealBuilder nonVegMealBuilder = new NonVegMealBuilder();
        director = new MealDirector(nonVegMealBuilder);
        director.constructMeal();
        Meal nonVegMeal = director.getMeal();
        System.out.println("Non-Veg Meal: " + nonVegMeal);
    }
}