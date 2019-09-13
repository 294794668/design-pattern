package design.creational.prototype;

import java.io.Serializable;

public class CloneDemo implements Cloneable, Serializable {
    private String name;
    private String value;
    private Creater creater;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Creater getCreater() {
        return creater;
    }

    public void setCreater(Creater creater) {
        this.creater = creater;
    }

    public Object clone() {
        Object clone = null;
        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }

    @Override
    public String toString() {
        return "CloneDemo{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
