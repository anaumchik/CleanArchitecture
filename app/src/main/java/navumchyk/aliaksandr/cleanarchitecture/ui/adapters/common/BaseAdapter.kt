package navumchyk.aliaksandr.cleanarchitecture.ui.adapters.common

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import rx.subjects.PublishSubject
import java.util.*

/**
 * @author Aliaksandr Navumchyk
 */
abstract class BaseAdapter<TypeData, TypeHolder : RecyclerView.ViewHolder, ClickData>(
        private val mLayoutResId: Int) : RecyclerView.Adapter<TypeHolder>(),
        IBaseAdapter<TypeData, ClickData> {

    private val mClick = PublishSubject.create<ClickData>()
    private var mData: ArrayList<TypeData> = ArrayList()

    abstract fun createViewHolder(view: View,
                                  viewGroup: ViewGroup,
                                  click: PublishSubject<ClickData>): TypeHolder

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): TypeHolder {
        val view = LayoutInflater
                .from(viewGroup.context).inflate(mLayoutResId, viewGroup, false)
        return createViewHolder(view, viewGroup, mClick)
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    override fun onViewDetachedFromWindow(holder: TypeHolder) {
        val baseHolder = holder as BaseHolder<*>
        baseHolder.unbindView()
        super.onViewDetachedFromWindow(holder)
    }

    override fun setData(data: ArrayList<TypeData>) {
        mData = data
        this.notifyDataSetChanged()
    }

    override fun getData(): ArrayList<TypeData> {
        return mData
    }

    override fun getItem(position: Int): TypeData {
        return mData[position]
    }

    override fun observeItemClick(): PublishSubject<ClickData> {
        return mClick
    }
}