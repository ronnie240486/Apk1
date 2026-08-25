package p247x2;

import android.util.Log;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import p055ea.AbstractC2460q;
import p228v2.InterfaceC3978e;

public final class C4098t extends Exception {

    public static final StackTraceElement[] f13888f = new StackTraceElement[0];

    public final List f13889a;

    public InterfaceC3978e f13890b;

    public int f13891c;

    public Class f13892d;

    public final String f13893e;

    public C4098t(String str) {
        this(str, Collections.emptyList());
    }

    public static void m8116a(Throwable th, ArrayList arrayList) {
        if (!(th instanceof C4098t)) {
            arrayList.add(th);
            return;
        }
        Iterator it = ((C4098t) th).f13889a.iterator();
        while (it.hasNext()) {
            m8116a((Throwable) it.next(), arrayList);
        }
    }

    public static void m8117b(List list, C4097s c4097s) throws IOException {
        int size = list.size();
        int i6 = 0;
        while (i6 < size) {
            c4097s.append("Cause (");
            int i10 = i6 + 1;
            c4097s.append(String.valueOf(i10));
            c4097s.append(" of ");
            c4097s.append(String.valueOf(size));
            c4097s.append("): ");
            Throwable th = (Throwable) list.get(i6);
            if (th instanceof C4098t) {
                ((C4098t) th).m8120e(c4097s);
            } else {
                m8118c(th, c4097s);
            }
            i6 = i10;
        }
    }

    public static void m8118c(Throwable th, Appendable appendable) {
        try {
            appendable.append(th.getClass().toString()).append(": ").append(th.getMessage()).append('\n');
        } catch (IOException unused) {
            throw new RuntimeException(th);
        }
    }

    public final void m8119d() {
        ArrayList arrayList = new ArrayList();
        m8116a(this, arrayList);
        int size = arrayList.size();
        int i6 = 0;
        while (i6 < size) {
            StringBuilder sb = new StringBuilder("Root cause (");
            int i10 = i6 + 1;
            sb.append(i10);
            sb.append(" of ");
            sb.append(size);
            sb.append(")");
            Log.i("Glide", sb.toString(), (Throwable) arrayList.get(i6));
            i6 = i10;
        }
    }

    public final void m8120e(Appendable appendable) {
        m8118c(this, appendable);
        try {
            m8117b(this.f13889a, new C4097s(appendable));
        } catch (IOException e5) {
            throw new RuntimeException(e5);
        }
    }

    @Override
    public final String getMessage() {
        StringBuilder sb = new StringBuilder(71);
        sb.append(this.f13893e);
        sb.append(this.f13892d != null ? ", " + this.f13892d : "");
        int i6 = this.f13891c;
        sb.append(i6 != 0 ? ", ".concat(AbstractC2460q.m5504r(i6)) : "");
        sb.append(this.f13890b != null ? ", " + this.f13890b : "");
        ArrayList<Throwable> arrayList = new ArrayList();
        m8116a(this, arrayList);
        if (arrayList.isEmpty()) {
            return sb.toString();
        }
        if (arrayList.size() == 1) {
            sb.append("\nThere was 1 root cause:");
        } else {
            sb.append("\nThere were ");
            sb.append(arrayList.size());
            sb.append(" root causes:");
        }
        for (Throwable th : arrayList) {
            sb.append('\n');
            sb.append(th.getClass().getName());
            sb.append('(');
            sb.append(th.getMessage());
            sb.append(')');
        }
        sb.append("\n call GlideException#logRootCauses(String) for more detail");
        return sb.toString();
    }

    @Override
    public final void printStackTrace() {
        m8120e(System.err);
    }

    public C4098t(String str, List list) {
        this.f13893e = str;
        setStackTrace(f13888f);
        this.f13889a = list;
    }

    @Override
    public final void printStackTrace(PrintStream printStream) {
        m8120e(printStream);
    }

    @Override
    public final void printStackTrace(PrintWriter printWriter) {
        m8120e(printWriter);
    }

    @Override
    public final Throwable fillInStackTrace() {
        return this;
    }
}
