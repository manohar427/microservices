package com.test.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.test.model.MovieInfo;
import com.test.model.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MovieInfoService {

    @Autowired
    RestTemplate restTemplate;


    @HystrixCommand(fallbackMethod = "getFallBackMoviInfo")
    public MovieInfo getMoviInfo(Rating t) {
        return restTemplate.getForObject("http://movie-info-service/movies/" + t.getMovieId(), MovieInfo.class);
    }

    public MovieInfo getFallBackMoviInfo(Rating t) {
        return new MovieInfo("No Movi Found", "", "");
    }
}
