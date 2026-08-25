package org.bitspark.android.keyboard.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.mediarouter.app.HandlerC1080c;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.nmmedit.protect.NativeUtil;
import com.p2serv.android.p032ds.R;
import java.util.ArrayList;
import java.util.concurrent.ScheduledExecutorService;
import ma.C3091a;
import na.C3222a;
import na.InterfaceC3223b;
import p003a2.AbstractC0032a;
import p055ea.AbstractC2444i;
import p063fa.InterfaceC2546n0;
import p157oa.C3286a;
import p173q1.C3406f0;

public class MyKeyBoardView extends LinearLayout implements View.OnClickListener {

    public final RecyclerView f11186a;

    public EditText f11187b;

    public final String[] f11188c;

    public final String f11189d;

    public final boolean f11190e;

    public final C3091a f11191f;

    public final ArrayList f11192g;

    public final View f11193h;

    public InterfaceC3223b f11194i;

    public final GridLayoutManager f11195j;

    public final C3222a f11196k;

    public final C3222a f11197l;

    public ScheduledExecutorService f11198m;

    public final C3222a f11199n;

    public final HandlerC1080c f11200o;

    static {
        NativeUtil.classesInit0(33);
    }

    public MyKeyBoardView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f11189d = AbstractC0032a.m165s("h1k+ksDQN5+DWTqSxNA7n49ZNpLI0D+fi1kykszQI5+XWS6S0NAnn5NZKpLU0Cufn1kmkrLQQZ/1\nWUiSttBFn/FZRJK60EM=\n", "xnV8voP8c7M=\n");
        this.f11190e = true;
        this.f11192g = new ArrayList();
        this.f11196k = new C3222a(this);
        this.f11197l = new C3222a(this);
        this.f11199n = new C3222a(this);
        this.f11200o = new HandlerC1080c(6, this);
    }

    public static native void m6734a(MyKeyBoardView myKeyBoardView, View view, int i6);

    public native EditText getEditText();

    @Override
    public final native void onClick(View view);

    public native void setEditText(EditText editText);

    public native void setOnBackDownPressedListener(InterfaceC2546n0 interfaceC2546n0);

    public native void setOnKeyClickListener(InterfaceC3223b interfaceC3223b);

    public MyKeyBoardView(Context context, AttributeSet attributeSet) {
        ArrayList arrayList;
        super(context, attributeSet);
        String strM165s = AbstractC0032a.m165s("nMFWj46cUf+YwVKPipxd/5TBXo+GnFn/kMFaj4KcRf+MwUaPnpxB/4jBQo+anE3/hMFOj/ycJ//u\nwSCP+Jwj/+rBLI/0nCU=\n", "3e0Uo82wFdM=\n");
        this.f11189d = strM165s;
        this.f11190e = true;
        this.f11192g = new ArrayList();
        this.f11196k = new C3222a(this);
        this.f11197l = new C3222a(this);
        this.f11199n = new C3222a(this);
        this.f11200o = new HandlerC1080c(6, this);
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.view_keyboard, this);
        this.f11193h = viewInflate;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC2444i.f8622a);
        typedArrayObtainStyledAttributes.getBoolean(6, false);
        if (typedArrayObtainStyledAttributes.getString(8) != null && !typedArrayObtainStyledAttributes.getString(8).equals("")) {
            this.f11189d = typedArrayObtainStyledAttributes.getString(8) + AbstractC0032a.m165s("SQ==\n", "ZXB3/Nk9E3s=\n") + strM165s;
        }
        this.f11186a = (RecyclerView) viewInflate.findViewById(R.id.rv_kb_num);
        this.f11188c = this.f11189d.split(AbstractC0032a.m165s("gw==\n", "rx1hjgkKHlg=\n"));
        int i6 = 0;
        while (true) {
            String[] strArr = this.f11188c;
            int length = strArr.length;
            arrayList = this.f11192g;
            if (i6 >= length) {
                break;
            }
            arrayList.add(new C3286a(0, strArr[i6]));
            i6++;
        }
        arrayList.add(new C3286a(9, " "));
        arrayList.add(new C3286a(0, AbstractC0032a.m165s("lg==\n", "u7x+WnIVgew=\n")));
        this.f11195j = new GridLayoutManager();
        C3091a c3091a = new C3091a();
        c3091a.f12844a = new C3406f0(5);
        new LinearInterpolator();
        c3091a.f12846c = arrayList;
        c3091a.f10559j = 500L;
        c3091a.f10560k = false;
        c3091a.f10561l = false;
        c3091a.f10563n = new Handler();
        c3091a.f10554e = this.f11196k;
        c3091a.f10555f = this.f11199n;
        c3091a.f10556g = this.f11197l;
        c3091a.m7581c(0, R.layout.item_keyboard_num);
        c3091a.m7581c(9, R.layout.item_keyboard_img_num);
        c3091a.m7581c(7, R.layout.item_keyboard_alphabet_a);
        c3091a.m7581c(8, R.layout.item_keyboard_char_big);
        c3091a.m7581c(6, R.layout.item_keyboard_alphabet_normal);
        c3091a.m7581c(1, R.layout.item_keyboard_alphabet_normal);
        c3091a.m7581c(2, R.layout.item_keyboard_alphabet_a);
        c3091a.m7581c(5, R.layout.item_keyboard_img_alphabet);
        c3091a.m7581c(3, R.layout.item_keyboard_img_num);
        c3091a.m7581c(4, R.layout.item_keyboard_img_alphabet);
        this.f11191f = c3091a;
        if (this.f11190e) {
            this.f11186a.setLayoutManager(this.f11195j);
            this.f11186a.setAdapter(this.f11191f);
        }
    }
}
