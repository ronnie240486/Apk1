package p015b2;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.datepicker.C1801r;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.NavigationMenuItemView;
import com.p2serv.android.p032ds.R;
import p138n0.C3103b;
import p148o0.C3232g;
import p148o0.C3233h;

public final class C1256h extends C3103b {

    public final int f3983d;

    public final Object f3984e;

    public C1256h(int i6, Object obj) {
        this.f3983d = i6;
        this.f3984e = obj;
    }

    @Override
    public void mo1135c(View view, AccessibilityEvent accessibilityEvent) {
        boolean z7;
        AbstractC1249a abstractC1249a;
        switch (this.f3983d) {
            case 0:
                super.mo1135c(view, accessibilityEvent);
                accessibilityEvent.setClassName(ViewPager.class.getName());
                ViewPager viewPager = (ViewPager) this.f3984e;
                AbstractC1249a abstractC1249a2 = viewPager.f3880e;
                if (abstractC1249a2 != null) {
                    z7 = abstractC1249a2.mo3131c() > 1;
                }
                accessibilityEvent.setScrollable(z7);
                if (accessibilityEvent.getEventType() == 4096 && (abstractC1249a = viewPager.f3880e) != null) {
                    accessibilityEvent.setItemCount(abstractC1249a.mo3131c());
                    accessibilityEvent.setFromIndex(viewPager.f3881f);
                    accessibilityEvent.setToIndex(viewPager.f3881f);
                    break;
                }
                break;
            case 3:
                super.mo1135c(view, accessibilityEvent);
                accessibilityEvent.setChecked(((CheckableImageButton) this.f3984e).f6319d);
                break;
            default:
                super.mo1135c(view, accessibilityEvent);
                break;
        }
    }

    @Override
    public final void mo1136d(View view, C3233h c3233h) {
        int i6 = -1;
        boolean z7 = false;
        Object obj = this.f3984e;
        View.AccessibilityDelegate accessibilityDelegate = this.f10576a;
        switch (this.f3983d) {
            case 0:
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, c3233h.f10862a);
                c3233h.m6547i(ViewPager.class.getName());
                ViewPager viewPager = (ViewPager) obj;
                AbstractC1249a abstractC1249a = viewPager.f3880e;
                if (abstractC1249a != null && abstractC1249a.mo3131c() > 1) {
                    z7 = true;
                }
                c3233h.m6552n(z7);
                if (viewPager.canScrollHorizontally(1)) {
                    c3233h.m6540a(4096);
                }
                if (viewPager.canScrollHorizontally(-1)) {
                    c3233h.m6540a(8192);
                }
                break;
            case 1:
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, c3233h.f10862a);
                int i10 = MaterialButtonToggleGroup.f6032k;
                MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) obj;
                materialButtonToggleGroup.getClass();
                if (view instanceof MaterialButton) {
                    int i11 = 0;
                    for (int i12 = 0; i12 < materialButtonToggleGroup.getChildCount(); i12++) {
                        if (materialButtonToggleGroup.getChildAt(i12) == view) {
                            i6 = i11;
                        } else {
                            if ((materialButtonToggleGroup.getChildAt(i12) instanceof MaterialButton) && materialButtonToggleGroup.m4145c(i12)) {
                                i11++;
                            }
                        }
                    }
                }
                c3233h.m6549k(C3232g.m6538a(0, 1, i6, 1, ((MaterialButton) view).f6028n));
                break;
            case 2:
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, c3233h.f10862a);
                C1801r c1801r = (C1801r) obj;
                c3233h.m6551m(c1801r.f6208e0.getVisibility() == 0 ? c1801r.m1325n(R.string.mtrl_picker_toggle_to_year_selection) : c1801r.m1325n(R.string.mtrl_picker_toggle_to_day_selection));
                break;
            case 3:
                AccessibilityNodeInfo accessibilityNodeInfo = c3233h.f10862a;
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                CheckableImageButton checkableImageButton = (CheckableImageButton) obj;
                accessibilityNodeInfo.setCheckable(checkableImageButton.f6320e);
                accessibilityNodeInfo.setChecked(checkableImageButton.f6319d);
                break;
            default:
                AccessibilityNodeInfo accessibilityNodeInfo2 = c3233h.f10862a;
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo2);
                accessibilityNodeInfo2.setCheckable(((NavigationMenuItemView) obj).f6341x);
                break;
        }
    }

    @Override
    public boolean mo1137g(View view, int i6, Bundle bundle) {
        switch (this.f3983d) {
            case 0:
                if (super.mo1137g(view, i6, bundle)) {
                    return true;
                }
                ViewPager viewPager = (ViewPager) this.f3984e;
                if (i6 != 4096) {
                    if (i6 == 8192 && viewPager.canScrollHorizontally(-1)) {
                        viewPager.setCurrentItem(viewPager.f3881f - 1);
                        return true;
                    }
                } else if (viewPager.canScrollHorizontally(1)) {
                    viewPager.setCurrentItem(viewPager.f3881f + 1);
                    return true;
                }
                return false;
            default:
                return super.mo1137g(view, i6, bundle);
        }
    }
}
