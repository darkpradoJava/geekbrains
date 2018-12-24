package java1.homework7;

public class Cat {

    private String name;
    private int appetite;
    boolean isFull = false;

    public Cat (String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public void eat(Plate p){
        if (p.getFood() >= appetite) {
            p.decreaseFood(appetite);
            isFull = true;
        }
    }

    public void infoCatAppettite () {
        String appetite = isFull ? " сыт!" : " голоден!";
        System.out.println("Кот по имени " + name + appetite);
    }

}
