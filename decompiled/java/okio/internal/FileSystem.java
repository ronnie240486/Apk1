package okio.internal;

import androidx.media3.extractor.metadata.dvbsi.AppInfoTableDecoder;
import androidx.media3.extractor.p010ts.TsExtractor;
import com.alibaba.fastjson.asm.Opcodes;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import okio.BufferedSink;
import okio.FileMetadata;
import okio.Okio;
import okio.Path;
import okio.Source;
import p008a9.InterfaceC0074d;
import p021b9.EnumC1367a;
import p030c9.AbstractC1433c;
import p030c9.AbstractC1438h;
import p030c9.InterfaceC1435e;
import p055ea.AbstractC2460q;
import p091i9.InterfaceC2728p;
import p103j9.AbstractC2796i;
import p123l5.AbstractC2973a;
import p156o9.AbstractC3280d;
import p181q9.AbstractC3547e;
import p181q9.C3546d;
import p181q9.C3549g;
import p181q9.InterfaceC3545c;
import p243w8.C4070l;
import p253x8.C4145h;
import p253x8.C4155r;

public final class FileSystem {

    @InterfaceC1435e(m3333c = "okio.internal.-FileSystem", m3334f = "FileSystem.kt", m3335l = {AppInfoTableDecoder.APPLICATION_INFORMATION_TABLE_ID, TsExtractor.TS_STREAM_TYPE_E_AC3, 145}, m3336m = "collectRecursively")
    public static final class C33141 extends AbstractC1433c {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        boolean Z$0;
        boolean Z$1;
        int label;
        Object result;

        public C33141(InterfaceC0074d<? super C33141> interfaceC0074d) {
            super(interfaceC0074d);
        }

