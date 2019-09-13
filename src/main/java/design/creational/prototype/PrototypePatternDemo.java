package design.creational.prototype;

import java.io.*;

public class PrototypePatternDemo {

    public static void main(String[] args) {
        CloneDemo cloneDemo = new CloneDemo();
        cloneDemo.setName("1");
        cloneDemo.setValue("1");
        Creater creater = new Creater();
        creater.setName("a");
        cloneDemo.setCreater(creater);
        CloneDemo clone = (CloneDemo)cloneDemo.clone();
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(cloneDemo);
            ByteArrayInputStream byteArrayInputStream  = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            CloneDemo cloneA = (CloneDemo)objectInputStream.readObject();
            clone.setName("2");
            creater.setName("B");
            System.out.println(cloneDemo.getCreater().getName());
            System.out.println(clone.getCreater().getName());
            System.out.println(cloneA.getCreater().getName());

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
