package p055ea;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.RadioButton;
import androidx.appcompat.widget.RunnableC0261r0;
import androidx.media3.container.MdtaMetadataEntry;
import androidx.media3.exoplayer.DefaultRenderersFactory;
import com.alibaba.fastjson.asm.Opcodes;
import com.p2serv.android.p032ds.R;
import com.tencent.mars.xlog.Log;
import com.tvbus.engine.TVService;
import ga.C2621d;
import ga.C2626i;
import ga.C2628k;
import ga.C2630m;
import ga.EnumC2629l;
import io.binstream.libtvcar.Libtvcar;
import org.bitspark.android.Constants$VIDEO_TYPE;
import org.bitspark.android.Spark;
import org.bitspark.android.beans.AuthInfo;
import org.bitspark.android.beans.ChannelBean;
import org.bitspark.android.utils.AbstractC3331m;
import org.bitspark.android.utils.C3320b;
import org.bitspark.android.utils.LimitQueue;
import p003a2.AbstractC0032a;
import p063fa.C2516d0;
import p116ka.ViewOnKeyListenerC2925j;
import p116ka.ViewOnKeyListenerC2932m0;
import p116ka.ViewOnKeyListenerC2937r;
import p125l7.C3004k;
import p156o9.AbstractC3280d;
import p193ra.C3663f;
import sa.DialogC3734e;
import sa.ViewOnKeyListenerC3733d;
import sa.ViewOnKeyListenerC3740k;

public final class HandlerC2468u extends Handler {

    public final Spark f8662a;

    public HandlerC2468u(Spark spark, Looper looper) {
        super(looper);
        this.f8662a = spark;
    }

