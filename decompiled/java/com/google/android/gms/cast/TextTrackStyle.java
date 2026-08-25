package com.google.android.gms.cast;

import android.graphics.Color;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;
import p111k5.AbstractC2891a;
import p156o9.AbstractC3280d;
import p165p4.C3371p;
import p230v4.AbstractC3987a;

public final class TextTrackStyle extends AbstractSafeParcelable {
    public static final Parcelable.Creator<TextTrackStyle> CREATOR = new C3371p(0);

    public float f4741a;

    public int f4742b;

    public int f4743c;

    public int f4744d;

    public int f4745e;

    public int f4746f;

    public int f4747g;

    public int f4748h;

    public String f4749i;

    public int f4750j;

    public int f4751k;

    public String f4752l;

    public JSONObject f4753m;

    public TextTrackStyle(float f, int i6, int i10, int i11, int i12, int i13, int i14, int i15, String str, int i16, int i17, String str2) {
        this.f4741a = f;
        this.f4742b = i6;
        this.f4743c = i10;
        this.f4744d = i11;
        this.f4745e = i12;
        this.f4746f = i13;
        this.f4747g = i14;
        this.f4748h = i15;
        this.f4749i = str;
        this.f4750j = i16;
        this.f4751k = i17;
        this.f4752l = str2;
        if (str2 == null) {
            this.f4753m = null;
            return;
        }
        try {
            this.f4753m = new JSONObject(this.f4752l);
        } catch (JSONException unused) {
            this.f4753m = null;
            this.f4752l = null;
        }
    }

    public static final int m3605l(String str) {
        if (str != null && str.length() == 9 && str.charAt(0) == '#') {
            try {
                return Color.argb(Integer.parseInt(str.substring(7, 9), 16), Integer.parseInt(str.substring(1, 3), 16), Integer.parseInt(str.substring(3, 5), 16), Integer.parseInt(str.substring(5, 7), 16));
            } catch (NumberFormatException unused) {
            }
        }
        return 0;
    }

