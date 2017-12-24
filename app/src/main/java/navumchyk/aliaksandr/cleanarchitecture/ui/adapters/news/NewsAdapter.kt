package navumchyk.aliaksandr.cleanarchitecture.ui.adapters.news

import android.view.View
import android.view.ViewGroup
import navumchyk.aliaksandr.cleanarchitecture.R
import navumchyk.aliaksandr.cleanarchitecture.ui.adapters.common.BaseAdapter
import navumchyk.aliaksandr.cleanarchitecture.ui.fragments.news.models.NewsModel

import rx.subjects.PublishSubject

/**
 * @author Aliaksandr Navumchyk
 */
class NewsAdapter : BaseAdapter<
        NewsModel,
        NewsHolder,
        NewsModel>(R.layout.item_news) {

    override fun createViewHolder(view: View,
                                  viewGroup: ViewGroup,
                                  click: PublishSubject<NewsModel>): NewsHolder =
            NewsHolder(view, click)

    override fun onBindViewHolder(holder: NewsHolder, position: Int) {
        holder.init(getItem(position))
    }
}