package com.company;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;

public class Lesson3 {

    public static void main(String[] args) throws IOException {
        doGuessWord();

        doGuessNum();
    }


/* Run */
    public static void doGuessWord() throws IOException {
        /*
         *2 * Создать массив из слов String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado",
         *  "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut",
         * "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
         *
         * При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
         * сравнивает его с загаданным словом и сообщает правильно ли ответил пользователь. Если слово не угадано,
         * компьютер показывает буквы которые стоят на своих местах. apple – загаданное apricot - ответ игрока
         * ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
         * Для сравнения двух слов посимвольно, можно пользоваться: * String str = "apple";
         * str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции Играем до тех пор,
         * пока игрок не отгадает слово. Используем только маленькие буквы
         */
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear",
                "pepper", "pineapple", "pumpkin", "potato"};

        String str = getWord(words);
        StringBuilder strReturn = new StringBuilder();
        for (String word : words) System.out.println(word); // Выводим варианты списком
        System.out.println("Угадайте загаданное слово!");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             while (true) {
                String answer = reader.readLine(); // Читаем что там написал пользователь
                 answer = maskedWord(answer);
                 String maskStr = maskedWord(str);
                 strReturn.setLength(maskStr.length());
                if (answer.equalsIgnoreCase(maskStr)) {

                    strReturn.append("Вы угадали  ").append(str);
                    System.out.println(strReturn);
                    break;
                } else {
                  for (int i = 0; i < maskStr.length() - 1; i++) {
                        if (maskStr.charAt(i) == answer.charAt(i)) {
                            strReturn.setCharAt(i, maskStr.charAt(i));
                        } else  strReturn.setCharAt(i, '#');
                    }
                    System.out.println(strReturn.toString());

                }

            }
   }

    static String maskedWord(String s) {
        String mask = "###############";
        StringBuilder sBuilder = new StringBuilder(s);
        for (int i = sBuilder.length() - 1; i < mask.length() - 1; i++) {
              sBuilder.append(mask.charAt(i));
            }
        s = sBuilder.toString();
        return s;
    }
    private static String getWord(String[] word) {
        Random random = new Random();
        return word[random.nextInt(word.length - 1)];
    }


    /**
     *Написать программу, которая загадывает случайное число от 0 до 9 и пользователю дается 3 попытки угадать это число.
     *  При каждой попытке компьютер должен сообщить, больше ли указанное пользователем число, чем загаданное,
     * или меньше. После победы или проигрыша выводится запрос – «Повторить игру еще раз?
     *  1 – да / 0 – нет»(1 – повторить, 0 – нет).
     */
    private static void doGuessNum (){


        int check = 3;
        int i;
        i = getNumber();
        System.out.println("Отгадайте число от '0' до '9'! ");
        System.out.println("У Вас есть 3 попытки!");
        do {

         Scanner getNum = new Scanner(System.in);
         System.out.println("Введите число от '0' до '9' ");
            int num = getNum.nextInt();
                if (num > i) {
                    System.out.println("Загаданное число меньше");
                    check--;

                }
                   else
                     if (num < i) {
                         System.out.println("Загаданное число больше");
                         check--;

                 }
                   else {
                         System.out.println("Вы угадали. Загаданное число "+ i);
                         System.out.println("Повторить игру? (1 – да / 0 – нет»(1 – повторить, 0 – нет)");
                         num = getNum.nextInt();
                         if (isContinue(num) == 0) break;
                         else {check = isContinue(num);
                             i = getNumber();
                         }
                     }
                   if (check == 0) {
                       System.out.println("Вы проиграли!");
                       System.out.println("Повторить игру? (1 – да / 0 – нет»(1 – повторить, 0 – нет)");
                       num = getNum.nextInt();
                       if (isContinue(num) == 0) break;
                       else {check = isContinue(num);
                            i = getNumber();
                       }
                   }
        }while (true);

    }
    private static int isContinue (int num) {

        if (num == 0) return 0;
        else {

            return  3;
        }
    }

    static int getNumber () {
        int min = 0;
        int max = 9;
        int diff = max - min;
        Random random = new Random();
        int i = random.nextInt(diff + 1);
        i += min;
        return i;
    }

}
