package androidx.appcompat.widget;

import android.app.Activity;
import android.content.ClipData;
import android.os.Build;
import android.text.Selection;
import android.text.Spannable;
import android.view.DragEvent;
import android.view.View;
import android.widget.TextView;
import p101j7.C2782c;
import p138n0.AbstractC3155s0;
import p138n0.C3112e;
import p138n0.InterfaceC3109d;

public abstract class AbstractC0185c0 {
    public static boolean m645a(DragEvent dragEvent, TextView textView, Activity activity) {
        InterfaceC3109d c2782c;
        activity.requestDragAndDropPermissions(dragEvent);
        int offsetForPosition = textView.getOffsetForPosition(dragEvent.getX(), dragEvent.getY());
        textView.beginBatchEdit();
        try {
            Selection.setSelection((Spannable) textView.getText(), offsetForPosition);
            ClipData clipData = dragEvent.getClipData();
            if (Build.VERSION.SDK_INT >= 31) {
                c2782c = new C2782c(clipData, 3);
            } else {
                C3112e c3112e = new C3112e();
                c3112e.f10586b = clipData;
                c3112e.f10587c = 3;
                c2782c = c3112e;
            }
            AbstractC3155s0.m6342l(textView, c2782c.mo5753f());
            return true;
        } finally {
            textView.endBatchEdit();
        }
    }

    public static boolean m646b(DragEvent dragEvent, View view, Activity activity) {
        InterfaceC3109d c2782c;
        activity.requestDragAndDropPermissions(dragEvent);
        ClipData clipData = dragEvent.getClipData();
        if (Build.VERSION.SDK_INT >= 31) {
            c2782c = new C2782c(clipData, 3);
        } else {
            C3112e c3112e = new C3112e();
            c3112e.f10586b = clipData;
            c3112e.f10587c = 3;
            c2782c = c3112e;
        }
        AbstractC3155s0.m6342l(view, c2782c.mo5753f());
        return true;
    }
}
