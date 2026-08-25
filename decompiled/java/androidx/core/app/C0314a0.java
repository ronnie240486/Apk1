package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.media.AbstractC0107a;
import android.support.v4.media.session.AbstractC0120b;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import androidx.core.graphics.drawable.IconCompat;
import com.p2serv.android.p032ds.R;
import p222u7.AbstractC3928d;

public final class C0314a0 extends AbstractC0337k0 {

    public int f1471a;

    public C0318b1 f1472b;

    public PendingIntent f1473c;

    public PendingIntent f1474d;

    public PendingIntent f1475e;

    public boolean f1476f;

    public Integer f1477g;

    public Integer f1478h;

    public IconCompat f1479i;

    public CharSequence f1480j;

    @Override
    public final void addCompatExtras(Bundle bundle) {
        super.addCompatExtras(bundle);
        bundle.putInt("android.callType", this.f1471a);
        bundle.putBoolean("android.callIsVideo", this.f1476f);
        C0318b1 c0318b1 = this.f1472b;
        if (c0318b1 != null) {
            if (Build.VERSION.SDK_INT >= 28) {
                c0318b1.getClass();
                bundle.putParcelable("android.callPerson", AbstractC0364y.m1067b(AbstractC0315a1.m946b(c0318b1)));
            } else {
                bundle.putParcelable("android.callPersonCompat", c0318b1.m949b());
            }
        }
        IconCompat iconCompat = this.f1479i;
        if (iconCompat != null) {
            if (Build.VERSION.SDK_INT >= 23) {
                bundle.putParcelable("android.verificationIcon", AbstractC0362x.m1063a(iconCompat.m1096n(this.mBuilder.f1552a)));
            } else {
                bundle.putParcelable("android.verificationIconCompat", iconCompat.m1095m());
            }
        }
        bundle.putCharSequence("android.verificationText", this.f1480j);
        bundle.putParcelable("android.answerIntent", this.f1473c);
        bundle.putParcelable("android.declineIntent", this.f1474d);
        bundle.putParcelable("android.hangUpIntent", this.f1475e);
        Integer num = this.f1477g;
        if (num != null) {
            bundle.putInt("android.answerColor", num.intValue());
        }
        Integer num2 = this.f1478h;
        if (num2 != null) {
            bundle.putInt("android.declineColor", num2.intValue());
        }
    }

    @Override
    public final void apply(InterfaceC0342n interfaceC0342n) {
        IconCompat iconCompat;
        int i6 = Build.VERSION.SDK_INT;
        String string = null;
        callStyleM1070a = null;
        Notification.CallStyle callStyleM1070a = null;
        if (i6 < 31) {
            C0355t0 c0355t0 = (C0355t0) interfaceC0342n;
            C0318b1 c0318b1 = this.f1472b;
            CharSequence charSequence = c0318b1 != null ? c0318b1.f1481a : null;
            Notification.Builder builder = c0355t0.f1546b;
            builder.setContentTitle(charSequence);
            Bundle bundle = this.mBuilder.f1572u;
            CharSequence charSequence2 = (bundle == null || !bundle.containsKey("android.text")) ? null : this.mBuilder.f1572u.getCharSequence("android.text");
            if (charSequence2 == null) {
                int i10 = this.f1471a;
                if (i10 == 1) {
                    string = this.mBuilder.f1552a.getResources().getString(R.string.call_notification_incoming_text);
                } else if (i10 == 2) {
                    string = this.mBuilder.f1552a.getResources().getString(R.string.call_notification_ongoing_text);
                } else if (i10 == 3) {
                    string = this.mBuilder.f1552a.getResources().getString(R.string.call_notification_screening_text);
                }
                charSequence2 = string;
            }
            builder.setContentText(charSequence2);
            C0318b1 c0318b2 = this.f1472b;
            if (c0318b2 != null) {
                if (i6 >= 23 && (iconCompat = c0318b2.f1482b) != null) {
                    AbstractC0362x.m1065c(builder, iconCompat.m1096n(this.mBuilder.f1552a));
                }
                if (i6 >= 28) {
                    C0318b1 c0318b3 = this.f1472b;
                    c0318b3.getClass();
                    AbstractC0364y.m1066a(builder, AbstractC0315a1.m946b(c0318b3));
                } else {
                    AbstractC0360w.m1061a(builder, this.f1472b.f1483c);
                }
            }
            AbstractC0360w.m1062b(builder, "call");
            return;
        }
        int i11 = this.f1471a;
        if (i11 == 1) {
            C0318b1 c0318b4 = this.f1472b;
            c0318b4.getClass();
            callStyleM1070a = AbstractC0366z.m1070a(AbstractC0315a1.m946b(c0318b4), this.f1474d, this.f1473c);
        } else if (i11 == 2) {
            C0318b1 c0318b5 = this.f1472b;
            c0318b5.getClass();
            callStyleM1070a = AbstractC0366z.m1071b(AbstractC0315a1.m946b(c0318b5), this.f1475e);
        } else if (i11 == 3) {
            C0318b1 c0318b6 = this.f1472b;
            c0318b6.getClass();
            callStyleM1070a = AbstractC0366z.m1072c(AbstractC0315a1.m946b(c0318b6), this.f1475e, this.f1473c);
        } else if (Log.isLoggable("NotifCompat", 3)) {
            Log.d("NotifCompat", "Unrecognized call type in CallStyle: " + String.valueOf(this.f1471a));
        }
        if (callStyleM1070a != null) {
            callStyleM1070a.setBuilder(((C0355t0) interfaceC0342n).f1546b);
            Integer num = this.f1477g;
            if (num != null) {
                AbstractC0366z.m1073d(callStyleM1070a, num.intValue());
            }
            Integer num2 = this.f1478h;
            if (num2 != null) {
                AbstractC0366z.m1075f(callStyleM1070a, num2.intValue());
            }
            AbstractC0366z.m1078i(callStyleM1070a, this.f1480j);
            IconCompat iconCompat2 = this.f1479i;
            if (iconCompat2 != null) {
                AbstractC0366z.m1077h(callStyleM1070a, iconCompat2.m1096n(this.mBuilder.f1552a));
            }
            AbstractC0366z.m1076g(callStyleM1070a, this.f1476f);
        }
    }

