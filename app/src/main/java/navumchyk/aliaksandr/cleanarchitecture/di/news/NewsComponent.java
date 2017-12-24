package navumchyk.aliaksandr.cleanarchitecture.di.news;

import dagger.Subcomponent;
import navumchyk.aliaksandr.cleanarchitecture.ui.fragments.news.views.NewsFragment;

/**
 * @author Aliaksandr Navumchyk
 */
@Subcomponent(modules = {NewsModule.class})
@NewsScope
public interface NewsComponent {

    void inject(NewsFragment fragment);
}
