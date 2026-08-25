package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import androidx.media3.exoplayer.rtsp.SessionDescription;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.cast.AbstractC1503a1;
import com.google.android.gms.internal.cast.AbstractC1714w1;
import com.google.android.gms.internal.cast.C1504a2;
import com.google.android.gms.internal.cast.C1696u1;
import com.lzy.okgo.cookie.SerializableCookie;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Locale;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p078h5.C2661a;
import p111k5.AbstractC2891a;
import p156o9.AbstractC3280d;
import p230v4.AbstractC3987a;

public class MediaInfo extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<MediaInfo> CREATOR;

    public static final long f4637s;

    public final String f4638a;

    public final int f4639b;

    public final String f4640c;

    public final MediaMetadata f4641d;

    public final long f4642e;

    public final ArrayList f4643f;

    public final TextTrackStyle f4644g;

    public String f4645h;

    public ArrayList f4646i;

    public ArrayList f4647j;

    public final String f4648k;

    public final VastAdsRequest f4649l;

    public final long f4650m;

    public final String f4651n;

    public final String f4652o;

    public final String f4653p;

    public final String f4654q;

    public final JSONObject f4655r;

    static {
        Pattern pattern = AbstractC3987a.f13519a;
        f4637s = -1000L;
        CREATOR = new C2661a(18);
    }

    public MediaInfo(String str, int i6, String str2, MediaMetadata mediaMetadata, long j10, ArrayList arrayList, TextTrackStyle textTrackStyle, String str3, ArrayList arrayList2, ArrayList arrayList3, String str4, VastAdsRequest vastAdsRequest, long j11, String str5, String str6, String str7, String str8) {
        this.f4638a = str;
        this.f4639b = i6;
        this.f4640c = str2;
        this.f4641d = mediaMetadata;
        this.f4642e = j10;
        this.f4643f = arrayList;
        this.f4644g = textTrackStyle;
        this.f4645h = str3;
        if (str3 != null) {
            try {
                this.f4655r = new JSONObject(this.f4645h);
            } catch (JSONException unused) {
                this.f4655r = null;
                this.f4645h = null;
            }
        } else {
            this.f4655r = null;
        }
        this.f4646i = arrayList2;
        this.f4647j = arrayList3;
        this.f4648k = str4;
        this.f4649l = vastAdsRequest;
        this.f4650m = j11;
        this.f4651n = str5;
        this.f4652o = str6;
        this.f4653p = str7;
        this.f4654q = str8;
        if (this.f4638a == null && str6 == null && str4 == null) {
            throw new IllegalArgumentException("Either contentID or contentUrl or entity should be set");
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaInfo)) {
            return false;
        }
        MediaInfo mediaInfo = (MediaInfo) obj;
        JSONObject jSONObject = this.f4655r;
        boolean z7 = jSONObject == null;
        JSONObject jSONObject2 = mediaInfo.f4655r;
        if (z7 != (jSONObject2 == null)) {
            return false;
        }
        return (jSONObject == null || jSONObject2 == null || AbstractC2891a.m5894a(jSONObject, jSONObject2)) && AbstractC3987a.m7972e(this.f4638a, mediaInfo.f4638a) && this.f4639b == mediaInfo.f4639b && AbstractC3987a.m7972e(this.f4640c, mediaInfo.f4640c) && AbstractC3987a.m7972e(this.f4641d, mediaInfo.f4641d) && this.f4642e == mediaInfo.f4642e && AbstractC3987a.m7972e(this.f4643f, mediaInfo.f4643f) && AbstractC3987a.m7972e(this.f4644g, mediaInfo.f4644g) && AbstractC3987a.m7972e(this.f4646i, mediaInfo.f4646i) && AbstractC3987a.m7972e(this.f4647j, mediaInfo.f4647j) && AbstractC3987a.m7972e(this.f4648k, mediaInfo.f4648k) && AbstractC3987a.m7972e(this.f4649l, mediaInfo.f4649l) && this.f4650m == mediaInfo.f4650m && AbstractC3987a.m7972e(this.f4651n, mediaInfo.f4651n) && AbstractC3987a.m7972e(this.f4652o, mediaInfo.f4652o) && AbstractC3987a.m7972e(this.f4653p, mediaInfo.f4653p) && AbstractC3987a.m7972e(this.f4654q, mediaInfo.f4654q);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f4638a, Integer.valueOf(this.f4639b), this.f4640c, this.f4641d, Long.valueOf(this.f4642e), String.valueOf(this.f4655r), this.f4643f, this.f4644g, this.f4646i, this.f4647j, this.f4648k, this.f4649l, Long.valueOf(this.f4650m), this.f4651n, this.f4653p, this.f4654q});
    }

    public final JSONObject m3591j() {
        String str;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("contentId", this.f4638a);
            jSONObject.putOpt("contentUrl", this.f4652o);
            int i6 = this.f4639b;
            if (i6 != 1) {
                str = i6 != 2 ? "NONE" : "LIVE";
            } else {
                str = "BUFFERED";
            }
            jSONObject.put("streamType", str);
            String str2 = this.f4640c;
            if (str2 != null) {
                jSONObject.put("contentType", str2);
            }
            MediaMetadata mediaMetadata = this.f4641d;
            if (mediaMetadata != null) {
                jSONObject.put(TtmlNode.TAG_METADATA, mediaMetadata.m3595l());
            }
            long j10 = this.f4642e;
            if (j10 <= -1) {
                jSONObject.put("duration", JSONObject.NULL);
            } else {
                Pattern pattern = AbstractC3987a.f13519a;
                jSONObject.put("duration", j10 / 1000.0d);
            }
            ArrayList arrayList = this.f4643f;
            if (arrayList != null) {
                JSONArray jSONArray = new JSONArray();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    jSONArray.put(((MediaTrack) it.next()).m3604j());
                }
                jSONObject.put("tracks", jSONArray);
            }
            TextTrackStyle textTrackStyle = this.f4644g;
            if (textTrackStyle != null) {
                jSONObject.put("textTrackStyle", textTrackStyle.m3607j());
            }
            JSONObject jSONObject2 = this.f4655r;
            if (jSONObject2 != null) {
                jSONObject.put("customData", jSONObject2);
            }
            String str3 = this.f4648k;
            if (str3 != null) {
                jSONObject.put("entity", str3);
            }
            if (this.f4646i != null) {
                JSONArray jSONArray2 = new JSONArray();
                Iterator it2 = this.f4646i.iterator();
                while (it2.hasNext()) {
                    jSONArray2.put(((AdBreakInfo) it2.next()).m3583j());
                }
                jSONObject.put("breaks", jSONArray2);
            }
            if (this.f4647j != null) {
                JSONArray jSONArray3 = new JSONArray();
                Iterator it3 = this.f4647j.iterator();
                while (it3.hasNext()) {
                    jSONArray3.put(((AdBreakClipInfo) it3.next()).m3582j());
                }
                jSONObject.put("breakClips", jSONArray3);
            }
            VastAdsRequest vastAdsRequest = this.f4649l;
            if (vastAdsRequest != null) {
                jSONObject.put("vmapAdsRequest", vastAdsRequest.m3608j());
            }
            long j11 = this.f4650m;
            if (j11 != -1) {
                Pattern pattern2 = AbstractC3987a.f13519a;
                jSONObject.put("startAbsoluteTime", j11 / 1000.0d);
            }
            jSONObject.putOpt("atvEntity", this.f4651n);
            String str4 = this.f4653p;
            if (str4 != null) {
                jSONObject.put("hlsSegmentFormat", str4);
            }
            String str5 = this.f4654q;
            if (str5 != null) {
                jSONObject.put("hlsVideoSegmentFormat", str5);
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public final void m3592l(JSONObject jSONObject) {
        AdBreakClipInfo adBreakClipInfo;
        AdBreakInfo adBreakInfo;
        int i6 = 0;
        if (jSONObject.has("breaks")) {
            JSONArray jSONArray = jSONObject.getJSONArray("breaks");
            ArrayList arrayList = new ArrayList(jSONArray.length());
            int i10 = 0;
            while (i10 < jSONArray.length()) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i10);
                if (jSONObject2 != null && jSONObject2.has(TtmlNode.ATTR_ID) && jSONObject2.has("position")) {
                    try {
                        String string = jSONObject2.getString(TtmlNode.ATTR_ID);
                        long j10 = jSONObject2.getLong("position");
                        Pattern pattern = AbstractC3987a.f13519a;
                        long j11 = j10 * 1000;
                        boolean zOptBoolean = jSONObject2.optBoolean("isWatched");
                        long jOptLong = jSONObject2.optLong("duration") * 1000;
                        JSONArray jSONArrayOptJSONArray = jSONObject2.optJSONArray("breakClipIds");
                        String[] strArr = new String[i6];
                        if (jSONArrayOptJSONArray != null) {
                            strArr = new String[jSONArrayOptJSONArray.length()];
                            for (int i11 = 0; i11 < jSONArrayOptJSONArray.length(); i11++) {
                                strArr[i11] = jSONArrayOptJSONArray.getString(i11);
                            }
                        }
                        adBreakInfo = new AdBreakInfo(j11, string, jOptLong, zOptBoolean, strArr, jSONObject2.optBoolean("isEmbedded"), jSONObject2.optBoolean("expanded"));
                    } catch (JSONException e5) {
                        String message = e5.getMessage();
                        Locale locale = Locale.ROOT;
                        Log.d("AdBreakInfo", "Error while creating an AdBreakInfo from JSON: " + message);
                        adBreakInfo = null;
                    }
                } else {
                    adBreakInfo = null;
                }
                if (adBreakInfo == null) {
                    arrayList.clear();
                    break;
                } else {
                    arrayList.add(adBreakInfo);
                    i10++;
                    i6 = 0;
                }
            }
            this.f4646i = new ArrayList(arrayList);
        }
        if (jSONObject.has("breakClips")) {
            JSONArray jSONArray2 = jSONObject.getJSONArray("breakClips");
            ArrayList arrayList2 = new ArrayList(jSONArray2.length());
            for (int i12 = 0; i12 < jSONArray2.length(); i12++) {
                JSONObject jSONObject3 = jSONArray2.getJSONObject(i12);
                if (jSONObject3 != null && jSONObject3.has(TtmlNode.ATTR_ID)) {
                    try {
                        String string2 = jSONObject3.getString(TtmlNode.ATTR_ID);
                        long jOptLong2 = jSONObject3.optLong("duration") * 1000;
                        String strM7969b = AbstractC3987a.m7969b(jSONObject3, "clickThroughUrl");
                        String strM7969b2 = AbstractC3987a.m7969b(jSONObject3, "contentUrl");
                        String strM7969b3 = AbstractC3987a.m7969b(jSONObject3, "mimeType");
                        if (strM7969b3 == null) {
                            strM7969b3 = AbstractC3987a.m7969b(jSONObject3, "contentType");
                        }
                        String str = strM7969b3;
                        String strM7969b4 = AbstractC3987a.m7969b(jSONObject3, "title");
                        JSONObject jSONObjectOptJSONObject = jSONObject3.optJSONObject("customData");
                        String strM7969b5 = AbstractC3987a.m7969b(jSONObject3, "contentId");
                        String strM7969b6 = AbstractC3987a.m7969b(jSONObject3, "posterUrl");
                        long jIntValue = jSONObject3.has("whenSkippable") ? ((long) ((Integer) jSONObject3.get("whenSkippable")).intValue()) * 1000 : -1L;
                        String strM7969b7 = AbstractC3987a.m7969b(jSONObject3, "hlsSegmentFormat");
                        JSONObject jSONObjectOptJSONObject2 = jSONObject3.optJSONObject("vastAdsRequest");
                        adBreakClipInfo = new AdBreakClipInfo(string2, strM7969b4, jOptLong2, strM7969b2, str, strM7969b, (jSONObjectOptJSONObject == 0 || jSONObjectOptJSONObject.length() == 0) ? null : jSONObjectOptJSONObject.toString(), strM7969b5, strM7969b6, jIntValue, strM7969b7, jSONObjectOptJSONObject2 == null ? null : new VastAdsRequest(AbstractC3987a.m7969b(jSONObjectOptJSONObject2, "adTagUrl"), AbstractC3987a.m7969b(jSONObjectOptJSONObject2, "adsResponse")));
                    } catch (JSONException e10) {
                        String message2 = e10.getMessage();
                        Locale locale2 = Locale.ROOT;
                        Log.d("AdBreakClipInfo", "Error while creating an AdBreakClipInfo from JSON: " + message2);
                        adBreakClipInfo = null;
                    }
                } else {
                    adBreakClipInfo = null;
                }
                if (adBreakClipInfo == null) {
                    arrayList2.clear();
                    break;
                }
                arrayList2.add(adBreakClipInfo);
            }
            this.f4647j = new ArrayList(arrayList2);
        }
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i6) {
        JSONObject jSONObject = this.f4655r;
        this.f4645h = jSONObject == null ? null : jSONObject.toString();
        int iM6583V = AbstractC3280d.m6583V(parcel, 20293);
        String str = this.f4638a;
        if (str == null) {
            str = "";
        }
        AbstractC3280d.m6579R(parcel, 2, str);
        AbstractC3280d.m6585X(parcel, 3, 4);
        parcel.writeInt(this.f4639b);
        AbstractC3280d.m6579R(parcel, 4, this.f4640c);
        AbstractC3280d.m6578Q(parcel, 5, this.f4641d, i6);
        AbstractC3280d.m6585X(parcel, 6, 8);
        parcel.writeLong(this.f4642e);
        AbstractC3280d.m6582U(parcel, 7, this.f4643f);
        AbstractC3280d.m6578Q(parcel, 8, this.f4644g, i6);
        AbstractC3280d.m6579R(parcel, 9, this.f4645h);
        ArrayList arrayList = this.f4646i;
        AbstractC3280d.m6582U(parcel, 10, arrayList == null ? null : Collections.unmodifiableList(arrayList));
        ArrayList arrayList2 = this.f4647j;
        AbstractC3280d.m6582U(parcel, 11, arrayList2 != null ? Collections.unmodifiableList(arrayList2) : null);
        AbstractC3280d.m6579R(parcel, 12, this.f4648k);
        AbstractC3280d.m6578Q(parcel, 13, this.f4649l, i6);
        AbstractC3280d.m6585X(parcel, 14, 8);
        parcel.writeLong(this.f4650m);
        AbstractC3280d.m6579R(parcel, 15, this.f4651n);
        AbstractC3280d.m6579R(parcel, 16, this.f4652o);
        AbstractC3280d.m6579R(parcel, 17, this.f4653p);
        AbstractC3280d.m6579R(parcel, 18, this.f4654q);
        AbstractC3280d.m6584W(parcel, iM6583V);
    }

    public MediaInfo(JSONObject jSONObject) throws JSONException {
        MediaInfo mediaInfo;
        VastAdsRequest vastAdsRequest;
        int i6;
        int i10;
        int i11;
        C1504a2 c1504a2M4052h;
        this(jSONObject.optString("contentId"), -1, null, null, -1L, null, null, null, null, null, null, null, -1L, null, null, null, null);
        String strOptString = jSONObject.optString("streamType", "NONE");
        if ("NONE".equals(strOptString)) {
            mediaInfo = this;
            mediaInfo.f4639b = 0;
        } else {
            mediaInfo = this;
            if ("BUFFERED".equals(strOptString)) {
                mediaInfo.f4639b = 1;
            } else if ("LIVE".equals(strOptString)) {
                mediaInfo.f4639b = 2;
            } else {
                mediaInfo.f4639b = -1;
            }
        }
        mediaInfo.f4640c = AbstractC3987a.m7969b(jSONObject, "contentType");
        if (jSONObject.has(TtmlNode.TAG_METADATA)) {
            JSONObject jSONObject2 = jSONObject.getJSONObject(TtmlNode.TAG_METADATA);
            MediaMetadata mediaMetadata = new MediaMetadata(jSONObject2.getInt("metadataType"));
            mediaInfo.f4641d = mediaMetadata;
            mediaMetadata.m3596m(jSONObject2);
        }
        mediaInfo.f4642e = -1L;
        if (mediaInfo.f4639b != 2 && jSONObject.has("duration") && !jSONObject.isNull("duration")) {
            double dOptDouble = jSONObject.optDouble("duration", 0.0d);
            if (!Double.isNaN(dOptDouble) && !Double.isInfinite(dOptDouble) && dOptDouble >= 0.0d) {
                mediaInfo.f4642e = (long) (dOptDouble * 1000.0d);
            }
        }
        int i12 = 4;
        if (jSONObject.has("tracks")) {
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArray = jSONObject.getJSONArray("tracks");
            int i13 = 0;
            while (i13 < jSONArray.length()) {
                JSONObject jSONObject3 = jSONArray.getJSONObject(i13);
                long j10 = jSONObject3.getLong("trackId");
                String strOptString2 = jSONObject3.optString(SessionDescription.ATTR_TYPE);
                if ("TEXT".equals(strOptString2)) {
                    i10 = 1;
                } else if ("AUDIO".equals(strOptString2)) {
                    i10 = 2;
                } else {
                    i10 = "VIDEO".equals(strOptString2) ? 3 : 0;
                }
                String strM7969b = AbstractC3987a.m7969b(jSONObject3, "trackContentId");
                String strM7969b2 = AbstractC3987a.m7969b(jSONObject3, "trackContentType");
                String strM7969b3 = AbstractC3987a.m7969b(jSONObject3, SerializableCookie.NAME);
                String strM7969b4 = AbstractC3987a.m7969b(jSONObject3, "language");
                if (jSONObject3.has("subtype")) {
                    String string = jSONObject3.getString("subtype");
                    if ("SUBTITLES".equals(string)) {
                        i11 = 1;
                    } else if ("CAPTIONS".equals(string)) {
                        i11 = 2;
                    } else if ("DESCRIPTIONS".equals(string)) {
                        i11 = 3;
                    } else if ("CHAPTERS".equals(string)) {
                        i11 = 4;
                    } else {
                        i11 = "METADATA".equals(string) ? 5 : -1;
                    }
                } else {
                    i11 = 0;
                }
                if (jSONObject3.has("roles")) {
                    C1696u1 c1696u1 = AbstractC1714w1.f5716b;
                    Object[] objArrCopyOf = new Object[i12];
                    JSONArray jSONArray2 = jSONObject3.getJSONArray("roles");
                    int i14 = 0;
                    int i15 = 0;
                    while (i14 < jSONArray2.length()) {
                        String strOptString3 = jSONArray2.optString(i14);
                        strOptString3.getClass();
                        int length = objArrCopyOf.length;
                        int i16 = i15 + 1;
                        int iM3693c = AbstractC1503a1.m3693c(length, i16);
                        if (iM3693c > length) {
                            objArrCopyOf = Arrays.copyOf(objArrCopyOf, iM3693c);
                        }
                        objArrCopyOf[i15] = strOptString3;
                        i14++;
                        i15 = i16;
                    }
                    c1504a2M4052h = AbstractC1714w1.m4052h(objArrCopyOf, i15);
                } else {
                    c1504a2M4052h = null;
                }
                arrayList.add(new MediaTrack(j10, i10, strM7969b, strM7969b2, strM7969b3, strM7969b4, i11, c1504a2M4052h, jSONObject3.optJSONObject("customData")));
                i13++;
                i12 = 4;
            }
            mediaInfo.f4643f = new ArrayList(arrayList);
        } else {
            mediaInfo.f4643f = null;
        }
        if (jSONObject.has("textTrackStyle")) {
            JSONObject jSONObject4 = jSONObject.getJSONObject("textTrackStyle");
            TextTrackStyle textTrackStyle = new TextTrackStyle(1.0f, 0, 0, -1, 0, -1, 0, 0, null, -1, -1, null);
            textTrackStyle.f4741a = (float) jSONObject4.optDouble("fontScale", 1.0d);
            textTrackStyle.f4742b = TextTrackStyle.m3605l(jSONObject4.optString("foregroundColor"));
            textTrackStyle.f4743c = TextTrackStyle.m3605l(jSONObject4.optString(TtmlNode.ATTR_TTS_BACKGROUND_COLOR));
            if (jSONObject4.has("edgeType")) {
                String string2 = jSONObject4.getString("edgeType");
                if ("NONE".equals(string2)) {
                    textTrackStyle.f4744d = 0;
                } else if ("OUTLINE".equals(string2)) {
                    textTrackStyle.f4744d = 1;
                } else if ("DROP_SHADOW".equals(string2)) {
                    textTrackStyle.f4744d = 2;
                } else if ("RAISED".equals(string2)) {
                    textTrackStyle.f4744d = 3;
                } else if ("DEPRESSED".equals(string2)) {
                    textTrackStyle.f4744d = 4;
                }
            }
            textTrackStyle.f4745e = TextTrackStyle.m3605l(jSONObject4.optString("edgeColor"));
            if (jSONObject4.has("windowType")) {
                String string3 = jSONObject4.getString("windowType");
                if ("NONE".equals(string3)) {
                    textTrackStyle.f4746f = 0;
                } else if ("NORMAL".equals(string3)) {
                    textTrackStyle.f4746f = 1;
                } else if ("ROUNDED_CORNERS".equals(string3)) {
                    i6 = 2;
                    textTrackStyle.f4746f = 2;
                }
                i6 = 2;
            } else {
                i6 = 2;
            }
            textTrackStyle.f4747g = TextTrackStyle.m3605l(jSONObject4.optString("windowColor"));
            if (textTrackStyle.f4746f == i6) {
                textTrackStyle.f4748h = jSONObject4.optInt("windowRoundedCornerRadius", 0);
            }
            textTrackStyle.f4749i = AbstractC3987a.m7969b(jSONObject4, TtmlNode.ATTR_TTS_FONT_FAMILY);
            if (jSONObject4.has("fontGenericFamily")) {
                String string4 = jSONObject4.getString("fontGenericFamily");
                if ("SANS_SERIF".equals(string4)) {
                    textTrackStyle.f4750j = 0;
                } else if ("MONOSPACED_SANS_SERIF".equals(string4)) {
                    textTrackStyle.f4750j = 1;
                } else if ("SERIF".equals(string4)) {
                    textTrackStyle.f4750j = 2;
                } else if ("MONOSPACED_SERIF".equals(string4)) {
                    textTrackStyle.f4750j = 3;
                } else if ("CASUAL".equals(string4)) {
                    textTrackStyle.f4750j = 4;
                } else if ("CURSIVE".equals(string4)) {
                    textTrackStyle.f4750j = 5;
                } else if ("SMALL_CAPITALS".equals(string4)) {
                    textTrackStyle.f4750j = 6;
                }
            }
            if (jSONObject4.has(TtmlNode.ATTR_TTS_FONT_STYLE)) {
                String string5 = jSONObject4.getString(TtmlNode.ATTR_TTS_FONT_STYLE);
                if ("NORMAL".equals(string5)) {
                    textTrackStyle.f4751k = 0;
                } else if ("BOLD".equals(string5)) {
                    textTrackStyle.f4751k = 1;
                } else if ("ITALIC".equals(string5)) {
                    textTrackStyle.f4751k = 2;
                } else if ("BOLD_ITALIC".equals(string5)) {
                    textTrackStyle.f4751k = 3;
                }
            }
            textTrackStyle.f4753m = jSONObject4.optJSONObject("customData");
            mediaInfo.f4644g = textTrackStyle;
            vastAdsRequest = null;
        } else {
            vastAdsRequest = null;
            mediaInfo.f4644g = null;
        }
        m3592l(jSONObject);
        mediaInfo.f4655r = jSONObject.optJSONObject("customData");
        mediaInfo.f4648k = AbstractC3987a.m7969b(jSONObject, "entity");
        mediaInfo.f4651n = AbstractC3987a.m7969b(jSONObject, "atvEntity");
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("vmapAdsRequest");
        mediaInfo.f4649l = jSONObjectOptJSONObject == null ? vastAdsRequest : new VastAdsRequest(AbstractC3987a.m7969b(jSONObjectOptJSONObject, "adTagUrl"), AbstractC3987a.m7969b(jSONObjectOptJSONObject, "adsResponse"));
        if (jSONObject.has("startAbsoluteTime") && !jSONObject.isNull("startAbsoluteTime")) {
            double dOptDouble2 = jSONObject.optDouble("startAbsoluteTime");
            if (!Double.isNaN(dOptDouble2) && !Double.isInfinite(dOptDouble2) && dOptDouble2 >= 0.0d) {
                mediaInfo.f4650m = (long) (dOptDouble2 * 1000.0d);
            }
        }
        if (jSONObject.has("contentUrl")) {
            mediaInfo.f4652o = jSONObject.optString("contentUrl");
        }
        mediaInfo.f4653p = AbstractC3987a.m7969b(jSONObject, "hlsSegmentFormat");
        mediaInfo.f4654q = AbstractC3987a.m7969b(jSONObject, "hlsVideoSegmentFormat");
    }
}
