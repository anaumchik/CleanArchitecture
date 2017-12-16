package navumchyk.aliaksandr.cleanarchitecture.interactors.news;

import java.util.ArrayList;

import navumchyk.aliaksandr.cleanarchitecture.interactors.common.BaseInteractor;
import navumchyk.aliaksandr.cleanarchitecture.repositories.news.INewsFragmentRepository;
import navumchyk.aliaksandr.cleanarchitecture.ui.fragments.news.models.NewsModel;
import rx.Single;

/**
 * @author Aliaksandr Navumchyk
 */
public class NewsFragmentInteractor extends BaseInteractor implements INewsFragmentInteractor {

    private INewsFragmentRepository mNewsFragmentRepository;

    public NewsFragmentInteractor(INewsFragmentRepository mNewsFragmentRepository) {
        this.mNewsFragmentRepository = mNewsFragmentRepository;
    }

    @Override
    public Single<ArrayList<NewsModel>> getNews() {
        log("getNews");
        return mNewsFragmentRepository
                .getNews()
                .onErrorReturn(throwable -> {
                    logError(throwable.getMessage());
                    return getMockNewsModelList();
                });
    }

    private ArrayList<NewsModel> getMockNewsModelList() {

        final ArrayList<NewsModel> newsModels = new ArrayList<>();

        newsModels.add(new NewsModel("first departments",
                                     "Russia, Moscow",
                                     "https://pbs.twimg.com/profile_images/378800000710852544/d8832a4e3301975477be73152ca29920_400x400.jpeg",
                                     "open in hours 9-18"));
        newsModels.add(new NewsModel("second departments",
                                     "Russia, Tver",
                                     "https://pbs.twimg.com/profile_images/378800000710852544/d8832a4e3301975477be73152ca29920_400x400.jpeg",
                                     "open in hours 10-18"));
        newsModels.add(new NewsModel("third departments",
                                     "Russia, Krasnodar",
                                     "https://pbs.twimg.com/profile_images/378800000710852544/d8832a4e3301975477be73152ca29920_400x400.jpeg",
                                     "open in hours 8-20"));

        return newsModels;
    }
}
