package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.Log;
import com.p2serv.android.p032ds.R;
import p005a4.C0049h;

public final class C0285w {

    public static final PorterDuff.Mode f1113b = PorterDuff.Mode.SRC_IN;

    public static C0285w f1114c;

    public C0233l2 f1115a;

    public static synchronized C0285w m801a() {
        try {
            if (f1114c == null) {
                m803d();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f1114c;
    }

    public static synchronized PorterDuffColorFilter m802c(int i6, PorterDuff.Mode mode) {
        return C0233l2.m721h(i6, mode);
    }

    public static synchronized void m803d() {
        if (f1114c == null) {
            C0285w c0285w = new C0285w();
            f1114c = c0285w;
            c0285w.f1115a = C0233l2.m720d();
            C0233l2 c0233l2 = f1114c.f1115a;
            C0049h c0049h = new C0049h();
            c0049h.f139a = new int[]{R.drawable.abc_textfield_search_default_mtrl_alpha, R.drawable.abc_textfield_default_mtrl_alpha, R.drawable.abc_ab_share_pack_mtrl_alpha};
            c0049h.f140b = new int[]{R.drawable.abc_ic_commit_search_api_mtrl_alpha, R.drawable.abc_seekbar_tick_mark_material, R.drawable.abc_ic_menu_share_mtrl_alpha, R.drawable.abc_ic_menu_copy_mtrl_am_alpha, R.drawable.abc_ic_menu_cut_mtrl_alpha, R.drawable.abc_ic_menu_selectall_mtrl_alpha, R.drawable.abc_ic_menu_paste_mtrl_am_alpha};
            c0049h.f141c = new int[]{R.drawable.abc_textfield_activated_mtrl_alpha, R.drawable.abc_textfield_search_activated_mtrl_alpha, R.drawable.abc_cab_background_top_mtrl_alpha, R.drawable.abc_text_cursor_material, R.drawable.abc_text_select_handle_left_mtrl, R.drawable.abc_text_select_handle_middle_mtrl, R.drawable.abc_text_select_handle_right_mtrl};
            c0049h.f142d = new int[]{R.drawable.abc_popup_background_mtrl_mult, R.drawable.abc_cab_background_internal_bg, R.drawable.abc_menu_hardkey_panel_mtrl_mult};
            c0049h.f143e = new int[]{R.drawable.abc_tab_indicator_material, R.drawable.abc_textfield_search_material};
            c0049h.f144f = new int[]{R.drawable.abc_btn_check_material, R.drawable.abc_btn_radio_material, R.drawable.abc_btn_check_material_anim, R.drawable.abc_btn_radio_material_anim};
            c0233l2.m732m(c0049h);
        }
    }

    public static void m804e(Drawable drawable, C0234l3 c0234l3, int[] iArr) {
        PorterDuff.Mode mode = C0233l2.f989h;
        int[] state = drawable.getState();
        int[] iArr2 = AbstractC0237m1.f1008a;
        if (drawable.mutate() != drawable) {
            Log.d("ResourceManagerInternal", "Mutated drawable is not the same instance as the input.");
            return;
        }
        if ((drawable instanceof LayerDrawable) && drawable.isStateful()) {
            drawable.setState(new int[0]);
            drawable.setState(state);
        }
        boolean z7 = c0234l3.f1002d;
        if (z7 || c0234l3.f1001c) {
            PorterDuffColorFilter porterDuffColorFilterM721h = null;
            ColorStateList colorStateList = z7 ? c0234l3.f999a : null;
            PorterDuff.Mode mode2 = c0234l3.f1001c ? c0234l3.f1000b : C0233l2.f989h;
            if (colorStateList != null && mode2 != null) {
                porterDuffColorFilterM721h = C0233l2.m721h(colorStateList.getColorForState(iArr, 0), mode2);
            }
            drawable.setColorFilter(porterDuffColorFilterM721h);
        } else {
            drawable.clearColorFilter();
        }
        if (Build.VERSION.SDK_INT <= 23) {
            drawable.invalidateSelf();
        }
    }

    public final synchronized Drawable m805b(Context context, int i6) {
        return this.f1115a.m727f(context, i6);
    }
}
