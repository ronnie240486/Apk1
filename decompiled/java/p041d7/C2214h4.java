package p041d7;

import java.util.Map;

public final enum C2214h4 extends EnumC2221i4 {
    public C2214h4() {
        super("VALUE", 1);
    }

    @Override
    public final Object apply(Object obj) {
        return ((Map.Entry) obj).getValue();
    }
}
