package p049e3;

import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import p000a.AbstractC0004e;
import p001a0.C0019b;
import p186r3.AbstractC3602f;
import p228v2.InterfaceC3977d;
import p259y2.C4243f;

public final class C2395m implements InterfaceC3977d {

    public static final byte[] f8355a = "Exif\u0000\u0000".getBytes(Charset.forName("UTF-8"));

    public static final int[] f8356b = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};

    public static int m5418e(InterfaceC2394l interfaceC2394l, C4243f c4243f) {
        try {
            int iMo92h = interfaceC2394l.mo92h();
            if (!((iMo92h & 65496) == 65496 || iMo92h == 19789 || iMo92h == 18761)) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Parser doesn't handle magic number: " + iMo92h);
                }
                return -1;
            }
            int iM5420g = m5420g(interfaceC2394l);
            if (iM5420g == -1) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Failed to parse exif segment length, or exif segment not found");
                }
                return -1;
            }
            byte[] bArr = (byte[]) c4243f.m8287d(iM5420g, byte[].class);
            try {
                return m5421h(interfaceC2394l, bArr, iM5420g);
            } finally {
                c4243f.m8291h(bArr);
            }
        } catch (C2393k unused) {
            return -1;
        }
    }

    public static ImageHeaderParser$ImageType m5419f(InterfaceC2394l interfaceC2394l) {
        try {
            int iMo92h = interfaceC2394l.mo92h();
            if (iMo92h == 65496) {
                return ImageHeaderParser$ImageType.JPEG;
            }
            int iMo88d = (iMo92h << 8) | interfaceC2394l.mo88d();
            if (iMo88d == 4671814) {
                return ImageHeaderParser$ImageType.GIF;
            }
            int iMo88d2 = (iMo88d << 8) | interfaceC2394l.mo88d();
            if (iMo88d2 == -1991225785) {
                interfaceC2394l.skip(21L);
                try {
                    return interfaceC2394l.mo88d() >= 3 ? ImageHeaderParser$ImageType.PNG_A : ImageHeaderParser$ImageType.PNG;
                } catch (C2393k unused) {
                    return ImageHeaderParser$ImageType.PNG;
                }
            }
            if (iMo88d2 == 1380533830) {
                interfaceC2394l.skip(4L);
                if (((interfaceC2394l.mo92h() << 16) | interfaceC2394l.mo92h()) != 1464156752) {
                    return ImageHeaderParser$ImageType.UNKNOWN;
                }
                int iMo92h2 = (interfaceC2394l.mo92h() << 16) | interfaceC2394l.mo92h();
                if ((iMo92h2 & (-256)) != 1448097792) {
                    return ImageHeaderParser$ImageType.UNKNOWN;
                }
                int i6 = iMo92h2 & 255;
                if (i6 != 88) {
                    if (i6 != 76) {
                        return ImageHeaderParser$ImageType.WEBP;
                    }
                    interfaceC2394l.skip(4L);
                    return (interfaceC2394l.mo88d() & 8) != 0 ? ImageHeaderParser$ImageType.WEBP_A : ImageHeaderParser$ImageType.WEBP;
                }
                interfaceC2394l.skip(4L);
                short sMo88d = interfaceC2394l.mo88d();
                if ((sMo88d & 2) != 0) {
                    return ImageHeaderParser$ImageType.ANIMATED_WEBP;
                }
                return (sMo88d & 16) != 0 ? ImageHeaderParser$ImageType.WEBP_A : ImageHeaderParser$ImageType.WEBP;
            }
            if (((interfaceC2394l.mo92h() << 16) | interfaceC2394l.mo92h()) != 1718909296) {
                return ImageHeaderParser$ImageType.UNKNOWN;
            }
            int iMo92h3 = (interfaceC2394l.mo92h() << 16) | interfaceC2394l.mo92h();
            if (iMo92h3 == 1635150195) {
                return ImageHeaderParser$ImageType.ANIMATED_AVIF;
            }
            int i10 = 0;
            boolean z7 = iMo92h3 == 1635150182;
            interfaceC2394l.skip(4L);
            int i11 = iMo88d2 - 16;
            if (i11 % 4 == 0) {
                while (i10 < 5 && i11 > 0) {
                    int iMo92h4 = (interfaceC2394l.mo92h() << 16) | interfaceC2394l.mo92h();
                    if (iMo92h4 == 1635150195) {
                        return ImageHeaderParser$ImageType.ANIMATED_AVIF;
                    }
                    if (iMo92h4 == 1635150182) {
                        z7 = true;
                    }
                    i10++;
                    i11 -= 4;
                }
            }
            return z7 ? ImageHeaderParser$ImageType.AVIF : ImageHeaderParser$ImageType.UNKNOWN;
        } catch (C2393k unused2) {
            return ImageHeaderParser$ImageType.UNKNOWN;
        }
    }

    public static int m5420g(InterfaceC2394l interfaceC2394l) {
        short sMo88d;
        int iMo92h;
        long j10;
        long jSkip;
        do {
            short sMo88d2 = interfaceC2394l.mo88d();
            if (sMo88d2 != 255) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Unknown segmentId=" + ((int) sMo88d2));
                }
                return -1;
            }
            sMo88d = interfaceC2394l.mo88d();
            if (sMo88d == 218) {
                return -1;
            }
            if (sMo88d == 217) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Found MARKER_EOI in exif segment");
                }
                return -1;
            }
            iMo92h = interfaceC2394l.mo92h() - 2;
            if (sMo88d == 225) {
                return iMo92h;
            }
            j10 = iMo92h;
            jSkip = interfaceC2394l.skip(j10);
        } while (jSkip == j10);
        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
            StringBuilder sbM28v = AbstractC0004e.m28v("Unable to skip enough data, type: ", sMo88d, ", wanted to skip: ", iMo92h, ", but actually skipped: ");
            sbM28v.append(jSkip);
            Log.d("DfltImageHeaderParser", sbM28v.toString());
        }
        return -1;
    }

    public static int m5421h(InterfaceC2394l interfaceC2394l, byte[] bArr, int i6) {
        ByteOrder byteOrder;
        int iMo87c = interfaceC2394l.mo87c(bArr, i6);
        if (iMo87c != i6) {
            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                Log.d("DfltImageHeaderParser", "Unable to read exif segment data, length: " + i6 + ", actually read: " + iMo87c);
            }
            return -1;
        }
        short s10 = 1;
        int i10 = 0;
        byte[] bArr2 = f8355a;
        boolean z7 = bArr != null && i6 > bArr2.length;
        if (z7) {
            for (int i11 = 0; i11 < bArr2.length; i11++) {
                if (bArr[i11] != bArr2[i11]) {
                    z7 = false;
                    break;
                }
            }
        }
        if (!z7) {
            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                Log.d("DfltImageHeaderParser", "Missing jpeg exif preamble");
            }
            return -1;
        }
        C2392j c2392j = new C2392j(bArr, i6);
        short sM5417f = c2392j.m5417f(6);
        if (sM5417f != 18761) {
            if (sM5417f != 19789 && Log.isLoggable("DfltImageHeaderParser", 3)) {
                Log.d("DfltImageHeaderParser", "Unknown endianness = " + ((int) sM5417f));
            }
            byteOrder = ByteOrder.BIG_ENDIAN;
        } else {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        }
        ByteBuffer byteBuffer = c2392j.f8354b;
        byteBuffer.order(byteOrder);
        int i12 = byteBuffer.remaining() - 10 >= 4 ? byteBuffer.getInt(10) : -1;
        short sM5417f2 = c2392j.m5417f(i12 + 6);
        while (i10 < sM5417f2) {
            int i13 = (i10 * 12) + i12 + 8;
            short sM5417f3 = c2392j.m5417f(i13);
            if (sM5417f3 == 274) {
                short sM5417f4 = c2392j.m5417f(i13 + 2);
                if (sM5417f4 >= s10 && sM5417f4 <= 12) {
                    int i14 = i13 + 4;
                    int i15 = byteBuffer.remaining() - i14 >= 4 ? byteBuffer.getInt(i14) : -1;
                    if (i15 >= 0) {
                        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                            StringBuilder sbM28v = AbstractC0004e.m28v("Got tagIndex=", i10, " tagType=", sM5417f3, " formatCode=");
                            sbM28v.append((int) sM5417f4);
                            sbM28v.append(" componentCount=");
                            sbM28v.append(i15);
                            Log.d("DfltImageHeaderParser", sbM28v.toString());
                        }
                        int i16 = i15 + f8356b[sM5417f4];
                        if (i16 <= 4) {
                            int i17 = i13 + 8;
                            if (i17 >= 0 && i17 <= byteBuffer.remaining()) {
                                if (i16 >= 0 && i16 + i17 <= byteBuffer.remaining()) {
                                    return c2392j.m5417f(i17);
                                }
                                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                    Log.d("DfltImageHeaderParser", "Illegal number of bytes for TI tag data tagType=" + ((int) sM5417f3));
                                }
                            } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                Log.d("DfltImageHeaderParser", "Illegal tagValueOffset=" + i17 + " tagType=" + ((int) sM5417f3));
                            }
                        } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                            Log.d("DfltImageHeaderParser", "Got byte count > 4, not orientation, continuing, formatCode=" + ((int) sM5417f4));
                        }
                    } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                        Log.d("DfltImageHeaderParser", "Negative tiff component count");
                    }
                } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Got invalid format code = " + ((int) sM5417f4));
                }
            }
            i10++;
            s10 = 1;
        }
        return -1;
    }

    @Override
    public final ImageHeaderParser$ImageType mo5422a(ByteBuffer byteBuffer) {
        AbstractC3602f.m7225c(byteBuffer, "Argument must not be null");
        return m5419f(new C2392j(byteBuffer, 0));
    }

    @Override
    public final int mo5423b(InputStream inputStream, C4243f c4243f) {
        C0019b c0019b = new C0019b(27, inputStream);
        AbstractC3602f.m7225c(c4243f, "Argument must not be null");
        return m5418e(c0019b, c4243f);
    }

    @Override
    public final int mo5424c(ByteBuffer byteBuffer, C4243f c4243f) {
        C2392j c2392j = new C2392j(byteBuffer, 0);
        AbstractC3602f.m7225c(c4243f, "Argument must not be null");
        return m5418e(c2392j, c4243f);
    }

    @Override
    public final ImageHeaderParser$ImageType mo5425d(InputStream inputStream) {
        return m5419f(new C0019b(27, inputStream));
    }
}
