package okio.internal;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import okhttp3.internal.p159ws.WebSocketProtocol;
import okio.BufferedSource;
import okio.FileHandle;
import okio.FileMetadata;
import okio.FileSystem;
import okio.Okio;
import okio.Path;
import okio.ZipFileSystem;
import p000a.AbstractC0004e;
import p003a2.AbstractC0032a;
import p091i9.InterfaceC2724l;
import p091i9.InterfaceC2728p;
import p103j9.AbstractC2796i;
import p103j9.AbstractC2797j;
import p103j9.C2799l;
import p103j9.C2800m;
import p103j9.C2801n;
import p156o9.AbstractC3280d;
import p192r9.AbstractC3648f;
import p192r9.AbstractC3656n;
import p243w8.C4064f;
import p243w8.C4070l;
import p253x8.AbstractC4147j;
import p253x8.AbstractC4158u;

public final class ZipFilesKt {
    private static final int BIT_FLAG_ENCRYPTED = 1;
    private static final int BIT_FLAG_UNSUPPORTED_MASK = 1;
    private static final int CENTRAL_FILE_HEADER_SIGNATURE = 33639248;
    public static final int COMPRESSION_METHOD_DEFLATED = 8;
    public static final int COMPRESSION_METHOD_STORED = 0;
    private static final int END_OF_CENTRAL_DIRECTORY_SIGNATURE = 101010256;
    private static final int HEADER_ID_EXTENDED_TIMESTAMP = 21589;
    private static final int HEADER_ID_ZIP64_EXTENDED_INFO = 1;
    private static final int LOCAL_FILE_HEADER_SIGNATURE = 67324752;
    private static final long MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE = 4294967295L;
    private static final int ZIP64_EOCD_RECORD_SIGNATURE = 101075792;
    private static final int ZIP64_LOCATOR_SIGNATURE = 117853008;

    public static final class C33161 extends AbstractC2797j implements InterfaceC2724l {
        public static final C33161 INSTANCE = new C33161();

        public C33161() {
            super(1);
        }

        @Override
        public final Boolean invoke(ZipEntry zipEntry) {
            AbstractC2796i.m5785f(zipEntry, "it");
            return Boolean.TRUE;
        }
    }

    public static final class C33171 extends AbstractC2797j implements InterfaceC2728p {
        final C2800m $compressedSize;
        final C2799l $hasZip64Extra;
        final C2800m $offset;
        final long $requiredZip64ExtraSize;
        final C2800m $size;
        final BufferedSource $this_readEntry;

        public C33171(C2799l c2799l, long j10, C2800m c2800m, BufferedSource bufferedSource, C2800m c2800m2, C2800m c2800m3) {
            super(2);
            this.$hasZip64Extra = c2799l;
            this.$requiredZip64ExtraSize = j10;
            this.$size = c2800m;
            this.$this_readEntry = bufferedSource;
            this.$compressedSize = c2800m2;
            this.$offset = c2800m3;
        }

        @Override
        public Object invoke(Object obj, Object obj2) throws IOException {
            invoke(((Number) obj).intValue(), ((Number) obj2).longValue());
            return C4070l.f13734a;
        }

        public final void invoke(int i6, long j10) throws IOException {
            if (i6 == 1) {
                C2799l c2799l = this.$hasZip64Extra;
                if (c2799l.f9538a) {
                    throw new IOException("bad zip: zip64 extra repeated");
                }
                c2799l.f9538a = true;
                if (j10 < this.$requiredZip64ExtraSize) {
                    throw new IOException("bad zip: zip64 extra too short");
                }
                C2800m c2800m = this.$size;
                long longLe = c2800m.f9539a;
                if (longLe == ZipFilesKt.MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE) {
                    longLe = this.$this_readEntry.readLongLe();
                }
                c2800m.f9539a = longLe;
                C2800m c2800m2 = this.$compressedSize;
                c2800m2.f9539a = c2800m2.f9539a == ZipFilesKt.MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE ? this.$this_readEntry.readLongLe() : 0L;
                C2800m c2800m3 = this.$offset;
                c2800m3.f9539a = c2800m3.f9539a == ZipFilesKt.MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE ? this.$this_readEntry.readLongLe() : 0L;
            }
        }
    }

    public static final class C33181 extends AbstractC2797j implements InterfaceC2728p {
        final C2801n $createdAtMillis;
        final C2801n $lastAccessedAtMillis;
        final C2801n $lastModifiedAtMillis;
        final BufferedSource $this_readOrSkipLocalHeader;

