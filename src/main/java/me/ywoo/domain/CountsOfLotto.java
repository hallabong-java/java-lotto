package me.ywoo.domain;

public class CountsOfLotto {
	private int count;

	public CountsOfLotto(String priceText) {
		Price price = new Price(priceText);
		this.count = price.getPrice() / Price.PRICE_UNIT;
	}

	public int getCount() {
		return count;
	}
}
