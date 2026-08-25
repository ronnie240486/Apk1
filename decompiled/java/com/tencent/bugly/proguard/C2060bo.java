package com.tencent.bugly.proguard;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public final class C2060bo extends AbstractC2088m {

    static ArrayList<C2059bn> f7491A;

    static Map<String, String> f7492B;

    static Map<String, String> f7493C;

    static Map<String, String> f7494v;

    static C2058bm f7495w;

    static C2057bl f7496x;

    static ArrayList<C2057bl> f7497y;

    static ArrayList<C2057bl> f7498z;

    public String f7499a = "";

    public long f7500b = 0;

    public String f7501c = "";

    public String f7502d = "";

    public String f7503e = "";

    public String f7504f = "";

    public String f7505g = "";

    public Map<String, String> f7506h = null;

    public String f7507i = "";

    public C2058bm f7508j = null;

    public int f7509k = 0;

    public String f7510l = "";

    public String f7511m = "";

    public C2057bl f7512n = null;

    public ArrayList<C2057bl> f7513o = null;

    public ArrayList<C2057bl> f7514p = null;

    public ArrayList<C2059bn> f7515q = null;

    public Map<String, String> f7516r = null;

    public Map<String, String> f7517s = null;

    public String f7518t = "";

    public boolean f7519u = true;

    static {
        HashMap map = new HashMap();
        f7494v = map;
        map.put("", "");
        f7495w = new C2058bm();
        f7496x = new C2057bl();
        f7497y = new ArrayList<>();
        f7497y.add(new C2057bl());
        f7498z = new ArrayList<>();
        f7498z.add(new C2057bl());
        f7491A = new ArrayList<>();
        f7491A.add(new C2059bn());
        HashMap map2 = new HashMap();
        f7492B = map2;
        map2.put("", "");
        HashMap map3 = new HashMap();
        f7493C = map3;
        map3.put("", "");
    }

    @Override
    public final void mo4852a(C2086l c2086l) {
        c2086l.m4934a(this.f7499a, 0);
        c2086l.m4931a(this.f7500b, 1);
        c2086l.m4934a(this.f7501c, 2);
        String str = this.f7502d;
        if (str != null) {
            c2086l.m4934a(str, 3);
        }
        String str2 = this.f7503e;
        if (str2 != null) {
            c2086l.m4934a(str2, 4);
        }
        String str3 = this.f7504f;
        if (str3 != null) {
            c2086l.m4934a(str3, 5);
        }
        String str4 = this.f7505g;
        if (str4 != null) {
            c2086l.m4934a(str4, 6);
        }
        Map<String, String> map = this.f7506h;
        if (map != null) {
            c2086l.m4936a((Map) map, 7);
        }
        String str5 = this.f7507i;
        if (str5 != null) {
            c2086l.m4934a(str5, 8);
        }
        C2058bm c2058bm = this.f7508j;
        if (c2058bm != null) {
            c2086l.m4932a((AbstractC2088m) c2058bm, 9);
        }
        c2086l.m4930a(this.f7509k, 10);
        String str6 = this.f7510l;
        if (str6 != null) {
            c2086l.m4934a(str6, 11);
        }
        String str7 = this.f7511m;
        if (str7 != null) {
            c2086l.m4934a(str7, 12);
        }
        C2057bl c2057bl = this.f7512n;
        if (c2057bl != null) {
            c2086l.m4932a((AbstractC2088m) c2057bl, 13);
        }
        ArrayList<C2057bl> arrayList = this.f7513o;
        if (arrayList != null) {
            c2086l.m4935a((Collection) arrayList, 14);
        }
        ArrayList<C2057bl> arrayList2 = this.f7514p;
        if (arrayList2 != null) {
            c2086l.m4935a((Collection) arrayList2, 15);
        }
        ArrayList<C2059bn> arrayList3 = this.f7515q;
        if (arrayList3 != null) {
            c2086l.m4935a((Collection) arrayList3, 16);
        }
        Map<String, String> map2 = this.f7516r;
        if (map2 != null) {
            c2086l.m4936a((Map) map2, 17);
        }
        Map<String, String> map3 = this.f7517s;
        if (map3 != null) {
            c2086l.m4936a((Map) map3, 18);
        }
        String str8 = this.f7518t;
        if (str8 != null) {
            c2086l.m4934a(str8, 19);
        }
        c2086l.m4938a(this.f7519u, 20);
    }

    @Override
    public final void mo4851a(C2084k c2084k) {
        this.f7499a = c2084k.m4915b(0, true);
        this.f7500b = c2084k.m4908a(this.f7500b, 1, true);
        this.f7501c = c2084k.m4915b(2, true);
        this.f7502d = c2084k.m4915b(3, false);
        this.f7503e = c2084k.m4915b(4, false);
        this.f7504f = c2084k.m4915b(5, false);
        this.f7505g = c2084k.m4915b(6, false);
        this.f7506h = (Map) c2084k.m4910a(f7494v, 7, false);
        this.f7507i = c2084k.m4915b(8, false);
        this.f7508j = (C2058bm) c2084k.m4909a((AbstractC2088m) f7495w, 9, false);
        this.f7509k = c2084k.m4906a(this.f7509k, 10, false);
        this.f7510l = c2084k.m4915b(11, false);
        this.f7511m = c2084k.m4915b(12, false);
        this.f7512n = (C2057bl) c2084k.m4909a((AbstractC2088m) f7496x, 13, false);
        this.f7513o = (ArrayList) c2084k.m4910a(f7497y, 14, false);
        this.f7514p = (ArrayList) c2084k.m4910a(f7498z, 15, false);
        this.f7515q = (ArrayList) c2084k.m4910a(f7491A, 16, false);
        this.f7516r = (Map) c2084k.m4910a(f7492B, 17, false);
        this.f7517s = (Map) c2084k.m4910a(f7493C, 18, false);
        this.f7518t = c2084k.m4915b(19, false);
        this.f7519u = c2084k.m4914a(20, false);
    }
}
