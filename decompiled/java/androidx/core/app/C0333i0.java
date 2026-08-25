package androidx.core.app;

import android.app.Notification;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.media.session.AbstractC0120b;
import androidx.media3.exoplayer.rtsp.SessionDescription;
import java.util.ArrayList;

public final class C0333i0 {

    public final CharSequence f1505a;

    public final long f1506b;

    public final C0318b1 f1507c;

    public final Bundle f1508d = new Bundle();

    public String f1509e;

    public Uri f1510f;

    public C0333i0(CharSequence charSequence, long j10, C0318b1 c0318b1) {
        this.f1505a = charSequence;
        this.f1506b = j10;
        this.f1507c = c0318b1;
    }

    public static Bundle[] m969a(ArrayList arrayList) {
        Bundle[] bundleArr = new Bundle[arrayList.size()];
        int size = arrayList.size();
        for (int i6 = 0; i6 < size; i6++) {
            C0333i0 c0333i0 = (C0333i0) arrayList.get(i6);
            c0333i0.getClass();
            Bundle bundle = new Bundle();
            CharSequence charSequence = c0333i0.f1505a;
            if (charSequence != null) {
                bundle.putCharSequence("text", charSequence);
            }
            bundle.putLong("time", c0333i0.f1506b);
            C0318b1 c0318b1 = c0333i0.f1507c;
            if (c0318b1 != null) {
                bundle.putCharSequence("sender", c0318b1.f1481a);
                if (Build.VERSION.SDK_INT >= 28) {
                    bundle.putParcelable("sender_person", AbstractC0331h0.m965a(AbstractC0315a1.m946b(c0318b1)));
                } else {
                    bundle.putBundle("person", c0318b1.m949b());
                }
            }
            String str = c0333i0.f1509e;
            if (str != null) {
                bundle.putString(SessionDescription.ATTR_TYPE, str);
            }
            Uri uri = c0333i0.f1510f;
            if (uri != null) {
                bundle.putParcelable("uri", uri);
            }
            Bundle bundle2 = c0333i0.f1508d;
            if (bundle2 != null) {
                bundle.putBundle("extras", bundle2);
            }
            bundleArr[i6] = bundle;
        }
        return bundleArr;
    }

    public static ArrayList m970b(Parcelable[] parcelableArr) {
        C0318b1 c0318b1M945a;
        ArrayList arrayList = new ArrayList(parcelableArr.length);
        for (Parcelable parcelable : parcelableArr) {
            if (parcelable instanceof Bundle) {
                Bundle bundle = (Bundle) parcelable;
                C0333i0 c0333i0 = null;
                try {
                    if (bundle.containsKey("text") && bundle.containsKey("time")) {
                        if (bundle.containsKey("person")) {
                            c0318b1M945a = C0318b1.m948a(bundle.getBundle("person"));
                        } else if (bundle.containsKey("sender_person") && Build.VERSION.SDK_INT >= 28) {
                            c0318b1M945a = AbstractC0315a1.m945a(AbstractC0120b.m332d(bundle.getParcelable("sender_person")));
                        } else if (bundle.containsKey("sender")) {
                            CharSequence charSequence = bundle.getCharSequence("sender");
                            C0318b1 c0318b1 = new C0318b1();
                            c0318b1.f1481a = charSequence;
                            c0318b1.f1482b = null;
                            c0318b1.f1483c = null;
                            c0318b1.f1484d = null;
                            c0318b1.f1485e = false;
                            c0318b1.f1486f = false;
                            c0318b1M945a = c0318b1;
                        } else {
                            c0318b1M945a = null;
                        }
                        C0333i0 c0333i1 = new C0333i0(bundle.getCharSequence("text"), bundle.getLong("time"), c0318b1M945a);
                        if (bundle.containsKey(SessionDescription.ATTR_TYPE) && bundle.containsKey("uri")) {
                            String string = bundle.getString(SessionDescription.ATTR_TYPE);
                            Uri uri = (Uri) bundle.getParcelable("uri");
                            c0333i1.f1509e = string;
                            c0333i1.f1510f = uri;
                        }
                        if (bundle.containsKey("extras")) {
                            c0333i1.f1508d.putAll(bundle.getBundle("extras"));
                        }
                        c0333i0 = c0333i1;
                    }
                } catch (ClassCastException unused) {
                }
                if (c0333i0 != null) {
                    arrayList.add(c0333i0);
                }
            }
        }
        return arrayList;
    }

    public final Notification.MessagingStyle.Message m971c() {
        Notification.MessagingStyle.Message messageM963a;
        int i6 = Build.VERSION.SDK_INT;
        long j10 = this.f1506b;
        CharSequence charSequence = this.f1505a;
        C0318b1 c0318b1 = this.f1507c;
        if (i6 >= 28) {
            messageM963a = AbstractC0331h0.m966b(charSequence, j10, c0318b1 != null ? AbstractC0315a1.m946b(c0318b1) : null);
        } else {
            messageM963a = AbstractC0329g0.m963a(charSequence, j10, c0318b1 != null ? c0318b1.f1481a : null);
        }
        String str = this.f1509e;
        if (str != null) {
            AbstractC0329g0.m964b(messageM963a, str, this.f1510f);
        }
        return messageM963a;
    }
}
