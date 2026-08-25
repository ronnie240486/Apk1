package androidx.mediarouter.app;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaRouter2;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.ContextThemeWrapper;
import android.view.View;
import androidx.appcompat.app.AbstractDialogC0139i0;
import androidx.appcompat.widget.AbstractC0173a0;
import androidx.fragment.app.AbstractC0410j0;
import androidx.fragment.app.C0391a;
import androidx.fragment.app.FragmentActivity;
import androidx.media3.extractor.p010ts.TsExtractor;
import com.bumptech.glide.AbstractC1465c;
import java.util.Iterator;
import p065g0.AbstractC2581a;
import p138n0.AbstractC3155s0;
import p143n5.AbstractC3198d;
import p156o9.AbstractC3280d;
import p156o9.AbstractC3281e;
import p162p1.AbstractC3350a;
import p173q1.C3424l0;
import p173q1.C3445s0;
import p173q1.C3451u0;
import p173q1.C3457x0;
import p187r4.AbstractC3612b;

public class MediaRouteButton extends View {

    public static final SparseArray f3145p = new SparseArray(2);

    public static final int[] f3146q = {R.attr.state_checked};

    public static final int[] f3147r = {R.attr.state_checkable};

    public final C3451u0 f3148a;

    public final C1093i0 f3149b;

    public C3424l0 f3150c;

    public C1118w f3151d;

    public boolean f3152e;

    public boolean f3153f;

    public AsyncTaskC1076a f3154g;

    public Drawable f3155h;

    public int f3156i;

    public int f3157j;

    public int f3158k;

    public final ColorStateList f3159l;

    public final int f3160m;

    public final int f3161n;

    public boolean f3162o;

