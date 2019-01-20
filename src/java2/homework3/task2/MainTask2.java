package java2.homework3.task2;

/**
 * @author Stanislav Melekhin
 * Created on 20/01/2019
 */

public class MainTask2 {

    public static void main(String[] args) {

        Phone phone = new Phone();
        phone.add("Иванов", 123, 234);
        phone.add("Смирнов", 12312);
        phone.add("Сидоров", 76123, 11123, 456);
        phone.add("Петров", 88888);
        phone.add("Смирнов", 12);

        //phone.print();

        phone.getPhone("Сидоров");
        phone.getPhone("Смирнов");

    }

}
