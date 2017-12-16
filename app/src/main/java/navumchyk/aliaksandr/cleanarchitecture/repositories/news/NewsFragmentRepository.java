package navumchyk.aliaksandr.cleanarchitecture.repositories.news;

import java.util.ArrayList;

import navumchyk.aliaksandr.cleanarchitecture.network.usecase.GetNewsUseCase;
import navumchyk.aliaksandr.cleanarchitecture.repositories.common.BaseRepository;
import navumchyk.aliaksandr.cleanarchitecture.ui.fragments.news.models.NewsModel;
import rx.Single;

/**
 * @author Aliaksandr Navumchyk
 */
public class NewsFragmentRepository extends BaseRepository implements INewsFragmentRepository {

    private final GetNewsUseCase mGetNewsUseCase;

    public NewsFragmentRepository(GetNewsUseCase getNewsUseCase) {
        mGetNewsUseCase = getNewsUseCase;
    }

    @Override
    public Single<ArrayList<NewsModel>> getNews() {
        log("getNews");
        return mGetNewsUseCase.execute(null);
    }
}
