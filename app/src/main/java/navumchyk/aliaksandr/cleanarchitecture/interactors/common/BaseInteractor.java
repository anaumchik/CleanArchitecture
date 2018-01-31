package navumchyk.aliaksandr.cleanarchitecture.interactors.common;

import navumchyk.aliaksandr.cleanarchitecture.utils.LogUtils;

/**
 * @author Aliaksandr Navumchyk
 */
public abstract class BaseInteractor implements IBaseInteractor {

    private final String TAG = getClass().getSimpleName();

    @Override
    public void log(String log) {
        LogUtils.i(TAG, log);
    }

    @Override
    public void logError(String error) {
        LogUtils.e(TAG, error);
    }
}