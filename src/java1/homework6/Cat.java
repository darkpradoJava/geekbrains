package java1.homework6;

public class Cat extends Animal {

    Cat (String name) {
        super(name);
        jump = (float)(Math.round(Math.random() * 2 * 100)) / 100;
        run = (float)(Math.round(Math.random() * 200 * 100)) / 100;
        sweem = 0;
    }

}