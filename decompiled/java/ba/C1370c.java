package ba;

import android.content.Context;
import android.content.ContextWrapper;

public final class C1370c extends ContextWrapper {

    public static final int f4184a = 0;

    @Override
    public final Context getApplicationContext() {
        return new C1368a(this, getBaseContext().getApplicationContext());
    }
}
