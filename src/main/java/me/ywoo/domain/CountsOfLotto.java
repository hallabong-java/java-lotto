package me.ywoo.domain;

public class CountsOfLotto {
	private int count;

	public CountsOfLotto(int price) {
		this.count = price / Price.PRICE_UNIT;
	}

	public int getCount() {
		return count;
	}
}
