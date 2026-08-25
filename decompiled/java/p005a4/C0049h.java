package p005a4;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import androidx.appcompat.widget.AbstractC0224j3;
import androidx.appcompat.widget.AbstractC0237m1;
import androidx.appcompat.widget.C0233l2;
import androidx.appcompat.widget.C0285w;
import com.p2serv.android.p032ds.R;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import p000a.AbstractC0004e;
import p055ea.AbstractC2460q;
import p056f0.AbstractC2478a;
import p220u5.C3899a;
import p222u7.AbstractC3928d;

public final class C0049h {

    public Serializable f139a;

    public Serializable f140b;

    public Object f141c;

    public Object f142d;

    public Serializable f143e;

    public Object f144f;

    public C0049h(Set set, String str, String str2) {
        C3899a c3899a = C3899a.f13099a;
        Set setEmptySet = set == null ? Collections.emptySet() : Collections.unmodifiableSet(set);
        this.f141c = setEmptySet;
        Map mapEmptyMap = Collections.emptyMap();
        this.f139a = str;
        this.f143e = str2;
        this.f144f = c3899a;
        HashSet hashSet = new HashSet(setEmptySet);
        Iterator it = mapEmptyMap.values().iterator();
        if (it.hasNext()) {
            throw AbstractC0004e.m18l(it);
        }
        this.f142d = Collections.unmodifiableSet(hashSet);
    }

    public static boolean m193b(int[] iArr, int i6) {
        for (int i10 : iArr) {
            if (i10 == i6) {
                return true;
            }
        }
        return false;
    }

    public static ColorStateList m194d(Context context, int i6) {
        int iM704c = AbstractC0224j3.m704c(context, R.attr.colorControlHighlight);
        return new ColorStateList(new int[][]{AbstractC0224j3.f955b, AbstractC0224j3.f957d, AbstractC0224j3.f956c, AbstractC0224j3.f959f}, new int[]{AbstractC0224j3.m703b(context, R.attr.colorButtonNormal), AbstractC2478a.m5511f(iM704c, i6), AbstractC2478a.m5511f(iM704c, i6), i6});
    }

