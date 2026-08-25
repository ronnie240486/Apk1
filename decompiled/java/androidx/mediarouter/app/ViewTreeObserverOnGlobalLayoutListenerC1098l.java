package androidx.mediarouter.app;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import p173q1.C3445s0;

public final class ViewTreeObserverOnGlobalLayoutListenerC1098l implements ViewTreeObserver.OnGlobalLayoutListener {

    public final boolean f3266a;

    public final DialogC1116u f3267b;

    public ViewTreeObserverOnGlobalLayoutListenerC1098l(DialogC1116u dialogC1116u, boolean z7) {
        this.f3267b = dialogC1116u;
        this.f3266a = z7;
    }

    @Override
    public final void onGlobalLayout() {
        int iM2795n;
        HashMap map;
        HashMap map2;
        Bitmap bitmap;
        DialogC1116u dialogC1116u = this.f3267b;
        dialogC1116u.f3419s.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        if (dialogC1116u.f3397f0) {
            dialogC1116u.f3399g0 = true;
            return;
        }
        int i6 = dialogC1116u.f3426z.getLayoutParams().height;
        DialogC1116u.m2790q(-1, dialogC1116u.f3426z);
        dialogC1116u.m2803w(dialogC1116u.m2792k());
        View decorView = dialogC1116u.getWindow().getDecorView();
        decorView.measure(View.MeasureSpec.makeMeasureSpec(dialogC1116u.getWindow().getAttributes().width, 1073741824), 0);
        DialogC1116u.m2790q(i6, dialogC1116u.f3426z);
        if (!(dialogC1116u.f3420t.getDrawable() instanceof BitmapDrawable) || (bitmap = ((BitmapDrawable) dialogC1116u.f3420t.getDrawable()).getBitmap()) == null) {
            iM2795n = 0;
        } else {
            iM2795n = dialogC1116u.m2795n(bitmap.getWidth(), bitmap.getHeight());
            dialogC1116u.f3420t.setScaleType(bitmap.getWidth() >= bitmap.getHeight() ? ImageView.ScaleType.FIT_XY : ImageView.ScaleType.FIT_CENTER);
        }
        int iM2796o = dialogC1116u.m2796o(dialogC1116u.m2792k());
        int size = dialogC1116u.f3371F.size();
        boolean zM2797p = dialogC1116u.m2797p();
        C3445s0 c3445s0 = dialogC1116u.f3400h;
        int size2 = zM2797p ? Collections.unmodifiableList(c3445s0.f11673v).size() * dialogC1116u.f3379N : 0;
        if (size > 0) {
            size2 += dialogC1116u.f3381P;
        }
        int iMin = Math.min(size2, dialogC1116u.f3380O);
        if (!dialogC1116u.f3395e0) {
            iMin = 0;
        }
        int iMax = Math.max(iM2795n, iMin) + iM2796o;
        Rect rect = new Rect();
        decorView.getWindowVisibleDisplayFrame(rect);
        int iHeight = rect.height() - (dialogC1116u.f3418r.getMeasuredHeight() - dialogC1116u.f3419s.getMeasuredHeight());
        if (iM2795n <= 0 || iMax > iHeight) {
            if (dialogC1116u.f3426z.getMeasuredHeight() + dialogC1116u.f3369D.getLayoutParams().height >= dialogC1116u.f3419s.getMeasuredHeight()) {
                dialogC1116u.f3420t.setVisibility(8);
            }
            iMax = iMin + iM2796o;
            iM2795n = 0;
        } else {
            dialogC1116u.f3420t.setVisibility(0);
            DialogC1116u.m2790q(iM2795n, dialogC1116u.f3420t);
        }
        if (!dialogC1116u.m2792k() || iMax > iHeight) {
            dialogC1116u.f3366A.setVisibility(8);
        } else {
            dialogC1116u.f3366A.setVisibility(0);
        }
        dialogC1116u.m2803w(dialogC1116u.f3366A.getVisibility() == 0);
        int iM2796o2 = dialogC1116u.m2796o(dialogC1116u.f3366A.getVisibility() == 0);
        int iMax2 = Math.max(iM2795n, iMin) + iM2796o2;
        if (iMax2 > iHeight) {
            iMin -= iMax2 - iHeight;
        } else {
            iHeight = iMax2;
        }
        dialogC1116u.f3426z.clearAnimation();
        dialogC1116u.f3369D.clearAnimation();
        dialogC1116u.f3419s.clearAnimation();
        boolean z7 = this.f3266a;
        if (z7) {
            dialogC1116u.m2791j(iM2796o2, dialogC1116u.f3426z);
            dialogC1116u.m2791j(iMin, dialogC1116u.f3369D);
            dialogC1116u.m2791j(iHeight, dialogC1116u.f3419s);
        } else {
            DialogC1116u.m2790q(iM2796o2, dialogC1116u.f3426z);
            DialogC1116u.m2790q(iMin, dialogC1116u.f3369D);
            DialogC1116u.m2790q(iHeight, dialogC1116u.f3419s);
        }
        DialogC1116u.m2790q(rect.height(), dialogC1116u.f3417q);
        List listUnmodifiableList = Collections.unmodifiableList(c3445s0.f11673v);
        if (listUnmodifiableList.isEmpty()) {
            dialogC1116u.f3371F.clear();
            dialogC1116u.f3370E.notifyDataSetChanged();
            return;
        }
        if (new HashSet(dialogC1116u.f3371F).equals(new HashSet(listUnmodifiableList))) {
            dialogC1116u.f3370E.notifyDataSetChanged();
            return;
        }
        if (z7) {
            OverlayListView overlayListView = dialogC1116u.f3369D;
            C1114t c1114t = dialogC1116u.f3370E;
            map = new HashMap();
            int firstVisiblePosition = overlayListView.getFirstVisiblePosition();
            for (int i10 = 0; i10 < overlayListView.getChildCount(); i10++) {
                Object item = c1114t.getItem(firstVisiblePosition + i10);
                View childAt = overlayListView.getChildAt(i10);
                map.put(item, new Rect(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom()));
            }
        } else {
            map = null;
        }
        if (z7) {
            OverlayListView overlayListView2 = dialogC1116u.f3369D;
            C1114t c1114t2 = dialogC1116u.f3370E;
            map2 = new HashMap();
            int firstVisiblePosition2 = overlayListView2.getFirstVisiblePosition();
            for (int i11 = 0; i11 < overlayListView2.getChildCount(); i11++) {
                Object item2 = c1114t2.getItem(firstVisiblePosition2 + i11);
                View childAt2 = overlayListView2.getChildAt(i11);
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(childAt2.getWidth(), childAt2.getHeight(), Bitmap.Config.ARGB_8888);
                childAt2.draw(new Canvas(bitmapCreateBitmap));
                map2.put(item2, new BitmapDrawable(dialogC1116u.f3402i.getResources(), bitmapCreateBitmap));
            }
        } else {
            map2 = null;
        }
        ArrayList arrayList = dialogC1116u.f3371F;
        HashSet hashSet = new HashSet(listUnmodifiableList);
        hashSet.removeAll(arrayList);
        dialogC1116u.f3372G = hashSet;
        HashSet hashSet2 = new HashSet(dialogC1116u.f3371F);
        hashSet2.removeAll(listUnmodifiableList);
        dialogC1116u.f3373H = hashSet2;
        dialogC1116u.f3371F.addAll(0, dialogC1116u.f3372G);
        dialogC1116u.f3371F.removeAll(dialogC1116u.f3373H);
        dialogC1116u.f3370E.notifyDataSetChanged();
        if (z7 && dialogC1116u.f3395e0) {
            if (dialogC1116u.f3373H.size() + dialogC1116u.f3372G.size() > 0) {
                dialogC1116u.f3369D.setEnabled(false);
                dialogC1116u.f3369D.requestLayout();
                dialogC1116u.f3397f0 = true;
                dialogC1116u.f3369D.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserverOnGlobalLayoutListenerC1102n(dialogC1116u, map, map2));
                return;
            }
        }
        dialogC1116u.f3372G = null;
        dialogC1116u.f3373H = null;
    }
}
