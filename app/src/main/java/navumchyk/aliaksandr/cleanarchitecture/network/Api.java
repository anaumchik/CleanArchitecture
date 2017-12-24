package navumchyk.aliaksandr.cleanarchitecture.network;

import navumchyk.aliaksandr.cleanarchitecture.ui.fragments.news.models.NewsModelRSS;
import retrofit2.http.GET;
import rx.Single;

/**
 * @author Aliaksandr Navumchyk
 */
public interface Api {

    @GET("rss")
    Single<NewsModelRSS> getNews();
}
