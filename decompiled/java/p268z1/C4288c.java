package p268z1;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import p046e0.AbstractC2343b;
import p046e0.AbstractC2350i;
import p046e0.AbstractC2355n;
import p064g.C2579f;
import p065g0.AbstractC2581a;
import p086i3.C2687c;
import p143n5.AbstractC3198d;
import p160p.C3341e;

public final class C4288c extends AbstractC4290e implements Animatable {

    public final Context f14526c;

    public final C2579f f14527d = new C2579f(this);

    public final C4287b f14525b = new C4287b();

    public C4288c(Context context) {
        this.f14526c = context;
    }

    @Override
    public final void applyTheme(Resources.Theme theme) {
        Drawable drawable = this.f14529a;
        if (drawable != null) {
            AbstractC2581a.m5579a(drawable, theme);
        }
    }

    @Override
    public final boolean canApplyTheme() {
        Drawable drawable = this.f14529a;
        if (drawable != null) {
            return AbstractC2581a.m5580b(drawable);
        }
        return false;
    }

    @Override
    public final void draw(Canvas canvas) {
        Drawable drawable = this.f14529a;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        C4287b c4287b = this.f14525b;
        c4287b.f14521a.draw(canvas);
        if (c4287b.f14522b.isStarted()) {
            invalidateSelf();
        }
    }

    @Override
    public final int getAlpha() {
        Drawable drawable = this.f14529a;
        return drawable != null ? drawable.getAlpha() : this.f14525b.f14521a.getAlpha();
    }

    @Override
    public final int getChangingConfigurations() {
        Drawable drawable = this.f14529a;
        if (drawable != null) {
            return drawable.getChangingConfigurations();
        }
        int changingConfigurations = super.getChangingConfigurations();
        this.f14525b.getClass();
        return changingConfigurations;
    }

    @Override
    public final ColorFilter getColorFilter() {
        Drawable drawable = this.f14529a;
        return drawable != null ? AbstractC2581a.m5581c(drawable) : this.f14525b.f14521a.getColorFilter();
    }

    @Override
    public final Drawable.ConstantState getConstantState() {
        if (this.f14529a == null || Build.VERSION.SDK_INT < 24) {
            return null;
        }
        return new C2687c(2, this.f14529a.getConstantState());
    }

    @Override
    public final int getIntrinsicHeight() {
        Drawable drawable = this.f14529a;
        return drawable != null ? drawable.getIntrinsicHeight() : this.f14525b.f14521a.getIntrinsicHeight();
    }

    @Override
    public final int getIntrinsicWidth() {
        Drawable drawable = this.f14529a;
        return drawable != null ? drawable.getIntrinsicWidth() : this.f14525b.f14521a.getIntrinsicWidth();
    }

    @Override
    public final int getOpacity() {
        Drawable drawable = this.f14529a;
        return drawable != null ? drawable.getOpacity() : this.f14525b.f14521a.getOpacity();
    }

