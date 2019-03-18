package behavioral.abstractfactory;

import behavioral.factory.Shape;

/**
 * @author pengfei.cheng
 * @since 2019/3/18 上午11:32
 */
public class ColorFactory extends AbstractFactory {
    @Override
    protected Shape getShape(String type) {
        return null;
    }

    @Override
    protected Color getColor(String type) {
        switch (type) {
            case "Red":
                return new Red();
            case "Blue":
                return new Blue();
            case "Green":
                return new Green();
            default:
                return null;
        }
    }
}
