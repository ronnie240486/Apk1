package p168p7;

import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public abstract class AbstractC3375a {

    public static final TimeZone f11403a = TimeZone.getTimeZone("UTC");

    public static boolean m6869a(char c5, String str, int i6) {
        return i6 < str.length() && str.charAt(i6) == c5;
    }

    public static Date m6870b(String str, ParsePosition parsePosition) throws ParseException {
        String str2;
        String message;
        int i6;
        int iM6871c;
        int i10;
        int iM6871c2;
        int length;
        char cCharAt;
        try {
            int index = parsePosition.getIndex();
            int i11 = index + 4;
            int iM6871c3 = m6871c(index, i11, str);
            if (m6869a('-', str, i11)) {
                i11 = index + 5;
            }
            int i12 = i11 + 2;
            int iM6871c4 = m6871c(i11, i12, str);
            if (m6869a('-', str, i12)) {
                i12 = i11 + 3;
            }
            int i13 = i12 + 2;
            int iM6871c5 = m6871c(i12, i13, str);
            boolean zM6869a = m6869a('T', str, i13);
            if (!zM6869a && str.length() <= i13) {
                GregorianCalendar gregorianCalendar = new GregorianCalendar(iM6871c3, iM6871c4 - 1, iM6871c5);
                parsePosition.setIndex(i13);
                return gregorianCalendar.getTime();
            }
            if (zM6869a) {
                int i14 = i12 + 5;
                int iM6871c6 = m6871c(i12 + 3, i14, str);
                if (m6869a(':', str, i14)) {
                    i14 = i12 + 6;
                }
                int i15 = i14 + 2;
                int iM6871c7 = m6871c(i14, i15, str);
                if (m6869a(':', str, i15)) {
                    i15 = i14 + 3;
                }
                if (str.length() <= i15 || (cCharAt = str.charAt(i15)) == 'Z' || cCharAt == '+' || cCharAt == '-') {
                    i10 = iM6871c7;
                    iM6871c = 0;
                    iM6871c2 = 0;
                    i13 = i15;
                    i6 = iM6871c6;
                } else {
                    int i16 = i15 + 2;
                    iM6871c2 = m6871c(i15, i16, str);
                    if (iM6871c2 > 59 && iM6871c2 < 63) {
                        iM6871c2 = 59;
                    }
                    if (m6869a('.', str, i16)) {
                        int i17 = i15 + 3;
                        int length2 = i15 + 4;
                        while (true) {
                            if (length2 >= str.length()) {
                                length2 = str.length();
                                break;
                            }
                            char cCharAt2 = str.charAt(length2);
                            if (cCharAt2 < '0' || cCharAt2 > '9') {
                                break;
                                break;
                            }
                            length2++;
                        }
                        int iMin = Math.min(length2, i15 + 6);
                        iM6871c = m6871c(i17, iMin, str);
                        int i18 = iMin - i17;
                        if (i18 == 1) {
                            iM6871c *= 100;
                        } else if (i18 == 2) {
                            iM6871c *= 10;
                        }
                        i6 = iM6871c6;
                        i13 = length2;
                        i10 = iM6871c7;
                    } else {
                        i6 = iM6871c6;
                        i13 = i16;
                        i10 = iM6871c7;
                        iM6871c = 0;
                    }
                }
            } else {
                i6 = 0;
                iM6871c = 0;
                i10 = 0;
                iM6871c2 = 0;
            }
            if (str.length() <= i13) {
                throw new IllegalArgumentException("No time zone indicator");
            }
            char cCharAt3 = str.charAt(i13);
            TimeZone timeZone = f11403a;
            if (cCharAt3 == 'Z') {
                length = i13 + 1;
            } else {
                if (cCharAt3 != '+' && cCharAt3 != '-') {
                    throw new IndexOutOfBoundsException("Invalid time zone indicator '" + cCharAt3 + "'");
                }
                String strSubstring = str.substring(i13);
                if (strSubstring.length() < 5) {
                    strSubstring = strSubstring + "00";
                }
                length = i13 + strSubstring.length();
                if (!"+0000".equals(strSubstring) && !"+00:00".equals(strSubstring)) {
                    String str3 = "GMT" + strSubstring;
                    timeZone = TimeZone.getTimeZone(str3);
                    String id = timeZone.getID();
                    if (!id.equals(str3) && !id.replace(":", "").equals(str3)) {
                        throw new IndexOutOfBoundsException("Mismatching time zone indicator: " + str3 + " given, resolves to " + timeZone.getID());
                    }
                }
            }
            GregorianCalendar gregorianCalendar2 = new GregorianCalendar(timeZone);
            gregorianCalendar2.setLenient(false);
            gregorianCalendar2.set(1, iM6871c3);
            gregorianCalendar2.set(2, iM6871c4 - 1);
            gregorianCalendar2.set(5, iM6871c5);
            gregorianCalendar2.set(11, i6);
            gregorianCalendar2.set(12, i10);
            gregorianCalendar2.set(13, iM6871c2);
            gregorianCalendar2.set(14, iM6871c);
            parsePosition.setIndex(length);
            return gregorianCalendar2.getTime();
        } catch (IllegalArgumentException e5) {
            e = e5;
            if (str == null) {
                str2 = null;
            } else {
                str2 = "\"" + str + '\"';
            }
            message = e.getMessage();
            if (message != null || message.isEmpty()) {
                message = "(" + e.getClass().getName() + ")";
            }
            ParseException parseException = new ParseException("Failed to parse date [" + str2 + "]: " + message, parsePosition.getIndex());
            parseException.initCause(e);
            throw parseException;
        } catch (IndexOutOfBoundsException e10) {
            e = e10;
            if (str == null) {
                str2 = null;
            } else {
                str2 = "\"" + str + '\"';
            }
            message = e.getMessage();
            if (message != null) {
                message = "(" + e.getClass().getName() + ")";
            } else {
                message = "(" + e.getClass().getName() + ")";
            }
            ParseException parseException2 = new ParseException("Failed to parse date [" + str2 + "]: " + message, parsePosition.getIndex());
            parseException2.initCause(e);
            throw parseException2;
        } catch (NumberFormatException e11) {
            e = e11;
            if (str == null) {
                str2 = null;
            } else {
                str2 = "\"" + str + '\"';
            }
            message = e.getMessage();
            if (message != null) {
                message = "(" + e.getClass().getName() + ")";
            } else {
                message = "(" + e.getClass().getName() + ")";
            }
            ParseException parseException3 = new ParseException("Failed to parse date [" + str2 + "]: " + message, parsePosition.getIndex());
            parseException3.initCause(e);
            throw parseException3;
        }
    }

    public static int m6871c(int i6, int i10, String str) {
        int i11;
        int i12;
        if (i6 < 0 || i10 > str.length() || i6 > i10) {
            throw new NumberFormatException(str);
        }
        if (i6 < i10) {
            i12 = i6 + 1;
            int iDigit = Character.digit(str.charAt(i6), 10);
            if (iDigit < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(i6, i10));
            }
            i11 = -iDigit;
        } else {
            i11 = 0;
            i12 = i6;
        }
        while (i12 < i10) {
            int i13 = i12 + 1;
            int iDigit2 = Character.digit(str.charAt(i12), 10);
            if (iDigit2 < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(i6, i10));
            }
            i11 = (i11 * 10) - iDigit2;
            i12 = i13;
        }
        return -i11;
    }
}
