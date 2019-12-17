package com.test.resource;

import com.test.model.Rating;
import com.test.model.UserRating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ratingsdata")
public class RatingResource {
    @RequestMapping("/{movieId}")
    public Rating getRating(@PathVariable("movieId") String movieId) {
        return new Rating(movieId, 4);
    }

    @RequestMapping("/users/{userId}")
    public UserRating getRatings(@PathVariable("userId") String userId) {
        UserRating userRating = new UserRating();
        userRating.setRatings(Arrays.asList(new Rating("100", 2), new Rating("101", 3)));
        return userRating;
    }

}
