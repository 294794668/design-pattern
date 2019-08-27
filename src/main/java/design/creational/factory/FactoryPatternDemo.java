package design.creational.factory;

/**
 * @author pengfei.cheng
 * @since 2019/3/18 上午11:22
 */
public class FactoryPatternDemo {

    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        shapeFactory.getShape("Circle").draw();
    }
}
