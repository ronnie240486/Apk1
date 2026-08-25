package androidx.recyclerview.widget;

import java.util.ArrayList;
import java.util.Arrays;

public final class C1195w1 {

    public int[] f3724a;

    public ArrayList f3725b;

    public final void m2999a(StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem staggeredGridLayoutManager$LazySpanLookup$FullSpanItem) {
        if (this.f3725b == null) {
            this.f3725b = new ArrayList();
        }
        int size = this.f3725b.size();
        for (int i6 = 0; i6 < size; i6++) {
            StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem staggeredGridLayoutManager$LazySpanLookup$FullSpanItem2 = (StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem) this.f3725b.get(i6);
            if (staggeredGridLayoutManager$LazySpanLookup$FullSpanItem2.f3496a == staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.f3496a) {
                this.f3725b.remove(i6);
            }
            if (staggeredGridLayoutManager$LazySpanLookup$FullSpanItem2.f3496a >= staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.f3496a) {
                this.f3725b.add(i6, staggeredGridLayoutManager$LazySpanLookup$FullSpanItem);
                return;
            }
        }
        this.f3725b.add(staggeredGridLayoutManager$LazySpanLookup$FullSpanItem);
    }

    public final void m3000b() {
        int[] iArr = this.f3724a;
        if (iArr != null) {
            Arrays.fill(iArr, -1);
        }
        this.f3725b = null;
    }

    public final void m3001c(int i6) {
        int[] iArr = this.f3724a;
        if (iArr == null) {
            int[] iArr2 = new int[Math.max(i6, 10) + 1];
            this.f3724a = iArr2;
            Arrays.fill(iArr2, -1);
        } else if (i6 >= iArr.length) {
            int length = iArr.length;
            while (length <= i6) {
                length *= 2;
            }
            int[] iArr3 = new int[length];
            this.f3724a = iArr3;
            System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            int[] iArr4 = this.f3724a;
            Arrays.fill(iArr4, iArr.length, iArr4.length, -1);
        }
    }

    public final void m3002d(int i6) {
        ArrayList arrayList = this.f3725b;
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (((StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem) this.f3725b.get(size)).f3496a >= i6) {
                    this.f3725b.remove(size);
                }
            }
        }
        m3005g(i6);
    }

    public final StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem m3003e(int i6, int i10, int i11) {
        ArrayList arrayList = this.f3725b;
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        for (int i12 = 0; i12 < size; i12++) {
            StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem staggeredGridLayoutManager$LazySpanLookup$FullSpanItem = (StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem) this.f3725b.get(i12);
            int i13 = staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.f3496a;
            if (i13 >= i10) {
                return null;
            }
            if (i13 >= i6 && (i11 == 0 || staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.f3497b == i11 || staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.f3499d)) {
                return staggeredGridLayoutManager$LazySpanLookup$FullSpanItem;
            }
        }
        return null;
    }

    public final StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem m3004f(int i6) {
        ArrayList arrayList = this.f3725b;
        if (arrayList == null) {
            return null;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem staggeredGridLayoutManager$LazySpanLookup$FullSpanItem = (StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem) this.f3725b.get(size);
            if (staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.f3496a == i6) {
                return staggeredGridLayoutManager$LazySpanLookup$FullSpanItem;
            }
        }
        return null;
    }

    public final int m3005g(int i6) {
        int i10;
        int[] iArr = this.f3724a;
        if (iArr == null || i6 >= iArr.length) {
            return -1;
        }
        if (this.f3725b != null) {
            StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem staggeredGridLayoutManager$LazySpanLookup$FullSpanItemM3004f = m3004f(i6);
            if (staggeredGridLayoutManager$LazySpanLookup$FullSpanItemM3004f != null) {
                this.f3725b.remove(staggeredGridLayoutManager$LazySpanLookup$FullSpanItemM3004f);
            }
            int size = this.f3725b.size();
            int i11 = 0;
            while (true) {
                if (i11 >= size) {
                    i11 = -1;
                    break;
                }
                if (((StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem) this.f3725b.get(i11)).f3496a >= i6) {
                    break;
                }
                i11++;
            }
            if (i11 != -1) {
                StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem staggeredGridLayoutManager$LazySpanLookup$FullSpanItem = (StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem) this.f3725b.get(i11);
                this.f3725b.remove(i11);
                i10 = staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.f3496a;
            } else {
                i10 = -1;
            }
        } else {
            i10 = -1;
        }
        if (i10 == -1) {
            int[] iArr2 = this.f3724a;
            Arrays.fill(iArr2, i6, iArr2.length, -1);
            return this.f3724a.length;
        }
        int iMin = Math.min(i10 + 1, this.f3724a.length);
        Arrays.fill(this.f3724a, i6, iMin, -1);
        return iMin;
    }

    public final void m3006h(int i6, int i10) {
        int[] iArr = this.f3724a;
        if (iArr == null || i6 >= iArr.length) {
            return;
        }
        int i11 = i6 + i10;
        m3001c(i11);
        int[] iArr2 = this.f3724a;
        System.arraycopy(iArr2, i6, iArr2, i11, (iArr2.length - i6) - i10);
        Arrays.fill(this.f3724a, i6, i11, -1);
        ArrayList arrayList = this.f3725b;
        if (arrayList == null) {
            return;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem staggeredGridLayoutManager$LazySpanLookup$FullSpanItem = (StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem) this.f3725b.get(size);
            int i12 = staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.f3496a;
            if (i12 >= i6) {
                staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.f3496a = i12 + i10;
            }
        }
    }

    public final void m3007i(int i6, int i10) {
        int[] iArr = this.f3724a;
        if (iArr == null || i6 >= iArr.length) {
            return;
        }
        int i11 = i6 + i10;
        m3001c(i11);
        int[] iArr2 = this.f3724a;
        System.arraycopy(iArr2, i11, iArr2, i6, (iArr2.length - i6) - i10);
        int[] iArr3 = this.f3724a;
        Arrays.fill(iArr3, iArr3.length - i10, iArr3.length, -1);
        ArrayList arrayList = this.f3725b;
        if (arrayList == null) {
            return;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem staggeredGridLayoutManager$LazySpanLookup$FullSpanItem = (StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem) this.f3725b.get(size);
            int i12 = staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.f3496a;
            if (i12 >= i6) {
                if (i12 < i11) {
                    this.f3725b.remove(size);
                } else {
                    staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.f3496a = i12 - i10;
                }
            }
        }
    }
}
