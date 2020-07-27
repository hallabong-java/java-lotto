package me.ywoo.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;

import java.math.BigInteger;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class YieldTest {

	private static final int EXAMPLE_OF_COUNT = 3;
	private static final String EXAMPLE_OF_INPUT = "1, 2, 3";

	UserLottoTickets userLottoTickets = new UserLottoTickets(EXAMPLE_OF_COUNT);
	WinnerLotto winnerLotto = new WinnerLotto(EXAMPLE_OF_INPUT);

	@DisplayName("Yield() - 수익률 가진 객체 생성")
	@Test
	void Yield_generateInstance() {
		assertThat(new Yield()).isInstanceOf(Yield.class);
	}

	@DisplayName("calculateResult() - Null이 아닌지 검사")
	@ParameterizedTest
	@NullSource
	void calculateYield_checkNonNull(final BigInteger totalEarning) {
		assertThatThrownBy(() -> new Yield().calculateYield(totalEarning, 4000))
			.isInstanceOf(NullPointerException.class)
			.hasMessage("총 수익이 없습니다.");
	}

	@DisplayName("calculateResult() - 계산 맞는지 검사")
	@Test
	void calculateYield_checkAnswer() {
		Yield yield = new Yield();
		BigInteger actual = yield.calculateYield(BigInteger.valueOf(100), 3000);
		BigInteger expected = BigInteger.valueOf(3);
		assertThat(actual).isEqualTo(expected);
	}
}