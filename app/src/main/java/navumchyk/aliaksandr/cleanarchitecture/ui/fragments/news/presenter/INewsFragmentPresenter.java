package navumchyk.aliaksandr.cleanarchitecture.ui.fragments.news.presenter;

import navumchyk.aliaksandr.cleanarchitecture.ui.fragments.common.IBasePresenter;
import navumchyk.aliaksandr.cleanarchitecture.ui.fragments.news.models.NewsModel;
import navumchyk.aliaksandr.cleanarchitecture.ui.fragments.news.views.INewsFragmentView;
import rx.subjects.PublishSubject;

/**
 * @author Aliaksandr Navumchyk
 */
public interface INewsFragmentPresenter extends IBasePresenter<INewsFragmentView> {

    void observeNewsAdapterItemClick(PublishSubject<NewsModel> subject);

    void loadNews();
}
