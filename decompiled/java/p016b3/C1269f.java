package p016b3;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.ComponentCallbacks2C1464b;
import com.bumptech.glide.EnumC1469g;
import com.bumptech.glide.load.data.C1484j;
import com.bumptech.glide.load.data.InterfaceC1478d;
import com.bumptech.glide.load.data.InterfaceC1479e;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import p222u7.AbstractC3928d;
import p239w2.C4050c;
import p239w2.InterfaceC4049b;

public final class C1269f implements InterfaceC1479e {

    public final int f4010a;

    public final Comparable f4011b;

    public final Object f4012c;

    public Object f4013d;

    public C1269f(int i6, Comparable comparable, Object obj) {
        this.f4010a = i6;
        this.f4011b = comparable;
        this.f4012c = obj;
    }

    public static C1269f m3155c(Context context, Uri uri, InterfaceC4049b interfaceC4049b) {
        return new C1269f(2, uri, new C4050c(ComponentCallbacks2C1464b.m3461a(context).f4408c.m3518b().m3526f(), interfaceC4049b, ComponentCallbacks2C1464b.m3461a(context).f4409d, context.getContentResolver()));
    }

    @Override
    public final Class mo3151a() {
        switch (this.f4010a) {
            case 0:
                ((C1263c) this.f4012c).getClass();
                return InputStream.class;
            case 1:
                return ((C1263c) this.f4012c).m3146b();
            default:
                return InputStream.class;
        }
    }

