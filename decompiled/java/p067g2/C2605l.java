package p067g2;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import android.os.NetworkOnMainThreadException;
import android.webkit.MimeTypeMap;
import androidx.fragment.app.C0423q;
import com.bumptech.glide.AbstractC1466d;
import java.io.IOException;
import java.util.Map;
import okhttp3.CacheControl;
import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.FileSystem;
import okio.Okio;
import okio.Path;
import p001a0.C0019b;
import p008a9.InterfaceC0074d;
import p021b9.EnumC1367a;
import p030c9.AbstractC1433c;
import p036d2.C2144m;
import p036d2.C2147p;
import p036d2.EnumC2137f;
import p048e2.C2368c;
import p048e2.C2370e;
import p048e2.C2373h;
import p048e2.C2375j;
import p048e2.C2376k;
import p048e2.InterfaceC2367b;
import p103j9.AbstractC2796i;
import p120l2.AbstractC2967d;
import p120l2.C2966c;
import p120l2.C2968e;
import p120l2.C2969f;
import p123l5.AbstractC2973a;
import p130m2.C3065m;
import p130m2.EnumC3054b;
import p156o9.AbstractC3280d;
import p185r2.AbstractC3587f;
import p185r2.C3588g;
import p192r9.AbstractC3648f;
import p192r9.AbstractC3656n;
import p213t9.C3827e;
import p243w8.C4067i;
import p243w8.C4070l;

public final class C2605l implements InterfaceC2600g {

    public static final CacheControl f9068f = new CacheControl.Builder().noCache().noStore().build();

    public static final CacheControl f9069g = new CacheControl.Builder().noCache().onlyIfCached().build();

    public final String f9070a;

    public final C3065m f9071b;

    public final C4067i f9072c;

    public final C4067i f9073d;

    public final boolean f9074e;

    public C2605l(String str, C3065m c3065m, C4067i c4067i, C4067i c4067i2, boolean z7) {
        this.f9070a = str;
        this.f9071b = c3065m;
        this.f9072c = c4067i;
        this.f9073d = c4067i2;
        this.f9074e = z7;
    }

    public static String m5616d(String str, MediaType mediaType) {
        String strM7209b;
        String string = mediaType != null ? mediaType.toString() : null;
        if ((string == null || AbstractC3656n.m7404V(string, "text/plain", false)) && (strM7209b = AbstractC3587f.m7209b(MimeTypeMap.getSingleton(), str)) != null) {
            return strM7209b;
        }
        if (string == null) {
            return null;
        }
        int iM7380b0 = AbstractC3648f.m7380b0(string, ';', 0, false, 6);
        if (iM7380b0 == -1) {
            return string;
        }
        String strSubstring = string.substring(0, iM7380b0);
        AbstractC2796i.m5784e(strSubstring, "substring(...)");
        return strSubstring;
    }

