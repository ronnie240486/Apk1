package androidx.media3.common;

import android.os.Bundle;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.media3.common.util.Clock;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Objects;

public class PlaybackException extends Exception {
    public static final int CUSTOM_ERROR_CODE_BASE = 1000000;
    public static final int ERROR_CODE_AUDIO_TRACK_INIT_FAILED = 5001;
    public static final int ERROR_CODE_AUDIO_TRACK_OFFLOAD_INIT_FAILED = 5004;
    public static final int ERROR_CODE_AUDIO_TRACK_OFFLOAD_WRITE_FAILED = 5003;
    public static final int ERROR_CODE_AUDIO_TRACK_WRITE_FAILED = 5002;
    public static final int ERROR_CODE_AUTHENTICATION_EXPIRED = -102;
    public static final int ERROR_CODE_BAD_VALUE = -3;
    public static final int ERROR_CODE_BEHIND_LIVE_WINDOW = 1002;
    public static final int ERROR_CODE_CONCURRENT_STREAM_LIMIT = -104;
    public static final int ERROR_CODE_CONTENT_ALREADY_PLAYING = -110;
    public static final int ERROR_CODE_DECODER_INIT_FAILED = 4001;
    public static final int ERROR_CODE_DECODER_QUERY_FAILED = 4002;
    public static final int ERROR_CODE_DECODING_FAILED = 4003;
    public static final int ERROR_CODE_DECODING_FORMAT_EXCEEDS_CAPABILITIES = 4004;
    public static final int ERROR_CODE_DECODING_FORMAT_UNSUPPORTED = 4005;
    public static final int ERROR_CODE_DECODING_RESOURCES_RECLAIMED = 4006;
    public static final int ERROR_CODE_DISCONNECTED = -100;
    public static final int ERROR_CODE_DRM_CONTENT_ERROR = 6003;
    public static final int ERROR_CODE_DRM_DEVICE_REVOKED = 6007;
    public static final int ERROR_CODE_DRM_DISALLOWED_OPERATION = 6005;
    public static final int ERROR_CODE_DRM_LICENSE_ACQUISITION_FAILED = 6004;
    public static final int ERROR_CODE_DRM_LICENSE_EXPIRED = 6008;
    public static final int ERROR_CODE_DRM_PROVISIONING_FAILED = 6002;
    public static final int ERROR_CODE_DRM_SCHEME_UNSUPPORTED = 6001;
    public static final int ERROR_CODE_DRM_SYSTEM_ERROR = 6006;
    public static final int ERROR_CODE_DRM_UNSPECIFIED = 6000;
    public static final int ERROR_CODE_END_OF_PLAYLIST = -109;
    public static final int ERROR_CODE_FAILED_RUNTIME_CHECK = 1004;
    public static final int ERROR_CODE_INVALID_STATE = -2;
    public static final int ERROR_CODE_IO_BAD_HTTP_STATUS = 2004;
    public static final int ERROR_CODE_IO_CLEARTEXT_NOT_PERMITTED = 2007;
    public static final int ERROR_CODE_IO_FILE_NOT_FOUND = 2005;
    public static final int ERROR_CODE_IO_INVALID_HTTP_CONTENT_TYPE = 2003;
    public static final int ERROR_CODE_IO_NETWORK_CONNECTION_FAILED = 2001;
    public static final int ERROR_CODE_IO_NETWORK_CONNECTION_TIMEOUT = 2002;
    public static final int ERROR_CODE_IO_NO_PERMISSION = 2006;
    public static final int ERROR_CODE_IO_READ_POSITION_OUT_OF_RANGE = 2008;
    public static final int ERROR_CODE_IO_UNSPECIFIED = 2000;
    public static final int ERROR_CODE_NOT_AVAILABLE_IN_REGION = -106;
    public static final int ERROR_CODE_NOT_SUPPORTED = -6;
    public static final int ERROR_CODE_PARENTAL_CONTROL_RESTRICTED = -105;
    public static final int ERROR_CODE_PARSING_CONTAINER_MALFORMED = 3001;
    public static final int ERROR_CODE_PARSING_CONTAINER_UNSUPPORTED = 3003;
    public static final int ERROR_CODE_PARSING_MANIFEST_MALFORMED = 3002;
    public static final int ERROR_CODE_PARSING_MANIFEST_UNSUPPORTED = 3004;
    public static final int ERROR_CODE_PERMISSION_DENIED = -4;
    public static final int ERROR_CODE_PREMIUM_ACCOUNT_REQUIRED = -103;
    public static final int ERROR_CODE_REMOTE_ERROR = 1001;
    public static final int ERROR_CODE_SETUP_REQUIRED = -108;
    public static final int ERROR_CODE_SKIP_LIMIT_REACHED = -107;
    public static final int ERROR_CODE_TIMEOUT = 1003;
    public static final int ERROR_CODE_UNSPECIFIED = 1000;

