package java1.homework7;

public class MainClass {
    public static void main(String[] args) {

        Plate plate = new Plate(100);
        Cat[] cats = {
                new Cat("Барсик", 16),
                new Cat("Персик", 30),
                new Cat("Мурзик", 12),
                new Cat("Васька", 11),
                new Cat("Ириска", 5),
                new Cat("Тоська", 17),
                new Cat("Муська", 25)
        };

        for (int i = 0; i < cats.length; i++) {
            cats[i].eat(plate);
            plate.info();
            cats[i].infoCatAppettite();
        }


    }
}
