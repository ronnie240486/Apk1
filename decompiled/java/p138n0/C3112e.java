package p138n0;

import android.content.ClipData;
import android.content.Context;
import android.content.res.XmlResourceParser;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import android.view.ContentInfo;
import androidx.constraintlayout.widget.C0308d;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.media3.extractor.text.ttml.TtmlNode;
import java.io.IOException;
import java.util.Locale;
import org.xmlpull.v1.XmlPullParserException;
import p000a.AbstractC0004e;
import p256y.C4185b;
import p256y.C4186c;

public final class C3112e implements InterfaceC3109d, InterfaceC3115f {

    public final int f10585a;

    public Object f10586b;

    public int f10587c;

    public int f10588d;

    public Object f10589e;

    public Cloneable f10590f;

    public C3112e() {
        this.f10585a = 0;
    }

    public void m6127a(Context context, XmlResourceParser xmlResourceParser) {
        C0308d c0308d = new C0308d();
        int attributeCount = xmlResourceParser.getAttributeCount();
        for (int i6 = 0; i6 < attributeCount; i6++) {
            if (TtmlNode.ATTR_ID.equals(xmlResourceParser.getAttributeName(i6))) {
                String attributeValue = xmlResourceParser.getAttributeValue(i6);
                int identifier = attributeValue.contains("/") ? context.getResources().getIdentifier(attributeValue.substring(attributeValue.indexOf(47) + 1), TtmlNode.ATTR_ID, context.getPackageName()) : -1;
                if (identifier == -1) {
                    if (attributeValue.length() > 1) {
                        identifier = Integer.parseInt(attributeValue.substring(1));
                    } else {
                        Log.e("ConstraintLayoutStates", "error in parsing id");
                    }
                }
                c0308d.m899i(context, xmlResourceParser);
                ((SparseArray) this.f10590f).put(identifier, c0308d);
                return;
            }
        }
    }

    @Override
    public ClipData mo5752e() {
        return (ClipData) this.f10586b;
    }

    @Override
    public C3118g mo5753f() {
        return new C3118g(new C3112e(this));
    }

    @Override
    public int getFlags() {
        return this.f10588d;
    }

    @Override
    public ContentInfo mo5755i() {
        return null;
    }

    @Override
    public void mo5756l(Uri uri) {
        this.f10589e = uri;
    }

    @Override
    public int mo5757m() {
        return this.f10587c;
    }

    @Override
    public void setExtras(Bundle bundle) {
        this.f10590f = bundle;
    }

    @Override
    public void setFlags(int i6) {
        this.f10588d = i6;
    }

    public String toString() {
        String strValueOf;
        String str;
        switch (this.f10585a) {
            case 1:
                StringBuilder sb = new StringBuilder("ContentInfoCompat{clip=");
                sb.append(((ClipData) this.f10586b).getDescription());
                sb.append(", source=");
                int i6 = this.f10587c;
                if (i6 == 0) {
                    strValueOf = "SOURCE_APP";
                } else if (i6 == 1) {
                    strValueOf = "SOURCE_CLIPBOARD";
                } else if (i6 == 2) {
                    strValueOf = "SOURCE_INPUT_METHOD";
                } else if (i6 == 3) {
                    strValueOf = "SOURCE_DRAG_AND_DROP";
                } else if (i6 != 4) {
                    strValueOf = i6 != 5 ? String.valueOf(i6) : "SOURCE_PROCESS_TEXT";
                } else {
                    strValueOf = "SOURCE_AUTOFILL";
                }
                sb.append(strValueOf);
                sb.append(", flags=");
                int i10 = this.f10588d;
                sb.append((i10 & 1) != 0 ? "FLAG_CONVERT_TO_PLAIN_TEXT" : String.valueOf(i10));
                Uri uri = (Uri) this.f10589e;
                if (uri == null) {
                    str = "";
                } else {
                    str = ", hasLinkUri(" + uri.toString().length() + ")";
                }
                sb.append(str);
                return AbstractC0004e.m26t(sb, ((Bundle) this.f10590f) != null ? ", hasExtras" : "", "}");
            default:
                return super.toString();
        }
    }

    public C3112e(Context context, ConstraintLayout constraintLayout, int i6) {
        byte b8;
        this.f10585a = 2;
        this.f10587c = -1;
        this.f10588d = -1;
        this.f10589e = new SparseArray();
        this.f10590f = new SparseArray();
        this.f10586b = constraintLayout;
        XmlResourceParser xml = context.getResources().getXml(i6);
        try {
            C4185b c4185b = null;
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 0) {
                    xml.getName();
                } else if (eventType == 2) {
                    String name = xml.getName();
                    switch (name.hashCode()) {
                        case -1349929691:
                            if (name.equals("ConstraintSet")) {
                                b8 = 4;
                            } else {
                                b8 = -1;
                            }
                            break;
                        case 80204913:
                            if (name.equals("State")) {
                                b8 = 2;
                            } else {
                                b8 = -1;
                            }
                            break;
                        case 1382829617:
                            if (name.equals("StateSet")) {
                                b8 = 1;
                            } else {
                                b8 = -1;
                            }
                            break;
                        case 1657696882:
                            if (name.equals("layoutDescription")) {
                                b8 = 0;
                            } else {
                                b8 = -1;
                            }
                            break;
                        case 1901439077:
                            if (name.equals("Variant")) {
                                b8 = 3;
                            } else {
                                b8 = -1;
                            }
                            break;
                        default:
                            b8 = -1;
                            break;
                    }
                    if (b8 != 0 && b8 != 1) {
                        if (b8 == 2) {
                            c4185b = new C4185b(context, xml);
                            ((SparseArray) this.f10589e).put(c4185b.f14135a, c4185b);
                        } else if (b8 == 3) {
                            C4186c c4186c = new C4186c(context, xml);
                            if (c4185b != null) {
                                c4185b.f14136b.add(c4186c);
                            }
                        } else if (b8 != 4) {
                            Log.v("ConstraintLayoutStates", "unknown tag " + name);
                        } else {
                            m6127a(context, xml);
                        }
                    }
                }
            }
        } catch (IOException e5) {
            e5.printStackTrace();
        } catch (XmlPullParserException e10) {
            e10.printStackTrace();
        }
    }

    public C3112e(C3112e c3112e) {
        this.f10585a = 1;
        ClipData clipData = (ClipData) c3112e.f10586b;
        clipData.getClass();
        this.f10586b = clipData;
        int i6 = c3112e.f10587c;
        if (i6 < 0) {
            Locale locale = Locale.US;
            throw new IllegalArgumentException("source is out of range of [0, 5] (too low)");
        }
        if (i6 <= 5) {
            this.f10587c = i6;
            int i10 = c3112e.f10588d;
            if ((i10 & 1) == i10) {
                this.f10588d = i10;
                this.f10589e = (Uri) c3112e.f10589e;
                this.f10590f = (Bundle) c3112e.f10590f;
                return;
            } else {
                throw new IllegalArgumentException("Requested flags 0x" + Integer.toHexString(i10) + ", but only 0x" + Integer.toHexString(1) + " are allowed");
            }
        }
        Locale locale2 = Locale.US;
        throw new IllegalArgumentException("source is out of range of [0, 5] (too high)");
    }
}
