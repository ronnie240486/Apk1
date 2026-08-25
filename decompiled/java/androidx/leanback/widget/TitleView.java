package androidx.leanback.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.p2serv.android.p032ds.R;

public class TitleView extends FrameLayout {

    public final ImageView f2301a;

    public final TextView f2302b;

    public final SearchOrbView f2303c;

    public final int f2304d;

    public boolean f2305e;

    public final C0470h1 f2306f;

    public TitleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.browseTitleViewStyle);
    }

    public Drawable getBadgeDrawable() {
        return this.f2301a.getDrawable();
    }

    public C0507y0 getSearchAffordanceColors() {
        return this.f2303c.getOrbColors();
    }

    public View getSearchAffordanceView() {
        return this.f2303c;
    }

    public CharSequence getTitle() {
        return this.f2302b.getText();
    }

    public AbstractC0473i1 getTitleViewAdapter() {
        return this.f2306f;
    }

    public void setBadgeDrawable(Drawable drawable) {
        this.f2301a.setImageDrawable(drawable);
        ImageView imageView = this.f2301a;
        Drawable drawable2 = imageView.getDrawable();
        TextView textView = this.f2302b;
        if (drawable2 != null) {
            imageView.setVisibility(0);
            textView.setVisibility(8);
        } else {
            imageView.setVisibility(8);
            textView.setVisibility(0);
        }
    }

    public void setOnSearchClickedListener(View.OnClickListener onClickListener) {
        this.f2305e = onClickListener != null;
        SearchOrbView searchOrbView = this.f2303c;
        searchOrbView.setOnOrbClickedListener(onClickListener);
        searchOrbView.setVisibility((this.f2305e && (this.f2304d & 4) == 4) ? 0 : 4);
    }

    public void setSearchAffordanceColors(C0507y0 c0507y0) {
        this.f2303c.setOrbColors(c0507y0);
    }

    public void setTitle(CharSequence charSequence) {
        this.f2302b.setText(charSequence);
        ImageView imageView = this.f2301a;
        Drawable drawable = imageView.getDrawable();
        TextView textView = this.f2302b;
        if (drawable != null) {
            imageView.setVisibility(0);
            textView.setVisibility(8);
        } else {
            imageView.setVisibility(8);
            textView.setVisibility(0);
        }
    }

    public TitleView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f2304d = 6;
        this.f2305e = false;
        this.f2306f = new C0470h1();
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.lb_title_view, this);
        this.f2301a = (ImageView) viewInflate.findViewById(R.id.title_badge);
        this.f2302b = (TextView) viewInflate.findViewById(R.id.title_text);
        this.f2303c = (SearchOrbView) viewInflate.findViewById(R.id.title_orb);
        setClipToPadding(false);
        setClipChildren(false);
    }
}
