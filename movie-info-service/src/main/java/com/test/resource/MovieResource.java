package com.test.resource;

import com.test.model.MovieInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/movies")
public class MovieResource {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${api.key}")
    private String apiKey;

    @RequestMapping("/{movieId}")
    public MovieInfo getMovieInfo(@PathVariable("movieId") String movieId) {
        System.out.println("MOVIE INFORMATION1111:" );
        MovieInfo movieInfo = restTemplate.getForObject("https://api.themoviedb.org/3/movie/550?api_key=" + apiKey, MovieInfo.class);
        System.out.println("MOVIE INFORMATION:" + movieInfo);
        return movieInfo;
    }
}
