package me.ywoo.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.util.stream.Collectors.toList;

public class RandomNumbers implements RandomNumbersGenerator {
	private static final int SIZE_OF_LOTTO = 6;

	public List<Integer> randomNumbers;

	public RandomNumbers() {
		randomNumbers = new ArrayList<>();
		this.randomNumbers = generateRandomNumber();
	}

	@Override
	public List<Integer> generateRandomNumber() {
		return new Random().ints(LOWER_BOUNDARY - 1, UPPER_BOUNDARY + 1)
			.distinct()
			.limit(SIZE_OF_LOTTO)
			.boxed()
			.collect(toList());
	}

	public int searchMatchNumber(List<Integer> winnerLotto) {
		int countOfSameNumbers = 0;
		for (Integer numbers : randomNumbers) {
			if (winnerLotto.contains(numbers)) {
				countOfSameNumbers++;
			}
		}
		return countOfSameNumbers;
	}

	public List<Integer> getRandomNumbers() {
		return randomNumbers;
	}
}