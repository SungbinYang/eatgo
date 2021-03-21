package kr.co.sungbin.eatgo.interfaces;

import kr.co.sungbin.eatgo.application.RestaurantService;
import kr.co.sungbin.eatgo.domain.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/restaurants")
    public List<Restaurant> list(@RequestParam("region") String region,
                                 @RequestParam("category") Long categoryId) {

        return restaurantService.getRestaurants(region, categoryId);
    }

    @GetMapping("/restaurants/{id}")
    public Restaurant detail(@PathVariable("id") Long id) {

        Restaurant restaurant = restaurantService.getRestaurant(id);

        return restaurant;
    }
}
