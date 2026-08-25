package p014b1;

import android.os.Build;
import android.text.Editable;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.TextWatcher;
import java.util.concurrent.atomic.AtomicInteger;

public final class C1244r implements TextWatcher, SpanWatcher {

    public final Object f3961a;

    public final AtomicInteger f3962b = new AtomicInteger(0);

    public C1244r(Object obj) {
        this.f3961a = obj;
    }

    @Override
    public final void afterTextChanged(Editable editable) {
        ((TextWatcher) this.f3961a).afterTextChanged(editable);
    }

    @Override
    public final void beforeTextChanged(CharSequence charSequence, int i6, int i10, int i11) {
        ((TextWatcher) this.f3961a).beforeTextChanged(charSequence, i6, i10, i11);
    }

    @Override
    public final void onSpanAdded(Spannable spannable, Object obj, int i6, int i10) {
        if (this.f3962b.get() <= 0 || !(obj instanceof C1246t)) {
            ((SpanWatcher) this.f3961a).onSpanAdded(spannable, obj, i6, i10);
        }
    }

    @Override
    public final void onSpanChanged(Spannable spannable, Object obj, int i6, int i10, int i11, int i12) {
        int i13;
        int i14;
        if (this.f3962b.get() <= 0 || !(obj instanceof C1246t)) {
            if (Build.VERSION.SDK_INT >= 28) {
                i13 = i6;
                i14 = i11;
            } else {
                if (i6 > i10) {
                    i6 = 0;
                }
                if (i11 > i12) {
                    i13 = i6;
                    i14 = 0;
                } else {
                    i13 = i6;
                    i14 = i11;
                }
            }
            ((SpanWatcher) this.f3961a).onSpanChanged(spannable, obj, i13, i10, i14, i12);
        }
    }

    @Override
    public final void onSpanRemoved(Spannable spannable, Object obj, int i6, int i10) {
        if (this.f3962b.get() <= 0 || !(obj instanceof C1246t)) {
            ((SpanWatcher) this.f3961a).onSpanRemoved(spannable, obj, i6, i10);
        }
    }

    @Override
    public final void onTextChanged(CharSequence charSequence, int i6, int i10, int i11) {
        ((TextWatcher) this.f3961a).onTextChanged(charSequence, i6, i10, i11);
    }
}
