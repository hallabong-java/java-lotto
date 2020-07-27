package me.ywoo.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class WinnerLotto {
	private static final String DELIMITER = ", ";
	private static final int LOTTO_NUMBERS_SIZE = 6;

	public List<Integer> winnerNumbers;

	public WinnerLotto(final String inputNumbers) {
		winnerNumbers = new ArrayList<>();
		createWinnerNumbers(inputNumbers);
		validateWinnerNumbers(winnerNumbers);
		findDuplication(winnerNumbers);
	}

	public void createWinnerNumbers(final String inputNumbers) {
		Objects.requireNonNull(inputNumbers, "숫자가 null입니다.");

		for (String numberText : inputNumbers.split(DELIMITER)) {
			Integer number = Integer.parseInt(numberText);
			winnerNumbers.add(number);
		}
	}

	public void validateWinnerNumbers(List<Integer> winnerNumbers) {
		if (winnerNumbers.size() != LOTTO_NUMBERS_SIZE) {
			throw new IllegalArgumentException("로또의 개수와 불일치합니다.");
		}
	}

	public void findDuplication(List<Integer> winnerNumbers) {
		if (winnerNumbers.stream().distinct().collect(Collectors.toList()).size() != winnerNumbers.size()) {
			throw new IllegalArgumentException("값이 중복되지 않게 입력해야 합니다.");
		}
	}

	public List<Integer> getWinnerNumbers() {
		return winnerNumbers;
	}
}
