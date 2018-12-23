package java1.homework4;

/*
Написать крестики нолики в процедурном стиле
 */

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    final static int SIZE = 3;
    final static int SIZE_WIN = 3;
    final static char DOT_PLAYER = 'x';
    final static char DOT_AI = 'o';
    final static char DOT_EMPTY = '•';
    static char[][] field;
    static Scanner sc = new Scanner(System.in);
    static Random rand = new Random();

    public static void main(String[] args) {
        initField();
        printField();
        while (true) {
            playerTurn();
            printField();
            if(checkWin(DOT_PLAYER)) {
                System.out.println("Игрок победил");
                break;
            }
            if (fieldIsFull()) {
                System.out.println("Ничья");
                break;
            }
            aiTurn();
            printField();
            if(checkWin(DOT_AI)) {
                System.out.println("Компьютер победил");
                break;
            }
            if (fieldIsFull()) {
                System.out.println("Ничья");
                break;
            }
        }
    }

    static void initField() {
        field = new char[SIZE][SIZE];
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                field[i][j] = DOT_EMPTY;
            }
        }
    }

    static void printField() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i);
            System.out.print(" ");
        }
        System.out.println();
        for (int i = 0; i < field.length; i++) {
            System.out.print(i + 1);
            System.out.print(" ");
            for (int j = 0; j < field[i].length; j++) {
                System.out.print(field[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    static void playerTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты х - линия и у - столбец:");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!dotIsEmpty(x, y));
        field[x][y] = DOT_PLAYER;
    }

    static void aiTurn() {
        System.out.println("Компьютер сделал ход:");
        int x, y;
        do {
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);
        } while (!dotIsEmpty(x, y));
        field[x][y] = DOT_AI;
    }

    static boolean dotIsEmpty(int x, int y) {
        return field[x][y] == DOT_EMPTY;
    }

    static boolean fieldIsFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (field[i][j] == DOT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    //проверка победы
    private static boolean checkWin(char dot) {
        for (int v = 0; v < SIZE; v++) {
            for (int h = 0; h < SIZE; h++) {
                //анализ наличие поля для проверки
                if (h + SIZE_WIN <= SIZE) {                           //по горизонтале
                    if (checkLineHorisont(v, h, dot) >= SIZE_WIN) return true;

                    if (v - SIZE_WIN > -2) {                            //вверх по диагонале
                        if (checkDiaUp(v, h, dot) >= SIZE_WIN) return true;
                    }
                    if (v + SIZE_WIN <= SIZE) {                       //вниз по диагонале
                        if (checkDiaDown(v, h, dot) >= SIZE_WIN) return true;
                    }
                }
                if (v + SIZE_WIN <= SIZE) {                       //по вертикале
                    if (checkLineVertical(v, h, dot) >= SIZE_WIN) return true;
                }
            }
        }
        return false;
    }

    //проверка заполнения всей линии по диагонале вверх
    private static int checkDiaUp(int v, int h, char dot) {
        int count = 0;
        for (int i = 0, j = 0; j < SIZE_WIN; i--, j++) {
            if ((field[v + i][h + j] == dot)) count++;
        }
        return count;
    }

    //проверка заполнения всей линии по диагонале вниз
    private static int checkDiaDown(int v, int h, char dot) {
        int count = 0;
        for (int i = 0; i < SIZE_WIN; i++) {
            if ((field[i + v][i + h] == dot)) count++;
        }
        return count;
    }

    private static int checkLineHorisont(int v, int h, char dot) {
        int count = 0;
        for (int j = h; j < SIZE_WIN + h; j++) {
            if ((field[v][j] == dot)) count++;
        }
        return count;
    }

    private static int checkLineVertical(int v, int h, char dot) {
        int count = 0;
        for (int i = v; i < SIZE_WIN + v; i++) {
            if ((field[i][h] == dot)) count++;
        }
        return count;
    }

}
