package p256y;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.constraintlayout.widget.C0308d;
import androidx.media3.container.MdtaMetadataEntry;
import androidx.media3.container.NalUnitUtil;
import androidx.media3.extractor.flac.FlacConstants;
import androidx.media3.extractor.p010ts.TsExtractor;
import com.alibaba.fastjson.asm.Opcodes;
import java.util.Arrays;

public final class C4187d {

    public static final SparseIntArray f14145k0;

    public int f14146A;

    public int f14147B;

    public int f14148C;

    public int f14149D;

    public int f14150E;

    public int f14151F;

    public int f14152G;

    public int f14153H;

    public int f14154I;

    public int f14155J;

    public int f14156K;

    public int f14157L;

    public int f14158M;

    public int f14159N;

    public int f14160O;

    public float f14161P;

    public float f14162Q;

    public int f14163R;

    public int f14164S;

    public int f14165T;

    public int f14166U;

    public int f14167V;

    public int f14168W;

    public int f14169X;

    public int f14170Y;

    public float f14171Z;

    public boolean f14172a;

    public float f14173a0;

    public boolean f14174b;

    public int f14175b0;

    public int f14176c;

    public int f14177c0;

    public int f14178d;

    public int f14179d0;

    public int f14180e;

    public int[] f14181e0;

    public int f14182f;

    public String f14183f0;

    public float f14184g;

    public String f14185g0;

    public int f14186h;

    public boolean f14187h0;

    public int f14188i;

    public boolean f14189i0;

    public int f14190j;

    public boolean f14191j0;

    public int f14192k;

    public int f14193l;

    public int f14194m;

    public int f14195n;

    public int f14196o;

    public int f14197p;

    public int f14198q;

    public int f14199r;

    public int f14200s;

    public int f14201t;

    public float f14202u;

    public float f14203v;

    public String f14204w;

    public int f14205x;

    public int f14206y;

