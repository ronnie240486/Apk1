package com.tencent.bugly.crashreport.crash.p033h5;

import android.webkit.JavascriptInterface;
import com.lzy.okgo.cookie.SerializableCookie;
import com.lzy.okgo.model.Progress;
import com.tencent.bugly.crashreport.CrashReport;
import com.tencent.bugly.crashreport.inner.InnerApi;
import com.tencent.bugly.proguard.C2029al;
import com.tencent.bugly.proguard.C2033ap;
import com.tencent.bugly.proguard.C2047bb;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONObject;

public class H5JavaScriptInterface {

    private static HashSet<Integer> f7154a = new HashSet<>();

    private String f7155b = null;

    private Thread f7156c = null;

    private String f7157d = null;

    private Map<String, String> f7158e = null;

    private H5JavaScriptInterface() {
    }

    private static C2047bb m4487a(String str) {
        String string;
        if (str != null && str.length() > 0) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                C2047bb c2047bb = new C2047bb();
                String string2 = jSONObject.getString("projectRoot");
                c2047bb.f7445a = string2;
                if (string2 == null) {
                    return null;
                }
                String string3 = jSONObject.getString("context");
                c2047bb.f7446b = string3;
                if (string3 == null) {
                    return null;
                }
                String string4 = jSONObject.getString(Progress.URL);
                c2047bb.f7447c = string4;
                if (string4 == null) {
                    return null;
                }
                String string5 = jSONObject.getString("userAgent");
                c2047bb.f7448d = string5;
                if (string5 == null) {
                    return null;
                }
                String string6 = jSONObject.getString("language");
                c2047bb.f7449e = string6;
                if (string6 == null) {
                    return null;
                }
                String string7 = jSONObject.getString(SerializableCookie.NAME);
                c2047bb.f7450f = string7;
                if (string7 == null || string7.equals("null") || (string = jSONObject.getString("stacktrace")) == null) {
                    return null;
                }
                int iIndexOf = string.indexOf("\n");
                if (iIndexOf < 0) {
                    C2029al.m4645d("H5 crash stack's format is wrong!", new Object[0]);
                    return null;
                }
                c2047bb.f7452h = string.substring(iIndexOf + 1);
                String strSubstring = string.substring(0, iIndexOf);
                c2047bb.f7451g = strSubstring;
                int iIndexOf2 = strSubstring.indexOf(":");
                if (iIndexOf2 > 0) {
                    c2047bb.f7451g = c2047bb.f7451g.substring(iIndexOf2 + 1);
                }
                c2047bb.f7453i = jSONObject.getString("file");
                if (c2047bb.f7450f == null) {
                    return null;
                }
                long j10 = jSONObject.getLong("lineNumber");
                c2047bb.f7454j = j10;
                if (j10 < 0) {
                    return null;
                }
                long j11 = jSONObject.getLong("columnNumber");
                c2047bb.f7455k = j11;
                if (j11 < 0) {
                    return null;
                }
                C2029al.m4640a("H5 crash information is following: ", new Object[0]);
                C2029al.m4640a("[projectRoot]: " + c2047bb.f7445a, new Object[0]);
                C2029al.m4640a("[context]: " + c2047bb.f7446b, new Object[0]);
                C2029al.m4640a("[url]: " + c2047bb.f7447c, new Object[0]);
                C2029al.m4640a("[userAgent]: " + c2047bb.f7448d, new Object[0]);
                C2029al.m4640a("[language]: " + c2047bb.f7449e, new Object[0]);
                C2029al.m4640a("[name]: " + c2047bb.f7450f, new Object[0]);
                C2029al.m4640a("[message]: " + c2047bb.f7451g, new Object[0]);
                C2029al.m4640a("[stacktrace]: \n" + c2047bb.f7452h, new Object[0]);
                C2029al.m4640a("[file]: " + c2047bb.f7453i, new Object[0]);
                C2029al.m4640a("[lineNumber]: " + c2047bb.f7454j, new Object[0]);
                C2029al.m4640a("[columnNumber]: " + c2047bb.f7455k, new Object[0]);
                return c2047bb;
            } catch (Throwable th) {
                if (!C2029al.m4641a(th)) {
                    th.printStackTrace();
                }
            }
        }
        return null;
    }

    public static H5JavaScriptInterface getInstance(CrashReport.InterfaceC2008a interfaceC2008a) {
        String string = null;
        if (interfaceC2008a == null || f7154a.contains(Integer.valueOf(interfaceC2008a.hashCode()))) {
            return null;
        }
        H5JavaScriptInterface h5JavaScriptInterface = new H5JavaScriptInterface();
        f7154a.add(Integer.valueOf(interfaceC2008a.hashCode()));
        Thread threadCurrentThread = Thread.currentThread();
        h5JavaScriptInterface.f7156c = threadCurrentThread;
        if (threadCurrentThread != null) {
            StringBuilder sb = new StringBuilder("\n");
            for (int i6 = 2; i6 < threadCurrentThread.getStackTrace().length; i6++) {
                StackTraceElement stackTraceElement = threadCurrentThread.getStackTrace()[i6];
                if (!stackTraceElement.toString().contains("crashreport")) {
                    sb.append(stackTraceElement.toString());
                    sb.append("\n");
                }
            }
            string = sb.toString();
        }
        h5JavaScriptInterface.f7157d = string;
        HashMap map = new HashMap();
        StringBuilder sb2 = new StringBuilder();
        sb2.append((Object) interfaceC2008a.mo4480c());
        map.put("[WebView] ContentDescription", sb2.toString());
        h5JavaScriptInterface.f7158e = map;
        return h5JavaScriptInterface;
    }

    @JavascriptInterface
    public void printLog(String str) {
        C2029al.m4645d("Log from js: %s", str);
    }

    @JavascriptInterface
    public void reportJSException(String str) {
        if (str == null) {
            C2029al.m4645d("Payload from JS is null.", new Object[0]);
            return;
        }
        String strM4705c = C2033ap.m4705c(str.getBytes());
        String str2 = this.f7155b;
        if (str2 != null && str2.equals(strM4705c)) {
            C2029al.m4645d("Same payload from js. Please check whether you've injected bugly.js more than one times.", new Object[0]);
            return;
        }
        this.f7155b = strM4705c;
        C2029al.m4645d("Handling JS exception ...", new Object[0]);
        C2047bb c2047bbM4487a = m4487a(str);
        if (c2047bbM4487a == null) {
            C2029al.m4645d("Failed to parse payload.", new Object[0]);
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        String str3 = c2047bbM4487a.f7445a;
        if (str3 != null) {
            linkedHashMap2.put("[JS] projectRoot", str3);
        }
        String str4 = c2047bbM4487a.f7446b;
        if (str4 != null) {
            linkedHashMap2.put("[JS] context", str4);
        }
        String str5 = c2047bbM4487a.f7447c;
        if (str5 != null) {
            linkedHashMap2.put("[JS] url", str5);
        }
        String str6 = c2047bbM4487a.f7448d;
        if (str6 != null) {
            linkedHashMap2.put("[JS] userAgent", str6);
        }
        String str7 = c2047bbM4487a.f7453i;
        if (str7 != null) {
            linkedHashMap2.put("[JS] file", str7);
        }
        long j10 = c2047bbM4487a.f7454j;
        if (j10 != 0) {
            linkedHashMap2.put("[JS] lineNumber", Long.toString(j10));
        }
        linkedHashMap.putAll(linkedHashMap2);
        linkedHashMap.putAll(this.f7158e);
        linkedHashMap.put("Java Stack", this.f7157d);
        InnerApi.postH5CrashAsync(this.f7156c, c2047bbM4487a.f7450f, c2047bbM4487a.f7451g, c2047bbM4487a.f7452h, linkedHashMap);
    }
}
