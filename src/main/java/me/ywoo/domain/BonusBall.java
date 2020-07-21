package me.ywoo.domain;

import java.util.ArrayList;

public class BonusBall {
    public int bonusBall;

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
        if (bonusBall < RandomNumberGenerator.LOWER_BOUNDARY || bonusBall > RandomNumberGenerator.UPPER_BOUNDARY) {
            throw new IllegalArgumentException("보너스 볼의 값은 1부터 45까지 입니다.");
        }
    }
}
