package p116ka;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import androidx.core.content.FileProvider;
import com.lzy.okgo.callback.FileCallback;
import com.lzy.okgo.model.Progress;
import com.lzy.okgo.model.Response;
import com.p2serv.android.p032ds.R;
import ga.C2628k;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import org.bitspark.android.Spark;
import p003a2.AbstractC0032a;
import p034d0.C2121g;
import p055ea.AbstractC2460q;
import p055ea.C2428a;
import sa.ViewOnKeyListenerC3740k;

public final class C2940u extends FileCallback {

    public final DialogInterface f10023a;

    public final ViewOnKeyListenerC3740k f10024b;

    public final ViewOnKeyListenerC2944y f10025c;

    public C2940u(ViewOnKeyListenerC2944y viewOnKeyListenerC2944y, String str, String str2, DialogInterface dialogInterface, ViewOnKeyListenerC3740k viewOnKeyListenerC3740k) {
        super(str, str2);
        this.f10025c = viewOnKeyListenerC2944y;
        this.f10023a = dialogInterface;
        this.f10024b = viewOnKeyListenerC3740k;
    }

    @Override
    public final void downloadProgress(Progress progress) {
        ViewOnKeyListenerC3740k viewOnKeyListenerC3740k = this.f10024b;
        viewOnKeyListenerC3740k.f12534m.setVisibility(8);
        viewOnKeyListenerC3740k.f12533l.setVisibility(0);
        viewOnKeyListenerC3740k.f12533l.setMax(100);
        viewOnKeyListenerC3740k.f12533l.setProgress((int) (progress.fraction * 100.0f));
        viewOnKeyListenerC3740k.f12534m.requestFocus();
    }

    @Override
    public final void onError(Response response) {
        Spark.m6678t0(0, AbstractC0032a.m165s("QGF5NaSTMhska3wpp45/X3Zreimx3D8ecGt8eg==\n", "BA4OW8j8U38=\n"));
        if (C2428a.f8496e > C2628k.f9129b.incompatibleVersion) {
            int color = this.f10025c.m1324m().getColor(R.color.dialog_btn_text);
            ViewOnKeyListenerC3740k viewOnKeyListenerC3740k = this.f10024b;
            viewOnKeyListenerC3740k.f12535n.setTextColor(color);
            viewOnKeyListenerC3740k.f12535n.setFocusable(true);
            viewOnKeyListenerC3740k.f12535n.setClickable(true);
            viewOnKeyListenerC3740k.f12535n.setFocusableInTouchMode(true);
        }
    }

    @Override
    public final void onSuccess(Response response) {
        ViewOnKeyListenerC2944y viewOnKeyListenerC2944y = this.f10025c;
        if (!viewOnKeyListenerC2944y.f10102t1) {
            this.f10023a.dismiss();
        }
        File file = (File) response.body();
        Uri uriFromFile = Uri.fromFile(file);
        if (Build.VERSION.SDK_INT >= 24) {
            C2121g c2121gM1080c = FileProvider.m1080c(viewOnKeyListenerC2944y.m1319h(), AbstractC0032a.m165s("CuHx4yaLtdQb+LKsON203gDqsqkll7bDBvj1qTPL\n", "aY6czVa5xrE=\n"));
            try {
                String canonicalPath = file.getCanonicalPath();
                Map.Entry entry = null;
                for (Map.Entry entry2 : c2121gM1080c.f7727b.entrySet()) {
                    String path = ((File) entry2.getValue()).getPath();
                    if (C2121g.m5078a(canonicalPath, path) && (entry == null || path.length() > ((File) entry.getValue()).getPath().length())) {
                        entry = entry2;
                    }
                }
                if (entry == null) {
                    throw new IllegalArgumentException(AbstractC2460q.m5501o("Failed to find configured root that contains ", canonicalPath));
                }
                String path2 = ((File) entry.getValue()).getPath();
                uriFromFile = new Uri.Builder().scheme("content").authority(c2121gM1080c.f7726a).encodedPath(Uri.encode((String) entry.getKey()) + '/' + Uri.encode(path2.endsWith("/") ? canonicalPath.substring(path2.length()) : canonicalPath.substring(path2.length() + 1), "/")).build();
            } catch (IOException unused) {
                throw new IllegalArgumentException("Failed to resolve canonical path for " + file);
            }
        }
        Intent intent = new Intent(AbstractC0032a.m165s("HKE6gG8pw/sUoSqXbjSJtB67N51ubvGcOJg=\n", "fc9e8gBAp9U=\n"), uriFromFile);
        intent.putExtra(AbstractC0032a.m165s("0wbujrXDglfbBv6ZtN7IHMoc+J305Kkt7T3Et5TlsTftO8WpiOmj\n", "smiK/Nqq5nk=\n"), true);
        intent.setDataAndType(uriFromFile, AbstractC0032a.m165s("ar5Bp9S0gwNioV/ky7mGWWqgVbnSvoZZe69SoNywh1pqvFKj1KGH\n", "C84xy73X4nc=\n"));
        intent.setFlags(268435456);
        intent.addFlags(1);
        viewOnKeyListenerC2944y.m1319h().startActivity(intent);
    }
}
