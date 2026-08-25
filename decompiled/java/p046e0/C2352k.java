package p046e0;

import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;

public final class C2352k {

    public final ColorStateList f8204a;

    public final Configuration f8205b;

    public final int f8206c;

    public C2352k(ColorStateList colorStateList, Configuration configuration, Resources.Theme theme) {
        this.f8204a = colorStateList;
        this.f8205b = configuration;
        this.f8206c = theme == null ? 0 : theme.hashCode();
    }
}
