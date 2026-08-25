package p084i1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.leanback.widget.VerticalGridView;
import androidx.leanback.widget.picker.Picker;
import androidx.recyclerview.widget.AbstractC1158k0;
import androidx.recyclerview.widget.AbstractC1174p1;
import java.util.ArrayList;

public final class C2679b extends AbstractC1158k0 {

    public final int f9315a;

    public final int f9316b;

    public final int f9317c;

    public final C2681d f9318d;

    public final Picker f9319e;

    public C2679b(Picker picker, int i6, int i10, int i11) {
        this.f9319e = picker;
        this.f9315a = i6;
        this.f9316b = i11;
        this.f9317c = i10;
        this.f9318d = (C2681d) picker.f2404c.get(i11);
    }

    @Override
    public final int getItemCount() {
        C2681d c2681d = this.f9318d;
        if (c2681d == null) {
            return 0;
        }
        return (c2681d.f9323c - c2681d.f9322b) + 1;
    }

    @Override
    public final void onBindViewHolder(AbstractC1174p1 abstractC1174p1, int i6) {
        C2681d c2681d;
        C2680c c2680c = (C2680c) abstractC1174p1;
        TextView textView = c2680c.f9320a;
        if (textView != null && (c2681d = this.f9318d) != null) {
            int i10 = c2681d.f9322b + i6;
            CharSequence[] charSequenceArr = c2681d.f9324d;
            textView.setText(charSequenceArr == null ? String.format(c2681d.f9325e, Integer.valueOf(i10)) : charSequenceArr[i10]);
        }
        View view = c2680c.itemView;
        Picker picker = this.f9319e;
        ArrayList arrayList = picker.f2403b;
        int i11 = this.f9316b;
        picker.m1461e(view, ((VerticalGridView) arrayList.get(i11)).getSelectedPosition() == i6, i11, false);
    }

    @Override
    public final AbstractC1174p1 onCreateViewHolder(ViewGroup viewGroup, int i6) {
        View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(this.f9315a, viewGroup, false);
        int i10 = this.f9317c;
        return new C2680c(viewInflate, i10 != 0 ? (TextView) viewInflate.findViewById(i10) : (TextView) viewInflate);
    }

    @Override
    public final void onViewAttachedToWindow(AbstractC1174p1 abstractC1174p1) {
        ((C2680c) abstractC1174p1).itemView.setFocusable(this.f9319e.isActivated());
    }
}
