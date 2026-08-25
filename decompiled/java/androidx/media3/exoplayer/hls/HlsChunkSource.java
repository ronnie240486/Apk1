package androidx.media3.exoplayer.hls;

import android.net.Uri;
import android.os.SystemClock;
import android.util.Pair;
import androidx.media3.common.C0565C;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.TrackGroup;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UriUtil;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DataSpec;
import androidx.media3.datasource.TransferListener;
import androidx.media3.exoplayer.LoadingInfo;
import androidx.media3.exoplayer.SeekParameters;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.hls.playlist.HlsMediaPlaylist;
import androidx.media3.exoplayer.hls.playlist.HlsPlaylistTracker;
import androidx.media3.exoplayer.source.BehindLiveWindowException;
import androidx.media3.exoplayer.source.chunk.BaseMediaChunkIterator;
import androidx.media3.exoplayer.source.chunk.Chunk;
import androidx.media3.exoplayer.source.chunk.DataChunk;
import androidx.media3.exoplayer.source.chunk.MediaChunk;
import androidx.media3.exoplayer.source.chunk.MediaChunkIterator;
import androidx.media3.exoplayer.trackselection.BaseTrackSelection;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import androidx.media3.exoplayer.upstream.CmcdData;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import p000a.AbstractC0004e;
import p041d7.AbstractC2182d0;
import p041d7.AbstractC2301u1;
import p041d7.C2180c5;
import p041d7.C2204g1;
import p055ea.AbstractC2460q;
import p187r4.AbstractC3612b;

class HlsChunkSource {
    public static final int CHUNK_PUBLICATION_STATE_PRELOAD = 0;
    public static final int CHUNK_PUBLICATION_STATE_PUBLISHED = 1;
    public static final int CHUNK_PUBLICATION_STATE_REMOVED = 2;
    private static final int KEY_CACHE_SIZE = 4;
    private final CmcdConfiguration cmcdConfiguration;
    private final DataSource encryptionDataSource;
    private Uri expectedPlaylistUrl;
    private final HlsExtractorFactory extractorFactory;
    private IOException fatalError;
    private boolean independentSegments;
    private boolean isPrimaryTimestampSource;
    private final DataSource mediaDataSource;
    private final List<Format> muxedCaptionFormats;
    private final PlayerId playerId;
    private final Format[] playlistFormats;
    private final HlsPlaylistTracker playlistTracker;
    private final Uri[] playlistUrls;
    private boolean seenExpectedPlaylistError;
    private final long timestampAdjusterInitializationTimeoutMs;
    private final TimestampAdjusterProvider timestampAdjusterProvider;
    private final TrackGroup trackGroup;
    private ExoTrackSelection trackSelection;
    private long lastChunkRequestRealtimeMs = C0565C.TIME_UNSET;
    private final FullSegmentEncryptionKeyCache keyCache = new FullSegmentEncryptionKeyCache(4);
    private byte[] scratchSpace = Util.EMPTY_BYTE_ARRAY;
    private long liveEdgeInPeriodTimeUs = C0565C.TIME_UNSET;

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface ChunkPublicationState {
    }

    public static final class EncryptionKeyChunk extends DataChunk {
        private byte[] result;

        public EncryptionKeyChunk(DataSource dataSource, DataSpec dataSpec, Format format, int i6, Object obj, byte[] bArr) {
            super(dataSource, dataSpec, 3, format, i6, obj, bArr);
        }

        @Override
        public void consume(byte[] bArr, int i6) {
            this.result = Arrays.copyOf(bArr, i6);
        }

        public byte[] getResult() {
            return this.result;
        }
    }

    public static final class HlsChunkHolder {
        public Chunk chunk;
        public boolean endOfStream;
        public Uri playlistUrl;

        public HlsChunkHolder() {
            clear();
        }

        public void clear() {
            this.chunk = null;
            this.endOfStream = false;
            this.playlistUrl = null;
        }
    }

    public static final class HlsMediaPlaylistSegmentIterator extends BaseMediaChunkIterator {
        private final String playlistBaseUri;
        private final List<HlsMediaPlaylist.SegmentBase> segmentBases;
        private final long startOfPlaylistInPeriodUs;

        public HlsMediaPlaylistSegmentIterator(String str, long j10, List<HlsMediaPlaylist.SegmentBase> list) {
            super(0L, list.size() - 1);
            this.playlistBaseUri = str;
            this.startOfPlaylistInPeriodUs = j10;
            this.segmentBases = list;
        }