    public MediaRouteButton(Context context, AttributeSet attributeSet, int i6) {
        Drawable.ConstantState constantState;
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, AbstractC3280d.m6599q(context));
        int iM6601s = AbstractC3280d.m6601s(contextThemeWrapper, com.p2serv.android.p032ds.R.attr.mediaRouteTheme);
        super(iM6601s != 0 ? new ContextThemeWrapper(contextThemeWrapper, iM6601s) : contextThemeWrapper, attributeSet, i6);
        this.f3150c = C3424l0.f11567c;
        this.f3151d = C1118w.f3430a;
        Context context2 = getContext();
        int[] iArr = AbstractC3350a.f11338a;
        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, iArr, i6, 0);
        AbstractC3155s0.m6346p(this, context2, iArr, attributeSet, typedArrayObtainStyledAttributes, i6, 0);
        if (isInEditMode()) {
            this.f3148a = null;
            this.f3149b = null;
            this.f3155h = AbstractC1465c.m3473h(context2, typedArrayObtainStyledAttributes.getResourceId(3, 0));
            return;
        }
        this.f3148a = C3451u0.m7069d(context2);
        this.f3149b = new C1093i0(this, 1);
        C3445s0 c3445s0M7071f = C3451u0.m7071f();
        int i10 = !c3445s0M7071f.m7021d() ? c3445s0M7071f.f11660i : 0;
        this.f3158k = i10;
        this.f3157j = i10;
        this.f3159l = typedArrayObtainStyledAttributes.getColorStateList(4);
        this.f3160m = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.f3161n = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, 0);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(3, 0);
        this.f3156i = typedArrayObtainStyledAttributes.getResourceId(2, 0);
        typedArrayObtainStyledAttributes.recycle();
        int i11 = this.f3156i;
        SparseArray sparseArray = f3145p;
        if (i11 != 0 && (constantState = (Drawable.ConstantState) sparseArray.get(i11)) != null) {
            setRemoteIndicatorDrawable(constantState.newDrawable());
        }
        if (this.f3155h == null) {
            if (resourceId != 0) {
                Drawable.ConstantState constantState2 = (Drawable.ConstantState) sparseArray.get(resourceId);
                if (constantState2 != null) {
                    setRemoteIndicatorDrawableInternal(constantState2.newDrawable());
                } else {
                    AsyncTaskC1076a asyncTaskC1076a = new AsyncTaskC1076a(this, resourceId, getContext());
                    this.f3154g = asyncTaskC1076a;
                    asyncTaskC1076a.executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new Void[0]);
                }
            } else {
                m2732a();
            }
        }
        m2735d();
        setClickable(true);
    }

    private Activity getActivity() {
        for (Context context = getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
        }
        return null;
    }

    private AbstractC0410j0 getFragmentManager() {
        Activity activity = getActivity();
        if (activity instanceof FragmentActivity) {
            return ((FragmentActivity) activity).m1184k();
        }
        return null;
    }

    public final void m2732a() {
        if (this.f3156i > 0) {
            AsyncTaskC1076a asyncTaskC1076a = this.f3154g;
            if (asyncTaskC1076a != null) {
                asyncTaskC1076a.cancel(false);
            }
            AsyncTaskC1076a asyncTaskC1076a2 = new AsyncTaskC1076a(this, this.f3156i, getContext());
            this.f3154g = asyncTaskC1076a2;
            this.f3156i = 0;
            asyncTaskC1076a2.executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new Void[0]);
        }
    }

    public final void m2733b() {
        this.f3148a.getClass();
        C3445s0 c3445s0M7071f = C3451u0.m7071f();
        int i6 = !c3445s0M7071f.m7021d() ? c3445s0M7071f.f11660i : 0;
        if (this.f3158k != i6) {
            this.f3158k = i6;
            m2735d();
            refreshDrawableState();
        }
        if (i6 == 1) {
            m2732a();
        }
    }

    public final boolean m2734c() {
        AbstractC0410j0 fragmentManager = getFragmentManager();
        if (fragmentManager == null) {
            throw new IllegalStateException("The activity must be a subclass of FragmentActivity");
        }
        this.f3148a.getClass();
        if (C3451u0.m7071f().m7021d()) {
            if (fragmentManager.m1264z("android.support.v7.mediarouter:MediaRouteChooserDialogFragment") != null) {
                Log.w("MediaRouteButton", "showDialog(): Route chooser dialog already showing!");
                return false;
            }
            this.f3151d.getClass();
            C1088g c1088g = new C1088g();
            C3424l0 c3424l0 = this.f3150c;
            if (c3424l0 == null) {
                throw new IllegalArgumentException("selector must not be null");
            }
            c1088g.m2747T();
            if (!c1088g.f3242m0.equals(c3424l0)) {
                c1088g.f3242m0 = c3424l0;
                Bundle bundle = c1088g.f1970g;
                if (bundle == null) {
                    bundle = new Bundle();
                }
                bundle.putBundle("selector", c3424l0.f11568a);
                c1088g.m1316O(bundle);
                AbstractDialogC0139i0 abstractDialogC0139i0 = c1088g.f3241l0;
                if (abstractDialogC0139i0 != null) {
                    if (c1088g.f3240k0) {
                        ((DialogC1081c0) abstractDialogC0139i0).m2741j(c3424l0);
                    } else {
                        ((DialogC1086f) abstractDialogC0139i0).m2745k(c3424l0);
                    }
                }
            }
            C0391a c0391a = new C0391a(fragmentManager);
            c0391a.m1191f(0, c1088g, "android.support.v7.mediarouter:MediaRouteChooserDialogFragment", 1);
            c0391a.m1190e(true);
        } else {
            if (fragmentManager.m1264z("android.support.v7.mediarouter:MediaRouteControllerDialogFragment") != null) {
                Log.w("MediaRouteButton", "showDialog(): Route controller dialog already showing!");
                return false;
            }
            this.f3151d.getClass();
            C1117v c1117v = new C1117v();
            C3424l0 c3424l1 = this.f3150c;
            if (c3424l1 == null) {
                throw new IllegalArgumentException("selector must not be null");
            }
            if (c1117v.f3429m0 == null) {
                Bundle bundle2 = c1117v.f1970g;
                if (bundle2 != null) {
                    c1117v.f3429m0 = C3424l0.m6999b(bundle2.getBundle("selector"));
                }
                if (c1117v.f3429m0 == null) {
                    c1117v.f3429m0 = C3424l0.f11567c;
                }
            }
            if (!c1117v.f3429m0.equals(c3424l1)) {
                c1117v.f3429m0 = c3424l1;
                Bundle bundle3 = c1117v.f1970g;
                if (bundle3 == null) {
                    bundle3 = new Bundle();
                }
                bundle3.putBundle("selector", c3424l1.f11568a);
                c1117v.m1316O(bundle3);
                AbstractDialogC0139i0 abstractDialogC0139i1 = c1117v.f3428l0;
                if (abstractDialogC0139i1 != null && c1117v.f3427k0) {
                    ((DialogC1109q0) abstractDialogC0139i1).m2775l(c3424l1);
                }
            }
            C0391a c0391a2 = new C0391a(fragmentManager);
            c0391a2.m1191f(0, c1117v, "android.support.v7.mediarouter:MediaRouteControllerDialogFragment", 1);
            c0391a2.m1190e(true);
        }
        return true;
    }

    public final void m2735d() {
        int i6;
        int i10 = this.f3158k;
        if (i10 != 1) {
            i6 = i10 != 2 ? com.p2serv.android.p032ds.R.string.mr_cast_button_disconnected : com.p2serv.android.p032ds.R.string.mr_cast_button_connected;
        } else {
            i6 = com.p2serv.android.p032ds.R.string.mr_cast_button_connecting;
        }
        String string = getContext().getString(i6);
        setContentDescription(string);
        if (!this.f3162o || TextUtils.isEmpty(string)) {
            string = null;
        }
        AbstractC3612b.m7256L(this, string);
    }

    @Override
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f3155h != null) {
            this.f3155h.setState(getDrawableState());
            if (this.f3155h.getCurrent() instanceof AnimationDrawable) {
                AnimationDrawable animationDrawable = (AnimationDrawable) this.f3155h.getCurrent();
                int i6 = this.f3158k;
                if (i6 == 1 || this.f3157j != i6) {
                    if (!animationDrawable.isRunning()) {
                        animationDrawable.start();
                    }
                } else if (i6 == 2 && !animationDrawable.isRunning()) {
                    animationDrawable.selectDrawable(animationDrawable.getNumberOfFrames() - 1);
                }
            }
            invalidate();
        }
        this.f3157j = this.f3158k;
    }

    public C1118w getDialogFactory() {
        return this.f3151d;
    }

    public C3424l0 getRouteSelector() {
        return this.f3150c;
    }

    @Override
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f3155h;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isInEditMode()) {
            return;
        }
        this.f3152e = true;
        if (!this.f3150c.m7002d()) {
            this.f3148a.m7074a(this.f3150c, this.f3149b, 0);
        }
        m2733b();
    }

    @Override
    public final int[] onCreateDrawableState(int i6) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i6 + 1);
        if (this.f3148a == null || this.f3153f) {
            return iArrOnCreateDrawableState;
        }
        int i10 = this.f3158k;
        if (i10 == 1) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f3147r);
        } else if (i10 == 2) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f3146q);
        }
        return iArrOnCreateDrawableState;
    }

    @Override
    public final void onDetachedFromWindow() {
        if (!isInEditMode()) {
            this.f3152e = false;
            if (!this.f3150c.m7002d()) {
                this.f3148a.m7075h(this.f3149b);
            }
        }
        super.onDetachedFromWindow();
    }

    @Override
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f3155h != null) {
            int paddingLeft = getPaddingLeft();
            int width = getWidth() - getPaddingRight();
            int paddingTop = getPaddingTop();
            int height = getHeight() - getPaddingBottom();
            int intrinsicWidth = this.f3155h.getIntrinsicWidth();
            int intrinsicHeight = this.f3155h.getIntrinsicHeight();
            int i6 = (((width - paddingLeft) - intrinsicWidth) / 2) + paddingLeft;
            int i10 = (((height - paddingTop) - intrinsicHeight) / 2) + paddingTop;
            this.f3155h.setBounds(i6, i10, intrinsicWidth + i6, intrinsicHeight + i10);
            this.f3155h.draw(canvas);
        }
    }

    @Override
    public final void onMeasure(int i6, int i10) {
        int paddingRight;
        int size = View.MeasureSpec.getSize(i6);
        int size2 = View.MeasureSpec.getSize(i10);
        int mode = View.MeasureSpec.getMode(i6);
        int mode2 = View.MeasureSpec.getMode(i10);
        Drawable drawable = this.f3155h;
        int paddingBottom = 0;
        if (drawable != null) {
            paddingRight = getPaddingRight() + getPaddingLeft() + drawable.getIntrinsicWidth();
        } else {
            paddingRight = 0;
        }
        int iMax = Math.max(this.f3160m, paddingRight);
        Drawable drawable2 = this.f3155h;
        if (drawable2 != null) {
            paddingBottom = getPaddingBottom() + getPaddingTop() + drawable2.getIntrinsicHeight();
        }
        int iMax2 = Math.max(this.f3161n, paddingBottom);
        if (mode == Integer.MIN_VALUE) {
            size = Math.min(size, iMax);
        } else if (mode != 1073741824) {
            size = iMax;
        }
        if (mode2 == Integer.MIN_VALUE) {
            size2 = Math.min(size2, iMax2);
        } else if (mode2 != 1073741824) {
            size2 = iMax2;
        }
        setMeasuredDimension(size, size2);
    }

    @Override
    public final boolean performClick() {
        boolean zM2734c;
        boolean zM6613I;
        ApplicationInfo applicationInfo;
        boolean z7;
        ApplicationInfo applicationInfo2;
        boolean z10;
        boolean zPerformClick = super.performClick();
        if (!zPerformClick) {
            playSoundEffect(0);
        }
        m2732a();
        if (this.f3152e) {
            this.f3148a.getClass();
            C3451u0.m7067b();
            C3457x0 c3457x0 = C3451u0.m7068c().f11508u;
            if (c3457x0 == null || !c3457x0.f11709b) {
                zM2734c = m2734c();
            } else {
                if (C3451u0.f11687c == null ? false : C3451u0.m7068c().m6941h()) {
                    Context context = getContext();
                    int i6 = Build.VERSION.SDK_INT;
                    if (i6 >= 34) {
                        if (i6 >= 30) {
                            MediaRouter2 mediaRouter2M2781a = AbstractC1113s0.m2781a(context);
                            if (i6 >= 34) {
                                zM6613I = AbstractC1115t0.m2788g(mediaRouter2M2781a);
                            } else {
                                zM6613I = false;
                            }
                        } else {
                            zM6613I = false;
                        }
                    } else if (i6 >= 31) {
                        Intent intentPutExtra = new Intent().setAction("com.android.systemui.action.LAUNCH_MEDIA_OUTPUT_DIALOG").setPackage("com.android.systemui").putExtra("package_name", context.getPackageName());
                        Iterator<ResolveInfo> it = context.getPackageManager().queryBroadcastReceivers(intentPutExtra, 0).iterator();
                        while (true) {
                            if (it.hasNext()) {
                                ActivityInfo activityInfo = it.next().activityInfo;
                                if (activityInfo != null && (applicationInfo = activityInfo.applicationInfo) != null && (applicationInfo.flags & TsExtractor.TS_STREAM_TYPE_AC3) != 0) {
                                    context.sendBroadcast(intentPutExtra);
                                }
                            } else if (!AbstractC3281e.m6613I(context)) {
                                zM6613I = false;
                            }
                            zM6613I = true;
                        }
                    } else if (i6 == 30) {
                        zM6613I = AbstractC3281e.m6613I(context);
                    } else {
                        zM6613I = false;
                    }
                    if (!zM6613I) {
                        if (context.getPackageManager().hasSystemFeature("android.hardware.type.watch")) {
                            Intent intentPutExtra2 = new Intent("android.settings.BLUETOOTH_SETTINGS").addFlags(268468224).putExtra("EXTRA_CONNECTION_ONLY", true).putExtra("android.bluetooth.devicepicker.extra.FILTER_TYPE", 1).putExtra("EXTRA_CLOSE_ON_CONNECT", !(Build.VERSION.SDK_INT >= 23 ? AbstractC0173a0.m634a(context) : true));
                            Iterator<ResolveInfo> it2 = context.getPackageManager().queryIntentActivities(intentPutExtra2, 0).iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    z7 = false;
                                    break;
                                }
                                ActivityInfo activityInfo2 = it2.next().activityInfo;
                                if (activityInfo2 != null && (applicationInfo2 = activityInfo2.applicationInfo) != null && (applicationInfo2.flags & TsExtractor.TS_STREAM_TYPE_AC3) != 0) {
                                    intentPutExtra2.setPackage(applicationInfo2.packageName);
                                    context.startActivity(intentPutExtra2);
                                    z7 = true;
                                    break;
                                }
                            }
                            z10 = z7;
                        }
                    }
                    if (z10) {
                        zM2734c = true;
                    } else {
                        zM2734c = m2734c();
                    }
                } else {
                    zM2734c = m2734c();
                }
            }
        } else {
            zM2734c = false;
        }
        return zM2734c || zPerformClick;
    }

    public void setCheatSheetEnabled(boolean z7) {
        if (z7 != this.f3162o) {
            this.f3162o = z7;
            m2735d();
        }
    }

    public void setDialogFactory(C1118w c1118w) {
        if (c1118w == null) {
            throw new IllegalArgumentException("factory must not be null");
        }
        this.f3151d = c1118w;
    }

    public void setRemoteIndicatorDrawable(Drawable drawable) {
        this.f3156i = 0;
        setRemoteIndicatorDrawableInternal(drawable);
    }

    public void setRemoteIndicatorDrawableInternal(Drawable drawable) {
        AsyncTaskC1076a asyncTaskC1076a = this.f3154g;
        if (asyncTaskC1076a != null) {
            asyncTaskC1076a.cancel(false);
        }
        Drawable drawable2 = this.f3155h;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.f3155h);
        }
        if (drawable != null) {
            ColorStateList colorStateList = this.f3159l;
            if (colorStateList != null) {
                drawable = AbstractC3198d.m6448W(drawable.mutate());
                AbstractC2581a.m5586h(drawable, colorStateList);
            }
            drawable.setCallback(this);
            drawable.setState(getDrawableState());
            drawable.setVisible(getVisibility() == 0, false);
        }
        this.f3155h = drawable;
        refreshDrawableState();
    }

    public void setRouteSelector(C3424l0 c3424l0) {
        if (c3424l0 == null) {
            throw new IllegalArgumentException("selector must not be null");
        }
        if (this.f3150c.equals(c3424l0)) {
            return;
        }
        if (this.f3152e) {
            boolean zM7002d = this.f3150c.m7002d();
            C1093i0 c1093i0 = this.f3149b;
            C3451u0 c3451u0 = this.f3148a;
            if (!zM7002d) {
                c3451u0.m7075h(c1093i0);
            }
            if (!c3424l0.m7002d()) {
                c3451u0.m7074a(c3424l0, c1093i0, 0);
            }
        }
        this.f3150c = c3424l0;
        m2733b();
    }

    @Override
    public void setVisibility(int i6) {
        super.setVisibility(i6);
        Drawable drawable = this.f3155h;
        if (drawable != null) {
            drawable.setVisible(i6 == 0, false);
        }
    }

    @Override
    public final boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f3155h;
    }

    @Deprecated
    public void setAlwaysVisible(boolean z7) {
    }

    public MediaRouteButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, com.p2serv.android.p032ds.R.attr.mediaRouteButtonStyle);
    }
}
