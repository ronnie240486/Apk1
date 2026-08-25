package p041d7;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public abstract class AbstractC2167b extends AbstractC2286s implements InterfaceC2314w2 {
    @Override
    public final Collection get(Object obj) {
        return (List) super.get(obj);
    }

    @Override
    public final Collection mo5104r(Collection collection) {
        return Collections.unmodifiableList((List) collection);
    }

    @Override
    public final Collection mo5105s(Collection collection, Object obj) {
        List list = (List) collection;
        return list instanceof RandomAccess ? new C2223j(this, obj, list, null) : new C2258o(this, obj, list, null);
    }

    @Override
    public final List get(Object obj) {
        return (List) super.get(obj);
    }
}
