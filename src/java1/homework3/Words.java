package java1.homework3;

/*
Создать массив из слов String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli",
"carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut",
"pear", "pepper", "pineapple", "pumpkin", "potato"};
При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
сравнивает его с загаданным словом и сообщает правильно ли ответил пользователь. Если слово не угадано,
компьютер показывает буквы которые стоят на своих местах.
apple – загаданное
apricot - ответ игрока
ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
Для сравнения двух слов посимвольно, можно пользоваться:
String str = "apple";
str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции
Играем до тех пор, пока игрок не отгадает слово
Используем только маленькие буквы
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;

public class Words {

    private String[] words = {"кошка", "собака", "антилопа", "рысь", "лось", "гиппопотам", "пингвин", "лемур", "олень",
            "обезьяна", "жираф", "черепаха", "хомяк", "крокодил", "кенгуру", "бык", "мышь", "леопард", "гепард", "енот",
            "медведь", "лиса", "волк", "суслик", "бобер", "куница", "заяц", "апосум", "бегемот", "слон", "верблюд",
            "белка", "кабан", "зебра", "панда", "пума", "тигр", "лев", "лама", "гиена", "линивец", "шиншила",
            "дикобраз", "коала", "пантера", "муравьед"};
    private BufferedReader reader;
    private Scanner sc;
    private Random rand;
    private boolean isCurrentGame, isGame;
    private String wordAi, wordPlayer;

    public static void main(String[] args) throws IOException {
        new Words();
    }

    public Words() throws IOException {

        isGame = true;
        isCurrentGame = true;
        sc = new Scanner(System.in);
        rand = new Random();
        reader = new BufferedReader(new InputStreamReader(System.in));

        while(isGame) {
            setWordAi();
            while (isCurrentGame) {
                System.out.println("Введите слово");
                wordPlayer = reader.readLine();
                if (checkWin(wordAi, wordPlayer)) {
                    System.out.println("Поздравляю, Вы угадали!");
                    isCurrentGame = false;
                } else {
                    showResult(wordAi, wordPlayer);
                }
            }
            isCurrentGame = true;
            isGame = isContinue();
        }

    }

    void setWordAi() {
        wordAi = words[rand.nextInt(words.length - 1)];
        //System.out.println(wordAi);
        System.out.println("Компьютер загадал слово(животное)");
    }

    public void showResult(String wordAi, String wordPlayer) {
        int wordMin = (wordAi.length() < wordPlayer.length()) ? wordAi.length() : wordPlayer.length();
        for (int i = 0; i < 15; i++) {
            if (i < wordMin && wordAi.charAt(i) == wordPlayer.charAt(i)) {
                System.out.print(wordAi.charAt(i));
            } else {
                System.out.print("*");
            }
        }
        System.out.println();
    }

    public boolean checkWin(String wordAi, String wordPlayer) {
        return wordAi.equals(wordPlayer);
    }

    boolean isContinue() {
        System.out.println("Продолжаем играть? (0 - нет, 1 - да)");
        int res = sc.nextInt();
        return res != 0;
    }
}
