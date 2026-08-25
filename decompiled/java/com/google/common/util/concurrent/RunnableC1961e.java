package com.google.common.util.concurrent;

public final class RunnableC1961e implements Runnable {

    public final int f6968a;

    public final AbstractIdleService.DelegateService f6969b;

    public RunnableC1961e(AbstractIdleService.DelegateService delegateService, int i6) {
        this.f6968a = i6;
        this.f6969b = delegateService;
    }

    @Override
    public final void run() {
        switch (this.f6968a) {
            case 0:
                this.f6969b.lambda$doStop$1();
                break;
            default:
                this.f6969b.lambda$doStart$0();
                break;
        }
    }
}
