package com.google.android.material.datepicker;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.AbstractC0410j0;
import androidx.fragment.app.C0391a;
import androidx.fragment.app.DialogInterfaceOnCancelListenerC0415m;
import androidx.leanback.widget.C0476j1;
import com.bumptech.glide.AbstractC1465c;
import com.google.android.material.internal.CheckableImageButton;
import com.p2serv.android.p032ds.R;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.WeakHashMap;
import p056f0.AbstractC2478a;
import p079h6.ViewOnTouchListenerC2662a;
import p138n0.AbstractC3108c1;
import p138n0.AbstractC3119g0;
import p138n0.AbstractC3155s0;
import p138n0.C3156s1;
import p138n0.C3159t1;
import p138n0.C3162u1;
import p138n0.C3165v1;
import p156o9.AbstractC3281e;
import p221u6.C3908h;

public final class C1804u<S> extends DialogInterfaceOnCancelListenerC0415m {

    public CharSequence f6213A0;

    public TextView f6214B0;

    public CheckableImageButton f6215C0;

    public C3908h f6216D0;

    public Button f6217E0;

    public boolean f6218F0;

    public final LinkedHashSet f6219k0 = new LinkedHashSet();

    public final LinkedHashSet f6220l0 = new LinkedHashSet();

    public final LinkedHashSet f6221m0 = new LinkedHashSet();

    public final LinkedHashSet f6222n0 = new LinkedHashSet();

    public int f6223o0;

    public DateSelector f6224p0;

    public AbstractC1777b0 f6225q0;

    public CalendarConstraints f6226r0;

    public C1801r f6227s0;

    public int f6228t0;

    public CharSequence f6229u0;

    public boolean f6230v0;

    public int f6231w0;

    public int f6232x0;

    public CharSequence f6233y0;

    public int f6234z0;

