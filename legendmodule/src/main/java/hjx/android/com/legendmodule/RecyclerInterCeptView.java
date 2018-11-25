package hjx.android.com.legendmodule;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by hjx on 2018/11/25 .
 */
public class RecyclerInterCeptView extends RecyclerView {
    private MoveEvent moveEvent;

    public RecyclerInterCeptView(@NonNull Context context) {
        super(context);
    }

    public RecyclerInterCeptView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public RecyclerInterCeptView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent e) {
        if (moveEvent != null) {
            moveEvent.moveEvent();
        }
        return super.onInterceptTouchEvent(e);
    }

    public void setOnMoveEvent(MoveEvent moveEvent) {
        this.moveEvent = moveEvent;
    }

    interface MoveEvent {
        void moveEvent();
    }
}
