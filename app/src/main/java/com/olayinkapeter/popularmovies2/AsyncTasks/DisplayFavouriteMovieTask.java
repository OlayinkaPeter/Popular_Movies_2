package com.olayinkapeter.popularmovies2.AsyncTasks;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.os.AsyncTask;
import android.widget.Toast;

import com.olayinkapeter.popularmovies2.activities.MovieModel;
import com.olayinkapeter.popularmovies2.R;

import java.util.ArrayList;

import com.olayinkapeter.popularmovies2.adapter.gridItemAdapter;
import com.olayinkapeter.popularmovies2.data.MovieContract;

/**
 * Created by Otunba on 7/19/2016.
 */
public class DisplayFavouriteMovieTask extends AsyncTask<Void ,Void,ArrayList<MovieModel>> {

    private Context mContext;
    private Activity mActivity;

    private ArrayList<MovieModel> mMovieList = new ArrayList<MovieModel>();
    private gridItemAdapter movieAdapter;
    private  String[] Movie_COLUMNS;

    public DisplayFavouriteMovieTask(Context context, Activity activity, String[] Movie_COLUMNS, gridItemAdapter movieAdapter ) {
        this.mContext = context;
        this.mActivity = activity;
        this.Movie_COLUMNS = Movie_COLUMNS;

        this.movieAdapter = movieAdapter;

    }

    @Override
    protected ArrayList<MovieModel> doInBackground(Void... params) {



        Cursor cursor = mContext.getContentResolver().query(MovieContract.MovieEntry.CONTENT_URI, Movie_COLUMNS, null,null,null);



        if(cursor != null) {
            while (cursor.moveToNext()) {
                MovieModel movie = new MovieModel(cursor);
                mMovieList.add(movie);
            }
        }
        cursor.close();

        return mMovieList;

    }


    @Override
    protected void onPostExecute(ArrayList<MovieModel> movieList) {
        super.onPostExecute(movieList);

        if(movieList !=null) {

            movieAdapter.clear();

            MovieModel curMovie;
            for (int i = 0; i < movieList.size(); i++) {
                curMovie = movieList.get(i);
                movieAdapter.add(curMovie);
            }

        }
        else{
            // Let the user know that some problem has occurred via a toast
            Toast.makeText(mContext,mContext.getString(R.string.no_movie_data_error) , Toast.LENGTH_SHORT).show();
        }


    }

}
