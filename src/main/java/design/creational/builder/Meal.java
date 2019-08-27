package design.creational.builder;

import java.util.ArrayList;

/**
 * @author pengfei.cheng
 * @since 2019/3/18 下午2:56
 */
public class Meal {
    private ArrayList<Item> items;

    public Meal() {
        this.items = new ArrayList<>();
    }

    public void add(Item item) {
        items.add(item);
    }

    public void name() {
        items.forEach(System.out::print);
    }

    public void price() {
        double sum = items.stream().map(Item::price).mapToDouble(Float::doubleValue).sum();
        System.out.println(sum);
    }

}
