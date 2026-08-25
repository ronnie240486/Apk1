package p125l7;

import java.lang.reflect.Field;
import java.util.Locale;

public abstract class EnumC3000g {

    public static final C2994a f10289a;

    public static final EnumC3000g[] f10290b;

    static {
        C2994a c2994a = new C2994a();
        f10289a = c2994a;
        f10290b = new EnumC3000g[]{c2994a, new EnumC3000g() {
            @Override
            public final String mo6074b(Field field) {
                return EnumC3000g.m6076c(field.getName());
            }
        }, new EnumC3000g() {
            @Override
            public final String mo6074b(Field field) {
                return EnumC3000g.m6076c(EnumC3000g.m6075a(field.getName(), " "));
            }
        }, new EnumC3000g() {
            @Override
            public final String mo6074b(Field field) {
                return EnumC3000g.m6075a(field.getName(), "_").toLowerCase(Locale.ENGLISH);
            }
        }, new EnumC3000g() {
            @Override
            public final String mo6074b(Field field) {
                return EnumC3000g.m6075a(field.getName(), "-").toLowerCase(Locale.ENGLISH);
            }
        }, new EnumC3000g() {
            @Override
            public final String mo6074b(Field field) {
                return EnumC3000g.m6075a(field.getName(), ".").toLowerCase(Locale.ENGLISH);
            }
        }};
    }

    public static String m6075a(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i6 = 0; i6 < length; i6++) {
            char cCharAt = str.charAt(i6);
            if (Character.isUpperCase(cCharAt) && sb.length() != 0) {
                sb.append(str2);
            }
            sb.append(cCharAt);
        }
        return sb.toString();
    }

    public static String m6076c(String str) {
        int length = str.length() - 1;
        int i6 = 0;
        while (!Character.isLetter(str.charAt(i6)) && i6 < length) {
            i6++;
        }
        char cCharAt = str.charAt(i6);
        if (Character.isUpperCase(cCharAt)) {
            return str;
        }
        char upperCase = Character.toUpperCase(cCharAt);
        if (i6 == 0) {
            return upperCase + str.substring(1);
        }
        return str.substring(0, i6) + upperCase + str.substring(i6 + 1);
    }

    public static EnumC3000g valueOf(String str) {
        return (EnumC3000g) Enum.valueOf(EnumC3000g.class, str);
    }

    public static EnumC3000g[] values() {
        return (EnumC3000g[]) f10290b.clone();
    }

    public abstract String mo6074b(Field field);
}
