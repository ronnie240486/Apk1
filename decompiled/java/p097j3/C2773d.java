package p097j3;

import androidx.leanback.widget.C0476j1;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicReference;
import p049e3.C2378a0;
import p086i3.C2688d;
import p086i3.C2693i;
import p186r3.AbstractC3597a;
import p228v2.C3981h;
import p247x2.InterfaceC4102x;

public final class C2773d implements InterfaceC2770a {

    public static final C2773d f9488b = new C2773d(0);

    public final int f9489a;

    public C2773d(int i6) {
        this.f9489a = i6;
    }

    @Override
    public final InterfaceC4102x mo89e(InterfaceC4102x interfaceC4102x, C3981h c3981h) {
        C0476j1 c0476j1;
        byte[] bArrArray;
        switch (this.f9489a) {
            case 0:
                return interfaceC4102x;
            default:
                ByteBuffer byteBufferAsReadOnlyBuffer = ((C2693i) ((C2688d) interfaceC4102x.get()).f9337a.f9336b).f9354a.f12824d.asReadOnlyBuffer();
                AtomicReference atomicReference = AbstractC3597a.f12090a;
                if (byteBufferAsReadOnlyBuffer.isReadOnly() || !byteBufferAsReadOnlyBuffer.hasArray()) {
                    c0476j1 = null;
                } else {
                    byte[] bArrArray2 = byteBufferAsReadOnlyBuffer.array();
                    int iArrayOffset = byteBufferAsReadOnlyBuffer.arrayOffset();
                    int iLimit = byteBufferAsReadOnlyBuffer.limit();
                    c0476j1 = new C0476j1();
                    c0476j1.f2353c = bArrArray2;
                    c0476j1.f2351a = iArrayOffset;
                    c0476j1.f2352b = iLimit;
                }
                if (c0476j1 == null || c0476j1.f2351a != 0) {
                    ByteBuffer byteBufferAsReadOnlyBuffer2 = byteBufferAsReadOnlyBuffer.asReadOnlyBuffer();
                    byte[] bArr = new byte[byteBufferAsReadOnlyBuffer2.limit()];
                    byteBufferAsReadOnlyBuffer2.get(bArr);
                    bArrArray = bArr;
                } else {
                    if (c0476j1.f2352b == ((byte[]) c0476j1.f2353c).length) {
                        bArrArray = byteBufferAsReadOnlyBuffer.array();
                    } else {
                        ByteBuffer byteBufferAsReadOnlyBuffer3 = byteBufferAsReadOnlyBuffer.asReadOnlyBuffer();
                        byte[] bArr2 = new byte[byteBufferAsReadOnlyBuffer3.limit()];
                        byteBufferAsReadOnlyBuffer3.get(bArr2);
                        bArrArray = bArr2;
                    }
                }
                return new C2378a0(bArrArray);
        }
    }
}
