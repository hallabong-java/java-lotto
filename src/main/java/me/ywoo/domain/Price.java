package me.ywoo.domain;

import java.util.Objects;

public class Price {
	private static final int PRICE_UNIT = 1000;
	private static final int REMAIN_IS_ZERO = 0;
	private static final int UPPER_BOUNDARY_OF_PRICE = 100000;
	private static final int LOWER_BOUNDARY_OF_PRICE = 1000;

	private int price;

	public Price(String priceText) {
		validateNumber(priceText);
		price = Integer.parseInt(priceText);
		validateBoundary(price);
		validatePrice(price);
	}

	private void validateNumber(String priceText) {
		Objects.requireNonNull(priceText, "가격이 null입니다.");
		try {
			Integer.parseInt(priceText);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("가격을 숫자로 입력해야 합니다.");
		}
	}

	private void validatePrice(int price) {
		if ((price % PRICE_UNIT) != REMAIN_IS_ZERO) {
			throw new IllegalArgumentException("1000원 단위로 입력해야 합니다.");
		}
	}

	private void validateBoundary(int price) {
		if (price < LOWER_BOUNDARY_OF_PRICE || price > UPPER_BOUNDARY_OF_PRICE) {
			throw new IllegalArgumentException("가격은 1000원 이상, 100000원 미만입니다.");
		}
	}

	public int getPrice() {
		return price;
	}
}
