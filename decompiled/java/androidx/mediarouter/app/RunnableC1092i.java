package androidx.mediarouter.app;

public final class RunnableC1092i implements Runnable {

    public final int f3250a;

    public final Object f3251b;

    public RunnableC1092i(int i6, Object obj) {
        this.f3250a = i6;
        this.f3251b = obj;
    }

    @Override
    public final void run() {
        switch (this.f3250a) {
            case 0:
                DialogC1116u dialogC1116u = (DialogC1116u) this.f3251b;
                dialogC1116u.m2793l(true);
                dialogC1116u.f3369D.requestLayout();
                dialogC1116u.f3369D.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserverOnGlobalLayoutListenerC1090h(dialogC1116u));
                break;
            default:
                DialogC1116u dialogC1116u2 = ((C1112s) this.f3251b).f3362b;
                if (dialogC1116u2.f3377L != null) {
                    dialogC1116u2.f3377L = null;
                    if (dialogC1116u2.f3393c0) {
                        dialogC1116u2.m2799s(dialogC1116u2.f3394d0);
                    }
                }
                break;
        }
    }
}
