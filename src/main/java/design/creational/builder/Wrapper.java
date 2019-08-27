package design.creational.builder;

/**
 * @author pengfei.cheng
 * @since 2019/3/18 下午2:11
 */
public class Wrapper implements PackIng {
    @Override
    public void packing() {
        System.out.println(this);
    }
}
