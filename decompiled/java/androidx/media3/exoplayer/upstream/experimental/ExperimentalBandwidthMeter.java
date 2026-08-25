package androidx.media3.exoplayer.upstream.experimental;

import android.content.Context;
import android.os.Handler;
import androidx.media3.common.C0565C;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.BackgroundExecutor;
import androidx.media3.common.util.NetworkTypeObserver;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.container.MdtaMetadataEntry;
import androidx.media3.container.NalUnitUtil;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DataSpec;
import androidx.media3.datasource.TransferListener;
import androidx.media3.exoplayer.DefaultRenderersFactory;
import androidx.media3.exoplayer.audio.SilenceSkippingAudioProcessor;
import androidx.media3.exoplayer.hls.playlist.HlsMediaPlaylist;
import androidx.media3.exoplayer.upstream.BandwidthMeter;
import androidx.media3.exoplayer.upstream.C0962f;
import androidx.media3.exoplayer.upstream.TimeToFirstByteEstimator;
import androidx.media3.extractor.AacUtil;
import androidx.media3.extractor.flac.FlacConstants;
import androidx.media3.extractor.metadata.dvbsi.AppInfoTableDecoder;
import androidx.media3.extractor.p010ts.PsExtractor;
import androidx.media3.extractor.p010ts.TsExtractor;
import com.alibaba.fastjson.asm.Opcodes;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import me.jessyan.autosize.BuildConfig;
import okio.Utf8;
import p020b7.AbstractC1332b;
import p041d7.AbstractC2301u1;
import p041d7.AbstractC2331z1;

@UnstableApi
public final class ExperimentalBandwidthMeter implements BandwidthMeter, TransferListener {
    private static final int COUNTRY_GROUP_INDEX_2G = 1;
    private static final int COUNTRY_GROUP_INDEX_3G = 2;
    private static final int COUNTRY_GROUP_INDEX_4G = 3;
    private static final int COUNTRY_GROUP_INDEX_5G_NSA = 4;
    private static final int COUNTRY_GROUP_INDEX_5G_SA = 5;
    private static final int COUNTRY_GROUP_INDEX_WIFI = 0;
    public static final long DEFAULT_INITIAL_BITRATE_ESTIMATE = 1000000;
    public static final AbstractC2301u1 DEFAULT_INITIAL_BITRATE_ESTIMATES_3G;
    public static final AbstractC2301u1 DEFAULT_INITIAL_BITRATE_ESTIMATES_4G;
    public static final AbstractC2301u1 DEFAULT_INITIAL_BITRATE_ESTIMATES_5G_NSA;
    public static final AbstractC2301u1 DEFAULT_INITIAL_BITRATE_ESTIMATES_5G_SA;
    public static final float DEFAULT_TIME_TO_FIRST_BYTE_PERCENTILE = 0.5f;
    public static final int DEFAULT_TIME_TO_FIRST_BYTE_SAMPLES = 20;
    private final BandwidthEstimator bandwidthEstimator;
    private final Context context;
    private String countryCode;
    private long initialBitrateEstimate;
    private final AbstractC2331z1 initialBitrateEstimates;
    private int networkType;
    private int networkTypeOverride;
    private boolean networkTypeOverrideSet;
    private final boolean resetOnNetworkTypeChange;
    private final TimeToFirstByteEstimator timeToFirstByteEstimator;
    public static final AbstractC2301u1 DEFAULT_INITIAL_BITRATE_ESTIMATES_WIFI = AbstractC2301u1.m5278u(4300000L, 3200000L, 2400000L, 1700000L, 860000L);
    public static final AbstractC2301u1 DEFAULT_INITIAL_BITRATE_ESTIMATES_2G = AbstractC2301u1.m5278u(1500000L, 980000L, 750000L, 520000L, 290000L);

    static {
        Long lValueOf = Long.valueOf(SilenceSkippingAudioProcessor.DEFAULT_MAX_SILENCE_TO_KEEP_DURATION_US);
        DEFAULT_INITIAL_BITRATE_ESTIMATES_3G = AbstractC2301u1.m5278u(lValueOf, 1300000L, 1000000L, 860000L, 610000L);
        DEFAULT_INITIAL_BITRATE_ESTIMATES_4G = AbstractC2301u1.m5278u(2500000L, 1700000L, 1200000L, 970000L, 680000L);
        DEFAULT_INITIAL_BITRATE_ESTIMATES_5G_NSA = AbstractC2301u1.m5278u(4700000L, 2800000L, 2100000L, 1700000L, 980000L);
        DEFAULT_INITIAL_BITRATE_ESTIMATES_5G_SA = AbstractC2301u1.m5278u(2700000L, lValueOf, 1600000L, 1300000L, 1000000L);
    }

