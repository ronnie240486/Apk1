package qa;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.leanback.widget.C0457d0;
import androidx.leanback.widget.C0482m;
import androidx.leanback.widget.VerticalGridView;
import com.bumptech.glide.AbstractC1466d;
import com.p2serv.android.p032ds.R;
import java.util.ArrayList;
import org.bitspark.android.beans.Menu;
import org.bitspark.android.beans.SubtitleMenu;
import p002a1.C0026b;
import p003a2.AbstractC0032a;
import p103j9.AbstractC2796i;
import p104ja.AbstractC2812h;
import p104ja.AbstractC2814j;
import p104ja.AbstractC2816l;
import p104ja.AbstractC2818n;
import p104ja.AbstractC2820p;
import p237w0.AbstractC4042c;
import p237w0.AbstractC4044e;
import p253x8.C4144g;
import qa.C3553a;

public final class C3564l {

    public final C0026b f11983A;

    public final C0457d0 f11984B;

    public final ArrayList f11985C;

    public final ArrayList f11986D;

    public final ArrayList f11987E;

    public EnumC3562j f11988F;

    public int f11989G;

    public final Activity f11990a;

    public final int f11991b;

    public final int f11992c;

    public Dialog f11993d;

    public C3553a f11994e;

    public final AbstractC4044e f11995f;

    public C3556d f11996g;

    public C3555c f11997h;

    public C3555c f11998i;

    public C3556d f11999j;

    public C3556d f12000k;

    public AbstractC2816l f12001l;

    public AbstractC2818n f12002m;

    public AbstractC2820p f12003n;

    public AbstractC2814j f12004o;

    public final C3565m f12005p;

    public final C0026b f12006q;

    public final C0457d0 f12007r;

    public final C3565m f12008s;

    public final C0026b f12009t;

    public final C0457d0 f12010u;

    public final C3565m f12011v;

    public final C0026b f12012w;

    public final C0457d0 f12013x;

    public final C3565m f12014y;

    public final C3565m f12015z;

