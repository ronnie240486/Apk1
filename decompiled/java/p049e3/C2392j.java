package p049e3;

import com.bumptech.glide.load.data.InterfaceC1481g;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.MessageDigest;
import p228v2.InterfaceC3979f;

public final class C2392j implements InterfaceC2394l, InterfaceC3979f, InterfaceC1481g {

    public final int f8353a;

    public final ByteBuffer f8354b;

    public C2392j(int i6) {
        this.f8353a = i6;
        switch (i6) {
            case 3:
                this.f8354b = ByteBuffer.allocate(4);
                break;
            default:
                this.f8354b = ByteBuffer.allocate(8);
                break;
        }
    }

    private final void m5415g(byte[] bArr, Object obj, MessageDigest messageDigest) {
        Long l9 = (Long) obj;
        messageDigest.update(bArr);
        synchronized (this.f8354b) {
            this.f8354b.position(0);
            messageDigest.update(this.f8354b.putLong(l9.longValue()).array());
        }
    }

    @Override
    public void mo5416a(byte[] bArr, Object obj, MessageDigest messageDigest) {
        switch (this.f8353a) {
            case 2:
                m5415g(bArr, obj, messageDigest);
                return;
            default:
                Integer num = (Integer) obj;
                if (num == null) {
                    return;
                }
                messageDigest.update(bArr);
                synchronized (this.f8354b) {
                    this.f8354b.position(0);
                    messageDigest.update(this.f8354b.putInt(num.intValue()).array());
                    break;
                }
                return;
        }
    }

    @Override
    public int mo87c(byte[] bArr, int i6) {
        ByteBuffer byteBuffer = this.f8354b;
        int iMin = Math.min(i6, byteBuffer.remaining());
        if (iMin == 0) {
            return -1;
        }
        byteBuffer.get(bArr, 0, iMin);
        return iMin;
    }

    @Override
    public short mo88d() throws C2393k {
        ByteBuffer byteBuffer = this.f8354b;
        if (byteBuffer.remaining() >= 1) {
            return (short) (byteBuffer.get() & 255);
        }
        throw new C2393k();
    }

    @Override
    public Object mo3551e() {
        ByteBuffer byteBuffer = this.f8354b;
        byteBuffer.position(0);
        return byteBuffer;
    }

    public short m5417f(int i6) {
        ByteBuffer byteBuffer = this.f8354b;
        if (byteBuffer.remaining() - i6 >= 2) {
            return byteBuffer.getShort(i6);
        }
        return (short) -1;
    }

    @Override
    public int mo92h() {
        return (mo88d() << 8) | mo88d();
    }

    @Override
    public long skip(long j10) {
        ByteBuffer byteBuffer = this.f8354b;
        int iMin = (int) Math.min(byteBuffer.remaining(), j10);
        byteBuffer.position(byteBuffer.position() + iMin);
        return iMin;
    }

    public C2392j(byte[] bArr, int i6) {
        this.f8353a = 1;
        this.f8354b = (ByteBuffer) ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).limit(i6);
    }

    public C2392j(ByteBuffer byteBuffer, int i6) {
        this.f8353a = i6;
        switch (i6) {
            case 4:
                this.f8354b = byteBuffer;
                break;
            default:
                this.f8354b = byteBuffer;
                byteBuffer.order(ByteOrder.BIG_ENDIAN);
                break;
        }
    }

    @Override
    public void mo3550b() {
    }
}
