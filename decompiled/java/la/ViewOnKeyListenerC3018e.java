package la;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import com.p2serv.android.p032ds.R;
import com.tencent.mars.xlog.Log;
import ga.C2630m;
import java.text.SimpleDateFormat;
import java.util.Locale;
import org.bitspark.android.Spark;
import org.bitspark.android.beans.AuthInfo;
import org.bitspark.android.utils.AbstractC3331m;
import p003a2.AbstractC0032a;
import p055ea.AbstractC2440g;
import p055ea.AbstractC2442h;
import p116ka.C2909b;
import p156o9.AbstractC3280d;
import p222u7.AbstractC3928d;

public class ViewOnKeyListenerC3018e extends C2909b implements View.OnKeyListener, View.OnClickListener {

    public Button f10328U;

    public TextView f10329V;

    public TextView f10330W;

    public TextView f10331X;

    public TextView f10332Y;

    public TextView f10333Z;

    public TextView f10334b0;

    public TextView f10335c0;

    public TextView f10336d0;

    public boolean f10337e0 = false;

    public View f10338f0;

    @Override
    public final void mo1270B() {
        AuthInfo.ServiceBean serviceBean;
        super.mo1270B();
        this.f10337e0 = true;
        String strM165s = AbstractC0032a.m165s("UTITykbbjANJ\n", "PV10oyiJ/28=\n");
        String strM165s2 = AbstractC0032a.m165s("c05dUFbL+0w=\n", "HCAPNSW+lik=\n");
        boolean z7 = AbstractC3331m.f11244b;
        Log.m5049i(strM165s, strM165s2);
        Log.m5049i(AbstractC0032a.m165s("ql1dABswz3WS\n", "5jI6aXVivBk=\n"), AbstractC0032a.m165s("ygVq2xRz12fwA2PDby6c\n", "uW0FrEEAshU=\n"));
        if (!this.f10337e0) {
            Log.m5049i(AbstractC0032a.m165s("YC5XYFD3Lw5Y\n", "LEEwCT6lXGI=\n"), AbstractC0032a.m165s("/Fl9553xT2v0W2f22OcKeeBFeg==\n", "lTcUk/iVbw0=\n"));
            return;
        }
        AuthInfo authInfo = C2630m.f9145e;
        if (authInfo == null || (serviceBean = authInfo.service) == null) {
            return;
        }
        this.f10329V.setText(serviceBean.name);
        this.f10330W.setText(C2630m.f9145e.service.reseller);
        this.f10332Y.setTextColor(AbstractC3928d.m7847i(m1321j(), R.color.user_center_txt_color));
        AuthInfo.UserBean userBean = C2630m.f9145e.user;
        if (userBean != null) {
            if (userBean.user_name != null) {
                if (AbstractC3331m.m6756f(0, AbstractC2440g.f8553b).intValue() == 2) {
                    this.f10331X.setText(AbstractC0032a.m165s("LVwuKDfkUqA0Pg==\n", "fW59bWWycvY=\n"));
                } else {
                    this.f10331X.setText(C2630m.f9145e.user.user_name.replace(AbstractC2442h.f8597c, ""));
                }
            }
            this.f10331X.setSelected(true);
            String string = m1324m().getString(R.string.user_status_enabled);
            int i6 = C2630m.f9145e.user.user_status;
            if (i6 == -1) {
                string = m1324m().getString(R.string.user_status_registered);
            } else if (i6 == 0) {
                string = m1324m().getString(R.string.user_status_disabled);
                this.f10332Y.setTextColor(-65536);
            }
            this.f10332Y.setText(string);
            if (C2630m.f9145e.user.EndTime > 0) {
                this.f10333Z.setText(new SimpleDateFormat(AbstractC0032a.m165s("0QbcQBZdrXfMGw==\n", "qH+lOTsQ4Fo=\n"), Locale.getDefault()).format(Long.valueOf(C2630m.f9145e.user.EndTime)));
                long jCurrentTimeMillis = ((C2630m.f9145e.user.EndTime - (System.currentTimeMillis() + AbstractC3331m.f11243a)) / 3600) / 1000;
                int i10 = (int) (jCurrentTimeMillis / 24);
                int i11 = (int) (jCurrentTimeMillis % 24);
                if (i10 < 0) {
                    i10 = 0;
                }
                if (i11 < 0) {
                    i11 = 0;
                }
                if (i10 == 0) {
                    this.f10334b0.setText(String.format(m1325n(R.string.service_expire_info_hours), Integer.valueOf(i11)));
                } else {
                    this.f10334b0.setText(String.format(m1325n(R.string.service_expire_info), Integer.valueOf(i10)));
                }
            } else {
                this.f10333Z.setText(m1324m().getString(R.string.nolimit));
            }
        }
        if (C2630m.f9145e.service.type == 1) {
            this.f10334b0.setText(m1324m().getString(R.string.demo_service));
        }
        this.f10335c0.setText(C2630m.f9145e.service.telephone);
        this.f10336d0.setText(C2630m.f9145e.service.website);
    }

    public final void m6094Q() {
        String str = AbstractC2442h.f8595a;
        Button button = this.f10328U;
        if (button != null && button.getVisibility() != 0) {
            this.f10328U.setVisibility(0);
            return;
        }
        Button button2 = this.f10328U;
        if (button2 != null) {
            button2.getVisibility();
        }
    }

    @Override
    public final void onClick(View view) {
        if (view.getId() == R.id.logout) {
            ((Spark) m1319h()).m6701Q0();
        }
    }

    @Override
    public final boolean onKey(View view, int i6, KeyEvent keyEvent) {
        int id = view.getId();
        if (keyEvent.getRepeatCount() == 0 && keyEvent.getAction() == 0) {
            if (id == R.id.logout && (i6 == 19 || i6 == 20)) {
                this.f10328U.requestFocus();
                this.f10328U.setSelected(true);
                return true;
            }
            if (i6 == 21 || i6 == 4) {
                Spark spark = (Spark) m1319h();
                RadioButton radioButton = spark.f11042E;
                if (radioButton != null && radioButton.isShown()) {
                    AbstractC3280d.m6606y(spark.f11042E);
                    spark.f11042E.setChecked(true);
                }
                return true;
            }
            if (i6 == 22) {
                return true;
            }
        }
        return super.onKey(view, i6, keyEvent);
    }

    @Override
    public final View mo1329t(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.userviewpager_loginsuccess, (ViewGroup) null);
        Button button = (Button) viewInflate.findViewById(R.id.logout);
        this.f10328U = button;
        button.setOnClickListener(this);
        this.f10328U.setOnKeyListener(this);
        this.f10329V = (TextView) viewInflate.findViewById(R.id.service_name);
        this.f10330W = (TextView) viewInflate.findViewById(R.id.reseller);
        this.f10331X = (TextView) viewInflate.findViewById(R.id.username);
        this.f10332Y = (TextView) viewInflate.findViewById(R.id.user_status);
        this.f10333Z = (TextView) viewInflate.findViewById(R.id.expire_time);
        this.f10334b0 = (TextView) viewInflate.findViewById(R.id.expire_notice);
        this.f10335c0 = (TextView) viewInflate.findViewById(R.id.phone);
        this.f10336d0 = (TextView) viewInflate.findViewById(R.id.website);
        View viewFindViewById = viewInflate.findViewById(R.id.servie_period_panel);
        this.f10338f0 = viewFindViewById;
        if (!AbstractC2442h.f8619y) {
            viewFindViewById.setVisibility(8);
        }
        return viewInflate;
    }
}
