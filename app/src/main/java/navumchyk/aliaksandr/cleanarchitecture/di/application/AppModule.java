package navumchyk.aliaksandr.cleanarchitecture.di.application;

import android.content.Context;
import android.support.annotation.NonNull;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import navumchyk.aliaksandr.cleanarchitecture.helpers.ImageHelper;

/**
 * @author Aliaksandr Navumchyk
 */
@Module
public class AppModule {

    private final Context appContext;

    public AppModule(@NonNull Context context) {
        appContext = context;
    }

    @Provides
    @Singleton
    Context provideContext() {
        return appContext;
    }

    @Provides
    ImageHelper provideImageManager() {
        return new ImageHelper();
    }
}
