package kr.co.sungbin.eatgo.application;

import kr.co.sungbin.eatgo.domain.Review;
import kr.co.sungbin.eatgo.domain.ReviewRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@SpringBootTest
class ReviewServiceTests {

    private ReviewService reviewService;

    @Mock
    private ReviewRepository reviewRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        reviewService = new ReviewService(reviewRepository);
    }

    @Test
    void addReview() {

        reviewService.addReview(1004L, "JOKER", 3, "delicious");

        verify(reviewRepository).save(any());
    }

}