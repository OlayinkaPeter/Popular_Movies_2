package com.olayinkapeter.popularmovies2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.olayinkapeter.popularmovies2.activities.MovieModel;
import com.olayinkapeter.popularmovies2.R;

import java.util.List;

/**
 * Created by Otunba on 3/22/2016.
 * This calss will be a middle man between GridView
 * for Displaying the movies and the raw movie data
 */
//This Class extends ArrayAdapter of type MovieModel class
public class gridItemAdapter extends ArrayAdapter<MovieModel> {
    private Context mContext;
    private List<MovieModel> mMovieList;

    public gridItemAdapter(Context context, List<MovieModel> moviesList) {
        super(context, 0, moviesList);
        this.mContext = context;
        this.mMovieList = moviesList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MovieModel movieModel = getItem(position);

        ViewHolder viewHolder;

        String posterUrl = movieModel.getPosterPath();
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.poster_item, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.posterView  =(ImageView) convertView.findViewById(R.id.moviePoster_image);
            viewHolder.movieNameTextView = (TextView) convertView.findViewById(R.id.tvMoviePosterName);
            convertView.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.posterView.setAdjustViewBounds(true);
        viewHolder.posterView.setPadding(0,0,0,0);

        Picasso.with(mContext)
                .load(posterUrl).fit()
                .placeholder(R.drawable.ic_poster_placeholder) // support download placeholder
                .error(R.drawable.ic_poster_placeholder_error) //support error placeholder, if back-end returns empty string or null
                .into(viewHolder.posterView);
        viewHolder.movieNameTextView.setText(movieModel.getTitle());


        return convertView;
    }
    static class ViewHolder{
        ImageView posterView;
        TextView movieNameTextView;

    }
    }

