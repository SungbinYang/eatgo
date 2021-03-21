package kr.co.sungbin.eatgo.application;

import kr.co.sungbin.eatgo.domain.Reservation;
import kr.co.sungbin.eatgo.domain.ReservationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
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
    void getReservations() {

        Long restaurantId = 1004L;
        List<Reservation> reservations = reservationService.getReservations(restaurantId);

        verify(reservationRepository).findAllByRestaurantId(restaurantId);
    }
}