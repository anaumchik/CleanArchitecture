package navumchyk.aliaksandr.cleanarchitecture;

import android.app.Application;
import android.content.IntentFilter;
import android.net.ConnectivityManager;

import navumchyk.aliaksandr.cleanarchitecture.di.application.AppComponent;
import navumchyk.aliaksandr.cleanarchitecture.di.application.AppModule;
import navumchyk.aliaksandr.cleanarchitecture.di.application.DaggerAppComponent;
import navumchyk.aliaksandr.cleanarchitecture.di.application.NetworkModule;

/**
 * @author Aliaksandr Navumchyk
 */
public class App extends Application {

    private static App sApp;
    private AppComponent mAppComponent;

    public static App getApplication() {
        return sApp;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sApp = this;
        initAppComponent();
        registerInternetBroadcastReceiver();
    }

    private void registerInternetBroadcastReceiver() {
        final IntentFilter filter = new IntentFilter();
        filter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
    }

    private void initAppComponent() {
        mAppComponent = DaggerAppComponent
                .builder()
                .appModule(new AppModule(this))
                .networkModule(new NetworkModule(this))
                .build();
        mAppComponent.inject(this);
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }
}
