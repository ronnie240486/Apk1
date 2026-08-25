package ba;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.WindowManager;

public final class C1368a extends ContextWrapper {

    public final C1370c f4181a;

    public C1368a(C1370c c1370c, Context context) {
        super(context);
        this.f4181a = c1370c;
    }

    @Override
    public final Object getSystemService(String str) {
        if (!"window".equals(str)) {
            return super.getSystemService(str);
        }
        return new WindowManagerC1369b(this.f4181a, (WindowManager) getBaseContext().getSystemService(str));
    }
}
