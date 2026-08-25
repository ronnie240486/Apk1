package androidx.media3.common.util;

import android.text.TextUtils;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.net.UnknownHostException;
import p000a.AbstractC0004e;

@UnstableApi
public final class Log {
    public static final int LOG_LEVEL_ALL = 0;
    public static final int LOG_LEVEL_ERROR = 3;
    public static final int LOG_LEVEL_INFO = 1;
    public static final int LOG_LEVEL_OFF = Integer.MAX_VALUE;
    public static final int LOG_LEVEL_WARNING = 2;
    private static int logLevel = 0;
    private static boolean logStackTraces = true;
    private static final Object lock = new Object();
    private static Logger logger = Logger.DEFAULT;

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface LogLevel {
    }

    public interface Logger {
        public static final Logger DEFAULT = new Logger() {
            @Override
            public void mo1721d(String str, String str2, Throwable th) {
                android.util.Log.d(str, Log.appendThrowableString(str2, th));
            }

            @Override
            public void mo1722e(String str, String str2, Throwable th) {
                android.util.Log.e(str, Log.appendThrowableString(str2, th));
            }

            @Override
            public void mo1723i(String str, String str2, Throwable th) {
                android.util.Log.i(str, Log.appendThrowableString(str2, th));
            }

            @Override
            public void mo1724w(String str, String str2, Throwable th) {
                android.util.Log.w(str, Log.appendThrowableString(str2, th));
            }
        };

        void mo1721d(String str, String str2, Throwable th);

        void mo1722e(String str, String str2, Throwable th);

        void mo1723i(String str, String str2, Throwable th);

        void mo1724w(String str, String str2, Throwable th);
    }

    private Log() {
    }

    public static String appendThrowableString(String str, Throwable th) {
        String throwableString = getThrowableString(th);
        if (TextUtils.isEmpty(throwableString)) {
            return str;
        }
        StringBuilder sbM29w = AbstractC0004e.m29w(str, "\n  ");
        sbM29w.append(throwableString.replace("\n", "\n  "));
        sbM29w.append('\n');
        return sbM29w.toString();
    }

    public static void m1713d(String str, String str2) {
        synchronized (lock) {
            try {
                if (logLevel == 0) {
                    logger.mo1721d(str, str2, null);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void m1715e(String str, String str2) {
        synchronized (lock) {
            try {
                if (logLevel <= 3) {
                    logger.mo1722e(str, str2, null);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static int getLogLevel() {
        int i6;
        synchronized (lock) {
            i6 = logLevel;
        }
        return i6;
    }

    public static String getThrowableString(Throwable th) {
        if (th == null) {
            return null;
        }
        synchronized (lock) {
            try {
                if (isCausedByUnknownHostException(th)) {
                    return "UnknownHostException (no network)";
                }
                if (logStackTraces) {
                    return android.util.Log.getStackTraceString(th).trim().replace("\t", "    ");
                }
                return th.getMessage();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static void m1717i(String str, String str2) {
        synchronized (lock) {
            try {
                if (logLevel <= 1) {
                    logger.mo1723i(str, str2, null);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static boolean isCausedByUnknownHostException(Throwable th) {
        while (th != null) {
            if (th instanceof UnknownHostException) {
                return true;
            }
            th = th.getCause();
        }
        return false;
    }

    public static void setLogLevel(int i6) {
        synchronized (lock) {
            logLevel = i6;
        }
    }

    public static void setLogStackTraces(boolean z7) {
        synchronized (lock) {
            logStackTraces = z7;
        }
    }

    public static void setLogger(Logger logger2) {
        synchronized (lock) {
            logger = logger2;
        }
    }

    public static void m1719w(String str, String str2) {
        synchronized (lock) {
            try {
                if (logLevel <= 2) {
                    logger.mo1724w(str, str2, null);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void m1714d(String str, String str2, Throwable th) {
        synchronized (lock) {
            try {
                if (logLevel == 0) {
                    logger.mo1721d(str, str2, th);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static void m1716e(String str, String str2, Throwable th) {
        synchronized (lock) {
            try {
                if (logLevel <= 3) {
                    logger.mo1722e(str, str2, th);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static void m1718i(String str, String str2, Throwable th) {
        synchronized (lock) {
            try {
                if (logLevel <= 1) {
                    logger.mo1723i(str, str2, th);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static void m1720w(String str, String str2, Throwable th) {
        synchronized (lock) {
            try {
                if (logLevel <= 2) {
                    logger.mo1724w(str, str2, th);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
