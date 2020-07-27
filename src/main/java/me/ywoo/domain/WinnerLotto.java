package me.ywoo.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class WinnerLotto implements SearchAnyNumber{
	private static final String DELIMITER = ", ";
	private static final int LOTTO_NUMBERS_SIZE = 6;

	private List<Integer> winnerNumbers;

	public WinnerLotto(final String inputNumbers) {
		winnerNumbers = new ArrayList<>();
		createWinnerNumbers(inputNumbers);
		validateWinnerNumbers(winnerNumbers);
		findDuplication(winnerNumbers);
	}

	private void createWinnerNumbers(final String inputNumbers) {
		Objects.requireNonNull(inputNumbers, "숫자가 null입니다.");

		for (String numberText : inputNumbers.split(DELIMITER)) {
			Integer number = Integer.parseInt(numberText);
			winnerNumbers.add(number);
		}
	}

	private void validateWinnerNumbers(List<Integer> winnerNumbers) {
		if (winnerNumbers.size() != LOTTO_NUMBERS_SIZE) {
			throw new IllegalArgumentException("로또의 개수와 불일치합니다.");
		}
	}

	private void findDuplication(List<Integer> winnerNumbers) {
		int sizeOfRemoveDuplication = winnerNumbers.stream().distinct().collect(Collectors.toList()).size();
		if (sizeOfRemoveDuplication != winnerNumbers.size()) {
			throw new IllegalArgumentException("값이 중복되지 않게 입력해야 합니다.");
		}
	}

	@Override
	public boolean searchNumber(Integer bonusBall){
		return winnerNumbers.contains(bonusBall);
	}

	public List<Integer> getWinnerNumbers() {
		return winnerNumbers;
	}
}
