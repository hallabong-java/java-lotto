package me.ywoo.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BonusBallTest {
	private static final ArrayList<Integer> winnerNumbers = new ArrayList<Integer>(
		Arrays.asList(13, 11, 20, 19, 40, 45));

	@DisplayName("BonusBall(string) - 문자열 받아서 Integer로 숫자 생성")
	@ParameterizedTest
	@ValueSource(strings = {"9", "33"})
	void bonusBall_generateInstance(final String bonusBallText) {
		assertThat(new BonusBall(bonusBallText, winnerNumbers)).isInstanceOf(BonusBall.class);
	}

	@DisplayName("validateBoundary() - 범위 내에 들어가는지 검사")
	@Test
	void validateBoundary_checkBoundaryOfBonusBallNumber() {
		assertThatThrownBy(() -> new BonusBall("46", winnerNumbers))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("보너스 볼의 값은 1부터 45까지 입니다.");
	}

	@DisplayName("findDuplication() - 당첨 번호와 중복될 때 검사")
	@Test
	void findDuplication_checkDuplicationExceptionThrown() {
		assertThatThrownBy(() -> new BonusBall("11", winnerNumbers))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("보너스 볼의 값이 당첨 로또와 일치합니다.");
	}
}