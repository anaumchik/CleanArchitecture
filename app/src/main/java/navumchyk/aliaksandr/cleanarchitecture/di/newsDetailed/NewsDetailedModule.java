package navumchyk.aliaksandr.cleanarchitecture.di.newsDetailed;

import dagger.Module;
import dagger.Provides;
import navumchyk.aliaksandr.cleanarchitecture.helpers.ImageHelper;
import navumchyk.aliaksandr.cleanarchitecture.interactors.newsDetailed.INewsDetailedFragmentInteractor;
import navumchyk.aliaksandr.cleanarchitecture.interactors.newsDetailed.NewsDetailedFragmentInteractor;
import navumchyk.aliaksandr.cleanarchitecture.repositories.newsDetailed.INewsDetailedFragmentRepository;
import navumchyk.aliaksandr.cleanarchitecture.repositories.newsDetailed.NewsDetailedFragmentRepository;
import navumchyk.aliaksandr.cleanarchitecture.ui.fragments.news.presenter.INewsDetailedFragmentPresenter;
import navumchyk.aliaksandr.cleanarchitecture.ui.fragments.news.presenter.NewsDetailedFragmentPresenter;

/**
 * @author Aliaksandr Navumchyk
 */
@Module
public class NewsDetailedModule {

    @Provides
    @NewsDetailedScope
    INewsDetailedFragmentRepository provideINewsDetailedFragmentRepository() {
        return new NewsDetailedFragmentRepository();
    }

    @Provides
    @NewsDetailedScope
    INewsDetailedFragmentInteractor provideINewsDetailedFragmentInteractor(INewsDetailedFragmentRepository repository) {
        return new NewsDetailedFragmentInteractor(repository);
    }

    @Provides
    @NewsDetailedScope
    INewsDetailedFragmentPresenter provideINewsDetailedPresenter(INewsDetailedFragmentInteractor interactor,
                                                                 ImageHelper imageHelper) {
        return new NewsDetailedFragmentPresenter(interactor, imageHelper);
    }

}
