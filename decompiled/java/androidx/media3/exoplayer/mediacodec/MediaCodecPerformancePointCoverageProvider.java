package androidx.media3.exoplayer.mediacodec;

import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Util;
import java.util.List;
import p001a0.AbstractC0018a;

final class MediaCodecPerformancePointCoverageProvider {
    static final int COVERAGE_RESULT_NO = 1;
    static final int COVERAGE_RESULT_NO_PERFORMANCE_POINTS_UNSUPPORTED = 0;
    static final int COVERAGE_RESULT_YES = 2;
    private static Boolean shouldIgnorePerformancePoints;

    public static final class Api29 {
        private Api29() {
        }

        public static int areResolutionAndFrameRateCovered(android.media.MediaCodecInfo.VideoCapabilities videoCapabilities, int i6, int i10, double d) {
            List supportedPerformancePoints = videoCapabilities.getSupportedPerformancePoints();
            if (supportedPerformancePoints == null || supportedPerformancePoints.isEmpty()) {
                return 0;
            }
            AbstractC0018a.m65i();
            int iEvaluatePerformancePointCoverage = evaluatePerformancePointCoverage(supportedPerformancePoints, AbstractC0018a.m58b(i6, i10, (int) d));
            if (iEvaluatePerformancePointCoverage == 1 && MediaCodecPerformancePointCoverageProvider.shouldIgnorePerformancePoints == null) {
                Boolean unused = MediaCodecPerformancePointCoverageProvider.shouldIgnorePerformancePoints = Boolean.valueOf(shouldIgnorePerformancePoints());
                if (MediaCodecPerformancePointCoverageProvider.shouldIgnorePerformancePoints.booleanValue()) {
                    return 0;
                }
            }
            return iEvaluatePerformancePointCoverage;
        }

        private static int evaluateH264RequiredSupport(boolean z7) {
            List supportedPerformancePoints;
            try {
                Format formatBuild = new Format.Builder().setSampleMimeType(MimeTypes.VIDEO_H264).build();
                if (formatBuild.sampleMimeType != null) {
                    List<MediaCodecInfo> decoderInfosSoftMatch = MediaCodecUtil.getDecoderInfosSoftMatch(MediaCodecSelector.DEFAULT, formatBuild, z7, false);
                    for (int i6 = 0; i6 < decoderInfosSoftMatch.size(); i6++) {
                        if (decoderInfosSoftMatch.get(i6).capabilities != null && decoderInfosSoftMatch.get(i6).capabilities.getVideoCapabilities() != null && (supportedPerformancePoints = decoderInfosSoftMatch.get(i6).capabilities.getVideoCapabilities().getSupportedPerformancePoints()) != null && !supportedPerformancePoints.isEmpty()) {
                            AbstractC0018a.m65i();
                            return evaluatePerformancePointCoverage(supportedPerformancePoints, AbstractC0819i.m2366f());
                        }
                    }
                }
            } catch (MediaCodecUtil.DecoderQueryException unused) {
            }
            return 0;
        }

        private static int evaluatePerformancePointCoverage(List<android.media.MediaCodecInfo.VideoCapabilities.PerformancePoint> list, android.media.MediaCodecInfo.VideoCapabilities.PerformancePoint performancePoint) {
            for (int i6 = 0; i6 < list.size(); i6++) {
                if (AbstractC0018a.m59c(list.get(i6)).covers(performancePoint)) {
                    return 2;
                }
            }
            return 1;
        }

        private static boolean shouldIgnorePerformancePoints() {
            if (Util.SDK_INT >= 35) {
                return false;
            }
            int iEvaluateH264RequiredSupport = evaluateH264RequiredSupport(false);
            int iEvaluateH264RequiredSupport2 = evaluateH264RequiredSupport(true);
            if (iEvaluateH264RequiredSupport == 0) {
                return true;
            }
            if (iEvaluateH264RequiredSupport2 == 0) {
                return iEvaluateH264RequiredSupport != 2;
            }
            return (iEvaluateH264RequiredSupport == 2 && iEvaluateH264RequiredSupport2 == 2) ? false : true;
        }
    }

    private MediaCodecPerformancePointCoverageProvider() {
    }

    public static int areResolutionAndFrameRateCovered(android.media.MediaCodecInfo.VideoCapabilities videoCapabilities, int i6, int i10, double d) {
        if (Util.SDK_INT < 29) {
            return 0;
        }
        Boolean bool = shouldIgnorePerformancePoints;
        if (bool == null || !bool.booleanValue()) {
            return Api29.areResolutionAndFrameRateCovered(videoCapabilities, i6, i10, d);
        }
        return 0;
    }
}
