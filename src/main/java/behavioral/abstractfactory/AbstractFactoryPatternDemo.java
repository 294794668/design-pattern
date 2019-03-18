package behavioral.abstractfactory;

import behavioral.factory.Shape;

/**
 * @author pengfei.cheng
 * @since 2019/3/18 上午11:36
 */
public class AbstractFactoryPatternDemo {
    public static void main(String[] args) {
        FactoryProducer factoryProducer = new FactoryProducer();
        AbstractFactory color = factoryProducer.getFactory("color");
        Color red = color.getColor("red");
        red.fill();
        AbstractFactory shape = factoryProducer.getFactory("shape");
        Shape circle = shape.getShape("Circle");
        circle.draw();
    }
}
