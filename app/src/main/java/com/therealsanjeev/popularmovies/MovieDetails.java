package com.therealsanjeev.popularmovies;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.therealsanjeev.popularmovies.model.Movie;

public class MovieDetails extends AppCompatActivity {
    private ImageView moviePoster;
    private TextView movieTitle;
    private TextView userRating;
    private TextView releaseDate;
    private TextView movieSynopsis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_details);

        moviePoster = findViewById(R.id.movie_thumbnail);
        movieTitle = findViewById(R.id.movie_title);
        userRating = findViewById(R.id.user_rating);
        releaseDate = findViewById(R.id.release_date);
        movieSynopsis = findViewById(R.id.movie_synopsis);

        Bundle bundle = getIntent().getExtras();
        Movie movie = (Movie) bundle.getSerializable("movieData");
        getMovieData(movie);



    }



    private void getMovieData(Movie movie) {
        Glide.with(this)
                .load(imagePath(movie.getPosterPath()))
                .into(moviePoster);

        movieTitle.setText(movie.getTitle());
        userRating.setText(String.format("%s/10", movie.getVoteAverage()));
        releaseDate.setText(movie.getReleaseDate());
        movieSynopsis.setText(movie.getOverview());
    }

    private static String imagePath(String posterPath) {
        return "https://image.tmdb.org/t/p/" + "w500" + posterPath;
    }
}
