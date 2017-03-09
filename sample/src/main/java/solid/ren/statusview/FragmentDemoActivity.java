package solid.ren.statusview;

import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by _SOLID
 * Date:2017/3/9
 * Time:10:43
 * Desc:
 */

public class FragmentDemoActivity extends BaseMenuActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_activity_fragment_demo);
        setTitle("Fragment Demo");
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl_content, new DemoFragment())
                .commit();
    }
}
