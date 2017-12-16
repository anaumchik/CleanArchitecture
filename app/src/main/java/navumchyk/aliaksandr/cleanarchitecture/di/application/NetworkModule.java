package navumchyk.aliaksandr.cleanarchitecture.di.application;

import android.content.Context;
import android.support.annotation.NonNull;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import navumchyk.aliaksandr.cleanarchitecture.network.Api;
import navumchyk.aliaksandr.cleanarchitecture.network.CustomOkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

/**
 * @author Aliaksandr Navumchyk
 */
@Module
public class NetworkModule {

    private static final String BASE_URL = "https://lenta.ru/";
    private Api mApi;
    private final Context appContext;

    public NetworkModule(@NonNull Context context) {
        appContext = context;
    }

    @Provides
    @Singleton
    Context provideContext() {
        return appContext;
    }

    @Provides
    CustomOkHttpClient provideOkHttpClient() {
        return new CustomOkHttpClient();
    }

    @Provides
    Api provideApiClient() {
        if (mApi == null) {
            return mApi = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(SimpleXmlConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .client(provideOkHttpClient().getOkHttpClient(appContext))
                    .build()
                    .create(Api.class);
        }
        return mApi;
    }
}
