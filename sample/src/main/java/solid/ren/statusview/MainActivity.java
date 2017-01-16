package solid.ren.statusview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import me.solidev.statusviewlayout.StatusViewLayout;

public class MainActivity extends AppCompatActivity {


    private StatusViewLayout mStatusView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupView();
    }

    private void setupView() {
        mStatusView = (StatusViewLayout) findViewById(R.id.status_view);
        mStatusView.setOnRetryListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "重试 Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.btn_show_loading).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mStatusView.showLoading();
            }
        });
        findViewById(R.id.btn_show_error).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mStatusView.showError();
            }
        });
        findViewById(R.id.btn_show_empty).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mStatusView.showEmpty();
            }
        });

        findViewById(R.id.btn_show_content).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mStatusView.showContent();
            }
        });


        findViewById(R.id.btn_show_no_network).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mStatusView.showNetWorkException();
            }
        });
    }


}
