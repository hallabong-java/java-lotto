package me.ywoo.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class YieldTest {
	@DisplayName("Yield() - 수익률 가진 객체 생성")
	@Test
	void Yield_generateInstance() {
		assertThat(new Yield()).isInstanceOf(Yield.class);
	}

}