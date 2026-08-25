package org.bitspark.android.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.VideoView;
import com.nmmedit.protect.NativeUtil;
import p003a2.AbstractC0032a;

public class SafeVideoView extends VideoView {

    public static final String f11300a;

    public SafeVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override
    public final native void onLayout(boolean z7, int i6, int i10, int i11, int i12);

    @Override
    public final native void onMeasure(int i6, int i10);

    static {
        NativeUtil.classesInit0(42);
        f11300a = AbstractC0032a.m165s("Sz+3BXCyg9V3CLgFUQ==\n", "GF7RYCbb57A=\n");
    }

    public SafeVideoView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
    }
}
