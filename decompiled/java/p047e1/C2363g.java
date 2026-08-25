package p047e1;

import android.content.res.AssetManager;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.system.OsConstants;
import android.util.Log;
import androidx.media3.extractor.p010ts.TsExtractor;
import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.regex.Pattern;
import java.util.zip.CRC32;
import p000a.AbstractC0004e;
import p187r4.AbstractC3612b;

public final class C2363g {

    public static final byte[] f8240A;

    public static final String[] f8241B;

    public static final int[] f8242C;

    public static final byte[] f8243D;

    public static final C2360d f8244E;

    public static final C2360d[][] f8245F;

    public static final C2360d[] f8246G;

    public static final HashMap[] f8247H;

    public static final HashMap[] f8248I;

    public static final HashSet f8249J;

    public static final HashMap f8250K;

    public static final Charset f8251L;

    public static final byte[] f8252M;

    public static final byte[] f8253N;

    public static final boolean f8254l = Log.isLoggable("ExifInterface", 3);

    public static final int[] f8255m;

    public static final int[] f8256n;

    public static final byte[] f8257o;

    public static final byte[] f8258p;

    public static final byte[] f8259q;

    public static final byte[] f8260r;

    public static final byte[] f8261s;

    public static final byte[] f8262t;

    public static final byte[] f8263u;

    public static final byte[] f8264v;

    public static final byte[] f8265w;

    public static final byte[] f8266x;

    public static final byte[] f8267y;

    public static final byte[] f8268z;

    public final FileDescriptor f8269a;

    public final AssetManager.AssetInputStream f8270b;

    public int f8271c;

    public final HashMap[] f8272d;

    public final HashSet f8273e;

    public ByteOrder f8274f;

    public boolean f8275g;

    public int f8276h;

    public int f8277i;

    public int f8278j;

    public int f8279k;

