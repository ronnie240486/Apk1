package com.google.android.material.datepicker;

public final class RunnableC1795l implements Runnable {

    public final int f6185a;

    public final C1801r f6186b;

    public RunnableC1795l(C1801r c1801r, int i6) {
        this.f6186b = c1801r;
        this.f6185a = i6;
    }

    @Override
    public final void run() {
        this.f6186b.f6206c0.smoothScrollToPosition(this.f6185a);
    }
}
