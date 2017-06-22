package solid.ren.statusview;

import android.app.Application;

import me.solidev.statusviewlayout.StatusViewConfig;

/**
 * Created by _SOLID
 * Date:2017/6/22
 * Time:17:05
 * Desc:
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        StatusViewConfig.errorDrawable(R.drawable.cry);
    }
}