    @UnstableApi
    public static final int ERROR_CODE_VIDEO_FRAME_PROCESSING_FAILED = 7001;

    @UnstableApi
    public static final int ERROR_CODE_VIDEO_FRAME_PROCESSOR_INIT_FAILED = 7000;

    @UnstableApi
    protected static final int FIELD_CUSTOM_ID_BASE = 1000;
    public final int errorCode;

    @UnstableApi
    public final Bundle extras;
    public final long timestampMs;
    private static final String FIELD_INT_ERROR_CODE = Util.intToStringMaxRadix(0);
    private static final String FIELD_LONG_TIMESTAMP_MS = Util.intToStringMaxRadix(1);
    private static final String FIELD_STRING_MESSAGE = Util.intToStringMaxRadix(2);
    private static final String FIELD_STRING_CAUSE_CLASS_NAME = Util.intToStringMaxRadix(3);
    private static final String FIELD_STRING_CAUSE_MESSAGE = Util.intToStringMaxRadix(4);
    private static final String FIELD_BUNDLE_EXTRAS = Util.intToStringMaxRadix(5);

    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface ErrorCode {
    }

    @UnstableApi
    public PlaybackException(String str, Throwable th, int i6) {
        this(str, th, i6, Bundle.EMPTY, Clock.DEFAULT.elapsedRealtime());
    }

    private static RemoteException createRemoteException(String str) {
        return new RemoteException(str);
    }

    private static Throwable createThrowable(Class<?> cls, String str) throws Exception {
        return (Throwable) cls.getConstructor(String.class).newInstance(str);
    }

    @UnstableApi
    public static PlaybackException fromBundle(Bundle bundle) {
        return new PlaybackException(bundle);
    }

