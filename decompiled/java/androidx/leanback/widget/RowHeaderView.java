package androidx.leanback.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.widget.TextView;
import com.p2serv.android.p032ds.R;
import p143n5.AbstractC3198d;

@SuppressLint({"AppCompatCustomView"})
public final class RowHeaderView extends TextView {
    public RowHeaderView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.rowHeaderStyle);
    }

    @Override
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(AbstractC3198d.m6449X(callback, this));
    }

    public RowHeaderView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
    }
}
