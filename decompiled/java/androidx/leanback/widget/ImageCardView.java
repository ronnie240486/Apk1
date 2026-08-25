package androidx.leanback.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.p2serv.android.p032ds.R;
import p075h1.AbstractC2639a;
import p138n0.AbstractC3155s0;

public class ImageCardView extends BaseCardView {

    public final ImageView f2154s;

    public final ViewGroup f2155t;

    public final TextView f2156u;

    public final TextView f2157v;

    public final ImageView f2158w;

    public boolean f2159x;

    public final ObjectAnimator f2160y;

    public ImageCardView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        setFocusable(true);
        setFocusableInTouchMode(true);
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
        layoutInflaterFrom.inflate(R.layout.lb_image_card_view, this);
        Context context2 = getContext();
        int[] iArr = AbstractC2639a.f9162f;
        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, iArr, i6, R.style.Widget_Leanback_ImageCardView);
        AbstractC3155s0.m6346p(this, getContext(), iArr, attributeSet, typedArrayObtainStyledAttributes, i6, R.style.Widget_Leanback_ImageCardView);
        int i10 = typedArrayObtainStyledAttributes.getInt(1, 0);
        boolean z7 = i10 == 0;
        boolean z10 = (i10 & 1) == 1;
        boolean z11 = (i10 & 2) == 2;
        boolean z12 = (i10 & 4) == 4;
        boolean z13 = !z12 && (i10 & 8) == 8;
        ImageView imageView = (ImageView) findViewById(R.id.main_image);
        this.f2154s = imageView;
        if (imageView.getDrawable() == null) {
            this.f2154s.setVisibility(4);
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f2154s, "alpha", 1.0f);
        this.f2160y = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setDuration(this.f2154s.getResources().getInteger(android.R.integer.config_shortAnimTime));
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.info_field);
        this.f2155t = viewGroup;
        if (z7) {
            removeView(viewGroup);
            typedArrayObtainStyledAttributes.recycle();
            return;
        }
        if (z10) {
            TextView textView = (TextView) layoutInflaterFrom.inflate(R.layout.lb_image_card_view_themed_title, viewGroup, false);
            this.f2156u = textView;
            this.f2155t.addView(textView);
        }
        if (z11) {
            TextView textView2 = (TextView) layoutInflaterFrom.inflate(R.layout.lb_image_card_view_themed_content, this.f2155t, false);
            this.f2157v = textView2;
            this.f2155t.addView(textView2);
        }
        if (z12 || z13) {
            ImageView imageView2 = (ImageView) layoutInflaterFrom.inflate(z13 ? R.layout.lb_image_card_view_themed_badge_left : R.layout.lb_image_card_view_themed_badge_right, this.f2155t, false);
            this.f2158w = imageView2;
            this.f2155t.addView(imageView2);
        }
        if (z10 && !z11 && this.f2158w != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f2156u.getLayoutParams();
            if (z13) {
                layoutParams.addRule(17, this.f2158w.getId());
            } else {
                layoutParams.addRule(16, this.f2158w.getId());
            }
            this.f2156u.setLayoutParams(layoutParams);
        }
        if (z11) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f2157v.getLayoutParams();
            if (!z10) {
                layoutParams2.addRule(10);
            }
            if (z13) {
                layoutParams2.removeRule(16);
                layoutParams2.removeRule(20);
                layoutParams2.addRule(17, this.f2158w.getId());
            }
            this.f2157v.setLayoutParams(layoutParams2);
        }
        ImageView imageView3 = this.f2158w;
        if (imageView3 != null) {
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) imageView3.getLayoutParams();
            if (z11) {
                layoutParams3.addRule(8, this.f2157v.getId());
            } else if (z10) {
                layoutParams3.addRule(8, this.f2156u.getId());
            }
            this.f2158w.setLayoutParams(layoutParams3);
        }
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(0);
        if (drawable != null) {
            setInfoAreaBackground(drawable);
        }
        ImageView imageView4 = this.f2158w;
        if (imageView4 != null && imageView4.getDrawable() == null) {
            this.f2158w.setVisibility(8);
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public Drawable getBadgeImage() {
        ImageView imageView = this.f2158w;
        if (imageView == null) {
            return null;
        }
        return imageView.getDrawable();
    }

    public CharSequence getContentText() {
        TextView textView = this.f2157v;
        if (textView == null) {
            return null;
        }
        return textView.getText();
    }

    public Drawable getInfoAreaBackground() {
        ViewGroup viewGroup = this.f2155t;
        if (viewGroup != null) {
            return viewGroup.getBackground();
        }
        return null;
    }

    public Drawable getMainImage() {
        ImageView imageView = this.f2154s;
        if (imageView == null) {
            return null;
        }
        return imageView.getDrawable();
    }

    public final ImageView getMainImageView() {
        return this.f2154s;
    }

    public CharSequence getTitleText() {
        TextView textView = this.f2156u;
        if (textView == null) {
            return null;
        }
        return textView.getText();
    }

    @Override
    public final boolean hasOverlappingRendering() {
        return false;
    }

    @Override
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f2159x = true;
        if (this.f2154s.getAlpha() == 0.0f) {
            this.f2154s.setAlpha(0.0f);
            if (this.f2159x) {
                this.f2160y.start();
            }
        }
    }

    @Override
    public final void onDetachedFromWindow() {
        this.f2159x = false;
        this.f2160y.cancel();
        this.f2154s.setAlpha(1.0f);
        super.onDetachedFromWindow();
    }

    public void setBadgeImage(Drawable drawable) {
        ImageView imageView = this.f2158w;
        if (imageView == null) {
            return;
        }
        imageView.setImageDrawable(drawable);
        if (drawable != null) {
            this.f2158w.setVisibility(0);
        } else {
            this.f2158w.setVisibility(8);
        }
    }

    public void setContentText(CharSequence charSequence) {
        TextView textView = this.f2157v;
        if (textView == null) {
            return;
        }
        textView.setText(charSequence);
    }

    public void setInfoAreaBackground(Drawable drawable) {
        ViewGroup viewGroup = this.f2155t;
        if (viewGroup != null) {
            viewGroup.setBackground(drawable);
        }
    }

    public void setInfoAreaBackgroundColor(int i6) {
        ViewGroup viewGroup = this.f2155t;
        if (viewGroup != null) {
            viewGroup.setBackgroundColor(i6);
        }
    }

    public void setMainImage(Drawable drawable) {
        ImageView imageView = this.f2154s;
        if (imageView == null) {
            return;
        }
        imageView.setImageDrawable(drawable);
        if (drawable == null) {
            this.f2160y.cancel();
            this.f2154s.setAlpha(1.0f);
            this.f2154s.setVisibility(4);
        } else {
            this.f2154s.setVisibility(0);
            this.f2154s.setAlpha(0.0f);
            if (this.f2159x) {
                this.f2160y.start();
            }
        }
    }

    public void setMainImageAdjustViewBounds(boolean z7) {
        ImageView imageView = this.f2154s;
        if (imageView != null) {
            imageView.setAdjustViewBounds(z7);
        }
    }

    public void setMainImageScaleType(ImageView.ScaleType scaleType) {
        ImageView imageView = this.f2154s;
        if (imageView != null) {
            imageView.setScaleType(scaleType);
        }
    }

    public void setTitleText(CharSequence charSequence) {
        TextView textView = this.f2156u;
        if (textView == null) {
            return;
        }
        textView.setText(charSequence);
    }

    public ImageCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.imageCardViewStyle);
    }
}
