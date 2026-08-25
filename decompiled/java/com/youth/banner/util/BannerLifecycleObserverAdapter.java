package com.youth.banner.util;

import androidx.lifecycle.EnumC0537n;
import androidx.lifecycle.InterfaceC0522f0;
import androidx.lifecycle.InterfaceC0553v;
import androidx.lifecycle.InterfaceC0555w;

public class BannerLifecycleObserverAdapter implements InterfaceC0553v {
    private final InterfaceC0555w mLifecycleOwner;
    private final BannerLifecycleObserver mObserver;

    public BannerLifecycleObserverAdapter(InterfaceC0555w interfaceC0555w, BannerLifecycleObserver bannerLifecycleObserver) {
        this.mLifecycleOwner = interfaceC0555w;
        this.mObserver = bannerLifecycleObserver;
    }

    @InterfaceC0522f0(EnumC0537n.ON_DESTROY)
    public void onDestroy() {
        LogUtils.m5065i("onDestroy");
        this.mObserver.onDestroy(this.mLifecycleOwner);
    }

    @InterfaceC0522f0(EnumC0537n.ON_START)
    public void onStart() {
        LogUtils.m5065i("onStart");
        this.mObserver.onStart(this.mLifecycleOwner);
    }

    @InterfaceC0522f0(EnumC0537n.ON_STOP)
    public void onStop() {
        LogUtils.m5065i("onStop");
        this.mObserver.onStop(this.mLifecycleOwner);
    }
}
