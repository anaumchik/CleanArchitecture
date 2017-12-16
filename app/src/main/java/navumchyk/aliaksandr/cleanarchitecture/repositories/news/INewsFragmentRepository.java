package navumchyk.aliaksandr.cleanarchitecture.repositories.news;

import java.util.ArrayList;

import navumchyk.aliaksandr.cleanarchitecture.ui.fragments.news.models.NewsModel;
import rx.Single;

/**
 * @author Aliaksandr Navumchyk
 */
public interface INewsFragmentRepository {

    Single<ArrayList<NewsModel>> getNews();

}


