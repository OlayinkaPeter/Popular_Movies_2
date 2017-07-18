package com.olayinkapeter.popularmovies2.moviemodel;

import com.google.gson.annotations.SerializedName;
import com.olayinkapeter.popularmovies2.activities.MovieModel;

import java.util.ArrayList;

/**
 * Created by Otunba on 7/16/2016.
 */
public class AllMovies {
    @SerializedName("results")
    ArrayList<MovieModel> movieList;

    public ArrayList<MovieModel> getMovieList() {
        return movieList;
    }

}
