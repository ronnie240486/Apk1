package p116ka;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.ViewOnClickListenerC0122a;
import androidx.appcompat.widget.ViewOnFocusChangeListenerC0263r2;
import androidx.fragment.app.FragmentActivity;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.p031db.CacheManager;
import com.lzy.okgo.request.PostRequest;
import com.p2serv.android.p032ds.R;
import com.tencent.mars.xlog.Log;
import ga.C2621d;
import ga.C2626i;
import ga.C2627j;
import ga.C2628k;
import ga.C2632o;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Objects;
import org.bitspark.android.Spark;
import org.bitspark.android.SpkApplication;
import org.bitspark.android.utils.AbstractC3329k;
import org.bitspark.android.utils.AbstractC3331m;
import org.bitspark.android.utils.AbstractC3336r;
import org.bitspark.android.utils.LimitQueue;
import p001a0.C0023f;
import p002a1.C0026b;
import p003a2.AbstractC0032a;
import p004a3.RunnableC0038c;
import p044da.C2340c;
import p055ea.AbstractC2442h;
import p055ea.AbstractC2460q;
import p055ea.C2428a;
import p055ea.C2448k;
import p055ea.DialogInterfaceOnClickListenerC2462r;
import p061f8.C2502b;
import p103j9.AbstractC2796i;
import p187r4.AbstractC3612b;
import p214ta.C3877a;
import sa.C3745p;
import sa.DialogC3734e;
import sa.ViewOnClickListenerC3737h;
import sa.ViewOnKeyListenerC3733d;
import sa.ViewOnKeyListenerC3740k;

public class ViewOnKeyListenerC2944y extends C2909b implements View.OnKeyListener, View.OnClickListener, View.OnFocusChangeListener {

    public static final String f10031u1 = AbstractC0032a.m165s("5ENUPO8pwvbB\n", "phAHWZtdq5g=\n");

    public TextView f10032A0;

    public ImageView f10033B0;

    public ImageView f10034C0;

    public RelativeLayout f10035D0;

    public ImageView f10036E0;

    public ImageView f10037F0;

    public RelativeLayout f10038G0;

    public RelativeLayout f10039H0;

    public RelativeLayout f10040I0;

    public RelativeLayout f10041J0;

    public RelativeLayout f10042K0;

    public RelativeLayout f10043L0;

    public TextView f10044M0;

    public ArrayList f10045N0;

    public HashMap f10046O0;

    public ArrayList f10047P0;

    public ArrayList f10048Q0;

    public ArrayList f10049R0;

    public ArrayList f10050S0;

    public ArrayList f10051T0;

    public View f10052U;

    public RelativeLayout f10054V;

    public ArrayList f10055V0;

    public RelativeLayout f10056W;

    public RelativeLayout f10058X;

    public TextView f10060Y;

    public ImageView f10062Z;

    public ImageView f10065b0;

    public RelativeLayout f10067c0;

    public TextView f10069d0;

    public ImageView f10071e0;

    public ImageView f10073f0;

    public C3877a f10074f1;

    public RelativeLayout f10075g0;

    public TextView f10076g1;

    public TextView f10077h0;

    public RelativeLayout f10078h1;

    public RelativeLayout f10079i0;

    public RelativeLayout f10080i1;

    public TextView f10081j0;

    public RelativeLayout f10082j1;

    public ImageView f10083k0;

    public ImageButton f10084k1;

    public ImageView f10085l0;

    public TextView f10086l1;

    public RelativeLayout f10087m0;

    public ImageView f10088m1;

    public RelativeLayout f10089n0;

    public ImageView f10090n1;

    public ImageView f10091o0;

    public ImageView f10092o1;

    public ImageView f10093p0;

    public ImageView f10094p1;

    public TextView f10095q0;

    public TextView f10097r0;

    public C3745p f10098r1;

    public ImageView f10099s0;

    public C2448k f10100s1;

    public ImageView f10101t0;

    public RelativeLayout f10103u0;

    public TextView f10104v0;

    public ImageView f10105w0;

    public ImageView f10106x0;

    public RelativeLayout f10107y0;

    public TextView f10108z0;

    public final ArrayList f10053U0 = new ArrayList();

    public int f10057W0 = 0;

    public int f10059X0 = 0;

    public int f10061Y0 = 0;

    public int f10063Z0 = 0;

    public int f10064a1 = 0;

    public boolean f10066b1 = false;

    public boolean f10068c1 = false;

    public int f10070d1 = 0;

    public long f10072e1 = 0;

    public boolean f10096q1 = false;

    public boolean f10102t1 = false;

    public final void m5966Q(String str) {
        C3745p c3745p = this.f10098r1;
        if (c3745p != null) {
            Bundle bundle = new Bundle();
            bundle.putString(C3745p.f12546s0, str);
            c3745p.m1316O(bundle);
            c3745p.f12553q0.post(new RunnableC0038c(c3745p, 28, str));
        }
    }

