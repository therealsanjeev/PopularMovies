package com.therealsanjeev.popularmovies.Netwoking;

import com.therealsanjeev.popularmovies.model.MovieResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieService {

    //Top Rated Movie
    @GET("movie/top_rated")
    Call<MovieResult> getTopRatedMovies(@Query("page") int page, @Query("api_key") String apiKey);


    //Most popular movies
    @GET("movie/popular")
    Call<MovieResult> getPopularMovies(@Query("page") int page, @Query("api_key") String apiKey);

}
