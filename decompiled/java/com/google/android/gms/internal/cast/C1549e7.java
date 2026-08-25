package com.google.android.gms.internal.cast;

import java.io.IOException;
import java.util.Locale;

public final class C1549e7 extends IOException {
    public C1549e7(long j10, long j11, int i6, IndexOutOfBoundsException indexOutOfBoundsException) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.: ".concat("Pos: " + j10 + ", limit: " + j11 + ", len: " + i6), indexOutOfBoundsException);
        Locale locale = Locale.US;
    }

    public C1549e7(IndexOutOfBoundsException indexOutOfBoundsException) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.", indexOutOfBoundsException);
    }

    public C1549e7(String str, int i6, IOException iOException) {
        super(str + ", status code: " + i6, iOException);
    }
}
