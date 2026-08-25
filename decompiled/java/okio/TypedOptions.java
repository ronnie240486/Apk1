package okio;

import java.util.List;
import java.util.RandomAccess;
import p091i9.InterfaceC2724l;
import p103j9.AbstractC2793f;
import p103j9.AbstractC2796i;
import p253x8.AbstractC4142e;
import p253x8.AbstractC4147j;

public final class TypedOptions<T> extends AbstractC4142e implements RandomAccess {
    public static final Companion Companion = new Companion(null);
    private final List<T> list;
    private final Options options;

    public static final class Companion {
        public Companion(AbstractC2793f abstractC2793f) {
            this();
        }

        public final <T> TypedOptions<T> m6652of(Iterable<? extends T> iterable, InterfaceC2724l interfaceC2724l) {
            AbstractC2796i.m5785f(iterable, "values");
            AbstractC2796i.m5785f(interfaceC2724l, "encode");
            List listM8189c0 = AbstractC4147j.m8189c0(iterable);
            Options.Companion companion = Options.Companion;
            int size = listM8189c0.size();
            ByteString[] byteStringArr = new ByteString[size];
            for (int i6 = 0; i6 < size; i6++) {
                byteStringArr[i6] = interfaceC2724l.invoke(listM8189c0.get(i6));
            }
            return new TypedOptions<>(listM8189c0, companion.m6650of(byteStringArr));
        }

        private Companion() {
        }
    }

    public TypedOptions(List<? extends T> list, Options options) {
        AbstractC2796i.m5785f(list, "list");
        AbstractC2796i.m5785f(options, "options");
        this.options = options;
        List<T> listM8189c0 = AbstractC4147j.m8189c0(list);
        this.list = listM8189c0;
        if (listM8189c0.size() != options.size()) {
            throw new IllegalArgumentException("Failed requirement.");
        }
    }

    public static final <T> TypedOptions<T> m6651of(Iterable<? extends T> iterable, InterfaceC2724l interfaceC2724l) {
        return Companion.m6652of(iterable, interfaceC2724l);
    }

    @Override
    public T get(int i6) {
        return this.list.get(i6);
    }

    public final List<T> getList$okio() {
        return this.list;
    }

    public final Options getOptions$okio() {
        return this.options;
    }

    @Override
    public int getSize() {
        return this.list.size();
    }
}