    @Override
    public final Object mo5615a(InterfaceC0074d interfaceC0074d) throws Exception {
        C2604k c2604k;
        ?? r12;
        C2375j c2375j;
        C2969f c2969fM6007a;
        ?? r13;
        C2969f c2969f;
        C2966c c2966c;
        InterfaceC2367b interfaceC2367b;
        C2375j c2375j2;
        ?? r10;
        Response response;
        ?? r11;
        Response response2;
        ResponseBody responseBodyBody;
        if (interfaceC0074d instanceof C2604k) {
            c2604k = (C2604k) interfaceC0074d;
            int i6 = c2604k.f9067f;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                c2604k.f9067f = i6 - Integer.MIN_VALUE;
            } else {
                c2604k = new C2604k(this, (AbstractC1433c) interfaceC0074d);
            }
        } else {
            c2604k = new C2604k(this, (AbstractC1433c) interfaceC0074d);
        }
        Object objM5617b = c2604k.f9065d;
        EnumC1367a enumC1367a = EnumC1367a.f4179a;
        ?? r14 = c2604k.f9067f;
        EnumC2137f enumC2137f = EnumC2137f.f7763d;
        EnumC2137f enumC2137f2 = EnumC2137f.f7762c;
        try {
            if (r14 == 0) {
                AbstractC3280d.m6570I(objM5617b);
                C3065m c3065m = this.f9071b;
                boolean z7 = c3065m.f10509n.f10417a;
                String str = this.f9070a;
                if (!z7 || (interfaceC2367b = (InterfaceC2367b) this.f9073d.getValue()) == null) {
                    c2375j = null;
                } else {
                    String str2 = c3065m.f10504i;
                    if (str2 == null) {
                        str2 = str;
                    }
                    C2370e c2370eM5389c = ((C2376k) interfaceC2367b).f8324b.m5389c(ByteString.Companion.encodeUtf8(str2).sha256().hex());
                    if (c2370eM5389c != null) {
                        c2375j2 = new C2375j(c2370eM5389c);
                    } else {
                        c2375j = null;
                    }
                }
                if (c2375j != null) {
                    FileSystem fileSystemM5618c = m5618c();
                    C2370e c2370e = c2375j.f8322a;
                    if (c2370e.f8300b) {
                        c2375j = c2375j2;
                        throw new IllegalStateException("snapshot is closed");
                    }
                    Long size = fileSystemM5618c.metadata((Path) c2370e.f8299a.f8292c.get(0)).getSize();
                    if (size == null) {
                        c2375j = c2375j2;
                    } else if (size.longValue() == 0) {
                        c2375j = c2375j2;
                        return new C2606m(m5621g(c2375j), m5616d(str, null), enumC2137f2);
                    }
                    c2375j = c2375j2;
                    if (!this.f9074e) {
                        C2144m c2144mM5621g = m5621g(c2375j);
                        C2966c c2966cM5620f = m5620f(c2375j);
                        return new C2606m(c2144mM5621g, m5616d(str, c2966cM5620f != null ? (MediaType) c2966cM5620f.f10153b.getValue() : null), enumC2137f2);
                    }
                    c2969fM6007a = new C2968e(m5619e(), m5620f(c2375j)).m6007a();
                    if (c2969fM6007a.f10169a == null && (c2966c = c2969fM6007a.f10170b) != null) {
                        return new C2606m(m5621g(c2375j), m5616d(str, (MediaType) c2966c.f10153b.getValue()), enumC2137f2);
                    }
                } else {
                    c2375j = c2375j2;
                    c2969fM6007a = new C2968e(m5619e(), null).m6007a();
                }
                Request request = c2969fM6007a.f10169a;
                AbstractC2796i.m5782c(request);
                c2604k.f9062a = this;
                c2604k.f9063b = c2375j;
                c2604k.f9064c = c2969fM6007a;
                c2604k.f9067f = 1;
                Object objM5617b2 = m5617b(request, c2604k);
                if (objM5617b2 == enumC1367a) {
                    return enumC1367a;
                }
                r13 = this;
                c2969f = c2969fM6007a;
                objM5617b = objM5617b2;
                r10 = c2375j;
            } else {
                if (r14 != 1) {
                    if (r14 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    response = (Response) c2604k.f9064c;
                    C2375j c2375j3 = c2604k.f9063b;
                    C2605l c2605l = c2604k.f9062a;
                    try {
                        AbstractC3280d.m6570I(objM5617b);
                        r11 = c2605l;
                        response2 = (Response) objM5617b;
                        try {
                            Bitmap.Config[] configArr = AbstractC3587f.f12065a;
                            responseBodyBody = response2.body();
                            if (responseBodyBody != null) {
                                throw new IllegalStateException("response body == null");
                            }
                            r11.getClass();
                            BufferedSource bufferedSourceSource = responseBodyBody.source();
                            Context context = r11.f9071b.f10496a;
                            C2147p c2147p = new C2147p(bufferedSourceSource, null);
                            String strM5616d = m5616d(r11.f9070a, responseBodyBody.contentType());
                            if (response2.networkResponse() != null) {
                                enumC2137f = enumC2137f2;
                            }
                            return new C2606m(c2147p, strM5616d, enumC2137f);
                        } catch (Exception e5) {
                            e = e5;
                            response = response2;
                            AbstractC3587f.m7208a(response);
                            throw e;
                        }
                    } catch (Exception e10) {
                        e = e10;
                        AbstractC3587f.m7208a(response);
                        throw e;
                    }
                }
                C2969f c2969f2 = (C2969f) c2604k.f9064c;
                r12 = c2604k.f9063b;
                C2605l c2605l2 = c2604k.f9062a;
                try {
                    AbstractC3280d.m6570I(objM5617b);
                    c2969f = c2969f2;
                    r10 = r12;
                    r13 = c2605l2;
                } catch (Exception e11) {
                    e = e11;
                    if (r12 != 0) {
                        AbstractC3587f.m7208a(r12);
                    }
                    throw e;
                }
            }
            Response response3 = (Response) objM5617b;
            Bitmap.Config[] configArr2 = AbstractC3587f.f12065a;
            ResponseBody responseBodyBody2 = response3.body();
            if (responseBodyBody2 == null) {
                throw new IllegalStateException("response body == null");
            }
            try {
                C2375j c2375jM5622h = r13.m5622h(r10, c2969f.f10169a, response3, c2969f.f10170b);
                String str3 = r13.f9070a;
                if (c2375jM5622h != null) {
                    C2144m c2144mM5621g2 = r13.m5621g(c2375jM5622h);
                    C2966c c2966cM5620f2 = r13.m5620f(c2375jM5622h);
                    return new C2606m(c2144mM5621g2, m5616d(str3, c2966cM5620f2 != null ? (MediaType) c2966cM5620f2.f10153b.getValue() : null), enumC2137f);
                }
                if (responseBodyBody2.contentLength() > 0) {
                    BufferedSource bufferedSourceSource2 = responseBodyBody2.source();
                    Context context2 = r13.f9071b.f10496a;
                    C2147p c2147p2 = new C2147p(bufferedSourceSource2, null);
                    String strM5616d2 = m5616d(str3, responseBodyBody2.contentType());
                    if (response3.networkResponse() == null) {
                        enumC2137f = enumC2137f2;
                    }
                    return new C2606m(c2147p2, strM5616d2, enumC2137f);
                }
                AbstractC3587f.m7208a(response3);
                Request requestM5619e = r13.m5619e();
                c2604k.f9062a = r13;
                c2604k.f9063b = c2375jM5622h;
                c2604k.f9064c = response3;
                c2604k.f9067f = 2;
                objM5617b = r13.m5617b(requestM5619e, c2604k);
                if (objM5617b == enumC1367a) {
                    return enumC1367a;
                }
                r11 = r13;
                response = response3;
                response2 = (Response) objM5617b;
                Bitmap.Config[] configArr3 = AbstractC3587f.f12065a;
                responseBodyBody = response2.body();
                if (responseBodyBody != null) {
                    throw new IllegalStateException("response body == null");
                }
                r11.getClass();
                BufferedSource bufferedSourceSource3 = responseBodyBody.source();
                Context context3 = r11.f9071b.f10496a;
                C2147p c2147p3 = new C2147p(bufferedSourceSource3, null);
                String strM5616d3 = m5616d(r11.f9070a, responseBodyBody.contentType());
                if (response2.networkResponse() != null) {
                    enumC2137f = enumC2137f2;
                }
                return new C2606m(c2147p3, strM5616d3, enumC2137f);
            } catch (Exception e12) {
                e = e12;
                response = response3;
                AbstractC3587f.m7208a(response);
                throw e;
            }
        } catch (Exception e13) {
            e = e13;
            r12 = r14;
        }
    }

