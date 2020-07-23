package me.ywoo.domain;

import java.util.ArrayList;

public class BonusBall {
    public static int bonusBall;

    public BonusBall(String bonusBallText, ArrayList<Integer> winnerNumbers) {
        this.bonusBall = Integer.parseInt(bonusBallText);
        findDuplication(winnerNumbers);
        validateBoundary(bonusBall);
    }

    public void findDuplication(ArrayList<Integer> winnerNumbers) {
        if (winnerNumbers.contains(bonusBall)) {
            throw new IllegalArgumentException("보너스 볼의 값이 당첨 로또와 일치합니다.");
        }
    }

    public void validateBoundary(int bonusBall) {
        if (bonusBall < RandomNumbers.LOWER_BOUNDARY || bonusBall > RandomNumbers.UPPER_BOUNDARY) {
            throw new IllegalArgumentException("보너스 볼의 값은 1부터 45까지 입니다.");
        }
    }

    public static boolean checkHavingBonusBall(ArrayList<Integer> randomNumbers) {
        if (randomNumbers.contains(bonusBall)) {
            return true;
        }
        return false;
    }
}
