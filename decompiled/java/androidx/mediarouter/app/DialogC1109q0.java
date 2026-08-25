package androidx.mediarouter.app;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AbstractDialogC0139i0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.p2serv.android.p032ds.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import p143n5.AbstractC3198d;
import p156o9.AbstractC3280d;
import p173q1.C3424l0;
import p173q1.C3436p0;
import p173q1.C3442r0;
import p173q1.C3445s0;
import p173q1.C3451u0;
import p173q1.C3460z;
import p222u7.AbstractC3928d;

public final class DialogC1109q0 extends AbstractDialogC0139i0 {

    public static final int f3307S = 0;

    public ImageButton f3308A;

    public Button f3309B;

    public ImageView f3310C;

    public View f3311D;

    public ImageView f3312E;

    public TextView f3313F;

    public TextView f3314G;

    public String f3315H;

    public MediaControllerCompat f3316I;

    public final C1087f0 f3317J;

    public MediaDescriptionCompat f3318K;

    public AsyncTaskC1085e0 f3319L;

    public Bitmap f3320M;

    public Uri f3321N;

    public boolean f3322O;

    public Bitmap f3323P;

    public int f3324Q;

    public final boolean f3325R;

    public final C3451u0 f3326e;

    public final C1093i0 f3327f;

    public C3424l0 f3328g;

    public C3445s0 f3329h;

    public final ArrayList f3330i;

    public final ArrayList f3331j;

    public final ArrayList f3332k;

    public final ArrayList f3333l;

    public final Context f3334m;

    public boolean f3335n;

    public boolean f3336o;

    public long f3337p;

    public final HandlerC1080c f3338q;

    public RecyclerView f3339r;

    public C1105o0 f3340s;

    public C1107p0 f3341t;

    public HashMap f3342u;

    public C3445s0 f3343v;

    public HashMap f3344w;

    public boolean f3345x;

    public boolean f3346y;

    public boolean f3347z;

    static {
        Log.isLoggable("MediaRouteCtrlDialog", 3);
    }

    public DialogC1109q0(Context context) {
        ContextThemeWrapper contextThemeWrapperM6589g = AbstractC3280d.m6589g(context, false);
        super(contextThemeWrapperM6589g, AbstractC3280d.m6590h(contextThemeWrapperM6589g));
        this.f3328g = C3424l0.f11567c;
        this.f3330i = new ArrayList();
        this.f3331j = new ArrayList();
        this.f3332k = new ArrayList();
        this.f3333l = new ArrayList();
        this.f3338q = new HandlerC1080c(2, this);
        Context context2 = getContext();
        this.f3334m = context2;
        this.f3326e = C3451u0.m7069d(context2);
        this.f3325R = C3451u0.m7072g();
        this.f3327f = new C1093i0(this, 0);
        this.f3329h = C3451u0.m7071f();
        this.f3317J = new C1087f0(this);
        m2774k(C3451u0.m7070e());
    }

