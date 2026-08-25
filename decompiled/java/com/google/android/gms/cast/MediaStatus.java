package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.bumptech.glide.AbstractC1466d;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.lzy.okgo.cookie.SerializableCookie;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p018b5.AbstractC1312l;
import p078h5.C2661a;
import p101j7.C2782c;
import p111k5.AbstractC2891a;
import p156o9.AbstractC3280d;
import p230v4.AbstractC3987a;
import p230v4.C3988b;
import p241w4.AbstractC4052a;

public class MediaStatus extends AbstractSafeParcelable {
    public static final Parcelable.Creator<MediaStatus> CREATOR;

    public MediaInfo f4704a;

    public long f4705b;

    public int f4706c;

    public double f4707d;

    public int f4708e;

    public int f4709f;

    public long f4710g;

    public long f4711h;

    public double f4712i;

    public boolean f4713j;

    public long[] f4714k;

    public int f4715l;

    public int f4716m;

    public String f4717n;

    public JSONObject f4718o;

    public int f4719p;

    public boolean f4721r;

    public AdBreakStatus f4722s;

    public VideoInfo f4723t;

    public MediaLiveSeekableRange f4724u;

    public MediaQueueData f4725v;

    public boolean f4726w;

    public final ArrayList f4720q = new ArrayList();

    public final SparseArray f4727x = new SparseArray();

    static {
        AbstractC1312l.m3197d("MediaStatus", "The log tag cannot be null or empty.");
        CREATOR = new C2661a(26);
    }

    public MediaStatus(MediaInfo mediaInfo, long j10, int i6, double d, int i10, int i11, long j11, long j12, double d10, boolean z7, long[] jArr, int i12, int i13, String str, int i14, ArrayList arrayList, boolean z10, AdBreakStatus adBreakStatus, VideoInfo videoInfo, MediaLiveSeekableRange mediaLiveSeekableRange, MediaQueueData mediaQueueData) {
        this.f4704a = mediaInfo;
        this.f4705b = j10;
        this.f4706c = i6;
        this.f4707d = d;
        this.f4708e = i10;
        this.f4709f = i11;
        this.f4710g = j11;
        this.f4711h = j12;
        this.f4712i = d10;
        this.f4713j = z7;
        this.f4714k = jArr;
        this.f4715l = i12;
        this.f4716m = i13;
        this.f4717n = str;
        if (str != null) {
            try {
                this.f4718o = new JSONObject(this.f4717n);
            } catch (JSONException unused) {
                this.f4718o = null;
                this.f4717n = null;
            }
        } else {
            this.f4718o = null;
        }
        this.f4719p = i14;
        if (arrayList != null && !arrayList.isEmpty()) {
            m3603m(arrayList);
        }
        this.f4721r = z10;
        this.f4722s = adBreakStatus;
        this.f4723t = videoInfo;
        this.f4724u = mediaLiveSeekableRange;
        this.f4725v = mediaQueueData;
        boolean z11 = false;
        if (mediaQueueData != null && mediaQueueData.f4694j) {
            z11 = true;
        }
        this.f4726w = z11;
    }

