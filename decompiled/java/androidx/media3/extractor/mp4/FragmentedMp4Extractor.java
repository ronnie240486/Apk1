package androidx.media3.extractor.mp4;

import android.util.Pair;
import android.util.SparseArray;
import androidx.media3.common.C0565C;
import androidx.media3.common.C0628x;
import androidx.media3.common.DataReader;
import androidx.media3.common.DrmInitData;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.TimestampAdjuster;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.container.Mp4Box;
import androidx.media3.container.NalUnitUtil;
import androidx.media3.container.ReorderingSeiMessageQueue;
import androidx.media3.extractor.AbstractC1009b;
import androidx.media3.extractor.Ac4Util;
import androidx.media3.extractor.CeaUtil;
import androidx.media3.extractor.ChunkIndex;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.ExtractorsFactory;
import androidx.media3.extractor.GaplessInfoHolder;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.SniffFailure;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.metadata.emsg.EventMessage;
import androidx.media3.extractor.metadata.emsg.EventMessageEncoder;
import androidx.media3.extractor.mkv.C1018a;
import androidx.media3.extractor.p010ts.PsExtractor;
import androidx.media3.extractor.text.SubtitleParser;
import androidx.media3.extractor.text.SubtitleTranscodingExtractorOutput;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import p000a.AbstractC0004e;
import p005a4.C0060s;
import p020b7.InterfaceC1346i;
import p041d7.AbstractC2301u1;
import p041d7.C2180c5;
import p041d7.C2204g1;

@UnstableApi
public class FragmentedMp4Extractor implements Extractor {
    private static final int EXTRA_TRACKS_BASE_ID = 100;
    public static final int FLAG_EMIT_RAW_SUBTITLE_DATA = 32;
    public static final int FLAG_ENABLE_EMSG_TRACK = 4;
    public static final int FLAG_READ_WITHIN_GOP_SAMPLE_DEPENDENCIES = 64;
    public static final int FLAG_READ_WITHIN_GOP_SAMPLE_DEPENDENCIES_H265 = 128;
    public static final int FLAG_WORKAROUND_EVERY_VIDEO_FRAME_IS_SYNC_FRAME = 1;
    public static final int FLAG_WORKAROUND_IGNORE_EDIT_LISTS = 16;
    public static final int FLAG_WORKAROUND_IGNORE_TFDT_BOX = 2;
    private static final int SAMPLE_GROUP_TYPE_seig = 1936025959;
    private static final int STATE_READING_ATOM_HEADER = 0;
    private static final int STATE_READING_ATOM_PAYLOAD = 1;
    private static final int STATE_READING_ENCRYPTION_DATA = 2;
    private static final int STATE_READING_SAMPLE_CONTINUE = 4;
    private static final int STATE_READING_SAMPLE_START = 3;
    private static final String TAG = "FragmentedMp4Extractor";
    private final TrackOutput additionalEmsgTrackOutput;
    private ParsableByteArray atomData;
    private final ParsableByteArray atomHeader;
    private int atomHeaderBytesRead;
    private long atomSize;
    private int atomType;
    private TrackOutput[] ceaTrackOutputs;
    private final List<Format> closedCaptionFormats;
    private final ArrayDeque<Mp4Box.ContainerBox> containerAtoms;
    private TrackBundle currentTrackBundle;
    private long durationUs;
    private TrackOutput[] emsgTrackOutputs;
    private long endOfMdatPosition;
    private final EventMessageEncoder eventMessageEncoder;
    private ExtractorOutput extractorOutput;
    private final int flags;
    private boolean haveOutputSeekMap;
    private boolean isSampleDependedOn;
    private AbstractC2301u1 lastSniffFailures;
    private final ParsableByteArray nalPrefix;
    private final ParsableByteArray nalStartCode;
    private final ParsableByteArray nalUnitWithoutHeaderBuffer;
    private int parserState;
    private int pendingMetadataSampleBytes;
    private final ArrayDeque<MetadataSampleInfo> pendingMetadataSampleInfos;
    private long pendingSeekTimeUs;
    private boolean processSeiNalUnitPayload;
    private final ReorderingSeiMessageQueue reorderingSeiMessageQueue;
    private int sampleBytesWritten;
    private int sampleCurrentNalBytesRemaining;
    private int sampleSize;
    private final ParsableByteArray scratch;
    private final byte[] scratchBytes;
    private long segmentIndexEarliestPresentationTimeUs;
    private final Track sideloadedTrack;
    private final SubtitleParser.Factory subtitleParserFactory;
    private final TimestampAdjuster timestampAdjuster;
    private final SparseArray<TrackBundle> trackBundles;

    @Deprecated
    public static final ExtractorsFactory FACTORY = new C0060s(16);
    private static final byte[] PIFF_SAMPLE_ENCRYPTION_BOX_EXTENDED_TYPE = {-94, 57, 79, 82, 90, -101, 79, 20, -94, 68, 108, 66, 124, 100, -115, -12};
    private static final Format EMSG_FORMAT = new Format.Builder().setSampleMimeType(MimeTypes.APPLICATION_EMSG).build();

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    public static final class MetadataSampleInfo {
        public final boolean sampleTimeIsRelative;
        public final long sampleTimeUs;
        public final int size;

        public MetadataSampleInfo(long j10, boolean z7, int i6) {
            this.sampleTimeUs = j10;
            this.sampleTimeIsRelative = z7;
            this.size = i6;
        }
    }

    public static final class TrackBundle {
        private static final int SINGLE_SUBSAMPLE_ENCRYPTION_DATA_LENGTH = 8;
        private final String containerMimeType;
        public int currentSampleInTrackRun;
        public int currentSampleIndex;
        public int currentTrackRunIndex;
        private boolean currentlyInFragment;
        public DefaultSampleValues defaultSampleValues;
        public int firstSampleToOutputIndex;
        public TrackSampleTable moovSampleTable;
        public final TrackOutput output;
        public final TrackFragment fragment = new TrackFragment();
        public final ParsableByteArray scratch = new ParsableByteArray();
        private final ParsableByteArray encryptionSignalByte = new ParsableByteArray(1);
        private final ParsableByteArray defaultInitializationVector = new ParsableByteArray();

        public TrackBundle(TrackOutput trackOutput, TrackSampleTable trackSampleTable, DefaultSampleValues defaultSampleValues, String str) {
            this.output = trackOutput;
            this.moovSampleTable = trackSampleTable;
            this.defaultSampleValues = defaultSampleValues;
            this.containerMimeType = str;
            reset(trackSampleTable, defaultSampleValues);
        }

        public int getCurrentSampleFlags() {
            int i6;
            if (this.currentlyInFragment) {
                i6 = this.fragment.sampleIsSyncFrameTable[this.currentSampleIndex] ? 1 : 0;
            } else {
                i6 = this.moovSampleTable.flags[this.currentSampleIndex];
            }
            return getEncryptionBoxIfEncrypted() != null ? i6 | 1073741824 : i6;
        }

        public long getCurrentSampleOffset() {
            return !this.currentlyInFragment ? this.moovSampleTable.offsets[this.currentSampleIndex] : this.fragment.trunDataPosition[this.currentTrackRunIndex];
        }

        public long getCurrentSamplePresentationTimeUs() {
            return !this.currentlyInFragment ? this.moovSampleTable.timestampsUs[this.currentSampleIndex] : this.fragment.getSamplePresentationTimeUs(this.currentSampleIndex);
        }

        public int getCurrentSampleSize() {
            return !this.currentlyInFragment ? this.moovSampleTable.sizes[this.currentSampleIndex] : this.fragment.sampleSizeTable[this.currentSampleIndex];
        }

        public TrackEncryptionBox getEncryptionBoxIfEncrypted() {
            if (!this.currentlyInFragment) {
                return null;
            }
            int i6 = ((DefaultSampleValues) Util.castNonNull(this.fragment.header)).sampleDescriptionIndex;
            TrackEncryptionBox sampleDescriptionEncryptionBox = this.fragment.trackEncryptionBox;
            if (sampleDescriptionEncryptionBox == null) {
                sampleDescriptionEncryptionBox = this.moovSampleTable.track.getSampleDescriptionEncryptionBox(i6);
            }
            if (sampleDescriptionEncryptionBox == null || !sampleDescriptionEncryptionBox.isEncrypted) {
                return null;
            }
            return sampleDescriptionEncryptionBox;
        }

        public boolean next() {
            this.currentSampleIndex++;
            if (!this.currentlyInFragment) {
                return false;
            }
            int i6 = this.currentSampleInTrackRun + 1;
            this.currentSampleInTrackRun = i6;
            int[] iArr = this.fragment.trunLength;
            int i10 = this.currentTrackRunIndex;
            if (i6 != iArr[i10]) {
                return true;
            }
            this.currentTrackRunIndex = i10 + 1;
            this.currentSampleInTrackRun = 0;
            return false;
        }

