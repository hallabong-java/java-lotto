package me.ywoo.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static java.util.stream.Collectors.toList;

public class LottoTicket implements SearchAnyNumber {
	public static int UPPER_BOUNDARY = 45;
	public static int LOWER_BOUNDARY = 1;
	private static int SIZE_OF_LOTTO = 6;

	private List<Integer> randomNumbers;

	public LottoTicket() {
		randomNumbers = new ArrayList<>();
		this.randomNumbers = generateLottoTicket();
	}

	public List<Integer> generateLottoTicket() {
		int sizeOfLotto = 6;
		while(sizeOfLotto-- > 0){
			Integer nowRandomNumber = new RandomNumber().randomNumber;
			if(!searchNumber(nowRandomNumber)){
				randomNumbers.add(nowRandomNumber);
			}
		}
		return randomNumbers;
	}

	public int giveCountOfMatchNumber(List<Integer> winnerLotto) {
		int countOfSameNumbers = 0;
		for (Integer numbers : randomNumbers) {
			if (winnerLotto.contains(numbers)) {
				countOfSameNumbers++;
			}
		}
		return countOfSameNumbers;
	}

	@Override
	public boolean searchNumber(Integer anyNumber){
		return randomNumbers.contains(anyNumber);
	}

	public List<Integer> getRandomNumbers() {
		return randomNumbers;
	}
}