    public static int m4204U(Context context) {
        Resources resources = context.getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_content_padding);
        Month month = new Month(AbstractC1787g0.m4198g());
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.mtrl_calendar_day_width);
        int dimensionPixelOffset2 = resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_month_horizontal_padding);
        int i6 = month.f6132d;
        return ((i6 - 1) * dimensionPixelOffset2) + (dimensionPixelSize * i6) + (dimensionPixelOffset * 2);
    }

    public static boolean m4205V(Context context, int i6) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(AbstractC1465c.m3478m(context, R.attr.materialCalendarStyle, C1801r.class.getCanonicalName()), new int[]{i6});
        boolean z7 = typedArrayObtainStyledAttributes.getBoolean(0, false);
        typedArrayObtainStyledAttributes.recycle();
        return z7;
    }

    @Override
    public final void mo1269A(Bundle bundle) {
        super.mo1269A(bundle);
        bundle.putInt("OVERRIDE_THEME_RES_ID", this.f6223o0);
        bundle.putParcelable("DATE_SELECTOR_KEY", this.f6224p0);
        CalendarConstraints calendarConstraints = this.f6226r0;
        C1776b c1776b = new C1776b();
        int i6 = C1776b.f6146c;
        int i10 = C1776b.f6146c;
        new DateValidatorPointForward(Long.MIN_VALUE);
        long j10 = calendarConstraints.f6115a.f6134f;
        long j11 = calendarConstraints.f6116b.f6134f;
        c1776b.f6147a = Long.valueOf(calendarConstraints.f6118d.f6134f);
        CalendarConstraints.DateValidator dateValidator = calendarConstraints.f6117c;
        c1776b.f6148b = dateValidator;
        Month month = this.f6227s0.f6202X;
        if (month != null) {
            c1776b.f6147a = Long.valueOf(month.f6134f);
        }
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("DEEP_COPY_VALIDATOR_KEY", dateValidator);
        Month monthM4181l = Month.m4181l(j10);
        Month monthM4181l2 = Month.m4181l(j11);
        CalendarConstraints.DateValidator dateValidator2 = (CalendarConstraints.DateValidator) bundle2.getParcelable("DEEP_COPY_VALIDATOR_KEY");
        Long l9 = c1776b.f6147a;
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", new CalendarConstraints(monthM4181l, monthM4181l2, dateValidator2, l9 == null ? null : Month.m4181l(l9.longValue())));
        bundle.putInt("TITLE_TEXT_RES_ID_KEY", this.f6228t0);
        bundle.putCharSequence("TITLE_TEXT_KEY", this.f6229u0);
        bundle.putInt("POSITIVE_BUTTON_TEXT_RES_ID_KEY", this.f6232x0);
        bundle.putCharSequence("POSITIVE_BUTTON_TEXT_KEY", this.f6233y0);
        bundle.putInt("NEGATIVE_BUTTON_TEXT_RES_ID_KEY", this.f6234z0);
        bundle.putCharSequence("NEGATIVE_BUTTON_TEXT_KEY", this.f6213A0);
    }

    @Override
    public final void mo1270B() {
        AbstractC3281e c3159t1;
        super.mo1270B();
        Dialog dialog = this.f1908f0;
        if (dialog == null) {
            throw new IllegalStateException("DialogFragment " + this + " does not have a Dialog.");
        }
        Window window = dialog.getWindow();
        if (this.f6230v0) {
            window.setLayout(-1, -1);
            window.setBackgroundDrawable(this.f6216D0);
            if (!this.f6218F0) {
                View viewFindViewById = m1313L().findViewById(R.id.fullscreen_header);
                Integer numValueOf = viewFindViewById.getBackground() instanceof ColorDrawable ? Integer.valueOf(((ColorDrawable) viewFindViewById.getBackground()).getColor()) : null;
                int i6 = Build.VERSION.SDK_INT;
                boolean z7 = false;
                boolean z10 = numValueOf == null || numValueOf.intValue() == 0;
                int iM6627q = AbstractC3281e.m6627q(window.getContext(), android.R.attr.colorBackground, -16777216);
                if (z10) {
                    numValueOf = Integer.valueOf(iM6627q);
                }
                if (i6 >= 30) {
                    AbstractC3108c1.m6126a(window, false);
                } else {
                    View decorView = window.getDecorView();
                    decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 1792);
                }
                int iM5513h = i6 < 23 ? AbstractC2478a.m5513h(AbstractC3281e.m6627q(window.getContext(), android.R.attr.statusBarColor, -16777216), 128) : 0;
                int iM5513h2 = i6 < 27 ? AbstractC2478a.m5513h(AbstractC3281e.m6627q(window.getContext(), android.R.attr.navigationBarColor, -16777216), 128) : 0;
                window.setStatusBarColor(iM5513h);
                window.setNavigationBarColor(iM5513h2);
                boolean z11 = AbstractC3281e.m6630t(iM5513h) || (iM5513h == 0 && AbstractC3281e.m6630t(numValueOf.intValue()));
                boolean zM6630t = AbstractC3281e.m6630t(iM6627q);
                if (AbstractC3281e.m6630t(iM5513h2) || (iM5513h2 == 0 && zM6630t)) {
                    z7 = true;
                }
                window.getDecorView();
                int i10 = Build.VERSION.SDK_INT;
                if (i10 >= 30) {
                    c3159t1 = new C3165v1(window);
                } else if (i10 >= 26) {
                    c3159t1 = new C3162u1(window);
                } else {
                    c3159t1 = i10 >= 23 ? new C3159t1(window) : new C3156s1(window);
                }
                c3159t1.mo6354G(z11);
                c3159t1.mo6357F(z7);
                int paddingTop = viewFindViewById.getPaddingTop();
                int i11 = viewFindViewById.getLayoutParams().height;
                C0476j1 c0476j1 = new C0476j1();
                c0476j1.f2351a = i11;
                c0476j1.f2353c = viewFindViewById;
                c0476j1.f2352b = paddingTop;
                WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
                AbstractC3119g0.m6182u(viewFindViewById, c0476j1);
                this.f6218F0 = true;
            }
        } else {
            window.setLayout(-2, -2);
            int dimensionPixelOffset = m1324m().getDimensionPixelOffset(R.dimen.mtrl_calendar_dialog_background_inset);
            Rect rect = new Rect(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
            window.setBackgroundDrawable(new InsetDrawable((Drawable) this.f6216D0, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset));
            View decorView2 = window.getDecorView();
            Dialog dialog2 = this.f1908f0;
            if (dialog2 == null) {
                throw new IllegalStateException("DialogFragment " + this + " does not have a Dialog.");
            }
            decorView2.setOnTouchListener(new ViewOnTouchListenerC2662a(dialog2, rect));
        }
        m4207W();
    }

    @Override
    public final void mo1271C() {
        this.f6225q0.f6149T.clear();
        super.mo1271C();
    }

    @Override
    public final Dialog mo1275R() {
        Context contextM1312K = m1312K();
        Context contextM1312K2 = m1312K();
        int iMo4171b = this.f6223o0;
        if (iMo4171b == 0) {
            iMo4171b = m4206T().mo4171b(contextM1312K2);
        }
        Dialog dialog = new Dialog(contextM1312K, iMo4171b);
        Context context = dialog.getContext();
        this.f6230v0 = m4205V(context, android.R.attr.windowFullscreen);
        int iM3478m = AbstractC1465c.m3478m(context, R.attr.colorSurface, C1804u.class.getCanonicalName());
        C3908h c3908h = new C3908h(context, null, R.attr.materialCalendarStyle, R.style.Widget_MaterialComponents_MaterialCalendar);
        this.f6216D0 = c3908h;
        c3908h.m7806k(context);
        this.f6216D0.m7809n(ColorStateList.valueOf(iM3478m));
        C3908h c3908h2 = this.f6216D0;
        View decorView = dialog.getWindow().getDecorView();
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        c3908h2.m7808m(AbstractC3119g0.m6170i(decorView));
        return dialog;
    }

    public final DateSelector m4206T() {
        if (this.f6224p0 == null) {
            this.f6224p0 = (DateSelector) this.f1970g.getParcelable("DATE_SELECTOR_KEY");
        }
        return this.f6224p0;
    }

    public final void m4207W() {
        Context contextM1312K = m1312K();
        int iMo4171b = this.f6223o0;
        if (iMo4171b == 0) {
            iMo4171b = m4206T().mo4171b(contextM1312K);
        }
        DateSelector dateSelectorM4206T = m4206T();
        CalendarConstraints calendarConstraints = this.f6226r0;
        C1801r c1801r = new C1801r();
        Bundle bundle = new Bundle();
        bundle.putInt("THEME_RES_ID_KEY", iMo4171b);
        bundle.putParcelable("GRID_SELECTOR_KEY", dateSelectorM4206T);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", calendarConstraints);
        bundle.putParcelable("CURRENT_MONTH_KEY", calendarConstraints.f6118d);
        c1801r.m1316O(bundle);
        this.f6227s0 = c1801r;
        AbstractC1777b0 abstractC1777b0 = c1801r;
        if (this.f6215C0.f6319d) {
            DateSelector dateSelectorM4206T2 = m4206T();
            CalendarConstraints calendarConstraints2 = this.f6226r0;
            C1805v c1805v = new C1805v();
            Bundle bundle2 = new Bundle();
            bundle2.putInt("THEME_RES_ID_KEY", iMo4171b);
            bundle2.putParcelable("DATE_SELECTOR_KEY", dateSelectorM4206T2);
            bundle2.putParcelable("CALENDAR_CONSTRAINTS_KEY", calendarConstraints2);
            c1805v.m1316O(bundle2);
            abstractC1777b0 = c1805v;
        }
        this.f6225q0 = abstractC1777b0;
        m4208X();
        AbstractC0410j0 abstractC0410j0M1320i = m1320i();
        abstractC0410j0M1320i.getClass();
        C0391a c0391a = new C0391a(abstractC0410j0M1320i);
        c0391a.m1194i(R.id.mtrl_calendar_frame, this.f6225q0);
        if (c0391a.f1807g) {
            throw new IllegalStateException("This transaction is already being added to the back stack");
        }
        c0391a.f1808h = false;
        c0391a.f1817q.m1260v(c0391a, false);
        this.f6225q0.mo4188Q(new C1803t(0, this));
    }

    public final void m4208X() {
        String strMo4170a = m4206T().mo4170a(m1321j());
        this.f6214B0.setContentDescription(String.format(m1325n(R.string.mtrl_picker_announce_current_selection), strMo4170a));
        this.f6214B0.setText(strMo4170a);
    }

    public final void m4209Y(CheckableImageButton checkableImageButton) {
        this.f6215C0.setContentDescription(this.f6215C0.f6319d ? checkableImageButton.getContext().getString(R.string.mtrl_picker_toggle_to_calendar_input_mode) : checkableImageButton.getContext().getString(R.string.mtrl_picker_toggle_to_text_input_mode));
    }

    @Override
    public final void onCancel(DialogInterface dialogInterface) {
        Iterator it = this.f6221m0.iterator();
        while (it.hasNext()) {
            ((DialogInterface.OnCancelListener) it.next()).onCancel(dialogInterface);
        }
    }

    @Override
    public final void onDismiss(DialogInterface dialogInterface) {
        Iterator it = this.f6222n0.iterator();
        while (it.hasNext()) {
            ((DialogInterface.OnDismissListener) it.next()).onDismiss(dialogInterface);
        }
        ViewGroup viewGroup = (ViewGroup) this.f1951F;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        super.onDismiss(dialogInterface);
    }

    @Override
    public final void mo1279s(Bundle bundle) {
        super.mo1279s(bundle);
        if (bundle == null) {
            bundle = this.f1970g;
        }
        this.f6223o0 = bundle.getInt("OVERRIDE_THEME_RES_ID");
        this.f6224p0 = (DateSelector) bundle.getParcelable("DATE_SELECTOR_KEY");
        this.f6226r0 = (CalendarConstraints) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.f6228t0 = bundle.getInt("TITLE_TEXT_RES_ID_KEY");
        this.f6229u0 = bundle.getCharSequence("TITLE_TEXT_KEY");
        this.f6231w0 = bundle.getInt("INPUT_MODE_KEY");
        this.f6232x0 = bundle.getInt("POSITIVE_BUTTON_TEXT_RES_ID_KEY");
        this.f6233y0 = bundle.getCharSequence("POSITIVE_BUTTON_TEXT_KEY");
        this.f6234z0 = bundle.getInt("NEGATIVE_BUTTON_TEXT_RES_ID_KEY");
        this.f6213A0 = bundle.getCharSequence("NEGATIVE_BUTTON_TEXT_KEY");
    }

    @Override
    public final View mo1329t(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i6 = 0;
        int i10 = 1;
        View viewInflate = layoutInflater.inflate(this.f6230v0 ? R.layout.mtrl_picker_fullscreen : R.layout.mtrl_picker_dialog, viewGroup);
        Context context = viewInflate.getContext();
        if (this.f6230v0) {
            viewInflate.findViewById(R.id.mtrl_calendar_frame).setLayoutParams(new LinearLayout.LayoutParams(m4204U(context), -2));
        } else {
            viewInflate.findViewById(R.id.mtrl_calendar_main_pane).setLayoutParams(new LinearLayout.LayoutParams(m4204U(context), -1));
        }
        TextView textView = (TextView) viewInflate.findViewById(R.id.mtrl_picker_header_selection_text);
        this.f6214B0 = textView;
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        textView.setAccessibilityLiveRegion(1);
        this.f6215C0 = (CheckableImageButton) viewInflate.findViewById(R.id.mtrl_picker_header_toggle);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.mtrl_picker_title_text);
        CharSequence charSequence = this.f6229u0;
        if (charSequence != null) {
            textView2.setText(charSequence);
        } else {
            textView2.setText(this.f6228t0);
        }
        this.f6215C0.setTag("TOGGLE_BUTTON_TAG");
        CheckableImageButton checkableImageButton = this.f6215C0;
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{android.R.attr.state_checked}, AbstractC1465c.m3473h(context, R.drawable.material_ic_calendar_black_24dp));
        stateListDrawable.addState(new int[0], AbstractC1465c.m3473h(context, R.drawable.material_ic_edit_black_24dp));
        checkableImageButton.setImageDrawable(stateListDrawable);
        this.f6215C0.setChecked(this.f6231w0 != 0);
        AbstractC3155s0.m6347q(this.f6215C0, null);
        m4209Y(this.f6215C0);
        this.f6215C0.setOnClickListener(new ViewOnClickListenerC1802s(this, 2));
        this.f6217E0 = (Button) viewInflate.findViewById(R.id.confirm_button);
        if (m4206T().mo4174f()) {
            this.f6217E0.setEnabled(true);
        } else {
            this.f6217E0.setEnabled(false);
        }
        this.f6217E0.setTag("CONFIRM_BUTTON_TAG");
        CharSequence charSequence2 = this.f6233y0;
        if (charSequence2 != null) {
            this.f6217E0.setText(charSequence2);
        } else {
            int i11 = this.f6232x0;
            if (i11 != 0) {
                this.f6217E0.setText(i11);
            }
        }
        this.f6217E0.setOnClickListener(new ViewOnClickListenerC1802s(this, i6));
        Button button = (Button) viewInflate.findViewById(R.id.cancel_button);
        button.setTag("CANCEL_BUTTON_TAG");
        CharSequence charSequence3 = this.f6213A0;
        if (charSequence3 != null) {
            button.setText(charSequence3);
        } else {
            int i12 = this.f6234z0;
            if (i12 != 0) {
                button.setText(i12);
            }
        }
        button.setOnClickListener(new ViewOnClickListenerC1802s(this, i10));
        return viewInflate;
    }
}