        @Override
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FileSystem.collectRecursively(null, null, null, null, false, false, this);
        }
    }

    @InterfaceC1435e(m3333c = "okio.internal.-FileSystem$commonListRecursively$1", m3334f = "FileSystem.kt", m3335l = {Opcodes.IADD}, m3336m = "invokeSuspend")
    public static final class C33151 extends AbstractC1438h implements InterfaceC2728p {
        final Path $dir;
        final boolean $followSymlinks;
        final okio.FileSystem $this_commonListRecursively;
        private Object L$0;
        Object L$1;
        Object L$2;
        int label;

        public C33151(Path path, okio.FileSystem fileSystem, boolean z7, InterfaceC0074d<? super C33151> interfaceC0074d) {
            super(interfaceC0074d);
            this.$dir = path;
            this.$this_commonListRecursively = fileSystem;
            this.$followSymlinks = z7;
        }

        @Override
        public final InterfaceC0074d<C4070l> create(Object obj, InterfaceC0074d<?> interfaceC0074d) {
            C33151 c33151 = new C33151(this.$dir, this.$this_commonListRecursively, this.$followSymlinks, interfaceC0074d);
            c33151.L$0 = obj;
            return c33151;
        }

        @Override
        public final Object invokeSuspend(Object obj) {
            AbstractC3547e abstractC3547e;
            C4145h c4145h;
            Iterator<Path> it;
            EnumC1367a enumC1367a = EnumC1367a.f4179a;
            int i6 = this.label;
            if (i6 == 0) {
                AbstractC3280d.m6570I(obj);
                AbstractC3547e abstractC3547e2 = (AbstractC3547e) this.L$0;
                C4145h c4145h2 = new C4145h();
                c4145h2.addLast(this.$dir);
                abstractC3547e = abstractC3547e2;
                c4145h = c4145h2;
                it = this.$this_commonListRecursively.list(this.$dir).iterator();
            } else {
                if (i6 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                it = (Iterator) this.L$2;
                C4145h c4145h3 = (C4145h) this.L$1;
                AbstractC3547e abstractC3547e3 = (AbstractC3547e) this.L$0;
                AbstractC3280d.m6570I(obj);
                c4145h = c4145h3;
                abstractC3547e = abstractC3547e3;
            }
            while (it.hasNext()) {
                Path next = it.next();
                okio.FileSystem fileSystem = this.$this_commonListRecursively;
                boolean z7 = this.$followSymlinks;
                this.L$0 = abstractC3547e;
                this.L$1 = c4145h;
                this.L$2 = it;
                this.label = 1;
                if (FileSystem.collectRecursively(abstractC3547e, fileSystem, c4145h, next, z7, false, this) == enumC1367a) {
                    return enumC1367a;
                }
            }
            return C4070l.f13734a;
        }

        @Override
        public final Object invoke(AbstractC3547e abstractC3547e, InterfaceC0074d<? super C4070l> interfaceC0074d) {
            return ((C33151) create(abstractC3547e, interfaceC0074d)).invokeSuspend(C4070l.f13734a);
        }
    }

    public static final Object collectRecursively(AbstractC3547e abstractC3547e, okio.FileSystem fileSystem, C4145h c4145h, Path path, boolean z7, boolean z10, InterfaceC0074d<? super C4070l> interfaceC0074d) throws Throwable {
        C33141 c33141;
        okio.FileSystem fileSystem2;
        C4145h c4145h2;
        AbstractC3547e abstractC3547e2;
        boolean z11;
        C4145h c4145h3;
        AbstractC3547e abstractC3547e3;
        okio.FileSystem fileSystem3;
        boolean z12;
        boolean z13;
        Iterator<Path> it;
        Path path2;
        Path next;
        Path path3 = path;
        boolean z14 = z10;
        if (interfaceC0074d instanceof C33141) {
            c33141 = (C33141) interfaceC0074d;
            int i6 = c33141.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                c33141.label = i6 - Integer.MIN_VALUE;
            } else {
                c33141 = new C33141(interfaceC0074d);
            }
        } else {
            c33141 = new C33141(interfaceC0074d);
        }
        Object obj = c33141.result;
        EnumC1367a enumC1367a = EnumC1367a.f4179a;
        int i10 = c33141.label;
        C4070l c4070l = C4070l.f13734a;
        if (i10 == 0) {
            AbstractC3280d.m6570I(obj);
            if (!z14) {
                c33141.L$0 = abstractC3547e;
                c33141.L$1 = fileSystem;
                c33141.L$2 = c4145h;
                c33141.L$3 = path3;
                c33141.Z$0 = z7;
                c33141.Z$1 = z14;
                c33141.label = 1;
                C3546d c3546d = (C3546d) abstractC3547e;
                c3546d.f11948b = path3;
                c3546d.f11947a = 3;
                c3546d.f11950d = c33141;
                return enumC1367a;
            }
            fileSystem2 = fileSystem;
            c4145h2 = c4145h;
            abstractC3547e2 = abstractC3547e;
            z11 = z7;
        } else {
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC3280d.m6570I(obj);
                    return c4070l;
                }
                z13 = c33141.Z$1;
                z12 = c33141.Z$0;
                it = (Iterator) c33141.L$4;
                path2 = (Path) c33141.L$3;
                c4145h3 = (C4145h) c33141.L$2;
                fileSystem3 = (okio.FileSystem) c33141.L$1;
                abstractC3547e3 = (AbstractC3547e) c33141.L$0;
                try {
                    AbstractC3280d.m6570I(obj);
                    while (it.hasNext()) {
                        next = it.next();
                        c33141.L$0 = abstractC3547e3;
                        c33141.L$1 = fileSystem3;
                        c33141.L$2 = c4145h3;
                        c33141.L$3 = path2;
                        c33141.L$4 = it;
                        c33141.Z$0 = z12;
                        c33141.Z$1 = z13;
                        c33141.label = 2;
                        if (collectRecursively(abstractC3547e3, fileSystem3, c4145h3, next, z12, z13, c33141) == enumC1367a) {
                            return enumC1367a;
                        }
                    }
                    c4145h3.removeLast();
                    z14 = z13;
                    path3 = path2;
                    abstractC3547e2 = abstractC3547e3;
                    if (z14) {
                        return c4070l;
                    }
                    c33141.L$0 = null;
                    c33141.L$1 = null;
                    c33141.L$2 = null;
                    c33141.L$3 = null;
                    c33141.L$4 = null;
                    c33141.label = 3;
                    C3546d c3546d2 = (C3546d) abstractC3547e2;
                    c3546d2.f11948b = path3;
                    c3546d2.f11947a = 3;
                    c3546d2.f11950d = c33141;
                    return enumC1367a;
                } catch (Throwable th) {
                    th = th;
                    c4145h3.removeLast();
                    throw th;
                }
            }
            boolean z15 = c33141.Z$1;
            boolean z16 = c33141.Z$0;
            Path path4 = (Path) c33141.L$3;
            c4145h2 = (C4145h) c33141.L$2;
            okio.FileSystem fileSystem4 = (okio.FileSystem) c33141.L$1;
            abstractC3547e2 = (AbstractC3547e) c33141.L$0;
            AbstractC3280d.m6570I(obj);
            fileSystem2 = fileSystem4;
            z14 = z15;
            z11 = z16;
            path3 = path4;
        }
        List<Path> listListOrNull = fileSystem2.listOrNull(path3);
        if (listListOrNull == null) {
            listListOrNull = C4155r.f14074a;
        }
        if (!listListOrNull.isEmpty()) {
            int i11 = 0;
            Path path5 = path3;
            while (true) {
                if (z11 && c4145h2.contains(path5)) {
                    throw new IOException(AbstractC2460q.m5497k(path3, "symlink cycle at "));
                }
                Path pathSymlinkTarget = symlinkTarget(fileSystem2, path5);
                if (pathSymlinkTarget != null) {
                    i11++;
                    path5 = pathSymlinkTarget;
                } else if (z11 || i11 == 0) {
                    c4145h2.addLast(path5);
                    try {
                        abstractC3547e3 = abstractC3547e2;
                        fileSystem3 = fileSystem2;
                        Path path6 = path3;
                        z12 = z11;
                        z13 = z14;
                        it = listListOrNull.iterator();
                        c4145h3 = c4145h2;
                        path2 = path6;
                        while (it.hasNext()) {
                            next = it.next();
                            c33141.L$0 = abstractC3547e3;
                            c33141.L$1 = fileSystem3;
                            c33141.L$2 = c4145h3;
                            c33141.L$3 = path2;
                            c33141.L$4 = it;
                            c33141.Z$0 = z12;
                            c33141.Z$1 = z13;
                            c33141.label = 2;
                            if (collectRecursively(abstractC3547e3, fileSystem3, c4145h3, next, z12, z13, c33141) == enumC1367a) {
                                return enumC1367a;
                            }
                        }
                        c4145h3.removeLast();
                        z14 = z13;
                        path3 = path2;
                        abstractC3547e2 = abstractC3547e3;
                    } catch (Throwable th2) {
                        th = th2;
                        c4145h3 = c4145h2;
                        c4145h3.removeLast();
                        throw th;
                    }
                }
            }
        }
        if (z14) {
            return c4070l;
        }
        c33141.L$0 = null;
        c33141.L$1 = null;
        c33141.L$2 = null;
        c33141.L$3 = null;
        c33141.L$4 = null;
        c33141.label = 3;
        C3546d c3546d3 = (C3546d) abstractC3547e2;
        c3546d3.f11948b = path3;
        c3546d3.f11947a = 3;
        c3546d3.f11950d = c33141;
        return enumC1367a;
    }

    public static final void commonCopy(okio.FileSystem fileSystem, Path path, Path path2) throws IOException {
        Long lValueOf;
        Throwable th;
        Long lValueOf2;
        AbstractC2796i.m5785f(fileSystem, "<this>");
        AbstractC2796i.m5785f(path, "source");
        AbstractC2796i.m5785f(path2, "target");
        Source source = fileSystem.source(path);
        Throwable th2 = null;
        try {
            BufferedSink bufferedSinkBuffer = Okio.buffer(fileSystem.sink(path2));
            try {
                lValueOf2 = Long.valueOf(bufferedSinkBuffer.writeAll(source));
                if (bufferedSinkBuffer != null) {
                    try {
                        bufferedSinkBuffer.close();
                    } catch (Throwable th3) {
                        th = th3;
                    }
                }
                th = null;
            } catch (Throwable th4) {
                if (bufferedSinkBuffer != null) {
                    try {
                        bufferedSinkBuffer.close();
                    } catch (Throwable th5) {
                        AbstractC2973a.m6013a(th4, th5);
                    }
                }
                th = th4;
                lValueOf2 = null;
            }
            if (th != null) {
                throw th;
            }
            AbstractC2796i.m5782c(lValueOf2);
            lValueOf = Long.valueOf(lValueOf2.longValue());
            if (source != null) {
                try {
                    source.close();
                } catch (Throwable th6) {
                    th2 = th6;
                }
            }
            if (th2 != null) {
                throw th2;
            }
            AbstractC2796i.m5782c(lValueOf);
        } catch (Throwable th7) {
            if (source != null) {
                try {
                    source.close();
                } catch (Throwable th8) {
                    AbstractC2973a.m6013a(th7, th8);
                }
            }
            th2 = th7;
            lValueOf = null;
        }
    }

    public static final void commonCreateDirectories(okio.FileSystem fileSystem, Path path, boolean z7) throws IOException {
        AbstractC2796i.m5785f(fileSystem, "<this>");
        AbstractC2796i.m5785f(path, "dir");
        C4145h c4145h = new C4145h();
        for (Path pathParent = path; pathParent != null && !fileSystem.exists(pathParent); pathParent = pathParent.parent()) {
            c4145h.addFirst(pathParent);
        }
        if (z7 && c4145h.isEmpty()) {
            throw new IOException(path + " already exists.");
        }
        Iterator<E> it = c4145h.iterator();
        while (it.hasNext()) {
            fileSystem.createDirectory((Path) it.next());
        }
    }

    public static final void commonDeleteRecursively(okio.FileSystem fileSystem, Path path, boolean z7) throws IOException {
        AbstractC2796i.m5785f(fileSystem, "<this>");
        AbstractC2796i.m5785f(path, "fileOrDirectory");
        FileSystem$commonDeleteRecursively$sequence$1 fileSystem$commonDeleteRecursively$sequence$1 = new FileSystem$commonDeleteRecursively$sequence$1(fileSystem, path, null);
        C3546d c3546d = new C3546d();
        c3546d.f11950d = fileSystem$commonDeleteRecursively$sequence$1.create(c3546d, c3546d);
        while (c3546d.hasNext()) {
            fileSystem.delete((Path) c3546d.next(), z7 && !c3546d.hasNext());
        }
    }

    public static final boolean commonExists(okio.FileSystem fileSystem, Path path) throws IOException {
        AbstractC2796i.m5785f(fileSystem, "<this>");
        AbstractC2796i.m5785f(path, "path");
        return fileSystem.metadataOrNull(path) != null;
    }

    public static final InterfaceC3545c commonListRecursively(okio.FileSystem fileSystem, Path path, boolean z7) throws IOException {
        AbstractC2796i.m5785f(fileSystem, "<this>");
        AbstractC2796i.m5785f(path, "dir");
        return new C3549g(new C33151(path, fileSystem, z7, null));
    }

    public static final FileMetadata commonMetadata(okio.FileSystem fileSystem, Path path) throws IOException {
        AbstractC2796i.m5785f(fileSystem, "<this>");
        AbstractC2796i.m5785f(path, "path");
        FileMetadata fileMetadataMetadataOrNull = fileSystem.metadataOrNull(path);
        if (fileMetadataMetadataOrNull != null) {
            return fileMetadataMetadataOrNull;
        }
        throw new FileNotFoundException(AbstractC2460q.m5497k(path, "no such file: "));
    }

    public static final Path symlinkTarget(okio.FileSystem fileSystem, Path path) throws IOException {
        AbstractC2796i.m5785f(fileSystem, "<this>");
        AbstractC2796i.m5785f(path, "path");
        Path symlinkTarget = fileSystem.metadata(path).getSymlinkTarget();
        if (symlinkTarget == null) {
            return null;
        }
        Path pathParent = path.parent();
        AbstractC2796i.m5782c(pathParent);
        return pathParent.resolve(symlinkTarget);
    }
}
