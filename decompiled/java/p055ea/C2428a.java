package p055ea;

import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.LocaleList;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import com.p2serv.android.p032ds.R;
import com.tencent.mars.xlog.Log;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.UUID;
import org.bitspark.android.Spark;
import org.bitspark.android.utils.AbstractC3331m;
import org.bitspark.android.utils.C3319a;
import p003a2.AbstractC0032a;
import p187r4.AbstractC3612b;

public final class C2428a {

    public static String f8493b;

    public static String f8494c;

    public static int f8495d;

    public static int f8496e;

    public static int f8497f;

    public static String f8498g;

    public static String f8499h;

    public static int f8500i;

    public static int f8501j;

    public static float f8502k;

    public static String f8503l;

    public static String f8504m;

    public static EnumC2438f f8505n;

    public static String f8506o;

    public static String f8507p;

    public static final String f8508q;

    public static final String f8509r;

    public final Spark f8510a;

    static {
        AbstractC0032a.m165s("QrndDw==\n", "AOqeacqnQVo=\n");
        f8493b = AbstractC0032a.m165s("7tqlesrffwbqhqM63d1xHeU=\n", "gajCVLmvHnQ=\n");
        AbstractC0032a.m165s("+i9gfeQ=\n", "n0E/KLe6UDo=\n");
        f8494c = "";
        f8495d = 0;
        f8496e = 1;
        f8497f = 1500000;
        f8498g = "";
        f8499h = "";
        f8505n = EnumC2438f.f8548b;
        f8506o = "";
        f8507p = "";
        f8508q = AbstractC0032a.m165s("wLO9FZe2yoreuw==\n", "rtzKRfvXs88=\n");
        f8509r = AbstractC0032a.m165s("+aXUQpWuHHLSsMs=\n", "l8CsNsXCfQs=\n");
        AbstractC0032a.m165s("xb1sIi4Elg==\n", "ptUNTEBh+hY=\n");
    }