    public final Object m5617b(Request request, AbstractC1433c abstractC1433c) throws Throwable {
        C2603j c2603j;
        Response responseExecute;
        if (abstractC1433c instanceof C2603j) {
            c2603j = (C2603j) abstractC1433c;
            int i6 = c2603j.f9061c;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                c2603j.f9061c = i6 - Integer.MIN_VALUE;
            } else {
                c2603j = new C2603j(this, abstractC1433c);
            }
        } else {
            c2603j = new C2603j(this, abstractC1433c);
        }
        Object objM7657m = c2603j.f9059a;
        EnumC1367a enumC1367a = EnumC1367a.f4179a;
        int i10 = c2603j.f9061c;
        if (i10 == 0) {
            AbstractC3280d.m6570I(objM7657m);
            Bitmap.Config[] configArr = AbstractC3587f.f12065a;
            boolean zM5780a = AbstractC2796i.m5780a(Looper.myLooper(), Looper.getMainLooper());
            C4067i c4067i = this.f9072c;
            if (!zM5780a) {
                Call callNewCall = ((Call.Factory) c4067i.getValue()).newCall(request);
                c2603j.f9061c = 1;
                C3827e c3827e = new C3827e(AbstractC1466d.m3499r(c2603j), 1);
                c3827e.m7658n();
                C3588g c3588g = new C3588g(callNewCall, c3827e);
                callNewCall.enqueue(c3588g);
                c3827e.m7660p(c3588g);
                objM7657m = c3827e.m7657m();
                if (objM7657m == enumC1367a) {
                    return enumC1367a;
                }
            } else {
                if (this.f9071b.f10510o.f10417a) {
                    throw new NetworkOnMainThreadException();
                }
                responseExecute = ((Call.Factory) c4067i.getValue()).newCall(request).execute();
            }
            if (!responseExecute.isSuccessful() || responseExecute.code() == 304) {
                return responseExecute;
            }
            ResponseBody responseBodyBody = responseExecute.body();
            if (responseBodyBody != null) {
                AbstractC3587f.m7208a(responseBodyBody);
            }
            throw new C0423q("HTTP " + responseExecute.code() + ": " + responseExecute.message(), 6);
        }
        if (i10 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        AbstractC3280d.m6570I(objM7657m);
        responseExecute = (Response) objM7657m;
        if (responseExecute.isSuccessful()) {
        }
        return responseExecute;
    }

