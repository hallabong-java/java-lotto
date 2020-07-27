package me.ywoo.domain;

public class CountsOfLotto {
	private static final int PRICE_UNIT = 1000;

	private int count;

	public CountsOfLotto(int price) {
		this.count = price / PRICE_UNIT;
	}

	public int getCount() {
		return count;
	}
}
