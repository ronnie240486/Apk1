package androidx.media3.exoplayer.offline;

public abstract class AbstractC0838a {
    public static boolean m2400a(DownloadCursor downloadCursor) {
        return downloadCursor.getCount() == 0 || downloadCursor.getPosition() == downloadCursor.getCount();
    }

    public static boolean m2401b(DownloadCursor downloadCursor) {
        return downloadCursor.getCount() == 0 || downloadCursor.getPosition() == -1;
    }

    public static boolean m2402c(DownloadCursor downloadCursor) {
        return downloadCursor.getPosition() == 0 && downloadCursor.getCount() != 0;
    }

    public static boolean m2403d(DownloadCursor downloadCursor) {
        int count = downloadCursor.getCount();
        return downloadCursor.getPosition() == count + (-1) && count != 0;
    }

    public static boolean m2404e(DownloadCursor downloadCursor) {
        return downloadCursor.moveToPosition(0);
    }

    public static boolean m2405f(DownloadCursor downloadCursor) {
        return downloadCursor.moveToPosition(downloadCursor.getCount() - 1);
    }

    public static boolean m2406g(DownloadCursor downloadCursor) {
        return downloadCursor.moveToPosition(downloadCursor.getPosition() + 1);
    }

    public static boolean m2407h(DownloadCursor downloadCursor) {
        return downloadCursor.moveToPosition(downloadCursor.getPosition() - 1);
    }
}
