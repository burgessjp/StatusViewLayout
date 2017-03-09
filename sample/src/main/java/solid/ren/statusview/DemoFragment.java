package solid.ren.statusview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.solidev.statusviewlayout.StatusHelper;
import me.solidev.statusviewlayout.StatusViewLayout;

/**
 * Created by _SOLID
 * Date:2017/3/9
 * Time:10:36
 * Desc:
 */

public class DemoFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        StatusViewLayout statusViewLayout =
                StatusHelper.onCreateView(this, R.layout.fragment_demo);
        statusViewLayout.showError();
        return statusViewLayout;
    }
}
