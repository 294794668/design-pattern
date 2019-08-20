package creational.factory;

import creational.abstractfactory.AbstractFactory;
import creational.abstractfactory.Color;

/**
 * @author pengfei.cheng
 * @since 2019/3/18 上午11:16
 */
public class ShapeFactory extends AbstractFactory {

    public Shape getShape(String type) {
        switch (type) {
            case "Circle":
                return new Circle();
            case "Rectangle":
                return new Rectangle();
            case "Square":
                return new Square();
            default:
                return null;
        }
    }

    @Override
    protected Color getColor(String type) {
        return null;
    }
}
