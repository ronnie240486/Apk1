package androidx.leanback.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;

public abstract class AbstractC0448a0 {

    public static final Rect f2309a = new Rect();

    public static int m1404a(View view, C0508z c0508z, int i6) {
        View viewFindViewById;
        int height;
        int width;
        int width2;
        int width3;
        C0496t c0496t = (C0496t) view.getLayoutParams();
        int i10 = c0508z.f2452a;
        if (i10 == 0 || (viewFindViewById = view.findViewById(i10)) == null) {
            viewFindViewById = view;
        }
        int paddingBottom = c0508z.f2453b;
        Rect rect = f2309a;
        if (i6 != 0) {
            if (c0508z.f2455d) {
                float f = c0508z.f2454c;
                if (f == 0.0f) {
                    paddingBottom += viewFindViewById.getPaddingTop();
                } else if (f == 100.0f) {
                    paddingBottom -= viewFindViewById.getPaddingBottom();
                }
            }
            if (c0508z.f2454c != -1.0f) {
                if (viewFindViewById == view) {
                    c0496t.getClass();
                    height = (viewFindViewById.getHeight() - c0496t.f2438f) - c0496t.f2440h;
                } else {
                    height = viewFindViewById.getHeight();
                }
                paddingBottom += (int) ((height * c0508z.f2454c) / 100.0f);
            }
            if (view == viewFindViewById) {
                return paddingBottom;
            }
            rect.top = paddingBottom;
            ((ViewGroup) view).offsetDescendantRectToMyCoords(viewFindViewById, rect);
            return rect.top - c0496t.f2438f;
        }
        if (view.getLayoutDirection() != 1) {
            if (c0508z.f2455d) {
                float f3 = c0508z.f2454c;
                if (f3 == 0.0f) {
                    paddingBottom += viewFindViewById.getPaddingLeft();
                } else if (f3 == 100.0f) {
                    paddingBottom -= viewFindViewById.getPaddingRight();
                }
            }
            if (c0508z.f2454c != -1.0f) {
                if (viewFindViewById == view) {
                    c0496t.getClass();
                    width = (viewFindViewById.getWidth() - c0496t.f2437e) - c0496t.f2439g;
                } else {
                    width = viewFindViewById.getWidth();
                }
                paddingBottom += (int) ((width * c0508z.f2454c) / 100.0f);
            }
            int i11 = paddingBottom;
            if (view == viewFindViewById) {
                return i11;
            }
            rect.left = i11;
            ((ViewGroup) view).offsetDescendantRectToMyCoords(viewFindViewById, rect);
            return rect.left - c0496t.f2437e;
        }
        if (viewFindViewById == view) {
            c0496t.getClass();
            width2 = (viewFindViewById.getWidth() - c0496t.f2437e) - c0496t.f2439g;
        } else {
            width2 = viewFindViewById.getWidth();
        }
        int paddingLeft = width2 - paddingBottom;
        if (c0508z.f2455d) {
            float f4 = c0508z.f2454c;
            if (f4 == 0.0f) {
                paddingLeft -= viewFindViewById.getPaddingRight();
            } else if (f4 == 100.0f) {
                paddingLeft += viewFindViewById.getPaddingLeft();
            }
        }
        if (c0508z.f2454c != -1.0f) {
            if (viewFindViewById == view) {
                c0496t.getClass();
                width3 = (viewFindViewById.getWidth() - c0496t.f2437e) - c0496t.f2439g;
            } else {
                width3 = viewFindViewById.getWidth();
            }
            paddingLeft -= (int) ((width3 * c0508z.f2454c) / 100.0f);
        }
        if (view == viewFindViewById) {
            return paddingLeft;
        }
        rect.right = paddingLeft;
        ((ViewGroup) view).offsetDescendantRectToMyCoords(viewFindViewById, rect);
        return rect.right + c0496t.f2439g;
    }
}
