package navumchyk.aliaksandr.cleanarchitecture.repositories.common;

import android.support.annotation.NonNull;

import navumchyk.aliaksandr.cleanarchitecture.utils.LogUtils;

/**
 * @author Aliaksandr Navumchyk
 */
public abstract class BaseRepository implements IBaseRepository {

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