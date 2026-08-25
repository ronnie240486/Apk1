package p154o7;

import androidx.media3.extractor.p010ts.TsExtractor;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
import p000a.AbstractC0004e;
import p124l6.C2982h;
import p125l7.C2994a;
import p125l7.EnumC3000g;
import p125l7.InterfaceC3012s;
import p144n7.C3208f;
import p179q7.AbstractC3524b;

public final class C3270k implements InterfaceC3012s {

    public final C2982h f10923a;

    public final EnumC3000g f10924b;

    public final C3208f f10925c;

    public final C3262c f10926d;

    public final AbstractC3524b f10927e;

    public C3270k(C2982h c2982h, C3208f c3208f, C3262c c3262c) {
        C2994a c2994a = EnumC3000g.f10289a;
        this.f10927e = AbstractC3524b.f11883a;
        this.f10923a = c2982h;
        this.f10924b = c2994a;
        this.f10925c = c3208f;
        this.f10926d = c3262c;
    }

    /*  JADX ERROR: NullPointerException in pass: ConstructorVisitor
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.RegisterArg.sameRegAndSVar(jadx.core.dex.instructions.args.InsnArg)" because "resultArg" is null
        	at jadx.core.dex.visitors.MoveInlineVisitor.processMove(MoveInlineVisitor.java:52)
        	at jadx.core.dex.visitors.MoveInlineVisitor.moveInline(MoveInlineVisitor.java:41)
        	at jadx.core.dex.visitors.ConstructorVisitor.visit(ConstructorVisitor.java:43)
        */
    @Override
    public final p125l7.AbstractC3011r mo6089a(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r34v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
        	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:215)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:150)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:415)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:299)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
        */
    /*  JADX ERROR: NullPointerException in pass: ConstructorVisitor
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.RegisterArg.sameRegAndSVar(jadx.core.dex.instructions.args.InsnArg)" because "resultArg" is null
        	at jadx.core.dex.visitors.MoveInlineVisitor.processMove(MoveInlineVisitor.java:52)
        	at jadx.core.dex.visitors.MoveInlineVisitor.moveInline(MoveInlineVisitor.java:41)
        */

    public final boolean m6562b(Field field, boolean z7) {
        Class<?> type = field.getType();
        C3208f c3208f = this.f10925c;
        c3208f.getClass();
        if (!C3208f.m6497c(type)) {
            c3208f.m6498b(z7);
            if ((field.getModifiers() & TsExtractor.TS_STREAM_TYPE_DTS_HD) == 0 && !field.isSynthetic() && !C3208f.m6497c(field.getType())) {
                List list = z7 ? c3208f.f10788a : c3208f.f10789b;
                if (!list.isEmpty()) {
                    Iterator it = list.iterator();
                    if (it.hasNext()) {
                        throw AbstractC0004e.m18l(it);
                    }
                }
                return true;
            }
        }
        return false;
    }
}
