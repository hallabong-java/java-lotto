package me.ywoo.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PriceTest {

	@DisplayName("Price(string) - 숫자 받아서 객체 생성")
	@ParameterizedTest
	@ValueSource(strings = {"14000"})
	void Price_GenerateInstance(final String priceText) {
		assertThat(new Price(priceText)).isInstanceOf(Price.class);
	}

	@DisplayName("ValidateNumber() - 숫자 이외에 다른 문자열인지 검사")
	@ParameterizedTest
	@ValueSource(strings = {"abc", "98123d"})
	void validate_checkRightNumber(final String priceText) {
		assertThatThrownBy(() -> new Price(priceText))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("가격을 숫자로 입력해야 합니다.");
	}

	@DisplayName("ValidateNumber() - Null이 아닌지 검사")
	@ParameterizedTest
	@NullSource
	void validate_checkNonNull(final String priceText) {
		assertThatThrownBy(() -> new Price(priceText))
			.isInstanceOf(NullPointerException.class)
			.hasMessage("가격이 null입니다.");
	}

	@DisplayName("ValidatePrice() - 유효한 가격인지 검사")
	@Test
	void validate_checkRightPrice() {
		assertThatThrownBy(() -> new Price("14444"))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("1000원 단위로 입력해야 합니다.");
	}

	@DisplayName("ValidateBoundary() - 유효한 가격 범위에 있는지 검사")
	@ParameterizedTest
	@ValueSource(strings = {"10000000", "-20000"})
	void validate_checkBoundary(final String priceText) {
		assertThatThrownBy(() -> new Price(priceText))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("가격은 1000원 이상, 100000원 미만입니다.");
	}
}