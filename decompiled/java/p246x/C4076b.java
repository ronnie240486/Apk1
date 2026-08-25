package p246x;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.constraintlayout.utils.widget.ImageFilterView;

public final class C4076b extends ViewOutlineProvider {

    public final int f13742a;

    public final ImageFilterView f13743b;

    public C4076b(ImageFilterView imageFilterView, int i6) {
        this.f13742a = i6;
        this.f13743b = imageFilterView;
    }

    @Override
    public final void getOutline(View view, Outline outline) {
        switch (this.f13742a) {
            case 0:
                ImageFilterView imageFilterView = this.f13743b;
                int width = imageFilterView.getWidth();
                int height = imageFilterView.getHeight();
                outline.setRoundRect(0, 0, width, height, (Math.min(width, height) * imageFilterView.f1264g) / 2.0f);
                break;
            default:
                ImageFilterView imageFilterView2 = this.f13743b;
                outline.setRoundRect(0, 0, imageFilterView2.getWidth(), imageFilterView2.getHeight(), imageFilterView2.f1265h);
                break;
        }
    }
}