    public static LayerDrawable m195e(C0233l2 c0233l2, Context context, int i6) {
        BitmapDrawable bitmapDrawable;
        BitmapDrawable bitmapDrawable2;
        BitmapDrawable bitmapDrawable3;
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(i6);
        Drawable drawableM727f = c0233l2.m727f(context, R.drawable.abc_star_black_48dp);
        Drawable drawableM727f2 = c0233l2.m727f(context, R.drawable.abc_star_half_black_48dp);
        if ((drawableM727f instanceof BitmapDrawable) && drawableM727f.getIntrinsicWidth() == dimensionPixelSize && drawableM727f.getIntrinsicHeight() == dimensionPixelSize) {
            bitmapDrawable = (BitmapDrawable) drawableM727f;
            bitmapDrawable2 = new BitmapDrawable(bitmapDrawable.getBitmap());
        } else {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            drawableM727f.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            drawableM727f.draw(canvas);
            bitmapDrawable = new BitmapDrawable(bitmapCreateBitmap);
            bitmapDrawable2 = new BitmapDrawable(bitmapCreateBitmap);
        }
        bitmapDrawable2.setTileModeX(Shader.TileMode.REPEAT);
        if ((drawableM727f2 instanceof BitmapDrawable) && drawableM727f2.getIntrinsicWidth() == dimensionPixelSize && drawableM727f2.getIntrinsicHeight() == dimensionPixelSize) {
            bitmapDrawable3 = (BitmapDrawable) drawableM727f2;
        } else {
            Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
            Canvas canvas2 = new Canvas(bitmapCreateBitmap2);
            drawableM727f2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            drawableM727f2.draw(canvas2);
            bitmapDrawable3 = new BitmapDrawable(bitmapCreateBitmap2);
        }
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{bitmapDrawable, bitmapDrawable3, bitmapDrawable2});
        layerDrawable.setId(0, android.R.id.background);
        layerDrawable.setId(1, android.R.id.secondaryProgress);
        layerDrawable.setId(2, android.R.id.progress);
        return layerDrawable;
    }

    public static void m196g(Drawable drawable, int i6, PorterDuff.Mode mode) {
        int[] iArr = AbstractC0237m1.f1008a;
        Drawable drawableMutate = drawable.mutate();
        if (mode == null) {
            mode = C0285w.f1113b;
        }
        drawableMutate.setColorFilter(C0285w.m802c(i6, mode));
    }

    public void m197a(String str, String str2) {
        HashMap map = (HashMap) this.f144f;
        if (map == null) {
            throw new IllegalStateException("Property \"autoMetadata\" has not been set");
        }
        map.put(str, str2);
    }

    public C0050i m198c() {
        String strM5494h = ((String) this.f139a) == null ? " transportName" : "";
        if (((C0055n) this.f141c) == null) {
            strM5494h = strM5494h.concat(" encodedPayload");
        }
        if (((Long) this.f142d) == null) {
            strM5494h = AbstractC2460q.m5494h(strM5494h, " eventMillis");
        }
        if (((Long) this.f143e) == null) {
            strM5494h = AbstractC2460q.m5494h(strM5494h, " uptimeMillis");
        }
        if (((HashMap) this.f144f) == null) {
            strM5494h = AbstractC2460q.m5494h(strM5494h, " autoMetadata");
        }
        if (strM5494h.isEmpty()) {
            return new C0050i((String) this.f139a, (Integer) this.f140b, (C0055n) this.f141c, ((Long) this.f142d).longValue(), ((Long) this.f143e).longValue(), (HashMap) this.f144f);
        }
        throw new IllegalStateException("Missing required properties:".concat(strM5494h));
    }

    public ColorStateList m199f(Context context, int i6) {
        if (i6 == R.drawable.abc_edit_text_material) {
            return AbstractC3928d.m7848k(context, R.color.abc_tint_edittext);
        }
        if (i6 == R.drawable.abc_switch_track_mtrl_alpha) {
            return AbstractC3928d.m7848k(context, R.color.abc_tint_switch_track);
        }
        if (i6 != R.drawable.abc_switch_thumb_material) {
            if (i6 == R.drawable.abc_btn_default_mtrl_shape) {
                return m194d(context, AbstractC0224j3.m704c(context, R.attr.colorButtonNormal));
            }
            if (i6 == R.drawable.abc_btn_borderless_material) {
                return m194d(context, 0);
            }
            if (i6 == R.drawable.abc_btn_colored_material) {
                return m194d(context, AbstractC0224j3.m704c(context, R.attr.colorAccent));
            }
            if (i6 == R.drawable.abc_spinner_mtrl_am_alpha || i6 == R.drawable.abc_spinner_textfield_background_material) {
                return AbstractC3928d.m7848k(context, R.color.abc_tint_spinner);
            }
            if (m193b((int[]) this.f140b, i6)) {
                return AbstractC0224j3.m705d(context, R.attr.colorControlNormal);
            }
            if (m193b((int[]) this.f143e, i6)) {
                return AbstractC3928d.m7848k(context, R.color.abc_tint_default);
            }
            if (m193b((int[]) this.f144f, i6)) {
                return AbstractC3928d.m7848k(context, R.color.abc_tint_btn_checkable);
            }
            if (i6 == R.drawable.abc_seekbar_thumb_material) {
                return AbstractC3928d.m7848k(context, R.color.abc_tint_seek_thumb);
            }
            return null;
        }
        int[][] iArr = new int[3][];
        int[] iArr2 = new int[3];
        ColorStateList colorStateListM705d = AbstractC0224j3.m705d(context, R.attr.colorSwitchThumbNormal);
        if (colorStateListM705d == null || !colorStateListM705d.isStateful()) {
            iArr[0] = AbstractC0224j3.f955b;
            iArr2[0] = AbstractC0224j3.m703b(context, R.attr.colorSwitchThumbNormal);
            iArr[1] = AbstractC0224j3.f958e;
            iArr2[1] = AbstractC0224j3.m704c(context, R.attr.colorControlActivated);
            iArr[2] = AbstractC0224j3.f959f;
            iArr2[2] = AbstractC0224j3.m704c(context, R.attr.colorSwitchThumbNormal);
        } else {
            int[] iArr3 = AbstractC0224j3.f955b;
            iArr[0] = iArr3;
            iArr2[0] = colorStateListM705d.getColorForState(iArr3, 0);
            iArr[1] = AbstractC0224j3.f958e;
            iArr2[1] = AbstractC0224j3.m704c(context, R.attr.colorControlActivated);
            iArr[2] = AbstractC0224j3.f959f;
            iArr2[2] = colorStateListM705d.getDefaultColor();
        }
        return new ColorStateList(iArr, iArr2);
    }
}
