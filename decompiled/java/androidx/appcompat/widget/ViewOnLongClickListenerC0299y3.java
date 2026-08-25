package androidx.appcompat.widget;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.widget.TextView;
import androidx.media3.common.C0565C;
import com.p2serv.android.p032ds.R;
import java.lang.reflect.Method;
import java.util.WeakHashMap;
import p000a.AbstractC0004e;
import p138n0.AbstractC3155s0;
import p138n0.AbstractC3161u0;
import p138n0.AbstractC3167w0;

public final class ViewOnLongClickListenerC0299y3 implements View.OnLongClickListener, View.OnHoverListener, View.OnAttachStateChangeListener {

    public static ViewOnLongClickListenerC0299y3 f1136k;

    public static ViewOnLongClickListenerC0299y3 f1137l;

    public final View f1138a;

    public final CharSequence f1139b;

    public final int f1140c;

    public final RunnableC0294x3 f1141d;

    public final RunnableC0294x3 f1142e;

    public int f1143f;

    public int f1144g;

    public C0304z3 f1145h;

    public boolean f1146i;

    public boolean f1147j;

    public ViewOnLongClickListenerC0299y3(View view, CharSequence charSequence) {
        final int i6 = 0;
        this.f1141d = new Runnable(this) {

            public final ViewOnLongClickListenerC0299y3 f1133b;

            {
                this.f1133b = this;
            }

            @Override
            public final void run() {
                switch (i6) {
                    case 0:
                        this.f1133b.m836c(false);
                        break;
                    default:
                        this.f1133b.m835a();
                        break;
                }
            }
        };
        final int i10 = 1;
        this.f1142e = new Runnable(this) {

            public final ViewOnLongClickListenerC0299y3 f1133b;

            {
                this.f1133b = this;
            }

            @Override
            public final void run() {
                switch (i10) {
                    case 0:
                        this.f1133b.m836c(false);
                        break;
                    default:
                        this.f1133b.m835a();
                        break;
                }
            }
        };
        this.f1138a = view;
        this.f1139b = charSequence;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(view.getContext());
        Method method = AbstractC3167w0.f10655a;
        this.f1140c = Build.VERSION.SDK_INT >= 28 ? AbstractC3161u0.m6355a(viewConfiguration) : viewConfiguration.getScaledTouchSlop() / 2;
        this.f1147j = true;
        view.setOnLongClickListener(this);
        view.setOnHoverListener(this);
    }

    public static void m834b(ViewOnLongClickListenerC0299y3 viewOnLongClickListenerC0299y3) {
        ViewOnLongClickListenerC0299y3 viewOnLongClickListenerC0299y4 = f1136k;
        if (viewOnLongClickListenerC0299y4 != null) {
            viewOnLongClickListenerC0299y4.f1138a.removeCallbacks(viewOnLongClickListenerC0299y4.f1141d);
        }
        f1136k = viewOnLongClickListenerC0299y3;
        if (viewOnLongClickListenerC0299y3 != null) {
            viewOnLongClickListenerC0299y3.f1138a.postDelayed(viewOnLongClickListenerC0299y3.f1141d, ViewConfiguration.getLongPressTimeout());
        }
    }

    public final void m835a() {
        ViewOnLongClickListenerC0299y3 viewOnLongClickListenerC0299y3 = f1137l;
        View view = this.f1138a;
        if (viewOnLongClickListenerC0299y3 == this) {
            f1137l = null;
            C0304z3 c0304z3 = this.f1145h;
            if (c0304z3 != null) {
                View view2 = (View) c0304z3.f1156b;
                if (view2.getParent() != null) {
                    ((WindowManager) ((Context) c0304z3.f1155a).getSystemService("window")).removeView(view2);
                }
                this.f1145h = null;
                this.f1147j = true;
                view.removeOnAttachStateChangeListener(this);
            } else {
                Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
            }
        }
        if (f1136k == this) {
            m834b(null);
        }
        view.removeCallbacks(this.f1142e);
    }

