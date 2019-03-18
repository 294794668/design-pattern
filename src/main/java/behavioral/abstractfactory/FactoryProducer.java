package behavioral.abstractfactory;

import behavioral.factory.ShapeFactory;

/**
 * @author pengfei.cheng
 * @since 2019/3/18 上午11:34
 */
public class FactoryProducer {
    public AbstractFactory getFactory(String type) {
        switch (type) {
            case "color":
                return new ColorFactory();
            case "shape":
                return new ShapeFactory();
            default:
                return null;
        }

    }
}
