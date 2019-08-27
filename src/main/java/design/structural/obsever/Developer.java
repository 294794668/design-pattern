package design.structural.obsever;

import java.util.Observable;
import java.util.Observer;

/**
 * @author pengfei.cheng
 * @description 开发人员
 * @date 2019-08-20 10:44
 */
public class Developer implements Observer {

    private String name;

    public Developer(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println(name + " shoud fix this bug, from:" + o + ", " + arg);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