        public C33181(BufferedSource bufferedSource, C2801n c2801n, C2801n c2801n2, C2801n c2801n3) {
            super(2);
            this.$this_readOrSkipLocalHeader = bufferedSource;
            this.$lastModifiedAtMillis = c2801n;
            this.$lastAccessedAtMillis = c2801n2;
            this.$createdAtMillis = c2801n3;
        }

        @Override
        public Object invoke(Object obj, Object obj2) throws IOException {
            invoke(((Number) obj).intValue(), ((Number) obj2).longValue());
            return C4070l.f13734a;
        }

        public final void invoke(int i6, long j10) throws IOException {
            if (i6 == ZipFilesKt.HEADER_ID_EXTENDED_TIMESTAMP) {
                if (j10 < 1) {
                    throw new IOException("bad zip: extended timestamp extra too short");
                }
                byte b8 = this.$this_readOrSkipLocalHeader.readByte();
                boolean z7 = (b8 & 1) == 1;
                boolean z10 = (b8 & 2) == 2;
                boolean z11 = (b8 & 4) == 4;
                BufferedSource bufferedSource = this.$this_readOrSkipLocalHeader;
                long j11 = z7 ? 5L : 1L;
                if (z10) {
                    j11 += 4;
                }
                if (z11) {
                    j11 += 4;
                }
                if (j10 < j11) {
                    throw new IOException("bad zip: extended timestamp extra too short");
                }
                if (z7) {
                    this.$lastModifiedAtMillis.f9540a = Long.valueOf(((long) bufferedSource.readIntLe()) * 1000);
                }
                if (z10) {
                    this.$lastAccessedAtMillis.f9540a = Long.valueOf(((long) this.$this_readOrSkipLocalHeader.readIntLe()) * 1000);
                }
                if (z11) {
                    this.$createdAtMillis.f9540a = Long.valueOf(((long) this.$this_readOrSkipLocalHeader.readIntLe()) * 1000);
                }
            }
        }
    }

    private static final Map<Path, ZipEntry> buildIndex(List<ZipEntry> list) {
        List<ZipEntry> listAsList;
        Path path = Path.Companion.get$default(Path.Companion, "/", false, 1, (Object) null);
        C4064f[] c4064fArr = {new C4064f(path, new ZipEntry(path, true, null, 0L, 0L, 0L, 0, null, 0L, 508, null))};
        LinkedHashMap linkedHashMap = new LinkedHashMap(AbstractC4158u.m8196p(1));
        C4064f c4064f = c4064fArr[0];
        linkedHashMap.put(c4064f.f13727a, c4064f.f13728b);
        Comparator comparator = new Comparator() {
            @Override
            public final int compare(T t5, T t8) {
                Path canonicalPath = ((ZipEntry) t5).getCanonicalPath();
                Path canonicalPath2 = ((ZipEntry) t8).getCanonicalPath();
                if (canonicalPath == canonicalPath2) {
                    return 0;
                }
                if (canonicalPath == null) {
                    return -1;
                }
                if (canonicalPath2 == null) {
                    return 1;
                }
                return canonicalPath.compareTo(canonicalPath2);
            }
        };
        AbstractC2796i.m5785f(list, "<this>");
        if (list.size() <= 1) {
            listAsList = AbstractC4147j.m8189c0(list);
        } else {
            Object[] array = list.toArray(new Object[0]);
            AbstractC2796i.m5785f(array, "<this>");
            if (array.length > 1) {
                Arrays.sort(array, comparator);
            }
            listAsList = Arrays.asList(array);
            AbstractC2796i.m5784e(listAsList, "asList(...)");
        }
        for (ZipEntry zipEntry : listAsList) {
            if (((ZipEntry) linkedHashMap.put(zipEntry.getCanonicalPath(), zipEntry)) == null) {
                while (true) {
                    Path pathParent = zipEntry.getCanonicalPath().parent();
                    if (pathParent == null) {
                        break;
                    }
                    ZipEntry zipEntry2 = (ZipEntry) linkedHashMap.get(pathParent);
                    if (zipEntry2 != null) {
                        zipEntry2.getChildren().add(zipEntry.getCanonicalPath());
                        break;
                    }
                    ZipEntry zipEntry3 = new ZipEntry(pathParent, true, null, 0L, 0L, 0L, 0, null, 0L, 508, null);
                    linkedHashMap.put(pathParent, zipEntry3);
                    zipEntry3.getChildren().add(zipEntry.getCanonicalPath());
                    zipEntry = zipEntry3;
                }
            }
        }
        return linkedHashMap;
    }

