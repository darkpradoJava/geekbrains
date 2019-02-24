package java3.homework1.smallTasks;

/**
 * @author Stanislav Melekhin
 * email darkprado@yandex.ru
 * Created on 16/02/2019
 */

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 1. Написать метод, который меняет два элемента массива местами.(массив может быть любого ссылочного типа);
 * 2. Написать метод, который преобразует массив в ArrayList;
 */

public class Main {

    public static void main(String[] args) {

        //task1.
        System.out.println("Task1. replace method");

        Float[] arrFloat = {3f, 5f, 6.5f, 7.1f, 123.9f};
        String[] arrString = {"A", "B", "C", "D", "E"};

        System.out.println(Arrays.toString(arrFloat));
        replaceElements(arrFloat, 0, 2);
        System.out.println(Arrays.toString(arrFloat));

        System.out.println(Arrays.toString(arrString));
        replaceElements(arrString, 1, 3);
        System.out.println(Arrays.toString(arrString));

        System.out.println("______________________________");

        //task2.
        System.out.println("Task2. ArrayToArrayList method");

        //return the order of the alphabet
        replaceElements(arrString, 1, 3);

        ArrayList<String> list = arrayToArrayList(arrString);
        list.add("F");
        System.out.println(list.toString());

    }

    //method task1
    public static <T> void replaceElements(T[] arr, int elem1, int elem2) {
        try {
            T temp = arr[elem1];
            arr[elem1] = arr[elem2];
            arr[elem2] = temp;
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    //method task2
    public static <T> ArrayList<T> arrayToArrayList(T[] array) {
        return new ArrayList<T>(Arrays.asList(array));
    }

}

