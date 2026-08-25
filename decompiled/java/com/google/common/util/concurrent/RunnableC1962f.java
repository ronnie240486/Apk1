package com.google.common.util.concurrent;

public final class RunnableC1962f implements Runnable {

    public final int f6970a;

    public final AbstractScheduledService.ServiceDelegate f6971b;

    public RunnableC1962f(AbstractScheduledService.ServiceDelegate serviceDelegate, int i6) {
        this.f6970a = i6;
        this.f6971b = serviceDelegate;
    }

    @Override
    public final void run() {
        switch (this.f6970a) {
            case 0:
                this.f6971b.lambda$doStart$1();
                break;
            default:
                this.f6971b.lambda$doStop$2();
                break;
        }
    }
}
