package kr.co.sungbin.eatgo.domain;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

class RestaurantTests {

    @Test
    public void creation() {

        Restaurant restaurant = Restaurant.builder()
                .id(1004L)
                .name("Bob zip")
                .address("Seoul")
                .build();

        assertThat(restaurant.getId()).isEqualTo(1004);
        assertThat(restaurant.getName()).isEqualTo("Bob zip");
        assertThat(restaurant.getAddress()).isEqualTo("Seoul");
    }

    @Test
    public void information() {
        Restaurant restaurant = Restaurant.builder()
                .id(1004L)
                .name("Bob zip")
                .address("Seoul")
                .build();

        assertThat(restaurant.getInformation()).isEqualTo("Bob zip in Seoul");
    }
}