package navumchyk.aliaksandr.cleanarchitecture.ui.fragments.news.presenter;

import android.support.annotation.NonNull;

import java.util.ArrayList;

import navumchyk.aliaksandr.cleanarchitecture.interactors.news.INewsFragmentInteractor;
import navumchyk.aliaksandr.cleanarchitecture.ui.fragments.news.models.NewsModel;
import navumchyk.aliaksandr.cleanarchitecture.ui.fragments.common.BasePresenter;
import navumchyk.aliaksandr.cleanarchitecture.ui.fragments.news.views.INewsFragmentView;
import navumchyk.aliaksandr.cleanarchitecture.utils.RxIoTransformer;
import rx.Subscription;
import rx.subjects.PublishSubject;

/**
 * @author Aliaksandr Navumchyk
 */
public class NewsFragmentPresenter extends BasePresenter<INewsFragmentView>
        implements INewsFragmentPresenter {

    private INewsFragmentInteractor mNewsFragmentInteractor;
    private INewsFragmentView mNewsFragmentView;

    public NewsFragmentPresenter(INewsFragmentInteractor newsInteractor) {
        this.mNewsFragmentInteractor = newsInteractor;
    }

    @Override
    public void bindView(INewsFragmentView newsFragmentView) {
        this.mNewsFragmentView = newsFragmentView;
    }

    @Override
    public void unbindView() {
        super.unbindView();
        mNewsFragmentView = null;
    }

    @Override
    public void initStartViewActions() {
        mNewsFragmentView.setAppBarTitle();
        mNewsFragmentView.initNewsAdapter();
    }

    @Override
    public void loadNews() {
        log("loadNews");
        mNewsFragmentView.showProgressDialog();
        mNewsFragmentView.hideContentContainer();
        mNewsFragmentView.hideNoContentContainer();

        final Subscription loadNewsSubscription = mNewsFragmentInteractor
                .getNews()
                .compose(new RxIoTransformer<>())
                .subscribe(this::handleSuccessLoadNews, this::handleErrorLoadNews);
        mCompositeSubscription.add(loadNewsSubscription);
    }

    private void handleSuccessLoadNews(@NonNull ArrayList<NewsModel> newsModelArrayList) {
        // view actions
        setNewsToView(newsModelArrayList);
        // hide progress
        mNewsFragmentView.hideProgressDialog();
        mNewsFragmentView.showContentContainer();
    }

    private void setNewsToView(ArrayList<NewsModel> newsModel) {
        for (int i = 0; i < newsModel.size(); i++) {
            log(newsModel.get(i).toString());
        }

        mNewsFragmentView.setNewsAdapterData(newsModel);
    }

    private void handleErrorLoadNews(Throwable throwable) {
        logError(throwable.getMessage());
        mNewsFragmentView.hideProgressDialog();
        mNewsFragmentView.showNoContentContainer();
    }

    @Override
    public void observeNewsAdapterItemClick(PublishSubject<String> stringPublishSubject) {

    }
}