    private static int[] getInitialBitrateCountryGroupAssignment(String str) {
        byte b8 = 4;
        str.getClass();
        switch (str.hashCode()) {
            case 2083:
                if (!str.equals("AD")) {
                    b8 = -1;
                } else {
                    b8 = 0;
                }
                break;
            case 2084:
                if (!str.equals("AE")) {
                    b8 = -1;
                } else {
                    b8 = 1;
                }
                break;
            case 2085:
                if (!str.equals("AF")) {
                    b8 = -1;
                } else {
                    b8 = 2;
                }
                break;
            case 2086:
                if (!str.equals("AG")) {
                    b8 = -1;
                } else {
                    b8 = 3;
                }
                break;
            case 2088:
                if (!str.equals("AI")) {
                    b8 = -1;
                }
                break;
            case 2091:
                if (!str.equals("AL")) {
                    b8 = -1;
                } else {
                    b8 = 5;
                }
                break;
            case 2092:
                if (!str.equals("AM")) {
                    b8 = -1;
                } else {
                    b8 = 6;
                }
                break;
            case 2094:
                if (!str.equals("AO")) {
                    b8 = -1;
                } else {
                    b8 = 7;
                }
                break;
            case 2096:
                if (!str.equals("AQ")) {
                    b8 = -1;
                } else {
                    b8 = 8;
                }
                break;
            case 2097:
                if (!str.equals("AR")) {
                    b8 = -1;
                } else {
                    b8 = 9;
                }
                break;
            case 2098:
                if (!str.equals("AS")) {
                    b8 = -1;
                } else {
                    b8 = 10;
                }
                break;
            case 2099:
                if (!str.equals("AT")) {
                    b8 = -1;
                } else {
                    b8 = 11;
                }
                break;
            case 2100:
                if (!str.equals("AU")) {
                    b8 = -1;
                } else {
                    b8 = 12;
                }
                break;
            case 2102:
                if (!str.equals("AW")) {
                    b8 = -1;
                } else {
                    b8 = 13;
                }
                break;
            case 2103:
                if (!str.equals("AX")) {
                    b8 = -1;
                } else {
                    b8 = 14;
                }
                break;
            case 2105:
                if (!str.equals("AZ")) {
                    b8 = -1;
                } else {
                    b8 = 15;
                }
                break;
            case 2111:
                if (!str.equals("BA")) {
                    b8 = -1;
                } else {
                    b8 = 16;
                }
                break;
            case 2112:
                if (!str.equals("BB")) {
                    b8 = -1;
                } else {
                    b8 = 17;
                }
                break;
            case 2114:
                if (!str.equals("BD")) {
                    b8 = -1;
                } else {
                    b8 = 18;
                }
                break;
            case 2115:
                if (!str.equals("BE")) {
                    b8 = -1;
                } else {
                    b8 = 19;
                }
                break;
            case 2116:
                if (!str.equals("BF")) {
                    b8 = -1;
                } else {
                    b8 = 20;
                }
                break;
            case 2117:
                if (!str.equals("BG")) {
                    b8 = -1;
                } else {
                    b8 = 21;
                }
                break;
            case 2118:
                if (!str.equals("BH")) {
                    b8 = -1;
                } else {
                    b8 = 22;
                }
                break;
            case 2119:
                if (!str.equals("BI")) {
                    b8 = -1;
                } else {
                    b8 = 23;
                }
                break;
            case 2120:
                if (!str.equals("BJ")) {
                    b8 = -1;
                } else {
                    b8 = 24;
                }
                break;
            case 2122:
                if (!str.equals("BL")) {
                    b8 = -1;
                } else {
                    b8 = 25;
                }
                break;
            case 2123:
                if (!str.equals("BM")) {
                    b8 = -1;
                } else {
                    b8 = 26;
                }
                break;
            case 2124:
                if (!str.equals("BN")) {
                    b8 = -1;
                } else {
                    b8 = 27;
                }
                break;
            case 2125:
                if (!str.equals("BO")) {
                    b8 = -1;
                } else {
                    b8 = 28;
                }
                break;
            case 2127:
                if (!str.equals("BQ")) {
                    b8 = -1;
                } else {
                    b8 = 29;
                }
                break;
            case 2128:
                if (!str.equals("BR")) {
                    b8 = -1;
                } else {
                    b8 = 30;
                }
                break;
            case 2129:
                if (!str.equals("BS")) {
                    b8 = -1;
                } else {
                    b8 = 31;
                }
                break;
            case 2130:
                if (!str.equals("BT")) {
                    b8 = -1;
                } else {
                    b8 = 32;
                }
                break;
            case 2133:
                if (!str.equals("BW")) {
                    b8 = -1;
                } else {
                    b8 = 33;
                }
                break;
            case 2135:
                if (!str.equals("BY")) {
                    b8 = -1;
                } else {
                    b8 = 34;
                }
                break;
            case 2136:
                if (!str.equals("BZ")) {
                    b8 = -1;
                } else {
                    b8 = 35;
                }
                break;
            case 2142:
                if (!str.equals("CA")) {
                    b8 = -1;
                } else {
                    b8 = 36;
                }
                break;
            case 2145:
                if (!str.equals("CD")) {
                    b8 = -1;
                } else {
                    b8 = 37;
                }
                break;
            case 2147:
                if (!str.equals("CF")) {
                    b8 = -1;
                } else {
                    b8 = 38;
                }
                break;
            case 2148:
                if (!str.equals("CG")) {
                    b8 = -1;
                } else {
                    b8 = 39;
                }
                break;
            case 2149:
                if (!str.equals("CH")) {
                    b8 = -1;
                } else {
                    b8 = 40;
                }
                break;
            case 2150:
                if (!str.equals("CI")) {
                    b8 = -1;
                } else {
                    b8 = 41;
                }
                break;
            case 2152:
                if (!str.equals("CK")) {
                    b8 = -1;
                } else {
                    b8 = 42;
                }
                break;
            case 2153:
                if (!str.equals("CL")) {
                    b8 = -1;
                } else {
                    b8 = 43;
                }
                break;
            case 2154:
                if (!str.equals("CM")) {
                    b8 = -1;
                } else {
                    b8 = 44;
                }
                break;
            case 2155:
                if (!str.equals("CN")) {
                    b8 = -1;
                } else {
                    b8 = 45;
                }
                break;
            case 2156:
                if (!str.equals("CO")) {
                    b8 = -1;
                } else {
                    b8 = 46;
                }
                break;
            case 2159:
                if (!str.equals("CR")) {
                    b8 = -1;
                } else {
                    b8 = 47;
                }
                break;
            case 2162:
                if (!str.equals("CU")) {
                    b8 = -1;
                } else {
                    b8 = 48;
                }
                break;
            case 2163:
                if (!str.equals("CV")) {
                    b8 = -1;
                } else {
                    b8 = 49;
                }
                break;
            case 2164:
                if (!str.equals("CW")) {
                    b8 = -1;
                } else {
                    b8 = 50;
                }
                break;
            case 2165:
                if (!str.equals("CX")) {
                    b8 = -1;
                } else {
                    b8 = 51;
                }
                break;
            case 2166:
                if (!str.equals("CY")) {
                    b8 = -1;
                } else {
                    b8 = 52;
                }
                break;
            case 2167:
                if (!str.equals("CZ")) {
                    b8 = -1;
                } else {
                    b8 = 53;
                }
                break;
            case 2177:
                if (!str.equals("DE")) {
                    b8 = -1;
                } else {
                    b8 = 54;
                }
                break;
            case 2182:
                if (!str.equals("DJ")) {
                    b8 = -1;
                } else {
                    b8 = 55;
                }
                break;
            case 2183:
                if (!str.equals("DK")) {
                    b8 = -1;
                } else {
                    b8 = 56;
                }
                break;
            case 2185:
                if (!str.equals("DM")) {
                    b8 = -1;
                } else {
                    b8 = 57;
                }
                break;
            case 2187:
                if (!str.equals("DO")) {
                    b8 = -1;
                } else {
                    b8 = 58;
                }
                break;
            case 2198:
                if (!str.equals("DZ")) {
                    b8 = -1;
                } else {
                    b8 = 59;
                }
                break;
            case 2206:
                if (!str.equals("EC")) {
                    b8 = -1;
                } else {
                    b8 = 60;
                }
                break;
            case 2208:
                if (!str.equals("EE")) {
                    b8 = -1;
                } else {
                    b8 = 61;
                }
                break;
            case 2210:
                if (!str.equals("EG")) {
                    b8 = -1;
                } else {
                    b8 = 62;
                }
                break;
            case 2221:
                if (!str.equals("ER")) {
                    b8 = -1;
                } else {
                    b8 = Utf8.REPLACEMENT_BYTE;
                }
                break;
            case 2222:
                if (!str.equals("ES")) {
                    b8 = -1;
                } else {
                    b8 = 64;
                }
                break;
            case 2223:
                if (!str.equals("ET")) {
                    b8 = -1;
                } else {
                    b8 = 65;
                }
                break;
            case 2243:
                if (!str.equals("FI")) {
                    b8 = -1;
                } else {
                    b8 = 66;
                }
                break;
            case 2244:
                if (!str.equals("FJ")) {
                    b8 = -1;
                } else {
                    b8 = 67;
                }
                break;
            case 2245:
                if (!str.equals("FK")) {
                    b8 = -1;
                } else {
                    b8 = 68;
                }
                break;
            case 2247:
                if (!str.equals("FM")) {
                    b8 = -1;
                } else {
                    b8 = 69;
                }
                break;
            case 2249:
                if (!str.equals("FO")) {
                    b8 = -1;
                } else {
                    b8 = 70;
                }
                break;
            case 2252:
                if (!str.equals("FR")) {
                    b8 = -1;
                } else {
                    b8 = 71;
                }
                break;
            case 2266:
                if (!str.equals("GA")) {
                    b8 = -1;
                } else {
                    b8 = 72;
                }
                break;
            case 2267:
                if (!str.equals("GB")) {
                    b8 = -1;
                } else {
                    b8 = 73;
                }
                break;
            case 2269:
                if (!str.equals("GD")) {
                    b8 = -1;
                } else {
                    b8 = 74;
                }
                break;
            case 2270:
                if (!str.equals("GE")) {
                    b8 = -1;
                } else {
                    b8 = 75;
                }
                break;
            case 2271:
                if (!str.equals("GF")) {
                    b8 = -1;
                } else {
                    b8 = 76;
                }
                break;
            case 2272:
                if (!str.equals("GG")) {
                    b8 = -1;
                } else {
                    b8 = 77;
                }
                break;
            case 2273:
                if (!str.equals("GH")) {
                    b8 = -1;
                } else {
                    b8 = 78;
                }
                break;
            case 2274:
                if (!str.equals("GI")) {
                    b8 = -1;
                } else {
                    b8 = 79;
                }
                break;
            case 2277:
                if (!str.equals("GL")) {
                    b8 = -1;
                } else {
                    b8 = 80;
                }
                break;
            case 2278:
                if (!str.equals("GM")) {
                    b8 = -1;
                } else {
                    b8 = 81;
                }
                break;
            case 2279:
                if (!str.equals("GN")) {
                    b8 = -1;
                } else {
                    b8 = 82;
                }
                break;
            case 2281:
                if (!str.equals("GP")) {
                    b8 = -1;
                } else {
                    b8 = 83;
                }
                break;
            case 2282:
                if (!str.equals("GQ")) {
                    b8 = -1;
                } else {
                    b8 = 84;
                }
                break;
            case 2283:
                if (!str.equals("GR")) {
                    b8 = -1;
                } else {
                    b8 = 85;
                }
                break;
            case 2285:
                if (!str.equals("GT")) {
                    b8 = -1;
                } else {
                    b8 = 86;
                }
                break;
            case 2286:
                if (!str.equals("GU")) {
                    b8 = -1;
                } else {
                    b8 = 87;
                }
                break;
            case 2288:
                if (!str.equals("GW")) {
                    b8 = -1;
                } else {
                    b8 = 88;
                }
                break;
            case 2290:
                if (!str.equals("GY")) {
                    b8 = -1;
                } else {
                    b8 = 89;
                }
                break;
            case 2307:
                if (!str.equals("HK")) {
                    b8 = -1;
                } else {
                    b8 = 90;
                }
                break;
            case 2314:
                if (!str.equals("HR")) {
                    b8 = -1;
                } else {
                    b8 = 91;
                }
                break;
            case 2316:
                if (!str.equals("HT")) {
                    b8 = -1;
                } else {
                    b8 = 92;
                }
                break;
            case 2317:
                if (!str.equals("HU")) {
                    b8 = -1;
                } else {
                    b8 = 93;
                }
                break;
            case 2331:
                if (!str.equals("ID")) {
                    b8 = -1;
                } else {
                    b8 = 94;
                }
                break;
            case 2332:
                if (!str.equals("IE")) {
                    b8 = -1;
                } else {
                    b8 = 95;
                }
                break;
            case 2339:
                if (!str.equals("IL")) {
                    b8 = -1;
                } else {
                    b8 = 96;
                }
                break;
            case 2340:
                if (!str.equals("IM")) {
                    b8 = -1;
                } else {
                    b8 = 97;
                }
                break;
            case 2341:
                if (!str.equals(HlsMediaPlaylist.Interstitial.SNAP_TYPE_IN)) {
                    b8 = -1;
                } else {
                    b8 = 98;
                }
                break;
            case 2342:
                if (!str.equals("IO")) {
                    b8 = -1;
                } else {
                    b8 = 99;
                }
                break;
            case 2344:
                if (!str.equals("IQ")) {
                    b8 = -1;
                } else {
                    b8 = 100;
                }
                break;
            case 2345:
                if (!str.equals("IR")) {
                    b8 = -1;
                } else {
                    b8 = 101;
                }
                break;
            case 2346:
                if (!str.equals("IS")) {
                    b8 = -1;
                } else {
                    b8 = 102;
                }
                break;
            case 2347:
                if (!str.equals("IT")) {
                    b8 = -1;
                } else {
                    b8 = 103;
                }
                break;
            case 2363:
                if (!str.equals("JE")) {
                    b8 = -1;
                } else {
                    b8 = 104;
                }
                break;
            case 2371:
                if (!str.equals("JM")) {
                    b8 = -1;
                } else {
                    b8 = 105;
                }
                break;
            case 2373:
                if (!str.equals("JO")) {
                    b8 = -1;
                } else {
                    b8 = 106;
                }
                break;
            case 2374:
                if (!str.equals("JP")) {
                    b8 = -1;
                } else {
                    b8 = 107;
                }
                break;
            case 2394:
                if (!str.equals("KE")) {
                    b8 = -1;
                } else {
                    b8 = 108;
                }
                break;
            case 2396:
                if (!str.equals("KG")) {
                    b8 = -1;
                } else {
                    b8 = 109;
                }
                break;
            case 2397:
                if (!str.equals("KH")) {
                    b8 = -1;
                } else {
                    b8 = 110;
                }
                break;
            case 2398:
                if (!str.equals("KI")) {
                    b8 = -1;
                } else {
                    b8 = 111;
                }
                break;
            case 2402:
                if (!str.equals("KM")) {
                    b8 = -1;
                } else {
                    b8 = 112;
                }
                break;
            case 2403:
                if (!str.equals("KN")) {
                    b8 = -1;
                } else {
                    b8 = 113;
                }
                break;
            case 2407:
                if (!str.equals("KR")) {
                    b8 = -1;
                } else {
                    b8 = 114;
                }
                break;
            case 2412:
                if (!str.equals("KW")) {
                    b8 = -1;
                } else {
                    b8 = 115;
                }
                break;
            case 2414:
                if (!str.equals("KY")) {
                    b8 = -1;
                } else {
                    b8 = 116;
                }
                break;
            case 2415:
                if (!str.equals("KZ")) {
                    b8 = -1;
                } else {
                    b8 = 117;
                }
                break;
            case 2421:
                if (!str.equals("LA")) {
                    b8 = -1;
                } else {
                    b8 = 118;
                }
                break;
            case 2422:
                if (!str.equals("LB")) {
                    b8 = -1;
                } else {
                    b8 = 119;
                }
                break;
            case 2423:
                if (!str.equals("LC")) {
                    b8 = -1;
                } else {
                    b8 = 120;
                }
                break;
            case 2429:
                if (!str.equals("LI")) {
                    b8 = -1;
                } else {
                    b8 = 121;
                }
                break;
            case 2431:
                if (!str.equals("LK")) {
                    b8 = -1;
                } else {
                    b8 = 122;
                }
                break;
            case 2438:
                if (!str.equals("LR")) {
                    b8 = -1;
                } else {
                    b8 = 123;
                }
                break;
            case 2439:
                if (!str.equals("LS")) {
                    b8 = -1;
                } else {
                    b8 = 124;
                }
                break;
            case 2440:
                if (!str.equals("LT")) {
                    b8 = -1;
                } else {
                    b8 = 125;
                }
                break;
            case 2441:
                if (!str.equals("LU")) {
                    b8 = -1;
                } else {
                    b8 = 126;
                }
                break;
            case 2442:
                if (!str.equals("LV")) {
                    b8 = -1;
                } else {
                    b8 = 127;
                }
                break;
            case 2445:
                if (!str.equals("LY")) {
                    b8 = -1;
                } else {
                    b8 = 128;
                }
                break;
            case 2452:
                if (!str.equals("MA")) {
                    b8 = -1;
                } else {
                    b8 = 129;
                }
                break;
            case 2454:
                if (!str.equals("MC")) {
                    b8 = -1;
                } else {
                    b8 = 130;
                }
                break;
            case 2455:
                if (!str.equals("MD")) {
                    b8 = -1;
                } else {
                    b8 = 131;
                }
                break;
            case 2456:
                if (!str.equals("ME")) {
                    b8 = -1;
                } else {
                    b8 = 132;
                }
                break;
            case 2457:
                if (!str.equals("MF")) {
                    b8 = -1;
                } else {
                    b8 = 133;
                }
                break;
            case 2458:
                if (!str.equals("MG")) {
                    b8 = -1;
                } else {
                    b8 = 134;
                }
                break;
            case 2459:
                if (!str.equals("MH")) {
                    b8 = -1;
                } else {
                    b8 = 135;
                }
                break;
            case 2462:
                if (!str.equals("MK")) {
                    b8 = -1;
                } else {
                    b8 = 136;
                }
                break;
            case 2463:
                if (!str.equals("ML")) {
                    b8 = -1;
                } else {
                    b8 = 137;
                }
                break;
            case 2464:
                if (!str.equals("MM")) {
                    b8 = -1;
                } else {
                    b8 = 138;
                }
                break;
            case 2465:
                if (!str.equals("MN")) {
                    b8 = -1;
                } else {
                    b8 = 139;
                }
                break;
            case 2466:
                if (!str.equals("MO")) {
                    b8 = -1;
                } else {
                    b8 = 140;
                }
                break;
            case 2467:
                if (!str.equals("MP")) {
                    b8 = -1;
                } else {
                    b8 = 141;
                }
                break;
            case 2468:
                if (!str.equals("MQ")) {
                    b8 = -1;
                } else {
                    b8 = 142;
                }
                break;
            case 2469:
                if (!str.equals("MR")) {
                    b8 = -1;
                } else {
                    b8 = 143;
                }
                break;
            case 2470:
                if (!str.equals("MS")) {
                    b8 = -1;
                } else {
                    b8 = 144;
                }
                break;
            case 2471:
                if (!str.equals("MT")) {
                    b8 = -1;
                } else {
                    b8 = 145;
                }
                break;
            case 2472:
                if (!str.equals("MU")) {
                    b8 = -1;
                } else {
                    b8 = 146;
                }
                break;
            case 2473:
                if (!str.equals("MV")) {
                    b8 = -1;
                } else {
                    b8 = 147;
                }
                break;
            case 2474:
                if (!str.equals("MW")) {
                    b8 = -1;
                } else {
                    b8 = 148;
                }
                break;
            case 2475:
                if (!str.equals("MX")) {
                    b8 = -1;
                } else {
                    b8 = 149;
                }
                break;
            case 2476:
                if (!str.equals("MY")) {
                    b8 = -1;
                } else {
                    b8 = 150;
                }
                break;
            case 2477:
                if (!str.equals("MZ")) {
                    b8 = -1;
                } else {
                    b8 = 151;
                }
                break;
            case 2483:
                if (!str.equals("NA")) {
                    b8 = -1;
                } else {
                    b8 = 152;
                }
                break;
            case 2485:
                if (!str.equals("NC")) {
                    b8 = -1;
                } else {
                    b8 = 153;
                }
                break;
            case 2487:
                if (!str.equals("NE")) {
                    b8 = -1;
                } else {
                    b8 = 154;
                }
                break;
            case 2488:
                if (!str.equals("NF")) {
                    b8 = -1;
                } else {
                    b8 = 155;
                }
                break;
            case 2489:
                if (!str.equals("NG")) {
                    b8 = -1;
                } else {
                    b8 = 156;
                }
                break;
            case 2491:
                if (!str.equals("NI")) {
                    b8 = -1;
                } else {
                    b8 = 157;
                }
                break;
            case 2494:
                if (!str.equals("NL")) {
                    b8 = -1;
                } else {
                    b8 = 158;
                }
                break;
            case 2497:
                if (!str.equals("NO")) {
                    b8 = -1;
                } else {
                    b8 = 159;
                }
                break;
            case 2498:
                if (!str.equals("NP")) {
                    b8 = -1;
                } else {
                    b8 = 160;
                }
                break;
            case 2500:
                if (!str.equals("NR")) {
                    b8 = -1;
                } else {
                    b8 = 161;
                }
                break;
            case 2503:
                if (!str.equals("NU")) {
                    b8 = -1;
                } else {
                    b8 = 162;
                }
                break;
            case 2508:
                if (!str.equals("NZ")) {
                    b8 = -1;
                } else {
                    b8 = 163;
                }
                break;
            case 2526:
                if (!str.equals("OM")) {
                    b8 = -1;
                } else {
                    b8 = 164;
                }
                break;
            case 2545:
                if (!str.equals("PA")) {
                    b8 = -1;
                } else {
                    b8 = 165;
                }
                break;
            case 2549:
                if (!str.equals("PE")) {
                    b8 = -1;
                } else {
                    b8 = 166;
                }
                break;
            case 2550:
                if (!str.equals("PF")) {
                    b8 = -1;
                } else {
                    b8 = 167;
                }
                break;
            case 2551:
                if (!str.equals("PG")) {
                    b8 = -1;
                } else {
                    b8 = 168;
                }
                break;
            case 2552:
                if (!str.equals("PH")) {
                    b8 = -1;
                } else {
                    b8 = 169;
                }
                break;
            case 2555:
                if (!str.equals("PK")) {
                    b8 = -1;
                } else {
                    b8 = 170;
                }
                break;
            case 2556:
                if (!str.equals("PL")) {
                    b8 = -1;
                } else {
                    b8 = 171;
                }
                break;
            case 2557:
                if (!str.equals("PM")) {
                    b8 = -1;
                } else {
                    b8 = 172;
                }
                break;
            case 2562:
                if (!str.equals("PR")) {
                    b8 = -1;
                } else {
                    b8 = 173;
                }
                break;
            case 2563:
                if (!str.equals("PS")) {
                    b8 = -1;
                } else {
                    b8 = 174;
                }
                break;
            case 2564:
                if (!str.equals("PT")) {
                    b8 = -1;
                } else {
                    b8 = 175;
                }
                break;
            case 2567:
                if (!str.equals("PW")) {
                    b8 = -1;
                } else {
                    b8 = 176;
                }
                break;
            case 2569:
                if (!str.equals("PY")) {
                    b8 = -1;
                } else {
                    b8 = 177;
                }
                break;
            case 2576:
                if (!str.equals("QA")) {
                    b8 = -1;
                } else {
                    b8 = 178;
                }
                break;
            case 2611:
                if (!str.equals("RE")) {
                    b8 = -1;
                } else {
                    b8 = 179;
                }
                break;
            case 2621:
                if (!str.equals("RO")) {
                    b8 = -1;
                } else {
                    b8 = 180;
                }
                break;
            case 2625:
                if (!str.equals("RS")) {
                    b8 = -1;
                } else {
                    b8 = 181;
                }
                break;
            case 2627:
                if (!str.equals("RU")) {
                    b8 = -1;
                } else {
                    b8 = 182;
                }
                break;
            case 2629:
                if (!str.equals("RW")) {
                    b8 = -1;
                } else {
                    b8 = 183;
                }
                break;
            case 2638:
                if (!str.equals("SA")) {
                    b8 = -1;
                } else {
                    b8 = 184;
                }
                break;
            case 2639:
                if (!str.equals("SB")) {
                    b8 = -1;
                } else {
                    b8 = 185;
                }
                break;
            case 2640:
                if (!str.equals("SC")) {
                    b8 = -1;
                } else {
                    b8 = 186;
                }
                break;
            case 2641:
                if (!str.equals("SD")) {
                    b8 = -1;
                } else {
                    b8 = 187;
                }
                break;
            case 2642:
                if (!str.equals("SE")) {
                    b8 = -1;
                } else {
                    b8 = 188;
                }
                break;
            case 2644:
                if (!str.equals("SG")) {
                    b8 = -1;
                } else {
                    b8 = 189;
                }
                break;
            case 2645:
                if (!str.equals("SH")) {
                    b8 = -1;
                } else {
                    b8 = 190;
                }
                break;
            case 2646:
                if (!str.equals("SI")) {
                    b8 = -1;
                } else {
                    b8 = 191;
                }
                break;
            case 2647:
                if (!str.equals("SJ")) {
                    b8 = -1;
                } else {
                    b8 = 192;
                }
                break;
            case 2648:
                if (!str.equals("SK")) {
                    b8 = -1;
                } else {
                    b8 = 193;
                }
                break;
            case 2649:
                if (!str.equals("SL")) {
                    b8 = -1;
                } else {
                    b8 = 194;
                }
                break;
            case 2650:
                if (!str.equals("SM")) {
                    b8 = -1;
                } else {
                    b8 = 195;
                }
                break;
            case 2651:
                if (!str.equals("SN")) {
                    b8 = -1;
                } else {
                    b8 = 196;
                }
                break;
            case 2652:
                if (!str.equals("SO")) {
                    b8 = -1;
                } else {
                    b8 = 197;
                }
                break;
            case 2655:
                if (!str.equals("SR")) {
                    b8 = -1;
                } else {
                    b8 = 198;
                }
                break;
            case 2656:
                if (!str.equals("SS")) {
                    b8 = -1;
                } else {
                    b8 = 199;
                }
                break;
            case 2657:
                if (!str.equals("ST")) {
                    b8 = -1;
                } else {
                    b8 = 200;
                }
                break;
            case 2659:
                if (!str.equals("SV")) {
                    b8 = -1;
                } else {
                    b8 = 201;
                }
                break;
            case 2661:
                if (!str.equals("SX")) {
                    b8 = -1;
                } else {
                    b8 = 202;
                }
                break;
            case 2662:
                if (!str.equals("SY")) {
                    b8 = -1;
                } else {
                    b8 = 203;
                }
                break;
            case 2663:
                if (!str.equals("SZ")) {
                    b8 = -1;
                } else {
                    b8 = 204;
                }
                break;
            case 2671:
                if (!str.equals("TC")) {
                    b8 = -1;
                } else {
                    b8 = 205;
                }
                break;
            case 2672:
                if (!str.equals("TD")) {
                    b8 = -1;
                } else {
                    b8 = 206;
                }
                break;
            case 2675:
                if (!str.equals("TG")) {
                    b8 = -1;
                } else {
                    b8 = 207;
                }
                break;
            case 2676:
                if (!str.equals("TH")) {
                    b8 = -1;
                } else {
                    b8 = 208;
                }
                break;
            case 2678:
                if (!str.equals("TJ")) {
                    b8 = -1;
                } else {
                    b8 = 209;
                }
                break;
            case 2680:
                if (!str.equals("TL")) {
                    b8 = -1;
                } else {
                    b8 = 210;
                }
                break;
            case 2681:
                if (!str.equals("TM")) {
                    b8 = -1;
                } else {
                    b8 = 211;
                }
                break;
            case 2682:
                if (!str.equals("TN")) {
                    b8 = -1;
                } else {
                    b8 = 212;
                }
                break;
            case 2683:
                if (!str.equals("TO")) {
                    b8 = -1;
                } else {
                    b8 = 213;
                }
                break;
            case 2686:
                if (!str.equals("TR")) {
                    b8 = -1;
                } else {
                    b8 = 214;
                }
                break;
            case 2688:
                if (!str.equals("TT")) {
                    b8 = -1;
                } else {
                    b8 = 215;
                }
                break;
            case 2690:
                if (!str.equals("TV")) {
                    b8 = -1;
                } else {
                    b8 = 216;
                }
                break;
            case 2691:
                if (!str.equals("TW")) {
                    b8 = -1;
                } else {
                    b8 = 217;
                }
                break;
            case 2694:
                if (!str.equals("TZ")) {
                    b8 = -1;
                } else {
                    b8 = 218;
                }
                break;
            case 2700:
                if (!str.equals("UA")) {
                    b8 = -1;
                } else {
                    b8 = 219;
                }
                break;
            case 2706:
                if (!str.equals("UG")) {
                    b8 = -1;
                } else {
                    b8 = 220;
                }
                break;
            case 2718:
                if (!str.equals("US")) {
                    b8 = -1;
                } else {
                    b8 = 221;
                }
                break;
            case 2724:
                if (!str.equals("UY")) {
                    b8 = -1;
                } else {
                    b8 = 222;
                }
                break;
            case 2725:
                if (!str.equals("UZ")) {
                    b8 = -1;
                } else {
                    b8 = 223;
                }
                break;
            case 2731:
                if (!str.equals("VA")) {
                    b8 = -1;
                } else {
                    b8 = 224;
                }
                break;
            case 2733:
                if (!str.equals("VC")) {
                    b8 = -1;
                } else {
                    b8 = 225;
                }
                break;
            case 2735:
                if (!str.equals("VE")) {
                    b8 = -1;
                } else {
                    b8 = 226;
                }
                break;
            case 2737:
                if (!str.equals("VG")) {
                    b8 = -1;
                } else {
                    b8 = 227;
                }
                break;
            case 2739:
                if (!str.equals("VI")) {
                    b8 = -1;
                } else {
                    b8 = 228;
                }
                break;
            case 2744:
                if (!str.equals("VN")) {
                    b8 = -1;
                } else {
                    b8 = 229;
                }
                break;
            case 2751:
                if (!str.equals("VU")) {
                    b8 = -1;
                } else {
                    b8 = 230;
                }
                break;
            case 2767:
                if (!str.equals("WF")) {
                    b8 = -1;
                } else {
                    b8 = 231;
                }
                break;
            case 2780:
                if (!str.equals("WS")) {
                    b8 = -1;
                } else {
                    b8 = 232;
                }
                break;
            case 2803:
                if (!str.equals("XK")) {
                    b8 = -1;
                } else {
                    b8 = 233;
                }
                break;
            case 2828:
                if (!str.equals("YE")) {
                    b8 = -1;
                } else {
                    b8 = 234;
                }
                break;
            case 2843:
                if (!str.equals("YT")) {
                    b8 = -1;
                } else {
                    b8 = 235;
                }
                break;
            case 2855:
                if (!str.equals("ZA")) {
                    b8 = -1;
                } else {
                    b8 = 236;
                }
                break;
            case 2867:
                if (!str.equals("ZM")) {
                    b8 = -1;
                } else {
                    b8 = 237;
                }
                break;
            case 2877:
                if (!str.equals("ZW")) {
                    b8 = -1;
                } else {
                    b8 = 238;
                }
                break;
            default:
                b8 = -1;
                break;
        }
        switch (b8) {
            case 0:
            case 4:
            case 17:
            case 29:
            case DefaultRenderersFactory.MAX_DROPPED_VIDEO_FRAME_COUNT_TO_NOTIFY:
            case Opcodes.DSTORE:
            case 113:
            case AppInfoTableDecoder.APPLICATION_INFORMATION_TABLE_ID:
            case 202:
            case 225:
                return new int[]{1, 2, 0, 0, 2, 2};
            case 1:
                return new int[]{1, 4, 2, 3, 4, 1};
            case 2:
            case 204:
                return new int[]{4, 4, 3, 4, 2, 2};
            case 3:
            case BuildConfig.VERSION_CODE:
                return new int[]{2, 4, 3, 4, 2, 2};
            case 5:
                return new int[]{1, 1, 1, 2, 2, 2};
            case 6:
            case Opcodes.IF_ACMPEQ:
                return new int[]{2, 3, 2, 3, 2, 2};
            case 7:
                return new int[]{3, 4, 4, 3, 2, 2};
            case 8:
            case 63:
            case Opcodes.IF_ICMPGE:
            case 186:
            case 190:
                return new int[]{4, 2, 2, 2, 2, 2};
            case 9:
                return new int[]{2, 2, 2, 2, 1, 2};
            case 10:
                return new int[]{2, 2, 3, 3, 2, 2};
            case 11:
            case 61:
            case 93:
            case 102:
            case 127:
            case 145:
            case 188:
                return new int[]{0, 0, 0, 0, 0, 2};
            case 12:
                return new int[]{0, 3, 1, 1, 3, 0};
            case 13:
                return new int[]{2, 2, 3, 4, 2, 2};
            case 14:
            case 51:
            case 121:
            case 144:
            case TsExtractor.TS_STREAM_TYPE_AC4:
            case 195:
            case 224:
                return new int[]{0, 2, 2, 2, 2, 2};
            case 15:
            case Opcodes.LSTORE:
            case 128:
            case 194:
                return new int[]{4, 2, 3, 3, 2, 2};
            case 16:
            case 106:
            case 214:
                return new int[]{1, 1, 1, 1, 2, 2};
            case 18:
                return new int[]{2, 1, 3, 2, 4, 2};
            case 19:
                return new int[]{0, 0, 1, 0, 1, 2};
            case 20:
            case Opcodes.NEW:
            case 203:
            case 206:
                return new int[]{4, 3, 4, 4, 2, 2};
            case 21:
            case 175:
            case 191:
                return new int[]{0, 0, 0, 0, 1, 2};
            case 22:
                return new int[]{1, 3, 1, 3, 4, 2};
            case 23:
            case 84:
            case 92:
            case Opcodes.IFNE:
            case 226:
            case 234:
                return new int[]{4, 4, 4, 4, 2, 2};
            case 24:
                return new int[]{4, 4, 2, 3, 2, 2};
            case 25:
            case 141:
            case Opcodes.RETURN:
                return new int[]{1, 2, 2, 2, 2, 2};
            case 26:
                return new int[]{0, 2, 0, 0, 2, 2};
            case 27:
                return new int[]{3, 2, 0, 0, 2, 2};
            case 28:
                return new int[]{1, 2, 4, 4, 2, 2};
            case 30:
                return new int[]{1, 1, 1, 1, 2, 4};
            case 31:
                return new int[]{3, 2, 1, 1, 2, 2};
            case 32:
                return new int[]{3, 1, 2, 2, 3, 2};
            case 33:
                return new int[]{3, 2, 1, 0, 2, 2};
            case 34:
                return new int[]{1, 2, 3, 3, 2, 2};
            case 35:
            case AacUtil.AUDIO_OBJECT_TYPE_AAC_XHE:
                return new int[]{2, 2, 2, 1, 2, 2};
            case TsExtractor.TS_STREAM_TYPE_H265:
            case 219:
                return new int[]{0, 2, 1, 2, 3, 3};
            case 37:
            case 137:
                return new int[]{3, 3, 2, 2, 2, 2};
            case FlacConstants.STREAM_INFO_BLOCK_SIZE:
                return new int[]{4, 2, 4, 2, 2, 2};
            case NalUnitUtil.H265_NAL_UNIT_TYPE_PREFIX_SEI:
            case 62:
            case TsExtractor.TS_STREAM_TYPE_SPLICE_INFO:
                return new int[]{3, 4, 3, 3, 2, 2};
            case NalUnitUtil.H265_NAL_UNIT_TYPE_SUFFIX_SEI:
                return new int[]{0, 1, 0, 0, 0, 2};
            case 43:
            case 208:
                return new int[]{0, 1, 2, 2, 2, 2};
            case 44:
            case 143:
                return new int[]{4, 3, 3, 4, 2, 2};
            case TsExtractor.TS_STREAM_TYPE_MHAS:
                return new int[]{2, 0, 1, 1, 3, 1};
            case 46:
                return new int[]{2, 3, 3, 2, 2, 2};
            case 47:
            case 157:
                return new int[]{2, 4, 4, 4, 2, 2};
            case NalUnitUtil.H265_NAL_UNIT_TYPE_UNSPECIFIED:
            case 111:
            case Opcodes.IF_ICMPLT:
            case 210:
                return new int[]{4, 2, 4, 4, 2, 2};
            case Opcodes.V1_5:
                return new int[]{2, 3, 0, 1, 2, 2};
            case 52:
                return new int[]{1, 0, 1, 0, 0, 2};
            case 53:
                return new int[]{0, 0, 2, 0, 1, 2};
            case Opcodes.ISTORE:
                return new int[]{0, 1, 4, 2, 2, 1};
            case Opcodes.FSTORE:
                return new int[]{0, 0, 2, 0, 0, 2};
            case Opcodes.ASTORE:
            case 123:
                return new int[]{3, 4, 4, 4, 2, 2};
            case 59:
            case 209:
                return new int[]{3, 3, 4, 4, 2, 2};
            case 60:
                return new int[]{1, 3, 2, 1, 2, 2};
            case 64:
                return new int[]{0, 0, 0, 0, 1, 0};
            case 65:
                return new int[]{4, 3, 4, 4, 4, 2};
            case 66:
                return new int[]{0, 0, 0, 1, 0, 2};
            case MdtaMetadataEntry.TYPE_INDICATOR_INT32:
                return new int[]{3, 2, 2, 3, 2, 2};
            case 68:
            case 155:
            case 192:
                return new int[]{3, 2, 2, 2, 2, 2};
            case 69:
                return new int[]{4, 2, 4, 0, 2, 2};
            case 70:
                return new int[]{0, 2, 2, 0, 2, 2};
            case TsExtractor.TS_SYNC_BYTE:
                return new int[]{1, 1, 1, 1, 0, 2};
            case 72:
                return new int[]{3, 4, 0, 0, 2, 2};
            case 73:
                return new int[]{1, 1, 3, 2, 2, 2};
            case 74:
                return new int[]{2, 2, 0, 0, 2, 2};
            case MdtaMetadataEntry.TYPE_INDICATOR_8_BIT_UNSIGNED_INT:
                return new int[]{1, 1, 0, 2, 2, 2};
            case 76:
                return new int[]{3, 2, 3, 3, 2, 2};
            case 77:
                return new int[]{0, 2, 1, 1, 2, 2};
            case MdtaMetadataEntry.TYPE_INDICATOR_UNSIGNED_INT64:
                return new int[]{3, 3, 3, 2, 2, 2};
            case Opcodes.IASTORE:
            case 97:
            case 104:
                return new int[]{0, 2, 0, 1, 2, 2};
            case 80:
            case TsExtractor.TS_STREAM_TYPE_HDMV_DTS:
                return new int[]{1, 2, 2, 0, 2, 2};
            case 81:
            case Opcodes.IFNONNULL:
                return new int[]{4, 3, 2, 4, 2, 2};
            case 82:
                return new int[]{3, 4, 4, 2, 2, 2};
            case 83:
                return new int[]{2, 1, 1, 3, 2, 2};
            case 85:
                return new int[]{1, 0, 0, 0, 1, 2};
            case 86:
                return new int[]{2, 1, 2, 1, 2, 2};
            case Opcodes.POP:
                return new int[]{2, 2, 4, 3, 3, 2};
            case 88:
                return new int[]{4, 4, 1, 2, 2, 2};
            case 89:
                return new int[]{3, 1, 1, 3, 2, 2};
            case 90:
                return new int[]{0, 1, 0, 1, 1, 0};
            case 91:
            case 115:
                return new int[]{1, 0, 0, 0, 0, 2};
            case 94:
                return new int[]{3, 1, 3, 3, 2, 4};
            case 95:
                return new int[]{1, 1, 1, 1, 1, 2};
            case Opcodes.IADD:
                return new int[]{1, 2, 2, 3, 4, 2};
            case 98:
                return new int[]{1, 1, 3, 2, 2, 3};
            case 99:
                return new int[]{3, 2, 2, 0, 2, 2};
            case 100:
                return new int[]{3, 2, 3, 2, 2, 2};
            case 101:
                return new int[]{4, 2, 3, 3, 4, 3};
            case 103:
                return new int[]{0, 1, 1, 2, 1, 2};
            case 105:
                return new int[]{2, 4, 3, 1, 2, 2};
            case 107:
                return new int[]{0, 3, 2, 3, 4, 2};
            case 108:
                return new int[]{3, 2, 1, 1, 1, 2};
            case 109:
                return new int[]{2, 1, 1, 2, 2, 2};
            case 110:
                return new int[]{1, 0, 4, 2, 2, 2};
            case 112:
            case 230:
                return new int[]{4, 3, 3, 2, 2, 2};
            case 114:
                return new int[]{0, 2, 2, 4, 4, 4};
            case 117:
                return new int[]{2, 1, 2, 2, 3, 2};
            case 118:
                return new int[]{1, 2, 1, 3, 2, 2};
            case 119:
                return new int[]{3, 1, 1, 2, 2, 2};
            case 120:
                return new int[]{2, 2, 1, 1, 2, 2};
            case 122:
            case TsExtractor.TS_STREAM_TYPE_DTS:
                return new int[]{3, 2, 3, 3, 4, 2};
            case 124:
            case 168:
                return new int[]{4, 3, 3, 3, 2, 2};
            case 125:
                return new int[]{0, 1, 0, 1, 0, 2};
            case 126:
                return new int[]{4, 0, 3, 2, 1, 3};
            case TsExtractor.TS_STREAM_TYPE_AC3:
                return new int[]{3, 3, 1, 1, 2, 2};
            case 131:
                return new int[]{1, 0, 0, 0, 2, 2};
            case 132:
                return new int[]{2, 0, 0, 1, 3, 2};
            case 133:
                return new int[]{1, 2, 2, 3, 2, 2};
            case TsExtractor.TS_STREAM_TYPE_E_AC3:
            case 211:
            case 216:
            case 231:
                return new int[]{4, 2, 2, 4, 2, 2};
            case TsExtractor.TS_STREAM_TYPE_DTS_HD:
                return new int[]{1, 0, 0, 1, 3, 2};
            case TsExtractor.TS_STREAM_TYPE_DTS_UHD:
                return new int[]{2, 0, 2, 2, 2, 2};
            case 140:
                return new int[]{0, 2, 4, 4, 3, 1};
            case 142:
                return new int[]{2, 1, 2, 3, 2, 2};
            case 146:
                return new int[]{3, 1, 0, 2, 2, 2};
            case 147:
                return new int[]{3, 2, 1, 3, 4, 2};
            case Opcodes.LCMP:
                return new int[]{3, 2, 2, 1, 2, 2};
            case Opcodes.FCMPL:
                return new int[]{2, 4, 4, 4, 3, 2};
            case 150:
                return new int[]{1, 0, 4, 1, 1, 0};
            case Opcodes.DCMPL:
            case 232:
                return new int[]{3, 1, 2, 2, 2, 2};
            case 152:
                return new int[]{3, 4, 3, 2, 2, 2};
            case Opcodes.IFEQ:
            case 235:
                return new int[]{2, 3, 3, 4, 2, 2};
            case 156:
                return new int[]{3, 4, 2, 1, 2, 2};
            case Opcodes.IFLE:
                return new int[]{2, 1, 4, 3, 0, 4};
            case Opcodes.IF_ICMPEQ:
                return new int[]{0, 0, 3, 0, 0, 2};
            case Opcodes.IF_ICMPNE:
                return new int[]{2, 2, 4, 3, 2, 2};
            case Opcodes.IF_ICMPGT:
                return new int[]{0, 0, 1, 2, 4, 2};
            case 164:
                return new int[]{2, 3, 1, 2, 4, 2};
            case Opcodes.IF_ACMPNE:
                return new int[]{1, 2, 4, 4, 3, 2};
            case Opcodes.GOTO:
                return new int[]{2, 2, 3, 1, 2, 2};
            case Opcodes.RET:
                return new int[]{2, 1, 2, 3, 2, 1};
            case 170:
                return new int[]{3, 3, 3, 3, 2, 2};
            case 171:
                return new int[]{1, 0, 2, 2, 4, 4};
            case 173:
                return new int[]{2, 0, 2, 1, 2, 0};
            case 174:
                return new int[]{3, 4, 1, 3, 2, 2};
            case Opcodes.ARETURN:
                return new int[]{2, 2, 4, 1, 2, 2};
            case Opcodes.GETSTATIC:
                return new int[]{1, 4, 4, 4, 4, 2};
            case 179:
                return new int[]{0, 3, 2, 3, 1, 2};
            case Opcodes.GETFIELD:
                return new int[]{0, 0, 1, 1, 3, 2};
            case Opcodes.PUTFIELD:
                return new int[]{1, 0, 0, 1, 2, 2};
            case Opcodes.INVOKEVIRTUAL:
                return new int[]{1, 0, 0, 1, 3, 3};
            case Opcodes.INVOKESPECIAL:
                return new int[]{3, 3, 2, 0, 2, 2};
            case Opcodes.INVOKESTATIC:
                return new int[]{3, 1, 1, 2, 2, 0};
            case Opcodes.INVOKEINTERFACE:
            case 238:
                return new int[]{4, 2, 4, 3, 2, 2};
            case PsExtractor.PRIVATE_STREAM_1:
                return new int[]{2, 3, 3, 3, 1, 1};
            case Opcodes.INSTANCEOF:
                return new int[]{0, 1, 1, 1, 2, 2};
            case 196:
                return new int[]{4, 4, 3, 2, 2, 2};
            case 197:
                return new int[]{2, 2, 3, 4, 4, 2};
            case Opcodes.IFNULL:
                return new int[]{2, 4, 4, 1, 2, 2};
            case 200:
                return new int[]{2, 2, 1, 2, 2, 2};
            case 201:
                return new int[]{2, 3, 2, 1, 2, 2};
            case 205:
                return new int[]{3, 2, 1, 2, 2, 2};
            case 207:
                return new int[]{3, 4, 1, 0, 2, 2};
            case 212:
                return new int[]{3, 1, 1, 1, 2, 2};
            case 213:
                return new int[]{3, 2, 4, 3, 2, 2};
            case 215:
                return new int[]{2, 4, 1, 0, 2, 2};
            case 217:
                return new int[]{0, 0, 0, 0, 0, 0};
            case 218:
                return new int[]{3, 4, 2, 1, 3, 2};
            case 220:
                return new int[]{3, 3, 2, 3, 4, 2};
            case 221:
                return new int[]{2, 2, 4, 1, 3, 1};
            case 222:
                return new int[]{2, 1, 1, 2, 1, 2};
            case 223:
                return new int[]{1, 2, 3, 4, 3, 2};
            case 227:
                return new int[]{2, 2, 1, 1, 2, 4};
            case 228:
                return new int[]{0, 2, 1, 2, 2, 2};
            case 229:
                return new int[]{0, 0, 1, 2, 2, 2};
            case 233:
                return new int[]{1, 2, 1, 1, 2, 2};
            case 236:
                return new int[]{2, 4, 2, 1, 1, 2};
            case 237:
                return new int[]{4, 4, 4, 3, 2, 2};
            default:
                return new int[]{2, 2, 2, 2, 2, 2};
        }
    }

