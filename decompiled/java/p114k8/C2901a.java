package p114k8;

import com.bumptech.glide.AbstractC1465c;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Serializable;

public final class C2901a extends AbstractC1465c {

    public final int f9854c;

    public final Object f9855d;

    public C2901a(int i6, Object obj) {
        this.f9854c = i6;
        this.f9855d = obj;
    }

    @Override
    public final AbstractC1465c mo3481a(Serializable serializable) {
        switch (this.f9854c) {
            case 0:
                ((PrintStream) this.f9855d).print(serializable);
                break;
            default:
                ((PrintWriter) this.f9855d).print(serializable);
                break;
        }
        return this;
    }
}
