package hjx.android.com.legendmodule;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;

/**
 * Created by hjx on 2018/11/25 .
 */
public class ObservableScrollView extends ScrollView {

    private ScrollViewListener scrollViewListener = null;
    private ScrollViewToBottomLiatener onScrollViewToBottomLiatener;

    public ObservableScrollView(Context context) {
        super(context);
    }

    public ObservableScrollView(Context context, AttributeSet attrs,
                                int defStyle) {
        super(context, attrs, defStyle);
    }

    public ObservableScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setScrollViewListener(ScrollViewListener scrollViewListener) {
        this.scrollViewListener = scrollViewListener;
    }

    //重写滚动方法
    @Override
    protected void onScrollChanged(int x, int y, int oldx, int oldy) {
        super.onScrollChanged(x, y, oldx, oldy);
//        if (scrollViewListener != null) {
//            scrollViewListener.onScrollChanged(this, x, y, oldx, oldy);
//        }

        View view = (View) getChildAt(getChildCount() - 1);

        int d = view.getBottom();

        //根据距离判断是否滑到了底部
        d -= (getHeight() + getScrollY());

//        Log.e("---------->","d"+d);
        if (d == 0) {
            //滑到底部的监听
            if (onScrollViewToBottomLiatener != null) {
                onScrollViewToBottomLiatener.onScrollViewToBottomListener();
            }

        } else {
            //滑动监听，可以根据滑动的距离做相应的事件，如返回顶部
            if (scrollViewListener != null) {
                scrollViewListener.onScrollChanged(this, x, y, oldx, oldy);
            }
        }
    }

    public void setScrollViewToBottomLiatener(ScrollViewToBottomLiatener onScrollViewToBottomLiatener) {
        this.onScrollViewToBottomLiatener = onScrollViewToBottomLiatener;
    }

    interface ScrollViewToBottomLiatener {
        public void onScrollViewToBottomListener();
    }

}