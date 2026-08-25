package androidx.mediarouter.app;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.AbstractC1158k0;
import androidx.recyclerview.widget.AbstractC1174p1;
import com.p2serv.android.p032ds.R;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import p156o9.AbstractC3280d;
import p173q1.AbstractC3394b0;
import p173q1.C3436p0;
import p173q1.C3442r0;
import p173q1.C3445s0;
import p173q1.C3451u0;
import p173q1.C3460z;

public final class C1105o0 extends AbstractC1158k0 {

    public final ArrayList f3290a = new ArrayList();

    public final LayoutInflater f3291b;

    public final Drawable f3292c;

    public final Drawable f3293d;

    public final Drawable f3294e;

    public final Drawable f3295f;

    public C1101m0 f3296g;

    public final int f3297h;

    public final AccelerateDecelerateInterpolator f3298i;

    public final DialogC1109q0 f3299j;

    public C1105o0(DialogC1109q0 dialogC1109q0) {
        this.f3299j = dialogC1109q0;
        this.f3291b = LayoutInflater.from(dialogC1109q0.f3334m);
        Context context = dialogC1109q0.f3334m;
        this.f3292c = AbstractC3280d.m6597o(context, R.attr.mediaRouteDefaultIconDrawable);
        this.f3293d = AbstractC3280d.m6597o(context, R.attr.mediaRouteTvIconDrawable);
        this.f3294e = AbstractC3280d.m6597o(context, R.attr.mediaRouteSpeakerIconDrawable);
        this.f3295f = AbstractC3280d.m6597o(context, R.attr.mediaRouteSpeakerGroupIconDrawable);
        this.f3297h = context.getResources().getInteger(R.integer.mr_cast_volume_slider_layout_animation_duration_ms);
        this.f3298i = new AccelerateDecelerateInterpolator();
        m2770d();
    }

    public final void m2767a(int i6, View view) {
        C1100m c1100m = new C1100m(i6, view.getLayoutParams().height, 1, view);
        c1100m.setAnimationListener(new AnimationAnimationListenerC1104o(2, this));
        c1100m.setDuration(this.f3297h);
        c1100m.setInterpolator(this.f3298i);
        view.startAnimation(c1100m);
    }

    public final Drawable m2768b(C3445s0 c3445s0) {
        Uri uri = c3445s0.f11657f;
        if (uri != null) {
            try {
                Drawable drawableCreateFromStream = Drawable.createFromStream(this.f3299j.f3334m.getContentResolver().openInputStream(uri), null);
                if (drawableCreateFromStream != null) {
                    return drawableCreateFromStream;
                }
            } catch (IOException e5) {
                Log.w("MediaRouteCtrlDialog", "Failed to load " + uri, e5);
            }
        }
        int i6 = c3445s0.f11665n;
        if (i6 == 1) {
            return this.f3293d;
        }
        if (i6 != 2) {
            return c3445s0.m7022e() ? this.f3295f : this.f3292c;
        }
        return this.f3294e;
    }

    public final void m2769c() {
        DialogC1109q0 dialogC1109q0 = this.f3299j;
        dialogC1109q0.f3333l.clear();
        ArrayList arrayList = dialogC1109q0.f3333l;
        ArrayList arrayList2 = dialogC1109q0.f3331j;
        ArrayList arrayList3 = new ArrayList();
        C3436p0 c3436p0M7019a = dialogC1109q0.f3329h.m7019a();
        if (c3436p0M7019a != null) {
            C3442r0 c3442r0 = dialogC1109q0.f3329h.f11652a;
            c3442r0.getClass();
            C3451u0.m7067b();
            for (C3445s0 c3445s0 : Collections.unmodifiableList(c3442r0.f11644b)) {
                if (c3436p0M7019a.m7014o(c3445s0)) {
                    arrayList3.add(c3445s0);
                }
            }
        }
        HashSet hashSet = new HashSet(arrayList2);
        hashSet.removeAll(arrayList3);
        arrayList.addAll(hashSet);
        notifyDataSetChanged();
    }

