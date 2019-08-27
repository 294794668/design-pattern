package design.structural.obsever;

import java.util.Observable;

/**
 * @author pengfei.cheng
 * @description 测试人员
 * @date 2019-08-20 10:44
 */
public class Tester extends Observable {

    private String name;

    public Tester(String name) {
        this.name = name;
    }

    void findBug() {
        System.out.println("tester find a bug");
        super.setChanged();
    }

    @Override
    public String toString() {
        return name;
    }
}
