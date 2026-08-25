package org.bitspark.android.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.nmmedit.protect.NativeUtil;

@SuppressLint({"AppCompatCustomView"})
public class AlwaysMarqueeTextView extends TextView {
    static {
        NativeUtil.classesInit0(56);
    }

    public AlwaysMarqueeTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override
    public final native boolean isFocused();

    public AlwaysMarqueeTextView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
    }
}
