package me.ywoo.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoTicket implements SearchAnyNumber {
	private static final int INITIAL_COUNT = 0;
	public static final int UPPER_BOUNDARY = 45;
	public static final int LOWER_BOUNDARY = 1;
	private static final int SIZE_OF_LOTTO = 6;

	private List<Integer> randomNumbers;

	public LottoTicket() {
		randomNumbers = new ArrayList<>();
		this.randomNumbers = generateLottoTicket();
	}

	public List<Integer> generateLottoTicket() {
		int sizeOfLotto = SIZE_OF_LOTTO;
		while (sizeOfLotto-- > 0) {
			Integer nowRandomNumber = new RandomNumber().randomNumber;
			if (!searchNumber(nowRandomNumber)) {
				randomNumbers.add(nowRandomNumber);
			} else
				sizeOfLotto++;
		}
		return randomNumbers;
	}

	public int giveCountOfMatchNumber(WinnerLotto winnerLotto) {
		int countOfSameNumbers = INITIAL_COUNT;
		for (Integer numbers : randomNumbers) {
			if (winnerLotto.matchNumber(numbers)) {
				countOfSameNumbers++;
			}
		}
		return countOfSameNumbers;
	}

	@Override
	public boolean searchNumber(Integer anyNumber) {
		return randomNumbers.contains(anyNumber);
	}

	public List<Integer> getRandomNumbers() {
		return randomNumbers;
	}
}