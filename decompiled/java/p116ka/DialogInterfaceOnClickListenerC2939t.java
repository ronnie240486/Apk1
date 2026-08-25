package p116ka;

import android.content.DialogInterface;
import android.os.Environment;
import android.widget.Button;
import androidx.fragment.app.FragmentActivity;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.request.GetRequest;
import com.p2serv.android.p032ds.R;
import ga.C2628k;
import org.bitspark.android.Spark;
import p003a2.AbstractC0032a;
import p055ea.C2428a;
import sa.ViewOnKeyListenerC3740k;

public final class DialogInterfaceOnClickListenerC2939t implements DialogInterface.OnClickListener {

    public final ViewOnKeyListenerC3740k f10021a;

    public final ViewOnKeyListenerC2944y f10022b;

    public DialogInterfaceOnClickListenerC2939t(ViewOnKeyListenerC2944y viewOnKeyListenerC2944y, ViewOnKeyListenerC3740k viewOnKeyListenerC3740k) {
        this.f10022b = viewOnKeyListenerC2944y;
        this.f10021a = viewOnKeyListenerC3740k;
    }

    @Override
    public final void onClick(DialogInterface dialogInterface, int i6) {
        String str = C2628k.f9129b.release.url;
        String str2 = ViewOnKeyListenerC2944y.f10031u1;
        ViewOnKeyListenerC2944y viewOnKeyListenerC2944y = this.f10022b;
        FragmentActivity fragmentActivityM1319h = viewOnKeyListenerC2944y.m1319h();
        ViewOnKeyListenerC3740k viewOnKeyListenerC3740k = this.f10021a;
        if (fragmentActivityM1319h == null) {
            Spark.m6678t0(0, AbstractC0032a.m165s("6gosflAykBKOACliUy/dVtwAL2JFfZ0X2gApMBI=\n", "rmVbEDxd8XY=\n"));
        } else if (viewOnKeyListenerC2944y.m1319h().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS) == null) {
            Spark.m6678t0(0, AbstractC0032a.m165s("dcjhO4WaY7oRwuQnhocu/kPC4ieQ1W6/RcLkdcfb\n", "MaeWVen1At4=\n"));
        } else {
            String absolutePath = viewOnKeyListenerC2944y.m1319h().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath();
            if (absolutePath == null) {
                Spark.m6678t0(0, AbstractC0032a.m165s("ONQRg46eRTBc3hSfjYMIdA7eEp+b0Ug1CN4UzczfCg==\n", "fLtm7eLxJFQ=\n"));
            } else {
                ((GetRequest) OkGo.get(str).cacheMode(CacheMode.NO_CACHE)).execute(new C2940u(viewOnKeyListenerC2944y, absolutePath, str.substring(str.lastIndexOf(AbstractC0032a.m165s("CQ==\n", "Jgk/SHl5N1s=\n")) + 1), dialogInterface, viewOnKeyListenerC3740k));
            }
        }
        int color = viewOnKeyListenerC2944y.m1324m().getColor(R.color.dialog_btn_text);
        viewOnKeyListenerC3740k.f12536o.setClickable(false);
        Button button = viewOnKeyListenerC3740k.f12537p;
        if (button != null) {
            button.setClickable(false);
            viewOnKeyListenerC3740k.f12537p.setFocusable(false);
            viewOnKeyListenerC3740k.f12537p.setFocusableInTouchMode(false);
            viewOnKeyListenerC3740k.f12537p.setTextColor(color);
        }
        if (C2428a.f8496e > C2628k.f9129b.incompatibleVersion) {
            viewOnKeyListenerC3740k.f12535n.setTextColor(color);
            viewOnKeyListenerC3740k.f12535n.setFocusable(false);
            viewOnKeyListenerC3740k.f12535n.setClickable(false);
            viewOnKeyListenerC3740k.f12535n.setFocusableInTouchMode(false);
        }
    }
}
