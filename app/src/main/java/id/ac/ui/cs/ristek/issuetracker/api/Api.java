package id.ac.ui.cs.ristek.issuetracker.api;

import android.os.Build;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import id.ac.ui.cs.ristek.issuetracker.preferences.UserPref;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by faqrulan on 10/7/17.
 */

public class Api {
    private static Retrofit defaultRetrofit;
    private static OkHttpClient defaultClient;
    private static final String BASE_URL = "http://pti-issue-dev.herokuapp.com/api/v1/";

    private static Retrofit getRetrofit(){
        if(defaultRetrofit == null){
            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();

            defaultRetrofit = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .client(getClient())
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return defaultRetrofit;
    }

    private static OkHttpClient getClient(){
        if(defaultClient == null){
            defaultClient = new OkHttpClient()
                    .newBuilder()
                    .addInterceptor(new Interceptor() {
                        @Override
                        public Response intercept(Chain chain) throws IOException {
                            Request original = chain.request();
                            Request request;
                            request = original.newBuilder()
                                    .header("User-Agent", "Android: " + Build.MANUFACTURER + " " + Build.MODEL)
                                    .header("Authorization", UserPref.instance().npm)
                                    .method(original.method(), original.body())
                                    .build();
                            return chain.proceed(request);
                        }
                    })
                    .build();
        }
        return defaultClient;
    }

    public static <T> T service(Class<T> service){
        return getRetrofit().create(service);
    }

}
