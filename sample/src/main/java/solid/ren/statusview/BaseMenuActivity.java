package solid.ren.statusview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

/**
 * Created by _SOLID
 * Date:2017/3/9
 * Time:10:47
 * Desc:
 */

public class BaseMenuActivity extends AppCompatActivity {
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent();
        if ("Normal".equals(item.getTitle())) {
            intent.setClass(this, NormalActivity.class);
        } else if ("Helper Demo".equals(item.getTitle())) {
            intent.setClass(this, HelperDemoActivity.class);
        } else if ("Fragment Demo".equals(item.getTitle())) {
            intent.setClass(this, FragmentDemoActivity.class);
        }
        startActivity(intent);
        this.finish();
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("Normal");
        menu.add("Helper Demo");
        menu.add("Fragment Demo");
        return true;
    }
}
