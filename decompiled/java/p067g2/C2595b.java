package p067g2;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import android.webkit.MimeTypeMap;
import com.bumptech.glide.AbstractC1465c;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import okio.Okio;
import org.xmlpull.v1.XmlPullParserException;
import p000a.AbstractC0004e;
import p003a2.AbstractC0032a;
import p008a9.InterfaceC0074d;
import p036d2.C2132a;
import p036d2.C2146o;
import p036d2.C2147p;
import p036d2.EnumC2137f;
import p046e0.AbstractC2350i;
import p046e0.AbstractC2355n;
import p103j9.AbstractC2796i;
import p130m2.C3065m;
import p140n2.C3176a;
import p140n2.C3183h;
import p185r2.AbstractC3587f;
import p187r4.AbstractC3612b;
import p192r9.AbstractC3648f;
import p192r9.AbstractC3655m;
import p222u7.AbstractC3928d;
import p253x8.AbstractC4147j;
import p253x8.C4155r;
import p268z1.C4288c;
import p268z1.C4299n;

public final class C2595b implements InterfaceC2600g {

    public final int f9046a;

    public final Uri f9047b;

    public final C3065m f9048c;

    public C2595b(Uri uri, C3065m c3065m, int i6) {
        this.f9046a = i6;
        this.f9047b = uri;
        this.f9048c = c3065m;
    }

