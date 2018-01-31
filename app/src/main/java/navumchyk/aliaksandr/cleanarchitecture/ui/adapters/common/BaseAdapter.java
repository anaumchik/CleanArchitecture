package navumchyk.aliaksandr.cleanarchitecture.ui.adapters.common;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import rx.subjects.PublishSubject;

/**
 * @author Aliaksandr Navumchyk
 */
public abstract class BaseAdapter<TypeData, TypeHolder extends RecyclerView.ViewHolder, ClickData>
        extends RecyclerView.Adapter<TypeHolder> implements IBaseAdapter<TypeData, ClickData> {

    private PublishSubject<ClickData> mClick = PublishSubject.create();
    private ArrayList<TypeData> mData = new ArrayList<>();
    private int mLayoutResId;

    public BaseAdapter(int layoutResId) {
        mLayoutResId = layoutResId;
    }

    public abstract TypeHolder createViewHolder(View view,
                                                ViewGroup viewGroup,
                                                PublishSubject<ClickData> click);

    @Override
    public TypeHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        final View view = LayoutInflater
                .from(viewGroup.getContext()).inflate(mLayoutResId, viewGroup, false);
        return createViewHolder(view, viewGroup, mClick);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public void onViewDetachedFromWindow(TypeHolder holder) {
        final BaseHolder baseHolder = (BaseHolder) holder;
        baseHolder.unbindView();
        super.onViewDetachedFromWindow(holder);
    }

    @Override
    public void setData(@NonNull ArrayList<TypeData> data) {
        mData = data;
        this.notifyDataSetChanged();
    }

    @Override
    public ArrayList<TypeData> getData() {
        return mData;
    }

    @Override
    public TypeData getItem(int position) {
        return mData.get(position);
    }

    @Override
    public PublishSubject<ClickData> observeItemClick() {
        return mClick;
    }
}