package navumchyk.aliaksandr.cleanarchitecture.di.newsdetailed;

import dagger.Subcomponent;

/**
 * @author Aliaksandr Navumchyk
 */
@Subcomponent(modules = {NewsDetailedModule.class})
@NewsDetailedScope
public interface NewsDetailedComponent {

//    void inject(NewsDetailedFragment fragment);

}
