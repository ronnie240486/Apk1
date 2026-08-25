package p148o0;

import android.view.accessibility.AccessibilityManager;
import android.widget.AutoCompleteTextView;
import com.google.android.material.textfield.C1875m;
import com.google.android.material.textfield.TextInputLayout;
import java.util.WeakHashMap;
import p001a0.C0019b;
import p138n0.AbstractC3155s0;

public final class AccessibilityManagerTouchExplorationStateChangeListenerC3227b implements AccessibilityManager.TouchExplorationStateChangeListener {

    public final C0019b f10840a;

    public AccessibilityManagerTouchExplorationStateChangeListenerC3227b(C0019b c0019b) {
        this.f10840a = c0019b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AccessibilityManagerTouchExplorationStateChangeListenerC3227b) {
            return this.f10840a.equals(((AccessibilityManagerTouchExplorationStateChangeListenerC3227b) obj).f10840a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f10840a.hashCode();
    }

    @Override
    public final void onTouchExplorationStateChanged(boolean z7) {
        AutoCompleteTextView autoCompleteTextView;
        C1875m c1875m = (C1875m) this.f10840a.f38b;
        TextInputLayout textInputLayout = c1875m.f6867a;
        if (textInputLayout == null || (autoCompleteTextView = (AutoCompleteTextView) textInputLayout.getEditText()) == null || autoCompleteTextView.getKeyListener() != null) {
            return;
        }
        int i6 = z7 ? 2 : 1;
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        c1875m.f6869c.setImportantForAccessibility(i6);
    }
}
