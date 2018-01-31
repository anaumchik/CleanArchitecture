package navumchyk.aliaksandr.cleanarchitecture.ui.fragments.newsDetailed.views;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import navumchyk.aliaksandr.cleanarchitecture.App;
import navumchyk.aliaksandr.cleanarchitecture.R;
import navumchyk.aliaksandr.cleanarchitecture.di.newsDetailed.NewsDetailedModule;
import navumchyk.aliaksandr.cleanarchitecture.ui.fragments.common.BaseFragment;
import navumchyk.aliaksandr.cleanarchitecture.ui.fragments.news.models.NewsModel;
import navumchyk.aliaksandr.cleanarchitecture.ui.fragments.newsDetailed.presenter.INewsDetailedFragmentPresenter;

import static navumchyk.aliaksandr.cleanarchitecture.utils.Constants.NEWS_DETAILED_FRAGMENT_NEWS_MODEL_KEY;

/**
 * @author Aliaksandr Navumchyk
 */
public class NewsDetailedFragment extends BaseFragment implements INewsDetailedFragmentView {

    @Inject INewsDetailedFragmentPresenter mNewsDetailedFragmentPresenter;
    @BindView(R.id.app_bar_title_tv) TextView mAppBarTitle;
    @BindView(R.id.app_bar_back_arrow_img) ImageView mAppBarBackArrow;
    @BindView(R.id.news_detailed_content_container) View mContentContainer;
    @BindView(R.id.news_detailed_progress_dialog) ProgressBar mProgressDialog;
    @BindView(R.id.news_detailed_no_content_tv) TextView mNoContentContainer;
    @BindView(R.id.news_detailed_img) ImageView mNewsImg;
    @BindView(R.id.news_detailed_title_tv) TextView mNewsTitleTv;
    @BindView(R.id.news_detailed_body_tv) TextView mNewsBodyTv;

    public static NewsDetailedFragment newInstance(NewsModel newsModel) {
        final NewsDetailedFragment fragment = new NewsDetailedFragment();
        final Bundle args = new Bundle();
        args.putParcelable(NEWS_DETAILED_FRAGMENT_NEWS_MODEL_KEY, newsModel);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        App.getApplication().getAppComponent().plus(new NewsDetailedModule()).inject(this);
        mNewsDetailedFragmentPresenter.restoreArguments(getArguments());
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mNewsDetailedFragmentPresenter.bindView(this);
        mNewsDetailedFragmentPresenter.initStartViewActions();
        mNewsDetailedFragmentPresenter.setNewsData();
        mNewsDetailedFragmentPresenter.loadNewsImg(mNewsImg);
    }

    @Override
    public void onDestroyView() {
        mNewsDetailedFragmentPresenter.unbindView();
        super.onDestroyView();
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_news_detailed;
    }

    @SuppressWarnings("ConstantConditions")
    @OnClick(R.id.app_bar_back_arrow_img)
    void onClickAppBarBackArrow() {
        getActivity().onBackPressed();
    }

    @Override
    public void showAppBarBackArrow() {
        mAppBarBackArrow.setVisibility(View.VISIBLE);
    }

    @Override
    public void setAppBarTitle(String text) {
        mAppBarTitle.setText(text);
    }

    @Override
    public void setTitle(String text) {
        mNewsTitleTv.setText(text);
    }

    @Override
    public void setBody(String text) {
        mNewsBodyTv.setText(text);
    }

    @Override
    public void showProgressDialog() {
        mProgressDialog.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressDialog() {
        mProgressDialog.setVisibility(View.GONE);
    }

    @Override
    public void showContentContainer() {
        mContentContainer.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideContentContainer() {
        mContentContainer.setVisibility(View.GONE);
    }

    @Override
    public void showNoContentContainer() {
        mNoContentContainer.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideNoContentContainer() {
        mNoContentContainer.setVisibility(View.GONE);
    }
}
