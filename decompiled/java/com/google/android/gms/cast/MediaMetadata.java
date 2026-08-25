package com.google.android.gms.cast;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p002a1.C0026b;
import p078h5.C2661a;
import p156o9.AbstractC3280d;
import p230v4.AbstractC3987a;
import p241w4.AbstractC4052a;

public class MediaMetadata extends AbstractSafeParcelable {

    public static final C0026b f4676e;

    public final ArrayList f4677a;

    public final Bundle f4678b;

    public int f4679c;

    public static final String[] f4675d = {"none", "String", "int", "double", "ISO-8601 date String", "Time in milliseconds as long"};
    public static final Parcelable.Creator<MediaMetadata> CREATOR = new C2661a(22);

    static {
        C0026b c0026b = new C0026b(29);
        c0026b.m124L(4, "com.google.android.gms.cast.metadata.CREATION_DATE", "creationDateTime");
        c0026b.m124L(4, "com.google.android.gms.cast.metadata.RELEASE_DATE", "releaseDate");
        c0026b.m124L(4, "com.google.android.gms.cast.metadata.BROADCAST_DATE", "originalAirdate");
        c0026b.m124L(1, "com.google.android.gms.cast.metadata.TITLE", "title");
        c0026b.m124L(1, "com.google.android.gms.cast.metadata.SUBTITLE", "subtitle");
        c0026b.m124L(1, "com.google.android.gms.cast.metadata.ARTIST", "artist");
        c0026b.m124L(1, "com.google.android.gms.cast.metadata.ALBUM_ARTIST", "albumArtist");
        c0026b.m124L(1, "com.google.android.gms.cast.metadata.ALBUM_TITLE", "albumName");
        c0026b.m124L(1, "com.google.android.gms.cast.metadata.COMPOSER", "composer");
        c0026b.m124L(2, "com.google.android.gms.cast.metadata.DISC_NUMBER", "discNumber");
        c0026b.m124L(2, "com.google.android.gms.cast.metadata.TRACK_NUMBER", "trackNumber");
        c0026b.m124L(2, "com.google.android.gms.cast.metadata.SEASON_NUMBER", "season");
        c0026b.m124L(2, "com.google.android.gms.cast.metadata.EPISODE_NUMBER", "episode");
        c0026b.m124L(1, "com.google.android.gms.cast.metadata.SERIES_TITLE", "seriesTitle");
        c0026b.m124L(1, "com.google.android.gms.cast.metadata.STUDIO", "studio");
        c0026b.m124L(2, "com.google.android.gms.cast.metadata.WIDTH", "width");
        c0026b.m124L(2, "com.google.android.gms.cast.metadata.HEIGHT", "height");
        c0026b.m124L(1, "com.google.android.gms.cast.metadata.LOCATION_NAME", "location");
        c0026b.m124L(3, "com.google.android.gms.cast.metadata.LOCATION_LATITUDE", "latitude");
        c0026b.m124L(3, "com.google.android.gms.cast.metadata.LOCATION_LONGITUDE", "longitude");
        c0026b.m124L(5, "com.google.android.gms.cast.metadata.SECTION_DURATION", "sectionDuration");
        c0026b.m124L(5, "com.google.android.gms.cast.metadata.SECTION_START_TIME_IN_MEDIA", "sectionStartTimeInMedia");
        c0026b.m124L(5, "com.google.android.gms.cast.metadata.SECTION_START_ABSOLUTE_TIME", "sectionStartAbsoluteTime");
        c0026b.m124L(5, "com.google.android.gms.cast.metadata.SECTION_START_TIME_IN_CONTAINER", "sectionStartTimeInContainer");
        c0026b.m124L(2, "com.google.android.gms.cast.metadata.QUEUE_ITEM_ID", "queueItemId");
        c0026b.m124L(1, "com.google.android.gms.cast.metadata.BOOK_TITLE", "bookTitle");
        c0026b.m124L(2, "com.google.android.gms.cast.metadata.CHAPTER_NUMBER", "chapterNumber");
        c0026b.m124L(1, "com.google.android.gms.cast.metadata.CHAPTER_TITLE", "chapterTitle");
        f4676e = c0026b;
    }

    public MediaMetadata(ArrayList arrayList, Bundle bundle, int i6) {
        this.f4677a = arrayList;
        this.f4678b = bundle;
        this.f4679c = i6;
    }

