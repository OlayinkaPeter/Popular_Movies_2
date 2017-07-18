package com.olayinkapeter.popularmovies2.activities;

import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import com.olayinkapeter.popularmovies2.util.Util;

/**
 * Created by Otunba on 3/22/2016.
 */
public class MovieModel implements Parcelable {


    @SerializedName("original_title")
    private String mTitle;

    @SerializedName("id")
    private long mMovieId;

    @SerializedName("release_date")
    private String mReleaseDate;

    @SerializedName("poster_path")
    private String mPosterPath;

    @SerializedName("backdrop_path")
    private String mBackdropPath;

    @SerializedName("vote_average")
    private String mRating;

    @SerializedName("vote_count")
    private int mVoteCount;

    @SerializedName("overview")
    private String mOverview;

    @SerializedName("popularity")
    private String mPopularity;


    final String BASE_IMAGE_URL = "http://image.tmdb.org/t/p/";
    final String POSTER_SIZE = "w185";
    final String BACKDROP_SIZE = "w500";


    String display_yearMonth;

    //constructor
    public MovieModel(Long id, String poster, String overview, String title,
                      String backdrop_path, String popularity, String vote_avg, String release_year){
        this.mMovieId = id;
        this.mPosterPath = poster;
        this.mOverview =overview;
        this.mTitle=title;
        this.mBackdropPath = backdrop_path;
        this.mPopularity= popularity;
        this.mRating = vote_avg;
        this.mReleaseDate = release_year;


    }



    // Constructor to get Movie object from Cursor
    public MovieModel(Cursor cursor) {
        this.mMovieId = cursor.getLong(MyPosterDisplayFragment.COL_MOVIE_ID);
        this.mTitle = cursor.getString(MyPosterDisplayFragment.COL_TITLE);
        this.mPosterPath = cursor.getString(MyPosterDisplayFragment.COL_POSTER);
        this.mBackdropPath = cursor.getString(MyPosterDisplayFragment.COL_BACKDROP);
        this.mOverview = cursor.getString(MyPosterDisplayFragment.COL_OVERVIEW);
        this.mRating = cursor.getString(MyPosterDisplayFragment.COL_RATING);
        this.mReleaseDate = cursor.getString(MyPosterDisplayFragment.COL_DATE);
    }


    //getters methods for all movie properties

    public String getTitle() {
        return mTitle;
    }

    public Long getMovieId() {
        return mMovieId;
    }

    public String getReleaseMonthYear() {

        display_yearMonth = Util.getMonthOfYear(mReleaseDate);

        return display_yearMonth;
    }

    public String getPosterPath() {
        return BASE_IMAGE_URL + POSTER_SIZE + mPosterPath;
    }

    public String getBackdropPath(){
        return BASE_IMAGE_URL + BACKDROP_SIZE + mBackdropPath;
    }

    public String getRating() {
        return mRating;
    }

    public int getVoteCount() {
        return mVoteCount;
    }

    public String getOverview() {
        return mOverview;
    }

    public String getPopularity() {
        return mPopularity;
    }


    protected MovieModel(Parcel in) {

        mMovieId = in.readLong();
        mTitle = in.readString();
        mPosterPath = in.readString();
        mBackdropPath = in.readString();
        mReleaseDate = in.readString();
        mRating = in.readString();
        mVoteCount = in.readInt();
        mOverview = in.readString();
        mPopularity = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeLong(mMovieId);
        dest.writeString(mTitle);
        dest.writeString(mPosterPath);
        dest.writeString(mBackdropPath);
        dest.writeString(mReleaseDate);
        dest.writeString(mRating);
        dest.writeInt(mVoteCount);
        dest.writeString(mOverview);
        dest.writeString(mPopularity);
    }

    public static final Parcelable.Creator<MovieModel> CREATOR  = new Parcelable.Creator<MovieModel>()
    {

        @Override
        public MovieModel createFromParcel(Parcel parcel) {
            return new MovieModel(parcel);
        }

        @Override
        public MovieModel[] newArray(int i) {
            return new MovieModel[i];
        }
    };


}
