package p035d1;

import android.graphics.Rect;
import android.text.method.TransformationMethod;
import android.view.View;
import p014b1.C1235i;

public final class C2131i implements TransformationMethod {

    public final TransformationMethod f7747a;

    public C2131i(TransformationMethod transformationMethod) {
        this.f7747a = transformationMethod;
    }

    @Override
    public final CharSequence getTransformation(CharSequence charSequence, View view) {
        if (view.isInEditMode()) {
            return charSequence;
        }
        TransformationMethod transformationMethod = this.f7747a;
        if (transformationMethod != null) {
            charSequence = transformationMethod.getTransformation(charSequence, view);
        }
        if (charSequence == null || C1235i.m3106a().m3107b() != 1) {
            return charSequence;
        }
        C1235i c1235iM3106a = C1235i.m3106a();
        c1235iM3106a.getClass();
        return c1235iM3106a.m3110e(charSequence, 0, charSequence.length());
    }

    @Override
    public final void onFocusChanged(View view, CharSequence charSequence, boolean z7, int i6, Rect rect) {
        TransformationMethod transformationMethod = this.f7747a;
        if (transformationMethod != null) {
            transformationMethod.onFocusChanged(view, charSequence, z7, i6, rect);
        }
    }
}
