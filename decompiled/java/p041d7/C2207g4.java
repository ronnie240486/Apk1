package p041d7;

import java.util.Map;

public final enum C2207g4 extends EnumC2221i4 {
    public C2207g4() {
        super("KEY", 0);
    }

    @Override
    public final Object apply(Object obj) {
        return ((Map.Entry) obj).getKey();
    }
}
