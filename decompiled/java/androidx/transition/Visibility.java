package androidx.transition;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Picture;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.p2serv.android.p032ds.R;
import java.util.HashMap;
import p046e0.AbstractC2343b;
import p258y1.AbstractC4204d0;
import p258y1.AbstractC4210g0;
import p258y1.AbstractC4233v;
import p258y1.C4206e0;
import p258y1.C4212h0;
import p258y1.C4220l0;
import p258y1.C4222m0;
import p258y1.C4224n0;

public abstract class Visibility extends Transition {

    public static final String[] f3816y = {"android:visibility:visibility", "android:visibility:parent"};

    public int f3817x;

    public Visibility() {
        this.f3817x = 3;
    }

    public static void m3075F(C4206e0 c4206e0) {
        int visibility = c4206e0.f14293b.getVisibility();
        HashMap map = c4206e0.f14292a;
        map.put("android:visibility:visibility", Integer.valueOf(visibility));
        View view = c4206e0.f14293b;
        map.put("android:visibility:parent", view.getParent());
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        map.put("android:visibility:screenLocation", iArr);
    }

    public static C4224n0 m3076G(C4206e0 c4206e0, C4206e0 c4206e1) {
        C4224n0 c4224n0 = new C4224n0();
        c4224n0.f14353a = false;
        c4224n0.f14354b = false;
        if (c4206e0 != null) {
            HashMap map = c4206e0.f14292a;
            if (map.containsKey("android:visibility:visibility")) {
                c4224n0.f14355c = ((Integer) map.get("android:visibility:visibility")).intValue();
                c4224n0.f14357e = (ViewGroup) map.get("android:visibility:parent");
            } else {
                c4224n0.f14355c = -1;
                c4224n0.f14357e = null;
            }
        } else {
            c4224n0.f14355c = -1;
            c4224n0.f14357e = null;
        }
        if (c4206e1 != null) {
            HashMap map2 = c4206e1.f14292a;
            if (map2.containsKey("android:visibility:visibility")) {
                c4224n0.f14356d = ((Integer) map2.get("android:visibility:visibility")).intValue();
                c4224n0.f14358f = (ViewGroup) map2.get("android:visibility:parent");
            } else {
                c4224n0.f14356d = -1;
                c4224n0.f14358f = null;
            }
        } else {
            c4224n0.f14356d = -1;
            c4224n0.f14358f = null;
        }
        if (c4206e0 != null && c4206e1 != null) {
            int i6 = c4224n0.f14355c;
            int i10 = c4224n0.f14356d;
            if (i6 == i10 && c4224n0.f14357e == c4224n0.f14358f) {
                return c4224n0;
            }
            if (i6 != i10) {
                if (i6 == 0) {
                    c4224n0.f14354b = false;
                    c4224n0.f14353a = true;
                } else if (i10 == 0) {
                    c4224n0.f14354b = true;
                    c4224n0.f14353a = true;
                }
            } else if (c4224n0.f14358f == null) {
                c4224n0.f14354b = false;
                c4224n0.f14353a = true;
            } else if (c4224n0.f14357e == null) {
                c4224n0.f14354b = true;
                c4224n0.f14353a = true;
            }
        } else if (c4206e0 == null && c4224n0.f14356d == 0) {
            c4224n0.f14354b = true;
            c4224n0.f14353a = true;
        } else if (c4206e1 == null && c4224n0.f14355c == 0) {
            c4224n0.f14354b = false;
            c4224n0.f14353a = true;
        }
        return c4224n0;
    }

    public Animator mo3038H(ViewGroup viewGroup, View view, C4206e0 c4206e0, C4206e0 c4206e1) {
        return null;
    }

    public Animator mo3039I(ViewGroup viewGroup, View view, C4206e0 c4206e0) {
        return null;
    }

    public final void m3077J(int i6) {
        if ((i6 & (-4)) != 0) {
            throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
        }
        this.f3817x = i6;
    }

    @Override
    public void mo3030c(C4206e0 c4206e0) {
        m3075F(c4206e0);
    }

    @Override
    public void mo3031f(C4206e0 c4206e0) {
        m3075F(c4206e0);
    }

