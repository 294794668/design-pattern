package creational.builder;

/**
 * @author pengfei.cheng
 * @since 2019/3/18 下午3:06
 */
public class Coca extends Drink {
    @Override
    public String name() {
        return "coca";
    }

    @Override
    public float price() {
        return 3.5f;
    }
}