        @Override
        public long getChunkEndTimeUs() {
            checkInBounds();
            HlsMediaPlaylist.SegmentBase segmentBase = this.segmentBases.get((int) getCurrentIndex());
            return this.startOfPlaylistInPeriodUs + segmentBase.relativeStartTimeUs + segmentBase.durationUs;
        }

        @Override
        public long getChunkStartTimeUs() {
            checkInBounds();
            return this.startOfPlaylistInPeriodUs + this.segmentBases.get((int) getCurrentIndex()).relativeStartTimeUs;
        }

        @Override
        public DataSpec getDataSpec() {
            checkInBounds();
            HlsMediaPlaylist.SegmentBase segmentBase = this.segmentBases.get((int) getCurrentIndex());
            return new DataSpec(UriUtil.resolveToUri(this.playlistBaseUri, segmentBase.url), segmentBase.byteRangeOffset, segmentBase.byteRangeLength);
        }
    }

    public static final class InitializationTrackSelection extends BaseTrackSelection {
        private int selectedIndex;

        public InitializationTrackSelection(TrackGroup trackGroup, int[] iArr) {
            super(trackGroup, iArr);
            this.selectedIndex = indexOf(trackGroup.getFormat(iArr[0]));
        }

        @Override
        public int getSelectedIndex() {
            return this.selectedIndex;
        }

        @Override
        public Object getSelectionData() {
            return null;
        }

        @Override
        public int getSelectionReason() {
            return 0;
        }

