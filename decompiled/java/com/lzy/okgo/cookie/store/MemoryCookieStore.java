package com.lzy.okgo.cookie.store;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import okhttp3.Cookie;
import okhttp3.HttpUrl;

public class MemoryCookieStore implements CookieStore {
    private final Map<String, List<Cookie>> memoryCookies = new HashMap();

    @Override
    public synchronized List<Cookie> getAllCookie() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator<String> it = this.memoryCookies.keySet().iterator();
        while (it.hasNext()) {
            arrayList.addAll(this.memoryCookies.get(it.next()));
        }
        return arrayList;
    }

    @Override
    public List<Cookie> getCookie(HttpUrl httpUrl) {
        ArrayList arrayList = new ArrayList();
        List<Cookie> list = this.memoryCookies.get(httpUrl.host());
        if (list != null) {
            arrayList.addAll(list);
        }
        return arrayList;
    }

    @Override
    public synchronized List<Cookie> loadCookie(HttpUrl httpUrl) {
        List<Cookie> arrayList;
        arrayList = this.memoryCookies.get(httpUrl.host());
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.memoryCookies.put(httpUrl.host(), arrayList);
        }
        return arrayList;
    }

    @Override
    public synchronized boolean removeAllCookie() {
        this.memoryCookies.clear();
        return true;
    }

    @Override
    public synchronized boolean removeCookie(HttpUrl httpUrl, Cookie cookie) {
        return cookie != null && this.memoryCookies.get(httpUrl.host()).remove(cookie);
    }

    @Override
    public synchronized void saveCookie(HttpUrl httpUrl, List<Cookie> list) {
        try {
            List<Cookie> list2 = this.memoryCookies.get(httpUrl.host());
            ArrayList arrayList = new ArrayList();
            for (Cookie cookie : list) {
                for (Cookie cookie2 : list2) {
                    if (cookie.name().equals(cookie2.name())) {
                        arrayList.add(cookie2);
                    }
                }
            }
            list2.removeAll(arrayList);
            list2.addAll(list);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override
    public synchronized boolean removeCookie(HttpUrl httpUrl) {
        return this.memoryCookies.remove(httpUrl.host()) != null;
    }

    @Override
    public synchronized void saveCookie(HttpUrl httpUrl, Cookie cookie) {
        try {
            List<Cookie> list = this.memoryCookies.get(httpUrl.host());
            ArrayList arrayList = new ArrayList();
            for (Cookie cookie2 : list) {
                if (cookie.name().equals(cookie2.name())) {
                    arrayList.add(cookie2);
                }
            }
            list.removeAll(arrayList);
            list.add(cookie);
        } catch (Throwable th) {
            throw th;
        }
    }
}