    private long getInitialBitrateEstimateForNetworkType(int i6) {
        Long lValueOf = (Long) this.initialBitrateEstimates.get(Integer.valueOf(i6));
        if (lValueOf == null) {
            lValueOf = (Long) this.initialBitrateEstimates.get(0);
        } else if (lValueOf.longValue() == C0565C.TIME_UNSET) {
            lValueOf = Long.valueOf(getInitialBitrateEstimatesForCountry(this.countryCode, i6));
        }
        if (lValueOf == null) {
            lValueOf = 1000000L;
        }
        return lValueOf.longValue();
    }

    public static long getInitialBitrateEstimatesForCountry(String str, int i6) {
        int[] initialBitrateCountryGroupAssignment = getInitialBitrateCountryGroupAssignment(AbstractC1332b.m3230u(str));
        if (i6 != 2) {
            if (i6 == 3) {
                return ((Long) DEFAULT_INITIAL_BITRATE_ESTIMATES_2G.get(initialBitrateCountryGroupAssignment[1])).longValue();
            }
            if (i6 == 4) {
                return ((Long) DEFAULT_INITIAL_BITRATE_ESTIMATES_3G.get(initialBitrateCountryGroupAssignment[2])).longValue();
            }
            if (i6 == 5) {
                return ((Long) DEFAULT_INITIAL_BITRATE_ESTIMATES_4G.get(initialBitrateCountryGroupAssignment[3])).longValue();
            }
            if (i6 != 7) {
                if (i6 == 9) {
                    return ((Long) DEFAULT_INITIAL_BITRATE_ESTIMATES_5G_SA.get(initialBitrateCountryGroupAssignment[5])).longValue();
                }
                if (i6 != 10) {
                    return 1000000L;
                }
                return ((Long) DEFAULT_INITIAL_BITRATE_ESTIMATES_5G_NSA.get(initialBitrateCountryGroupAssignment[4])).longValue();
            }
        }
        return ((Long) DEFAULT_INITIAL_BITRATE_ESTIMATES_WIFI.get(initialBitrateCountryGroupAssignment[0])).longValue();
    }

