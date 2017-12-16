package navumchyk.aliaksandr.cleanarchitecture.utils


import rx.Single
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * @author Aliaksandr Navumchyk
 */
class RxIoTransformer<T> : Single.Transformer<T, T> {

    override fun call(single: Single<T>): Single<T> {
        return single
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }
}