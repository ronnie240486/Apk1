package p246x;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.constraintlayout.utils.widget.ImageFilterButton;
import com.google.android.material.chip.Chip;
import p051e6.C2419d;

public final class C4075a extends ViewOutlineProvider {

    public final int f13740a;

    public final View f13741b;

    public C4075a(View view, int i6) {
        this.f13740a = i6;
        this.f13741b = view;
    }

    @Override
    public final void getOutline(View view, Outline outline) {
        switch (this.f13740a) {
            case 0:
                ImageFilterButton imageFilterButton = (ImageFilterButton) this.f13741b;
                int width = imageFilterButton.getWidth();
                int height = imageFilterButton.getHeight();
                outline.setRoundRect(0, 0, width, height, (Math.min(width, height) * imageFilterButton.f1253f) / 2.0f);
                break;
            case 1:
                ImageFilterButton imageFilterButton2 = (ImageFilterButton) this.f13741b;
                outline.setRoundRect(0, 0, imageFilterButton2.getWidth(), imageFilterButton2.getHeight(), imageFilterButton2.f1254g);
                break;
            default:
                C2419d c2419d = ((Chip) this.f13741b).f6084e;
                if (c2419d == null) {
                    outline.setAlpha(0.0f);
                } else {
                    c2419d.getOutline(outline);
                }
                break;
        }
    }
}