    private static Throwable getCauseFromBundle(Bundle bundle) {
        String string = bundle.getString(FIELD_STRING_CAUSE_CLASS_NAME);
        String string2 = bundle.getString(FIELD_STRING_CAUSE_MESSAGE);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            Class<?> cls = Class.forName(string, true, PlaybackException.class.getClassLoader());
            Throwable thCreateThrowable = Throwable.class.isAssignableFrom(cls) ? createThrowable(cls, string2) : null;
            if (thCreateThrowable != null) {
                return thCreateThrowable;
            }
        } catch (Throwable unused) {
        }
        return createRemoteException(string2);
    }

    public static String getErrorCodeName(int i6) {
        if (i6 == -100) {
            return "ERROR_CODE_DISCONNECTED";
        }
        if (i6 == -6) {
            return "ERROR_CODE_NOT_SUPPORTED";
        }
        if (i6 == -4) {
            return "ERROR_CODE_PERMISSION_DENIED";
        }
        if (i6 == -3) {
            return "ERROR_CODE_BAD_VALUE";
        }
        if (i6 == -2) {
            return "ERROR_CODE_INVALID_STATE";
        }
        if (i6 == 7000) {
            return "ERROR_CODE_VIDEO_FRAME_PROCESSOR_INIT_FAILED";
        }
        if (i6 == 7001) {
            return "ERROR_CODE_VIDEO_FRAME_PROCESSING_FAILED";
        }
        switch (i6) {
            case ERROR_CODE_CONTENT_ALREADY_PLAYING:
                return "ERROR_CODE_CONTENT_ALREADY_PLAYING";
            case ERROR_CODE_END_OF_PLAYLIST:
                return "ERROR_CODE_END_OF_PLAYLIST";
            case ERROR_CODE_SETUP_REQUIRED:
                return "ERROR_CODE_SETUP_REQUIRED";
            case ERROR_CODE_SKIP_LIMIT_REACHED:
                return "ERROR_CODE_SKIP_LIMIT_REACHED";
            case ERROR_CODE_NOT_AVAILABLE_IN_REGION:
                return "ERROR_CODE_NOT_AVAILABLE_IN_REGION";
            case ERROR_CODE_PARENTAL_CONTROL_RESTRICTED:
                return "ERROR_CODE_PARENTAL_CONTROL_RESTRICTED";
            case ERROR_CODE_CONCURRENT_STREAM_LIMIT:
                return "ERROR_CODE_CONCURRENT_STREAM_LIMIT";
            case ERROR_CODE_PREMIUM_ACCOUNT_REQUIRED:
                return "ERROR_CODE_PREMIUM_ACCOUNT_REQUIRED";
            case ERROR_CODE_AUTHENTICATION_EXPIRED:
                return "ERROR_CODE_AUTHENTICATION_EXPIRED";
            default:
                switch (i6) {
                    case 1000:
                        return "ERROR_CODE_UNSPECIFIED";
                    case 1001:
                        return "ERROR_CODE_REMOTE_ERROR";
                    case 1002:
                        return "ERROR_CODE_BEHIND_LIVE_WINDOW";
                    case 1003:
                        return "ERROR_CODE_TIMEOUT";
                    case 1004:
                        return "ERROR_CODE_FAILED_RUNTIME_CHECK";
                    default:
                        switch (i6) {
                            case 2000:
                                return "ERROR_CODE_IO_UNSPECIFIED";
                            case ERROR_CODE_IO_NETWORK_CONNECTION_FAILED:
                                return "ERROR_CODE_IO_NETWORK_CONNECTION_FAILED";
                            case ERROR_CODE_IO_NETWORK_CONNECTION_TIMEOUT:
                                return "ERROR_CODE_IO_NETWORK_CONNECTION_TIMEOUT";
                            case ERROR_CODE_IO_INVALID_HTTP_CONTENT_TYPE:
                                return "ERROR_CODE_IO_INVALID_HTTP_CONTENT_TYPE";
                            case ERROR_CODE_IO_BAD_HTTP_STATUS:
                                return "ERROR_CODE_IO_BAD_HTTP_STATUS";
                            case ERROR_CODE_IO_FILE_NOT_FOUND:
                                return "ERROR_CODE_IO_FILE_NOT_FOUND";
                            case ERROR_CODE_IO_NO_PERMISSION:
                                return "ERROR_CODE_IO_NO_PERMISSION";
                            case ERROR_CODE_IO_CLEARTEXT_NOT_PERMITTED:
                                return "ERROR_CODE_IO_CLEARTEXT_NOT_PERMITTED";
                            case 2008:
                                return "ERROR_CODE_IO_READ_POSITION_OUT_OF_RANGE";
                            default:
                                switch (i6) {
                                    case ERROR_CODE_PARSING_CONTAINER_MALFORMED:
                                        return "ERROR_CODE_PARSING_CONTAINER_MALFORMED";
                                    case ERROR_CODE_PARSING_MANIFEST_MALFORMED:
                                        return "ERROR_CODE_PARSING_MANIFEST_MALFORMED";
                                    case ERROR_CODE_PARSING_CONTAINER_UNSUPPORTED:
                                        return "ERROR_CODE_PARSING_CONTAINER_UNSUPPORTED";
                                    case ERROR_CODE_PARSING_MANIFEST_UNSUPPORTED:
                                        return "ERROR_CODE_PARSING_MANIFEST_UNSUPPORTED";
                                    default:
                                        switch (i6) {
                                            case ERROR_CODE_DECODER_INIT_FAILED:
                                                return "ERROR_CODE_DECODER_INIT_FAILED";
                                            case ERROR_CODE_DECODER_QUERY_FAILED:
                                                return "ERROR_CODE_DECODER_QUERY_FAILED";
                                            case ERROR_CODE_DECODING_FAILED:
                                                return "ERROR_CODE_DECODING_FAILED";
                                            case ERROR_CODE_DECODING_FORMAT_EXCEEDS_CAPABILITIES:
                                                return "ERROR_CODE_DECODING_FORMAT_EXCEEDS_CAPABILITIES";
                                            case ERROR_CODE_DECODING_FORMAT_UNSUPPORTED:
                                                return "ERROR_CODE_DECODING_FORMAT_UNSUPPORTED";
                                            case ERROR_CODE_DECODING_RESOURCES_RECLAIMED:
                                                return "ERROR_CODE_DECODING_RESOURCES_RECLAIMED";
                                            default:
                                                switch (i6) {
                                                    case ERROR_CODE_AUDIO_TRACK_INIT_FAILED:
                                                        return "ERROR_CODE_AUDIO_TRACK_INIT_FAILED";
                                                    case ERROR_CODE_AUDIO_TRACK_WRITE_FAILED:
                                                        return "ERROR_CODE_AUDIO_TRACK_WRITE_FAILED";
                                                    case ERROR_CODE_AUDIO_TRACK_OFFLOAD_WRITE_FAILED:
                                                        return "ERROR_CODE_AUDIO_TRACK_OFFLOAD_WRITE_FAILED";
                                                    case ERROR_CODE_AUDIO_TRACK_OFFLOAD_INIT_FAILED:
                                                        return "ERROR_CODE_AUDIO_TRACK_OFFLOAD_INIT_FAILED";
                                                    default:
                                                        switch (i6) {
                                                            case ERROR_CODE_DRM_UNSPECIFIED:
                                                                return "ERROR_CODE_DRM_UNSPECIFIED";
                                                            case ERROR_CODE_DRM_SCHEME_UNSUPPORTED:
                                                                return "ERROR_CODE_DRM_SCHEME_UNSUPPORTED";
                                                            case ERROR_CODE_DRM_PROVISIONING_FAILED:
                                                                return "ERROR_CODE_DRM_PROVISIONING_FAILED";
                                                            case ERROR_CODE_DRM_CONTENT_ERROR:
                                                                return "ERROR_CODE_DRM_CONTENT_ERROR";
                                                            case ERROR_CODE_DRM_LICENSE_ACQUISITION_FAILED:
                                                                return "ERROR_CODE_DRM_LICENSE_ACQUISITION_FAILED";
                                                            case ERROR_CODE_DRM_DISALLOWED_OPERATION:
                                                                return "ERROR_CODE_DRM_DISALLOWED_OPERATION";
                                                            case ERROR_CODE_DRM_SYSTEM_ERROR:
                                                                return "ERROR_CODE_DRM_SYSTEM_ERROR";
                                                            case ERROR_CODE_DRM_DEVICE_REVOKED:
                                                                return "ERROR_CODE_DRM_DEVICE_REVOKED";
                                                            case ERROR_CODE_DRM_LICENSE_EXPIRED:
                                                                return "ERROR_CODE_DRM_LICENSE_EXPIRED";
                                                            default:
                                                                return i6 >= 1000000 ? "custom error code" : "invalid error code";
                                                        }
                                                }
                                        }
                                }
                        }
                }
        }
    }

    private static Bundle getExtrasFromBundle(Bundle bundle) {
        Bundle bundle2 = bundle.getBundle(FIELD_BUNDLE_EXTRAS);
        return bundle2 != null ? bundle2 : Bundle.EMPTY;
    }

    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean errorInfoEquals(PlaybackException playbackException) {
        if (this == playbackException) {
            return true;
        }
        if (playbackException != null && getClass() == playbackException.getClass()) {
            Throwable cause = getCause();
            Throwable cause2 = playbackException.getCause();
            if (cause == null || cause2 == null) {
                if (cause == null) {
                }
            } else if (!Objects.equals(cause.getMessage(), cause2.getMessage()) || !cause.getClass().equals(cause2.getClass())) {
                return false;
            }
            return this.errorCode == playbackException.errorCode && Objects.equals(getMessage(), playbackException.getMessage()) && this.timestampMs == playbackException.timestampMs;
        }
        return false;
    }

    @UnstableApi
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(FIELD_INT_ERROR_CODE, this.errorCode);
        bundle.putLong(FIELD_LONG_TIMESTAMP_MS, this.timestampMs);
        bundle.putString(FIELD_STRING_MESSAGE, getMessage());
        bundle.putBundle(FIELD_BUNDLE_EXTRAS, this.extras);
        Throwable cause = getCause();
        if (cause != null) {
            bundle.putString(FIELD_STRING_CAUSE_CLASS_NAME, cause.getClass().getName());
            bundle.putString(FIELD_STRING_CAUSE_MESSAGE, cause.getMessage());
        }
        return bundle;
    }

    @UnstableApi
    public PlaybackException(String str, Throwable th, int i6, Bundle bundle) {
        this(str, th, i6, bundle, Clock.DEFAULT.elapsedRealtime());
    }

    @UnstableApi
    public PlaybackException(Bundle bundle) {
        this(bundle.getString(FIELD_STRING_MESSAGE), getCauseFromBundle(bundle), bundle.getInt(FIELD_INT_ERROR_CODE, 1000), getExtrasFromBundle(bundle), bundle.getLong(FIELD_LONG_TIMESTAMP_MS, SystemClock.elapsedRealtime()));
    }

    @UnstableApi
    public PlaybackException(String str, Throwable th, int i6, Bundle bundle, long j10) {
        super(str, th);
        this.errorCode = i6;
        this.extras = bundle;
        this.timestampMs = j10;
    }

    public final String getErrorCodeName() {
        return getErrorCodeName(this.errorCode);
    }
}
