package p261y4;

import com.google.android.gms.common.Feature;

public final class C4265m extends UnsupportedOperationException {

    public final Feature f14466a;

    public C4265m(Feature feature) {
        this.f14466a = feature;
    }

    @Override
    public final String getMessage() {
        return "Missing ".concat(String.valueOf(this.f14466a));
    }
}
