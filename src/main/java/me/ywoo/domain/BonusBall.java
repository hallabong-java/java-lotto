package me.ywoo.domain;

import java.util.ArrayList;

public class BonusBall {
	private int bonusBall;

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
		if (bonusBall < RandomNumbersGenerator.LOWER_BOUNDARY || bonusBall > RandomNumbersGenerator.UPPER_BOUNDARY) {
			throw new IllegalArgumentException("보너스 볼의 값은 1부터 45까지 입니다.");
		}
	}

	public static boolean checkHavingBonusBall(ArrayList<Integer> randomNumbers, int bonusBall) {
		return randomNumbers.contains(bonusBall);
	}

	public int getBonusBall() {
		return bonusBall;
	}
}
