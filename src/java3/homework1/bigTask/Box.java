package java3.homework1.bigTask;

import java.util.ArrayList;
import java.util.Arrays;

public class Box<T extends Fruit> {

    private static int boxCount = 0;
    private int boxId;
    private ArrayList<T> fruitsList = new ArrayList<>();

    public Box() {
        boxId = ++boxCount;
    }

    public void add(T... fruit) {
        fruitsList.addAll(Arrays.asList(fruit));
    }

    public float getWeight() {
        float w = 0;
        try {
            if (!fruitsList.isEmpty()) {
                w = fruitsList.size() * fruitsList.get(0).getWeight();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return w;
    }

    public boolean compare(Box otherBox) {
        return getWeight() - otherBox.getWeight() == 0;
    }

    public void intersperse(Box<T> otherBox) {
        for (T f : fruitsList) {
            otherBox.add(f);
        }
        fruitsList.clear();
    }

    @Override
    public String toString() {
        if (!fruitsList.isEmpty()) {
            return getClass().getSimpleName() + " number " + boxId + " contains " + fruitsList.size()
                    + " " + fruitsList.get(0).getClass().getSimpleName() + "(s)";
        }
        return getClass().getSimpleName() + " number " + boxId + " is empty";
    }

}
