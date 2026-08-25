package p063fa;

import androidx.recyclerview.widget.AbstractC1158k0;
import androidx.recyclerview.widget.AbstractC1174p1;
import p116ka.C2933n;
import p156o9.AbstractC3280d;

public abstract class AbstractC2531i0 extends AbstractC1158k0 {

    public int f8817a = -1;

    public C2933n f8818b;

    @Override
    public final void onViewAttachedToWindow(AbstractC1174p1 abstractC1174p1) {
        super.onViewAttachedToWindow(abstractC1174p1);
        if (this.f8817a == -1 || abstractC1174p1.getAbsoluteAdapterPosition() != this.f8817a) {
            return;
        }
        AbstractC3280d.m6606y(abstractC1174p1.itemView);
        this.f8817a = -1;
    }
}