    public C2428a(Spark spark) {
        String strM165s;
        int i6;
        String upperCase;
        this.f8510a = spark;
        String strM165s2 = AbstractC0032a.m165s("r+mRvA==\n", "7brS2oCov5o=\n");
        String strM165s3 = AbstractC0032a.m165s("ylR4kV+5JY+uKB/3Pswu+skROt4P/A==\n", "6XdbsnyZacA=\n");
        boolean z7 = AbstractC3331m.f11244b;
        Log.m5049i(strM165s2, strM165s3);
        Log.m5049i(AbstractC0032a.m165s("DrptmQ==\n", "TOku/wmIPR0=\n"), AbstractC0032a.m165s("YGQUJTurnnIqK1NFd+W6biRpcUpZ3ZNVeWdnNEvOjlE=\n", "Q0c3BhiL3Ac=\n"));
        Locale locale = Build.VERSION.SDK_INT >= 24 ? LocaleList.getDefault().get(0) : Locale.getDefault();
        f8506o = locale.getLanguage();
        f8507p = locale.getCountry();
        Log.m5049i(AbstractC0032a.m165s("KDbM+g==\n", "amWPnMFgMHk=\n"), AbstractC0032a.m165s("afuzZ9XR/sokv+UlkZSoiw==\n", "StiQRPbxkqs=\n") + f8506o + AbstractC0032a.m165s("8g==\n", "rf9kEsD6HTA=\n") + f8507p);
        Log.m5049i(AbstractC0032a.m165s("ivXDDw==\n", "yKaAaU18J8w=\n"), AbstractC0032a.m165s("bGM1Ly/6U/pqUxB5aw==\n", "LhZcQ0vUHrU=\n") + Build.MODEL + AbstractC0032a.m165s("2E1WtZ2ToYy3TnGYy9c=\n", "+A8j3PH3j84=\n") + Build.BOARD);
        f8493b = spark.getPackageName().toString();
        Log.m5049i(AbstractC0032a.m165s("NA5LcA==\n", "dl0IFn6z/Qg=\n"), AbstractC0032a.m165s("q7JaiMgAbVW6vlze\n", "29M546lnCBs=\n") + f8493b);
        if (C3319a.f11201a == null) {
            synchronized (C3319a.class) {
                try {
                    if (C3319a.f11201a == null) {
                        SharedPreferences sharedPreferences = spark.getSharedPreferences(AbstractC0032a.m165s("B241JG3yHOAHJTsgYg==\n", "YwtDTQ6XQ4k=\n"), 0);
                        String string = sharedPreferences.getString(AbstractC0032a.m165s("SoG78Z2A8/5K\n", "LuTNmP7lrJc=\n"), null);
                        if (string != null) {
                            C3319a.f11201a = UUID.fromString(string);
                        } else {
                            String string2 = Settings.Secure.getString(spark.getContentResolver(), AbstractC0032a.m165s("jNii99rOeHWE0g==\n", "7bbGhbWnHCo=\n"));
                            try {
                                if (AbstractC0032a.m165s("LdcfBLnZ450i2BpV6Njsmg==\n", "FOAoMN3s1fk=\n").equals(string2)) {
                                    String deviceId = ((TelephonyManager) spark.getSystemService(AbstractC0032a.m165s("LmIy30s=\n", "XgpdsS7s0P4=\n"))).getDeviceId();
                                    C3319a.f11201a = deviceId != null ? UUID.nameUUIDFromBytes(deviceId.getBytes(AbstractC0032a.m165s("sK6YXg==\n", "xdr+Zrbk1CA=\n"))) : UUID.randomUUID();
                                } else {
                                    C3319a.f11201a = UUID.nameUUIDFromBytes(string2.getBytes(AbstractC0032a.m165s("zjSwXw==\n", "u0DWZ1QVIkE=\n")));
                                }
                                sharedPreferences.edit().putString(AbstractC0032a.m165s("h4mA0uGNNamH\n", "4+z2u4LoasA=\n"), C3319a.f11201a.toString()).commit();
                            } catch (UnsupportedEncodingException e5) {
                                throw new RuntimeException(e5);
                            }
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        Log.m5049i(AbstractC0032a.m165s("poKZ6A==\n", "5NHajnuKYrk=\n"), AbstractC0032a.m165s("RM5IQD0=\n", "MbshJADPJMI=\n") + C3319a.f11201a.toString());
        try {
            f8498g = spark.getPackageManager().getPackageInfo(f8493b, 0).versionName;
        } catch (PackageManager.NameNotFoundException e10) {
            e10.printStackTrace();
        }
        Log.m5049i(AbstractC0032a.m165s("JSZRTg==\n", "Z3USKAedLSY=\n"), AbstractC0032a.m165s("+fSKhvEtyHzx65SX5iXfMg==\n", "mIT62YdIug8=\n") + f8498g);
        try {
            f8496e = this.f8510a.getPackageManager().getPackageInfo(f8493b, 0).versionCode;
        } catch (PackageManager.NameNotFoundException e11) {
            e11.printStackTrace();
        }
        Log.m5049i(AbstractC0032a.m165s("aDw3rQ==\n", "Km90y9WqYEE=\n"), AbstractC0032a.m165s("vjgbYJWwXz22JwV8jLFIcw==\n", "30hrP+PVLU4=\n") + f8496e);
        f8503l = this.f8510a.getString(R.string.app_name);
        String strM7270l = AbstractC3612b.m7270l(spark);
        String strM165s4 = AbstractC0032a.m165s("xxwUaGz3EEryGAVIaPtYbPJDO35o/h0qox9VLnepHUPoCAdkbfYdJ/VXVS53qR0n9UU=\n", "hmx1CwSSPQI=\n");
        String str = Build.VERSION.RELEASE;
        f8504m = String.format(strM165s4, f8503l, f8498g, str, Build.MODEL, strM7270l);
        Log.m5049i(AbstractC0032a.m165s("G0M1hg==\n", "WRB24JShVrE=\n"), AbstractC0032a.m165s("5jSvYtu4elrnfeo=\n", "k0fKEJrfHzQ=\n") + f8504m);
        DisplayMetrics displayMetrics = Spark.f11004Z1;
        f8500i = displayMetrics.widthPixels;
        f8501j = displayMetrics.heightPixels;
        f8502k = displayMetrics.density;
        Log.m5049i(AbstractC0032a.m165s("6/9hBg==\n", "qawiYLjf3Mg=\n"), AbstractC0032a.m165s("TFNnP8F0\n", "OzoDS6lJBog=\n") + f8500i);
        Log.m5049i(AbstractC0032a.m165s("zuAt9g==\n", "jLNukMt9RQA=\n"), AbstractC0032a.m165s("rCcQ1bQ+lg==\n", "xEJ5stxKqzE=\n") + f8501j);
        Log.m5049i(AbstractC0032a.m165s("MdW4xg==\n", "c4b7oB14rOk=\n"), AbstractC0032a.m165s("nLwn9r8StFk=\n", "+NlJhdZmzWQ=\n") + f8502k);
        if (Locale.getDefault().getLanguage().indexOf(AbstractC0032a.m165s("6+Q=\n", "kYxrUGKAqf0=\n")) != -1) {
            AbstractC0032a.m165s("Dm5MSGg=\n", "dAYTCyYvqpw=\n");
        }
        f8494c = str;
        Log.m5049i(AbstractC0032a.m165s("/gKspw==\n", "vFHvwSzyHuA=\n"), AbstractC0032a.m165s("w+g/lAVJzpnf/3E=\n", "sJFMwmA7vfA=\n") + f8494c);
        f8495d = Build.VERSION.SDK_INT;
        Log.m5049i(AbstractC0032a.m165s("N2DKEw==\n", "dTOJdRHaQU8=\n"), AbstractC0032a.m165s("noiL14weFDuJlMU=\n", "7fH4gelsV1Q=\n") + f8495d);
        try {
            InputStream inputStream = new ProcessBuilder(AbstractC0032a.m165s("hvHukURkK/vL6/nNU2Ay\n", "qYKX4jABRtQ=\n"), AbstractC0032a.m165s("yBExxUstm7iOAS3FSzqHvZMHJZkHOYvhhBI9hksqjruBEC3HSyqOu44MLtk7JJ+2uAQ60xU=\n", "52JItmRJ/s4=\n")).start().getInputStream();
            byte[] bArr = new byte[24];
            strM165s = "";
            while (inputStream.read(bArr) != -1) {
                strM165s = strM165s + new String(bArr);
            }
            inputStream.close();
        } catch (IOException e12) {
            e12.printStackTrace();
            strM165s = AbstractC0032a.m165s("V6rP\n", "GYWOmj9CcNo=\n");
        }
        try {
            i6 = Integer.parseInt(strM165s.trim());
        } catch (NumberFormatException unused) {
            i6 = 0;
        }
        if (i6 > 0) {
            f8497f = Runtime.getRuntime().availableProcessors() * i6;
        } else {
            f8497f = Runtime.getRuntime().availableProcessors() * f8497f;
        }
        Log.m5049i(AbstractC0032a.m165s("CZkgww==\n", "S8pjpRqa0v4=\n"), AbstractC0032a.m165s("xuGVVBi+\n", "q4DtF16DuYQ=\n") + f8497f);
        WifiInfo connectionInfo = ((WifiManager) spark.getSystemService(AbstractC0032a.m165s("/6/wqw==\n", "iMaWwvV5RdM=\n"))).getConnectionInfo();
        if (connectionInfo == null || connectionInfo.getMacAddress() == null) {
            upperCase = "";
            try {
                String strM165s5 = AbstractC0032a.m165s("4Z0Tc+xQc8O9nUVupkcwx7qGWi+iV3vQq50Z\n", "zu5qAMMzH6I=\n");
                StringBuffer stringBuffer = new StringBuffer(1000);
                BufferedReader bufferedReader = new BufferedReader(new FileReader(strM165s5));
                char[] cArr = new char[1024];
                while (true) {
                    int i10 = bufferedReader.read(cArr);
                    if (i10 == -1) {
                        break;
                    } else {
                        stringBuffer.append(String.valueOf(cArr, 0, i10));
                    }
                }
                bufferedReader.close();
                String string3 = stringBuffer.toString();
                if (string3.length() == 17) {
                    upperCase = string3.toUpperCase();
                }
            } catch (IOException e13) {
                e13.printStackTrace();
            }
            Log.m5049i(AbstractC0032a.m165s("ViJDYA==\n", "FHEABpyropc=\n"), AbstractC0032a.m165s("XCMaXXDQC1YDdw==\n", "OVdybVC9ajU=\n") + upperCase);
        } else {
            upperCase = connectionInfo.getMacAddress();
            Log.m5049i(AbstractC0032a.m165s("zMU5bg==\n", "jpZ6CAFZy6E=\n"), AbstractC0032a.m165s("7xQmky8vdN2iXQ==\n", "mH1A+g9CFb4=\n") + upperCase);
        }
        Log.m5049i(AbstractC0032a.m165s("j0tFVQ==\n", "zRgGMybWTgk=\n"), AbstractC0032a.m165s("779Rae8rbC4=\n", "nMsjJK5oVg4=\n") + upperCase);
        if (!upperCase.equals("") && upperCase.length() == 17) {
            String str2 = upperCase.substring(0, 2) + upperCase.substring(3, 5) + upperCase.substring(6, 8) + upperCase.substring(9, 11) + upperCase.substring(12, 14) + upperCase.substring(15, 17);
            f8499h = str2;
            f8499h = str2.toUpperCase();
            Log.m5049i(AbstractC0032a.m165s("ilhjRw==\n", "yAsgIVblL/M=\n"), AbstractC0032a.m165s("xUPoccNG6/rbUbEQ\n", "qCKLMKcimZ8=\n") + f8499h);
        }
        String str3 = Build.MANUFACTURER;
        Log.m5049i(AbstractC0032a.m165s("DeS+xQ==\n", "T7f9o7tBBSA=\n"), AbstractC0032a.m165s("szXTPJ7fwLSrJtg7wp4=\n", "3lS9Sfi+o8A=\n") + str3);
        int iIntValue = AbstractC3331m.m6756f(-1, AbstractC0032a.m165s("+NYRIrXu3w/vxgEkqO4=\n", "rplVffirm0Y=\n")).intValue();
        if ((str3.toLowerCase().equals(AbstractC0032a.m165s("EErIeUVW\n", "eD+pDiA/pWs=\n")) || str3.toLowerCase().equals(AbstractC0032a.m165s("53u7J4eF\n", "gBTUQOvghI8=\n"))) && iIntValue == -1) {
            AbstractC3331m.m6763m(1, AbstractC0032a.m165s("9UHrJndLGmLiUfsgaks=\n", "ow6veToOXis=\n"));
        }
        int iIntValue2 = AbstractC3331m.m6756f(-1, AbstractC0032a.m165s("SbeKrEyZHLJep5qqUZk=\n", "H/jO8wHcWPs=\n")).intValue();
        if (iIntValue2 == 1) {
            f8505n = EnumC2438f.f8548b;
            Log.m5049i(AbstractC0032a.m165s("2v6j5A==\n", "mK3ggl5uMak=\n"), AbstractC0032a.m165s("haCnzW/dMmGgvqrgdMw0MNWYlQ==\n", "9czGtA28UQo=\n"));
        } else if (iIntValue2 == 0) {
            f8505n = EnumC2438f.f8547a;
            Log.m5049i(AbstractC0032a.m165s("nDjYSw==\n", "3mubLVfNi74=\n"), AbstractC0032a.m165s("OGSssJtL9lIdeqGdgFrwA2hcng==\n", "SAjNyfkqlTk=\n"));
        }
    }
}
