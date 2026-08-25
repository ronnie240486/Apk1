package la;

import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.ViewOnClickListenerC0122a;
import androidx.appcompat.widget.ViewOnLayoutChangeListenerC0268s2;
import androidx.appcompat.widget.ViewOnTouchListenerC0187c2;
import androidx.fragment.app.FragmentActivity;
import com.p2serv.android.p032ds.R;
import com.tencent.mars.xlog.Log;
import org.bitspark.android.R$drawable;
import org.bitspark.android.Spark;
import org.bitspark.android.utils.AbstractC3329k;
import org.bitspark.android.utils.AbstractC3331m;
import p003a2.AbstractC0032a;
import p004a3.RunnableC0038c;
import p051e6.C2416a;
import p055ea.AbstractC2440g;
import p055ea.AbstractC2442h;
import p116ka.C2909b;
import p156o9.AbstractC3280d;
import sa.C3745p;

public class ViewOnClickListenerC3017d extends C2909b implements View.OnClickListener, View.OnKeyListener {

    public static final String f10310m0 = AbstractC0032a.m165s("l1GSmIY=\n", "2z718eggJmA=\n");

    public ImageView f10311U;

    public Button f10312V;

    public Button f10313W;

    public RelativeLayout f10314X;

    public EditText f10315Y;

    public EditText f10316Z;

    public Button f10317b0;

    public String f10318c0;

    public String f10319d0;

    public TextView f10320e0;

    public CheckBox f10321f0;

    public ImageButton f10323h0;

    public C3745p f10326k0;

    public boolean f10322g0 = false;

    public final ViewOnLayoutChangeListenerC0268s2 f10324i0 = new ViewOnLayoutChangeListenerC0268s2(2, this);

    public View f10325j0 = null;

    public boolean f10327l0 = false;

    @Override
    public final void mo1270B() {
        String strM165s = AbstractC0032a.m165s("F/TUqR0BwQ==\n", "eJqH3XxztRw=\n");
        boolean z7 = AbstractC3331m.f11244b;
        Log.m5049i(f10310m0, strM165s);
        super.mo1270B();
    }

    public final void m6090Q() {
        String strM1325n;
        int iIntValue = AbstractC3331m.m6756f(-65535, AbstractC2440g.f8552a).intValue();
        if (iIntValue == -2) {
            strM1325n = m1325n(R.string.no_input_data_err);
        } else if (iIntValue != -1) {
            switch (iIntValue) {
                case -12:
                    strM1325n = m1325n(R.string.disabled_or_expired_err);
                    break;
                case -11:
                    strM1325n = m1325n(R.string.no_such_accout_err);
                    break;
                case -10:
                    strM1325n = m1325n(R.string.password_err);
                    break;
                default:
                    strM1325n = "";
                    break;
            }
        } else {
            strM1325n = m1325n(R.string.server_err);
        }
        if (strM1325n.equals("")) {
            return;
        }
        this.f10320e0.setText(strM1325n);
        this.f10320e0.setVisibility(0);
    }

    public final void m6091R() {
        String strM165s = AbstractC0032a.m165s("34n54Z2JT3XlheHl\n", "keyNlvL7JCA=\n");
        String strM165s2 = AbstractC0032a.m165s("slPir6cyp1W5ZeKOqzuuQL0WptL+dQ==\n", "1TaW/M5VyTQ=\n");
        boolean z7 = AbstractC3331m.f11244b;
        Log.m5049i(strM165s, strM165s2);
        FragmentActivity fragmentActivityM1319h = m1319h();
        if (fragmentActivityM1319h == null) {
            return;
        }
        String string = fragmentActivityM1319h.getString(R.string.network_status_not_good);
        boolean zM6746b = AbstractC3329k.m6746b(fragmentActivityM1319h);
        int i6 = R.mipmap.network_icon4_3x;
        if (zM6746b) {
            int iCalculateSignalLevel = WifiManager.calculateSignalLevel(((WifiManager) fragmentActivityM1319h.getApplicationContext().getSystemService(AbstractC0032a.m165s("pQDVWA==\n", "0mmzMXCE32s=\n"))).getConnectionInfo().getRssi(), 5);
            Log.m5049i(AbstractC0032a.m165s("qsxhR6fruLuQwHlD\n", "5KkVMMiZ0+4=\n"), AbstractC0032a.m165s("yEdDIlKPgRjDcUMDXoaIDccCWxRNjYNDjw==\n", "ryI3cTvo73k=\n") + iCalculateSignalLevel);
            if (iCalculateSignalLevel == 1) {
                i6 = R.mipmap.network_icon1_3x;
            } else if (iCalculateSignalLevel == 2) {
                i6 = R.mipmap.network_icon2_3x;
            } else if (iCalculateSignalLevel == 3) {
                i6 = R.mipmap.network_icon3_3x;
            } else if (iCalculateSignalLevel != 4) {
                this.f10327l0 = true;
                m6093T(string);
                i6 = R.mipmap.network_icon_no_3x;
            }
        }
        this.f10323h0.setImageResource(i6);
        if (AbstractC3329k.m6745a(fragmentActivityM1319h)) {
            AbstractC3329k.m6749e(new C3014a(this));
            return;
        }
        this.f10323h0.setImageResource(R.mipmap.network_icon_no_3x);
        this.f10327l0 = true;
        m6093T(string);
    }

