package androidx.media3.exoplayer.rtsp;

import android.net.Uri;
import androidx.media3.common.C0565C;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UriUtil;
import androidx.media3.common.util.Util;
import com.lzy.okgo.model.Progress;
import java.util.Arrays;
import p041d7.AbstractC2182d0;
import p041d7.AbstractC2267p1;
import p041d7.AbstractC2301u1;

final class RtspTrackTiming {
    public final long rtpTimestamp;
    public final int sequenceNumber;
    public final Uri uri;

    private RtspTrackTiming(long j10, int i6, Uri uri) {
        this.rtpTimestamp = j10;
        this.sequenceNumber = i6;
        this.uri = uri;
    }

    public static AbstractC2301u1 parseTrackTiming(String str, Uri uri) throws ParserException {
        byte b8;
        AbstractC2182d0.m5141d(4, "initialCapacity");
        Object[] objArrCopyOf = new Object[4];
        String[] strArrSplit = Util.split(str, ",");
        int length = strArrSplit.length;
        char c5 = 0;
        int i6 = 0;
        int i10 = 0;
        while (i6 < length) {
            String str2 = strArrSplit[i6];
            String[] strArrSplit2 = Util.split(str2, ";");
            int length2 = strArrSplit2.length;
            int i11 = 0;
            Uri uriResolveUri = null;
            int i12 = -1;
            long j10 = C0565C.TIME_UNSET;
            while (i11 < length2) {
                String str3 = strArrSplit2[i11];
                try {
                    String[] strArrSplitAtFirst = Util.splitAtFirst(str3, "=");
                    String str4 = strArrSplitAtFirst[c5];
                    String str5 = strArrSplitAtFirst[1];
                    int iHashCode = str4.hashCode();
                    String[] strArr = strArrSplit;
                    if (iHashCode != 113759) {
                        if (iHashCode != 116079) {
                            if (iHashCode == 1524180539 && str4.equals("rtptime")) {
                                b8 = 2;
                            } else {
                                b8 = -1;
                            }
                        } else if (str4.equals(Progress.URL)) {
                            b8 = 0;
                        } else {
                            b8 = -1;
                        }
                    } else if (str4.equals("seq")) {
                        b8 = 1;
                    } else {
                        b8 = -1;
                    }
                    if (b8 == 0) {
                        uriResolveUri = resolveUri(str5, uri);
                    } else if (b8 == 1) {
                        i12 = Integer.parseInt(str5);
                    } else {
                        if (b8 != 2) {
                            throw ParserException.createForMalformedManifest(str4, null);
                        }
                        j10 = Long.parseLong(str5);
                    }
                    i11++;
                    strArrSplit = strArr;
                    c5 = 0;
                } catch (Exception e5) {
                    throw ParserException.createForMalformedManifest(str3, e5);
                }
            }
            String[] strArr2 = strArrSplit;
            if (uriResolveUri != null && uriResolveUri.getScheme() != null) {
                long j11 = j10;
                if (i12 != -1 || j11 != C0565C.TIME_UNSET) {
                    RtspTrackTiming rtspTrackTiming = new RtspTrackTiming(j11, i12, uriResolveUri);
                    int i13 = i10 + 1;
                    int iM5254f = AbstractC2267p1.m5254f(objArrCopyOf.length, i13);
                    if (iM5254f > objArrCopyOf.length) {
                        objArrCopyOf = Arrays.copyOf(objArrCopyOf, iM5254f);
                    }
                    objArrCopyOf[i10] = rtspTrackTiming;
                    i6++;
                    i10 = i13;
                    strArrSplit = strArr2;
                    c5 = 0;
                }
            }
            throw ParserException.createForMalformedManifest(str2, null);
        }
        return AbstractC2301u1.m5268j(objArrCopyOf, i10);
    }

    public static Uri resolveUri(String str, Uri uri) {
        Assertions.checkArgument(((String) Assertions.checkNotNull(uri.getScheme())).equals("rtsp"));
        Uri uri2 = Uri.parse(str);
        if (uri2.isAbsolute()) {
            return uri2;
        }
        Uri uri3 = Uri.parse("rtsp://" + str);
        String string = uri.toString();
        if (((String) Assertions.checkNotNull(uri3.getHost())).equals(uri.getHost())) {
            return uri3;
        }
        return string.endsWith("/") ? UriUtil.resolveToUri(string, str) : UriUtil.resolveToUri(string.concat("/"), str);
    }
}
