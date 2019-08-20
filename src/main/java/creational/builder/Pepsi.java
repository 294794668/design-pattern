package creational.builder;

/**
 * @author pengfei.cheng
 * @since 2019/3/18 下午3:06
 */
public class Pepsi extends Drink {
    @Override
    public String name() {
        return "pepsi";
    }

    @Override
    public float price() {
        return 2.5f;
    }
}
