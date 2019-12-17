package com.test.resources;

import com.test.model.CatalogItem;
import com.test.model.MovieInfo;
import com.test.model.Rating;
import com.test.model.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/catalog")
public class MovieCatalogResources {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WebClient.Builder weBuilder;

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCataLogItems(@PathVariable("userId") String userId) {
        //List<Rating> ratings = Arrays.asList(new Rating("100", 2), new Rating("101", 3));
        UserRating userRating = restTemplate.getForObject("http://localhost:8083/ratingsdata/users/" + userId, UserRating.class);
        System.out.println(userRating);
        //RestTemplate restTemplate = new RestTemplate();
        //  MovieInfo movieInfo = restTemplate.getForObject("http://localhost:8082/movies/104", MovieInfo.class);
        // System.out.println(movieInfo);
        return userRating.getRatings().stream().map(t -> {
            MovieInfo movieInfo = restTemplate.getForObject("http://localhost:8082/movies/" + t.getMovieId(), MovieInfo.class);
//            MovieInfo movieInfo= weBuilder.build().get().uri("http://localhost:8082/movies/" + t.getMovieId()).retrieve()
//                    .bodyToMono(MovieInfo.class)
//                    .block();

            System.out.println(movieInfo);
            return new CatalogItem(movieInfo.getName(), "descr", t.getRating());
        }).collect(Collectors.toList());
        // return Collections.singletonList(new CatalogItem("S1", "S1 desc", 100));
    }
}
