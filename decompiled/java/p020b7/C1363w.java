package p020b7;

public final enum C1363w extends EnumC1365y {
    public C1363w() {
        super("IS_NULL", 2);
    }

    @Override
    public final boolean apply(Object obj) {
        return obj == null;
    }

    @Override
    public final String toString() {
        return "Predicates.isNull()";
    }
}
