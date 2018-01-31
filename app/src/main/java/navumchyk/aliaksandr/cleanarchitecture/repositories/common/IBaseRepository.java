package navumchyk.aliaksandr.cleanarchitecture.repositories.common;

/**
 * @author Aliaksandr Navumchyk
 */
public interface IBaseRepository {

    void log(String log);

    void logError(String error);
}
