package navumchyk.aliaksandr.cleanarchitecture.di.application;

import android.content.Context;
import android.support.annotation.NonNull;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

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
}
