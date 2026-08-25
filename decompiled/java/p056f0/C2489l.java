package p056f0;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.graphics.fonts.FontStyle;
import android.os.ParcelFileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import p046e0.C2347f;
import p046e0.C2348g;
import p106k0.C2859g;
import p123l5.AbstractC2973a;

public final class C2489l extends AbstractC2973a {
    public static Font m5538V(FontFamily fontFamily, int i6) {
        FontStyle fontStyle = new FontStyle((i6 & 1) != 0 ? 700 : 400, (i6 & 2) != 0 ? 1 : 0);
        Font font = fontFamily.getFont(0);
        int iM5539W = m5539W(fontStyle, font.getStyle());
        for (int i10 = 1; i10 < fontFamily.getSize(); i10++) {
            Font font2 = fontFamily.getFont(i10);
            int iM5539W2 = m5539W(fontStyle, font2.getStyle());
            if (iM5539W2 < iM5539W) {
                font = font2;
                iM5539W = iM5539W2;
            }
        }
        return font;
    }

    public static int m5539W(FontStyle fontStyle, FontStyle fontStyle2) {
        return (Math.abs(fontStyle.getWeight() - fontStyle2.getWeight()) / 100) + (fontStyle.getSlant() == fontStyle2.getSlant() ? 0 : 2);
    }

    @Override
    public final Typeface mo5525l(Context context, C2347f c2347f, Resources resources, int i6) {
        try {
            FontFamily.Builder builder = null;
            for (C2348g c2348g : c2347f.f8193a) {
                try {
                    Font fontBuild = new Font.Builder(resources, c2348g.f8199f).setWeight(c2348g.f8195b).setSlant(c2348g.f8196c ? 1 : 0).setTtcIndex(c2348g.f8198e).setFontVariationSettings(c2348g.f8197d).build();
                    if (builder == null) {
                        builder = new FontFamily.Builder(fontBuild);
                    } else {
                        builder.addFont(fontBuild);
                    }
                } catch (IOException unused) {
                }
            }
            if (builder == null) {
                return null;
            }
            FontFamily fontFamilyBuild = builder.build();
            return new Typeface.CustomFallbackBuilder(fontFamilyBuild).setStyle(m5538V(fontFamilyBuild, i6).getStyle()).build();
        } catch (Exception unused2) {
            return null;
        }
    }

    @Override
    public final Typeface mo5526m(Context context, C2859g[] c2859gArr, int i6) {
        ContentResolver contentResolver = context.getContentResolver();
        try {
            FontFamily.Builder builder = null;
            for (C2859g c2859g : c2859gArr) {
                try {
                    ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = contentResolver.openFileDescriptor(c2859g.f9782a, "r", null);
                    if (parcelFileDescriptorOpenFileDescriptor == null) {
                        if (parcelFileDescriptorOpenFileDescriptor != null) {
                        }
                    } else {
                        try {
                            Font fontBuild = new Font.Builder(parcelFileDescriptorOpenFileDescriptor).setWeight(c2859g.f9784c).setSlant(c2859g.f9785d ? 1 : 0).setTtcIndex(c2859g.f9783b).build();
                            if (builder == null) {
                                builder = new FontFamily.Builder(fontBuild);
                            } else {
                                builder.addFont(fontBuild);
                            }
                        } catch (Throwable th) {
                            try {
                                parcelFileDescriptorOpenFileDescriptor.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                            throw th;
                        }
                    }
                    parcelFileDescriptorOpenFileDescriptor.close();
                } catch (IOException unused) {
                }
            }
            if (builder == null) {
                return null;
            }
            FontFamily fontFamilyBuild = builder.build();
            return new Typeface.CustomFallbackBuilder(fontFamilyBuild).setStyle(m5538V(fontFamilyBuild, i6).getStyle()).build();
        } catch (Exception unused2) {
            return null;
        }
    }

    @Override
    public final Typeface mo5540n(Context context, InputStream inputStream) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }

    @Override
    public final Typeface mo5537o(Context context, Resources resources, int i6, String str, int i10) {
        try {
            Font fontBuild = new Font.Builder(resources, i6).build();
            return new Typeface.CustomFallbackBuilder(new FontFamily.Builder(fontBuild).build()).setStyle(fontBuild.getStyle()).build();
        } catch (Exception unused) {
            return null;
        }
    }

    @Override
    public final C2859g mo5541s(int i6, C2859g[] c2859gArr) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }
}
