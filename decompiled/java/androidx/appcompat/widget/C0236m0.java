package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import android.widget.ListAdapter;
import android.widget.PopupWindow;

public final class C0236m0 extends ListPopupWindow implements InterfaceC0246o0 {

    public CharSequence f1003C;

    public C0221j0 f1004D;

    public final Rect f1005E;

    public int f1006F;

    public final AppCompatSpinner f1007G;

    public C0236m0(AppCompatSpinner appCompatSpinner, Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f1007G = appCompatSpinner;
        this.f1005E = new Rect();
        this.f705o = appCompatSpinner;
        this.f714x = true;
        this.f715y.setFocusable(true);
        this.f706p = new C0226k0(0, this);
    }

    @Override
    public final void mo692g(CharSequence charSequence) {
        this.f1003C = charSequence;
    }

    @Override
    public final void mo695l(int i6) {
        this.f1006F = i6;
    }

    @Override
    public final void mo697n(int i6, int i10) {
        ViewTreeObserver viewTreeObserver;
        PopupWindow popupWindow = this.f715y;
        boolean zIsShowing = popupWindow.isShowing();
        m734s();
        this.f715y.setInputMethodMode(2);
        mo576a();
        C0267s1 c0267s1 = this.f693c;
        c0267s1.setChoiceMode(1);
        AbstractC0206g0.m673d(c0267s1, i6);
        AbstractC0206g0.m672c(c0267s1, i10);
        AppCompatSpinner appCompatSpinner = this.f1007G;
        int selectedItemPosition = appCompatSpinner.getSelectedItemPosition();
        C0267s1 c0267s2 = this.f693c;
        if (popupWindow.isShowing() && c0267s2 != null) {
            c0267s2.setListSelectionHidden(false);
            c0267s2.setSelection(selectedItemPosition);
            if (c0267s2.getChoiceMode() != 0) {
                c0267s2.setItemChecked(selectedItemPosition, true);
            }
        }
        if (zIsShowing || (viewTreeObserver = appCompatSpinner.getViewTreeObserver()) == null) {
            return;
        }
        ViewTreeObserverOnGlobalLayoutListenerC0255q viewTreeObserverOnGlobalLayoutListenerC0255q = new ViewTreeObserverOnGlobalLayoutListenerC0255q(2, this);
        viewTreeObserver.addOnGlobalLayoutListener(viewTreeObserverOnGlobalLayoutListenerC0255q);
        this.f715y.setOnDismissListener(new C0231l0(this, viewTreeObserverOnGlobalLayoutListenerC0255q));
    }

    @Override
    public final CharSequence mo699p() {
        return this.f1003C;
    }

    @Override
    public final void mo586q(ListAdapter listAdapter) {
        super.mo586q(listAdapter);
        this.f1004D = (C0221j0) listAdapter;
    }

    public final void m734s() {
        int i6;
        PopupWindow popupWindow = this.f715y;
        Drawable background = popupWindow.getBackground();
        AppCompatSpinner appCompatSpinner = this.f1007G;
        if (background != null) {
            background.getPadding(appCompatSpinner.f650h);
            boolean zM648a = AbstractC0189c4.m648a(appCompatSpinner);
            Rect rect = appCompatSpinner.f650h;
            i6 = zM648a ? rect.right : -rect.left;
        } else {
            Rect rect2 = appCompatSpinner.f650h;
            rect2.right = 0;
            rect2.left = 0;
            i6 = 0;
        }
        int paddingLeft = appCompatSpinner.getPaddingLeft();
        int paddingRight = appCompatSpinner.getPaddingRight();
        int width = appCompatSpinner.getWidth();
        int i10 = appCompatSpinner.f649g;
        if (i10 == -2) {
            int iM569a = appCompatSpinner.m569a(this.f1004D, popupWindow.getBackground());
            int i11 = appCompatSpinner.getContext().getResources().getDisplayMetrics().widthPixels;
            Rect rect3 = appCompatSpinner.f650h;
            int i12 = (i11 - rect3.left) - rect3.right;
            if (iM569a > i12) {
                iM569a = i12;
            }
            m587r(Math.max(iM569a, (width - paddingLeft) - paddingRight));
        } else if (i10 == -1) {
            m587r((width - paddingLeft) - paddingRight);
        } else {
            m587r(i10);
        }
        this.f696f = AbstractC0189c4.m648a(appCompatSpinner) ? (((width - paddingRight) - this.f695e) - this.f1006F) + i6 : paddingLeft + this.f1006F + i6;
    }
}
