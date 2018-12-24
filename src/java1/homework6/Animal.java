package java1.homework6;

public class Animal implements Skills {

    protected float run, jump, sweem;
    protected String name;

    Animal (String name) {
        this.name = name;
    }

    @Override
    public void jump(float height) {
        if(jump > height) {
            System.out.println(this.getClass().getSimpleName() + " " + name + " jump on " + height + ": true");
        } else {
            System.out.println(this.getClass().getSimpleName() + " " + name + " jump on " + height + ": false");
        }
    }

    @Override
    public void run(float distance) {
        if(run > distance) {
            System.out.println(this.getClass().getSimpleName() + " " + name + " run on " + distance + ": true");
        } else {
            System.out.println(this.getClass().getSimpleName() + " " + name + " run on " + distance + ": false");
        }
    }

    @Override
    public void sweem(float distance) {
        if(sweem > distance) {
            System.out.println(this.getClass().getSimpleName() + " " + name + " sweem on " + distance + ": true");
        } else {
            System.out.println(this.getClass().getSimpleName() + " " + name + " sweem on " + distance + ": true");
        }
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " " + name +", can run: " + run + ", sweem: " + sweem + ", jump: " + jump + ".";
    }
}