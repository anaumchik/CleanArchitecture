package navumchyk.aliaksandr.cleanarchitecture.ui.fragments.news.presenter;

import android.os.Bundle;
import android.widget.ImageView;

import navumchyk.aliaksandr.cleanarchitecture.ui.fragments.common.IBasePresenter;
import navumchyk.aliaksandr.cleanarchitecture.ui.fragments.news.views.INewsDetailedFragmentView;

/**
 * @author Aliaksandr Navumchyk
 */
public interface INewsDetailedFragmentPresenter extends IBasePresenter<INewsDetailedFragmentView> {

    void restoreArguments(Bundle arguments);

    void setNewsData();

    void loadNewsImg(ImageView newsImg);
}
