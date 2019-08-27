package design.structural.obsever;

/**
 * @author pengfei.cheng
 * @description 定义对象间一种一对多的依赖关系，
 * 使得每当一个对象改变状态，
 * 则所有依赖于它的对象都会得到通知并被自动更新。
 * @date 2019-08-20 10:47
 */
public class ObserverPattern {

    public static void main(String[] args) {
        Tester tester = new Tester("测试小张");
        tester.addObserver(new Developer("开发小明"));
        tester.addObserver(new Developer("开发小红"));
        tester.addObserver(new Developer("开发小1"));
        tester.addObserver(new Developer("开发小红2"));
        tester.addObserver(new Developer("开发小红3"));
        tester.addObserver(new Developer("开发小红4"));
        tester.addObserver(new Developer("开发小红5"));
        tester.addObserver(new Developer("开发小红6"));
        tester.addObserver(new Developer("开发小红7"));

        tester.findBug();
        tester.notifyObservers("bug important!");
    }
}