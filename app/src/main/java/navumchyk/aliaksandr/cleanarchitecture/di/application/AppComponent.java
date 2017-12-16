package navumchyk.aliaksandr.cleanarchitecture.di.application;

import javax.inject.Singleton;

import dagger.Component;
import navumchyk.aliaksandr.cleanarchitecture.App;
import navumchyk.aliaksandr.cleanarchitecture.di.news.NewsComponent;
import navumchyk.aliaksandr.cleanarchitecture.di.news.NewsModule;
import navumchyk.aliaksandr.cleanarchitecture.di.newsdetailed.NewsDetailedComponent;
import navumchyk.aliaksandr.cleanarchitecture.di.newsdetailed.NewsDetailedModule;
import navumchyk.aliaksandr.cleanarchitecture.ui.adapters.news.NewsHolder;

/**
 * @author Aliaksandr Navumchyk
 */
@Component(modules = {AppModule.class, NetworkModule.class})
@Singleton
public interface AppComponent {

    NewsComponent plus(NewsModule module);

    NewsDetailedComponent plus(NewsDetailedModule module);

    void inject(App application);

    void inject(NewsHolder holder);

}
