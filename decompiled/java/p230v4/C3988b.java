package p230v4;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import java.util.Locale;
import p000a.AbstractC0004e;
import p018b5.AbstractC1312l;

public final class C3988b {

    public final String f13521a;

    public final boolean f13522b;

    public final String f13523c;

    public C3988b(String str, String str2) {
        AbstractC1312l.m3197d(str, "The log tag cannot be null or empty.");
        this.f13521a = str;
        this.f13523c = str2;
        this.f13522b = str.length() <= 23;
    }

    public final void m7974a(Exception exc, String str, Object... objArr) {
        if (Build.TYPE.equals("user") || !this.f13522b) {
            return;
        }
        String str2 = this.f13521a;
        if (Log.isLoggable(str2, 3)) {
            Log.d(str2, m7977d(str, objArr), exc);
        }
    }

    public final void m7975b(String str, Object... objArr) {
        if (Build.TYPE.equals("user") || !this.f13522b) {
            return;
        }
        String str2 = this.f13521a;
        if (Log.isLoggable(str2, 3)) {
            Log.d(str2, m7977d(str, objArr));
        }
    }

    public final void m7976c(Object... objArr) {
        Log.e(this.f13521a, m7977d("Bundle is null", objArr));
    }

    public final String m7977d(String str, Object... objArr) {
        if (objArr.length != 0) {
            str = String.format(Locale.ROOT, str, objArr);
        }
        String str2 = this.f13523c;
        String strM24r = TextUtils.isEmpty(str2) ? "" : AbstractC0004e.m24r("[", str2, "] ");
        return !TextUtils.isEmpty(strM24r) ? strM24r.concat(String.valueOf(str)) : str;
    }
}
