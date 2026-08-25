package p230v4;

import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.common.api.Status;
import p261y4.InterfaceC4264l;

public final class C4006t implements InterfaceC4264l {

    public final Status f13566a;

    public final ApplicationMetadata f13567b;

    public final String f13568c;

    public final String f13569d;

    public final boolean f13570e;

    public C4006t(Status status, ApplicationMetadata applicationMetadata, String str, String str2, boolean z7) {
        this.f13566a = status;
        this.f13567b = applicationMetadata;
        this.f13568c = str;
        this.f13569d = str2;
        this.f13570e = z7;
    }

    @Override
    public final Status mo3637h() {
        return this.f13566a;
    }
}
