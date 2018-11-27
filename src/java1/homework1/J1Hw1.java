package java1.homework1;

/*
1. Создать пустой проект в IntelliJ IDEA и прописать метод main();
2. Создать переменные всех пройденных типов данных, и инициализировать их значения;
3. Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат,
где a, b, c, d – входные параметры этого метода;
4. Написать метод, принимающий на вход два числа, и проверяющий что их сумма лежит в пределах от 10 до 20(включительно),
если да – вернуть true, в противном случае – false;
5. Написать метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль
положительное ли число передали, или отрицательное; Замечание: ноль считаем положительным числом.
6. Написать метод, которому в качестве параметра передается целое число, метод должен вернуть true,
если число отрицательное;
7. Написать метод, которому в качестве параметра передается строка, обозначающая имя,
метод должен вывести в консоль сообщение «Привет, указанное_имя!»;
8. * Написать метод, который определяет является ли год високосным,
и выводит сообщение в консоль. Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
 */

public class J1Hw1 {

    public static void main(String[] args) {

        //task2.
        byte a = 12;
        short b = 200;
        int c = 200000;
        long d = 1234577L;

        float e = 5.6f;
        double f = 7777.12;

        boolean g = true;

        char h = 'a';

        //task3.
        System.out.println(calc(5, 7, 8, 9));

        //task4.
        System.out.println(isDiapason(5, 7));
        System.out.println(isDiapason(5, 3));
        System.out.println(isDiapason(15, 7));

        //task5.
        aboutNumber(1);
        aboutNumber(-1);

        //task6.
        System.out.println(isNegative(-7));
        System.out.println(isNegative(7));

        //task7.
        hello("Станислав");

        //task8.
        isLeep(2018);
        isLeep(2016);
        isLeep(100);
        isLeep(400);

    }

    public static double calc(double a, double b, double c, double d) {
        return a * (b + (c / d));
    }

    public static boolean isDiapason(int a, int b) {
        int sum = a + b;
        return (sum >= 10 && sum <= 20);
    }

    public static void aboutNumber(int a) {
        if (a < 0) {
            System.out.println("Число " + a + " отрицательное.");
            return;
        }
        System.out.println("Число " + a + " положительное.");
    }

    public static boolean isNegative(int a) {
        return a < 0;
    }

    public static void hello(String name) {
        System.out.println("Привет, " + name + "!");
    }

    public static void isLeep(int year) {
        if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            System.out.println("Год " + year + " является високосным!");
        } else {
            System.out.println("Год " + year + " не является високосным!");
        }
    }

}
