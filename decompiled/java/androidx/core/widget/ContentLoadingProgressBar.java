package androidx.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;

public class ContentLoadingProgressBar extends ProgressBar {

    public static final int f1617c = 0;

    public final RunnableC0371d f1618a;

    public final RunnableC0371d f1619b;

    public ContentLoadingProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        final int i6 = 0;
        this.f1618a = new Runnable(this) {

            public final ContentLoadingProgressBar f1662b;

            {
                this.f1662b = this;
            }

            @Override
            public final void run() {
                ContentLoadingProgressBar contentLoadingProgressBar = this.f1662b;
                switch (i6) {
                    case 0:
                        int i10 = ContentLoadingProgressBar.f1617c;
                        contentLoadingProgressBar.setVisibility(8);
                        break;
                    default:
                        int i11 = ContentLoadingProgressBar.f1617c;
                        contentLoadingProgressBar.getClass();
                        System.currentTimeMillis();
                        contentLoadingProgressBar.setVisibility(0);
                        break;
                }
            }
        };
        final int i10 = 1;
        this.f1619b = new Runnable(this) {

            public final ContentLoadingProgressBar f1662b;

            {
                this.f1662b = this;
            }

            @Override
            public final void run() {
                ContentLoadingProgressBar contentLoadingProgressBar = this.f1662b;
                switch (i10) {
                    case 0:
                        int i11 = ContentLoadingProgressBar.f1617c;
                        contentLoadingProgressBar.setVisibility(8);
                        break;
                    default:
                        int i12 = ContentLoadingProgressBar.f1617c;
                        contentLoadingProgressBar.getClass();
                        System.currentTimeMillis();
                        contentLoadingProgressBar.setVisibility(0);
                        break;
                }
            }
        };
    }

    @Override
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        removeCallbacks(this.f1618a);
        removeCallbacks(this.f1619b);
    }

    @Override
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f1618a);
        removeCallbacks(this.f1619b);
    }
}
