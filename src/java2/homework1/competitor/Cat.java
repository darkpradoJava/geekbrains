package java2.homework1.competitor;

/**
 * @author Stanislav Melekhin
 * Created on 13/01/2019
 */

public class Cat extends Animal {

    public Cat(String name, double maxDistanceRun, double maxHeightJump) {
        super(name, maxDistanceRun, maxHeightJump);
        this.maxDistanceSwim = 0;
    }

}
