package behavioral.builder;

/**
 * @author pengfei.cheng
 * @since 2019/3/18 下午2:12
 */
public class VegBurger extends Burger {
    @Override
    public String name() {
        return "veg burger";
    }

    @Override
    public float price() {
        return 10;
    }
}
