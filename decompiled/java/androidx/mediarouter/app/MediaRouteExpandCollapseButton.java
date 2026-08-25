package androidx.mediarouter.app;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageButton;
import com.p2serv.android.p032ds.R;
import p034d0.AbstractC2115a;
import p156o9.AbstractC3280d;

class MediaRouteExpandCollapseButton extends AppCompatImageButton {

    public final AnimationDrawable f3163d;

    public final AnimationDrawable f3164e;

    public final String f3165f;

    public final String f3166g;

    public boolean f3167h;

    public View.OnClickListener f3168i;

    public MediaRouteExpandCollapseButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override
    public final void setOnClickListener(View.OnClickListener onClickListener) {
        this.f3168i = onClickListener;
    }

    public MediaRouteExpandCollapseButton(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        AnimationDrawable animationDrawable = (AnimationDrawable) AbstractC2115a.m5069b(context, R.drawable.mr_group_expand);
        this.f3163d = animationDrawable;
        AnimationDrawable animationDrawable2 = (AnimationDrawable) AbstractC2115a.m5069b(context, R.drawable.mr_group_collapse);
        this.f3164e = animationDrawable2;
        PorterDuffColorFilter porterDuffColorFilter = new PorterDuffColorFilter(AbstractC3280d.m6594l(context, i6), PorterDuff.Mode.SRC_IN);
        animationDrawable.setColorFilter(porterDuffColorFilter);
        animationDrawable2.setColorFilter(porterDuffColorFilter);
        String string = context.getString(R.string.mr_controller_expand_group);
        this.f3165f = string;
        this.f3166g = context.getString(R.string.mr_controller_collapse_group);
        setImageDrawable(animationDrawable.getFrame(0));
        setContentDescription(string);
        super.setOnClickListener(new ViewOnClickListenerC1089g0(1, this));
    }
}
