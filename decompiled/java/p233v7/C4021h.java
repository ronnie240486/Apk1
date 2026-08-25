package p233v7;

import androidx.media3.exoplayer.hls.playlist.HlsMediaPlaylist;
import com.lzy.okgo.https.HttpsUtils;
import com.lzy.okgo.model.HttpHeaders;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.concurrent.ConcurrentLinkedQueue;
import javax.net.ssl.HttpsURLConnection;
import org.bitspark.android.utils.C3330l;
import p187r4.C3624n;
import ua.RunnableC3940a;

public final class C4021h extends AbstractC4017d {
    @Override
    public final C4019f mo8006a(C3624n c3624n, String str, String str2) throws IOException {
        byte[] bArr;
        int i6;
        C4015b c4015b = new C4015b((short) (Math.random() * 65535.0d), str2);
        byte[] bArrM8005a = c4015b.m8005a();
        HttpsUtils.SSLParams sslSocketFactory = HttpsUtils.getSslSocketFactory();
        C3330l c3330l = new C3330l(1);
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) new URL(str).openConnection();
        httpsURLConnection.setHostnameVerifier(c3330l);
        httpsURLConnection.setSSLSocketFactory(sslSocketFactory.sSLSocketFactory);
        int i10 = this.f13625c * 1000;
        httpsURLConnection.setConnectTimeout(i10);
        httpsURLConnection.setReadTimeout(i10);
        httpsURLConnection.setDoOutput(true);
        httpsURLConnection.setRequestMethod(HlsMediaPlaylist.Interstitial.CUE_TRIGGER_POST);
        httpsURLConnection.setRequestProperty("Content-Type", "application/dns-message");
        httpsURLConnection.setRequestProperty("Accept", "application/dns-message");
        httpsURLConnection.setRequestProperty(HttpHeaders.HEAD_KEY_ACCEPT_ENCODING, "");
        DataOutputStream dataOutputStream = new DataOutputStream(httpsURLConnection.getOutputStream());
        ((ConcurrentLinkedQueue) c3624n.f12182b).add(new RunnableC3940a(httpsURLConnection, 3, dataOutputStream));
        dataOutputStream.write(bArrM8005a);
        dataOutputStream.close();
        int responseCode = httpsURLConnection.getResponseCode();
        InputStream errorStream = null;
        if (responseCode != 200) {
            try {
                errorStream = httpsURLConnection.getErrorStream();
                if (errorStream != null && (i6 = errorStream.read((bArr = new byte[256]))) > 0) {
                    throw new IOException("DoH HTTP " + responseCode + " from " + str + ", errorBody=" + new String(bArr, 0, i6));
                }
                if (errorStream != null) {
                    try {
                        errorStream.close();
                    } catch (IOException unused) {
                    }
                }
            } catch (Exception unused2) {
                if (errorStream != null) {
                    errorStream.close();
                }
            } catch (Throwable th) {
                if (errorStream != null) {
                    try {
                        errorStream.close();
                    } catch (IOException unused3) {
                    }
                }
                throw th;
            }
            throw new IOException("DoH HTTP " + responseCode + " from " + str);
        }
        try {
            InputStream inputStream = httpsURLConnection.getInputStream();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Math.max(512, httpsURLConnection.getContentLength()));
            byte[] bArr2 = new byte[8192];
            int i11 = 0;
            while (true) {
                int i12 = inputStream.read(bArr2);
                if (i12 == -1) {
                    if (i11 > 0) {
                        C4019f c4019f = new C4019f(str, 5, c4015b, byteArrayOutputStream.toByteArray());
                        try {
                            inputStream.close();
                        } catch (IOException unused4) {
                        }
                        return c4019f;
                    }
                    throw new IOException("DoH response empty from " + str);
                }
                if (i12 != 0) {
                    i11 += i12;
                    if (i11 > 1048576) {
                        throw new IOException("DoH response too large from " + str + ": " + i11);
                    }
                    byteArrayOutputStream.write(bArr2, 0, i12);
                }
            }
        } catch (Throwable th2) {
            if (0 != 0) {
                try {
                    errorStream.close();
                } catch (IOException unused5) {
                }
            }
            throw th2;
        }
    }
}
