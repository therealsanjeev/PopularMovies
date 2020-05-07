package com.therealsanjeev.popularmovies.Netwoking;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.therealsanjeev.popularmovies.R;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static MovieService movieService;
    public static MovieService getRetrofitClient(Context context){
        if (movieService == null){

            Gson gson = new GsonBuilder().create();
            Retrofit retrofit =new Retrofit.Builder()
                    .baseUrl(context.getString(R.string.BASE_URL))
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();

            movieService =retrofit.create(MovieService.class);
        }

        return movieService;
    }
}
