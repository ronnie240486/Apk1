package p268z1;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import android.view.InflateException;
import android.view.animation.AnimationUtils;
import com.bumptech.glide.AbstractC1466d;
import com.lzy.okgo.model.Progress;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParserException;
import p046e0.AbstractC2343b;
import p056f0.C2483f;
import p124l6.C2987m;

public abstract class AbstractC4286a {

    public static final int[] f14510a = {R.attr.name, R.attr.tint, R.attr.height, R.attr.width, R.attr.alpha, R.attr.autoMirrored, R.attr.tintMode, R.attr.viewportWidth, R.attr.viewportHeight};

    public static final int[] f14511b = {R.attr.name, R.attr.pivotX, R.attr.pivotY, R.attr.scaleX, R.attr.scaleY, R.attr.rotation, R.attr.translateX, R.attr.translateY};

    public static final int[] f14512c = {R.attr.name, R.attr.fillColor, R.attr.pathData, R.attr.strokeColor, R.attr.strokeWidth, R.attr.trimPathStart, R.attr.trimPathEnd, R.attr.trimPathOffset, R.attr.strokeLineCap, R.attr.strokeLineJoin, R.attr.strokeMiterLimit, R.attr.strokeAlpha, R.attr.fillAlpha, R.attr.fillType};

    public static final int[] f14513d = {R.attr.name, R.attr.pathData, R.attr.fillType};

    public static final int[] f14514e = {R.attr.drawable};

    public static final int[] f14515f = {R.attr.name, R.attr.animation};

    public static final int[] f14516g = {R.attr.interpolator, R.attr.duration, R.attr.startOffset, R.attr.repeatCount, R.attr.repeatMode, R.attr.valueFrom, R.attr.valueTo, R.attr.valueType};

    public static final int[] f14517h = {R.attr.ordering};

    public static final int[] f14518i = {R.attr.valueFrom, R.attr.valueTo, R.attr.valueType, R.attr.propertyName};

    public static final int[] f14519j = {R.attr.value, R.attr.interpolator, R.attr.valueType, R.attr.fraction};

    public static final int[] f14520k = {R.attr.propertyName, R.attr.pathData, R.attr.propertyXName, R.attr.propertyYName};

