package navumchyk.aliaksandr.cleanarchitecture.ui.adapters.news;

import android.view.View;
import android.view.ViewGroup;

import navumchyk.aliaksandr.cleanarchitecture.R;
import navumchyk.aliaksandr.cleanarchitecture.ui.adapters.common.BaseAdapter;
import navumchyk.aliaksandr.cleanarchitecture.ui.fragments.news.models.NewsModel;
import rx.subjects.PublishSubject;

/**
 * @author Aliaksandr Navumchyk
 */
public class NewsAdapter extends BaseAdapter<NewsModel, NewsHolder, NewsModel> {

    public NewsAdapter() {
        super(R.layout.item_news);
    }

    @Override
    public NewsHolder createViewHolder(View view,
                                       ViewGroup viewGroup,
                                       PublishSubject<NewsModel> click) {
        return new NewsHolder(view, click);
    }

    @Override
    public void onBindViewHolder(NewsHolder holder, int position) {
        holder.init(getItem(position));
    }
}