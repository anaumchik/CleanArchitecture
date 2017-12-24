package navumchyk.aliaksandr.cleanarchitecture.di.newsDetailed;

import dagger.Subcomponent;
import navumchyk.aliaksandr.cleanarchitecture.ui.fragments.news.views.NewsDetailedFragment;

/**
 * @author Aliaksandr Navumchyk
 */
@Subcomponent(modules = {NewsDetailedModule.class})
@NewsDetailedScope
public interface NewsDetailedComponent {

    void inject(NewsDetailedFragment fragment);

}