    public final FileSystem m5618c() {
        Object value = this.f9073d.getValue();
        AbstractC2796i.m5782c(value);
        return ((C2376k) ((InterfaceC2367b) value)).f8323a;
    }

    public final Request m5619e() {
        Request.Builder builderUrl = new Request.Builder().url(this.f9070a);
        C3065m c3065m = this.f9071b;
        Request.Builder builderHeaders = builderUrl.headers(c3065m.f10505j);
        for (Map.Entry entry : c3065m.f10506k.f10522a.entrySet()) {
            Object key = entry.getKey();
            AbstractC2796i.m5783d(key, "null cannot be cast to non-null type java.lang.Class<kotlin.Any>");
            builderHeaders.tag((Class) key, entry.getValue());
        }
        EnumC3054b enumC3054b = c3065m.f10509n;
        boolean z7 = enumC3054b.f10417a;
        boolean z10 = c3065m.f10510o.f10417a;
        if (!z10 && z7) {
            builderHeaders.cacheControl(CacheControl.FORCE_CACHE);
        } else if (!z10 || z7) {
            if (!z10 && !z7) {
                builderHeaders.cacheControl(f9069g);
            }
        } else if (enumC3054b.f10418b) {
            builderHeaders.cacheControl(CacheControl.FORCE_NETWORK);
        } else {
            builderHeaders.cacheControl(f9068f);
        }
        return builderHeaders.build();
    }

