package java1.homework6;

public class Dog extends Animal {

    Dog(String name) {
        super(name);
        jump = (float)(Math.round(Math.random() * 100)) / 100;
        run = (float)(Math.round(Math.random() * 500 * 100)) / 100;
        sweem = (float)(Math.round(Math.random() * 50 * 100)) / 100;
    }

}