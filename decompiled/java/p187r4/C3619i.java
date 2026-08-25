package p187r4;

import android.util.Log;
import androidx.media3.exoplayer.rtsp.SessionDescription;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaLoadRequestData;
import com.google.android.gms.cast.MediaQueueData;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p165p4.C3362g;
import p230v4.AbstractC3987a;
import p230v4.C3988b;
import p230v4.C3995i;
import p230v4.C3998l;
import p230v4.InterfaceC3999m;

public final class C3619i extends AbstractC3625o {

    public final int f12166u;

    public final C3616f f12167v;

    public final Object f12168w;

    public C3619i(C3616f c3616f, Object obj, int i6) {
        super(c3616f, false);
        this.f12166u = i6;
        this.f12168w = obj;
        this.f12167v = c3616f;
    }

    @Override
    public final void mo7323k0() {
        Object obj = this.f12168w;
        C3616f c3616f = this.f12167v;
        int i6 = 0;
        switch (this.f12166u) {
            case 0:
                C3998l c3998l = c3616f.f12150c;
                InterfaceC3999m interfaceC3999mM7344l0 = m7344l0();
                int[] iArr = (int[]) obj;
                c3998l.getClass();
                JSONObject jSONObject = new JSONObject();
                long jM7999b = c3998l.m7999b();
                try {
                    jSONObject.put("requestId", jM7999b);
                    jSONObject.put(SessionDescription.ATTR_TYPE, "QUEUE_GET_ITEMS");
                    jSONObject.put("mediaSessionId", c3998l.m7991p());
                    JSONArray jSONArray = new JSONArray();
                    int length = iArr.length;
                    while (i6 < length) {
                        jSONArray.put(iArr[i6]);
                        i6++;
                    }
                    jSONObject.put("itemIds", jSONArray);
                    break;
                } catch (JSONException unused) {
                }
                c3998l.m8000c(jM7999b, jSONObject.toString());
                c3998l.f13545t.m7992a(jM7999b, interfaceC3999mM7344l0);
                return;
            case 1:
                C3998l c3998l2 = c3616f.f12150c;
                InterfaceC3999m interfaceC3999mM7344l1 = m7344l0();
                c3998l2.getClass();
                MediaLoadRequestData mediaLoadRequestData = (MediaLoadRequestData) obj;
                MediaInfo mediaInfo = mediaLoadRequestData.f4662a;
                MediaQueueData mediaQueueData = mediaLoadRequestData.f4663b;
                if (mediaInfo == null && mediaQueueData == null) {
                    throw new IllegalArgumentException("MediaInfo and MediaQueueData should not be both null");
                }
                JSONObject jSONObject2 = new JSONObject();
                try {
                    MediaInfo mediaInfo2 = mediaLoadRequestData.f4662a;
                    if (mediaInfo2 != null) {
                        jSONObject2.put("media", mediaInfo2.m3591j());
                    }
                    if (mediaQueueData != null) {
                        jSONObject2.put("queueData", mediaQueueData.m3598j());
                    }
                    jSONObject2.putOpt("autoplay", mediaLoadRequestData.f4664c);
                    long j10 = mediaLoadRequestData.f4665d;
                    if (j10 != -1) {
                        Pattern pattern = AbstractC3987a.f13519a;
                        jSONObject2.put("currentTime", j10 / 1000.0d);
                    }
                    jSONObject2.put("playbackRate", mediaLoadRequestData.f4666e);
                    jSONObject2.putOpt("credentials", mediaLoadRequestData.f4670i);
                    jSONObject2.putOpt("credentialsType", mediaLoadRequestData.f4671j);
                    jSONObject2.putOpt("atvCredentials", mediaLoadRequestData.f4672k);
                    jSONObject2.putOpt("atvCredentialsType", mediaLoadRequestData.f4673l);
                    long[] jArr = mediaLoadRequestData.f4667f;
                    if (jArr != null) {
                        JSONArray jSONArray2 = new JSONArray();
                        for (int i10 = 0; i10 < jArr.length; i10++) {
                            jSONArray2.put(i10, jArr[i10]);
                        }
                        jSONObject2.put("activeTrackIds", jSONArray2);
                    }
                    jSONObject2.putOpt("customData", mediaLoadRequestData.f4669h);
                    jSONObject2.put("requestId", mediaLoadRequestData.f4674m);
                    break;
                } catch (JSONException e5) {
                    Object[] objArr = {e5};
                    C3988b c3988b = MediaLoadRequestData.f4661n;
                    Log.e(c3988b.f13521a, c3988b.m7977d("Error transforming MediaLoadRequestData into JSONObject", objArr));
                    jSONObject2 = new JSONObject();
                }
                long jM7999b2 = c3998l2.m7999b();
                try {
                    jSONObject2.put("requestId", jM7999b2);
                    jSONObject2.put(SessionDescription.ATTR_TYPE, "LOAD");
                    break;
                } catch (JSONException unused2) {
                }
                c3998l2.m8000c(jM7999b2, jSONObject2.toString());
                c3998l2.f13535j.m7992a(jM7999b2, interfaceC3999mM7344l1);
                return;
            case 2:
                C3998l c3998l3 = c3616f.f12150c;
                InterfaceC3999m interfaceC3999mM7344l2 = m7344l0();
                c3998l3.getClass();
                JSONObject jSONObject3 = new JSONObject();
                long jM7999b3 = c3998l3.m7999b();
                C3362g c3362g = (C3362g) obj;
                long j11 = c3362g.f11354b ? 4294967296000L : c3362g.f11353a;
                try {
                    jSONObject3.put("requestId", jM7999b3);
                    jSONObject3.put(SessionDescription.ATTR_TYPE, "SEEK");
                    jSONObject3.put("mediaSessionId", c3998l3.m7991p());
                    Pattern pattern2 = AbstractC3987a.f13519a;
                    jSONObject3.put("currentTime", j11 / 1000.0d);
                    break;
                } catch (JSONException unused3) {
                }
                c3998l3.m8000c(jM7999b3, jSONObject3.toString());
                c3998l3.f13532g = Long.valueOf(j11);
                c3998l3.f13538m.m7992a(jM7999b3, new C3995i(c3998l3, interfaceC3999mM7344l2, i6));
                return;
            default:
                C3998l c3998l4 = c3616f.f12150c;
                InterfaceC3999m interfaceC3999mM7344l3 = m7344l0();
                c3998l4.getClass();
                long[] jArr2 = (long[]) obj;
                JSONObject jSONObject4 = new JSONObject();
                long jM7999b4 = c3998l4.m7999b();
                try {
                    jSONObject4.put("requestId", jM7999b4);
                    jSONObject4.put(SessionDescription.ATTR_TYPE, "EDIT_TRACKS_INFO");
                    jSONObject4.put("mediaSessionId", c3998l4.m7991p());
                    JSONArray jSONArray3 = new JSONArray();
                    while (i6 < jArr2.length) {
                        jSONArray3.put(i6, jArr2[i6]);
                        i6++;
                    }
                    jSONObject4.put("activeTrackIds", jSONArray3);
                    break;
                } catch (JSONException unused4) {
                }
                c3998l4.m8000c(jM7999b4, jSONObject4.toString());
                c3998l4.f13542q.m7992a(jM7999b4, interfaceC3999mM7344l3);
                return;
        }
    }

    public C3619i(C3616f c3616f, int[] iArr) {
        super(c3616f, true);
        this.f12166u = 0;
        this.f12168w = iArr;
        this.f12167v = c3616f;
    }
}
