package dom.test.model.api;

import android.util.Log;

import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by dementr on 29.11.2017.
 */

public class ApiModul {
    /**
     * Creates a retrofit service from an arbitrary class (clazz)
     *
     * @param clazz    Java interface of the retrofit service
     * @param endPoint REST endpoint url
     * @return retrofit service with defined endpoint
     */
    public static <T> T getApiInterface(final Class<T> clazz, final String endPoint) {
        Interceptor interceptor = chain -> {
            Request newRequest = chain.request().newBuilder().addHeader("User-Agent", "Retrofit-Sample-App").build();
            Log.i("Запросы 1", chain.request().toString());
            //Log.i("Запросы 2",chain.proceed(newRequest).toString());
            return chain.proceed(newRequest);
        };
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.interceptors().add(interceptor);
        //таймауты
        builder.connectTimeout(300, TimeUnit.SECONDS);
        builder.writeTimeout(300, TimeUnit.SECONDS);
        builder.readTimeout(300, TimeUnit.SECONDS);

        OkHttpClient client = builder.build();

        final Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(endPoint)
                .client(client)
                .build();
        T service = retrofit.create(clazz);
        return service;
    }
}
