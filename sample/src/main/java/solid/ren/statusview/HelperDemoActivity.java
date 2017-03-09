package solid.ren.statusview;

import android.os.Bundle;

import me.solidev.statusviewlayout.StatusHelper;
import me.solidev.statusviewlayout.StatusViewLayout;

/**
 * Created by _SOLID
 * Date:2017/3/9
 * Time:9:44
 * Desc:
 */

public class HelperDemoActivity extends BaseMenuActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Helper Demo");
        StatusViewLayout statusViewLayout = StatusHelper
                .setContentView(this, R.layout.activity_helper_demo);
        statusViewLayout.showLoading();
    }
}
