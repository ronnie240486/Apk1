package androidx.appcompat.widget;

import p206t0.AbstractC3788b;

public final class RunnableC0258q2 implements Runnable {

    public final int f1038a;

    public final SearchView f1039b;

    public RunnableC0258q2(SearchView searchView, int i6) {
        this.f1038a = i6;
        this.f1039b = searchView;
    }

    @Override
    public final void run() {
        switch (this.f1038a) {
            case 0:
                this.f1039b.m599u();
                break;
            default:
                AbstractC3788b abstractC3788b = this.f1039b.f731O;
                if (abstractC3788b instanceof ViewOnClickListenerC0204f3) {
                    abstractC3788b.mo664b(null);
                }
                break;
        }
    }
}
