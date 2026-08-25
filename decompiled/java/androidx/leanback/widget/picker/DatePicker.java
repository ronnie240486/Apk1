package androidx.leanback.widget.picker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import android.util.Log;
import com.p2serv.android.p032ds.R;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import p000a.RunnableC0005f;
import p007a7.C0069f;
import p075h1.AbstractC2639a;
import p084i1.C2681d;
import p138n0.AbstractC3155s0;
import p143n5.AbstractC3198d;

public class DatePicker extends Picker {

    public static final int[] f2388C = {5, 2, 1};

    public final Calendar f2389A;

    public final Calendar f2390B;

    public String f2391p;

    public C2681d f2392q;

    public C2681d f2393r;

    public C2681d f2394s;

    public int f2395t;

    public int f2396u;

    public int f2397v;

    public final SimpleDateFormat f2398w;

    public final C0069f f2399x;

    public final Calendar f2400y;

    public final Calendar f2401z;

    public DatePicker(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.datePickerStyle);
    }

    @Override
    public final void mo1455a(int i6, int i10) {
        this.f2390B.setTimeInMillis(this.f2389A.getTimeInMillis());
        ArrayList arrayList = this.f2404c;
        int i11 = (arrayList == null ? null : (C2681d) arrayList.get(i6)).f9321a;
        if (i6 == this.f2396u) {
            this.f2390B.add(5, i10 - i11);
        } else if (i6 == this.f2395t) {
            this.f2390B.add(2, i10 - i11);
        } else {
            if (i6 != this.f2397v) {
                throw new IllegalArgumentException();
            }
            this.f2390B.add(1, i10 - i11);
        }
        m1457j(this.f2390B.get(1), this.f2390B.get(2), this.f2390B.get(5));
    }

    public long getDate() {
        return this.f2389A.getTimeInMillis();
    }

    public String getDatePickerFormat() {
        return this.f2391p;
    }

    public long getMaxDate() {
        return this.f2401z.getTimeInMillis();
    }

    public long getMinDate() {
        return this.f2400y.getTimeInMillis();
    }

    public final boolean m1456i(String str, Calendar calendar) {
        try {
            calendar.setTime(this.f2398w.parse(str));
            return true;
        } catch (ParseException unused) {
            Log.w("DatePicker", "Date: " + str + " not in format: MM/dd/yyyy");
            return false;
        }
    }

    public final void m1457j(int i6, int i10, int i11) {
        if (this.f2389A.get(1) == i6 && this.f2389A.get(2) == i11 && this.f2389A.get(5) == i10) {
            return;
        }
        this.f2389A.set(i6, i10, i11);
        if (this.f2389A.before(this.f2400y)) {
            this.f2389A.setTimeInMillis(this.f2400y.getTimeInMillis());
        } else if (this.f2389A.after(this.f2401z)) {
            this.f2389A.setTimeInMillis(this.f2401z.getTimeInMillis());
        }
        post(new RunnableC0005f(19, this));
    }

    public void setDate(long j10) {
        this.f2390B.setTimeInMillis(j10);
        m1457j(this.f2390B.get(1), this.f2390B.get(2), this.f2390B.get(5));
    }

    public void setDatePickerFormat(String str) {
        int i6 = 6;
        C0069f c0069f = this.f2399x;
        String str2 = TextUtils.isEmpty(str) ? new String(DateFormat.getDateFormatOrder(getContext())) : str;
        if (TextUtils.equals(this.f2391p, str2)) {
            return;
        }
        this.f2391p = str2;
        String bestDateTimePattern = DateFormat.getBestDateTimePattern((Locale) c0069f.f196b, str2);
        if (TextUtils.isEmpty(bestDateTimePattern)) {
            bestDateTimePattern = "MM/dd/yyyy";
        }
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        char[] cArr = {'Y', 'y', 'M', 'm', 'D', 'd'};
        int i10 = 0;
        boolean z7 = false;
        char c5 = 0;
        while (i10 < bestDateTimePattern.length()) {
            char cCharAt = bestDateTimePattern.charAt(i10);
            if (cCharAt != ' ') {
                if (cCharAt != '\'') {
                    if (!z7) {
                        int i11 = 0;
                        while (true) {
                            if (i11 >= i6) {
                                sb.append(cCharAt);
                                break;
                            }
                            if (cCharAt == cArr[i11]) {
                                if (cCharAt == c5) {
                                    break;
                                }
                                arrayList.add(sb.toString());
                                sb.setLength(0);
                                break;
                            }
                            i11++;
                            i6 = 6;
                        }
                    } else {
                        sb.append(cCharAt);
                    }
                    c5 = cCharAt;
                } else if (z7) {
                    z7 = false;
                } else {
                    sb.setLength(0);
                    z7 = true;
                }
            }
            i10++;
            i6 = 6;
        }
        arrayList.add(sb.toString());
        if (arrayList.size() != str2.length() + 1) {
            throw new IllegalStateException("Separators size: " + arrayList.size() + " must equal the size of datePickerFormat: " + str2.length() + " + 1");
        }
        setSeparators(arrayList);
        this.f2393r = null;
        this.f2392q = null;
        this.f2394s = null;
        this.f2395t = -1;
        this.f2396u = -1;
        this.f2397v = -1;
        String upperCase = str2.toUpperCase((Locale) c0069f.f196b);
        ArrayList arrayList2 = new ArrayList(3);
        for (int i12 = 0; i12 < upperCase.length(); i12++) {
            char cCharAt2 = upperCase.charAt(i12);
            if (cCharAt2 == 'D') {
                if (this.f2393r != null) {
                    throw new IllegalArgumentException("datePicker format error");
                }
                C2681d c2681d = new C2681d();
                this.f2393r = c2681d;
                arrayList2.add(c2681d);
                this.f2393r.f9325e = "%02d";
                this.f2396u = i12;
            } else if (cCharAt2 != 'M') {
                if (cCharAt2 != 'Y') {
                    throw new IllegalArgumentException("datePicker format error");
                }
                if (this.f2394s != null) {
                    throw new IllegalArgumentException("datePicker format error");
                }
                C2681d c2681d2 = new C2681d();
                this.f2394s = c2681d2;
                arrayList2.add(c2681d2);
                this.f2397v = i12;
                this.f2394s.f9325e = "%d";
            } else {
                if (this.f2392q != null) {
                    throw new IllegalArgumentException("datePicker format error");
                }
                C2681d c2681d3 = new C2681d();
                this.f2392q = c2681d3;
                arrayList2.add(c2681d3);
                this.f2392q.f9324d = (String[]) c0069f.f197c;
                this.f2395t = i12;
            }
        }
        setColumns(arrayList2);
        post(new RunnableC0005f(19, this));
    }

    public void setMaxDate(long j10) {
        this.f2390B.setTimeInMillis(j10);
        if (this.f2390B.get(1) != this.f2401z.get(1) || this.f2390B.get(6) == this.f2401z.get(6)) {
            this.f2401z.setTimeInMillis(j10);
            if (this.f2389A.after(this.f2401z)) {
                this.f2389A.setTimeInMillis(this.f2401z.getTimeInMillis());
            }
            post(new RunnableC0005f(19, this));
        }
    }

    public void setMinDate(long j10) {
        this.f2390B.setTimeInMillis(j10);
        if (this.f2390B.get(1) != this.f2400y.get(1) || this.f2390B.get(6) == this.f2400y.get(6)) {
            this.f2400y.setTimeInMillis(j10);
            if (this.f2389A.before(this.f2400y)) {
                this.f2389A.setTimeInMillis(this.f2400y.getTimeInMillis());
            }
            post(new RunnableC0005f(19, this));
        }
    }

    @SuppressLint({"CustomViewStyleable"})
    public DatePicker(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f2398w = new SimpleDateFormat("MM/dd/yyyy", Locale.getDefault());
        Locale locale = Locale.getDefault();
        getContext().getResources();
        this.f2399x = new C0069f(locale);
        this.f2390B = AbstractC3198d.m6472t(this.f2390B, locale);
        this.f2400y = AbstractC3198d.m6472t(this.f2400y, (Locale) this.f2399x.f196b);
        this.f2401z = AbstractC3198d.m6472t(this.f2401z, (Locale) this.f2399x.f196b);
        this.f2389A = AbstractC3198d.m6472t(this.f2389A, (Locale) this.f2399x.f196b);
        C2681d c2681d = this.f2392q;
        if (c2681d != null) {
            c2681d.f9324d = (String[]) this.f2399x.f197c;
            m1458b(this.f2395t, c2681d);
        }
        int[] iArr = AbstractC2639a.f9161e;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        AbstractC3155s0.m6346p(this, context, iArr, attributeSet, typedArrayObtainStyledAttributes, 0, 0);
        try {
            String string = typedArrayObtainStyledAttributes.getString(0);
            String string2 = typedArrayObtainStyledAttributes.getString(1);
            String string3 = typedArrayObtainStyledAttributes.getString(2);
            typedArrayObtainStyledAttributes.recycle();
            this.f2390B.clear();
            if (TextUtils.isEmpty(string) || !m1456i(string, this.f2390B)) {
                this.f2390B.set(1900, 0, 1);
            }
            this.f2400y.setTimeInMillis(this.f2390B.getTimeInMillis());
            this.f2390B.clear();
            if (TextUtils.isEmpty(string2) || !m1456i(string2, this.f2390B)) {
                this.f2390B.set(2100, 0, 1);
            }
            this.f2401z.setTimeInMillis(this.f2390B.getTimeInMillis());
            setDatePickerFormat(TextUtils.isEmpty(string3) ? new String(DateFormat.getDateFormatOrder(context)) : string3);
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }
}
