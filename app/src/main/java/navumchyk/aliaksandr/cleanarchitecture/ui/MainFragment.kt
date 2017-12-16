package navumchyk.aliaksandr.cleanarchitecture.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import navumchyk.aliaksandr.cleanarchitecture.R
import navumchyk.aliaksandr.cleanarchitecture.ui.fragments.news.views.NewsFragment

/**
 * @author Aliaksandr Navumchyk
 */
class MainFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (savedInstanceState == null) {

            val transaction = activity?.supportFragmentManager?.beginTransaction()
            transaction?.replace(R.id.main_fragment_container, NewsFragment())
            transaction?.commit()
        }
    }

}
