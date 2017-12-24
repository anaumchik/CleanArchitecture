package navumchyk.aliaksandr.cleanarchitecture.ui.fragments.news.presenter;

import android.os.Bundle;
import android.widget.ImageView;

import navumchyk.aliaksandr.cleanarchitecture.helpers.ImageHelper;
import navumchyk.aliaksandr.cleanarchitecture.interactors.newsDetailed.INewsDetailedFragmentInteractor;
import navumchyk.aliaksandr.cleanarchitecture.ui.fragments.common.BasePresenter;
import navumchyk.aliaksandr.cleanarchitecture.ui.fragments.news.models.NewsModel;
import navumchyk.aliaksandr.cleanarchitecture.ui.fragments.news.views.INewsDetailedFragmentView;
import rx.Subscription;

import static navumchyk.aliaksandr.cleanarchitecture.utils.Constants.NEWS_DETAILED_FRAGMENT_NEWS_MODEL_KEY;

/**
 * @author Aliaksandr Navumchyk
 */
public class NewsDetailedFragmentPresenter extends BasePresenter<INewsDetailedFragmentView>
        implements INewsDetailedFragmentPresenter {

    private static final int NEWS_DETAILED_IMG_WIDTH = 100;
    private static final int NEWS_DETAILED_IMG_HEIGHT = 100;

    private final ImageHelper mImageHelper;
    private final INewsDetailedFragmentInteractor mNewsDetailedFragmentInteractor;
    private INewsDetailedFragmentView mNewsDetailedFragmentView;
    private NewsModel mNewsModel;

    public NewsDetailedFragmentPresenter(INewsDetailedFragmentInteractor newsDetailedFragmentInteractor,
                                         ImageHelper imageHelper) {
        mNewsDetailedFragmentInteractor = newsDetailedFragmentInteractor;
        mImageHelper = imageHelper;
    }

    @Override
    public void bindView(INewsDetailedFragmentView newsDetailedFragmentView) {
        this.mNewsDetailedFragmentView = newsDetailedFragmentView;
    }

    @Override
    public void unbindView() {
        super.unbindView();
        mNewsDetailedFragmentView = null;
    }

    @Override
    public void initStartViewActions() {
        mNewsDetailedFragmentView.showAppBarBackArrow();}

    @Override
    public void restoreArguments(Bundle arguments) {
        if (arguments != null) {
            if (arguments.containsKey(NEWS_DETAILED_FRAGMENT_NEWS_MODEL_KEY)) {
                mNewsModel = arguments.getParcelable(NEWS_DETAILED_FRAGMENT_NEWS_MODEL_KEY);
            }
        }
    }

    @Override
    public void setNewsData() {
        mNewsDetailedFragmentView.setTitle(mNewsModel.getTitle());
        mNewsDetailedFragmentView.setAppBarTitle(mNewsModel.getTitle());
        mNewsDetailedFragmentView.setBody(mNewsModel.getBody().trim());
    }

    @Override
    public void loadNewsImg(ImageView newsImg) {
        if (mNewsModel.getEnclosure() != null) {
            final Subscription subscription = mImageHelper.loadImageRx(
                    newsImg.getContext(),
                    mNewsModel.getEnclosure().getUrl(),
                    newsImg,
                    NEWS_DETAILED_IMG_WIDTH,
                    NEWS_DETAILED_IMG_HEIGHT);
            mCompositeSubscription.add(subscription);
        }
    }
}
