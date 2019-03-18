package behavioral.singleton;

/**
 * @author pengfei.cheng
 * @since 2019/3/18 上午11:40
 */
public class SingleObjectLazy {

    private static SingleObjectLazy singleObjectLazy;

    public static SingleObjectLazy getInstance() {
        if (singleObjectLazy == null) {
            singleObjectLazy = new SingleObjectLazy();
        }
        return singleObjectLazy;
    }

    private SingleObjectLazy() {

    }
}