        public int outputSampleEncryptionData(int i6, int i10) {
            ParsableByteArray parsableByteArray;
            TrackEncryptionBox encryptionBoxIfEncrypted = getEncryptionBoxIfEncrypted();
            if (encryptionBoxIfEncrypted == null) {
                return 0;
            }
            int length = encryptionBoxIfEncrypted.perSampleIvSize;
            if (length != 0) {
                parsableByteArray = this.fragment.sampleEncryptionData;
            } else {
                byte[] bArr = (byte[]) Util.castNonNull(encryptionBoxIfEncrypted.defaultInitializationVector);
                this.defaultInitializationVector.reset(bArr, bArr.length);
                ParsableByteArray parsableByteArray2 = this.defaultInitializationVector;
                length = bArr.length;
                parsableByteArray = parsableByteArray2;
            }
            boolean zSampleHasSubsampleEncryptionTable = this.fragment.sampleHasSubsampleEncryptionTable(this.currentSampleIndex);
            boolean z7 = zSampleHasSubsampleEncryptionTable || i10 != 0;
            this.encryptionSignalByte.getData()[0] = (byte) ((z7 ? 128 : 0) | length);
            this.encryptionSignalByte.setPosition(0);
            this.output.sampleData(this.encryptionSignalByte, 1, 1);
            this.output.sampleData(parsableByteArray, length, 1);
            if (!z7) {
                return length + 1;
            }
            if (!zSampleHasSubsampleEncryptionTable) {
                this.scratch.reset(8);
                byte[] data = this.scratch.getData();
                data[0] = 0;
                data[1] = 1;
                data[2] = (byte) ((i10 >> 8) & 255);
                data[3] = (byte) (i10 & 255);
                data[4] = (byte) ((i6 >> 24) & 255);
                data[5] = (byte) ((i6 >> 16) & 255);
                data[6] = (byte) ((i6 >> 8) & 255);
                data[7] = (byte) (i6 & 255);
                this.output.sampleData(this.scratch, 8, 1);
                return length + 9;
            }
            ParsableByteArray parsableByteArray3 = this.fragment.sampleEncryptionData;
            int unsignedShort = parsableByteArray3.readUnsignedShort();
            parsableByteArray3.skipBytes(-2);
            int i11 = (unsignedShort * 6) + 2;
            if (i10 != 0) {
                this.scratch.reset(i11);
                byte[] data2 = this.scratch.getData();
                parsableByteArray3.readBytes(data2, 0, i11);
                int i12 = (((data2[2] & 255) << 8) | (data2[3] & 255)) + i10;
                data2[2] = (byte) ((i12 >> 8) & 255);
                data2[3] = (byte) (i12 & 255);
                parsableByteArray3 = this.scratch;
            }
            this.output.sampleData(parsableByteArray3, i11, 1);
            return length + 1 + i11;
        }

        public void reset(TrackSampleTable trackSampleTable, DefaultSampleValues defaultSampleValues) {
            this.moovSampleTable = trackSampleTable;
            this.defaultSampleValues = defaultSampleValues;
            this.output.format(trackSampleTable.track.format.buildUpon().setContainerMimeType(this.containerMimeType).build());
            resetFragmentInfo();
        }

        public void resetFragmentInfo() {
            this.fragment.reset();
            this.currentSampleIndex = 0;
            this.currentTrackRunIndex = 0;
            this.currentSampleInTrackRun = 0;
            this.firstSampleToOutputIndex = 0;
            this.currentlyInFragment = false;
        }

        public void seek(long j10) {
            int i6 = this.currentSampleIndex;
            while (true) {
                TrackFragment trackFragment = this.fragment;
                if (i6 >= trackFragment.sampleCount || trackFragment.getSamplePresentationTimeUs(i6) > j10) {
                    return;
                }
                if (this.fragment.sampleIsSyncFrameTable[i6]) {
                    this.firstSampleToOutputIndex = i6;
                }
                i6++;
            }
        }

        public void skipSampleEncryptionData() {
            TrackEncryptionBox encryptionBoxIfEncrypted = getEncryptionBoxIfEncrypted();
            if (encryptionBoxIfEncrypted == null) {
                return;
            }
            ParsableByteArray parsableByteArray = this.fragment.sampleEncryptionData;
            int i6 = encryptionBoxIfEncrypted.perSampleIvSize;
            if (i6 != 0) {
                parsableByteArray.skipBytes(i6);
            }
            if (this.fragment.sampleHasSubsampleEncryptionTable(this.currentSampleIndex)) {
                parsableByteArray.skipBytes(parsableByteArray.readUnsignedShort() * 6);
            }
        }

        public void updateDrmInitData(DrmInitData drmInitData) {
            TrackEncryptionBox sampleDescriptionEncryptionBox = this.moovSampleTable.track.getSampleDescriptionEncryptionBox(((DefaultSampleValues) Util.castNonNull(this.fragment.header)).sampleDescriptionIndex);
            this.output.format(this.moovSampleTable.track.format.buildUpon().setContainerMimeType(this.containerMimeType).setDrmInitData(drmInitData.copyWithSchemeType(sampleDescriptionEncryptionBox != null ? sampleDescriptionEncryptionBox.schemeType : null)).build());
        }
    }

    @Deprecated
    public FragmentedMp4Extractor() {
        SubtitleParser.Factory factory = SubtitleParser.Factory.UNSUPPORTED;
        C2204g1 c2204g1 = AbstractC2301u1.f8069b;
        this(factory, 32, null, null, C2180c5.f7862e, null);
    }

    private boolean canReadWithinGopSampleDependencies(Format format) {
        if (Objects.equals(format.sampleMimeType, MimeTypes.VIDEO_H264)) {
            return (this.flags & 64) != 0;
        }
        return Objects.equals(format.sampleMimeType, MimeTypes.VIDEO_H265) && (this.flags & 128) != 0;
    }

    private static int checkNonNegative(int i6) throws ParserException {
        if (i6 >= 0) {
            return i6;
        }
        throw ParserException.createForMalformedContainer("Unexpected negative value: " + i6, null);
    }

    public static int codecsToParseWithinGopSampleDependenciesAsFlags(int i6) {
        int i10 = (i6 & 1) != 0 ? 64 : 0;
        return (i6 & 2) != 0 ? i10 | 128 : i10;
    }

    private void enterReadingAtomHeaderState() {
        this.parserState = 0;
        this.atomHeaderBytesRead = 0;
    }

    private DefaultSampleValues getDefaultSampleValues(SparseArray<DefaultSampleValues> sparseArray, int i6) {
        return sparseArray.size() == 1 ? sparseArray.valueAt(0) : (DefaultSampleValues) Assertions.checkNotNull(sparseArray.get(i6));
    }

