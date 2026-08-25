package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.core.widget.ViewOnTouchListenerC0375h;
import com.p2serv.android.p032ds.R;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import p000a.RunnableC0005f;
import p065g0.AbstractC2581a;
import p094j0.AbstractC2754b;

public class C0267s1 extends ListView {

    public final Rect f1051a;

    public int f1052b;

    public int f1053c;

    public int f1054d;

    public int f1055e;

    public int f1056f;

    public C0257q1 f1057g;

    public boolean f1058h;

    public final boolean f1059i;

    public boolean f1060j;

    public ViewOnTouchListenerC0375h f1061k;

    public RunnableC0005f f1062l;

    public C0267s1(Context context, boolean z7) {
        super(context, null, R.attr.dropDownListViewStyle);
        this.f1051a = new Rect();
        this.f1052b = 0;
        this.f1053c = 0;
        this.f1054d = 0;
        this.f1055e = 0;
        this.f1059i = z7;
        setCacheColorHint(0);
    }

    public final int m769a(int i6, int i10) {
        int listPaddingTop = getListPaddingTop();
        int listPaddingBottom = getListPaddingBottom();
        int dividerHeight = getDividerHeight();
        Drawable divider = getDivider();
        ListAdapter adapter = getAdapter();
        if (adapter == null) {
            return listPaddingTop + listPaddingBottom;
        }
        int measuredHeight = listPaddingTop + listPaddingBottom;
        if (dividerHeight <= 0 || divider == null) {
            dividerHeight = 0;
        }
        int count = adapter.getCount();
        View view = null;
        int i11 = 0;
        for (int i12 = 0; i12 < count; i12++) {
            int itemViewType = adapter.getItemViewType(i12);
            if (itemViewType != i11) {
                view = null;
                i11 = itemViewType;
            }
            view = adapter.getView(i12, view, this);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
                view.setLayoutParams(layoutParams);
            }
            int i13 = layoutParams.height;
            view.measure(i6, i13 > 0 ? View.MeasureSpec.makeMeasureSpec(i13, 1073741824) : View.MeasureSpec.makeMeasureSpec(0, 0));
            view.forceLayout();
            if (i12 > 0) {
                measuredHeight += dividerHeight;
            }
            measuredHeight += view.getMeasuredHeight();
            if (measuredHeight >= i10) {
                return i10;
            }
        }
        return measuredHeight;
    }

    public final boolean m770b(MotionEvent motionEvent, int i6) {
        boolean z7;
        boolean zM741a;
        View childAt;
        View childAt2;
        ViewOnTouchListenerC0375h viewOnTouchListenerC0375h;
        int actionMasked = motionEvent.getActionMasked();
        boolean z10 = false;
        if (actionMasked != 1) {
            if (actionMasked == 2) {
                z7 = true;
            } else if (actionMasked != 3) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (z7 || z10) {
                this.f1060j = false;
                setPressed(false);
                drawableStateChanged();
                childAt2 = getChildAt(this.f1056f - getFirstVisiblePosition());
                if (childAt2 != null) {
                    childAt2.setPressed(false);
                }
            }
            if (z7) {
                if (this.f1061k == null) {
                    this.f1061k = new ViewOnTouchListenerC0375h(this);
                }
                ViewOnTouchListenerC0375h viewOnTouchListenerC0375h2 = this.f1061k;
                boolean z11 = viewOnTouchListenerC0375h2.f1679p;
                viewOnTouchListenerC0375h2.f1679p = true;
                viewOnTouchListenerC0375h2.onTouch(this, motionEvent);
            } else {
                viewOnTouchListenerC0375h = this.f1061k;
                if (viewOnTouchListenerC0375h != null) {
                    if (viewOnTouchListenerC0375h.f1679p) {
                        viewOnTouchListenerC0375h.m1133d();
                    }
                    viewOnTouchListenerC0375h.f1679p = false;
                }
            }
            return z7;
        }
        z7 = false;
        int iFindPointerIndex = motionEvent.findPointerIndex(i6);
        if (iFindPointerIndex < 0) {
            z7 = false;
        } else {
            int x10 = (int) motionEvent.getX(iFindPointerIndex);
            int y7 = (int) motionEvent.getY(iFindPointerIndex);
            int iPointToPosition = pointToPosition(x10, y7);
            if (iPointToPosition == -1) {
                z10 = true;
            } else {
                View childAt3 = getChildAt(iPointToPosition - getFirstVisiblePosition());
                float f = x10;
                float f3 = y7;
                this.f1060j = true;
                AbstractC0242n1.m738a(this, f, f3);
                if (!isPressed()) {
                    setPressed(true);
                }
                layoutChildren();
                int i10 = this.f1056f;
                if (i10 != -1 && (childAt = getChildAt(i10 - getFirstVisiblePosition())) != null && childAt != childAt3 && childAt.isPressed()) {
                    childAt.setPressed(false);
                }
                this.f1056f = iPointToPosition;
                AbstractC0242n1.m738a(childAt3, f - childAt3.getLeft(), f3 - childAt3.getTop());
                if (!childAt3.isPressed()) {
                    childAt3.setPressed(true);
                }
                Drawable selector = getSelector();
                boolean z12 = (selector == null || iPointToPosition == -1) ? false : true;
                if (z12) {
                    selector.setVisible(false, false);
                }
                int left = childAt3.getLeft();
                int top = childAt3.getTop();
                int right = childAt3.getRight();
                int bottom = childAt3.getBottom();
                Rect rect = this.f1051a;
                rect.set(left, top, right, bottom);
                rect.left -= this.f1052b;
                rect.top -= this.f1053c;
                rect.right += this.f1054d;
                rect.bottom += this.f1055e;
                if (AbstractC2754b.m5721a()) {
                    zM741a = AbstractC0252p1.m741a(this);
                } else {
                    Field field = AbstractC0262r1.f1047a;
                    if (field != null) {
                        try {
                            zM741a = field.getBoolean(this);
                        } catch (IllegalAccessException e5) {
                            e5.printStackTrace();
                            zM741a = false;
                        }
                    } else {
                        zM741a = false;
                    }
                }
                if (childAt3.isEnabled() != zM741a) {
                    boolean z13 = !zM741a;
                    if (AbstractC2754b.m5721a()) {
                        AbstractC0252p1.m742b(this, z13);
                    } else {
                        Field field2 = AbstractC0262r1.f1047a;
                        if (field2 != null) {
                            try {
                                field2.set(this, Boolean.valueOf(z13));
                            } catch (IllegalAccessException e10) {
                                e10.printStackTrace();
                            }
                        }
                    }
                    if (iPointToPosition != -1) {
                        refreshDrawableState();
                    }
                }
                if (z12) {
                    float fExactCenterX = rect.exactCenterX();
                    float fExactCenterY = rect.exactCenterY();
                    selector.setVisible(getVisibility() == 0, false);
                    AbstractC2581a.m5583e(selector, fExactCenterX, fExactCenterY);
                }
                Drawable selector2 = getSelector();
                if (selector2 != null && iPointToPosition != -1) {
                    AbstractC2581a.m5583e(selector2, f, f3);
                }
                C0257q1 c0257q1 = this.f1057g;
                if (c0257q1 != null) {
                    c0257q1.f1037b = false;
                }
                refreshDrawableState();
                if (actionMasked == 1) {
                    performItemClick(childAt3, iPointToPosition, getItemIdAtPosition(iPointToPosition));
                }
                z7 = true;
                z10 = false;
            }
        }
        if (z7) {
            this.f1060j = false;
            setPressed(false);
            drawableStateChanged();
            childAt2 = getChildAt(this.f1056f - getFirstVisiblePosition());
            if (childAt2 != null) {
                childAt2.setPressed(false);
            }
        } else {
            this.f1060j = false;
            setPressed(false);
            drawableStateChanged();
            childAt2 = getChildAt(this.f1056f - getFirstVisiblePosition());
            if (childAt2 != null) {
                childAt2.setPressed(false);
            }
        }
        if (z7) {
            if (this.f1061k == null) {
                this.f1061k = new ViewOnTouchListenerC0375h(this);
            }
            ViewOnTouchListenerC0375h viewOnTouchListenerC0375h3 = this.f1061k;
            boolean z14 = viewOnTouchListenerC0375h3.f1679p;
            viewOnTouchListenerC0375h3.f1679p = true;
            viewOnTouchListenerC0375h3.onTouch(this, motionEvent);
        } else {
            viewOnTouchListenerC0375h = this.f1061k;
            if (viewOnTouchListenerC0375h != null) {
                if (viewOnTouchListenerC0375h.f1679p) {
                    viewOnTouchListenerC0375h.m1133d();
                }
                viewOnTouchListenerC0375h.f1679p = false;
            }
        }
        return z7;
    }

    @Override
    public final void dispatchDraw(Canvas canvas) {
        Drawable selector;
        Rect rect = this.f1051a;
        if (!rect.isEmpty() && (selector = getSelector()) != null) {
            selector.setBounds(rect);
            selector.draw(canvas);
        }
        super.dispatchDraw(canvas);
    }

    @Override
    public final void drawableStateChanged() {
        if (this.f1062l != null) {
            return;
        }
        super.drawableStateChanged();
        C0257q1 c0257q1 = this.f1057g;
        if (c0257q1 != null) {
            c0257q1.f1037b = true;
        }
        Drawable selector = getSelector();
        if (selector != null && this.f1060j && isPressed()) {
            selector.setState(getDrawableState());
        }
    }

    @Override
    public final boolean hasFocus() {
        return this.f1059i || super.hasFocus();
    }

    @Override
    public final boolean hasWindowFocus() {
        return this.f1059i || super.hasWindowFocus();
    }

    @Override
    public final boolean isFocused() {
        return this.f1059i || super.isFocused();
    }

    @Override
    public final boolean isInTouchMode() {
        return (this.f1059i && this.f1058h) || super.isInTouchMode();
    }

    @Override
    public final void onDetachedFromWindow() {
        this.f1062l = null;
        super.onDetachedFromWindow();
    }

    @Override
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int i6 = 2;
        int i10 = Build.VERSION.SDK_INT;
        if (i10 < 26) {
            return super.onHoverEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 10 && this.f1062l == null) {
            RunnableC0005f runnableC0005f = new RunnableC0005f(i6, this);
            this.f1062l = runnableC0005f;
            post(runnableC0005f);
        }
        boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
        if (actionMasked == 9 || actionMasked == 7) {
            int iPointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
            if (iPointToPosition != -1 && iPointToPosition != getSelectedItemPosition()) {
                View childAt = getChildAt(iPointToPosition - getFirstVisiblePosition());
                if (childAt.isEnabled()) {
                    requestFocus();
                    if (i10 < 30 || !AbstractC0247o1.f1024d) {
                        setSelectionFromTop(iPointToPosition, childAt.getTop() - getTop());
                    } else {
                        try {
                            AbstractC0247o1.f1021a.invoke(this, Integer.valueOf(iPointToPosition), childAt, Boolean.FALSE, -1, -1);
                            AbstractC0247o1.f1022b.invoke(this, Integer.valueOf(iPointToPosition));
                            AbstractC0247o1.f1023c.invoke(this, Integer.valueOf(iPointToPosition));
                        } catch (IllegalAccessException e5) {
                            e5.printStackTrace();
                        } catch (InvocationTargetException e10) {
                            e10.printStackTrace();
                        }
                    }
                }
                Drawable selector = getSelector();
                if (selector != null && this.f1060j && isPressed()) {
                    selector.setState(getDrawableState());
                }
            }
        } else {
            setSelection(-1);
        }
        return zOnHoverEvent;
    }

    @Override
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f1056f = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        RunnableC0005f runnableC0005f = this.f1062l;
        if (runnableC0005f != null) {
            C0267s1 c0267s1 = (C0267s1) runnableC0005f.f6b;
            c0267s1.f1062l = null;
            c0267s1.removeCallbacks(runnableC0005f);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setListSelectionHidden(boolean z7) {
        this.f1058h = z7;
    }

    @Override
    public void setSelector(Drawable drawable) {
        C0257q1 c0257q1 = null;
        if (drawable != null) {
            C0257q1 c0257q2 = new C0257q1();
            Drawable drawable2 = c0257q2.f1036a;
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            c0257q2.f1036a = drawable;
            drawable.setCallback(c0257q2);
            c0257q2.f1037b = true;
            c0257q1 = c0257q2;
        }
        this.f1057g = c0257q1;
        super.setSelector(c0257q1);
        Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.f1052b = rect.left;
        this.f1053c = rect.top;
        this.f1054d = rect.right;
        this.f1055e = rect.bottom;
    }
}
