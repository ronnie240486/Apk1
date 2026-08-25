package p173q1;

import android.content.Intent;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;

public final class C3438q extends AbstractC3433o0 {

    public final Messenger f11627a;

    public final int f11628b;

    public C3438q(String str, Intent intent, Messenger messenger, int i6) {
        this.f11627a = messenger;
        this.f11628b = i6;
    }

    public static void m7016c(Messenger messenger, int i6, int i10, Bundle bundle, Bundle bundle2) {
        Message messageObtain = Message.obtain();
        messageObtain.what = i6;
        messageObtain.arg1 = i10;
        messageObtain.arg2 = 0;
        messageObtain.obj = bundle;
        messageObtain.setData(bundle2);
        try {
            messenger.send(messageObtain);
        } catch (DeadObjectException unused) {
        } catch (RemoteException e5) {
            Log.e("MR2ProviderService", "Could not send message to the client.", e5);
        }
    }

    @Override
    public final void mo6959a(String str, Bundle bundle) {
        int i6 = C3452v.f11690f;
        Messenger messenger = this.f11627a;
        int i10 = this.f11628b;
        if (str == null) {
            m7016c(messenger, 4, i10, bundle, null);
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString("error", str);
        m7016c(messenger, 4, i10, bundle, bundle2);
    }

    @Override
    public final void mo6960b(Bundle bundle) {
        int i6 = C3452v.f11690f;
        m7016c(this.f11627a, 3, this.f11628b, bundle, null);
    }
}
