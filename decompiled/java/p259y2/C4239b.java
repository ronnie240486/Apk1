package p259y2;

public final class C4239b {

    public final int f14397a;

    public final int m8279a(Object obj) {
        switch (this.f14397a) {
            case 0:
                return ((byte[]) obj).length;
            default:
                return ((int[]) obj).length;
        }
    }

    public final int m8280b() {
        switch (this.f14397a) {
            case 0:
                return 1;
            default:
                return 4;
        }
    }

    public final String m8281c() {
        switch (this.f14397a) {
            case 0:
                return "ByteArrayPool";
            default:
                return "IntegerArrayPool";
        }
    }
}
