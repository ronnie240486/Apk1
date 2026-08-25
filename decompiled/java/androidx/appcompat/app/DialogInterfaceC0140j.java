package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.widget.NestedScrollView;
import com.p2serv.android.p032ds.R;
import java.util.WeakHashMap;
import p138n0.AbstractC3122h0;
import p138n0.AbstractC3155s0;

public class DialogInterfaceC0140j extends AbstractDialogC0139i0 implements DialogInterface {

    public final C0136h f389e;

    public DialogInterfaceC0140j(ContextThemeWrapper contextThemeWrapper, int i6) {
        super(contextThemeWrapper, m424i(contextThemeWrapper, i6));
        this.f389e = new C0136h(getContext(), this, getWindow());
    }

    public static int m424i(Context context, int i6) {
        if (((i6 >>> 24) & 255) >= 1) {
            return i6;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    @Override
    public void onCreate(Bundle bundle) {
        int i6;
        ListAdapter listAdapter;
        View view;
        View viewFindViewById;
        int i10 = 0;
        super.onCreate(bundle);
        C0136h c0136h = this.f389e;
        c0136h.f358b.setContentView(c0136h.f375s);
        Window window = c0136h.f359c;
        View viewFindViewById2 = window.findViewById(R.id.parentPanel);
        View viewFindViewById3 = viewFindViewById2.findViewById(R.id.topPanel);
        View viewFindViewById4 = viewFindViewById2.findViewById(R.id.contentPanel);
        View viewFindViewById5 = viewFindViewById2.findViewById(R.id.buttonPanel);
        ViewGroup viewGroup = (ViewGroup) viewFindViewById2.findViewById(R.id.customPanel);
        View view2 = c0136h.f362f;
        if (view2 == null) {
            view2 = null;
        }
        boolean z7 = view2 != null;
        if (!z7 || !C0136h.m412a(view2)) {
            window.setFlags(131072, 131072);
        }
        if (z7) {
            FrameLayout frameLayout = (FrameLayout) window.findViewById(R.id.custom);
            frameLayout.addView(view2, new ViewGroup.LayoutParams(-1, -1));
            if (c0136h.f363g) {
                frameLayout.setPadding(0, 0, 0, 0);
            }
            if (c0136h.f361e != null) {
                ((LinearLayout.LayoutParams) ((LinearLayoutCompat.LayoutParams) viewGroup.getLayoutParams())).weight = 0.0f;
            }
        } else {
            viewGroup.setVisibility(8);
        }
        View viewFindViewById6 = viewGroup.findViewById(R.id.topPanel);
        View viewFindViewById7 = viewGroup.findViewById(R.id.contentPanel);
        View viewFindViewById8 = viewGroup.findViewById(R.id.buttonPanel);
        ViewGroup viewGroupM414c = C0136h.m414c(viewFindViewById6, viewFindViewById3);
        ViewGroup viewGroupM414c2 = C0136h.m414c(viewFindViewById7, viewFindViewById4);
        ViewGroup viewGroupM414c3 = C0136h.m414c(viewFindViewById8, viewFindViewById5);
        NestedScrollView nestedScrollView = (NestedScrollView) window.findViewById(R.id.scrollView);
        c0136h.f367k = nestedScrollView;
        nestedScrollView.setFocusable(false);
        c0136h.f367k.setNestedScrollingEnabled(false);
        TextView textView = (TextView) viewGroupM414c2.findViewById(android.R.id.message);
        c0136h.f371o = textView;
        if (textView != null) {
            textView.setVisibility(8);
            c0136h.f367k.removeView(c0136h.f371o);
            if (c0136h.f361e != null) {
                ViewGroup viewGroup2 = (ViewGroup) c0136h.f367k.getParent();
                int iIndexOfChild = viewGroup2.indexOfChild(c0136h.f367k);
                viewGroup2.removeViewAt(iIndexOfChild);
                viewGroup2.addView(c0136h.f361e, iIndexOfChild, new ViewGroup.LayoutParams(-1, -1));
            } else {
                viewGroupM414c2.setVisibility(8);
            }
        }
        Button button = (Button) viewGroupM414c3.findViewById(android.R.id.button1);
        c0136h.f364h = button;
        ViewOnClickListenerC0122a viewOnClickListenerC0122a = c0136h.f381y;
        button.setOnClickListener(viewOnClickListenerC0122a);
        if (TextUtils.isEmpty(null)) {
            c0136h.f364h.setVisibility(8);
            i6 = 0;
        } else {
            c0136h.f364h.setText((CharSequence) null);
            c0136h.f364h.setVisibility(0);
            i6 = 1;
        }
        Button button2 = (Button) viewGroupM414c3.findViewById(android.R.id.button2);
        c0136h.f365i = button2;
        button2.setOnClickListener(viewOnClickListenerC0122a);
        if (TextUtils.isEmpty(null)) {
            c0136h.f365i.setVisibility(8);
        } else {
            c0136h.f365i.setText((CharSequence) null);
            c0136h.f365i.setVisibility(0);
            i6 |= 2;
        }
        Button button3 = (Button) viewGroupM414c3.findViewById(android.R.id.button3);
        c0136h.f366j = button3;
        button3.setOnClickListener(viewOnClickListenerC0122a);
        if (TextUtils.isEmpty(null)) {
            c0136h.f366j.setVisibility(8);
        } else {
            c0136h.f366j.setText((CharSequence) null);
            c0136h.f366j.setVisibility(0);
            i6 |= 4;
        }
        TypedValue typedValue = new TypedValue();
        c0136h.f357a.getTheme().resolveAttribute(R.attr.alertDialogCenterButtons, typedValue, true);
        if (typedValue.data != 0) {
            if (i6 == 1) {
                Button button4 = c0136h.f364h;
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button4.getLayoutParams();
                layoutParams.gravity = 1;
                layoutParams.weight = 0.5f;
                button4.setLayoutParams(layoutParams);
            } else if (i6 == 2) {
                Button button5 = c0136h.f365i;
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) button5.getLayoutParams();
                layoutParams2.gravity = 1;
                layoutParams2.weight = 0.5f;
                button5.setLayoutParams(layoutParams2);
            } else if (i6 == 4) {
                Button button6 = c0136h.f366j;
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) button6.getLayoutParams();
                layoutParams3.gravity = 1;
                layoutParams3.weight = 0.5f;
                button6.setLayoutParams(layoutParams3);
            }
        }
        if (i6 == 0) {
            viewGroupM414c3.setVisibility(8);
        }
        if (c0136h.f372p != null) {
            viewGroupM414c.addView(c0136h.f372p, 0, new ViewGroup.LayoutParams(-1, -2));
            window.findViewById(R.id.title_template).setVisibility(8);
        } else {
            c0136h.f369m = (ImageView) window.findViewById(android.R.id.icon);
            if (TextUtils.isEmpty(c0136h.f360d) || !c0136h.f379w) {
                window.findViewById(R.id.title_template).setVisibility(8);
                c0136h.f369m.setVisibility(8);
                viewGroupM414c.setVisibility(8);
            } else {
                TextView textView2 = (TextView) window.findViewById(R.id.alertTitle);
                c0136h.f370n = textView2;
                textView2.setText(c0136h.f360d);
                Drawable drawable = c0136h.f368l;
                if (drawable != null) {
                    c0136h.f369m.setImageDrawable(drawable);
                } else {
                    c0136h.f370n.setPadding(c0136h.f369m.getPaddingLeft(), c0136h.f369m.getPaddingTop(), c0136h.f369m.getPaddingRight(), c0136h.f369m.getPaddingBottom());
                    c0136h.f369m.setVisibility(8);
                }
            }
        }
        boolean z10 = viewGroup.getVisibility() != 8;
        int i11 = (viewGroupM414c == null || viewGroupM414c.getVisibility() == 8) ? 0 : 1;
        boolean z11 = viewGroupM414c3.getVisibility() != 8;
        if (!z11 && (viewFindViewById = viewGroupM414c2.findViewById(R.id.textSpacerNoButtons)) != null) {
            viewFindViewById.setVisibility(0);
        }
        if (i11 != 0) {
            NestedScrollView nestedScrollView2 = c0136h.f367k;
            if (nestedScrollView2 != null) {
                nestedScrollView2.setClipToPadding(true);
            }
            View viewFindViewById9 = c0136h.f361e != null ? viewGroupM414c.findViewById(R.id.titleDividerNoCustom) : null;
            if (viewFindViewById9 != null) {
                viewFindViewById9.setVisibility(0);
            }
        } else {
            View viewFindViewById10 = viewGroupM414c2.findViewById(R.id.textSpacerNoTitle);
            if (viewFindViewById10 != null) {
                viewFindViewById10.setVisibility(0);
            }
        }
        AlertController$RecycleListView alertController$RecycleListView = c0136h.f361e;
        if (alertController$RecycleListView instanceof AlertController$RecycleListView) {
            alertController$RecycleListView.getClass();
            if (!z11 || i11 == 0) {
                alertController$RecycleListView.setPadding(alertController$RecycleListView.getPaddingLeft(), i11 != 0 ? alertController$RecycleListView.getPaddingTop() : alertController$RecycleListView.f248a, alertController$RecycleListView.getPaddingRight(), z11 ? alertController$RecycleListView.getPaddingBottom() : alertController$RecycleListView.f249b);
            }
        }
        if (!z10) {
            View view3 = c0136h.f361e;
            if (view3 == null) {
                view3 = c0136h.f367k;
            }
            if (view3 != null) {
                int i12 = i11 | (z11 ? 2 : 0);
                View viewFindViewById11 = window.findViewById(R.id.scrollIndicatorUp);
                View viewFindViewById12 = window.findViewById(R.id.scrollIndicatorDown);
                int i13 = Build.VERSION.SDK_INT;
                if (i13 >= 23) {
                    WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
                    if (i13 >= 23) {
                        AbstractC3122h0.m6192d(view3, i12, 3);
                    }
                    if (viewFindViewById11 != null) {
                        viewGroupM414c2.removeView(viewFindViewById11);
                    }
                    if (viewFindViewById12 != null) {
                        viewGroupM414c2.removeView(viewFindViewById12);
                    }
                } else {
                    if (viewFindViewById11 != null && (i12 & 1) == 0) {
                        viewGroupM414c2.removeView(viewFindViewById11);
                        viewFindViewById11 = null;
                    }
                    if (viewFindViewById12 == null || (i12 & 2) != 0) {
                        view = viewFindViewById12;
                    } else {
                        viewGroupM414c2.removeView(viewFindViewById12);
                        view = null;
                    }
                    if (viewFindViewById11 != null || view != null) {
                        AlertController$RecycleListView alertController$RecycleListView2 = c0136h.f361e;
                        if (alertController$RecycleListView2 != null) {
                            alertController$RecycleListView2.setOnScrollListener(new C0124b(viewFindViewById11, view));
                            c0136h.f361e.post(new RunnableC0126c(c0136h, viewFindViewById11, view, i10));
                        } else {
                            if (viewFindViewById11 != null) {
                                viewGroupM414c2.removeView(viewFindViewById11);
                            }
                            if (view != null) {
                                viewGroupM414c2.removeView(view);
                            }
                        }
                    }
                }
            }
        }
        AlertController$RecycleListView alertController$RecycleListView3 = c0136h.f361e;
        if (alertController$RecycleListView3 == null || (listAdapter = c0136h.f373q) == null) {
            return;
        }
        alertController$RecycleListView3.setAdapter(listAdapter);
        int i14 = c0136h.f374r;
        if (i14 > -1) {
            alertController$RecycleListView3.setItemChecked(i14, true);
            alertController$RecycleListView3.setSelection(i14);
        }
    }

    @Override
    public boolean onKeyDown(int i6, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.f389e.f367k;
        if (nestedScrollView == null || !nestedScrollView.m1101h(keyEvent)) {
            return super.onKeyDown(i6, keyEvent);
        }
        return true;
    }

    @Override
    public boolean onKeyUp(int i6, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.f389e.f367k;
        if (nestedScrollView == null || !nestedScrollView.m1101h(keyEvent)) {
            return super.onKeyUp(i6, keyEvent);
        }
        return true;
    }

    @Override
    public final void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        C0136h c0136h = this.f389e;
        c0136h.f360d = charSequence;
        TextView textView = c0136h.f370n;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }
}
