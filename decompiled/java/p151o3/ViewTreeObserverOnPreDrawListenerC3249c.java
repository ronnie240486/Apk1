package p151o3;

import android.util.Log;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import p141n3.C3192f;

public final class ViewTreeObserverOnPreDrawListenerC3249c implements ViewTreeObserver.OnPreDrawListener {

    public final int f10878a = 0;

    public final WeakReference f10879b;

    public ViewTreeObserverOnPreDrawListenerC3249c(C3250d c3250d) {
        this.f10879b = new WeakReference(c3250d);
    }

    @Override
    public final boolean onPreDraw() {
        switch (this.f10878a) {
            case 0:
                if (Log.isLoggable("CustomViewTarget", 2)) {
                    Log.v("CustomViewTarget", "OnGlobalLayoutListener called attachStateListener=" + this);
                }
                C3250d c3250d = (C3250d) this.f10879b.get();
                if (c3250d != null) {
                    ArrayList arrayList = c3250d.f10882b;
                    if (!arrayList.isEmpty()) {
                        ImageView imageView = c3250d.f10881a;
                        int paddingRight = imageView.getPaddingRight() + imageView.getPaddingLeft();
                        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
                        int iM6557a = c3250d.m6557a(imageView.getWidth(), layoutParams != null ? layoutParams.width : 0, paddingRight);
                        int paddingBottom = imageView.getPaddingBottom() + imageView.getPaddingTop();
                        ViewGroup.LayoutParams layoutParams2 = imageView.getLayoutParams();
                        int iM6557a2 = c3250d.m6557a(imageView.getHeight(), layoutParams2 != null ? layoutParams2.height : 0, paddingBottom);
                        if (iM6557a > 0 || iM6557a == Integer.MIN_VALUE) {
                            if (iM6557a2 > 0 || iM6557a2 == Integer.MIN_VALUE) {
                                Iterator it = new ArrayList(arrayList).iterator();
                                while (it.hasNext()) {
                                    ((C3192f) ((InterfaceC3253g) it.next())).m6418m(iM6557a, iM6557a2);
                                }
                                ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
                                if (viewTreeObserver.isAlive()) {
                                    viewTreeObserver.removeOnPreDrawListener(c3250d.f10883c);
                                }
                                c3250d.f10883c = null;
                                arrayList.clear();
                            }
                        }
                        break;
                    }
                }
                break;
            default:
                if (Log.isLoggable("ViewTarget", 2)) {
                    Log.v("ViewTarget", "OnGlobalLayoutListener called attachStateListener=" + this);
                }
                C3255i c3255i = (C3255i) this.f10879b.get();
                if (c3255i != null) {
                    ArrayList arrayList2 = c3255i.f10889b;
                    if (!arrayList2.isEmpty()) {
                        ImageView imageView2 = c3255i.f10888a;
                        int paddingRight2 = imageView2.getPaddingRight() + imageView2.getPaddingLeft();
                        ViewGroup.LayoutParams layoutParams3 = imageView2.getLayoutParams();
                        int iM6558a = c3255i.m6558a(imageView2.getWidth(), layoutParams3 != null ? layoutParams3.width : 0, paddingRight2);
                        int paddingBottom2 = imageView2.getPaddingBottom() + imageView2.getPaddingTop();
                        ViewGroup.LayoutParams layoutParams4 = imageView2.getLayoutParams();
                        int iM6558a2 = c3255i.m6558a(imageView2.getHeight(), layoutParams4 != null ? layoutParams4.height : 0, paddingBottom2);
                        if (iM6558a > 0 || iM6558a == Integer.MIN_VALUE) {
                            if (iM6558a2 > 0 || iM6558a2 == Integer.MIN_VALUE) {
                                Iterator it2 = new ArrayList(arrayList2).iterator();
                                while (it2.hasNext()) {
                                    ((C3192f) ((InterfaceC3253g) it2.next())).m6418m(iM6558a, iM6558a2);
                                }
                                ViewTreeObserver viewTreeObserver2 = imageView2.getViewTreeObserver();
                                if (viewTreeObserver2.isAlive()) {
                                    viewTreeObserver2.removeOnPreDrawListener(c3255i.f10890c);
                                }
                                c3255i.f10890c = null;
                                arrayList2.clear();
                            }
                        }
                        break;
                    }
                }
                break;
        }
        return true;
    }

    public ViewTreeObserverOnPreDrawListenerC3249c(C3255i c3255i) {
        this.f10879b = new WeakReference(c3255i);
    }
}
