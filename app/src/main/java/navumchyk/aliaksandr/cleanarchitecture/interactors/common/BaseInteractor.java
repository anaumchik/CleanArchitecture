package navumchyk.aliaksandr.cleanarchitecture.interactors.common;

import android.support.annotation.NonNull;

import navumchyk.aliaksandr.cleanarchitecture.utils.LogUtils;

/**
 * @author Aliaksandr Navumchyk
 */
public abstract class BaseInteractor implements IBaseInteractor {

    private final String TAG = getClass().getSimpleName();

    @Override
    public void log(@NonNull final String log) {
        LogUtils.i(TAG, log);
    }

    @Override
    public void logError(@NonNull final String error) {
        LogUtils.e(TAG, error);
    }
}