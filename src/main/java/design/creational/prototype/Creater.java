package design.creational.prototype;

import java.io.Serializable;

public class Creater implements Serializable {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
