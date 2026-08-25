package androidx.core.app;

import android.app.Notification;
import android.content.res.ColorStateList;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.media.AbstractC0108b;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import androidx.appcompat.app.C0157r0;
import java.util.ArrayList;
import java.util.Iterator;
import p055ea.AbstractC2460q;
import p118l0.AbstractC2959j;
import p118l0.C2951b;

public final class C0335j0 extends AbstractC0337k0 {

    public final ArrayList f1514a = new ArrayList();

    public final ArrayList f1515b = new ArrayList();

    public C0318b1 f1516c;

    public CharSequence f1517d;

    public Boolean f1518e;

    @Override
    public final void addCompatExtras(Bundle bundle) {
        super.addCompatExtras(bundle);
        bundle.putCharSequence("android.selfDisplayName", this.f1516c.f1481a);
        bundle.putBundle("android.messagingStyleUser", this.f1516c.m949b());
        bundle.putCharSequence("android.hiddenConversationTitle", this.f1517d);
        if (this.f1517d != null && this.f1518e.booleanValue()) {
            bundle.putCharSequence("android.conversationTitle", this.f1517d);
        }
        ArrayList arrayList = this.f1514a;
        if (!arrayList.isEmpty()) {
            bundle.putParcelableArray("android.messages", C0333i0.m969a(arrayList));
        }
        ArrayList arrayList2 = this.f1515b;
        if (!arrayList2.isEmpty()) {
            bundle.putParcelableArray("android.messages.historic", C0333i0.m969a(arrayList2));
        }
        Boolean bool = this.f1518e;
        if (bool != null) {
            bundle.putBoolean("android.isGroupConversation", bool.booleanValue());
        }
    }

    @Override
    public final void apply(InterfaceC0342n interfaceC0342n) {
        boolean zBooleanValue;
        C0333i0 c0333i0;
        boolean z7;
        Notification.MessagingStyle messagingStyleM951b;
        C0356u c0356u = this.mBuilder;
        if (c0356u == null || c0356u.f1552a.getApplicationInfo().targetSdkVersion >= 28 || this.f1518e != null) {
            Boolean bool = this.f1518e;
            if (bool != null) {
                zBooleanValue = bool.booleanValue();
            } else {
                zBooleanValue = false;
            }
        } else if (this.f1517d != null) {
            zBooleanValue = true;
        } else {
            zBooleanValue = false;
        }
        this.f1518e = Boolean.valueOf(zBooleanValue);
        int i6 = Build.VERSION.SDK_INT;
        ArrayList arrayList = this.f1514a;
        if (i6 >= 24) {
            if (i6 >= 28) {
                C0318b1 c0318b1 = this.f1516c;
                c0318b1.getClass();
                messagingStyleM951b = AbstractC0327f0.m958a(AbstractC0315a1.m946b(c0318b1));
            } else {
                messagingStyleM951b = AbstractC0323d0.m951b(this.f1516c.f1481a);
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                AbstractC0323d0.m950a(AbstractC0108b.m292a(messagingStyleM951b), ((C0333i0) it.next()).m971c());
            }
            if (Build.VERSION.SDK_INT >= 26) {
                Iterator it2 = this.f1515b.iterator();
                while (it2.hasNext()) {
                    AbstractC0325e0.m953a(AbstractC0108b.m292a(messagingStyleM951b), ((C0333i0) it2.next()).m971c());
                }
            }
            if (this.f1518e.booleanValue() || Build.VERSION.SDK_INT >= 28) {
                AbstractC0323d0.m952c(AbstractC0108b.m292a(messagingStyleM951b), this.f1517d);
            }
            if (Build.VERSION.SDK_INT >= 28) {
                AbstractC0327f0.m959b(AbstractC0108b.m292a(messagingStyleM951b), this.f1518e.booleanValue());
            }
            messagingStyleM951b.setBuilder(((C0355t0) interfaceC0342n).f1546b);
            return;
        }
        int size = arrayList.size() - 1;
        while (true) {
            if (size < 0) {
                if (arrayList.isEmpty()) {
                    c0333i0 = null;
                    break;
                } else {
                    c0333i0 = (C0333i0) AbstractC2460q.m5491e(1, arrayList);
                    break;
                }
            }
            c0333i0 = (C0333i0) arrayList.get(size);
            C0318b1 c0318b2 = c0333i0.f1507c;
            if (c0318b2 != null && !TextUtils.isEmpty(c0318b2.f1481a)) {
                break;
            } else {
                size--;
            }
        }
        if (this.f1517d != null && this.f1518e.booleanValue()) {
            ((C0355t0) interfaceC0342n).f1546b.setContentTitle(this.f1517d);
        } else if (c0333i0 != null) {
            Notification.Builder builder = ((C0355t0) interfaceC0342n).f1546b;
            builder.setContentTitle("");
            C0318b1 c0318b3 = c0333i0.f1507c;
            if (c0318b3 != null) {
                builder.setContentTitle(c0318b3.f1481a);
            }
        }
        if (c0333i0 != null) {
            ((C0355t0) interfaceC0342n).f1546b.setContentText(this.f1517d != null ? m973c(c0333i0) : c0333i0.f1505a);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.f1517d != null) {
            z7 = true;
            break;
        }
        int size2 = arrayList.size() - 1;
        while (true) {
            if (size2 < 0) {
                z7 = false;
                break;
            }
            C0318b1 c0318b4 = ((C0333i0) arrayList.get(size2)).f1507c;
            if (c0318b4 != null && c0318b4.f1481a == null) {
                z7 = true;
                break;
            }
            size2--;
        }
        for (int size3 = arrayList.size() - 1; size3 >= 0; size3--) {
            C0333i0 c0333i1 = (C0333i0) arrayList.get(size3);
            CharSequence charSequenceM973c = z7 ? m973c(c0333i1) : c0333i1.f1505a;
            if (size3 != arrayList.size() - 1) {
                spannableStringBuilder.insert(0, (CharSequence) "\n");
            }
            spannableStringBuilder.insert(0, charSequenceM973c);
        }
        new Notification.BigTextStyle(((C0355t0) interfaceC0342n).f1546b).setBigContentTitle(null).bigText(spannableStringBuilder);
    }