    public final void m6092S() {
        this.f10311U.setVisibility(8);
        this.f10312V.setVisibility(8);
        this.f10313W.setVisibility(8);
        this.f10314X.setVisibility(0);
        String strM165s = AbstractC0032a.m165s("CPdtkfPIeaY48CiF8sphsF21\n", "fYQI452pFMM=\n");
        boolean z7 = AbstractC3331m.f11244b;
        Log.m5049i(f10310m0, strM165s);
        this.f10315Y.requestFocusFromTouch();
        this.f10315Y.requestFocus();
    }

    public final void m6093T(String str) {
        C3745p c3745p = this.f10326k0;
        if (c3745p != null) {
            Bundle bundle = new Bundle();
            bundle.putString(C3745p.f12546s0, str);
            c3745p.m1316O(bundle);
            c3745p.f12553q0.post(new RunnableC0038c(c3745p, 28, str));
        }
    }

    @Override
    public final void onClick(View view) {
        int id = view.getId();
        if (id == this.f10312V.getId()) {
            Spark.f11002X1.sendEmptyMessage(9);
            return;
        }
        if (id != this.f10317b0.getId()) {
            if (id == this.f10313W.getId()) {
                this.f10314X.setVisibility(0);
                m6092S();
                return;
            }
            return;
        }
        this.f10320e0.setVisibility(4);
        this.f10318c0 = this.f10315Y.getText().toString().trim();
        this.f10319d0 = this.f10316Z.getText().toString().trim();
        if (TextUtils.isEmpty(this.f10318c0)) {
            this.f10315Y.requestFocus();
            this.f10315Y.requestFocusFromTouch();
            Spark.m6676s0(R.string.username_cannot_blank);
            return;
        }
        if (this.f10318c0.length() < 4) {
            this.f10315Y.requestFocus();
            this.f10315Y.requestFocusFromTouch();
            Spark.m6678t0(0, String.format(m1325n(R.string.username_too_short), 4));
            return;
        }
        if (TextUtils.isEmpty(this.f10319d0)) {
            this.f10316Z.requestFocus();
            this.f10316Z.requestFocusFromTouch();
            Spark.m6676s0(R.string.password_cannot_blank);
            return;
        }
        if (this.f10319d0.length() < 4) {
            this.f10316Z.requestFocus();
            this.f10316Z.requestFocusFromTouch();
            Spark.m6678t0(0, String.format(m1325n(R.string.password_too_short), 4));
            return;
        }
        if (!this.f10318c0.matches("[0-9A-Fa-f]{12}") && !this.f10318c0.contains(AbstractC0032a.m165s("SA==\n", "CLdnvmMq65Q=\n"))) {
            this.f10318c0 += AbstractC2442h.f8597c;
        }
        String str = AbstractC0032a.m165s("k8bcLOcSr9zg3tI5+lz3k7XB2Cz9U7bW+pI=\n", "wLK9XpMy27M=\n") + this.f10318c0 + AbstractC0032a.m165s("tFJsD3HzYgXwGC0=\n", "lCINfAKEDXc=\n") + this.f10319d0;
        boolean z7 = AbstractC3331m.f11244b;
        Log.m5049i(f10310m0, str);
        AbstractC3331m.m6763m(1, AbstractC2440g.f8553b);
        AbstractC3331m.m6764n(AbstractC2440g.f8556e, this.f10318c0);
        AbstractC3331m.m6764n(AbstractC2440g.f8557f, this.f10319d0);
        Spark.f11002X1.sendEmptyMessage(13);
    }

    @Override
    public final boolean onKey(View view, int i6, KeyEvent keyEvent) {
        String str = AbstractC0032a.m165s("w2ozl7XBhd/JfTudqJ6f\n", "rAR48sz7pbQ=\n") + i6 + AbstractC0032a.m165s("t88Dx325Ak75lkeFPq4=\n", "muIu6lCULw8=\n") + keyEvent.getAction();
        boolean z7 = AbstractC3331m.f11244b;
        Log.m5049i(f10310m0, str);
        int id = view.getId();
        boolean z10 = keyEvent.getRepeatCount() == 0 && keyEvent.getAction() == 0;
        if (id == this.f10323h0.getId() && (i6 == 21 || i6 == 22 || i6 == 19)) {
            return true;
        }
        if (id == this.f10317b0.getId() && (i6 == 21 || i6 == 22 || i6 == 20)) {
            return true;
        }
        if (z10) {
            if (i6 == 4 && this.f10314X.getVisibility() == 0 && !this.f10322g0) {
                AbstractC3331m.m6761k();
                return true;
            }
            if (id == this.f10312V.getId() && i6 == 19) {
                this.f10312V.requestFocus();
                this.f10312V.setSelected(true);
                return true;
            }
            if (i6 == 21) {
                if (id == this.f10315Y.getId() && this.f10315Y.getText().length() > 0 && this.f10315Y.getSelectionStart() > 0) {
                    return false;
                }
                if (id == this.f10316Z.getId() && this.f10316Z.getText().length() > 0 && this.f10316Z.getSelectionStart() > 0) {
                    return false;
                }
                if (id == this.f10321f0.getId()) {
                    this.f10316Z.requestFocus();
                    EditText editText = this.f10316Z;
                    editText.setSelection(editText.getText().length());
                    return true;
                }
                Spark spark = (Spark) m1319h();
                RadioButton radioButton = spark.f11042E;
                if (radioButton != null && radioButton.isShown()) {
                    AbstractC3280d.m6606y(spark.f11042E);
                    spark.f11042E.setChecked(true);
                }
                return true;
            }
            if (i6 == 22 && id == this.f10321f0.getId()) {
                return true;
            }
        }
        return super.onKey(view, i6, keyEvent);
    }