    private static boolean isTransferAtFullNetworkSpeed(DataSpec dataSpec, boolean z7) {
        return z7 && !dataSpec.isFlagSet(8);
    }

    public synchronized void onNetworkTypeChanged(int i6) {
        int i10 = this.networkType;
        if (i10 == 0 || this.resetOnNetworkTypeChange) {
            if (this.networkTypeOverrideSet) {
                i6 = this.networkTypeOverride;
            }
            if (i10 != i6 || this.countryCode == null) {
                this.networkType = i6;
                if (i6 != 1 && i6 != 0 && i6 != 8) {
                    if (this.countryCode == null) {
                        this.countryCode = Util.getCountryCode(this.context);
                    }
                    long initialBitrateEstimateForNetworkType = getInitialBitrateEstimateForNetworkType(i6);
                    this.initialBitrateEstimate = initialBitrateEstimateForNetworkType;
                    this.bandwidthEstimator.onNetworkTypeChange(initialBitrateEstimateForNetworkType);
                    this.timeToFirstByteEstimator.reset();
                }
            }
        }
    }

    @Override
    public synchronized void addEventListener(Handler handler, BandwidthMeter.EventListener eventListener) {
        Assertions.checkNotNull(handler);
        Assertions.checkNotNull(eventListener);
        this.bandwidthEstimator.addEventListener(handler, eventListener);
    }