    @Override
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Animator mo3032j(ViewGroup viewGroup, C4206e0 c4206e0, C4206e0 c4206e1) {
        View view;
        boolean z7;
        int i6;
        View view2;
        View view3;
        boolean z10;
        boolean zIsAttachedToWindow;
        boolean z11;
        int i10;
        ViewGroup viewGroup2;
        int iRound;
        Bitmap bitmapCreateBitmap;
        C4224n0 c4224n0M3076G = m3076G(c4206e0, c4206e1);
        if (!c4224n0M3076G.f14353a || (c4224n0M3076G.f14357e == null && c4224n0M3076G.f14358f == null)) {
            return null;
        }
        boolean z12 = false;
        if (c4224n0M3076G.f14354b) {
            if ((this.f3817x & 1) == 1 && c4206e1 != null) {
                View view4 = c4206e1.f14293b;
                if (c4206e0 == null) {
                    View view5 = (View) view4.getParent();
                }
                return mo3038H(viewGroup, view4, c4206e0, c4206e1);
            }
            return null;
        }
        int i11 = c4224n0M3076G.f14356d;
        if ((this.f3817x & 2) == 2 && c4206e0 != null) {
            View view6 = c4206e1 != null ? c4206e1.f14293b : null;
            View view7 = c4206e0.f14293b;
            View view8 = (View) view7.getTag(R.id.save_overlay_view);
            if (view8 != null) {
                i6 = i11;
                view3 = null;
                z12 = true;
            } else {
                if (view6 == null || view6.getParent() == null) {
                    if (view6 != null) {
                        view = null;
                        z7 = false;
                    } else {
                        view6 = null;
                        view = null;
                        z7 = true;
                    }
                } else if (i11 == 4 || view7 == view6) {
                    view = view6;
                    view6 = null;
                    z7 = false;
                } else {
                    view6 = null;
                    view = null;
                    z7 = true;
                }
                if (!z7) {
                    i6 = i11;
                    view2 = view;
                    view8 = view6;
                    view3 = view2;
                    z12 = false;
                } else if (view7.getParent() == null) {
                    i6 = i11;
                    view3 = view;
                    view8 = view7;
                } else {
                    if (view7.getParent() instanceof View) {
                        View view9 = (View) view7.getParent();
                        if (m3076G(m3061p(view9, true), m3060m(view9, true)).f14353a) {
                            i6 = i11;
                            view2 = view;
                            int id = view9.getId();
                            if (view9.getParent() == null && id != -1) {
                                viewGroup.findViewById(id);
                            }
                        } else {
                            boolean z13 = AbstractC4204d0.f14289a;
                            Matrix matrix = new Matrix();
                            matrix.setTranslate(-view9.getScrollX(), -view9.getScrollY());
                            C4212h0 c4212h0 = AbstractC4210g0.f14313a;
                            c4212h0.mo8262n(view7, matrix);
                            c4212h0.mo8263o(viewGroup, matrix);
                            RectF rectF = new RectF(0.0f, 0.0f, view7.getWidth(), view7.getHeight());
                            matrix.mapRect(rectF);
                            int iRound2 = Math.round(rectF.left);
                            int iRound3 = Math.round(rectF.top);
                            int iRound4 = Math.round(rectF.right);
                            int iRound5 = Math.round(rectF.bottom);
                            ImageView imageView = new ImageView(view7.getContext());
                            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                            if (AbstractC4204d0.f14289a) {
                                z10 = !view7.isAttachedToWindow();
                                if (viewGroup != null) {
                                    zIsAttachedToWindow = viewGroup.isAttachedToWindow();
                                }
                                z11 = AbstractC4204d0.f14290b;
                                if (z11 || !z10) {
                                    i10 = 0;
                                    viewGroup2 = null;
                                } else {
                                    if (zIsAttachedToWindow) {
                                        viewGroup2 = (ViewGroup) view7.getParent();
                                        int iIndexOfChild = viewGroup2.indexOfChild(view7);
                                        viewGroup.getOverlay().add(view7);
                                        i10 = iIndexOfChild;
                                    } else {
                                        i6 = i11;
                                        view2 = view;
                                        bitmapCreateBitmap = null;
                                    }
                                    if (bitmapCreateBitmap != null) {
                                        imageView.setImageBitmap(bitmapCreateBitmap);
                                    }
                                    imageView.measure(View.MeasureSpec.makeMeasureSpec(iRound4 - iRound2, 1073741824), View.MeasureSpec.makeMeasureSpec(iRound5 - iRound3, 1073741824));
                                    imageView.layout(iRound2, iRound3, iRound4, iRound5);
                                    view8 = imageView;
                                }
                                view2 = view;
                                iRound = Math.round(rectF.width());
                                i6 = i11;
                                int iRound6 = Math.round(rectF.height());
                                if (iRound > 0 || iRound6 <= 0) {
                                    bitmapCreateBitmap = null;
                                } else {
                                    float fMin = Math.min(1.0f, 1048576.0f / (iRound * iRound6));
                                    int iRound7 = Math.round(iRound * fMin);
                                    int iRound8 = Math.round(iRound6 * fMin);
                                    matrix.postTranslate(-rectF.left, -rectF.top);
                                    matrix.postScale(fMin, fMin);
                                    if (AbstractC4204d0.f14291c) {
                                        Picture picture = new Picture();
                                        Canvas canvasBeginRecording = picture.beginRecording(iRound7, iRound8);
                                        canvasBeginRecording.concat(matrix);
                                        view7.draw(canvasBeginRecording);
                                        picture.endRecording();
                                        bitmapCreateBitmap = Bitmap.createBitmap(picture);
                                    } else {
                                        bitmapCreateBitmap = Bitmap.createBitmap(iRound7, iRound8, Bitmap.Config.ARGB_8888);
                                        Canvas canvas = new Canvas(bitmapCreateBitmap);
                                        canvas.concat(matrix);
                                        view7.draw(canvas);
                                    }
                                }
                                if (z11 && z10) {
                                    viewGroup.getOverlay().remove(view7);
                                    viewGroup2.addView(view7, i10);
                                }
                                if (bitmapCreateBitmap != null) {
                                    imageView.setImageBitmap(bitmapCreateBitmap);
                                }
                                imageView.measure(View.MeasureSpec.makeMeasureSpec(iRound4 - iRound2, 1073741824), View.MeasureSpec.makeMeasureSpec(iRound5 - iRound3, 1073741824));
                                imageView.layout(iRound2, iRound3, iRound4, iRound5);
                                view8 = imageView;
                            } else {
                                z10 = false;
                            }
                            zIsAttachedToWindow = false;
                            z11 = AbstractC4204d0.f14290b;
                            if (z11) {
                                i10 = 0;
                                viewGroup2 = null;
                                view2 = view;
                                iRound = Math.round(rectF.width());
                                i6 = i11;
                                int iRound9 = Math.round(rectF.height());
                                if (iRound > 0) {
                                    bitmapCreateBitmap = null;
                                } else {
                                    bitmapCreateBitmap = null;
                                }
                                if (z11) {
                                    viewGroup.getOverlay().remove(view7);
                                    viewGroup2.addView(view7, i10);
                                }
                            } else {
                                i10 = 0;
                                viewGroup2 = null;
                                view2 = view;
                                iRound = Math.round(rectF.width());
                                i6 = i11;
                                int iRound10 = Math.round(rectF.height());
                                if (iRound > 0) {
                                    bitmapCreateBitmap = null;
                                } else {
                                    bitmapCreateBitmap = null;
                                }
                                if (z11) {
                                    viewGroup.getOverlay().remove(view7);
                                    viewGroup2.addView(view7, i10);
                                }
                            }
                            if (bitmapCreateBitmap != null) {
                                imageView.setImageBitmap(bitmapCreateBitmap);
                            }
                            imageView.measure(View.MeasureSpec.makeMeasureSpec(iRound4 - iRound2, 1073741824), View.MeasureSpec.makeMeasureSpec(iRound5 - iRound3, 1073741824));
                            imageView.layout(iRound2, iRound3, iRound4, iRound5);
                            view8 = imageView;
                        }
                        view3 = view2;
                        z12 = false;
                    } else {
                        i6 = i11;
                        view2 = view;
                    }
                    view8 = view6;
                    view3 = view2;
                    z12 = false;
                }
            }
            if (view8 != null) {
                if (!z12) {
                    int[] iArr = (int[]) c4206e0.f14292a.get("android:visibility:screenLocation");
                    int i12 = iArr[0];
                    int i13 = iArr[1];
                    int[] iArr2 = new int[2];
                    viewGroup.getLocationOnScreen(iArr2);
                    view8.offsetLeftAndRight((i12 - iArr2[0]) - view8.getLeft());
                    view8.offsetTopAndBottom((i13 - iArr2[1]) - view8.getTop());
                    viewGroup.getOverlay().add(view8);
                }
                Animator animatorMo3039I = mo3039I(viewGroup, view8, c4206e0);
                if (z12) {
                    return animatorMo3039I;
                }
                if (animatorMo3039I == null) {
                    viewGroup.getOverlay().remove(view8);
                    return animatorMo3039I;
                }
                view7.setTag(R.id.save_overlay_view, view8);
                m3052a(new C4220l0(this, viewGroup, view8, view7));
                return animatorMo3039I;
            }
            if (view3 != null) {
                int visibility = view3.getVisibility();
                AbstractC4210g0.m8258c(0, view3);
                Animator animatorMo3039I2 = mo3039I(viewGroup, view3, c4206e0);
                if (animatorMo3039I2 != null) {
                    C4222m0 c4222m0 = new C4222m0(view3, i6);
                    animatorMo3039I2.addListener(c4222m0);
                    animatorMo3039I2.addPauseListener(c4222m0);
                    m3052a(c4222m0);
                } else {
                    AbstractC4210g0.m8258c(visibility, view3);
                }
                return animatorMo3039I2;
            }
        }
        return null;
    }

    @Override
    public final String[] mo3033o() {
        return f3816y;
    }

    @Override
    public final boolean mo3062q(C4206e0 c4206e0, C4206e0 c4206e1) {
        if (c4206e0 == null && c4206e1 == null) {
            return false;
        }
        if (c4206e0 != null && c4206e1 != null && c4206e1.f14292a.containsKey("android:visibility:visibility") != c4206e0.f14292a.containsKey("android:visibility:visibility")) {
            return false;
        }
        C4224n0 c4224n0M3076G = m3076G(c4206e0, c4206e1);
        if (c4224n0M3076G.f14353a) {
            return c4224n0M3076G.f14355c == 0 || c4224n0M3076G.f14356d == 0;
        }
        return false;
    }

    @SuppressLint({"RestrictedApi"})
    public Visibility(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3817x = 3;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC4233v.f14373c);
        int iM5317c = AbstractC2343b.m5317c(typedArrayObtainStyledAttributes, (XmlResourceParser) attributeSet, "transitionVisibilityMode", 0, 0);
        typedArrayObtainStyledAttributes.recycle();
        if (iM5317c != 0) {
            m3077J(iM5317c);
        }
    }
}
