package id.ac.ui.cs.ristek.issuetracker.api;

import android.os.Build;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

import java.io.IOException;

import id.ac.ui.cs.ristek.issuetracker.preferences.UserData;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by faqrulan on 10/7/17.
 */
@EBean()
public class Api {

    @Bean
    public UserData userData;
    private static Retrofit defaultRetrofit;
    private static OkHttpClient defaultClient;
    private static final String BASE_URL = "http://pti-issue-dev.herokuapp.com/api/v1/";

    private Retrofit getRetrofit(){
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

    private OkHttpClient getClient(){
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
                                    .header("Authorization", "")
                                    .method(original.method(), original.body())
                                    .build();
                            return chain.proceed(request);
                        }
                    })
                    .build();
        }
        return defaultClient;
    }

    public <T> T service(Class<T> service){
        return getRetrofit().create(service);
    }

    public void TesApi(){
        Log.d("haha", userData.getNPM());
    }

}
