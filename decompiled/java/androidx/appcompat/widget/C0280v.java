package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.appcompat.app.C0142k;
import androidx.core.widget.AbstractC0369b;
import androidx.lifecycle.C0531k;
import com.bumptech.glide.AbstractC1465c;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import p002a1.C0026b;
import p045e.AbstractC2341a;
import p065g0.AbstractC2581a;
import p103j9.AbstractC2796i;
import p127m.C3020b;
import p127m.C3021c;
import p127m.C3024f;
import p138n0.AbstractC3155s0;
import p143n5.AbstractC3198d;
import p227v1.InterfaceC3972d;

public final class C0280v {

    public Parcelable f1082a;

    public Object f1083b;

    public boolean f1084c;

    public boolean f1085d;

    public boolean f1086e;

    public final Object f1087f;

    public C0280v(TextView textView) {
        this.f1082a = null;
        this.f1083b = null;
        this.f1084c = false;
        this.f1085d = false;
        this.f1087f = textView;
    }

    public void m785a() {
        CompoundButton compoundButton = (CompoundButton) this.f1087f;
        Drawable drawableM3472g = AbstractC1465c.m3472g(compoundButton);
        if (drawableM3472g != null) {
            if (this.f1084c || this.f1085d) {
                Drawable drawableMutate = AbstractC3198d.m6448W(drawableM3472g).mutate();
                if (this.f1084c) {
                    AbstractC2581a.m5586h(drawableMutate, (ColorStateList) this.f1082a);
                }
                if (this.f1085d) {
                    AbstractC2581a.m5587i(drawableMutate, (PorterDuff.Mode) this.f1083b);
                }
                if (drawableMutate.isStateful()) {
                    drawableMutate.setState(compoundButton.getDrawableState());
                }
                compoundButton.setButtonDrawable(drawableMutate);
            }
        }
    }

    public void m786b() {
        AppCompatCheckedTextView appCompatCheckedTextView = (AppCompatCheckedTextView) this.f1087f;
        Drawable checkMarkDrawable = appCompatCheckedTextView.getCheckMarkDrawable();
        if (checkMarkDrawable != null) {
            if (this.f1084c || this.f1085d) {
                Drawable drawableMutate = AbstractC3198d.m6448W(checkMarkDrawable).mutate();
                if (this.f1084c) {
                    AbstractC2581a.m5586h(drawableMutate, (ColorStateList) this.f1082a);
                }
                if (this.f1085d) {
                    AbstractC2581a.m5587i(drawableMutate, (PorterDuff.Mode) this.f1083b);
                }
                if (drawableMutate.isStateful()) {
                    drawableMutate.setState(appCompatCheckedTextView.getDrawableState());
                }
                appCompatCheckedTextView.setCheckMarkDrawable(drawableMutate);
            }
        }
    }

    public Bundle m787c(String str) {
        if (!this.f1085d) {
            throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component");
        }
        Bundle bundle = (Bundle) this.f1082a;
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = bundle.getBundle(str);
        Bundle bundle3 = (Bundle) this.f1082a;
        if (bundle3 != null) {
            bundle3.remove(str);
        }
        Bundle bundle4 = (Bundle) this.f1082a;
        if (bundle4 == null || bundle4.isEmpty()) {
            this.f1082a = null;
        }
        return bundle2;
    }

    public InterfaceC3972d m788d() {
        String str;
        InterfaceC3972d interfaceC3972d;
        Iterator it = ((C3024f) this.f1087f).iterator();
        do {
            C3020b c3020b = (C3020b) it;
            if (!c3020b.hasNext()) {
                return null;
            }
            Map.Entry entry = (Map.Entry) c3020b.next();
            AbstractC2796i.m5784e(entry, "components");
            str = (String) entry.getKey();
            interfaceC3972d = (InterfaceC3972d) entry.getValue();
        } while (!AbstractC2796i.m5780a(str, "androidx.lifecycle.internal.SavedStateHandlesProvider"));
        return interfaceC3972d;
    }

    public void m789e(AttributeSet attributeSet, int i6) {
        int resourceId;
        int resourceId2;
        CompoundButton compoundButton = (CompoundButton) this.f1087f;
        Context context = compoundButton.getContext();
        int[] iArr = AbstractC2341a.f8166n;
        C0026b c0026bM111C = C0026b.m111C(context, attributeSet, iArr, i6);
        TypedArray typedArray = (TypedArray) c0026bM111C.f55c;
        AbstractC3155s0.m6346p(compoundButton, compoundButton.getContext(), iArr, attributeSet, (TypedArray) c0026bM111C.f55c, i6, 0);
        try {
            if (typedArray.hasValue(1) && (resourceId2 = typedArray.getResourceId(1, 0)) != 0) {
                try {
                    compoundButton.setButtonDrawable(AbstractC1465c.m3473h(compoundButton.getContext(), resourceId2));
                } catch (Resources.NotFoundException unused) {
                    if (typedArray.hasValue(0)) {
                        compoundButton.setButtonDrawable(AbstractC1465c.m3473h(compoundButton.getContext(), resourceId));
                    }
                }
            } else if (typedArray.hasValue(0) && (resourceId = typedArray.getResourceId(0, 0)) != 0) {
                compoundButton.setButtonDrawable(AbstractC1465c.m3473h(compoundButton.getContext(), resourceId));
            }
            if (typedArray.hasValue(2)) {
                AbstractC0369b.m1119c(compoundButton, c0026bM111C.m139s(2));
            }
            if (typedArray.hasValue(3)) {
                AbstractC0369b.m1120d(compoundButton, AbstractC0237m1.m737c(typedArray.getInt(3, -1), null));
            }
        } finally {
            c0026bM111C.m120F();
        }
    }

    public void m790f(String str, InterfaceC3972d interfaceC3972d) {
        Object obj;
        AbstractC2796i.m5785f(interfaceC3972d, "provider");
        C3024f c3024f = (C3024f) this.f1087f;
        C3021c c3021cMo6095c = c3024f.mo6095c(str);
        if (c3021cMo6095c != null) {
            obj = c3021cMo6095c.f10344b;
        } else {
            C3021c c3021c = new C3021c(str, interfaceC3972d);
            c3024f.f10353d++;
            C3021c c3021c2 = c3024f.f10351b;
            if (c3021c2 == null) {
                c3024f.f10350a = c3021c;
                c3024f.f10351b = c3021c;
            } else {
                c3021c2.f10345c = c3021c;
                c3021c.f10346d = c3021c2;
                c3024f.f10351b = c3021c;
            }
            obj = null;
        }
        if (((InterfaceC3972d) obj) != null) {
            throw new IllegalArgumentException("SavedStateProvider with the given key is already registered");
        }
    }

    public void m791g() {
        if (!this.f1086e) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
        C0142k c0142k = (C0142k) this.f1083b;
        if (c0142k == null) {
            c0142k = new C0142k(this);
        }
        this.f1083b = c0142k;
        try {
            C0531k.class.getDeclaredConstructor(null);
            C0142k c0142k2 = (C0142k) this.f1083b;
            if (c0142k2 != null) {
                ((LinkedHashSet) c0142k2.f396b).add(C0531k.class.getName());
            }
        } catch (NoSuchMethodException e5) {
            throw new IllegalArgumentException("Class " + C0531k.class.getSimpleName() + " must have default constructor in order to be automatically recreated", e5);
        }
    }

    public C0280v() {
        this.f1087f = new C3024f();
        this.f1086e = true;
    }
}
