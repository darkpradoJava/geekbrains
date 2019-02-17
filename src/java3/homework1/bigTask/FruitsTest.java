package java3.homework1.bigTask;

/**
 * @author Stanislav Melekhin
 * email darkprado@yandex.ru
 * Created on 16/02/2019
 */

/**
 * 3. Большая задача:
 * a. Есть классы Fruit -> Apple, Orange;(больше фруктов не надо)
 * b. Класс Box в который можно складывать фрукты, коробки условно сортируются по типу фрукта,
 * поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
 * c. Для хранения фруктов внутри коробки можете использовать ArrayList;
 * d. Сделать метод getWeight() который высчитывает вес коробки, зная количество фруктов и вес одного фрукта
 * (вес яблока - 1.0f, апельсина - 1.5f, не важно в каких это единицах);
 * e. Внутри класса коробка сделать метод compare, который позволяет сравнить текущую коробку с той,
 * которую подадут в compare в качестве параметра, true - если их веса равны, false в противном случае(
 * коробки с яблоками мы можем сравнивать с коробками с апельсинами);
 * f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую коробку
 * (помним про сортировку фруктов, нельзя яблоки высыпать в коробку с апельсинами), соответственно в текущей коробке
 * фруктов не остается, а в другую перекидываются объекты, которые были в этой коробке;
 * g. Не забываем про метод добавления фрукта в коробку.
 */

public class FruitsTest {

    public static void main(String[] args) {

        Box<Apple> box1 = new Box<>();
        box1.add(new Apple(), new Apple(), new Apple());

        Box<Apple> box2 = new Box<>();
        box2.add(new Apple(), new Apple(), new Apple(), new Apple(), new Apple(), new Apple());

        Box<Orange> box3 = new Box<>();
        box3.add(new Orange(), new Orange(), new Orange(), new Orange());

        Box<Orange> box4 = new Box<>();
        box4.add(new Orange(), new Orange());

        System.out.println(box1);
        System.out.println(box2);
        System.out.println(box3);
        System.out.println(box4);

        System.out.println(box1.compare(box2));
        System.out.println(box1.compare(box4));

        box1.intersperse(box2);
        System.out.println(box1);
        System.out.println(box2);

        System.out.println(box2.getWeight());
        System.out.println(box1.getWeight());

    }

}
