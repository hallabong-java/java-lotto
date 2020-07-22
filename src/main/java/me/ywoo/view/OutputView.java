package me.ywoo.view;

import java.util.ArrayList;

public class OutputView {
    public static void printPrice(int price){
        System.out.println(price);
    }
    public static void printCountOfLotto(int count){
        System.out.println(count+"를 구매했습니다.");
    }
    public static void printLotto(ArrayList<Integer> UserLotto){
        System.out.print("[");
        for(int lotto : UserLotto){
            System.out.print(lotto+", ");
        }
        System.out.print("]");
    }
}