        @Override
        public void updateSelectedTrack(long j10, long j11, long j12, List<? extends MediaChunk> list, MediaChunkIterator[] mediaChunkIteratorArr) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            if (isTrackExcluded(this.selectedIndex, jElapsedRealtime)) {
                for (int i6 = this.length - 1; i6 >= 0; i6--) {
                    if (!isTrackExcluded(i6, jElapsedRealtime)) {
                        this.selectedIndex = i6;
                        return;
                    }
                }
                throw new IllegalStateException();
            }
        }
    }

    public static final class SegmentBaseHolder {
        public final boolean isPreload;
        public final long mediaSequence;
        public final int partIndex;
        public final HlsMediaPlaylist.SegmentBase segmentBase;

        public SegmentBaseHolder(HlsMediaPlaylist.SegmentBase segmentBase, long j10, int i6) {
            this.segmentBase = segmentBase;
            this.mediaSequence = j10;
            this.partIndex = i6;
            this.isPreload = (segmentBase instanceof HlsMediaPlaylist.Part) && ((HlsMediaPlaylist.Part) segmentBase).isPreload;
        }
    }

    public HlsChunkSource(HlsExtractorFactory hlsExtractorFactory, HlsPlaylistTracker hlsPlaylistTracker, Uri[] uriArr, Format[] formatArr, HlsDataSourceFactory hlsDataSourceFactory, TransferListener transferListener, TimestampAdjusterProvider timestampAdjusterProvider, long j10, List<Format> list, PlayerId playerId, CmcdConfiguration cmcdConfiguration) {
        this.extractorFactory = hlsExtractorFactory;
        this.playlistTracker = hlsPlaylistTracker;
        this.playlistUrls = uriArr;
        this.playlistFormats = formatArr;
        this.timestampAdjusterProvider = timestampAdjusterProvider;
        this.timestampAdjusterInitializationTimeoutMs = j10;
        this.muxedCaptionFormats = list;
        this.playerId = playerId;
        this.cmcdConfiguration = cmcdConfiguration;
        DataSource dataSourceCreateDataSource = hlsDataSourceFactory.createDataSource(1);
        this.mediaDataSource = dataSourceCreateDataSource;
        if (transferListener != null) {
            dataSourceCreateDataSource.addTransferListener(transferListener);
        }
        this.encryptionDataSource = hlsDataSourceFactory.createDataSource(3);
        this.trackGroup = new TrackGroup(formatArr);
        ArrayList arrayList = new ArrayList();
        for (int i6 = 0; i6 < uriArr.length; i6++) {
            if ((formatArr[i6].roleFlags & 16384) == 0) {
                arrayList.add(Integer.valueOf(i6));
            }
        }
        this.trackSelection = new InitializationTrackSelection(this.trackGroup, AbstractC3612b.m7258N(arrayList));
    }

    private void deactivatePlaylistForSelectedTrack() {
        this.playlistTracker.deactivatePlaylistForPlayback(this.playlistUrls[this.trackSelection.getSelectedIndexInTrackGroup()]);
    }

    private static Uri getFullEncryptionKeyUri(HlsMediaPlaylist hlsMediaPlaylist, HlsMediaPlaylist.SegmentBase segmentBase) {
        String str;
        if (segmentBase == null || (str = segmentBase.fullSegmentEncryptionKeyUri) == null) {
            return null;
        }
        return UriUtil.resolveToUri(hlsMediaPlaylist.baseUri, str);
    }

    private Pair<Long, Integer> getNextMediaSequenceAndPartIndex(HlsMediaChunk hlsMediaChunk, boolean z7, HlsMediaPlaylist hlsMediaPlaylist, long j10, long j11) {
        int i6 = -1;
        if (hlsMediaChunk != null && !z7) {
            if (!hlsMediaChunk.isLoadCompleted()) {
                return new Pair<>(Long.valueOf(hlsMediaChunk.chunkIndex), Integer.valueOf(hlsMediaChunk.partIndex));
            }
            Long lValueOf = Long.valueOf(hlsMediaChunk.partIndex == -1 ? hlsMediaChunk.getNextChunkIndex() : hlsMediaChunk.chunkIndex);
            int i10 = hlsMediaChunk.partIndex;
            return new Pair<>(lValueOf, Integer.valueOf(i10 != -1 ? i10 + 1 : -1));
        }
        long j12 = hlsMediaPlaylist.durationUs + j10;
        if (hlsMediaChunk != null && !this.independentSegments) {
            j11 = hlsMediaChunk.startTimeUs;
        }
        if (!hlsMediaPlaylist.hasEndTag && j11 >= j12) {
            return new Pair<>(Long.valueOf(hlsMediaPlaylist.mediaSequence + ((long) hlsMediaPlaylist.segments.size())), -1);
        }
        long j13 = j11 - j10;
        int iBinarySearchFloor = Util.binarySearchFloor((List<? extends Comparable<? super Long>>) hlsMediaPlaylist.segments, Long.valueOf(j13), true, !this.playlistTracker.isLive() || hlsMediaChunk == null);
        long j14 = ((long) iBinarySearchFloor) + hlsMediaPlaylist.mediaSequence;
        if (iBinarySearchFloor >= 0) {
            HlsMediaPlaylist.Segment segment = hlsMediaPlaylist.segments.get(iBinarySearchFloor);
            List<HlsMediaPlaylist.Part> list = j13 < segment.relativeStartTimeUs + segment.durationUs ? segment.parts : hlsMediaPlaylist.trailingParts;
            for (int i11 = 0; i11 < list.size(); i11++) {
                HlsMediaPlaylist.Part part = list.get(i11);
                if (j13 < part.relativeStartTimeUs + part.durationUs) {
                    if (!part.isIndependent) {
                        break;
                    }
                    j14 += list == hlsMediaPlaylist.trailingParts ? 1L : 0L;
                    i6 = i11;
                    break;
                }
            }
        }
        return new Pair<>(Long.valueOf(j14), Integer.valueOf(i6));
    }

    private static SegmentBaseHolder getNextSegmentHolder(HlsMediaPlaylist hlsMediaPlaylist, long j10, int i6) {
        int i10 = (int) (j10 - hlsMediaPlaylist.mediaSequence);
        if (i10 == hlsMediaPlaylist.segments.size()) {
            if (i6 == -1) {
                i6 = 0;
            }
            if (i6 < hlsMediaPlaylist.trailingParts.size()) {
                return new SegmentBaseHolder(hlsMediaPlaylist.trailingParts.get(i6), j10, i6);
            }
            return null;
        }
        HlsMediaPlaylist.Segment segment = hlsMediaPlaylist.segments.get(i10);
        if (i6 == -1) {
            return new SegmentBaseHolder(segment, j10, -1);
        }
        if (i6 < segment.parts.size()) {
            return new SegmentBaseHolder(segment.parts.get(i6), j10, i6);
        }
        int i11 = i10 + 1;
        if (i11 < hlsMediaPlaylist.segments.size()) {
            return new SegmentBaseHolder(hlsMediaPlaylist.segments.get(i11), j10 + 1, -1);
        }
        if (hlsMediaPlaylist.trailingParts.isEmpty()) {
            return null;
        }
        return new SegmentBaseHolder(hlsMediaPlaylist.trailingParts.get(0), j10 + 1, 0);
    }

    public static List<HlsMediaPlaylist.SegmentBase> getSegmentBaseList(HlsMediaPlaylist hlsMediaPlaylist, long j10, int i6) {
        int i10 = (int) (j10 - hlsMediaPlaylist.mediaSequence);
        if (i10 < 0 || hlsMediaPlaylist.segments.size() < i10) {
            C2204g1 c2204g1 = AbstractC2301u1.f8069b;
            return C2180c5.f7862e;
        }
        ArrayList arrayList = new ArrayList();
        if (i10 < hlsMediaPlaylist.segments.size()) {
            if (i6 != -1) {
                HlsMediaPlaylist.Segment segment = hlsMediaPlaylist.segments.get(i10);
                if (i6 == 0) {
                    arrayList.add(segment);
                } else if (i6 < segment.parts.size()) {
                    List<HlsMediaPlaylist.Part> list = segment.parts;
                    arrayList.addAll(list.subList(i6, list.size()));
                }
                i10++;
            }
            List<HlsMediaPlaylist.Segment> list2 = hlsMediaPlaylist.segments;
            arrayList.addAll(list2.subList(i10, list2.size()));
            i6 = 0;
        }
        if (hlsMediaPlaylist.partTargetDurationUs != C0565C.TIME_UNSET) {
            int i11 = i6 != -1 ? i6 : 0;
            if (i11 < hlsMediaPlaylist.trailingParts.size()) {
                List<HlsMediaPlaylist.Part> list3 = hlsMediaPlaylist.trailingParts;
                arrayList.addAll(list3.subList(i11, list3.size()));
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    private Chunk maybeCreateEncryptionChunkFor(Uri uri, int i6, boolean z7, CmcdData.Factory factory) {
        if (uri == null) {
            return null;
        }
        byte[] bArrRemove = this.keyCache.remove(uri);
        if (bArrRemove != null) {
            this.keyCache.put(uri, bArrRemove);
            return null;
        }
        DataSpec dataSpecBuild = new DataSpec.Builder().setUri(uri).setFlags(1).build();
        if (factory != null) {
            if (z7) {
                factory.setObjectType(CmcdData.OBJECT_TYPE_INIT_SEGMENT);
            }
            dataSpecBuild = factory.createCmcdData().addToDataSpec(dataSpecBuild);
        }
        return new EncryptionKeyChunk(this.encryptionDataSource, dataSpecBuild, this.playlistFormats[i6], this.trackSelection.getSelectionReason(), this.trackSelection.getSelectionData(), this.scratchSpace);
    }

    private long resolveTimeToLiveEdgeUs(long j10) {
        long j11 = this.liveEdgeInPeriodTimeUs;
        return j11 != C0565C.TIME_UNSET ? j11 - j10 : C0565C.TIME_UNSET;
    }

    private void updateLiveEdgeTimeUs(HlsMediaPlaylist hlsMediaPlaylist) {
        this.liveEdgeInPeriodTimeUs = hlsMediaPlaylist.hasEndTag ? C0565C.TIME_UNSET : hlsMediaPlaylist.getEndTimeUs() - this.playlistTracker.getInitialStartTimeUs();
    }

    public MediaChunkIterator[] createMediaChunkIterators(HlsMediaChunk hlsMediaChunk, long j10) {
        int i6;
        int iIndexOf = hlsMediaChunk == null ? -1 : this.trackGroup.indexOf(hlsMediaChunk.trackFormat);
        int length = this.trackSelection.length();
        MediaChunkIterator[] mediaChunkIteratorArr = new MediaChunkIterator[length];
        boolean z7 = false;
        int i10 = 0;
        while (i10 < length) {
            int indexInTrackGroup = this.trackSelection.getIndexInTrackGroup(i10);
            Uri uri = this.playlistUrls[indexInTrackGroup];
            if (this.playlistTracker.isSnapshotValid(uri)) {
                HlsMediaPlaylist playlistSnapshot = this.playlistTracker.getPlaylistSnapshot(uri, z7);
                Assertions.checkNotNull(playlistSnapshot);
                long initialStartTimeUs = playlistSnapshot.startTimeUs - this.playlistTracker.getInitialStartTimeUs();
                i6 = i10;
                Pair<Long, Integer> nextMediaSequenceAndPartIndex = getNextMediaSequenceAndPartIndex(hlsMediaChunk, indexInTrackGroup != iIndexOf, playlistSnapshot, initialStartTimeUs, j10);
                mediaChunkIteratorArr[i6] = new HlsMediaPlaylistSegmentIterator(playlistSnapshot.baseUri, initialStartTimeUs, getSegmentBaseList(playlistSnapshot, ((Long) nextMediaSequenceAndPartIndex.first).longValue(), ((Integer) nextMediaSequenceAndPartIndex.second).intValue()));
            } else {
                mediaChunkIteratorArr[i10] = MediaChunkIterator.EMPTY;
                i6 = i10;
            }
            i10 = i6 + 1;
            z7 = false;
        }
        return mediaChunkIteratorArr;
    }

    public long getAdjustedSeekPositionUs(long j10, SeekParameters seekParameters) {
        int selectedIndex = this.trackSelection.getSelectedIndex();
        Uri[] uriArr = this.playlistUrls;
        HlsMediaPlaylist playlistSnapshot = (selectedIndex >= uriArr.length || selectedIndex == -1) ? null : this.playlistTracker.getPlaylistSnapshot(uriArr[this.trackSelection.getSelectedIndexInTrackGroup()], true);
        if (playlistSnapshot == null || playlistSnapshot.segments.isEmpty()) {
            return j10;
        }
        long initialStartTimeUs = playlistSnapshot.startTimeUs - this.playlistTracker.getInitialStartTimeUs();
        long j11 = j10 - initialStartTimeUs;
        int iBinarySearchFloor = Util.binarySearchFloor((List<? extends Comparable<? super Long>>) playlistSnapshot.segments, Long.valueOf(j11), true, true);
        long j12 = playlistSnapshot.segments.get(iBinarySearchFloor).relativeStartTimeUs;
        return seekParameters.resolveSeekPositionUs(j11, j12, (!playlistSnapshot.hasIndependentSegments || iBinarySearchFloor == playlistSnapshot.segments.size() - 1) ? j12 : playlistSnapshot.segments.get(iBinarySearchFloor + 1).relativeStartTimeUs) + initialStartTimeUs;
    }

    public int getChunkPublicationState(HlsMediaChunk hlsMediaChunk) {
        if (hlsMediaChunk.partIndex == -1) {
            return 1;
        }
        HlsMediaPlaylist hlsMediaPlaylist = (HlsMediaPlaylist) Assertions.checkNotNull(this.playlistTracker.getPlaylistSnapshot(this.playlistUrls[this.trackGroup.indexOf(hlsMediaChunk.trackFormat)], false));
        int i6 = (int) (hlsMediaChunk.chunkIndex - hlsMediaPlaylist.mediaSequence);
        if (i6 < 0) {
            return 1;
        }
        List<HlsMediaPlaylist.Part> list = i6 < hlsMediaPlaylist.segments.size() ? hlsMediaPlaylist.segments.get(i6).parts : hlsMediaPlaylist.trailingParts;
        if (hlsMediaChunk.partIndex >= list.size()) {
            return 2;
        }
        HlsMediaPlaylist.Part part = list.get(hlsMediaChunk.partIndex);
        if (part.isPreload) {
            return 0;
        }
        return Objects.equals(Uri.parse(UriUtil.resolve(hlsMediaPlaylist.baseUri, part.url)), hlsMediaChunk.dataSpec.uri) ? 1 : 2;
    }

    public void getNextChunk(LoadingInfo loadingInfo, long j10, List<HlsMediaChunk> list, boolean z7, HlsChunkHolder hlsChunkHolder) {
        long j11;
        long jMax;
        HlsMediaPlaylist hlsMediaPlaylist;
        Uri uri;
        int i6;
        boolean z10;
        long jLongValue;
        int iIntValue;
        HlsMediaPlaylist hlsMediaPlaylist2;
        int i10;
        Uri uri2;
        long j12;
        Uri uri3;
        HlsMediaChunk hlsMediaChunk = list.isEmpty() ? null : (HlsMediaChunk) AbstractC2182d0.m5151n(list);
        int iIndexOf = hlsMediaChunk == null ? -1 : this.trackGroup.indexOf(hlsMediaChunk.trackFormat);
        long j13 = loadingInfo.playbackPositionUs;
        boolean z11 = hlsMediaChunk == null;
        long jMax2 = j10 - j13;
        long jResolveTimeToLiveEdgeUs = resolveTimeToLiveEdgeUs(j13);
        if (hlsMediaChunk == null || this.independentSegments) {
            j11 = jMax2;
            jMax = jResolveTimeToLiveEdgeUs;
        } else {
            long durationUs = hlsMediaChunk.getDurationUs();
            jMax2 = Math.max(0L, jMax2 - durationUs);
            if (jResolveTimeToLiveEdgeUs != C0565C.TIME_UNSET) {
                jMax = Math.max(0L, jResolveTimeToLiveEdgeUs - durationUs);
                j11 = jMax2;
            } else {
                j11 = jMax2;
                jMax = jResolveTimeToLiveEdgeUs;
            }
        }
        this.trackSelection.updateSelectedTrack(j13, j11, jMax, list, createMediaChunkIterators(hlsMediaChunk, j10));
        int selectedIndexInTrackGroup = this.trackSelection.getSelectedIndexInTrackGroup();
        boolean z12 = iIndexOf != selectedIndexInTrackGroup;
        Uri uri4 = this.playlistUrls[selectedIndexInTrackGroup];
        Format format = this.playlistFormats[selectedIndexInTrackGroup];
        boolean z13 = format != null && MimeTypes.isText(format.sampleMimeType);
        if (!this.playlistTracker.isSnapshotValid(uri4)) {
            hlsChunkHolder.playlistUrl = uri4;
            this.seenExpectedPlaylistError &= uri4.equals(this.expectedPlaylistUrl);
            this.expectedPlaylistUrl = uri4;
            return;
        }
        HlsMediaPlaylist playlistSnapshot = this.playlistTracker.getPlaylistSnapshot(uri4, true);
        Assertions.checkNotNull(playlistSnapshot);
        this.independentSegments = playlistSnapshot.hasIndependentSegments;
        updateLiveEdgeTimeUs(playlistSnapshot);
        long j14 = j11;
        long initialStartTimeUs = playlistSnapshot.startTimeUs - this.playlistTracker.getInitialStartTimeUs();
        if (z11 && z13) {
            hlsMediaPlaylist = playlistSnapshot;
            jLongValue = (playlistSnapshot.mediaSequence + ((long) playlistSnapshot.segments.size())) - 1;
            i6 = selectedIndexInTrackGroup;
            iIntValue = -1;
            z10 = true;
            uri = uri4;
        } else {
            hlsMediaPlaylist = playlistSnapshot;
            uri = uri4;
            i6 = selectedIndexInTrackGroup;
            z10 = true;
            Pair<Long, Integer> nextMediaSequenceAndPartIndex = getNextMediaSequenceAndPartIndex(hlsMediaChunk, z12, hlsMediaPlaylist, initialStartTimeUs, j10);
            jLongValue = ((Long) nextMediaSequenceAndPartIndex.first).longValue();
            iIntValue = ((Integer) nextMediaSequenceAndPartIndex.second).intValue();
        }
        HlsMediaPlaylist hlsMediaPlaylist3 = hlsMediaPlaylist;
        if (jLongValue >= hlsMediaPlaylist3.mediaSequence || hlsMediaChunk == null || !z12) {
            hlsMediaPlaylist2 = hlsMediaPlaylist3;
            i10 = i6;
            uri2 = uri;
            j12 = initialStartTimeUs;
        } else {
            uri3 = this.playlistUrls[iIndexOf];
            HlsMediaPlaylist playlistSnapshot2 = this.playlistTracker.getPlaylistSnapshot(uri3, z10);
            Assertions.checkNotNull(playlistSnapshot2);
            long initialStartTimeUs2 = playlistSnapshot2.startTimeUs - this.playlistTracker.getInitialStartTimeUs();
            Pair<Long, Integer> nextMediaSequenceAndPartIndex2 = getNextMediaSequenceAndPartIndex(hlsMediaChunk, false, playlistSnapshot2, initialStartTimeUs2, j10);
            jLongValue = ((Long) nextMediaSequenceAndPartIndex2.first).longValue();
            iIntValue = ((Integer) nextMediaSequenceAndPartIndex2.second).intValue();
            i10 = iIndexOf;
            j12 = initialStartTimeUs2;
            hlsMediaPlaylist2 = playlistSnapshot2;
        }
        if (i10 != iIndexOf && iIndexOf != -1) {
            uri2 = uri3;
            this.playlistTracker.deactivatePlaylistForPlayback(this.playlistUrls[iIndexOf]);
        }
        uri2 = uri3;
        uri2 = uri3;
        HlsMediaChunk hlsMediaChunk2 = hlsMediaChunk;
        if (jLongValue < hlsMediaPlaylist2.mediaSequence) {
            this.fatalError = new BehindLiveWindowException();
            return;
        }
        SegmentBaseHolder nextSegmentHolder = getNextSegmentHolder(hlsMediaPlaylist2, jLongValue, iIntValue);
        if (nextSegmentHolder == null) {
            if (!hlsMediaPlaylist2.hasEndTag) {
                hlsChunkHolder.playlistUrl = uri2;
                this.seenExpectedPlaylistError &= uri2.equals(this.expectedPlaylistUrl);
                this.expectedPlaylistUrl = uri2;
                return;
            } else {
                if (z7 || hlsMediaPlaylist2.segments.isEmpty()) {
                    hlsChunkHolder.endOfStream = true;
                    return;
                }
                nextSegmentHolder = new SegmentBaseHolder((HlsMediaPlaylist.SegmentBase) AbstractC2182d0.m5151n(hlsMediaPlaylist2.segments), (hlsMediaPlaylist2.mediaSequence + ((long) hlsMediaPlaylist2.segments.size())) - 1, -1);
            }
        }
        this.seenExpectedPlaylistError = false;
        CmcdData.Factory chunkDurationUs = null;
        this.expectedPlaylistUrl = null;
        if (this.cmcdConfiguration != null) {
            chunkDurationUs = new CmcdData.Factory(this.cmcdConfiguration, CmcdData.STREAMING_FORMAT_HLS).setTrackSelection(this.trackSelection).setBufferedDurationUs(Math.max(0L, j14)).setPlaybackRate(loadingInfo.playbackSpeed).setIsLive(!hlsMediaPlaylist2.hasEndTag).setDidRebuffer(loadingInfo.rebufferedSince(this.lastChunkRequestRealtimeMs)).setIsBufferEmpty(list.isEmpty()).setChunkDurationUs(nextSegmentHolder.segmentBase.durationUs);
            int i11 = nextSegmentHolder.partIndex;
            SegmentBaseHolder nextSegmentHolder2 = getNextSegmentHolder(hlsMediaPlaylist2, i11 == -1 ? nextSegmentHolder.mediaSequence + 1 : nextSegmentHolder.mediaSequence, i11 == -1 ? -1 : i11 + 1);
            if (nextSegmentHolder2 != null) {
                chunkDurationUs.setNextObjectRequest(UriUtil.getRelativePath(UriUtil.resolveToUri(hlsMediaPlaylist2.baseUri, nextSegmentHolder.segmentBase.url), UriUtil.resolveToUri(hlsMediaPlaylist2.baseUri, nextSegmentHolder2.segmentBase.url)));
                String strM25s = AbstractC0004e.m25s(new StringBuilder(), nextSegmentHolder2.segmentBase.byteRangeOffset, "-");
                if (nextSegmentHolder2.segmentBase.byteRangeLength != -1) {
                    StringBuilder sbM5498l = AbstractC2460q.m5498l(strM25s);
                    HlsMediaPlaylist.SegmentBase segmentBase = nextSegmentHolder2.segmentBase;
                    sbM5498l.append(segmentBase.byteRangeOffset + segmentBase.byteRangeLength);
                    strM25s = sbM5498l.toString();
                }
                chunkDurationUs.setNextRangeRequest(strM25s);
            }
        }
        CmcdData.Factory factory = chunkDurationUs;
        this.lastChunkRequestRealtimeMs = SystemClock.elapsedRealtime();
        Uri fullEncryptionKeyUri = getFullEncryptionKeyUri(hlsMediaPlaylist2, nextSegmentHolder.segmentBase.initializationSegment);
        Chunk chunkMaybeCreateEncryptionChunkFor = maybeCreateEncryptionChunkFor(fullEncryptionKeyUri, i10, true, factory);
        hlsChunkHolder.chunk = chunkMaybeCreateEncryptionChunkFor;
        if (chunkMaybeCreateEncryptionChunkFor != null) {
            return;
        }
        Uri fullEncryptionKeyUri2 = getFullEncryptionKeyUri(hlsMediaPlaylist2, nextSegmentHolder.segmentBase);
        Chunk chunkMaybeCreateEncryptionChunkFor2 = maybeCreateEncryptionChunkFor(fullEncryptionKeyUri2, i10, false, factory);
        hlsChunkHolder.chunk = chunkMaybeCreateEncryptionChunkFor2;
        if (chunkMaybeCreateEncryptionChunkFor2 != null) {
            return;
        }
        HlsMediaPlaylist hlsMediaPlaylist4 = hlsMediaPlaylist2;
        Uri uri5 = uri2;
        boolean zShouldSpliceIn = HlsMediaChunk.shouldSpliceIn(hlsMediaChunk2, uri2, hlsMediaPlaylist2, nextSegmentHolder, j12);
        if (zShouldSpliceIn && nextSegmentHolder.isPreload) {
            return;
        }
        hlsChunkHolder.chunk = HlsMediaChunk.createInstance(this.extractorFactory, this.mediaDataSource, this.playlistFormats[i10], j12, hlsMediaPlaylist4, nextSegmentHolder, uri5, this.muxedCaptionFormats, this.trackSelection.getSelectionReason(), this.trackSelection.getSelectionData(), this.isPrimaryTimestampSource, this.timestampAdjusterProvider, this.timestampAdjusterInitializationTimeoutMs, hlsMediaChunk2, this.keyCache.get(fullEncryptionKeyUri2), this.keyCache.get(fullEncryptionKeyUri), zShouldSpliceIn, this.playerId, factory);
    }

    public int getPreferredQueueSize(long j10, List<? extends MediaChunk> list) {
        return (this.fatalError != null || this.trackSelection.length() < 2) ? list.size() : this.trackSelection.evaluateQueueSize(j10, list);
    }

    public TrackGroup getTrackGroup() {
        return this.trackGroup;
    }

    public ExoTrackSelection getTrackSelection() {
        return this.trackSelection;
    }

    public boolean hasIndependentSegments() {
        return this.independentSegments;
    }

    public boolean maybeExcludeTrack(Chunk chunk, long j10) {
        ExoTrackSelection exoTrackSelection = this.trackSelection;
        return exoTrackSelection.excludeTrack(exoTrackSelection.indexOf(this.trackGroup.indexOf(chunk.trackFormat)), j10);
    }

    public void maybeThrowError() throws IOException {
        IOException iOException = this.fatalError;
        if (iOException != null) {
            throw iOException;
        }
        Uri uri = this.expectedPlaylistUrl;
        if (uri == null || !this.seenExpectedPlaylistError) {
            return;
        }
        this.playlistTracker.maybeThrowPlaylistRefreshError(uri);
    }

    public boolean obtainsChunksForPlaylist(Uri uri) {
        return Util.contains(this.playlistUrls, uri);
    }

    public void onChunkLoadCompleted(Chunk chunk) {
        if (chunk instanceof EncryptionKeyChunk) {
            EncryptionKeyChunk encryptionKeyChunk = (EncryptionKeyChunk) chunk;
            this.scratchSpace = encryptionKeyChunk.getDataHolder();
            this.keyCache.put(encryptionKeyChunk.dataSpec.uri, (byte[]) Assertions.checkNotNull(encryptionKeyChunk.getResult()));
        }
    }

    public boolean onPlaylistError(Uri uri, long j10) {
        int iIndexOf;
        int i6 = 0;
        while (true) {
            Uri[] uriArr = this.playlistUrls;
            if (i6 >= uriArr.length) {
                i6 = -1;
                break;
            }
            if (uriArr[i6].equals(uri)) {
                break;
            }
            i6++;
        }
        if (i6 == -1 || (iIndexOf = this.trackSelection.indexOf(i6)) == -1) {
            return true;
        }
        this.seenExpectedPlaylistError |= uri.equals(this.expectedPlaylistUrl);
        return j10 == C0565C.TIME_UNSET || (this.trackSelection.excludeTrack(iIndexOf, j10) && this.playlistTracker.excludeMediaPlaylist(uri, j10));
    }

    public void reset() {
        deactivatePlaylistForSelectedTrack();
        this.fatalError = null;
    }

    public void setIsPrimaryTimestampSource(boolean z7) {
        this.isPrimaryTimestampSource = z7;
    }

    public void setTrackSelection(ExoTrackSelection exoTrackSelection) {
        deactivatePlaylistForSelectedTrack();
        this.trackSelection = exoTrackSelection;
    }

    public boolean shouldCancelLoad(long j10, Chunk chunk, List<? extends MediaChunk> list) {
        if (this.fatalError != null) {
            return false;
        }
        return this.trackSelection.shouldCancelChunkLoad(j10, chunk, list);
    }
}
