package java1.homework2;

/*
1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
С помощью цикла и условия заменить 0 на 1, 1 на 0;
2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
6. ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен
вернуть true если в массиве есть место, в котором сумма левой и правой части массива равны.
Примеры: checkBalance([1, 1, 1, || 2, 1]) → true, checkBalance ([2, 1, 1, 2, 1]) → false,
checkBalance ([10, || 10]) → true, граница показана символами ||, эти символы в массив не входят.
7. **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным,
или отрицательным), при этом метод должен сместить все элементымассива на n позиций.
Для усложнения задачи нельзя пользоваться вспомогательными массивами.
 */

import java.util.Arrays;

public class J1Hw2 {

    public static void main(String[] args) {

        //task1.
        int[] arr1 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println(Arrays.toString(arr1));
        replaceArrayTask1(arr1);
        System.out.println(Arrays.toString(arr1));

        //task2.
        int[] arr2 = new int[8];
        initArrayOn3(arr2);
        System.out.println(Arrays.toString(arr2));

        //task3.
        int[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(arr3));
        less6(arr3);
        System.out.println(Arrays.toString(arr3));

        //task4.
        int[][] arr4 = new int[5][5];
        diagonal(arr4);
        for (int i = 0; i < arr4.length; i++) {
            System.out.println(Arrays.toString(arr4[i]));
        }

        //task5.
        minMax(arr3);

        //task6.
        //int[] arr6 = {1, 1, 2};
        System.out.println(isCenter(new int[]{1, 1, 2}));

        //task7.
        int[] arr7 = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(arr7));
        replaceArray(arr7, 2);
        System.out.println(Arrays.toString(arr7));

    }

    //task1.
    public static void replaceArrayTask1(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] == 0 ? 1 : 0;
        }
    }

    //task2.
    public static void initArrayOn3(int[] arr) {
        if (arr.length == 8) {
            for (int i = 1; i < 8; i++) {
                arr[i] = i * 3;
            }
        }
    }

    //task3.
    public static void less6(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] < 6 ? arr[i] * 2 : arr[i];
        }
    }

    //task4.
    public static void diagonal(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i][i] = 1;
            arr[i][arr.length - i - 1] = 1;
        }
    }

    //task5.
    public static void minMax(int[] arr) {
        int min = arr[0], max = arr[0];
        for (int n : arr) {
            if (n < min) min = n;
            if (n > max) max = n;
        }
        System.out.println("В массиве:");
        System.out.println(Arrays.toString(arr));
        System.out.println("минимум = " + min + ", максимум = " + max);
    }

    //task6.
    public static boolean isCenter(int[] arr) {
        int center = 0, result = 0;
        for (int n : arr) {
            center += n;
        }
        center /= 2;
        for (int n : arr) {
            result += n;
            if (result > center) return false;
            if (result == center) return true;
        }
        return false;
    }

    //task7.
    public static void replaceArray(int[] arr, int n) {
        n = n % arr.length;
        if (n == 0) return;
        if (n > 0) {
            for (int i = 0; i < n; i++) {
                int temp = arr[arr.length - 1];
                for (int j = arr.length - 2; j >= 0; j--) {
                    arr[j + 1] = arr[j];
                }
                arr[0] = temp;
            }
        }
        if (n < 0) {
            n *= -1;
            for (int i = 0; i < n; i++) {
                int temp = arr[0];
                for (int j = 1; j < arr.length; j++) {
                    arr[j - 1] = arr[j];
                }
                arr[arr.length - 1] = temp;
            }
        }
    }
}
