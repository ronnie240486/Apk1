package p093j;

import android.view.ActionMode;
import android.view.SearchEvent;
import android.view.Window;

public abstract class AbstractC2750k {
    public static boolean m5716a(Window.Callback callback, SearchEvent searchEvent) {
        return callback.onSearchRequested(searchEvent);
    }

    public static ActionMode m5717b(Window.Callback callback, ActionMode.Callback callback2, int i6) {
        return callback.onWindowStartingActionMode(callback2, i6);
    }
}