    public final C0346p m944c(int i6, int i10, Integer num, int i11, PendingIntent pendingIntent) {
        if (num == null) {
            num = Integer.valueOf(AbstractC3928d.m7847i(this.mBuilder.f1552a, i11));
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) this.mBuilder.f1552a.getResources().getString(i10));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(num.intValue()), 0, spannableStringBuilder.length(), 18);
        Context context = this.mBuilder.f1552a;
        PorterDuff.Mode mode = IconCompat.f1606k;
        context.getClass();
        C0346p c0346pM996a = new C0344o(IconCompat.m1087e(context.getResources(), context.getPackageName(), i6), spannableStringBuilder, pendingIntent, new Bundle()).m996a();
        c0346pM996a.f1531a.putBoolean("key_action_priority", true);
        return c0346pM996a;
    }

    @Override
    public final boolean displayCustomViewInline() {
        return true;
    }

    @Override
    public final String getClassName() {
        return "androidx.core.app.NotificationCompat$CallStyle";
    }

    @Override
    public final void restoreFromCompatExtras(Bundle bundle) {
        super.restoreFromCompatExtras(bundle);
        this.f1471a = bundle.getInt("android.callType");
        this.f1476f = bundle.getBoolean("android.callIsVideo");
        int i6 = Build.VERSION.SDK_INT;
        if (i6 >= 28 && bundle.containsKey("android.callPerson")) {
            this.f1472b = AbstractC0315a1.m945a(AbstractC0120b.m332d(bundle.getParcelable("android.callPerson")));
        } else if (bundle.containsKey("android.callPersonCompat")) {
            this.f1472b = C0318b1.m948a(bundle.getBundle("android.callPersonCompat"));
        }
        if (i6 >= 23 && bundle.containsKey("android.verificationIcon")) {
            this.f1479i = IconCompat.m1085c(AbstractC0107a.m268g(bundle.getParcelable("android.verificationIcon")));
        } else if (bundle.containsKey("android.verificationIconCompat")) {
            this.f1479i = IconCompat.m1084b(bundle.getBundle("android.verificationIconCompat"));
        }
        this.f1480j = bundle.getCharSequence("android.verificationText");
        this.f1473c = (PendingIntent) bundle.getParcelable("android.answerIntent");
        this.f1474d = (PendingIntent) bundle.getParcelable("android.declineIntent");
        this.f1475e = (PendingIntent) bundle.getParcelable("android.hangUpIntent");
        this.f1477g = bundle.containsKey("android.answerColor") ? Integer.valueOf(bundle.getInt("android.answerColor")) : null;
        this.f1478h = bundle.containsKey("android.declineColor") ? Integer.valueOf(bundle.getInt("android.declineColor")) : null;
    }
}
