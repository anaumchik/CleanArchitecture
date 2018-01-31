package navumchyk.aliaksandr.cleanarchitecture.ui.fragments.common;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import navumchyk.aliaksandr.cleanarchitecture.R;
import navumchyk.aliaksandr.cleanarchitecture.utils.LogUtils;

/**
 * @author Aliaksandr Navumchyk
 */
public abstract class BaseFragment extends Fragment implements IBaseFragment {

    private String mTag;
    private Unbinder mUnbinder;

    public abstract int getLayout();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getActivity() != null)
            mTag = getActivity().getSupportFragmentManager()
                    .findFragmentById(R.id.main_fragment_container)
                    .getClass().getSimpleName();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        final View rootLayout = getLayoutInflater().inflate(getLayout(), container, false);
        mUnbinder = ButterKnife.bind(this, rootLayout);
        return rootLayout;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }

    @Override
    public void log(String message) {
        LogUtils.i(mTag, message);
    }

    @Override
    public void logError(String error) {
        LogUtils.e(mTag, error);
    }
}