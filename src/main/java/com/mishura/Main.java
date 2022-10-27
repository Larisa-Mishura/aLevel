package com.mishura;

public class Main {
    public static void main(String[] args) {
        System.out.println("Лариса Мішура");

        var y = 5;
        for(int i = 0; i <=10; i++){
            System.out.println("Крок " + i + ", значення " + y);
            y += 2;
        }

        for(int i = 0; i <=10; i++){
            if(i == 3){
                continue;
            }
            if(i == 6){
                break;
            }
            System.out.println("Крок " + i);
        }
    }
}