    public final void m2772i(List list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            C3445s0 c3445s0 = (C3445s0) list.get(size);
            if (c3445s0.m7021d() || !c3445s0.f11658g || !c3445s0.m7025h(this.f3328g) || this.f3329h == c3445s0) {
                list.remove(size);
            }
        }
    }

    public final void m2773j() {
        MediaDescriptionCompat mediaDescriptionCompat = this.f3318K;
        Bitmap iconBitmap = mediaDescriptionCompat == null ? null : mediaDescriptionCompat.getIconBitmap();
        MediaDescriptionCompat mediaDescriptionCompat2 = this.f3318K;
        Uri iconUri = mediaDescriptionCompat2 != null ? mediaDescriptionCompat2.getIconUri() : null;
        AsyncTaskC1085e0 asyncTaskC1085e0 = this.f3319L;
        Bitmap bitmap = asyncTaskC1085e0 == null ? this.f3320M : asyncTaskC1085e0.f3217a;
        Uri uri = asyncTaskC1085e0 == null ? this.f3321N : asyncTaskC1085e0.f3218b;
        if (bitmap != iconBitmap || (bitmap == null && !Objects.equals(uri, iconUri))) {
            AsyncTaskC1085e0 asyncTaskC1085e1 = this.f3319L;
            if (asyncTaskC1085e1 != null) {
                asyncTaskC1085e1.cancel(true);
            }
            AsyncTaskC1085e0 asyncTaskC1085e2 = new AsyncTaskC1085e0(this);
            this.f3319L = asyncTaskC1085e2;
            asyncTaskC1085e2.execute(new Void[0]);
        }
    }

    public final void m2774k(MediaSessionCompat.Token token) {
        MediaControllerCompat mediaControllerCompat = this.f3316I;
        C1087f0 c1087f0 = this.f3317J;
        if (mediaControllerCompat != null) {
            mediaControllerCompat.unregisterCallback(c1087f0);
            this.f3316I = null;
        }
        if (token != null && this.f3336o) {
            MediaControllerCompat mediaControllerCompat2 = new MediaControllerCompat(this.f3334m, token);
            this.f3316I = mediaControllerCompat2;
            mediaControllerCompat2.registerCallback(c1087f0);
            MediaMetadataCompat metadata = this.f3316I.getMetadata();
            this.f3318K = metadata != null ? metadata.getDescription() : null;
            m2773j();
            m2777n();
        }
    }

    public final void m2775l(C3424l0 c3424l0) {
        if (c3424l0 == null) {
            throw new IllegalArgumentException("selector must not be null");
        }
        if (this.f3328g.equals(c3424l0)) {
            return;
        }
        this.f3328g = c3424l0;
        if (this.f3336o) {
            C3451u0 c3451u0 = this.f3326e;
            C1093i0 c1093i0 = this.f3327f;
            c3451u0.m7075h(c1093i0);
            c3451u0.m7074a(c3424l0, c1093i0, 1);
            m2778o();
        }
    }

    public final void m2776m() {
        Context context = this.f3334m;
        getWindow().setLayout(!context.getResources().getBoolean(R.bool.is_tablet) ? -1 : AbstractC3198d.m6473v(context), context.getResources().getBoolean(R.bool.is_tablet) ? -2 : -1);
        this.f3320M = null;
        this.f3321N = null;
        m2773j();
        m2777n();
        m2779p();
    }

    public final void m2777n() {
        Bitmap bitmap;
        if ((this.f3343v != null || this.f3345x) ? true : !this.f3335n) {
            this.f3347z = true;
            return;
        }
        this.f3347z = false;
        if (!this.f3329h.m7024g() || this.f3329h.m7021d()) {
            dismiss();
        }
        if (!this.f3322O || (((bitmap = this.f3323P) != null && bitmap.isRecycled()) || this.f3323P == null)) {
            Bitmap bitmap2 = this.f3323P;
            if (bitmap2 != null && bitmap2.isRecycled()) {
                Log.w("MediaRouteCtrlDialog", "Can't set artwork image with recycled bitmap: " + this.f3323P);
            }
            this.f3312E.setVisibility(8);
            this.f3311D.setVisibility(8);
            this.f3310C.setImageBitmap(null);
        } else {
            this.f3312E.setVisibility(0);
            this.f3312E.setImageBitmap(this.f3323P);
            this.f3312E.setBackgroundColor(this.f3324Q);
            this.f3311D.setVisibility(0);
            Bitmap bitmap3 = this.f3323P;
            RenderScript renderScriptCreate = RenderScript.create(this.f3334m);
            Allocation allocationCreateFromBitmap = Allocation.createFromBitmap(renderScriptCreate, bitmap3);
            Allocation allocationCreateTyped = Allocation.createTyped(renderScriptCreate, allocationCreateFromBitmap.getType());
            ScriptIntrinsicBlur scriptIntrinsicBlurCreate = ScriptIntrinsicBlur.create(renderScriptCreate, Element.U8_4(renderScriptCreate));
            scriptIntrinsicBlurCreate.setRadius(10.0f);
            scriptIntrinsicBlurCreate.setInput(allocationCreateFromBitmap);
            scriptIntrinsicBlurCreate.forEach(allocationCreateTyped);
            Bitmap bitmapCopy = bitmap3.copy(bitmap3.getConfig(), true);
            allocationCreateTyped.copyTo(bitmapCopy);
            allocationCreateFromBitmap.destroy();
            allocationCreateTyped.destroy();
            scriptIntrinsicBlurCreate.destroy();
            renderScriptCreate.destroy();
            this.f3310C.setImageBitmap(bitmapCopy);
        }
        this.f3322O = false;
        this.f3323P = null;
        this.f3324Q = 0;
        MediaDescriptionCompat mediaDescriptionCompat = this.f3318K;
        CharSequence title = mediaDescriptionCompat == null ? null : mediaDescriptionCompat.getTitle();
        boolean zIsEmpty = TextUtils.isEmpty(title);
        MediaDescriptionCompat mediaDescriptionCompat2 = this.f3318K;
        CharSequence subtitle = mediaDescriptionCompat2 != null ? mediaDescriptionCompat2.getSubtitle() : null;
        boolean zIsEmpty2 = TextUtils.isEmpty(subtitle);
        if (zIsEmpty) {
            this.f3313F.setText(this.f3315H);
        } else {
            this.f3313F.setText(title);
        }
        if (zIsEmpty2) {
            this.f3314G.setVisibility(8);
        } else {
            this.f3314G.setText(subtitle);
            this.f3314G.setVisibility(0);
        }
    }

    public final void m2778o() {
        ArrayList arrayList = this.f3330i;
        arrayList.clear();
        ArrayList arrayList2 = this.f3331j;
        arrayList2.clear();
        ArrayList arrayList3 = this.f3332k;
        arrayList3.clear();
        arrayList.addAll(Collections.unmodifiableList(this.f3329h.f11673v));
        C3436p0 c3436p0M7019a = this.f3329h.m7019a();
        if (c3436p0M7019a != null) {
            C3442r0 c3442r0 = this.f3329h.f11652a;
            c3442r0.getClass();
            C3451u0.m7067b();
            for (C3445s0 c3445s0 : Collections.unmodifiableList(c3442r0.f11644b)) {
                if (c3436p0M7019a.m7014o(c3445s0)) {
                    arrayList2.add(c3445s0);
                }
                C3460z c3460z = (C3460z) c3436p0M7019a.f11621x.get(c3445s0.f11654c);
                if (c3460z != null && c3460z.f11723e) {
                    arrayList3.add(c3445s0);
                }
            }
        }
        m2772i(arrayList2);
        m2772i(arrayList3);
        C1084e c1084e = C1084e.f3215d;
        Collections.sort(arrayList, c1084e);
        Collections.sort(arrayList2, c1084e);
        Collections.sort(arrayList3, c1084e);
        this.f3340s.m2770d();
    }

    @Override
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f3336o = true;
        this.f3326e.m7074a(this.f3328g, this.f3327f, 1);
        m2778o();
        m2774k(C3451u0.m7070e());
    }

    @Override
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.mr_cast_dialog);
        Context context = this.f3334m;
        getWindow().getDecorView().setBackgroundColor(AbstractC3928d.m7847i(context, AbstractC3280d.m6602t(context) ? R.color.mr_dynamic_dialog_background_light : R.color.mr_dynamic_dialog_background_dark));
        ImageButton imageButton = (ImageButton) findViewById(R.id.mr_cast_close_button);
        this.f3308A = imageButton;
        imageButton.setColorFilter(-1);
        this.f3308A.setOnClickListener(new ViewOnClickListenerC1083d0(this, 0));
        Button button = (Button) findViewById(R.id.mr_cast_stop_button);
        this.f3309B = button;
        button.setTextColor(-1);
        this.f3309B.setOnClickListener(new ViewOnClickListenerC1083d0(this, 1));
        this.f3340s = new C1105o0(this);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.mr_cast_list);
        this.f3339r = recyclerView;
        recyclerView.setAdapter(this.f3340s);
        this.f3339r.setLayoutManager(new LinearLayoutManager(1));
        this.f3341t = new C1107p0(this);
        this.f3342u = new HashMap();
        this.f3344w = new HashMap();
        this.f3310C = (ImageView) findViewById(R.id.mr_cast_meta_background);
        this.f3311D = findViewById(R.id.mr_cast_meta_black_scrim);
        this.f3312E = (ImageView) findViewById(R.id.mr_cast_meta_art);
        TextView textView = (TextView) findViewById(R.id.mr_cast_meta_title);
        this.f3313F = textView;
        textView.setTextColor(-1);
        TextView textView2 = (TextView) findViewById(R.id.mr_cast_meta_subtitle);
        this.f3314G = textView2;
        textView2.setTextColor(-1);
        this.f3315H = context.getResources().getString(R.string.mr_cast_dialog_title_view_placeholder);
        this.f3335n = true;
        m2776m();
    }

    @Override
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f3336o = false;
        this.f3326e.m7075h(this.f3327f);
        this.f3338q.removeCallbacksAndMessages(null);
        m2774k(null);
    }

    public final void m2779p() {
        if (this.f3336o) {
            if (SystemClock.uptimeMillis() - this.f3337p < 300) {
                HandlerC1080c handlerC1080c = this.f3338q;
                handlerC1080c.removeMessages(1);
                handlerC1080c.sendEmptyMessageAtTime(1, this.f3337p + 300);
                return;
            }
            if ((this.f3343v != null || this.f3345x) ? true : !this.f3335n) {
                this.f3346y = true;
                return;
            }
            this.f3346y = false;
            if (!this.f3329h.m7024g() || this.f3329h.m7021d()) {
                dismiss();
            }
            this.f3337p = SystemClock.uptimeMillis();
            this.f3340s.m2769c();
        }
    }

    public final void m2780q() {
        if (this.f3346y) {
            m2779p();
        }
        if (this.f3347z) {
            m2777n();
        }
    }
}
