package p055ea;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import com.tencent.mars.xlog.Log;
import org.bitspark.android.Spark;
import org.bitspark.android.utils.AbstractC3331m;
import p003a2.AbstractC0032a;
import p116ka.ViewOnKeyListenerC2915e;
import p116ka.ViewOnKeyListenerC2932m0;
import p156o9.AbstractC3280d;

public final class ViewOnFocusChangeListenerC2476y implements View.OnFocusChangeListener {

    public final int f8676a;

    public final Spark f8677b;

    public ViewOnFocusChangeListenerC2476y(Spark spark, int i6) {
        this.f8676a = i6;
        this.f8677b = spark;
    }

    @Override
    public final void onFocusChange(View view, boolean z7) {
        RelativeLayout relativeLayout;
        RelativeLayout relativeLayout2;
        Spark spark = this.f8677b;
        switch (this.f8676a) {
            case 0:
                String strM165s = AbstractC0032a.m165s("Hc3ixevO\n", "X56vpIKgJAA=\n");
                String str = AbstractC0032a.m165s("gGJJwlyV5qyHbWHKWtq1gopiev9ehPyArXl72VCOuc+HbXzrUIPgnM8=\n", "7wwPrT/gle8=\n") + z7 + AbstractC0032a.m165s("+7zZbyglJWOrvpE=\n", "29urAF1VcRo=\n") + Spark.f11006b2;
                boolean z10 = AbstractC3331m.f11244b;
                Log.m5049i(strM165s, str);
                if (z7) {
                    if (!Spark.f11014j2) {
                        Spark.m6677t(spark);
                    }
                    if (Spark.f11007c2) {
                        Spark.f11007c2 = false;
                        spark.f11054I.m5956c0();
                        spark.f11054I.f10001X.notifyItemChanged(spark.f11054I.m5950W());
                    }
                    spark.f11054I.f10014l0 = true;
                    Spark.f11006b2 = 100;
                    spark.m6685A0(spark.f11033B);
                    if (AbstractC3331m.m6756f(-65535, AbstractC2440g.f8552a).intValue() == 0) {
                        spark.f11153y.m3101u(0, false);
                        spark.f11054I.m5953Z();
                        RelativeLayout relativeLayout3 = spark.f11054I.f10005c0;
                        if ((relativeLayout3 != null ? relativeLayout3.getVisibility() : 0) != 0 && (relativeLayout = spark.f11054I.f10005c0) != null) {
                            relativeLayout.setVisibility(0);
                            break;
                        }
                    } else {
                        RadioButton radioButton = spark.f11042E;
                        if (radioButton != null && radioButton.isShown()) {
                            AbstractC3280d.m6606y(spark.f11042E);
                            break;
                        }
                    }
                }
                break;
            case 1:
                String strM165s2 = AbstractC0032a.m165s("7e8K9874\n", "r7xHlqeW324=\n");
                String str2 = AbstractC0032a.m165s("vJbA9O+uUrW7mej86eEBgLyc1Prosk60pozy9OL3AZ6yi8D0765S1g==\n", "0/iGm4zbIfY=\n") + z7;
                boolean z11 = AbstractC3331m.f11244b;
                Log.m5049i(strM165s2, str2);
                if (z7) {
                    spark.m6685A0(spark.f11036C);
                    if (!Spark.f11014j2) {
                        Spark.m6677t(spark);
                    }
                    if (Spark.f11007c2) {
                        Spark.f11007c2 = false;
                        ViewOnKeyListenerC2932m0 viewOnKeyListenerC2932m0 = spark.f11057J;
                        if (viewOnKeyListenerC2932m0.f9979r0) {
                            viewOnKeyListenerC2932m0.f9962Z.m5556b();
                        } else {
                            viewOnKeyListenerC2932m0.f9963b0.m5557b();
                        }
                    }
                    if (AbstractC3331m.m6756f(-65535, AbstractC2440g.f8552a).intValue() == 0) {
                        spark.f11153y.m3101u(AbstractC2440g.f8559h, false);
                        RelativeLayout relativeLayout4 = spark.f11057J.f9967f0;
                        if ((relativeLayout4 != null ? relativeLayout4.getVisibility() : 0) != 0 && (relativeLayout2 = spark.f11057J.f9967f0) != null) {
                            relativeLayout2.setVisibility(0);
                            break;
                        }
                    } else {
                        RadioButton radioButton2 = spark.f11042E;
                        if (radioButton2 != null && radioButton2.isShown()) {
                            AbstractC3280d.m6606y(spark.f11042E);
                            break;
                        }
                    }
                }
                break;
            case 2:
                String strM165s3 = AbstractC0032a.m165s("Q/9gcItA\n", "AawtEeIuKbA=\n");
                String str3 = AbstractC0032a.m165s("AM2YkYRBKfAHwrCZgg562wbQqpGVTQjSC8qxvJJALtwBj/6Whkcc3AzWrd4=\n", "b6Pe/uc0WrM=\n") + z7;
                boolean z12 = AbstractC3331m.f11244b;
                Log.m5049i(strM165s3, str3);
                if (z7) {
                    if (!Spark.f11014j2) {
                        Spark.m6677t(spark);
                    }
                    spark.m6685A0(spark.f11039D);
                    if (AbstractC3331m.m6756f(-65535, AbstractC2440g.f8552a).intValue() == 0) {
                        spark.f11153y.m3101u(AbstractC2440g.f8560i, false);
                        spark.f11060K.m5908Q();
                        RelativeLayout relativeLayout5 = spark.f11060K.f9881V;
                        if ((relativeLayout5 != null ? relativeLayout5.getVisibility() : 0) != 0) {
                            ViewOnKeyListenerC2915e viewOnKeyListenerC2915e = spark.f11060K;
                            RelativeLayout relativeLayout6 = viewOnKeyListenerC2915e.f9881V;
                            if (relativeLayout6 != null) {
                                relativeLayout6.setVisibility(0);
                            }
                            LinearLayout linearLayout = viewOnKeyListenerC2915e.f9882W;
                            if (linearLayout != null) {
                                linearLayout.setVisibility(0);
                            }
                            spark.f11060K.f9893i0.setVisibility(8);
                        }
                        break;
                    } else {
                        RadioButton radioButton3 = spark.f11042E;
                        if (radioButton3 != null && radioButton3.isShown()) {
                            AbstractC3280d.m6606y(spark.f11042E);
                            break;
                        }
                    }
                }
                break;
            case 3:
                String strM165s4 = AbstractC0032a.m165s("Ev0cIcf0\n", "UK5RQK6a5Ko=\n");
                String str4 = AbstractC0032a.m165s("VpN6FEwELX9RnFIcSkt+SUqYTilOFTdTe4hID0AfchxRnE89QBIrTxk=\n", "Of08ey9xXjw=\n") + z7;
                boolean z13 = AbstractC3331m.f11244b;
                Log.m5049i(strM165s4, str4);
                if (z7) {
                    spark.m6685A0(spark.f11042E);
                    spark.f11153y.m3101u(AbstractC2440g.f8561j, false);
                }
                break;
            case 4:
                String strM165s5 = AbstractC0032a.m165s("Og7zfBpi\n", "eF2+HXMM6Wk=\n");
                String str5 = AbstractC0032a.m165s("AyBhtUQ5yvAEL0m9QnaZ0hw+VIhGKNDcLjtTrkgilZMEL1ScSC/MwEw=\n", "bE4n2idMubM=\n") + z7;
                boolean z14 = AbstractC3331m.f11244b;
                Log.m5049i(strM165s5, str5);
                if (z7) {
                    spark.m6685A0(spark.f11045F);
                    spark.f11153y.m3101u(AbstractC2440g.f8562k, false);
                }
                break;
            case 5:
                String strM165s6 = AbstractC0032a.m165s("OS0Rs5B6\n", "e35c0vkUypQ=\n");
                String str6 = AbstractC0032a.m165s("o3ryizMaCnmkddqDNVVZSalgwI0+CCtbqH3bpiUbDVWiOJSMMRw/Va9hx8Q=\n", "zBS05FBveTo=\n") + z7;
                boolean z15 = AbstractC3331m.f11244b;
                Log.m5049i(strM165s6, str6);
                if (z7) {
                    spark.m6685A0(spark.f11048G);
                    spark.f11153y.m3101u(AbstractC2440g.f8563l, false);
                }
                break;
            default:
                String strM165s7 = AbstractC0032a.m165s("0DZJvIKR\n", "kmUE3ev/Z6w=\n");
                String str7 = AbstractC0032a.m165s("kPNGWKg3nduX/G5QrnjO/Yn4bkOZI4rxkN91Q78tgLTf9WFEjS2N7Yy9\n", "/50AN8tC7pg=\n") + z7;
                boolean z16 = AbstractC3331m.f11244b;
                Log.m5049i(strM165s7, str7);
                if (z7) {
                    spark.m6685A0(spark.f11051H);
                    spark.f11153y.m3101u(AbstractC2440g.f8564m, false);
                    FrameLayout frameLayout = spark.f11069N.f9932b0;
                    if (frameLayout != null) {
                        frameLayout.setVisibility(0);
                    }
                }
                break;
        }
    }
}
