package androidx.recyclerview.widget;

public final class C1162l1 {

    public int f3615a;

    public int f3616b;

    public int f3617c;

    public int f3618d;

    public int f3619e;

    public boolean f3620f;

    public boolean f3621g;

    public boolean f3622h;

    public boolean f3623i;

    public boolean f3624j;

    public boolean f3625k;

    public int f3626l;

    public long f3627m;

    public int f3628n;

    public int f3629o;

    public int f3630p;

    public final void m2969a(int i6) {
        if ((this.f3618d & i6) != 0) {
            return;
        }
        throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i6) + " but it is " + Integer.toBinaryString(this.f3618d));
    }

    public final int m2970b() {
        return this.f3621g ? this.f3616b - this.f3617c : this.f3619e;
    }

    public final String toString() {
        return "State{mTargetPosition=" + this.f3615a + ", mData=null, mItemCount=" + this.f3619e + ", mIsMeasuring=" + this.f3623i + ", mPreviousLayoutItemCount=" + this.f3616b + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.f3617c + ", mStructureChanged=" + this.f3620f + ", mInPreLayout=" + this.f3621g + ", mRunSimpleAnimations=" + this.f3624j + ", mRunPredictiveAnimations=" + this.f3625k + '}';
    }
}
