package qa;

import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.leanback.widget.InterfaceC0484n;
import com.youth.banner.adapter.ViewOnClickListenerC2111a;
import org.bitspark.android.beans.Menu;
import org.bitspark.android.beans.SettingBean;
import org.bitspark.android.beans.Source;
import org.bitspark.android.beans.SubtitleMenu;
import p003a2.AbstractC0032a;
import p091i9.InterfaceC2724l;
import p092ia.C2737b;
import p103j9.AbstractC2796i;
import p104ja.C2807c;
import p104ja.C2808d;
import p104ja.C2809e;
import p104ja.C2810f;
import p104ja.C2811g;

public final class C3565m implements InterfaceC0484n {

    public InterfaceC2724l f12016a;

    public C3561i f12017b;

    public final int f12018c;

    public static void m7178b(View view, Object obj, InterfaceC2724l interfaceC2724l) {
        AbstractC2796i.m5785f(view, AbstractC0032a.m165s("crkkHQ==\n", "ANZLaRn7QeI=\n"));
        view.setOnClickListener(new ViewOnClickListenerC2111a(interfaceC2724l, 1, obj));
    }

    public static void m7179c(View view, final Object obj) {
        AbstractC2796i.m5785f(view, AbstractC0032a.m165s("n1wszw==\n", "7TNDu9u+ukg=\n"));
        view.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public final boolean onKey(View view2, int i6, KeyEvent keyEvent) {
                return false;
            }
        });
    }

    public static void m7180d(View view) {
        if (view == null || !view.hasTransientState()) {
            return;
        }
        view.animate().cancel();
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i6 = 0; view.hasTransientState() && i6 < childCount; i6++) {
                m7180d(viewGroup.getChildAt(i6));
            }
        }
    }

    private final void m7181f(final C2737b c2737b, Object obj) {
        final SettingBean settingBean = (SettingBean) obj;
        AbstractC2796i.m5785f(c2737b, AbstractC0032a.m165s("ICy/CEhas5QzNw==\n", "VkXafwA13/A=\n"));
        AbstractC2796i.m5785f(settingBean, AbstractC0032a.m165s("/IVOJw==\n", "mOQ6Rqd9Kno=\n"));
        C2807c c2807c = (C2807c) c2737b.f9404b;
        c2807c.f9547m = settingBean;
        synchronized (c2807c) {
            c2807c.f9549o |= 1;
        }
        c2807c.m173G();
        c2807c.m8048S();
        View view = ((C2807c) c2737b.f9404b).f13698d;
        AbstractC2796i.m5784e(view, AbstractC0032a.m165s("AFvJYg0wrjBJEJMZ\n", "Zz69MGJf2hg=\n"));
        m7178b(view, settingBean, this.f12016a);
        View view2 = ((C2807c) c2737b.f9404b).f13698d;
        AbstractC2796i.m5784e(view2, AbstractC0032a.m165s("XnpAeYMr81gXMRoC\n", "OR80K+xEh3A=\n"));
        m7179c(view2, settingBean);
        ((C2807c) c2737b.f9404b).f13698d.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public final void onFocusChange(View view3, boolean z7) {
                C3561i c3561i = this.f12019a.f12017b;
                if (c3561i != null) {
                    View view4 = ((C2807c) c2737b.f9404b).f13698d;
                    AbstractC2796i.m5784e(view4, AbstractC0032a.m165s("aVb+F/HlKe8gHaRs\n", "DjOKRZ6KXcc=\n"));
                    c3561i.m7174a(view4, Boolean.valueOf(z7), settingBean);
                }
            }
        });
    }

    private final void m7182g(C2737b c2737b, Object obj) {
        Source source = (Source) obj;
        AbstractC2796i.m5785f(c2737b, AbstractC0032a.m165s("/qSnPLG700Xtvw==\n", "iM3CS/nUvyE=\n"));
        AbstractC2796i.m5785f(source, AbstractC0032a.m165s("ptvfKw==\n", "wrqrSr1uaKc=\n"));
        C2808d c2808d = (C2808d) c2737b.f9404b;
        c2808d.f9551m = source;
        synchronized (c2808d) {
            c2808d.f9553o |= 1;
        }
        c2808d.m173G();
        c2808d.m8048S();
        ((C2808d) c2737b.f9404b).f13698d.setSelected(source.isSelected());
        View view = ((C2808d) c2737b.f9404b).f13698d;
        AbstractC2796i.m5784e(view, AbstractC0032a.m165s("c46rm9bSEAM6xfHg\n", "FOvfybm9ZCs=\n"));
        m7178b(view, source, this.f12016a);
        View view2 = ((C2808d) c2737b.f9404b).f13698d;
        AbstractC2796i.m5784e(view2, AbstractC0032a.m165s("Tu9AUpZSurkHpBop\n", "KYo0APk9zpE=\n"));
        m7179c(view2, source);
    }

    private final void m7183h(C2737b c2737b, Object obj) {
        SubtitleMenu subtitleMenu = (SubtitleMenu) obj;
        AbstractC2796i.m5785f(c2737b, AbstractC0032a.m165s("HILqYWfB6EwPmQ==\n", "auuPFi+uhCg=\n"));
        AbstractC2796i.m5785f(subtitleMenu, AbstractC0032a.m165s("4N6S6A==\n", "hL/miQmPZ2Q=\n"));
        C2809e c2809e = (C2809e) c2737b.f9404b;
        c2809e.f9555m = subtitleMenu;
        synchronized (c2809e) {
            c2809e.f9557o |= 1;
        }
        c2809e.m173G();
        c2809e.m8048S();
        ((C2809e) c2737b.f9404b).f13698d.setSelected(subtitleMenu.isSelected());
        View view = ((C2809e) c2737b.f9404b).f13698d;
        AbstractC2796i.m5784e(view, AbstractC0032a.m165s("p68g4JE16pTu5Hqb\n", "wMpUsv5anrw=\n"));
        m7178b(view, subtitleMenu, this.f12016a);
        View view2 = ((C2809e) c2737b.f9404b).f13698d;
        AbstractC2796i.m5784e(view2, AbstractC0032a.m165s("O19/ukhtcv5yFCXB\n", "XDoL6CcCBtY=\n"));
        m7179c(view2, subtitleMenu);
    }

    public final void m7184e(C2737b c2737b, Object obj) {
        switch (this.f12018c) {
            case 0:
                Menu menu = (Menu) obj;
                AbstractC2796i.m5785f(c2737b, AbstractC0032a.m165s("yf48HEKw1f3a5Q==\n", "v5dZawrfuZk=\n"));
                AbstractC2796i.m5785f(menu, AbstractC0032a.m165s("3sAD6w==\n", "uqF3iqX5iq0=\n"));
                C2810f c2810f = (C2810f) c2737b.f9404b;
                c2810f.m5802U(menu);
                boolean zIsSelected = menu.isSelected();
                View view = c2810f.f13698d;
                view.setSelected(zIsSelected);
                AbstractC2796i.m5784e(view, AbstractC0032a.m165s("El9Aa+HSqeNbFBoQ\n", "dTo0OY693cs=\n"));
                m7178b(view, menu, this.f12016a);
                AbstractC2796i.m5784e(view, AbstractC0032a.m165s("qpLznCdVCMjj2ann\n", "zfeHzkg6fOA=\n"));
                m7179c(view, menu);
                return;
            case 1:
                m7181f(c2737b, obj);
                return;
            case 2:
                m7182g(c2737b, obj);
                return;
            case 3:
                Menu menu2 = (Menu) obj;
                AbstractC2796i.m5785f(c2737b, AbstractC0032a.m165s("HB1eAy4crRUPBg==\n", "anQ7dGZzwXE=\n"));
                AbstractC2796i.m5785f(menu2, AbstractC0032a.m165s("4rYf+Q==\n", "htdrmMrD5YQ=\n"));
                C2810f c2810f2 = (C2810f) c2737b.f9404b;
                c2810f2.m5802U(menu2);
                boolean zIsSelected2 = menu2.isSelected();
                View view2 = c2810f2.f13698d;
                view2.setSelected(zIsSelected2);
                AbstractC2796i.m5784e(view2, AbstractC0032a.m165s("iKSlUBR5xEDB7/8r\n", "78HRAnsWsGg=\n"));
                m7178b(view2, menu2, this.f12016a);
                AbstractC2796i.m5784e(view2, AbstractC0032a.m165s("LWMH1QzorIZkKF2u\n", "SgZzh2OH2K4=\n"));
                m7179c(view2, menu2);
                return;
            case 4:
                m7183h(c2737b, obj);
                return;
            default:
                String str = (String) obj;
                AbstractC2796i.m5785f(c2737b, AbstractC0032a.m165s("XCf3Z9co/gtPPA==\n", "Kk6SEJ9Hkm8=\n"));
                AbstractC2796i.m5785f(str, AbstractC0032a.m165s("TOYpHA==\n", "KIddfTLXdQ8=\n"));
                C2811g c2811g = (C2811g) c2737b.f9404b;
                c2811g.f9563m = str;
                synchronized (c2811g) {
                    c2811g.f9564n |= 1;
                    break;
                }
                c2811g.m173G();
                c2811g.m8048S();
                View view3 = ((C2811g) c2737b.f9404b).f13698d;
                AbstractC2796i.m5784e(view3, AbstractC0032a.m165s("5N/Ft+R0OemtlJ/M\n", "g7qx5YsbTcE=\n"));
                m7178b(view3, str, this.f12016a);
                View view4 = ((C2811g) c2737b.f9404b).f13698d;
                AbstractC2796i.m5784e(view4, AbstractC0032a.m165s("bVPcdf5d7awkGIYO\n", "CjaoJ5EymYQ=\n"));
                m7179c(view4, str);
                return;
        }
    }

    @Override
    public final void mo1420a() {
    }
}
