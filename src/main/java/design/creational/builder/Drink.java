package design.creational.builder;

/**
 * @author pengfei.cheng
 * @since 2019/3/18 下午2:10
 */
public abstract class Drink implements Item{
    @Override
    public PackIng packing() {
        return new Bottle();
    }
}
