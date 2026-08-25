package com.google.android.material.snackbar;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.p2serv.android.p032ds.R;
import java.util.WeakHashMap;
import p138n0.AbstractC3155s0;

public class SnackbarContentLayout extends LinearLayout {

    public TextView f6677a;

    public Button f6678b;

    public int f6679c;

    public SnackbarContentLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final boolean m4333a(int i6, int i10, int i11) {
        boolean z7;
        if (i6 != getOrientation()) {
            setOrientation(i6);
            z7 = true;
        } else {
            z7 = false;
        }
        if (this.f6677a.getPaddingTop() == i10 && this.f6677a.getPaddingBottom() == i11) {
            return z7;
        }
        TextView textView = this.f6677a;
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        if (textView.isPaddingRelative()) {
            textView.setPaddingRelative(textView.getPaddingStart(), i10, textView.getPaddingEnd(), i11);
            return true;
        }
        textView.setPadding(textView.getPaddingLeft(), i10, textView.getPaddingRight(), i11);
        return true;
    }

    public Button getActionView() {
        return this.f6678b;
    }

    public TextView getMessageView() {
        return this.f6677a;
    }

    @Override
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.f6677a = (TextView) findViewById(R.id.snackbar_text);
        this.f6678b = (Button) findViewById(R.id.snackbar_action);
    }

    @Override
    public final void onMeasure(int i6, int i10) {
        super.onMeasure(i6, i10);
        if (getOrientation() == 1) {
            return;
        }
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.design_snackbar_padding_vertical_2lines);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.design_snackbar_padding_vertical);
        boolean z7 = this.f6677a.getLayout().getLineCount() > 1;
        if (!z7 || this.f6679c <= 0 || this.f6678b.getMeasuredWidth() <= this.f6679c) {
            if (!z7) {
                dimensionPixelSize = dimensionPixelSize2;
            }
            if (!m4333a(0, dimensionPixelSize, dimensionPixelSize)) {
                return;
            }
        } else if (!m4333a(1, dimensionPixelSize, dimensionPixelSize - dimensionPixelSize2)) {
            return;
        }
        super.onMeasure(i6, i10);
    }

    public void setMaxInlineActionWidth(int i6) {
        this.f6679c = i6;
    }
}
