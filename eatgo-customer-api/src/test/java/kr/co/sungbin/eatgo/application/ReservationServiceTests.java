package kr.co.sungbin.eatgo.application;

import kr.co.sungbin.eatgo.domain.Reservation;
import kr.co.sungbin.eatgo.domain.ReservationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

class ReservationServiceTests {

    private ReservationService reservationService;

    @Mock
    private ReservationRepository reservationRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        reservationService = new ReservationService(reservationRepository);
    }

    @Test
    void addReservation() {

        Long restaurantId = 369L;
        Long userId = 1004L;
        String name = "John";
        String date = "2021-12-24";
        String time = "20:00";
        Integer partySize = 20;

        given(reservationRepository.save(any())).will(invocation -> {
            return invocation.<Reservation>getArgument(0);
        });

        Reservation reservation = reservationService.addReservation(restaurantId, userId, name, date, time, partySize);

        assertThat(reservation.getName()).isEqualTo(name);

        verify(reservationRepository).save(any(Reservation.class));
    }
}