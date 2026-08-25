package p241w4;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.images.WebImage;
import com.lzy.okgo.model.Progress;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p055ea.AbstractC2460q;
import p230v4.C3988b;

public abstract class AbstractC4052a {

    public static final C3988b f13717a = new C3988b("MetadataUtils", null);

    public static final String[] f13718b;

    public static final String f13719c;

    static {
        String[] strArr = {"Z", "+hh", "+hhmm", "+hh:mm"};
        f13718b = strArr;
        f13719c = "yyyyMMdd'T'HHmmss".concat(String.valueOf(strArr[0]));
    }

    public static Calendar m8055a(String str) {
        String strSubstring;
        int iIndexOf;
        int i6;
        String strSubstring2;
        char cCharAt;
        String[] strArr;
        int length;
        String str2;
        boolean zIsEmpty = TextUtils.isEmpty(str);
        C3988b c3988b = f13717a;
        if (zIsEmpty) {
            c3988b.m7975b("Input string is empty or null", new Object[0]);
            return null;
        }
        if (TextUtils.isEmpty(str)) {
            c3988b.m7975b("Input string is empty or null", new Object[0]);
        } else {
            try {
                strSubstring = str.substring(0, 8);
            } catch (IndexOutOfBoundsException e5) {
                Log.e(c3988b.f13521a, c3988b.m7977d("Error extracting the date", new Object[0]), e5);
                strSubstring = null;
            }
            if (TextUtils.isEmpty(strSubstring)) {
                c3988b.m7975b("Invalid date format", new Object[0]);
                return null;
            }
            try {
                if (TextUtils.isEmpty(str)) {
                    c3988b.m7975b("string is empty or null", new Object[0]);
                } else {
                    iIndexOf = str.indexOf(84);
                    i6 = iIndexOf + 1;
                    if (iIndexOf != 8) {
                        try {
                            strSubstring2 = str.substring(i6);
                            if (strSubstring2.length() != 6) {
                                cCharAt = strSubstring2.charAt(6);
                                strArr = f13718b;
                                if (cCharAt != '+' || cCharAt == '-') {
                                    length = strSubstring2.length();
                                    if (length != strArr[1].length() + 6 || length == strArr[2].length() + 6 || length == strArr[3].length() + 6) {
                                        strSubstring2 = strSubstring2.replaceAll("([\\+\\-]\\d\\d):(\\d\\d)", "$1$2");
                                    }
                                } else if (cCharAt == 'Z' && strSubstring2.length() == strArr[0].length() + 6) {
                                    strSubstring2 = String.valueOf(strSubstring2.substring(0, strSubstring2.length() - 1)).concat("+0000");
                                }
                            }
                        } catch (IndexOutOfBoundsException e10) {
                            Log.e(c3988b.f13521a, c3988b.m7977d("Error extracting the time substring: %s", new Object[0]), e10);
                        }
                        if (TextUtils.isEmpty(strSubstring2)) {
                            str2 = "yyyyMMdd";
                        } else {
                            strSubstring = AbstractC2460q.m5495i(strSubstring, "T", strSubstring2);
                            if (strSubstring2.length() == 6) {
                                str2 = "yyyyMMdd'T'HHmmss";
                            } else {
                                str2 = f13719c;
                            }
                        }
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTime(new SimpleDateFormat(str2).parse(strSubstring));
                        return calendar;
                    }
                    c3988b.m7975b("T delimeter is not found", new Object[0]);
                }
                calendar.setTime(new SimpleDateFormat(str2).parse(strSubstring));
                return calendar;
            } catch (ParseException e11) {
                Log.e(c3988b.f13521a, c3988b.m7977d("Error parsing string", new Object[0]), e11);
                return null;
            }
            strSubstring2 = null;
            if (TextUtils.isEmpty(strSubstring2)) {
                strSubstring = AbstractC2460q.m5495i(strSubstring, "T", strSubstring2);
                if (strSubstring2.length() == 6) {
                    str2 = "yyyyMMdd'T'HHmmss";
                } else {
                    str2 = f13719c;
                }
            } else {
                str2 = "yyyyMMdd";
            }
            Calendar calendar2 = Calendar.getInstance();
        }
        strSubstring = null;
        if (TextUtils.isEmpty(strSubstring)) {
            c3988b.m7975b("Invalid date format", new Object[0]);
            return null;
        }
        if (TextUtils.isEmpty(str)) {
            c3988b.m7975b("string is empty or null", new Object[0]);
        } else {
            iIndexOf = str.indexOf(84);
            i6 = iIndexOf + 1;
            if (iIndexOf != 8) {
                strSubstring2 = str.substring(i6);
                if (strSubstring2.length() != 6) {
                    cCharAt = strSubstring2.charAt(6);
                    strArr = f13718b;
                    if (cCharAt != '+') {
                        length = strSubstring2.length();
                        if (length != strArr[1].length() + 6) {
                        }
                        strSubstring2 = strSubstring2.replaceAll("([\\+\\-]\\d\\d):(\\d\\d)", "$1$2");
                    } else {
                        length = strSubstring2.length();
                        if (length != strArr[1].length() + 6) {
                        }
                        strSubstring2 = strSubstring2.replaceAll("([\\+\\-]\\d\\d):(\\d\\d)", "$1$2");
                    }
                }
                if (TextUtils.isEmpty(strSubstring2)) {
                    strSubstring = AbstractC2460q.m5495i(strSubstring, "T", strSubstring2);
                    if (strSubstring2.length() == 6) {
                        str2 = "yyyyMMdd'T'HHmmss";
                    } else {
                        str2 = f13719c;
                    }
                } else {
                    str2 = "yyyyMMdd";
                }
                Calendar calendar3 = Calendar.getInstance();
                calendar3.setTime(new SimpleDateFormat(str2).parse(strSubstring));
                return calendar3;
            }
            c3988b.m7975b("T delimeter is not found", new Object[0]);
        }
        strSubstring2 = null;
        if (TextUtils.isEmpty(strSubstring2)) {
            strSubstring = AbstractC2460q.m5495i(strSubstring, "T", strSubstring2);
            if (strSubstring2.length() == 6) {
                str2 = "yyyyMMdd'T'HHmmss";
            } else {
                str2 = f13719c;
            }
        } else {
            str2 = "yyyyMMdd";
        }
        Calendar calendar4 = Calendar.getInstance();
        calendar4.setTime(new SimpleDateFormat(str2).parse(strSubstring));
        return calendar4;
    }

    public static JSONArray m8056b(ArrayList arrayList) {
        arrayList.getClass();
        JSONArray jSONArray = new JSONArray();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            WebImage webImage = (WebImage) it.next();
            webImage.getClass();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(Progress.URL, webImage.f5023b.toString());
                jSONObject.put("width", webImage.f5024c);
                jSONObject.put("height", webImage.f5025d);
            } catch (JSONException unused) {
            }
            jSONArray.put(jSONObject);
        }
        return jSONArray;
    }

    public static void m8057c(ArrayList arrayList, JSONArray jSONArray) {
        try {
            arrayList.clear();
            for (int i6 = 0; i6 < jSONArray.length(); i6++) {
                try {
                    arrayList.add(new WebImage(jSONArray.getJSONObject(i6)));
                } catch (IllegalArgumentException unused) {
                }
            }
        } catch (JSONException unused2) {
        }
    }
}
