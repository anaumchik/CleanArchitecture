package navumchyk.aliaksandr.cleanarchitecture.ui.adapters.common;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import rx.subjects.PublishSubject;

/**
 * @author Aliaksandr Navumchyk
 */
public interface IBaseAdapter<TypeData, ClickData> {

    void setData(@NotNull ArrayList<TypeData> data);

    ArrayList<TypeData> getData();

    TypeData getItem(final int position);

    PublishSubject<ClickData> observeItemClick();

}


