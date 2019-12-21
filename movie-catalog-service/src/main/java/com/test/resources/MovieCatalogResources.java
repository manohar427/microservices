package com.test.resources;

import com.test.model.CatalogItem;
import com.test.model.MovieInfo;
import com.test.model.UserRating;
import com.test.service.MovieInfoService;
import com.test.service.UserRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/catalog")
public class MovieCatalogResources {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WebClient.Builder weBuilder;
    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    MovieInfoService movieInfoService;

    @Autowired
    UserRatingService userRatingService;

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCataLogItems(@PathVariable("userId") String userId) {
        //List<Rating> ratings = Arrays.asList(new Rating("100", 2), new Rating("101", 3));
        // System.out.println("movie-info-service:::::::::" + discoveryClient.getInstances("movie-info-service").size());

        UserRating userRating = userRatingService.getUserRating(userId);
        //RestTemplate restTemplate = new RestTemplate();
        //  MovieInfo movieInfo = restTemplate.getForObject("http://localhost:8082/movies/104", MovieInfo.class);
        // System.out.println(movieInfo);
        return userRating.getRatings().stream().map(t -> {
            MovieInfo movieInfo = movieInfoService.getMoviInfo(t);
            System.out.println("movieInfo:"+movieInfo);
            return new CatalogItem(movieInfo.getTitle(), movieInfo.getOverview(), t.getRating());
        }).collect(Collectors.toList());
        // return Collections.singletonList(new CatalogItem("S1", "S1 desc", 100));
    }


    //            MovieInfo movieInfo= weBuilder.build().get().uri("http://localhost:8082/movies/" + t.getMovieId()).retrieve()
//                    .bodyToMono(MovieInfo.class)
//                    .block();

//    public List<CatalogItem> getFallBackcataLog(@PathVariable("userId") String userId) {
//        return Arrays.asList(new CatalogItem("No Movie", "", 0));
//    }
}