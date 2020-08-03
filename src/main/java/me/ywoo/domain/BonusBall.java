package me.ywoo.domain;

public class BonusBall {
	private static int bonusBall;

	public BonusBall(String bonusBallText) {
		validateBoundary(Integer.parseInt(bonusBallText));
		bonusBall = Integer.parseInt(bonusBallText);
	}

	public void validateBoundary(int bonusBall) {
		if (bonusBall < LottoTicket.LOWER_BOUNDARY || bonusBall > LottoTicket.UPPER_BOUNDARY) {
			throw new IllegalArgumentException("보너스 볼의 값은 1부터 45까지 입니다.");
		}
	}

	public int getBonusBall() {
		return bonusBall;
	}
}