    private static DrmInitData getDrmInitDataFromAtoms(List<Mp4Box.LeafBox> list) {
        int size = list.size();
        ArrayList arrayList = null;
        for (int i6 = 0; i6 < size; i6++) {
            Mp4Box.LeafBox leafBox = list.get(i6);
            if (leafBox.type == 1886614376) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                byte[] data = leafBox.data.getData();
                UUID uuid = PsshAtomUtil.parseUuid(data);
                if (uuid == null) {
                    Log.m1719w(TAG, "Skipped pssh atom (failed to extract uuid)");
                } else {
                    arrayList.add(new DrmInitData.SchemeData(uuid, MimeTypes.VIDEO_MP4, data));
                }
            }
        }
        if (arrayList == null) {
            return null;
        }
        return new DrmInitData(arrayList);
    }

    private static TrackBundle getNextTrackBundle(SparseArray<TrackBundle> sparseArray) {
        int size = sparseArray.size();
        TrackBundle trackBundle = null;
        long j10 = Long.MAX_VALUE;
        for (int i6 = 0; i6 < size; i6++) {
            TrackBundle trackBundleValueAt = sparseArray.valueAt(i6);
            if ((trackBundleValueAt.currentlyInFragment || trackBundleValueAt.currentSampleIndex != trackBundleValueAt.moovSampleTable.sampleCount) && (!trackBundleValueAt.currentlyInFragment || trackBundleValueAt.currentTrackRunIndex != trackBundleValueAt.fragment.trunCount)) {
                long currentSampleOffset = trackBundleValueAt.getCurrentSampleOffset();
                if (currentSampleOffset < j10) {
                    trackBundle = trackBundleValueAt;
                    j10 = currentSampleOffset;
                }
            }
        }
        return trackBundle;
    }

    private void initExtraTracks() {
        int i6;
        TrackOutput[] trackOutputArr = new TrackOutput[2];
        this.emsgTrackOutputs = trackOutputArr;
        TrackOutput trackOutput = this.additionalEmsgTrackOutput;
        int i10 = 0;
        if (trackOutput != null) {
            trackOutputArr[0] = trackOutput;
            i6 = 1;
        } else {
            i6 = 0;
        }
        int i11 = 100;
        if ((this.flags & 4) != 0) {
            trackOutputArr[i6] = this.extractorOutput.track(100, 5);
            i11 = 101;
            i6++;
        }
        TrackOutput[] trackOutputArr2 = (TrackOutput[]) Util.nullSafeArrayCopy(this.emsgTrackOutputs, i6);
        this.emsgTrackOutputs = trackOutputArr2;
        for (TrackOutput trackOutput2 : trackOutputArr2) {
            trackOutput2.format(EMSG_FORMAT);
        }
        this.ceaTrackOutputs = new TrackOutput[this.closedCaptionFormats.size()];
        while (i10 < this.ceaTrackOutputs.length) {
            TrackOutput trackOutputTrack = this.extractorOutput.track(i11, 3);
            trackOutputTrack.format(this.closedCaptionFormats.get(i10));
            this.ceaTrackOutputs[i10] = trackOutputTrack;
            i10++;
            i11++;
        }
    }

    private static boolean isEdtsListDurationForEntireMediaTimeline(Track track) {
        long[] jArr = track.editListDurations;
        if (jArr == null || jArr.length != 1 || track.editListMediaTimes == null) {
            return false;
        }
        long j10 = jArr[0];
        return j10 == 0 || Util.scaleLargeTimestamp(j10, 1000000L, track.movieTimescale) + Util.scaleLargeTimestamp(track.editListMediaTimes[0], 1000000L, track.timescale) >= track.durationUs;
    }

    public void lambda$new$2(long j10, ParsableByteArray parsableByteArray) {
        CeaUtil.consume(j10, parsableByteArray, this.ceaTrackOutputs);
    }

    public static Extractor[] lambda$newFactory$0(SubtitleParser.Factory factory) {
        return new Extractor[]{new FragmentedMp4Extractor(factory)};
    }

    public static Extractor[] lambda$static$1() {
        return new Extractor[]{new FragmentedMp4Extractor(SubtitleParser.Factory.UNSUPPORTED, 32)};
    }

    public static ExtractorsFactory newFactory(SubtitleParser.Factory factory) {
        return new C1018a(factory, 1);
    }

    private void onContainerAtomRead(Mp4Box.ContainerBox containerBox) throws ParserException {
        int i6 = containerBox.type;
        if (i6 == 1836019574) {
            onMoovContainerAtomRead(containerBox);
        } else if (i6 == 1836019558) {
            onMoofContainerAtomRead(containerBox);
        } else {
            if (this.containerAtoms.isEmpty()) {
                return;
            }
            this.containerAtoms.peek().add(containerBox);
        }
    }

    private void onEmsgLeafAtomRead(ParsableByteArray parsableByteArray) {
        long jScaleLargeTimestamp;
        String str;
        long jScaleLargeTimestamp2;
        String str2;
        long unsignedInt;
        long jAdjustSampleTimestamp;
        if (this.emsgTrackOutputs.length == 0) {
            return;
        }
        parsableByteArray.setPosition(8);
        int fullBoxVersion = BoxParser.parseFullBoxVersion(parsableByteArray.readInt());
        if (fullBoxVersion == 0) {
            String str3 = (String) Assertions.checkNotNull(parsableByteArray.readNullTerminatedString());
            String str4 = (String) Assertions.checkNotNull(parsableByteArray.readNullTerminatedString());
            long unsignedInt2 = parsableByteArray.readUnsignedInt();
            jScaleLargeTimestamp = Util.scaleLargeTimestamp(parsableByteArray.readUnsignedInt(), 1000000L, unsignedInt2);
            long j10 = this.segmentIndexEarliestPresentationTimeUs;
            long j11 = j10 != C0565C.TIME_UNSET ? j10 + jScaleLargeTimestamp : -9223372036854775807L;
            str = str3;
            jScaleLargeTimestamp2 = Util.scaleLargeTimestamp(parsableByteArray.readUnsignedInt(), 1000L, unsignedInt2);
            str2 = str4;
            unsignedInt = parsableByteArray.readUnsignedInt();
            jAdjustSampleTimestamp = j11;
        } else {
            if (fullBoxVersion != 1) {
                AbstractC0004e.m31y(fullBoxVersion, "Skipping unsupported emsg version: ", TAG);
                return;
            }
            long unsignedInt3 = parsableByteArray.readUnsignedInt();
            jAdjustSampleTimestamp = Util.scaleLargeTimestamp(parsableByteArray.readUnsignedLongToLong(), 1000000L, unsignedInt3);
            long jScaleLargeTimestamp3 = Util.scaleLargeTimestamp(parsableByteArray.readUnsignedInt(), 1000L, unsignedInt3);
            long unsignedInt4 = parsableByteArray.readUnsignedInt();
            str = (String) Assertions.checkNotNull(parsableByteArray.readNullTerminatedString());
            jScaleLargeTimestamp2 = jScaleLargeTimestamp3;
            unsignedInt = unsignedInt4;
            str2 = (String) Assertions.checkNotNull(parsableByteArray.readNullTerminatedString());
            jScaleLargeTimestamp = -9223372036854775807L;
        }
        byte[] bArr = new byte[parsableByteArray.bytesLeft()];
        parsableByteArray.readBytes(bArr, 0, parsableByteArray.bytesLeft());
        ParsableByteArray parsableByteArray2 = new ParsableByteArray(this.eventMessageEncoder.encode(new EventMessage(str, str2, jScaleLargeTimestamp2, unsignedInt, bArr)));
        int iBytesLeft = parsableByteArray2.bytesLeft();
        for (TrackOutput trackOutput : this.emsgTrackOutputs) {
            parsableByteArray2.setPosition(0);
            trackOutput.sampleData(parsableByteArray2, iBytesLeft);
        }
        if (jAdjustSampleTimestamp == C0565C.TIME_UNSET) {
            this.pendingMetadataSampleInfos.addLast(new MetadataSampleInfo(jScaleLargeTimestamp, true, iBytesLeft));
            this.pendingMetadataSampleBytes += iBytesLeft;
            return;
        }
        if (!this.pendingMetadataSampleInfos.isEmpty()) {
            this.pendingMetadataSampleInfos.addLast(new MetadataSampleInfo(jAdjustSampleTimestamp, false, iBytesLeft));
            this.pendingMetadataSampleBytes += iBytesLeft;
            return;
        }
        TimestampAdjuster timestampAdjuster = this.timestampAdjuster;
        if (timestampAdjuster != null && !timestampAdjuster.isInitialized()) {
            this.pendingMetadataSampleInfos.addLast(new MetadataSampleInfo(jAdjustSampleTimestamp, false, iBytesLeft));
            this.pendingMetadataSampleBytes += iBytesLeft;
            return;
        }
        TimestampAdjuster timestampAdjuster2 = this.timestampAdjuster;
        if (timestampAdjuster2 != null) {
            jAdjustSampleTimestamp = timestampAdjuster2.adjustSampleTimestamp(jAdjustSampleTimestamp);
        }
        for (TrackOutput trackOutput2 : this.emsgTrackOutputs) {
            trackOutput2.sampleMetadata(jAdjustSampleTimestamp, 1, iBytesLeft, 0, null);
        }
    }

    private void onLeafAtomRead(Mp4Box.LeafBox leafBox, long j10) throws ParserException {
        if (!this.containerAtoms.isEmpty()) {
            this.containerAtoms.peek().add(leafBox);
            return;
        }
        int i6 = leafBox.type;
        if (i6 != 1936286840) {
            if (i6 == 1701671783) {
                onEmsgLeafAtomRead(leafBox.data);
            }
        } else {
            Pair<Long, ChunkIndex> sidx = parseSidx(leafBox.data, j10);
            this.segmentIndexEarliestPresentationTimeUs = ((Long) sidx.first).longValue();
            this.extractorOutput.seekMap((SeekMap) sidx.second);
            this.haveOutputSeekMap = true;
        }
    }

    private void onMoofContainerAtomRead(Mp4Box.ContainerBox containerBox) throws ParserException {
        parseMoof(containerBox, this.trackBundles, this.sideloadedTrack != null, this.flags, this.scratchBytes);
        DrmInitData drmInitDataFromAtoms = getDrmInitDataFromAtoms(containerBox.leafChildren);
        if (drmInitDataFromAtoms != null) {
            int size = this.trackBundles.size();
            for (int i6 = 0; i6 < size; i6++) {
                this.trackBundles.valueAt(i6).updateDrmInitData(drmInitDataFromAtoms);
            }
        }
        if (this.pendingSeekTimeUs != C0565C.TIME_UNSET) {
            int size2 = this.trackBundles.size();
            for (int i10 = 0; i10 < size2; i10++) {
                this.trackBundles.valueAt(i10).seek(this.pendingSeekTimeUs);
            }
            this.pendingSeekTimeUs = C0565C.TIME_UNSET;
        }
    }

    private void onMoovContainerAtomRead(Mp4Box.ContainerBox containerBox) throws ParserException {
        int i6 = 0;
        Assertions.checkState(this.sideloadedTrack == null, "Unexpected moov box.");
        DrmInitData drmInitDataFromAtoms = getDrmInitDataFromAtoms(containerBox.leafChildren);
        Mp4Box.ContainerBox containerBox2 = (Mp4Box.ContainerBox) Assertions.checkNotNull(containerBox.getContainerBoxOfType(Mp4Box.TYPE_mvex));
        SparseArray<DefaultSampleValues> sparseArray = new SparseArray<>();
        int size = containerBox2.leafChildren.size();
        long mehd = -9223372036854775807L;
        for (int i10 = 0; i10 < size; i10++) {
            Mp4Box.LeafBox leafBox = containerBox2.leafChildren.get(i10);
            int i11 = leafBox.type;
            if (i11 == 1953654136) {
                Pair<Integer, DefaultSampleValues> trex = parseTrex(leafBox.data);
                sparseArray.put(((Integer) trex.first).intValue(), (DefaultSampleValues) trex.second);
            } else if (i11 == 1835362404) {
                mehd = parseMehd(leafBox.data);
            }
        }
        List<TrackSampleTable> traks = BoxParser.parseTraks(containerBox, new GaplessInfoHolder(), mehd, drmInitDataFromAtoms, (this.flags & 16) != 0, false, new InterfaceC1346i() {
            @Override
            public final Object apply(Object obj) {
                return this.f3101a.modifyTrack((Track) obj);
            }
        });
        int size2 = traks.size();
        if (this.trackBundles.size() != 0) {
            Assertions.checkState(this.trackBundles.size() == size2);
            while (i6 < size2) {
                TrackSampleTable trackSampleTable = traks.get(i6);
                Track track = trackSampleTable.track;
                this.trackBundles.get(track.f3100id).reset(trackSampleTable, getDefaultSampleValues(sparseArray, track.f3100id));
                i6++;
            }
            return;
        }
        String containerMimeType = MimeTypeResolver.getContainerMimeType(traks);
        while (i6 < size2) {
            TrackSampleTable trackSampleTable2 = traks.get(i6);
            Track track2 = trackSampleTable2.track;
            TrackOutput trackOutputTrack = this.extractorOutput.track(i6, track2.type);
            trackOutputTrack.durationUs(track2.durationUs);
            this.trackBundles.put(track2.f3100id, new TrackBundle(trackOutputTrack, trackSampleTable2, getDefaultSampleValues(sparseArray, track2.f3100id), containerMimeType));
            this.durationUs = Math.max(this.durationUs, track2.durationUs);
            i6++;
        }
        this.extractorOutput.endTracks();
    }

    private void outputPendingMetadataSamples(long j10) {
        while (!this.pendingMetadataSampleInfos.isEmpty()) {
            MetadataSampleInfo metadataSampleInfoRemoveFirst = this.pendingMetadataSampleInfos.removeFirst();
            this.pendingMetadataSampleBytes -= metadataSampleInfoRemoveFirst.size;
            long jAdjustSampleTimestamp = metadataSampleInfoRemoveFirst.sampleTimeUs;
            if (metadataSampleInfoRemoveFirst.sampleTimeIsRelative) {
                jAdjustSampleTimestamp += j10;
            }
            TimestampAdjuster timestampAdjuster = this.timestampAdjuster;
            if (timestampAdjuster != null) {
                jAdjustSampleTimestamp = timestampAdjuster.adjustSampleTimestamp(jAdjustSampleTimestamp);
            }
            for (TrackOutput trackOutput : this.emsgTrackOutputs) {
                trackOutput.sampleMetadata(jAdjustSampleTimestamp, 1, metadataSampleInfoRemoveFirst.size, this.pendingMetadataSampleBytes, null);
            }
        }
    }

    private static long parseMehd(ParsableByteArray parsableByteArray) {
        parsableByteArray.setPosition(8);
        return BoxParser.parseFullBoxVersion(parsableByteArray.readInt()) == 0 ? parsableByteArray.readUnsignedInt() : parsableByteArray.readUnsignedLongToLong();
    }

    private static void parseMoof(Mp4Box.ContainerBox containerBox, SparseArray<TrackBundle> sparseArray, boolean z7, int i6, byte[] bArr) throws ParserException {
        int size = containerBox.containerChildren.size();
        for (int i10 = 0; i10 < size; i10++) {
            Mp4Box.ContainerBox containerBox2 = containerBox.containerChildren.get(i10);
            if (containerBox2.type == 1953653094) {
                parseTraf(containerBox2, sparseArray, z7, i6, bArr);
            }
        }
    }

    private static void parseSaio(ParsableByteArray parsableByteArray, TrackFragment trackFragment) throws ParserException {
        parsableByteArray.setPosition(8);
        int i6 = parsableByteArray.readInt();
        if ((BoxParser.parseFullBoxFlags(i6) & 1) == 1) {
            parsableByteArray.skipBytes(8);
        }
        int unsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
        if (unsignedIntToInt == 1) {
            trackFragment.auxiliaryDataPosition += BoxParser.parseFullBoxVersion(i6) == 0 ? parsableByteArray.readUnsignedInt() : parsableByteArray.readUnsignedLongToLong();
        } else {
            throw ParserException.createForMalformedContainer("Unexpected saio entry count: " + unsignedIntToInt, null);
        }
    }

    private static void parseSaiz(TrackEncryptionBox trackEncryptionBox, ParsableByteArray parsableByteArray, TrackFragment trackFragment) throws ParserException {
        int i6;
        int i10 = trackEncryptionBox.perSampleIvSize;
        parsableByteArray.setPosition(8);
        if ((BoxParser.parseFullBoxFlags(parsableByteArray.readInt()) & 1) == 1) {
            parsableByteArray.skipBytes(8);
        }
        int unsignedByte = parsableByteArray.readUnsignedByte();
        int unsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
        if (unsignedIntToInt > trackFragment.sampleCount) {
            StringBuilder sbM27u = AbstractC0004e.m27u(unsignedIntToInt, "Saiz sample count ", " is greater than fragment sample count");
            sbM27u.append(trackFragment.sampleCount);
            throw ParserException.createForMalformedContainer(sbM27u.toString(), null);
        }
        if (unsignedByte == 0) {
            boolean[] zArr = trackFragment.sampleHasSubsampleEncryptionTable;
            i6 = 0;
            for (int i11 = 0; i11 < unsignedIntToInt; i11++) {
                int unsignedByte2 = parsableByteArray.readUnsignedByte();
                i6 += unsignedByte2;
                zArr[i11] = unsignedByte2 > i10;
            }
        } else {
            i6 = unsignedByte * unsignedIntToInt;
            Arrays.fill(trackFragment.sampleHasSubsampleEncryptionTable, 0, unsignedIntToInt, unsignedByte > i10);
        }
        Arrays.fill(trackFragment.sampleHasSubsampleEncryptionTable, unsignedIntToInt, trackFragment.sampleCount, false);
        if (i6 > 0) {
            trackFragment.initEncryptionData(i6);
        }
    }

    private static void parseSampleGroups(Mp4Box.ContainerBox containerBox, String str, TrackFragment trackFragment) throws ParserException {
        byte[] bArr = null;
        ParsableByteArray parsableByteArray = null;
        ParsableByteArray parsableByteArray2 = null;
        for (int i6 = 0; i6 < containerBox.leafChildren.size(); i6++) {
            Mp4Box.LeafBox leafBox = containerBox.leafChildren.get(i6);
            ParsableByteArray parsableByteArray3 = leafBox.data;
            int i10 = leafBox.type;
            if (i10 == 1935828848) {
                parsableByteArray3.setPosition(12);
                if (parsableByteArray3.readInt() == SAMPLE_GROUP_TYPE_seig) {
                    parsableByteArray = parsableByteArray3;
                }
            } else if (i10 == 1936158820) {
                parsableByteArray3.setPosition(12);
                if (parsableByteArray3.readInt() == SAMPLE_GROUP_TYPE_seig) {
                    parsableByteArray2 = parsableByteArray3;
                }
            }
        }
        if (parsableByteArray == null || parsableByteArray2 == null) {
            return;
        }
        parsableByteArray.setPosition(8);
        int fullBoxVersion = BoxParser.parseFullBoxVersion(parsableByteArray.readInt());
        parsableByteArray.skipBytes(4);
        if (fullBoxVersion == 1) {
            parsableByteArray.skipBytes(4);
        }
        if (parsableByteArray.readInt() != 1) {
            throw ParserException.createForUnsupportedContainerFeature("Entry count in sbgp != 1 (unsupported).");
        }
        parsableByteArray2.setPosition(8);
        int fullBoxVersion2 = BoxParser.parseFullBoxVersion(parsableByteArray2.readInt());
        parsableByteArray2.skipBytes(4);
        if (fullBoxVersion2 == 1) {
            if (parsableByteArray2.readUnsignedInt() == 0) {
                throw ParserException.createForUnsupportedContainerFeature("Variable length description in sgpd found (unsupported)");
            }
        } else if (fullBoxVersion2 >= 2) {
            parsableByteArray2.skipBytes(4);
        }
        if (parsableByteArray2.readUnsignedInt() != 1) {
            throw ParserException.createForUnsupportedContainerFeature("Entry count in sgpd != 1 (unsupported).");
        }
        parsableByteArray2.skipBytes(1);
        int unsignedByte = parsableByteArray2.readUnsignedByte();
        int i11 = (unsignedByte & PsExtractor.VIDEO_STREAM_MASK) >> 4;
        int i12 = unsignedByte & 15;
        boolean z7 = parsableByteArray2.readUnsignedByte() == 1;
        if (z7) {
            int unsignedByte2 = parsableByteArray2.readUnsignedByte();
            byte[] bArr2 = new byte[16];
            parsableByteArray2.readBytes(bArr2, 0, 16);
            if (unsignedByte2 == 0) {
                int unsignedByte3 = parsableByteArray2.readUnsignedByte();
                bArr = new byte[unsignedByte3];
                parsableByteArray2.readBytes(bArr, 0, unsignedByte3);
            }
            trackFragment.definesEncryptionData = true;
            trackFragment.trackEncryptionBox = new TrackEncryptionBox(z7, str, unsignedByte2, bArr2, i11, i12, bArr);
        }
    }

    private static void parseSenc(ParsableByteArray parsableByteArray, TrackFragment trackFragment) throws ParserException {
        parseSenc(parsableByteArray, 0, trackFragment);
    }

    private static Pair<Long, ChunkIndex> parseSidx(ParsableByteArray parsableByteArray, long j10) throws ParserException {
        long unsignedLongToLong;
        long unsignedLongToLong2;
        parsableByteArray.setPosition(8);
        int fullBoxVersion = BoxParser.parseFullBoxVersion(parsableByteArray.readInt());
        parsableByteArray.skipBytes(4);
        long unsignedInt = parsableByteArray.readUnsignedInt();
        if (fullBoxVersion == 0) {
            unsignedLongToLong = parsableByteArray.readUnsignedInt();
            unsignedLongToLong2 = parsableByteArray.readUnsignedInt();
        } else {
            unsignedLongToLong = parsableByteArray.readUnsignedLongToLong();
            unsignedLongToLong2 = parsableByteArray.readUnsignedLongToLong();
        }
        long j11 = unsignedLongToLong;
        long j12 = unsignedLongToLong2 + j10;
        long jScaleLargeTimestamp = Util.scaleLargeTimestamp(j11, 1000000L, unsignedInt);
        parsableByteArray.skipBytes(2);
        int unsignedShort = parsableByteArray.readUnsignedShort();
        int[] iArr = new int[unsignedShort];
        long[] jArr = new long[unsignedShort];
        long[] jArr2 = new long[unsignedShort];
        long[] jArr3 = new long[unsignedShort];
        long j13 = j11;
        long j14 = jScaleLargeTimestamp;
        int i6 = 0;
        while (i6 < unsignedShort) {
            int i10 = parsableByteArray.readInt();
            if ((i10 & Integer.MIN_VALUE) != 0) {
                throw ParserException.createForMalformedContainer("Unhandled indirect reference", null);
            }
            long unsignedInt2 = parsableByteArray.readUnsignedInt();
            iArr[i6] = i10 & Integer.MAX_VALUE;
            jArr[i6] = j12;
            jArr3[i6] = j14;
            long j15 = j13 + unsignedInt2;
            long[] jArr4 = jArr2;
            long[] jArr5 = jArr3;
            int i11 = unsignedShort;
            int[] iArr2 = iArr;
            long jScaleLargeTimestamp2 = Util.scaleLargeTimestamp(j15, 1000000L, unsignedInt);
            jArr4[i6] = jScaleLargeTimestamp2 - jArr5[i6];
            parsableByteArray.skipBytes(4);
            j12 += (long) iArr2[i6];
            i6++;
            iArr = iArr2;
            jArr3 = jArr5;
            jArr2 = jArr4;
            jArr = jArr;
            unsignedShort = i11;
            j13 = j15;
            j14 = jScaleLargeTimestamp2;
        }
        return Pair.create(Long.valueOf(jScaleLargeTimestamp), new ChunkIndex(iArr, jArr, jArr2, jArr3));
    }

    private static long parseTfdt(ParsableByteArray parsableByteArray) {
        parsableByteArray.setPosition(8);
        return BoxParser.parseFullBoxVersion(parsableByteArray.readInt()) == 1 ? parsableByteArray.readUnsignedLongToLong() : parsableByteArray.readUnsignedInt();
    }

    private static TrackBundle parseTfhd(ParsableByteArray parsableByteArray, SparseArray<TrackBundle> sparseArray, boolean z7) {
        parsableByteArray.setPosition(8);
        int fullBoxFlags = BoxParser.parseFullBoxFlags(parsableByteArray.readInt());
        TrackBundle trackBundleValueAt = z7 ? sparseArray.valueAt(0) : sparseArray.get(parsableByteArray.readInt());
        if (trackBundleValueAt == null) {
            return null;
        }
        if ((fullBoxFlags & 1) != 0) {
            long unsignedLongToLong = parsableByteArray.readUnsignedLongToLong();
            TrackFragment trackFragment = trackBundleValueAt.fragment;
            trackFragment.dataPosition = unsignedLongToLong;
            trackFragment.auxiliaryDataPosition = unsignedLongToLong;
        }
        DefaultSampleValues defaultSampleValues = trackBundleValueAt.defaultSampleValues;
        trackBundleValueAt.fragment.header = new DefaultSampleValues((fullBoxFlags & 2) != 0 ? parsableByteArray.readInt() - 1 : defaultSampleValues.sampleDescriptionIndex, (fullBoxFlags & 8) != 0 ? parsableByteArray.readInt() : defaultSampleValues.duration, (fullBoxFlags & 16) != 0 ? parsableByteArray.readInt() : defaultSampleValues.size, (fullBoxFlags & 32) != 0 ? parsableByteArray.readInt() : defaultSampleValues.flags);
        return trackBundleValueAt;
    }

    private static void parseTraf(Mp4Box.ContainerBox containerBox, SparseArray<TrackBundle> sparseArray, boolean z7, int i6, byte[] bArr) throws ParserException {
        TrackBundle tfhd = parseTfhd(((Mp4Box.LeafBox) Assertions.checkNotNull(containerBox.getLeafBoxOfType(Mp4Box.TYPE_tfhd))).data, sparseArray, z7);
        if (tfhd == null) {
            return;
        }
        TrackFragment trackFragment = tfhd.fragment;
        long j10 = trackFragment.nextFragmentDecodeTime;
        boolean z10 = trackFragment.nextFragmentDecodeTimeIncludesMoov;
        tfhd.resetFragmentInfo();
        tfhd.currentlyInFragment = true;
        Mp4Box.LeafBox leafBoxOfType = containerBox.getLeafBoxOfType(Mp4Box.TYPE_tfdt);
        if (leafBoxOfType == null || (i6 & 2) != 0) {
            trackFragment.nextFragmentDecodeTime = j10;
            trackFragment.nextFragmentDecodeTimeIncludesMoov = z10;
        } else {
            trackFragment.nextFragmentDecodeTime = parseTfdt(leafBoxOfType.data);
            trackFragment.nextFragmentDecodeTimeIncludesMoov = true;
        }
        parseTruns(containerBox, tfhd, i6);
        TrackEncryptionBox sampleDescriptionEncryptionBox = tfhd.moovSampleTable.track.getSampleDescriptionEncryptionBox(((DefaultSampleValues) Assertions.checkNotNull(trackFragment.header)).sampleDescriptionIndex);
        Mp4Box.LeafBox leafBoxOfType2 = containerBox.getLeafBoxOfType(Mp4Box.TYPE_saiz);
        if (leafBoxOfType2 != null) {
            parseSaiz((TrackEncryptionBox) Assertions.checkNotNull(sampleDescriptionEncryptionBox), leafBoxOfType2.data, trackFragment);
        }
        Mp4Box.LeafBox leafBoxOfType3 = containerBox.getLeafBoxOfType(Mp4Box.TYPE_saio);
        if (leafBoxOfType3 != null) {
            parseSaio(leafBoxOfType3.data, trackFragment);
        }
        Mp4Box.LeafBox leafBoxOfType4 = containerBox.getLeafBoxOfType(Mp4Box.TYPE_senc);
        if (leafBoxOfType4 != null) {
            parseSenc(leafBoxOfType4.data, trackFragment);
        }
        parseSampleGroups(containerBox, sampleDescriptionEncryptionBox != null ? sampleDescriptionEncryptionBox.schemeType : null, trackFragment);
        int size = containerBox.leafChildren.size();
        for (int i10 = 0; i10 < size; i10++) {
            Mp4Box.LeafBox leafBox = containerBox.leafChildren.get(i10);
            if (leafBox.type == 1970628964) {
                parseUuid(leafBox.data, trackFragment, bArr);
            }
        }
    }

    private static Pair<Integer, DefaultSampleValues> parseTrex(ParsableByteArray parsableByteArray) {
        parsableByteArray.setPosition(12);
        return Pair.create(Integer.valueOf(parsableByteArray.readInt()), new DefaultSampleValues(parsableByteArray.readInt() - 1, parsableByteArray.readInt(), parsableByteArray.readInt(), parsableByteArray.readInt()));
    }

    private static int parseTrun(TrackBundle trackBundle, int i6, int i10, ParsableByteArray parsableByteArray, int i11) throws ParserException {
        int i12;
        TrackBundle trackBundle2 = trackBundle;
        parsableByteArray.setPosition(8);
        int fullBoxFlags = BoxParser.parseFullBoxFlags(parsableByteArray.readInt());
        Track track = trackBundle2.moovSampleTable.track;
        TrackFragment trackFragment = trackBundle2.fragment;
        DefaultSampleValues defaultSampleValues = (DefaultSampleValues) Util.castNonNull(trackFragment.header);
        trackFragment.trunLength[i6] = parsableByteArray.readUnsignedIntToInt();
        long[] jArr = trackFragment.trunDataPosition;
        long j10 = trackFragment.dataPosition;
        jArr[i6] = j10;
        if ((fullBoxFlags & 1) != 0) {
            jArr[i6] = j10 + ((long) parsableByteArray.readInt());
        }
        boolean z7 = (fullBoxFlags & 4) != 0;
        int i13 = defaultSampleValues.flags;
        if (z7) {
            i13 = parsableByteArray.readInt();
        }
        boolean z10 = (fullBoxFlags & 256) != 0;
        boolean z11 = (fullBoxFlags & 512) != 0;
        boolean z12 = (fullBoxFlags & 1024) != 0;
        boolean z13 = (fullBoxFlags & 2048) != 0;
        long j11 = isEdtsListDurationForEntireMediaTimeline(track) ? ((long[]) Util.castNonNull(track.editListMediaTimes))[0] : 0L;
        int[] iArr = trackFragment.sampleSizeTable;
        long[] jArr2 = trackFragment.samplePresentationTimesUs;
        boolean[] zArr = trackFragment.sampleIsSyncFrameTable;
        int i14 = i13;
        boolean z14 = track.type == 2 && (i10 & 1) != 0;
        int i15 = i11 + trackFragment.trunLength[i6];
        boolean z15 = z14;
        long j12 = track.timescale;
        long j13 = trackFragment.nextFragmentDecodeTime;
        int i16 = i11;
        while (i16 < i15) {
            int iCheckNonNegative = checkNonNegative(z10 ? parsableByteArray.readInt() : defaultSampleValues.duration);
            int iCheckNonNegative2 = checkNonNegative(z11 ? parsableByteArray.readInt() : defaultSampleValues.size);
            if (z12) {
                i12 = parsableByteArray.readInt();
            } else {
                i12 = (i16 == 0 && z7) ? i14 : defaultSampleValues.flags;
            }
            long jScaleLargeTimestamp = Util.scaleLargeTimestamp((((long) (z13 ? parsableByteArray.readInt() : 0)) + j13) - j11, 1000000L, j12);
            jArr2[i16] = jScaleLargeTimestamp;
            if (!trackFragment.nextFragmentDecodeTimeIncludesMoov) {
                jArr2[i16] = jScaleLargeTimestamp + trackBundle2.moovSampleTable.durationUs;
            }
            iArr[i16] = iCheckNonNegative2;
            zArr[i16] = ((i12 >> 16) & 1) == 0 && (!z15 || i16 == 0);
            j13 += (long) iCheckNonNegative;
            i16++;
            trackBundle2 = trackBundle;
            z10 = z10;
            z7 = z7;
            z13 = z13;
            z11 = z11;
            z12 = z12;
        }
        trackFragment.nextFragmentDecodeTime = j13;
        return i15;
    }

    private static void parseTruns(Mp4Box.ContainerBox containerBox, TrackBundle trackBundle, int i6) throws ParserException {
        List<Mp4Box.LeafBox> list = containerBox.leafChildren;
        int size = list.size();
        int i10 = 0;
        int i11 = 0;
        for (int i12 = 0; i12 < size; i12++) {
            Mp4Box.LeafBox leafBox = list.get(i12);
            if (leafBox.type == 1953658222) {
                ParsableByteArray parsableByteArray = leafBox.data;
                parsableByteArray.setPosition(12);
                int unsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
                if (unsignedIntToInt > 0) {
                    i11 += unsignedIntToInt;
                    i10++;
                }
            }
        }
        trackBundle.currentTrackRunIndex = 0;
        trackBundle.currentSampleInTrackRun = 0;
        trackBundle.currentSampleIndex = 0;
        trackBundle.fragment.initTables(i10, i11);
        int i13 = 0;
        int trun = 0;
        for (int i14 = 0; i14 < size; i14++) {
            Mp4Box.LeafBox leafBox2 = list.get(i14);
            if (leafBox2.type == 1953658222) {
                trun = parseTrun(trackBundle, i13, i6, leafBox2.data, trun);
                i13++;
            }
        }
    }

    private static void parseUuid(ParsableByteArray parsableByteArray, TrackFragment trackFragment, byte[] bArr) throws ParserException {
        parsableByteArray.setPosition(8);
        parsableByteArray.readBytes(bArr, 0, 16);
        if (Arrays.equals(bArr, PIFF_SAMPLE_ENCRYPTION_BOX_EXTENDED_TYPE)) {
            parseSenc(parsableByteArray, 16, trackFragment);
        }
    }

    private void processAtomEnded(long j10) throws ParserException {
        while (!this.containerAtoms.isEmpty() && this.containerAtoms.peek().endPosition == j10) {
            onContainerAtomRead(this.containerAtoms.pop());
        }
        enterReadingAtomHeaderState();
    }

    private boolean readAtomHeader(ExtractorInput extractorInput) throws IOException {
        if (this.atomHeaderBytesRead == 0) {
            if (!extractorInput.readFully(this.atomHeader.getData(), 0, 8, true)) {
                return false;
            }
            this.atomHeaderBytesRead = 8;
            this.atomHeader.setPosition(0);
            this.atomSize = this.atomHeader.readUnsignedInt();
            this.atomType = this.atomHeader.readInt();
        }
        long j10 = this.atomSize;
        if (j10 == 1) {
            extractorInput.readFully(this.atomHeader.getData(), 8, 8);
            this.atomHeaderBytesRead += 8;
            this.atomSize = this.atomHeader.readUnsignedLongToLong();
        } else if (j10 == 0) {
            long length = extractorInput.getLength();
            if (length == -1 && !this.containerAtoms.isEmpty()) {
                length = this.containerAtoms.peek().endPosition;
            }
            if (length != -1) {
                this.atomSize = (length - extractorInput.getPosition()) + ((long) this.atomHeaderBytesRead);
            }
        }
        if (this.atomSize < this.atomHeaderBytesRead) {
            throw ParserException.createForUnsupportedContainerFeature("Atom size less than header length (unsupported).");
        }
        long position = extractorInput.getPosition() - ((long) this.atomHeaderBytesRead);
        int i6 = this.atomType;
        if ((i6 == 1836019558 || i6 == 1835295092) && !this.haveOutputSeekMap) {
            this.extractorOutput.seekMap(new SeekMap.Unseekable(this.durationUs, position));
            this.haveOutputSeekMap = true;
        }
        if (this.atomType == 1836019558) {
            int size = this.trackBundles.size();
            for (int i10 = 0; i10 < size; i10++) {
                TrackFragment trackFragment = this.trackBundles.valueAt(i10).fragment;
                trackFragment.atomPosition = position;
                trackFragment.auxiliaryDataPosition = position;
                trackFragment.dataPosition = position;
            }
        }
        int i11 = this.atomType;
        if (i11 == 1835295092) {
            this.currentTrackBundle = null;
            this.endOfMdatPosition = position + this.atomSize;
            this.parserState = 2;
            return true;
        }
        if (shouldParseContainerAtom(i11)) {
            long position2 = (extractorInput.getPosition() + this.atomSize) - 8;
            this.containerAtoms.push(new Mp4Box.ContainerBox(this.atomType, position2));
            if (this.atomSize == this.atomHeaderBytesRead) {
                processAtomEnded(position2);
            } else {
                enterReadingAtomHeaderState();
            }
        } else if (shouldParseLeafAtom(this.atomType)) {
            if (this.atomHeaderBytesRead != 8) {
                throw ParserException.createForUnsupportedContainerFeature("Leaf atom defines extended atom size (unsupported).");
            }
            if (this.atomSize > 2147483647L) {
                throw ParserException.createForUnsupportedContainerFeature("Leaf atom with length > 2147483647 (unsupported).");
            }
            ParsableByteArray parsableByteArray = new ParsableByteArray((int) this.atomSize);
            System.arraycopy(this.atomHeader.getData(), 0, parsableByteArray.getData(), 0, 8);
            this.atomData = parsableByteArray;
            this.parserState = 1;
        } else {
            if (this.atomSize > 2147483647L) {
                throw ParserException.createForUnsupportedContainerFeature("Skipping atom with length > 2147483647 (unsupported).");
            }
            this.atomData = null;
            this.parserState = 1;
        }
        return true;
    }

    private void readAtomPayload(ExtractorInput extractorInput) throws IOException {
        int i6 = (int) (this.atomSize - ((long) this.atomHeaderBytesRead));
        ParsableByteArray parsableByteArray = this.atomData;
        if (parsableByteArray != null) {
            extractorInput.readFully(parsableByteArray.getData(), 8, i6);
            onLeafAtomRead(new Mp4Box.LeafBox(this.atomType, parsableByteArray), extractorInput.getPosition());
        } else {
            extractorInput.skipFully(i6);
        }
        processAtomEnded(extractorInput.getPosition());
    }

    private void readEncryptionData(ExtractorInput extractorInput) throws IOException {
        int size = this.trackBundles.size();
        long j10 = Long.MAX_VALUE;
        TrackBundle trackBundleValueAt = null;
        for (int i6 = 0; i6 < size; i6++) {
            TrackFragment trackFragment = this.trackBundles.valueAt(i6).fragment;
            if (trackFragment.sampleEncryptionDataNeedsFill) {
                long j11 = trackFragment.auxiliaryDataPosition;
                if (j11 < j10) {
                    trackBundleValueAt = this.trackBundles.valueAt(i6);
                    j10 = j11;
                }
            }
        }
        if (trackBundleValueAt == null) {
            this.parserState = 3;
            return;
        }
        int position = (int) (j10 - extractorInput.getPosition());
        if (position < 0) {
            throw ParserException.createForMalformedContainer("Offset to encryption data was negative.", null);
        }
        extractorInput.skipFully(position);
        trackBundleValueAt.fragment.fillEncryptionData(extractorInput);
    }

    private boolean readSample(ExtractorInput extractorInput) throws IOException {
        int iSampleData;
        int iNumberOfBytesInNalUnitHeader;
        TrackBundle nextTrackBundle = this.currentTrackBundle;
        if (nextTrackBundle == null) {
            nextTrackBundle = getNextTrackBundle(this.trackBundles);
            if (nextTrackBundle == null) {
                int position = (int) (this.endOfMdatPosition - extractorInput.getPosition());
                if (position < 0) {
                    throw ParserException.createForMalformedContainer("Offset to end of mdat was negative.", null);
                }
                extractorInput.skipFully(position);
                enterReadingAtomHeaderState();
                return false;
            }
            int currentSampleOffset = (int) (nextTrackBundle.getCurrentSampleOffset() - extractorInput.getPosition());
            if (currentSampleOffset < 0) {
                Log.m1719w(TAG, "Ignoring negative offset to sample data.");
                currentSampleOffset = 0;
            }
            extractorInput.skipFully(currentSampleOffset);
            this.currentTrackBundle = nextTrackBundle;
        }
        if (this.parserState == 3) {
            this.sampleSize = nextTrackBundle.getCurrentSampleSize();
            this.isSampleDependedOn = !canReadWithinGopSampleDependencies(nextTrackBundle.moovSampleTable.track.format);
            if (nextTrackBundle.currentSampleIndex < nextTrackBundle.firstSampleToOutputIndex) {
                extractorInput.skipFully(this.sampleSize);
                nextTrackBundle.skipSampleEncryptionData();
                if (!nextTrackBundle.next()) {
                    this.currentTrackBundle = null;
                }
                this.parserState = 3;
                return true;
            }
            if (nextTrackBundle.moovSampleTable.track.sampleTransformation == 1) {
                this.sampleSize -= 8;
                extractorInput.skipFully(8);
            }
            if (MimeTypes.AUDIO_AC4.equals(nextTrackBundle.moovSampleTable.track.format.sampleMimeType)) {
                this.sampleBytesWritten = nextTrackBundle.outputSampleEncryptionData(this.sampleSize, 7);
                Ac4Util.getAc4SampleHeader(this.sampleSize, this.scratch);
                nextTrackBundle.output.sampleData(this.scratch, 7);
                this.sampleBytesWritten += 7;
            } else {
                this.sampleBytesWritten = nextTrackBundle.outputSampleEncryptionData(this.sampleSize, 0);
            }
            this.sampleSize += this.sampleBytesWritten;
            this.parserState = 4;
            this.sampleCurrentNalBytesRemaining = 0;
        }
        Track track = nextTrackBundle.moovSampleTable.track;
        TrackOutput trackOutput = nextTrackBundle.output;
        long currentSamplePresentationTimeUs = nextTrackBundle.getCurrentSamplePresentationTimeUs();
        TimestampAdjuster timestampAdjuster = this.timestampAdjuster;
        if (timestampAdjuster != null) {
            currentSamplePresentationTimeUs = timestampAdjuster.adjustSampleTimestamp(currentSamplePresentationTimeUs);
        }
        long j10 = currentSamplePresentationTimeUs;
        if (track.nalUnitLengthFieldLength == 0) {
            while (true) {
                int i6 = this.sampleBytesWritten;
                int i10 = this.sampleSize;
                if (i6 >= i10) {
                    break;
                }
                this.sampleBytesWritten += trackOutput.sampleData((DataReader) extractorInput, i10 - i6, false);
            }
        } else {
            byte[] data = this.nalPrefix.getData();
            data[0] = 0;
            data[1] = 0;
            data[2] = 0;
            int i11 = 4 - track.nalUnitLengthFieldLength;
            while (this.sampleBytesWritten < this.sampleSize) {
                int i12 = this.sampleCurrentNalBytesRemaining;
                if (i12 == 0) {
                    if (this.ceaTrackOutputs.length > 0 || !this.isSampleDependedOn) {
                        iNumberOfBytesInNalUnitHeader = NalUnitUtil.numberOfBytesInNalUnitHeader(track.format);
                        if (track.nalUnitLengthFieldLength + iNumberOfBytesInNalUnitHeader > this.sampleSize - this.sampleBytesWritten) {
                            iNumberOfBytesInNalUnitHeader = 0;
                        }
                    } else {
                        iNumberOfBytesInNalUnitHeader = 0;
                    }
                    extractorInput.readFully(data, i11, track.nalUnitLengthFieldLength + iNumberOfBytesInNalUnitHeader);
                    this.nalPrefix.setPosition(0);
                    int i13 = this.nalPrefix.readInt();
                    if (i13 < 0) {
                        throw ParserException.createForMalformedContainer("Invalid NAL length", null);
                    }
                    this.sampleCurrentNalBytesRemaining = i13 - iNumberOfBytesInNalUnitHeader;
                    this.nalStartCode.setPosition(0);
                    trackOutput.sampleData(this.nalStartCode, 4);
                    this.sampleBytesWritten += 4;
                    this.sampleSize += i11;
                    this.processSeiNalUnitPayload = this.ceaTrackOutputs.length > 0 && iNumberOfBytesInNalUnitHeader > 0 && NalUnitUtil.isNalUnitSei(track.format, data[4]);
                    trackOutput.sampleData(this.nalPrefix, iNumberOfBytesInNalUnitHeader);
                    this.sampleBytesWritten += iNumberOfBytesInNalUnitHeader;
                    if (iNumberOfBytesInNalUnitHeader > 0 && !this.isSampleDependedOn && NalUnitUtil.isDependedOn(data, 4, iNumberOfBytesInNalUnitHeader, track.format)) {
                        this.isSampleDependedOn = true;
                    }
                } else {
                    if (this.processSeiNalUnitPayload) {
                        this.nalUnitWithoutHeaderBuffer.reset(i12);
                        extractorInput.readFully(this.nalUnitWithoutHeaderBuffer.getData(), 0, this.sampleCurrentNalBytesRemaining);
                        trackOutput.sampleData(this.nalUnitWithoutHeaderBuffer, this.sampleCurrentNalBytesRemaining);
                        iSampleData = this.sampleCurrentNalBytesRemaining;
                        int iUnescapeStream = NalUnitUtil.unescapeStream(this.nalUnitWithoutHeaderBuffer.getData(), this.nalUnitWithoutHeaderBuffer.limit());
                        this.nalUnitWithoutHeaderBuffer.setPosition(0);
                        this.nalUnitWithoutHeaderBuffer.setLimit(iUnescapeStream);
                        if (track.format.maxNumReorderSamples != -1) {
                            int maxSize = this.reorderingSeiMessageQueue.getMaxSize();
                            int i14 = track.format.maxNumReorderSamples;
                            if (maxSize != i14) {
                                this.reorderingSeiMessageQueue.setMaxSize(i14);
                            }
                        } else if (this.reorderingSeiMessageQueue.getMaxSize() != 0) {
                            this.reorderingSeiMessageQueue.setMaxSize(0);
                        }
                        this.reorderingSeiMessageQueue.add(j10, this.nalUnitWithoutHeaderBuffer);
                        if ((nextTrackBundle.getCurrentSampleFlags() & 4) != 0) {
                            this.reorderingSeiMessageQueue.flush();
                        }
                    } else {
                        iSampleData = trackOutput.sampleData((DataReader) extractorInput, i12, false);
                    }
                    this.sampleBytesWritten += iSampleData;
                    this.sampleCurrentNalBytesRemaining -= iSampleData;
                }
            }
        }
        int currentSampleFlags = nextTrackBundle.getCurrentSampleFlags();
        if (!this.isSampleDependedOn) {
            currentSampleFlags |= C0565C.BUFFER_FLAG_NOT_DEPENDED_ON;
        }
        int i15 = currentSampleFlags;
        TrackEncryptionBox encryptionBoxIfEncrypted = nextTrackBundle.getEncryptionBoxIfEncrypted();
        trackOutput.sampleMetadata(j10, i15, this.sampleSize, 0, encryptionBoxIfEncrypted != null ? encryptionBoxIfEncrypted.cryptoData : null);
        outputPendingMetadataSamples(j10);
        if (!nextTrackBundle.next()) {
            this.currentTrackBundle = null;
        }
        this.parserState = 3;
        return true;
    }

    private static boolean shouldParseContainerAtom(int i6) {
        return i6 == 1836019574 || i6 == 1953653099 || i6 == 1835297121 || i6 == 1835626086 || i6 == 1937007212 || i6 == 1836019558 || i6 == 1953653094 || i6 == 1836475768 || i6 == 1701082227;
    }

    private static boolean shouldParseLeafAtom(int i6) {
        return i6 == 1751411826 || i6 == 1835296868 || i6 == 1836476516 || i6 == 1936286840 || i6 == 1937011556 || i6 == 1937011827 || i6 == 1668576371 || i6 == 1937011555 || i6 == 1937011578 || i6 == 1937013298 || i6 == 1937007471 || i6 == 1668232756 || i6 == 1937011571 || i6 == 1952867444 || i6 == 1952868452 || i6 == 1953196132 || i6 == 1953654136 || i6 == 1953658222 || i6 == 1886614376 || i6 == 1935763834 || i6 == 1935763823 || i6 == 1936027235 || i6 == 1970628964 || i6 == 1935828848 || i6 == 1936158820 || i6 == 1701606260 || i6 == 1835362404 || i6 == 1701671783;
    }

    @Override
    public final Extractor getUnderlyingImplementation() {
        return AbstractC1009b.m2646b(this);
    }

    @Override
    public void init(ExtractorOutput extractorOutput) {
        if ((this.flags & 32) == 0) {
            extractorOutput = new SubtitleTranscodingExtractorOutput(extractorOutput, this.subtitleParserFactory);
        }
        this.extractorOutput = extractorOutput;
        enterReadingAtomHeaderState();
        initExtraTracks();
        Track track = this.sideloadedTrack;
        if (track != null) {
            this.trackBundles.put(0, new TrackBundle(this.extractorOutput.track(0, track.type), new TrackSampleTable(this.sideloadedTrack, new long[0], new int[0], 0, new long[0], new int[0], 0L), new DefaultSampleValues(0, 0, 0, 0), MimeTypeResolver.getContainerMimeType(this.sideloadedTrack.format)));
            this.extractorOutput.endTracks();
        }
    }

    @Override
    public int read(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        while (true) {
            int i6 = this.parserState;
            if (i6 != 0) {
                if (i6 == 1) {
                    readAtomPayload(extractorInput);
                } else if (i6 == 2) {
                    readEncryptionData(extractorInput);
                } else if (readSample(extractorInput)) {
                    return 0;
                }
            } else if (!readAtomHeader(extractorInput)) {
                this.reorderingSeiMessageQueue.flush();
                return -1;
            }
        }
    }

    @Override
    public void seek(long j10, long j11) {
        int size = this.trackBundles.size();
        for (int i6 = 0; i6 < size; i6++) {
            this.trackBundles.valueAt(i6).resetFragmentInfo();
        }
        this.pendingMetadataSampleInfos.clear();
        this.pendingMetadataSampleBytes = 0;
        this.reorderingSeiMessageQueue.clear();
        this.pendingSeekTimeUs = j11;
        this.containerAtoms.clear();
        enterReadingAtomHeaderState();
    }

    @Override
    public boolean sniff(ExtractorInput extractorInput) throws IOException {
        C2180c5 c2180c5M5275r;
        SniffFailure sniffFailureSniffFragmented = Sniffer.sniffFragmented(extractorInput);
        if (sniffFailureSniffFragmented != null) {
            c2180c5M5275r = AbstractC2301u1.m5275r(sniffFailureSniffFragmented);
        } else {
            C2204g1 c2204g1 = AbstractC2301u1.f8069b;
            c2180c5M5275r = C2180c5.f7862e;
        }
        this.lastSniffFailures = c2180c5M5275r;
        return sniffFailureSniffFragmented == null;
    }

    private static void parseSenc(ParsableByteArray parsableByteArray, int i6, TrackFragment trackFragment) throws ParserException {
        parsableByteArray.setPosition(i6 + 8);
        int fullBoxFlags = BoxParser.parseFullBoxFlags(parsableByteArray.readInt());
        if ((fullBoxFlags & 1) != 0) {
            throw ParserException.createForUnsupportedContainerFeature("Overriding TrackEncryptionBox parameters is unsupported.");
        }
        boolean z7 = (fullBoxFlags & 2) != 0;
        int unsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
        if (unsignedIntToInt == 0) {
            Arrays.fill(trackFragment.sampleHasSubsampleEncryptionTable, 0, trackFragment.sampleCount, false);
            return;
        }
        if (unsignedIntToInt != trackFragment.sampleCount) {
            StringBuilder sbM27u = AbstractC0004e.m27u(unsignedIntToInt, "Senc sample count ", " is different from fragment sample count");
            sbM27u.append(trackFragment.sampleCount);
            throw ParserException.createForMalformedContainer(sbM27u.toString(), null);
        }
        Arrays.fill(trackFragment.sampleHasSubsampleEncryptionTable, 0, unsignedIntToInt, z7);
        trackFragment.initEncryptionData(parsableByteArray.bytesLeft());
        trackFragment.fillEncryptionData(parsableByteArray);
    }

    @Override
    public AbstractC2301u1 getSniffFailureDetails() {
        return this.lastSniffFailures;
    }

    public FragmentedMp4Extractor(SubtitleParser.Factory factory) {
        this(factory, 0, null, null, C2180c5.f7862e, null);
        C2204g1 c2204g1 = AbstractC2301u1.f8069b;
    }

    @Deprecated
    public FragmentedMp4Extractor(int i6) {
        SubtitleParser.Factory factory = SubtitleParser.Factory.UNSUPPORTED;
        int i10 = i6 | 32;
        C2204g1 c2204g1 = AbstractC2301u1.f8069b;
        this(factory, i10, null, null, C2180c5.f7862e, null);
    }

    public FragmentedMp4Extractor(SubtitleParser.Factory factory, int i6) {
        this(factory, i6, null, null, C2180c5.f7862e, null);
        C2204g1 c2204g1 = AbstractC2301u1.f8069b;
    }

    @Deprecated
    public FragmentedMp4Extractor(int i6, TimestampAdjuster timestampAdjuster) {
        SubtitleParser.Factory factory = SubtitleParser.Factory.UNSUPPORTED;
        int i10 = i6 | 32;
        C2204g1 c2204g1 = AbstractC2301u1.f8069b;
        this(factory, i10, timestampAdjuster, null, C2180c5.f7862e, null);
    }

    @Deprecated
    public FragmentedMp4Extractor(int i6, TimestampAdjuster timestampAdjuster, Track track) {
        SubtitleParser.Factory factory = SubtitleParser.Factory.UNSUPPORTED;
        int i10 = i6 | 32;
        C2204g1 c2204g1 = AbstractC2301u1.f8069b;
        this(factory, i10, timestampAdjuster, track, C2180c5.f7862e, null);
    }

    @Override
    public void release() {
    }

    @Deprecated
    public FragmentedMp4Extractor(int i6, TimestampAdjuster timestampAdjuster, Track track, List<Format> list) {
        this(SubtitleParser.Factory.UNSUPPORTED, i6 | 32, timestampAdjuster, track, list, null);
    }

    @Deprecated
    public FragmentedMp4Extractor(int i6, TimestampAdjuster timestampAdjuster, Track track, List<Format> list, TrackOutput trackOutput) {
        this(SubtitleParser.Factory.UNSUPPORTED, i6 | 32, timestampAdjuster, track, list, trackOutput);
    }

    public Track modifyTrack(Track track) {
        return track;
    }

    public FragmentedMp4Extractor(SubtitleParser.Factory factory, int i6, TimestampAdjuster timestampAdjuster, Track track, List<Format> list, TrackOutput trackOutput) {
        this.subtitleParserFactory = factory;
        this.flags = i6;
        this.timestampAdjuster = timestampAdjuster;
        this.sideloadedTrack = track;
        this.closedCaptionFormats = Collections.unmodifiableList(list);
        this.additionalEmsgTrackOutput = trackOutput;
        this.eventMessageEncoder = new EventMessageEncoder();
        this.atomHeader = new ParsableByteArray(16);
        this.nalStartCode = new ParsableByteArray(NalUnitUtil.NAL_START_CODE);
        this.nalPrefix = new ParsableByteArray(6);
        this.nalUnitWithoutHeaderBuffer = new ParsableByteArray();
        byte[] bArr = new byte[16];
        this.scratchBytes = bArr;
        this.scratch = new ParsableByteArray(bArr);
        this.containerAtoms = new ArrayDeque<>();
        this.pendingMetadataSampleInfos = new ArrayDeque<>();
        this.trackBundles = new SparseArray<>();
        C2204g1 c2204g1 = AbstractC2301u1.f8069b;
        this.lastSniffFailures = C2180c5.f7862e;
        this.durationUs = C0565C.TIME_UNSET;
        this.pendingSeekTimeUs = C0565C.TIME_UNSET;
        this.segmentIndexEarliestPresentationTimeUs = C0565C.TIME_UNSET;
        this.extractorOutput = ExtractorOutput.PLACEHOLDER;
        this.emsgTrackOutputs = new TrackOutput[0];
        this.ceaTrackOutputs = new TrackOutput[0];
        this.reorderingSeiMessageQueue = new ReorderingSeiMessageQueue(new C0628x(6, this));
    }
}
