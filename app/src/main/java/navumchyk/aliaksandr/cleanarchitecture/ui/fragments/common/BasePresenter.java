package navumchyk.aliaksandr.cleanarchitecture.ui.fragments.common;

import navumchyk.aliaksandr.cleanarchitecture.utils.LogUtils;
import rx.subscriptions.CompositeSubscription;

/**
 * @author Aliaksandr Navumchyk
 */
public abstract class BasePresenter<TypeView> implements IBasePresenter<TypeView> {

    protected CompositeSubscription mCompositeSubscription = new CompositeSubscription();
    private final String TAG = getClass().getSimpleName();

    @Override
    public void unbindView() {
        mCompositeSubscription.clear();
    }

    protected void log(final String log) {
        LogUtils.i(TAG, log);
    }

    protected void logError(final String error) {
        LogUtils.e(TAG, error);
    }
}