package p138n0;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.contentcapture.ContentCaptureSession;
import java.util.List;
import p183r0.AbstractC3576a;

public abstract class AbstractC3137m0 {
    public static View.AccessibilityDelegate m6266a(View view) {
        return view.getAccessibilityDelegate();
    }

    public static ContentCaptureSession m6267b(View view) {
        return view.getContentCaptureSession();
    }

    public static List<Rect> m6268c(View view) {
        return view.getSystemGestureExclusionRects();
    }

    public static void m6269d(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i6, int i10) {
        view.saveAttributeDataForStyleable(context, iArr, attributeSet, typedArray, i6, i10);
    }

    public static void m6270e(View view, AbstractC3576a abstractC3576a) {
        view.setContentCaptureSession(null);
    }

    public static void m6271f(View view, List<Rect> list) {
        view.setSystemGestureExclusionRects(list);
    }
}
