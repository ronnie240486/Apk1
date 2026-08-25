package p016b3;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bumptech.glide.EnumC1469g;
import com.bumptech.glide.load.data.InterfaceC1478d;
import com.bumptech.glide.load.data.InterfaceC1479e;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.ByteBuffer;

public final class C1283p implements InterfaceC1479e {

    public static final String[] f4044d = {"_data"};

    public final int f4045a;

    public final Object f4046b;

    public final Object f4047c;

    public C1283p(Object obj, int i6, Object obj2) {
        this.f4045a = i6;
        this.f4046b = obj;
        this.f4047c = obj2;
    }

    @Override
    public final Class mo3151a() {
        switch (this.f4045a) {
            case 0:
                return File.class;
            default:
                return ((C1263c) this.f4047c).m3146b();
        }
    }

    @Override
    public final void mo3152b() {
        int i6 = this.f4045a;
    }

    @Override
    public final void cancel() {
        int i6 = this.f4045a;
    }

    @Override
    public final int mo3153d() {
        switch (this.f4045a) {
        }
        return 1;
    }

    @Override
    public final void mo3154f(EnumC1469g enumC1469g, InterfaceC1478d interfaceC1478d) {
        Object objWrap;
        switch (this.f4045a) {
            case 0:
                Cursor cursorQuery = ((Context) this.f4046b).getContentResolver().query((Uri) this.f4047c, f4044d, null, null, null);
                String string = null;
                if (cursorQuery != null) {
                    try {
                        string = cursorQuery.moveToFirst() ? cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data")) : null;
                        cursorQuery.close();
                    } catch (Throwable th) {
                        cursorQuery.close();
                        throw th;
                    }
                    break;
                }
                if (!TextUtils.isEmpty(string)) {
                    interfaceC1478d.mo3173e(new File(string));
                    return;
                }
                interfaceC1478d.mo3172c(new FileNotFoundException("Failed to find file path for: " + ((Uri) this.f4047c)));
                return;
            default:
                C1263c c1263c = (C1263c) this.f4047c;
                byte[] bArr = (byte[]) this.f4046b;
                switch (c1263c.f3999a) {
                    case 0:
                        objWrap = ByteBuffer.wrap(bArr);
                        break;
                    default:
                        objWrap = new ByteArrayInputStream(bArr);
                        break;
                }
                interfaceC1478d.mo3173e(objWrap);
                return;
        }
    }

    private final void m3165c() {
    }

    private final void m3166e() {
    }

    private final void m3167g() {
    }

    private final void m3168h() {
    }
}
