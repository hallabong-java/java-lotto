package me.ywoo.domain;

import static java.util.stream.Collectors.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomNumber {
	private static final int LOWER_BOUNDARY = 1;
	public static int UPPER_BOUNDARY = 45;

	public Integer randomNumber;

	public RandomNumber() {
		this.randomNumber = new Random().nextInt(UPPER_BOUNDARY + 1) + 1;
	}
}