    public static final String m3606m(int i6) {
        return String.format("#%02X%02X%02X%02X", Integer.valueOf(Color.red(i6)), Integer.valueOf(Color.green(i6)), Integer.valueOf(Color.blue(i6)), Integer.valueOf(Color.alpha(i6)));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextTrackStyle)) {
            return false;
        }
        TextTrackStyle textTrackStyle = (TextTrackStyle) obj;
        JSONObject jSONObject = this.f4753m;
        boolean z7 = jSONObject == null;
        JSONObject jSONObject2 = textTrackStyle.f4753m;
        if (z7 != (jSONObject2 == null)) {
            return false;
        }
        return (jSONObject == null || jSONObject2 == null || AbstractC2891a.m5894a(jSONObject, jSONObject2)) && this.f4741a == textTrackStyle.f4741a && this.f4742b == textTrackStyle.f4742b && this.f4743c == textTrackStyle.f4743c && this.f4744d == textTrackStyle.f4744d && this.f4745e == textTrackStyle.f4745e && this.f4746f == textTrackStyle.f4746f && this.f4747g == textTrackStyle.f4747g && this.f4748h == textTrackStyle.f4748h && AbstractC3987a.m7972e(this.f4749i, textTrackStyle.f4749i) && this.f4750j == textTrackStyle.f4750j && this.f4751k == textTrackStyle.f4751k;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f4741a), Integer.valueOf(this.f4742b), Integer.valueOf(this.f4743c), Integer.valueOf(this.f4744d), Integer.valueOf(this.f4745e), Integer.valueOf(this.f4746f), Integer.valueOf(this.f4747g), Integer.valueOf(this.f4748h), this.f4749i, Integer.valueOf(this.f4750j), Integer.valueOf(this.f4751k), String.valueOf(this.f4753m)});
    }

    public final JSONObject m3607j() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("fontScale", this.f4741a);
            int i6 = this.f4742b;
            if (i6 != 0) {
                jSONObject.put("foregroundColor", m3606m(i6));
            }
            int i10 = this.f4743c;
            if (i10 != 0) {
                jSONObject.put(TtmlNode.ATTR_TTS_BACKGROUND_COLOR, m3606m(i10));
            }
            int i11 = this.f4744d;
            if (i11 == 0) {
                jSONObject.put("edgeType", "NONE");
            } else if (i11 == 1) {
                jSONObject.put("edgeType", "OUTLINE");
            } else if (i11 == 2) {
                jSONObject.put("edgeType", "DROP_SHADOW");
            } else if (i11 == 3) {
                jSONObject.put("edgeType", "RAISED");
            } else if (i11 == 4) {
                jSONObject.put("edgeType", "DEPRESSED");
            }
            int i12 = this.f4745e;
            if (i12 != 0) {
                jSONObject.put("edgeColor", m3606m(i12));
            }
            int i13 = this.f4746f;
            if (i13 == 0) {
                jSONObject.put("windowType", "NONE");
            } else if (i13 == 1) {
                jSONObject.put("windowType", "NORMAL");
            } else if (i13 == 2) {
                jSONObject.put("windowType", "ROUNDED_CORNERS");
            }
            int i14 = this.f4747g;
            if (i14 != 0) {
                jSONObject.put("windowColor", m3606m(i14));
            }
            if (this.f4746f == 2) {
                jSONObject.put("windowRoundedCornerRadius", this.f4748h);
            }
            String str = this.f4749i;
            if (str != null) {
                jSONObject.put(TtmlNode.ATTR_TTS_FONT_FAMILY, str);
            }
            switch (this.f4750j) {
                case 0:
                    jSONObject.put("fontGenericFamily", "SANS_SERIF");
                    break;
                case 1:
                    jSONObject.put("fontGenericFamily", "MONOSPACED_SANS_SERIF");
                    break;
                case 2:
                    jSONObject.put("fontGenericFamily", "SERIF");
                    break;
                case 3:
                    jSONObject.put("fontGenericFamily", "MONOSPACED_SERIF");
                    break;
                case 4:
                    jSONObject.put("fontGenericFamily", "CASUAL");
                    break;
                case 5:
                    jSONObject.put("fontGenericFamily", "CURSIVE");
                    break;
                case 6:
                    jSONObject.put("fontGenericFamily", "SMALL_CAPITALS");
                    break;
            }
            int i15 = this.f4751k;
            if (i15 == 0) {
                jSONObject.put(TtmlNode.ATTR_TTS_FONT_STYLE, "NORMAL");
            } else if (i15 == 1) {
                jSONObject.put(TtmlNode.ATTR_TTS_FONT_STYLE, "BOLD");
            } else if (i15 == 2) {
                jSONObject.put(TtmlNode.ATTR_TTS_FONT_STYLE, "ITALIC");
            } else if (i15 == 3) {
                jSONObject.put(TtmlNode.ATTR_TTS_FONT_STYLE, "BOLD_ITALIC");
            }
            JSONObject jSONObject2 = this.f4753m;
            if (jSONObject2 != null) {
                jSONObject.put("customData", jSONObject2);
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i6) {
        JSONObject jSONObject = this.f4753m;
        this.f4752l = jSONObject == null ? null : jSONObject.toString();
        int iM6583V = AbstractC3280d.m6583V(parcel, 20293);
        float f = this.f4741a;
        AbstractC3280d.m6585X(parcel, 2, 4);
        parcel.writeFloat(f);
        int i10 = this.f4742b;
        AbstractC3280d.m6585X(parcel, 3, 4);
        parcel.writeInt(i10);
        int i11 = this.f4743c;
        AbstractC3280d.m6585X(parcel, 4, 4);
        parcel.writeInt(i11);
        int i12 = this.f4744d;
        AbstractC3280d.m6585X(parcel, 5, 4);
        parcel.writeInt(i12);
        int i13 = this.f4745e;
        AbstractC3280d.m6585X(parcel, 6, 4);
        parcel.writeInt(i13);
        int i14 = this.f4746f;
        AbstractC3280d.m6585X(parcel, 7, 4);
        parcel.writeInt(i14);
        int i15 = this.f4747g;
        AbstractC3280d.m6585X(parcel, 8, 4);
        parcel.writeInt(i15);
        int i16 = this.f4748h;
        AbstractC3280d.m6585X(parcel, 9, 4);
        parcel.writeInt(i16);
        AbstractC3280d.m6579R(parcel, 10, this.f4749i);
        int i17 = this.f4750j;
        AbstractC3280d.m6585X(parcel, 11, 4);
        parcel.writeInt(i17);
        int i18 = this.f4751k;
        AbstractC3280d.m6585X(parcel, 12, 4);
        parcel.writeInt(i18);
        AbstractC3280d.m6579R(parcel, 13, this.f4752l);
        AbstractC3280d.m6584W(parcel, iM6583V);
    }
}
