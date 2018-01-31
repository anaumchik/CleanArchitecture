package navumchyk.aliaksandr.cleanarchitecture.ui.fragments.news.views;

import java.util.ArrayList;

import navumchyk.aliaksandr.cleanarchitecture.ui.fragments.news.models.NewsModel;

/**
 * @author Aliaksandr Navumchyk
 */
public interface INewsFragmentView {

    void setAppBarTitle();

    void initNewsAdapter();

    void setNewsAdapterData(ArrayList<NewsModel> data);

    void showProgressDialog();

    void hideProgressDialog();

    void showContentContainer();

    void hideContentContainer();

    void showNoContentContainer();

    void hideNoContentContainer();

    void openNewsDetailedFragment(NewsModel newsModel);
}
