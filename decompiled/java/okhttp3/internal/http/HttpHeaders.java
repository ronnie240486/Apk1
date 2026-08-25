package okhttp3.internal.http;

import com.lzy.okgo.model.Progress;
import java.io.EOFException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import okhttp3.Challenge;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.platform.Platform;
import okio.Buffer;
import okio.ByteString;
import p055ea.AbstractC2460q;
import p103j9.AbstractC2796i;
import p253x8.C4156s;

public final class HttpHeaders {
    private static final ByteString QUOTED_STRING_DELIMITERS;
    private static final ByteString TOKEN_DELIMITERS;

    static {
        ByteString.Companion companion = ByteString.Companion;
        QUOTED_STRING_DELIMITERS = companion.encodeUtf8("\"\\");
        TOKEN_DELIMITERS = companion.encodeUtf8("\t ,=");
    }

    public static final boolean hasBody(Response response) {
        AbstractC2796i.m5785f(response, "response");
        return promisesBody(response);
    }

    public static final List<Challenge> parseChallenges(Headers headers, String str) {
        AbstractC2796i.m5785f(headers, "<this>");
        AbstractC2796i.m5785f(str, "headerName");
        ArrayList arrayList = new ArrayList();
        int size = headers.size();
        for (int i6 = 0; i6 < size; i6++) {
            if (str.equalsIgnoreCase(headers.name(i6))) {
                try {
                    readChallengeHeader(new Buffer().writeUtf8(headers.value(i6)), arrayList);
                } catch (EOFException e5) {
                    Platform.Companion.get().log("Unable to parse challenge", 5, e5);
                }
            }
        }
        return arrayList;
    }

    public static final boolean promisesBody(Response response) {
        AbstractC2796i.m5785f(response, "<this>");
        if (AbstractC2796i.m5780a(response.request().method(), "HEAD")) {
            return false;
        }
        int iCode = response.code();
        return (((iCode >= 100 && iCode < 200) || iCode == 204 || iCode == 304) && Util.headersContentLength(response) == -1 && !"chunked".equalsIgnoreCase(Response.header$default(response, "Transfer-Encoding", null, 2, null))) ? false : true;
    }

