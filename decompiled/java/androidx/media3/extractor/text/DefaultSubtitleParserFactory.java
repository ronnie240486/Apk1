package androidx.media3.extractor.text;

import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.extractor.text.dvb.DvbParser;
import androidx.media3.extractor.text.pgs.PgsParser;
import androidx.media3.extractor.text.ssa.SsaParser;
import androidx.media3.extractor.text.subrip.SubripParser;
import androidx.media3.extractor.text.ttml.TtmlParser;
import androidx.media3.extractor.text.tx3g.Tx3gParser;
import androidx.media3.extractor.text.vobsub.VobsubParser;
import androidx.media3.extractor.text.webvtt.Mp4WebvttParser;
import androidx.media3.extractor.text.webvtt.WebvttParser;
import java.util.Objects;
import p055ea.AbstractC2460q;

@UnstableApi
public final class DefaultSubtitleParserFactory implements SubtitleParser.Factory {
    @Override
    public SubtitleParser create(Format format) {
        String str = format.sampleMimeType;
        if (str != null) {
            switch (str) {
                case "application/dvbsubs":
                    return new DvbParser(format.initializationData);
                case "application/pgs":
                    return new PgsParser();
                case "application/x-mp4-vtt":
                    return new Mp4WebvttParser();
                case "text/vtt":
                    return new WebvttParser();
                case "application/x-quicktime-tx3g":
                    return new Tx3gParser(format.initializationData);
                case "text/x-ssa":
                    return new SsaParser(format.initializationData);
                case "application/vobsub":
                    return new VobsubParser(format.initializationData);
                case "application/x-subrip":
                    return new SubripParser();
                case "application/ttml+xml":
                    return new TtmlParser();
            }
        }
        throw new IllegalArgumentException(AbstractC2460q.m5501o("Unsupported MIME type: ", str));
    }

    @Override
    public int getCueReplacementBehavior(Format format) {
        String str = format.sampleMimeType;
        if (str != null) {
            switch (str) {
                case "application/dvbsubs":
                case "application/pgs":
                case "application/x-mp4-vtt":
                    return 2;
                case "text/vtt":
                    return 1;
                case "application/x-quicktime-tx3g":
                    return 2;
                case "text/x-ssa":
                    return 1;
                case "application/vobsub":
                    return 2;
                case "application/x-subrip":
                case "application/ttml+xml":
                    return 1;
            }
        }
        throw new IllegalArgumentException(AbstractC2460q.m5501o("Unsupported MIME type: ", str));
    }

    @Override
    public boolean supportsFormat(Format format) {
        String str = format.sampleMimeType;
        return Objects.equals(str, MimeTypes.TEXT_SSA) || Objects.equals(str, MimeTypes.TEXT_VTT) || Objects.equals(str, MimeTypes.APPLICATION_MP4VTT) || Objects.equals(str, MimeTypes.APPLICATION_SUBRIP) || Objects.equals(str, MimeTypes.APPLICATION_TX3G) || Objects.equals(str, MimeTypes.APPLICATION_PGS) || Objects.equals(str, MimeTypes.APPLICATION_VOBSUB) || Objects.equals(str, MimeTypes.APPLICATION_DVBSUBS) || Objects.equals(str, MimeTypes.APPLICATION_TTML);
    }
}