    @Override
    public final void mo3152b() {
        switch (this.f4010a) {
            case 0:
                try {
                    ((ByteArrayInputStream) this.f4013d).close();
                } catch (IOException unused) {
                    return;
                }
                break;
            case 1:
                Object obj = this.f4013d;
                if (obj != null) {
                    try {
                        switch (((C1263c) this.f4012c).f3999a) {
                            case 4:
                                ((ParcelFileDescriptor) obj).close();
                                break;
                            default:
                                ((InputStream) obj).close();
                                break;
                        }
                    } catch (IOException unused2) {
                        return;
                    }
                }
                break;
            default:
                InputStream inputStream = (InputStream) this.f4013d;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused3) {
                        return;
                    }
                }
                break;
        }
    }

    @Override
    public final void cancel() {
        int i6 = this.f4010a;
    }

    @Override
    public final int mo3153d() {
        switch (this.f4010a) {
        }
        return 1;
    }

    @Override
    public final void mo3154f(EnumC1469g enumC1469g, InterfaceC1478d interfaceC1478d) throws Throwable {
        Object objOpen;
        switch (this.f4010a) {
            case 0:
                try {
                    ByteArrayInputStream byteArrayInputStreamM3145a = C1263c.m3145a((String) this.f4011b);
                    this.f4013d = byteArrayInputStreamM3145a;
                    interfaceC1478d.mo3173e(byteArrayInputStreamM3145a);
                } catch (IllegalArgumentException e5) {
                    interfaceC1478d.mo3172c(e5);
                }
                break;
            case 1:
                try {
                    C1263c c1263c = (C1263c) this.f4012c;
                    File file = (File) this.f4011b;
                    switch (c1263c.f3999a) {
                        case 4:
                            objOpen = ParcelFileDescriptor.open(file, 268435456);
                            break;
                        default:
                            objOpen = new FileInputStream(file);
                            break;
                    }
                    this.f4013d = objOpen;
                    interfaceC1478d.mo3173e(objOpen);
                } catch (FileNotFoundException e10) {
                    if (Log.isLoggable("FileLoader", 3)) {
                        Log.d("FileLoader", "Failed to open file", e10);
                    }
                    interfaceC1478d.mo3172c(e10);
                    return;
                }
                break;
            default:
                try {
                    InputStream inputStreamM3159i = m3159i();
                    this.f4013d = inputStreamM3159i;
                    interfaceC1478d.mo3173e(inputStreamM3159i);
                } catch (FileNotFoundException e11) {
                    if (Log.isLoggable("MediaStoreThumbFetcher", 3)) {
                        Log.d("MediaStoreThumbFetcher", "Failed to find thumbnail file", e11);
                    }
                    interfaceC1478d.mo3172c(e11);
                    return;
                }
                break;
        }
    }

    public InputStream m3159i() throws Throwable {
        Cursor cursorMo8053a;
        ?? r10;
        String string;
        boolean zIsEmpty;
        ContentResolver contentResolver;
        File file;
        InputStream inputStreamOpenInputStream;
        int iM7850n;
        Uri uri = (Uri) this.f4011b;
        C4050c c4050c = (C4050c) this.f4012c;
        ?? r11 = 0;
        InputStream inputStreamOpenInputStream2 = null;
        try {
            try {
                cursorMo8053a = c4050c.f13712a.mo8053a(uri);
                if (cursorMo8053a != null) {
                    try {
                        if (cursorMo8053a.moveToFirst()) {
                            string = cursorMo8053a.getString(0);
                            cursorMo8053a.close();
                        }
                    } catch (SecurityException e5) {
                        e = e5;
                        if (Log.isLoggable("ThumbStreamOpener", 3)) {
                            Log.d("ThumbStreamOpener", "Failed to query for thumbnail for Uri: " + uri, e);
                        }
                        if (cursorMo8053a != null) {
                        }
                        string = null;
                        zIsEmpty = TextUtils.isEmpty(string);
                        contentResolver = c4050c.f13714c;
                        if (zIsEmpty) {
                            inputStreamOpenInputStream = null;
                        } else {
                            file = new File(string);
                            if (file.exists()) {
                                inputStreamOpenInputStream = null;
                            } else {
                                inputStreamOpenInputStream = null;
                            }
                        }
                        if (inputStreamOpenInputStream != null) {
                            try {
                                try {
                                    inputStreamOpenInputStream2 = contentResolver.openInputStream(uri);
                                    iM7850n = AbstractC3928d.m7850n(c4050c.f13715d, inputStreamOpenInputStream2, c4050c.f13713b);
                                    if (inputStreamOpenInputStream2 != null) {
                                        try {
                                            inputStreamOpenInputStream2.close();
                                        } catch (IOException unused) {
                                        }
                                    }
                                } catch (Throwable th) {
                                    if (0 != 0) {
                                        try {
                                            r11.close();
                                        } catch (IOException unused2) {
                                        }
                                    }
                                    throw th;
                                }
                            } catch (IOException | NullPointerException e10) {
                                if (Log.isLoggable("ThumbStreamOpener", 3)) {
                                    Log.d("ThumbStreamOpener", "Failed to open uri: " + uri, e10);
                                }
                                if (inputStreamOpenInputStream2 != null) {
                                    try {
                                        inputStreamOpenInputStream2.close();
                                    } catch (IOException unused3) {
                                    }
                                }
                                iM7850n = -1;
                            }
                        } else {
                            iM7850n = -1;
                        }
                        if (iM7850n != -1) {
                            return new C1484j(inputStreamOpenInputStream, iM7850n);
                        }
                        return inputStreamOpenInputStream;
                    }
                    zIsEmpty = TextUtils.isEmpty(string);
                    contentResolver = c4050c.f13714c;
                    if (zIsEmpty) {
                        inputStreamOpenInputStream = null;
                    } else {
                        file = new File(string);
                        if (file.exists() || 0 >= file.length()) {
                            inputStreamOpenInputStream = null;
                        } else {
                            Uri uriFromFile = Uri.fromFile(file);
                            try {
                                inputStreamOpenInputStream = contentResolver.openInputStream(uriFromFile);
                            } catch (NullPointerException e11) {
                                throw ((FileNotFoundException) new FileNotFoundException("NPE opening uri: " + uri + " -> " + uriFromFile).initCause(e11));
                            }
                        }
                    }
                    if (inputStreamOpenInputStream != null) {
                        inputStreamOpenInputStream2 = contentResolver.openInputStream(uri);
                        iM7850n = AbstractC3928d.m7850n(c4050c.f13715d, inputStreamOpenInputStream2, c4050c.f13713b);
                        if (inputStreamOpenInputStream2 != null) {
                            inputStreamOpenInputStream2.close();
                        }
                    } else {
                        iM7850n = -1;
                    }
                    if (iM7850n != -1) {
                        return new C1484j(inputStreamOpenInputStream, iM7850n);
                    }
                    return inputStreamOpenInputStream;
                }
                if (cursorMo8053a != null) {
                    cursorMo8053a.close();
                }
            } catch (Throwable th2) {
                th = th2;
                r11 = r10;
                if (r11 != 0) {
                    r11.close();
                }
                throw th;
            }
        } catch (SecurityException e12) {
            e = e12;
            cursorMo8053a = null;
        } catch (Throwable th3) {
            th = th3;
            if (r11 != 0) {
                r11.close();
            }
            throw th;
        }
        string = null;
        zIsEmpty = TextUtils.isEmpty(string);
        contentResolver = c4050c.f13714c;
        if (zIsEmpty) {
            inputStreamOpenInputStream = null;
        } else {
            file = new File(string);
            if (file.exists()) {
                inputStreamOpenInputStream = null;
            } else {
                inputStreamOpenInputStream = null;
            }
        }
        if (inputStreamOpenInputStream != null) {
            inputStreamOpenInputStream2 = contentResolver.openInputStream(uri);
            iM7850n = AbstractC3928d.m7850n(c4050c.f13715d, inputStreamOpenInputStream2, c4050c.f13713b);
            if (inputStreamOpenInputStream2 != null) {
                inputStreamOpenInputStream2.close();
            }
        } else {
            iM7850n = -1;
        }
        if (iM7850n != -1) {
            return new C1484j(inputStreamOpenInputStream, iM7850n);
        }
        return inputStreamOpenInputStream;
    }

    private final void m3156e() {
    }

    private final void m3157g() {
    }

    private final void m3158h() {
    }
}
