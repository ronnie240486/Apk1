package com.youth.banner.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.AbstractC1158k0;
import androidx.recyclerview.widget.AbstractC1174p1;
import com.youth.banner.C2110R;
import com.youth.banner.holder.IViewHolder;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.util.BannerUtils;
import java.util.ArrayList;
import java.util.List;

public abstract class BannerAdapter<T, VH extends AbstractC1174p1> extends AbstractC1158k0 implements IViewHolder<T, VH> {
    protected List<T> mDatas = new ArrayList();
    private int mIncreaseCount = 2;
    private OnBannerListener<T> mOnBannerListener;
    private VH mViewHolder;

    public BannerAdapter(List<T> list) {
        setDatas(list);
    }

    public void lambda$onBindViewHolder$0(Object obj, int i6, View view) {
        this.mOnBannerListener.OnBannerClick(obj, i6);
    }

    public void lambda$onCreateViewHolder$1(AbstractC1174p1 abstractC1174p1, View view) {
        if (this.mOnBannerListener != null) {
            Object tag = abstractC1174p1.itemView.getTag(C2110R.id.banner_data_key);
            this.mOnBannerListener.OnBannerClick((T) tag, ((Integer) abstractC1174p1.itemView.getTag(C2110R.id.banner_pos_key)).intValue());
        }
    }

    public T getData(int i6) {
        if (i6 > this.mDatas.size() - 1) {
            return null;
        }
        return this.mDatas.get(i6);
    }

    @Override
    public int getItemCount() {
        return getRealCount() > 1 ? getRealCount() + this.mIncreaseCount : getRealCount();
    }

    public int getRealCount() {
        List<T> list = this.mDatas;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public T getRealData(int i6) {
        int realPosition = getRealPosition(i6);
        if (realPosition > this.mDatas.size() - 1) {
            return null;
        }
        return this.mDatas.get(realPosition);
    }

    public int getRealPosition(int i6) {
        return BannerUtils.getRealPosition(this.mIncreaseCount == 2, i6, getRealCount());
    }

    public VH getViewHolder() {
        return this.mViewHolder;
    }

    @Override
    public final void onBindViewHolder(VH vh, int i6) {
        this.mViewHolder = vh;
        final int realPosition = getRealPosition(i6);
        final T t5 = this.mDatas.get(realPosition);
        vh.itemView.setTag(C2110R.id.banner_data_key, t5);
        vh.itemView.setTag(C2110R.id.banner_pos_key, Integer.valueOf(realPosition));
        onBindView(vh, this.mDatas.get(realPosition), realPosition, getRealCount());
        if (this.mOnBannerListener != null) {
            vh.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public final void onClick(View view) {
                    this.f7722a.lambda$onBindViewHolder$0(t5, realPosition, view);
                }
            });
        }
    }

    @Override
    public VH onCreateViewHolder(ViewGroup viewGroup, int i6) {
        VH vhOnCreateHolder = onCreateHolder(viewGroup, i6);
        vhOnCreateHolder.itemView.setOnClickListener(new ViewOnClickListenerC2111a(this, 0, vhOnCreateHolder));
        return vhOnCreateHolder;
    }

    public void setDatas(List<T> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        this.mDatas.clear();
        this.mDatas.addAll(list);
        notifyDataSetChanged();
    }

    public void setIncreaseCount(int i6) {
        this.mIncreaseCount = i6;
    }

    public void setOnBannerListener(OnBannerListener<T> onBannerListener) {
        this.mOnBannerListener = onBannerListener;
    }
}
