package okio;

import com.lzy.okgo.cache.CacheEntity;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import p103j9.AbstractC2793f;
import p103j9.AbstractC2796i;

public final class HashingSource extends ForwardingSource implements Source {
    public static final Companion Companion = new Companion(null);
    private final Mac mac;
    private final MessageDigest messageDigest;

    public static final class Companion {
        public Companion(AbstractC2793f abstractC2793f) {
            this();
        }

        public final HashingSource hmacSha1(Source source, ByteString byteString) {
            AbstractC2796i.m5785f(source, "source");
            AbstractC2796i.m5785f(byteString, CacheEntity.KEY);
            return new HashingSource(source, byteString, "HmacSHA1");
        }

        public final HashingSource hmacSha256(Source source, ByteString byteString) {
            AbstractC2796i.m5785f(source, "source");
            AbstractC2796i.m5785f(byteString, CacheEntity.KEY);
            return new HashingSource(source, byteString, "HmacSHA256");
        }

        public final HashingSource hmacSha512(Source source, ByteString byteString) {
            AbstractC2796i.m5785f(source, "source");
            AbstractC2796i.m5785f(byteString, CacheEntity.KEY);
            return new HashingSource(source, byteString, "HmacSHA512");
        }

        public final HashingSource md5(Source source) {
            AbstractC2796i.m5785f(source, "source");
            return new HashingSource(source, "MD5");
        }

        public final HashingSource sha1(Source source) {
            AbstractC2796i.m5785f(source, "source");
            return new HashingSource(source, "SHA-1");
        }

        public final HashingSource sha256(Source source) {
            AbstractC2796i.m5785f(source, "source");
            return new HashingSource(source, "SHA-256");
        }

        public final HashingSource sha512(Source source) {
            AbstractC2796i.m5785f(source, "source");
            return new HashingSource(source, "SHA-512");
        }

        private Companion() {
        }
    }

    public HashingSource(Source source, MessageDigest messageDigest) {
        super(source);
        AbstractC2796i.m5785f(source, "source");
        AbstractC2796i.m5785f(messageDigest, "digest");
        this.messageDigest = messageDigest;
        this.mac = null;
    }

    public static final HashingSource hmacSha1(Source source, ByteString byteString) {
        return Companion.hmacSha1(source, byteString);
    }

    public static final HashingSource hmacSha256(Source source, ByteString byteString) {
        return Companion.hmacSha256(source, byteString);
    }

    public static final HashingSource hmacSha512(Source source, ByteString byteString) {
        return Companion.hmacSha512(source, byteString);
    }

    public static final HashingSource md5(Source source) {
        return Companion.md5(source);
    }

    public static final HashingSource sha1(Source source) {
        return Companion.sha1(source);
    }

    public static final HashingSource sha256(Source source) {
        return Companion.sha256(source);
    }

    public static final HashingSource sha512(Source source) {
        return Companion.sha512(source);
    }

    public final ByteString m8578deprecated_hash() {
        return hash();
    }

    public final ByteString hash() {
        byte[] bArrDoFinal;
        MessageDigest messageDigest = this.messageDigest;
        if (messageDigest != null) {
            bArrDoFinal = messageDigest.digest();
        } else {
            Mac mac = this.mac;
            AbstractC2796i.m5782c(mac);
            bArrDoFinal = mac.doFinal();
        }
        AbstractC2796i.m5782c(bArrDoFinal);
        return new ByteString(bArrDoFinal);
    }

    @Override
    public long read(Buffer buffer, long j10) throws IOException {
        AbstractC2796i.m5785f(buffer, "sink");
        long j11 = super.read(buffer, j10);
        if (j11 != -1) {
            long size = buffer.size() - j11;
            long size2 = buffer.size();
            Segment segment = buffer.head;
            AbstractC2796i.m5782c(segment);
            while (size2 > size) {
                segment = segment.prev;
                AbstractC2796i.m5782c(segment);
                size2 -= (long) (segment.limit - segment.pos);
            }
            while (size2 < buffer.size()) {
                int i6 = (int) ((((long) segment.pos) + size) - size2);
                MessageDigest messageDigest = this.messageDigest;
                if (messageDigest != null) {
                    messageDigest.update(segment.data, i6, segment.limit - i6);
                } else {
                    Mac mac = this.mac;
                    AbstractC2796i.m5782c(mac);
                    mac.update(segment.data, i6, segment.limit - i6);
                }
                size2 += (long) (segment.limit - segment.pos);
                segment = segment.next;
                AbstractC2796i.m5782c(segment);
                size = size2;
            }
        }
        return j11;
    }

    public HashingSource(Source source, String str) throws NoSuchAlgorithmException {
        AbstractC2796i.m5785f(source, "source");
        AbstractC2796i.m5785f(str, "algorithm");
        MessageDigest messageDigest = MessageDigest.getInstance(str);
        AbstractC2796i.m5784e(messageDigest, "getInstance(...)");
        this(source, messageDigest);
    }

    public HashingSource(Source source, Mac mac) {
        super(source);
        AbstractC2796i.m5785f(source, "source");
        AbstractC2796i.m5785f(mac, "mac");
        this.mac = mac;
        this.messageDigest = null;
    }

    public HashingSource(Source source, ByteString byteString, String str) throws NoSuchAlgorithmException {
        AbstractC2796i.m5785f(source, "source");
        AbstractC2796i.m5785f(byteString, CacheEntity.KEY);
        AbstractC2796i.m5785f(str, "algorithm");
        try {
            Mac mac = Mac.getInstance(str);
            mac.init(new SecretKeySpec(byteString.toByteArray(), str));
            this(source, mac);
        } catch (InvalidKeyException e5) {
            throw new IllegalArgumentException(e5);
        }
    }
}
