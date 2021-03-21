package kr.co.sungbin.eatgo.interfaces;

import kr.co.sungbin.eatgo.application.ReviewService;
import kr.co.sungbin.eatgo.domain.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/reviews")
    public List<Review> list() {

        List<Review> reviews = reviewService.getReviews();

        return reviews;
    }
}
