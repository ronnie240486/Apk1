package p037d3;

import android.graphics.ColorSpace;
import android.graphics.ImageDecoder;
import android.os.Build;
import android.util.Log;
import android.util.Size;
import p049e3.C2396n;
import p049e3.C2398p;
import p049e3.C2404v;
import p228v2.C3980g;
import p228v2.C3981h;
import p228v2.EnumC3974a;
import p228v2.EnumC3982i;

public final class C2149b implements ImageDecoder.OnHeaderDecodedListener {

    public final C2404v f7787a = C2404v.m5436a();

    public final int f7788b;

    public final int f7789c;

    public final EnumC3974a f7790d;

    public final C2396n f7791e;

    public final boolean f7792f;

    public final EnumC3982i f7793g;

    public C2149b(int i6, int i10, C3981h c3981h) {
        this.f7788b = i6;
        this.f7789c = i10;
        this.f7790d = (EnumC3974a) c3981h.m7967c(C2398p.f8365f);
        this.f7791e = (C2396n) c3981h.m7967c(C2396n.f8362g);
        C3980g c3980g = C2398p.f8368i;
        this.f7792f = c3981h.m7967c(c3980g) != null && ((Boolean) c3981h.m7967c(c3980g)).booleanValue();
        this.f7793g = (EnumC3982i) c3981h.m7967c(C2398p.f8366g);
    }

    @Override
    public final void onHeaderDecoded(ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
        if (this.f7787a.m5438c(this.f7788b, this.f7789c, this.f7792f, false)) {
            imageDecoder.setAllocator(3);
        } else {
            imageDecoder.setAllocator(1);
        }
        if (this.f7790d == EnumC3974a.f13505b) {
            imageDecoder.setMemorySizePolicy(0);
        }
        imageDecoder.setOnPartialImageListener(new C2148a());
        Size size = imageInfo.getSize();
        int width = this.f7788b;
        if (width == Integer.MIN_VALUE) {
            width = size.getWidth();
        }
        int height = this.f7789c;
        if (height == Integer.MIN_VALUE) {
            height = size.getHeight();
        }
        float fM5427b = this.f7791e.m5427b(size.getWidth(), size.getHeight(), width, height);
        int iRound = Math.round(size.getWidth() * fM5427b);
        int iRound2 = Math.round(size.getHeight() * fM5427b);
        if (Log.isLoggable("ImageDecoder", 2)) {
            Log.v("ImageDecoder", "Resizing from [" + size.getWidth() + "x" + size.getHeight() + "] to [" + iRound + "x" + iRound2 + "] scaleFactor: " + fM5427b);
        }
        imageDecoder.setTargetSize(iRound, iRound2);
        EnumC3982i enumC3982i = this.f7793g;
        if (enumC3982i != null) {
            int i6 = Build.VERSION.SDK_INT;
            if (i6 >= 28) {
                imageDecoder.setTargetColorSpace(ColorSpace.get((enumC3982i == EnumC3982i.f13516a && imageInfo.getColorSpace() != null && imageInfo.getColorSpace().isWideGamut()) ? ColorSpace.Named.DISPLAY_P3 : ColorSpace.Named.SRGB));
            } else if (i6 >= 26) {
                imageDecoder.setTargetColorSpace(ColorSpace.get(ColorSpace.Named.SRGB));
            }
        }
    }
}
