package p055ea;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaLoadRequestData;
import com.google.android.gms.cast.MediaMetadata;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.Iterator;
import org.bitspark.android.Constants$VIDEO_TYPE;
import org.bitspark.android.Spark;
import org.bitspark.android.utils.C3320b;
import p003a2.AbstractC0032a;
import p018b5.AbstractC1312l;
import p176q4.C3475c;
import p187r4.C3616f;
import p187r4.C3619i;
import p193ra.C3663f;

public final class RunnableC2431b0 implements Runnable {

    public final C2448k f8519a;

    public RunnableC2431b0(C2448k c2448k) {
        this.f8519a = c2448k;
    }

    @Override
    public final void run() {
        String string;
        String hostAddress;
        C2448k c2448k = this.f8519a;
        boolean zM6712c0 = c2448k.f8630b.m6712c0();
        Spark spark = c2448k.f8630b;
        if (zM6712c0 || !spark.f11059J1.isPlaying()) {
            spark.f11059J1.pause();
        } else {
            spark.f11081R.performClick();
        }
        C3320b c3320bM6737d = C3320b.m6737d();
        boolean z7 = c3320bM6737d.f11210h;
        if (z7 && z7) {
            if (c3320bM6737d.f11208f == null) {
                C3475c c3475cM7142c = c3320bM6737d.f11206d.m7102a().m7142c();
                c3320bM6737d.f11208f = c3475cM7142c;
                if (c3475cM7142c == null) {
                    return;
                }
            }
            if (c3320bM6737d.f11210h) {
                if (c3320bM6737d.f11216n == null) {
                    C3616f c3616fM7125f = c3320bM6737d.f11208f.m7125f();
                    c3320bM6737d.f11216n = c3616fM7125f;
                    if (c3616fM7125f == null) {
                        return;
                    }
                }
                if (TextUtils.isEmpty(c3320bM6737d.f11215m)) {
                    return;
                }
                if (spark.f11044E1 == Constants$VIDEO_TYPE.BSLIVE) {
                    String string2 = C3663f.m7415b().f12272e.getName().getInit().toString();
                    String string3 = spark.f11143t1.getText().toString();
                    spark.getClass();
                    Spark.m6671Y();
                    C3320b.m6737d().f11214l = string2;
                    C3320b.m6737d().f11213k = string3;
                    C3320b.m6737d().getClass();
                    C3320b.m6737d().f11212j = 0L;
                    C3320b.m6737d().f11211i = 0L;
                }
                C3320b c3320bM6737d2 = C3320b.m6737d();
                if (c3320bM6737d2.f11210h) {
                    MediaMetadata mediaMetadata = new MediaMetadata(1);
                    String str = c3320bM6737d2.f11213k;
                    Bundle bundle = mediaMetadata.f4678b;
                    if (str != null) {
                        String strM165s = AbstractC0032a.m165s("g5Z34RDHeJOMnDSuGcxlm4mdNKga2zmXgYpu4RrNY5WEmG6uWftCtrSwToMy\n", "4Pkaz3eoF/Q=\n");
                        String str2 = c3320bM6737d2.f11213k;
                        MediaMetadata.m3593j(1, strM165s);
                        bundle.putString(strM165s, str2);
                    }
                    if (c3320bM6737d2.f11214l != null) {
                        String strM165s2 = AbstractC0032a.m165s("ZI6aN52Mq8BrhNl4lIe2yG6F2X6XkOrEZpKDN5eGsMZjgIN41LeN80uk\n", "B+H3GfrjxKc=\n");
                        String str3 = c3320bM6737d2.f11214l;
                        MediaMetadata.m3593j(1, strM165s2);
                        bundle.putString(strM165s2, str3);
                    }
                    if (c3320bM6737d2.f11215m.contains(AbstractC0032a.m165s("dgypdQ==\n", "Gz/cTddxNv0=\n"))) {
                        String str4 = c3320bM6737d2.f11215m;
                        try {
                            Iterator it = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
                            loop0: while (true) {
                                if (!it.hasNext()) {
                                    hostAddress = null;
                                    break;
                                }
                                for (InetAddress inetAddress : Collections.list(((NetworkInterface) it.next()).getInetAddresses())) {
                                    if (!inetAddress.isLoopbackAddress() && inetAddress.getHostAddress().indexOf(58) == -1) {
                                        hostAddress = inetAddress.getHostAddress();
                                        break loop0;
                                    }
                                    hostAddress = null;
                                }
                            }
                        } catch (Exception e5) {
                            e5.printStackTrace();
                        }
                        Uri uri = Uri.parse(str4);
                        Uri.Builder builderBuildUpon = uri.buildUpon();
                        StringBuilder sbM5498l = AbstractC2460q.m5498l(hostAddress);
                        sbM5498l.append(AbstractC0032a.m165s("Kw==\n", "EShGbVwqx6o=\n"));
                        sbM5498l.append(uri.getPort());
                        string = builderBuildUpon.encodedAuthority(sbM5498l.toString()).build().toString();
                    } else {
                        string = c3320bM6737d2.f11215m;
                    }
                    String str5 = string;
                    AbstractC0032a.m165s("SHMQYcwtLwEa\n", "OhZxDZlfQzs=\n");
                    String strM165s3 = AbstractC0032a.m165s("eVfXcr3VdLR/Cg==\n", "Dz6zF9KmW9k=\n");
                    long j10 = c3320bM6737d2.f11212j;
                    if (j10 < 0 && j10 != -1) {
                        throw new IllegalArgumentException("Invalid stream duration");
                    }
                    MediaInfo mediaInfo = new MediaInfo(str5, 1, strM165s3, mediaMetadata, j10, null, null, null, null, null, null, null, -1L, null, null, null, null);
                    C3616f c3616f = c3320bM6737d2.f11216n;
                    MediaLoadRequestData mediaLoadRequestData = new MediaLoadRequestData(mediaInfo, null, Boolean.TRUE, c3320bM6737d2.f11211i, 1.0d, null, null, AbstractC0032a.m165s("968luulHMunmuS68rUUs/w==\n", "gtxAyMQkQIw=\n"), null, AbstractC0032a.m165s("PNXOn0ZqH5ZwwsrXV3wUkDTA1ME=\n", "XaG4sjMZeuQ=\n"), null, 0L);
                    c3616f.getClass();
                    AbstractC1312l.m3195b("Must be called from the main thread.");
                    if (c3616f.m7296F()) {
                        C3616f.m7289G(new C3619i(c3616f, mediaLoadRequestData, 1));
                    } else {
                        C3616f.m7290x();
                    }
                }
            }
        }
    }
}
