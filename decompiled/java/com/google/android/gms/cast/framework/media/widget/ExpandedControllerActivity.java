package com.google.android.gms.cast.framework.media.widget;

import android.app.Activity;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import android.renderscript.Allocation;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.C0159s0;
import androidx.appcompat.app.C0169x0;
import androidx.appcompat.app.LayoutInflaterFactory2C0135g0;
import androidx.appcompat.app.ViewOnClickListenerC0122a;
import androidx.appcompat.widget.Toolbar;
import com.google.android.gms.cast.AdBreakClipInfo;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaMetadata;
import com.google.android.gms.cast.MediaStatus;
import com.google.android.gms.cast.framework.media.ImageHints;
import com.google.android.gms.internal.cast.AbstractC1542e0;
import com.google.android.gms.internal.cast.C1572h0;
import com.google.android.gms.internal.cast.C1582i0;
import com.google.android.gms.internal.cast.C1592j0;
import com.google.android.gms.internal.cast.C1602k0;
import com.google.android.gms.internal.cast.C1612l0;
import com.google.android.gms.internal.cast.C1622m0;
import com.google.android.gms.internal.cast.C1632n0;
import com.google.android.gms.internal.cast.C1641o0;
import com.google.android.gms.internal.cast.C1650p0;
import com.google.android.gms.internal.cast.C1670r2;
import com.google.android.gms.internal.cast.EnumC1679s2;
import com.p2serv.android.p032ds.R;
import java.util.Timer;
import p018b5.AbstractC1312l;
import p025c2.C1381b;
import p123l5.AbstractC2973a;
import p176q4.AbstractC3480f;
import p176q4.AbstractC3481g;
import p176q4.C3473b;
import p176q4.C3475c;
import p176q4.C3482h;
import p176q4.C3496v;
import p176q4.InterfaceC3498x;
import p187r4.C3616f;
import p187r4.C3624n;
import p187r4.C3626p;
import p199s4.AbstractC3717k;
import p210t4.AbstractC3808a;
import p210t4.C3809b;
import p210t4.ViewOnClickListenerC3810c;
import p219u4.AbstractC3898f;
import p219u4.C3895c;
import p219u4.C3896d;
import p219u4.C3897e;
import p230v4.C3988b;

public abstract class ExpandedControllerActivity extends AppCompatActivity {

    public static final int f4902n0 = 0;

    public int f4903A;

    public int f4904B;

    public int f4905C;

    public int f4906D;

    public int f4907E;

    public int f4908F;

    public int f4909G;

    public int f4910H;

    public int f4911I;

    public int f4912J;

    public int f4913K;

    public int f4914L;

    public int f4915M;

    public int f4916N;

    public int f4917O;

    public int f4918P;

    public int f4919Q;

    public TextView f4920R;

    public CastSeekBar f4921S;

    public ImageView f4922T;

    public ImageView f4923U;

    public int[] f4924V;

    public View f4926X;

    public View f4927Y;

    public ImageView f4928Z;

    public TextView f4929b0;

    public TextView f4930c0;

    public TextView f4931d0;

    public TextView f4932e0;

    public C1381b f4933f0;

    public C3809b f4934g0;

    public C3482h f4935h0;

    public C1602k0 f4936i0;

    public boolean f4937j0;

    public boolean f4938k0;

    public Timer f4939l0;

    public String f4940m0;

    public int f4943z;

    public final C3895c f4941x = new C3895c(this);

    public final C3897e f4942y = new C3897e(this);

    public final ImageView[] f4925W = new ImageView[4];

