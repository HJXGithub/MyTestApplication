package hjx.android.com.legendmodule;

import android.support.v4.util.SparseArrayCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Created by hjx on 2018/11/25 .
 */
public class HeaderAndFooterLoadMoreWrapper extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private RecyclerView.Adapter adapter;
    /*
        // 普通布局
        private final int TYPE_ITEM = 1;
        // 加载更多脚布局
        private final int TYPE_FOOTER = 2;*/
    // 当前加载状态，默认为加载完成
    private int loadState = 2;
    // 正在加载
    public final int LOADING = 1;
    // 加载完成
    public final int LOADING_COMPLETE = 2;
    // 加载到底
    public final int LOADING_END = 3;


    private static final int BASE_ITEM_TYPE_HEADER = 100000;
    private static final int BASE_ITEM_TYPE_FOOTER = 200000;
    private static final int BASE_ITEM_TYPE_LOAD_MORE = 250000;

    private SparseArrayCompat<View> mHeaderViews = new SparseArrayCompat<>();
    private SparseArrayCompat<View> mFootViews = new SparseArrayCompat<>();

    private RecyclerView.Adapter mInnerAdapter;

    private boolean isHeaderViewPos(int position) {
        return position < getHeadersCount();
    }

    private boolean isFooterViewPos(int position) {
        return position >= getHeadersCount() + getRealItemCount();
    }


    public void addHeaderView(View view) {
        mHeaderViews.put(mHeaderViews.size() + BASE_ITEM_TYPE_HEADER, view);
    }

    public void addFootView(View view) {
        mFootViews.put(mFootViews.size() + BASE_ITEM_TYPE_FOOTER, view);
    }

    public int getHeadersCount() {
        return mHeaderViews.size();
    }

    public int getFootersCount() {
        return mFootViews.size();
    }

    public HeaderAndFooterLoadMoreWrapper(RecyclerView.Adapter adapter) {
        this.adapter = adapter;
    }

    @Override
    public int getItemViewType(int position) {
        int i = getItemCount();
        boolean a = position == (getItemCount() - 1);
        if (isHeaderViewPos(position)) {
            return mHeaderViews.keyAt(position);
        } else if (position == (getItemCount() - 1)) {
            return BASE_ITEM_TYPE_LOAD_MORE;
        } else if (isFooterViewPos(position)) {
            return mFootViews.keyAt(position - getHeadersCount() - getRealItemCount());
        } else
            return position;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int a = getRealItemCount() + 1;
        if (mHeaderViews.get(viewType) != null) {
            RecyclerView.ViewHolder holder = new MViewHolder(mHeaderViews.get(viewType));
            return holder;
        } else if (mFootViews.get(viewType) != null) {
            RecyclerView.ViewHolder holder = new MViewHolder(mFootViews.get(viewType));
            return holder;
        } else if (viewType == BASE_ITEM_TYPE_LOAD_MORE) {
            // 通过判断显示类型，来创建不同的View
            adapter.createViewHolder(null, 1);
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.layout_refresh_footer, parent, false);
            return new FootViewHolder(view);
        } else {
            return adapter.onCreateViewHolder(parent, viewType);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (isHeaderViewPos(position))
            return;
        else if (holder instanceof FootViewHolder) {
            FootViewHolder footViewHolder = (FootViewHolder) holder;
            switch (loadState) {
                case LOADING: // 正在加载
                    footViewHolder.pbLoading.setVisibility(View.VISIBLE);
                    footViewHolder.tvLoading.setVisibility(View.VISIBLE);
                    footViewHolder.llEnd.setVisibility(View.GONE);
                    break;

                case LOADING_COMPLETE: // 加载完成
                    footViewHolder.pbLoading.setVisibility(View.INVISIBLE);
                    footViewHolder.tvLoading.setVisibility(View.INVISIBLE);
                    footViewHolder.llEnd.setVisibility(View.GONE);
                    break;

                case LOADING_END: // 加载到底
                    footViewHolder.pbLoading.setVisibility(View.GONE);
                    footViewHolder.tvLoading.setVisibility(View.GONE);
                    footViewHolder.llEnd.setVisibility(View.GONE);
                    footViewHolder.itemView.setVisibility(View.GONE);
                    break;

                default:
                    break;
            }
        } else if (isFooterViewPos(position))
            return;
        else
            adapter.onBindViewHolder(holder, position - getHeadersCount());
    }

    @Override
    public int getItemCount() {
        return adapter.getItemCount() + getHeadersCount() + getFootersCount() + 1;
    }

    private int getRealItemCount() {
        return adapter.getItemCount();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        RecyclerView.LayoutManager manager = recyclerView.getLayoutManager();
        if (manager instanceof GridLayoutManager) {
            final GridLayoutManager gridManager = ((GridLayoutManager) manager);
            gridManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    // 如果当前是loadMore的位置，那么该item占据2个单元格，正常情况下占据1个单元格
                    return getItemViewType(position) == (getRealItemCount() + getHeadersCount() + getFootersCount() + 1) ? gridManager.getSpanCount() : 1;
                }
            });
        }
    }

    private class FootViewHolder extends RecyclerView.ViewHolder {

        ProgressBar pbLoading;
        TextView tvLoading;
        LinearLayout llEnd;

        FootViewHolder(View itemView) {
            super(itemView);
            pbLoading = (ProgressBar) itemView.findViewById(R.id.pb_loading);
            tvLoading = (TextView) itemView.findViewById(R.id.tv_loading);
            llEnd = (LinearLayout) itemView.findViewById(R.id.ll_end);
        }
    }

    private class MViewHolder extends RecyclerView.ViewHolder {
        public MViewHolder(View itemView) {
            super(itemView);
        }
    }

    /**
     * 设置上拉加载状态
     *
     * @param loadState 0.正在加载 1.加载完成 2.加载到底
     */
    public void setLoadState(int loadState) {
        this.loadState = loadState;
        notifyDataSetChanged();
    }
}
