package navumchyk.aliaksandr.cleanarchitecture.network.usecase;

import java.util.ArrayList;

import javax.inject.Inject;
import javax.inject.Singleton;

import navumchyk.aliaksandr.cleanarchitecture.network.Api;
import navumchyk.aliaksandr.cleanarchitecture.network.usecase.common.BaseUseCase;
import navumchyk.aliaksandr.cleanarchitecture.ui.fragments.news.models.NewsModel;
import navumchyk.aliaksandr.cleanarchitecture.ui.fragments.news.models.NewsModelResponse;
import rx.Single;
import rx.subjects.PublishSubject;

/**
 * @author Aliaksandr Navumchyk
 */
@Singleton
public class GetNewsUseCase extends BaseUseCase<Void, ArrayList<NewsModel>, Void> {

    private final Api mApiClient;

    @Inject
    GetNewsUseCase(Api apiClient) {
        mApiClient = apiClient;
    }

    @Override
    public Single<ArrayList<NewsModel>> buildUseCaseObservable(Void param,
                                                                  PublishSubject retrievedData) {
        log("GetNewsUseCase");
        return mApiClient
                .getNews()
                .map(NewsModelResponse::getNewsModelList);
    }
}