    @Override
    public final View mo1329t(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.userviewpager_login, (ViewGroup) null);
        this.f10311U = (ImageView) viewInflate.findViewById(R.id.userlogin_icon);
        this.f10312V = (Button) viewInflate.findViewById(R.id.deviceId_login_btn);
        this.f10313W = (Button) viewInflate.findViewById(R.id.username_login_btn);
        ImageButton imageButton = (ImageButton) viewInflate.findViewById(R.id.signalIcon);
        this.f10323h0 = imageButton;
        imageButton.setOnKeyListener(this);
        this.f10323h0.setOnClickListener(new ViewOnClickListenerC0122a(16, this));
        this.f10314X = (RelativeLayout) viewInflate.findViewById(R.id.username_login_layout);
        EditText editText = (EditText) viewInflate.findViewById(R.id.et_username);
        this.f10315Y = editText;
        editText.setFocusableInTouchMode(true);
        this.f10316Z = (EditText) viewInflate.findViewById(R.id.old_password);
        this.f10317b0 = (Button) viewInflate.findViewById(R.id.username_login_submit_btn);
        this.f10320e0 = (TextView) viewInflate.findViewById(R.id.login_error);
        this.f10321f0 = (CheckBox) viewInflate.findViewById(R.id.eyeIcon);
        this.f10320e0.setVisibility(4);
        this.f10312V.setOnClickListener(this);
        this.f10313W.setOnClickListener(this);
        this.f10317b0.setOnClickListener(this);
        this.f10312V.setOnKeyListener(this);
        this.f10313W.setOnKeyListener(this);
        this.f10321f0.setOnKeyListener(this);
        this.f10317b0.setOnKeyListener(this);
        this.f10321f0.setOnCheckedChangeListener(new C2416a(1, this));
        this.f10321f0.setButtonDrawable(R$drawable.shape_eye_checkbox_select_border);
        this.f10315Y.setOnKeyListener(new ViewOnKeyListenerC3016c(this, 0));
        this.f10316Z.setOnKeyListener(new ViewOnKeyListenerC3016c(this, 1));
        this.f10313W.setOnTouchListener(new ViewOnTouchListenerC0187c2(1, this));
        String strReplace = AbstractC3331m.m6757g(AbstractC2440g.f8556e, "").replace(AbstractC2442h.f8597c, "");
        if (AbstractC3331m.m6756f(0, AbstractC2440g.f8553b).intValue() == 2 && strReplace.length() > 6) {
            strReplace = strReplace.substring(0, 6);
        }
        if (TextUtils.isEmpty(strReplace)) {
            strReplace = org.bitspark.android.MacId.get12(m1319h());
        }
        this.f10315Y.setText(strReplace);
        EditText editText2 = this.f10315Y;
        editText2.setSelection(editText2.getText().length());
        String savedPassword = AbstractC3331m.m6757g(AbstractC2440g.f8557f, "");
        if (TextUtils.isEmpty(savedPassword)) {
            savedPassword = strReplace;
        }
        this.f10316Z.setText(savedPassword);
        EditText editText3 = this.f10316Z;
        editText3.setSelection(editText3.getText().length());
        if (TextUtils.isEmpty(strReplace)) {
            m6092S();
        } else {
            this.f10311U.setVisibility(8);
            this.f10312V.setVisibility(8);
            this.f10313W.setVisibility(8);
            this.f10314X.setVisibility(0);
            this.f10317b0.requestFocus();
        }
        m6091R();
        View rootView = viewInflate.getRootView();
        this.f10325j0 = rootView;
        rootView.addOnLayoutChangeListener(this.f10324i0);
        return viewInflate;
    }

    @Override
    public final void mo1330u() {
        super.mo1330u();
        View view = this.f10325j0;
        if (view != null) {
            view.removeOnLayoutChangeListener(this.f10324i0);
        }
    }

    @Override
    public final void mo1332z() {
        String strM165s = AbstractC0032a.m165s("m8BC6z51ASE=\n", "9K4Qjk0AbEQ=\n");
        boolean z7 = AbstractC3331m.f11244b;
        Log.m5049i(f10310m0, strM165s);
        super.mo1332z();
    }
}