    public final void m2770d() {
        ArrayList arrayList = this.f3290a;
        arrayList.clear();
        DialogC1109q0 dialogC1109q0 = this.f3299j;
        this.f3296g = new C1101m0(1, dialogC1109q0.f3329h);
        ArrayList arrayList2 = dialogC1109q0.f3330i;
        if (arrayList2.isEmpty()) {
            arrayList.add(new C1101m0(3, dialogC1109q0.f3329h));
        } else {
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                arrayList.add(new C1101m0(3, (C3445s0) it.next()));
            }
        }
        ArrayList<C3445s0> arrayList3 = dialogC1109q0.f3331j;
        boolean z7 = false;
        if (!arrayList3.isEmpty()) {
            boolean z10 = false;
            for (C3445s0 c3445s0 : arrayList3) {
                if (!arrayList2.contains(c3445s0)) {
                    if (!z10) {
                        dialogC1109q0.f3329h.getClass();
                        AbstractC3394b0 abstractC3394b0M7018b = C3445s0.m7018b();
                        String strMo6887k = abstractC3394b0M7018b != null ? abstractC3394b0M7018b.mo6887k() : null;
                        if (TextUtils.isEmpty(strMo6887k)) {
                            strMo6887k = dialogC1109q0.f3334m.getString(R.string.mr_dialog_groupable_header);
                        }
                        arrayList.add(new C1101m0(2, strMo6887k));
                        z10 = true;
                    }
                    arrayList.add(new C1101m0(3, c3445s0));
                }
            }
        }
        ArrayList<C3445s0> arrayList4 = dialogC1109q0.f3332k;
        if (!arrayList4.isEmpty()) {
            for (C3445s0 c3445s1 : arrayList4) {
                C3445s0 c3445s2 = dialogC1109q0.f3329h;
                if (c3445s2 != c3445s1) {
                    if (!z7) {
                        c3445s2.getClass();
                        AbstractC3394b0 abstractC3394b0M7018b2 = C3445s0.m7018b();
                        String strMo6888l = abstractC3394b0M7018b2 != null ? abstractC3394b0M7018b2.mo6888l() : null;
                        if (TextUtils.isEmpty(strMo6888l)) {
                            strMo6888l = dialogC1109q0.f3334m.getString(R.string.mr_dialog_transferable_header);
                        }
                        arrayList.add(new C1101m0(2, strMo6888l));
                        z7 = true;
                    }
                    arrayList.add(new C1101m0(4, c3445s1));
                }
            }
        }
        m2769c();
    }

    @Override
    public final int getItemCount() {
        return this.f3290a.size() + 1;
    }

    @Override
    public final int getItemViewType(int i6) {
        return (i6 == 0 ? this.f3296g : (C1101m0) this.f3290a.get(i6 - 1)).f3274b;
    }

    @Override
    public final void onBindViewHolder(AbstractC1174p1 abstractC1174p1, int i6) {
        C3436p0 c3436p0M7019a;
        C3460z c3460z;
        ArrayList arrayList = this.f3290a;
        int i10 = (i6 == 0 ? this.f3296g : (C1101m0) arrayList.get(i6 - 1)).f3274b;
        boolean z7 = true;
        C1101m0 c1101m0 = i6 == 0 ? this.f3296g : (C1101m0) arrayList.get(i6 - 1);
        DialogC1109q0 dialogC1109q0 = this.f3299j;
        int i11 = 0;
        if (i10 == 1) {
            dialogC1109q0.f3342u.put(((C3445s0) c1101m0.f3273a).f11654c, (AbstractC1091h0) abstractC1174p1);
            C1097k0 c1097k0 = (C1097k0) abstractC1174p1;
            View view = c1097k0.itemView;
            DialogC1109q0 dialogC1109q1 = c1097k0.f3265g.f3299j;
            if (dialogC1109q1.f3325R && Collections.unmodifiableList(dialogC1109q1.f3329h.f11673v).size() > 1) {
                i11 = c1097k0.f3264f;
            }
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.height = i11;
            view.setLayoutParams(layoutParams);
            C3445s0 c3445s0 = (C3445s0) c1101m0.f3273a;
            c1097k0.m2748b(c3445s0);
            c1097k0.f3263e.setText(c3445s0.f11655d);
            return;
        }
        if (i10 == 2) {
            C1099l0 c1099l0 = (C1099l0) abstractC1174p1;
            c1099l0.getClass();
            c1099l0.f3268a.setText(c1101m0.f3273a.toString());
            return;
        }
        float f = 1.0f;
        if (i10 != 3) {
            if (i10 != 4) {
                throw new IllegalStateException();
            }
            C1095j0 c1095j0 = (C1095j0) abstractC1174p1;
            c1095j0.getClass();
            C3445s0 c3445s1 = (C3445s0) c1101m0.f3273a;
            c1095j0.f3259f = c3445s1;
            ImageView imageView = c1095j0.f3255b;
            imageView.setVisibility(0);
            c1095j0.f3256c.setVisibility(4);
            C1105o0 c1105o0 = c1095j0.f3260g;
            List listUnmodifiableList = Collections.unmodifiableList(c1105o0.f3299j.f3329h.f11673v);
            if (listUnmodifiableList.size() == 1 && listUnmodifiableList.get(0) == c3445s1) {
                f = c1095j0.f3258e;
            }
            View view2 = c1095j0.f3254a;
            view2.setAlpha(f);
            view2.setOnClickListener(new ViewOnClickListenerC1089g0(3, c1095j0));
            imageView.setImageDrawable(c1105o0.m2768b(c3445s1));
            c1095j0.f3257d.setText(c3445s1.f11655d);
            return;
        }
        dialogC1109q0.f3342u.put(((C3445s0) c1101m0.f3273a).f11654c, (AbstractC1091h0) abstractC1174p1);
        C1103n0 c1103n0 = (C1103n0) abstractC1174p1;
        c1103n0.getClass();
        C3445s0 c3445s2 = (C3445s0) c1101m0.f3273a;
        C1105o0 c1105o1 = c1103n0.f3287n;
        DialogC1109q0 dialogC1109q2 = c1105o1.f3299j;
        if (c3445s2 == dialogC1109q2.f3329h && Collections.unmodifiableList(c3445s2.f11673v).size() > 0) {
            for (C3445s0 c3445s3 : Collections.unmodifiableList(c3445s2.f11673v)) {
                if (!dialogC1109q2.f3331j.contains(c3445s3)) {
                    c3445s2 = c3445s3;
                    break;
                }
            }
        }
        c1103n0.m2748b(c3445s2);
        Drawable drawableM2768b = c1105o1.m2768b(c3445s2);
        ImageView imageView2 = c1103n0.f3279f;
        imageView2.setImageDrawable(drawableM2768b);
        c1103n0.f3281h.setText(c3445s2.f11655d);
        CheckBox checkBox = c1103n0.f3283j;
        checkBox.setVisibility(0);
        boolean zM2760d = c1103n0.m2760d(c3445s2);
        boolean z10 = !dialogC1109q2.f3333l.contains(c3445s2) && (!c1103n0.m2760d(c3445s2) || Collections.unmodifiableList(dialogC1109q2.f3329h.f11673v).size() >= 2) && !(c1103n0.m2760d(c3445s2) && ((c3436p0M7019a = dialogC1109q2.f3329h.m7019a()) == null || (c3460z = (C3460z) c3436p0M7019a.f11621x.get(c3445s2.f11654c)) == null || !c3460z.f11721c));
        checkBox.setChecked(zM2760d);
        c1103n0.f3280g.setVisibility(4);
        imageView2.setVisibility(0);
        View view3 = c1103n0.f3278e;
        view3.setEnabled(z10);
        checkBox.setEnabled(z10);
        c1103n0.f3247b.setEnabled(z10 || zM2760d);
        if (!z10 && !zM2760d) {
            z7 = false;
        }
        c1103n0.f3248c.setEnabled(z7);
        ViewOnClickListenerC1089g0 viewOnClickListenerC1089g0 = c1103n0.f3286m;
        view3.setOnClickListener(viewOnClickListenerC1089g0);
        checkBox.setOnClickListener(viewOnClickListenerC1089g0);
        if (zM2760d && !c1103n0.f3246a.m7022e()) {
            i11 = c1103n0.f3285l;
        }
        RelativeLayout relativeLayout = c1103n0.f3282i;
        ViewGroup.LayoutParams layoutParams2 = relativeLayout.getLayoutParams();
        layoutParams2.height = i11;
        relativeLayout.setLayoutParams(layoutParams2);
        float f3 = c1103n0.f3284k;
        view3.setAlpha((z10 || zM2760d) ? 1.0f : f3);
        if (!z10 && zM2760d) {
            f = f3;
        }
        checkBox.setAlpha(f);
    }

    @Override
    public final AbstractC1174p1 onCreateViewHolder(ViewGroup viewGroup, int i6) {
        LayoutInflater layoutInflater = this.f3291b;
        if (i6 == 1) {
            return new C1097k0(this, layoutInflater.inflate(R.layout.mr_cast_group_volume_item, viewGroup, false));
        }
        if (i6 == 2) {
            return new C1099l0(layoutInflater.inflate(R.layout.mr_cast_header_item, viewGroup, false));
        }
        if (i6 == 3) {
            return new C1103n0(this, layoutInflater.inflate(R.layout.mr_cast_route_item, viewGroup, false));
        }
        if (i6 == 4) {
            return new C1095j0(this, layoutInflater.inflate(R.layout.mr_cast_group_item, viewGroup, false));
        }
        throw new IllegalStateException();
    }

    @Override
    public final void onViewRecycled(AbstractC1174p1 abstractC1174p1) {
        super.onViewRecycled(abstractC1174p1);
        this.f3299j.f3342u.values().remove(abstractC1174p1);
    }
}
