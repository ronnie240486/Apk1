package androidx.leanback.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.p2serv.android.p032ds.R;

public final class ListRowHoverCardView extends LinearLayout {

    public final TextView f2161a;

    public final TextView f2162b;

    public ListRowHoverCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final CharSequence getDescription() {
        return this.f2162b.getText();
    }

    public final CharSequence getTitle() {
        return this.f2161a.getText();
    }

    public final void setDescription(CharSequence charSequence) {
        boolean zIsEmpty = TextUtils.isEmpty(charSequence);
        TextView textView = this.f2162b;
        if (zIsEmpty) {
            textView.setVisibility(8);
        } else {
            textView.setText(charSequence);
            textView.setVisibility(0);
        }
    }

    public final void setTitle(CharSequence charSequence) {
        boolean zIsEmpty = TextUtils.isEmpty(charSequence);
        TextView textView = this.f2161a;
        if (zIsEmpty) {
            textView.setVisibility(8);
        } else {
            textView.setText(charSequence);
            textView.setVisibility(0);
        }
    }

    public ListRowHoverCardView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        LayoutInflater.from(context).inflate(R.layout.lb_list_row_hovercard, this);
        this.f2161a = (TextView) findViewById(R.id.title);
        this.f2162b = (TextView) findViewById(R.id.description);
    }
}
