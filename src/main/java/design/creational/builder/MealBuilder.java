package design.creational.builder;

/**
 * @author pengfei.cheng
 * @since 2019/3/18 下午3:04
 */
public class MealBuilder {

    public Meal prepareVegMeal() {
        Meal meal = new Meal();
        meal.add(new VegBurger());
        meal.add(new Coca());

        return meal;
    }

    public Meal prepareNonVegMeal() {
        Meal meal = new Meal();
        meal.add(new ChickenBurger());
        meal.add(new Pepsi());
        return meal;
    }
}
