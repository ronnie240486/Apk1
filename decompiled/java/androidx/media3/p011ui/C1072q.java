package androidx.media3.p011ui;

import p020b7.InterfaceC1354n;

public final class C1072q implements InterfaceC1354n {

    public final int f3139a;

    public C1072q(int i6) {
        this.f3139a = i6;
    }

    @Override
    public final boolean apply(Object obj) {
        switch (this.f3139a) {
            case 0:
                return SubtitleViewUtils.lambda$removeAllEmbeddedStyling$0(obj);
            default:
                return SubtitleViewUtils.lambda$removeEmbeddedFontSizes$1(obj);
        }
    }
}
