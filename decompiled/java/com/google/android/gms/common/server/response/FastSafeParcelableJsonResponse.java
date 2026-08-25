package com.google.android.gms.common.server.response;

import android.util.Base64;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.converter.StringToIntConverter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import p018b5.AbstractC1312l;
import p111k5.AbstractC2891a;
import p187r4.AbstractC3612b;

public abstract class FastSafeParcelableJsonResponse implements SafeParcelable {
    public static final Object m3672o(FastJsonResponse$Field fastJsonResponse$Field, Object obj) {
        StringToIntConverter stringToIntConverter = fastJsonResponse$Field.f5146k;
        if (stringToIntConverter == null) {
            return obj;
        }
        String str = (String) stringToIntConverter.f5130c.get(((Integer) obj).intValue());
        return (str == null && stringToIntConverter.f5129b.containsKey("gms_unknown")) ? "gms_unknown" : str;
    }

    public static final void m3673p(StringBuilder sb, FastJsonResponse$Field fastJsonResponse$Field, Object obj) {
        int i6 = fastJsonResponse$Field.f5137b;
        if (i6 == 11) {
            Class cls = fastJsonResponse$Field.f5143h;
            AbstractC1312l.m3198e(cls);
            sb.append(((FastSafeParcelableJsonResponse) cls.cast(obj)).toString());
        } else {
            if (i6 != 7) {
                sb.append(obj);
                return;
            }
            sb.append("\"");
            sb.append(AbstractC2891a.m5895b((String) obj));
            sb.append("\"");
        }
    }

    @Override
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!getClass().isInstance(obj)) {
            return false;
        }
        FastSafeParcelableJsonResponse fastSafeParcelableJsonResponse = (FastSafeParcelableJsonResponse) obj;
        for (FastJsonResponse$Field fastJsonResponse$Field : mo3674h().values()) {
            if (m3677m(fastJsonResponse$Field)) {
                if (!fastSafeParcelableJsonResponse.m3677m(fastJsonResponse$Field) || !AbstractC1312l.m3201h(m3675j(fastJsonResponse$Field), fastSafeParcelableJsonResponse.m3675j(fastJsonResponse$Field))) {
                    return false;
                }
            } else if (fastSafeParcelableJsonResponse.m3677m(fastJsonResponse$Field)) {
                return false;
            }
        }
        return true;
    }

    public abstract Map mo3674h();

    public final int hashCode() {
        int iHashCode = 0;
        for (FastJsonResponse$Field fastJsonResponse$Field : mo3674h().values()) {
            if (m3677m(fastJsonResponse$Field)) {
                Object objM3675j = m3675j(fastJsonResponse$Field);
                AbstractC1312l.m3198e(objM3675j);
                iHashCode = (iHashCode * 31) + objM3675j.hashCode();
            }
        }
        return iHashCode;
    }

    public final Object m3675j(FastJsonResponse$Field fastJsonResponse$Field) {
        if (fastJsonResponse$Field.f5143h == null) {
            return mo3676l();
        }
        Object objMo3676l = mo3676l();
        String str = fastJsonResponse$Field.f5141f;
        if (objMo3676l != null) {
            throw new IllegalStateException("Concrete field shouldn't be value object: " + str);
        }
        try {
            return getClass().getMethod("get" + Character.toUpperCase(str.charAt(0)) + str.substring(1), null).invoke(this, null);
        } catch (Exception e5) {
            throw new RuntimeException(e5);
        }
    }

    public Object mo3676l() {
        return null;
    }

    public final boolean m3677m(FastJsonResponse$Field fastJsonResponse$Field) {
        if (fastJsonResponse$Field.f5139d != 11) {
            return mo3678n();
        }
        if (fastJsonResponse$Field.f5140e) {
            throw new UnsupportedOperationException("Concrete type arrays not supported");
        }
        throw new UnsupportedOperationException("Concrete types not supported");
    }

    public boolean mo3678n() {
        return false;
    }

    public String toString() {
        Map mapMo3674h = mo3674h();
        StringBuilder sb = new StringBuilder(100);
        for (String str : mapMo3674h.keySet()) {
            FastJsonResponse$Field fastJsonResponse$Field = (FastJsonResponse$Field) mapMo3674h.get(str);
            if (m3677m(fastJsonResponse$Field)) {
                Object objM3672o = m3672o(fastJsonResponse$Field, m3675j(fastJsonResponse$Field));
                if (sb.length() == 0) {
                    sb.append("{");
                } else {
                    sb.append(",");
                }
                sb.append("\"");
                sb.append(str);
                sb.append("\":");
                if (objM3672o != null) {
                    switch (fastJsonResponse$Field.f5139d) {
                        case 8:
                            sb.append("\"");
                            sb.append(Base64.encodeToString((byte[]) objM3672o, 0));
                            sb.append("\"");
                            break;
                        case 9:
                            sb.append("\"");
                            sb.append(Base64.encodeToString((byte[]) objM3672o, 10));
                            sb.append("\"");
                            break;
                        case 10:
                            AbstractC3612b.m7260Q(sb, (HashMap) objM3672o);
                            break;
                        default:
                            if (fastJsonResponse$Field.f5138c) {
                                ArrayList arrayList = (ArrayList) objM3672o;
                                sb.append("[");
                                int size = arrayList.size();
                                for (int i6 = 0; i6 < size; i6++) {
                                    if (i6 > 0) {
                                        sb.append(",");
                                    }
                                    Object obj = arrayList.get(i6);
                                    if (obj != null) {
                                        m3673p(sb, fastJsonResponse$Field, obj);
                                    }
                                }
                                sb.append("]");
                            } else {
                                m3673p(sb, fastJsonResponse$Field, objM3672o);
                            }
                            break;
                    }
                } else {
                    sb.append("null");
                }
            }
        }
        if (sb.length() > 0) {
            sb.append("}");
        } else {
            sb.append("{}");
        }
        return sb.toString();
    }
}
