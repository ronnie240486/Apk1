package p148o0;

import android.R;
import android.os.Build;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.media3.common.C0565C;
import androidx.media3.exoplayer.source.ProgressiveMediaSource;

public final class C3228c {

    public static final C3228c f10841e = new C3228c(1);

    public static final C3228c f10842f = new C3228c(2);

    public static final C3228c f10843g;

    public static final C3228c f10844h;

    public static final C3228c f10845i;

    public static final C3228c f10846j;

    public static final C3228c f10847k;

    public static final C3228c f10848l;

    public static final C3228c f10849m;

    public static final C3228c f10850n;

    public static final C3228c f10851o;

    public static final C3228c f10852p;

    public static final C3228c f10853q;

    public static final C3228c f10854r;

    public static final C3228c f10855s;

    public final Object f10856a;

    public final int f10857b;

    public final Class f10858c;

    public final InterfaceC3244s f10859d;

    static {
        new C3228c(4);
        new C3228c(8);
        f10843g = new C3228c(16);
        new C3228c(32);
        new C3228c(64);
        new C3228c(128);
        new C3228c(256, AbstractC3237l.class);
        new C3228c(512, AbstractC3237l.class);
        new C3228c(1024, AbstractC3238m.class);
        new C3228c(2048, AbstractC3238m.class);
        f10844h = new C3228c(4096);
        f10845i = new C3228c(8192);
        new C3228c(16384);
        new C3228c(32768);
        new C3228c(C0565C.DEFAULT_BUFFER_SEGMENT_SIZE);
        new C3228c(131072, AbstractC3242q.class);
        f10846j = new C3228c(262144);
        f10847k = new C3228c(524288);
        f10848l = new C3228c(ProgressiveMediaSource.DEFAULT_LOADING_CHECK_INTERVAL_BYTES);
        new C3228c(2097152, AbstractC3243r.class);
        int i6 = Build.VERSION.SDK_INT;
        new C3228c(i6 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN : null, R.id.accessibilityActionShowOnScreen, null, null, null);
        f10849m = new C3228c(i6 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION : null, R.id.accessibilityActionScrollToPosition, null, null, AbstractC3240o.class);
        f10850n = new C3228c(i6 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP : null, R.id.accessibilityActionScrollUp, null, null, null);
        f10851o = new C3228c(i6 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT : null, R.id.accessibilityActionScrollLeft, null, null, null);
        f10852p = new C3228c(i6 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN : null, R.id.accessibilityActionScrollDown, null, null, null);
        f10853q = new C3228c(i6 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT : null, R.id.accessibilityActionScrollRight, null, null, null);
        new C3228c(i6 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP : null, R.id.accessibilityActionPageUp, null, null, null);
        new C3228c(i6 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN : null, R.id.accessibilityActionPageDown, null, null, null);
        new C3228c(i6 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT : null, R.id.accessibilityActionPageLeft, null, null, null);
        new C3228c(i6 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT : null, R.id.accessibilityActionPageRight, null, null, null);
        new C3228c(i6 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK : null, R.id.accessibilityActionContextClick, null, null, null);
        f10854r = new C3228c(i6 >= 24 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS : null, R.id.accessibilityActionSetProgress, null, null, AbstractC3241p.class);
        new C3228c(i6 >= 26 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW : null, R.id.accessibilityActionMoveWindow, null, null, AbstractC3239n.class);
        new C3228c(i6 >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP : null, R.id.accessibilityActionShowTooltip, null, null, null);
        new C3228c(i6 >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP : null, R.id.accessibilityActionHideTooltip, null, null, null);
        new C3228c(i6 >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PRESS_AND_HOLD : null, R.id.accessibilityActionPressAndHold, null, null, null);
        new C3228c(i6 >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_IME_ENTER : null, R.id.accessibilityActionImeEnter, null, null, null);
        new C3228c(i6 >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_START : null, R.id.accessibilityActionDragStart, null, null, null);
        new C3228c(i6 >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_DROP : null, R.id.accessibilityActionDragDrop, null, null, null);
        new C3228c(i6 >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_CANCEL : null, R.id.accessibilityActionDragCancel, null, null, null);
        new C3228c(i6 >= 33 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TEXT_SUGGESTIONS : null, R.id.accessibilityActionShowTextSuggestions, null, null, null);
        f10855s = new C3228c(i6 >= 34 ? AbstractC3231f.m6526a() : null, R.id.accessibilityActionScrollInDirection, null, null, null);
    }

    public C3228c(int i6) {
        this(null, i6, null, null, null);
    }

    public final int m6512a() {
        return ((AccessibilityNodeInfo.AccessibilityAction) this.f10856a).getId();
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof C3228c)) {
            return false;
        }
        Object obj2 = ((C3228c) obj).f10856a;
        Object obj3 = this.f10856a;
        if (obj3 == null) {
            return obj2 == null;
        }
        return obj3.equals(obj2);
    }

    public final int hashCode() {
        Object obj = this.f10856a;
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("AccessibilityActionCompat: ");
        String strM6539d = C3233h.m6539d(this.f10857b);
        if (strM6539d.equals("ACTION_UNKNOWN")) {
            Object obj = this.f10856a;
            if (((AccessibilityNodeInfo.AccessibilityAction) obj).getLabel() != null) {
                strM6539d = ((AccessibilityNodeInfo.AccessibilityAction) obj).getLabel().toString();
            }
        }
        sb.append(strM6539d);
        return sb.toString();
    }

    public C3228c(int i6, Class cls) {
        this(null, i6, null, null, cls);
    }

    public C3228c(Object obj, int i6, String str, InterfaceC3244s interfaceC3244s, Class cls) {
        this.f10857b = i6;
        this.f10859d = interfaceC3244s;
        if (obj == null) {
            this.f10856a = new AccessibilityNodeInfo.AccessibilityAction(i6, str);
        } else {
            this.f10856a = obj;
        }
        this.f10858c = cls;
    }
}
