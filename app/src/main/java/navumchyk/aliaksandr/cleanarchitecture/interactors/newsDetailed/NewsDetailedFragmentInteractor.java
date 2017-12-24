package navumchyk.aliaksandr.cleanarchitecture.interactors.newsDetailed;

import navumchyk.aliaksandr.cleanarchitecture.interactors.common.BaseInteractor;
import navumchyk.aliaksandr.cleanarchitecture.repositories.newsDetailed.INewsDetailedFragmentRepository;

/**
 * @author Aliaksandr Navumchyk
 */
public class NewsDetailedFragmentInteractor extends BaseInteractor implements INewsDetailedFragmentInteractor {

    private final INewsDetailedFragmentRepository mNewsDetailedFragmentRepository;

    public NewsDetailedFragmentInteractor(INewsDetailedFragmentRepository newsDetailedFragmentRepository) {
        this.mNewsDetailedFragmentRepository = newsDetailedFragmentRepository;
    }
}
