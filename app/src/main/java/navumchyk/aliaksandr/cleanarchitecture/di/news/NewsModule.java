package navumchyk.aliaksandr.cleanarchitecture.di.news;

import dagger.Module;
import dagger.Provides;
import navumchyk.aliaksandr.cleanarchitecture.interactors.news.INewsFragmentInteractor;
import navumchyk.aliaksandr.cleanarchitecture.interactors.news.NewsFragmentInteractor;
import navumchyk.aliaksandr.cleanarchitecture.network.usecase.news.GetNewsUseCase;
import navumchyk.aliaksandr.cleanarchitecture.repositories.news.INewsFragmentRepository;
import navumchyk.aliaksandr.cleanarchitecture.repositories.news.NewsFragmentRepository;
import navumchyk.aliaksandr.cleanarchitecture.ui.fragments.news.presenter.INewsFragmentPresenter;
import navumchyk.aliaksandr.cleanarchitecture.ui.fragments.news.presenter.NewsFragmentPresenter;

/**
 * @author Aliaksandr Navumchyk
 */
@Module
public class NewsModule {

    @Provides
    @NewsScope
    INewsFragmentRepository provideINewsFragmentRepository(GetNewsUseCase getNewsUseCase) {
        return new NewsFragmentRepository(getNewsUseCase);
    }

    @Provides
    @NewsScope
    INewsFragmentInteractor provideINewsFragmentInteractor(INewsFragmentRepository repository) {
        return new NewsFragmentInteractor(repository);
    }

    @Provides
    @NewsScope
    INewsFragmentPresenter provideINewsPresenter(INewsFragmentInteractor interactor) {
        return new NewsFragmentPresenter(interactor);
    }

}
