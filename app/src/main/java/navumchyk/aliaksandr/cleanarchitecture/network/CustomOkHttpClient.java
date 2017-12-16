package navumchyk.aliaksandr.cleanarchitecture.network;

import android.content.Context;

import java.io.File;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import navumchyk.aliaksandr.cleanarchitecture.BuildConfig;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * @author Aliaksandr Navumchyk
 */
@Singleton
public class CustomOkHttpClient extends OkHttpClient {

    private static final int CACHE_SIZE = 10 * 1024 * 1024; // 10 Mb
    private static final int CONNECT_TIMEOUT = 60; // 60 seconds
    private static final int READ_WRITE_TIMEOUT = 120; // 120 seconds

    public OkHttpClient getOkHttpClient(Context context ) {
        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder()
                .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(READ_WRITE_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(READ_WRITE_TIMEOUT, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .cache(setCacheSettings(context));

        if (BuildConfig.DEBUG) okHttpClientBuilder.addInterceptor(setLogging());

        return okHttpClientBuilder.build();
    }

    private Cache setCacheSettings(Context context) {
        File cacheDir = new File(context.getCacheDir(), "HttpCache");
        return new Cache(cacheDir, CACHE_SIZE);
    }

    private Interceptor setLogging() {
        return new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
    }
}
