package navumchyk.aliaksandr.cleanarchitecture.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import navumchyk.aliaksandr.cleanarchitecture.R

/**
 * @author Aliaksandr Navumchyk
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.main_activity_container, MainFragment())
            transaction.commit()
        }
    }
}
