package java2.homework1.competitor;

import java2.homework1.action.*;

/**
 * @author Stanislav Melekhin
 * Created on 13/01/2019
 */

public abstract class Animal implements Running, Jumping, Swimming {

    protected String name;
    protected double maxDistanceRun, maxDistanceSwim, maxHeightJump;
    private boolean finished;

    public Animal(String name, double maxDistanceRun, double maxHeightJump) {
        this.name = name;
        this.maxDistanceRun = maxDistanceRun;
        this.maxHeightJump = maxHeightJump;
    }

    public Animal(String name, double maxDistanceRun, double maxDistanceSwim, double maxHeightJump) {
        this.name = name;
        this.maxDistanceRun = maxDistanceRun;
        this.maxDistanceSwim = maxDistanceSwim;
        this.maxHeightJump = maxHeightJump;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " with name " + name + " can run on " + maxDistanceRun + ", jump " +
                maxHeightJump + ", swim " + maxDistanceSwim;
    }

    public boolean run(double run) {
        return run < maxDistanceRun;
    }

    public boolean jump(double jump) {
        return jump < maxHeightJump;
    }

    public boolean swim(double swim) {
        return swim < maxDistanceSwim;
    }

    public boolean getFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

}
