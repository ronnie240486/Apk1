package p207t1;

import android.content.res.AssetManager;
import android.os.Build;
import androidx.media3.common.util.RunnableC0619d;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.concurrent.Executor;

public final class C3789a {

    public final Executor f12757a;

    public final InterfaceC3791c f12758b;

    public final byte[] f12759c;

    public final File f12760d;

    public final String f12761e;

    public boolean f12762f = false;

    public C3790b[] f12763g;

    public byte[] f12764h;

    public C3789a(AssetManager assetManager, Executor executor, InterfaceC3791c interfaceC3791c, String str, File file) {
        this.f12757a = executor;
        this.f12758b = interfaceC3791c;
        this.f12761e = str;
        this.f12760d = file;
        int i6 = Build.VERSION.SDK_INT;
        byte[] bArr = null;
        if (i6 >= 24 && i6 <= 34) {
            switch (i6) {
                case 24:
                case 25:
                    bArr = AbstractC3792d.f12781h;
                    break;
                case 26:
                    bArr = AbstractC3792d.f12780g;
                    break;
                case 27:
                    bArr = AbstractC3792d.f12779f;
                    break;
                case 28:
                case 29:
                case 30:
                    bArr = AbstractC3792d.f12778e;
                    break;
                case 31:
                case 32:
                case 33:
                case 34:
                    bArr = AbstractC3792d.f12777d;
                    break;
            }
        }
        this.f12759c = bArr;
    }

    public final FileInputStream m7540a(AssetManager assetManager, String str) {
        try {
            return assetManager.openFd(str).createInputStream();
        } catch (FileNotFoundException e5) {
            String message = e5.getMessage();
            if (message != null && message.contains("compressed")) {
                this.f12758b.mo6883i();
            }
            return null;
        }
    }

    public final void m7541b(int i6, Serializable serializable) {
        this.f12757a.execute(new RunnableC0619d(this, i6, serializable, 2));
    }
}
