package design.creational.singleton;

/**
 * @author pengfei.cheng
 * @since 2019/3/18 上午11:39
 */
public class SingleObject {

    private static SingleObject ourInstance = new SingleObject();

    public static SingleObject getInstance() {
        return ourInstance;
    }

    private SingleObject() {
    }
}
