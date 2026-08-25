package androidx.appcompat.widget;

import android.R;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Shader;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Build;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.AbsSeekBar;
import android.widget.EditText;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import p001a0.C0019b;
import p002a1.C0026b;
import p003a2.AbstractC0032a;
import p007a7.C0069f;
import p014b1.C1235i;
import p035d1.C2124b;
import p035d1.C2127e;
import p035d1.C2130h;
import p045e.AbstractC2341a;
import p065g0.C2590j;
import p065g0.InterfaceC2589i;

public class C0179b0 {

    public static final int[] f870d = {R.attr.indeterminateDrawable, R.attr.progressDrawable};

    public final int f871a = 2;

    public View f872b;

    public Object f873c;

    public C0179b0() {
    }

    public KeyListener m639a(KeyListener keyListener) {
        if (keyListener instanceof NumberKeyListener) {
            return keyListener;
        }
        ((C0069f) ((C0019b) this.f873c).f38b).getClass();
        if (keyListener instanceof C2127e) {
            return keyListener;
        }
        if (keyListener == null) {
            return null;
        }
        return keyListener instanceof NumberKeyListener ? keyListener : new C2127e(keyListener);
    }

    public void mo640b(AttributeSet attributeSet, int i6) {
        switch (this.f871a) {
            case 0:
                AbsSeekBar absSeekBar = (AbsSeekBar) this.f872b;
                C0026b c0026bM111C = C0026b.m111C(absSeekBar.getContext(), attributeSet, f870d, i6);
                Drawable drawableM141u = c0026bM111C.m141u(0);
                if (drawableM141u != null) {
                    if (drawableM141u instanceof AnimationDrawable) {
                        AnimationDrawable animationDrawable = (AnimationDrawable) drawableM141u;
                        int numberOfFrames = animationDrawable.getNumberOfFrames();
                        AnimationDrawable animationDrawable2 = new AnimationDrawable();
                        animationDrawable2.setOneShot(animationDrawable.isOneShot());
                        for (int i10 = 0; i10 < numberOfFrames; i10++) {
                            Drawable drawableM643e = m643e(animationDrawable.getFrame(i10), true);
                            drawableM643e.setLevel(10000);
                            animationDrawable2.addFrame(drawableM643e, animationDrawable.getDuration(i10));
                        }
                        animationDrawable2.setLevel(10000);
                        drawableM141u = animationDrawable2;
                    }
                    absSeekBar.setIndeterminateDrawable(drawableM141u);
                }
                Drawable drawableM141u2 = c0026bM111C.m141u(1);
                if (drawableM141u2 != null) {
                    absSeekBar.setProgressDrawable(m643e(drawableM141u2, false));
                }
                c0026bM111C.m120F();
                return;
            default:
                TypedArray typedArrayObtainStyledAttributes = ((EditText) this.f872b).getContext().obtainStyledAttributes(attributeSet, AbstractC2341a.f8162j, i6, 0);
                try {
                    boolean z7 = true;
                    if (typedArrayObtainStyledAttributes.hasValue(14)) {
                        z7 = typedArrayObtainStyledAttributes.getBoolean(14, true);
                        break;
                    }
                    typedArrayObtainStyledAttributes.recycle();
                    m642d(z7);
                    return;
                } catch (Throwable th) {
                    typedArrayObtainStyledAttributes.recycle();
                    throw th;
                }
        }
    }

    public C2124b m641c(InputConnection inputConnection, EditorInfo editorInfo) {
        C0019b c0019b = (C0019b) this.f873c;
        if (inputConnection == null) {
            c0019b.getClass();
            inputConnection = null;
        } else {
            C0069f c0069f = (C0069f) c0019b.f38b;
            c0069f.getClass();
            if (!(inputConnection instanceof C2124b)) {
                inputConnection = new C2124b((EditText) c0069f.f196b, inputConnection, editorInfo);
            }
        }
        return (C2124b) inputConnection;
    }

    public void m642d(boolean z7) {
        C2130h c2130h = (C2130h) ((C0069f) ((C0019b) this.f873c).f38b).f197c;
        if (c2130h.f7746c != z7) {
            if (c2130h.f7745b != null) {
                C1235i c1235iM3106a = C1235i.m3106a();
                C0219i3 c0219i3 = c2130h.f7745b;
                c1235iM3106a.getClass();
                AbstractC0032a.m162p(c0219i3, "initCallback cannot be null");
                ReentrantReadWriteLock reentrantReadWriteLock = c1235iM3106a.f3924a;
                reentrantReadWriteLock.writeLock().lock();
                try {
                    c1235iM3106a.f3925b.remove(c0219i3);
                    reentrantReadWriteLock.writeLock().unlock();
                } catch (Throwable th) {
                    reentrantReadWriteLock.writeLock().unlock();
                    throw th;
                }
            }
            c2130h.f7746c = z7;
            if (z7) {
                C2130h.m5080a(c2130h.f7744a, C1235i.m3106a().m3107b());
            }
        }
    }

    public Drawable m643e(Drawable drawable, boolean z7) {
        if (drawable instanceof InterfaceC2589i) {
            C2590j c2590j = (C2590j) ((InterfaceC2589i) drawable);
            Drawable drawable2 = c2590j.f9035f;
            if (drawable2 != null) {
                c2590j.m5612h(m643e(drawable2, z7));
            }
        } else {
            if (drawable instanceof LayerDrawable) {
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                int numberOfLayers = layerDrawable.getNumberOfLayers();
                Drawable[] drawableArr = new Drawable[numberOfLayers];
                for (int i6 = 0; i6 < numberOfLayers; i6++) {
                    int id = layerDrawable.getId(i6);
                    drawableArr[i6] = m643e(layerDrawable.getDrawable(i6), id == 16908301 || id == 16908303);
                }
                LayerDrawable layerDrawable2 = new LayerDrawable(drawableArr);
                for (int i10 = 0; i10 < numberOfLayers; i10++) {
                    layerDrawable2.setId(i10, layerDrawable.getId(i10));
                    if (Build.VERSION.SDK_INT >= 23) {
                        AbstractC0173a0.m635b(layerDrawable, layerDrawable2, i10);
                    }
                }
                return layerDrawable2;
            }
            if (drawable instanceof BitmapDrawable) {
                BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
                Bitmap bitmap = bitmapDrawable.getBitmap();
                if (((Bitmap) this.f873c) == null) {
                    this.f873c = bitmap;
                }
                ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f}, null, null));
                shapeDrawable.getPaint().setShader(new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.CLAMP));
                shapeDrawable.getPaint().setColorFilter(bitmapDrawable.getPaint().getColorFilter());
                return z7 ? new ClipDrawable(shapeDrawable, 3, 1) : shapeDrawable;
            }
        }
        return drawable;
    }

    public C0179b0(AbsSeekBar absSeekBar) {
        this.f872b = absSeekBar;
    }

    public C0179b0(EditText editText) {
        this.f872b = editText;
        this.f873c = new C0019b(editText);
    }
}
