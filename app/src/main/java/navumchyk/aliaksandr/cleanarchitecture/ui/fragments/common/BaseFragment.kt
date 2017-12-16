package navumchyk.aliaksandr.cleanarchitecture.ui.fragments.common

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.ButterKnife
import butterknife.Unbinder
import navumchyk.aliaksandr.cleanarchitecture.R
import navumchyk.aliaksandr.cleanarchitecture.utils.LogUtils

/**
 * @author Aliaksandr Navumchyk
 */
abstract class BaseFragment : Fragment(), IBaseFragment{

    private lateinit var mTag: String
    private lateinit var mUnbinder: Unbinder

    protected abstract val layout: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mTag = activity!!.supportFragmentManager
                .findFragmentById(R.id.main_fragment_container)
                .javaClass
                .simpleName
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        val rootLayout = inflater.inflate(layout, container, false)

        mUnbinder = ButterKnife.bind(this, rootLayout)

        return rootLayout
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mUnbinder.unbind()
    }

    override fun log(message: String) {
        LogUtils.i(mTag, message)
    }

    override fun logError(message: String) {
        LogUtils.e(mTag, message)
    }
}
