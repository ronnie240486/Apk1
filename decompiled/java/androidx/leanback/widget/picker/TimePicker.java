package androidx.leanback.widget.picker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.p2serv.android.p032ds.R;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import p001a0.C0023f;
import p055ea.AbstractC2460q;
import p075h1.AbstractC2639a;
import p084i1.C2681d;
import p138n0.AbstractC3155s0;

public class TimePicker extends Picker {

    public String f2417A;

    public C2681d f2418p;

    public C2681d f2419q;

    public C2681d f2420r;

    public int f2421s;

    public int f2422t;

    public int f2423u;

    public final C0023f f2424v;

    public boolean f2425w;

    public int f2426x;

    public int f2427y;

    public int f2428z;

    public TimePicker(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.timePickerStyle);
    }

    @Override
    public final void mo1455a(int i6, int i10) {
        if (i6 == this.f2421s) {
            this.f2426x = i10;
        } else if (i6 == this.f2422t) {
            this.f2427y = i10;
        } else {
            if (i6 != this.f2423u) {
                throw new IllegalArgumentException("Invalid column index.");
            }
            this.f2428z = i10;
        }
    }

    public String getBestHourMinutePattern() {
        String bestDateTimePattern = DateFormat.getBestDateTimePattern((Locale) this.f2424v.f44b, this.f2425w ? "Hma" : "hma");
        return TextUtils.isEmpty(bestDateTimePattern) ? "h:mma" : bestDateTimePattern;
    }

    public int getHour() {
        if (this.f2425w) {
            return this.f2426x;
        }
        return this.f2428z == 0 ? this.f2426x % 12 : (this.f2426x % 12) + 12;
    }

    public int getMinute() {
        return this.f2427y;
    }

    public final void m1465i() {
        int i6 = 7;
        String bestHourMinutePattern = getBestHourMinutePattern();
        if (TextUtils.equals(bestHourMinutePattern, this.f2417A)) {
            return;
        }
        this.f2417A = bestHourMinutePattern;
        String bestHourMinutePattern2 = getBestHourMinutePattern();
        C0023f c0023f = this.f2424v;
        boolean z7 = TextUtils.getLayoutDirectionFromLocale((Locale) c0023f.f44b) == 1;
        boolean z10 = bestHourMinutePattern2.indexOf(97) < 0 || bestHourMinutePattern2.indexOf(CmcdData.OBJECT_TYPE_AUDIO_ONLY) > bestHourMinutePattern2.indexOf(CmcdData.OBJECT_TYPE_MANIFEST);
        String strConcat = z7 ? "mh" : "hm";
        if (!this.f2425w) {
            strConcat = z10 ? strConcat.concat(CmcdData.OBJECT_TYPE_AUDIO_ONLY) : CmcdData.OBJECT_TYPE_AUDIO_ONLY.concat(strConcat);
        }
        String bestHourMinutePattern3 = getBestHourMinutePattern();
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        char[] cArr = {'H', 'h', 'K', 'k', 'm', 'M', 'a'};
        int i10 = 0;
        boolean z11 = false;
        char c5 = 0;
        while (i10 < bestHourMinutePattern3.length()) {
            char cCharAt = bestHourMinutePattern3.charAt(i10);
            if (cCharAt != ' ') {
                if (cCharAt != '\'') {
                    if (!z11) {
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
                            i6 = 7;
                        }
                    } else {
                        sb.append(cCharAt);
                    }
                    c5 = cCharAt;
                } else if (z11) {
                    z11 = false;
                } else {
                    sb.setLength(0);
                    z11 = true;
                }
            }
            i10++;
            i6 = 7;
        }
        arrayList.add(sb.toString());
        if (arrayList.size() != strConcat.length() + 1) {
            throw new IllegalStateException("Separators size: " + arrayList.size() + " must equal the size of timeFieldsPattern: " + strConcat.length() + " + 1");
        }
        setSeparators(arrayList);
        String upperCase = strConcat.toUpperCase((Locale) c0023f.f44b);
        this.f2420r = null;
        this.f2419q = null;
        this.f2418p = null;
        this.f2423u = -1;
        this.f2422t = -1;
        this.f2421s = -1;
        ArrayList arrayList2 = new ArrayList(3);
        for (int i12 = 0; i12 < upperCase.length(); i12++) {
            char cCharAt2 = upperCase.charAt(i12);
            if (cCharAt2 == 'A') {
                C2681d c2681d = new C2681d();
                this.f2420r = c2681d;
                arrayList2.add(c2681d);
                C2681d c2681d2 = this.f2420r;
                c2681d2.f9324d = (String[]) c0023f.f47e;
                this.f2423u = i12;
                if (c2681d2.f9322b != 0) {
                    c2681d2.f9322b = 0;
                }
                if (1 != c2681d2.f9323c) {
                    c2681d2.f9323c = 1;
                }
            } else if (cCharAt2 == 'H') {
                C2681d c2681d3 = new C2681d();
                this.f2418p = c2681d3;
                arrayList2.add(c2681d3);
                this.f2418p.f9324d = (String[]) c0023f.f45c;
                this.f2421s = i12;
            } else {
                if (cCharAt2 != 'M') {
                    throw new IllegalArgumentException("Invalid time picker format.");
                }
                C2681d c2681d4 = new C2681d();
                this.f2419q = c2681d4;
                arrayList2.add(c2681d4);
                this.f2419q.f9324d = (String[]) c0023f.f46d;
                this.f2422t = i12;
            }
        }
        setColumns(arrayList2);
    }

    public final void m1466j() {
        C2681d c2681d = this.f2418p;
        boolean z7 = this.f2425w;
        int i6 = !z7 ? 1 : 0;
        if (i6 != c2681d.f9322b) {
            c2681d.f9322b = i6;
        }
        int i10 = z7 ? 23 : 12;
        if (i10 != c2681d.f9323c) {
            c2681d.f9323c = i10;
        }
        C2681d c2681d2 = this.f2419q;
        if (c2681d2.f9322b != 0) {
            c2681d2.f9322b = 0;
        }
        if (59 != c2681d2.f9323c) {
            c2681d2.f9323c = 59;
        }
        C2681d c2681d3 = this.f2420r;
        if (c2681d3 != null) {
            if (c2681d3.f9322b != 0) {
                c2681d3.f9322b = 0;
            }
            if (1 != c2681d3.f9323c) {
                c2681d3.f9323c = 1;
            }
        }
    }

    public void setHour(int i6) {
        if (i6 < 0 || i6 > 23) {
            throw new IllegalArgumentException(AbstractC2460q.m5492f(i6, "hour: ", " is not in [0-23] range in"));
        }
        this.f2426x = i6;
        boolean z7 = this.f2425w;
        if (!z7) {
            if (i6 >= 12) {
                this.f2428z = 1;
                if (i6 > 12) {
                    this.f2426x = i6 - 12;
                }
            } else {
                this.f2428z = 0;
                if (i6 == 0) {
                    this.f2426x = 12;
                }
            }
            if (!z7) {
                m1459c(this.f2423u, this.f2428z);
            }
        }
        m1459c(this.f2421s, this.f2426x);
    }

    public void setIs24Hour(boolean z7) {
        if (this.f2425w == z7) {
            return;
        }
        int hour = getHour();
        int minute = getMinute();
        this.f2425w = z7;
        m1465i();
        m1466j();
        setHour(hour);
        setMinute(minute);
        if (this.f2425w) {
            return;
        }
        m1459c(this.f2423u, this.f2428z);
    }

    public void setMinute(int i6) {
        if (i6 < 0 || i6 > 59) {
            throw new IllegalArgumentException(AbstractC2460q.m5492f(i6, "minute: ", " is not in [0-59] range."));
        }
        this.f2427y = i6;
        m1459c(this.f2422t, i6);
    }

    @SuppressLint({"CustomViewStyleable"})
    public TimePicker(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        Locale locale = Locale.getDefault();
        context.getResources();
        this.f2424v = new C0023f(locale);
        int[] iArr = AbstractC2639a.f9168l;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        AbstractC3155s0.m6346p(this, context, iArr, attributeSet, typedArrayObtainStyledAttributes, 0, 0);
        try {
            this.f2425w = typedArrayObtainStyledAttributes.getBoolean(0, DateFormat.is24HourFormat(context));
            boolean z7 = typedArrayObtainStyledAttributes.getBoolean(3, true);
            typedArrayObtainStyledAttributes.recycle();
            m1465i();
            m1466j();
            if (z7) {
                Calendar calendar = Calendar.getInstance(locale);
                setHour(calendar.get(11));
                setMinute(calendar.get(12));
                if (this.f2425w) {
                    return;
                }
                m1459c(this.f2423u, this.f2428z);
            }
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }
}
