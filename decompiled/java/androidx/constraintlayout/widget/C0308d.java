package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.media3.container.MdtaMetadataEntry;
import androidx.media3.container.NalUnitUtil;
import androidx.media3.exoplayer.DefaultRenderersFactory;
import androidx.media3.extractor.AacUtil;
import androidx.media3.extractor.flac.FlacConstants;
import androidx.media3.extractor.p010ts.TsExtractor;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.alibaba.fastjson.asm.Opcodes;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import me.jessyan.autosize.BuildConfig;
import org.xmlpull.v1.XmlPullParserException;
import p003a2.AbstractC0032a;
import p194s.C3681e;
import p256y.AbstractC4192i;
import p256y.AbstractC4193j;
import p256y.C4184a;
import p256y.C4187d;
import p256y.C4188e;
import p256y.C4189f;
import p256y.C4190g;

public final class C0308d {

    public static final int[] f1412d = {0, 4, 8};

    public static final SparseIntArray f1413e;

    public final HashMap f1414a = new HashMap();

    public boolean f1415b = true;

    public final HashMap f1416c = new HashMap();

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f1413e = sparseIntArray;
        sparseIntArray.append(76, 25);
        sparseIntArray.append(77, 26);
        sparseIntArray.append(79, 29);
        sparseIntArray.append(80, 30);
        sparseIntArray.append(86, 36);
        sparseIntArray.append(85, 35);
        sparseIntArray.append(58, 4);
        sparseIntArray.append(57, 3);
        sparseIntArray.append(55, 1);
        sparseIntArray.append(94, 6);
        sparseIntArray.append(95, 7);
        sparseIntArray.append(65, 17);
        sparseIntArray.append(66, 18);
        sparseIntArray.append(67, 19);
        sparseIntArray.append(0, 27);
        sparseIntArray.append(81, 32);
        sparseIntArray.append(82, 33);
        sparseIntArray.append(64, 10);
        sparseIntArray.append(63, 9);
        sparseIntArray.append(98, 13);
        sparseIntArray.append(101, 16);
        sparseIntArray.append(99, 14);
        sparseIntArray.append(96, 11);
        sparseIntArray.append(100, 15);
        sparseIntArray.append(97, 12);
        sparseIntArray.append(89, 40);
        sparseIntArray.append(74, 39);
        sparseIntArray.append(73, 41);
        sparseIntArray.append(88, 42);
        sparseIntArray.append(72, 20);
        sparseIntArray.append(87, 37);
        sparseIntArray.append(62, 5);
        sparseIntArray.append(75, 82);
        sparseIntArray.append(84, 82);
        sparseIntArray.append(78, 82);
        sparseIntArray.append(56, 82);
        sparseIntArray.append(54, 82);
        sparseIntArray.append(5, 24);
        sparseIntArray.append(7, 28);
        sparseIntArray.append(23, 31);
        sparseIntArray.append(24, 8);
        sparseIntArray.append(6, 34);
        sparseIntArray.append(8, 2);
        sparseIntArray.append(3, 23);
        sparseIntArray.append(4, 21);
        sparseIntArray.append(2, 22);
        sparseIntArray.append(13, 43);
        sparseIntArray.append(26, 44);
        sparseIntArray.append(21, 45);
        sparseIntArray.append(22, 46);
        sparseIntArray.append(20, 60);
        sparseIntArray.append(18, 47);
        sparseIntArray.append(19, 48);
        sparseIntArray.append(14, 49);
        sparseIntArray.append(15, 50);
        sparseIntArray.append(16, 51);
        sparseIntArray.append(17, 52);
        sparseIntArray.append(25, 53);
        sparseIntArray.append(90, 54);
        sparseIntArray.append(68, 55);
        sparseIntArray.append(91, 56);
        sparseIntArray.append(69, 57);
        sparseIntArray.append(92, 58);
        sparseIntArray.append(70, 59);
        sparseIntArray.append(59, 61);
        sparseIntArray.append(61, 62);
        sparseIntArray.append(60, 63);
        sparseIntArray.append(27, 64);
        sparseIntArray.append(106, 65);
        sparseIntArray.append(33, 66);
        sparseIntArray.append(107, 67);
        sparseIntArray.append(103, 79);
        sparseIntArray.append(1, 38);
        sparseIntArray.append(102, 68);
        sparseIntArray.append(93, 69);
        sparseIntArray.append(71, 70);
        sparseIntArray.append(31, 71);
        sparseIntArray.append(29, 72);
        sparseIntArray.append(30, 73);
        sparseIntArray.append(32, 74);
        sparseIntArray.append(28, 75);
        sparseIntArray.append(104, 76);
        sparseIntArray.append(83, 77);
        sparseIntArray.append(108, 78);
        sparseIntArray.append(53, 80);
        sparseIntArray.append(52, 81);
    }

    public static int[] m890e(Barrier barrier, String str) {
        int iIntValue;
        HashMap map;
        String[] strArrSplit = str.split(",");
        Context context = barrier.getContext();
        int[] iArr = new int[strArrSplit.length];
        int i6 = 0;
        int i10 = 0;
        while (i6 < strArrSplit.length) {
            String strTrim = strArrSplit[i6].trim();
            Object obj = null;
            try {
                iIntValue = AbstractC4192i.class.getField(strTrim).getInt(null);
            } catch (Exception unused) {
                iIntValue = 0;
            }
            if (iIntValue == 0) {
                iIntValue = context.getResources().getIdentifier(strTrim, TtmlNode.ATTR_ID, context.getPackageName());
            }
            if (iIntValue == 0 && barrier.isInEditMode() && (barrier.getParent() instanceof ConstraintLayout)) {
                ConstraintLayout constraintLayout = (ConstraintLayout) barrier.getParent();
                constraintLayout.getClass();
                if ((strTrim instanceof String) && (map = constraintLayout.f1312m) != null && map.containsKey(strTrim)) {
                    obj = constraintLayout.f1312m.get(strTrim);
                }
                if (obj != null && (obj instanceof Integer)) {
                    iIntValue = ((Integer) obj).intValue();
                }
            }
            iArr[i10] = iIntValue;
            i6++;
            i10++;
        }
        return i10 != strArrSplit.length ? Arrays.copyOf(iArr, i10) : iArr;
    }

    public static C0307c m891f(Context context, AttributeSet attributeSet) {
        C0307c c0307c = new C0307c();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC4193j.f14235a);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i6 = 0; i6 < indexCount; i6++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i6);
            C4189f c4189f = c0307c.f1407b;
            C4188e c4188e = c0307c.f1408c;
            C4190g c4190g = c0307c.f1410e;
            C4187d c4187d = c0307c.f1409d;
            if (index != 1 && 23 != index && 24 != index) {
                c4188e.f14209a = true;
                c4187d.f14174b = true;
                c4189f.f14216a = true;
                c4190g.f14222a = true;
            }
            SparseIntArray sparseIntArray = f1413e;
            switch (sparseIntArray.get(index)) {
                case 1:
                    c4187d.f14197p = m892j(typedArrayObtainStyledAttributes, index, c4187d.f14197p);
                    break;
                case 2:
                    c4187d.f14152G = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, c4187d.f14152G);
                    break;
                case 3:
                    c4187d.f14196o = m892j(typedArrayObtainStyledAttributes, index, c4187d.f14196o);
                    break;
                case 4:
                    c4187d.f14195n = m892j(typedArrayObtainStyledAttributes, index, c4187d.f14195n);
                    break;
                case 5:
                    c4187d.f14204w = typedArrayObtainStyledAttributes.getString(index);
                    break;
                case 6:
                    c4187d.f14146A = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, c4187d.f14146A);
                    break;
                case 7:
                    c4187d.f14147B = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, c4187d.f14147B);
                    break;
                case 8:
                    c4187d.f14153H = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, c4187d.f14153H);
                    break;
                case 9:
                    c4187d.f14201t = m892j(typedArrayObtainStyledAttributes, index, c4187d.f14201t);
                    break;
                case 10:
                    c4187d.f14200s = m892j(typedArrayObtainStyledAttributes, index, c4187d.f14200s);
                    break;
                case 11:
                    c4187d.f14158M = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, c4187d.f14158M);
                    break;
                case 12:
                    c4187d.f14159N = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, c4187d.f14159N);
                    break;
                case 13:
                    c4187d.f14155J = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, c4187d.f14155J);
                    break;
                case 14:
                    c4187d.f14157L = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, c4187d.f14157L);
                    break;
                case 15:
                    c4187d.f14160O = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, c4187d.f14160O);
                    break;
                case 16:
                    c4187d.f14156K = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, c4187d.f14156K);
                    break;
                case 17:
                    c4187d.f14180e = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, c4187d.f14180e);
                    break;
                case 18:
                    c4187d.f14182f = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, c4187d.f14182f);
                    break;
                case 19:
                    c4187d.f14184g = typedArrayObtainStyledAttributes.getFloat(index, c4187d.f14184g);
                    break;
                case 20:
                    c4187d.f14202u = typedArrayObtainStyledAttributes.getFloat(index, c4187d.f14202u);
                    break;
                case 21:
                    c4187d.f14178d = typedArrayObtainStyledAttributes.getLayoutDimension(index, c4187d.f14178d);
                    break;
                case 22:
                    int i10 = typedArrayObtainStyledAttributes.getInt(index, c4189f.f14217b);
                    c4189f.f14217b = i10;
                    c4189f.f14217b = f1412d[i10];
                    break;
                case 23:
                    c4187d.f14176c = typedArrayObtainStyledAttributes.getLayoutDimension(index, c4187d.f14176c);
                    break;
                case 24:
                    c4187d.f14149D = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, c4187d.f14149D);
                    break;
                case 25:
                    c4187d.f14186h = m892j(typedArrayObtainStyledAttributes, index, c4187d.f14186h);
                    break;
                case 26:
                    c4187d.f14188i = m892j(typedArrayObtainStyledAttributes, index, c4187d.f14188i);
                    break;
                case 27:
                    c4187d.f14148C = typedArrayObtainStyledAttributes.getInt(index, c4187d.f14148C);
                    break;
                case 28:
                    c4187d.f14150E = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, c4187d.f14150E);
                    break;
                case 29:
                    c4187d.f14190j = m892j(typedArrayObtainStyledAttributes, index, c4187d.f14190j);
                    break;
                case 30:
                    c4187d.f14192k = m892j(typedArrayObtainStyledAttributes, index, c4187d.f14192k);
                    break;
                case 31:
                    c4187d.f14154I = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, c4187d.f14154I);
                    break;
                case 32:
                    c4187d.f14198q = m892j(typedArrayObtainStyledAttributes, index, c4187d.f14198q);
                    break;
                case 33:
                    c4187d.f14199r = m892j(typedArrayObtainStyledAttributes, index, c4187d.f14199r);
                    break;
                case 34:
                    c4187d.f14151F = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, c4187d.f14151F);
                    break;
                case 35:
                    c4187d.f14194m = m892j(typedArrayObtainStyledAttributes, index, c4187d.f14194m);
                    break;
                case TsExtractor.TS_STREAM_TYPE_H265:
                    c4187d.f14193l = m892j(typedArrayObtainStyledAttributes, index, c4187d.f14193l);
                    break;
                case 37:
                    c4187d.f14203v = typedArrayObtainStyledAttributes.getFloat(index, c4187d.f14203v);
                    break;
                case FlacConstants.STREAM_INFO_BLOCK_SIZE:
                    c0307c.f1406a = typedArrayObtainStyledAttributes.getResourceId(index, c0307c.f1406a);
                    break;
                case NalUnitUtil.H265_NAL_UNIT_TYPE_PREFIX_SEI:
                    c4187d.f14162Q = typedArrayObtainStyledAttributes.getFloat(index, c4187d.f14162Q);
                    break;
                case NalUnitUtil.H265_NAL_UNIT_TYPE_SUFFIX_SEI:
                    c4187d.f14161P = typedArrayObtainStyledAttributes.getFloat(index, c4187d.f14161P);
                    break;
                case BuildConfig.VERSION_CODE:
                    c4187d.f14163R = typedArrayObtainStyledAttributes.getInt(index, c4187d.f14163R);
                    break;
                case AacUtil.AUDIO_OBJECT_TYPE_AAC_XHE:
                    c4187d.f14164S = typedArrayObtainStyledAttributes.getInt(index, c4187d.f14164S);
                    break;
                case 43:
                    c4189f.f14219d = typedArrayObtainStyledAttributes.getFloat(index, c4189f.f14219d);
                    break;
                case 44:
                    c4190g.f14233l = true;
                    c4190g.f14234m = typedArrayObtainStyledAttributes.getDimension(index, c4190g.f14234m);
                    break;
                case TsExtractor.TS_STREAM_TYPE_MHAS:
                    c4190g.f14224c = typedArrayObtainStyledAttributes.getFloat(index, c4190g.f14224c);
                    break;
                case 46:
                    c4190g.f14225d = typedArrayObtainStyledAttributes.getFloat(index, c4190g.f14225d);
                    break;
                case 47:
                    c4190g.f14226e = typedArrayObtainStyledAttributes.getFloat(index, c4190g.f14226e);
                    break;
                case NalUnitUtil.H265_NAL_UNIT_TYPE_UNSPECIFIED:
                    c4190g.f14227f = typedArrayObtainStyledAttributes.getFloat(index, c4190g.f14227f);
                    break;
                case Opcodes.V1_5:
                    c4190g.f14228g = typedArrayObtainStyledAttributes.getDimension(index, c4190g.f14228g);
                    break;
                case DefaultRenderersFactory.MAX_DROPPED_VIDEO_FRAME_COUNT_TO_NOTIFY:
                    c4190g.f14229h = typedArrayObtainStyledAttributes.getDimension(index, c4190g.f14229h);
                    break;
                case 51:
                    c4190g.f14230i = typedArrayObtainStyledAttributes.getDimension(index, c4190g.f14230i);
                    break;
                case 52:
                    c4190g.f14231j = typedArrayObtainStyledAttributes.getDimension(index, c4190g.f14231j);
                    break;
                case 53:
                    c4190g.f14232k = typedArrayObtainStyledAttributes.getDimension(index, c4190g.f14232k);
                    break;
                case Opcodes.ISTORE:
                    c4187d.f14165T = typedArrayObtainStyledAttributes.getInt(index, c4187d.f14165T);
                    break;
                case Opcodes.LSTORE:
                    c4187d.f14166U = typedArrayObtainStyledAttributes.getInt(index, c4187d.f14166U);
                    break;
                case Opcodes.FSTORE:
                    c4187d.f14167V = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, c4187d.f14167V);
                    break;
                case Opcodes.DSTORE:
                    c4187d.f14168W = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, c4187d.f14168W);
                    break;
                case Opcodes.ASTORE:
                    c4187d.f14169X = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, c4187d.f14169X);
                    break;
                case 59:
                    c4187d.f14170Y = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, c4187d.f14170Y);
                    break;
                case 60:
                    c4190g.f14223b = typedArrayObtainStyledAttributes.getFloat(index, c4190g.f14223b);
                    break;
                case 61:
                    c4187d.f14205x = m892j(typedArrayObtainStyledAttributes, index, c4187d.f14205x);
                    break;
                case 62:
                    c4187d.f14206y = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, c4187d.f14206y);
                    break;
                case 63:
                    c4187d.f14207z = typedArrayObtainStyledAttributes.getFloat(index, c4187d.f14207z);
                    break;
                case 64:
                    c4188e.f14210b = m892j(typedArrayObtainStyledAttributes, index, c4188e.f14210b);
                    break;
                case 65:
                    if (typedArrayObtainStyledAttributes.peekValue(index).type == 3) {
                        c4188e.f14211c = typedArrayObtainStyledAttributes.getString(index);
                    } else {
                        c4188e.f14211c = C3681e.f12322c[typedArrayObtainStyledAttributes.getInteger(index, 0)];
                    }
                    break;
                case 66:
                    c4188e.f14213e = typedArrayObtainStyledAttributes.getInt(index, 0);
                    break;
                case MdtaMetadataEntry.TYPE_INDICATOR_INT32:
                    c4188e.f14215g = typedArrayObtainStyledAttributes.getFloat(index, c4188e.f14215g);
                    break;
                case 68:
                    c4189f.f14220e = typedArrayObtainStyledAttributes.getFloat(index, c4189f.f14220e);
                    break;
                case 69:
                    c4187d.f14171Z = typedArrayObtainStyledAttributes.getFloat(index, 1.0f);
                    break;
                case 70:
                    c4187d.f14173a0 = typedArrayObtainStyledAttributes.getFloat(index, 1.0f);
                    break;
                case TsExtractor.TS_SYNC_BYTE:
                    Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                    break;
                case 72:
                    c4187d.f14175b0 = typedArrayObtainStyledAttributes.getInt(index, c4187d.f14175b0);
                    break;
                case 73:
                    c4187d.f14177c0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, c4187d.f14177c0);
                    break;
                case 74:
                    c4187d.f14183f0 = typedArrayObtainStyledAttributes.getString(index);
                    break;
                case MdtaMetadataEntry.TYPE_INDICATOR_8_BIT_UNSIGNED_INT:
                    c4187d.f14191j0 = typedArrayObtainStyledAttributes.getBoolean(index, c4187d.f14191j0);
                    break;
                case 76:
                    c4188e.f14212d = typedArrayObtainStyledAttributes.getInt(index, c4188e.f14212d);
                    break;
                case 77:
                    c4187d.f14185g0 = typedArrayObtainStyledAttributes.getString(index);
                    break;
                case MdtaMetadataEntry.TYPE_INDICATOR_UNSIGNED_INT64:
                    c4189f.f14218c = typedArrayObtainStyledAttributes.getInt(index, c4189f.f14218c);
                    break;
                case Opcodes.IASTORE:
                    c4188e.f14214f = typedArrayObtainStyledAttributes.getFloat(index, c4188e.f14214f);
                    break;
                case 80:
                    c4187d.f14187h0 = typedArrayObtainStyledAttributes.getBoolean(index, c4187d.f14187h0);
                    break;
                case 81:
                    c4187d.f14189i0 = typedArrayObtainStyledAttributes.getBoolean(index, c4187d.f14189i0);
                    break;
                case 82:
                    Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + sparseIntArray.get(index));
                    break;
                default:
                    Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(index) + "   " + sparseIntArray.get(index));
                    break;
            }
        }
        typedArrayObtainStyledAttributes.recycle();
        return c0307c;
    }

    public static int m892j(TypedArray typedArray, int i6, int i10) {
        int resourceId = typedArray.getResourceId(i6, i10);
        return resourceId == -1 ? typedArray.getInt(i6, -1) : resourceId;
    }

    public final void m893a(MotionLayout motionLayout) {
        int childCount = motionLayout.getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = motionLayout.getChildAt(i6);
            int id = childAt.getId();
            HashMap map = this.f1416c;
            if (!map.containsKey(Integer.valueOf(id))) {
                Log.v("ConstraintSet", "id unknown " + AbstractC0032a.m171y(childAt));
            } else {
                if (this.f1415b && id == -1) {
                    throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
                }
                if (map.containsKey(Integer.valueOf(id))) {
                    C4184a.m8234f(childAt, ((C0307c) map.get(Integer.valueOf(id))).f1411f);
                }
            }
        }
    }

    public final void m894b(ConstraintLayout constraintLayout) {
        m895c(constraintLayout);
        constraintLayout.setConstraintSet(null);
        constraintLayout.requestLayout();
    }

    public final void m895c(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        HashMap map = this.f1416c;
        HashSet<Integer> hashSet = new HashSet(map.keySet());
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = constraintLayout.getChildAt(i6);
            int id = childAt.getId();
            if (!map.containsKey(Integer.valueOf(id))) {
                Log.w("ConstraintSet", "id unknown " + AbstractC0032a.m171y(childAt));
            } else {
                if (this.f1415b && id == -1) {
                    throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
                }
                if (id != -1) {
                    if (map.containsKey(Integer.valueOf(id))) {
                        hashSet.remove(Integer.valueOf(id));
                        C0307c c0307c = (C0307c) map.get(Integer.valueOf(id));
                        if (childAt instanceof Barrier) {
                            c0307c.f1409d.f14179d0 = 1;
                        }
                        int i10 = c0307c.f1409d.f14179d0;
                        if (i10 != -1 && i10 == 1) {
                            Barrier barrier = (Barrier) childAt;
                            barrier.setId(id);
                            C4187d c4187d = c0307c.f1409d;
                            barrier.setType(c4187d.f14175b0);
                            barrier.setMargin(c4187d.f14177c0);
                            barrier.setAllowsGoneWidget(c4187d.f14191j0);
                            int[] iArr = c4187d.f14181e0;
                            if (iArr != null) {
                                barrier.setReferencedIds(iArr);
                            } else {
                                String str = c4187d.f14183f0;
                                if (str != null) {
                                    int[] iArrM890e = m890e(barrier, str);
                                    c4187d.f14181e0 = iArrM890e;
                                    barrier.setReferencedIds(iArrM890e);
                                }
                            }
                        }
                        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) childAt.getLayoutParams();
                        layoutParams.m884a();
                        c0307c.m887a(layoutParams);
                        C4184a.m8234f(childAt, c0307c.f1411f);
                        childAt.setLayoutParams(layoutParams);
                        C4189f c4189f = c0307c.f1407b;
                        if (c4189f.f14218c == 0) {
                            childAt.setVisibility(c4189f.f14217b);
                        }
                        childAt.setAlpha(c4189f.f14219d);
                        C4190g c4190g = c0307c.f1410e;
                        childAt.setRotation(c4190g.f14223b);
                        childAt.setRotationX(c4190g.f14224c);
                        childAt.setRotationY(c4190g.f14225d);
                        childAt.setScaleX(c4190g.f14226e);
                        childAt.setScaleY(c4190g.f14227f);
                        if (!Float.isNaN(c4190g.f14228g)) {
                            childAt.setPivotX(c4190g.f14228g);
                        }
                        if (!Float.isNaN(c4190g.f14229h)) {
                            childAt.setPivotY(c4190g.f14229h);
                        }
                        childAt.setTranslationX(c4190g.f14230i);
                        childAt.setTranslationY(c4190g.f14231j);
                        childAt.setTranslationZ(c4190g.f14232k);
                        if (c4190g.f14233l) {
                            childAt.setElevation(c4190g.f14234m);
                        }
                    } else {
                        Log.v("ConstraintSet", "WARNING NO CONSTRAINTS for view " + id);
                    }
                }
            }
        }
        for (Integer num : hashSet) {
            C0307c c0307c2 = (C0307c) map.get(num);
            C4187d c4187d2 = c0307c2.f1409d;
            int i11 = c4187d2.f14179d0;
            if (i11 != -1 && i11 == 1) {
                Barrier barrier2 = new Barrier(constraintLayout.getContext());
                barrier2.setId(num.intValue());
                int[] iArr2 = c4187d2.f14181e0;
                if (iArr2 != null) {
                    barrier2.setReferencedIds(iArr2);
                } else {
                    String str2 = c4187d2.f14183f0;
                    if (str2 != null) {
                        int[] iArrM890e2 = m890e(barrier2, str2);
                        c4187d2.f14181e0 = iArrM890e2;
                        barrier2.setReferencedIds(iArrM890e2);
                    }
                }
                barrier2.setType(c4187d2.f14175b0);
                barrier2.setMargin(c4187d2.f14177c0);
                int i12 = ConstraintLayout.f1299p;
                ConstraintLayout.LayoutParams layoutParams2 = new ConstraintLayout.LayoutParams();
                barrier2.m876l();
                c0307c2.m887a(layoutParams2);
                constraintLayout.addView(barrier2, layoutParams2);
            }
            if (c4187d2.f14172a) {
                View guideline = new Guideline(constraintLayout.getContext());
                guideline.setId(num.intValue());
                int i13 = ConstraintLayout.f1299p;
                ConstraintLayout.LayoutParams layoutParams3 = new ConstraintLayout.LayoutParams();
                c0307c2.m887a(layoutParams3);
                constraintLayout.addView(guideline, layoutParams3);
            }
        }
    }

    public final void m896d(ConstraintLayout constraintLayout) {
        C0308d c0308d = this;
        int childCount = constraintLayout.getChildCount();
        HashMap map = c0308d.f1416c;
        map.clear();
        int i6 = 0;
        while (i6 < childCount) {
            View childAt = constraintLayout.getChildAt(i6);
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) childAt.getLayoutParams();
            int id = childAt.getId();
            if (c0308d.f1415b && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!map.containsKey(Integer.valueOf(id))) {
                map.put(Integer.valueOf(id), new C0307c());
            }
            C0307c c0307c = (C0307c) map.get(Integer.valueOf(id));
            HashMap map2 = c0308d.f1414a;
            HashMap map3 = new HashMap();
            Class<?> cls = childAt.getClass();
            for (String str : map2.keySet()) {
                C4184a c4184a = (C4184a) map2.get(str);
                try {
                    if (str.equals("BackgroundColor")) {
                        map3.put(str, new C4184a(c4184a, Integer.valueOf(((ColorDrawable) childAt.getBackground()).getColor())));
                    } else {
                        map3.put(str, new C4184a(c4184a, cls.getMethod("getMap" + str, null).invoke(childAt, null)));
                    }
                } catch (IllegalAccessException e5) {
                    e5.printStackTrace();
                } catch (NoSuchMethodException e10) {
                    e10.printStackTrace();
                } catch (InvocationTargetException e11) {
                    e11.printStackTrace();
                }
            }
            c0307c.f1411f = map3;
            c0307c.m888b(id, layoutParams);
            int visibility = childAt.getVisibility();
            C4189f c4189f = c0307c.f1407b;
            c4189f.f14217b = visibility;
            c4189f.f14219d = childAt.getAlpha();
            float rotation = childAt.getRotation();
            C4190g c4190g = c0307c.f1410e;
            c4190g.f14223b = rotation;
            c4190g.f14224c = childAt.getRotationX();
            c4190g.f14225d = childAt.getRotationY();
            c4190g.f14226e = childAt.getScaleX();
            c4190g.f14227f = childAt.getScaleY();
            float pivotX = childAt.getPivotX();
            float pivotY = childAt.getPivotY();
            if (pivotX != 0.0d || pivotY != 0.0d) {
                c4190g.f14228g = pivotX;
                c4190g.f14229h = pivotY;
            }
            c4190g.f14230i = childAt.getTranslationX();
            c4190g.f14231j = childAt.getTranslationY();
            c4190g.f14232k = childAt.getTranslationZ();
            if (c4190g.f14233l) {
                c4190g.f14234m = childAt.getElevation();
            }
            if (childAt instanceof Barrier) {
                Barrier barrier = (Barrier) childAt;
                boolean z7 = barrier.f1291j.f13293j0;
                C4187d c4187d = c0307c.f1409d;
                c4187d.f14191j0 = z7;
                c4187d.f14181e0 = barrier.getReferencedIds();
                c4187d.f14175b0 = barrier.getType();
                c4187d.f14177c0 = barrier.getMargin();
            }
            i6++;
            c0308d = this;
        }
    }

    public final C0307c m897g(int i6) {
        HashMap map = this.f1416c;
        if (!map.containsKey(Integer.valueOf(i6))) {
            map.put(Integer.valueOf(i6), new C0307c());
        }
        return (C0307c) map.get(Integer.valueOf(i6));
    }

    public final void m898h(Context context, int i6) {
        XmlResourceParser xml = context.getResources().getXml(i6);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 0) {
                    xml.getName();
                } else if (eventType == 2) {
                    String name = xml.getName();
                    C0307c c0307cM891f = m891f(context, Xml.asAttributeSet(xml));
                    if (name.equalsIgnoreCase("Guideline")) {
                        c0307cM891f.f1409d.f14172a = true;
                    }
                    this.f1416c.put(Integer.valueOf(c0307cM891f.f1406a), c0307cM891f);
                }
            }
        } catch (IOException e5) {
            e5.printStackTrace();
        } catch (XmlPullParserException e10) {
            e10.printStackTrace();
        }
    }

    public final void m899i(Context context, XmlResourceParser xmlResourceParser) {
        try {
            int eventType = xmlResourceParser.getEventType();
            C0307c c0307cM891f = null;
            while (eventType != 1) {
                if (eventType != 0) {
                    if (eventType == 2) {
                        switch (xmlResourceParser.getName()) {
                            case "Constraint":
                                c0307cM891f = m891f(context, Xml.asAttributeSet(xmlResourceParser));
                                break;
                            case "Guideline":
                                c0307cM891f = m891f(context, Xml.asAttributeSet(xmlResourceParser));
                                C4187d c4187d = c0307cM891f.f1409d;
                                c4187d.f14172a = true;
                                c4187d.f14174b = true;
                                break;
                            case "Barrier":
                                c0307cM891f = m891f(context, Xml.asAttributeSet(xmlResourceParser));
                                c0307cM891f.f1409d.f14179d0 = 1;
                                break;
                            case "PropertySet":
                                if (c0307cM891f == null) {
                                    throw new RuntimeException("XML parser error must be within a Constraint " + xmlResourceParser.getLineNumber());
                                }
                                c0307cM891f.f1407b.m8245a(context, Xml.asAttributeSet(xmlResourceParser));
                                break;
                                break;
                            case "Transform":
                                if (c0307cM891f == null) {
                                    throw new RuntimeException("XML parser error must be within a Constraint " + xmlResourceParser.getLineNumber());
                                }
                                c0307cM891f.f1410e.m8247b(context, Xml.asAttributeSet(xmlResourceParser));
                                break;
                                break;
                            case "Layout":
                                if (c0307cM891f == null) {
                                    throw new RuntimeException("XML parser error must be within a Constraint " + xmlResourceParser.getLineNumber());
                                }
                                c0307cM891f.f1409d.m8242b(context, Xml.asAttributeSet(xmlResourceParser));
                                break;
                                break;
                            case "Motion":
                                if (c0307cM891f == null) {
                                    throw new RuntimeException("XML parser error must be within a Constraint " + xmlResourceParser.getLineNumber());
                                }
                                c0307cM891f.f1408c.m8244b(context, Xml.asAttributeSet(xmlResourceParser));
                                break;
                                break;
                            case "CustomAttribute":
                                if (c0307cM891f == null) {
                                    throw new RuntimeException("XML parser error must be within a Constraint " + xmlResourceParser.getLineNumber());
                                }
                                C4184a.m8233e(context, xmlResourceParser, c0307cM891f.f1411f);
                                break;
                                break;
                        }
                    } else if (eventType != 3) {
                        continue;
                    } else {
                        String name = xmlResourceParser.getName();
                        if ("ConstraintSet".equals(name)) {
                            return;
                        }
                        if (name.equalsIgnoreCase("Constraint")) {
                            this.f1416c.put(Integer.valueOf(c0307cM891f.f1406a), c0307cM891f);
                            c0307cM891f = null;
                        }
                    }
                } else {
                    xmlResourceParser.getName();
                }
                eventType = xmlResourceParser.next();
            }
        } catch (IOException e5) {
            e5.printStackTrace();
        } catch (XmlPullParserException e10) {
            e10.printStackTrace();
        }
    }
}