    @Override
    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        C4287b c4287b;
        Animator animatorM8344a;
        C4299n c4299n;
        int next;
        Drawable drawable = this.f14529a;
        if (drawable != null) {
            AbstractC2581a.m5582d(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        while (true) {
            c4287b = this.f14525b;
            if (eventType == 1 || (xmlPullParser.getDepth() < depth && eventType == 3)) {
                break;
            }
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if ("animated-vector".equals(name)) {
                    TypedArray typedArrayM5322h = AbstractC2343b.m5322h(resources, theme, attributeSet, AbstractC4286a.f14514e);
                    int resourceId = typedArrayM5322h.getResourceId(0, 0);
                    if (resourceId != 0) {
                        PorterDuff.Mode mode = C4299n.f14584j;
                        if (Build.VERSION.SDK_INT >= 24) {
                            c4299n = new C4299n();
                            ThreadLocal threadLocal = AbstractC2355n.f8209a;
                            c4299n.f14529a = AbstractC2350i.m5332a(resources, resourceId, theme);
                            new C4298m(c4299n.f14529a.getConstantState());
                        } else {
                            try {
                                XmlResourceParser xml = resources.getXml(resourceId);
                                AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
                                do {
                                    next = xml.next();
                                    if (next == 2) {
                                        break;
                                    }
                                } while (next != 1);
                                if (next != 2) {
                                    throw new XmlPullParserException("No start tag found");
                                }
                                c4299n = new C4299n();
                                c4299n.inflate(resources, xml, attributeSetAsAttributeSet, theme);
                            } catch (IOException e5) {
                                Log.e("VectorDrawableCompat", "parser error", e5);
                                c4299n = null;
                            } catch (XmlPullParserException e10) {
                                Log.e("VectorDrawableCompat", "parser error", e10);
                                c4299n = null;
                            }
                        }
                        c4299n.f14589f = false;
                        c4299n.setCallback(this.f14527d);
                        C4299n c4299n2 = c4287b.f14521a;
                        if (c4299n2 != null) {
                            c4299n2.setCallback(null);
                        }
                        c4287b.f14521a = c4299n;
                    }
                    typedArrayM5322h.recycle();
                } else {
                    XmlResourceParser animation = null;
                    if ("target".equals(name)) {
                        TypedArray typedArrayObtainAttributes = resources.obtainAttributes(attributeSet, AbstractC4286a.f14515f);
                        String string = typedArrayObtainAttributes.getString(0);
                        int resourceId2 = typedArrayObtainAttributes.getResourceId(1, 0);
                        if (resourceId2 != 0) {
                            Context context = this.f14526c;
                            if (context == null) {
                                typedArrayObtainAttributes.recycle();
                                throw new IllegalStateException("Context can't be null when inflating animators");
                            }
                            if (Build.VERSION.SDK_INT >= 24) {
                                animatorM8344a = AnimatorInflater.loadAnimator(context, resourceId2);
                            } else {
                                Resources resources2 = context.getResources();
                                Resources.Theme theme2 = context.getTheme();
                                try {
                                    try {
                                        try {
                                            animation = resources2.getAnimation(resourceId2);
                                            animatorM8344a = AbstractC4286a.m8344a(context, resources2, theme2, animation, Xml.asAttributeSet(animation), null, 0);
                                            animation.close();
                                        } catch (IOException e11) {
                                            Resources.NotFoundException notFoundException = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(resourceId2));
                                            notFoundException.initCause(e11);
                                            throw notFoundException;
                                        }
                                    } catch (XmlPullParserException e12) {
                                        Resources.NotFoundException notFoundException2 = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(resourceId2));
                                        notFoundException2.initCause(e12);
                                        throw notFoundException2;
                                    }
                                } catch (Throwable th) {
                                    if (animation != null) {
                                        animation.close();
                                    }
                                    throw th;
                                }
                            }
                            animatorM8344a.setTarget(c4287b.f14521a.f14585b.f14572b.f14570o.get(string));
                            if (c4287b.f14523c == null) {
                                c4287b.f14523c = new ArrayList();
                                c4287b.f14524d = new C3341e(0);
                            }
                            c4287b.f14523c.add(animatorM8344a);
                            c4287b.f14524d.put(animatorM8344a, string);
                        }
                        typedArrayObtainAttributes.recycle();
                    } else {
                        continue;
                    }
                }
            }
            eventType = xmlPullParser.next();
        }
        if (c4287b.f14522b == null) {
            c4287b.f14522b = new AnimatorSet();
        }
        c4287b.f14522b.playTogether(c4287b.f14523c);
    }

    @Override
    public final boolean isAutoMirrored() {
        Drawable drawable = this.f14529a;
        return drawable != null ? drawable.isAutoMirrored() : this.f14525b.f14521a.isAutoMirrored();
    }

    @Override
    public final boolean isRunning() {
        Drawable drawable = this.f14529a;
        return drawable != null ? ((AnimatedVectorDrawable) drawable).isRunning() : this.f14525b.f14522b.isRunning();
    }

    @Override
    public final boolean isStateful() {
        Drawable drawable = this.f14529a;
        return drawable != null ? drawable.isStateful() : this.f14525b.f14521a.isStateful();
    }

    @Override
    public final Drawable mutate() {
        Drawable drawable = this.f14529a;
        if (drawable != null) {
            drawable.mutate();
        }
        return this;
    }

    @Override
    public final void onBoundsChange(Rect rect) {
        Drawable drawable = this.f14529a;
        if (drawable != null) {
            drawable.setBounds(rect);
        } else {
            this.f14525b.f14521a.setBounds(rect);
        }
    }

    @Override
    public final boolean onLevelChange(int i6) {
        Drawable drawable = this.f14529a;
        return drawable != null ? drawable.setLevel(i6) : this.f14525b.f14521a.setLevel(i6);
    }

    @Override
    public final boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f14529a;
        return drawable != null ? drawable.setState(iArr) : this.f14525b.f14521a.setState(iArr);
    }

    @Override
    public final void setAlpha(int i6) {
        Drawable drawable = this.f14529a;
        if (drawable != null) {
            drawable.setAlpha(i6);
        } else {
            this.f14525b.f14521a.setAlpha(i6);
        }
    }

    @Override
    public final void setAutoMirrored(boolean z7) {
        Drawable drawable = this.f14529a;
        if (drawable != null) {
            drawable.setAutoMirrored(z7);
        } else {
            this.f14525b.f14521a.setAutoMirrored(z7);
        }
    }

    @Override
    public final void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f14529a;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.f14525b.f14521a.setColorFilter(colorFilter);
        }
    }

    @Override
    public final void setTint(int i6) {
        Drawable drawable = this.f14529a;
        if (drawable != null) {
            AbstractC3198d.m6444S(drawable, i6);
        } else {
            this.f14525b.f14521a.setTint(i6);
        }
    }

    @Override
    public final void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f14529a;
        if (drawable != null) {
            AbstractC2581a.m5586h(drawable, colorStateList);
        } else {
            this.f14525b.f14521a.setTintList(colorStateList);
        }
    }

    @Override
    public final void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f14529a;
        if (drawable != null) {
            AbstractC2581a.m5587i(drawable, mode);
        } else {
            this.f14525b.f14521a.setTintMode(mode);
        }
    }

    @Override
    public final boolean setVisible(boolean z7, boolean z10) {
        Drawable drawable = this.f14529a;
        if (drawable != null) {
            return drawable.setVisible(z7, z10);
        }
        this.f14525b.f14521a.setVisible(z7, z10);
        return super.setVisible(z7, z10);
    }

    @Override
    public final void start() {
        Drawable drawable = this.f14529a;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).start();
            return;
        }
        C4287b c4287b = this.f14525b;
        if (c4287b.f14522b.isStarted()) {
            return;
        }
        c4287b.f14522b.start();
        invalidateSelf();
    }

    @Override
    public final void stop() {
        Drawable drawable = this.f14529a;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).stop();
        } else {
            this.f14525b.f14522b.end();
        }
    }

    @Override
    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        inflate(resources, xmlPullParser, attributeSet, null);
    }
}
