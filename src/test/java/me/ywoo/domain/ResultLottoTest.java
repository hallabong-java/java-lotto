package me.ywoo.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ResultLottoTest {
    @DisplayName("ResultLotto() - 결과 가진 맵 객체 생성")
    @Test
    void ResultLotto_generateInstance() {
        assertThat(new ResultLotto()).isInstanceOf(ResultLotto.class);
    }

    @DisplayName("calculateResult() - Null이 아닌지 검사")
    @ParameterizedTest
    @NullSource
    void calculateResult_checkNonNull(final UserLottoTickets userLottoTickets) {
        assertThatThrownBy(() -> new ResultLotto().calculateResult(userLottoTickets))
                .isInstanceOf(NullPointerException.class)
                .hasMessage("가진 티켓이 없습니다.");
    }
}