    @Override
    public final void handleMessage(Message message) {
        AuthInfo.ServiceBean serviceBean;
        View view;
        AuthInfo authInfo;
        AuthInfo.ServiceBean serviceBean2;
        View view2;
        char c5 = 1;
        char c8 = 1;
        int i6 = 0;
        int i10 = message.what;
        if (i10 == 60) {
            AbstractC3331m.m6759i(AbstractC0032a.m165s("lva7xpgv\n", "1KX2p/FB6GA=\n"), AbstractC0032a.m165s("x5g3FbhDCXequBIjl3AzGNq5BTKceygCxLg=\n", "iv1EZtkkbE0=\n"));
            Spark.m6656D(this.f8662a);
            if (this.f8662a.f11063L.f10112W != null) {
                this.f8662a.f11063L.f10112W.m6094Q();
            }
        } else if (i10 == 61) {
            AbstractC3331m.m6759i(AbstractC0032a.m165s("8KZO1+dB\n", "svUDto4vvhM=\n"), AbstractC0032a.m165s("YV/fN7bVl/YMf/oBmeatmXx+7RCS7beefg==\n", "LDqsRNey8sw=\n"));
            if (this.f8662a.f11063L.f10112W != null) {
                this.f8662a.f11063L.f10112W.m6094Q();
            }
        } else if (i10 == 71) {
            this.f8662a.f11158z1.setProgress(this.f8662a.f11113e1);
            this.f8662a.f11032A1.setProgress(this.f8662a.f11113e1);
            this.f8662a.f11155y1.setText(this.f8662a.f11113e1 + AbstractC0032a.m165s("InfpBw==\n", "DUbZN7XgE4s=\n"));
            Spark spark = this.f8662a;
            spark.m6728u0(AbstractC3331m.m6752b((long) spark.f11117g1));
        } else if (i10 == 72) {
            AbstractC3331m.m6759i(AbstractC0032a.m165s("cOOWjl5h\n", "MrDb7zcP86o=\n"), AbstractC0032a.m165s("qevssx1o7b/Ey8mFMlvX0LTK3pQ5UMzKs8DTjz1L19el2to=\n", "5I6fwHwPiIU=\n"));
            int i11 = message.arg1;
            if (this.f8662a.f11044E1 == Constants$VIDEO_TYPE.STATIC) {
                this.f8662a.m6728u0(AbstractC3331m.m6752b(i11));
            }
        } else if (i10 == 80) {
            C3320b.m6737d().m6740f();
            AbstractC3331m.m6759i(AbstractC0032a.m165s("tGEgDJmt\n", "9jJtbfDDsyI=\n"), AbstractC0032a.m165s("rHfEexz9QBnBV+FNM856c61T7lcr02Fmrg==\n", "4RK3CH2aJSM=\n"));
            Spark spark2 = this.f8662a;
            spark2.f11101Y = null;
            spark2.f11049G0 = false;
            spark2.f11106b0.post(new RunnableC2470v(spark2, i6));
            this.f8662a.m6720l0(message.getData());
            this.f8662a.m6716g0(0);
        } else if (i10 == 81) {
            AbstractC3331m.m6759i(AbstractC0032a.m165s("dFWY04t5\n", "NgbVsuIXTGw=\n"), AbstractC0032a.m165s("8oQrx/n3niCfpA7x1sSkSfq1B+LR1L5V4LEZ4NDPr1XgsRT1wdWp\n", "v+FYtJiQ+xo=\n"));
            this.f8662a.f11103Z = message.getData().getString(AbstractC0032a.m165s("3vLQharzEvrA\n", "qJu04MWjc44=\n"));
            AbstractC3331m.m6759i(AbstractC0032a.m165s("76nbyB2A\n", "rfqWqXTuddc=\n"), AbstractC0032a.m165s("c0qRwmcBsEN5W4bfUg6wfSo=\n", "ED/jsAJvxBU=\n") + this.f8662a.f11103Z);
            Spark spark3 = this.f8662a;
            Spark.m6660H(spark3, spark3.f11103Z);
        } else if (i10 == 93) {
            AbstractC3331m.m6759i(AbstractC0032a.m165s("CsnESfJK\n", "SJqJKJskuLI=\n"), AbstractC0032a.m165s("xmvcHEWV+uyrS/kqaqbAhc5L5DtrrduTx1ru\n", "iw6vbyTyn9Y=\n"));
            long currentPosition = this.f8662a.f11065L1.getCurrentPosition() + ((long) (message.arg1 * 1000));
            this.f8662a.f11065L1.seekTo(currentPosition >= 0 ? currentPosition : 0L);
            this.f8662a.getClass();
        } else if (i10 == 94) {
            AbstractC3331m.m6759i(AbstractC0032a.m165s("4t2E22U5\n", "oI7JugxX6zk=\n"), AbstractC0032a.m165s("BqHyFGlhubJrgdciRlKDzgqAxChdUoPBBYLO\n", "S8SBZwgG3Ig=\n"));
            Spark.m6667O(this.f8662a);
        } else if (i10 == 130) {
            ViewOnKeyListenerC2937r viewOnKeyListenerC2937r = this.f8662a.f11054I;
            if (viewOnKeyListenerC2937r != null) {
                viewOnKeyListenerC2937r.m5949V(message.arg1);
                Spark spark4 = this.f8662a;
                spark4.m6685A0(spark4.f11033B);
            }
            this.f8662a.m6716g0(0);
        } else if (i10 == 131) {
            ViewOnKeyListenerC2932m0 viewOnKeyListenerC2932m0 = this.f8662a.f11057J;
            if (viewOnKeyListenerC2932m0 != null) {
                int i12 = message.arg1;
                if (ViewOnKeyListenerC2932m0.f9952G0) {
                    viewOnKeyListenerC2932m0.m5930S();
                }
                this.f8662a.f11057J.m5932U(i12);
                Spark spark5 = this.f8662a;
                spark5.m6685A0(spark5.f11036C);
            }
            this.f8662a.m6716g0(0);
        } else if (i10 == 201) {
            AbstractC0032a.m165s("MHceV+Jv\n", "ciRTNosBIe0=\n");
            AbstractC0032a.m165s("tGkxY1MbrrLZSRRVfCiUy7FJAVttLIfJoEkQ\n", "+QxCEDJ8y4g=\n");
            Spark.m6655C(this.f8662a);
        } else if (i10 == 202) {
            String strM165s = AbstractC0032a.m165s("wR/RQeYR\n", "g0ycII9/ibs=\n");
            String strM165s2 = AbstractC0032a.m165s("Z/IIYF4L0ugK0i1WcTjohmXIK19+NeiBY9MkUHct+Zxv2w==\n", "Kpd7Ez9st9I=\n");
            boolean z7 = AbstractC3331m.f11244b;
            Log.m5049i(strM165s, strM165s2);
            Log.m5049i(AbstractC0032a.m165s("yXAw8XmO\n", "iyN9kBDgyoE=\n"), AbstractC0032a.m165s("odeNi0eGkBCm0cnB\n", "1bit+yvn6TA=\n") + this.f8662a.f11110d0);
            if (C2621d.f9111e != null) {
                ChannelBean channelBean = (ChannelBean) C2621d.f9111e.get(Integer.valueOf(this.f8662a.f11110d0));
                if (channelBean != null) {
                    Log.m5049i(AbstractC0032a.m165s("01Xwtgm9\n", "kQa912DT354=\n"), AbstractC0032a.m165s("SRxlFA==\n", "OnUBLtDEy0g=\n") + this.f8662a.f11110d0 + AbstractC0032a.m165s("mC7/08kCVWrWZ/KOgQVUcd1v6A==\n", "uAPS7elkOh8=\n") + channelBean.getChid());
                    this.f8662a.f11054I.m5955b0(channelBean);
                }
                this.f8662a.f11110d0 = 0;
            }
        } else if (i10 == 9998) {
            String string = message.getData().getString(AbstractC0032a.m165s("GnOR7/M53g==\n", "dxbinJJeu1U=\n"));
            Spark spark6 = this.f8662a;
            ViewOnKeyListenerC3733d viewOnKeyListenerC3733d = new ViewOnKeyListenerC3733d(spark6);
            viewOnKeyListenerC3733d.f12505b = string;
            String string2 = spark6.getResources().getString(R.string.quit_now);
            DialogInterfaceOnClickListenerC2462r dialogInterfaceOnClickListenerC2462r = new DialogInterfaceOnClickListenerC2462r(i6);
            viewOnKeyListenerC3733d.f12506c = string2;
            viewOnKeyListenerC3733d.f12509f = dialogInterfaceOnClickListenerC2462r;
            DialogC3734e dialogC3734eM7487a = viewOnKeyListenerC3733d.m7487a();
            dialogC3734eM7487a.show();
            CountDownTimerC2464s countDownTimerC2464s = new CountDownTimerC2464s(string, viewOnKeyListenerC3733d, dialogC3734eM7487a);
            countDownTimerC2464s.start();
            dialogC3734eM7487a.setOnDismissListener(new DialogInterfaceOnDismissListenerC2466t(i6, countDownTimerC2464s));
        } else if (i10 != 9999) {
            switch (i10) {
                case 7:
                    AbstractC3331m.m6759i(AbstractC0032a.m165s("fPVC5RYM\n", "PqYPhH9iZ04=\n"), AbstractC0032a.m165s("Sp1Zk3FWN0AnvXylXmUNOU+9aatPfxcuULd4qw==\n", "B/gq4BAxUno=\n"));
                    this.f8662a.m6703S();
                    break;
                case 8:
                    AbstractC3331m.m6759i(AbstractC0032a.m165s("fiBiGdGf\n", "PHMveLjxFvk=\n"), AbstractC0032a.m165s("I/QI+XgGRBJO1C3PVzV+aybUOMFGL2R8Od4pwUYlbmYr\n", "bpF7ihlhISg=\n"));
                    Spark.m6674r(this.f8662a);
                    Spark.m6675s(this.f8662a);
                    this.f8662a.m6714e0();
                    break;
                case 9:
                    AbstractC3331m.m6759i(AbstractC0032a.m165s("pWq2g3eI\n", "5zn74h7mVao=\n"), AbstractC0032a.m165s("EiZF24jlsY9/BmDtp9aL5xoEf/u9x4bqGwZg4arH\n", "X0M2qOmC1LU=\n"));
                    Spark spark7 = this.f8662a;
                    if (spark7.f11087T == null) {
                        spark7.f11087T = new C2630m(this.f8662a);
                    }
                    this.f8662a.f11087T.m5651g();
                    break;
                case 10:
                    Spark.f11005a2 = true;
                    this.f8662a.f11075P.setVisibility(0);
                    AbstractC3331m.m6759i(AbstractC0032a.m165s("dUMY2yBA\n", "NxBVukkuoyE=\n"), AbstractC0032a.m165s("IOY8/0JXMelNxhnJbWQLlCLXANN2eQufIsQGwg==\n", "bYNPjCMwVNM=\n"));
                    this.f8662a.f11153y.m3101u(AbstractC2440g.f8561j, false);
                    RadioButton radioButton = this.f8662a.f11042E;
                    if (radioButton != null) {
                        radioButton.setChecked(true);
                    }
                    String strM165s3 = AbstractC0032a.m165s("8ppI7x1V\n", "sMkFjnQ7Y4Y=\n");
                    StringBuilder sb = new StringBuilder();
                    sb.append(AbstractC0032a.m165s("qbtnJfFikgqxrWwjmWWACK6eazLAQJIKubojatllnwH85Tx3\n", "3MgCV7cQ820=\n"));
                    sb.append(this.f8662a.f11063L.f10113X != null);
                    AbstractC3331m.m6759i(strM165s3, sb.toString());
                    if (this.f8662a.f11063L.f10113X != null) {
                        String str = AbstractC2440g.f8552a;
                        if (AbstractC3331m.m6756f(-65535, str).intValue() == -12) {
                            this.f8662a.f11063L.f10113X.setCurrentItem(1);
                        } else if (AbstractC3331m.m6756f(-65535, str).intValue() != 0) {
                            this.f8662a.f11063L.f10113X.setCurrentItem(0);
                            this.f8662a.f11063L.f10111V.m6090Q();
                            this.f8662a.f11063L.f10111V.m6092S();
                            this.f8662a.f11063L.f10111V.m6091R();
                        }
                    }
                    break;
                case 11:
                    AbstractC3331m.m6759i(AbstractC0032a.m165s("eBye+b+D\n", "Ok/TmNbtjUI=\n"), AbstractC0032a.m165s("+KBj1QamIdOVgEbjKZUbu/CCWfUzhBa28YBG7ySEDa3qgV/oIg==\n", "tcUQpmfBROk=\n"));
                    Spark.m6674r(this.f8662a);
                    break;
                case 12:
                    AbstractC3331m.m6759i(AbstractC0032a.m165s("TZ0SvQjf\n", "D85f3GGxBu4=\n"), AbstractC0032a.m165s("9hHK9bV4l1qbMe/DmkutMv4z8NWAWqA//zHvz5dauyTkMevU\n", "u3S5htQf8mA=\n"));
                    break;
                case 13:
                    AbstractC3331m.m6759i(AbstractC0032a.m165s("R7mrK9c4\n", "BermSr5WrLc=\n"), AbstractC0032a.m165s("+v+J0ShrGeOX36znB1gjiuLYt+sdUymK8si04wRJI4n2yan1Bl44\n", "t5r6okkMfNk=\n"));
                    Spark.m6674r(this.f8662a);
                    break;
                default:
                    switch (i10) {
                        case 15:
                            Spark.f11005a2 = false;
                            AbstractC3331m.m6759i(AbstractC0032a.m165s("a1S2GMFe\n", "KQf7eagwDcM=\n"), AbstractC0032a.m165s("+LMJx5+6TluVkyzxsIl0LfqRM/qhmWQv8A==\n", "tdZ6tP7dK2E=\n"));
                            int iIntValue = AbstractC3331m.m6756f(-1, AbstractC0032a.m165s("5k7ZblEy/NTmV8JjWjfr\n", "tR6GJhh2uYs=\n")).intValue();
                            if (iIntValue == -1) {
                                iIntValue = AbstractC2442h.f8593O ? 0 : 1;
                            }
                            this.f8662a.f11120i0.f12991d.m1488h(AbstractC3331m.m6756f(-1, AbstractC0032a.m165s("ZfcriSrooJRz+CCUP/s=\n", "Nqd0zW++6dc=\n")));
                            this.f8662a.f11120i0.f12992e.m1490j(Integer.valueOf(iIntValue));
                            Spark.m6680v(this.f8662a);
                            if (AbstractC2442h.f8604j) {
                                this.f8662a.m6694J0();
                            }
                            this.f8662a.m6719k0(false);
                            String strM165s4 = AbstractC0032a.m165s("DUUeLals\n", "TxZTTMAC5z0=\n");
                            StringBuilder sb2 = new StringBuilder("false ");
                            sb2.append(this.f8662a.f11063L.f10113X != null);
                            AbstractC3331m.m6759i(strM165s4, sb2.toString());
                            if (AbstractC2442h.f8586H) {
                                this.f8662a.f11075P.setVisibility(0);
                                this.f8662a.f11153y.m3101u(AbstractC2440g.f8564m, false);
                                AbstractC3280d.m6606y(this.f8662a.f11051H);
                                ViewOnKeyListenerC2925j viewOnKeyListenerC2925j = this.f8662a.f11069N;
                                if (viewOnKeyListenerC2925j.f9927V != null) {
                                    viewOnKeyListenerC2925j.m5923S();
                                } else {
                                    Spark.f11002X1.sendEmptyMessageDelayed(140, 100L);
                                }
                            }
                            AuthInfo authInfo2 = C2630m.f9145e;
                            if (authInfo2 != null && (serviceBean = authInfo2.service) != null) {
                                if (!serviceBean.enabledLive) {
                                    this.f8662a.f11033B.setVisibility(8);
                                }
                                if (!C2630m.f9145e.service.enabledVoD) {
                                    this.f8662a.f11036C.setVisibility(8);
                                }
                                if (AbstractC2442h.f8580B) {
                                    this.f8662a.f11039D.setVisibility(8);
                                }
                                Spark.m6681w(this.f8662a, C2630m.f9145e.service.logo);
                                String strM5649h = C2630m.m5649h(EnumC2629l.f9140k);
                                if (strM5649h != null && !strM5649h.isEmpty()) {
                                    Spark.m6682x(this.f8662a, strM5649h);
                                }
                            }
                            Spark.m6683y(this.f8662a);
                            this.f8662a.m6716g0(0);
                            break;
                        case 30:
                            AbstractC3331m.m6759i(AbstractC0032a.m165s("Ng6x3yz0\n", "dF38vkWaexY=\n"), AbstractC0032a.m165s("D0lo1VO3BK5iaU3jfIQ+0RJrROJ9niQ=\n", "QiwbpjLQYZQ=\n"));
                            this.f8662a.m6714e0();
                            this.f8662a.f11075P.setVisibility(0);
                            this.f8662a.f11054I.m5953Z();
                            if (!Spark.f11005a2) {
                                Spark.f11002X1.sendEmptyMessageDelayed(110, 10L);
                            }
                            break;
                        case 32:
                            AbstractC3331m.m6759i(AbstractC0032a.m165s("c59ACCf5\n", "McwNaU6XFII=\n"), AbstractC0032a.m165s("Ydi2gGA6riMM+JO2TwmUXHz6mqFEGo5N\n", "LL3F8wFdyxk=\n"));
                            Spark.f11010f2 = true;
                            Spark.m6684z(this.f8662a);
                            break;
                        case DefaultRenderersFactory.MAX_DROPPED_VIDEO_FRAME_COUNT_TO_NOTIFY:
                            String strM165s5 = AbstractC0032a.m165s("qnYVb+WW\n", "6CVYDoz4la4=\n");
                            String strM165s6 = AbstractC0032a.m165s("HMUDkfPciXhx5San3O+zDxTzI6PV/rMGHu41\n", "UaBw4pK77EI=\n");
                            boolean z10 = AbstractC3331m.f11244b;
                            Log.m5049i(strM165s5, strM165s6);
                            Spark spark8 = this.f8662a;
                            HandlerC2468u handlerC2468u = Spark.f11002X1;
                            spark8.getClass();
                            new C2628k().m5643a(AbstractC0032a.m165s("z+/yj4M=\n", "o4CV5u23Dh8=\n"));
                            break;
                        case MdtaMetadataEntry.TYPE_INDICATOR_8_BIT_UNSIGNED_INT:
                            String strM165s7 = AbstractC0032a.m165s("0vguqzAD\n", "kKtjylltwgo=\n");
                            String strM165s8 = AbstractC0032a.m165s("o1s3GTFKJtnOexIvHnkcsatyCysUchC6vWoBJw9vGry7bQE4\n", "7j5EalAtQ+M=\n");
                            boolean z11 = AbstractC3331m.f11244b;
                            Log.m5049i(strM165s7, strM165s8);
                            Spark.m6677t(this.f8662a);
                            this.f8662a.m6697M0(true);
                            Spark.f11005a2 = false;
                            this.f8662a.m6703S();
                            break;
                        case 144:
                            ViewOnKeyListenerC2932m0 viewOnKeyListenerC2932m1 = this.f8662a.f11057J;
                            if (!viewOnKeyListenerC2932m1.f9979r0) {
                                AbstractC3280d.m6606y(viewOnKeyListenerC2932m1.f9961Y);
                            } else {
                                AbstractC3280d.m6606y(viewOnKeyListenerC2932m1.f9959W);
                            }
                            break;
                        case 250:
                            if (message.getData() != null) {
                                String string3 = message.getData().getString(AbstractC0032a.m165s("GmH6sg==\n", "bgSCxgK8XVc=\n"));
                                if (!TextUtils.isEmpty(string3)) {
                                    this.f8662a.m6693I0(message.arg2, string3);
                                    String strM165s9 = AbstractC0032a.m165s("fQs/jC6e\n", "P1hy7UfwH1c=\n");
                                    String strM5496j = AbstractC2460q.m5496j("OgIAWjcfUn5XIiVsGCxoEDgmIH0JNXIXJCY0bHZVFw==\n", "d2dzKVZ4N0Q=\n", new StringBuilder(), string3);
                                    boolean z12 = AbstractC3331m.f11244b;
                                    Log.m5049i(strM165s9, strM5496j);
                                }
                            }
                            break;
                        case 260:
                            String strM165s10 = AbstractC0032a.m165s("bnlg/OxJ\n", "LCotnYUnSys=\n");
                            String strM165s11 = AbstractC0032a.m165s("Ka6iI2MGR8xEjocVTDV9tSiOkAJdNkOfEKK/N0UOVpk+rqM/Ug5RnxCivj4=\n", "ZMvRUAJhIvY=\n");
                            boolean z13 = AbstractC3331m.f11244b;
                            Log.m5049i(strM165s10, strM165s11);
                            break;
                        case 270:
                            String strM165s12 = AbstractC0032a.m165s("qVqIOqZY\n", "6wnFW8825KQ=\n");
                            String strM165s13 = AbstractC0032a.m165s("AsTKNlSd6QJv5O8Ae67Taxjo7QZ9pd9tDfXwEXm/\n", "T6G5RTX6jDg=\n");
                            boolean z14 = AbstractC3331m.f11244b;
                            Log.m5049i(strM165s12, strM165s13);
                            break;
                        case 301:
                            C2516d0 c2516d0 = this.f8662a.f11054I.f10002Y;
                            if (c2516d0 != null && (view = c2516d0.f8768e) != null) {
                                int iIndexOf = c2516d0.f8767d.indexOf(view.getTag());
                                this.f8662a.f11054I.f10002Y.notifyDataSetChanged();
                                postDelayed(new RunnableC0261r0(this, iIndexOf, view, 5), 500L);
                            }
                            break;
                        case 651:
                            String strM165s14 = AbstractC0032a.m165s("KpuIf50a\n", "aMjFHvR0fNs=\n");
                            String strM165s15 = AbstractC0032a.m165s("ke++sZYtRo/8z5uHuR58+JnZnoOwD3zwjtg=\n", "3IrNwvdKI7U=\n");
                            boolean z15 = AbstractC3331m.f11244b;
                            Log.m5049i(strM165s14, strM165s15);
                            Spark spark9 = this.f8662a;
                            HandlerC2468u handlerC2468u2 = Spark.f11002X1;
                            spark9.getClass();
                            new C2628k().m5643a(AbstractC0032a.m165s("z+/yj4M=\n", "o4CV5u23Dh8=\n"));
                            break;
                        case 1000:
                            String strM165s16 = AbstractC0032a.m165s("fZm+Mevy\n", "P8rzUIKc1UY=\n");
                            String strM165s17 = AbstractC0032a.m165s("Ix2eWCAorYROK7lkERCY8i8hqHkeAIbhKyC9YhMK\n", "bnjtK0FPyL4=\n");
                            boolean z16 = AbstractC3331m.f11244b;
                            Log.m5049i(strM165s16, strM165s17);
                            Spark spark10 = this.f8662a;
                            HandlerC2468u handlerC2468u3 = Spark.f11002X1;
                            spark10.getClass();
                            ViewOnKeyListenerC3740k viewOnKeyListenerC3740k = new ViewOnKeyListenerC3740k(spark10);
                            viewOnKeyListenerC3740k.f12523b = (String) spark10.getText(R.string.expire_error);
                            viewOnKeyListenerC3740k.f12524c = AbstractC0032a.m165s("Xs9GM+kTwXs=\n", "LKorWod3pAk=\n");
                            viewOnKeyListenerC3740k.f12528g = R.mipmap.error;
                            String string4 = spark10.getResources().getString(R.string.ignore);
                            String string5 = spark10.getResources().getString(R.string.stop_player);
                            DialogInterfaceOnClickListenerC2462r dialogInterfaceOnClickListenerC2462r2 = new DialogInterfaceOnClickListenerC2462r(c8 == true ? 1 : 0);
                            viewOnKeyListenerC3740k.f12525d = string4;
                            viewOnKeyListenerC3740k.f12529h = dialogInterfaceOnClickListenerC2462r2;
                            DialogInterfaceOnClickListenerC2450l dialogInterfaceOnClickListenerC2450l = new DialogInterfaceOnClickListenerC2450l(spark10, c5 == true ? 1 : 0);
                            viewOnKeyListenerC3740k.f12526e = string5;
                            viewOnKeyListenerC3740k.f12530i = dialogInterfaceOnClickListenerC2450l;
                            viewOnKeyListenerC3740k.m7488a().show();
                            break;
                        case 9990:
                            Spark spark11 = this.f8662a;
                            HandlerC2468u handlerC2468u4 = Spark.f11002X1;
                            spark11.getClass();
                            spark11.stopService(new Intent(spark11, (Class<?>) TVService.class));
                            if (AbstractC2442h.f8604j) {
                                Libtvcar.release();
                            }
                            break;
                        default:
                            switch (i10) {
                                case 120:
                                    Spark spark12 = this.f8662a;
                                    ViewOnKeyListenerC2932m0 viewOnKeyListenerC2932m2 = spark12.f11057J;
                                    if (viewOnKeyListenerC2932m2.f9979r0) {
                                        spark12.m6731x0(Boolean.TRUE);
                                        AbstractC3280d.m6606y(this.f8662a.f11036C);
                                        this.f8662a.f11036C.setChecked(true);
                                    } else if (!ViewOnKeyListenerC2932m0.f9952G0) {
                                        AbstractC3280d.m6606y(viewOnKeyListenerC2932m2.f9960X);
                                    } else {
                                        AbstractC3280d.m6606y(viewOnKeyListenerC2932m2.f9971j0);
                                    }
                                    break;
                                case 121:
                                    this.f8662a.f11057J.m5939c0();
                                    break;
                                case 122:
                                    String strM165s18 = AbstractC0032a.m165s("5UP1cqup\n", "pxC4E8LHa04=\n");
                                    String strM165s19 = AbstractC0032a.m165s("qh8saDaLffTHPwleGbhHiqI2HkIIpFGKoiUTVBmrR561PwxIEqhHnrU1GEkSv0uRsyw=\n", "53pfG1fsGM4=\n");
                                    boolean z17 = AbstractC3331m.f11244b;
                                    Log.m5049i(strM165s18, strM165s19);
                                    Spark spark13 = this.f8662a;
                                    if (!spark13.f11053H1.m5483a()) {
                                        spark13.f11035B1.setVisibility(8);
                                    }
                                    break;
                                default:
                                    switch (i10) {
                                        case 140:
                                            ViewOnKeyListenerC2925j viewOnKeyListenerC2925j2 = this.f8662a.f11069N;
                                            if (viewOnKeyListenerC2925j2.f9927V == null) {
                                                Spark.f11002X1.sendEmptyMessageDelayed(140, 100L);
                                            } else {
                                                viewOnKeyListenerC2925j2.m5923S();
                                                String str2 = AbstractC2442h.f8595a;
                                            }
                                            break;
                                        case 141:
                                            String strM165s20 = AbstractC0032a.m165s("fAk01xxn\n", "Plp5tnUJww4=\n");
                                            String strM165s21 = AbstractC0032a.m165s("LM7fa+TGrbZB7vpdy/WX2ijv6Vfa8ofeNeLiX9rigM0v7Olc\n", "YausGIWhyIw=\n");
                                            boolean z18 = AbstractC3331m.f11244b;
                                            Log.m5049i(strM165s20, strM165s21);
                                            this.f8662a.f11057J.m5941e0(message.arg1);
                                            ViewOnKeyListenerC2932m0.f9953H0.f4320a.clear();
                                            ViewOnKeyListenerC2932m0.f9950E0.sendEmptyMessage(1);
                                            break;
                                        case 142:
                                            this.f8662a.m6699O0(message);
                                            break;
                                        default:
                                            switch (i10) {
                                                case 18:
                                                    String strM165s22 = AbstractC0032a.m165s("3a4ku9sv\n", "n/1p2rJBM6U=\n");
                                                    String strM165s23 = AbstractC0032a.m165s("2a1rKCl2Zji0jU4eBkVcQdyJVhUNXVxF0Zw=\n", "lMgYW0gRAwI=\n");
                                                    boolean z19 = AbstractC3331m.f11244b;
                                                    Log.m5049i(strM165s22, strM165s23);
                                                    Spark.m6683y(this.f8662a);
                                                    this.f8662a.m6716g0(0);
                                                    break;
                                                case 19:
                                                    String strM165s24 = AbstractC0032a.m165s("zUs90Mzj\n", "jxhwsaWNiks=\n");
                                                    String strM165s25 = AbstractC0032a.m165s("ao7pSWFYmpoHrsx/Tmug9mivxXlIfrHuYqfFfUVr\n", "J+uaOgA//6A=\n");
                                                    boolean z20 = AbstractC3331m.f11244b;
                                                    Log.m5049i(strM165s24, strM165s25);
                                                    if (AbstractC2442h.f8604j && (authInfo = C2630m.f9145e) != null && (serviceBean2 = authInfo.service) != null && serviceBean2.enabledVoD) {
                                                        Spark.m6653A(this.f8662a);
                                                    } else if (!Spark.f11010f2) {
                                                        Spark.m6654B(this.f8662a);
                                                    }
                                                    break;
                                                case 20:
                                                    if (Spark.f11003Y1 == null) {
                                                        C2626i c2626i = new C2626i();
                                                        Object objM5307b = Spark.f11008d2.m5307b(AbstractC0032a.m165s("YU+gmojkihd5SaSGiPrS\n", "DSbW/9eM42Q=\n"));
                                                        if (objM5307b != null) {
                                                            C2626i.f9124e = (LimitQueue) objM5307b;
                                                        } else {
                                                            C2626i.f9124e = new LimitQueue(20);
                                                        }
                                                        Object objM5307b2 = Spark.f11008d2.m5307b(AbstractC0032a.m165s("PqEHuzT8oxwnvBq7KqQ=\n", "SM5j5FyV0Gg=\n"));
                                                        if (objM5307b2 != null) {
                                                            C2626i.f9125f = (LimitQueue) objM5307b2;
                                                        } else {
                                                            C2626i.f9125f = new LimitQueue(50);
                                                        }
                                                        Object objM5307b3 = Spark.f11008d2.m5307b(AbstractC0032a.m165s("9U1Q7JXnBbb8Xl/si78=\n", "kywms/2OdsI=\n"));
                                                        if (objM5307b3 != null) {
                                                            C2626i.f9126g = (LimitQueue) objM5307b3;
                                                        } else {
                                                            C2626i.f9126g = new LimitQueue(100);
                                                        }
                                                        Spark.f11003Y1 = c2626i;
                                                    }
                                                    this.f8662a.f11060K.m5908Q();
                                                    String strM165s26 = AbstractC0032a.m165s("tMBmHe4W\n", "9pMrfId4/qY=\n");
                                                    String strM165s27 = AbstractC0032a.m165s("k82s3GqSIEP+7YnqRaEaOpbpkeFOuRo9keaa\n", "3qjfrwv1RXk=\n");
                                                    boolean z21 = AbstractC3331m.f11244b;
                                                    Log.m5049i(strM165s26, strM165s27);
                                                    Spark.f11010f2 = false;
                                                    Spark.m6684z(this.f8662a);
                                                    Spark.f11002X1.sendEmptyMessageDelayed(19, 10L);
                                                    this.f8662a.m6714e0();
                                                    break;
                                                case 21:
                                                    String strM165s28 = AbstractC0032a.m165s("5LXB/m1D\n", "puaMnwQt4fE=\n");
                                                    String strM165s29 = AbstractC0032a.m165s("xx0Z70LvcbeqPTzZbdxLzsI5JNJmxEvI2Co=\n", "inhqnCOIFI0=\n");
                                                    boolean z22 = AbstractC3331m.f11244b;
                                                    Log.m5049i(strM165s28, strM165s29);
                                                    this.f8662a.m6693I0(0, AbstractC0032a.m165s("9oiU45k4P0ffiIzjljktXZGIkrGVIn8=\n", "se3gw/pQXik=\n"));
                                                    break;
                                                case 22:
                                                    String strM165s30 = AbstractC0032a.m165s("nm5SxiBu\n", "3D0fp0kAp8o=\n");
                                                    String strM165s31 = AbstractC0032a.m165s("rkj/jbAULdLDaNq7nycXvqxp072ZMgampmHTup49DQ==\n", "4y2M/tFzSOg=\n");
                                                    boolean z23 = AbstractC3331m.f11244b;
                                                    Log.m5049i(strM165s30, strM165s31);
                                                    this.f8662a.m6714e0();
                                                    this.f8662a.f11057J.m5934X();
                                                    Spark spark14 = this.f8662a;
                                                    ViewOnKeyListenerC2932m0 viewOnKeyListenerC2932m3 = spark14.f11057J;
                                                    ViewOnKeyListenerC2932m0.f9951F0 = EnumC2434d.f8532d;
                                                    Spark.m6654B(spark14);
                                                    break;
                                                default:
                                                    switch (i10) {
                                                        case 83:
                                                            String strM165s32 = AbstractC0032a.m165s("qDG+zlZk\n", "6mLzrz8K9rU=\n");
                                                            String strM165s33 = AbstractC0032a.m165s("4H53qlq3oWaNXlKcdYSbD/lUVIZrkYgF6Ek=\n", "rRsE2TvQxFw=\n");
                                                            boolean z24 = AbstractC3331m.f11244b;
                                                            Log.m5049i(strM165s32, strM165s33);
                                                            Spark.m6677t(this.f8662a);
                                                            if (Spark.f11005a2) {
                                                                this.f8662a.m6697M0(true);
                                                            }
                                                            break;
                                                        case 84:
                                                            String strM165s34 = AbstractC0032a.m165s("2w0x0Pzd\n", "mV58sZWz+Wc=\n");
                                                            String strM165s35 = AbstractC0032a.m165s("C3LRNe5wOB1mUvQDwUMCdQNE9wvKSA1mCk7nFA==\n", "RheiRo8XXSc=\n");
                                                            boolean z25 = AbstractC3331m.f11244b;
                                                            Log.m5049i(strM165s34, strM165s35);
                                                            this.f8662a.f11121i1 = System.currentTimeMillis() + 4000;
                                                            Spark spark15 = this.f8662a;
                                                            int i13 = Spark.f11017m2;
                                                            String str3 = spark15.f11150x;
                                                            if (i13 != 0) {
                                                                Log.m5049i(str3, AbstractC0032a.m165s("ZnAOoFtnwwd1bBinFmfrBDR8DqVaY+oCenJH\n", "FBV91TYCk2s=\n") + spark15.f11065L1.isPlaying());
                                                                spark15.f11065L1.setPlayWhenReady(true);
                                                                spark15.m6718j0(true);
                                                                spark15.f11065L1.mo7406b();
                                                            } else {
                                                                Log.m5049i(str3, AbstractC0032a.m165s("E7LKaYozSv4ArtxuxyVj4UG+ymyLN2P7D7CD\n", "Yde5HOdWGpI=\n") + spark15.f11065L1.isPlaying());
                                                                if (spark15.f11065L1.isPlaying()) {
                                                                    spark15.f11065L1.mo7407c();
                                                                }
                                                                spark15.f11065L1.mo7412h(spark15.f11103Z);
                                                                spark15.f11065L1.start();
                                                                if (spark15.f11050G1 > 0) {
                                                                    Log.m5049i(str3, AbstractC0032a.m165s("k+sgNv0QZQWA9zYxsAZMGsH9Nib7VUEG2w==\n", "4Y5TQ5B1NWk=\n") + spark15.f11050G1);
                                                                    spark15.f11065L1.seekTo(spark15.f11050G1);
                                                                }
                                                            }
                                                            break;
                                                        case 85:
                                                            Spark spark16 = this.f8662a;
                                                            spark16.f11106b0.post(new RunnableC2470v(spark16, i6));
                                                            String strM165s36 = AbstractC0032a.m165s("PzsPqOPW\n", "fWhCyYq4nC0=\n");
                                                            String strM165s37 = AbstractC0032a.m165s("REeAz7//DmwpZ6X5kMw0BkVjquON3TkfTHE=\n", "CSLzvN6Ya1Y=\n");
                                                            boolean z26 = AbstractC3331m.f11244b;
                                                            Log.m5049i(strM165s36, strM165s37);
                                                            this.f8662a.f11101Y = message.getData();
                                                            Spark spark17 = this.f8662a;
                                                            Spark.m6658F(spark17, spark17.f11101Y);
                                                            break;
                                                        case 86:
                                                            this.f8662a.f11058J0 = EnumC2434d.valueOf(message.getData().getString(AbstractC0032a.m165s("0kUMsZupUHI=\n", "vyBixM/QIBc=\n")));
                                                            break;
                                                        default:
                                                            switch (i10) {
                                                                case Opcodes.IADD:
                                                                    String strM165s38 = AbstractC0032a.m165s("5AtdjgK4\n", "plgQ72vWo80=\n");
                                                                    String strM165s39 = AbstractC0032a.m165s("ILtcEXCqxwJNm3knX5n9cCSaaj1Bn+17KI18PVOM8A==\n", "bd4vYhHNojg=\n");
                                                                    boolean z27 = AbstractC3331m.f11244b;
                                                                    Log.m5049i(strM165s38, strM165s39);
                                                                    this.f8662a.m6709Z();
                                                                    break;
                                                                case 97:
                                                                    String strM165s40 = AbstractC0032a.m165s("eunFKR4v\n", "OLqISHdB/YY=\n");
                                                                    String strM165s41 = AbstractC0032a.m165s("vy6PQccS+YDSDqp36CHD6r4KpXf0Ks/usx+pYfk21Pu8DLl2\n", "8kv8MqZ1nLo=\n");
                                                                    boolean z28 = AbstractC3331m.f11244b;
                                                                    Log.m5049i(strM165s40, strM165s41);
                                                                    break;
                                                                case 98:
                                                                    String strM165s42 = AbstractC0032a.m165s("nPDn1LHf\n", "3qOqtdixa6M=\n");
                                                                    String strM165s43 = AbstractC0032a.m165s("y1uhhgcFxoume4SwKDb84cp/i7A0PeD+y26esDIr7P8=\n", "hj7S9WZio7E=\n");
                                                                    boolean z29 = AbstractC3331m.f11244b;
                                                                    Log.m5049i(strM165s42, strM165s43);
                                                                    break;
                                                                case 99:
                                                                    String strM165s44 = AbstractC0032a.m165s("T3miKwFP\n", "DSrvSmghRTU=\n");
                                                                    String strM165s45 = AbstractC0032a.m165s("Id4jw9+sBHNM/gb18J8+GiT0B+/7mTMGPg==\n", "bLtQsL7LYUk=\n");
                                                                    boolean z30 = AbstractC3331m.f11244b;
                                                                    Log.m5049i(strM165s44, strM165s45);
                                                                    if (this.f8662a.m6712c0() && C3663f.m7415b().m7417c() && !Spark.f11011g2) {
                                                                        this.f8662a.m6709Z();
                                                                        if (!C3663f.m7415b().m7418d()) {
                                                                            C3663f c3663fM7415b = C3663f.m7415b();
                                                                            if (c3663fM7415b.f12272e != null) {
                                                                                if (c3663fM7415b.m7418d()) {
                                                                                    c3663fM7415b.f12273f = 0;
                                                                                } else {
                                                                                    c3663fM7415b.f12273f++;
                                                                                }
                                                                                c3663fM7415b.m7420f(c3663fM7415b.f12272e, Boolean.valueOf(c3663fM7415b.f12274g), c3663fM7415b.f12273f, c3663fM7415b.f12279l);
                                                                            }
                                                                        } else {
                                                                            Spark.m6666N(this.f8662a, message.arg1);
                                                                            C3663f.m7415b().m7416a();
                                                                        }
                                                                    } else {
                                                                        Spark.m6666N(this.f8662a, message.arg1);
                                                                    }
                                                                    break;
                                                                case 100:
                                                                    String strM165s46 = AbstractC0032a.m165s("jQvDNG/r\n", "z1iOVQaFl2s=\n");
                                                                    String strM165s47 = AbstractC0032a.m165s("uaMBPmuLqV7UgyQIRLiTLL2CNxJHqYIx\n", "9MZyTQrszGQ=\n");
                                                                    boolean z31 = AbstractC3331m.f11244b;
                                                                    Log.m5049i(strM165s46, strM165s47);
                                                                    if (this.f8662a.f11135p1.isShown()) {
                                                                        this.f8662a.m6709Z();
                                                                    }
                                                                    this.f8662a.m6697M0(false);
                                                                    break;
                                                                case 101:
                                                                    String strM165s48 = AbstractC0032a.m165s("tu/EJ7oQ\n", "9LyJRtN+yUQ=\n");
                                                                    String strM165s49 = AbstractC0032a.m165s("kuvp/Y7vjeT/y8zLody3jZfBzdGizaaL\n", "346aju+I6N4=\n");
                                                                    boolean z32 = AbstractC3331m.f11244b;
                                                                    Log.m5049i(strM165s48, strM165s49);
                                                                    Spark spark18 = this.f8662a;
                                                                    HandlerC2468u handlerC2468u5 = Spark.f11002X1;
                                                                    spark18.m6697M0(true);
                                                                    break;
                                                                default:
                                                                    switch (i10) {
                                                                        case 105:
                                                                            String strM165s50 = AbstractC0032a.m165s("q+n7ys7s\n", "6bq2q6eCPMQ=\n");
                                                                            String strM165s51 = AbstractC0032a.m165s("2t/OiDCSJl+3/+u+H6EcI9j56KgOowwhyPjorwW6DQ==\n", "l7q9+1H1Q2U=\n");
                                                                            boolean z33 = AbstractC3331m.f11244b;
                                                                            Log.m5049i(strM165s50, strM165s51);
                                                                            this.f8662a.m6731x0(Boolean.TRUE);
                                                                            AbstractC3280d.m6606y(this.f8662a.f11036C);
                                                                            this.f8662a.f11036C.setChecked(true);
                                                                            break;
                                                                        case 106:
                                                                            String strM165s52 = AbstractC0032a.m165s("2+TKvdWN\n", "mbeH3LzjRW4=\n");
                                                                            String strM165s53 = AbstractC0032a.m165s("pkyIzkIuf9PLbK34bR1Fr6Rqru58CEq5uHa56HcdVac=\n", "6yn7vSNJGuk=\n");
                                                                            boolean z34 = AbstractC3331m.f11244b;
                                                                            Log.m5049i(strM165s52, strM165s53);
                                                                            AbstractC3280d.m6606y(this.f8662a.f11045F);
                                                                            this.f8662a.f11045F.setChecked(true);
                                                                            break;
                                                                        case 107:
                                                                            String strM165s54 = AbstractC0032a.m165s("RI4XagS0\n", "Bt1aC23aKfg=\n");
                                                                            String strM165s55 = AbstractC0032a.m165s("6EK6N75LSTmFYp8BkXhzRepknBeAf2lC92SBG5p4\n", "pSfJRN8sLAM=\n");
                                                                            boolean z35 = AbstractC3331m.f11244b;
                                                                            Log.m5049i(strM165s54, strM165s55);
                                                                            ViewOnKeyListenerC2932m0 viewOnKeyListenerC2932m4 = this.f8662a.f11057J;
                                                                            if (viewOnKeyListenerC2932m4.f9959W != null && ViewOnKeyListenerC2932m0.f9952G0) {
                                                                                AbstractC3280d.m6606y(viewOnKeyListenerC2932m4.f9974m0);
                                                                            }
                                                                            break;
                                                                        case 108:
                                                                            String strM165s56 = AbstractC0032a.m165s("RePDENMC\n", "B7COcbpsv1U=\n");
                                                                            String strM165s57 = AbstractC0032a.m165s("1tbmeUbXXqW79sNPaeRk2dTwwFl4437eyfDdVWXkdQ==\n", "m7OVCiewO58=\n");
                                                                            boolean z36 = AbstractC3331m.f11244b;
                                                                            Log.m5049i(strM165s56, strM165s57);
                                                                            this.f8662a.m6723o0();
                                                                            break;
                                                                        default:
                                                                            switch (i10) {
                                                                                case 110:
                                                                                    String strM165s58 = AbstractC0032a.m165s("RxxOdX1R\n", "BU8DFBQ/u10=\n");
                                                                                    String strM165s59 = AbstractC0032a.m165s("NaiOuZFdZpRYiKuPvm5c6DeOqJmvfkboOZixnq93RuAt\n", "eM39yvA6A64=\n");
                                                                                    boolean z37 = AbstractC3331m.f11244b;
                                                                                    Log.m5049i(strM165s58, strM165s59);
                                                                                    Spark.f11005a2 = true;
                                                                                    this.f8662a.f11108c0.setVisibility(8);
                                                                                    this.f8662a.m6707W();
                                                                                    ViewOnKeyListenerC2925j viewOnKeyListenerC2925j3 = this.f8662a.f11069N;
                                                                                    if (viewOnKeyListenerC2925j3 != null && (view2 = viewOnKeyListenerC2925j3.f9926U) != null) {
                                                                                        view2.findViewById(R.id.home_loading_text).setVisibility(8);
                                                                                        viewOnKeyListenerC2925j3.f9927V.setFocusable(true);
                                                                                        viewOnKeyListenerC2925j3.f9927V.setFocusableInTouchMode(true);
                                                                                    }
                                                                                    this.f8662a.m6716g0(0);
                                                                                    break;
                                                                                case 111:
                                                                                    String strM165s60 = AbstractC0032a.m165s("JT3NymSi\n", "Z26Aqw3Mf/U=\n");
                                                                                    String strM165s61 = AbstractC0032a.m165s("sEWSjKZrHnrdZbe6iVgkBrJjtKyYQDIWuH+jqpNYNA4=\n", "/SDh/8cMe0A=\n");
                                                                                    boolean z38 = AbstractC3331m.f11244b;
                                                                                    Log.m5049i(strM165s60, strM165s61);
                                                                                    AbstractC3280d.m6606y(this.f8662a.f11033B);
                                                                                    this.f8662a.f11033B.setChecked(true);
                                                                                    break;
                                                                                case 112:
                                                                                    String strM165s62 = AbstractC0032a.m165s("/FnMaYU7\n", "vgqBCOxVtUs=\n");
                                                                                    String strM165s63 = AbstractC0032a.m165s("XQVIkAJ61jwwJW2mLUnsQF8jbrA8VfpVRC9pujxf5lJEL3U=\n", "EGA742MdswY=\n");
                                                                                    boolean z39 = AbstractC3331m.f11244b;
                                                                                    Log.m5049i(strM165s62, strM165s63);
                                                                                    this.f8662a.m6731x0(Boolean.TRUE);
                                                                                    AbstractC3280d.m6606y(this.f8662a.f11039D);
                                                                                    this.f8662a.f11039D.setChecked(true);
                                                                                    break;
                                                                                case 113:
                                                                                    String strM165s64 = AbstractC0032a.m165s("7j1CnrMv\n", "rG4P/9pBYa8=\n");
                                                                                    String strM165s65 = AbstractC0032a.m165s("pxAuATmYUAfKMAs3Fqtqe6U2CCEHrHBpvjwTNQe9YGm+OhM=\n", "6nVdclj/NT0=\n");
                                                                                    boolean z40 = AbstractC3331m.f11244b;
                                                                                    Log.m5049i(strM165s64, strM165s65);
                                                                                    this.f8662a.m6731x0(Boolean.TRUE);
                                                                                    AbstractC3280d.m6606y(this.f8662a.f11048G);
                                                                                    this.f8662a.f11048G.setChecked(true);
                                                                                    break;
                                                                                case 114:
                                                                                    this.f8662a.getClass();
                                                                                    if (Spark.f11003Y1 != null && C2626i.m5634c(C2626i.f9124e.toArray()).isEmpty()) {
                                                                                        Spark.f11003Y1.getClass();
                                                                                        if (!C2626i.m5634c(C2626i.f9125f.toArray()).isEmpty()) {
                                                                                            this.f8662a.f11039D.setNextFocusRightId(-1);
                                                                                        } else {
                                                                                            this.f8662a.f11039D.setNextFocusRightId(R.id.rb_history);
                                                                                        }
                                                                                    } else {
                                                                                        this.f8662a.f11039D.setNextFocusRightId(-1);
                                                                                    }
                                                                                    break;
                                                                            }
                                                                            break;
                                                                    }
                                                                    break;
                                                            }
                                                            break;
                                                    }
                                                    break;
                                            }
                                            break;
                                    }
                                    break;
                            }
                            break;
                    }
                    break;
            }
        } else {
            String strM165s66 = AbstractC0032a.m165s("Uvw8KRzv\n", "EK9xSHWBdvg=\n");
            String strM165s67 = AbstractC0032a.m165s("vURvUvJmg+7QZERox161jaN1WWw=\n", "8CEcIZMB5tQ=\n");
            boolean z41 = AbstractC3331m.f11244b;
            Log.m5049i(strM165s66, strM165s67);
            C3663f c3663fM7415b2 = C3663f.m7415b();
            c3663fM7415b2.getClass();
            AbstractC3331m.m6764n(c3663fM7415b2.f12268a, new C3004k().m6083e(c3663fM7415b2.f12270c));
            C3663f c3663fM7415b3 = C3663f.m7415b();
            c3663fM7415b3.getClass();
            AbstractC3331m.m6764n(c3663fM7415b3.f12269b, new C3004k().m6083e(c3663fM7415b3.f12271d));
            Spark spark19 = this.f8662a;
            HandlerC2468u handlerC2468u6 = Spark.f11002X1;
            spark19.m6721m0();
        }
        super.handleMessage(message);
    }
}
