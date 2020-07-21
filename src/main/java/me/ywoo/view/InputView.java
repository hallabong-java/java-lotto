package me.ywoo.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static String receivePrice(){
        System.out.println("구입 금액을 입력해 주세요.");
        return scanner.nextLine();
    }

    public static String receiveWinnerNumbers(){
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }

    public static String receiveBonusBallNumber(){
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.nextLine();
    }
}
