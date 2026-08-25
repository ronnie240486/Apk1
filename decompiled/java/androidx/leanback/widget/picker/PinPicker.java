package androidx.leanback.widget.picker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.KeyEvent;
import com.p2serv.android.p032ds.R;
import java.util.ArrayList;
import p075h1.AbstractC2639a;
import p084i1.C2681d;
import p138n0.AbstractC3155s0;

public class PinPicker extends Picker {
    public PinPicker(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.pinPickerStyle);
    }

    @Override
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if (keyEvent.getAction() != 1 || keyCode < 7 || keyCode > 16) {
            return super.dispatchKeyEvent(keyEvent);
        }
        m1459c(getSelectedColumn(), keyCode - 7);
        performClick();
        return true;
    }

    public String getPin() {
        StringBuilder sb = new StringBuilder();
        int columnsCount = getColumnsCount();
        for (int i6 = 0; i6 < columnsCount; i6++) {
            ArrayList arrayList = this.f2404c;
            sb.append(Integer.toString((arrayList == null ? null : (C2681d) arrayList.get(i6)).f9321a));
        }
        return sb.toString();
    }

    @Override
    public final boolean performClick() {
        int selectedColumn = getSelectedColumn();
        if (selectedColumn == getColumnsCount() - 1) {
            return super.performClick();
        }
        setSelectedColumn(selectedColumn + 1);
        return false;
    }

    public void setNumberOfColumns(int i6) {
        ArrayList arrayList = new ArrayList(i6);
        for (int i10 = 0; i10 < i6; i10++) {
            C2681d c2681d = new C2681d();
            c2681d.f9322b = 0;
            c2681d.f9323c = 9;
            c2681d.f9325e = "%d";
            arrayList.add(c2681d);
        }
        setColumns(arrayList);
    }

    @SuppressLint({"CustomViewStyleable"})
    public PinPicker(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        int[] iArr = AbstractC2639a.f9164h;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i6, 0);
        AbstractC3155s0.m6346p(this, context, iArr, attributeSet, typedArrayObtainStyledAttributes, i6, 0);
        try {
            setSeparator(" ");
            setNumberOfColumns(typedArrayObtainStyledAttributes.getInt(0, 4));
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }
}
