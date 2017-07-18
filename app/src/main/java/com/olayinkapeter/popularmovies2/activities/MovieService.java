package com.olayinkapeter.popularmovies2.activities;

import com.olayinkapeter.popularmovies2.BuildConfig;

import com.olayinkapeter.popularmovies2.moviemodel.AllMovies;
import com.olayinkapeter.popularmovies2.moviemodel.AllReviews;
import com.olayinkapeter.popularmovies2.moviemodel.AllTrailers;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Otunba on 7/16/2016.
 */
public class MovieService {
    //An Interface of TheMovieDatabase
    public interface TheMovieDBApi {
        // To get all the movies and store them as MovieModel objects

        @GET("movie/{sort}?api_key=" + BuildConfig.TMDB_API_KEY)
        Call<AllMovies> getMovies(
                @Path("sort") String sortCriteria
        );


        // To get the trailers and store them as MovieTrailer objects

        @GET("movie/{id}/videos?api_key=" + BuildConfig.TMDB_API_KEY)
        Call<AllTrailers> getTrailers(
                @Path("id") long movieID
        );

        // To get the reviews and store them as MovieReview objects

        @GET("movie/{id}/reviews?api_key=" + BuildConfig.TMDB_API_KEY)
        Call<AllReviews> getReviews(
                @Path("id") long movieID
        );

    }
}