package androidx.media3.p011ui;

public final class RunnableC1061f implements Runnable {

    public final int f3127a;

    public final PlayerControlViewLayoutManager f3128b;

    public RunnableC1061f(PlayerControlViewLayoutManager playerControlViewLayoutManager, int i6) {
        this.f3127a = i6;
        this.f3128b = playerControlViewLayoutManager;
    }

    @Override
    public final void run() {
        switch (this.f3127a) {
            case 0:
                this.f3128b.updateLayoutForSizeChange();
                break;
            case 1:
                this.f3128b.onLayoutWidthChanged();
                break;
            case 2:
                this.f3128b.showAllBars();
                break;
            case 3:
                this.f3128b.hideAllBars();
                break;
            case 4:
                this.f3128b.hideProgressBar();
                break;
            case 5:
                this.f3128b.hideMainBar();
                break;
            default:
                this.f3128b.hideController();
                break;
        }
    }
}
