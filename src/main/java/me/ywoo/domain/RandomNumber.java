package me.ywoo.domain;

import java.util.Random;

public class RandomNumber {
	public static final int UPPER_BOUNDARY = 45;

	public Integer randomNumber;

	public RandomNumber() {
		this.randomNumber = new Random().nextInt(UPPER_BOUNDARY) + 1;
	}
}
