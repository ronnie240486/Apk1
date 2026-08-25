package p016b3;

import com.bumptech.glide.load.data.InterfaceC1479e;
import java.util.Collections;
import java.util.List;
import p186r3.AbstractC3602f;
import p228v2.InterfaceC3978e;

public final class C1287t {

    public final InterfaceC3978e f4052a;

    public final List f4053b;

    public final InterfaceC1479e f4054c;

    public C1287t(InterfaceC3978e interfaceC3978e, InterfaceC1479e interfaceC1479e) {
        List listEmptyList = Collections.emptyList();
        AbstractC3602f.m7225c(interfaceC3978e, "Argument must not be null");
        this.f4052a = interfaceC3978e;
        AbstractC3602f.m7225c(listEmptyList, "Argument must not be null");
        this.f4053b = listEmptyList;
        AbstractC3602f.m7225c(interfaceC1479e, "Argument must not be null");
        this.f4054c = interfaceC1479e;
    }
}