    static {
        Arrays.asList(1, 6, 3, 8);
        Arrays.asList(2, 7, 4, 5);
        f8255m = new int[]{8, 8, 8};
        f8256n = new int[]{8};
        f8257o = new byte[]{-1, -40, -1};
        f8258p = new byte[]{102, 116, 121, 112};
        f8259q = new byte[]{109, 105, 102, 49};
        f8260r = new byte[]{104, 101, 105, 99};
        f8261s = new byte[]{79, 76, 89, 77, 80, 0};
        f8262t = new byte[]{79, 76, 89, 77, 80, 85, 83, 0, 73, 73};
        f8263u = new byte[]{-119, 80, 78, 71, 13, 10, 26, 10};
        f8264v = new byte[]{101, 88, 73, 102};
        f8265w = new byte[]{73, 72, 68, 82};
        f8266x = new byte[]{73, 69, 78, 68};
        f8267y = new byte[]{82, 73, 70, 70};
        f8268z = new byte[]{87, 69, 66, 80};
        f8240A = new byte[]{69, 88, 73, 70};
        "VP8X".getBytes(Charset.defaultCharset());
        "VP8L".getBytes(Charset.defaultCharset());
        "VP8 ".getBytes(Charset.defaultCharset());
        "ANIM".getBytes(Charset.defaultCharset());
        "ANMF".getBytes(Charset.defaultCharset());
        f8241B = new String[]{"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE", "IFD"};
        f8242C = new int[]{0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};
        f8243D = new byte[]{65, 83, 67, 73, 73, 0, 0, 0};
        C2360d[] c2360dArr = {new C2360d("NewSubfileType", 254, 4), new C2360d("SubfileType", 255, 4), new C2360d(256, "ImageWidth", 3, 4), new C2360d(TsExtractor.TS_STREAM_TYPE_AIT, "ImageLength", 3, 4), new C2360d("BitsPerSample", 258, 3), new C2360d("Compression", 259, 3), new C2360d("PhotometricInterpretation", 262, 3), new C2360d("ImageDescription", 270, 2), new C2360d("Make", 271, 2), new C2360d("Model", 272, 2), new C2360d(273, "StripOffsets", 3, 4), new C2360d("Orientation", 274, 3), new C2360d("SamplesPerPixel", 277, 3), new C2360d(278, "RowsPerStrip", 3, 4), new C2360d(279, "StripByteCounts", 3, 4), new C2360d("XResolution", 282, 5), new C2360d("YResolution", 283, 5), new C2360d("PlanarConfiguration", 284, 3), new C2360d("ResolutionUnit", 296, 3), new C2360d("TransferFunction", 301, 3), new C2360d("Software", 305, 2), new C2360d("DateTime", 306, 2), new C2360d("Artist", 315, 2), new C2360d("WhitePoint", 318, 5), new C2360d("PrimaryChromaticities", 319, 5), new C2360d("SubIFDPointer", 330, 4), new C2360d("JPEGInterchangeFormat", 513, 4), new C2360d("JPEGInterchangeFormatLength", 514, 4), new C2360d("YCbCrCoefficients", 529, 5), new C2360d("YCbCrSubSampling", 530, 3), new C2360d("YCbCrPositioning", 531, 3), new C2360d("ReferenceBlackWhite", 532, 5), new C2360d("Copyright", 33432, 2), new C2360d("ExifIFDPointer", 34665, 4), new C2360d("GPSInfoIFDPointer", 34853, 4), new C2360d("SensorTopBorder", 4, 4), new C2360d("SensorLeftBorder", 5, 4), new C2360d("SensorBottomBorder", 6, 4), new C2360d("SensorRightBorder", 7, 4), new C2360d("ISO", 23, 3), new C2360d("JpgFromRaw", 46, 7), new C2360d("Xmp", 700, 1)};
        C2360d[] c2360dArr2 = {new C2360d("ExposureTime", 33434, 5), new C2360d("FNumber", 33437, 5), new C2360d("ExposureProgram", 34850, 3), new C2360d("SpectralSensitivity", 34852, 2), new C2360d("PhotographicSensitivity", 34855, 3), new C2360d("OECF", 34856, 7), new C2360d("SensitivityType", 34864, 3), new C2360d("StandardOutputSensitivity", 34865, 4), new C2360d("RecommendedExposureIndex", 34866, 4), new C2360d("ISOSpeed", 34867, 4), new C2360d("ISOSpeedLatitudeyyy", 34868, 4), new C2360d("ISOSpeedLatitudezzz", 34869, 4), new C2360d("ExifVersion", 36864, 2), new C2360d("DateTimeOriginal", 36867, 2), new C2360d("DateTimeDigitized", 36868, 2), new C2360d("OffsetTime", 36880, 2), new C2360d("OffsetTimeOriginal", 36881, 2), new C2360d("OffsetTimeDigitized", 36882, 2), new C2360d("ComponentsConfiguration", 37121, 7), new C2360d("CompressedBitsPerPixel", 37122, 5), new C2360d("ShutterSpeedValue", 37377, 10), new C2360d("ApertureValue", 37378, 5), new C2360d("BrightnessValue", 37379, 10), new C2360d("ExposureBiasValue", 37380, 10), new C2360d("MaxApertureValue", 37381, 5), new C2360d("SubjectDistance", 37382, 5), new C2360d("MeteringMode", 37383, 3), new C2360d("LightSource", 37384, 3), new C2360d("Flash", 37385, 3), new C2360d("FocalLength", 37386, 5), new C2360d("SubjectArea", 37396, 3), new C2360d("MakerNote", 37500, 7), new C2360d("UserComment", 37510, 7), new C2360d("SubSecTime", 37520, 2), new C2360d("SubSecTimeOriginal", 37521, 2), new C2360d("SubSecTimeDigitized", 37522, 2), new C2360d("FlashpixVersion", 40960, 7), new C2360d("ColorSpace", 40961, 3), new C2360d(40962, "PixelXDimension", 3, 4), new C2360d(40963, "PixelYDimension", 3, 4), new C2360d("RelatedSoundFile", 40964, 2), new C2360d("InteroperabilityIFDPointer", 40965, 4), new C2360d("FlashEnergy", 41483, 5), new C2360d("SpatialFrequencyResponse", 41484, 7), new C2360d("FocalPlaneXResolution", 41486, 5), new C2360d("FocalPlaneYResolution", 41487, 5), new C2360d("FocalPlaneResolutionUnit", 41488, 3), new C2360d("SubjectLocation", 41492, 3), new C2360d("ExposureIndex", 41493, 5), new C2360d("SensingMethod", 41495, 3), new C2360d("FileSource", 41728, 7), new C2360d("SceneType", 41729, 7), new C2360d("CFAPattern", 41730, 7), new C2360d("CustomRendered", 41985, 3), new C2360d("ExposureMode", 41986, 3), new C2360d("WhiteBalance", 41987, 3), new C2360d("DigitalZoomRatio", 41988, 5), new C2360d("FocalLengthIn35mmFilm", 41989, 3), new C2360d("SceneCaptureType", 41990, 3), new C2360d("GainControl", 41991, 3), new C2360d("Contrast", 41992, 3), new C2360d("Saturation", 41993, 3), new C2360d("Sharpness", 41994, 3), new C2360d("DeviceSettingDescription", 41995, 7), new C2360d("SubjectDistanceRange", 41996, 3), new C2360d("ImageUniqueID", 42016, 2), new C2360d("CameraOwnerName", 42032, 2), new C2360d("BodySerialNumber", 42033, 2), new C2360d("LensSpecification", 42034, 5), new C2360d("LensMake", 42035, 2), new C2360d("LensModel", 42036, 2), new C2360d("Gamma", 42240, 5), new C2360d("DNGVersion", 50706, 1), new C2360d(50720, "DefaultCropSize", 3, 4)};
        C2360d[] c2360dArr3 = {new C2360d("GPSVersionID", 0, 1), new C2360d("GPSLatitudeRef", 1, 2), new C2360d(2, "GPSLatitude", 5, 10), new C2360d("GPSLongitudeRef", 3, 2), new C2360d(4, "GPSLongitude", 5, 10), new C2360d("GPSAltitudeRef", 5, 1), new C2360d("GPSAltitude", 6, 5), new C2360d("GPSTimeStamp", 7, 5), new C2360d("GPSSatellites", 8, 2), new C2360d("GPSStatus", 9, 2), new C2360d("GPSMeasureMode", 10, 2), new C2360d("GPSDOP", 11, 5), new C2360d("GPSSpeedRef", 12, 2), new C2360d("GPSSpeed", 13, 5), new C2360d("GPSTrackRef", 14, 2), new C2360d("GPSTrack", 15, 5), new C2360d("GPSImgDirectionRef", 16, 2), new C2360d("GPSImgDirection", 17, 5), new C2360d("GPSMapDatum", 18, 2), new C2360d("GPSDestLatitudeRef", 19, 2), new C2360d("GPSDestLatitude", 20, 5), new C2360d("GPSDestLongitudeRef", 21, 2), new C2360d("GPSDestLongitude", 22, 5), new C2360d("GPSDestBearingRef", 23, 2), new C2360d("GPSDestBearing", 24, 5), new C2360d("GPSDestDistanceRef", 25, 2), new C2360d("GPSDestDistance", 26, 5), new C2360d("GPSProcessingMethod", 27, 7), new C2360d("GPSAreaInformation", 28, 7), new C2360d("GPSDateStamp", 29, 2), new C2360d("GPSDifferential", 30, 3), new C2360d("GPSHPositioningError", 31, 5)};
        C2360d[] c2360dArr4 = {new C2360d("InteroperabilityIndex", 1, 2)};
        C2360d[] c2360dArr5 = {new C2360d("NewSubfileType", 254, 4), new C2360d("SubfileType", 255, 4), new C2360d(256, "ThumbnailImageWidth", 3, 4), new C2360d(TsExtractor.TS_STREAM_TYPE_AIT, "ThumbnailImageLength", 3, 4), new C2360d("BitsPerSample", 258, 3), new C2360d("Compression", 259, 3), new C2360d("PhotometricInterpretation", 262, 3), new C2360d("ImageDescription", 270, 2), new C2360d("Make", 271, 2), new C2360d("Model", 272, 2), new C2360d(273, "StripOffsets", 3, 4), new C2360d("ThumbnailOrientation", 274, 3), new C2360d("SamplesPerPixel", 277, 3), new C2360d(278, "RowsPerStrip", 3, 4), new C2360d(279, "StripByteCounts", 3, 4), new C2360d("XResolution", 282, 5), new C2360d("YResolution", 283, 5), new C2360d("PlanarConfiguration", 284, 3), new C2360d("ResolutionUnit", 296, 3), new C2360d("TransferFunction", 301, 3), new C2360d("Software", 305, 2), new C2360d("DateTime", 306, 2), new C2360d("Artist", 315, 2), new C2360d("WhitePoint", 318, 5), new C2360d("PrimaryChromaticities", 319, 5), new C2360d("SubIFDPointer", 330, 4), new C2360d("JPEGInterchangeFormat", 513, 4), new C2360d("JPEGInterchangeFormatLength", 514, 4), new C2360d("YCbCrCoefficients", 529, 5), new C2360d("YCbCrSubSampling", 530, 3), new C2360d("YCbCrPositioning", 531, 3), new C2360d("ReferenceBlackWhite", 532, 5), new C2360d("Copyright", 33432, 2), new C2360d("ExifIFDPointer", 34665, 4), new C2360d("GPSInfoIFDPointer", 34853, 4), new C2360d("DNGVersion", 50706, 1), new C2360d(50720, "DefaultCropSize", 3, 4)};
        f8244E = new C2360d("StripOffsets", 273, 3);
        f8245F = new C2360d[][]{c2360dArr, c2360dArr2, c2360dArr3, c2360dArr4, c2360dArr5, c2360dArr, new C2360d[]{new C2360d("ThumbnailImage", 256, 7), new C2360d("CameraSettingsIFDPointer", 8224, 4), new C2360d("ImageProcessingIFDPointer", 8256, 4)}, new C2360d[]{new C2360d("PreviewImageStart", TsExtractor.TS_STREAM_TYPE_AIT, 4), new C2360d("PreviewImageLength", 258, 4)}, new C2360d[]{new C2360d("AspectFrame", 4371, 3)}, new C2360d[]{new C2360d("ColorSpace", 55, 3)}};
        f8246G = new C2360d[]{new C2360d("SubIFDPointer", 330, 4), new C2360d("ExifIFDPointer", 34665, 4), new C2360d("GPSInfoIFDPointer", 34853, 4), new C2360d("InteroperabilityIFDPointer", 40965, 4), new C2360d("CameraSettingsIFDPointer", 8224, 1), new C2360d("ImageProcessingIFDPointer", 8256, 1)};
        f8247H = new HashMap[10];
        f8248I = new HashMap[10];
        f8249J = new HashSet(Arrays.asList("FNumber", "DigitalZoomRatio", "ExposureTime", "SubjectDistance", "GPSTimeStamp"));
        f8250K = new HashMap();
        Charset charsetForName = Charset.forName("US-ASCII");
        f8251L = charsetForName;
        f8252M = "Exif\u0000\u0000".getBytes(charsetForName);
        f8253N = "http://ns.adobe.com/xap/1.0/\u0000".getBytes(charsetForName);
        Locale locale = Locale.US;
        new SimpleDateFormat("yyyy:MM:dd HH:mm:ss", locale).setTimeZone(TimeZone.getTimeZone("UTC"));
        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", locale).setTimeZone(TimeZone.getTimeZone("UTC"));
        int i6 = 0;
        while (true) {
            C2360d[][] c2360dArr6 = f8245F;
            if (i6 >= c2360dArr6.length) {
                HashMap map = f8250K;
                C2360d[] c2360dArr7 = f8246G;
                map.put(Integer.valueOf(c2360dArr7[0].f8234a), 5);
                map.put(Integer.valueOf(c2360dArr7[1].f8234a), 1);
                map.put(Integer.valueOf(c2360dArr7[2].f8234a), 2);
                map.put(Integer.valueOf(c2360dArr7[3].f8234a), 3);
                map.put(Integer.valueOf(c2360dArr7[4].f8234a), 7);
                map.put(Integer.valueOf(c2360dArr7[5].f8234a), 8);
                Pattern.compile(".*[1-9].*");
                Pattern.compile("^(\\d{2}):(\\d{2}):(\\d{2})$");
                Pattern.compile("^(\\d{4}):(\\d{2}):(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
                Pattern.compile("^(\\d{4})-(\\d{2})-(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
                return;
            }
            f8247H[i6] = new HashMap();
            f8248I[i6] = new HashMap();
            for (C2360d c2360d : c2360dArr6[i6]) {
                f8247H[i6].put(Integer.valueOf(c2360d.f8234a), c2360d);
                f8248I[i6].put(c2360d.f8235b, c2360d);
            }
            i6++;
        }
    }

    public C2363g(InputStream inputStream) throws IOException {
        C2360d[][] c2360dArr = f8245F;
        this.f8272d = new HashMap[c2360dArr.length];
        this.f8273e = new HashSet(c2360dArr.length);
        this.f8274f = ByteOrder.BIG_ENDIAN;
        boolean z7 = inputStream instanceof AssetManager.AssetInputStream;
        boolean z10 = f8254l;
        if (z7) {
            this.f8270b = (AssetManager.AssetInputStream) inputStream;
            this.f8269a = null;
        } else if (inputStream instanceof FileInputStream) {
            FileInputStream fileInputStream = (FileInputStream) inputStream;
            try {
                AbstractC2364h.m5376c(fileInputStream.getFD(), 0L, OsConstants.SEEK_CUR);
                this.f8270b = null;
                this.f8269a = fileInputStream.getFD();
            } catch (Exception unused) {
                if (z10) {
                    Log.d("ExifInterface", "The file descriptor for the given input is not seekable");
                }
                this.f8270b = null;
                this.f8269a = null;
            }
        } else {
            this.f8270b = null;
            this.f8269a = null;
        }
        for (int i6 = 0; i6 < c2360dArr.length; i6++) {
            try {
                try {
                    this.f8272d[i6] = new HashMap();
                } catch (Throwable th) {
                    m5350a();
                    if (z10) {
                        m5366q();
                    }
                    throw th;
                }
            } catch (IOException e5) {
                e = e5;
                if (z10) {
                    Log.w("ExifInterface", "Invalid image: ExifInterface got an unsupported image format file(ExifInterface supports JPEG and some RAW image formats only) or a corrupted JPEG file to ExifInterface.", e);
                }
                m5350a();
                if (!z10) {
                    return;
                }
            } catch (UnsupportedOperationException e10) {
                e = e10;
                if (z10) {
                    Log.w("ExifInterface", "Invalid image: ExifInterface got an unsupported image format file(ExifInterface supports JPEG and some RAW image formats only) or a corrupted JPEG file to ExifInterface.", e);
                }
                m5350a();
                if (!z10) {
                    return;
                }
            }
        }
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, 5000);
        int iM5356g = m5356g(bufferedInputStream);
        this.f8271c = iM5356g;
        if (iM5356g == 4 || iM5356g == 9 || iM5356g == 13 || iM5356g == 14) {
            C2358b c2358b = new C2358b(bufferedInputStream);
            int i10 = this.f8271c;
            if (i10 == 4) {
                m5355f(c2358b, 0, 0);
            } else if (i10 == 13) {
                m5358i(c2358b);
            } else if (i10 == 9) {
                m5359j(c2358b);
            } else if (i10 == 14) {
                m5362m(c2358b);
            }
        } else {
            C2362f c2362f = new C2362f(bufferedInputStream);
            int i11 = this.f8271c;
            if (i11 == 12) {
                m5354e(c2362f);
            } else if (i11 == 7) {
                m5357h(c2362f);
            } else if (i11 == 10) {
                m5361l(c2362f);
            } else {
                m5360k(c2362f);
            }
            c2362f.m5348b(this.f8276h);
            m5370v(c2362f);
        }
        m5350a();
        if (!z10) {
            return;
        }
        m5366q();
    }

    public static ByteOrder m5349r(C2358b c2358b) throws IOException {
        short s10 = c2358b.readShort();
        boolean z7 = f8254l;
        if (s10 == 18761) {
            if (z7) {
                Log.d("ExifInterface", "readExifSegment: Byte Align II");
            }
            return ByteOrder.LITTLE_ENDIAN;
        }
        if (s10 == 19789) {
            if (z7) {
                Log.d("ExifInterface", "readExifSegment: Byte Align MM");
            }
            return ByteOrder.BIG_ENDIAN;
        }
        throw new IOException("Invalid byte order: " + Integer.toHexString(s10));
    }

    public final void m5350a() {
        String strM5351b = m5351b("DateTimeOriginal");
        HashMap[] mapArr = this.f8272d;
        if (strM5351b != null && m5351b("DateTime") == null) {
            HashMap map = mapArr[0];
            byte[] bytes = strM5351b.concat("\u0000").getBytes(f8251L);
            map.put("DateTime", new C2359c(bytes, 2, bytes.length));
        }
        if (m5351b("ImageWidth") == null) {
            mapArr[0].put("ImageWidth", C2359c.m5341a(0L, this.f8274f));
        }
        if (m5351b("ImageLength") == null) {
            mapArr[0].put("ImageLength", C2359c.m5341a(0L, this.f8274f));
        }
        if (m5351b("Orientation") == null) {
            mapArr[0].put("Orientation", C2359c.m5341a(0L, this.f8274f));
        }
        if (m5351b("LightSource") == null) {
            mapArr[1].put("LightSource", C2359c.m5341a(0L, this.f8274f));
        }
    }

    public final String m5351b(String str) {
        C2359c c2359cM5353d = m5353d(str);
        if (c2359cM5353d != null) {
            if (!f8249J.contains(str)) {
                return c2359cM5353d.m5346f(this.f8274f);
            }
            if (str.equals("GPSTimeStamp")) {
                int i6 = c2359cM5353d.f8230a;
                if (i6 != 5 && i6 != 10) {
                    Log.w("ExifInterface", "GPS Timestamp format is not rational. format=" + i6);
                    return null;
                }
                C2361e[] c2361eArr = (C2361e[]) c2359cM5353d.m5347g(this.f8274f);
                if (c2361eArr == null || c2361eArr.length != 3) {
                    Log.w("ExifInterface", "Invalid GPS Timestamp array. array=" + Arrays.toString(c2361eArr));
                    return null;
                }
                C2361e c2361e = c2361eArr[0];
                Integer numValueOf = Integer.valueOf((int) (c2361e.f8238a / c2361e.f8239b));
                C2361e c2361e2 = c2361eArr[1];
                Integer numValueOf2 = Integer.valueOf((int) (c2361e2.f8238a / c2361e2.f8239b));
                C2361e c2361e3 = c2361eArr[2];
                return String.format("%02d:%02d:%02d", numValueOf, numValueOf2, Integer.valueOf((int) (c2361e3.f8238a / c2361e3.f8239b)));
            }
            try {
                return Double.toString(c2359cM5353d.m5344d(this.f8274f));
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }

    public final int m5352c() {
        C2359c c2359cM5353d = m5353d("Orientation");
        if (c2359cM5353d == null) {
            return 1;
        }
        try {
            return c2359cM5353d.m5345e(this.f8274f);
        } catch (NumberFormatException unused) {
            return 1;
        }
    }

    public final C2359c m5353d(String str) {
        if ("ISOSpeedRatings".equals(str)) {
            if (f8254l) {
                Log.d("ExifInterface", "getExifAttribute: Replacing TAG_ISO_SPEED_RATINGS with TAG_PHOTOGRAPHIC_SENSITIVITY.");
            }
            str = "PhotographicSensitivity";
        }
        for (int i6 = 0; i6 < f8245F.length; i6++) {
            C2359c c2359c = (C2359c) this.f8272d[i6].get(str);
            if (c2359c != null) {
                return c2359c;
            }
        }
        return null;
    }

    public final void m5354e(C2362f c2362f) throws IOException {
        String strExtractMetadata;
        String strExtractMetadata2;
        String strExtractMetadata3;
        int i6;
        if (Build.VERSION.SDK_INT < 28) {
            throw new UnsupportedOperationException("Reading EXIF from HEIF files is supported from SDK 28 and above");
        }
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                AbstractC2365i.m5377a(mediaMetadataRetriever, new C2357a(c2362f));
                String strExtractMetadata4 = mediaMetadataRetriever.extractMetadata(33);
                String strExtractMetadata5 = mediaMetadataRetriever.extractMetadata(34);
                String strExtractMetadata6 = mediaMetadataRetriever.extractMetadata(26);
                String strExtractMetadata7 = mediaMetadataRetriever.extractMetadata(17);
                if ("yes".equals(strExtractMetadata6)) {
                    strExtractMetadata = mediaMetadataRetriever.extractMetadata(29);
                    strExtractMetadata2 = mediaMetadataRetriever.extractMetadata(30);
                    strExtractMetadata3 = mediaMetadataRetriever.extractMetadata(31);
                } else if ("yes".equals(strExtractMetadata7)) {
                    strExtractMetadata = mediaMetadataRetriever.extractMetadata(18);
                    strExtractMetadata2 = mediaMetadataRetriever.extractMetadata(19);
                    strExtractMetadata3 = mediaMetadataRetriever.extractMetadata(24);
                } else {
                    strExtractMetadata = null;
                    strExtractMetadata2 = null;
                    strExtractMetadata3 = null;
                }
                HashMap[] mapArr = this.f8272d;
                if (strExtractMetadata != null) {
                    mapArr[0].put("ImageWidth", C2359c.m5343c(Integer.parseInt(strExtractMetadata), this.f8274f));
                }
                if (strExtractMetadata2 != null) {
                    mapArr[0].put("ImageLength", C2359c.m5343c(Integer.parseInt(strExtractMetadata2), this.f8274f));
                }
                if (strExtractMetadata3 != null) {
                    int i10 = Integer.parseInt(strExtractMetadata3);
                    if (i10 == 90) {
                        i6 = 6;
                    } else if (i10 != 180) {
                        i6 = i10 != 270 ? 1 : 8;
                    } else {
                        i6 = 3;
                    }
                    mapArr[0].put("Orientation", C2359c.m5343c(i6, this.f8274f));
                }
                if (strExtractMetadata4 != null && strExtractMetadata5 != null) {
                    int i11 = Integer.parseInt(strExtractMetadata4);
                    int i12 = Integer.parseInt(strExtractMetadata5);
                    if (i12 <= 6) {
                        throw new IOException("Invalid exif length");
                    }
                    c2362f.m5348b(i11);
                    byte[] bArr = new byte[6];
                    c2362f.readFully(bArr);
                    int i13 = i11 + 6;
                    int i14 = i12 - 6;
                    if (!Arrays.equals(bArr, f8252M)) {
                        throw new IOException("Invalid identifier");
                    }
                    byte[] bArr2 = new byte[i14];
                    c2362f.readFully(bArr2);
                    this.f8276h = i13;
                    m5367s(bArr2, 0);
                }
                if (f8254l) {
                    Log.d("ExifInterface", "Heif meta: " + strExtractMetadata + "x" + strExtractMetadata2 + ", rotation " + strExtractMetadata3);
                }
                mediaMetadataRetriever.release();
            } catch (RuntimeException unused) {
                throw new UnsupportedOperationException("Failed to read EXIF from HEIF file. Given stream is either malformed or unsupported.");
            }
        } catch (Throwable th) {
            mediaMetadataRetriever.release();
            throw th;
        }
    }

    /*  JADX ERROR: UnsupportedOperationException in pass: RegionMakerVisitor
        java.lang.UnsupportedOperationException
        	at java.base/java.util.Collections$UnmodifiableCollection.add(Collections.java:1092)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker$1.leaveRegion(SwitchRegionMaker.java:419)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:91)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:31)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaksForCase(SwitchRegionMaker.java:399)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaks(SwitchRegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.leaveRegion(PostProcessRegions.java:31)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:91)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:27)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.process(PostProcessRegions.java:21)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:31)
        */
    public final void m5355f(p047e1.C2358b r23, int r24, int r25) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 528
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p047e1.C2363g.m5355f(e1.b, int, int):void");
    }

