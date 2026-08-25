package androidx.core.app;

import android.app.NotificationManager;
import android.content.Context;
import java.util.HashSet;

public final class C0367z0 {

    public static String f1593d;

    public static ServiceConnectionC0365y0 f1596g;

    public final Context f1597a;

    public final NotificationManager f1598b;

    public static final Object f1592c = new Object();

    public static HashSet f1594e = new HashSet();

    public static final Object f1595f = new Object();

    public C0367z0(Context context) {
        this.f1597a = context;
        this.f1598b = (NotificationManager) context.getSystemService("notification");
    }
}
