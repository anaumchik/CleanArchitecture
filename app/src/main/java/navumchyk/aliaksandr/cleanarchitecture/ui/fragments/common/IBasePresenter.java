package navumchyk.aliaksandr.cleanarchitecture.ui.fragments.common;

/**
 * @author Aliaksandr Navumchyk
 */
public interface IBasePresenter<TypeView> {

    void bindView(TypeView view);

    void unbindView();

    void initStartViewActions();
}
