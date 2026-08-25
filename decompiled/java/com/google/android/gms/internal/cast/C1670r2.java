package com.google.android.gms.internal.cast;

import android.content.SharedPreferences;
import android.os.Looper;
import androidx.media3.container.NalUnitUtil;
import androidx.media3.exoplayer.DefaultRenderersFactory;
import androidx.media3.extractor.AacUtil;
import androidx.media3.extractor.flac.FlacConstants;
import androidx.media3.extractor.p010ts.TsExtractor;
import com.alibaba.fastjson.asm.Opcodes;
import java.util.HashSet;
import java.util.Iterator;
import me.jessyan.autosize.BuildConfig;
import p055ea.AbstractC2460q;
import p230v4.C3988b;

public final class C1670r2 {

    public static final C3988b f5576i = new C3988b("FeatureUsageAnalytics", null);

    public static final String f5577j = "22.1.0";

    public static C1670r2 f5578k;

    public final C1678s1 f5579a;

    public final SharedPreferences f5580b;

    public final String f5581c;

    public long f5586h;

    public final HashSet f5584f = new HashSet();

    public final HashSet f5585g = new HashSet();

    public final HandlerC1731y0 f5583e = new HandlerC1731y0(Looper.getMainLooper(), 0);

    public final RunnableC1502a0 f5582d = new RunnableC1502a0(3, this);

    public C1670r2(SharedPreferences sharedPreferences, C1678s1 c1678s1, String str) {
        this.f5580b = sharedPreferences;
        this.f5579a = c1678s1;
        this.f5581c = str;
    }

    public static void m3989a(EnumC1679s2 enumC1679s2) {
        C1670r2 c1670r2;
        if (!C1678s1.f5603k || (c1670r2 = f5578k) == null) {
            return;
        }
        String string = Integer.toString(enumC1679s2.f5672a);
        SharedPreferences sharedPreferences = c1670r2.f5580b;
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        String strM5501o = AbstractC2460q.m5501o("feature_usage_timestamp_reported_feature_", string);
        if (!sharedPreferences.contains(strM5501o)) {
            strM5501o = AbstractC2460q.m5501o("feature_usage_timestamp_detected_feature_", string);
        }
        editorEdit.putLong(strM5501o, System.currentTimeMillis()).apply();
        c1670r2.f5584f.add(enumC1679s2);
        c1670r2.f5583e.post(c1670r2.f5582d);
    }

