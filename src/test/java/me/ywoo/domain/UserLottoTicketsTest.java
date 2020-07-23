package me.ywoo.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class UserLottoTicketsTest {
    @DisplayName("UserLottoTickets(int) - 로또 티켓 객체 생성")
    @Test
    void UserLottoTickets_generateInstance() {
        assertThat(new UserLottoTickets(10)).isInstanceOf(UserLottoTickets.class);
    }

    @DisplayName("UserLottoTickets(int) - 받은 돈만큼 로또 티켓 생성")
    @ParameterizedTest
    @ValueSource(ints = {1, 10})
    void UserLottoTickets_generateTickets(final int countOfLotto) {
        int actual = new UserLottoTickets(countOfLotto).lottoNumbers.size();

        assertThat(actual).isEqualTo(countOfLotto);
    }
}