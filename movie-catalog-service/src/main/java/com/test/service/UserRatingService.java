package com.test.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.test.model.Rating;
import com.test.model.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class UserRatingService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getFallBackcUserRating")
    public UserRating getUserRating(@PathVariable("userId") String userId) {
        UserRating userRating = restTemplate.getForObject("http://rating-data-service/ratingsdata/users/" + userId, UserRating.class);
        System.out.println("getUserRating:" + userRating);
        return userRating;
    }
    /* commandProperties = {
                       @HystrixProperty(name = "hystrix.command.default.execution.isolation.thread.timeoutInMilliseconds", value = "2000"),
                       @HystrixProperty(name = "hystrix.command.default.circuitBreaker.requestVolumeThreshold", value = "6"),
                       @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
                       @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000")
               }*/
    public UserRating getFallBackcUserRating(@PathVariable("userId") String userId) {
        UserRating userRating = new UserRating();
        userRating.setRatings(Arrays.asList(new Rating("No Movie Found", 0)));
        return userRating;
    }
}
