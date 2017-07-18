package com.olayinkapeter.popularmovies2.data;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by Otunba on 7/16/2016.
 */
public class MovieContract {
    public static final String CONTENT_AUTHORITY = "com.udacity.otunba.popularmoviesapp";
    public static final Uri BASE_CONTENT_URL =  Uri.parse("content://" + CONTENT_AUTHORITY);
    public static final String PATH_MOVIE = "movie";
    public static final String DB_NAME = "movie.db";

    //movie entry class to implement Basecolumn class for db helper and content provider
    public static final class MovieEntry implements BaseColumns {
        public static final Uri CONTENT_URI = BASE_CONTENT_URL.buildUpon().appendPath(PATH_MOVIE).build();
        //handle URI containing a cursor of zero or more item
        public static final String CONTENT_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE +"/" +CONTENT_AUTHORITY +"/" +PATH_MOVIE;
        //handle URI containing a cursor of single item
        public static final String CONTENT_ITEM_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE +"/" +CONTENT_AUTHORITY +"/" +PATH_MOVIE;

        //table movie and column names

        public static  final String TABLE_NAME = "movie";

        public static final String COLUMN_MOVIE_ID = "movie_id";
        public static final String COLUMN_TITLE = "title";
        public static final String COLUMN_POSTER = "poster";
        public static final String COLUMN_BACKDROP = "backdrop";
        public static final String COLUMN_OVERVIEW = "overview";
        public static final String COLUMN_RATING  = "rating";
        public static final String COLUMN_DATE = "date";

        public static Uri buildMovieUri(long id){
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }

    }
}
