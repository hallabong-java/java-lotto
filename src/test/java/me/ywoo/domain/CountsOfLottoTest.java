package me.ywoo.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CountsOfLottoTest {
	@DisplayName("CountsOfLotto(int) - 숫자 받아서 객체 생성")
	@Test
	void CountsOfLotto_GenerateInstance() {
		int expected = 3;
		int actual = new CountsOfLotto(3000).getCount();
		assertThat(actual).isEqualTo(expected);
	}
}