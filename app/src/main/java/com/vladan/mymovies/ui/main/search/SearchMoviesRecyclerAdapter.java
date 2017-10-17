package com.vladan.mymovies.ui.main.search;

import android.content.Context;
import com.vladan.mymovies.data.model.Movie;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.vladan.mymovies.R;

import java.util.List;

/**
 * Created by Vladan on 10/16/2017.
 */

public class SearchMoviesRecyclerAdapter extends RecyclerView.Adapter<SearchMoviesRecyclerAdapter.ViewHolder> {

    private List<Movie> listOfMovies;
    private Context context;

    public SearchMoviesRecyclerAdapter(List<Movie> listOfMovies, Context context) {
        this.listOfMovies = listOfMovies;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movies_adapter_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Movie movie = listOfMovies.get(position);

        //binding data
        holder.bind(movie.getPosterPath(), movie.getTitle(), movie.getGenres());
    }

    @Override
    public int getItemCount() {
        return listOfMovies.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView movieImg;
        TextView movieName;
        TextView movieGenre;


        private ViewHolder(View itemView) {
            super(itemView);

            movieImg = itemView.findViewById(R.id.iv_recycler_item);
            movieName = itemView.findViewById(R.id.tv_recycler_item_name);
            movieGenre = itemView.findViewById(R.id.tv_recycler_item_genre);
        }

        void bind(String img, String name, int genre){
            Picasso.with(context).load(img).into(movieImg);
            movieName.setText(name);
            movieGenre.setText(genre);
        }
    }
}
