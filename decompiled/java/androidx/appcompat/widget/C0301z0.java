package androidx.appcompat.widget;

import p001a0.C0019b;

public final class C0301z0 extends C0019b {

    public final AppCompatTextView f1152c;

    public C0301z0(AppCompatTextView appCompatTextView) {
        super(6, appCompatTextView);
        this.f1152c = appCompatTextView;
    }

    @Override
    public final void mo85a(int i6) {
        super/*android.widget.TextView*/.setLastBaselineToBottomHeight(i6);
    }

    @Override
    public final void mo95k(int i6) {
        super/*android.widget.TextView*/.setFirstBaselineToTopHeight(i6);
    }
}
