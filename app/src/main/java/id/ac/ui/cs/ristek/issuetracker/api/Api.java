package id.ac.ui.cs.ristek.issuetracker.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by faqrulan on 10/7/17.
 */

public class Api {
    private static Retrofit defaultRetrofit;
    private static final String BASE_URL = "http://pti-issue-dev.herokuapp.com/api/v1/";

    private static Retrofit getRetrofit(){
        if(defaultRetrofit == null){
            Gson gson = new GsonBuilder()
                    .create();

            defaultRetrofit = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .client(new OkHttpClient())
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return defaultRetrofit;
    }

    public static <T> T service(Class<T> service){
        return getRetrofit().create(service);
    }

}