    public final boolean equals(Object obj) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaStatus)) {
            return false;
        }
        MediaStatus mediaStatus = (MediaStatus) obj;
        return (this.f4718o == null) == (mediaStatus.f4718o == null) && this.f4705b == mediaStatus.f4705b && this.f4706c == mediaStatus.f4706c && this.f4707d == mediaStatus.f4707d && this.f4708e == mediaStatus.f4708e && this.f4709f == mediaStatus.f4709f && this.f4710g == mediaStatus.f4710g && this.f4712i == mediaStatus.f4712i && this.f4713j == mediaStatus.f4713j && this.f4715l == mediaStatus.f4715l && this.f4716m == mediaStatus.f4716m && this.f4719p == mediaStatus.f4719p && Arrays.equals(this.f4714k, mediaStatus.f4714k) && AbstractC3987a.m7972e(Long.valueOf(this.f4711h), Long.valueOf(mediaStatus.f4711h)) && AbstractC3987a.m7972e(this.f4720q, mediaStatus.f4720q) && AbstractC3987a.m7972e(this.f4704a, mediaStatus.f4704a) && ((jSONObject = this.f4718o) == null || (jSONObject2 = mediaStatus.f4718o) == null || AbstractC2891a.m5894a(jSONObject, jSONObject2)) && this.f4721r == mediaStatus.f4721r && AbstractC3987a.m7972e(this.f4722s, mediaStatus.f4722s) && AbstractC3987a.m7972e(this.f4723t, mediaStatus.f4723t) && AbstractC3987a.m7972e(this.f4724u, mediaStatus.f4724u) && AbstractC1312l.m3201h(this.f4725v, mediaStatus.f4725v) && this.f4726w == mediaStatus.f4726w;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f4704a, Long.valueOf(this.f4705b), Integer.valueOf(this.f4706c), Double.valueOf(this.f4707d), Integer.valueOf(this.f4708e), Integer.valueOf(this.f4709f), Long.valueOf(this.f4710g), Long.valueOf(this.f4711h), Double.valueOf(this.f4712i), Boolean.valueOf(this.f4713j), Integer.valueOf(Arrays.hashCode(this.f4714k)), Integer.valueOf(this.f4715l), Integer.valueOf(this.f4716m), String.valueOf(this.f4718o), Integer.valueOf(this.f4719p), this.f4720q, Boolean.valueOf(this.f4721r), this.f4722s, this.f4723t, this.f4724u, this.f4725v});
    }

    public final AdBreakClipInfo m3601j() {
        MediaInfo mediaInfo;
        AdBreakStatus adBreakStatus = this.f4722s;
        if (adBreakStatus == null) {
            return null;
        }
        String str = adBreakStatus.f4588d;
        if (TextUtils.isEmpty(str) || (mediaInfo = this.f4704a) == null) {
            return null;
        }
        ArrayList arrayList = mediaInfo.f4647j;
        List<AdBreakClipInfo> listUnmodifiableList = arrayList == null ? null : Collections.unmodifiableList(arrayList);
        if (listUnmodifiableList != null && !listUnmodifiableList.isEmpty()) {
            for (AdBreakClipInfo adBreakClipInfo : listUnmodifiableList) {
                if (str.equals(adBreakClipInfo.f4564a)) {
                    return adBreakClipInfo;
                }
            }
        }
        return null;
    }

    public final int m3602l(JSONObject jSONObject, int i6) throws JSONException {
        JSONObject jSONObject2;
        int i10;
        long[] jArr;
        boolean z7;
        AdBreakStatus adBreakStatus;
        byte b8;
        int i11;
        VideoInfo videoInfo;
        MediaLiveSeekableRange mediaLiveSeekableRange;
        byte b10;
        int i12;
        MediaInfo mediaInfo;
        boolean zM3599j;
        MediaInfo mediaInfo2;
        int i13;
        int i14;
        int i15;
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("extendedStatus");
        if (jSONObjectOptJSONObject != null) {
            try {
                ArrayList arrayList = new ArrayList();
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    arrayList.add(itKeys.next());
                }
                jSONObject2 = new JSONObject(jSONObject, (String[]) arrayList.toArray(new String[0]));
                Iterator<String> itKeys2 = jSONObjectOptJSONObject.keys();
                while (itKeys2.hasNext()) {
                    String next = itKeys2.next();
                    jSONObject2.put(next, jSONObjectOptJSONObject.get(next));
                }
                jSONObject2.remove("extendedStatus");
            } catch (JSONException unused) {
                jSONObject2 = jSONObject;
            }
        } else {
            jSONObject2 = jSONObject;
        }
        long j10 = jSONObject2.getLong("mediaSessionId");
        if (j10 != this.f4705b) {
            this.f4705b = j10;
            i10 = 1;
        } else {
            i10 = 0;
        }
        if (jSONObject2.has("playerState")) {
            String string = jSONObject2.getString("playerState");
            if (string.equals("IDLE")) {
                i14 = 1;
            } else if (string.equals("PLAYING")) {
                i14 = 2;
            } else if (string.equals("PAUSED")) {
                i14 = 3;
            } else if (string.equals("BUFFERING")) {
                i14 = 4;
            } else {
                i14 = string.equals("LOADING") ? 5 : 0;
            }
            if (i14 != this.f4708e) {
                this.f4708e = i14;
                i10 |= 2;
            }
            if (i14 == 1 && jSONObject2.has("idleReason")) {
                String string2 = jSONObject2.getString("idleReason");
                if (string2.equals("CANCELLED")) {
                    i15 = 2;
                } else if (string2.equals("INTERRUPTED")) {
                    i15 = 3;
                } else if (string2.equals("FINISHED")) {
                    i15 = 1;
                } else {
                    i15 = string2.equals("ERROR") ? 4 : 0;
                }
                if (i15 != this.f4709f) {
                    this.f4709f = i15;
                    i10 |= 2;
                }
            }
        }
        if (jSONObject2.has("playbackRate")) {
            double d = jSONObject2.getDouble("playbackRate");
            if (this.f4707d != d) {
                this.f4707d = d;
                i10 |= 2;
            }
        }
        if (jSONObject2.has("currentTime")) {
            double d10 = jSONObject2.getDouble("currentTime");
            Pattern pattern = AbstractC3987a.f13519a;
            long j11 = (long) (d10 * 1000.0d);
            if (j11 != this.f4710g) {
                this.f4710g = j11;
                i10 |= 2;
            }
            i10 |= 128;
        }
        if (jSONObject2.has("supportedMediaCommands")) {
            long j12 = jSONObject2.getLong("supportedMediaCommands");
            if (j12 != this.f4711h) {
                this.f4711h = j12;
                i10 |= 2;
            }
        }
        if (jSONObject2.has("volume") && i6 == 0) {
            JSONObject jSONObject3 = jSONObject2.getJSONObject("volume");
            double d11 = jSONObject3.getDouble("level");
            if (d11 != this.f4712i) {
                this.f4712i = d11;
                i10 |= 2;
            }
            boolean z10 = jSONObject3.getBoolean("muted");
            if (z10 != this.f4713j) {
                this.f4713j = z10;
                i10 |= 2;
            }
        }
        JSONArray jSONArray = jSONObject2.has("activeTrackIds") ? jSONObject2.getJSONArray("activeTrackIds") : null;
        Pattern pattern2 = AbstractC3987a.f13519a;
        if (jSONArray == null) {
            jArr = null;
        } else {
            jArr = new long[jSONArray.length()];
            for (int i16 = 0; i16 < jSONArray.length(); i16++) {
                jArr[i16] = jSONArray.getLong(i16);
            }
        }
        if (jArr != null) {
            long[] jArr2 = this.f4714k;
            if (jArr2 == null || jArr2.length != jArr.length) {
                this.f4714k = jArr;
                i10 |= 2;
                break;
            }
            for (int i17 = 0; i17 < jArr.length; i17++) {
                if (this.f4714k[i17] != jArr[i17]) {
                    this.f4714k = jArr;
                    i10 |= 2;
                    break;
                }
            }
        } else if (this.f4714k != null) {
            this.f4714k = jArr;
            i10 |= 2;
            break;
        }
        if (jSONObject2.has("customData")) {
            this.f4718o = jSONObject2.getJSONObject("customData");
            this.f4717n = null;
            i10 |= 2;
        }
        if (jSONObject2.has("media")) {
            JSONObject jSONObject4 = jSONObject2.getJSONObject("media");
            MediaInfo mediaInfo3 = new MediaInfo(jSONObject4);
            MediaInfo mediaInfo4 = this.f4704a;
            if (mediaInfo4 == null || !mediaInfo4.equals(mediaInfo3)) {
                this.f4704a = mediaInfo3;
                i10 |= 2;
            }
            if (jSONObject4.has(TtmlNode.TAG_METADATA)) {
                i10 |= 4;
            }
        }
        if (jSONObject2.has("currentItemId") && this.f4706c != (i13 = jSONObject2.getInt("currentItemId"))) {
            this.f4706c = i13;
            i10 |= 2;
        }
        int iOptInt = jSONObject2.optInt("preloadedItemId", 0);
        if (this.f4716m != iOptInt) {
            this.f4716m = iOptInt;
            i10 |= 16;
        }
        int iOptInt2 = jSONObject2.optInt("loadingItemId", 0);
        if (this.f4715l != iOptInt2) {
            this.f4715l = iOptInt2;
            i10 |= 2;
        }
        MediaInfo mediaInfo5 = this.f4704a;
        int i18 = mediaInfo5 == null ? -1 : mediaInfo5.f4639b;
        int i19 = this.f4708e;
        int i20 = this.f4709f;
        int i21 = this.f4715l;
        if (i19 != 1) {
            z7 = false;
        } else if (i20 != 1) {
            if (i20 != 2) {
                if (i20 == 3) {
                    if (i21 != 0) {
                        z7 = false;
                    }
                }
            } else if (i18 == 2) {
                z7 = false;
            }
            z7 = true;
        } else if (i21 != 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        ArrayList arrayList2 = this.f4720q;
        SparseArray sparseArray = this.f4727x;
        if (z7) {
            this.f4706c = 0;
            this.f4715l = 0;
            this.f4716m = 0;
            if (!arrayList2.isEmpty()) {
                i10 |= 8;
                this.f4719p = 0;
                arrayList2.clear();
                sparseArray.clear();
            }
        } else {
            if (jSONObject2.has("repeatMode")) {
                Integer numM3502v = AbstractC1466d.m3502v(jSONObject2.getString("repeatMode"));
                int iIntValue = numM3502v == null ? this.f4719p : numM3502v.intValue();
                if (this.f4719p != iIntValue) {
                    this.f4719p = iIntValue;
                    zM3599j = true;
                } else {
                    zM3599j = false;
                }
            } else {
                zM3599j = false;
            }
            if (jSONObject2.has("items")) {
                JSONArray jSONArray2 = jSONObject2.getJSONArray("items");
                int length = jSONArray2.length();
                SparseArray sparseArray2 = new SparseArray();
                for (int i22 = 0; i22 < length; i22++) {
                    sparseArray2.put(i22, Integer.valueOf(jSONArray2.getJSONObject(i22).getInt("itemId")));
                }
                ArrayList arrayList3 = new ArrayList();
                for (int i23 = 0; i23 < length; i23++) {
                    Integer num = (Integer) sparseArray2.get(i23);
                    JSONObject jSONObject5 = jSONArray2.getJSONObject(i23);
                    Integer num2 = (Integer) sparseArray.get(num.intValue());
                    MediaQueueItem mediaQueueItem = num2 == null ? null : (MediaQueueItem) arrayList2.get(num2.intValue());
                    if (mediaQueueItem != null) {
                        zM3599j |= mediaQueueItem.m3599j(jSONObject5);
                        arrayList3.add(mediaQueueItem);
                        if (i23 != ((Integer) sparseArray.get(num.intValue())).intValue()) {
                        }
                    } else if (num.intValue() != this.f4706c || (mediaInfo2 = this.f4704a) == null) {
                        arrayList3.add(new MediaQueueItem(jSONObject5));
                    } else {
                        MediaQueueItem mediaQueueItemM5759r = new C2782c(mediaInfo2).m5759r();
                        mediaQueueItemM5759r.m3599j(jSONObject5);
                        arrayList3.add(mediaQueueItemM5759r);
                    }
                    zM3599j = true;
                }
                zM3599j |= !(arrayList2.size() == length);
                m3603m(arrayList3);
            }
            if (zM3599j) {
                i10 |= 8;
            }
        }
        int i24 = i10;
        JSONObject jSONObjectOptJSONObject2 = jSONObject2.optJSONObject("breakStatus");
        Parcelable.Creator<AdBreakStatus> creator = AdBreakStatus.CREATOR;
        if (jSONObjectOptJSONObject2 != null && jSONObjectOptJSONObject2.has("currentBreakTime") && jSONObjectOptJSONObject2.has("currentBreakClipTime")) {
            try {
                long j13 = jSONObjectOptJSONObject2.getLong("currentBreakTime");
                Pattern pattern3 = AbstractC3987a.f13519a;
                long j14 = j13 * 1000;
                long j15 = jSONObjectOptJSONObject2.getLong("currentBreakClipTime") * 1000;
                String strM7969b = AbstractC3987a.m7969b(jSONObjectOptJSONObject2, "breakId");
                String strM7969b2 = AbstractC3987a.m7969b(jSONObjectOptJSONObject2, "breakClipId");
                long jOptLong = jSONObjectOptJSONObject2.optLong("whenSkippable", -1L);
                if (jOptLong != -1) {
                    jOptLong *= 1000;
                }
                adBreakStatus = new AdBreakStatus(j14, j15, strM7969b, strM7969b2, jOptLong);
            } catch (JSONException e5) {
                C3988b c3988b = AdBreakStatus.f4584f;
                Log.e(c3988b.f13521a, c3988b.m7977d("Error while creating an AdBreakClipInfo from JSON", new Object[0]), e5);
                adBreakStatus = null;
            }
        } else {
            adBreakStatus = null;
        }
        AdBreakStatus adBreakStatus2 = this.f4722s;
        if ((adBreakStatus2 == null && adBreakStatus != null) || (adBreakStatus2 != null && !adBreakStatus2.equals(adBreakStatus))) {
            this.f4721r = (adBreakStatus == null || (adBreakStatus.f4587c == null && adBreakStatus.f4588d == null)) ? false : true;
            this.f4722s = adBreakStatus;
            i24 |= 32;
        }
        JSONObject jSONObjectOptJSONObject3 = jSONObject2.optJSONObject("videoInfo");
        C3988b c3988b2 = VideoInfo.f4756d;
        if (jSONObjectOptJSONObject3 == null) {
            videoInfo = null;
        } else {
            try {
                String string3 = jSONObjectOptJSONObject3.getString("hdrType");
                int iHashCode = string3.hashCode();
                if (iHashCode != 3218) {
                    if (iHashCode != 103158) {
                        if (iHashCode != 113729) {
                            if (iHashCode == 99136405 && string3.equals("hdr10")) {
                                b8 = 1;
                            } else {
                                b8 = -1;
                            }
                        } else if (string3.equals("sdr")) {
                            b8 = 3;
                        } else {
                            b8 = -1;
                        }
                    } else if (string3.equals("hdr")) {
                        b8 = 2;
                    } else {
                        b8 = -1;
                    }
                } else if (string3.equals("dv")) {
                    b8 = 0;
                } else {
                    b8 = -1;
                }
                if (b8 == 0) {
                    i11 = 3;
                } else if (b8 == 1) {
                    i11 = 2;
                } else if (b8 == 2) {
                    i11 = 4;
                } else if (b8 != 3) {
                    c3988b2.m7975b("Unknown HDR type: %s", string3);
                    i11 = 0;
                } else {
                    i11 = 1;
                }
                videoInfo = new VideoInfo(jSONObjectOptJSONObject3.getInt("width"), jSONObjectOptJSONObject3.getInt("height"), i11);
            } catch (JSONException e10) {
                c3988b2.m7974a(e10, "Error while creating a VideoInfo instance from JSON", new Object[0]);
                videoInfo = null;
            }
        }
        VideoInfo videoInfo2 = this.f4723t;
        if ((videoInfo2 == null && videoInfo != null) || (videoInfo2 != null && !videoInfo2.equals(videoInfo))) {
            this.f4723t = videoInfo;
            i24 |= 64;
        }
        if (jSONObject2.has("breakInfo") && (mediaInfo = this.f4704a) != null) {
            mediaInfo.m3592l(jSONObject2.getJSONObject("breakInfo"));
            i24 |= 2;
        }
        if (jSONObject2.has("queueData")) {
            MediaQueueData mediaQueueData = new MediaQueueData();
            mediaQueueData.f4685a = null;
            mediaQueueData.f4686b = null;
            mediaQueueData.f4687c = 0;
            mediaQueueData.f4688d = null;
            mediaQueueData.f4690f = 0;
            mediaQueueData.f4691g = null;
            mediaQueueData.f4692h = 0;
            mediaQueueData.f4693i = -1L;
            mediaQueueData.f4694j = false;
            JSONObject jSONObject6 = jSONObject2.getJSONObject("queueData");
            mediaQueueData.f4685a = null;
            mediaQueueData.f4686b = null;
            mediaQueueData.f4687c = 0;
            mediaQueueData.f4688d = null;
            mediaQueueData.f4690f = 0;
            mediaQueueData.f4691g = null;
            mediaQueueData.f4692h = 0;
            mediaQueueData.f4693i = -1L;
            mediaQueueData.f4694j = false;
            if (jSONObject6 != null) {
                mediaQueueData.f4685a = AbstractC3987a.m7969b(jSONObject6, TtmlNode.ATTR_ID);
                mediaQueueData.f4686b = AbstractC3987a.m7969b(jSONObject6, "entity");
                switch (jSONObject6.optString("queueType")) {
                    case "ALBUM":
                        i12 = 1;
                        mediaQueueData.f4687c = i12;
                        break;
                    case "PLAYLIST":
                        i12 = 2;
                        mediaQueueData.f4687c = i12;
                        break;
                    case "AUDIOBOOK":
                        i12 = 3;
                        mediaQueueData.f4687c = i12;
                        break;
                    case "RADIO_STATION":
                        i12 = 4;
                        mediaQueueData.f4687c = i12;
                        break;
                    case "PODCAST_SERIES":
                        i12 = 5;
                        mediaQueueData.f4687c = i12;
                        break;
                    case "TV_SERIES":
                        mediaQueueData.f4687c = 6;
                        break;
                    case "VIDEO_PLAYLIST":
                        mediaQueueData.f4687c = 7;
                        break;
                    case "LIVE_TV":
                        i12 = 8;
                        mediaQueueData.f4687c = i12;
                        break;
                    case "MOVIE":
                        i12 = 9;
                        mediaQueueData.f4687c = i12;
                        break;
                }
                mediaQueueData.f4688d = AbstractC3987a.m7969b(jSONObject6, SerializableCookie.NAME);
                JSONObject jSONObjectOptJSONObject4 = jSONObject6.has("containerMetadata") ? jSONObject6.optJSONObject("containerMetadata") : null;
                if (jSONObjectOptJSONObject4 != null) {
                    MediaQueueContainerMetadata mediaQueueContainerMetadata = new MediaQueueContainerMetadata();
                    mediaQueueContainerMetadata.f4680a = 0;
                    mediaQueueContainerMetadata.f4681b = null;
                    mediaQueueContainerMetadata.f4682c = null;
                    mediaQueueContainerMetadata.f4683d = null;
                    mediaQueueContainerMetadata.f4684e = 0.0d;
                    String strOptString = jSONObjectOptJSONObject4.optString("containerType", "");
                    int iHashCode2 = strOptString.hashCode();
                    if (iHashCode2 != 6924225) {
                        if (iHashCode2 == 828666841 && strOptString.equals("GENERIC_CONTAINER")) {
                            b10 = 0;
                        } else {
                            b10 = -1;
                        }
                    } else if (strOptString.equals("AUDIOBOOK_CONTAINER")) {
                        b10 = 1;
                    } else {
                        b10 = -1;
                    }
                    if (b10 == 0) {
                        mediaQueueContainerMetadata.f4680a = 0;
                    } else if (b10 == 1) {
                        mediaQueueContainerMetadata.f4680a = 1;
                    }
                    mediaQueueContainerMetadata.f4681b = AbstractC3987a.m7969b(jSONObjectOptJSONObject4, "title");
                    JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject4.optJSONArray("sections");
                    if (jSONArrayOptJSONArray != null) {
                        ArrayList arrayList4 = new ArrayList();
                        mediaQueueContainerMetadata.f4682c = arrayList4;
                        for (int i25 = 0; i25 < jSONArrayOptJSONArray.length(); i25++) {
                            JSONObject jSONObjectOptJSONObject5 = jSONArrayOptJSONArray.optJSONObject(i25);
                            if (jSONObjectOptJSONObject5 != null) {
                                MediaMetadata mediaMetadata = new MediaMetadata(0);
                                mediaMetadata.m3596m(jSONObjectOptJSONObject5);
                                arrayList4.add(mediaMetadata);
                            }
                        }
                    }
                    JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject4.optJSONArray("containerImages");
                    if (jSONArrayOptJSONArray2 != null) {
                        ArrayList arrayList5 = new ArrayList();
                        mediaQueueContainerMetadata.f4683d = arrayList5;
                        AbstractC4052a.m8057c(arrayList5, jSONArrayOptJSONArray2);
                    }
                    double dOptDouble = jSONObjectOptJSONObject4.optDouble("containerDuration", mediaQueueContainerMetadata.f4684e);
                    mediaQueueContainerMetadata.f4684e = dOptDouble;
                    MediaQueueContainerMetadata mediaQueueContainerMetadata2 = new MediaQueueContainerMetadata();
                    mediaQueueContainerMetadata2.f4680a = mediaQueueContainerMetadata.f4680a;
                    mediaQueueContainerMetadata2.f4681b = mediaQueueContainerMetadata.f4681b;
                    mediaQueueContainerMetadata2.f4682c = mediaQueueContainerMetadata.f4682c;
                    mediaQueueContainerMetadata2.f4683d = mediaQueueContainerMetadata.f4683d;
                    mediaQueueContainerMetadata2.f4684e = dOptDouble;
                    mediaQueueData.f4689e = mediaQueueContainerMetadata2;
                }
                Integer numM3502v2 = AbstractC1466d.m3502v(jSONObject6.optString("repeatMode"));
                if (numM3502v2 != null) {
                    mediaQueueData.f4690f = numM3502v2.intValue();
                }
                JSONArray jSONArrayOptJSONArray3 = jSONObject6.optJSONArray("items");
                if (jSONArrayOptJSONArray3 != null) {
                    ArrayList arrayList6 = new ArrayList();
                    mediaQueueData.f4691g = arrayList6;
                    for (int i26 = 0; i26 < jSONArrayOptJSONArray3.length(); i26++) {
                        JSONObject jSONObjectOptJSONObject6 = jSONArrayOptJSONArray3.optJSONObject(i26);
                        if (jSONObjectOptJSONObject6 != null) {
                            try {
                                arrayList6.add(new MediaQueueItem(jSONObjectOptJSONObject6));
                            } catch (JSONException unused2) {
                            }
                        }
                    }
                }
                mediaQueueData.f4692h = jSONObject6.optInt("startIndex", mediaQueueData.f4692h);
                if (jSONObject6.has("startTime")) {
                    mediaQueueData.f4693i = (long) (jSONObject6.optDouble("startTime", mediaQueueData.f4693i) * 1000.0d);
                }
                mediaQueueData.f4694j = jSONObject6.optBoolean("shuffle");
            }
            MediaQueueData mediaQueueData2 = new MediaQueueData();
            mediaQueueData2.f4685a = mediaQueueData.f4685a;
            mediaQueueData2.f4686b = mediaQueueData.f4686b;
            mediaQueueData2.f4687c = mediaQueueData.f4687c;
            mediaQueueData2.f4688d = mediaQueueData.f4688d;
            mediaQueueData2.f4689e = mediaQueueData.f4689e;
            mediaQueueData2.f4690f = mediaQueueData.f4690f;
            mediaQueueData2.f4691g = mediaQueueData.f4691g;
            mediaQueueData2.f4692h = mediaQueueData.f4692h;
            mediaQueueData2.f4693i = mediaQueueData.f4693i;
            boolean z11 = mediaQueueData.f4694j;
            mediaQueueData2.f4694j = z11;
            this.f4725v = mediaQueueData2;
            if (this.f4726w != z11) {
                this.f4726w = z11;
                i24 |= 8;
            }
        }
        if (jSONObject2.has("liveSeekableRange")) {
            i24 |= 2;
            JSONObject jSONObjectOptJSONObject7 = jSONObject2.optJSONObject("liveSeekableRange");
            Parcelable.Creator<MediaLiveSeekableRange> creator2 = MediaLiveSeekableRange.CREATOR;
            if (jSONObjectOptJSONObject7 != null && jSONObjectOptJSONObject7.has(TtmlNode.START) && jSONObjectOptJSONObject7.has(TtmlNode.END)) {
                try {
                    double d12 = jSONObjectOptJSONObject7.getDouble(TtmlNode.START);
                    Pattern pattern4 = AbstractC3987a.f13519a;
                    mediaLiveSeekableRange = new MediaLiveSeekableRange((long) (d12 * 1000.0d), (long) (jSONObjectOptJSONObject7.getDouble(TtmlNode.END) * 1000.0d), jSONObjectOptJSONObject7.optBoolean("isMovingWindow"), jSONObjectOptJSONObject7.optBoolean("isLiveDone"));
                } catch (JSONException unused3) {
                    C3988b c3988b3 = MediaLiveSeekableRange.f4656e;
                    Log.e(c3988b3.f13521a, c3988b3.m7977d("Ignoring Malformed MediaLiveSeekableRange: ".concat(jSONObjectOptJSONObject7.toString()), new Object[0]));
                    mediaLiveSeekableRange = null;
                }
            } else {
                mediaLiveSeekableRange = null;
            }
            this.f4724u = mediaLiveSeekableRange;
        } else {
            if (this.f4724u != null) {
                i24 |= 2;
            }
            this.f4724u = null;
        }
        return i24;
    }

    public final void m3603m(ArrayList arrayList) {
        ArrayList arrayList2 = this.f4720q;
        arrayList2.clear();
        SparseArray sparseArray = this.f4727x;
        sparseArray.clear();
        if (arrayList != null) {
            for (int i6 = 0; i6 < arrayList.size(); i6++) {
                MediaQueueItem mediaQueueItem = (MediaQueueItem) arrayList.get(i6);
                arrayList2.add(mediaQueueItem);
                sparseArray.put(mediaQueueItem.f4696b, Integer.valueOf(i6));
            }
        }
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i6) {
        JSONObject jSONObject = this.f4718o;
        this.f4717n = jSONObject == null ? null : jSONObject.toString();
        int iM6583V = AbstractC3280d.m6583V(parcel, 20293);
        AbstractC3280d.m6578Q(parcel, 2, this.f4704a, i6);
        long j10 = this.f4705b;
        AbstractC3280d.m6585X(parcel, 3, 8);
        parcel.writeLong(j10);
        int i10 = this.f4706c;
        AbstractC3280d.m6585X(parcel, 4, 4);
        parcel.writeInt(i10);
        double d = this.f4707d;
        AbstractC3280d.m6585X(parcel, 5, 8);
        parcel.writeDouble(d);
        int i11 = this.f4708e;
        AbstractC3280d.m6585X(parcel, 6, 4);
        parcel.writeInt(i11);
        int i12 = this.f4709f;
        AbstractC3280d.m6585X(parcel, 7, 4);
        parcel.writeInt(i12);
        long j11 = this.f4710g;
        AbstractC3280d.m6585X(parcel, 8, 8);
        parcel.writeLong(j11);
        long j12 = this.f4711h;
        AbstractC3280d.m6585X(parcel, 9, 8);
        parcel.writeLong(j12);
        double d10 = this.f4712i;
        AbstractC3280d.m6585X(parcel, 10, 8);
        parcel.writeDouble(d10);
        boolean z7 = this.f4713j;
        AbstractC3280d.m6585X(parcel, 11, 4);
        parcel.writeInt(z7 ? 1 : 0);
        AbstractC3280d.m6577P(parcel, 12, this.f4714k);
        int i13 = this.f4715l;
        AbstractC3280d.m6585X(parcel, 13, 4);
        parcel.writeInt(i13);
        int i14 = this.f4716m;
        AbstractC3280d.m6585X(parcel, 14, 4);
        parcel.writeInt(i14);
        AbstractC3280d.m6579R(parcel, 15, this.f4717n);
        int i15 = this.f4719p;
        AbstractC3280d.m6585X(parcel, 16, 4);
        parcel.writeInt(i15);
        AbstractC3280d.m6582U(parcel, 17, this.f4720q);
        boolean z10 = this.f4721r;
        AbstractC3280d.m6585X(parcel, 18, 4);
        parcel.writeInt(z10 ? 1 : 0);
        AbstractC3280d.m6578Q(parcel, 19, this.f4722s, i6);
        AbstractC3280d.m6578Q(parcel, 20, this.f4723t, i6);
        AbstractC3280d.m6578Q(parcel, 21, this.f4724u, i6);
        AbstractC3280d.m6578Q(parcel, 22, this.f4725v, i6);
        AbstractC3280d.m6584W(parcel, iM6583V);
    }
}
