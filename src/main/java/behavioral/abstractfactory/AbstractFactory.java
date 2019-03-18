package behavioral.abstractfactory;

import behavioral.factory.Shape;

/**
 * @author pengfei.cheng
 * @since 2019/3/18 上午11:26
 */
public abstract class AbstractFactory {
    protected abstract Shape getShape(String type);
    protected abstract Color getColor(String type);
}