    public static void m3593j(int i6, String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("null and empty keys are not allowed");
        }
        Integer num = (Integer) ((HashMap) f4676e.f56d).get(str);
        int iIntValue = num != null ? num.intValue() : 0;
        if (iIntValue == i6 || iIntValue == 0) {
            return;
        }
        throw new IllegalArgumentException("Value for " + str + " must be a " + f4675d[i6]);
    }

    public static boolean m3594n(Bundle bundle, Bundle bundle2) {
        if (bundle.size() != bundle2.size()) {
            return false;
        }
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            Object obj2 = bundle2.get(str);
            if ((obj instanceof Bundle) && (obj2 instanceof Bundle) && !m3594n((Bundle) obj, (Bundle) obj2)) {
                return false;
            }
            if (obj == null) {
                if (obj2 != null || !bundle2.containsKey(str)) {
                    return false;
                }
            } else if (!obj.equals(obj2)) {
                return false;
            }
        }
        return true;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaMetadata)) {
            return false;
        }
        MediaMetadata mediaMetadata = (MediaMetadata) obj;
        return m3594n(this.f4678b, mediaMetadata.f4678b) && this.f4677a.equals(mediaMetadata.f4677a);
    }

    public final int hashCode() {
        int iHashCode = 17;
        Bundle bundle = this.f4678b;
        if (bundle != null) {
            Iterator<String> it = bundle.keySet().iterator();
            while (it.hasNext()) {
                Object obj = bundle.get(it.next());
                iHashCode = (iHashCode * 31) + (obj != null ? obj.hashCode() : 0);
            }
        }
        return this.f4677a.hashCode() + (iHashCode * 31);
    }

    public final JSONObject m3595l() {
        ArrayList arrayList;
        Iterator it;
        Bundle bundle;
        JSONObject jSONObject = new JSONObject();
        try {
            try {
                jSONObject.put("metadataType", this.f4679c);
                while (true) {
                    boolean zHasNext = it.hasNext();
                    bundle = this.f4678b;
                    if (!zHasNext) {
                        break;
                    }
                    String str = (String) it.next();
                    if (str != null && bundle.containsKey(str)) {
                        C0026b c0026b = f4676e;
                        String str2 = (String) ((HashMap) c0026b.f54b).get(str);
                        if (str2 != null) {
                            Integer num = (Integer) ((HashMap) c0026b.f56d).get(str);
                            int iIntValue = num != null ? num.intValue() : 0;
                            if (iIntValue != 1) {
                                if (iIntValue == 2) {
                                    jSONObject.put(str2, bundle.getInt(str));
                                } else if (iIntValue == 3) {
                                    jSONObject.put(str2, bundle.getDouble(str));
                                } else if (iIntValue != 4) {
                                    if (iIntValue == 5) {
                                        long j10 = bundle.getLong(str);
                                        Pattern pattern = AbstractC3987a.f13519a;
                                        jSONObject.put(str2, j10 / 1000.0d);
                                    }
                                }
                            }
                            jSONObject.put(str2, bundle.getString(str));
                        }
                    }
                }
            } catch (JSONException unused) {
            }
            it = arrayList.iterator();
            for (String str3 : bundle.keySet()) {
                if (!str3.startsWith("com.google.")) {
                    Object obj = bundle.get(str3);
                    if (obj instanceof String) {
                        jSONObject.put(str3, obj);
                    } else if (obj instanceof Integer) {
                        jSONObject.put(str3, obj);
                    } else if (obj instanceof Double) {
                        jSONObject.put(str3, obj);
                    }
                }
            }
        } catch (JSONException unused2) {
        }
        JSONArray jSONArrayM8056b = AbstractC4052a.m8056b(this.f4677a);
        if (jSONArrayM8056b.length() != 0) {
            try {
                jSONObject.put("images", jSONArrayM8056b);
            } catch (JSONException unused3) {
            }
        }
        arrayList = new ArrayList();
        int i6 = this.f4679c;
        if (i6 == 0) {
            Collections.addAll(arrayList, "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.ARTIST", "com.google.android.gms.cast.metadata.SUBTITLE", "com.google.android.gms.cast.metadata.RELEASE_DATE");
        } else if (i6 == 1) {
            Collections.addAll(arrayList, "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.STUDIO", "com.google.android.gms.cast.metadata.SUBTITLE", "com.google.android.gms.cast.metadata.RELEASE_DATE");
        } else if (i6 == 2) {
            Collections.addAll(arrayList, "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.SERIES_TITLE", "com.google.android.gms.cast.metadata.SEASON_NUMBER", "com.google.android.gms.cast.metadata.EPISODE_NUMBER", "com.google.android.gms.cast.metadata.BROADCAST_DATE");
        } else if (i6 == 3) {
            Collections.addAll(arrayList, "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.ARTIST", "com.google.android.gms.cast.metadata.ALBUM_TITLE", "com.google.android.gms.cast.metadata.ALBUM_ARTIST", "com.google.android.gms.cast.metadata.COMPOSER", "com.google.android.gms.cast.metadata.TRACK_NUMBER", "com.google.android.gms.cast.metadata.DISC_NUMBER", "com.google.android.gms.cast.metadata.RELEASE_DATE");
        } else if (i6 == 4) {
            Collections.addAll(arrayList, "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.ARTIST", "com.google.android.gms.cast.metadata.LOCATION_NAME", "com.google.android.gms.cast.metadata.LOCATION_LATITUDE", "com.google.android.gms.cast.metadata.LOCATION_LONGITUDE", "com.google.android.gms.cast.metadata.WIDTH", "com.google.android.gms.cast.metadata.HEIGHT", "com.google.android.gms.cast.metadata.CREATION_DATE");
        } else if (i6 == 5) {
            Collections.addAll(arrayList, "com.google.android.gms.cast.metadata.CHAPTER_TITLE", "com.google.android.gms.cast.metadata.CHAPTER_NUMBER", "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.BOOK_TITLE", "com.google.android.gms.cast.metadata.SUBTITLE");
        }
        Collections.addAll(arrayList, "com.google.android.gms.cast.metadata.SECTION_DURATION", "com.google.android.gms.cast.metadata.SECTION_START_TIME_IN_MEDIA", "com.google.android.gms.cast.metadata.SECTION_START_ABSOLUTE_TIME", "com.google.android.gms.cast.metadata.SECTION_START_TIME_IN_CONTAINER", "com.google.android.gms.cast.metadata.QUEUE_ITEM_ID");
        return jSONObject;
    }

    public final void m3596m(JSONObject jSONObject) {
        HashSet hashSet;
        Bundle bundle = this.f4678b;
        bundle.clear();
        ArrayList arrayList = this.f4677a;
        arrayList.clear();
        this.f4679c = 0;
        try {
            this.f4679c = jSONObject.getInt("metadataType");
        } catch (JSONException unused) {
        }
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("images");
        if (jSONArrayOptJSONArray != null) {
            AbstractC4052a.m8057c(arrayList, jSONArrayOptJSONArray);
        }
        ArrayList arrayList2 = new ArrayList();
        int i6 = this.f4679c;
        if (i6 == 0) {
            Collections.addAll(arrayList2, "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.ARTIST", "com.google.android.gms.cast.metadata.SUBTITLE", "com.google.android.gms.cast.metadata.RELEASE_DATE");
        } else if (i6 == 1) {
            Collections.addAll(arrayList2, "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.STUDIO", "com.google.android.gms.cast.metadata.SUBTITLE", "com.google.android.gms.cast.metadata.RELEASE_DATE");
        } else if (i6 == 2) {
            Collections.addAll(arrayList2, "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.SERIES_TITLE", "com.google.android.gms.cast.metadata.SEASON_NUMBER", "com.google.android.gms.cast.metadata.EPISODE_NUMBER", "com.google.android.gms.cast.metadata.BROADCAST_DATE");
        } else if (i6 == 3) {
            Collections.addAll(arrayList2, "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.ALBUM_TITLE", "com.google.android.gms.cast.metadata.ARTIST", "com.google.android.gms.cast.metadata.ALBUM_ARTIST", "com.google.android.gms.cast.metadata.COMPOSER", "com.google.android.gms.cast.metadata.TRACK_NUMBER", "com.google.android.gms.cast.metadata.DISC_NUMBER", "com.google.android.gms.cast.metadata.RELEASE_DATE");
        } else if (i6 == 4) {
            Collections.addAll(arrayList2, "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.ARTIST", "com.google.android.gms.cast.metadata.LOCATION_NAME", "com.google.android.gms.cast.metadata.LOCATION_LATITUDE", "com.google.android.gms.cast.metadata.LOCATION_LONGITUDE", "com.google.android.gms.cast.metadata.WIDTH", "com.google.android.gms.cast.metadata.HEIGHT", "com.google.android.gms.cast.metadata.CREATION_DATE");
        } else if (i6 == 5) {
            Collections.addAll(arrayList2, "com.google.android.gms.cast.metadata.CHAPTER_TITLE", "com.google.android.gms.cast.metadata.CHAPTER_NUMBER", "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.BOOK_TITLE", "com.google.android.gms.cast.metadata.SUBTITLE");
        }
        Collections.addAll(arrayList2, "com.google.android.gms.cast.metadata.SECTION_DURATION", "com.google.android.gms.cast.metadata.SECTION_START_TIME_IN_MEDIA", "com.google.android.gms.cast.metadata.SECTION_START_ABSOLUTE_TIME", "com.google.android.gms.cast.metadata.SECTION_START_TIME_IN_CONTAINER", "com.google.android.gms.cast.metadata.QUEUE_ITEM_ID");
        HashSet hashSet2 = new HashSet(arrayList2);
        try {
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                if (next != null && !"metadataType".equals(next)) {
                    C0026b c0026b = f4676e;
                    String str = (String) ((HashMap) c0026b.f55c).get(next);
                    if (str == null) {
                        hashSet = hashSet2;
                        Object obj = jSONObject.get(next);
                        if (obj instanceof String) {
                            bundle.putString(next, (String) obj);
                        } else if (obj instanceof Integer) {
                            bundle.putInt(next, ((Integer) obj).intValue());
                        } else if (obj instanceof Double) {
                            bundle.putDouble(next, ((Double) obj).doubleValue());
                        }
                    } else if (hashSet2.contains(str)) {
                        try {
                            Object obj2 = jSONObject.get(next);
                            if (obj2 != null) {
                                Integer num = (Integer) ((HashMap) c0026b.f56d).get(str);
                                int iIntValue = num != null ? num.intValue() : 0;
                                if (iIntValue == 1) {
                                    hashSet = hashSet2;
                                    if (obj2 instanceof String) {
                                        bundle.putString(str, (String) obj2);
                                    }
                                } else if (iIntValue == 2) {
                                    hashSet = hashSet2;
                                    if (obj2 instanceof Integer) {
                                        bundle.putInt(str, ((Integer) obj2).intValue());
                                    }
                                } else if (iIntValue == 3) {
                                    hashSet = hashSet2;
                                    double dOptDouble = jSONObject.optDouble(next);
                                    if (!Double.isNaN(dOptDouble)) {
                                        bundle.putDouble(str, dOptDouble);
                                    }
                                } else if (iIntValue == 4) {
                                    hashSet = hashSet2;
                                    if (obj2 instanceof String) {
                                        String str2 = (String) obj2;
                                        if (AbstractC4052a.m8055a(str2) != null) {
                                            bundle.putString(str, str2);
                                        }
                                    }
                                } else if (iIntValue == 5) {
                                    long jOptLong = jSONObject.optLong(next);
                                    Pattern pattern = AbstractC3987a.f13519a;
                                    hashSet = hashSet2;
                                    try {
                                        bundle.putLong(str, jOptLong * 1000);
                                    } catch (JSONException unused2) {
                                    }
                                }
                            }
                        } catch (JSONException unused3) {
                            hashSet = hashSet2;
                        }
                    }
                    hashSet2 = hashSet;
                }
            }
        } catch (JSONException unused4) {
        }
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i6) {
        int iM6583V = AbstractC3280d.m6583V(parcel, 20293);
        AbstractC3280d.m6582U(parcel, 2, this.f4677a);
        AbstractC3280d.m6574M(parcel, 3, this.f4678b);
        int i10 = this.f4679c;
        AbstractC3280d.m6585X(parcel, 4, 4);
        parcel.writeInt(i10);
        AbstractC3280d.m6584W(parcel, iM6583V);
    }

    public MediaMetadata(int i6) {
        this(new ArrayList(), new Bundle(), i6);
    }
}
