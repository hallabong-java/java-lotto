package me.ywoo.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinnerLottoTest {

	@DisplayName("createWinnerNumbers(String) - 문자열 받아서 자르고 Integer로 배열 생성")
	@ParameterizedTest
	@ValueSource(strings = {"1, 2, 3, 4, 5, 6"})
	void CreateWinnerNumbers_generateInstance(final String inputNumbers) {
		ArrayList<Integer> actual = new WinnerLotto(inputNumbers).winnerNumbers;

		assertThat(actual).containsExactly(1, 2, 3, 4, 5, 6);
	}

	@DisplayName("createWinnerNumbers(String) - NULL 받은 경우 예외 검사")
	@ParameterizedTest
	@NullSource
	void CreateWinnerNumbers_checkNullExceptionThrown(final String inputNumbers) {
		assertThatThrownBy(() -> new WinnerLotto(inputNumbers))
			.isInstanceOf(NullPointerException.class)
			.hasMessage("숫자가 null입니다.");
	}

	@DisplayName("validateWinnerNumbers() - 6개 입력했는지 검사")
	@ParameterizedTest
	@ValueSource(strings = {"1, 2, 3, 4"})
	void validateWinnerNumbers_checkAnotherSizeExceptionThrown(final String inputNumbers) {
		ArrayList<Integer> winnerNumbers = new ArrayList<Integer>();

		winnerNumbers.addAll(Arrays.asList(13, 11, 20, 19, 40));

		assertThatThrownBy(() -> new WinnerLotto(inputNumbers).validateWinnerNumbers(winnerNumbers))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("로또의 개수와 불일치합니다.");
	}

	@DisplayName("findDuplication() - 중복되는 숫자 있는지 검사")
	@ParameterizedTest
	@ValueSource(strings = {"1, 2, 3, 4, 5, 5"})
	void findDuplication_checkDuplicationExceptionThrown(final String inputNumbers) {
		assertThatThrownBy(() -> new WinnerLotto(inputNumbers))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("값이 중복되지 않게 입력해야 합니다.");
	}
}