    @Override
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C3482h c3482hM7102a = C3473b.m7099b(this).m7102a();
        this.f4935h0 = c3482hM7102a;
        if (c3482hM7102a.m7142c() == null) {
            finish();
        }
        C3809b c3809b = new C3809b(this);
        this.f4934g0 = c3809b;
        AbstractC1312l.m3195b("Must be called from the main thread.");
        c3809b.f12856f = this.f4942y;
        setContentView(R.layout.cast_expanded_controller_activity);
        TypedArray typedArrayObtainStyledAttributes = obtainStyledAttributes(new int[]{R.attr.selectableItemBackgroundBorderless});
        this.f4943z = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        typedArrayObtainStyledAttributes.recycle();
        TypedArray typedArrayObtainStyledAttributes2 = obtainStyledAttributes(null, AbstractC3480f.f11774a, R.attr.castExpandedControllerStyle, R.style.CastExpandedController);
        this.f4916N = typedArrayObtainStyledAttributes2.getResourceId(7, 0);
        this.f4903A = typedArrayObtainStyledAttributes2.getResourceId(16, 0);
        this.f4904B = typedArrayObtainStyledAttributes2.getResourceId(15, 0);
        this.f4905C = typedArrayObtainStyledAttributes2.getResourceId(26, 0);
        this.f4906D = typedArrayObtainStyledAttributes2.getResourceId(25, 0);
        this.f4907E = typedArrayObtainStyledAttributes2.getResourceId(24, 0);
        this.f4908F = typedArrayObtainStyledAttributes2.getResourceId(17, 0);
        this.f4909G = typedArrayObtainStyledAttributes2.getResourceId(12, 0);
        this.f4910H = typedArrayObtainStyledAttributes2.getResourceId(14, 0);
        this.f4911I = typedArrayObtainStyledAttributes2.getResourceId(8, 0);
        int resourceId = typedArrayObtainStyledAttributes2.getResourceId(9, 0);
        if (resourceId != 0) {
            TypedArray typedArrayObtainTypedArray = getResources().obtainTypedArray(resourceId);
            if (typedArrayObtainTypedArray.length() != 4) {
                throw new IllegalArgumentException();
            }
            this.f4924V = new int[typedArrayObtainTypedArray.length()];
            for (int i6 = 0; i6 < typedArrayObtainTypedArray.length(); i6++) {
                this.f4924V[i6] = typedArrayObtainTypedArray.getResourceId(i6, 0);
            }
            typedArrayObtainTypedArray.recycle();
        } else {
            this.f4924V = new int[]{R.id.cast_button_type_empty, R.id.cast_button_type_empty, R.id.cast_button_type_empty, R.id.cast_button_type_empty};
        }
        this.f4915M = typedArrayObtainStyledAttributes2.getColor(11, 0);
        this.f4912J = getResources().getColor(typedArrayObtainStyledAttributes2.getResourceId(4, 0));
        this.f4913K = getResources().getColor(typedArrayObtainStyledAttributes2.getResourceId(3, 0));
        this.f4914L = getResources().getColor(typedArrayObtainStyledAttributes2.getResourceId(6, 0));
        this.f4917O = typedArrayObtainStyledAttributes2.getResourceId(5, 0);
        this.f4918P = typedArrayObtainStyledAttributes2.getResourceId(1, 0);
        this.f4919Q = typedArrayObtainStyledAttributes2.getResourceId(2, 0);
        int resourceId2 = typedArrayObtainStyledAttributes2.getResourceId(10, 0);
        if (resourceId2 != 0) {
            this.f4940m0 = getApplicationContext().getResources().getString(resourceId2);
        }
        typedArrayObtainStyledAttributes2.recycle();
        View viewFindViewById = findViewById(R.id.expanded_controller_layout);
        C3809b c3809b2 = this.f4934g0;
        this.f4922T = (ImageView) viewFindViewById.findViewById(R.id.background_image_view);
        this.f4923U = (ImageView) viewFindViewById.findViewById(R.id.blurred_background_image_view);
        View viewFindViewById2 = viewFindViewById.findViewById(R.id.background_place_holder_image_view);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        ImageView imageView = this.f4922T;
        ImageHints imageHints = new ImageHints(4, displayMetrics.widthPixels, displayMetrics.heightPixels);
        C3895c c3895c = new C3895c(this);
        c3809b2.getClass();
        AbstractC1312l.m3195b("Must be called from the main thread.");
        c3809b2.m7588s(imageView, new C1592j0(imageView, c3809b2.f12851a, imageHints, viewFindViewById2, c3895c));
        this.f4920R = (TextView) viewFindViewById.findViewById(R.id.status_text);
        ProgressBar progressBar = (ProgressBar) viewFindViewById.findViewById(R.id.loading_indicator);
        Drawable indeterminateDrawable = progressBar.getIndeterminateDrawable();
        int i10 = this.f4915M;
        if (i10 != 0) {
            indeterminateDrawable.setColorFilter(i10, PorterDuff.Mode.SRC_IN);
        }
        AbstractC1312l.m3195b("Must be called from the main thread.");
        c3809b2.m7588s(progressBar, new C1622m0(progressBar));
        TextView textView = (TextView) viewFindViewById.findViewById(R.id.start_text);
        TextView textView2 = (TextView) viewFindViewById.findViewById(R.id.end_text);
        CastSeekBar castSeekBar = (CastSeekBar) viewFindViewById.findViewById(R.id.cast_seek_bar);
        this.f4921S = castSeekBar;
        AbstractC1312l.m3195b("Must be called from the main thread.");
        C1670r2.m3989a(EnumC1679s2.SEEK_CONTROLLER);
        castSeekBar.f4888f = new C3624n(4, c3809b2);
        C3626p c3626p = c3809b2.f12855e;
        c3809b2.m7588s(castSeekBar, new C1582i0(castSeekBar, c3626p));
        AbstractC3808a c1632n0 = new C1632n0(textView, c3626p, 1);
        AbstractC1312l.m3195b("Must be called from the main thread.");
        c3809b2.m7588s(textView, c1632n0);
        AbstractC3808a c1632n1 = new C1632n0(textView2, c3626p, 0);
        AbstractC1312l.m3195b("Must be called from the main thread.");
        c3809b2.m7588s(textView2, c1632n1);
        View viewFindViewById3 = viewFindViewById.findViewById(R.id.live_indicators);
        AbstractC3808a c1641o0 = new C1641o0(viewFindViewById3, c3626p);
        AbstractC1312l.m3195b("Must be called from the main thread.");
        c3809b2.m7588s(viewFindViewById3, c1641o0);
        RelativeLayout relativeLayout = (RelativeLayout) viewFindViewById.findViewById(R.id.tooltip_container);
        C1650p0 c1650p0 = new C1650p0(relativeLayout, this.f4921S, c3626p);
        AbstractC1312l.m3195b("Must be called from the main thread.");
        c3809b2.m7588s(relativeLayout, c1650p0);
        c3809b2.f12854d.add(c1650p0);
        ImageView imageView2 = (ImageView) viewFindViewById.findViewById(R.id.button_0);
        ImageView[] imageViewArr = this.f4925W;
        imageViewArr[0] = imageView2;
        imageViewArr[1] = (ImageView) viewFindViewById.findViewById(R.id.button_1);
        imageViewArr[2] = (ImageView) viewFindViewById.findViewById(R.id.button_2);
        imageViewArr[3] = (ImageView) viewFindViewById.findViewById(R.id.button_3);
        m3629q(viewFindViewById, R.id.button_0, this.f4924V[0], c3809b2);
        m3629q(viewFindViewById, R.id.button_1, this.f4924V[1], c3809b2);
        m3629q(viewFindViewById, R.id.button_play_pause_toggle, R.id.cast_button_type_play_pause_toggle, c3809b2);
        m3629q(viewFindViewById, R.id.button_2, this.f4924V[2], c3809b2);
        m3629q(viewFindViewById, R.id.button_3, this.f4924V[3], c3809b2);
        View viewFindViewById4 = findViewById(R.id.ad_container);
        this.f4926X = viewFindViewById4;
        this.f4928Z = (ImageView) viewFindViewById4.findViewById(R.id.ad_image_view);
        this.f4927Y = this.f4926X.findViewById(R.id.ad_background_image_view);
        TextView textView3 = (TextView) this.f4926X.findViewById(R.id.ad_label);
        this.f4930c0 = textView3;
        textView3.setTextColor(this.f4914L);
        this.f4930c0.setBackgroundColor(this.f4912J);
        this.f4929b0 = (TextView) this.f4926X.findViewById(R.id.ad_in_progress_label);
        this.f4932e0 = (TextView) findViewById(R.id.ad_skip_text);
        TextView textView4 = (TextView) findViewById(R.id.ad_skip_button);
        this.f4931d0 = textView4;
        textView4.setOnClickListener(new ViewOnClickListenerC0122a(21, this));
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        LayoutInflaterFactory2C0135g0 layoutInflaterFactory2C0135g0 = (LayoutInflaterFactory2C0135g0) m364m();
        if (layoutInflaterFactory2C0135g0.f340j instanceof Activity) {
            layoutInflaterFactory2C0135g0.m384B();
            AbstractC2973a abstractC2973a = layoutInflaterFactory2C0135g0.f345o;
            if (abstractC2973a instanceof C0169x0) {
                throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
            }
            layoutInflaterFactory2C0135g0.f346p = null;
            if (abstractC2973a != null) {
                abstractC2973a.mo445C();
            }
            layoutInflaterFactory2C0135g0.f345o = null;
            if (toolbar != null) {
                Object obj = layoutInflaterFactory2C0135g0.f340j;
                C0159s0 c0159s0 = new C0159s0(toolbar, obj instanceof Activity ? ((Activity) obj).getTitle() : layoutInflaterFactory2C0135g0.f347q, layoutInflaterFactory2C0135g0.f343m);
                layoutInflaterFactory2C0135g0.f345o = c0159s0;
                layoutInflaterFactory2C0135g0.f343m.f482b = c0159s0.f434t;
                toolbar.setBackInvokedCallbackEnabled(true);
            } else {
                layoutInflaterFactory2C0135g0.f343m.f482b = null;
            }
            layoutInflaterFactory2C0135g0.mo394b();
        }
        AbstractC2973a abstractC2973aM365n = m365n();
        if (abstractC2973aM365n != null) {
            abstractC2973aM365n.mo450K(true);
            abstractC2973aM365n.mo451L();
        }
        m3631s();
        m3632t();
        TextView textView5 = this.f4929b0;
        if (textView5 != null && this.f4919Q != 0) {
            if (Build.VERSION.SDK_INT >= 23) {
                textView5.setTextAppearance(this.f4918P);
            } else {
                textView5.setTextAppearance(getApplicationContext(), this.f4918P);
            }
            this.f4929b0.setTextColor(this.f4913K);
            this.f4929b0.setText(this.f4919Q);
        }
        C1381b c1381b = new C1381b(getApplicationContext(), new ImageHints(-1, this.f4928Z.getWidth(), this.f4928Z.getHeight()));
        this.f4933f0 = c1381b;
        c1381b.f4202f = new C3895c(this);
        C1670r2.m3989a(EnumC1679s2.CAF_EXPANDED_CONTROLLER);
    }

    @Override
    public final void onDestroy() {
        C1381b c1381b = this.f4933f0;
        c1381b.m3260j();
        c1381b.f4202f = null;
        C3809b c3809b = this.f4934g0;
        if (c3809b != null) {
            AbstractC1312l.m3195b("Must be called from the main thread.");
            c3809b.f12856f = null;
            C3809b c3809b2 = this.f4934g0;
            c3809b2.getClass();
            AbstractC1312l.m3195b("Must be called from the main thread.");
            c3809b2.m7586q();
            c3809b2.f12853c.clear();
            C3482h c3482h = c3809b2.f12852b;
            if (c3482h != null) {
                c3482h.m7144e(c3809b2);
            }
            c3809b2.f12856f = null;
        }
        super.onDestroy();
    }

    @Override
    public final boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return true;
        }
        finish();
        return true;
    }

    @Override
    public final void onPause() {
        C3482h c3482h = this.f4935h0;
        if (c3482h == null) {
            return;
        }
        C3475c c3475cM7142c = c3482h.m7142c();
        C1602k0 c1602k0 = this.f4936i0;
        if (c1602k0 != null && c3475cM7142c != null) {
            AbstractC1312l.m3195b("Must be called from the main thread.");
            c3475cM7142c.f11757d.remove(c1602k0);
            this.f4936i0 = null;
        }
        this.f4935h0.m7144e(this.f4941x);
        super.onPause();
    }

    @Override
    public final void onResume() {
        boolean z7;
        boolean z10 = true;
        C3482h c3482h = this.f4935h0;
        if (c3482h == null) {
            return;
        }
        c3482h.m7140a(this.f4941x);
        C3475c c3475cM7142c = this.f4935h0.m7142c();
        if (c3475cM7142c == null) {
            finish();
        } else {
            if (!c3475cM7142c.m7136a()) {
                AbstractC1312l.m3195b("Must be called from the main thread.");
                InterfaceC3498x interfaceC3498x = c3475cM7142c.f11776a;
                if (interfaceC3498x != null) {
                    try {
                        C3496v c3496v = (C3496v) interfaceC3498x;
                        Parcel parcelM3688w = c3496v.m3688w(c3496v.m3687l(), 6);
                        int i6 = AbstractC1542e0.f5277a;
                        z7 = parcelM3688w.readInt() != 0;
                        parcelM3688w.recycle();
                    } catch (RemoteException e5) {
                        AbstractC3481g.f11775b.m7974a(e5, "Unable to call %s on %s.", "isConnecting", InterfaceC3498x.class.getSimpleName());
                        z7 = false;
                    }
                } else {
                    z7 = false;
                }
                if (!z7) {
                    finish();
                }
            }
            C1602k0 c1602k0 = new C1602k0(2, this);
            this.f4936i0 = c1602k0;
            AbstractC1312l.m3195b("Must be called from the main thread.");
            c3475cM7142c.f11757d.add(c1602k0);
        }
        C3616f c3616fM3628p = m3628p();
        if (c3616fM3628p != null && c3616fM3628p.m7305i()) {
            z10 = false;
        }
        this.f4937j0 = z10;
        m3631s();
        m3633u();
        super.onResume();
    }

    @Override
    public final void onWindowFocusChanged(boolean z7) {
        super.onWindowFocusChanged(z7);
        if (z7) {
            getWindow().getDecorView().setSystemUiVisibility(getWindow().getDecorView().getSystemUiVisibility() ^ 4102);
            setImmersive(true);
        }
    }

    public final C3616f m3628p() {
        C3475c c3475cM7142c = this.f4935h0.m7142c();
        if (c3475cM7142c == null || !c3475cM7142c.m7136a()) {
            return null;
        }
        return c3475cM7142c.m7125f();
    }

    public final void m3629q(View view, int i6, int i10, C3809b c3809b) {
        ImageView imageView = (ImageView) view.findViewById(i6);
        if (i10 == R.id.cast_button_type_empty) {
            imageView.setVisibility(4);
            return;
        }
        if (i10 == R.id.cast_button_type_play_pause_toggle) {
            imageView.setBackgroundResource(this.f4943z);
            Drawable drawableM7793a = AbstractC3898f.m7793a(this, this.f4916N, this.f4904B);
            Drawable drawableM7793a2 = AbstractC3898f.m7793a(this, this.f4916N, this.f4903A);
            Drawable drawableM7793a3 = AbstractC3898f.m7793a(this, this.f4916N, this.f4905C);
            imageView.setImageDrawable(drawableM7793a2);
            c3809b.getClass();
            AbstractC1312l.m3195b("Must be called from the main thread.");
            C1670r2.m3989a(EnumC1679s2.PAUSE_CONTROLLER);
            imageView.setOnClickListener(new ViewOnClickListenerC3810c(c3809b, 1));
            c3809b.m7588s(imageView, new C1612l0(imageView, c3809b.f12851a, drawableM7793a2, drawableM7793a, drawableM7793a3));
            return;
        }
        if (i10 == R.id.cast_button_type_skip_previous) {
            imageView.setBackgroundResource(this.f4943z);
            imageView.setImageDrawable(AbstractC3898f.m7793a(this, this.f4916N, this.f4906D));
            imageView.setContentDescription(getResources().getString(R.string.cast_skip_prev));
            c3809b.getClass();
            AbstractC1312l.m3195b("Must be called from the main thread.");
            imageView.setOnClickListener(new ViewOnClickListenerC3810c(c3809b, 3));
            c3809b.m7588s(imageView, new C1622m0(imageView, 1));
            return;
        }
        if (i10 == R.id.cast_button_type_skip_next) {
            imageView.setBackgroundResource(this.f4943z);
            imageView.setImageDrawable(AbstractC3898f.m7793a(this, this.f4916N, this.f4907E));
            imageView.setContentDescription(getResources().getString(R.string.cast_skip_next));
            c3809b.getClass();
            AbstractC1312l.m3195b("Must be called from the main thread.");
            imageView.setOnClickListener(new ViewOnClickListenerC3810c(c3809b, 2));
            c3809b.m7588s(imageView, new C1622m0(imageView, 0));
            return;
        }
        if (i10 == R.id.cast_button_type_rewind_30_seconds) {
            imageView.setBackgroundResource(this.f4943z);
            imageView.setImageDrawable(AbstractC3898f.m7793a(this, this.f4916N, this.f4908F));
            imageView.setContentDescription(getResources().getString(R.string.cast_rewind_30));
            c3809b.getClass();
            AbstractC1312l.m3195b("Must be called from the main thread.");
            imageView.setOnClickListener(new ViewOnClickListenerC3810c(c3809b, 5));
            c3809b.m7588s(imageView, new C1582i0(imageView, c3809b.f12855e, 1));
            return;
        }
        if (i10 == R.id.cast_button_type_forward_30_seconds) {
            imageView.setBackgroundResource(this.f4943z);
            imageView.setImageDrawable(AbstractC3898f.m7793a(this, this.f4916N, this.f4909G));
            imageView.setContentDescription(getResources().getString(R.string.cast_forward_30));
            c3809b.getClass();
            AbstractC1312l.m3195b("Must be called from the main thread.");
            imageView.setOnClickListener(new ViewOnClickListenerC3810c(c3809b, 4));
            c3809b.m7588s(imageView, new C1582i0(imageView, c3809b.f12855e, 0));
            return;
        }
        if (i10 == R.id.cast_button_type_mute_toggle) {
            imageView.setBackgroundResource(this.f4943z);
            imageView.setImageDrawable(AbstractC3898f.m7793a(this, this.f4916N, this.f4910H));
            c3809b.getClass();
            AbstractC1312l.m3195b("Must be called from the main thread.");
            imageView.setOnClickListener(new ViewOnClickListenerC3810c(c3809b, 0));
            c3809b.m7588s(imageView, new C1592j0(imageView, c3809b.f12851a));
            return;
        }
        if (i10 == R.id.cast_button_type_closed_caption) {
            imageView.setBackgroundResource(this.f4943z);
            imageView.setImageDrawable(AbstractC3898f.m7793a(this, this.f4916N, this.f4911I));
            c3809b.getClass();
            AbstractC1312l.m3195b("Must be called from the main thread.");
            imageView.setOnClickListener(new ViewOnClickListenerC3810c(c3809b, 6));
            c3809b.m7588s(imageView, new C1572h0(imageView, c3809b.f12851a));
        }
    }

    public final void m3630r(C3616f c3616f) {
        MediaStatus mediaStatusM7302f;
        if (this.f4937j0 || (mediaStatusM7302f = c3616f.m7302f()) == null || c3616f.m7306j()) {
            return;
        }
        this.f4931d0.setVisibility(8);
        this.f4932e0.setVisibility(8);
        AdBreakClipInfo adBreakClipInfoM3601j = mediaStatusM7302f.m3601j();
        if (adBreakClipInfoM3601j != null) {
            long j10 = adBreakClipInfoM3601j.f4573j;
            if (j10 != -1) {
                if (!this.f4938k0) {
                    C3896d c3896d = new C3896d(this, c3616f);
                    Timer timer = new Timer();
                    this.f4939l0 = timer;
                    timer.scheduleAtFixedRate(c3896d, 0L, 500L);
                    this.f4938k0 = true;
                }
                float fM7298b = j10 - c3616f.m7298b();
                if (fM7298b > 0.0f) {
                    this.f4932e0.setVisibility(0);
                    this.f4932e0.setText(getResources().getString(R.string.cast_expanded_controller_skip_ad_text, Integer.valueOf((int) Math.ceil(fM7298b / 1000.0f))));
                    this.f4931d0.setClickable(false);
                } else {
                    if (this.f4938k0) {
                        this.f4939l0.cancel();
                        this.f4938k0 = false;
                    }
                    this.f4931d0.setVisibility(0);
                    this.f4931d0.setClickable(true);
                }
            }
        }
    }

    public final void m3631s() {
        CastDevice castDeviceM7124e;
        C3475c c3475cM7142c = this.f4935h0.m7142c();
        if (c3475cM7142c != null && (castDeviceM7124e = c3475cM7142c.m7124e()) != null) {
            String str = castDeviceM7124e.f4603d;
            if (!TextUtils.isEmpty(str)) {
                this.f4920R.setText(getResources().getString(R.string.cast_casting_to_device, str));
                return;
            }
        }
        this.f4920R.setText("");
    }

    public final void m3632t() {
        MediaInfo mediaInfoM7301e;
        MediaMetadata mediaMetadata;
        AbstractC2973a abstractC2973aM365n;
        C3616f c3616fM3628p = m3628p();
        if (c3616fM3628p == null || !c3616fM3628p.m7305i() || (mediaInfoM7301e = c3616fM3628p.m7301e()) == null || (mediaMetadata = mediaInfoM7301e.f4641d) == null || (abstractC2973aM365n = m365n()) == null) {
            return;
        }
        MediaMetadata.m3593j(1, "com.google.android.gms.cast.metadata.TITLE");
        Bundle bundle = mediaMetadata.f4678b;
        abstractC2973aM365n.mo454P(bundle.getString("com.google.android.gms.cast.metadata.TITLE"));
        C3988b c3988b = AbstractC3717k.f12470a;
        String str = "com.google.android.gms.cast.metadata.SUBTITLE";
        if (!bundle.containsKey("com.google.android.gms.cast.metadata.SUBTITLE")) {
            int i6 = mediaMetadata.f4679c;
            if (i6 == 1) {
                str = "com.google.android.gms.cast.metadata.STUDIO";
            } else if (i6 == 2) {
                str = "com.google.android.gms.cast.metadata.SERIES_TITLE";
            } else if (i6 != 3) {
                if (i6 == 4) {
                    str = "com.google.android.gms.cast.metadata.ARTIST";
                }
            } else if (bundle.containsKey("com.google.android.gms.cast.metadata.ARTIST")) {
                str = "com.google.android.gms.cast.metadata.ARTIST";
            } else {
                String str2 = "com.google.android.gms.cast.metadata.ALBUM_ARTIST";
                if (bundle.containsKey("com.google.android.gms.cast.metadata.ALBUM_ARTIST")) {
                    str = str2;
                } else {
                    str2 = "com.google.android.gms.cast.metadata.COMPOSER";
                    if (bundle.containsKey("com.google.android.gms.cast.metadata.COMPOSER")) {
                        str = str2;
                    }
                }
            }
        }
        MediaMetadata.m3593j(1, str);
        String string = bundle.getString(str);
        if (string != null) {
            abstractC2973aM365n.mo453O(string);
        }
    }

    public final void m3633u() {
        MediaStatus mediaStatusM7302f;
        String str;
        String string;
        Drawable drawable;
        Bitmap bitmap;
        C3616f c3616fM3628p = m3628p();
        if (c3616fM3628p == null || (mediaStatusM7302f = c3616fM3628p.m7302f()) == null) {
            return;
        }
        if (!mediaStatusM7302f.f4721r) {
            this.f4932e0.setVisibility(8);
            this.f4931d0.setVisibility(8);
            this.f4926X.setVisibility(8);
            this.f4923U.setVisibility(8);
            this.f4923U.setImageBitmap(null);
            return;
        }
        if (this.f4923U.getVisibility() == 8 && (drawable = this.f4922T.getDrawable()) != null && (drawable instanceof BitmapDrawable) && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null) {
            C3988b c3988b = AbstractC3898f.f13098a;
            Object[] objArr = {bitmap, Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight())};
            C3988b c3988b2 = AbstractC3898f.f13098a;
            c3988b2.m7975b("Begin blurring bitmap %s, original width = %d, original height = %d.", objArr);
            int iRound = Math.round(bitmap.getWidth() * 0.25f);
            int iRound2 = Math.round(bitmap.getHeight() * 0.25f);
            Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, iRound, iRound2, false);
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iRound, iRound2, bitmapCreateScaledBitmap.getConfig());
            RenderScript renderScriptCreate = RenderScript.create(this);
            Allocation allocationCreateFromBitmap = Allocation.createFromBitmap(renderScriptCreate, bitmapCreateScaledBitmap);
            Allocation allocationCreateTyped = Allocation.createTyped(renderScriptCreate, allocationCreateFromBitmap.getType());
            ScriptIntrinsicBlur scriptIntrinsicBlurCreate = ScriptIntrinsicBlur.create(renderScriptCreate, allocationCreateFromBitmap.getElement());
            scriptIntrinsicBlurCreate.setInput(allocationCreateFromBitmap);
            scriptIntrinsicBlurCreate.setRadius(7.5f);
            scriptIntrinsicBlurCreate.forEach(allocationCreateTyped);
            allocationCreateTyped.copyTo(bitmapCreateBitmap);
            renderScriptCreate.destroy();
            c3988b2.m7975b("End blurring bitmap %s, original width = %d, original height = %d.", bitmapCreateScaledBitmap, Integer.valueOf(iRound), Integer.valueOf(iRound2));
            if (bitmapCreateBitmap != null) {
                this.f4923U.setImageBitmap(bitmapCreateBitmap);
                this.f4923U.setVisibility(0);
            }
        }
        AdBreakClipInfo adBreakClipInfoM3601j = mediaStatusM7302f.m3601j();
        if (adBreakClipInfoM3601j != null) {
            string = adBreakClipInfoM3601j.f4565b;
            str = adBreakClipInfoM3601j.f4572i;
        } else {
            str = null;
            string = null;
        }
        if (!TextUtils.isEmpty(str)) {
            this.f4933f0.m3259i(Uri.parse(str));
            this.f4927Y.setVisibility(8);
        } else if (TextUtils.isEmpty(this.f4940m0)) {
            this.f4929b0.setVisibility(0);
            this.f4927Y.setVisibility(0);
            this.f4928Z.setVisibility(8);
        } else {
            this.f4933f0.m3259i(Uri.parse(this.f4940m0));
            this.f4927Y.setVisibility(8);
        }
        TextView textView = this.f4930c0;
        if (TextUtils.isEmpty(string)) {
            string = getResources().getString(R.string.cast_ad_label);
        }
        textView.setText(string);
        if (Build.VERSION.SDK_INT >= 23) {
            this.f4930c0.setTextAppearance(this.f4917O);
        } else {
            this.f4930c0.setTextAppearance(this, this.f4917O);
        }
        this.f4926X.setVisibility(0);
        m3630r(c3616fM3628p);
    }
}
