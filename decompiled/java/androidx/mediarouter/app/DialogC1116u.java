package androidx.mediarouter.app;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.app.DialogInterfaceC0140j;
import com.p2serv.android.p032ds.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;
import p007a7.C0069f;
import p056f0.AbstractC2478a;
import p143n5.AbstractC3198d;
import p156o9.AbstractC3280d;
import p173q1.C3424l0;
import p173q1.C3445s0;
import p173q1.C3451u0;

public final class DialogC1116u extends DialogInterfaceC0140j {

    public static final int f3365p0;

    public RelativeLayout f3366A;

    public LinearLayout f3367B;

    public View f3368C;

    public OverlayListView f3369D;

    public C1114t f3370E;

    public ArrayList f3371F;

    public HashSet f3372G;

    public HashSet f3373H;

    public HashSet f3374I;

    public SeekBar f3375J;

    public C1112s f3376K;

    public C3445s0 f3377L;

    public int f3378M;

    public int f3379N;

    public int f3380O;

    public final int f3381P;

    public HashMap f3382Q;

    public MediaControllerCompat f3383R;

    public final C1110r f3384S;

    public PlaybackStateCompat f3385T;

    public MediaDescriptionCompat f3386U;

    public AsyncTaskC1108q f3387V;

    public Bitmap f3388W;

    public Uri f3389X;

    public boolean f3390Y;

    public Bitmap f3391Z;

    public int f3392b0;

    public boolean f3393c0;

    public boolean f3394d0;

    public boolean f3395e0;

    public final C3451u0 f3396f;

    public boolean f3397f0;

    public final C1093i0 f3398g;

    public boolean f3399g0;

    public final C3445s0 f3400h;

    public int f3401h0;

    public final Context f3402i;

    public int f3403i0;

    public boolean f3404j;

    public int f3405j0;

    public boolean f3406k;

    public Interpolator f3407k0;

    public int f3408l;

    public final Interpolator f3409l0;

    public Button f3410m;

    public final Interpolator f3411m0;

    public Button f3412n;

    public final AccessibilityManager f3413n0;

    public ImageButton f3414o;

    public final RunnableC1092i f3415o0;

    public MediaRouteExpandCollapseButton f3416p;

    public FrameLayout f3417q;

    public LinearLayout f3418r;

    public FrameLayout f3419s;

    public ImageView f3420t;

    public TextView f3421u;

    public TextView f3422v;

    public TextView f3423w;

    public final boolean f3424x;

    public final boolean f3425y;

    public LinearLayout f3426z;

    static {
        Log.isLoggable("MediaRouteCtrlDialog", 3);
        f3365p0 = (int) TimeUnit.SECONDS.toMillis(30L);
    }

    public DialogC1116u(Context context) {
        ContextThemeWrapper contextThemeWrapperM6589g = AbstractC3280d.m6589g(context, true);
        super(contextThemeWrapperM6589g, AbstractC3280d.m6590h(contextThemeWrapperM6589g));
        this.f3424x = true;
        this.f3415o0 = new RunnableC1092i(0, this);
        Context context2 = getContext();
        this.f3402i = context2;
        this.f3384S = new C1110r(this);
        this.f3396f = C3451u0.m7069d(context2);
        this.f3425y = C3451u0.m7072g();
        this.f3398g = new C1093i0(this, 3);
        this.f3400h = C3451u0.m7071f();
        m2798r(C3451u0.m7070e());
        this.f3381P = context2.getResources().getDimensionPixelSize(R.dimen.mr_controller_volume_group_list_padding_top);
        this.f3413n0 = (AccessibilityManager) context2.getSystemService("accessibility");
        this.f3409l0 = AnimationUtils.loadInterpolator(contextThemeWrapperM6589g, R.interpolator.mr_linear_out_slow_in);
        this.f3411m0 = AnimationUtils.loadInterpolator(contextThemeWrapperM6589g, R.interpolator.mr_fast_out_slow_in);
    }

    public static void m2790q(int i6, View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = i6;
        view.setLayoutParams(layoutParams);
    }

    public final void m2791j(int i6, View view) {
        C1100m c1100m = new C1100m(view.getLayoutParams().height, i6, 0, view);
        c1100m.setDuration(this.f3401h0);
        c1100m.setInterpolator(this.f3407k0);
        view.startAnimation(c1100m);
    }

