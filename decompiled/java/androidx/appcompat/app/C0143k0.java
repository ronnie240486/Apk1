package androidx.appcompat.app;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.appcompat.widget.AppCompatTextView;
import java.lang.reflect.Constructor;
import p160p.C3347k;

public class C0143k0 {

    public static final Class[] f397b = {Context.class, AttributeSet.class};

    public static final int[] f398c = {R.attr.onClick};

    public static final int[] f399d = {R.attr.accessibilityHeading};

    public static final int[] f400e = {R.attr.accessibilityPaneTitle};

    public static final int[] f401f = {R.attr.screenReaderFocusable};

    public static final String[] f402g = {"android.widget.", "android.view.", "android.webkit."};

    public static final C3347k f403h = new C3347k(0);

    public final Object[] f404a = new Object[2];

    public AppCompatAutoCompleteTextView mo425a(Context context, AttributeSet attributeSet) {
        return new AppCompatAutoCompleteTextView(context, attributeSet);
    }

    public AppCompatButton mo426b(Context context, AttributeSet attributeSet) {
        return new AppCompatButton(context, attributeSet);
    }

    public AppCompatCheckBox mo427c(Context context, AttributeSet attributeSet) {
        return new AppCompatCheckBox(context, attributeSet);
    }

    public AppCompatRadioButton mo428d(Context context, AttributeSet attributeSet) {
        return new AppCompatRadioButton(context, attributeSet);
    }

    public AppCompatTextView mo429e(Context context, AttributeSet attributeSet) {
        return new AppCompatTextView(context, attributeSet);
    }

    public final View m430f(Context context, String str, String str2) {
        String strConcat;
        C3347k c3347k = f403h;
        Constructor constructor = (Constructor) c3347k.get(str);
        if (constructor == null) {
            if (str2 != null) {
                try {
                    strConcat = str2.concat(str);
                } catch (Exception unused) {
                    return null;
                }
            } else {
                strConcat = str;
            }
            constructor = Class.forName(strConcat, false, context.getClassLoader()).asSubclass(View.class).getConstructor(f397b);
            c3347k.put(str, constructor);
        }
        constructor.setAccessible(true);
        return (View) constructor.newInstance(this.f404a);
    }
}
