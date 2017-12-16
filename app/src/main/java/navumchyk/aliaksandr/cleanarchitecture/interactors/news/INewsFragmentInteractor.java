package navumchyk.aliaksandr.cleanarchitecture.interactors.news;

import java.util.ArrayList;

import navumchyk.aliaksandr.cleanarchitecture.ui.fragments.news.models.NewsModel;
import rx.Single;

/**
 * @author Aliaksandr Navumchyk
 */
public interface INewsFragmentInteractor {

    Single<ArrayList<NewsModel>> getNews();
}
