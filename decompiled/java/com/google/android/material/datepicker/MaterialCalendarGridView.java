package com.google.android.material.datepicker;

import android.R;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Adapter;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.core.widget.C0376i;
import com.google.android.material.internal.AbstractC1811a0;
import java.util.Calendar;
import java.util.Iterator;
import p128m0.C3026b;
import p138n0.AbstractC3155s0;

final class MaterialCalendarGridView extends GridView {

    public final Calendar f6127a;

    public final boolean f6128b;

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final C1807x m4178a() {
        return (C1807x) super.getAdapter();
    }

    public final View m4179b(int i6) {
        return getChildAt(i6 - getFirstVisiblePosition());
    }

    @Override
    public final Adapter getAdapter() {
        return (C1807x) super.getAdapter();
    }

    @Override
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        ((C1807x) super.getAdapter()).notifyDataSetChanged();
    }

    @Override
    public final void onDraw(Canvas canvas) {
        int iM4183m;
        int width;
        int iM4183m2;
        int width2;
        int i6;
        int width3;
        int right;
        MaterialCalendarGridView materialCalendarGridView = this;
        super.onDraw(canvas);
        C1807x c1807x = (C1807x) super.getAdapter();
        DateSelector dateSelector = c1807x.f6241b;
        C1778c c1778c = c1807x.f6243d;
        Month month = c1807x.f6240a;
        int iMax = Math.max(month.m4183m(), getFirstVisiblePosition());
        int iMin = Math.min(c1807x.m4211b(), getLastVisiblePosition());
        Long item = c1807x.getItem(iMax);
        Long item2 = c1807x.getItem(iMin);
        Iterator it = dateSelector.mo4172c().iterator();
        while (it.hasNext()) {
            C3026b c3026b = (C3026b) it.next();
            Object obj = c3026b.f10354a;
            if (obj != null) {
                Object obj2 = c3026b.f10355b;
                if (obj2 != null) {
                    Long l9 = (Long) obj;
                    long jLongValue = l9.longValue();
                    Long l10 = (Long) obj2;
                    long jLongValue2 = l10.longValue();
                    if (item == null || item2 == null || l9.longValue() > item2.longValue() || l10.longValue() < item.longValue()) {
                        materialCalendarGridView = this;
                        month = month;
                        iMax = iMax;
                        it = it;
                        c1807x = c1807x;
                    } else {
                        boolean zM4249i = AbstractC1811a0.m4249i(this);
                        long jLongValue3 = item.longValue();
                        int i10 = month.f6132d;
                        Iterator it2 = it;
                        Calendar calendar = materialCalendarGridView.f6127a;
                        if (jLongValue < jLongValue3) {
                            if (iMax % i10 == 0) {
                                right = 0;
                            } else {
                                right = !zM4249i ? materialCalendarGridView.m4179b(iMax - 1).getRight() : materialCalendarGridView.m4179b(iMax - 1).getLeft();
                            }
                            width = right;
                            iM4183m = iMax;
                        } else {
                            calendar.setTimeInMillis(jLongValue);
                            iM4183m = month.m4183m() + (calendar.get(5) - 1);
                            View viewM4179b = materialCalendarGridView.m4179b(iM4183m);
                            width = (viewM4179b.getWidth() / 2) + viewM4179b.getLeft();
                        }
                        if (jLongValue2 > item2.longValue()) {
                            if ((iMin + 1) % i10 == 0) {
                                width2 = getWidth();
                            } else {
                                width2 = !zM4249i ? materialCalendarGridView.m4179b(iMin).getRight() : materialCalendarGridView.m4179b(iMin).getLeft();
                            }
                            iM4183m2 = iMin;
                        } else {
                            calendar.setTimeInMillis(jLongValue2);
                            iM4183m2 = month.m4183m() + (calendar.get(5) - 1);
                            View viewM4179b2 = materialCalendarGridView.m4179b(iM4183m2);
                            width2 = (viewM4179b2.getWidth() / 2) + viewM4179b2.getLeft();
                        }
                        int itemId = (int) c1807x.getItemId(iM4183m);
                        Month month2 = month;
                        int i11 = iMax;
                        int itemId2 = (int) c1807x.getItemId(iM4183m2);
                        while (itemId <= itemId2) {
                            int numColumns = getNumColumns() * itemId;
                            C1807x c1807x2 = c1807x;
                            int numColumns2 = (getNumColumns() + numColumns) - 1;
                            View viewM4179b3 = materialCalendarGridView.m4179b(numColumns);
                            int top = viewM4179b3.getTop() + ((Rect) c1778c.f6150a.f1070b).top;
                            int i12 = width2;
                            int bottom = viewM4179b3.getBottom() - ((Rect) c1778c.f6150a.f1070b).bottom;
                            if (zM4249i) {
                                int i13 = iM4183m2 > numColumns2 ? 0 : i12;
                                int width4 = numColumns > iM4183m ? getWidth() : width;
                                i6 = i13;
                                width3 = width4;
                            } else {
                                i6 = numColumns > iM4183m ? 0 : width;
                                width3 = iM4183m2 > numColumns2 ? getWidth() : i12;
                            }
                            canvas.drawRect(i6, top, width3, bottom, c1778c.f6157h);
                            itemId++;
                            materialCalendarGridView = this;
                            itemId2 = itemId2;
                            c1807x = c1807x2;
                            width2 = i12;
                        }
                        materialCalendarGridView = this;
                        month = month2;
                        iMax = i11;
                        it = it2;
                    }
                }
            } else {
                materialCalendarGridView = this;
            }
        }
    }

    @Override
    public final void onFocusChanged(boolean z7, int i6, Rect rect) {
        if (!z7) {
            super.onFocusChanged(false, i6, rect);
            return;
        }
        if (i6 == 33) {
            setSelection(((C1807x) super.getAdapter()).m4211b());
        } else if (i6 == 130) {
            setSelection(((C1807x) super.getAdapter()).f6240a.m4183m());
        } else {
            super.onFocusChanged(true, i6, rect);
        }
    }

    @Override
    public final boolean onKeyDown(int i6, KeyEvent keyEvent) {
        if (!super.onKeyDown(i6, keyEvent)) {
            return false;
        }
        if (getSelectedItemPosition() == -1 || getSelectedItemPosition() >= ((C1807x) super.getAdapter()).f6240a.m4183m()) {
            return true;
        }
        if (19 != i6) {
            return false;
        }
        setSelection(((C1807x) super.getAdapter()).f6240a.m4183m());
        return true;
    }

    @Override
    public final void onMeasure(int i6, int i10) {
        if (!this.f6128b) {
            super.onMeasure(i6, i10);
            return;
        }
        super.onMeasure(i6, View.MeasureSpec.makeMeasureSpec(16777215, Integer.MIN_VALUE));
        getLayoutParams().height = getMeasuredHeight();
    }

    @Override
    public final void setSelection(int i6) {
        if (i6 < ((C1807x) super.getAdapter()).f6240a.m4183m()) {
            super.setSelection(((C1807x) super.getAdapter()).f6240a.m4183m());
        } else {
            super.setSelection(i6);
        }
    }

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f6127a = AbstractC1787g0.m4199h(null);
        if (C1804u.m4205V(getContext(), R.attr.windowFullscreen)) {
            setNextFocusLeftId(com.p2serv.android.p032ds.R.id.cancel_button);
            setNextFocusRightId(com.p2serv.android.p032ds.R.id.confirm_button);
        }
        this.f6128b = C1804u.m4205V(getContext(), com.p2serv.android.p032ds.R.attr.nestedScrollable);
        AbstractC3155s0.m6347q(this, new C0376i(2));
    }

    @Override
    public final ListAdapter getAdapter() {
        return (C1807x) super.getAdapter();
    }

    @Override
    public final void setAdapter(ListAdapter listAdapter) {
        if (!(listAdapter instanceof C1807x)) {
            throw new IllegalArgumentException(String.format("%1$s must have its Adapter set to a %2$s", MaterialCalendarGridView.class.getCanonicalName(), C1807x.class.getCanonicalName()));
        }
        super.setAdapter(listAdapter);
    }
}