    @Override
    public final Object mo5615a(InterfaceC0074d interfaceC0074d) throws XmlPullParserException, IOException {
        Collection collection;
        Collection collectionM154F;
        InputStream inputStreamOpenInputStream;
        List<String> pathSegments;
        int size;
        Bundle bundle;
        Integer numM7394L;
        Drawable drawableM5332a;
        Drawable c4288c;
        EnumC2137f enumC2137f = EnumC2137f.f7762c;
        C3065m c3065m = this.f9048c;
        Uri uri = this.f9047b;
        boolean z7 = true;
        switch (this.f9046a) {
            case 0:
                List<String> pathSegments2 = uri.getPathSegments();
                AbstractC2796i.m5785f(pathSegments2, "<this>");
                int size2 = pathSegments2.size() - 1;
                if (size2 > 0) {
                    if (size2 == 1) {
                        collectionM154F = AbstractC0032a.m154F(AbstractC4147j.m8185Y(pathSegments2));
                    } else {
                        ArrayList arrayList = new ArrayList(size2);
                        if (pathSegments2 instanceof RandomAccess) {
                            int size3 = pathSegments2.size();
                            for (int i6 = 1; i6 < size3; i6++) {
                                arrayList.add(pathSegments2.get(i6));
                            }
                        } else {
                            ListIterator<String> listIterator = pathSegments2.listIterator(1);
                            while (listIterator.hasNext()) {
                                arrayList.add(listIterator.next());
                            }
                        }
                        collection = arrayList;
                    }
                    String strM8184X = AbstractC4147j.m8184X(collection, "/", null, null, null, 62);
                    return new C2606m(new C2147p(Okio.buffer(Okio.source(c3065m.f10496a.getAssets().open(strM8184X))), new C2132a()), AbstractC3587f.m7209b(MimeTypeMap.getSingleton(), strM8184X), enumC2137f);
                }
                collectionM154F = C4155r.f14074a;
                collection = collectionM154F;
                String strM8184X2 = AbstractC4147j.m8184X(collection, "/", null, null, null, 62);
                return new C2606m(new C2147p(Okio.buffer(Okio.source(c3065m.f10496a.getAssets().open(strM8184X2))), new C2132a()), AbstractC3587f.m7209b(MimeTypeMap.getSingleton(), strM8184X2), enumC2137f);
            case 1:
                ContentResolver contentResolver = c3065m.f10496a.getContentResolver();
                if (AbstractC2796i.m5780a(uri.getAuthority(), "com.android.contacts") && AbstractC2796i.m5780a(uri.getLastPathSegment(), "display_photo")) {
                    AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor = contentResolver.openAssetFileDescriptor(uri, "r");
                    inputStreamOpenInputStream = assetFileDescriptorOpenAssetFileDescriptor != null ? assetFileDescriptorOpenAssetFileDescriptor.createInputStream() : null;
                    if (inputStreamOpenInputStream == null) {
                        throw new IllegalStateException(("Unable to find a contact photo associated with '" + uri + "'.").toString());
                    }
                } else if (Build.VERSION.SDK_INT >= 29 && AbstractC2796i.m5780a(uri.getAuthority(), "media") && (size = (pathSegments = uri.getPathSegments()).size()) >= 3 && AbstractC2796i.m5780a(pathSegments.get(size - 3), "audio") && AbstractC2796i.m5780a(pathSegments.get(size - 2), "albums")) {
                    C3183h c3183h = c3065m.f10499d;
                    AbstractC3612b abstractC3612b = c3183h.f10678a;
                    C3176a c3176a = abstractC3612b instanceof C3176a ? (C3176a) abstractC3612b : null;
                    if (c3176a != null) {
                        AbstractC3612b abstractC3612b2 = c3183h.f10679b;
                        C3176a c3176a2 = abstractC3612b2 instanceof C3176a ? (C3176a) abstractC3612b2 : null;
                        if (c3176a2 != null) {
                            bundle = new Bundle(1);
                            bundle.putParcelable("android.content.extra.SIZE", new Point(c3176a.f10667c, c3176a2.f10667c));
                        } else {
                            bundle = null;
                        }
                    } else {
                        bundle = null;
                    }
                    AssetFileDescriptor assetFileDescriptorOpenTypedAssetFile = contentResolver.openTypedAssetFile(uri, "image/*", bundle, null);
                    inputStreamOpenInputStream = assetFileDescriptorOpenTypedAssetFile != null ? assetFileDescriptorOpenTypedAssetFile.createInputStream() : null;
                    if (inputStreamOpenInputStream == null) {
                        throw new IllegalStateException(("Unable to find a music thumbnail associated with '" + uri + "'.").toString());
                    }
                } else {
                    inputStreamOpenInputStream = contentResolver.openInputStream(uri);
                    if (inputStreamOpenInputStream == null) {
                        throw new IllegalStateException(("Unable to open '" + uri + "'.").toString());
                    }
                }
                return new C2606m(new C2147p(Okio.buffer(Okio.source(inputStreamOpenInputStream)), new C2132a()), contentResolver.getType(uri), enumC2137f);
            default:
                String authority = uri.getAuthority();
                if (authority != null) {
                    if (AbstractC3648f.m7383e0(authority)) {
                        authority = null;
                    }
                    if (authority != null) {
                        List<String> pathSegments3 = uri.getPathSegments();
                        AbstractC2796i.m5785f(pathSegments3, "<this>");
                        String str = pathSegments3.isEmpty() ? null : pathSegments3.get(pathSegments3.size() - 1);
                        if (str == null || (numM7394L = AbstractC3655m.m7394L(str)) == null) {
                            throw new IllegalStateException("Invalid android.resource URI: " + uri);
                        }
                        int iIntValue = numM7394L.intValue();
                        Context context = c3065m.f10496a;
                        Resources resources = authority.equals(context.getPackageName()) ? context.getResources() : context.getPackageManager().getResourcesForApplication(authority);
                        TypedValue typedValue = new TypedValue();
                        resources.getValue(iIntValue, typedValue, true);
                        CharSequence charSequence = typedValue.string;
                        String strM7209b = AbstractC3587f.m7209b(MimeTypeMap.getSingleton(), charSequence.subSequence(AbstractC3648f.m7384f0(charSequence, '/', 0, 6), charSequence.length()).toString());
                        if (!AbstractC2796i.m5780a(strM7209b, "text/xml")) {
                            TypedValue typedValue2 = new TypedValue();
                            return new C2606m(new C2147p(Okio.buffer(Okio.source(resources.openRawResource(iIntValue, typedValue2))), new C2146o(typedValue2.density)), strM7209b, enumC2137f);
                        }
                        if (authority.equals(context.getPackageName())) {
                            drawableM5332a = AbstractC1465c.m3473h(context, iIntValue);
                            if (drawableM5332a == null) {
                                throw new IllegalStateException(AbstractC0004e.m20n(iIntValue, "Invalid resource ID: ").toString());
                            }
                        } else {
                            XmlResourceParser xml = resources.getXml(iIntValue);
                            int next = xml.next();
                            while (next != 2 && next != 1) {
                                next = xml.next();
                            }
                            if (next != 2) {
                                throw new XmlPullParserException("No start tag found.");
                            }
                            if (Build.VERSION.SDK_INT < 24) {
                                String name = xml.getName();
                                if (AbstractC2796i.m5780a(name, "vector")) {
                                    AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
                                    Resources.Theme theme = context.getTheme();
                                    c4288c = new C4299n();
                                    c4288c.inflate(resources, xml, attributeSetAsAttributeSet, theme);
                                } else if (AbstractC2796i.m5780a(name, "animated-vector")) {
                                    AttributeSet attributeSetAsAttributeSet2 = Xml.asAttributeSet(xml);
                                    Resources.Theme theme2 = context.getTheme();
                                    c4288c = new C4288c(context);
                                    c4288c.inflate(resources, xml, attributeSetAsAttributeSet2, theme2);
                                } else {
                                    Resources.Theme theme3 = context.getTheme();
                                    ThreadLocal threadLocal = AbstractC2355n.f8209a;
                                    drawableM5332a = AbstractC2350i.m5332a(resources, iIntValue, theme3);
                                    if (drawableM5332a == null) {
                                        throw new IllegalStateException(AbstractC0004e.m20n(iIntValue, "Invalid resource ID: ").toString());
                                    }
                                }
                                drawableM5332a = c4288c;
                            } else {
                                Resources.Theme theme4 = context.getTheme();
                                ThreadLocal threadLocal2 = AbstractC2355n.f8209a;
                                drawableM5332a = AbstractC2350i.m5332a(resources, iIntValue, theme4);
                                if (drawableM5332a == null) {
                                    throw new IllegalStateException(AbstractC0004e.m20n(iIntValue, "Invalid resource ID: ").toString());
                                }
                            }
                        }
                        if (!(drawableM5332a instanceof VectorDrawable) && !(drawableM5332a instanceof C4299n)) {
                            z7 = false;
                        }
                        if (z7) {
                            drawableM5332a = new BitmapDrawable(context.getResources(), AbstractC3928d.m7843d(drawableM5332a, c3065m.f10497b, c3065m.f10499d, c3065m.f10500e, c3065m.f10501f));
                        }
                        return new C2597d(drawableM5332a, z7, enumC2137f);
                    }
                }
                throw new IllegalStateException("Invalid android.resource URI: " + uri);
        }
    }
}
