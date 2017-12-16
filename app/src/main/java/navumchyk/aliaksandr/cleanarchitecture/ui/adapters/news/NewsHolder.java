package navumchyk.aliaksandr.cleanarchitecture.ui.adapters.news;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import navumchyk.aliaksandr.cleanarchitecture.R;
import navumchyk.aliaksandr.cleanarchitecture.App;
import navumchyk.aliaksandr.cleanarchitecture.helpers.ImageHelper;
import navumchyk.aliaksandr.cleanarchitecture.ui.adapters.common.BaseHolder;
import navumchyk.aliaksandr.cleanarchitecture.ui.fragments.news.models.NewsModel;
import rx.Subscription;
import rx.subjects.PublishSubject;

/**
 * @author Aliaksandr Navumchyk
 */
public class NewsHolder extends BaseHolder<String> {

    private static final int NEWS_IMG_WIDTH = 64;
    private static final int NEWS_IMG_HEIGHT = 64;

    @Inject ImageHelper mImageHelper;
    @BindView(R.id.item_news_title_tv) TextView mNewsTitleTv;
    @BindView(R.id.item_news_body_tv) TextView mNewsBodyTv;
    @BindView(R.id.item_news_img) ImageView mNewsImg;

    private NewsModel mNewsModel;
    private Context mContext;

    public NewsHolder(View v, PublishSubject<String> click) {
        super(v, click);
        App.getApplication().getAppComponent().inject(this);
    }

    @Override
    public void unbindView() {
        super.unbindView();
        mImageHelper.clearMemory(mContext);
    }

    @OnClick(R.id.item_news_root)
    void onClickItem() {
        mClick.onNext(mNewsModel.getLink());
    }

    public void init(NewsModel newsModel) {
        mNewsModel = newsModel;
        mContext = mNewsTitleTv.getContext();

        mNewsTitleTv.setText(mNewsModel.getTitle());
        mNewsBodyTv.setText(mNewsModel.getBody());

        final Subscription subscription = mImageHelper.loadImageRx(mContext,
                                                                   mNewsModel.getImg(),
                                                                   mNewsImg,
                                                                   NEWS_IMG_WIDTH,
                                                                   NEWS_IMG_HEIGHT);

        mCompositeSubscription.add(subscription);
    }
}