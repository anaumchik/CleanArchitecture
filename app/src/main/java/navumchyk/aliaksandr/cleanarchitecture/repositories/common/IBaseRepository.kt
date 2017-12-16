package navumchyk.aliaksandr.cleanarchitecture.repositories.common

/**
 * @author Aliaksandr Navumchyk
 */
interface IBaseRepository {

    fun log(message: String)

    fun logError(message: String)
}
