package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import p002a1.C0026b;
import p045e.AbstractC2341a;
import p138n0.AbstractC3106c;
import p138n0.AbstractC3155s0;

public class ActivityChooserView extends ViewGroup {

    public final C0265s f593a;

    public final ViewOnClickListenerC0270t f594b;

    public final View f595c;

    public final FrameLayout f596d;

    public final ImageView f597e;

    public final FrameLayout f598f;

    public AbstractC3106c f599g;

    public final ViewTreeObserverOnGlobalLayoutListenerC0255q f600h;

    public ListPopupWindow f601i;

    public PopupWindow.OnDismissListener f602j;

    public boolean f603k;

    public static class InnerLayout extends LinearLayout {

        public static final int[] f604a = {R.attr.background};

        public InnerLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            C0026b c0026bM110B = C0026b.m110B(context, attributeSet, f604a);
            setBackgroundDrawable(c0026bM110B.m140t(0));
            c0026bM110B.m120F();
        }
    }

    public ActivityChooserView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void m564a() {
        if (m565b()) {
            getListPopupWindow().dismiss();
            ViewTreeObserver viewTreeObserver = getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeGlobalOnLayoutListener(this.f600h);
            }
        }
    }

    public final boolean m565b() {
        return getListPopupWindow().f715y.isShowing();
    }

    public AbstractC0245o getDataModel() {
        this.f593a.getClass();
        return null;
    }

    public ListPopupWindow getListPopupWindow() {
        if (this.f601i == null) {
            ListPopupWindow listPopupWindow = new ListPopupWindow(getContext());
            this.f601i = listPopupWindow;
            listPopupWindow.mo586q(this.f593a);
            ListPopupWindow listPopupWindow2 = this.f601i;
            listPopupWindow2.f705o = this;
            listPopupWindow2.f714x = true;
            listPopupWindow2.f715y.setFocusable(true);
            ListPopupWindow listPopupWindow3 = this.f601i;
            ViewOnClickListenerC0270t viewOnClickListenerC0270t = this.f594b;
            listPopupWindow3.f706p = viewOnClickListenerC0270t;
            listPopupWindow3.f715y.setOnDismissListener(viewOnClickListenerC0270t);
        }
        return this.f601i;
    }

    @Override
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f593a.getClass();
        this.f603k = true;
    }

    @Override
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f593a.getClass();
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.f600h);
        }
        if (m565b()) {
            m564a();
        }
        this.f603k = false;
    }

    @Override
    public final void onLayout(boolean z7, int i6, int i10, int i11, int i12) {
        this.f595c.layout(0, 0, i11 - i6, i12 - i10);
        if (m565b()) {
            return;
        }
        m564a();
    }

    @Override
    public final void onMeasure(int i6, int i10) {
        if (this.f598f.getVisibility() != 0) {
            i10 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i10), 1073741824);
        }
        View view = this.f595c;
        measureChild(view, i6, i10);
        setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    public void setActivityChooserModel(AbstractC0245o abstractC0245o) {
        C0265s c0265s = this.f593a;
        c0265s.f1050a.f593a.getClass();
        c0265s.notifyDataSetChanged();
        if (m565b()) {
            m564a();
            if (m565b() || !this.f603k) {
                return;
            }
            c0265s.getClass();
            throw new IllegalStateException("No data model. Did you call #setDataModel?");
        }
    }

    public void setExpandActivityOverflowButtonContentDescription(int i6) {
        this.f597e.setContentDescription(getContext().getString(i6));
    }

    public void setExpandActivityOverflowButtonDrawable(Drawable drawable) {
        this.f597e.setImageDrawable(drawable);
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.f602j = onDismissListener;
    }

    public void setProvider(AbstractC3106c abstractC3106c) {
        this.f599g = abstractC3106c;
    }

    public ActivityChooserView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        int i10 = 0;
        new C0250p(this, i10);
        this.f600h = new ViewTreeObserverOnGlobalLayoutListenerC0255q(i10, this);
        int[] iArr = AbstractC2341a.f8157e;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i6, 0);
        AbstractC3155s0.m6346p(this, context, iArr, attributeSet, typedArrayObtainStyledAttributes, i6, 0);
        typedArrayObtainStyledAttributes.getInt(1, 4);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(0);
        typedArrayObtainStyledAttributes.recycle();
        LayoutInflater.from(getContext()).inflate(com.p2serv.android.p032ds.R.layout.abc_activity_chooser_view, (ViewGroup) this, true);
        ViewOnClickListenerC0270t viewOnClickListenerC0270t = new ViewOnClickListenerC0270t(this);
        this.f594b = viewOnClickListenerC0270t;
        View viewFindViewById = findViewById(com.p2serv.android.p032ds.R.id.activity_chooser_view_content);
        this.f595c = viewFindViewById;
        viewFindViewById.getBackground();
        FrameLayout frameLayout = (FrameLayout) findViewById(com.p2serv.android.p032ds.R.id.default_activity_button);
        this.f598f = frameLayout;
        frameLayout.setOnClickListener(viewOnClickListenerC0270t);
        frameLayout.setOnLongClickListener(viewOnClickListenerC0270t);
        FrameLayout frameLayout2 = (FrameLayout) findViewById(com.p2serv.android.p032ds.R.id.expand_activities_button);
        frameLayout2.setOnClickListener(viewOnClickListenerC0270t);
        frameLayout2.setAccessibilityDelegate(new C0260r());
        frameLayout2.setOnTouchListener(new C0210h(this, frameLayout2, 1));
        this.f596d = frameLayout2;
        ImageView imageView = (ImageView) frameLayout2.findViewById(com.p2serv.android.p032ds.R.id.image);
        this.f597e = imageView;
        imageView.setImageDrawable(drawable);
        C0265s c0265s = new C0265s(this);
        this.f593a = c0265s;
        c0265s.registerDataSetObserver(new C0250p(this, 1));
        Resources resources = context.getResources();
        Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(com.p2serv.android.p032ds.R.dimen.abc_config_prefDialogWidth));
    }

    public void setDefaultActionButtonContentDescription(int i6) {
    }

    public void setInitialActivityCount(int i6) {
    }
}
