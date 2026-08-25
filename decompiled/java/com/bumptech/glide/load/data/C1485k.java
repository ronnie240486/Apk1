package com.bumptech.glide.load.data;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import java.io.IOException;
import java.io.InputStream;

public final class C1485k extends AbstractC1476b {

    public final int f4489e;

    public C1485k(AssetManager assetManager, String str, int i6) {
        super(0, str, assetManager);
        this.f4489e = i6;
    }

    @Override
    public final Class mo3151a() {
        switch (this.f4489e) {
            case 0:
                return AssetFileDescriptor.class;
            default:
                return InputStream.class;
        }
    }

    @Override
    public final void mo3543g(Object obj) throws IOException {
        switch (this.f4489e) {
            case 0:
                ((AssetFileDescriptor) obj).close();
                break;
            default:
                ((InputStream) obj).close();
                break;
        }
    }

    @Override
    public final Object mo3547h(AssetManager assetManager, String str) {
        switch (this.f4489e) {
            case 0:
                return assetManager.openFd(str);
            default:
                return assetManager.open(str);
        }
    }
}
