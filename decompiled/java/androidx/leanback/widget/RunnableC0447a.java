package androidx.leanback.widget;

public final class RunnableC0447a implements Runnable {

    public final int f2307a;

    public final Object f2308b;

    public RunnableC0447a(int i6, Object obj) {
        this.f2307a = i6;
        this.f2308b = obj;
    }

    @Override
    public final void run() {
        switch (this.f2307a) {
            case 0:
                ((BaseCardView) this.f2308b).m1346a(true);
                break;
            case 1:
                ((GridLayoutManager) this.f2308b).requestLayout();
                break;
            case 2:
                SearchBar searchBar = ((C0493r0) this.f2308b).f2433a;
                searchBar.f2233j = true;
                searchBar.f2225b.requestFocus();
                break;
            default:
                InterfaceC0503w0 interfaceC0503w0 = ((SearchEditText) this.f2308b).f2247h;
                if (interfaceC0503w0 != null) {
                    ((SearchBar) ((C0490q) interfaceC0503w0).f2429a).getClass();
                }
                break;
        }
    }
}
