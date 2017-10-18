package com.vladan.mymovies.ui;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import com.vladan.mymovies.data.model.Movie;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.vladan.mymovies.R;
import com.vladan.mymovies.ui.movie.MovieActivity;

import java.util.List;

/**
 * Created by Vladan on 10/16/2017.
 */

public class MoviesRecyclerAdapter extends RecyclerView.Adapter<MoviesRecyclerAdapter.ViewHolder> {

    private List<Movie> listOfMovies;
    private Context context;
    private OnItemClicked mListener;

    public MoviesRecyclerAdapter(List<Movie> listOfMovies, Context context, OnItemClicked listener) {
        this.listOfMovies = listOfMovies;
        this.context = context;
        this.mListener = listener;
    }

    public interface OnItemClicked{
        void onItemClicked(int position);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movies_adapter_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final Movie movie = listOfMovies.get(position);

        //binding data
        holder.bind(movie.getPosterPath(), movie.getTitle(), movie.getGenres());



    }

    @Override
    public int getItemCount() {
        return listOfMovies.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView movieImg;
        TextView movieName;
        TextView movieGenre;
        View mView;


        private ViewHolder(View itemView)  {
            super(itemView);
            mView = itemView;
            movieImg = itemView.findViewById(R.id.iv_recycler_item);
            movieName = itemView.findViewById(R.id.tv_recycler_item_name);
            movieGenre = itemView.findViewById(R.id.tv_recycler_item_genre);
            itemView.setOnClickListener(this);
        }

        void bind(String img, String name, int genre){
            Picasso.with(context).load(img).into(movieImg);
            movieName.setText(name);
            movieGenre.setText(String.valueOf(genre));
        }


        @Override
        public void onClick(View view) {
            int index = getAdapterPosition();
            mListener.onItemClicked(index);
        }
    }


}