    @Override
    public synchronized long getBitrateEstimate() {
        long bandwidthEstimate;
        bandwidthEstimate = this.bandwidthEstimator.getBandwidthEstimate();
        if (bandwidthEstimate == Long.MIN_VALUE) {
            bandwidthEstimate = this.initialBitrateEstimate;
        }
        return bandwidthEstimate;
    }

    @Override
    public synchronized long getTimeToFirstByteEstimateUs() {
        return this.timeToFirstByteEstimator.getTimeToFirstByteEstimateUs();
    }

    @Override
    public synchronized void onBytesTransferred(DataSource dataSource, DataSpec dataSpec, boolean z7, int i6) {
        if (isTransferAtFullNetworkSpeed(dataSpec, z7)) {
            this.bandwidthEstimator.onBytesTransferred(dataSource, i6);
        }
    }

    @Override
    public synchronized void onTransferEnd(DataSource dataSource, DataSpec dataSpec, boolean z7) {
        if (isTransferAtFullNetworkSpeed(dataSpec, z7)) {
            this.bandwidthEstimator.onTransferEnd(dataSource);
        }
    }

    @Override
    public synchronized void onTransferInitializing(DataSource dataSource, DataSpec dataSpec, boolean z7) {
        if (isTransferAtFullNetworkSpeed(dataSpec, z7)) {
            this.timeToFirstByteEstimator.onTransferInitializing(dataSpec);
            this.bandwidthEstimator.onTransferInitializing(dataSource);
        }
    }

