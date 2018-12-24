package java1.homework7;

public class Plate {

    private int food;

    public int getFood () {
        return food;
    }

    public Plate (int food) {
        this.food = food;
    }

    public void info () {
        System.out.println("Plate: " + food);
    }

    public void decreaseFood(int n) {
        if(n <= food) {
            food -= n;
        }
    }

    public void addFood(int n) {
        food += n;
    }

}
