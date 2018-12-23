package java1.homework5;

public class Main {

    public static void main(String[] args) {

        Worker[] workers = new Worker[5];
        workers[0] = new Worker("Ivan", "driver", "a@a.ru", 123, 42);
        workers[1] = new Worker("Oleg", "writer", "b@b.ru", 456, 33);
        workers[2] = new Worker("Stanislav", "programmist", "c@c.ru", 789, 30);
        workers[3] = new Worker("Kirill", "director", "d@d.ru", 157, 46);
        workers[4] = new Worker("Elena", "slesar", "e@e.ru", 864, 35);

        for (Worker w : workers) {
            if(w.getAge() > 40) {
                System.out.println(w.toString());
            }
        }

    }

}
