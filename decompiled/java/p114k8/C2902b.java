package p114k8;

import androidx.fragment.app.C0423q;
import com.bumptech.glide.AbstractC1465c;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

public final class C2902b extends RuntimeException {

    public final List f9856a;

    public final String f9857b;

    public Throwable f9858c;

    public C2902b(List list) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Throwable th = (Throwable) it.next();
                if (th instanceof C2902b) {
                    linkedHashSet.addAll(((C2902b) th).f9856a);
                } else if (th != null) {
                    linkedHashSet.add(th);
                } else {
                    linkedHashSet.add(new NullPointerException("Throwable was null!"));
                }
            }
        } else {
            linkedHashSet.add(new NullPointerException("errors was null"));
        }
        if (linkedHashSet.isEmpty()) {
            throw new IllegalArgumentException("errors is empty");
        }
        List listUnmodifiableList = Collections.unmodifiableList(new ArrayList(linkedHashSet));
        this.f9856a = listUnmodifiableList;
        this.f9857b = listUnmodifiableList.size() + " exceptions occurred. ";
    }

    public static void m5903a(AbstractC1465c abstractC1465c, Throwable th, String str) {
        abstractC1465c.mo3481a(str).mo3481a(th).mo3481a('\n');
        for (StackTraceElement stackTraceElement : th.getStackTrace()) {
            abstractC1465c.mo3481a("\t\tat ").mo3481a(stackTraceElement).mo3481a('\n');
        }
        if (th.getCause() != null) {
            abstractC1465c.mo3481a("\tCaused by: ");
            m5903a(abstractC1465c, th.getCause(), "");
        }
    }

    public final void m5904b(AbstractC1465c abstractC1465c) {
        abstractC1465c.mo3481a(this).mo3481a("\n");
        for (StackTraceElement stackTraceElement : getStackTrace()) {
            abstractC1465c.mo3481a("\tat ").mo3481a(stackTraceElement).mo3481a("\n");
        }
        int i6 = 1;
        for (Throwable th : this.f9856a) {
            abstractC1465c.mo3481a("  ComposedException ").mo3481a(Integer.valueOf(i6)).mo3481a(" :\n");
            m5903a(abstractC1465c, th, "\t");
            i6++;
        }
        abstractC1465c.mo3481a("\n");
    }

    @Override
    public final synchronized Throwable getCause() {
        int i6;
        try {
            if (this.f9858c == null) {
                String property = System.getProperty("line.separator");
                if (this.f9856a.size() > 1) {
                    IdentityHashMap identityHashMap = new IdentityHashMap();
                    StringBuilder sb = new StringBuilder();
                    sb.append("Multiple exceptions (");
                    sb.append(this.f9856a.size());
                    sb.append(")");
                    sb.append(property);
                    for (Throwable cause : this.f9856a) {
                        int i10 = 0;
                        while (cause != null) {
                            for (int i11 = 0; i11 < i10; i11++) {
                                sb.append("  ");
                            }
                            sb.append("|-- ");
                            sb.append(cause.getClass().getCanonicalName());
                            sb.append(": ");
                            String message = cause.getMessage();
                            if (message == null || !message.contains(property)) {
                                sb.append(message);
                                sb.append(property);
                            } else {
                                sb.append(property);
                                for (String str : message.split(property)) {
                                    for (int i12 = 0; i12 < i10 + 2; i12++) {
                                        sb.append("  ");
                                    }
                                    sb.append(str);
                                    sb.append(property);
                                }
                            }
                            int i13 = 0;
                            while (true) {
                                i6 = i10 + 2;
                                if (i13 >= i6) {
                                    break;
                                }
                                sb.append("  ");
                                i13++;
                            }
                            StackTraceElement[] stackTrace = cause.getStackTrace();
                            if (stackTrace.length > 0) {
                                sb.append("at ");
                                sb.append(stackTrace[0]);
                                sb.append(property);
                            }
                            if (identityHashMap.containsKey(cause)) {
                                Throwable cause2 = cause.getCause();
                                if (cause2 == null) {
                                    break;
                                }
                                for (int i14 = 0; i14 < i6; i14++) {
                                    sb.append("  ");
                                }
                                sb.append("|-- ");
                                sb.append("(cause not expanded again) ");
                                sb.append(cause2.getClass().getCanonicalName());
                                sb.append(": ");
                                sb.append(cause2.getMessage());
                                sb.append(property);
                                break;
                            }
                            identityHashMap.put(cause, Boolean.TRUE);
                            cause = cause.getCause();
                            i10++;
                        }
                    }
                    this.f9858c = new C0423q(sb.toString().trim(), 5);
                } else {
                    this.f9858c = (Throwable) this.f9856a.get(0);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f9858c;
    }

    @Override
    public final String getMessage() {
        return this.f9857b;
    }

    @Override
    public final void printStackTrace() {
        printStackTrace(System.err);
    }

    @Override
    public final void printStackTrace(PrintStream printStream) {
        m5904b(new C2901a(0, printStream));
    }

    @Override
    public final void printStackTrace(PrintWriter printWriter) {
        m5904b(new C2901a(1, printWriter));
    }
}
