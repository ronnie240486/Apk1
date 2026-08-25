package p208t2;

import android.util.Log;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import p000a.AbstractC0004e;

public final class C3802c {

    public ByteBuffer f12818b;

    public C3801b f12819c;

    public final byte[] f12817a = new byte[256];

    public int f12820d = 0;

    public final boolean m7571a() {
        return this.f12819c.f12807b != 0;
    }

    public final C3801b m7572b() {
        byte[] bArr;
        if (this.f12818b == null) {
            throw new IllegalStateException("You must call setData() before parseHeader()");
        }
        if (m7571a()) {
            return this.f12819c;
        }
        StringBuilder sb = new StringBuilder();
        for (int i6 = 0; i6 < 6; i6++) {
            sb.append((char) m7573c());
        }
        if (sb.toString().startsWith("GIF")) {
            this.f12819c.f12811f = this.f12818b.getShort();
            this.f12819c.f12812g = this.f12818b.getShort();
            int iM7573c = m7573c();
            C3801b c3801b = this.f12819c;
            c3801b.f12813h = (iM7573c & 128) != 0;
            c3801b.f12814i = (int) Math.pow(2.0d, (iM7573c & 7) + 1);
            this.f12819c.f12815j = m7573c();
            C3801b c3801b2 = this.f12819c;
            m7573c();
            c3801b2.getClass();
            if (this.f12819c.f12813h && !m7571a()) {
                C3801b c3801b3 = this.f12819c;
                c3801b3.f12806a = m7575e(c3801b3.f12814i);
                C3801b c3801b4 = this.f12819c;
                c3801b4.f12816k = c3801b4.f12806a[c3801b4.f12815j];
            }
        } else {
            this.f12819c.f12807b = 1;
        }
        if (!m7571a()) {
            boolean z7 = false;
            while (!z7 && !m7571a() && this.f12819c.f12808c <= Integer.MAX_VALUE) {
                int iM7573c2 = m7573c();
                if (iM7573c2 == 33) {
                    int iM7573c3 = m7573c();
                    if (iM7573c3 == 1) {
                        m7576f();
                    } else if (iM7573c3 == 249) {
                        this.f12819c.f12809d = new C3800a();
                        m7573c();
                        int iM7573c4 = m7573c();
                        C3800a c3800a = this.f12819c.f12809d;
                        int i10 = (iM7573c4 & 28) >> 2;
                        c3800a.f12801g = i10;
                        if (i10 == 0) {
                            c3800a.f12801g = 1;
                        }
                        c3800a.f12800f = (iM7573c4 & 1) != 0;
                        short s10 = this.f12818b.getShort();
                        if (s10 < 2) {
                            s10 = 10;
                        }
                        C3800a c3800a2 = this.f12819c.f12809d;
                        c3800a2.f12803i = s10 * 10;
                        c3800a2.f12802h = m7573c();
                        m7573c();
                    } else if (iM7573c3 == 254) {
                        m7576f();
                    } else if (iM7573c3 != 255) {
                        m7576f();
                    } else {
                        m7574d();
                        StringBuilder sb2 = new StringBuilder();
                        int i11 = 0;
                        while (true) {
                            bArr = this.f12817a;
                            if (i11 >= 11) {
                                break;
                            }
                            sb2.append((char) bArr[i11]);
                            i11++;
                        }
                        if (sb2.toString().equals("NETSCAPE2.0")) {
                            do {
                                m7574d();
                                if (bArr[0] == 1) {
                                    byte b8 = bArr[1];
                                    byte b10 = bArr[2];
                                    this.f12819c.getClass();
                                }
                                if (this.f12820d <= 0) {
                                    break;
                                }
                            } while (!m7571a());
                        } else {
                            m7576f();
                        }
                    }
                } else if (iM7573c2 == 44) {
                    C3801b c3801b5 = this.f12819c;
                    if (c3801b5.f12809d == null) {
                        c3801b5.f12809d = new C3800a();
                    }
                    c3801b5.f12809d.f12795a = this.f12818b.getShort();
                    this.f12819c.f12809d.f12796b = this.f12818b.getShort();
                    this.f12819c.f12809d.f12797c = this.f12818b.getShort();
                    this.f12819c.f12809d.f12798d = this.f12818b.getShort();
                    int iM7573c5 = m7573c();
                    boolean z10 = (iM7573c5 & 128) != 0;
                    int iPow = (int) Math.pow(2.0d, (iM7573c5 & 7) + 1);
                    C3800a c3800a3 = this.f12819c.f12809d;
                    c3800a3.f12799e = (iM7573c5 & 64) != 0;
                    if (z10) {
                        c3800a3.f12805k = m7575e(iPow);
                    } else {
                        c3800a3.f12805k = null;
                    }
                    this.f12819c.f12809d.f12804j = this.f12818b.position();
                    m7573c();
                    m7576f();
                    if (!m7571a()) {
                        C3801b c3801b6 = this.f12819c;
                        c3801b6.f12808c++;
                        c3801b6.f12810e.add(c3801b6.f12809d);
                    }
                } else if (iM7573c2 != 59) {
                    this.f12819c.f12807b = 1;
                } else {
                    z7 = true;
                }
            }
            C3801b c3801b7 = this.f12819c;
            if (c3801b7.f12808c < 0) {
                c3801b7.f12807b = 1;
            }
        }
        return this.f12819c;
    }

    public final int m7573c() {
        try {
            return this.f12818b.get() & 255;
        } catch (Exception unused) {
            this.f12819c.f12807b = 1;
            return 0;
        }
    }

    public final void m7574d() {
        int iM7573c = m7573c();
        this.f12820d = iM7573c;
        if (iM7573c <= 0) {
            return;
        }
        int i6 = 0;
        int i10 = 0;
        while (true) {
            try {
                int i11 = this.f12820d;
                if (i6 >= i11) {
                    return;
                }
                i10 = i11 - i6;
                this.f12818b.get(this.f12817a, i6, i10);
                i6 += i10;
            } catch (Exception e5) {
                if (Log.isLoggable("GifHeaderParser", 3)) {
                    StringBuilder sbM28v = AbstractC0004e.m28v("Error Reading Block n: ", i6, " count: ", i10, " blockSize: ");
                    sbM28v.append(this.f12820d);
                    Log.d("GifHeaderParser", sbM28v.toString(), e5);
                }
                this.f12819c.f12807b = 1;
                return;
            }
        }
    }

    public final int[] m7575e(int i6) {
        byte[] bArr = new byte[i6 * 3];
        int[] iArr = null;
        try {
            this.f12818b.get(bArr);
            iArr = new int[256];
            int i10 = 0;
            int i11 = 0;
            while (i10 < i6) {
                int i12 = bArr[i11] & 255;
                int i13 = i11 + 2;
                int i14 = bArr[i11 + 1] & 255;
                i11 += 3;
                int i15 = i10 + 1;
                iArr[i10] = (i14 << 8) | (i12 << 16) | (-16777216) | (bArr[i13] & 255);
                i10 = i15;
            }
        } catch (BufferUnderflowException e5) {
            if (Log.isLoggable("GifHeaderParser", 3)) {
                Log.d("GifHeaderParser", "Format Error Reading Color Table", e5);
            }
            this.f12819c.f12807b = 1;
        }
        return iArr;
    }

    public final void m7576f() {
        int iM7573c;
        do {
            iM7573c = m7573c();
            this.f12818b.position(Math.min(this.f12818b.position() + iM7573c, this.f12818b.limit()));
        } while (iM7573c > 0);
    }
}
