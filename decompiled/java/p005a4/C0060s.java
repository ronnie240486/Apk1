package p005a4;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.Base64;
import android.view.SurfaceView;
import androidx.media3.common.AbstractC0592e;
import androidx.media3.common.DebugViewProvider;
import androidx.media3.common.FlagSet;
import androidx.media3.common.Player;
import androidx.media3.common.util.ListenerSet;
import androidx.media3.datasource.DataSpec;
import androidx.media3.datasource.cache.AbstractC0644a;
import androidx.media3.datasource.cache.CacheKeyFactory;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import androidx.media3.exoplayer.analytics.DefaultAnalyticsCollector;
import androidx.media3.exoplayer.image.BitmapFactoryImageDecoder;
import androidx.media3.extractor.AbstractC1010c;
import androidx.media3.extractor.DefaultExtractorsFactory;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorsFactory;
import androidx.media3.extractor.amr.AmrExtractor;
import androidx.media3.extractor.flac.FlacExtractor;
import androidx.media3.extractor.flv.FlvExtractor;
import androidx.media3.extractor.metadata.id3.Id3Decoder;
import androidx.media3.extractor.mkv.MatroskaExtractor;
import androidx.media3.extractor.mp3.Mp3Extractor;
import androidx.media3.extractor.mp4.FragmentedMp4Extractor;
import androidx.media3.extractor.mp4.Mp4Extractor;
import androidx.media3.extractor.ogg.OggExtractor;
import androidx.media3.extractor.p010ts.Ac3Extractor;
import androidx.media3.extractor.p010ts.Ac4Extractor;
import androidx.media3.extractor.p010ts.AdtsExtractor;
import androidx.media3.extractor.p010ts.PsExtractor;
import androidx.media3.extractor.p010ts.TsExtractor;
import androidx.media3.extractor.text.SubtitleParser;
import androidx.media3.extractor.wav.WavExtractor;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Map;
import p002a1.C0026b;
import p087i4.InterfaceC2700e;
import p122l4.AbstractC2972a;

public final class C0060s implements DebugViewProvider, ListenerSet.Event, CacheKeyFactory, ListenerSet.IterationFinishedEvent, BitmapFactoryImageDecoder.BitmapDecoder, DefaultExtractorsFactory.ExtensionLoader.ConstructorSupplier, ExtractorsFactory, Id3Decoder.FramePredicate, InterfaceC2700e {

    public final int f169a;

    public C0060s(int i6) {
        this.f169a = i6;
    }

    @Override
    public Object apply(Object obj) {
        Cursor cursorRawQuery = ((SQLiteDatabase) obj).rawQuery("SELECT distinct t._id, t.backend_name, t.priority, t.extras FROM transport_contexts AS t, events AS e WHERE e.context_id = t._id", new String[0]);
        try {
            ArrayList arrayList = new ArrayList();
            while (cursorRawQuery.moveToNext()) {
                C0026b c0026bM203a = C0051j.m203a();
                c0026bM203a.m121G(cursorRawQuery.getString(1));
                c0026bM203a.f56d = AbstractC2972a.m6009b(cursorRawQuery.getInt(2));
                String string = cursorRawQuery.getString(3);
                c0026bM203a.f55c = string == null ? null : Base64.decode(string, 0);
                arrayList.add(c0026bM203a.m130h());
            }
            return arrayList;
        } finally {
            cursorRawQuery.close();
        }
    }

    @Override
    public String buildCacheKey(DataSpec dataSpec) {
        return AbstractC0644a.m1778a(dataSpec);
    }

    @Override
    public Extractor[] createExtractors() {
        switch (this.f169a) {
            case 8:
                return AbstractC1010c.m2651e();
            case 9:
                return AmrExtractor.lambda$static$0();
            case 10:
                return FlacExtractor.lambda$static$0();
            case 11:
                return FlvExtractor.lambda$static$0();
            case 12:
            case 15:
            default:
                return WavExtractor.lambda$static$0();
            case 13:
                return MatroskaExtractor.lambda$static$1();
            case 14:
                return Mp3Extractor.lambda$static$0();
            case 16:
                return FragmentedMp4Extractor.lambda$static$1();
            case 17:
                return Mp4Extractor.lambda$static$1();
            case 18:
                return OggExtractor.lambda$static$0();
            case 19:
                return Ac3Extractor.lambda$static$0();
            case 20:
                return Ac4Extractor.lambda$static$0();
            case 21:
                return AdtsExtractor.lambda$static$0();
            case 22:
                return PsExtractor.lambda$static$0();
            case 23:
                return TsExtractor.lambda$static$1();
        }
    }

    @Override
    public Bitmap decode(byte[] bArr, int i6) {
        return BitmapFactoryImageDecoder.access$100(bArr, i6);
    }

    @Override
    public boolean evaluate(int i6, int i10, int i11, int i12, int i13) {
        switch (this.f169a) {
            case 12:
                return Id3Decoder.lambda$static$0(i6, i10, i11, i12, i13);
            default:
                return Mp3Extractor.lambda$static$1(i6, i10, i11, i12, i13);
        }
    }

    @Override
    public ExtractorsFactory experimentalSetCodecsToParseWithinGopSampleDependencies(int i6) {
        int i10 = this.f169a;
        return AbstractC1010c.m2648b(this, i6);
    }

    @Override
    public ExtractorsFactory experimentalSetTextTrackTranscodingEnabled(boolean z7) {
        int i6 = this.f169a;
        return AbstractC1010c.m2649c(this, z7);
    }

    @Override
    public Constructor getConstructor() {
        switch (this.f169a) {
            case 6:
                return DefaultExtractorsFactory.getFlacExtractorConstructor();
            default:
                return DefaultExtractorsFactory.getMidiExtractorConstructor();
        }
    }

    @Override
    public SurfaceView getDebugPreviewSurfaceView(int i6, int i10) {
        return AbstractC0592e.m1645a(i6, i10);
    }

    @Override
    public void invoke(Object obj) {
        ((Player.Listener) obj).onRenderedFirstFrame();
    }

    @Override
    public ExtractorsFactory setSubtitleParserFactory(SubtitleParser.Factory factory) {
        int i6 = this.f169a;
        return AbstractC1010c.m2650d(this, factory);
    }

    @Override
    public Extractor[] createExtractors(Uri uri, Map map) {
        int i6 = this.f169a;
        return AbstractC1010c.m2647a(this, uri, map);
    }

    @Override
    public void invoke(Object obj, FlagSet flagSet) {
        DefaultAnalyticsCollector.lambda$new$0((AnalyticsListener) obj, flagSet);
    }
}
