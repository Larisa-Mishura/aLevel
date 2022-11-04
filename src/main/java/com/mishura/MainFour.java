package com.mishura;

import java.util.Scanner;

public class MainFour {
    public static void main(String[] args) {
        fistAndLastSymbol();
        endsWithText();
        startsWithText();
        containsSubstring();
        comparison();
    }

    public static String inputText(String message){
        System.out.println(message);
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        if (text.isBlank()){
            text = inputText(message);
        }
        return text;
    }

    public static void fistAndLastSymbol(){
        String text = inputText("Введіть текст");
        System.out.println("Перший символ - " + text.charAt(0));
        System.out.println("Останній символ - " + text.charAt(text.length()-1));
    }

    public static void endsWithText(){
        String text = inputText("Введіть текст, щоб перевірити, чи закінчується вказаною підстрокою");
        String substring = inputText("Введіть текст підстроки");
        System.out.println(text.endsWith(substring));
    }

    public static void startsWithText(){
        String text = inputText("Введіть текст, щоб перевірити, чи починається з вказаної підстроки");
        String substring = inputText("Введіть текст підстроки");
        System.out.println(text.startsWith(substring));
    }

    public static void containsSubstring(){
        String text = inputText("Введіть текст, щоб перевірити, чи містить вказану підстроку");
        String substring = inputText("Введіть текст підстроки");
        System.out.println(text.contains(substring));
    }

    public static void comparison(){
        String text1 = inputText("Введіть перший рядок для порівняння");
        System.out.println("Введіть другий рядок");
        Scanner sc = new Scanner(System.in);
        String text2 = sc.nextLine();
        System.out.println(text1.equalsIgnoreCase(text2));
    }

}