    private static final Long dosDateTimeToEpochMillis(int i6, int i10) {
        if (i10 == -1) {
            return null;
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(14, 0);
        gregorianCalendar.set(((i6 >> 9) & 127) + 1980, ((i6 >> 5) & 15) - 1, i6 & 31, (i10 >> 11) & 31, (i10 >> 5) & 63, (i10 & 31) << 1);
        return Long.valueOf(gregorianCalendar.getTime().getTime());
    }

    private static final String getHex(int i6) {
        AbstractC3280d.m6586d(16);
        String string = Integer.toString(i6, 16);
        AbstractC2796i.m5784e(string, "toString(...)");
        return "0x".concat(string);
    }

    public static final ZipFileSystem openZip(Path path, FileSystem fileSystem, InterfaceC2724l interfaceC2724l) throws IOException {
        AbstractC2796i.m5785f(path, "zipPath");
        AbstractC2796i.m5785f(fileSystem, "fileSystem");
        AbstractC2796i.m5785f(interfaceC2724l, "predicate");
        FileHandle fileHandleOpenReadOnly = fileSystem.openReadOnly(path);
        try {
            long size = fileHandleOpenReadOnly.size() - ((long) 22);
            if (size < 0) {
                throw new IOException("not a zip: size=" + fileHandleOpenReadOnly.size());
            }
            long jMax = Math.max(size - PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH, 0L);
            do {
                BufferedSource bufferedSourceBuffer = Okio.buffer(fileHandleOpenReadOnly.source(size));
                try {
                    if (bufferedSourceBuffer.readIntLe() == END_OF_CENTRAL_DIRECTORY_SIGNATURE) {
                        EocdRecord eocdRecord = readEocdRecord(bufferedSourceBuffer);
                        String utf8 = bufferedSourceBuffer.readUtf8(eocdRecord.getCommentByteCount());
                        bufferedSourceBuffer.close();
                        long j10 = size - ((long) 20);
                        if (j10 > 0) {
                            BufferedSource bufferedSourceBuffer2 = Okio.buffer(fileHandleOpenReadOnly.source(j10));
                            try {
                                if (bufferedSourceBuffer2.readIntLe() == ZIP64_LOCATOR_SIGNATURE) {
                                    int intLe = bufferedSourceBuffer2.readIntLe();
                                    long longLe = bufferedSourceBuffer2.readLongLe();
                                    if (bufferedSourceBuffer2.readIntLe() != 1 || intLe != 0) {
                                        throw new IOException("unsupported zip: spanned");
                                    }
                                    BufferedSource bufferedSourceBuffer3 = Okio.buffer(fileHandleOpenReadOnly.source(longLe));
                                    try {
                                        int intLe2 = bufferedSourceBuffer3.readIntLe();
                                        if (intLe2 != ZIP64_EOCD_RECORD_SIGNATURE) {
                                            throw new IOException("bad zip: expected " + getHex(ZIP64_EOCD_RECORD_SIGNATURE) + " but was " + getHex(intLe2));
                                        }
                                        eocdRecord = readZip64EocdRecord(bufferedSourceBuffer3, eocdRecord);
                                        AbstractC0032a.m164r(bufferedSourceBuffer3, null);
                                    } catch (Throwable th) {
                                        try {
                                            throw th;
                                        } catch (Throwable th2) {
                                            AbstractC0032a.m164r(bufferedSourceBuffer3, th);
                                            throw th2;
                                        }
                                    }
                                    try {
                                        throw th;
                                    } catch (Throwable th3) {
                                        AbstractC0032a.m164r(fileHandleOpenReadOnly, th);
                                        throw th3;
                                    }
                                }
                                AbstractC0032a.m164r(bufferedSourceBuffer2, null);
                            } catch (Throwable th4) {
                                try {
                                    throw th4;
                                } catch (Throwable th5) {
                                    AbstractC0032a.m164r(bufferedSourceBuffer2, th4);
                                    throw th5;
                                }
                            }
                        }
                        ArrayList arrayList = new ArrayList();
                        BufferedSource bufferedSourceBuffer4 = Okio.buffer(fileHandleOpenReadOnly.source(eocdRecord.getCentralDirectoryOffset()));
                        try {
                            long entryCount = eocdRecord.getEntryCount();
                            for (long j11 = 0; j11 < entryCount; j11++) {
                                ZipEntry entry = readEntry(bufferedSourceBuffer4);
                                if (entry.getOffset() >= eocdRecord.getCentralDirectoryOffset()) {
                                    throw new IOException("bad zip: local file header offset >= central directory offset");
                                }
                                if (((Boolean) interfaceC2724l.invoke(entry)).booleanValue()) {
                                    arrayList.add(entry);
                                }
                                throw th;
                            }
                            AbstractC0032a.m164r(bufferedSourceBuffer4, null);
                            ZipFileSystem zipFileSystem = new ZipFileSystem(path, fileSystem, buildIndex(arrayList), utf8);
                            AbstractC0032a.m164r(fileHandleOpenReadOnly, null);
                            return zipFileSystem;
                        } catch (Throwable th6) {
                            try {
                                throw th6;
                            } catch (Throwable th7) {
                                AbstractC0032a.m164r(bufferedSourceBuffer4, th6);
                                throw th7;
                            }
                        }
                    }
                    bufferedSourceBuffer.close();
                    size--;
                } catch (Throwable th8) {
                    bufferedSourceBuffer.close();
                    throw th8;
                }
            } while (size >= jMax);
            throw new IOException("not a zip: end of central directory signature not found");
        } catch (Throwable th9) {
            throw th9;
        }
    }

    public static ZipFileSystem openZip$default(Path path, FileSystem fileSystem, InterfaceC2724l interfaceC2724l, int i6, Object obj) throws IOException {
        if ((i6 & 4) != 0) {
            interfaceC2724l = C33161.INSTANCE;
        }
        return openZip(path, fileSystem, interfaceC2724l);
    }

    public static final ZipEntry readEntry(BufferedSource bufferedSource) throws IOException {
        int i6;
        AbstractC2796i.m5785f(bufferedSource, "<this>");
        int intLe = bufferedSource.readIntLe();
        if (intLe != CENTRAL_FILE_HEADER_SIGNATURE) {
            throw new IOException("bad zip: expected " + getHex(CENTRAL_FILE_HEADER_SIGNATURE) + " but was " + getHex(intLe));
        }
        bufferedSource.skip(4L);
        short shortLe = bufferedSource.readShortLe();
        int i10 = shortLe & 65535;
        if ((shortLe & 1) != 0) {
            throw new IOException("unsupported zip: general purpose bit flag=" + getHex(i10));
        }
        int shortLe2 = bufferedSource.readShortLe() & 65535;
        Long lDosDateTimeToEpochMillis = dosDateTimeToEpochMillis(bufferedSource.readShortLe() & 65535, bufferedSource.readShortLe() & 65535);
        long intLe2 = ((long) bufferedSource.readIntLe()) & MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE;
        C2800m c2800m = new C2800m();
        c2800m.f9539a = ((long) bufferedSource.readIntLe()) & MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE;
        C2800m c2800m2 = new C2800m();
        c2800m2.f9539a = ((long) bufferedSource.readIntLe()) & MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE;
        int shortLe3 = bufferedSource.readShortLe() & 65535;
        int shortLe4 = bufferedSource.readShortLe() & 65535;
        int shortLe5 = bufferedSource.readShortLe() & 65535;
        bufferedSource.skip(8L);
        C2800m c2800m3 = new C2800m();
        c2800m3.f9539a = ((long) bufferedSource.readIntLe()) & MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE;
        String utf8 = bufferedSource.readUtf8(shortLe3);
        if (AbstractC3648f.m7375W(utf8, (char) 0)) {
            throw new IOException("bad zip: filename contains 0x00");
        }
        long j10 = c2800m2.f9539a == MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE ? 8 : 0L;
        if (c2800m.f9539a == MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE) {
            i6 = 8;
            j10 += (long) 8;
        } else {
            i6 = 8;
        }
        if (c2800m3.f9539a == MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE) {
            j10 += (long) i6;
        }
        long j11 = j10;
        C2799l c2799l = new C2799l();
        readExtra(bufferedSource, shortLe4, new C33171(c2799l, j11, c2800m2, bufferedSource, c2800m, c2800m3));
        if (j11 <= 0 || c2799l.f9538a) {
            return new ZipEntry(Path.Companion.get$default(Path.Companion, "/", false, 1, (Object) null).resolve(utf8), AbstractC3656n.m7397O(utf8, "/", false), bufferedSource.readUtf8(shortLe5), intLe2, c2800m.f9539a, c2800m2.f9539a, shortLe2, lDosDateTimeToEpochMillis, c2800m3.f9539a);
        }
        throw new IOException("bad zip: zip64 extra required but absent");
    }

    private static final EocdRecord readEocdRecord(BufferedSource bufferedSource) throws IOException {
        int shortLe = bufferedSource.readShortLe() & 65535;
        int shortLe2 = bufferedSource.readShortLe() & 65535;
        long shortLe3 = bufferedSource.readShortLe() & 65535;
        if (shortLe3 != (bufferedSource.readShortLe() & 65535) || shortLe != 0 || shortLe2 != 0) {
            throw new IOException("unsupported zip: spanned");
        }
        bufferedSource.skip(4L);
        return new EocdRecord(shortLe3, MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE & ((long) bufferedSource.readIntLe()), bufferedSource.readShortLe() & 65535);
    }

    private static final void readExtra(BufferedSource bufferedSource, int i6, InterfaceC2728p interfaceC2728p) throws IOException {
        long j10 = i6;
        while (j10 != 0) {
            if (j10 < 4) {
                throw new IOException("bad zip: truncated header in extra field");
            }
            int shortLe = bufferedSource.readShortLe() & 65535;
            long shortLe2 = ((long) bufferedSource.readShortLe()) & WebSocketProtocol.PAYLOAD_SHORT_MAX;
            long j11 = j10 - ((long) 4);
            if (j11 < shortLe2) {
                throw new IOException("bad zip: truncated value in extra field");
            }
            bufferedSource.require(shortLe2);
            long size = bufferedSource.getBuffer().size();
            interfaceC2728p.invoke(Integer.valueOf(shortLe), Long.valueOf(shortLe2));
            long size2 = (bufferedSource.getBuffer().size() + shortLe2) - size;
            if (size2 < 0) {
                throw new IOException(AbstractC0004e.m20n(shortLe, "unsupported zip: too many bytes processed for "));
            }
            if (size2 > 0) {
                bufferedSource.getBuffer().skip(size2);
            }
            j10 = j11 - shortLe2;
        }
    }

    public static final FileMetadata readLocalHeader(BufferedSource bufferedSource, FileMetadata fileMetadata) throws IOException {
        AbstractC2796i.m5785f(bufferedSource, "<this>");
        AbstractC2796i.m5785f(fileMetadata, "basicMetadata");
        FileMetadata orSkipLocalHeader = readOrSkipLocalHeader(bufferedSource, fileMetadata);
        AbstractC2796i.m5782c(orSkipLocalHeader);
        return orSkipLocalHeader;
    }

    private static final FileMetadata readOrSkipLocalHeader(BufferedSource bufferedSource, FileMetadata fileMetadata) throws IOException {
        C2801n c2801n = new C2801n();
        c2801n.f9540a = fileMetadata != null ? fileMetadata.getLastModifiedAtMillis() : null;
        C2801n c2801n2 = new C2801n();
        C2801n c2801n3 = new C2801n();
        int intLe = bufferedSource.readIntLe();
        if (intLe != LOCAL_FILE_HEADER_SIGNATURE) {
            throw new IOException("bad zip: expected " + getHex(LOCAL_FILE_HEADER_SIGNATURE) + " but was " + getHex(intLe));
        }
        bufferedSource.skip(2L);
        short shortLe = bufferedSource.readShortLe();
        int i6 = shortLe & 65535;
        if ((shortLe & 1) != 0) {
            throw new IOException("unsupported zip: general purpose bit flag=" + getHex(i6));
        }
        bufferedSource.skip(18L);
        long shortLe2 = ((long) bufferedSource.readShortLe()) & WebSocketProtocol.PAYLOAD_SHORT_MAX;
        int shortLe3 = bufferedSource.readShortLe() & 65535;
        bufferedSource.skip(shortLe2);
        if (fileMetadata == null) {
            bufferedSource.skip(shortLe3);
            return null;
        }
        readExtra(bufferedSource, shortLe3, new C33181(bufferedSource, c2801n, c2801n2, c2801n3));
        return new FileMetadata(fileMetadata.isRegularFile(), fileMetadata.isDirectory(), null, fileMetadata.getSize(), (Long) c2801n3.f9540a, (Long) c2801n.f9540a, (Long) c2801n2.f9540a, null, 128, null);
    }

    private static final EocdRecord readZip64EocdRecord(BufferedSource bufferedSource, EocdRecord eocdRecord) throws IOException {
        bufferedSource.skip(12L);
        int intLe = bufferedSource.readIntLe();
        int intLe2 = bufferedSource.readIntLe();
        long longLe = bufferedSource.readLongLe();
        if (longLe != bufferedSource.readLongLe() || intLe != 0 || intLe2 != 0) {
            throw new IOException("unsupported zip: spanned");
        }
        bufferedSource.skip(8L);
        return new EocdRecord(longLe, bufferedSource.readLongLe(), eocdRecord.getCommentByteCount());
    }

    public static final void skipLocalHeader(BufferedSource bufferedSource) throws IOException {
        AbstractC2796i.m5785f(bufferedSource, "<this>");
        readOrSkipLocalHeader(bufferedSource, null);
    }
}
