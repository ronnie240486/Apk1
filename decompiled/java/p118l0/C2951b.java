package p118l0;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import androidx.appcompat.app.C0157r0;
import java.util.Locale;

public final class C2951b {

    public static final String f10126b;

    public static final String f10127c;

    public static final C2951b f10128d;

    public static final C2951b f10129e;

    public final boolean f10130a;

    static {
        C0157r0 c0157r0 = AbstractC2959j.f10139c;
        f10126b = Character.toString((char) 8206);
        f10127c = Character.toString((char) 8207);
        f10128d = new C2951b(false);
        f10129e = new C2951b(true);
    }

    public C2951b(boolean z7) {
        C0157r0 c0157r0 = AbstractC2959j.f10137a;
        this.f10130a = z7;
    }

    public static int m5972a(CharSequence charSequence) {
        byte directionality;
        C2950a c2950a = new C2950a(charSequence);
        c2950a.f10124c = 0;
        int i6 = 0;
        int i10 = 0;
        int i11 = 0;
        while (true) {
            int i12 = c2950a.f10124c;
            if (i12 < c2950a.f10123b && i6 == 0) {
                CharSequence charSequence2 = c2950a.f10122a;
                char cCharAt = charSequence2.charAt(i12);
                c2950a.f10125d = cCharAt;
                if (Character.isHighSurrogate(cCharAt)) {
                    int iCodePointAt = Character.codePointAt(charSequence2, c2950a.f10124c);
                    c2950a.f10124c = Character.charCount(iCodePointAt) + c2950a.f10124c;
                    directionality = Character.getDirectionality(iCodePointAt);
                } else {
                    c2950a.f10124c++;
                    char c5 = c2950a.f10125d;
                    directionality = c5 < 1792 ? C2950a.f10121e[c5] : Character.getDirectionality(c5);
                }
                if (directionality != 0) {
                    if (directionality == 1 || directionality == 2) {
                        if (i11 == 0) {
                            return 1;
                        }
                    } else if (directionality != 9) {
                        switch (directionality) {
                            case 14:
                            case 15:
                                i11++;
                                i10 = -1;
                                continue;
                            case 16:
                            case 17:
                                i11++;
                                i10 = 1;
                                continue;
                            case 18:
                                i11--;
                                i10 = 0;
                                continue;
                        }
                    }
                } else if (i11 == 0) {
                    return -1;
                }
                i6 = i11;
            }
        }
        if (i6 == 0) {
            return 0;
        }
        if (i10 != 0) {
            return i10;
        }
        while (c2950a.f10124c > 0) {
            switch (c2950a.m5971a()) {
                case 14:
                case 15:
                    if (i6 == i11) {
                        return -1;
                    }
                    i11--;
                    break;
                case 16:
                case 17:
                    if (i6 == i11) {
                        return 1;
                    }
                    i11--;
                    break;
                case 18:
                    i11++;
                    break;
                default:
                    break;
            }
        }
        return 0;
    }

    public static int m5973b(CharSequence charSequence) {
        C2950a c2950a = new C2950a(charSequence);
        c2950a.f10124c = c2950a.f10123b;
        int i6 = 0;
        int i10 = 0;
        while (c2950a.f10124c > 0) {
            byte bM5971a = c2950a.m5971a();
            if (bM5971a == 0) {
                if (i6 == 0) {
                    return -1;
                }
                if (i10 == 0) {
                    i10 = i6;
                }
            } else if (bM5971a == 1 || bM5971a == 2) {
                if (i6 == 0) {
                    return 1;
                }
                if (i10 == 0) {
                    i10 = i6;
                }
            } else if (bM5971a != 9) {
                switch (bM5971a) {
                    case 14:
                    case 15:
                        if (i10 == i6) {
                            return -1;
                        }
                        i6--;
                        break;
                    case 16:
                    case 17:
                        if (i10 == i6) {
                            return 1;
                        }
                        i6--;
                        break;
                    case 18:
                        i6++;
                        break;
                    default:
                        if (i10 == 0) {
                            i10 = i6;
                        }
                        break;
                }
            } else {
                continue;
            }
        }
        return 0;
    }

    public static C2951b m5974c() {
        return TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1 ? f10129e : f10128d;
    }

    public final SpannableStringBuilder m5975d(CharSequence charSequence) {
        String str;
        C0157r0 c0157r0 = AbstractC2959j.f10139c;
        if (charSequence == null) {
            return null;
        }
        boolean zM441d = c0157r0.m441d(charSequence, charSequence.length());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        boolean zM441d2 = (zM441d ? AbstractC2959j.f10138b : AbstractC2959j.f10137a).m441d(charSequence, charSequence.length());
        String str2 = "";
        String str3 = f10127c;
        String str4 = f10126b;
        boolean z7 = this.f10130a;
        if (z7 || !(zM441d2 || m5972a(charSequence) == 1)) {
            str = (!z7 || (zM441d2 && m5972a(charSequence) != -1)) ? "" : str3;
        } else {
            str = str4;
        }
        spannableStringBuilder.append((CharSequence) str);
        if (zM441d != z7) {
            spannableStringBuilder.append(zM441d ? (char) 8235 : (char) 8234);
            spannableStringBuilder.append(charSequence);
            spannableStringBuilder.append((char) 8236);
        } else {
            spannableStringBuilder.append(charSequence);
        }
        boolean zM441d3 = (zM441d ? AbstractC2959j.f10138b : AbstractC2959j.f10137a).m441d(charSequence, charSequence.length());
        if (!z7 && (zM441d3 || m5973b(charSequence) == 1)) {
            str2 = str4;
        } else if (z7 && (!zM441d3 || m5973b(charSequence) == -1)) {
            str2 = str3;
        }
        spannableStringBuilder.append((CharSequence) str2);
        return spannableStringBuilder;
    }
}
