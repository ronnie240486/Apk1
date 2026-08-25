package com.google.android.material.datepicker;

import android.content.res.Resources;
import com.p2serv.android.p032ds.R;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicReference;

public abstract class AbstractC1787g0 {

    public static final AtomicReference f6165a = new AtomicReference();

    public static long m4192a(long j10) {
        Calendar calendarM4199h = m4199h(null);
        calendarM4199h.setTimeInMillis(j10);
        return m4194c(calendarM4199h).getTimeInMillis();
    }

    public static int m4193b(int i6, int i10, String str, String str2) {
        while (i10 >= 0 && i10 < str.length() && str2.indexOf(str.charAt(i10)) == -1) {
            if (str.charAt(i10) == '\'') {
                do {
                    i10 += i6;
                    if (i10 < 0 || i10 >= str.length()) {
                        break;
                    }
                } while (str.charAt(i10) != '\'');
            }
            i10 += i6;
        }
        return i10;
    }

    public static Calendar m4194c(Calendar calendar) {
        Calendar calendarM4199h = m4199h(calendar);
        Calendar calendarM4199h2 = m4199h(null);
        calendarM4199h2.set(calendarM4199h.get(1), calendarM4199h.get(2), calendarM4199h.get(5));
        return calendarM4199h2;
    }

    public static DateFormat m4195d(int i6, Locale locale) {
        DateFormat dateInstance = DateFormat.getDateInstance(i6, locale);
        dateInstance.setTimeZone(TimeZone.getTimeZone("UTC"));
        return dateInstance;
    }

    public static SimpleDateFormat m4196e() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(((SimpleDateFormat) DateFormat.getDateInstance(3, Locale.getDefault())).toPattern().replaceAll("\\s+", ""), Locale.getDefault());
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        simpleDateFormat.setLenient(false);
        return simpleDateFormat;
    }

    public static String m4197f(Resources resources, SimpleDateFormat simpleDateFormat) {
        String pattern = simpleDateFormat.toPattern();
        String string = resources.getString(R.string.mtrl_picker_text_input_year_abbr);
        String string2 = resources.getString(R.string.mtrl_picker_text_input_month_abbr);
        String string3 = resources.getString(R.string.mtrl_picker_text_input_day_abbr);
        if (pattern.replaceAll("[^y]", "").length() == 1) {
            pattern = pattern.replace("y", "yyyy");
        }
        return pattern.replace("d", string3).replace("M", string2).replace("y", string);
    }

    public static Calendar m4198g() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        calendar.setTimeZone(TimeZone.getTimeZone("UTC"));
        return calendar;
    }

    public static Calendar m4199h(Calendar calendar) {
        Calendar calendar2 = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        if (calendar == null) {
            calendar2.clear();
        } else {
            calendar2.setTimeInMillis(calendar.getTimeInMillis());
        }
        return calendar2;
    }
}