    public final int m5356g(BufferedInputStream bufferedInputStream) throws Throwable {
        ?? r10;
        C2358b c2358b;
        C2358b c2358b2;
        C2358b c2358b3;
        boolean z7;
        C2358b c2358b4;
        C2358b c2358b5;
        boolean z10;
        int i6;
        byte[] bArr;
        boolean z11;
        int i10;
        byte[] bArr2;
        int i11;
        byte[] bArr3;
        boolean z12;
        C2358b c2358b6;
        short s10;
        long j10;
        bufferedInputStream.mark(5000);
        byte[] bArr4 = new byte[5000];
        bufferedInputStream.read(bArr4);
        bufferedInputStream.reset();
        int i12 = 0;
        while (true) {
            byte[] bArr5 = f8257o;
            if (i12 >= bArr5.length) {
                return 4;
            }
            if (bArr4[i12] != bArr5[i12]) {
                byte[] bytes = "FUJIFILMCCD-RAW".getBytes(Charset.defaultCharset());
                for (int i13 = 0; i13 < bytes.length; i13++) {
                    byte b8 = bArr4[i13];
                    ?? r11 = bytes[i13];
                    try {
                        if (b8 != r11) {
                            try {
                                c2358b = new C2358b(bArr4);
                                try {
                                    long j11 = c2358b.readInt();
                                    byte[] bArr6 = new byte[4];
                                    c2358b.readFully(bArr6);
                                    if (Arrays.equals(bArr6, f8258p)) {
                                        if (j11 == 1) {
                                            j11 = c2358b.readLong();
                                            j10 = 16;
                                            if (j11 < 16) {
                                            }
                                        } else {
                                            j10 = 8;
                                        }
                                        long j12 = 5000;
                                        if (j11 > j12) {
                                            j11 = j12;
                                        }
                                        long j13 = j11 - j10;
                                        if (j13 >= 8) {
                                            byte[] bArr7 = new byte[4];
                                            boolean z13 = false;
                                            boolean z14 = false;
                                            for (long j14 = 0; j14 < j13 / 4; j14++) {
                                                try {
                                                    c2358b.readFully(bArr7);
                                                    if (j14 != 1) {
                                                        if (Arrays.equals(bArr7, f8259q)) {
                                                            z13 = true;
                                                        } else if (Arrays.equals(bArr7, f8260r)) {
                                                            z14 = true;
                                                        }
                                                        if (z13 && z14) {
                                                            c2358b.close();
                                                            return 12;
                                                        }
                                                    }
                                                } catch (EOFException unused) {
                                                }
                                            }
                                        }
                                    }
                                } catch (Exception e5) {
                                    e = e5;
                                    if (f8254l) {
                                        Log.d("ExifInterface", "Exception parsing HEIF file type box.", e);
                                    }
                                    if (c2358b != null) {
                                    }
                                    c2358b3 = new C2358b(bArr4);
                                    ByteOrder byteOrderM5349r = m5349r(c2358b3);
                                    this.f8274f = byteOrderM5349r;
                                    c2358b3.f8227c = byteOrderM5349r;
                                    s10 = c2358b3.readShort();
                                    if (s10 != 20306) {
                                        z7 = true;
                                    } else {
                                        z7 = true;
                                    }
                                    c2358b3.close();
                                    if (z7) {
                                        return 7;
                                    }
                                    try {
                                        c2358b6 = new C2358b(bArr4);
                                        try {
                                            ByteOrder byteOrderM5349r2 = m5349r(c2358b6);
                                            this.f8274f = byteOrderM5349r2;
                                            c2358b6.f8227c = byteOrderM5349r2;
                                            if (c2358b6.readShort() == 85) {
                                                z10 = true;
                                            } else {
                                                z10 = false;
                                            }
                                            c2358b6.close();
                                        } catch (Exception unused2) {
                                            c2358b5 = c2358b6;
                                            if (c2358b5 != null) {
                                                c2358b5.close();
                                            }
                                            z10 = false;
                                        } catch (Throwable th) {
                                            th = th;
                                            c2358b4 = c2358b6;
                                            if (c2358b4 != null) {
                                                c2358b4.close();
                                            }
                                            throw th;
                                        }
                                    } catch (Exception unused3) {
                                        c2358b5 = null;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        c2358b4 = null;
                                    }
                                    if (z10) {
                                        return 10;
                                    }
                                    i6 = 0;
                                    while (true) {
                                        bArr = f8263u;
                                        if (i6 < bArr.length) {
                                            z11 = true;
                                            break;
                                        }
                                        if (bArr4[i6] != bArr[i6]) {
                                            z11 = false;
                                            break;
                                        }
                                        i6++;
                                    }
                                    if (z11) {
                                        return 13;
                                    }
                                    i10 = 0;
                                    while (true) {
                                        bArr2 = f8267y;
                                        if (i10 < bArr2.length) {
                                            i11 = 0;
                                            while (true) {
                                                bArr3 = f8268z;
                                                if (i11 < bArr3.length) {
                                                    z12 = true;
                                                } else {
                                                    if (bArr4[bArr2.length + i11 + 4] != bArr3[i11]) {
                                                        break;
                                                    }
                                                    i11++;
                                                }
                                                if (z12) {
                                                    return 14;
                                                }
                                                return 0;
                                            }
                                        }
                                        if (bArr4[i10] != bArr2[i10]) {
                                            break;
                                        }
                                        i10++;
                                    }
                                    z12 = false;
                                    if (z12) {
                                        return 14;
                                    }
                                    return 0;
                                }
                            } catch (Exception e10) {
                                e = e10;
                                c2358b = null;
                            } catch (Throwable th3) {
                                th = th3;
                                r10 = 0;
                                if (r10 != 0) {
                                    r10.close();
                                }
                                throw th;
                            }
                            c2358b.close();
                            try {
                                c2358b3 = new C2358b(bArr4);
                                try {
                                    ByteOrder byteOrderM5349r3 = m5349r(c2358b3);
                                    this.f8274f = byteOrderM5349r3;
                                    c2358b3.f8227c = byteOrderM5349r3;
                                    s10 = c2358b3.readShort();
                                    if (s10 != 20306 || s10 == 21330) {
                                        z7 = true;
                                    } else {
                                        z7 = false;
                                    }
                                    c2358b3.close();
                                } catch (Exception unused4) {
                                    if (c2358b3 != null) {
                                        c2358b3.close();
                                    }
                                    z7 = false;
                                } catch (Throwable th4) {
                                    th = th4;
                                    c2358b2 = c2358b3;
                                    if (c2358b2 != null) {
                                        c2358b2.close();
                                    }
                                    throw th;
                                }
                            } catch (Exception unused5) {
                                c2358b3 = null;
                            } catch (Throwable th5) {
                                th = th5;
                                c2358b2 = null;
                            }
                            if (z7) {
                                return 7;
                            }
                            c2358b6 = new C2358b(bArr4);
                            ByteOrder byteOrderM5349r4 = m5349r(c2358b6);
                            this.f8274f = byteOrderM5349r4;
                            c2358b6.f8227c = byteOrderM5349r4;
                            if (c2358b6.readShort() == 85) {
                                z10 = true;
                            } else {
                                z10 = false;
                            }
                            c2358b6.close();
                            if (z10) {
                                return 10;
                            }
                            i6 = 0;
                            while (true) {
                                bArr = f8263u;
                                if (i6 < bArr.length) {
                                    z11 = true;
                                    break;
                                }
                                if (bArr4[i6] != bArr[i6]) {
                                    z11 = false;
                                    break;
                                }
                                i6++;
                            }
                            if (z11) {
                                return 13;
                            }
                            i10 = 0;
                            while (true) {
                                bArr2 = f8267y;
                                if (i10 < bArr2.length) {
                                    i11 = 0;
                                    while (true) {
                                        bArr3 = f8268z;
                                        if (i11 < bArr3.length) {
                                            z12 = true;
                                        } else {
                                            if (bArr4[bArr2.length + i11 + 4] != bArr3[i11]) {
                                                break;
                                                break;
                                            }
                                            i11++;
                                        }
                                        if (z12) {
                                            return 14;
                                        }
                                        return 0;
                                    }
                                }
                                if (bArr4[i10] != bArr2[i10]) {
                                    break;
                                    break;
                                }
                                i10++;
                            }
                            z12 = false;
                            if (z12) {
                                return 14;
                            }
                            return 0;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        r10 = r11;
                    }
                }
                return 9;
            }
            i12++;
        }
    }

    public final void m5357h(C2362f c2362f) throws Throwable {
        int i6;
        int i10;
        m5360k(c2362f);
        HashMap[] mapArr = this.f8272d;
        C2359c c2359c = (C2359c) mapArr[1].get("MakerNote");
        if (c2359c != null) {
            C2362f c2362f2 = new C2362f(c2359c.f8233d);
            c2362f2.f8227c = this.f8274f;
            byte[] bArr = f8261s;
            byte[] bArr2 = new byte[bArr.length];
            c2362f2.readFully(bArr2);
            c2362f2.m5348b(0L);
            byte[] bArr3 = f8262t;
            byte[] bArr4 = new byte[bArr3.length];
            c2362f2.readFully(bArr4);
            if (Arrays.equals(bArr2, bArr)) {
                c2362f2.m5348b(8L);
            } else if (Arrays.equals(bArr4, bArr3)) {
                c2362f2.m5348b(12L);
            }
            m5368t(c2362f2, 6);
            C2359c c2359c2 = (C2359c) mapArr[7].get("PreviewImageStart");
            C2359c c2359c3 = (C2359c) mapArr[7].get("PreviewImageLength");
            if (c2359c2 != null && c2359c3 != null) {
                mapArr[5].put("JPEGInterchangeFormat", c2359c2);
                mapArr[5].put("JPEGInterchangeFormatLength", c2359c3);
            }
            C2359c c2359c4 = (C2359c) mapArr[8].get("AspectFrame");
            if (c2359c4 != null) {
                int[] iArr = (int[]) c2359c4.m5347g(this.f8274f);
                if (iArr == null || iArr.length != 4) {
                    Log.w("ExifInterface", "Invalid aspect frame values. frame=" + Arrays.toString(iArr));
                    return;
                }
                int i11 = iArr[2];
                int i12 = iArr[0];
                if (i11 <= i12 || (i6 = iArr[3]) <= (i10 = iArr[1])) {
                    return;
                }
                int i13 = (i11 - i12) + 1;
                int i14 = (i6 - i10) + 1;
                if (i13 < i14) {
                    int i15 = i13 + i14;
                    i14 = i15 - i14;
                    i13 = i15 - i14;
                }
                C2359c c2359cM5343c = C2359c.m5343c(i13, this.f8274f);
                C2359c c2359cM5343c2 = C2359c.m5343c(i14, this.f8274f);
                mapArr[0].put("ImageWidth", c2359cM5343c);
                mapArr[0].put("ImageLength", c2359cM5343c2);
            }
        }
    }

    public final void m5358i(C2358b c2358b) throws Throwable {
        if (f8254l) {
            Log.d("ExifInterface", "getPngAttributes starting with: " + c2358b);
        }
        c2358b.f8227c = ByteOrder.BIG_ENDIAN;
        byte[] bArr = f8263u;
        c2358b.m5340a(bArr.length);
        int length = bArr.length;
        while (true) {
            try {
                int i6 = c2358b.readInt();
                byte[] bArr2 = new byte[4];
                c2358b.readFully(bArr2);
                int i10 = length + 8;
                if (i10 == 16 && !Arrays.equals(bArr2, f8265w)) {
                    throw new IOException("Encountered invalid PNG file--IHDR chunk should appearas the first chunk");
                }
                if (Arrays.equals(bArr2, f8266x)) {
                    return;
                }
                if (Arrays.equals(bArr2, f8264v)) {
                    byte[] bArr3 = new byte[i6];
                    c2358b.readFully(bArr3);
                    int i11 = c2358b.readInt();
                    CRC32 crc32 = new CRC32();
                    crc32.update(bArr2);
                    crc32.update(bArr3);
                    if (((int) crc32.getValue()) == i11) {
                        this.f8276h = i10;
                        m5367s(bArr3, 0);
                        m5373y();
                        m5370v(new C2358b(bArr3));
                        return;
                    }
                    throw new IOException("Encountered invalid CRC value for PNG-EXIF chunk.\n recorded CRC value: " + i11 + ", calculated CRC value: " + crc32.getValue());
                }
                int i12 = i6 + 4;
                c2358b.m5340a(i12);
                length = i10 + i12;
            } catch (EOFException unused) {
                throw new IOException("Encountered corrupt PNG file.");
            }
        }
    }

    public final void m5359j(C2358b c2358b) throws Throwable {
        boolean z7 = f8254l;
        if (z7) {
            Log.d("ExifInterface", "getRafAttributes starting with: " + c2358b);
        }
        c2358b.m5340a(84);
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[4];
        byte[] bArr3 = new byte[4];
        c2358b.readFully(bArr);
        c2358b.readFully(bArr2);
        c2358b.readFully(bArr3);
        int i6 = ByteBuffer.wrap(bArr).getInt();
        int i10 = ByteBuffer.wrap(bArr2).getInt();
        int i11 = ByteBuffer.wrap(bArr3).getInt();
        byte[] bArr4 = new byte[i10];
        c2358b.m5340a(i6 - c2358b.f8226b);
        c2358b.readFully(bArr4);
        m5355f(new C2358b(bArr4), i6, 5);
        c2358b.m5340a(i11 - c2358b.f8226b);
        c2358b.f8227c = ByteOrder.BIG_ENDIAN;
        int i12 = c2358b.readInt();
        if (z7) {
            Log.d("ExifInterface", "numberOfDirectoryEntry: " + i12);
        }
        for (int i13 = 0; i13 < i12; i13++) {
            int unsignedShort = c2358b.readUnsignedShort();
            int unsignedShort2 = c2358b.readUnsignedShort();
            if (unsignedShort == f8244E.f8234a) {
                short s10 = c2358b.readShort();
                short s11 = c2358b.readShort();
                C2359c c2359cM5343c = C2359c.m5343c(s10, this.f8274f);
                C2359c c2359cM5343c2 = C2359c.m5343c(s11, this.f8274f);
                HashMap[] mapArr = this.f8272d;
                mapArr[0].put("ImageLength", c2359cM5343c);
                mapArr[0].put("ImageWidth", c2359cM5343c2);
                if (z7) {
                    Log.d("ExifInterface", "Updated to length: " + ((int) s10) + ", width: " + ((int) s11));
                    return;
                }
                return;
            }
            c2358b.m5340a(unsignedShort2);
        }
    }

    public final void m5360k(C2362f c2362f) throws Throwable {
        m5365p(c2362f);
        m5368t(c2362f, 0);
        m5372x(c2362f, 0);
        m5372x(c2362f, 5);
        m5372x(c2362f, 4);
        m5373y();
        if (this.f8271c == 8) {
            HashMap[] mapArr = this.f8272d;
            C2359c c2359c = (C2359c) mapArr[1].get("MakerNote");
            if (c2359c != null) {
                C2362f c2362f2 = new C2362f(c2359c.f8233d);
                c2362f2.f8227c = this.f8274f;
                c2362f2.m5340a(6);
                m5368t(c2362f2, 9);
                C2359c c2359c2 = (C2359c) mapArr[9].get("ColorSpace");
                if (c2359c2 != null) {
                    mapArr[1].put("ColorSpace", c2359c2);
                }
            }
        }
    }

    public final void m5361l(C2362f c2362f) throws Throwable {
        if (f8254l) {
            Log.d("ExifInterface", "getRw2Attributes starting with: " + c2362f);
        }
        m5360k(c2362f);
        HashMap[] mapArr = this.f8272d;
        C2359c c2359c = (C2359c) mapArr[0].get("JpgFromRaw");
        if (c2359c != null) {
            m5355f(new C2358b(c2359c.f8233d), (int) c2359c.f8232c, 5);
        }
        C2359c c2359c2 = (C2359c) mapArr[0].get("ISO");
        C2359c c2359c3 = (C2359c) mapArr[1].get("PhotographicSensitivity");
        if (c2359c2 == null || c2359c3 != null) {
            return;
        }
        mapArr[1].put("PhotographicSensitivity", c2359c2);
    }

    public final void m5362m(C2358b c2358b) throws Throwable {
        if (f8254l) {
            Log.d("ExifInterface", "getWebpAttributes starting with: " + c2358b);
        }
        c2358b.f8227c = ByteOrder.LITTLE_ENDIAN;
        c2358b.m5340a(f8267y.length);
        int i6 = c2358b.readInt() + 8;
        byte[] bArr = f8268z;
        c2358b.m5340a(bArr.length);
        int length = bArr.length + 8;
        while (true) {
            try {
                byte[] bArr2 = new byte[4];
                c2358b.readFully(bArr2);
                int i10 = c2358b.readInt();
                int i11 = length + 8;
                if (Arrays.equals(f8240A, bArr2)) {
                    byte[] bArr3 = new byte[i10];
                    c2358b.readFully(bArr3);
                    this.f8276h = i11;
                    m5367s(bArr3, 0);
                    m5370v(new C2358b(bArr3));
                    return;
                }
                if (i10 % 2 == 1) {
                    i10++;
                }
                length = i11 + i10;
                if (length == i6) {
                    return;
                }
                if (length > i6) {
                    throw new IOException("Encountered WebP file with invalid chunk size");
                }
                c2358b.m5340a(i10);
            } catch (EOFException unused) {
                throw new IOException("Encountered corrupt WebP file.");
            }
        }
    }

    public final void m5363n(C2358b c2358b, HashMap map) throws Throwable {
        C2359c c2359c = (C2359c) map.get("JPEGInterchangeFormat");
        C2359c c2359c2 = (C2359c) map.get("JPEGInterchangeFormatLength");
        if (c2359c == null || c2359c2 == null) {
            return;
        }
        int iM5345e = c2359c.m5345e(this.f8274f);
        int iM5345e2 = c2359c2.m5345e(this.f8274f);
        if (this.f8271c == 7) {
            iM5345e += this.f8277i;
        }
        if (iM5345e > 0 && iM5345e2 > 0 && this.f8270b == null && this.f8269a == null) {
            c2358b.m5340a(iM5345e);
            c2358b.readFully(new byte[iM5345e2]);
        }
        if (f8254l) {
            Log.d("ExifInterface", "Setting thumbnail attributes with offset: " + iM5345e + ", length: " + iM5345e2);
        }
    }

    public final boolean m5364o(HashMap map) {
        C2359c c2359c = (C2359c) map.get("ImageLength");
        C2359c c2359c2 = (C2359c) map.get("ImageWidth");
        if (c2359c == null || c2359c2 == null) {
            return false;
        }
        return c2359c.m5345e(this.f8274f) <= 512 && c2359c2.m5345e(this.f8274f) <= 512;
    }

    public final void m5365p(C2362f c2362f) throws IOException {
        ByteOrder byteOrderM5349r = m5349r(c2362f);
        this.f8274f = byteOrderM5349r;
        c2362f.f8227c = byteOrderM5349r;
        int unsignedShort = c2362f.readUnsignedShort();
        int i6 = this.f8271c;
        if (i6 != 7 && i6 != 10 && unsignedShort != 42) {
            throw new IOException("Invalid start code: " + Integer.toHexString(unsignedShort));
        }
        int i10 = c2362f.readInt();
        if (i10 < 8) {
            throw new IOException(AbstractC0004e.m20n(i10, "Invalid first Ifd offset: "));
        }
        int i11 = i10 - 8;
        if (i11 > 0) {
            c2362f.m5340a(i11);
        }
    }

    public final void m5366q() {
        int i6 = 0;
        while (true) {
            HashMap[] mapArr = this.f8272d;
            if (i6 >= mapArr.length) {
                return;
            }
            StringBuilder sbM27u = AbstractC0004e.m27u(i6, "The size of tag group[", "]: ");
            sbM27u.append(mapArr[i6].size());
            Log.d("ExifInterface", sbM27u.toString());
            for (Map.Entry entry : mapArr[i6].entrySet()) {
                C2359c c2359c = (C2359c) entry.getValue();
                Log.d("ExifInterface", "tagName: " + ((String) entry.getKey()) + ", tagType: " + c2359c.toString() + ", tagValue: '" + c2359c.m5346f(this.f8274f) + "'");
            }
            i6++;
        }
    }

    public final void m5367s(byte[] bArr, int i6) throws IOException {
        C2362f c2362f = new C2362f(bArr);
        m5365p(c2362f);
        m5368t(c2362f, i6);
    }

    public final void m5368t(C2362f c2362f, int i6) throws IOException {
        HashMap[] mapArr;
        HashMap[] mapArr2;
        int i10;
        long j10;
        boolean z7;
        int i11;
        C2360d c2360d;
        Integer num;
        HashSet hashSet;
        String str;
        int unsignedShort;
        long j11;
        int i12;
        String strM21o;
        int i13;
        Integer numValueOf = Integer.valueOf(c2362f.f8226b);
        HashSet hashSet2 = this.f8273e;
        hashSet2.add(numValueOf);
        short s10 = c2362f.readShort();
        boolean z10 = f8254l;
        if (z10) {
            Log.d("ExifInterface", "numberOfDirectoryEntry: " + ((int) s10));
        }
        if (s10 <= 0) {
            return;
        }
        short s11 = 0;
        while (true) {
            mapArr = this.f8272d;
            if (s11 >= s10) {
                break;
            }
            int unsignedShort2 = c2362f.readUnsignedShort();
            int unsignedShort3 = c2362f.readUnsignedShort();
            int i14 = c2362f.readInt();
            short s12 = s10;
            long j12 = ((long) c2362f.f8226b) + 4;
            C2360d c2360d2 = (C2360d) f8247H[i6].get(Integer.valueOf(unsignedShort2));
            if (z10) {
                Log.d("ExifInterface", String.format("ifdType: %d, tagNumber: %d, tagName: %s, dataFormat: %d, numberOfComponents: %d", Integer.valueOf(i6), Integer.valueOf(unsignedShort2), c2360d2 != null ? c2360d2.f8235b : null, Integer.valueOf(unsignedShort3), Integer.valueOf(i14)));
            }
            if (c2360d2 != null) {
                if (unsignedShort3 > 0) {
                    int[] iArr = f8242C;
                    if (unsignedShort3 < iArr.length) {
                        int i15 = c2360d2.f8236c;
                        if (i15 == 7 || unsignedShort3 == 7 || i15 == unsignedShort3 || (i11 = c2360d2.f8237d) == unsignedShort3 || (((i15 == 4 || i11 == 4) && unsignedShort3 == 3) || (((i15 == 9 || i11 == 9) && unsignedShort3 == 8) || ((i15 == 12 || i11 == 12) && unsignedShort3 == 11)))) {
                            if (unsignedShort3 == 7) {
                                unsignedShort3 = i15;
                            }
                            mapArr2 = mapArr;
                            i10 = unsignedShort3;
                            j10 = ((long) iArr[unsignedShort3]) * ((long) i14);
                            if (j10 < 0 || j10 > 2147483647L) {
                                if (z10) {
                                    Log.d("ExifInterface", "Skip the tag entry since the number of components is invalid: " + i14);
                                }
                                z7 = false;
                            } else {
                                z7 = true;
                            }
                        } else if (z10) {
                            Log.d("ExifInterface", "Skip the tag entry since data format (" + f8241B[unsignedShort3] + ") is unexpected for tag: " + c2360d2.f8235b);
                        }
                    }
                    if (z7) {
                        if (j10 > 4) {
                            i13 = c2362f.readInt();
                            if (z10) {
                                Log.d("ExifInterface", "seek to data offset: " + i13);
                            }
                            if (this.f8271c != 7) {
                                c2360d = c2360d2;
                            } else {
                                if ("MakerNote".equals(c2360d2.f8235b)) {
                                    this.f8277i = i13;
                                } else if (i6 != 6 && "ThumbnailImage".equals(c2360d2.f8235b)) {
                                    this.f8278j = i13;
                                    this.f8279k = i14;
                                    C2359c c2359cM5343c = C2359c.m5343c(6, this.f8274f);
                                    C2359c c2359cM5341a = C2359c.m5341a(this.f8278j, this.f8274f);
                                    c2360d = c2360d2;
                                    C2359c c2359cM5341a2 = C2359c.m5341a(this.f8279k, this.f8274f);
                                    mapArr2[4].put("Compression", c2359cM5343c);
                                    mapArr2[4].put("JPEGInterchangeFormat", c2359cM5341a);
                                    mapArr2[4].put("JPEGInterchangeFormatLength", c2359cM5341a2);
                                }
                                c2360d = c2360d2;
                            }
                            c2362f.m5348b(i13);
                        } else {
                            i14 = i14;
                            c2360d = c2360d2;
                        }
                        num = (Integer) f8250K.get(Integer.valueOf(unsignedShort2));
                        if (z10) {
                            Log.d("ExifInterface", "nextIfdType: " + num + " byteCount: " + j10);
                        }
                        if (num != null) {
                            if (i10 != 3) {
                                if (i10 == 4) {
                                    j11 = ((long) c2362f.readInt()) & 4294967295L;
                                } else if (i10 == 8) {
                                    unsignedShort = c2362f.readShort();
                                } else if (i10 != 9 || i10 == 13) {
                                    unsignedShort = c2362f.readInt();
                                } else {
                                    j11 = -1;
                                }
                                if (z10) {
                                    Log.d("ExifInterface", String.format("Offset: %d, tagName: %s", Long.valueOf(j11), c2360d.f8235b));
                                }
                                i12 = c2362f.f8229e;
                                if (j11 > 0 || (i12 != -1 && j11 >= i12)) {
                                    hashSet = hashSet2;
                                    if (z10) {
                                        strM21o = AbstractC0004e.m21o(j11, "Skip jump into the IFD since its offset is invalid: ");
                                        if (i12 != -1) {
                                            strM21o = strM21o + " (total length: " + i12 + ")";
                                        }
                                        Log.d("ExifInterface", strM21o);
                                    }
                                } else {
                                    hashSet = hashSet2;
                                    if (!hashSet.contains(Integer.valueOf((int) j11))) {
                                        c2362f.m5348b(j11);
                                        m5368t(c2362f, num.intValue());
                                    } else if (z10) {
                                        Log.d("ExifInterface", "Skip jump into the IFD since it has already been read: IfdType " + num + " (at " + j11 + ")");
                                    }
                                }
                                c2362f.m5348b(j12);
                            } else {
                                unsignedShort = c2362f.readUnsignedShort();
                            }
                            j11 = unsignedShort;
                            if (z10) {
                                Log.d("ExifInterface", String.format("Offset: %d, tagName: %s", Long.valueOf(j11), c2360d.f8235b));
                            }
                            i12 = c2362f.f8229e;
                            if (j11 > 0) {
                                hashSet = hashSet2;
                                if (z10) {
                                    strM21o = AbstractC0004e.m21o(j11, "Skip jump into the IFD since its offset is invalid: ");
                                    if (i12 != -1) {
                                        strM21o = strM21o + " (total length: " + i12 + ")";
                                    }
                                    Log.d("ExifInterface", strM21o);
                                }
                            } else {
                                hashSet = hashSet2;
                                if (z10) {
                                    strM21o = AbstractC0004e.m21o(j11, "Skip jump into the IFD since its offset is invalid: ");
                                    if (i12 != -1) {
                                        strM21o = strM21o + " (total length: " + i12 + ")";
                                    }
                                    Log.d("ExifInterface", strM21o);
                                }
                            }
                            c2362f.m5348b(j12);
                        } else {
                            hashSet = hashSet2;
                            C2360d c2360d3 = c2360d;
                            int i16 = c2362f.f8226b + this.f8276h;
                            byte[] bArr = new byte[(int) j10];
                            c2362f.readFully(bArr);
                            C2359c c2359c = new C2359c(i16, bArr, i10, i14);
                            mapArr2[i6].put(c2360d3.f8235b, c2359c);
                            str = c2360d3.f8235b;
                            if ("DNGVersion".equals(str)) {
                                this.f8271c = 3;
                            }
                            if (((!"Make".equals(str) || "Model".equals(str)) && c2359c.m5346f(this.f8274f).contains("PENTAX")) || ("Compression".equals(str) && c2359c.m5345e(this.f8274f) == 65535)) {
                                this.f8271c = 8;
                            }
                            if (c2362f.f8226b != j12) {
                                c2362f.m5348b(j12);
                            }
                        }
                        s11 = (short) (s11 + 1);
                        hashSet2 = hashSet;
                        s10 = s12;
                    } else {
                        c2362f.m5348b(j12);
                        hashSet = hashSet2;
                    }
                    s11 = (short) (s11 + 1);
                    hashSet2 = hashSet;
                    s10 = s12;
                }
                mapArr2 = mapArr;
                if (z10) {
                    Log.d("ExifInterface", "Skip the tag entry since data format is invalid: " + unsignedShort3);
                }
                i10 = unsignedShort3;
                j10 = 0;
                z7 = false;
                if (z7) {
                    c2362f.m5348b(j12);
                    hashSet = hashSet2;
                } else {
                    if (j10 > 4) {
                        i13 = c2362f.readInt();
                        if (z10) {
                            Log.d("ExifInterface", "seek to data offset: " + i13);
                        }
                        if (this.f8271c != 7) {
                            c2360d = c2360d2;
                        } else {
                            if ("MakerNote".equals(c2360d2.f8235b)) {
                                this.f8277i = i13;
                            } else if (i6 != 6) {
                            }
                            c2360d = c2360d2;
                        }
                        c2362f.m5348b(i13);
                    } else {
                        i14 = i14;
                        c2360d = c2360d2;
                    }
                    num = (Integer) f8250K.get(Integer.valueOf(unsignedShort2));
                    if (z10) {
                        Log.d("ExifInterface", "nextIfdType: " + num + " byteCount: " + j10);
                    }
                    if (num != null) {
                        if (i10 != 3) {
                            if (i10 == 4) {
                                j11 = ((long) c2362f.readInt()) & 4294967295L;
                            } else if (i10 == 8) {
                                if (i10 != 9) {
                                }
                                unsignedShort = c2362f.readInt();
                            } else {
                                unsignedShort = c2362f.readShort();
                            }
                            if (z10) {
                                Log.d("ExifInterface", String.format("Offset: %d, tagName: %s", Long.valueOf(j11), c2360d.f8235b));
                            }
                            i12 = c2362f.f8229e;
                            if (j11 > 0) {
                                hashSet = hashSet2;
                                if (z10) {
                                    strM21o = AbstractC0004e.m21o(j11, "Skip jump into the IFD since its offset is invalid: ");
                                    if (i12 != -1) {
                                        strM21o = strM21o + " (total length: " + i12 + ")";
                                    }
                                    Log.d("ExifInterface", strM21o);
                                }
                            } else {
                                hashSet = hashSet2;
                                if (z10) {
                                    strM21o = AbstractC0004e.m21o(j11, "Skip jump into the IFD since its offset is invalid: ");
                                    if (i12 != -1) {
                                        strM21o = strM21o + " (total length: " + i12 + ")";
                                    }
                                    Log.d("ExifInterface", strM21o);
                                }
                            }
                            c2362f.m5348b(j12);
                        } else {
                            unsignedShort = c2362f.readUnsignedShort();
                        }
                        j11 = unsignedShort;
                        if (z10) {
                            Log.d("ExifInterface", String.format("Offset: %d, tagName: %s", Long.valueOf(j11), c2360d.f8235b));
                        }
                        i12 = c2362f.f8229e;
                        if (j11 > 0) {
                            hashSet = hashSet2;
                            if (z10) {
                                strM21o = AbstractC0004e.m21o(j11, "Skip jump into the IFD since its offset is invalid: ");
                                if (i12 != -1) {
                                    strM21o = strM21o + " (total length: " + i12 + ")";
                                }
                                Log.d("ExifInterface", strM21o);
                            }
                        } else {
                            hashSet = hashSet2;
                            if (z10) {
                                strM21o = AbstractC0004e.m21o(j11, "Skip jump into the IFD since its offset is invalid: ");
                                if (i12 != -1) {
                                    strM21o = strM21o + " (total length: " + i12 + ")";
                                }
                                Log.d("ExifInterface", strM21o);
                            }
                        }
                        c2362f.m5348b(j12);
                    } else {
                        hashSet = hashSet2;
                        C2360d c2360d4 = c2360d;
                        int i17 = c2362f.f8226b + this.f8276h;
                        byte[] bArr2 = new byte[(int) j10];
                        c2362f.readFully(bArr2);
                        C2359c c2359c2 = new C2359c(i17, bArr2, i10, i14);
                        mapArr2[i6].put(c2360d4.f8235b, c2359c2);
                        str = c2360d4.f8235b;
                        if ("DNGVersion".equals(str)) {
                            this.f8271c = 3;
                        }
                        if (!"Make".equals(str)) {
                        }
                        this.f8271c = 8;
                        if (c2362f.f8226b != j12) {
                            c2362f.m5348b(j12);
                        }
                    }
                    s11 = (short) (s11 + 1);
                    hashSet2 = hashSet;
                    s10 = s12;
                }
                s11 = (short) (s11 + 1);
                hashSet2 = hashSet;
                s10 = s12;
            } else if (z10) {
                Log.d("ExifInterface", "Skip the tag entry since tag number is not defined: " + unsignedShort2);
            }
            mapArr2 = mapArr;
            i10 = unsignedShort3;
            j10 = 0;
            z7 = false;
            if (z7) {
                c2362f.m5348b(j12);
                hashSet = hashSet2;
            } else {
                if (j10 > 4) {
                    i13 = c2362f.readInt();
                    if (z10) {
                        Log.d("ExifInterface", "seek to data offset: " + i13);
                    }
                    if (this.f8271c != 7) {
                        c2360d = c2360d2;
                    } else {
                        if ("MakerNote".equals(c2360d2.f8235b)) {
                            this.f8277i = i13;
                        } else if (i6 != 6) {
                        }
                        c2360d = c2360d2;
                    }
                    c2362f.m5348b(i13);
                } else {
                    i14 = i14;
                    c2360d = c2360d2;
                }
                num = (Integer) f8250K.get(Integer.valueOf(unsignedShort2));
                if (z10) {
                    Log.d("ExifInterface", "nextIfdType: " + num + " byteCount: " + j10);
                }
                if (num != null) {
                    if (i10 != 3) {
                        if (i10 == 4) {
                            j11 = ((long) c2362f.readInt()) & 4294967295L;
                        } else if (i10 == 8) {
                            if (i10 != 9) {
                            }
                            unsignedShort = c2362f.readInt();
                        } else {
                            unsignedShort = c2362f.readShort();
                        }
                        if (z10) {
                            Log.d("ExifInterface", String.format("Offset: %d, tagName: %s", Long.valueOf(j11), c2360d.f8235b));
                        }
                        i12 = c2362f.f8229e;
                        if (j11 > 0) {
                            hashSet = hashSet2;
                            if (z10) {
                                strM21o = AbstractC0004e.m21o(j11, "Skip jump into the IFD since its offset is invalid: ");
                                if (i12 != -1) {
                                    strM21o = strM21o + " (total length: " + i12 + ")";
                                }
                                Log.d("ExifInterface", strM21o);
                            }
                        } else {
                            hashSet = hashSet2;
                            if (z10) {
                                strM21o = AbstractC0004e.m21o(j11, "Skip jump into the IFD since its offset is invalid: ");
                                if (i12 != -1) {
                                    strM21o = strM21o + " (total length: " + i12 + ")";
                                }
                                Log.d("ExifInterface", strM21o);
                            }
                        }
                        c2362f.m5348b(j12);
                    } else {
                        unsignedShort = c2362f.readUnsignedShort();
                    }
                    j11 = unsignedShort;
                    if (z10) {
                        Log.d("ExifInterface", String.format("Offset: %d, tagName: %s", Long.valueOf(j11), c2360d.f8235b));
                    }
                    i12 = c2362f.f8229e;
                    if (j11 > 0) {
                        hashSet = hashSet2;
                        if (z10) {
                            strM21o = AbstractC0004e.m21o(j11, "Skip jump into the IFD since its offset is invalid: ");
                            if (i12 != -1) {
                                strM21o = strM21o + " (total length: " + i12 + ")";
                            }
                            Log.d("ExifInterface", strM21o);
                        }
                    } else {
                        hashSet = hashSet2;
                        if (z10) {
                            strM21o = AbstractC0004e.m21o(j11, "Skip jump into the IFD since its offset is invalid: ");
                            if (i12 != -1) {
                                strM21o = strM21o + " (total length: " + i12 + ")";
                            }
                            Log.d("ExifInterface", strM21o);
                        }
                    }
                    c2362f.m5348b(j12);
                } else {
                    hashSet = hashSet2;
                    C2360d c2360d5 = c2360d;
                    int i18 = c2362f.f8226b + this.f8276h;
                    byte[] bArr3 = new byte[(int) j10];
                    c2362f.readFully(bArr3);
                    C2359c c2359c3 = new C2359c(i18, bArr3, i10, i14);
                    mapArr2[i6].put(c2360d5.f8235b, c2359c3);
                    str = c2360d5.f8235b;
                    if ("DNGVersion".equals(str)) {
                        this.f8271c = 3;
                    }
                    if (!"Make".equals(str)) {
                    }
                    this.f8271c = 8;
                    if (c2362f.f8226b != j12) {
                        c2362f.m5348b(j12);
                    }
                }
                s11 = (short) (s11 + 1);
                hashSet2 = hashSet;
                s10 = s12;
            }
            s11 = (short) (s11 + 1);
            hashSet2 = hashSet;
            s10 = s12;
        }
        HashSet hashSet3 = hashSet2;
        int i19 = c2362f.readInt();
        if (z10) {
            Log.d("ExifInterface", String.format("nextIfdOffset: %d", Integer.valueOf(i19)));
        }
        long j13 = i19;
        if (j13 <= 0) {
            if (z10) {
                Log.d("ExifInterface", "Stop reading file since a wrong offset may cause an infinite loop: " + i19);
                return;
            }
            return;
        }
        if (hashSet3.contains(Integer.valueOf(i19))) {
            if (z10) {
                Log.d("ExifInterface", "Stop reading file since re-reading an IFD may cause an infinite loop: " + i19);
                return;
            }
            return;
        }
        c2362f.m5348b(j13);
        if (mapArr[4].isEmpty()) {
            m5368t(c2362f, 4);
        } else if (mapArr[5].isEmpty()) {
            m5368t(c2362f, 5);
        }
    }

    public final void m5369u(int i6, String str, String str2) {
        HashMap[] mapArr = this.f8272d;
        if (mapArr[i6].isEmpty() || mapArr[i6].get(str) == null) {
            return;
        }
        HashMap map = mapArr[i6];
        map.put(str2, map.get(str));
        mapArr[i6].remove(str);
    }

    public final void m5370v(C2358b c2358b) throws Throwable {
        C2359c c2359c;
        int iM5345e;
        HashMap map = this.f8272d[4];
        C2359c c2359c2 = (C2359c) map.get("Compression");
        if (c2359c2 == null) {
            m5363n(c2358b, map);
            return;
        }
        int iM5345e2 = c2359c2.m5345e(this.f8274f);
        if (iM5345e2 != 1) {
            if (iM5345e2 == 6) {
                m5363n(c2358b, map);
                return;
            } else if (iM5345e2 != 7) {
                return;
            }
        }
        C2359c c2359c3 = (C2359c) map.get("BitsPerSample");
        if (c2359c3 != null) {
            int[] iArr = (int[]) c2359c3.m5347g(this.f8274f);
            int[] iArr2 = f8255m;
            if (Arrays.equals(iArr2, iArr) || (this.f8271c == 3 && (c2359c = (C2359c) map.get("PhotometricInterpretation")) != null && (((iM5345e = c2359c.m5345e(this.f8274f)) == 1 && Arrays.equals(iArr, f8256n)) || (iM5345e == 6 && Arrays.equals(iArr, iArr2))))) {
                C2359c c2359c4 = (C2359c) map.get("StripOffsets");
                C2359c c2359c5 = (C2359c) map.get("StripByteCounts");
                if (c2359c4 == null || c2359c5 == null) {
                    return;
                }
                long[] jArrM7268j = AbstractC3612b.m7268j(c2359c4.m5347g(this.f8274f));
                long[] jArrM7268j2 = AbstractC3612b.m7268j(c2359c5.m5347g(this.f8274f));
                if (jArrM7268j == null || jArrM7268j.length == 0) {
                    Log.w("ExifInterface", "stripOffsets should not be null or have zero length.");
                    return;
                }
                if (jArrM7268j2 == null || jArrM7268j2.length == 0) {
                    Log.w("ExifInterface", "stripByteCounts should not be null or have zero length.");
                    return;
                }
                if (jArrM7268j.length != jArrM7268j2.length) {
                    Log.w("ExifInterface", "stripOffsets and stripByteCounts should have same length.");
                    return;
                }
                long j10 = 0;
                for (long j11 : jArrM7268j2) {
                    j10 += j11;
                }
                byte[] bArr = new byte[(int) j10];
                this.f8275g = true;
                int i6 = 0;
                int i10 = 0;
                for (int i11 = 0; i11 < jArrM7268j.length; i11++) {
                    int i12 = (int) jArrM7268j[i11];
                    int i13 = (int) jArrM7268j2[i11];
                    if (i11 < jArrM7268j.length - 1 && i12 + i13 != jArrM7268j[i11 + 1]) {
                        this.f8275g = false;
                    }
                    int i14 = i12 - i6;
                    if (i14 < 0) {
                        Log.d("ExifInterface", "Invalid strip offset value");
                        return;
                    }
                    try {
                        c2358b.m5340a(i14);
                        int i15 = i6 + i14;
                        byte[] bArr2 = new byte[i13];
                        try {
                            c2358b.readFully(bArr2);
                            i6 = i15 + i13;
                            System.arraycopy(bArr2, 0, bArr, i10, i13);
                            i10 += i13;
                        } catch (EOFException unused) {
                            Log.d("ExifInterface", "Failed to read " + i13 + " bytes.");
                            return;
                        }
                    } catch (EOFException unused2) {
                        Log.d("ExifInterface", "Failed to skip " + i14 + " bytes.");
                        return;
                    }
                }
                if (this.f8275g) {
                    long j12 = jArrM7268j[0];
                    return;
                }
                return;
            }
        }
        if (f8254l) {
            Log.d("ExifInterface", "Unsupported data type value");
        }
    }

    public final void m5371w(int i6, int i10) throws Throwable {
        HashMap[] mapArr = this.f8272d;
        boolean zIsEmpty = mapArr[i6].isEmpty();
        boolean z7 = f8254l;
        if (zIsEmpty || mapArr[i10].isEmpty()) {
            if (z7) {
                Log.d("ExifInterface", "Cannot perform swap since only one image data exists");
                return;
            }
            return;
        }
        C2359c c2359c = (C2359c) mapArr[i6].get("ImageLength");
        C2359c c2359c2 = (C2359c) mapArr[i6].get("ImageWidth");
        C2359c c2359c3 = (C2359c) mapArr[i10].get("ImageLength");
        C2359c c2359c4 = (C2359c) mapArr[i10].get("ImageWidth");
        if (c2359c == null || c2359c2 == null) {
            if (z7) {
                Log.d("ExifInterface", "First image does not contain valid size information");
                return;
            }
            return;
        }
        if (c2359c3 == null || c2359c4 == null) {
            if (z7) {
                Log.d("ExifInterface", "Second image does not contain valid size information");
                return;
            }
            return;
        }
        int iM5345e = c2359c.m5345e(this.f8274f);
        int iM5345e2 = c2359c2.m5345e(this.f8274f);
        int iM5345e3 = c2359c3.m5345e(this.f8274f);
        int iM5345e4 = c2359c4.m5345e(this.f8274f);
        if (iM5345e >= iM5345e3 || iM5345e2 >= iM5345e4) {
            return;
        }
        HashMap map = mapArr[i6];
        mapArr[i6] = mapArr[i10];
        mapArr[i10] = map;
    }

    public final void m5372x(C2362f c2362f, int i6) throws Throwable {
        C2359c c2359cM5343c;
        C2359c c2359cM5343c2;
        HashMap[] mapArr = this.f8272d;
        C2359c c2359c = (C2359c) mapArr[i6].get("DefaultCropSize");
        C2359c c2359c2 = (C2359c) mapArr[i6].get("SensorTopBorder");
        C2359c c2359c3 = (C2359c) mapArr[i6].get("SensorLeftBorder");
        C2359c c2359c4 = (C2359c) mapArr[i6].get("SensorBottomBorder");
        C2359c c2359c5 = (C2359c) mapArr[i6].get("SensorRightBorder");
        if (c2359c != null) {
            if (c2359c.f8230a == 5) {
                C2361e[] c2361eArr = (C2361e[]) c2359c.m5347g(this.f8274f);
                if (c2361eArr == null || c2361eArr.length != 2) {
                    Log.w("ExifInterface", "Invalid crop size values. cropSize=" + Arrays.toString(c2361eArr));
                    return;
                }
                c2359cM5343c = C2359c.m5342b(c2361eArr[0], this.f8274f);
                c2359cM5343c2 = C2359c.m5342b(c2361eArr[1], this.f8274f);
            } else {
                int[] iArr = (int[]) c2359c.m5347g(this.f8274f);
                if (iArr == null || iArr.length != 2) {
                    Log.w("ExifInterface", "Invalid crop size values. cropSize=" + Arrays.toString(iArr));
                    return;
                }
                c2359cM5343c = C2359c.m5343c(iArr[0], this.f8274f);
                c2359cM5343c2 = C2359c.m5343c(iArr[1], this.f8274f);
            }
            mapArr[i6].put("ImageWidth", c2359cM5343c);
            mapArr[i6].put("ImageLength", c2359cM5343c2);
            return;
        }
        if (c2359c2 != null && c2359c3 != null && c2359c4 != null && c2359c5 != null) {
            int iM5345e = c2359c2.m5345e(this.f8274f);
            int iM5345e2 = c2359c4.m5345e(this.f8274f);
            int iM5345e3 = c2359c5.m5345e(this.f8274f);
            int iM5345e4 = c2359c3.m5345e(this.f8274f);
            if (iM5345e2 <= iM5345e || iM5345e3 <= iM5345e4) {
                return;
            }
            C2359c c2359cM5343c3 = C2359c.m5343c(iM5345e2 - iM5345e, this.f8274f);
            C2359c c2359cM5343c4 = C2359c.m5343c(iM5345e3 - iM5345e4, this.f8274f);
            mapArr[i6].put("ImageLength", c2359cM5343c3);
            mapArr[i6].put("ImageWidth", c2359cM5343c4);
            return;
        }
        C2359c c2359c6 = (C2359c) mapArr[i6].get("ImageLength");
        C2359c c2359c7 = (C2359c) mapArr[i6].get("ImageWidth");
        if (c2359c6 == null || c2359c7 == null) {
            C2359c c2359c8 = (C2359c) mapArr[i6].get("JPEGInterchangeFormat");
            C2359c c2359c9 = (C2359c) mapArr[i6].get("JPEGInterchangeFormatLength");
            if (c2359c8 == null || c2359c9 == null) {
                return;
            }
            int iM5345e5 = c2359c8.m5345e(this.f8274f);
            int iM5345e6 = c2359c8.m5345e(this.f8274f);
            c2362f.m5348b(iM5345e5);
            byte[] bArr = new byte[iM5345e6];
            c2362f.readFully(bArr);
            m5355f(new C2358b(bArr), iM5345e5, i6);
        }
    }

    public final void m5373y() throws Throwable {
        m5371w(0, 5);
        m5371w(0, 4);
        m5371w(5, 4);
        HashMap[] mapArr = this.f8272d;
        C2359c c2359c = (C2359c) mapArr[1].get("PixelXDimension");
        C2359c c2359c2 = (C2359c) mapArr[1].get("PixelYDimension");
        if (c2359c != null && c2359c2 != null) {
            mapArr[0].put("ImageWidth", c2359c);
            mapArr[0].put("ImageLength", c2359c2);
        }
        if (mapArr[4].isEmpty() && m5364o(mapArr[5])) {
            mapArr[4] = mapArr[5];
            mapArr[5] = new HashMap();
        }
        if (!m5364o(mapArr[4])) {
            Log.d("ExifInterface", "No image meets the size requirements of a thumbnail image.");
        }
        m5369u(0, "ThumbnailOrientation", "Orientation");
        m5369u(0, "ThumbnailImageLength", "ImageLength");
        m5369u(0, "ThumbnailImageWidth", "ImageWidth");
        m5369u(5, "ThumbnailOrientation", "Orientation");
        m5369u(5, "ThumbnailImageLength", "ImageLength");
        m5369u(5, "ThumbnailImageWidth", "ImageWidth");
        m5369u(4, "Orientation", "ThumbnailOrientation");
        m5369u(4, "ImageLength", "ThumbnailImageLength");
        m5369u(4, "ImageWidth", "ThumbnailImageWidth");
    }
}
