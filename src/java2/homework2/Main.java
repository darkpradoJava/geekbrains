package java2.homework2;

/**
 * @author Stanislav Melekhin
 * Created on 16/01/2019
 */

/*
1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4,
при подаче массива другого размера необходимо бросить исключение MyArraySizeException.
2. Далее метод должен пройтись по всем элементам массива, преобразовать в int, и просуммировать.
Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа),
должно быть брошено исключение MyArrayDataException, с детализацией в какой именно ячейке лежат неверные данные.
3. В методе main() вызвать полученный метод, обработать возможные исключения MySizeArrayException и
MyArrayDataException, и вывести результат расчета.
 */

import java2.homework2.MyExceptions.*;

public class Main {

    public static String[][] array = {
            {"31", "s", "1", "17"},
            {"55", "1", "5", "7"},
            {"51", "122", "15", "17"},
            {"23", "5", "1", "74"}
    };

    public static void main(String[] args) {
        try {
            System.out.println(arrayFourOnFour(array));
        } catch (MyArraySizeException e) {
            System.out.println(e.getError());
        } catch (MyArrayDataException e) {
            System.out.println(e.getStrError());
        }


    }

    public static int arrayFourOnFour(String[][] array) throws MyArraySizeException, MyArrayDataException {
        if (array.length != 4) {
            throw new MyArraySizeException("Main array length not four!");
        } else {
            for (int i = 0; i < array.length; i++) {
                if (array[i].length != 4) {
                    throw new MyArraySizeException("In main array element [" + i + "] length not four!");
                }
            }
        }
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    count += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    System.out.println(e.getMessage());
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        return count;
    }

}
