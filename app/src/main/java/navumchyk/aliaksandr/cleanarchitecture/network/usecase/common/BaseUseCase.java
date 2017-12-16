package navumchyk.aliaksandr.cleanarchitecture.network.usecase.common;

import navumchyk.aliaksandr.cleanarchitecture.utils.LogUtils;
import rx.Single;
import rx.subjects.PublishSubject;

/**
 * @author Aliaksandr Navumchyk
 */
public abstract class BaseUseCase<ParamType, ResultType, RetrievedDataType> implements IBaseUseCase {

    private final String TAG = getClass().getSimpleName();
    private PublishSubject<RetrievedDataType> mRetrievedData = PublishSubject.create();

    public abstract Single<ResultType> buildUseCaseObservable(
            ParamType param,
            PublishSubject<RetrievedDataType> retrieveData);

    public Single<ResultType> execute(ParamType param) {
        return buildUseCaseObservable(param, mRetrievedData);
    }

    @Override
    public PublishSubject<RetrievedDataType> observeRetrievedData() {
        return mRetrievedData;
    }

    @Override
    public void log(String log) {
        LogUtils.i(TAG, log);
    }

    @Override
    public void logError(String error) {
        LogUtils.e(TAG, error);
    }
}