    public float f14207z;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f14145k0 = sparseIntArray;
        sparseIntArray.append(38, 24);
        sparseIntArray.append(39, 25);
        sparseIntArray.append(41, 28);
        sparseIntArray.append(42, 29);
        sparseIntArray.append(47, 35);
        sparseIntArray.append(46, 34);
        sparseIntArray.append(20, 4);
        sparseIntArray.append(19, 3);
        sparseIntArray.append(17, 1);
        sparseIntArray.append(55, 6);
        sparseIntArray.append(56, 7);
        sparseIntArray.append(27, 17);
        sparseIntArray.append(28, 18);
        sparseIntArray.append(29, 19);
        sparseIntArray.append(0, 26);
        sparseIntArray.append(43, 31);
        sparseIntArray.append(44, 32);
        sparseIntArray.append(26, 10);
        sparseIntArray.append(25, 9);
        sparseIntArray.append(59, 13);
        sparseIntArray.append(62, 16);
        sparseIntArray.append(60, 14);
        sparseIntArray.append(57, 11);
        sparseIntArray.append(61, 15);
        sparseIntArray.append(58, 12);
        sparseIntArray.append(50, 38);
        sparseIntArray.append(36, 37);
        sparseIntArray.append(35, 39);
        sparseIntArray.append(49, 40);
        sparseIntArray.append(34, 20);
        sparseIntArray.append(48, 36);
        sparseIntArray.append(24, 5);
        sparseIntArray.append(37, 76);
        sparseIntArray.append(45, 76);
        sparseIntArray.append(40, 76);
        sparseIntArray.append(18, 76);
        sparseIntArray.append(16, 76);
        sparseIntArray.append(3, 23);
        sparseIntArray.append(5, 27);
        sparseIntArray.append(7, 30);
        sparseIntArray.append(8, 8);
        sparseIntArray.append(4, 33);
        sparseIntArray.append(6, 2);
        sparseIntArray.append(1, 22);
        sparseIntArray.append(2, 21);
        sparseIntArray.append(21, 61);
        sparseIntArray.append(23, 62);
        sparseIntArray.append(22, 63);
        sparseIntArray.append(54, 69);
        sparseIntArray.append(33, 70);
        sparseIntArray.append(12, 71);
        sparseIntArray.append(10, 72);
        sparseIntArray.append(11, 73);
        sparseIntArray.append(13, 74);
        sparseIntArray.append(9, 75);
    }

    public final void m8241a(C4187d c4187d) {
        this.f14172a = c4187d.f14172a;
        this.f14176c = c4187d.f14176c;
        this.f14174b = c4187d.f14174b;
        this.f14178d = c4187d.f14178d;
        this.f14180e = c4187d.f14180e;
        this.f14182f = c4187d.f14182f;
        this.f14184g = c4187d.f14184g;
        this.f14186h = c4187d.f14186h;
        this.f14188i = c4187d.f14188i;
        this.f14190j = c4187d.f14190j;
        this.f14192k = c4187d.f14192k;
        this.f14193l = c4187d.f14193l;
        this.f14194m = c4187d.f14194m;
        this.f14195n = c4187d.f14195n;
        this.f14196o = c4187d.f14196o;
        this.f14197p = c4187d.f14197p;
        this.f14198q = c4187d.f14198q;
        this.f14199r = c4187d.f14199r;
        this.f14200s = c4187d.f14200s;
        this.f14201t = c4187d.f14201t;
        this.f14202u = c4187d.f14202u;
        this.f14203v = c4187d.f14203v;
        this.f14204w = c4187d.f14204w;
        this.f14205x = c4187d.f14205x;
        this.f14206y = c4187d.f14206y;
        this.f14207z = c4187d.f14207z;
        this.f14146A = c4187d.f14146A;
        this.f14147B = c4187d.f14147B;
        this.f14148C = c4187d.f14148C;
        this.f14149D = c4187d.f14149D;
        this.f14150E = c4187d.f14150E;
        this.f14151F = c4187d.f14151F;
        this.f14152G = c4187d.f14152G;
        this.f14153H = c4187d.f14153H;
        this.f14154I = c4187d.f14154I;
        this.f14155J = c4187d.f14155J;
        this.f14156K = c4187d.f14156K;
        this.f14157L = c4187d.f14157L;
        this.f14158M = c4187d.f14158M;
        this.f14159N = c4187d.f14159N;
        this.f14160O = c4187d.f14160O;
        this.f14161P = c4187d.f14161P;
        this.f14162Q = c4187d.f14162Q;
        this.f14163R = c4187d.f14163R;
        this.f14164S = c4187d.f14164S;
        this.f14165T = c4187d.f14165T;
        this.f14166U = c4187d.f14166U;
        this.f14167V = c4187d.f14167V;
        this.f14168W = c4187d.f14168W;
        this.f14169X = c4187d.f14169X;
        this.f14170Y = c4187d.f14170Y;
        this.f14171Z = c4187d.f14171Z;
        this.f14173a0 = c4187d.f14173a0;
        this.f14175b0 = c4187d.f14175b0;
        this.f14177c0 = c4187d.f14177c0;
        this.f14179d0 = c4187d.f14179d0;
        this.f14185g0 = c4187d.f14185g0;
        int[] iArr = c4187d.f14181e0;
        if (iArr != null) {
            this.f14181e0 = Arrays.copyOf(iArr, iArr.length);
        } else {
            this.f14181e0 = null;
        }
        this.f14183f0 = c4187d.f14183f0;
        this.f14187h0 = c4187d.f14187h0;
        this.f14189i0 = c4187d.f14189i0;
        this.f14191j0 = c4187d.f14191j0;
    }

    public final void m8242b(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC4193j.f14241g);
        this.f14174b = true;
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i6 = 0; i6 < indexCount; i6++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i6);
            SparseIntArray sparseIntArray = f14145k0;
            int i10 = sparseIntArray.get(index);
            if (i10 == 80) {
                this.f14187h0 = typedArrayObtainStyledAttributes.getBoolean(index, this.f14187h0);
            } else if (i10 != 81) {
                switch (i10) {
                    case 1:
                        this.f14197p = C0308d.m892j(typedArrayObtainStyledAttributes, index, this.f14197p);
                        break;
                    case 2:
                        this.f14152G = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f14152G);
                        break;
                    case 3:
                        this.f14196o = C0308d.m892j(typedArrayObtainStyledAttributes, index, this.f14196o);
                        break;
                    case 4:
                        this.f14195n = C0308d.m892j(typedArrayObtainStyledAttributes, index, this.f14195n);
                        break;
                    case 5:
                        this.f14204w = typedArrayObtainStyledAttributes.getString(index);
                        break;
                    case 6:
                        this.f14146A = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f14146A);
                        break;
                    case 7:
                        this.f14147B = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f14147B);
                        break;
                    case 8:
                        this.f14153H = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f14153H);
                        break;
                    case 9:
                        this.f14201t = C0308d.m892j(typedArrayObtainStyledAttributes, index, this.f14201t);
                        break;
                    case 10:
                        this.f14200s = C0308d.m892j(typedArrayObtainStyledAttributes, index, this.f14200s);
                        break;
                    case 11:
                        this.f14158M = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f14158M);
                        break;
                    case 12:
                        this.f14159N = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f14159N);
                        break;
                    case 13:
                        this.f14155J = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f14155J);
                        break;
                    case 14:
                        this.f14157L = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f14157L);
                        break;
                    case 15:
                        this.f14160O = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f14160O);
                        break;
                    case 16:
                        this.f14156K = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f14156K);
                        break;
                    case 17:
                        this.f14180e = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f14180e);
                        break;
                    case 18:
                        this.f14182f = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f14182f);
                        break;
                    case 19:
                        this.f14184g = typedArrayObtainStyledAttributes.getFloat(index, this.f14184g);
                        break;
                    case 20:
                        this.f14202u = typedArrayObtainStyledAttributes.getFloat(index, this.f14202u);
                        break;
                    case 21:
                        this.f14178d = typedArrayObtainStyledAttributes.getLayoutDimension(index, this.f14178d);
                        break;
                    case 22:
                        this.f14176c = typedArrayObtainStyledAttributes.getLayoutDimension(index, this.f14176c);
                        break;
                    case 23:
                        this.f14149D = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f14149D);
                        break;
                    case 24:
                        this.f14186h = C0308d.m892j(typedArrayObtainStyledAttributes, index, this.f14186h);
                        break;
                    case 25:
                        this.f14188i = C0308d.m892j(typedArrayObtainStyledAttributes, index, this.f14188i);
                        break;
                    case 26:
                        this.f14148C = typedArrayObtainStyledAttributes.getInt(index, this.f14148C);
                        break;
                    case 27:
                        this.f14150E = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f14150E);
                        break;
                    case 28:
                        this.f14190j = C0308d.m892j(typedArrayObtainStyledAttributes, index, this.f14190j);
                        break;
                    case 29:
                        this.f14192k = C0308d.m892j(typedArrayObtainStyledAttributes, index, this.f14192k);
                        break;
                    case 30:
                        this.f14154I = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f14154I);
                        break;
                    case 31:
                        this.f14198q = C0308d.m892j(typedArrayObtainStyledAttributes, index, this.f14198q);
                        break;
                    case 32:
                        this.f14199r = C0308d.m892j(typedArrayObtainStyledAttributes, index, this.f14199r);
                        break;
                    case 33:
                        this.f14151F = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f14151F);
                        break;
                    case 34:
                        this.f14194m = C0308d.m892j(typedArrayObtainStyledAttributes, index, this.f14194m);
                        break;
                    case 35:
                        this.f14193l = C0308d.m892j(typedArrayObtainStyledAttributes, index, this.f14193l);
                        break;
                    case TsExtractor.TS_STREAM_TYPE_H265:
                        this.f14203v = typedArrayObtainStyledAttributes.getFloat(index, this.f14203v);
                        break;
                    case 37:
                        this.f14162Q = typedArrayObtainStyledAttributes.getFloat(index, this.f14162Q);
                        break;
                    case FlacConstants.STREAM_INFO_BLOCK_SIZE:
                        this.f14161P = typedArrayObtainStyledAttributes.getFloat(index, this.f14161P);
                        break;
                    case NalUnitUtil.H265_NAL_UNIT_TYPE_PREFIX_SEI:
                        this.f14163R = typedArrayObtainStyledAttributes.getInt(index, this.f14163R);
                        break;
                    case NalUnitUtil.H265_NAL_UNIT_TYPE_SUFFIX_SEI:
                        this.f14164S = typedArrayObtainStyledAttributes.getInt(index, this.f14164S);
                        break;
                    default:
                        switch (i10) {
                            case Opcodes.ISTORE:
                                this.f14165T = typedArrayObtainStyledAttributes.getInt(index, this.f14165T);
                                break;
                            case Opcodes.LSTORE:
                                this.f14166U = typedArrayObtainStyledAttributes.getInt(index, this.f14166U);
                                break;
                            case Opcodes.FSTORE:
                                this.f14167V = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f14167V);
                                break;
                            case Opcodes.DSTORE:
                                this.f14168W = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f14168W);
                                break;
                            case Opcodes.ASTORE:
                                this.f14169X = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f14169X);
                                break;
                            case 59:
                                this.f14170Y = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f14170Y);
                                break;
                            default:
                                switch (i10) {
                                    case 61:
                                        this.f14205x = C0308d.m892j(typedArrayObtainStyledAttributes, index, this.f14205x);
                                        break;
                                    case 62:
                                        this.f14206y = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f14206y);
                                        break;
                                    case 63:
                                        this.f14207z = typedArrayObtainStyledAttributes.getFloat(index, this.f14207z);
                                        break;
                                    default:
                                        switch (i10) {
                                            case 69:
                                                this.f14171Z = typedArrayObtainStyledAttributes.getFloat(index, 1.0f);
                                                break;
                                            case 70:
                                                this.f14173a0 = typedArrayObtainStyledAttributes.getFloat(index, 1.0f);
                                                break;
                                            case TsExtractor.TS_SYNC_BYTE:
                                                Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                                                break;
                                            case 72:
                                                this.f14175b0 = typedArrayObtainStyledAttributes.getInt(index, this.f14175b0);
                                                break;
                                            case 73:
                                                this.f14177c0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f14177c0);
                                                break;
                                            case 74:
                                                this.f14183f0 = typedArrayObtainStyledAttributes.getString(index);
                                                break;
                                            case MdtaMetadataEntry.TYPE_INDICATOR_8_BIT_UNSIGNED_INT:
                                                this.f14191j0 = typedArrayObtainStyledAttributes.getBoolean(index, this.f14191j0);
                                                break;
                                            case 76:
                                                Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + sparseIntArray.get(index));
                                                break;
                                            case 77:
                                                this.f14185g0 = typedArrayObtainStyledAttributes.getString(index);
                                                break;
                                            default:
                                                Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(index) + "   " + sparseIntArray.get(index));
                                                break;
                                        }
                                        break;
                                }
                                break;
                        }
                        break;
                }
            } else {
                this.f14189i0 = typedArrayObtainStyledAttributes.getBoolean(index, this.f14189i0);
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }
}
