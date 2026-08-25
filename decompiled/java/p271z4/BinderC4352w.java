package p271z4;

import android.accounts.Account;
import android.content.Context;
import android.os.Parcel;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.zat;
import com.google.android.gms.internal.cast.AbstractBinderC1694u;
import com.google.android.gms.internal.cast.C1543e1;
import com.google.android.gms.internal.cast.HandlerC1731y0;
import com.google.android.gms.signin.internal.zai;
import com.google.android.gms.signin.internal.zak;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;
import p000a.C0016q;
import p005a4.C0049h;
import p018b5.AbstractC1312l;
import p142n4.C3194a;
import p177q5.AbstractC3501a;
import p220u5.AbstractC3900b;
import p231v5.C4010a;
import p231v5.C4011b;
import p261y4.InterfaceC4260h;
import p261y4.InterfaceC4261i;
import ua.RunnableC3940a;

public final class BinderC4352w extends AbstractBinderC1694u implements InterfaceC4260h, InterfaceC4261i {

    public static final C1543e1 f14751k = AbstractC3900b.f13100a;

    public final Context f14752d;

    public final HandlerC1731y0 f14753e;

    public final C1543e1 f14754f;

    public final Set f14755g;

    public final C0049h f14756h;

    public C4010a f14757i;

    public C0016q f14758j;

    public BinderC4352w(Context context, HandlerC1731y0 handlerC1731y0, C0049h c0049h) {
        attachInterface(this, "com.google.android.gms.signin.internal.ISignInCallbacks");
        this.f14752d = context;
        this.f14753e = handlerC1731y0;
        this.f14756h = c0049h;
        this.f14755g = (Set) c0049h.f141c;
        this.f14754f = f14751k;
    }

    @Override
    public final void mo8307g(int i6) {
        C0016q c0016q = this.f14758j;
        C4343n c4343n = (C4343n) ((C4334e) c0016q.f36f).f14707j.get((C4331b) c0016q.f33c);
        if (c4343n != null) {
            if (c4343n.f14728k) {
                c4343n.m8380p(new ConnectionResult(17));
            } else {
                c4343n.mo8307g(i6);
            }
        }
    }

    @Override
    public final void mo8308l(ConnectionResult connectionResult) {
        this.f14758j.m52e(connectionResult);
    }

    @Override
    public final void onConnected() {
        GoogleSignInAccount googleSignInAccountM3581j;
        boolean z7 = false;
        C4010a c4010a = this.f14757i;
        c4010a.getClass();
        try {
            c4010a.f13600A.getClass();
            Account account = new Account("<<default account>>", "com.google");
            if ("<<default account>>".equals(account.name)) {
                Context context = c4010a.f5071c;
                ReentrantLock reentrantLock = C3194a.f10748c;
                AbstractC1312l.m3198e(context);
                ReentrantLock reentrantLock2 = C3194a.f10748c;
                reentrantLock2.lock();
                try {
                    if (C3194a.f10749d == null) {
                        C3194a.f10749d = new C3194a(context.getApplicationContext());
                    }
                    C3194a c3194a = C3194a.f10749d;
                    reentrantLock2.unlock();
                    String strM6419a = c3194a.m6419a("defaultGoogleSignInAccount");
                    if (!TextUtils.isEmpty(strM6419a)) {
                        String strM6419a2 = c3194a.m6419a("googleSignInAccount:" + strM6419a);
                        if (strM6419a2 != null) {
                            try {
                                googleSignInAccountM3581j = GoogleSignInAccount.m3581j(strM6419a2);
                            } catch (JSONException unused) {
                                googleSignInAccountM3581j = null;
                            }
                        }
                    }
                    googleSignInAccountM3581j = null;
                } catch (Throwable th) {
                    reentrantLock2.unlock();
                    throw th;
                }
            } else {
                googleSignInAccountM3581j = null;
            }
            Integer num = c4010a.f13602C;
            AbstractC1312l.m3198e(num);
            zat zatVar = new zat(2, account, num.intValue(), googleSignInAccountM3581j);
            C4011b c4011b = (C4011b) c4010a.m3663p();
            zai zaiVar = new zai(1, zatVar);
            Parcel parcelObtain = Parcel.obtain();
            parcelObtain.writeInterfaceToken(c4011b.f5196e);
            int i6 = AbstractC3501a.f11790a;
            parcelObtain.writeInt(1);
            zaiVar.writeToParcel(parcelObtain, 0);
            parcelObtain.writeStrongBinder(this);
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                c4011b.f5195d.transact(12, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
            } finally {
                parcelObtain.recycle();
                parcelObtain2.recycle();
            }
        } catch (RemoteException e5) {
            Log.w("SignInClientImpl", "Remote service probably died when signIn is called");
            try {
                this.f14753e.post(new RunnableC3940a(9, this, new zak(1, new ConnectionResult(8, null), null), z7));
            } catch (RemoteException unused2) {
                Log.wtf("SignInClientImpl", "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", e5);
            }
        }
    }
}