    @Override
    public synchronized void onTransferStart(DataSource dataSource, DataSpec dataSpec, boolean z7) {
        if (isTransferAtFullNetworkSpeed(dataSpec, z7)) {
            this.timeToFirstByteEstimator.onTransferStart(dataSpec);
            this.bandwidthEstimator.onTransferStart(dataSource);
        }
    }

    @Override
    public synchronized void removeEventListener(BandwidthMeter.EventListener eventListener) {
        this.bandwidthEstimator.removeEventListener(eventListener);
    }

    public synchronized void setNetworkTypeOverride(int i6) {
        this.networkTypeOverride = i6;
        this.networkTypeOverrideSet = true;
        onNetworkTypeChanged(i6);
    }

    public static final class Builder {
        private final Context context;
        private final Map<Integer, Long> initialBitrateEstimates;
        private TimeToFirstByteEstimator timeToFirstByteEstimator = new PercentileTimeToFirstByteEstimator(20, 0.5f);
        private BandwidthEstimator bandwidthEstimator = new SplitParallelSampleBandwidthEstimator.Builder().build();
        private boolean resetOnNetworkTypeChange = true;

        public Builder(Context context) {
            this.context = context.getApplicationContext();
            HashMap map = new HashMap(8);
            this.initialBitrateEstimates = map;
            map.put(0, 1000000L);
            Long lValueOf = Long.valueOf(C0565C.TIME_UNSET);
            map.put(2, lValueOf);
            map.put(3, lValueOf);
            map.put(4, lValueOf);
            map.put(5, lValueOf);
            map.put(10, lValueOf);
            map.put(9, lValueOf);
            map.put(7, lValueOf);
        }

