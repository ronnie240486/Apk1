package androidx.leanback.widget.picker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.leanback.widget.VerticalGridView;
import com.p2serv.android.p032ds.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import p055ea.AbstractC2460q;
import p075h1.AbstractC2639a;
import p084i1.C2678a;
import p084i1.C2679b;
import p084i1.C2681d;
import p138n0.AbstractC3155s0;

public class Picker extends FrameLayout {

    public final ViewGroup f2402a;

    public final ArrayList f2403b;

    public ArrayList f2404c;

    public final float f2405d;

    public final float f2406e;

    public final float f2407f;

    public final int f2408g;

    public final DecelerateInterpolator f2409h;

    public float f2410i;

    public float f2411j;

    public int f2412k;

    public final ArrayList f2413l;

    public int f2414m;

    public int f2415n;

    public final C2678a f2416o;

    public Picker(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.pickerStyle);
    }

    public void mo1455a(int i6, int i10) {
        C2681d c2681d = (C2681d) this.f2404c.get(i6);
        if (c2681d.f9321a != i10) {
            c2681d.f9321a = i10;
        }
    }

    public final void m1458b(int i6, C2681d c2681d) {
        this.f2404c.set(i6, c2681d);
        VerticalGridView verticalGridView = (VerticalGridView) this.f2403b.get(i6);
        C2679b c2679b = (C2679b) verticalGridView.getAdapter();
        if (c2679b != null) {
            c2679b.notifyDataSetChanged();
        }
        verticalGridView.setSelectedPosition(c2681d.f9321a - c2681d.f9322b);
    }

    public final void m1459c(int i6, int i10) {
        C2681d c2681d = (C2681d) this.f2404c.get(i6);
        if (c2681d.f9321a != i10) {
            c2681d.f9321a = i10;
            VerticalGridView verticalGridView = (VerticalGridView) this.f2403b.get(i6);
            if (verticalGridView != null) {
                verticalGridView.setSelectedPosition(i10 - ((C2681d) this.f2404c.get(i6)).f9322b);
            }
        }
    }

    public final void m1460d(View view, boolean z7, float f, DecelerateInterpolator decelerateInterpolator) {
        view.animate().cancel();
        if (z7) {
            view.animate().alpha(f).setDuration(this.f2408g).setInterpolator(decelerateInterpolator).start();
        } else {
            view.setAlpha(f);
        }
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!isActivated()) {
            return super.dispatchKeyEvent(keyEvent);
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode != 23 && keyCode != 66) {
            return super.dispatchKeyEvent(keyEvent);
        }
        if (keyEvent.getAction() == 1) {
            performClick();
        }
        return true;
    }

    public final void m1461e(View view, boolean z7, int i6, boolean z10) {
        boolean z11 = i6 == this.f2412k || !hasFocus();
        DecelerateInterpolator decelerateInterpolator = this.f2409h;
        if (z7) {
            if (z11) {
                m1460d(view, z10, this.f2406e, decelerateInterpolator);
                return;
            } else {
                m1460d(view, z10, this.f2405d, decelerateInterpolator);
                return;
            }
        }
        if (z11) {
            m1460d(view, z10, this.f2407f, decelerateInterpolator);
        } else {
            m1460d(view, z10, 0.0f, decelerateInterpolator);
        }
    }

    public final void m1462f(int i6) {
        VerticalGridView verticalGridView = (VerticalGridView) this.f2403b.get(i6);
        int selectedPosition = verticalGridView.getSelectedPosition();
        int i10 = 0;
        while (i10 < verticalGridView.getAdapter().getItemCount()) {
            View viewFindViewByPosition = verticalGridView.getLayoutManager().findViewByPosition(i10);
            if (viewFindViewByPosition != null) {
                m1461e(viewFindViewByPosition, selectedPosition == i10, i6, true);
            }
            i10++;
        }
    }

    public final void m1463g() {
        for (int i6 = 0; i6 < getColumnsCount(); i6++) {
            m1464h((VerticalGridView) this.f2403b.get(i6));
        }
    }

    public float getActivatedVisibleItemCount() {
        return this.f2410i;
    }

    public int getColumnsCount() {
        ArrayList arrayList = this.f2404c;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public int getPickerItemHeightPixels() {
        return getContext().getResources().getDimensionPixelSize(R.dimen.picker_item_height);
    }

    public final int getPickerItemLayoutId() {
        return this.f2414m;
    }

    public final int getPickerItemTextViewId() {
        return this.f2415n;
    }

    public int getSelectedColumn() {
        return this.f2412k;
    }

    @Deprecated
    public final CharSequence getSeparator() {
        return (CharSequence) this.f2413l.get(0);
    }

    public final List<CharSequence> getSeparators() {
        return this.f2413l;
    }

    public float getVisibleItemCount() {
        return 1.0f;
    }

    public final void m1464h(VerticalGridView verticalGridView) {
        ViewGroup.LayoutParams layoutParams = verticalGridView.getLayoutParams();
        float activatedVisibleItemCount = isActivated() ? getActivatedVisibleItemCount() : getVisibleItemCount();
        layoutParams.height = (int) AbstractC2460q.m5490d(activatedVisibleItemCount, 1.0f, verticalGridView.getVerticalSpacing(), getPickerItemHeightPixels() * activatedVisibleItemCount);
        verticalGridView.setLayoutParams(layoutParams);
    }

    @Override
    public final boolean onRequestFocusInDescendants(int i6, Rect rect) {
        int selectedColumn = getSelectedColumn();
        if (selectedColumn < 0) {
            return false;
        }
        ArrayList arrayList = this.f2403b;
        if (selectedColumn < arrayList.size()) {
            return ((VerticalGridView) arrayList.get(selectedColumn)).requestFocus(i6, rect);
        }
        return false;
    }

    @Override
    public final void requestChildFocus(View view, View view2) {
        super.requestChildFocus(view, view2);
        int i6 = 0;
        while (true) {
            ArrayList arrayList = this.f2403b;
            if (i6 >= arrayList.size()) {
                return;
            }
            if (((VerticalGridView) arrayList.get(i6)).hasFocus()) {
                setSelectedColumn(i6);
            }
            i6++;
        }
    }

    @Override
    public void setActivated(boolean z7) {
        ArrayList arrayList;
        if (z7 == isActivated()) {
            super.setActivated(z7);
            return;
        }
        super.setActivated(z7);
        boolean zHasFocus = hasFocus();
        int selectedColumn = getSelectedColumn();
        setDescendantFocusability(131072);
        if (!z7 && zHasFocus && isFocusable()) {
            requestFocus();
        }
        int i6 = 0;
        while (true) {
            int columnsCount = getColumnsCount();
            arrayList = this.f2403b;
            if (i6 >= columnsCount) {
                break;
            }
            ((VerticalGridView) arrayList.get(i6)).setFocusable(z7);
            i6++;
        }
        m1463g();
        boolean zIsActivated = isActivated();
        for (int i10 = 0; i10 < getColumnsCount(); i10++) {
            VerticalGridView verticalGridView = (VerticalGridView) arrayList.get(i10);
            for (int i11 = 0; i11 < verticalGridView.getChildCount(); i11++) {
                verticalGridView.getChildAt(i11).setFocusable(zIsActivated);
            }
        }
        if (z7 && zHasFocus && selectedColumn >= 0) {
            ((VerticalGridView) arrayList.get(selectedColumn)).requestFocus();
        }
        setDescendantFocusability(262144);
    }

    public void setActivatedVisibleItemCount(float f) {
        if (f <= 0.0f) {
            throw new IllegalArgumentException();
        }
        if (this.f2410i != f) {
            this.f2410i = f;
            if (isActivated()) {
                m1463g();
            }
        }
    }

    public void setColumns(List<C2681d> list) {
        ArrayList arrayList = this.f2413l;
        if (arrayList.size() == 0) {
            throw new IllegalStateException("Separators size is: " + arrayList.size() + ". At least one separator must be provided");
        }
        if (arrayList.size() == 1) {
            CharSequence charSequence = (CharSequence) arrayList.get(0);
            arrayList.clear();
            arrayList.add("");
            for (int i6 = 0; i6 < list.size() - 1; i6++) {
                arrayList.add(charSequence);
            }
            arrayList.add("");
        } else if (arrayList.size() != list.size() + 1) {
            throw new IllegalStateException("Separators size: " + arrayList.size() + " mustequal the size of columns: " + list.size() + " + 1");
        }
        ArrayList arrayList2 = this.f2403b;
        arrayList2.clear();
        ViewGroup viewGroup = this.f2402a;
        viewGroup.removeAllViews();
        ArrayList arrayList3 = new ArrayList(list);
        this.f2404c = arrayList3;
        if (this.f2412k > arrayList3.size() - 1) {
            this.f2412k = this.f2404c.size() - 1;
        }
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
        int columnsCount = getColumnsCount();
        if (!TextUtils.isEmpty((CharSequence) arrayList.get(0))) {
            TextView textView = (TextView) layoutInflaterFrom.inflate(R.layout.lb_picker_separator, viewGroup, false);
            textView.setText((CharSequence) arrayList.get(0));
            viewGroup.addView(textView);
        }
        int i10 = 0;
        while (i10 < columnsCount) {
            VerticalGridView verticalGridView = (VerticalGridView) layoutInflaterFrom.inflate(R.layout.lb_picker_column, viewGroup, false);
            m1464h(verticalGridView);
            verticalGridView.setWindowAlignment(0);
            verticalGridView.setHasFixedSize(false);
            verticalGridView.setFocusable(isActivated());
            verticalGridView.setItemViewCacheSize(0);
            arrayList2.add(verticalGridView);
            viewGroup.addView(verticalGridView);
            int i11 = i10 + 1;
            if (!TextUtils.isEmpty((CharSequence) arrayList.get(i11))) {
                TextView textView2 = (TextView) layoutInflaterFrom.inflate(R.layout.lb_picker_separator, viewGroup, false);
                textView2.setText((CharSequence) arrayList.get(i11));
                viewGroup.addView(textView2);
            }
            verticalGridView.setAdapter(new C2679b(this, getPickerItemLayoutId(), getPickerItemTextViewId(), i10));
            verticalGridView.setOnChildViewHolderSelectedListener(this.f2416o);
            i10 = i11;
        }
    }

    public final void setPickerItemLayoutId(int i6) {
        this.f2414m = i6;
    }

    public final void setPickerItemTextViewId(int i6) {
        this.f2415n = i6;
    }

    public void setSelectedColumn(int i6) {
        int i10 = this.f2412k;
        ArrayList arrayList = this.f2403b;
        if (i10 != i6) {
            this.f2412k = i6;
            for (int i11 = 0; i11 < arrayList.size(); i11++) {
                m1462f(i11);
            }
        }
        VerticalGridView verticalGridView = (VerticalGridView) arrayList.get(i6);
        if (!hasFocus() || verticalGridView.hasFocus()) {
            return;
        }
        verticalGridView.requestFocus();
    }

    public final void setSeparator(CharSequence charSequence) {
        setSeparators(Arrays.asList(charSequence));
    }

    public final void setSeparators(List<CharSequence> list) {
        ArrayList arrayList = this.f2413l;
        arrayList.clear();
        arrayList.addAll(list);
    }

    public void setVisibleItemCount(float f) {
        if (f <= 0.0f) {
            throw new IllegalArgumentException();
        }
        if (this.f2411j != f) {
            this.f2411j = f;
            if (isActivated()) {
                return;
            }
            m1463g();
        }
    }

    @SuppressLint({"CustomViewStyleable"})
    public Picker(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f2403b = new ArrayList();
        this.f2410i = 3.0f;
        this.f2411j = 1.0f;
        this.f2412k = 0;
        this.f2413l = new ArrayList();
        this.f2416o = new C2678a(this);
        int[] iArr = AbstractC2639a.f9163g;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i6, 0);
        AbstractC3155s0.m6346p(this, context, iArr, attributeSet, typedArrayObtainStyledAttributes, i6, 0);
        this.f2414m = typedArrayObtainStyledAttributes.getResourceId(0, R.layout.lb_picker_item);
        this.f2415n = typedArrayObtainStyledAttributes.getResourceId(1, 0);
        typedArrayObtainStyledAttributes.recycle();
        setEnabled(true);
        setDescendantFocusability(262144);
        this.f2406e = 1.0f;
        this.f2405d = 1.0f;
        this.f2407f = 0.5f;
        this.f2408g = 200;
        this.f2409h = new DecelerateInterpolator(2.5f);
        this.f2402a = (ViewGroup) ((ViewGroup) LayoutInflater.from(getContext()).inflate(R.layout.lb_picker, (ViewGroup) this, true)).findViewById(R.id.picker);
    }
}