    public C3564l(Activity activity) {
        AbstractC2796i.m5785f(activity, AbstractC0032a.m165s("1Aqqj/5tJg==\n", "t2XE+5sVUqc=\n"));
        AbstractC0032a.m165s("2tj3PUcBLA==\n", "ubeZSSJ5WMc=\n");
        AbstractC2796i.m5785f(activity, AbstractC0032a.m165s("5YtClFr0GA==\n", "huQs4D+MbB8=\n"));
        this.f11990a = activity;
        this.f11991b = -2;
        this.f11992c = -1;
        AbstractC4044e abstractC4044eM8044a = AbstractC4042c.m8044a(LayoutInflater.from(activity), R.layout.layout_live_setting_container, null);
        AbstractC2796i.m5784e(abstractC4044eM8044a, AbstractC0032a.m165s("+PuAb1IqC7a/u8gq\n", "kZXmAzNebp4=\n"));
        this.f11995f = abstractC4044eM8044a;
        String strM165s = AbstractC0032a.m165s("3YWQ4oRQqDaUzsqZ\n", "uuDksOs/3B4=\n");
        View view = abstractC4044eM8044a.f13698d;
        AbstractC2796i.m5784e(view, strM165s);
        AbstractC0032a.m165s("pfueLw==\n", "05L7WBkJ+WY=\n");
        final Dialog dialog = new Dialog(this.f11990a);
        dialog.setContentView(view);
        Window window = dialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setLayout(this.f11991b, this.f11992c);
            window.setGravity(8388613);
            window.setFlags(32, 32);
            window.clearFlags(8);
        }
        dialog.setOnKeyListener(new DialogInterface.OnKeyListener() {
            @Override
            public final boolean onKey(DialogInterface dialogInterface, int i6, KeyEvent keyEvent) {
                if (i6 != 4 || keyEvent.getAction() != 1) {
                    return false;
                }
                C3553a c3553a = this.f9405a.f11994e;
                if (!(c3553a != null ? ((Boolean) c3553a.invoke()).booleanValue() : false)) {
                    dialog.dismiss();
                }
                return true;
            }
        });
        AbstractC0032a.m165s("ISCBRkEtVA==\n", "HVPkMmwSapA=\n");
        this.f11993d = dialog;
        C3565m c3565m = new C3565m(2);
        this.f12005p = c3565m;
        C0026b c0026b = new C0026b(c3565m);
        this.f12006q = c0026b;
        this.f12007r = new C0457d0(c0026b);
        C3565m c3565m2 = new C3565m(1);
        this.f12008s = c3565m2;
        C0026b c0026b2 = new C0026b(c3565m2);
        this.f12009t = c0026b2;
        this.f12010u = new C0457d0(c0026b2);
        C3565m c3565m3 = new C3565m(0);
        this.f12011v = c3565m3;
        C0026b c0026b3 = new C0026b(c3565m3);
        this.f12012w = c0026b3;
        this.f12013x = new C0457d0(c0026b3);
        C3565m c3565m4 = new C3565m(5);
        C3565m c3565m5 = new C3565m(4);
        this.f12014y = c3565m5;
        C3565m c3565m6 = new C3565m(3);
        this.f12015z = c3565m6;
        C0482m c0482m = new C0482m();
        c0482m.m1445b(String.class, c3565m4);
        c0482m.m1445b(SubtitleMenu.class, c3565m5);
        c0482m.m1445b(Menu.class, c3565m6);
        C0026b c0026b4 = new C0026b(c0482m);
        this.f11983A = c0026b4;
        this.f11984B = new C0457d0(c0026b4);
        this.f11985C = new ArrayList();
        String string = activity.getString(R.string.original);
        AbstractC2796i.m5784e(string, AbstractC0032a.m165s("po7BhKlNHUemw5v58xY=\n", "weu1190/dCk=\n"));
        Menu menu = new Menu(string, true);
        String string2 = activity.getString(R.string.full_screen);
        AbstractC2796i.m5784e(string2, AbstractC0032a.m165s("vMS4H49h4OG8ieJi1To=\n", "26HMTPsTiY8=\n"));
        this.f11986D = new ArrayList(new C4144g(new Menu[]{menu, new Menu(string2, false)}, true));
        String string3 = activity.getString(R.string.Top);
        AbstractC2796i.m5784e(string3, AbstractC0032a.m165s("U3eT3VIcmkhTOsmgCEc=\n", "NBLnjiZu8yY=\n"));
        Menu menu2 = new Menu(string3, false);
        String string4 = activity.getString(R.string.Bottom);
        AbstractC2796i.m5784e(string4, AbstractC0032a.m165s("Oh11mpf32Fs6UC/nzaw=\n", "XXgByeOFsTU=\n"));
        this.f11987E = new ArrayList(new C4144g(new Menu[]{menu2, new Menu(string4, false)}, true));
        this.f11988F = EnumC3562j.f11977a;
        this.f11994e = new C3553a(1, this);
    }

    public final Dialog m7175a() {
        Dialog dialog = this.f11993d;
        if (dialog != null) {
            return dialog;
        }
        AbstractC2796i.m5791l(AbstractC0032a.m165s("5Pc4x8p9\n", "gJ5Zq6UaRhE=\n"));
        throw null;
    }

    public final void m7176b() {
        VerticalGridView verticalGridView;
        VerticalGridView verticalGridView2;
        TextView textView;
        if (this.f12001l == null) {
            Activity activity = this.f11990a;
            LayoutInflater layoutInflaterFrom = LayoutInflater.from(activity);
            FrameLayout frameLayout = ((AbstractC2812h) this.f11995f).f9565l;
            int i6 = AbstractC2816l.f9574o;
            this.f12001l = (AbstractC2816l) AbstractC4042c.m8044a(layoutInflaterFrom, R.layout.view_live_setting_main, frameLayout);
            Typeface typefaceCreateFromAsset = Typeface.createFromAsset(activity.getAssets(), AbstractC0032a.m165s("wT7lOjK1c6vJOPlgaYBm\n", "p1GLTh30Bc4=\n"));
            AbstractC2816l abstractC2816l = this.f12001l;
            if (abstractC2816l != null && (textView = abstractC2816l.f9576m) != null) {
                textView.setTypeface(typefaceCreateFromAsset);
            }
            AbstractC2816l abstractC2816l2 = this.f12001l;
            if (abstractC2816l2 != null && (verticalGridView2 = abstractC2816l2.f9577n) != null) {
                verticalGridView2.setAdapter(this.f12010u);
            }
            C3560h c3560h = new C3560h(this, 2);
            C3565m c3565m = this.f12008s;
            c3565m.f12016a = c3560h;
            c3565m.f12017b = new C3561i(this);
        }
        AbstractC2816l abstractC2816l3 = this.f12001l;
        AbstractC2796i.m5782c(abstractC2816l3);
        String strM165s = AbstractC0032a.m165s("ezdyTMciyjAyfCg3\n", "HFIGHqhNvhg=\n");
        View view = abstractC2816l3.f13698d;
        AbstractC2796i.m5784e(view, strM165s);
        m7177c(view, EnumC3562j.f11977a);
        AbstractC2816l abstractC2816l4 = this.f12001l;
        if (abstractC2816l4 == null || (verticalGridView = abstractC2816l4.f9577n) == null) {
            return;
        }
        AbstractC1466d.m3483D(verticalGridView, this.f11989G);
    }

    public final void m7177c(View view, EnumC3562j enumC3562j) {
        AbstractC4044e abstractC4044e = this.f11995f;
        ((AbstractC2812h) abstractC4044e).f9565l.removeAllViews();
        ((AbstractC2812h) abstractC4044e).f9565l.addView(view);
        this.f11988F = enumC3562j;
    }
}
