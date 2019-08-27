package design.creational.builder;

/**
 * @author pengfei.cheng
 * @since 2019/3/18 下午2:12
 */
public class ChickenBurger extends Burger {
    @Override
    public String name() {
        return "chicken burger";
    }

    @Override
    public float price() {
        return 8;
    }
}
