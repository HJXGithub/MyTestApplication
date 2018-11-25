package eostest.android.com.customview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView topRecycler = findViewById(R.id.top_recycler);
        RecyclerView bottomRecycler = findViewById(R.id.bottom_recycler);
        RelativeLayout moveView = findViewById(R.id.move_view);

        initData();

        topRecycler.setLayoutManager(new GridLayoutManager(this, 3));
        topRecycler.setAdapter(new TopViewAdapter());
        bottomRecycler.setLayoutManager(new GridLayoutManager(this, 3));
    }

    private void initData() {
        for (int i = 0; i < 10; i++) {

        }
    }
}
