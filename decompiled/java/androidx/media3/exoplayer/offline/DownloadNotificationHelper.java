package androidx.media3.exoplayer.offline;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import androidx.core.app.C0354t;
import androidx.core.app.C0356u;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.C0677R;
import java.util.List;

@UnstableApi
public final class DownloadNotificationHelper {
    private static final int NULL_STRING_ID = 0;
    private final C0356u notificationBuilder;

    public static final class Api31 {
        private Api31() {
        }

        @SuppressLint({"WrongConstant"})
        public static void setForegroundServiceBehavior(C0356u c0356u) {
            c0356u.f1577z = 1;
        }
    }

    public DownloadNotificationHelper(Context context, String str) {
        this.notificationBuilder = new C0356u(context.getApplicationContext(), str);
    }

    private Notification buildEndStateNotification(Context context, int i6, PendingIntent pendingIntent, String str, int i10) {
        return buildNotification(context, i6, pendingIntent, str, i10, 0, 0, false, false, true);
    }

    private Notification buildNotification(Context context, int i6, PendingIntent pendingIntent, String str, int i10, int i11, int i12, boolean z7, boolean z10, boolean z11) {
        C0356u c0356u = this.notificationBuilder;
        c0356u.f1550B.icon = i6;
        C0354t c0354t = null;
        c0356u.f1556e = C0356u.m1024b(i10 == 0 ? null : context.getResources().getString(i10));
        C0356u c0356u2 = this.notificationBuilder;
        c0356u2.f1558g = pendingIntent;
        if (str != null) {
            c0354t = new C0354t(0);
            c0354t.f1544b = C0356u.m1024b(str);
        }
        c0356u2.m1028e(c0354t);
        C0356u c0356u3 = this.notificationBuilder;
        c0356u3.f1565n = i11;
        c0356u3.f1566o = i12;
        c0356u3.f1567p = z7;
        c0356u3.m1026c(2, z10);
        C0356u c0356u4 = this.notificationBuilder;
        c0356u4.f1561j = z11;
        if (Util.SDK_INT >= 31) {
            Api31.setForegroundServiceBehavior(c0356u4);
        }
        return this.notificationBuilder.m1025a();
    }

    public Notification buildDownloadCompletedNotification(Context context, int i6, PendingIntent pendingIntent, String str) {
        return buildEndStateNotification(context, i6, pendingIntent, str, C0677R.string.exo_download_completed);
    }

    public Notification buildDownloadFailedNotification(Context context, int i6, PendingIntent pendingIntent, String str) {
        return buildEndStateNotification(context, i6, pendingIntent, str, C0677R.string.exo_download_failed);
    }

    public Notification buildProgressNotification(Context context, int i6, PendingIntent pendingIntent, String str, List<Download> list, int i10) {
        boolean z7;
        int i11;
        int i12;
        int i13;
        int i14;
        boolean z10;
        float percentDownloaded;
        boolean z11;
        float f = 0.0f;
        boolean z12 = false;
        boolean z13 = false;
        boolean z14 = false;
        boolean z15 = false;
        boolean z16 = false;
        int i15 = 0;
        boolean z17 = true;
        for (int i16 = 0; i16 < list.size(); i16++) {
            Download download = list.get(i16);
            int i17 = download.state;
            if (i17 == 0) {
                z14 = true;
            } else if (i17 == 2) {
                percentDownloaded = download.getPercentDownloaded();
                if (percentDownloaded != -1.0f) {
                    f += percentDownloaded;
                    z17 = false;
                }
                if (download.getBytesDownloaded() > 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                z15 |= z11;
                i15++;
                z13 = true;
            } else if (i17 == 5) {
                z16 = true;
            } else if (i17 == 7) {
                percentDownloaded = download.getPercentDownloaded();
                if (percentDownloaded != -1.0f) {
                    f += percentDownloaded;
                    z17 = false;
                }
                if (download.getBytesDownloaded() > 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                z15 |= z11;
                i15++;
                z13 = true;
            }
        }
        if (!z13) {
            if (z14 && i10 != 0) {
                i11 = (i10 & 2) != 0 ? C0677R.string.exo_download_paused_for_wifi : (i10 & 1) != 0 ? C0677R.string.exo_download_paused_for_network : C0677R.string.exo_download_paused;
                z7 = false;
            } else if (z16) {
                i12 = C0677R.string.exo_download_removing;
            } else {
                z7 = true;
                i11 = 0;
            }
            if (z7) {
                i13 = 0;
                i14 = 0;
                z10 = false;
            } else if (z13) {
                int i18 = (int) (f / i15);
                if (z17 && z15) {
                    z12 = true;
                }
                i14 = i18;
                z10 = z12;
                i13 = 100;
            } else {
                i13 = 100;
                i14 = 0;
                z10 = true;
            }
            return buildNotification(context, i6, pendingIntent, str, i11, i13, i14, z10, true, false);
        }
        i12 = C0677R.string.exo_download_downloading;
        i11 = i12;
        z7 = true;
        if (z7) {
            i13 = 0;
            i14 = 0;
            z10 = false;
        } else if (z13) {
            int i19 = (int) (f / i15);
            if (z17) {
                z12 = true;
            }
            i14 = i19;
            z10 = z12;
            i13 = 100;
        } else {
            i13 = 100;
            i14 = 0;
            z10 = true;
        }
        return buildNotification(context, i6, pendingIntent, str, i11, i13, i14, z10, true, false);
    }
}