    private static final void readChallengeHeader(Buffer buffer, List<Challenge> list) throws EOFException {
        String token;
        int iSkipAll;
        int i6;
        String token2;
        while (true) {
            String token3 = null;
            while (true) {
                if (token3 == null) {
                    skipCommasAndWhitespace(buffer);
                    token3 = readToken(buffer);
                    if (token3 == null) {
                        return;
                    }
                }
                boolean zSkipCommasAndWhitespace = skipCommasAndWhitespace(buffer);
                token = readToken(buffer);
                if (token == null) {
                    if (buffer.exhausted()) {
                        list.add(new Challenge(token3, C4156s.f14075a));
                        return;
                    }
                    return;
                }
                iSkipAll = Util.skipAll(buffer, (byte) 61);
                boolean zSkipCommasAndWhitespace2 = skipCommasAndWhitespace(buffer);
                i6 = 1;
                if (!zSkipCommasAndWhitespace && (zSkipCommasAndWhitespace2 || buffer.exhausted())) {
                    break;
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                int iSkipAll2 = Util.skipAll(buffer, (byte) 61) + iSkipAll;
                while (true) {
                    if (token == null) {
                        token = readToken(buffer);
                        if (skipCommasAndWhitespace(buffer)) {
                            break;
                        }
                        iSkipAll2 = Util.skipAll(buffer, (byte) 61);
                        if (iSkipAll2 != 0) {
                            break;
                        }
                        if (iSkipAll2 <= 1 || skipCommasAndWhitespace(buffer)) {
                            return;
                        }
                        if (startsWith(buffer, (byte) 34)) {
                            token2 = readQuotedString(buffer);
                        } else {
                            token2 = readToken(buffer);
                        }
                        if (token2 != null || ((String) linkedHashMap.put(token, token2)) != null) {
                            return;
                        }
                        if (skipCommasAndWhitespace(buffer) && !buffer.exhausted()) {
                            return;
                        } else {
                            token = null;
                        }
                    } else {
                        if (iSkipAll2 != 0) {
                            break;
                            break;
                        }
                        if (iSkipAll2 <= 1) {
                            return;
                        }
                        if (startsWith(buffer, (byte) 34)) {
                            token2 = readQuotedString(buffer);
                        } else {
                            token2 = readToken(buffer);
                        }
                        if (token2 != null) {
                            return;
                        }
                        if (skipCommasAndWhitespace(buffer)) {
                        }
                        token = null;
                    }
                }
                list.add(new Challenge(token3, linkedHashMap));
                token3 = token;
            }
            StringBuilder sbM5498l = AbstractC2460q.m5498l(token);
            if (iSkipAll < 0) {
                throw new IllegalArgumentException(("Count 'n' must be non-negative, but was " + iSkipAll + '.').toString());
            }
            String string = "";
            if (iSkipAll != 0) {
                if (iSkipAll != 1) {
                    int length = "=".length();
                    if (length != 0) {
                        if (length != 1) {
                            StringBuilder sb = new StringBuilder("=".length() * iSkipAll);
                            if (1 <= iSkipAll) {
                                while (true) {
                                    sb.append((CharSequence) "=");
                                    if (i6 == iSkipAll) {
                                        break;
                                    } else {
                                        i6++;
                                    }
                                }
                            }
                            string = sb.toString();
                            AbstractC2796i.m5782c(string);
                        } else {
                            char cCharAt = "=".charAt(0);
                            char[] cArr = new char[iSkipAll];
                            for (int i10 = 0; i10 < iSkipAll; i10++) {
                                cArr[i10] = cCharAt;
                            }
                            string = new String(cArr);
                        }
                    }
                } else {
                    string = "=".toString();
                }
            }
            sbM5498l.append(string);
            Map mapSingletonMap = Collections.singletonMap(null, sbM5498l.toString());
            AbstractC2796i.m5784e(mapSingletonMap, "singletonMap<String, Str…ek + \"=\".repeat(eqCount))");
            list.add(new Challenge(token3, (Map<String, String>) mapSingletonMap));
        }
    }

    private static final String readQuotedString(Buffer buffer) throws EOFException {
        if (buffer.readByte() != 34) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        Buffer buffer2 = new Buffer();
        while (true) {
            long jIndexOfElement = buffer.indexOfElement(QUOTED_STRING_DELIMITERS);
            if (jIndexOfElement == -1) {
                return null;
            }
            if (buffer.getByte(jIndexOfElement) == 34) {
                buffer2.write(buffer, jIndexOfElement);
                buffer.readByte();
                return buffer2.readUtf8();
            }
            if (buffer.size() == jIndexOfElement + 1) {
                return null;
            }
            buffer2.write(buffer, jIndexOfElement);
            buffer.readByte();
            buffer2.write(buffer, 1L);
        }
    }

    private static final String readToken(Buffer buffer) {
        long jIndexOfElement = buffer.indexOfElement(TOKEN_DELIMITERS);
        if (jIndexOfElement == -1) {
            jIndexOfElement = buffer.size();
        }
        if (jIndexOfElement != 0) {
            return buffer.readUtf8(jIndexOfElement);
        }
        return null;
    }

    public static final void receiveHeaders(CookieJar cookieJar, HttpUrl httpUrl, Headers headers) {
        AbstractC2796i.m5785f(cookieJar, "<this>");
        AbstractC2796i.m5785f(httpUrl, Progress.URL);
        AbstractC2796i.m5785f(headers, "headers");
        if (cookieJar == CookieJar.NO_COOKIES) {
            return;
        }
        List<Cookie> all = Cookie.Companion.parseAll(httpUrl, headers);
        if (all.isEmpty()) {
            return;
        }
        cookieJar.saveFromResponse(httpUrl, all);
    }

    private static final boolean skipCommasAndWhitespace(Buffer buffer) throws EOFException {
        boolean z7 = false;
        while (!buffer.exhausted()) {
            byte b8 = buffer.getByte(0L);
            if (b8 == 44) {
                buffer.readByte();
                z7 = true;
            } else {
                if (b8 != 32 && b8 != 9) {
                    break;
                }
                buffer.readByte();
            }
        }
        return z7;
    }

    private static final boolean startsWith(Buffer buffer, byte b8) {
        return !buffer.exhausted() && buffer.getByte(0L) == b8;
    }
}
