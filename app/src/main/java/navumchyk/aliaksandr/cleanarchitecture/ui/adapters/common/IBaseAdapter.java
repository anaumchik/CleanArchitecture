package navumchyk.aliaksandr.cleanarchitecture.ui.adapters.common;

import java.util.ArrayList;

import rx.subjects.PublishSubject;

/**
 * @author Aliaksandr Navumchyk
 */
public interface IBaseAdapter<TypeData, ClickData> {

    void setData(ArrayList<TypeData> data);

    ArrayList<TypeData> getData();

    TypeData getItem(final int position);

    PublishSubject<ClickData> observeItemClick();
}


