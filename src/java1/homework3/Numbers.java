package java1.homework3;

/*
Написать программу, которая загадывает случайное число от 0 до 9, и пользователю дается 3 попытки угадать это число.
При каждой попытке компьютер должен сообщить больше ли указанное пользователем число чем загаданное, или меньше.
После победы или проигрыша выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).
 */

import java.util.Random;
import java.util.Scanner;

public class Numbers {

    public static void main(String[] args) {
        new Numbers();
    }

    private Scanner sc;
    private Random rand;
    private boolean isGame;
    private int numAi, numPlayer;

    public Numbers() {

        isGame = true;
        rand = new Random();
        sc = new Scanner(System.in);

        while (isGame) {
            numAi = rand.nextInt(9);
            System.out.println("Компьютер загадал число от 0 до 9");
            System.out.println("Попытайтесь его угадать с трех попыток");
            for (int i = 1; i < 4; i++) {
                System.out.println("Попытка № " + i);
                numPlayer = sc.nextInt();
                if(checkResult(numPlayer, numAi)) {
                    break;
                }
                if(i == 3) {
                    System.out.println("Увы, Вы проиграли, было загаданно число " + numAi);
                }
            }
            isGame = isContinue();
        }
        System.out.println("Игра окончена");
    }

    boolean checkResult(int numPlayer, int numAi) {
        if (numPlayer == numAi) {
            System.out.println("Поздравляем, Вы угадали число!");
            return true;
        }
        if (numPlayer > numAi) System.out.println("Загаданное число меньше");
        if (numPlayer < numAi) System.out.println("Загаданное число больше");
        return false;
    }

    boolean isContinue() {
        System.out.println("Продолжаем играть? (0 - нет, 1 - да)");
        int res = sc.nextInt();
        return res != 0;
    }

}