    @Override
    public final void onClick(View view) throws Throwable {
        int i6 = 3;
        int id = view.getId();
        int i10 = 0;
        if (id == this.f10080i1.getId()) {
            boolean zM7737g = this.f10074f1.m7737g();
            ArrayList arrayList = this.f10053U0;
            if (zM7737g) {
                this.f10074f1.f12992e.m1488h(1);
                this.f10086l1.setText((CharSequence) arrayList.get(1));
                AbstractC3331m.m6763m(1, AbstractC0032a.m165s("0Sh71oITyv/RMWDbiRbd\n", "gngknstXj6A=\n"));
                return;
            } else {
                this.f10074f1.f12992e.m1488h(0);
                this.f10086l1.setText((CharSequence) arrayList.get(0));
                AbstractC3331m.m6763m(0, AbstractC0032a.m165s("CCdT6JN7xS0IPkjlmH7S\n", "W3cMoNo/gHI=\n"));
                return;
            }
        }
        if (id == this.f10078h1.getId()) {
            if (this.f10074f1.m7738h()) {
                this.f10074f1.f12991d.m1488h(0);
                this.f10076g1.setText(m1325n(R.string.device_type_tv));
                AbstractC3331m.m6763m(0, AbstractC0032a.m165s("osiSwu2EH4W0x5nf+Jc=\n", "8ZjNhqjSVsY=\n"));
                this.f10080i1.setVisibility(0);
                return;
            }
            this.f10074f1.f12991d.m1488h(1);
            this.f10076g1.setText(m1325n(R.string.device_type_phone));
            AbstractC3331m.m6763m(1, AbstractC0032a.m165s("36DU8iTXe1rJr9/vMcQ=\n", "jPCLtmGBMhk=\n"));
            this.f10080i1.setVisibility(8);
            if (this.f10074f1.m7737g()) {
                this.f10086l1.setText(m1325n(R.string.auto_start_on));
                return;
            } else {
                this.f10086l1.setText(m1325n(R.string.auto_start_off));
                return;
            }
        }
        if (id == this.f10089n0.getId()) {
            C3877a c3877a = this.f10074f1;
            int i11 = c3877a.f12993f + 1;
            c3877a.f12993f = i11;
            ArrayList arrayList2 = c3877a.f12995h;
            String str = (String) arrayList2.get(i11 % arrayList2.size());
            AbstractC3331m.m6763m(c3877a.f12993f % arrayList2.size(), AbstractC0032a.m165s("0zZLwcQijbfUKlHN3S+av9QvW9w=\n", "gGYUkpFg2f4=\n"));
            c3877a.f12997j.m1488h(str);
            this.f10095q0.setText(str);
            return;
        }
        int id2 = this.f10035D0.getId();
        String str2 = f10031u1;
        if (id == id2) {
            int i12 = this.f10063Z0 + 1;
            this.f10063Z0 = i12;
            int size = i12 % this.f10049R0.size();
            this.f10032A0.setText((CharSequence) this.f10049R0.get(size));
            String str3 = AbstractC0032a.m165s("PyQMrq9Xp40pKlq44FO6gCIiWg==\n", "TEV6y48hzuk=\n") + size;
            boolean z7 = AbstractC3331m.f11244b;
            Log.m5049i(str2, str3);
            AbstractC3331m.m6763m(size, AbstractC0032a.m165s("dvnrmSZun/h6+vudO2OU8A==\n", "Jam0z28q2rc=\n"));
            Message message = new Message();
            message.what = 141;
            message.arg1 = size;
            Spark.f11002X1.sendMessage(message);
            return;
        }
        if (id == this.f10087m0.getId()) {
            int i13 = this.f10057W0 + 1;
            this.f10057W0 = i13;
            TextView textView = this.f10097r0;
            ArrayList arrayList3 = this.f10045N0;
            textView.setText((CharSequence) arrayList3.get(i13 % arrayList3.size()));
            String str4 = AbstractC0032a.m165s("xT6VAW+mbQTlK5EBLokqOeYAsygOvUE4lg==\n", "tl/jZE/kBGo=\n") + (this.f10057W0 % this.f10045N0.size());
            boolean z10 = AbstractC3331m.f11244b;
            Log.m5049i(str2, str4);
            AbstractC3331m.m6763m(this.f10057W0 % this.f10045N0.size(), AbstractC0032a.m165s("dVxTY1tXr1R0\n", "JgwMMxcW9hE=\n"));
            C2448k c2448k = this.f10100s1;
            if (c2448k != null) {
                c2448k.f8630b.m6696L0();
                return;
            }
            return;
        }
        if (id == this.f10103u0.getId()) {
            String strM6757g = AbstractC3331m.m6757g(AbstractC0032a.m165s("D1qWaqkOPbUdTYw=\n", "XArJJuhAeuA=\n"), AbstractC0032a.m165s("Q9c=\n", "JrlogNeoW00=\n"));
            String str5 = "";
            boolean z11 = false;
            for (String str6 : this.f10046O0.keySet()) {
                if (z11) {
                    str5 = str6;
                    break;
                }
                if (str5.isEmpty()) {
                    str5 = str6;
                }
                if (Objects.equals(strM6757g, str6)) {
                    z11 = true;
                }
            }
            this.f10104v0.setText((CharSequence) this.f10046O0.get(str5));
            Spark.m6678t0(0, String.format(m1325n(R.string.setting_app_restart), this.f10046O0.get(str5)));
            AbstractC3331m.m6764n(AbstractC0032a.m165s("CSZxAlIH5+0bMWs=\n", "WnYuThNJoLg=\n"), str5);
            C2502b c2502b = C2502b.f8734d;
            if (c2502b == null) {
                throw new IllegalStateException("Lingver should be initialized first");
            }
            Context applicationContext = SpkApplication.f11160c.getApplicationContext();
            AbstractC2796i.m5786g(applicationContext, "context");
            AbstractC2796i.m5786g(str5, "language");
            Locale locale = new Locale(str5, "", "");
            ((SharedPreferences) c2502b.f8736b.f196b).edit().putBoolean("follow_system_locale_key", false).apply();
            c2502b.m5548a(applicationContext, locale);
            return;
        }
        if (id == this.f10058X.getId()) {
            this.f10066b1 = !this.f10066b1;
            String str7 = AbstractC0032a.m165s("/bipWUj3Cnfdra1ZCdhNSt6Glm839DZNwYaMaCnnNzk=\n", "jtnfPGi1Yxk=\n") + this.f10066b1;
            boolean z12 = AbstractC3331m.f11244b;
            Log.m5049i(str2, str7);
            this.f10060Y.setText((CharSequence) this.f10051T0.get(!this.f10066b1 ? 1 : 0));
            String strM165s = AbstractC0032a.m165s("N3xdEv4jp1owY10I+T20Ww==\n", "ZCwCW6185g8=\n");
            boolean z13 = this.f10066b1;
            SharedPreferences.Editor editorEdit = SpkApplication.f11160c.getApplicationContext().getSharedPreferences(AbstractC0032a.m165s("Bf9XETe18dQ=\n", "Z4wnY1LTlKY=\n"), 0).edit();
            editorEdit.putBoolean(strM165s, z13);
            editorEdit.commit();
            return;
        }
        if (id == this.f10075g0.getId()) {
            int i14 = this.f10059X0 + 1;
            this.f10059X0 = i14;
            int size2 = i14 % this.f10047P0.size();
            this.f10059X0 = size2;
            this.f10077h0.setText((CharSequence) this.f10047P0.get(size2));
            String str8 = AbstractC0032a.m165s("UImQkutpw95wnJSSqkaE43O3q7KPYuvvd7G2sus=\n", "I+jm98srqrA=\n") + this.f10059X0;
            boolean z14 = AbstractC3331m.f11244b;
            Log.m5049i(str2, str8);
            AbstractC3331m.m6763m(this.f10059X0, AbstractC0032a.m165s("t4jw+FB7pimgmOD+TXs=\n", "4ce0px0+4mA=\n"));
            return;
        }
        if (id == this.f10067c0.getId()) {
            int i15 = this.f10064a1 + 1;
            this.f10064a1 = i15;
            int size3 = i15 % this.f10050S0.size();
            this.f10064a1 = size3;
            this.f10069d0.setText((CharSequence) this.f10050S0.get(size3));
            String str9 = AbstractC0032a.m165s("97OYiGxIFvzXppyILWdRwdSNvageXDrApA==\n", "hNLu7UwKf5I=\n") + this.f10064a1;
            boolean z15 = AbstractC3331m.f11244b;
            Log.m5049i(str2, str9);
            AbstractC3331m.m6763m(this.f10064a1, AbstractC0032a.m165s("rBMwPFWv\n", "/1ZiahD9cCA=\n"));
            return;
        }
        if (id == this.f10038G0.getId()) {
            CacheManager.getInstance().clear();
            String str10 = C2626i.f9120a;
            String strM165s2 = AbstractC0032a.m165s("EkP4gtUurhYCW/KR3i7oUV8=\n", "cS+d46cOxn8=\n");
            boolean z16 = AbstractC3331m.f11244b;
            Log.m5049i(C2626i.f9120a, strM165s2);
            C2626i.f9124e = new LimitQueue(20);
            C2626i.f9125f = new LimitQueue(50);
            C2626i.f9126g = new LimitQueue(100);
            C2340c c2340c = Spark.f11008d2;
            String str11 = C2626i.f9121b;
            c2340c.m5311g(str11);
            Spark.f11008d2.m5308d(str11, C2626i.f9124e, 315360000);
            C2340c c2340c2 = Spark.f11008d2;
            String str12 = C2626i.f9122c;
            c2340c2.m5311g(str12);
            Spark.f11008d2.m5308d(str12, C2626i.f9125f, 315360000);
            C2340c c2340c3 = Spark.f11008d2;
            String str13 = C2626i.f9123d;
            c2340c3.m5311g(str13);
            Spark.f11008d2.m5308d(str13, C2626i.f9126g, 315360000);
            Spark.f11008d2.m5306a();
            AbstractC3331m.m6763m(-1, AbstractC0032a.m165s("kdZKK5Q3/gyH2UE2gSQ=\n", "woYVb9Fht08=\n"));
            C2621d.m5627a();
            String str14 = ViewOnKeyListenerC2937r.f9993s0;
            Log.m5049i(ViewOnKeyListenerC2937r.f9993s0, AbstractC0032a.m165s("BdvU6/exIOwxzNX6y5s37RjK\n", "dr66j7veQYg=\n"));
            Message message2 = new Message();
            message2.what = 1;
            ViewOnKeyListenerC2937r.f9994t0.sendMessage(message2);
            C2632o.m5653a();
            String str15 = ViewOnKeyListenerC2932m0.f9947B0;
            Log.m5049i(ViewOnKeyListenerC2932m0.f9947B0, AbstractC0032a.m165s("OFlnm2DkfPEMTmaKXM5r8CVI\n", "SzwJ/yyLHZU=\n"));
            Message message3 = new Message();
            message3.what = 1;
            ViewOnKeyListenerC2932m0.f9950E0.sendMessage(message3);
            Spark.m6676s0(R.string.done);
            return;
        }
        if (id == this.f10040I0.getId()) {
            Spark.f11009e2 = true;
            new C2628k().m5643a(AbstractC0032a.m165s("xszmnZh43w==\n", "tamS6fEWuC0=\n"));
            return;
        }
        if (id == this.f10039H0.getId()) {
            Context contextM1321j = m1321j();
            C0023f c0023f = new C0023f(9, false);
            c0023f.f44b = contextM1321j;
            c0023f.f45c = new DialogInterfaceOnClickListenerC2462r(3);
            LayoutInflater layoutInflater = (LayoutInflater) contextM1321j.getSystemService(AbstractC0032a.m165s("luJvYvhaCNeU5Xps+Usl\n", "+oMWDY0uV74=\n"));
            DialogC3734e dialogC3734e = new DialogC3734e(contextM1321j, R.style.Dialog);
            View viewInflate = layoutInflater.inflate(R.layout.dialog_new_pwd_layout, (ViewGroup) null);
            dialogC3734e.addContentView(viewInflate, new ViewGroup.LayoutParams(-1, -2));
            c0023f.f46d = (EditText) viewInflate.findViewById(R.id.old_password);
            c0023f.f47e = (EditText) viewInflate.findViewById(R.id.new_password);
            TextView textView2 = (TextView) viewInflate.findViewById(R.id.error);
            Button button = (Button) viewInflate.findViewById(R.id.positiveButton);
            if (((DialogInterfaceOnClickListenerC2462r) c0023f.f45c) != null) {
                button.setOnClickListener(new ViewOnClickListenerC3737h(c0023f, textView2, dialogC3734e));
            }
            ((Button) viewInflate.findViewById(R.id.negativeButton)).setOnClickListener(new ViewOnClickListenerC0122a(18, dialogC3734e));
            dialogC3734e.setContentView(viewInflate);
            ((EditText) c0023f.f46d).requestFocus();
            dialogC3734e.getWindow().setSoftInputMode(4);
            dialogC3734e.show();
            return;
        }
        if (id == this.f10041J0.getId()) {
            Context contextM1321j2 = m1321j();
            ViewOnKeyListenerC3740k viewOnKeyListenerC3740k = new ViewOnKeyListenerC3740k(contextM1321j2);
            viewOnKeyListenerC3740k.f12523b = (String) contextM1321j2.getText(R.string.about_us);
            viewOnKeyListenerC3740k.f12524c = (String) contextM1321j2.getText(R.string.about_us_text);
            viewOnKeyListenerC3740k.f12528g = R.mipmap.info_l;
            String string = m1321j().getResources().getString(R.string.close);
            DialogInterfaceOnClickListenerC2462r dialogInterfaceOnClickListenerC2462r = new DialogInterfaceOnClickListenerC2462r(2);
            viewOnKeyListenerC3740k.f12526e = string;
            viewOnKeyListenerC3740k.f12530i = dialogInterfaceOnClickListenerC2462r;
            viewOnKeyListenerC3740k.m7488a().show();
            viewOnKeyListenerC3740k.f12536o.requestFocus();
            return;
        }
        if (id == this.f10107y0.getId()) {
            this.f10068c1 = !this.f10068c1;
            String str16 = AbstractC0032a.m165s("/WAjTIHa34nddSdMwPWYtN5eA2blx/G1wVQFCQ==\n", "jgFVKaGYtuc=\n") + this.f10068c1;
            boolean z17 = AbstractC3331m.f11244b;
            Log.m5049i(str2, str16);
            this.f10108z0.setText((CharSequence) this.f10055V0.get(!this.f10068c1 ? 1 : 0));
            String strM165s3 = AbstractC0032a.m165s("LMUi1GF8BQ8t2ijS\n", "f5V9gi44Wkg=\n");
            boolean z18 = this.f10068c1;
            SharedPreferences.Editor editorEdit2 = SpkApplication.f11160c.getApplicationContext().getSharedPreferences(AbstractC0032a.m165s("Bf9XETe18dQ=\n", "Z4wnY1LTlKY=\n"), 0).edit();
            editorEdit2.putBoolean(strM165s3, z18);
            editorEdit2.commit();
            Spark.m6678t0(0, String.format(m1325n(R.string.setting_app_restart), this.f10055V0.get(!this.f10068c1 ? 1 : 0)));
            return;
        }
        if (id == this.f10043L0.getId()) {
            if (m1319h() != null) {
                FragmentActivity fragmentActivityM1319h = m1319h();
                ViewOnKeyListenerC3733d viewOnKeyListenerC3733d = new ViewOnKeyListenerC3733d(fragmentActivityM1319h);
                viewOnKeyListenerC3733d.f12505b = (String) fragmentActivityM1319h.getText(R.string.setting_confirm_logout);
                DialogInterfaceOnClickListenerC2462r dialogInterfaceOnClickListenerC2462r2 = new DialogInterfaceOnClickListenerC2462r(5);
                viewOnKeyListenerC3733d.f12506c = (String) fragmentActivityM1319h.getText(R.string.No);
                viewOnKeyListenerC3733d.f12509f = dialogInterfaceOnClickListenerC2462r2;
                DialogInterfaceOnClickListenerC2943x dialogInterfaceOnClickListenerC2943x = new DialogInterfaceOnClickListenerC2943x(i10, this);
                viewOnKeyListenerC3733d.f12507d = (String) fragmentActivityM1319h.getText(R.string.Yes);
                viewOnKeyListenerC3733d.f12510g = dialogInterfaceOnClickListenerC2943x;
                viewOnKeyListenerC3733d.m7487a().show();
                return;
            }
            return;
        }
        if (id == this.f10042K0.getId()) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            int i16 = jCurrentTimeMillis - this.f10072e1 > 1000 ? 0 : this.f10070d1 + 1;
            this.f10070d1 = i16;
            this.f10072e1 = jCurrentTimeMillis;
            if (i16 >= 4) {
                this.f10070d1 = 0;
                String strM6775a = AbstractC3336r.m6775a();
                if (strM6775a == null || strM6775a.isEmpty()) {
                    return;
                }
                String strConcat = AbstractC0032a.m165s("LZfBoknIHCAtmdLnXNVQPXvW\n", "Qfa1xzq8PFg=\n").concat(strM6775a);
                boolean z19 = AbstractC3331m.f11244b;
                Log.m5049i(str2, strConcat);
                Spark.m6678t0(0, AbstractC0032a.m165s("A+Q=\n", "TI9wAy6NHEQ=\n"));
                ((PostRequest) ((PostRequest) OkGo.post(AbstractC0032a.m165s("zH5BMhX55pvIfxsgRri6l9ZvVC8Bv6bZlzMMexb5vJPIZVQm\n", "pAo1Qi/WyeM=\n")).tag(this)).headers(AbstractC0032a.m165s("DZTaCMi0W7k43A==\n", "VbmcYaTRNdg=\n"), AbstractC0032a.m165s("/6pUABWkbkw=\n", "k8UzZnzIC2E=\n") + C2428a.f8493b + AbstractC0032a.m165s("XfnHlQ==\n", "c5Wo8jJoFqI=\n"))).upFile(new File(strM6775a)).execute(new C2627j(i6));
            }
        }
    }

    @Override
    public final void onFocusChange(View view, boolean z7) {
        int id = view.getId();
        AbstractC0032a.m165s("KzxX6Be/7rUsM3/gEfC9niUhV+gXv+7W\n", "RFIRh3TKnfY=\n");
        AbstractC0032a.m165s("kuhsbg==\n", "soEIVB0e524=\n");
        if (id == this.f10080i1.getId()) {
            if (z7) {
                this.f10092o1.setVisibility(0);
                this.f10094p1.setVisibility(0);
                return;
            } else {
                this.f10092o1.setVisibility(4);
                this.f10094p1.setVisibility(4);
                return;
            }
        }
        if (id == this.f10078h1.getId()) {
            if (z7) {
                this.f10088m1.setVisibility(0);
                this.f10090n1.setVisibility(0);
                return;
            } else {
                this.f10088m1.setVisibility(4);
                this.f10090n1.setVisibility(4);
                return;
            }
        }
        if (id == this.f10035D0.getId()) {
            if (z7) {
                this.f10033B0.setVisibility(0);
                this.f10034C0.setVisibility(0);
                return;
            } else {
                this.f10033B0.setVisibility(4);
                this.f10034C0.setVisibility(4);
                return;
            }
        }
        if (id == this.f10087m0.getId()) {
            if (z7) {
                this.f10099s0.setVisibility(0);
                this.f10101t0.setVisibility(0);
                return;
            } else {
                this.f10099s0.setVisibility(4);
                this.f10101t0.setVisibility(4);
                return;
            }
        }
        if (id == this.f10103u0.getId()) {
            if (z7) {
                this.f10105w0.setVisibility(0);
                this.f10106x0.setVisibility(0);
                return;
            } else {
                this.f10105w0.setVisibility(4);
                this.f10106x0.setVisibility(4);
                return;
            }
        }
        if (id == this.f10107y0.getId()) {
            if (z7) {
                this.f10036E0.setVisibility(0);
                this.f10037F0.setVisibility(0);
                return;
            } else {
                this.f10036E0.setVisibility(4);
                this.f10037F0.setVisibility(4);
                return;
            }
        }
        if (id == this.f10058X.getId()) {
            if (z7) {
                this.f10062Z.setVisibility(0);
                this.f10065b0.setVisibility(0);
                return;
            } else {
                this.f10062Z.setVisibility(4);
                this.f10065b0.setVisibility(4);
                return;
            }
        }
        if (id == this.f10079i0.getId()) {
            if (z7) {
                this.f10083k0.setVisibility(0);
                this.f10085l0.setVisibility(0);
                return;
            } else {
                this.f10083k0.setVisibility(4);
                this.f10085l0.setVisibility(4);
                return;
            }
        }
        if (id == this.f10067c0.getId()) {
            String str = AbstractC0032a.m165s("0sdYAFLKsKTVyHAIVJ+wgs/fex193rqIyN0+VRHXopT7xn0aQp8=\n", "vakebzG/w+c=\n") + z7 + AbstractC0032a.m165s("b7gJHQ==\n", "T9FtJ5dyk4A=\n") + id;
            boolean z10 = AbstractC3331m.f11244b;
            Log.m5049i(f10031u1, str);
            if (z7) {
                this.f10071e0.setVisibility(0);
                this.f10073f0.setVisibility(0);
            } else {
                this.f10071e0.setVisibility(4);
                this.f10073f0.setVisibility(4);
            }
        }
    }

    @Override
    public final boolean onKey(View view, int i6, KeyEvent keyEvent) {
        boolean z7 = keyEvent.getRepeatCount() == 0 && keyEvent.getAction() == 0;
        AbstractC0032a.m165s("Vls/71CcZzpcTDflTcNn\n", "OTV0iimmR1E=\n");
        AbstractC0032a.m165s("GYsWR7fHdthWiRYU5g==\n", "Of54LsayE5w=\n");
        AbstractC0032a.m165s("5FITOgaOX+WrW0w=\n", "xDV2TkftK4w=\n");
        keyEvent.getAction();
        int id = view.getId();
        if (z7) {
            if (i6 == 21) {
                Spark spark = (Spark) m1319h();
                if (spark != null) {
                    spark.m6731x0(Boolean.TRUE);
                    spark.f11048G.requestFocus();
                }
                return true;
            }
            if (i6 == 4) {
                Spark.f11002X1.sendEmptyMessage(113);
                return true;
            }
        }
        if (id == this.f10054V.getId() && i6 == 19) {
            return true;
        }
        if ((id == this.f10056W.getId() && i6 == 20) || i6 == 22) {
            return true;
        }
        return super.onKey(view, i6, keyEvent);
    }

    @Override
    public final View mo1329t(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f10052U = layoutInflater.inflate(R.layout.fragment_setting, (ViewGroup) null);
        this.f10074f1 = (C3877a) new C0026b(m1319h()).m136o(C3877a.class);
        ArrayList arrayList = new ArrayList();
        this.f10051T0 = arrayList;
        arrayList.add(m1325n(R.string.auto_start_on));
        this.f10051T0.add(m1325n(R.string.auto_start_off));
        ArrayList arrayList2 = this.f10053U0;
        arrayList2.add(m1325n(R.string.auto_start_on));
        arrayList2.add(m1325n(R.string.auto_start_off));
        this.f10058X = (RelativeLayout) this.f10052U.findViewById(R.id.auto_start_bg);
        this.f10060Y = (TextView) this.f10052U.findViewById(R.id.poweron_text);
        this.f10062Z = (ImageView) this.f10052U.findViewById(R.id.poweron_left);
        this.f10065b0 = (ImageView) this.f10052U.findViewById(R.id.poweron_right);
        this.f10058X.setOnClickListener(this);
        this.f10058X.setOnKeyListener(this);
        this.f10058X.setOnFocusChangeListener(this);
        String strM165s = AbstractC0032a.m165s("GIujxcx38cUflKPfy2nixA==\n", "S9v8jJ8osJA=\n");
        String str = AbstractC2442h.f8595a;
        this.f10066b1 = AbstractC3331m.m6755e(strM165s, false).booleanValue();
        String str2 = AbstractC0032a.m165s("9zTsoiqzefr/Ndnt\n", "nket117cKo4=\n") + this.f10066b1;
        String str3 = f10031u1;
        Log.m5049i(str3, str2);
        if (this.f10066b1) {
            this.f10060Y.setText(R.string.auto_start_on);
        } else {
            this.f10060Y.setText(R.string.auto_start_off);
        }
        ArrayList arrayList3 = new ArrayList();
        this.f10050S0 = arrayList3;
        arrayList3.add(m1325n(R.string.server_main));
        this.f10050S0.add(m1325n(R.string.server_bk) + AbstractC0032a.m165s("PIU=\n", "HLSkr6yn84o=\n"));
        this.f10050S0.add(m1325n(R.string.server_bk) + AbstractC0032a.m165s("AKI=\n", "IJCzk0KLZbg=\n"));
        this.f10067c0 = (RelativeLayout) this.f10052U.findViewById(R.id.server_bg);
        this.f10069d0 = (TextView) this.f10052U.findViewById(R.id.server_text);
        this.f10071e0 = (ImageView) this.f10052U.findViewById(R.id.server_left);
        this.f10073f0 = (ImageView) this.f10052U.findViewById(R.id.server_right);
        this.f10067c0.setOnClickListener(this);
        this.f10067c0.setOnKeyListener(this);
        this.f10067c0.setOnFocusChangeListener(this);
        this.f10064a1 = AbstractC3331m.m6756f(0, AbstractC0032a.m165s("jMVH6VZq\n", "34AVvxM4JhA=\n")).intValue();
        Log.m5049i(str3, AbstractC0032a.m165s("oppuUGfZXHq1mmQc\n", "0f8cJgKrFRQ=\n") + this.f10064a1);
        this.f10069d0.setText((CharSequence) this.f10050S0.get(this.f10064a1));
        this.f10067c0.setVisibility(8);
        ArrayList arrayList4 = new ArrayList();
        this.f10047P0 = arrayList4;
        arrayList4.add(AbstractC0032a.m165s("7tPt1A==\n", "o+C47E0d0ic=\n"));
        this.f10047P0.add(AbstractC0032a.m165s("VtY=\n", "AoUUC4ZPis0=\n"));
        this.f10075g0 = (RelativeLayout) this.f10052U.findViewById(R.id.media_type_bg);
        this.f10077h0 = (TextView) this.f10052U.findViewById(R.id.media_type_text);
        this.f10075g0.setOnClickListener(this);
        this.f10075g0.setOnKeyListener(this);
        this.f10075g0.setOnFocusChangeListener(this);
        this.f10059X0 = AbstractC3331m.m6756f(0, AbstractC0032a.m165s("Ebfmcnu6Zr4Gp/Z0Zro=\n", "R/iiLTb/Ivc=\n")).intValue();
        Log.m5049i(str3, AbstractC0032a.m165s("y5Y08ieOsEvDuj7/I6Lz\n", "pvNQm0bayTs=\n") + this.f10059X0);
        this.f10077h0.setText((CharSequence) this.f10047P0.get(this.f10059X0));
        this.f10075g0.setVisibility(8);
        ArrayList arrayList5 = new ArrayList();
        this.f10048Q0 = arrayList5;
        arrayList5.add(m1325n(R.string.vod_conn_type_auto));
        this.f10048Q0.add(m1325n(R.string.vod_conn_type_tcp));
        this.f10048Q0.add(m1325n(R.string.vod_conn_type_udp));
        this.f10079i0 = (RelativeLayout) this.f10052U.findViewById(R.id.vod_conn_type_bg);
        this.f10081j0 = (TextView) this.f10052U.findViewById(R.id.vod_conn_type_text);
        this.f10083k0 = (ImageView) this.f10052U.findViewById(R.id.vod_conn_type_left);
        this.f10085l0 = (ImageView) this.f10052U.findViewById(R.id.vod_conn_type_right);
        this.f10079i0.setOnClickListener(this);
        this.f10079i0.setOnKeyListener(this);
        this.f10079i0.setOnFocusChangeListener(this);
        this.f10061Y0 = AbstractC3331m.m6756f(0, AbstractC0032a.m165s("BGiS6f7SwywNc4/m+A==\n", "UifWtr2djWI=\n")).intValue();
        Log.m5049i(str3, AbstractC0032a.m165s("F8ybO8djq9cY05oxxmmg+1s=\n", "YaP/eKgNxYM=\n") + this.f10061Y0);
        this.f10081j0.setText((CharSequence) this.f10048Q0.get(this.f10061Y0));
        this.f10079i0.setVisibility(8);
        ArrayList arrayList6 = new ArrayList();
        this.f10049R0 = arrayList6;
        arrayList6.add(m1325n(R.string.video_sorting_default));
        this.f10049R0.add(m1325n(R.string.video_sorting_update_time));
        this.f10049R0.add(m1325n(R.string.video_sorting_a_2_z));
        this.f10049R0.add(m1325n(R.string.video_sorting_z_2_a));
        this.f10035D0 = (RelativeLayout) this.f10052U.findViewById(R.id.video_sorting_bg);
        this.f10032A0 = (TextView) this.f10052U.findViewById(R.id.video_sorting_text);
        this.f10033B0 = (ImageView) this.f10052U.findViewById(R.id.video_sorting_left);
        this.f10034C0 = (ImageView) this.f10052U.findViewById(R.id.video_sorting_right);
        this.f10035D0.setOnClickListener(this);
        this.f10035D0.setOnKeyListener(this);
        this.f10035D0.setOnFocusChangeListener(this);
        int iIntValue = AbstractC3331m.m6756f(0, AbstractC0032a.m165s("HtzKxcvmGp0S39rB1usRlQ==\n", "TYyVk4KiX9I=\n")).intValue();
        this.f10063Z0 = iIntValue;
        this.f10032A0.setText((CharSequence) this.f10049R0.get(iIntValue));
        ArrayList arrayList7 = new ArrayList();
        this.f10045N0 = arrayList7;
        arrayList7.add(m1325n(R.string.player_system));
        this.f10045N0.add(m1325n(R.string.player_exo));
        C3877a c3877a = this.f10074f1;
        FragmentActivity fragmentActivityM1319h = m1319h();
        ArrayList arrayList8 = c3877a.f12995h;
        arrayList8.add(fragmentActivityM1319h.getString(R.string.Top));
        arrayList8.add(fragmentActivityM1319h.getString(R.string.Bottom));
        int iIntValue2 = AbstractC3331m.m6756f(AbstractC2442h.f8618x, AbstractC0032a.m165s("x5BDQbSQlqPAjFlNrZ2Bq8CJU1w=\n", "lMAcEuHSwuo=\n")).intValue();
        c3877a.f12993f = iIntValue2;
        c3877a.f12997j.m1488h((String) arrayList8.get(iIntValue2 % arrayList8.size()));
        this.f10087m0 = (RelativeLayout) this.f10052U.findViewById(R.id.player_bg);
        RelativeLayout relativeLayout = (RelativeLayout) this.f10052U.findViewById(R.id.rv_vod_subtitle_location);
        this.f10089n0 = relativeLayout;
        relativeLayout.setOnClickListener(this);
        this.f10089n0.setOnKeyListener(this);
        this.f10091o0 = (ImageView) this.f10052U.findViewById(R.id.vod_subtitle_location_left);
        this.f10093p0 = (ImageView) this.f10052U.findViewById(R.id.vod_subtitle_location_right);
        this.f10089n0.setOnFocusChangeListener(new ViewOnFocusChangeListenerC0263r2(7, this));
        this.f10095q0 = (TextView) this.f10052U.findViewById(R.id.tv_vod_subtitle_location);
        this.f10097r0 = (TextView) this.f10052U.findViewById(R.id.player_text);
        this.f10099s0 = (ImageView) this.f10052U.findViewById(R.id.player_left);
        this.f10101t0 = (ImageView) this.f10052U.findViewById(R.id.player_right);
        this.f10087m0.setOnClickListener(this);
        this.f10087m0.setOnKeyListener(this);
        this.f10087m0.setOnFocusChangeListener(this);
        this.f10057W0 = AbstractC3331m.m6756f(AbstractC2442h.f8617w, AbstractC0032a.m165s("igdXg9Wygb+L\n", "2VcI05nz2Po=\n")).intValue();
        this.f10074f1.f12997j.m1485e(m1319h(), new C2941v(this));
        Log.m5049i(str3, AbstractC0032a.m165s("Om1zHvbCs7EuZGpd\n", "SgESZ5Ow+t8=\n") + this.f10057W0);
        this.f10097r0.setText((CharSequence) this.f10045N0.get(this.f10057W0));
        if (!AbstractC2442h.f8588J) {
            this.f10087m0.setVisibility(8);
        }
        HashMap map = new HashMap();
        this.f10046O0 = map;
        map.put(AbstractC0032a.m165s("j48=\n", "6uHd2u1GWnw=\n"), AbstractC0032a.m165s("6kyIu+YhFg==\n", "ryLv149Sfho=\n"));
        this.f10046O0.put(AbstractC0032a.m165s("WlQ=\n", "IDylFXpe8Xk=\n"), AbstractC0032a.m165s("REDrdcaK\n", "oPhGk1ANt+Q=\n"));
        this.f10046O0.put(AbstractC0032a.m165s("jtk=\n", "/q3cZ/RI1mU=\n"), AbstractC0032a.m165s("4O6NwYtp9qMa8g==\n", "sIH/tf4Og2A=\n"));
        this.f10046O0.put(AbstractC0032a.m165s("B6o=\n", "bMWSGAlcVkg=\n"), AbstractC0032a.m165s("y5Xw5kwo9zKS\n", "JgBsDPmFG6Q=\n"));
        this.f10046O0.put(AbstractC0032a.m165s("lqw=\n", "5MPR1snXFUk=\n"), AbstractC0032a.m165s("QVkXoH6/TCk=\n", "EzZ6Y9zRiKo=\n"));
        this.f10046O0.put(AbstractC0032a.m165s("ycY=\n", "rLWBFSjo1kY=\n"), AbstractC0032a.m165s("4umNkElal0M=\n", "p5r98Yrr+C8=\n"));
        RelativeLayout relativeLayout2 = (RelativeLayout) this.f10052U.findViewById(R.id.lang_bg);
        this.f10103u0 = relativeLayout2;
        relativeLayout2.setOnClickListener(this);
        this.f10103u0.setOnKeyListener(this);
        this.f10103u0.setOnFocusChangeListener(this);
        this.f10104v0 = (TextView) this.f10052U.findViewById(R.id.lang_text);
        C2502b c2502b = C2502b.f8734d;
        if (c2502b == null) {
            throw new IllegalStateException("Lingver should be initialized first");
        }
        String language = c2502b.f8736b.m219B().getLanguage();
        AbstractC2796i.m5781b(language, "getLocale().language");
        int iHashCode = language.hashCode();
        if (iHashCode != 3365) {
            if (iHashCode != 3374) {
                if (iHashCode == 3391 && language.equals("ji")) {
                    language = "yi";
                }
            } else if (language.equals("iw")) {
                language = "he";
            }
        } else if (language.equals("in")) {
            language = TtmlNode.ATTR_ID;
        }
        if (language.length() > 2) {
            language = language.substring(0, 2);
        }
        this.f10104v0.setText((CharSequence) this.f10046O0.get(language));
        this.f10105w0 = (ImageView) this.f10052U.findViewById(R.id.lang_left);
        this.f10106x0 = (ImageView) this.f10052U.findViewById(R.id.lang_right);
        RelativeLayout relativeLayout3 = (RelativeLayout) this.f10052U.findViewById(R.id.change_lock);
        this.f10039H0 = relativeLayout3;
        relativeLayout3.setOnKeyListener(this);
        this.f10039H0.setOnClickListener(this);
        this.f10039H0.setOnFocusChangeListener(this);
        if (AbstractC2442h.f8615u == "") {
            this.f10039H0.setVisibility(8);
        }
        ArrayList arrayList9 = new ArrayList();
        this.f10055V0 = arrayList9;
        arrayList9.add(m1325n(R.string.Horizontal));
        this.f10055V0.add(m1325n(R.string.Vertical));
        this.f10107y0 = (RelativeLayout) this.f10052U.findViewById(R.id.vod_group_bg);
        this.f10108z0 = (TextView) this.f10052U.findViewById(R.id.vod_group_text);
        this.f10036E0 = (ImageView) this.f10052U.findViewById(R.id.vod_group_left);
        this.f10037F0 = (ImageView) this.f10052U.findViewById(R.id.vod_group_right);
        this.f10107y0.setOnClickListener(this);
        this.f10107y0.setOnKeyListener(this);
        this.f10107y0.setOnFocusChangeListener(this);
        if (SpkApplication.f11160c.getApplicationContext().getSharedPreferences(AbstractC0032a.m165s("9JiGh7y1sxg=\n", "luv29dnT1mo=\n"), 0).contains(AbstractC0032a.m165s("kRS81sJrVZ2QC7bQ\n", "wkTjgI0vCto=\n"))) {
            this.f10068c1 = AbstractC3331m.m6755e(AbstractC0032a.m165s("0aOJ8W/PUkLQvIP3\n", "gvPWpyCLDQU=\n"), false).booleanValue();
        } else {
            this.f10068c1 = AbstractC2442h.f8587I;
        }
        Log.m5049i(str3, AbstractC0032a.m165s("EruHQxUJ3uQVvK5AXQ==\n", "e8jPLGdgpIs=\n") + this.f10068c1);
        if (this.f10068c1) {
            this.f10108z0.setText(R.string.Horizontal);
        } else {
            this.f10108z0.setText(R.string.Vertical);
        }
        int iIntValue3 = AbstractC3331m.m6756f(0, AbstractC0032a.m165s("w47hVlfgnMDVgepLQvM=\n", "kN6+EhK21YM=\n")).intValue();
        boolean zM7737g = this.f10074f1.m7737g();
        this.f10076g1 = (TextView) this.f10052U.findViewById(R.id.tv_device_type);
        this.f10078h1 = (RelativeLayout) this.f10052U.findViewById(R.id.rl_device_type);
        RelativeLayout relativeLayout4 = (RelativeLayout) this.f10052U.findViewById(R.id.rl_hide_sidebar);
        this.f10080i1 = relativeLayout4;
        relativeLayout4.setOnClickListener(this);
        this.f10080i1.setOnFocusChangeListener(this);
        this.f10080i1.setOnKeyListener(this);
        RelativeLayout relativeLayout5 = (RelativeLayout) this.f10052U.findViewById(R.id.rl_network_speed_test);
        this.f10082j1 = relativeLayout5;
        relativeLayout5.setOnClickListener(this);
        this.f10082j1.setOnFocusChangeListener(this);
        this.f10082j1.setOnKeyListener(this);
        this.f10084k1 = (ImageButton) this.f10052U.findViewById(R.id.ib_network_speed_test_right_icon);
        this.f10082j1.setOnClickListener(new ViewOnClickListenerC0122a(15, this));
        this.f10092o1 = (ImageView) this.f10052U.findViewById(R.id.iv_hide_sidebar_left);
        this.f10094p1 = (ImageView) this.f10052U.findViewById(R.id.iv_hide_sidebar_right);
        this.f10086l1 = (TextView) this.f10052U.findViewById(R.id.tv_hide_sidebar);
        this.f10088m1 = (ImageView) this.f10052U.findViewById(R.id.iv_device_type_left);
        this.f10090n1 = (ImageView) this.f10052U.findViewById(R.id.iv_device_type_right);
        this.f10078h1.setOnClickListener(this);
        this.f10078h1.setOnFocusChangeListener(this);
        this.f10078h1.setOnKeyListener(this);
        boolean z7 = iIntValue3 == 0;
        if (zM7737g) {
            this.f10086l1.setText(m1325n(R.string.auto_start_on));
        } else {
            this.f10086l1.setText(m1325n(R.string.auto_start_off));
        }
        if (z7) {
            this.f10076g1.setText(m1325n(R.string.device_type_tv));
            this.f10080i1.setVisibility(0);
        } else {
            this.f10076g1.setText(m1325n(R.string.device_type_phone));
            this.f10080i1.setVisibility(8);
        }
        RelativeLayout relativeLayout6 = (RelativeLayout) this.f10052U.findViewById(R.id.clear_data_bg);
        this.f10038G0 = relativeLayout6;
        relativeLayout6.setOnKeyListener(this);
        this.f10038G0.setOnClickListener(this);
        this.f10038G0.setOnFocusChangeListener(this);
        this.f10040I0 = (RelativeLayout) this.f10052U.findViewById(R.id.update_bg);
        this.f10044M0 = (TextView) this.f10052U.findViewById(R.id.update_text);
        String string = m1321j().getResources().getString(R.string.current_version);
        TextView textView = this.f10044M0;
        StringBuilder sbM5498l = AbstractC2460q.m5498l(string);
        sbM5498l.append(AbstractC0032a.m165s("oQ==\n", "m8+M7gel1r4=\n"));
        sbM5498l.append(C2428a.f8498g);
        textView.setText(sbM5498l.toString());
        this.f10040I0.setOnKeyListener(this);
        this.f10040I0.setOnClickListener(this);
        this.f10040I0.setOnFocusChangeListener(this);
        RelativeLayout relativeLayout7 = (RelativeLayout) this.f10052U.findViewById(R.id.aboutus_bg);
        this.f10041J0 = relativeLayout7;
        relativeLayout7.setOnKeyListener(this);
        this.f10041J0.setOnClickListener(this);
        this.f10041J0.setOnFocusChangeListener(this);
        this.f10041J0.setVisibility(8);
        if (!AbstractC2442h.f8604j) {
            this.f10079i0.setVisibility(8);
        }
        RelativeLayout relativeLayout8 = (RelativeLayout) this.f10052U.findViewById(R.id.system_info);
        this.f10042K0 = relativeLayout8;
        relativeLayout8.setOnKeyListener(this);
        this.f10042K0.setOnClickListener(this);
        this.f10042K0.setOnFocusChangeListener(this);
        this.f10042K0.setVisibility(0);
        String str4 = Build.BRAND + AbstractC0032a.m165s("XA==\n", "c+P9iEEpD0E=\n") + Build.MODEL + AbstractC0032a.m165s("2Q==\n", "9kFPNC29lH4=\n") + Build.VERSION.RELEASE;
        String strM7270l = AbstractC3612b.m7270l(m1321j());
        if (strM7270l.length() > 6) {
            strM7270l = strM7270l.substring(0, 6);
        }
        ((TextView) this.f10052U.findViewById(R.id.system_info_txt)).setText(AbstractC2460q.m5496j("rQ==\n", "ggmAkDF6US0=\n", AbstractC2460q.m5498l(str4), strM7270l));
        RelativeLayout relativeLayout9 = (RelativeLayout) this.f10052U.findViewById(R.id.settings_logout);
        this.f10043L0 = relativeLayout9;
        relativeLayout9.setOnKeyListener(this);
        this.f10043L0.setOnClickListener(this);
        this.f10043L0.setOnFocusChangeListener(this);
        this.f10043L0.setVisibility(0);
        this.f10054V = this.f10078h1;
        this.f10056W = this.f10043L0;
        Log.m5049i(AbstractC0032a.m165s("retF44b5qsWX513n\n", "444xlOmLwZA=\n"), AbstractC0032a.m165s("B6EEni2JWVYMlwS/IYBQQwjkQON0zg==\n", "YMRwzUTuNzc=\n"));
        FragmentActivity fragmentActivityM1319h2 = m1319h();
        if (fragmentActivityM1319h2 != null) {
            String string2 = fragmentActivityM1319h2.getString(R.string.network_status_not_good);
            boolean zM6746b = AbstractC3329k.m6746b(fragmentActivityM1319h2);
            int i6 = R.mipmap.network_icon4_3x;
            if (zM6746b) {
                int iCalculateSignalLevel = WifiManager.calculateSignalLevel(((WifiManager) fragmentActivityM1319h2.getApplicationContext().getSystemService(AbstractC0032a.m165s("U+TAwQ==\n", "JI2mqEjmTpk=\n"))).getConnectionInfo().getRssi(), 5);
                Log.m5049i(AbstractC0032a.m165s("+VTv34+YMwPDWPfb\n", "tzGbqODqWFY=\n"), AbstractC0032a.m165s("Rs6duWZvLhJN+J2YamYnB0mLhY95bSxJAQ==\n", "Iavp6g8IQHM=\n") + iCalculateSignalLevel);
                if (iCalculateSignalLevel == 1) {
                    i6 = R.mipmap.network_icon1_3x;
                } else if (iCalculateSignalLevel == 2) {
                    i6 = R.mipmap.network_icon2_3x;
                } else if (iCalculateSignalLevel == 3) {
                    i6 = R.mipmap.network_icon3_3x;
                } else if (iCalculateSignalLevel != 4) {
                    this.f10096q1 = true;
                    m5966Q(string2);
                    i6 = R.mipmap.network_icon_no_3x;
                }
            }
            this.f10084k1.setImageResource(i6);
            if (AbstractC3329k.m6745a(fragmentActivityM1319h2)) {
                AbstractC3329k.m6749e(new C2941v(this));
            } else {
                this.f10084k1.setImageResource(R.mipmap.network_icon_no_3x);
                this.f10096q1 = true;
                m5966Q(string2);
            }
        }
        return this.f10052U;
    }
}
