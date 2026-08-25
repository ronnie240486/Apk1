package com.google.common.util.concurrent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import p041d7.AbstractC2182d0;
import p041d7.AbstractC2274q1;

@ElementTypesAreNonnullByDefault
abstract class CollectionFuture<V, C> extends AggregateFuture<V, C> {
    private List<Present<V>> values;

    public static final class ListFuture<V> extends CollectionFuture<V, List<V>> {
        public ListFuture(AbstractC2274q1 abstractC2274q1, boolean z7) {
            super(abstractC2274q1, z7);
            init();
        }

        @Override
        public List<V> combine(List<Present<V>> list) {
            ArrayList arrayListM5157t = AbstractC2182d0.m5157t(list.size());
            Iterator<Present<V>> it = list.iterator();
            while (it.hasNext()) {
                Present<V> next = it.next();
                arrayListM5157t.add(next != null ? next.value : null);
            }
            return Collections.unmodifiableList(arrayListM5157t);
        }
    }

    public static final class Present<V> {

        @ParametricNullness
        final V value;

        public Present(@ParametricNullness V v10) {
            this.value = v10;
        }
    }

    public CollectionFuture(AbstractC2274q1 abstractC2274q1, boolean z7) {
        super(abstractC2274q1, z7, true);
        List<Present<V>> listEmptyList = abstractC2274q1.isEmpty() ? Collections.emptyList() : AbstractC2182d0.m5157t(abstractC2274q1.size());
        for (int i6 = 0; i6 < abstractC2274q1.size(); i6++) {
            listEmptyList.add(null);
        }
        this.values = listEmptyList;
    }

    @Override
    public final void collectOneValue(int i6, @ParametricNullness V v10) {
        List<Present<V>> list = this.values;
        if (list != null) {
            list.set(i6, new Present<>(v10));
        }
    }

    public abstract C combine(List<Present<V>> list);

    @Override
    public final void handleAllCompleted() {
        List<Present<V>> list = this.values;
        if (list != null) {
            set(combine(list));
        }
    }

    @Override
    public void releaseResources(AggregateFuture.ReleaseResourcesReason releaseResourcesReason) {
        super.releaseResources(releaseResourcesReason);
        this.values = null;
    }
}
