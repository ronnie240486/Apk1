package com.google.common.util.concurrent;

import p020b7.InterfaceC1339e0;

public final class C1958b implements InterfaceC1339e0 {

    public final int f6964a;

    public final AbstractService f6965b;

    public C1958b(AbstractService abstractService, int i6) {
        this.f6964a = i6;
        this.f6965b = abstractService;
    }

    @Override
    public final Object get() {
        switch (this.f6964a) {
            case 0:
                return ((AbstractExecutionThreadService.C18941) this.f6965b).lambda$doStart$0();
            default:
                return ((AbstractScheduledService.ServiceDelegate) this.f6965b).lambda$doStart$0();
        }
    }
}
