package p001a0;

import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

public final class ViewGroupOnHierarchyChangeListenerC0020c implements ViewGroup.OnHierarchyChangeListener {

    public final CoordinatorLayout f39a;

    public ViewGroupOnHierarchyChangeListenerC0020c(CoordinatorLayout coordinatorLayout) {
        this.f39a = coordinatorLayout;
    }

    @Override
    public final void onChildViewAdded(View view, View view2) {
        ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.f39a.f1438q;
        if (onHierarchyChangeListener != null) {
            onHierarchyChangeListener.onChildViewAdded(view, view2);
        }
    }

    @Override
    public final void onChildViewRemoved(View view, View view2) {
        CoordinatorLayout coordinatorLayout = this.f39a;
        coordinatorLayout.m913u(2);
        ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = coordinatorLayout.f1438q;
        if (onHierarchyChangeListener != null) {
            onHierarchyChangeListener.onChildViewRemoved(view, view2);
        }
    }
}
