package navumchyk.aliaksandr.cleanarchitecture.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import navumchyk.aliaksandr.cleanarchitecture.R;

/**
 * @author Aliaksandr Naumhick
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.main_activity_container, new MainFragment())
                    .commit();
        }
    }
}
