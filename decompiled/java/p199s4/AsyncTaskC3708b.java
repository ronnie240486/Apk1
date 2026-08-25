package p199s4;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.cast.AbstractC1542e0;
import com.google.android.gms.internal.cast.AbstractC1581i;
import com.google.android.gms.internal.cast.C1601k;
import p025c2.C1381b;
import p132m5.BinderC3079b;
import p176q4.BinderC3484j;
import p176q4.C3479e;
import p230v4.C3988b;

public final class AsyncTaskC3708b extends AsyncTask {

    public static final C3988b f12413c = new C3988b("FetchBitmapTask", null);

    public final InterfaceC3711e f12414a;

    public final C1381b f12415b;

    public AsyncTaskC3708b(Context context, int i6, int i10, C1381b c1381b) {
        InterfaceC3711e interfaceC3711eM3902D;
        this.f12415b = c1381b;
        Context applicationContext = context.getApplicationContext();
        BinderC3484j binderC3484j = new BinderC3484j(this);
        C3988b c3988b = AbstractC1581i.f5339a;
        try {
            C1601k c1601kM3843b = AbstractC1581i.m3843b(applicationContext.getApplicationContext());
            BinderC3079b binderC3079b = new BinderC3079b(applicationContext.getApplicationContext());
            Parcel parcelM3688w = c1601kM3843b.m3688w(c1601kM3843b.m3687l(), 8);
            int i11 = parcelM3688w.readInt();
            parcelM3688w.recycle();
            interfaceC3711eM3902D = i11 >= 233700000 ? c1601kM3843b.m3902D(binderC3079b, new BinderC3079b(this), binderC3484j, i6, i10) : c1601kM3843b.m3901C(new BinderC3079b(this), binderC3484j, i6, i10);
        } catch (RemoteException | C3479e e5) {
            AbstractC1581i.f5339a.m7974a(e5, "Unable to call %s on %s.", "newFetchBitmapTaskImpl", C1601k.class.getSimpleName());
            interfaceC3711eM3902D = null;
        }
        this.f12414a = interfaceC3711eM3902D;
    }

    @Override
    public final Object doInBackground(Object[] objArr) {
        Uri uri;
        InterfaceC3711e interfaceC3711e;
        Uri[] uriArr = (Uri[]) objArr;
        if (uriArr.length != 1 || (uri = uriArr[0]) == null || (interfaceC3711e = this.f12414a) == null) {
            return null;
        }
        try {
            C3709c c3709c = (C3709c) interfaceC3711e;
            Parcel parcelM3687l = c3709c.m3687l();
            AbstractC1542e0.m3809c(parcelM3687l, uri);
            Parcel parcelM3688w = c3709c.m3688w(parcelM3687l, 1);
            Bitmap bitmap = (Bitmap) AbstractC1542e0.m3807a(parcelM3688w, Bitmap.CREATOR);
            parcelM3688w.recycle();
            return bitmap;
        } catch (RemoteException e5) {
            f12413c.m7974a(e5, "Unable to call %s on %s.", "doFetch", InterfaceC3711e.class.getSimpleName());
            return null;
        }
    }

    @Override
    public final void onPostExecute(Object obj) {
        Bitmap bitmap = (Bitmap) obj;
        C1381b c1381b = this.f12415b;
        if (c1381b != null) {
            InterfaceC3707a interfaceC3707a = (InterfaceC3707a) c1381b.f4202f;
            if (interfaceC3707a != null) {
                interfaceC3707a.mo3999f(bitmap);
            }
            c1381b.f4201e = null;
        }
    }
}
