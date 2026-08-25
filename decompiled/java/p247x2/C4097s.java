package p247x2;

import java.io.IOException;

public final class C4097s implements Appendable {

    public final Appendable f13886a;

    public boolean f13887b = true;

    public C4097s(Appendable appendable) {
        this.f13886a = appendable;
    }

    @Override
    public final Appendable append(char c5) throws IOException {
        boolean z7 = this.f13887b;
        Appendable appendable = this.f13886a;
        if (z7) {
            this.f13887b = false;
            appendable.append("  ");
        }
        this.f13887b = c5 == '\n';
        appendable.append(c5);
        return this;
    }

    @Override
    public final Appendable append(CharSequence charSequence) throws IOException {
        if (charSequence == null) {
            charSequence = "";
        }
        append(charSequence, 0, charSequence.length());
        return this;
    }

    @Override
    public final Appendable append(CharSequence charSequence, int i6, int i10) throws IOException {
        if (charSequence == null) {
            charSequence = "";
        }
        boolean z7 = this.f13887b;
        Appendable appendable = this.f13886a;
        boolean z10 = false;
        if (z7) {
            this.f13887b = false;
            appendable.append("  ");
        }
        if (charSequence.length() > 0 && charSequence.charAt(i10 - 1) == '\n') {
            z10 = true;
        }
        this.f13887b = z10;
        appendable.append(charSequence, i6, i10);
        return this;
    }
}
