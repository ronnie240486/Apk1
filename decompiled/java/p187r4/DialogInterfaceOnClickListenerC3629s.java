package p187r4;

import android.app.AlertDialog;
import android.content.DialogInterface;
import com.google.android.gms.cast.MediaTrack;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import p018b5.AbstractC1312l;

public final class DialogInterfaceOnClickListenerC3629s implements DialogInterface.OnClickListener {

    public final ViewOnClickListenerC3631u f12194a;

    public final ViewOnClickListenerC3631u f12195b;

    public final C3617g f12196c;

    public DialogInterfaceOnClickListenerC3629s(C3617g c3617g, ViewOnClickListenerC3631u viewOnClickListenerC3631u, ViewOnClickListenerC3631u viewOnClickListenerC3631u2) {
        this.f12194a = viewOnClickListenerC3631u;
        this.f12195b = viewOnClickListenerC3631u2;
        this.f12196c = c3617g;
    }

    @Override
    public final void onClick(DialogInterface dialogInterface, int i6) {
        C3617g c3617g = this.f12196c;
        if (!c3617g.f12158k0) {
            AlertDialog alertDialog = c3617g.f12162o0;
            if (alertDialog != null) {
                alertDialog.cancel();
                c3617g.f12162o0 = null;
                return;
            }
            return;
        }
        C3616f c3616f = c3617g.f12163p0;
        AbstractC1312l.m3198e(c3616f);
        if (!c3616f.m7305i()) {
            AlertDialog alertDialog2 = c3617g.f12162o0;
            if (alertDialog2 != null) {
                alertDialog2.cancel();
                c3617g.f12162o0 = null;
                return;
            }
            return;
        }
        ArrayList arrayList = new ArrayList();
        ViewOnClickListenerC3631u viewOnClickListenerC3631u = this.f12194a;
        int i10 = viewOnClickListenerC3631u.f12200b;
        MediaTrack mediaTrack = (i10 < 0 || i10 >= viewOnClickListenerC3631u.getCount()) ? null : (MediaTrack) viewOnClickListenerC3631u.getItem(viewOnClickListenerC3631u.f12200b);
        if (mediaTrack != null) {
            long j10 = mediaTrack.f4728a;
            if (j10 != -1) {
                arrayList.add(Long.valueOf(j10));
            }
        }
        ViewOnClickListenerC3631u viewOnClickListenerC3631u2 = this.f12195b;
        int i11 = viewOnClickListenerC3631u2.f12200b;
        MediaTrack mediaTrack2 = (i11 < 0 || i11 >= viewOnClickListenerC3631u2.getCount()) ? null : (MediaTrack) viewOnClickListenerC3631u2.getItem(viewOnClickListenerC3631u2.f12200b);
        if (mediaTrack2 != null) {
            arrayList.add(Long.valueOf(mediaTrack2.f4728a));
        }
        long[] jArr = c3617g.f12161n0;
        if (jArr != null && jArr.length > 0) {
            HashSet hashSet = new HashSet();
            Iterator it = c3617g.f12160m0.iterator();
            while (it.hasNext()) {
                hashSet.add(Long.valueOf(((MediaTrack) it.next()).f4728a));
            }
            Iterator it2 = c3617g.f12159l0.iterator();
            while (it2.hasNext()) {
                hashSet.add(Long.valueOf(((MediaTrack) it2.next()).f4728a));
            }
            for (long j11 : jArr) {
                Long lValueOf = Long.valueOf(j11);
                if (!hashSet.contains(lValueOf)) {
                    arrayList.add(lValueOf);
                }
            }
        }
        long[] jArr2 = new long[arrayList.size()];
        for (int i12 = 0; i12 < arrayList.size(); i12++) {
            jArr2[i12] = ((Long) arrayList.get(i12)).longValue();
        }
        Arrays.sort(jArr2);
        AbstractC1312l.m3195b("Must be called from the main thread.");
        if (c3616f.m7296F()) {
            C3616f.m7289G(new C3619i(c3616f, jArr2, 3));
        } else {
            C3616f.m7290x();
        }
        AlertDialog alertDialog3 = c3617g.f12162o0;
        if (alertDialog3 != null) {
            alertDialog3.cancel();
            c3617g.f12162o0 = null;
        }
    }
}
