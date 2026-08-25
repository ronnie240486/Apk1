package p118l0;

public final class C2950a {

    public static final byte[] f10121e = new byte[1792];

    public final CharSequence f10122a;

    public final int f10123b;

    public int f10124c;

    public char f10125d;

    static {
        for (int i6 = 0; i6 < 1792; i6++) {
            f10121e[i6] = Character.getDirectionality(i6);
        }
    }

    public C2950a(CharSequence charSequence) {
        this.f10122a = charSequence;
        this.f10123b = charSequence.length();
    }

    public final byte m5971a() {
        int i6 = this.f10124c - 1;
        CharSequence charSequence = this.f10122a;
        char cCharAt = charSequence.charAt(i6);
        this.f10125d = cCharAt;
        if (Character.isLowSurrogate(cCharAt)) {
            int iCodePointBefore = Character.codePointBefore(charSequence, this.f10124c);
            this.f10124c -= Character.charCount(iCodePointBefore);
            return Character.getDirectionality(iCodePointBefore);
        }
        this.f10124c--;
        char c5 = this.f10125d;
        return c5 < 1792 ? f10121e[c5] : Character.getDirectionality(c5);
    }
}
