package p272z5;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Xml;
import com.bumptech.glide.AbstractC1466d;
import com.google.android.material.badge.BadgeState$State;
import com.google.android.material.internal.AbstractC1811a0;
import com.p2serv.android.p032ds.R;
import java.io.IOException;
import java.util.Locale;
import org.xmlpull.v1.XmlPullParserException;
import p250x5.AbstractC4121a;

public final class C4356b {

    public final BadgeState$State f14778a;

    public final BadgeState$State f14779b = new BadgeState$State();

    public final float f14780c;

    public final float f14781d;

    public final float f14782e;

    public C4356b(Context context, BadgeState$State badgeState$State) {
        AttributeSet attributeSet;
        int styleAttribute;
        int next;
        BadgeState$State badgeState$State2 = badgeState$State == null ? new BadgeState$State() : badgeState$State;
        int i6 = badgeState$State2.f5882a;
        if (i6 != 0) {
            try {
                XmlResourceParser xml = context.getResources().getXml(i6);
                do {
                    next = xml.next();
                    if (next == 2) {
                        break;
                    }
                } while (next != 1);
                if (next != 2) {
                    throw new XmlPullParserException("No start tag found");
                }
                if (!TextUtils.equals(xml.getName(), "badge")) {
                    throw new XmlPullParserException("Must have a <" + ((Object) "badge") + "> start tag");
                }
                AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
                styleAttribute = attributeSetAsAttributeSet.getStyleAttribute();
                attributeSet = attributeSetAsAttributeSet;
            } catch (IOException | XmlPullParserException e5) {
                Resources.NotFoundException notFoundException = new Resources.NotFoundException("Can't load badge resource ID #0x" + Integer.toHexString(i6));
                notFoundException.initCause(e5);
                throw notFoundException;
            }
        } else {
            attributeSet = null;
            styleAttribute = 0;
        }
        TypedArray typedArrayM4250j = AbstractC1811a0.m4250j(context, attributeSet, AbstractC4121a.f13987c, R.attr.badgeStyle, styleAttribute == 0 ? R.style.Widget_MaterialComponents_Badge : styleAttribute, new int[0]);
        Resources resources = context.getResources();
        this.f14780c = typedArrayM4250j.getDimensionPixelSize(2, resources.getDimensionPixelSize(R.dimen.mtrl_badge_radius));
        this.f14782e = typedArrayM4250j.getDimensionPixelSize(4, resources.getDimensionPixelSize(R.dimen.mtrl_badge_long_text_horizontal_padding));
        this.f14781d = typedArrayM4250j.getDimensionPixelSize(5, resources.getDimensionPixelSize(R.dimen.mtrl_badge_with_text_radius));
        BadgeState$State badgeState$State3 = this.f14779b;
        int i10 = badgeState$State2.f5885d;
        badgeState$State3.f5885d = i10 == -2 ? 255 : i10;
        CharSequence charSequence = badgeState$State2.f5889h;
        badgeState$State3.f5889h = charSequence == null ? context.getString(R.string.mtrl_badge_numberless_content_description) : charSequence;
        BadgeState$State badgeState$State4 = this.f14779b;
        int i11 = badgeState$State2.f5890i;
        badgeState$State4.f5890i = i11 == 0 ? R.plurals.mtrl_badge_content_description : i11;
        int i12 = badgeState$State2.f5891j;
        badgeState$State4.f5891j = i12 == 0 ? R.string.mtrl_exceed_max_badge_number_content_description : i12;
        Boolean bool = badgeState$State2.f5893l;
        badgeState$State4.f5893l = Boolean.valueOf(bool == null || bool.booleanValue());
        BadgeState$State badgeState$State5 = this.f14779b;
        int i13 = badgeState$State2.f5887f;
        badgeState$State5.f5887f = i13 == -2 ? typedArrayM4250j.getInt(8, 4) : i13;
        int i14 = badgeState$State2.f5886e;
        if (i14 != -2) {
            this.f14779b.f5886e = i14;
        } else if (typedArrayM4250j.hasValue(9)) {
            this.f14779b.f5886e = typedArrayM4250j.getInt(9, 0);
        } else {
            this.f14779b.f5886e = -1;
        }
        BadgeState$State badgeState$State6 = this.f14779b;
        Integer num = badgeState$State2.f5883b;
        badgeState$State6.f5883b = Integer.valueOf(num == null ? AbstractC1466d.m3493k(context, typedArrayM4250j, 0).getDefaultColor() : num.intValue());
        Integer num2 = badgeState$State2.f5884c;
        if (num2 != null) {
            this.f14779b.f5884c = num2;
        } else if (typedArrayM4250j.hasValue(3)) {
            this.f14779b.f5884c = Integer.valueOf(AbstractC1466d.m3493k(context, typedArrayM4250j, 3).getDefaultColor());
        } else {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(R.style.TextAppearance_MaterialComponents_Badge, AbstractC4121a.f13982Z);
            typedArrayObtainStyledAttributes.getDimension(0, 0.0f);
            ColorStateList colorStateListM3493k = AbstractC1466d.m3493k(context, typedArrayObtainStyledAttributes, 3);
            AbstractC1466d.m3493k(context, typedArrayObtainStyledAttributes, 4);
            AbstractC1466d.m3493k(context, typedArrayObtainStyledAttributes, 5);
            typedArrayObtainStyledAttributes.getInt(2, 0);
            typedArrayObtainStyledAttributes.getInt(1, 1);
            int i15 = typedArrayObtainStyledAttributes.hasValue(12) ? 12 : 10;
            typedArrayObtainStyledAttributes.getResourceId(i15, 0);
            typedArrayObtainStyledAttributes.getString(i15);
            typedArrayObtainStyledAttributes.getBoolean(14, false);
            AbstractC1466d.m3493k(context, typedArrayObtainStyledAttributes, 6);
            typedArrayObtainStyledAttributes.getFloat(7, 0.0f);
            typedArrayObtainStyledAttributes.getFloat(8, 0.0f);
            typedArrayObtainStyledAttributes.getFloat(9, 0.0f);
            typedArrayObtainStyledAttributes.recycle();
            TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(R.style.TextAppearance_MaterialComponents_Badge, AbstractC4121a.f13964H);
            typedArrayObtainStyledAttributes2.hasValue(0);
            typedArrayObtainStyledAttributes2.getFloat(0, 0.0f);
            typedArrayObtainStyledAttributes2.recycle();
            this.f14779b.f5884c = Integer.valueOf(colorStateListM3493k.getDefaultColor());
        }
        BadgeState$State badgeState$State7 = this.f14779b;
        Integer num3 = badgeState$State2.f5892k;
        badgeState$State7.f5892k = Integer.valueOf(num3 == null ? typedArrayM4250j.getInt(1, 8388661) : num3.intValue());
        BadgeState$State badgeState$State8 = this.f14779b;
        Integer num4 = badgeState$State2.f5894m;
        badgeState$State8.f5894m = Integer.valueOf(num4 == null ? typedArrayM4250j.getDimensionPixelOffset(6, 0) : num4.intValue());
        this.f14779b.f5895n = Integer.valueOf(badgeState$State2.f5894m == null ? typedArrayM4250j.getDimensionPixelOffset(10, 0) : badgeState$State2.f5895n.intValue());
        BadgeState$State badgeState$State9 = this.f14779b;
        Integer num5 = badgeState$State2.f5896o;
        badgeState$State9.f5896o = Integer.valueOf(num5 == null ? typedArrayM4250j.getDimensionPixelOffset(7, badgeState$State9.f5894m.intValue()) : num5.intValue());
        BadgeState$State badgeState$State10 = this.f14779b;
        Integer num6 = badgeState$State2.f5897p;
        badgeState$State10.f5897p = Integer.valueOf(num6 == null ? typedArrayM4250j.getDimensionPixelOffset(11, badgeState$State10.f5895n.intValue()) : num6.intValue());
        BadgeState$State badgeState$State11 = this.f14779b;
        Integer num7 = badgeState$State2.f5898q;
        badgeState$State11.f5898q = Integer.valueOf(num7 == null ? 0 : num7.intValue());
        BadgeState$State badgeState$State12 = this.f14779b;
        Integer num8 = badgeState$State2.f5899r;
        badgeState$State12.f5899r = Integer.valueOf(num8 != null ? num8.intValue() : 0);
        typedArrayM4250j.recycle();
        Locale locale = badgeState$State2.f5888g;
        if (locale == null) {
            this.f14779b.f5888g = Build.VERSION.SDK_INT >= 24 ? Locale.getDefault(Locale.Category.FORMAT) : Locale.getDefault();
        } else {
            this.f14779b.f5888g = locale;
        }
        this.f14778a = badgeState$State2;
    }
}
