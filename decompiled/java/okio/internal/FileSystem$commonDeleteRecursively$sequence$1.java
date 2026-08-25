package okio.internal;

import androidx.media3.container.MdtaMetadataEntry;
import okio.FileSystem;
import okio.Path;
import p008a9.InterfaceC0074d;
import p021b9.EnumC1367a;
import p030c9.AbstractC1438h;
import p030c9.InterfaceC1435e;
import p091i9.InterfaceC2728p;
import p156o9.AbstractC3280d;
import p181q9.AbstractC3547e;
import p243w8.C4070l;
import p253x8.C4145h;

@InterfaceC1435e(m3333c = "okio.internal.-FileSystem$commonDeleteRecursively$sequence$1", m3334f = "FileSystem.kt", m3335l = {MdtaMetadataEntry.TYPE_INDICATOR_8_BIT_UNSIGNED_INT}, m3336m = "invokeSuspend")
public final class FileSystem$commonDeleteRecursively$sequence$1 extends AbstractC1438h implements InterfaceC2728p {
    final Path $fileOrDirectory;
    final FileSystem $this_commonDeleteRecursively;
    private Object L$0;
    int label;

    public FileSystem$commonDeleteRecursively$sequence$1(FileSystem fileSystem, Path path, InterfaceC0074d<? super FileSystem$commonDeleteRecursively$sequence$1> interfaceC0074d) {
        super(interfaceC0074d);
        this.$this_commonDeleteRecursively = fileSystem;
        this.$fileOrDirectory = path;
    }

    @Override
    public final InterfaceC0074d<C4070l> create(Object obj, InterfaceC0074d<?> interfaceC0074d) {
        FileSystem$commonDeleteRecursively$sequence$1 fileSystem$commonDeleteRecursively$sequence$1 = new FileSystem$commonDeleteRecursively$sequence$1(this.$this_commonDeleteRecursively, this.$fileOrDirectory, interfaceC0074d);
        fileSystem$commonDeleteRecursively$sequence$1.L$0 = obj;
        return fileSystem$commonDeleteRecursively$sequence$1;
    }

    @Override
    public final Object invokeSuspend(Object obj) {
        EnumC1367a enumC1367a = EnumC1367a.f4179a;
        int i6 = this.label;
        if (i6 == 0) {
            AbstractC3280d.m6570I(obj);
            AbstractC3547e abstractC3547e = (AbstractC3547e) this.L$0;
            FileSystem fileSystem = this.$this_commonDeleteRecursively;
            C4145h c4145h = new C4145h();
            Path path = this.$fileOrDirectory;
            this.label = 1;
            if (FileSystem.collectRecursively(abstractC3547e, fileSystem, c4145h, path, false, true, this) == enumC1367a) {
                return enumC1367a;
            }
        } else {
            if (i6 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC3280d.m6570I(obj);
        }
        return C4070l.f13734a;
    }

    @Override
    public final Object invoke(AbstractC3547e abstractC3547e, InterfaceC0074d<? super C4070l> interfaceC0074d) {
        return ((FileSystem$commonDeleteRecursively$sequence$1) create(abstractC3547e, interfaceC0074d)).invokeSuspend(C4070l.f13734a);
    }
}
