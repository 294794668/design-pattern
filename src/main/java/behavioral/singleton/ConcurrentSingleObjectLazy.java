package behavioral.singleton;

/**
 * @author pengfei.cheng
 * @since 2019/3/18 上午11:40
 */
public class ConcurrentSingleObjectLazy {

    private static volatile ConcurrentSingleObjectLazy singleObjectLazy;

    public static synchronized ConcurrentSingleObjectLazy getInstanceBad() {
        if (singleObjectLazy == null) {
            singleObjectLazy = new ConcurrentSingleObjectLazy();
        }
        return singleObjectLazy;
    }


    public static ConcurrentSingleObjectLazy getInstanceGood() {
        if (singleObjectLazy == null) {
            synchronized (ConcurrentSingleObjectLazy.class) {
                if (singleObjectLazy == null) {
                    singleObjectLazy = new ConcurrentSingleObjectLazy();
                }
            }
        }
        return singleObjectLazy;
    }

    private ConcurrentSingleObjectLazy() {

    }
}