    public static EnumC1679s2 m3990b(String str) {
        EnumC1679s2 enumC1679s2 = EnumC1679s2.DEVELOPER_FEATURE_FLAG_UNKNOWN;
        try {
            switch (Integer.parseInt(str)) {
                case 0:
                    break;
                case 1:
                    enumC1679s2 = EnumC1679s2.CAF_CAST_BUTTON;
                    break;
                case 2:
                    enumC1679s2 = EnumC1679s2.CAF_EXPANDED_CONTROLLER;
                    break;
                case 3:
                    enumC1679s2 = EnumC1679s2.CAF_MINI_CONTROLLER;
                    break;
                case 4:
                    enumC1679s2 = EnumC1679s2.CAF_CONTAINER_CONTROLLER;
                    break;
                case 5:
                    enumC1679s2 = EnumC1679s2.CAST_CONTEXT;
                    break;
                case 6:
                    enumC1679s2 = EnumC1679s2.IMAGE_CACHE;
                    break;
                case 7:
                    enumC1679s2 = EnumC1679s2.IMAGE_PICKER;
                    break;
                case 8:
                    enumC1679s2 = EnumC1679s2.AD_BREAK_PARSER;
                    break;
                case 9:
                    enumC1679s2 = EnumC1679s2.UI_STYLE;
                    break;
                case 10:
                    enumC1679s2 = EnumC1679s2.HARDWARE_VOLUME_BUTTON;
                    break;
                case 11:
                    enumC1679s2 = EnumC1679s2.NON_CAST_DEVICE_PROVIDER;
                    break;
                case 12:
                    enumC1679s2 = EnumC1679s2.PAUSE_CONTROLLER;
                    break;
                case 13:
                    enumC1679s2 = EnumC1679s2.SEEK_CONTROLLER;
                    break;
                case 14:
                    enumC1679s2 = EnumC1679s2.STREAM_VOLUME;
                    break;
                case 15:
                    enumC1679s2 = EnumC1679s2.UI_MEDIA_CONTROLLER;
                    break;
                case 16:
                    enumC1679s2 = EnumC1679s2.PLAYBACK_RATE_CONTROLLER;
                    break;
                case 17:
                    enumC1679s2 = EnumC1679s2.PRECACHE;
                    break;
                case 18:
                    enumC1679s2 = EnumC1679s2.INSTRUCTIONS_VIEW;
                    break;
                case 19:
                    enumC1679s2 = EnumC1679s2.OPTION_SUSPEND_SESSIONS_WHEN_BACKGROUNDED;
                    break;
                case 20:
                    enumC1679s2 = EnumC1679s2.OPTION_STOP_RECEIVER_APPLICATION_WHEN_ENDING_SESSION;
                    break;
                case 21:
                    enumC1679s2 = EnumC1679s2.OPTION_DISABLE_DISCOVERY_AUTOSTART;
                    break;
                case 22:
                    enumC1679s2 = EnumC1679s2.OPTION_DISABLE_ANALYTICS_LOGGING;
                    break;
                case 23:
                    enumC1679s2 = EnumC1679s2.OPTION_PHYSICAL_VOLUME_BUTTONS_WILL_CONTROL_DEVICE_VOLUME;
                    break;
                case 24:
                    enumC1679s2 = EnumC1679s2.CAF_EXPANDED_CONTROLLER_HIDE_STREAM_POSITION_CONTROLS_FOR_LIVE_CONTENT;
                    break;
                case 25:
                    enumC1679s2 = EnumC1679s2.CAF_EXPANDED_CONTROLLER_WITH_LIVE_CONTENT;
                    break;
                case 26:
                    enumC1679s2 = EnumC1679s2.REMOTE_MEDIA_CLIENT_LOAD_MEDIA_WITH_OPTIONS;
                    break;
                case 27:
                    enumC1679s2 = EnumC1679s2.REMOTE_MEDIA_CLIENT_QUEUE_LOAD_ITEMS_WITH_OPTIONS;
                    break;
                case 28:
                    enumC1679s2 = EnumC1679s2.REMOTE_MEDIA_CLIENT_LOAD_MEDIA_WITH_LOAD_REQUEST_DATA;
                    break;
                case 29:
                    enumC1679s2 = EnumC1679s2.LAUNCH_OPTION_ANDROID_RECEIVER_COMPATIBLE;
                    break;
                case 30:
                    enumC1679s2 = EnumC1679s2.CAST_CONTEXT_SET_LAUNCH_CREDENTIALS_DATA;
                    break;
                case 31:
                    enumC1679s2 = EnumC1679s2.START_DISCOVERY_AFTER_FIRST_TAP_ON_CAST_BUTTON;
                    break;
                case 32:
                    enumC1679s2 = EnumC1679s2.CAST_UNAVAILABLE_BUTTON_VISIBLE;
                    break;
                case 33:
                    enumC1679s2 = EnumC1679s2.CAST_DEFAULT_MEDIA_ROUTER_DIALOG;
                    break;
                case 34:
                    enumC1679s2 = EnumC1679s2.CAST_CUSTOM_MEDIA_ROUTER_DIALOG;
                    break;
                case 35:
                    enumC1679s2 = EnumC1679s2.CAST_OUTPUT_SWITCHER_ENABLED;
                    break;
                case TsExtractor.TS_STREAM_TYPE_H265:
                    enumC1679s2 = EnumC1679s2.CAST_TRANSFER_TO_LOCAL_ENABLED;
                    break;
                case 37:
                    enumC1679s2 = EnumC1679s2.CAST_BUTTON_IS_TRIGGERED_DEFAULT_CAST_DIALOG_FALSE;
                    break;
                case FlacConstants.STREAM_INFO_BLOCK_SIZE:
                    enumC1679s2 = EnumC1679s2.CAST_BUTTON_DELEGATE;
                    break;
                case NalUnitUtil.H265_NAL_UNIT_TYPE_PREFIX_SEI:
                    enumC1679s2 = EnumC1679s2.CAST_BUTTON_DELEGATE_PRESENT_LNA_PERMISSION_CUSTOM_DIALOG;
                    break;
                case NalUnitUtil.H265_NAL_UNIT_TYPE_SUFFIX_SEI:
                    enumC1679s2 = EnumC1679s2.CAST_BUTTON_DELEGATE_PRESENT_CAST_STATE_CUSTOM_DIALOG;
                    break;
                case BuildConfig.VERSION_CODE:
                    enumC1679s2 = EnumC1679s2.CAST_TRANSFER_TO_LOCAL_USED;
                    break;
                case AacUtil.AUDIO_OBJECT_TYPE_AAC_XHE:
                    enumC1679s2 = EnumC1679s2.MEDIA_REQUEST_ITEM_MAP_HLS_SEGMENT_FORMAT_TO_STRING;
                    break;
                case 43:
                    enumC1679s2 = EnumC1679s2.MEDIA_REQUEST_ITEM_MAP_HLS_SEGMENT_FORMAT_STRING_TO_ENUM;
                    break;
                case 44:
                    enumC1679s2 = EnumC1679s2.HLS_SEGMENT_MAP_HLS_SEGMENT_FORMAT_TO_STRING;
                    break;
                case TsExtractor.TS_STREAM_TYPE_MHAS:
                    enumC1679s2 = EnumC1679s2.HLS_SEGMENT_MAP_HLS_SEGMENT_FORMAT_STRING_TO_ENUM;
                    break;
                case 46:
                    enumC1679s2 = EnumC1679s2.HLS_VIDEO_SEGMENT_MAP_HLS_VIDEO_SEGMENT_FORMAT_TO_STRING;
                    break;
                case 47:
                    enumC1679s2 = EnumC1679s2.HLS_VIDEO_SEGMENT_MAP_HLS_VIDEO_SEGMENT_FORMAT_STRING_TO_ENUM;
                    break;
                case NalUnitUtil.H265_NAL_UNIT_TYPE_UNSPECIFIED:
                    enumC1679s2 = EnumC1679s2.CAST_SLIDER_SET_AD_BLOCK_POSITIONS;
                    break;
                case Opcodes.V1_5:
                    enumC1679s2 = EnumC1679s2.CAF_NOTIFICATION_SERVICE;
                    break;
                case DefaultRenderersFactory.MAX_DROPPED_VIDEO_FRAME_COUNT_TO_NOTIFY:
                    enumC1679s2 = EnumC1679s2.HARDWARE_VOLUME_BUTTON_PRESS;
                    break;
                case 51:
                    enumC1679s2 = EnumC1679s2.CAST_SDK_DEFAULT_DEVICE_DIALOG;
                    break;
                case 52:
                    enumC1679s2 = EnumC1679s2.CAST_SDK_CUSTOM_DEVICE_DIALOG;
                    break;
                case 53:
                    enumC1679s2 = EnumC1679s2.PERSISTENT_CAST_BUTTON_DISCOVERY_DISABLED_WITH_CONFLICT_TYPES;
                    break;
                case Opcodes.ISTORE:
                    enumC1679s2 = EnumC1679s2.CAST_DEVICE_DIALOG_FACTORY_INSTANTIATED;
                    break;
                case Opcodes.LSTORE:
                    enumC1679s2 = EnumC1679s2.CAF_MEDIA_NOTIFICATION_PROXY;
                    break;
                case Opcodes.FSTORE:
                    enumC1679s2 = EnumC1679s2.REMOTE_CONNECTION_MANAGER_ACQUIRED;
                    break;
                case Opcodes.DSTORE:
                    enumC1679s2 = EnumC1679s2.REMOTE_CONNECTION_CALLBACK_SET;
                    break;
                default:
                    enumC1679s2 = null;
                    break;
            }
        } catch (NumberFormatException unused) {
        }
        return enumC1679s2;
    }

    public final void m3991c(HashSet hashSet) {
        if (hashSet.isEmpty()) {
            return;
        }
        SharedPreferences.Editor editorEdit = this.f5580b.edit();
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            editorEdit.remove((String) it.next());
        }
        editorEdit.apply();
    }
}
