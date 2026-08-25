package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.media3.common.C0565C;
import com.p2serv.android.p032ds.R;
import java.util.WeakHashMap;
import p002a1.C0026b;
import p045e.AbstractC2341a;
import p105k.C2840n;
import p105k.InterfaceC2852z;
import p105k.MenuC2838l;
import p138n0.AbstractC3155s0;

public class ListMenuItemView extends LinearLayout implements InterfaceC2852z, AbsListView.SelectionBoundsAdjuster {

    public C2840n f500a;

    public ImageView f501b;

    public RadioButton f502c;

    public TextView f503d;

    public CheckBox f504e;

    public TextView f505f;

    public ImageView f506g;

    public ImageView f507h;

    public LinearLayout f508i;

    public final Drawable f509j;

    public final int f510k;

    public final Context f511l;

    public boolean f512m;

    public final Drawable f513n;

    public final boolean f514o;

    public LayoutInflater f515p;

    public boolean f516q;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.listMenuViewStyle);
    }

    private LayoutInflater getInflater() {
        if (this.f515p == null) {
            this.f515p = LayoutInflater.from(getContext());
        }
        return this.f515p;
    }

    private void setSubMenuArrowVisible(boolean z7) {
        ImageView imageView = this.f506g;
        if (imageView != null) {
            imageView.setVisibility(z7 ? 0 : 8);
        }
    }

    @Override
    public final void adjustListItemSelectionBounds(Rect rect) {
        ImageView imageView = this.f507h;
        if (imageView == null || imageView.getVisibility() != 0) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f507h.getLayoutParams();
        rect.top = this.f507h.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin + rect.top;
    }

    @Override
    public final void mo532c(C2840n c2840n) {
        boolean z7;
        int i6;
        String string;
        boolean z10;
        this.f500a = c2840n;
        setVisibility(c2840n.isVisible() ? 0 : 8);
        setTitle(c2840n.f9721e);
        setCheckable(c2840n.isCheckable());
        if (c2840n.f9730n.mo5820o()) {
            if ((c2840n.f9730n.mo5819n() ? c2840n.f9726j : c2840n.f9724h) != 0) {
                z7 = true;
            } else {
                z7 = false;
            }
        } else {
            z7 = false;
        }
        c2840n.f9730n.mo5819n();
        if (z7) {
            C2840n c2840n2 = this.f500a;
            if (c2840n2.f9730n.mo5820o()) {
                if ((c2840n2.f9730n.mo5819n() ? c2840n2.f9726j : c2840n2.f9724h) != 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
            } else {
                z10 = false;
            }
            i6 = z10 ? 0 : 8;
        }
        if (i6 == 0) {
            TextView textView = this.f505f;
            C2840n c2840n3 = this.f500a;
            char c5 = c2840n3.f9730n.mo5819n() ? c2840n3.f9726j : c2840n3.f9724h;
            if (c5 == 0) {
                string = "";
            } else {
                MenuC2838l menuC2838l = c2840n3.f9730n;
                Resources resources = menuC2838l.f9687a.getResources();
                StringBuilder sb = new StringBuilder();
                if (ViewConfiguration.get(menuC2838l.f9687a).hasPermanentMenuKey()) {
                    sb.append(resources.getString(R.string.abc_prepend_shortcut_label));
                }
                int i10 = menuC2838l.mo5819n() ? c2840n3.f9727k : c2840n3.f9725i;
                C2840n.m5841c(sb, i10, C0565C.DEFAULT_BUFFER_SEGMENT_SIZE, resources.getString(R.string.abc_menu_meta_shortcut_label));
                C2840n.m5841c(sb, i10, 4096, resources.getString(R.string.abc_menu_ctrl_shortcut_label));
                C2840n.m5841c(sb, i10, 2, resources.getString(R.string.abc_menu_alt_shortcut_label));
                C2840n.m5841c(sb, i10, 1, resources.getString(R.string.abc_menu_shift_shortcut_label));
                C2840n.m5841c(sb, i10, 4, resources.getString(R.string.abc_menu_sym_shortcut_label));
                C2840n.m5841c(sb, i10, 8, resources.getString(R.string.abc_menu_function_shortcut_label));
                if (c5 == '\b') {
                    sb.append(resources.getString(R.string.abc_menu_delete_shortcut_label));
                } else if (c5 == '\n') {
                    sb.append(resources.getString(R.string.abc_menu_enter_shortcut_label));
                } else if (c5 != ' ') {
                    sb.append(c5);
                } else {
                    sb.append(resources.getString(R.string.abc_menu_space_shortcut_label));
                }
                string = sb.toString();
            }
            textView.setText(string);
        }
        if (this.f505f.getVisibility() != i6) {
            this.f505f.setVisibility(i6);
        }
        setIcon(c2840n.getIcon());
        setEnabled(c2840n.isEnabled());
        setSubMenuArrowVisible(c2840n.hasSubMenu());
        setContentDescription(c2840n.f9733q);
    }

    @Override
    public C2840n getItemData() {
        return this.f500a;
    }

    @Override
    public final void onFinishInflate() {
        super.onFinishInflate();
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        setBackground(this.f509j);
        TextView textView = (TextView) findViewById(R.id.title);
        this.f503d = textView;
        int i6 = this.f510k;
        if (i6 != -1) {
            textView.setTextAppearance(this.f511l, i6);
        }
        this.f505f = (TextView) findViewById(R.id.shortcut);
        ImageView imageView = (ImageView) findViewById(R.id.submenuarrow);
        this.f506g = imageView;
        if (imageView != null) {
            imageView.setImageDrawable(this.f513n);
        }
        this.f507h = (ImageView) findViewById(R.id.group_divider);
        this.f508i = (LinearLayout) findViewById(R.id.content);
    }

    @Override
    public final void onMeasure(int i6, int i10) {
        if (this.f501b != null && this.f512m) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f501b.getLayoutParams();
            int i11 = layoutParams.height;
            if (i11 > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = i11;
            }
        }
        super.onMeasure(i6, i10);
    }

    public void setCheckable(boolean z7) {
        CompoundButton compoundButton;
        View view;
        if (!z7 && this.f502c == null && this.f504e == null) {
            return;
        }
        if ((this.f500a.f9740x & 4) != 0) {
            if (this.f502c == null) {
                RadioButton radioButton = (RadioButton) getInflater().inflate(R.layout.abc_list_menu_item_radio, (ViewGroup) this, false);
                this.f502c = radioButton;
                LinearLayout linearLayout = this.f508i;
                if (linearLayout != null) {
                    linearLayout.addView(radioButton, -1);
                } else {
                    addView(radioButton, -1);
                }
            }
            compoundButton = this.f502c;
            view = this.f504e;
        } else {
            if (this.f504e == null) {
                CheckBox checkBox = (CheckBox) getInflater().inflate(R.layout.abc_list_menu_item_checkbox, (ViewGroup) this, false);
                this.f504e = checkBox;
                LinearLayout linearLayout2 = this.f508i;
                if (linearLayout2 != null) {
                    linearLayout2.addView(checkBox, -1);
                } else {
                    addView(checkBox, -1);
                }
            }
            compoundButton = this.f504e;
            view = this.f502c;
        }
        if (z7) {
            compoundButton.setChecked(this.f500a.isChecked());
            if (compoundButton.getVisibility() != 0) {
                compoundButton.setVisibility(0);
            }
            if (view == null || view.getVisibility() == 8) {
                return;
            }
            view.setVisibility(8);
            return;
        }
        CheckBox checkBox2 = this.f504e;
        if (checkBox2 != null) {
            checkBox2.setVisibility(8);
        }
        RadioButton radioButton2 = this.f502c;
        if (radioButton2 != null) {
            radioButton2.setVisibility(8);
        }
    }

    public void setChecked(boolean z7) {
        CompoundButton compoundButton;
        if ((this.f500a.f9740x & 4) != 0) {
            if (this.f502c == null) {
                RadioButton radioButton = (RadioButton) getInflater().inflate(R.layout.abc_list_menu_item_radio, (ViewGroup) this, false);
                this.f502c = radioButton;
                LinearLayout linearLayout = this.f508i;
                if (linearLayout != null) {
                    linearLayout.addView(radioButton, -1);
                } else {
                    addView(radioButton, -1);
                }
            }
            compoundButton = this.f502c;
        } else {
            if (this.f504e == null) {
                CheckBox checkBox = (CheckBox) getInflater().inflate(R.layout.abc_list_menu_item_checkbox, (ViewGroup) this, false);
                this.f504e = checkBox;
                LinearLayout linearLayout2 = this.f508i;
                if (linearLayout2 != null) {
                    linearLayout2.addView(checkBox, -1);
                } else {
                    addView(checkBox, -1);
                }
            }
            compoundButton = this.f504e;
        }
        compoundButton.setChecked(z7);
    }

    public void setForceShowIcon(boolean z7) {
        this.f516q = z7;
        this.f512m = z7;
    }

    public void setGroupDividerEnabled(boolean z7) {
        ImageView imageView = this.f507h;
        if (imageView != null) {
            imageView.setVisibility((this.f514o || !z7) ? 8 : 0);
        }
    }

    public void setIcon(Drawable drawable) {
        this.f500a.f9730n.getClass();
        boolean z7 = this.f516q;
        if (z7 || this.f512m) {
            ImageView imageView = this.f501b;
            if (imageView == null && drawable == null && !this.f512m) {
                return;
            }
            if (imageView == null) {
                ImageView imageView2 = (ImageView) getInflater().inflate(R.layout.abc_list_menu_item_icon, (ViewGroup) this, false);
                this.f501b = imageView2;
                LinearLayout linearLayout = this.f508i;
                if (linearLayout != null) {
                    linearLayout.addView(imageView2, 0);
                } else {
                    addView(imageView2, 0);
                }
            }
            if (drawable == null && !this.f512m) {
                this.f501b.setVisibility(8);
                return;
            }
            ImageView imageView3 = this.f501b;
            if (!z7) {
                drawable = null;
            }
            imageView3.setImageDrawable(drawable);
            if (this.f501b.getVisibility() != 0) {
                this.f501b.setVisibility(0);
            }
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence == null) {
            if (this.f503d.getVisibility() != 8) {
                this.f503d.setVisibility(8);
            }
        } else {
            this.f503d.setText(charSequence);
            if (this.f503d.getVisibility() != 0) {
                this.f503d.setVisibility(0);
            }
        }
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet);
        C0026b c0026bM111C = C0026b.m111C(getContext(), attributeSet, AbstractC2341a.f8171s, i6);
        this.f509j = c0026bM111C.m140t(5);
        TypedArray typedArray = (TypedArray) c0026bM111C.f55c;
        this.f510k = typedArray.getResourceId(1, -1);
        this.f512m = typedArray.getBoolean(7, false);
        this.f511l = context;
        this.f513n = c0026bM111C.m140t(8);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, new int[]{android.R.attr.divider}, R.attr.dropDownListViewStyle, 0);
        this.f514o = typedArrayObtainStyledAttributes.hasValue(0);
        c0026bM111C.m120F();
        typedArrayObtainStyledAttributes.recycle();
    }
}