    public static Animator m8344a(Context context, Resources resources, Resources.Theme theme, XmlResourceParser xmlResourceParser, AttributeSet attributeSet, AnimatorSet animatorSet, int i6) throws XmlPullParserException, IOException {
        PropertyValuesHolder[] propertyValuesHolderArr;
        AttributeSet attributeSet2;
        String str;
        PropertyValuesHolder propertyValuesHolderM8345b;
        int size;
        int i10;
        int i11;
        Keyframe keyframeOfFloat;
        Resources resources2 = resources;
        Resources.Theme theme2 = theme;
        XmlResourceParser xmlResourceParser2 = xmlResourceParser;
        int depth = xmlResourceParser.getDepth();
        Animator animatorM8347d = null;
        ArrayList arrayList = null;
        while (true) {
            int next = xmlResourceParser.next();
            boolean z7 = false;
            int i12 = 3;
            if (next == 3 && xmlResourceParser.getDepth() <= depth) {
                break;
            }
            int i13 = 1;
            if (next == 1) {
                break;
            }
            int i14 = 2;
            if (next == 2) {
                String name = xmlResourceParser.getName();
                if (name.equals("objectAnimator")) {
                    ObjectAnimator objectAnimator = new ObjectAnimator();
                    m8347d(context, resources, theme, attributeSet, objectAnimator, xmlResourceParser);
                    animatorM8347d = objectAnimator;
                } else if (name.equals("animator")) {
                    animatorM8347d = m8347d(context, resources, theme, attributeSet, null, xmlResourceParser);
                } else if (name.equals("set")) {
                    AnimatorSet animatorSet2 = new AnimatorSet();
                    TypedArray typedArrayM5322h = AbstractC2343b.m5322h(resources2, theme2, attributeSet, f14517h);
                    m8344a(context, resources, theme, xmlResourceParser, attributeSet, animatorSet2, !AbstractC2343b.m5319e(xmlResourceParser2, "ordering") ? 0 : typedArrayM5322h.getInt(0, 0));
                    typedArrayM5322h.recycle();
                    animatorM8347d = animatorSet2;
                } else {
                    String str2 = "propertyValuesHolder";
                    if (!name.equals("propertyValuesHolder")) {
                        throw new RuntimeException("Unknown animator name: " + xmlResourceParser.getName());
                    }
                    AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xmlResourceParser);
                    ArrayList arrayList2 = null;
                    while (true) {
                        int eventType = xmlResourceParser.getEventType();
                        if (eventType == i12 || eventType == i13) {
                            break;
                        }
                        if (eventType != i14) {
                            xmlResourceParser.next();
                        } else {
                            if (xmlResourceParser.getName().equals(str2)) {
                                TypedArray typedArrayM5322h2 = AbstractC2343b.m5322h(resources2, theme2, attributeSetAsAttributeSet, f14518i);
                                String strM5318d = AbstractC2343b.m5318d(typedArrayM5322h2, xmlResourceParser2, "propertyName", i12);
                                int i15 = !AbstractC2343b.m5319e(xmlResourceParser2, "valueType") ? 4 : typedArrayM5322h2.getInt(i14, 4);
                                int i16 = i15;
                                ArrayList arrayList3 = null;
                                while (true) {
                                    int next2 = xmlResourceParser.next();
                                    attributeSet2 = attributeSetAsAttributeSet;
                                    if (next2 == i12 || next2 == 1) {
                                        break;
                                    }
                                    if (xmlResourceParser.getName().equals("keyframe")) {
                                        int[] iArr = f14519j;
                                        i11 = i16;
                                        if (i11 == 4) {
                                            TypedArray typedArrayM5322h3 = AbstractC2343b.m5322h(resources2, theme2, Xml.asAttributeSet(xmlResourceParser), iArr);
                                            TypedValue typedValuePeekValue = !AbstractC2343b.m5319e(xmlResourceParser2, "value") ? null : typedArrayM5322h3.peekValue(0);
                                            int i17 = (typedValuePeekValue == null || !m8346c(typedValuePeekValue.type)) ? 0 : 3;
                                            typedArrayM5322h3.recycle();
                                            i11 = i17;
                                        }
                                        TypedArray typedArrayM5322h4 = AbstractC2343b.m5322h(resources2, theme2, Xml.asAttributeSet(xmlResourceParser), iArr);
                                        float f = AbstractC2343b.m5319e(xmlResourceParser2, Progress.FRACTION) ? typedArrayM5322h4.getFloat(3, -1.0f) : -1.0f;
                                        TypedValue typedValuePeekValue2 = !AbstractC2343b.m5319e(xmlResourceParser2, "value") ? null : typedArrayM5322h4.peekValue(0);
                                        boolean z10 = typedValuePeekValue2 != null;
                                        int i18 = i11 == 4 ? (z10 && m8346c(typedValuePeekValue2.type)) ? 3 : 0 : i11;
                                        if (!z10) {
                                            keyframeOfFloat = i18 == 0 ? Keyframe.ofFloat(f) : Keyframe.ofInt(f);
                                        } else if (i18 == 0) {
                                            keyframeOfFloat = Keyframe.ofFloat(f, !AbstractC2343b.m5319e(xmlResourceParser2, "value") ? 0.0f : typedArrayM5322h4.getFloat(0, 0.0f));
                                        } else if (i18 == 1 || i18 == 3) {
                                            keyframeOfFloat = Keyframe.ofInt(f, !AbstractC2343b.m5319e(xmlResourceParser2, "value") ? 0 : typedArrayM5322h4.getInt(0, 0));
                                        } else {
                                            keyframeOfFloat = null;
                                        }
                                        int resourceId = !AbstractC2343b.m5319e(xmlResourceParser2, "interpolator") ? 0 : typedArrayM5322h4.getResourceId(1, 0);
                                        if (resourceId > 0) {
                                            keyframeOfFloat.setInterpolator(AnimationUtils.loadInterpolator(context, resourceId));
                                        }
                                        typedArrayM5322h4.recycle();
                                        if (keyframeOfFloat != null) {
                                            if (arrayList3 == null) {
                                                arrayList3 = new ArrayList();
                                            }
                                            arrayList3.add(keyframeOfFloat);
                                        }
                                        xmlResourceParser.next();
                                    } else {
                                        i11 = i16;
                                    }
                                    resources2 = resources;
                                    theme2 = theme;
                                    str2 = str2;
                                    attributeSetAsAttributeSet = attributeSet2;
                                    i16 = i11;
                                    i12 = 3;
                                }
                                int i19 = i16;
                                str = str2;
                                if (arrayList3 == null || (size = arrayList3.size()) <= 0) {
                                    propertyValuesHolderM8345b = null;
                                } else {
                                    Keyframe keyframe = (Keyframe) arrayList3.get(0);
                                    Keyframe keyframe2 = (Keyframe) arrayList3.get(size - 1);
                                    float fraction = keyframe2.getFraction();
                                    if (fraction < 1.0f) {
                                        if (fraction < 0.0f) {
                                            keyframe2.setFraction(1.0f);
                                        } else {
                                            arrayList3.add(arrayList3.size(), keyframe2.getType() == Float.TYPE ? Keyframe.ofFloat(1.0f) : keyframe2.getType() == Integer.TYPE ? Keyframe.ofInt(1.0f) : Keyframe.ofObject(1.0f));
                                            size++;
                                        }
                                    }
                                    float fraction2 = keyframe.getFraction();
                                    if (fraction2 != 0.0f) {
                                        if (fraction2 < 0.0f) {
                                            keyframe.setFraction(0.0f);
                                        } else {
                                            arrayList3.add(0, keyframe.getType() == Float.TYPE ? Keyframe.ofFloat(0.0f) : keyframe.getType() == Integer.TYPE ? Keyframe.ofInt(0.0f) : Keyframe.ofObject(0.0f));
                                            size++;
                                        }
                                    }
                                    Keyframe[] keyframeArr = new Keyframe[size];
                                    arrayList3.toArray(keyframeArr);
                                    int i20 = 0;
                                    while (i20 < size) {
                                        Keyframe keyframe3 = keyframeArr[i20];
                                        if (keyframe3.getFraction() >= 0.0f) {
                                            i10 = size;
                                        } else {
                                            if (i20 == 0) {
                                                keyframe3.setFraction(0.0f);
                                            } else {
                                                int i21 = size - 1;
                                                if (i20 == i21) {
                                                    keyframe3.setFraction(1.0f);
                                                } else {
                                                    int i22 = i20;
                                                    for (int i23 = i20 + 1; i23 < i21 && keyframeArr[i23].getFraction() < 0.0f; i23++) {
                                                        i22 = i23;
                                                    }
                                                    float fraction3 = (keyframeArr[i22 + 1].getFraction() - keyframeArr[i20 - 1].getFraction()) / ((i22 - i20) + 2);
                                                    int i24 = i20;
                                                    while (i24 <= i22) {
                                                        keyframeArr[i24].setFraction(keyframeArr[i24 - 1].getFraction() + fraction3);
                                                        i24++;
                                                        size = size;
                                                    }
                                                    i10 = size;
                                                }
                                            }
                                            i10 = size;
                                        }
                                        i20++;
                                        size = i10;
                                    }
                                    propertyValuesHolderM8345b = PropertyValuesHolder.ofKeyframe(strM5318d, keyframeArr);
                                    if (i19 == 3) {
                                        propertyValuesHolderM8345b.setEvaluator(C4289d.f14528a);
                                    }
                                }
                                if (propertyValuesHolderM8345b == null) {
                                    propertyValuesHolderM8345b = m8345b(typedArrayM5322h2, i15, 0, 1, strM5318d);
                                }
                                if (propertyValuesHolderM8345b != null) {
                                    if (arrayList2 == null) {
                                        arrayList2 = new ArrayList();
                                    }
                                    arrayList2.add(propertyValuesHolderM8345b);
                                }
                                typedArrayM5322h2.recycle();
                            } else {
                                attributeSet2 = attributeSetAsAttributeSet;
                                str = str2;
                            }
                            xmlResourceParser.next();
                            resources2 = resources;
                            theme2 = theme;
                            xmlResourceParser2 = xmlResourceParser;
                            str2 = str;
                            attributeSetAsAttributeSet = attributeSet2;
                            i12 = 3;
                            i13 = 1;
                            i14 = 2;
                        }
                    }
                    if (arrayList2 != null) {
                        int size2 = arrayList2.size();
                        propertyValuesHolderArr = new PropertyValuesHolder[size2];
                        for (int i25 = 0; i25 < size2; i25++) {
                            propertyValuesHolderArr[i25] = (PropertyValuesHolder) arrayList2.get(i25);
                        }
                    } else {
                        propertyValuesHolderArr = null;
                    }
                    if (propertyValuesHolderArr != null && (animatorM8347d instanceof ValueAnimator)) {
                        ((ValueAnimator) animatorM8347d).setValues(propertyValuesHolderArr);
                    }
                    z7 = true;
                }
                if (animatorSet != null && !z7) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(animatorM8347d);
                }
                resources2 = resources;
                theme2 = theme;
                xmlResourceParser2 = xmlResourceParser;
            }
        }
        if (animatorSet != null && arrayList != null) {
            Animator[] animatorArr = new Animator[arrayList.size()];
            Iterator it = arrayList.iterator();
            int i26 = 0;
            while (it.hasNext()) {
                animatorArr[i26] = (Animator) it.next();
                i26++;
            }
            if (i6 == 0) {
                animatorSet.playTogether(animatorArr);
            } else {
                animatorSet.playSequentially(animatorArr);
            }
        }
        return animatorM8347d;
    }

    public static PropertyValuesHolder m8345b(TypedArray typedArray, int i6, int i10, int i11, String str) {
        int color;
        int color2;
        int color3;
        PropertyValuesHolder propertyValuesHolderOfFloat;
        PropertyValuesHolder propertyValuesHolderOfObject;
        int i12 = 3;
        TypedValue typedValuePeekValue = typedArray.peekValue(i10);
        boolean z7 = typedValuePeekValue != null;
        int i13 = z7 ? typedValuePeekValue.type : 0;
        TypedValue typedValuePeekValue2 = typedArray.peekValue(i11);
        boolean z10 = typedValuePeekValue2 != null;
        int i14 = z10 ? typedValuePeekValue2.type : 0;
        if (i6 == 4) {
            i6 = ((z7 && m8346c(i13)) || (z10 && m8346c(i14))) ? 3 : 0;
        }
        boolean z11 = i6 == 0;
        PropertyValuesHolder propertyValuesHolderOfInt = null;
        if (i6 == 2) {
            String string = typedArray.getString(i10);
            String string2 = typedArray.getString(i11);
            C2483f[] c2483fArrM3488f = AbstractC1466d.m3488f(string);
            C2483f[] c2483fArrM3488f2 = AbstractC1466d.m3488f(string2);
            if (c2483fArrM3488f == null && c2483fArrM3488f2 == null) {
                return null;
            }
            if (c2483fArrM3488f == null) {
                if (c2483fArrM3488f2 != null) {
                    return PropertyValuesHolder.ofObject(str, new C2987m(i12), c2483fArrM3488f2);
                }
                return null;
            }
            C2987m c2987m = new C2987m(i12);
            if (c2483fArrM3488f2 == null) {
                propertyValuesHolderOfObject = PropertyValuesHolder.ofObject(str, c2987m, c2483fArrM3488f);
            } else {
                if (!AbstractC1466d.m3486a(c2483fArrM3488f, c2483fArrM3488f2)) {
                    throw new InflateException(" Can't morph from " + string + " to " + string2);
                }
                propertyValuesHolderOfObject = PropertyValuesHolder.ofObject(str, c2987m, c2483fArrM3488f, c2483fArrM3488f2);
            }
            return propertyValuesHolderOfObject;
        }
        C4289d c4289d = i6 == 3 ? C4289d.f14528a : null;
        if (z11) {
            if (z7) {
                float dimension = i13 == 5 ? typedArray.getDimension(i10, 0.0f) : typedArray.getFloat(i10, 0.0f);
                if (z10) {
                    propertyValuesHolderOfFloat = PropertyValuesHolder.ofFloat(str, dimension, i14 == 5 ? typedArray.getDimension(i11, 0.0f) : typedArray.getFloat(i11, 0.0f));
                } else {
                    propertyValuesHolderOfFloat = PropertyValuesHolder.ofFloat(str, dimension);
                }
            } else {
                propertyValuesHolderOfFloat = PropertyValuesHolder.ofFloat(str, i14 == 5 ? typedArray.getDimension(i11, 0.0f) : typedArray.getFloat(i11, 0.0f));
            }
            propertyValuesHolderOfInt = propertyValuesHolderOfFloat;
        } else if (z7) {
            if (i13 == 5) {
                color2 = (int) typedArray.getDimension(i10, 0.0f);
            } else {
                color2 = m8346c(i13) ? typedArray.getColor(i10, 0) : typedArray.getInt(i10, 0);
            }
            if (z10) {
                if (i14 == 5) {
                    color3 = (int) typedArray.getDimension(i11, 0.0f);
                } else {
                    color3 = m8346c(i14) ? typedArray.getColor(i11, 0) : typedArray.getInt(i11, 0);
                }
                propertyValuesHolderOfInt = PropertyValuesHolder.ofInt(str, color2, color3);
            } else {
                propertyValuesHolderOfInt = PropertyValuesHolder.ofInt(str, color2);
            }
        } else if (z10) {
            if (i14 == 5) {
                color = (int) typedArray.getDimension(i11, 0.0f);
            } else {
                color = m8346c(i14) ? typedArray.getColor(i11, 0) : typedArray.getInt(i11, 0);
            }
            propertyValuesHolderOfInt = PropertyValuesHolder.ofInt(str, color);
        }
        if (propertyValuesHolderOfInt == null || c4289d == null) {
            return propertyValuesHolderOfInt;
        }
        propertyValuesHolderOfInt.setEvaluator(c4289d);
        return propertyValuesHolderOfInt;
    }

    public static boolean m8346c(int i6) {
        return i6 >= 28 && i6 <= 31;
    }

    public static ValueAnimator m8347d(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, ObjectAnimator objectAnimator, XmlResourceParser xmlResourceParser) {
        ValueAnimator valueAnimator;
        TypedArray typedArray;
        TypedArray typedArray2;
        ValueAnimator valueAnimator2;
        int resourceId = 0;
        int i6 = 1;
        TypedArray typedArrayM5322h = AbstractC2343b.m5322h(resources, theme, attributeSet, f14516g);
        TypedArray typedArrayM5322h2 = AbstractC2343b.m5322h(resources, theme, attributeSet, f14520k);
        ValueAnimator valueAnimator3 = objectAnimator == null ? new ValueAnimator() : objectAnimator;
        long jM5317c = AbstractC2343b.m5317c(typedArrayM5322h, xmlResourceParser, "duration", 1, 300);
        long j10 = !AbstractC2343b.m5319e(xmlResourceParser, "startOffset") ? 0 : typedArrayM5322h.getInt(2, 0);
        int i10 = !AbstractC2343b.m5319e(xmlResourceParser, "valueType") ? 4 : typedArrayM5322h.getInt(7, 4);
        if (AbstractC2343b.m5319e(xmlResourceParser, "valueFrom") && AbstractC2343b.m5319e(xmlResourceParser, "valueTo")) {
            if (i10 == 4) {
                TypedValue typedValuePeekValue = typedArrayM5322h.peekValue(5);
                boolean z7 = typedValuePeekValue != null;
                int i11 = z7 ? typedValuePeekValue.type : 0;
                TypedValue typedValuePeekValue2 = typedArrayM5322h.peekValue(6);
                boolean z10 = typedValuePeekValue2 != null;
                i10 = ((z7 && m8346c(i11)) || (z10 && m8346c(z10 ? typedValuePeekValue2.type : 0))) ? 3 : 0;
            }
            PropertyValuesHolder propertyValuesHolderM8345b = m8345b(typedArrayM5322h, i10, 5, 6, "");
            if (propertyValuesHolderM8345b != null) {
                valueAnimator3.setValues(propertyValuesHolderM8345b);
            }
        }
        valueAnimator3.setDuration(jM5317c);
        valueAnimator3.setStartDelay(j10);
        valueAnimator3.setRepeatCount(!AbstractC2343b.m5319e(xmlResourceParser, "repeatCount") ? 0 : typedArrayM5322h.getInt(3, 0));
        valueAnimator3.setRepeatMode(!AbstractC2343b.m5319e(xmlResourceParser, "repeatMode") ? 1 : typedArrayM5322h.getInt(4, 1));
        if (typedArrayM5322h2 != null) {
            ObjectAnimator objectAnimator2 = (ObjectAnimator) valueAnimator3;
            String strM5318d = AbstractC2343b.m5318d(typedArrayM5322h2, xmlResourceParser, "pathData", 1);
            if (strM5318d != null) {
                String strM5318d2 = AbstractC2343b.m5318d(typedArrayM5322h2, xmlResourceParser, "propertyXName", 2);
                String strM5318d3 = AbstractC2343b.m5318d(typedArrayM5322h2, xmlResourceParser, "propertyYName", 3);
                if (strM5318d2 == null && strM5318d3 == null) {
                    throw new InflateException(typedArrayM5322h2.getPositionDescription() + " propertyXName or propertyYName is needed for PathData");
                }
                Path pathM3489g = AbstractC1466d.m3489g(strM5318d);
                PathMeasure pathMeasure = new PathMeasure(pathM3489g, false);
                ArrayList arrayList = new ArrayList();
                arrayList.add(Float.valueOf(0.0f));
                float length = 0.0f;
                while (true) {
                    length += pathMeasure.getLength();
                    arrayList.add(Float.valueOf(length));
                    if (!pathMeasure.nextContour()) {
                        break;
                    }
                    valueAnimator3 = valueAnimator3;
                    i6 = 1;
                }
                PathMeasure pathMeasure2 = new PathMeasure(pathM3489g, false);
                int iMin = Math.min(100, ((int) (length / 0.5f)) + i6);
                float[] fArr = new float[iMin];
                float[] fArr2 = new float[iMin];
                float[] fArr3 = new float[2];
                float f = length / (iMin - 1);
                valueAnimator = valueAnimator3;
                typedArray = typedArrayM5322h;
                int i12 = 0;
                int i13 = 0;
                float f3 = 0.0f;
                while (true) {
                    if (i13 >= iMin) {
                        break;
                    }
                    int i14 = iMin;
                    pathMeasure2.getPosTan(f3 - ((Float) arrayList.get(i12)).floatValue(), fArr3, null);
                    fArr[i13] = fArr3[0];
                    fArr2[i13] = fArr3[1];
                    f3 += f;
                    int i15 = i12 + 1;
                    if (i15 < arrayList.size() && f3 > ((Float) arrayList.get(i15)).floatValue()) {
                        pathMeasure2.nextContour();
                        i12 = i15;
                    }
                    i13++;
                    iMin = i14;
                }
                PropertyValuesHolder propertyValuesHolderOfFloat = strM5318d2 != null ? PropertyValuesHolder.ofFloat(strM5318d2, fArr) : null;
                PropertyValuesHolder propertyValuesHolderOfFloat2 = strM5318d3 != null ? PropertyValuesHolder.ofFloat(strM5318d3, fArr2) : null;
                if (propertyValuesHolderOfFloat == null) {
                    resourceId = 0;
                    objectAnimator2.setValues(propertyValuesHolderOfFloat2);
                } else {
                    resourceId = 0;
                    if (propertyValuesHolderOfFloat2 == null) {
                        objectAnimator2.setValues(propertyValuesHolderOfFloat);
                    } else {
                        objectAnimator2.setValues(propertyValuesHolderOfFloat, propertyValuesHolderOfFloat2);
                    }
                }
            } else {
                valueAnimator = valueAnimator3;
                typedArray = typedArrayM5322h;
                objectAnimator2.setPropertyName(AbstractC2343b.m5318d(typedArrayM5322h2, xmlResourceParser, "propertyName", 0));
            }
        } else {
            valueAnimator = valueAnimator3;
            typedArray = typedArrayM5322h;
        }
        if (AbstractC2343b.m5319e(xmlResourceParser, "interpolator")) {
            typedArray2 = typedArray;
            resourceId = typedArray2.getResourceId(resourceId, resourceId);
        } else {
            typedArray2 = typedArray;
        }
        if (resourceId > 0) {
            valueAnimator2 = valueAnimator;
            valueAnimator2.setInterpolator(AnimationUtils.loadInterpolator(context, resourceId));
        } else {
            valueAnimator2 = valueAnimator;
        }
        typedArray2.recycle();
        if (typedArrayM5322h2 != null) {
            typedArrayM5322h2.recycle();
        }
        return valueAnimator2;
    }
}