    public final boolean m2792k() {
        return (this.f3386U == null && this.f3385T == null) ? false : true;
    }

    public final void m2793l(boolean z7) {
        HashSet hashSet;
        int firstVisiblePosition = this.f3369D.getFirstVisiblePosition();
        for (int i6 = 0; i6 < this.f3369D.getChildCount(); i6++) {
            View childAt = this.f3369D.getChildAt(i6);
            C3445s0 c3445s0 = (C3445s0) this.f3370E.getItem(firstVisiblePosition + i6);
            if (!z7 || (hashSet = this.f3372G) == null || !hashSet.contains(c3445s0)) {
                ((LinearLayout) childAt.findViewById(R.id.volume_item_container)).setVisibility(0);
                AnimationSet animationSet = new AnimationSet(true);
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 1.0f);
                alphaAnimation.setDuration(0L);
                animationSet.addAnimation(alphaAnimation);
                new TranslateAnimation(0.0f, 0.0f, 0.0f, 0.0f).setDuration(0L);
                animationSet.setFillAfter(true);
                animationSet.setFillEnabled(true);
                childAt.clearAnimation();
                childAt.startAnimation(animationSet);
            }
        }
        for (C1111r0 c1111r0 : this.f3369D.f3174a) {
            c1111r0.f3358j = true;
            c1111r0.f3359k = true;
            C0069f c0069f = c1111r0.f3360l;
            if (c0069f != null) {
                DialogC1116u dialogC1116u = (DialogC1116u) c0069f.f197c;
                dialogC1116u.f3374I.remove((C3445s0) c0069f.f196b);
                dialogC1116u.f3370E.notifyDataSetChanged();
            }
        }
        if (z7) {
            return;
        }
        m2794m(false);
    }

    public final void m2794m(boolean z7) {
        this.f3372G = null;
        this.f3373H = null;
        this.f3397f0 = false;
        if (this.f3399g0) {
            this.f3399g0 = false;
            m2802v(z7);
        }
        this.f3369D.setEnabled(true);
    }

    public final int m2795n(int i6, int i10) {
        return i6 >= i10 ? (int) (((this.f3408l * i10) / i6) + 0.5f) : (int) (((this.f3408l * 9.0f) / 16.0f) + 0.5f);
    }

    public final int m2796o(boolean z7) {
        if (!z7 && this.f3367B.getVisibility() != 0) {
            return 0;
        }
        int paddingBottom = this.f3426z.getPaddingBottom() + this.f3426z.getPaddingTop();
        if (z7) {
            paddingBottom += this.f3366A.getMeasuredHeight();
        }
        int measuredHeight = this.f3367B.getVisibility() == 0 ? this.f3367B.getMeasuredHeight() + paddingBottom : paddingBottom;
        return (z7 && this.f3367B.getVisibility() == 0) ? this.f3368C.getMeasuredHeight() + measuredHeight : measuredHeight;
    }

    @Override
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f3406k = true;
        this.f3396f.m7074a(C3424l0.f11567c, this.f3398g, 2);
        m2798r(C3451u0.m7070e());
    }

    @Override
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        setContentView(R.layout.mr_controller_material_dialog_b);
        findViewById(android.R.id.button3).setVisibility(8);
        ViewOnClickListenerC1106p viewOnClickListenerC1106p = new ViewOnClickListenerC1106p(this);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.mr_expandable_area);
        this.f3417q = frameLayout;
        frameLayout.setOnClickListener(new ViewOnClickListenerC1096k(this, 1));
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.mr_dialog_area);
        this.f3418r = linearLayout;
        linearLayout.setOnClickListener(new ViewOnClickListenerC1094j());
        Context context = this.f3402i;
        int iM6600r = AbstractC3280d.m6600r(context, 0, R.attr.colorPrimary);
        if (AbstractC2478a.m5508c(iM6600r, AbstractC3280d.m6600r(context, 0, android.R.attr.colorBackground)) < 3.0d) {
            iM6600r = AbstractC3280d.m6600r(context, 0, R.attr.colorAccent);
        }
        Button button = (Button) findViewById(android.R.id.button2);
        this.f3410m = button;
        button.setText(R.string.mr_controller_disconnect);
        this.f3410m.setTextColor(iM6600r);
        this.f3410m.setOnClickListener(viewOnClickListenerC1106p);
        Button button2 = (Button) findViewById(android.R.id.button1);
        this.f3412n = button2;
        button2.setText(R.string.mr_controller_stop_casting);
        this.f3412n.setTextColor(iM6600r);
        this.f3412n.setOnClickListener(viewOnClickListenerC1106p);
        this.f3423w = (TextView) findViewById(R.id.mr_name);
        ((ImageButton) findViewById(R.id.mr_close)).setOnClickListener(viewOnClickListenerC1106p);
        this.f3419s = (FrameLayout) findViewById(R.id.mr_default_control);
        ViewOnClickListenerC1096k viewOnClickListenerC1096k = new ViewOnClickListenerC1096k(this, 2);
        ImageView imageView = (ImageView) findViewById(R.id.mr_art);
        this.f3420t = imageView;
        imageView.setOnClickListener(viewOnClickListenerC1096k);
        findViewById(R.id.mr_control_title_container).setOnClickListener(viewOnClickListenerC1096k);
        this.f3426z = (LinearLayout) findViewById(R.id.mr_media_main_control);
        this.f3368C = findViewById(R.id.mr_control_divider);
        this.f3366A = (RelativeLayout) findViewById(R.id.mr_playback_control);
        this.f3421u = (TextView) findViewById(R.id.mr_control_title);
        this.f3422v = (TextView) findViewById(R.id.mr_control_subtitle);
        ImageButton imageButton = (ImageButton) findViewById(R.id.mr_control_playback_ctrl);
        this.f3414o = imageButton;
        imageButton.setOnClickListener(viewOnClickListenerC1106p);
        LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.mr_volume_control);
        this.f3367B = linearLayout2;
        linearLayout2.setVisibility(8);
        SeekBar seekBar = (SeekBar) findViewById(R.id.mr_volume_slider);
        this.f3375J = seekBar;
        C3445s0 c3445s0 = this.f3400h;
        seekBar.setTag(c3445s0);
        C1112s c1112s = new C1112s(this);
        this.f3376K = c1112s;
        this.f3375J.setOnSeekBarChangeListener(c1112s);
        this.f3369D = (OverlayListView) findViewById(R.id.mr_volume_group_list);
        this.f3371F = new ArrayList();
        C1114t c1114t = new C1114t(this, this.f3369D.getContext(), this.f3371F);
        this.f3370E = c1114t;
        this.f3369D.setAdapter((ListAdapter) c1114t);
        this.f3374I = new HashSet();
        LinearLayout linearLayout3 = this.f3426z;
        OverlayListView overlayListView = this.f3369D;
        boolean zM2797p = m2797p();
        int iM6600r2 = AbstractC3280d.m6600r(context, 0, R.attr.colorPrimary);
        int iM6600r3 = AbstractC3280d.m6600r(context, 0, R.attr.colorPrimaryDark);
        if (zM2797p && AbstractC3280d.m6594l(context, 0) == -570425344) {
            iM6600r3 = iM6600r2;
            iM6600r2 = -1;
        }
        linearLayout3.setBackgroundColor(iM6600r2);
        overlayListView.setBackgroundColor(iM6600r3);
        linearLayout3.setTag(Integer.valueOf(iM6600r2));
        overlayListView.setTag(Integer.valueOf(iM6600r3));
        MediaRouteVolumeSlider mediaRouteVolumeSlider = (MediaRouteVolumeSlider) this.f3375J;
        LinearLayout linearLayout4 = this.f3426z;
        int iM6594l = AbstractC3280d.m6594l(context, 0);
        if (Color.alpha(iM6594l) != 255) {
            iM6594l = AbstractC2478a.m5511f(iM6594l, ((Integer) linearLayout4.getTag()).intValue());
        }
        mediaRouteVolumeSlider.m2736a(iM6594l, iM6594l);
        HashMap map = new HashMap();
        this.f3382Q = map;
        map.put(c3445s0, this.f3375J);
        MediaRouteExpandCollapseButton mediaRouteExpandCollapseButton = (MediaRouteExpandCollapseButton) findViewById(R.id.mr_group_expand_collapse);
        this.f3416p = mediaRouteExpandCollapseButton;
        mediaRouteExpandCollapseButton.f3168i = new ViewOnClickListenerC1096k(this, 0);
        this.f3407k0 = this.f3395e0 ? this.f3409l0 : this.f3411m0;
        this.f3401h0 = context.getResources().getInteger(R.integer.mr_controller_volume_group_list_animation_duration_ms);
        this.f3403i0 = context.getResources().getInteger(R.integer.mr_controller_volume_group_list_fade_in_duration_ms);
        this.f3405j0 = context.getResources().getInteger(R.integer.mr_controller_volume_group_list_fade_out_duration_ms);
        this.f3404j = true;
        m2801u();
    }

    @Override
    public final void onDetachedFromWindow() {
        this.f3396f.m7075h(this.f3398g);
        m2798r(null);
        this.f3406k = false;
        super.onDetachedFromWindow();
    }

    @Override
    public final boolean onKeyDown(int i6, KeyEvent keyEvent) {
        if (i6 != 25 && i6 != 24) {
            return super.onKeyDown(i6, keyEvent);
        }
        if (this.f3425y || !this.f3395e0) {
            this.f3400h.m7028k(i6 == 25 ? -1 : 1);
        }
        return true;
    }

    @Override
    public final boolean onKeyUp(int i6, KeyEvent keyEvent) {
        if (i6 == 25 || i6 == 24) {
            return true;
        }
        return super.onKeyUp(i6, keyEvent);
    }

    public final boolean m2797p() {
        C3445s0 c3445s0 = this.f3400h;
        return c3445s0.m7022e() && Collections.unmodifiableList(c3445s0.f11673v).size() > 1;
    }

    public final void m2798r(MediaSessionCompat.Token token) {
        MediaControllerCompat mediaControllerCompat = this.f3383R;
        C1110r c1110r = this.f3384S;
        if (mediaControllerCompat != null) {
            mediaControllerCompat.unregisterCallback(c1110r);
            this.f3383R = null;
        }
        if (token != null && this.f3406k) {
            MediaControllerCompat mediaControllerCompat2 = new MediaControllerCompat(this.f3402i, token);
            this.f3383R = mediaControllerCompat2;
            mediaControllerCompat2.registerCallback(c1110r);
            MediaMetadataCompat metadata = this.f3383R.getMetadata();
            this.f3386U = metadata != null ? metadata.getDescription() : null;
            this.f3385T = this.f3383R.getPlaybackState();
            m2800t();
            m2799s(false);
        }
    }

    public final void m2799s(boolean z7) {
        boolean z10;
        boolean z11;
        int i6;
        int i10;
        PlaybackStateCompat playbackStateCompat;
        boolean z12;
        Context context;
        int i11;
        int i12;
        boolean z13 = true;
        if (this.f3377L != null) {
            this.f3393c0 = true;
            this.f3394d0 = z7 | this.f3394d0;
            return;
        }
        this.f3393c0 = false;
        this.f3394d0 = false;
        C3445s0 c3445s0 = this.f3400h;
        if (!c3445s0.m7024g() || c3445s0.m7021d()) {
            dismiss();
            return;
        }
        if (this.f3404j) {
            this.f3423w.setText(c3445s0.f11655d);
            this.f3410m.setVisibility(c3445s0.f11661j ? 0 : 8);
            if (this.f3390Y) {
                Bitmap bitmap = this.f3391Z;
                if (bitmap == null || !bitmap.isRecycled()) {
                    this.f3420t.setImageBitmap(this.f3391Z);
                    this.f3420t.setBackgroundColor(this.f3392b0);
                } else {
                    Log.w("MediaRouteCtrlDialog", "Can't set artwork image with recycled bitmap: " + this.f3391Z);
                }
                this.f3390Y = false;
                this.f3391Z = null;
                this.f3392b0 = 0;
            }
            boolean z14 = this.f3425y;
            if (!z14 && m2797p()) {
                this.f3367B.setVisibility(8);
                this.f3395e0 = true;
                this.f3369D.setVisibility(0);
                this.f3407k0 = this.f3395e0 ? this.f3409l0 : this.f3411m0;
                m2802v(false);
            } else if ((!this.f3395e0 || z14) && this.f3424x) {
                if (((!c3445s0.m7022e() || C3451u0.m7072g()) ? c3445s0.f11666o : 0) != 1) {
                    this.f3367B.setVisibility(8);
                } else if (this.f3367B.getVisibility() == 8) {
                    this.f3367B.setVisibility(0);
                    this.f3375J.setMax(c3445s0.f11668q);
                    this.f3375J.setProgress(c3445s0.f11667p);
                    this.f3416p.setVisibility(m2797p() ? 0 : 8);
                }
            } else {
                this.f3367B.setVisibility(8);
            }
            if (m2792k()) {
                MediaDescriptionCompat mediaDescriptionCompat = this.f3386U;
                CharSequence title = mediaDescriptionCompat == null ? null : mediaDescriptionCompat.getTitle();
                boolean zIsEmpty = TextUtils.isEmpty(title);
                MediaDescriptionCompat mediaDescriptionCompat2 = this.f3386U;
                CharSequence subtitle = mediaDescriptionCompat2 != null ? mediaDescriptionCompat2.getSubtitle() : null;
                boolean zIsEmpty2 = TextUtils.isEmpty(subtitle);
                if (c3445s0.f11669r != -1) {
                    this.f3421u.setText(R.string.mr_controller_casting_screen);
                } else {
                    PlaybackStateCompat playbackStateCompat2 = this.f3385T;
                    if (playbackStateCompat2 == null || playbackStateCompat2.getState() == 0) {
                        this.f3421u.setText(R.string.mr_controller_no_media_selected);
                    } else {
                        if (zIsEmpty && zIsEmpty2) {
                            this.f3421u.setText(R.string.mr_controller_no_info_available);
                        } else {
                            if (zIsEmpty) {
                                z10 = false;
                            } else {
                                this.f3421u.setText(title);
                                z10 = true;
                            }
                            if (zIsEmpty2) {
                                z11 = false;
                            } else {
                                this.f3422v.setText(subtitle);
                                z11 = true;
                            }
                        }
                        TextView textView = this.f3421u;
                        if (z10) {
                            i6 = 0;
                        } else {
                            i6 = 8;
                        }
                        textView.setVisibility(i6);
                        TextView textView2 = this.f3422v;
                        if (z11) {
                            i10 = 0;
                        } else {
                            i10 = 8;
                        }
                        textView2.setVisibility(i10);
                        playbackStateCompat = this.f3385T;
                        if (playbackStateCompat != null) {
                            if (playbackStateCompat.getState() != 6 || this.f3385T.getState() == 3) {
                                z12 = true;
                            } else {
                                z12 = false;
                            }
                            context = this.f3414o.getContext();
                            if (!z12 && (this.f3385T.getActions() & 514) != 0) {
                                i11 = R.attr.mediaRoutePauseDrawable;
                                i12 = R.string.mr_controller_pause;
                            } else if (!z12 && (this.f3385T.getActions() & 1) != 0) {
                                i11 = R.attr.mediaRouteStopDrawable;
                                i12 = R.string.mr_controller_stop;
                            } else if (!z12 || (this.f3385T.getActions() & 516) == 0) {
                                z13 = false;
                                i11 = 0;
                                i12 = 0;
                            } else {
                                i11 = R.attr.mediaRoutePlayDrawable;
                                i12 = R.string.mr_controller_play;
                            }
                            this.f3414o.setVisibility(z13 ? 0 : 8);
                            if (z13) {
                                this.f3414o.setImageResource(AbstractC3280d.m6601s(context, i11));
                                this.f3414o.setContentDescription(context.getResources().getText(i12));
                            }
                        }
                    }
                }
                z10 = true;
                z11 = false;
                TextView textView3 = this.f3421u;
                if (z10) {
                    i6 = 0;
                } else {
                    i6 = 8;
                }
                textView3.setVisibility(i6);
                TextView textView4 = this.f3422v;
                if (z11) {
                    i10 = 0;
                } else {
                    i10 = 8;
                }
                textView4.setVisibility(i10);
                playbackStateCompat = this.f3385T;
                if (playbackStateCompat != null) {
                    if (playbackStateCompat.getState() != 6) {
                        z12 = true;
                    } else {
                        z12 = true;
                    }
                    context = this.f3414o.getContext();
                    if (!z12) {
                        if (!z12) {
                            if (z12) {
                                z13 = false;
                                i11 = 0;
                                i12 = 0;
                            } else {
                                z13 = false;
                                i11 = 0;
                                i12 = 0;
                            }
                        } else if (z12) {
                            z13 = false;
                            i11 = 0;
                            i12 = 0;
                        } else {
                            z13 = false;
                            i11 = 0;
                            i12 = 0;
                        }
                    } else if (!z12) {
                        if (z12) {
                            z13 = false;
                            i11 = 0;
                            i12 = 0;
                        } else {
                            z13 = false;
                            i11 = 0;
                            i12 = 0;
                        }
                    } else if (z12) {
                        z13 = false;
                        i11 = 0;
                        i12 = 0;
                    } else {
                        z13 = false;
                        i11 = 0;
                        i12 = 0;
                    }
                    this.f3414o.setVisibility(z13 ? 0 : 8);
                    if (z13) {
                        this.f3414o.setImageResource(AbstractC3280d.m6601s(context, i11));
                        this.f3414o.setContentDescription(context.getResources().getText(i12));
                    }
                }
            }
            m2802v(z7);
        }
    }

    public final void m2800t() {
        MediaDescriptionCompat mediaDescriptionCompat = this.f3386U;
        Bitmap iconBitmap = mediaDescriptionCompat == null ? null : mediaDescriptionCompat.getIconBitmap();
        MediaDescriptionCompat mediaDescriptionCompat2 = this.f3386U;
        Uri iconUri = mediaDescriptionCompat2 != null ? mediaDescriptionCompat2.getIconUri() : null;
        AsyncTaskC1108q asyncTaskC1108q = this.f3387V;
        Bitmap bitmap = asyncTaskC1108q == null ? this.f3388W : asyncTaskC1108q.f3302a;
        Uri uri = asyncTaskC1108q == null ? this.f3389X : asyncTaskC1108q.f3303b;
        if (bitmap == iconBitmap) {
            if (bitmap != null) {
                return;
            }
            if (uri != null && uri.equals(iconUri)) {
                return;
            }
            if (uri == null && iconUri == null) {
                return;
            }
        }
        if (!m2797p() || this.f3425y) {
            AsyncTaskC1108q asyncTaskC1108q2 = this.f3387V;
            if (asyncTaskC1108q2 != null) {
                asyncTaskC1108q2.cancel(true);
            }
            AsyncTaskC1108q asyncTaskC1108q3 = new AsyncTaskC1108q(this);
            this.f3387V = asyncTaskC1108q3;
            asyncTaskC1108q3.execute(new Void[0]);
        }
    }

    public final void m2801u() {
        Context context = this.f3402i;
        int iM6473v = AbstractC3198d.m6473v(context);
        getWindow().setLayout(iM6473v, -2);
        View decorView = getWindow().getDecorView();
        this.f3408l = (iM6473v - decorView.getPaddingLeft()) - decorView.getPaddingRight();
        Resources resources = context.getResources();
        this.f3378M = resources.getDimensionPixelSize(R.dimen.mr_controller_volume_group_list_item_icon_size);
        this.f3379N = resources.getDimensionPixelSize(R.dimen.mr_controller_volume_group_list_item_height);
        this.f3380O = resources.getDimensionPixelSize(R.dimen.mr_controller_volume_group_list_max_height);
        this.f3388W = null;
        this.f3389X = null;
        m2800t();
        m2799s(false);
    }

    public final void m2802v(boolean z7) {
        this.f3419s.requestLayout();
        this.f3419s.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserverOnGlobalLayoutListenerC1098l(this, z7));
    }

    public final void m2803w(boolean z7) {
        int i6 = 0;
        this.f3368C.setVisibility((this.f3367B.getVisibility() == 0 && z7) ? 0 : 8);
        LinearLayout linearLayout = this.f3426z;
        if (this.f3367B.getVisibility() == 8 && !z7) {
            i6 = 8;
        }
        linearLayout.setVisibility(i6);
    }
}
