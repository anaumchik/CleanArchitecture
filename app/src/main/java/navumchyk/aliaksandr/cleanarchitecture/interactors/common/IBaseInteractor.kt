package navumchyk.aliaksandr.cleanarchitecture.interactors.common

/**
 * @author Aliaksandr Navumchyk
 */
interface IBaseInteractor {

    fun log(message: String)

    fun logError(message: String)
}
