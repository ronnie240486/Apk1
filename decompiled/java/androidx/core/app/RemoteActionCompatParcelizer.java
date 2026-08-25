package androidx.core.app;

import android.app.PendingIntent;
import android.os.Parcel;
import android.text.TextUtils;
import androidx.core.graphics.drawable.IconCompat;
import p003a2.AbstractC0033b;
import p003a2.C0034c;
import p003a2.InterfaceC0035d;

public class RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(AbstractC0033b abstractC0033b) {
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
        InterfaceC0035d interfaceC0035dM186h = remoteActionCompat.f1465a;
        if (abstractC0033b.mo183e(1)) {
            interfaceC0035dM186h = abstractC0033b.m186h();
        }
        remoteActionCompat.f1465a = (IconCompat) interfaceC0035dM186h;
        CharSequence charSequence = remoteActionCompat.f1466b;
        if (abstractC0033b.mo183e(2)) {
            charSequence = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(((C0034c) abstractC0033b).f99e);
        }
        remoteActionCompat.f1466b = charSequence;
        CharSequence charSequence2 = remoteActionCompat.f1467c;
        if (abstractC0033b.mo183e(3)) {
            charSequence2 = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(((C0034c) abstractC0033b).f99e);
        }
        remoteActionCompat.f1467c = charSequence2;
        remoteActionCompat.f1468d = (PendingIntent) abstractC0033b.m185g(remoteActionCompat.f1468d, 4);
        boolean z7 = remoteActionCompat.f1469e;
        if (abstractC0033b.mo183e(5)) {
            z7 = ((C0034c) abstractC0033b).f99e.readInt() != 0;
        }
        remoteActionCompat.f1469e = z7;
        boolean z10 = remoteActionCompat.f1470f;
        if (abstractC0033b.mo183e(6)) {
            z10 = ((C0034c) abstractC0033b).f99e.readInt() != 0;
        }
        remoteActionCompat.f1470f = z10;
        return remoteActionCompat;
    }

    public static void write(RemoteActionCompat remoteActionCompat, AbstractC0033b abstractC0033b) {
        abstractC0033b.getClass();
        IconCompat iconCompat = remoteActionCompat.f1465a;
        abstractC0033b.mo187i(1);
        abstractC0033b.m190l(iconCompat);
        CharSequence charSequence = remoteActionCompat.f1466b;
        abstractC0033b.mo187i(2);
        Parcel parcel = ((C0034c) abstractC0033b).f99e;
        TextUtils.writeToParcel(charSequence, parcel, 0);
        CharSequence charSequence2 = remoteActionCompat.f1467c;
        abstractC0033b.mo187i(3);
        TextUtils.writeToParcel(charSequence2, parcel, 0);
        abstractC0033b.m189k(remoteActionCompat.f1468d, 4);
        boolean z7 = remoteActionCompat.f1469e;
        abstractC0033b.mo187i(5);
        parcel.writeInt(z7 ? 1 : 0);
        boolean z10 = remoteActionCompat.f1470f;
        abstractC0033b.mo187i(6);
        parcel.writeInt(z10 ? 1 : 0);
    }
}
