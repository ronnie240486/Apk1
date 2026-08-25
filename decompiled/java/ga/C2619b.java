package ga;

import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.p2serv.android.p032ds.R;
import com.tencent.mars.xlog.Log;
import org.bitspark.android.Spark;
import org.bitspark.android.utils.AbstractC3331m;
import p003a2.AbstractC0032a;
import p055ea.C2428a;

public final class C2619b {

    public static final String f9102c = AbstractC0032a.m165s("eqapoIE=\n", "OPXk0+Zs+Kg=\n");

    public PopupWindow f9103a;

    public FrameLayout f9104b;

    public static void m5626a(C2619b c2619b, String str, Spark spark) {
        View viewInflate = View.inflate(spark, R.layout.layout_bsmessage1, null);
        int i6 = (C2428a.f8500i * 530) / 1920;
        String strM165s = AbstractC0032a.m165s("XnLcn0BSJg==\n", "LRqz6BA9VkE=\n");
        String str2 = AbstractC0032a.m165s("3ETrPKafOU0=\n", "uC2GWcjHA20=\n") + i6;
        boolean z7 = AbstractC3331m.f11244b;
        Log.m5049i(strM165s, str2);
        PopupWindow popupWindow = new PopupWindow(viewInflate, i6, -2);
        c2619b.f9103a = popupWindow;
        TextView textView = (TextView) popupWindow.getContentView().findViewById(R.id.message_body);
        ((TextView) c2619b.f9103a.getContentView().findViewById(R.id.message_title)).setTextSize(15.0f);
        textView.setTextSize(14.0f);
        textView.setText(str);
        c2619b.f9103a.setBackgroundDrawable(new BitmapDrawable());
        c2619b.f9103a.setAnimationStyle(R.style.anim_menu_bottombar);
        FrameLayout frameLayout = c2619b.f9104b;
        frameLayout.getLocationOnScreen(new int[2]);
        c2619b.f9103a.showAtLocation(frameLayout, 53, 20, 60);
    }
}
