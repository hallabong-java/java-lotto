package me.ywoo.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class YieldTest {
	@DisplayName("Yield() - 수익률 가진 객체 생성")
	@Test
	void Yield_generateInstance() {
		assertThat(new Yield()).isInstanceOf(Yield.class);
	}

	@DisplayName("calculateResult() - Null이 아닌지 검사")
	@ParameterizedTest
	@NullSource
	void calculateYield_checkNonNull(final Long totalEarning) {
		assertThatThrownBy(() -> new Yield().calculateYield(totalEarning, 4000))
			.isInstanceOf(NullPointerException.class)
			.hasMessage("총 수익이 없습니다.");
	}

	@DisplayName("calculateResult() - 계산 맞는지 검사")
	@Test
	void calculateYield_checkAnswer() {
		Yield yield = new Yield();
		Long actual = yield.calculateYield((long)100, 3000);
		assertThat(actual).isEqualTo(3);
	}
}