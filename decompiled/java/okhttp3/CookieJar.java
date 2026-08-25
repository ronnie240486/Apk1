package okhttp3;

import com.lzy.okgo.model.Progress;
import java.util.List;
import p103j9.AbstractC2796i;
import p253x8.C4155r;

public interface CookieJar {
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final CookieJar NO_COOKIES = new Companion.NoCookies();

    public static final class Companion {
        static final Companion $$INSTANCE = new Companion();

        public static final class NoCookies implements CookieJar {
            @Override
            public List<Cookie> loadForRequest(HttpUrl httpUrl) {
                AbstractC2796i.m5785f(httpUrl, Progress.URL);
                return C4155r.f14074a;
            }

            @Override
            public void saveFromResponse(HttpUrl httpUrl, List<Cookie> list) {
                AbstractC2796i.m5785f(httpUrl, Progress.URL);
                AbstractC2796i.m5785f(list, "cookies");
            }
        }

        private Companion() {
        }
    }

    List<Cookie> loadForRequest(HttpUrl httpUrl);

    void saveFromResponse(HttpUrl httpUrl, List<Cookie> list);
}
