package p187r4;

import android.os.Bundle;
import android.text.format.DateUtils;
import androidx.media3.exoplayer.Renderer;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaLiveSeekableRange;
import com.google.android.gms.cast.MediaMetadata;
import com.google.android.gms.cast.MediaQueueItem;
import com.google.android.gms.cast.MediaStatus;
import java.text.DateFormat;
import java.util.Date;
import java.util.regex.Pattern;
import p018b5.AbstractC1312l;
import p230v4.AbstractC3987a;
import p230v4.C3998l;

public final class C3626p {

    public C3616f f12186a;

    public static final String m7346m(long j10) {
        return j10 >= 0 ? DateUtils.formatElapsedTime(j10 / 1000) : "-".concat(String.valueOf(DateUtils.formatElapsedTime((-j10) / 1000)));
    }

    public int m7347a() {
        C3616f c3616f = this.f12186a;
        if (c3616f != null && c3616f.m7305i()) {
            C3616f c3616f2 = this.f12186a;
            if (c3616f2.m7307k() || !c3616f2.m7308l()) {
                int iM7299c = (int) (c3616f2.m7299c() - m7351e());
                if (c3616f2.m7294D()) {
                    int iM7350d = m7350d();
                    int iM7349c = m7349c();
                    Pattern pattern = AbstractC3987a.f13519a;
                    iM7299c = Math.min(Math.max(iM7299c, iM7350d), iM7349c);
                }
                int iM7348b = m7348b();
                Pattern pattern2 = AbstractC3987a.f13519a;
                return Math.min(Math.max(iM7299c, 0), iM7348b);
            }
        }
        return 0;
    }

    public int m7348b() {
        MediaInfo mediaInfo;
        C3616f c3616f = this.f12186a;
        long jLongValue = 1;
        if (c3616f != null && c3616f.m7305i()) {
            C3616f c3616f2 = this.f12186a;
            if (c3616f2.m7307k()) {
                Long lM7354h = m7354h();
                if (lM7354h != null) {
                    jLongValue = lM7354h.longValue();
                } else {
                    Long lM7352f = m7352f();
                    jLongValue = lM7352f != null ? lM7352f.longValue() : Math.max(c3616f2.m7299c(), 1L);
                }
            } else if (c3616f2.m7308l()) {
                MediaQueueItem mediaQueueItemM7300d = c3616f2.m7300d();
                if (mediaQueueItemM7300d != null && (mediaInfo = mediaQueueItemM7300d.f4695a) != null) {
                    jLongValue = Math.max(mediaInfo.f4642e, 1L);
                }
            } else {
                jLongValue = Math.max(c3616f2.m7304h(), 1L);
            }
        }
        return Math.max((int) (jLongValue - m7351e()), 1);
    }

    public int m7349c() {
        C3616f c3616f = this.f12186a;
        if (c3616f == null || !c3616f.m7305i() || !this.f12186a.m7307k()) {
            return m7348b();
        }
        if (!this.f12186a.m7294D()) {
            return 0;
        }
        Long lM7352f = m7352f();
        AbstractC1312l.m3198e(lM7352f);
        long jLongValue = lM7352f.longValue() - m7351e();
        int iM7348b = m7348b();
        Pattern pattern = AbstractC3987a.f13519a;
        return Math.min(Math.max((int) jLongValue, 0), iM7348b);
    }

    public int m7350d() {
        C3616f c3616f = this.f12186a;
        if (c3616f == null || !c3616f.m7305i() || !this.f12186a.m7307k() || !this.f12186a.m7294D()) {
            return 0;
        }
        Long lM7353g = m7353g();
        AbstractC1312l.m3198e(lM7353g);
        long jLongValue = lM7353g.longValue() - m7351e();
        int iM7348b = m7348b();
        Pattern pattern = AbstractC3987a.f13519a;
        return Math.min(Math.max((int) jLongValue, 0), iM7348b);
    }

    public long m7351e() {
        C3616f c3616f = this.f12186a;
        if (c3616f == null || !c3616f.m7305i() || !this.f12186a.m7307k()) {
            return 0L;
        }
        C3616f c3616f2 = this.f12186a;
        Long lM7355i = m7355i();
        if (lM7355i != null) {
            return lM7355i.longValue();
        }
        Long lM7353g = m7353g();
        return lM7353g != null ? lM7353g.longValue() : c3616f2.m7299c();
    }

    public Long m7352f() {
        C3616f c3616f;
        MediaStatus mediaStatusM7302f;
        long jM7982e;
        MediaLiveSeekableRange mediaLiveSeekableRange;
        C3616f c3616f2 = this.f12186a;
        if (c3616f2 == null || !c3616f2.m7305i() || !this.f12186a.m7307k() || !this.f12186a.m7294D() || (mediaStatusM7302f = (c3616f = this.f12186a).m7302f()) == null || mediaStatusM7302f.f4724u == null) {
            return null;
        }
        synchronized (c3616f.f12148a) {
            AbstractC1312l.m3195b("Must be called from the main thread.");
            C3998l c3998l = c3616f.f12150c;
            MediaStatus mediaStatus = c3998l.f13531f;
            jM7982e = 0;
            if (mediaStatus != null && (mediaLiveSeekableRange = mediaStatus.f4724u) != null) {
                jM7982e = mediaLiveSeekableRange.f4658b;
                if (!mediaLiveSeekableRange.f4660d) {
                    jM7982e = c3998l.m7982e(jM7982e, 1.0d, -1L);
                }
            }
        }
        return Long.valueOf(jM7982e);
    }