    public final void m836c(boolean z7) {
        int height;
        int i6;
        int i10;
        long longPressTimeout;
        long j10;
        long j11;
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        View view = this.f1138a;
        if (view.isAttachedToWindow()) {
            m834b(null);
            ViewOnLongClickListenerC0299y3 viewOnLongClickListenerC0299y3 = f1137l;
            if (viewOnLongClickListenerC0299y3 != null) {
                viewOnLongClickListenerC0299y3.m835a();
            }
            f1137l = this;
            this.f1146i = z7;
            Context context = view.getContext();
            C0304z3 c0304z3 = new C0304z3();
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            c0304z3.f1158d = layoutParams;
            c0304z3.f1159e = new Rect();
            c0304z3.f1160f = new int[2];
            c0304z3.f1161g = new int[2];
            c0304z3.f1155a = context;
            View viewInflate = LayoutInflater.from(context).inflate(R.layout.abc_tooltip, (ViewGroup) null);
            c0304z3.f1156b = viewInflate;
            c0304z3.f1157c = (TextView) viewInflate.findViewById(R.id.message);
            layoutParams.setTitle(C0304z3.class.getSimpleName());
            layoutParams.packageName = context.getPackageName();
            layoutParams.type = 1002;
            layoutParams.width = -2;
            layoutParams.height = -2;
            layoutParams.format = -3;
            layoutParams.windowAnimations = R.style.Animation_AppCompat_Tooltip;
            layoutParams.flags = 24;
            this.f1145h = c0304z3;
            int width = this.f1143f;
            int i11 = this.f1144g;
            boolean z10 = this.f1146i;
            View view2 = (View) c0304z3.f1156b;
            ViewParent parent = view2.getParent();
            Context context2 = (Context) c0304z3.f1155a;
            if (parent != null && view2.getParent() != null) {
                ((WindowManager) context2.getSystemService("window")).removeView(view2);
            }
            ((TextView) c0304z3.f1157c).setText(this.f1139b);
            WindowManager.LayoutParams layoutParams2 = (WindowManager.LayoutParams) c0304z3.f1158d;
            layoutParams2.token = view.getApplicationWindowToken();
            int dimensionPixelOffset = context2.getResources().getDimensionPixelOffset(R.dimen.tooltip_precise_anchor_threshold);
            if (view.getWidth() < dimensionPixelOffset) {
                width = view.getWidth() / 2;
            }
            if (view.getHeight() >= dimensionPixelOffset) {
                int dimensionPixelOffset2 = context2.getResources().getDimensionPixelOffset(R.dimen.tooltip_precise_anchor_extra_offset);
                height = i11 + dimensionPixelOffset2;
                i6 = i11 - dimensionPixelOffset2;
            } else {
                height = view.getHeight();
                i6 = 0;
            }
            layoutParams2.gravity = 49;
            int dimensionPixelOffset3 = context2.getResources().getDimensionPixelOffset(z10 ? R.dimen.tooltip_y_offset_touch : R.dimen.tooltip_y_offset_non_touch);
            View rootView = view.getRootView();
            ViewGroup.LayoutParams layoutParams3 = rootView.getLayoutParams();
            if (!(layoutParams3 instanceof WindowManager.LayoutParams) || ((WindowManager.LayoutParams) layoutParams3).type != 2) {
                for (Context context3 = view.getContext(); context3 instanceof ContextWrapper; context3 = ((ContextWrapper) context3).getBaseContext()) {
                    if (context3 instanceof Activity) {
                        rootView = ((Activity) context3).getWindow().getDecorView();
                        break;
                    }
                }
            }
            if (rootView == null) {
                Log.e("TooltipPopup", "Cannot find app view");
            } else {
                Rect rect = (Rect) c0304z3.f1159e;
                rootView.getWindowVisibleDisplayFrame(rect);
                if (rect.left >= 0 || rect.top >= 0) {
                    i10 = 0;
                } else {
                    Resources resources = context2.getResources();
                    int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
                    int dimensionPixelSize = identifier != 0 ? resources.getDimensionPixelSize(identifier) : 0;
                    DisplayMetrics displayMetrics = resources.getDisplayMetrics();
                    i10 = 0;
                    rect.set(0, dimensionPixelSize, displayMetrics.widthPixels, displayMetrics.heightPixels);
                }
                int[] iArr = (int[]) c0304z3.f1161g;
                rootView.getLocationOnScreen(iArr);
                int[] iArr2 = (int[]) c0304z3.f1160f;
                view.getLocationOnScreen(iArr2);
                int i12 = iArr2[i10] - iArr[i10];
                iArr2[i10] = i12;
                iArr2[1] = iArr2[1] - iArr[1];
                layoutParams2.x = (i12 + width) - (rootView.getWidth() / 2);
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i10, i10);
                view2.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                int measuredHeight = view2.getMeasuredHeight();
                int i13 = iArr2[1];
                int iM13g = AbstractC0004e.m13g(i13, i6, dimensionPixelOffset3, measuredHeight);
                int i14 = i13 + height + dimensionPixelOffset3;
                if (z10) {
                    if (iM13g >= 0) {
                        layoutParams2.y = iM13g;
                    } else {
                        layoutParams2.y = i14;
                    }
                } else if (measuredHeight + i14 <= rect.height()) {
                    layoutParams2.y = i14;
                } else {
                    layoutParams2.y = iM13g;
                }
            }
            ((WindowManager) context2.getSystemService("window")).addView(view2, layoutParams2);
            view.addOnAttachStateChangeListener(this);
            if (this.f1146i) {
                j11 = 2500;
            } else {
                if ((view.getWindowSystemUiVisibility() & 1) == 1) {
                    longPressTimeout = ViewConfiguration.getLongPressTimeout();
                    j10 = C0565C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS;
                } else {
                    longPressTimeout = ViewConfiguration.getLongPressTimeout();
                    j10 = C0565C.DEFAULT_SEEK_FORWARD_INCREMENT_MS;
                }
                j11 = j10 - longPressTimeout;
            }
            RunnableC0294x3 runnableC0294x3 = this.f1142e;
            view.removeCallbacks(runnableC0294x3);
            view.postDelayed(runnableC0294x3, j11);
        }
    }

    @Override
    public final boolean onHover(View view, MotionEvent motionEvent) {
        if (this.f1145h != null && this.f1146i) {
            return false;
        }
        View view2 = this.f1138a;
        AccessibilityManager accessibilityManager = (AccessibilityManager) view2.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 7) {
            if (action == 10) {
                this.f1147j = true;
                m835a();
            }
        } else if (view2.isEnabled() && this.f1145h == null) {
            int x10 = (int) motionEvent.getX();
            int y7 = (int) motionEvent.getY();
            if (this.f1147j) {
                this.f1143f = x10;
                this.f1144g = y7;
                this.f1147j = false;
                m834b(this);
            } else {
                int iAbs = Math.abs(x10 - this.f1143f);
                int i6 = this.f1140c;
                if (iAbs > i6 || Math.abs(y7 - this.f1144g) > i6) {
                    this.f1143f = x10;
                    this.f1144g = y7;
                    this.f1147j = false;
                    m834b(this);
                }
            }
        }
        return false;
    }

    @Override
    public final boolean onLongClick(View view) {
        this.f1143f = view.getWidth() / 2;
        this.f1144g = view.getHeight() / 2;
        m836c(true);
        return true;
    }

    @Override
    public final void onViewDetachedFromWindow(View view) {
        m835a();
    }

    @Override
    public final void onViewAttachedToWindow(View view) {
    }
}