        public ExperimentalBandwidthMeter build() {
            return new ExperimentalBandwidthMeter(this.context, this.initialBitrateEstimates, this.timeToFirstByteEstimator, this.bandwidthEstimator, this.resetOnNetworkTypeChange);
        }

        public Builder setBandwidthEstimator(BandwidthEstimator bandwidthEstimator) {
            this.bandwidthEstimator = bandwidthEstimator;
            return this;
        }

        public Builder setInitialBitrateEstimate(long j10) {
            Iterator<Integer> it = this.initialBitrateEstimates.keySet().iterator();
            while (it.hasNext()) {
                setInitialBitrateEstimate(it.next().intValue(), j10);
            }
            return this;
        }

        public Builder setResetOnNetworkTypeChange(boolean z7) {
            this.resetOnNetworkTypeChange = z7;
            return this;
        }

        public Builder setTimeToFirstByteEstimator(TimeToFirstByteEstimator timeToFirstByteEstimator) {
            this.timeToFirstByteEstimator = timeToFirstByteEstimator;
            return this;
        }

        public Builder setInitialBitrateEstimate(int i6, long j10) {
            this.initialBitrateEstimates.put(Integer.valueOf(i6), Long.valueOf(j10));
            return this;
        }

        public Builder setInitialBitrateEstimate(String str) {
            String strM3233x = AbstractC1332b.m3233x(str);
            for (Integer num : this.initialBitrateEstimates.keySet()) {
                setInitialBitrateEstimate(num.intValue(), ExperimentalBandwidthMeter.getInitialBitrateEstimatesForCountry(strM3233x, num.intValue()));
            }
            return this;
        }
    }

    private ExperimentalBandwidthMeter(Context context, Map<Integer, Long> map, TimeToFirstByteEstimator timeToFirstByteEstimator, BandwidthEstimator bandwidthEstimator, boolean z7) {
        this.context = context == null ? null : context.getApplicationContext();
        this.initialBitrateEstimates = AbstractC2331z1.m5296b(map);
        this.timeToFirstByteEstimator = timeToFirstByteEstimator;
        this.bandwidthEstimator = bandwidthEstimator;
        this.resetOnNetworkTypeChange = z7;
        NetworkTypeObserver networkTypeObserver = NetworkTypeObserver.getInstance(context);
        int networkType = networkTypeObserver.getNetworkType();
        this.networkType = networkType;
        this.initialBitrateEstimate = getInitialBitrateEstimateForNetworkType(networkType);
        networkTypeObserver.register(new C0962f(1, this), BackgroundExecutor.get());
    }

    @Override
    public TransferListener getTransferListener() {
        return this;
    }
}
