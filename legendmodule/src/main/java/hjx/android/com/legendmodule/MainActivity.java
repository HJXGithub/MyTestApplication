package hjx.android.com.legendmodule;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvTop;
    private LinearLayout layoutTwo;
    private LinearLayout layoutThree;
    private ObservableScrollView scrollView;
    private TextView tvThree;
    private TextView tvTwo;
    private int tvTopViewBottomY;
    private int[] tvTopCoordinate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvTop = findViewById(R.id.tvTop);
        tvTwo = findViewById(R.id.tvTwo);
        tvThree = findViewById(R.id.tvThree);
        layoutTwo = findViewById(R.id.layout_two);
        layoutThree = findViewById(R.id.layout_three);
        scrollView = findViewById(R.id.scrollView);
        tvTopCoordinate = new int[2];
        scrollView.setScrollViewListener(new ScrollViewListener() {
            @Override
            public void onScrollChanged(View view, int x, int y, int oldx, int oldy) {
                if (tvTopViewBottomY == 0) {
                    tvTop.getLocationInWindow(tvTopCoordinate);
                    tvTopViewBottomY = tvTop.getMeasuredHeight();
                    tvTopViewBottomY = tvTopViewBottomY + tvTopCoordinate[1];
                }
                int[] scrollViewCoordinate = new int[2];
                scrollView.getLocationInWindow(scrollViewCoordinate);
                int[] layoutTwoCoordinate = new int[2];
                tvTwo.getLocationInWindow(layoutTwoCoordinate);
                int[] layoutThreeCoordinate = new int[2];
                tvThree.getLocationInWindow(layoutThreeCoordinate);
                ViewGroup.MarginLayoutParams margin = new ViewGroup.MarginLayoutParams(tvTop.getLayoutParams());
                if (layoutThreeCoordinate[1] <= scrollViewCoordinate[1]) {
                    tvTop.setVisibility(View.VISIBLE);
                    tvTop.setText(tvThree.getText());
                    if (layoutThreeCoordinate[1] < tvTopViewBottomY + dip2px(getBaseContext(), 48)) {
                        margin.setMargins(0, dip2px(getBaseContext(), 48), 0, 0);
                        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(margin);
                        tvTop.setLayoutParams(layoutParams);
                    }
                } else if (layoutTwoCoordinate[1] <= scrollViewCoordinate[1]) {
                    tvTop.setVisibility(View.VISIBLE);
                    tvTop.setText(tvTwo.getText());
                    if (layoutThreeCoordinate[1] < tvTopViewBottomY) {
                        margin.setMargins(0, dip2px(getBaseContext(), 48) - (tvTopViewBottomY - layoutThreeCoordinate[1]), 0, 0);
                        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(margin);
                        tvTop.setLayoutParams(layoutParams);
                    } else {
                        margin.setMargins(0, dip2px(getBaseContext(), 48), 0, 0);
                        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(margin);
                        tvTop.setLayoutParams(layoutParams);
                    }
                } else {
                    tvTop.setVisibility(View.GONE);
                }
            }
        });
        initData();
    }

    private void initData() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            View view = LayoutInflater.from(getBaseContext()).inflate(R.layout.item_layout, null);
                            layoutTwo.addView(view);
                            view = LayoutInflater.from(getBaseContext()).inflate(R.layout.item_layout, null);
                            layoutTwo.addView(view);
                            view = LayoutInflater.from(getBaseContext()).inflate(R.layout.item_layout, null);
                            layoutTwo.addView(view);
                            view = LayoutInflater.from(getBaseContext()).inflate(R.layout.item_layout, null);
                            layoutTwo.addView(view);
                            view = LayoutInflater.from(getBaseContext()).inflate(R.layout.item_layout, null);
                            layoutTwo.addView(view);
                            view = LayoutInflater.from(getBaseContext()).inflate(R.layout.item_layout, null);
                            layoutTwo.addView(view);
                            view = LayoutInflater.from(getBaseContext()).inflate(R.layout.item_layout, null);
                            layoutTwo.addView(view);
                            view = LayoutInflater.from(getBaseContext()).inflate(R.layout.item_layout, null);
                            layoutTwo.addView(view);
                            view = LayoutInflater.from(getBaseContext()).inflate(R.layout.item_layout, null);
                            layoutTwo.addView(view);
                            view = LayoutInflater.from(getBaseContext()).inflate(R.layout.item_layout, null);
                            layoutTwo.addView(view);
                            view = LayoutInflater.from(getBaseContext()).inflate(R.layout.item_layout, null);
                            layoutTwo.addView(view);
                            view = LayoutInflater.from(getBaseContext()).inflate(R.layout.item_layout, null);
                            layoutTwo.addView(view);
                            view = LayoutInflater.from(getBaseContext()).inflate(R.layout.item_layout, null);
                            layoutTwo.addView(view);
                            view = LayoutInflater.from(getBaseContext()).inflate(R.layout.item_layout, null);
                            layoutTwo.addView(view);
                            view = LayoutInflater.from(getBaseContext()).inflate(R.layout.item_layout, null);
                            layoutTwo.addView(view);
                            view = LayoutInflater.from(getBaseContext()).inflate(R.layout.item_layout, null);
                            layoutTwo.addView(view);
                            view = LayoutInflater.from(getBaseContext()).inflate(R.layout.item_layout, null);
                            layoutTwo.addView(view);
                            view = LayoutInflater.from(getBaseContext()).inflate(R.layout.item_layout, null);
                            layoutTwo.addView(view);
                            view = LayoutInflater.from(getBaseContext()).inflate(R.layout.item_layout, null);
                            layoutTwo.addView(view);
                            view = LayoutInflater.from(getBaseContext()).inflate(R.layout.item_layout, null);
                            layoutTwo.addView(view);
                            view = LayoutInflater.from(getBaseContext()).inflate(R.layout.item_layout, null);
                            layoutTwo.addView(view);
                            view = LayoutInflater.from(getBaseContext()).inflate(R.layout.item_layout, null);
                            layoutTwo.addView(view);
                            view = LayoutInflater.from(getBaseContext()).inflate(R.layout.item_layout, null);
                            layoutTwo.addView(view);
                            view = LayoutInflater.from(getBaseContext()).inflate(R.layout.item_layout, null);
                            layoutTwo.addView(view);
                            view = LayoutInflater.from(getBaseContext()).inflate(R.layout.item_layout, null);
                            layoutTwo.addView(view);
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            View view = LayoutInflater.from(getBaseContext()).inflate(R.layout.item_three_layout, null);
                            layoutThree.addView(view);
                            view = LayoutInflater.from(getBaseContext()).inflate(R.layout.item_three_layout, null);
                            layoutThree.addView(view);
                            view = LayoutInflater.from(getBaseContext()).inflate(R.layout.item_three_layout, null);
                            layoutThree.addView(view);
                            view = LayoutInflater.from(getBaseContext()).inflate(R.layout.item_three_layout, null);
                            layoutThree.addView(view);
                            view = LayoutInflater.from(getBaseContext()).inflate(R.layout.item_three_layout, null);
                            layoutThree.addView(view);
                            view = LayoutInflater.from(getBaseContext()).inflate(R.layout.item_three_layout, null);
                            layoutThree.addView(view);
                            view = LayoutInflater.from(getBaseContext()).inflate(R.layout.item_three_layout, null);
                            layoutThree.addView(view);
                            view = LayoutInflater.from(getBaseContext()).inflate(R.layout.item_three_layout, null);
                            layoutThree.addView(view);
                            view = LayoutInflater.from(getBaseContext()).inflate(R.layout.item_three_layout, null);
                            layoutThree.addView(view);
                            view = LayoutInflater.from(getBaseContext()).inflate(R.layout.item_three_layout, null);
                            layoutThree.addView(view);
                            view = LayoutInflater.from(getBaseContext()).inflate(R.layout.item_three_layout, null);
                            layoutThree.addView(view);
                            view = LayoutInflater.from(getBaseContext()).inflate(R.layout.item_three_layout, null);
                            layoutThree.addView(view);
                            view = LayoutInflater.from(getBaseContext()).inflate(R.layout.item_three_layout, null);
                            layoutThree.addView(view);
                            view = LayoutInflater.from(getBaseContext()).inflate(R.layout.item_three_layout, null);
                            layoutThree.addView(view);
                            view = LayoutInflater.from(getBaseContext()).inflate(R.layout.item_three_layout, null);
                            layoutThree.addView(view);
                            view = LayoutInflater.from(getBaseContext()).inflate(R.layout.item_three_layout, null);
                            layoutThree.addView(view);
                            view = LayoutInflater.from(getBaseContext()).inflate(R.layout.item_three_layout, null);
                            layoutThree.addView(view);
                            view = LayoutInflater.from(getBaseContext()).inflate(R.layout.item_three_layout, null);
                            layoutThree.addView(view);
                            view = LayoutInflater.from(getBaseContext()).inflate(R.layout.item_three_layout, null);
                            layoutThree.addView(view);
                            view = LayoutInflater.from(getBaseContext()).inflate(R.layout.item_three_layout, null);
                            layoutThree.addView(view);
                            view = LayoutInflater.from(getBaseContext()).inflate(R.layout.item_three_layout, null);
                            layoutThree.addView(view);
                            view = LayoutInflater.from(getBaseContext()).inflate(R.layout.item_three_layout, null);
                            layoutThree.addView(view);
                            view = LayoutInflater.from(getBaseContext()).inflate(R.layout.item_three_layout, null);
                            layoutThree.addView(view);
                            view = LayoutInflater.from(getBaseContext()).inflate(R.layout.item_three_layout, null);
                            layoutThree.addView(view);
                            view = LayoutInflater.from(getBaseContext()).inflate(R.layout.item_three_layout, null);
                            layoutThree.addView(view);
                            view = LayoutInflater.from(getBaseContext()).inflate(R.layout.item_three_layout, null);
                            layoutThree.addView(view);
                            view = LayoutInflater.from(getBaseContext()).inflate(R.layout.item_three_layout, null);
                            layoutThree.addView(view);
                            view = LayoutInflater.from(getBaseContext()).inflate(R.layout.item_three_layout, null);
                            layoutThree.addView(view);
                            view = LayoutInflater.from(getBaseContext()).inflate(R.layout.item_three_layout, null);
                            layoutThree.addView(view);
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
