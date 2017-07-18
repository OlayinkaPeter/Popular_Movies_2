package com.olayinkapeter.popularmovies2.AsyncTasks;

import android.content.Context;
import android.database.Cursor;
import android.os.AsyncTask;
import android.view.View;
import android.widget.Button;

import com.olayinkapeter.popularmovies2.activities.MovieModel;
import com.olayinkapeter.popularmovies2.R;

import com.olayinkapeter.popularmovies2.data.MovieContract;

/**
 * Created by Otunba on 7/19/2016.
 * An AsyncTask to Verify if the selected Movie is in the Favourite DB or not
 * If it is there, it returns 1, if it isn't it returns 0
 */
public class CheckFavourite extends AsyncTask<MovieModel, Integer, Integer> {

    private Context mContext;
    private int isFavoriteMovie;
    private MovieModel mMovie;
    private Button favButton;
    private int numRows;
    private  int  mIsFavorite;
    private View rootView;

    public CheckFavourite(Context context, View rootView) {
        this.mContext = context;
        this.rootView = rootView;
    }


    @Override
    protected Integer doInBackground(MovieModel... params) {

        mMovie = params[0];

         /*
          Check  if Movie is in DB
         */

//        Cursor cursor = mContext.getContentResolver().query(
//                MovieContract.MovieEntry.CONTENT_URI,
//                null,   //projection
//                MovieContract.MovieEntry.COLUMN_MOVIE_ID + " =?",
//                new String[]{String.valueOf(mMovie.getMovieId())},      // selectionArgs : gets the rows with this movieID
//                null             // Sort order
//
//        );

//        if (cursor != null) {
//            numRows = cursor.getCount();
//            cursor.close();
//        }

        if (numRows == 1) {    // Inside db
            isFavoriteMovie = 1;
        } else {             // Not inside db
            isFavoriteMovie = 0;
        }

        return isFavoriteMovie;
    }


    @Override
    protected void onPostExecute(Integer isFav) {
        super.onPostExecute(isFav);



        //Set the icon of Floating action button based on if move in favorites or not


        mIsFavorite = isFav;
        favButton = (Button) rootView.findViewById(R.id.fav_Button);

        if (mIsFavorite == 1) {

            favButton.setBackgroundResource(R.drawable.favorite);
        } else if (mIsFavorite == 0) {

            favButton.setBackgroundResource(R.drawable.fav);
        }


    }

}
