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

public final class HashingSink extends ForwardingSink implements Sink {
    public static final Companion Companion = new Companion(null);
    private final Mac mac;
    private final MessageDigest messageDigest;

    public static final class Companion {
        public Companion(AbstractC2793f abstractC2793f) {
            this();
        }

        public final HashingSink hmacSha1(Sink sink, ByteString byteString) {
            AbstractC2796i.m5785f(sink, "sink");
            AbstractC2796i.m5785f(byteString, CacheEntity.KEY);
            return new HashingSink(sink, byteString, "HmacSHA1");
        }

        public final HashingSink hmacSha256(Sink sink, ByteString byteString) {
            AbstractC2796i.m5785f(sink, "sink");
            AbstractC2796i.m5785f(byteString, CacheEntity.KEY);
            return new HashingSink(sink, byteString, "HmacSHA256");
        }

        public final HashingSink hmacSha512(Sink sink, ByteString byteString) {
            AbstractC2796i.m5785f(sink, "sink");
            AbstractC2796i.m5785f(byteString, CacheEntity.KEY);
            return new HashingSink(sink, byteString, "HmacSHA512");
        }

        public final HashingSink md5(Sink sink) {
            AbstractC2796i.m5785f(sink, "sink");
            return new HashingSink(sink, "MD5");
        }

        public final HashingSink sha1(Sink sink) {
            AbstractC2796i.m5785f(sink, "sink");
            return new HashingSink(sink, "SHA-1");
        }

        public final HashingSink sha256(Sink sink) {
            AbstractC2796i.m5785f(sink, "sink");
            return new HashingSink(sink, "SHA-256");
        }

        public final HashingSink sha512(Sink sink) {
            AbstractC2796i.m5785f(sink, "sink");
            return new HashingSink(sink, "SHA-512");
        }

        private Companion() {
        }
    }

    public HashingSink(Sink sink, MessageDigest messageDigest) {
        super(sink);
        AbstractC2796i.m5785f(sink, "sink");
        AbstractC2796i.m5785f(messageDigest, "digest");
        this.messageDigest = messageDigest;
        this.mac = null;
    }

    public static final HashingSink hmacSha1(Sink sink, ByteString byteString) {
        return Companion.hmacSha1(sink, byteString);
    }

    public static final HashingSink hmacSha256(Sink sink, ByteString byteString) {
        return Companion.hmacSha256(sink, byteString);
    }

    public static final HashingSink hmacSha512(Sink sink, ByteString byteString) {
        return Companion.hmacSha512(sink, byteString);
    }

    public static final HashingSink md5(Sink sink) {
        return Companion.md5(sink);
    }

    public static final HashingSink sha1(Sink sink) {
        return Companion.sha1(sink);
    }

    public static final HashingSink sha256(Sink sink) {
        return Companion.sha256(sink);
    }

    public static final HashingSink sha512(Sink sink) {
        return Companion.sha512(sink);
    }

    public final ByteString m8577deprecated_hash() {
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
    public void write(Buffer buffer, long j10) throws IOException {
        AbstractC2796i.m5785f(buffer, "source");
        SegmentedByteString.checkOffsetAndCount(buffer.size(), 0L, j10);
        Segment segment = buffer.head;
        AbstractC2796i.m5782c(segment);
        long j11 = 0;
        while (j11 < j10) {
            int iMin = (int) Math.min(j10 - j11, segment.limit - segment.pos);
            MessageDigest messageDigest = this.messageDigest;
            if (messageDigest != null) {
                messageDigest.update(segment.data, segment.pos, iMin);
            } else {
                Mac mac = this.mac;
                AbstractC2796i.m5782c(mac);
                mac.update(segment.data, segment.pos, iMin);
            }
            j11 += (long) iMin;
            segment = segment.next;
            AbstractC2796i.m5782c(segment);
        }
        super.write(buffer, j10);
    }

    public HashingSink(Sink sink, String str) throws NoSuchAlgorithmException {
        AbstractC2796i.m5785f(sink, "sink");
        AbstractC2796i.m5785f(str, "algorithm");
        MessageDigest messageDigest = MessageDigest.getInstance(str);
        AbstractC2796i.m5784e(messageDigest, "getInstance(...)");
        this(sink, messageDigest);
    }

    public HashingSink(Sink sink, Mac mac) {
        super(sink);
        AbstractC2796i.m5785f(sink, "sink");
        AbstractC2796i.m5785f(mac, "mac");
        this.mac = mac;
        this.messageDigest = null;
    }

    public HashingSink(Sink sink, ByteString byteString, String str) throws NoSuchAlgorithmException {
        AbstractC2796i.m5785f(sink, "sink");
        AbstractC2796i.m5785f(byteString, CacheEntity.KEY);
        AbstractC2796i.m5785f(str, "algorithm");
        try {
            Mac mac = Mac.getInstance(str);
            mac.init(new SecretKeySpec(byteString.toByteArray(), str));
            this(sink, mac);
        } catch (InvalidKeyException e5) {
            throw new IllegalArgumentException(e5);
        }
    }
}
