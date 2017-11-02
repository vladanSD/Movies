package com.vladan.mymovies.ui;

import android.content.Context;

import com.vladan.mymovies.BuildConfig;
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

    public void updateList(List<Movie> list){
        listOfMovies = list;
        notifyDataSetChanged();
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
        holder.bind(movie.getPosterPath(), movie.getTitle(), movie.getOverview(), String.valueOf(movie.getVoteAverage()), movie.getGenreIds());



    }

    @Override
    public int getItemCount() {
        return listOfMovies.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView movieImg;
        TextView movieName;
        TextView movieOverview;
        TextView movieRating;
        TextView movieGenres;
        View mView;


        private ViewHolder(View itemView)  {
            super(itemView);
            mView = itemView;
            movieImg = itemView.findViewById(R.id.iv_recycler_item);
            movieName = itemView.findViewById(R.id.tv_recycler_item_name);
            movieOverview = itemView.findViewById(R.id.tv_recycler_item_overview);
            movieGenres = itemView.findViewById(R.id.tv_recycler_item_genres);
            movieRating = itemView.findViewById(R.id.tv_recycler_item_rating);
            itemView.setOnClickListener(this);
        }

        void bind(String img, String name, String overview, String rating, List<Integer> list){
            Picasso.with(context).load(BuildConfig.IMAGES_BASE_URL+img).into(movieImg);
            movieName.setText(name);
            movieOverview.setText(overview);
            movieRating.setText(rating);


            String genres = "";
            for(int i=0; i<list.size(); i++){

                int numb = list.get(i);
                String genreName = "";
                switch (numb){
                    case 28: genreName = "Action";
                    break;
                    case 12: genreName = "Adventure";
                        break;
                    case 16: genreName = "Animation";
                        break;
                    case 35: genreName = "Comedy";
                        break;
                    case 80: genreName = "Crime";
                        break;
                    case 99: genreName = "Documentary";
                        break;
                    case 18: genreName = "Drama";
                        break;
                    case 10751: genreName = "Family";
                        break;
                    case 14: genreName = "Fantasy";
                        break;
                    case 36: genreName = "History";
                        break;
                    case 27: genreName = "Horror";
                        break;
                    case 10402: genreName = "Music";
                        break;
                    case 9648: genreName = "Mystery";
                        break;
                    case 10749: genreName = "Romance";
                        break;
                    case 878: genreName = "Science Fiction";
                        break;
                    case 10770: genreName = "TV Movie";
                        break;
                    case 53: genreName = "Thriller";
                        break;
                    case 10752: genreName = "War";
                        break;
                    case 37: genreName = "Western";
                        break;

                }

                if(i==0){
                    genres += genreName;
                } else {
                    genres += ", "+genreName;
                }

            }
            movieGenres.setText(genres);
        }


        @Override
        public void onClick(View view) {
            int index = getAdapterPosition();
            mListener.onItemClicked(index);
        }
    }


}
