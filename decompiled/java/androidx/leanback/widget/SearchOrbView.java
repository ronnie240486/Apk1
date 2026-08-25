package androidx.leanback.widget;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.p2serv.android.p032ds.R;
import java.util.WeakHashMap;
import p055ea.AbstractC2460q;
import p075h1.AbstractC2639a;
import p138n0.AbstractC3119g0;
import p138n0.AbstractC3155s0;

public class SearchOrbView extends FrameLayout implements View.OnClickListener {

    public static final int f2248s = 0;

    public View.OnClickListener f2249a;

    public final View f2250b;

    public final View f2251c;

    public final ImageView f2252d;

    public Drawable f2253e;

    public C0507y0 f2254f;

    public final float f2255g;

    public final int f2256h;

    public final int f2257i;

    public final float f2258j;

    public final float f2259k;

    public ValueAnimator f2260l;

    public boolean f2261m;

    public boolean f2262n;

    public final ArgbEvaluator f2263o;

    public final C0505x0 f2264p;

    public ValueAnimator f2265q;

    public final C0505x0 f2266r;

    public SearchOrbView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.searchOrbViewStyle);
    }

    public final void m1399a(boolean z7) {
        float f = z7 ? this.f2255g : 1.0f;
        ViewPropertyAnimator viewPropertyAnimatorScaleY = this.f2250b.animate().scaleX(f).scaleY(f);
        long j10 = this.f2257i;
        viewPropertyAnimatorScaleY.setDuration(j10).start();
        if (this.f2265q == null) {
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.f2265q = valueAnimatorOfFloat;
            valueAnimatorOfFloat.addUpdateListener(this.f2266r);
        }
        if (z7) {
            this.f2265q.start();
        } else {
            this.f2265q.reverse();
        }
        this.f2265q.setDuration(j10);
        this.f2261m = z7;
        m1400b();
    }

    public final void m1400b() {
        ValueAnimator valueAnimator = this.f2260l;
        if (valueAnimator != null) {
            valueAnimator.end();
            this.f2260l = null;
        }
        if (this.f2261m && this.f2262n) {
            ValueAnimator valueAnimatorOfObject = ValueAnimator.ofObject(this.f2263o, Integer.valueOf(this.f2254f.f2449a), Integer.valueOf(this.f2254f.f2450b), Integer.valueOf(this.f2254f.f2449a));
            this.f2260l = valueAnimatorOfObject;
            valueAnimatorOfObject.setRepeatCount(-1);
            this.f2260l.setDuration(this.f2256h * 2);
            this.f2260l.addUpdateListener(this.f2264p);
            this.f2260l.start();
        }
    }

    public float getFocusedZoom() {
        return this.f2255g;
    }

    public int getLayoutResourceId() {
        return R.layout.lb_search_orb;
    }

    public int getOrbColor() {
        return this.f2254f.f2449a;
    }

    public C0507y0 getOrbColors() {
        return this.f2254f;
    }

    public Drawable getOrbIcon() {
        return this.f2253e;
    }

    @Override
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f2262n = true;
        m1400b();
    }

    @Override
    public final void onClick(View view) {
        View.OnClickListener onClickListener = this.f2249a;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    @Override
    public final void onDetachedFromWindow() {
        this.f2262n = false;
        m1400b();
        super.onDetachedFromWindow();
    }

    @Override
    public final void onFocusChanged(boolean z7, int i6, Rect rect) {
        super.onFocusChanged(z7, i6, rect);
        m1399a(z7);
    }

    public void setOnOrbClickedListener(View.OnClickListener onClickListener) {
        this.f2249a = onClickListener;
    }

    public void setOrbColor(int i6) {
        setOrbColors(new C0507y0(i6, i6, 0));
    }

    public void setOrbColors(C0507y0 c0507y0) {
        this.f2254f = c0507y0;
        this.f2252d.setColorFilter(c0507y0.f2451c);
        if (this.f2260l == null) {
            setOrbViewColor(this.f2254f.f2449a);
        } else {
            this.f2261m = true;
            m1400b();
        }
    }

    public void setOrbIcon(Drawable drawable) {
        this.f2253e = drawable;
        this.f2252d.setImageDrawable(drawable);
    }

    public void setOrbViewColor(int i6) {
        View view = this.f2251c;
        if (view.getBackground() instanceof GradientDrawable) {
            ((GradientDrawable) view.getBackground()).setColor(i6);
        }
    }

    public void setSearchOrbZ(float f) {
        float f3 = this.f2259k;
        float f4 = this.f2258j;
        float fM5490d = AbstractC2460q.m5490d(f3, f4, f, f4);
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        AbstractC3119g0.m6185x(this.f2251c, fM5490d);
    }

    @SuppressLint({"CustomViewStyleable"})
    public SearchOrbView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f2263o = new ArgbEvaluator();
        final int i10 = 0;
        this.f2264p = new ValueAnimator.AnimatorUpdateListener(this) {

            public final SearchOrbView f2448b;

            {
                this.f2448b = this;
            }

            @Override
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                SearchOrbView searchOrbView = this.f2448b;
                switch (i10) {
                    case 0:
                        int i11 = SearchOrbView.f2248s;
                        searchOrbView.getClass();
                        searchOrbView.setOrbViewColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
                        break;
                    default:
                        int i12 = SearchOrbView.f2248s;
                        searchOrbView.getClass();
                        searchOrbView.setSearchOrbZ(valueAnimator.getAnimatedFraction());
                        break;
                }
            }
        };
        final int i11 = 1;
        this.f2266r = new ValueAnimator.AnimatorUpdateListener(this) {

            public final SearchOrbView f2448b;

            {
                this.f2448b = this;
            }

            @Override
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                SearchOrbView searchOrbView = this.f2448b;
                switch (i11) {
                    case 0:
                        int i12 = SearchOrbView.f2248s;
                        searchOrbView.getClass();
                        searchOrbView.setOrbViewColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
                        break;
                    default:
                        int i13 = SearchOrbView.f2248s;
                        searchOrbView.getClass();
                        searchOrbView.setSearchOrbZ(valueAnimator.getAnimatedFraction());
                        break;
                }
            }
        };
        Resources resources = context.getResources();
        View viewInflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(getLayoutResourceId(), (ViewGroup) this, true);
        this.f2250b = viewInflate;
        this.f2251c = viewInflate.findViewById(R.id.search_orb);
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.icon);
        this.f2252d = imageView;
        this.f2255g = context.getResources().getFraction(R.fraction.lb_search_orb_focused_zoom, 1, 1);
        this.f2256h = context.getResources().getInteger(R.integer.lb_search_orb_pulse_duration_ms);
        this.f2257i = context.getResources().getInteger(R.integer.lb_search_orb_scale_duration_ms);
        float dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.lb_search_orb_focused_z);
        this.f2259k = dimensionPixelSize;
        this.f2258j = context.getResources().getDimensionPixelSize(R.dimen.lb_search_orb_unfocused_z);
        int[] iArr = AbstractC2639a.f9166j;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i6, 0);
        AbstractC3155s0.m6346p(this, context, iArr, attributeSet, typedArrayObtainStyledAttributes, i6, 0);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(2);
        setOrbIcon(drawable == null ? resources.getDrawable(R.drawable.lb_ic_in_app_search) : drawable);
        int color = typedArrayObtainStyledAttributes.getColor(1, resources.getColor(R.color.lb_default_search_color));
        setOrbColors(new C0507y0(color, typedArrayObtainStyledAttributes.getColor(0, color), typedArrayObtainStyledAttributes.getColor(3, 0)));
        typedArrayObtainStyledAttributes.recycle();
        setFocusable(true);
        setClipChildren(false);
        setOnClickListener(this);
        setSoundEffectsEnabled(false);
        setSearchOrbZ(0.0f);
        AbstractC3119g0.m6185x(imageView, dimensionPixelSize);
    }
}
