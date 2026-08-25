package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.C0210h;
import androidx.appcompat.widget.InterfaceC0230l;
import p045e.AbstractC2341a;
import p105k.AbstractC2824b;
import p105k.C2840n;
import p105k.InterfaceC2837k;
import p105k.InterfaceC2852z;
import p105k.MenuC2838l;
import p187r4.AbstractC3612b;

public class ActionMenuItemView extends AppCompatTextView implements InterfaceC2852z, View.OnClickListener, InterfaceC0230l {

    public C2840n f487h;

    public CharSequence f488i;

    public Drawable f489j;

    public InterfaceC2837k f490k;

    public C0210h f491l;

    public AbstractC2824b f492m;

    public boolean f493n;

    public boolean f494o;

    public final int f495p;

    public int f496q;

    public final int f497r;

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override
    public final boolean mo530a() {
        return !TextUtils.isEmpty(getText());
    }

    @Override
    public final boolean mo531b() {
        return !TextUtils.isEmpty(getText()) && this.f487h.getIcon() == null;
    }

    @Override
    public final void mo532c(C2840n c2840n) {
        this.f487h = c2840n;
        setIcon(c2840n.getIcon());
        setTitle(c2840n.getTitleCondensed());
        setId(c2840n.f9717a);
        setVisibility(c2840n.isVisible() ? 0 : 8);
        setEnabled(c2840n.isEnabled());
        if (c2840n.hasSubMenu() && this.f491l == null) {
            this.f491l = new C0210h(this);
        }
    }

    public final boolean m533g() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int i6 = configuration.screenWidthDp;
        return i6 >= 480 || (i6 >= 640 && configuration.screenHeightDp >= 480) || configuration.orientation == 2;
    }

    @Override
    public CharSequence getAccessibilityClassName() {
        return Button.class.getName();
    }

    @Override
    public C2840n getItemData() {
        return this.f487h;
    }

    public final void m534h() {
        boolean z7 = true;
        boolean z10 = !TextUtils.isEmpty(this.f488i);
        if (this.f489j != null && ((this.f487h.f9741y & 4) != 4 || (!this.f493n && !this.f494o))) {
            z7 = false;
        }
        boolean z11 = z10 & z7;
        setText(z11 ? this.f488i : null);
        CharSequence charSequence = this.f487h.f9733q;
        if (TextUtils.isEmpty(charSequence)) {
            setContentDescription(z11 ? null : this.f487h.f9721e);
        } else {
            setContentDescription(charSequence);
        }
        CharSequence charSequence2 = this.f487h.f9734r;
        if (TextUtils.isEmpty(charSequence2)) {
            AbstractC3612b.m7256L(this, z11 ? null : this.f487h.f9721e);
        } else {
            AbstractC3612b.m7256L(this, charSequence2);
        }
    }

    @Override
    public final void onClick(View view) {
        InterfaceC2837k interfaceC2837k = this.f490k;
        if (interfaceC2837k != null) {
            interfaceC2837k.mo535a(this.f487h);
        }
    }

    @Override
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f493n = m533g();
        m534h();
    }

    @Override
    public final void onMeasure(int i6, int i10) {
        int i11;
        boolean zIsEmpty = TextUtils.isEmpty(getText());
        if (!zIsEmpty && (i11 = this.f496q) >= 0) {
            super.setPadding(i11, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i6, i10);
        int mode = View.MeasureSpec.getMode(i6);
        int size = View.MeasureSpec.getSize(i6);
        int measuredWidth = getMeasuredWidth();
        int i12 = this.f495p;
        int iMin = mode == Integer.MIN_VALUE ? Math.min(size, i12) : i12;
        if (mode != 1073741824 && i12 > 0 && measuredWidth < iMin) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(iMin, 1073741824), i10);
        }
        if (!zIsEmpty || this.f489j == null) {
            return;
        }
        super.setPadding((getMeasuredWidth() - this.f489j.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
    }

    @Override
    public final void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(null);
    }

    @Override
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        C0210h c0210h;
        if (this.f487h.hasSubMenu() && (c0210h = this.f491l) != null && c0210h.onTouch(this, motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setExpandedFormat(boolean z7) {
        if (this.f494o != z7) {
            this.f494o = z7;
            C2840n c2840n = this.f487h;
            if (c2840n != null) {
                MenuC2838l menuC2838l = c2840n.f9730n;
                menuC2838l.f9697k = true;
                menuC2838l.mo4279p(true);
            }
        }
    }

    public void setIcon(Drawable drawable) {
        this.f489j = drawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int i6 = this.f497r;
            if (intrinsicWidth > i6) {
                intrinsicHeight = (int) (intrinsicHeight * (i6 / intrinsicWidth));
                intrinsicWidth = i6;
            }
            if (intrinsicHeight > i6) {
                intrinsicWidth = (int) (intrinsicWidth * (i6 / intrinsicHeight));
            } else {
                i6 = intrinsicHeight;
            }
            drawable.setBounds(0, 0, intrinsicWidth, i6);
        }
        setCompoundDrawables(drawable, null, null, null);
        m534h();
    }

    public void setItemInvoker(InterfaceC2837k interfaceC2837k) {
        this.f490k = interfaceC2837k;
    }

    @Override
    public final void setPadding(int i6, int i10, int i11, int i12) {
        this.f496q = i6;
        super.setPadding(i6, i10, i11, i12);
    }

    public void setPopupCallback(AbstractC2824b abstractC2824b) {
        this.f492m = abstractC2824b;
    }

    public void setTitle(CharSequence charSequence) {
        this.f488i = charSequence;
        m534h();
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        Resources resources = context.getResources();
        this.f493n = m533g();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC2341a.f8155c, i6, 0);
        this.f495p = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        typedArrayObtainStyledAttributes.recycle();
        this.f497r = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        this.f496q = -1;
        setSaveEnabled(false);
    }

    public void setCheckable(boolean z7) {
    }

    public void setChecked(boolean z7) {
    }
}