    public final SpannableStringBuilder m973c(C0333i0 c0333i0) {
        C2951b c2951bM5974c = C2951b.m5974c();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        C0318b1 c0318b1 = c0333i0.f1507c;
        CharSequence charSequence = c0318b1 == null ? "" : c0318b1.f1481a;
        int i6 = -16777216;
        if (TextUtils.isEmpty(charSequence)) {
            charSequence = this.f1516c.f1481a;
            int i10 = this.mBuilder.f1573v;
            if (i10 != 0) {
                i6 = i10;
            }
        }
        c2951bM5974c.getClass();
        C0157r0 c0157r0 = AbstractC2959j.f10137a;
        SpannableStringBuilder spannableStringBuilderM5975d = c2951bM5974c.m5975d(charSequence);
        spannableStringBuilder.append((CharSequence) spannableStringBuilderM5975d);
        spannableStringBuilder.setSpan(new TextAppearanceSpan(null, 0, 0, ColorStateList.valueOf(i6), null), spannableStringBuilder.length() - spannableStringBuilderM5975d.length(), spannableStringBuilder.length(), 33);
        CharSequence charSequence2 = c0333i0.f1505a;
        spannableStringBuilder.append((CharSequence) "  ").append((CharSequence) c2951bM5974c.m5975d(charSequence2 != null ? charSequence2 : ""));
        return spannableStringBuilder;
    }

    @Override
    public final void clearCompatExtraKeys(Bundle bundle) {
        super.clearCompatExtraKeys(bundle);
        bundle.remove("android.messagingStyleUser");
        bundle.remove("android.selfDisplayName");
        bundle.remove("android.conversationTitle");
        bundle.remove("android.hiddenConversationTitle");
        bundle.remove("android.messages");
        bundle.remove("android.messages.historic");
        bundle.remove("android.isGroupConversation");
    }

    @Override
    public final String getClassName() {
        return "androidx.core.app.NotificationCompat$MessagingStyle";
    }

    @Override
    public final void restoreFromCompatExtras(Bundle bundle) {
        super.restoreFromCompatExtras(bundle);
        ArrayList arrayList = this.f1514a;
        arrayList.clear();
        if (bundle.containsKey("android.messagingStyleUser")) {
            this.f1516c = C0318b1.m948a(bundle.getBundle("android.messagingStyleUser"));
        } else {
            String string = bundle.getString("android.selfDisplayName");
            C0318b1 c0318b1 = new C0318b1();
            c0318b1.f1481a = string;
            c0318b1.f1482b = null;
            c0318b1.f1483c = null;
            c0318b1.f1484d = null;
            c0318b1.f1485e = false;
            c0318b1.f1486f = false;
            this.f1516c = c0318b1;
        }
        CharSequence charSequence = bundle.getCharSequence("android.conversationTitle");
        this.f1517d = charSequence;
        if (charSequence == null) {
            this.f1517d = bundle.getCharSequence("android.hiddenConversationTitle");
        }
        Parcelable[] parcelableArray = bundle.getParcelableArray("android.messages");
        if (parcelableArray != null) {
            arrayList.addAll(C0333i0.m970b(parcelableArray));
        }
        Parcelable[] parcelableArray2 = bundle.getParcelableArray("android.messages.historic");
        if (parcelableArray2 != null) {
            this.f1515b.addAll(C0333i0.m970b(parcelableArray2));
        }
        if (bundle.containsKey("android.isGroupConversation")) {
            this.f1518e = Boolean.valueOf(bundle.getBoolean("android.isGroupConversation"));
        }
    }
}
