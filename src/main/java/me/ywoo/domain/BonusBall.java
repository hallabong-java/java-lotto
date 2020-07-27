package me.ywoo.domain;

public class BonusBall {
	private static int bonusBall;

	public BonusBall(String bonusBallText) {
		this.bonusBall = Integer.parseInt(bonusBallText);
		validateBoundary(bonusBall);
	}

	public void validateBoundary(int bonusBall) {
		if (bonusBall < RandomNumbersGenerator.LOWER_BOUNDARY || bonusBall > RandomNumbersGenerator.UPPER_BOUNDARY) {
			throw new IllegalArgumentException("보너스 볼의 값은 1부터 45까지 입니다.");
		}
	}

	public void duplicationException() {
		throw new IllegalArgumentException("보너스 볼의 값이 당첨 로또와 일치합니다.");
	}

	public int getBonusBall() {
		return bonusBall;
	}
}