    public final C2966c m5620f(C2375j c2375j) throws Throwable {
        Throwable th;
        C2966c c2966c;
        try {
            FileSystem fileSystemM5618c = m5618c();
            C2370e c2370e = c2375j.f8322a;
            if (c2370e.f8300b) {
                throw new IllegalStateException("snapshot is closed");
            }
            BufferedSource bufferedSourceBuffer = Okio.buffer(fileSystemM5618c.source((Path) c2370e.f8299a.f8292c.get(0)));
            try {
                c2966c = new C2966c(bufferedSourceBuffer);
                try {
                    bufferedSourceBuffer.close();
                    th = null;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                if (bufferedSourceBuffer != null) {
                    try {
                        bufferedSourceBuffer.close();
                    } catch (Throwable th4) {
                        AbstractC2973a.m6013a(th3, th4);
                    }
                }
                th = th3;
                c2966c = null;
            }
            if (th != null) {
                throw th;
            }
            AbstractC2796i.m5782c(c2966c);
            return c2966c;
        } catch (IOException unused) {
            return null;
        }
    }

    public final C2144m m5621g(C2375j c2375j) {
        C2370e c2370e = c2375j.f8322a;
        if (c2370e.f8300b) {
            throw new IllegalStateException("snapshot is closed");
        }
        Path path = (Path) c2370e.f8299a.f8292c.get(1);
        FileSystem fileSystemM5618c = m5618c();
        String str = this.f9071b.f10504i;
        if (str == null) {
            str = this.f9070a;
        }
        return new C2144m(path, fileSystemM5618c, str, c2375j);
    }

    public final C2375j m5622h(C2375j c2375j, Request request, Response response, C2966c c2966c) {
        C0019b c0019b;
        Throwable th;
        C4070l c4070l;
        Long lValueOf;
        C4070l c4070l2;
        C2368c c2368cM5388b;
        Throwable th2 = null;
        if (!this.f9071b.f10509n.f10418b || (this.f9074e && (request.cacheControl().noStore() || response.cacheControl().noStore() || AbstractC2796i.m5780a(response.headers().get("Vary"), "*")))) {
            if (c2375j != null) {
                AbstractC3587f.m7208a(c2375j);
            }
            return null;
        }
        if (c2375j != null) {
            C2370e c2370e = c2375j.f8322a;
            C2373h c2373h = c2370e.f8301c;
            synchronized (c2373h) {
                c2370e.close();
                c2368cM5388b = c2373h.m5388b(c2370e.f8299a.f8290a);
            }
            if (c2368cM5388b != null) {
                c0019b = new C0019b(26, c2368cM5388b);
            } else {
                c0019b = null;
            }
        } else {
            InterfaceC2367b interfaceC2367b = (InterfaceC2367b) this.f9073d.getValue();
            if (interfaceC2367b == null) {
                c0019b = null;
            } else {
                String str = this.f9071b.f10504i;
                if (str == null) {
                    str = this.f9070a;
                }
                C2368c c2368cM5388b2 = ((C2376k) interfaceC2367b).f8324b.m5388b(ByteString.Companion.encodeUtf8(str).sha256().hex());
                if (c2368cM5388b2 != null) {
                    c0019b = new C0019b(26, c2368cM5388b2);
                } else {
                    c0019b = null;
                }
            }
        }
        if (c0019b == null) {
            return null;
        }
        try {
            try {
                if (response.code() != 304 || c2966c == null) {
                    BufferedSink bufferedSinkBuffer = Okio.buffer(m5618c().sink(((C2368c) c0019b.f38b).m5383e(0), false));
                    try {
                        new C2966c(response).m6004a(bufferedSinkBuffer);
                        c4070l = C4070l.f13734a;
                        try {
                            bufferedSinkBuffer.close();
                            th = null;
                        } catch (Throwable th3) {
                            th = th3;
                        }
                    } catch (Throwable th4) {
                        if (bufferedSinkBuffer != null) {
                            try {
                                bufferedSinkBuffer.close();
                            } catch (Throwable th5) {
                                AbstractC2973a.m6013a(th4, th5);
                            }
                        }
                        th = th4;
                        c4070l = null;
                    }
                    if (th != null) {
                        throw th;
                    }
                    AbstractC2796i.m5782c(c4070l);
                    BufferedSink bufferedSinkBuffer2 = Okio.buffer(m5618c().sink(((C2368c) c0019b.f38b).m5383e(1), false));
                    try {
                        ResponseBody responseBodyBody = response.body();
                        AbstractC2796i.m5782c(responseBodyBody);
                        lValueOf = Long.valueOf(responseBodyBody.source().readAll(bufferedSinkBuffer2));
                        if (bufferedSinkBuffer2 != null) {
                            try {
                                bufferedSinkBuffer2.close();
                            } catch (Throwable th6) {
                                th2 = th6;
                            }
                        }
                    } catch (Throwable th7) {
                        if (bufferedSinkBuffer2 != null) {
                            try {
                                bufferedSinkBuffer2.close();
                            } catch (Throwable th8) {
                                AbstractC2973a.m6013a(th7, th8);
                            }
                        }
                        th2 = th7;
                        lValueOf = null;
                    }
                    if (th2 != null) {
                        throw th2;
                    }
                    AbstractC2796i.m5782c(lValueOf);
                } else {
                    Response responseBuild = response.newBuilder().headers(AbstractC2967d.m6005a(c2966c.f10157f, response.headers())).build();
                    BufferedSink bufferedSinkBuffer3 = Okio.buffer(m5618c().sink(((C2368c) c0019b.f38b).m5383e(0), false));
                    try {
                        new C2966c(responseBuild).m6004a(bufferedSinkBuffer3);
                        c4070l2 = C4070l.f13734a;
                        try {
                            bufferedSinkBuffer3.close();
                        } catch (Throwable th9) {
                            th2 = th9;
                        }
                    } catch (Throwable th10) {
                        if (bufferedSinkBuffer3 != null) {
                            try {
                                bufferedSinkBuffer3.close();
                            } catch (Throwable th11) {
                                AbstractC2973a.m6013a(th10, th11);
                            }
                        }
                        th2 = th10;
                        c4070l2 = null;
                    }
                    if (th2 != null) {
                        throw th2;
                    }
                    AbstractC2796i.m5782c(c4070l2);
                }
                C2375j c2375jM100q = c0019b.m100q();
                AbstractC3587f.m7208a(response);
                return c2375jM100q;
            } catch (Exception e5) {
                Bitmap.Config[] configArr = AbstractC3587f.f12065a;
                try {
                    ((C2368c) c0019b.f38b).m5382d(false);
                } catch (Exception unused) {
                }
                throw e5;
            }
        } catch (Throwable th12) {
            AbstractC3587f.m7208a(response);
            throw th12;
        }
    }
}
