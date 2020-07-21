package me.ywoo.view;

import java.util.Scanner;

public class inputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static String receivePrice(){
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextLine();
    }
}