    public Long m7353g() {
        C3616f c3616f;
        MediaStatus mediaStatusM7302f;
        long jMin;
        MediaLiveSeekableRange mediaLiveSeekableRange;
        C3616f c3616f2 = this.f12186a;
        if (c3616f2 == null || !c3616f2.m7305i() || !this.f12186a.m7307k() || !this.f12186a.m7294D() || (mediaStatusM7302f = (c3616f = this.f12186a).m7302f()) == null || mediaStatusM7302f.f4724u == null) {
            return null;
        }
        synchronized (c3616f.f12148a) {
            AbstractC1312l.m3195b("Must be called from the main thread.");
            C3998l c3998l = c3616f.f12150c;
            MediaStatus mediaStatus = c3998l.f13531f;
            jMin = 0;
            if (mediaStatus != null && (mediaLiveSeekableRange = mediaStatus.f4724u) != null) {
                jMin = mediaLiveSeekableRange.f4657a;
                if (mediaLiveSeekableRange.f4659c) {
                    jMin = c3998l.m7982e(jMin, 1.0d, -1L);
                }
                if (mediaLiveSeekableRange.f4660d) {
                    jMin = Math.min(jMin, mediaLiveSeekableRange.f4658b);
                }
            }
        }
        return Long.valueOf(jMin);
    }

    public Long m7354h() {
        Long lM7355i;
        MediaInfo mediaInfoM7301e;
        C3616f c3616f = this.f12186a;
        if (c3616f != null && c3616f.m7305i() && this.f12186a.m7307k()) {
            C3616f c3616f2 = this.f12186a;
            MediaMetadata mediaMetadata = (c3616f2 == null || !c3616f2.m7305i() || (mediaInfoM7301e = this.f12186a.m7301e()) == null) ? null : mediaInfoM7301e.f4641d;
            if (mediaMetadata != null) {
                Bundle bundle = mediaMetadata.f4678b;
                if (bundle.containsKey("com.google.android.gms.cast.metadata.SECTION_DURATION") && (lM7355i = m7355i()) != null) {
                    long jLongValue = lM7355i.longValue();
                    MediaMetadata.m3593j(5, "com.google.android.gms.cast.metadata.SECTION_DURATION");
                    return Long.valueOf(bundle.getLong("com.google.android.gms.cast.metadata.SECTION_DURATION") + jLongValue);
                }
            }
        }
        return null;
    }

    public Long m7355i() {
        MediaInfo mediaInfoM7301e;
        C3616f c3616f = this.f12186a;
        if (c3616f != null && c3616f.m7305i() && this.f12186a.m7307k()) {
            C3616f c3616f2 = this.f12186a;
            MediaInfo mediaInfoM7301e2 = c3616f2.m7301e();
            C3616f c3616f3 = this.f12186a;
            MediaMetadata mediaMetadata = (c3616f3 == null || !c3616f3.m7305i() || (mediaInfoM7301e = this.f12186a.m7301e()) == null) ? null : mediaInfoM7301e.f4641d;
            if (mediaInfoM7301e2 != null && mediaMetadata != null) {
                Bundle bundle = mediaMetadata.f4678b;
                if (bundle.containsKey("com.google.android.gms.cast.metadata.SECTION_START_TIME_IN_MEDIA") && (bundle.containsKey("com.google.android.gms.cast.metadata.SECTION_DURATION") || c3616f2.m7294D())) {
                    MediaMetadata.m3593j(5, "com.google.android.gms.cast.metadata.SECTION_START_TIME_IN_MEDIA");
                    return Long.valueOf(bundle.getLong("com.google.android.gms.cast.metadata.SECTION_START_TIME_IN_MEDIA"));
                }
            }
        }
        return null;
    }

    public Long m7356j() {
        MediaInfo mediaInfoM7301e;
        C3616f c3616f = this.f12186a;
        if (c3616f == null || !c3616f.m7305i() || !this.f12186a.m7307k() || (mediaInfoM7301e = this.f12186a.m7301e()) == null) {
            return null;
        }
        long j10 = mediaInfoM7301e.f4650m;
        if (j10 != -1) {
            return Long.valueOf(j10);
        }
        return null;
    }

    public String m7357k(long j10) {
        C3616f c3616f = this.f12186a;
        if (c3616f == null || !c3616f.m7305i()) {
            return null;
        }
        C3616f c3616f2 = this.f12186a;
        int i6 = 1;
        if (c3616f2 != null && c3616f2.m7305i() && this.f12186a.m7307k() && m7356j() != null) {
            i6 = 2;
        }
        if (i6 - 1 == 0) {
            return (c3616f2.m7307k() && m7355i() == null) ? m7346m(j10) : m7346m(j10 - m7351e());
        }
        Long lM7356j = m7356j();
        AbstractC1312l.m3198e(lM7356j);
        return DateFormat.getTimeInstance().format(new Date(lM7356j.longValue() + j10));
    }

    public boolean m7358l(long j10) {
        C3616f c3616f = this.f12186a;
        if (c3616f != null && c3616f.m7305i() && this.f12186a.m7294D()) {
            return (m7351e() + ((long) m7349c())) - j10 < Renderer.DEFAULT_DURATION_TO_PROGRESS_US;
        }
        return false;
    }
}
