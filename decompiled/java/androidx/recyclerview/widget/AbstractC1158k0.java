package androidx.recyclerview.widget;

import android.os.Trace;
import android.view.ViewGroup;
import java.util.List;
import p094j0.AbstractC2766n;

public abstract class AbstractC1158k0 {
    private final C1161l0 mObservable = new C1161l0();
    private boolean mHasStableIds = false;
    private EnumC1155j0 mStateRestorationPolicy = EnumC1155j0.f3597a;

    public final void bindViewHolder(AbstractC1174p1 abstractC1174p1, int i6) {
        boolean z7 = abstractC1174p1.mBindingAdapter == null;
        if (z7) {
            abstractC1174p1.mPosition = i6;
            if (hasStableIds()) {
                abstractC1174p1.mItemId = getItemId(i6);
            }
            abstractC1174p1.setFlags(1, 519);
            if (AbstractC2766n.m5740a()) {
                Trace.beginSection(String.format("RV onBindViewHolder type=0x%X", Integer.valueOf(abstractC1174p1.mItemViewType)));
            }
        }
        abstractC1174p1.mBindingAdapter = this;
        if (RecyclerView.sDebugAssertionsEnabled) {
            if (abstractC1174p1.itemView.getParent() == null && abstractC1174p1.itemView.isAttachedToWindow() != abstractC1174p1.isTmpDetached()) {
                throw new IllegalStateException("Temp-detached state out of sync with reality. holder.isTmpDetached(): " + abstractC1174p1.isTmpDetached() + ", attached to window: " + abstractC1174p1.itemView.isAttachedToWindow() + ", holder: " + abstractC1174p1);
            }
            if (abstractC1174p1.itemView.getParent() == null && abstractC1174p1.itemView.isAttachedToWindow()) {
                throw new IllegalStateException("Attempting to bind attached holder with no parent (AKA temp detached): " + abstractC1174p1);
            }
        }
        onBindViewHolder(abstractC1174p1, i6, abstractC1174p1.getUnmodifiedPayloads());
        if (z7) {
            abstractC1174p1.clearPayload();
            ViewGroup.LayoutParams layoutParams = abstractC1174p1.itemView.getLayoutParams();
            if (layoutParams instanceof RecyclerView.LayoutParams) {
                ((RecyclerView.LayoutParams) layoutParams).f3467c = true;
            }
            Trace.endSection();
        }
    }

    public boolean canRestoreState() {
        int iOrdinal = this.mStateRestorationPolicy.ordinal();
        if (iOrdinal != 1) {
            return iOrdinal != 2;
        }
        return getItemCount() > 0;
    }

    public final AbstractC1174p1 createViewHolder(ViewGroup viewGroup, int i6) {
        try {
            if (AbstractC2766n.m5740a()) {
                Trace.beginSection(String.format("RV onCreateViewHolder type=0x%X", Integer.valueOf(i6)));
            }
            AbstractC1174p1 abstractC1174p1OnCreateViewHolder = onCreateViewHolder(viewGroup, i6);
            if (abstractC1174p1OnCreateViewHolder.itemView.getParent() != null) {
                throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
            }
            abstractC1174p1OnCreateViewHolder.mItemViewType = i6;
            Trace.endSection();
            return abstractC1174p1OnCreateViewHolder;
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    public int findRelativeAdapterPositionIn(AbstractC1158k0 abstractC1158k0, AbstractC1174p1 abstractC1174p1, int i6) {
        if (abstractC1158k0 == this) {
            return i6;
        }
        return -1;
    }

    public abstract int getItemCount();

    public long getItemId(int i6) {
        return -1L;
    }

    public int getItemViewType(int i6) {
        return 0;
    }

    public final EnumC1155j0 getStateRestorationPolicy() {
        return this.mStateRestorationPolicy;
    }

    public final boolean hasObservers() {
        return this.mObservable.m2962a();
    }

    public final boolean hasStableIds() {
        return this.mHasStableIds;
    }

    public final void notifyDataSetChanged() {
        this.mObservable.m2963b();
    }

    public final void notifyItemChanged(int i6) {
        this.mObservable.m2965d(i6, 1, null);
    }

    public final void notifyItemInserted(int i6) {
        this.mObservable.m2966e(i6, 1);
    }

    public final void notifyItemMoved(int i6, int i10) {
        this.mObservable.m2964c(i6, i10);
    }

    public final void notifyItemRangeChanged(int i6, int i10) {
        this.mObservable.m2965d(i6, i10, null);
    }

    public final void notifyItemRangeInserted(int i6, int i10) {
        this.mObservable.m2966e(i6, i10);
    }

    public final void notifyItemRangeRemoved(int i6, int i10) {
        this.mObservable.m2967f(i6, i10);
    }

    public final void notifyItemRemoved(int i6) {
        this.mObservable.m2967f(i6, 1);
    }

    public abstract void onBindViewHolder(AbstractC1174p1 abstractC1174p1, int i6);

    public void onBindViewHolder(AbstractC1174p1 abstractC1174p1, int i6, List<Object> list) {
        onBindViewHolder(abstractC1174p1, i6);
    }

    public abstract AbstractC1174p1 onCreateViewHolder(ViewGroup viewGroup, int i6);

    public boolean onFailedToRecycleView(AbstractC1174p1 abstractC1174p1) {
        return false;
    }

    public void registerAdapterDataObserver(AbstractC1164m0 abstractC1164m0) {
        this.mObservable.registerObserver(abstractC1164m0);
    }

    public void setHasStableIds(boolean z7) {
        if (hasObservers()) {
            throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
        }
        this.mHasStableIds = z7;
    }

    public void setStateRestorationPolicy(EnumC1155j0 enumC1155j0) {
        this.mStateRestorationPolicy = enumC1155j0;
        this.mObservable.m2968g();
    }

    public void unregisterAdapterDataObserver(AbstractC1164m0 abstractC1164m0) {
        this.mObservable.unregisterObserver(abstractC1164m0);
    }

    public final void notifyItemChanged(int i6, Object obj) {
        this.mObservable.m2965d(i6, 1, obj);
    }

    public final void notifyItemRangeChanged(int i6, int i10, Object obj) {
        this.mObservable.m2965d(i6, i10, obj);
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
    }

    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
    }

    public void onViewAttachedToWindow(AbstractC1174p1 abstractC1174p1) {
    }

    public void onViewDetachedFromWindow(AbstractC1174p1 abstractC1174p1) {
    }

    public void onViewRecycled(AbstractC1174p1 abstractC1174p1) {
    }
}
