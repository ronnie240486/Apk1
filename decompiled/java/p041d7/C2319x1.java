package p041d7;

public final class C2319x1 {

    public final Object f8089a;

    public final Object f8090b;

    public final Object f8091c;

    public C2319x1(Object obj, Object obj2, Object obj3) {
        this.f8089a = obj;
        this.f8090b = obj2;
        this.f8091c = obj3;
    }

    public final IllegalArgumentException m5288a() {
        StringBuilder sb = new StringBuilder("Multiple entries with same key: ");
        Object obj = this.f8089a;
        sb.append(obj);
        sb.append("=");
        sb.append(this.f8090b);
        sb.append(" and ");
        sb.append(obj);
        sb.append("=");
        sb.append(this.f8091c);
        return new IllegalArgumentException(sb.toString());
    }
}
