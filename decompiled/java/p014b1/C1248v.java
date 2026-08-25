package p014b1;

import android.os.Build;
import android.text.Spannable;
import android.text.SpannableString;
import java.util.stream.IntStream;
import p221u6.C3905e;

public final class C1248v implements Spannable {

    public boolean f3968a = false;

    public Spannable f3969b;

    public C1248v(Spannable spannable) {
        this.f3969b = spannable;
    }

    public final void m3130a() {
        Spannable spannable = this.f3969b;
        if (!this.f3968a) {
            if ((Build.VERSION.SDK_INT < 28 ? new C3905e(4) : new C1247u(4)).mo3129h(spannable)) {
                this.f3969b = new SpannableString(spannable);
            }
        }
        this.f3968a = true;
    }

    @Override
    public final char charAt(int i6) {
        return this.f3969b.charAt(i6);
    }

    @Override
    public final IntStream chars() {
        return this.f3969b.chars();
    }

    @Override
    public final IntStream codePoints() {
        return this.f3969b.codePoints();
    }

    @Override
    public final int getSpanEnd(Object obj) {
        return this.f3969b.getSpanEnd(obj);
    }

    @Override
    public final int getSpanFlags(Object obj) {
        return this.f3969b.getSpanFlags(obj);
    }

    @Override
    public final int getSpanStart(Object obj) {
        return this.f3969b.getSpanStart(obj);
    }

    @Override
    public final Object[] getSpans(int i6, int i10, Class cls) {
        return this.f3969b.getSpans(i6, i10, cls);
    }

    @Override
    public final int length() {
        return this.f3969b.length();
    }

    @Override
    public final int nextSpanTransition(int i6, int i10, Class cls) {
        return this.f3969b.nextSpanTransition(i6, i10, cls);
    }

    @Override
    public final void removeSpan(Object obj) {
        m3130a();
        this.f3969b.removeSpan(obj);
    }

    @Override
    public final void setSpan(Object obj, int i6, int i10, int i11) {
        m3130a();
        this.f3969b.setSpan(obj, i6, i10, i11);
    }

    @Override
    public final CharSequence subSequence(int i6, int i10) {
        return this.f3969b.subSequence(i6, i10);
    }

    @Override
    public final String toString() {
        return this.f3969b.toString();
    }

    public C1248v(CharSequence charSequence) {
        this.f3969b = new SpannableString(charSequence);
    }
}
