package androidx.appcompat.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import com.p2serv.android.p032ds.R;
import java.lang.ref.WeakReference;
import p045e.AbstractC2341a;

public final class C0136h {

    public final Context f357a;

    public final DialogInterfaceC0140j f358b;

    public final Window f359c;

    public CharSequence f360d;

    public AlertController$RecycleListView f361e;

    public View f362f;

    public Button f364h;

    public Button f365i;

    public Button f366j;

    public NestedScrollView f367k;

    public Drawable f368l;

    public ImageView f369m;

    public TextView f370n;

    public TextView f371o;

    public View f372p;

    public ListAdapter f373q;

    public final int f375s;

    public final int f376t;

    public final int f377u;

    public final int f378v;

    public final boolean f379w;

    public final HandlerC0132f f380x;

    public boolean f363g = false;

    public int f374r = -1;

    public final ViewOnClickListenerC0122a f381y = new ViewOnClickListenerC0122a(0, this);

    public C0136h(Context context, DialogInterfaceC0140j dialogInterfaceC0140j, Window window) {
        this.f357a = context;
        this.f358b = dialogInterfaceC0140j;
        this.f359c = window;
        HandlerC0132f handlerC0132f = new HandlerC0132f();
        handlerC0132f.f285b = new WeakReference(dialogInterfaceC0140j);
        this.f380x = handlerC0132f;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, AbstractC2341a.f8158f, R.attr.alertDialogStyle, 0);
        this.f375s = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        typedArrayObtainStyledAttributes.getResourceId(2, 0);
        this.f376t = typedArrayObtainStyledAttributes.getResourceId(4, 0);
        typedArrayObtainStyledAttributes.getResourceId(5, 0);
        this.f377u = typedArrayObtainStyledAttributes.getResourceId(7, 0);
        this.f378v = typedArrayObtainStyledAttributes.getResourceId(3, 0);
        this.f379w = typedArrayObtainStyledAttributes.getBoolean(6, true);
        typedArrayObtainStyledAttributes.getDimensionPixelSize(1, 0);
        typedArrayObtainStyledAttributes.recycle();
        dialogInterfaceC0140j.m419c().mo397g(1);
    }

    public static boolean m412a(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (m412a(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    public static void m413b(View view, View view2, View view3) {
        if (view2 != null) {
            view2.setVisibility(view.canScrollVertically(-1) ? 0 : 4);
        }
        if (view3 != null) {
            view3.setVisibility(view.canScrollVertically(1) ? 0 : 4);
        }
    }

    public static ViewGroup m414c(View view, View view2) {
        if (view == null) {
            if (view2 instanceof ViewStub) {
                view2 = ((ViewStub) view2).inflate();
            }
            return (ViewGroup) view2;
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        if (view instanceof ViewStub) {
            view = ((ViewStub) view).inflate();
        }
        return (ViewGroup) view;
    }
}
