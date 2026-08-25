package p014b1;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import java.lang.reflect.Array;
import java.util.ArrayList;
import p003a2.AbstractC0032a;

public final class C1245s extends SpannableStringBuilder {

    public final Class f3963a;

    public final ArrayList f3964b;

    public C1245s(Class cls, CharSequence charSequence) {
        super(charSequence);
        this.f3964b = new ArrayList();
        AbstractC0032a.m162p(cls, "watcherClass cannot be null");
        this.f3963a = cls;
    }

    public final void m3124a() {
        int i6 = 0;
        while (true) {
            ArrayList arrayList = this.f3964b;
            if (i6 >= arrayList.size()) {
                return;
            }
            ((C1244r) arrayList.get(i6)).f3962b.incrementAndGet();
            i6++;
        }
    }

    @Override
    public final Editable append(CharSequence charSequence) {
        super.append(charSequence);
        return this;
    }

    public final void m3125b() {
        m3128e();
        int i6 = 0;
        while (true) {
            ArrayList arrayList = this.f3964b;
            if (i6 >= arrayList.size()) {
                return;
            }
            ((C1244r) arrayList.get(i6)).onTextChanged(this, 0, length(), length());
            i6++;
        }
    }

    public final C1244r m3126c(Object obj) {
        int i6 = 0;
        while (true) {
            ArrayList arrayList = this.f3964b;
            if (i6 >= arrayList.size()) {
                return null;
            }
            C1244r c1244r = (C1244r) arrayList.get(i6);
            if (c1244r.f3961a == obj) {
                return c1244r;
            }
            i6++;
        }
    }

    public final boolean m3127d(Object obj) {
        if (obj != null) {
            if (this.f3963a == obj.getClass()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public final Editable delete(int i6, int i10) {
        super.delete(i6, i10);
        return this;
    }

    public final void m3128e() {
        int i6 = 0;
        while (true) {
            ArrayList arrayList = this.f3964b;
            if (i6 >= arrayList.size()) {
                return;
            }
            ((C1244r) arrayList.get(i6)).f3962b.decrementAndGet();
            i6++;
        }
    }

    @Override
    public final int getSpanEnd(Object obj) {
        C1244r c1244rM3126c;
        if (m3127d(obj) && (c1244rM3126c = m3126c(obj)) != null) {
            obj = c1244rM3126c;
        }
        return super.getSpanEnd(obj);
    }

    @Override
    public final int getSpanFlags(Object obj) {
        C1244r c1244rM3126c;
        if (m3127d(obj) && (c1244rM3126c = m3126c(obj)) != null) {
            obj = c1244rM3126c;
        }
        return super.getSpanFlags(obj);
    }

    @Override
    public final int getSpanStart(Object obj) {
        C1244r c1244rM3126c;
        if (m3127d(obj) && (c1244rM3126c = m3126c(obj)) != null) {
            obj = c1244rM3126c;
        }
        return super.getSpanStart(obj);
    }

    @Override
    public final Object[] getSpans(int i6, int i10, Class cls) {
        if (this.f3963a != cls) {
            return super.getSpans(i6, i10, cls);
        }
        C1244r[] c1244rArr = (C1244r[]) super.getSpans(i6, i10, C1244r.class);
        Object[] objArr = (Object[]) Array.newInstance((Class<?>) cls, c1244rArr.length);
        for (int i11 = 0; i11 < c1244rArr.length; i11++) {
            objArr[i11] = c1244rArr[i11].f3961a;
        }
        return objArr;
    }

    @Override
    public final Editable insert(int i6, CharSequence charSequence) {
        super.insert(i6, charSequence);
        return this;
    }

    @Override
    public final int nextSpanTransition(int i6, int i10, Class cls) {
        if (cls == null || this.f3963a == cls) {
            cls = C1244r.class;
        }
        return super.nextSpanTransition(i6, i10, cls);
    }

    @Override
    public final void removeSpan(Object obj) {
        C1244r c1244rM3126c;
        if (m3127d(obj)) {
            c1244rM3126c = m3126c(obj);
            if (c1244rM3126c != null) {
                obj = c1244rM3126c;
            }
        } else {
            c1244rM3126c = null;
        }
        super.removeSpan(obj);
        if (c1244rM3126c != null) {
            this.f3964b.remove(c1244rM3126c);
        }
    }

    @Override
    public final Editable replace(int i6, int i10, CharSequence charSequence) {
        replace(i6, i10, charSequence);
        return this;
    }

    @Override
    public final void setSpan(Object obj, int i6, int i10, int i11) {
        if (m3127d(obj)) {
            C1244r c1244r = new C1244r(obj);
            this.f3964b.add(c1244r);
            obj = c1244r;
        }
        super.setSpan(obj, i6, i10, i11);
    }

    @Override
    public final CharSequence subSequence(int i6, int i10) {
        return new C1245s(this.f3963a, this, i6, i10);
    }

    @Override
    public final SpannableStringBuilder append(CharSequence charSequence) {
        super.append(charSequence);
        return this;
    }

    @Override
    public final SpannableStringBuilder delete(int i6, int i10) {
        super.delete(i6, i10);
        return this;
    }

    @Override
    public final SpannableStringBuilder insert(int i6, CharSequence charSequence) {
        super.insert(i6, charSequence);
        return this;
    }

    @Override
    public final Editable replace(int i6, int i10, CharSequence charSequence, int i11, int i12) {
        replace(i6, i10, charSequence, i11, i12);
        return this;
    }

    @Override
    public final Appendable append(CharSequence charSequence) {
        super.append(charSequence);
        return this;
    }

    @Override
    public final Editable insert(int i6, CharSequence charSequence, int i10, int i11) {
        super.insert(i6, charSequence, i10, i11);
        return this;
    }

    @Override
    public final SpannableStringBuilder replace(int i6, int i10, CharSequence charSequence) {
        m3124a();
        super.replace(i6, i10, charSequence);
        m3128e();
        return this;
    }

    @Override
    public final Editable append(char c5) {
        super.append(c5);
        return this;
    }

    @Override
    public final SpannableStringBuilder insert(int i6, CharSequence charSequence, int i10, int i11) {
        super.insert(i6, charSequence, i10, i11);
        return this;
    }

    public C1245s(Class cls, C1245s c1245s, int i6, int i10) {
        super(c1245s, i6, i10);
        this.f3964b = new ArrayList();
        AbstractC0032a.m162p(cls, "watcherClass cannot be null");
        this.f3963a = cls;
    }

    @Override
    public final SpannableStringBuilder append(char c5) {
        super.append(c5);
        return this;
    }

    @Override
    public final Appendable append(char c5) {
        super.append(c5);
        return this;
    }

    @Override
    public final SpannableStringBuilder replace(int i6, int i10, CharSequence charSequence, int i11, int i12) {
        m3124a();
        super.replace(i6, i10, charSequence, i11, i12);
        m3128e();
        return this;
    }

    @Override
    public final Editable append(CharSequence charSequence, int i6, int i10) {
        super.append(charSequence, i6, i10);
        return this;
    }

    @Override
    public final SpannableStringBuilder append(CharSequence charSequence, int i6, int i10) {
        super.append(charSequence, i6, i10);
        return this;
    }

    @Override
    public final Appendable append(CharSequence charSequence, int i6, int i10) {
        super.append(charSequence, i6, i10);
        return this;
    }

    @Override
    public final SpannableStringBuilder append(CharSequence charSequence, Object obj, int i6) {
        super.append(charSequence, obj, i6);
        return this;
    }
}
