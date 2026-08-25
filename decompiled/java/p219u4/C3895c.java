package p219u4;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.cast.framework.media.widget.ExpandedControllerActivity;
import p176q4.AbstractC3481g;
import p176q4.InterfaceC3483i;
import p199s4.InterfaceC3707a;

public final class C3895c implements InterfaceC3707a, InterfaceC3483i {

    public final ExpandedControllerActivity f13094a;

    public C3895c(ExpandedControllerActivity expandedControllerActivity) {
        this.f13094a = expandedControllerActivity;
    }

    @Override
    public void mo3717a(AbstractC3481g abstractC3481g, int i6) {
    }

    @Override
    public void mo3718d(AbstractC3481g abstractC3481g, boolean z7) {
    }

    @Override
    public void mo3999f(Bitmap bitmap) {
        if (bitmap != null) {
            ExpandedControllerActivity expandedControllerActivity = this.f13094a;
            TextView textView = expandedControllerActivity.f4929b0;
            if (textView != null) {
                textView.setVisibility(8);
            }
            ImageView imageView = expandedControllerActivity.f4928Z;
            if (imageView != null) {
                imageView.setVisibility(0);
                expandedControllerActivity.f4928Z.setImageBitmap(bitmap);
            }
        }
    }

    @Override
    public void mo3719g(AbstractC3481g abstractC3481g, int i6) {
    }

    @Override
    public void mo3720h(AbstractC3481g abstractC3481g, String str) {
    }

    @Override
    public void mo3721i(AbstractC3481g abstractC3481g, int i6) {
    }

    @Override
    public void mo3722k(AbstractC3481g abstractC3481g, String str) {
    }

    @Override
    public void mo3723l(AbstractC3481g abstractC3481g) {
    }

    @Override
    public void mo3724m(AbstractC3481g abstractC3481g, int i6) {
        this.f13094a.finish();
    }

    @Override
    public void mo3725n(AbstractC3481g abstractC3481g) {
    }
}
