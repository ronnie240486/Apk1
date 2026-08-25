package p261y4;

import com.google.android.gms.common.api.Status;

public class C4257e extends Exception {

    public final Status f14453a;

    public C4257e(Status status) {
        int i6 = status.f4994a;
        String str = status.f4995b;
        super(i6 + ": " + (str == null ? "" : str));
        this.f14453a = status;
    }
}
