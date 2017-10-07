package id.ac.ui.cs.ristek.issuetracker;

import okhttp3.OkHttpClient;

/**
 * Created by Sang Agung Raditya P on 10/7/2017.
 */

public class Retrofit {
    String baseUrl = "https://bem.cs.ui.ac.id/issue/api/v1/";

    public <T> T getService(Class<T> serviceClass) {
        return getRetrofit().create(serviceClass);
    }

    public synchronized retrofit2.Retrofit getRetrofit() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        OkHttpClient client = httpClient.build();
        return new retrofit2.Retrofit
                .Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
    }
}
