package androidx.transition;

import android.content.Context;
import android.util.AttributeSet;
import java.util.ArrayList;

public class AutoTransition extends TransitionSet {
    public AutoTransition(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m3028J();
    }

    public final void m3028J() {
        m3074I(1);
        m3071F(new Fade(2));
        ChangeBounds changeBounds = new ChangeBounds();
        changeBounds.f3761x = false;
        m3071F(changeBounds);
        m3071F(new Fade(1));
    }

    public AutoTransition() {
        this.f3813x = new ArrayList();
        this.f3814y = true;
        this.f3811A = false;
        this.f3812B = 0;
        m3028J();
    }
}
