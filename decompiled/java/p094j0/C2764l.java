package p094j0;

import android.os.LocaleList;
import com.alibaba.fastjson.parser.deserializer.AbstractC1451d;
import java.util.Locale;

public final class C2764l implements InterfaceC2763k {

    public final LocaleList f9479a;

    public C2764l(Object obj) {
        this.f9479a = AbstractC1451d.m3441h(obj);
    }

    @Override
    public final String mo5734a() {
        return this.f9479a.toLanguageTags();
    }

    @Override
    public final Object mo5735b() {
        return this.f9479a;
    }

    public final boolean equals(Object obj) {
        return this.f9479a.equals(((InterfaceC2763k) obj).mo5735b());
    }

    @Override
    public final Locale get(int i6) {
        return this.f9479a.get(i6);
    }

    public final int hashCode() {
        return this.f9479a.hashCode();
    }

    @Override
    public final boolean isEmpty() {
        return this.f9479a.isEmpty();
    }

    @Override
    public final int size() {
        return this.f9479a.size();
    }

    public final String toString() {
        return this.f9479a.toString();
    }
}
