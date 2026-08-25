package p187r4;

import android.util.Log;
import androidx.media3.exoplayer.rtsp.SessionDescription;
import com.google.android.gms.cast.MediaStatus;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
import p055ea.AbstractC2460q;
import p230v4.C3988b;
import p230v4.C3998l;
import p230v4.InterfaceC3999m;

public final class C3618h extends AbstractC3625o {

    public final int f12164u;

    public final C3616f f12165v;

    public C3618h(C3616f c3616f, int i6) {
        super(c3616f, false);
        this.f12164u = i6;
        this.f12165v = c3616f;
    }

    @Override
    public final void mo7323k0() {
        switch (this.f12164u) {
            case 0:
                this.f12165v.f12150c.m7981d(m7344l0(), -1);
                break;
            case 1:
                this.f12165v.f12150c.m7981d(m7344l0(), 1);
                break;
            case 2:
                C3998l c3998l = this.f12165v.f12150c;
                InterfaceC3999m interfaceC3999mM7344l0 = m7344l0();
                c3998l.getClass();
                JSONObject jSONObject = new JSONObject();
                long jM7999b = c3998l.m7999b();
                try {
                    jSONObject.put("requestId", jM7999b);
                    jSONObject.put(SessionDescription.ATTR_TYPE, "QUEUE_GET_ITEM_IDS");
                    jSONObject.put("mediaSessionId", c3998l.m7991p());
                    break;
                } catch (JSONException unused) {
                }
                c3998l.m8000c(jM7999b, jSONObject.toString());
                c3998l.f13544s.m7992a(jM7999b, interfaceC3999mM7344l0);
                break;
            case 3:
                C3998l c3998l2 = this.f12165v.f12150c;
                InterfaceC3999m interfaceC3999mM7344l1 = m7344l0();
                c3998l2.getClass();
                JSONObject jSONObject2 = new JSONObject();
                long jM7999b2 = c3998l2.m7999b();
                try {
                    jSONObject2.put("requestId", jM7999b2);
                    jSONObject2.put(SessionDescription.ATTR_TYPE, "PAUSE");
                    jSONObject2.put("mediaSessionId", c3998l2.m7991p());
                    break;
                } catch (JSONException unused2) {
                }
                c3998l2.m8000c(jM7999b2, jSONObject2.toString());
                c3998l2.f13536k.m7992a(jM7999b2, interfaceC3999mM7344l1);
                break;
            case 4:
                C3998l c3998l3 = this.f12165v.f12150c;
                InterfaceC3999m interfaceC3999mM7344l2 = m7344l0();
                c3998l3.getClass();
                JSONObject jSONObject3 = new JSONObject();
                long jM7999b3 = c3998l3.m7999b();
                try {
                    jSONObject3.put("requestId", jM7999b3);
                    jSONObject3.put(SessionDescription.ATTR_TYPE, "PLAY");
                    jSONObject3.put("mediaSessionId", c3998l3.m7991p());
                    break;
                } catch (JSONException unused3) {
                }
                c3998l3.m8000c(jM7999b3, jSONObject3.toString());
                c3998l3.f13537l.m7992a(jM7999b3, interfaceC3999mM7344l2);
                break;
            case 5:
                C3616f c3616f = this.f12165v;
                InterfaceC3999m interfaceC3999mM7344l3 = m7344l0();
                C3998l c3998l4 = c3616f.f12150c;
                c3998l4.getClass();
                JSONObject jSONObject4 = new JSONObject();
                long jM7999b4 = c3998l4.m7999b();
                try {
                    jSONObject4.put("requestId", jM7999b4);
                    jSONObject4.put(SessionDescription.ATTR_TYPE, "SKIP_AD");
                    jSONObject4.put("mediaSessionId", c3998l4.m7991p());
                } catch (JSONException e5) {
                    Locale locale = Locale.ROOT;
                    C3988b c3988b = c3998l4.f13557a;
                    Log.w(c3988b.f13521a, c3988b.m7977d(AbstractC2460q.m5501o("Error creating SkipAd message: ", e5.getMessage()), new Object[0]));
                }
                c3998l4.m8000c(jM7999b4, jSONObject4.toString());
                c3998l4.f13547v.m7992a(jM7999b4, interfaceC3999mM7344l3);
                break;
            default:
                C3998l c3998l5 = this.f12165v.f12150c;
                InterfaceC3999m interfaceC3999mM7344l4 = m7344l0();
                c3998l5.getClass();
                JSONObject jSONObject5 = new JSONObject();
                long jM7999b5 = c3998l5.m7999b();
                try {
                    jSONObject5.put("requestId", jM7999b5);
                    jSONObject5.put(SessionDescription.ATTR_TYPE, "GET_STATUS");
                    MediaStatus mediaStatus = c3998l5.f13531f;
                    if (mediaStatus != null) {
                        jSONObject5.put("mediaSessionId", mediaStatus.f4705b);
                    }
                    break;
                } catch (JSONException unused4) {
                }
                c3998l5.m8000c(jM7999b5, jSONObject5.toString());
                c3998l5.f13541p.m7992a(jM7999b5, interfaceC3999mM7344l4);
                break;
        }
    }

    public C3618h(C3616f c3616f) {
        super(c3616f, true);
        this.f12164u = 2;
        this.f12165v = c3616f;
    }
}
