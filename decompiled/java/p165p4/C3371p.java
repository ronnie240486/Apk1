package p165p4;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableByte;
import androidx.databinding.ObservableChar;
import androidx.databinding.ObservableDouble;
import androidx.databinding.ObservableFloat;
import androidx.databinding.ObservableInt;
import androidx.databinding.ObservableLong;
import androidx.databinding.ObservableShort;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.LaunchOptions;
import com.google.android.gms.cast.TextTrackStyle;
import com.google.android.gms.cast.VastAdsRequest;
import com.google.android.gms.cast.VideoInfo;
import com.google.android.gms.cast.framework.CastOptions;
import com.google.android.gms.cast.framework.media.CastMediaOptions;
import com.google.android.gms.cast.framework.media.ImageHints;
import com.google.android.gms.cast.framework.media.NotificationAction;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import com.google.android.gms.cast.framework.zzj;
import com.google.android.gms.cast.framework.zzl;
import com.google.android.gms.cast.internal.zza;
import com.google.android.gms.cast.internal.zzaa;
import com.google.android.gms.cast.internal.zzac;
import com.google.android.gms.cast.zzat;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.zat;
import com.google.android.gms.common.internal.zav;
import com.google.android.gms.common.zzo;
import com.google.android.gms.common.zzq;
import com.google.android.gms.signin.internal.zaa;
import com.google.android.gms.signin.internal.zag;
import com.google.android.gms.signin.internal.zai;
import com.google.android.gms.signin.internal.zak;
import java.util.ArrayList;
import p143n5.AbstractC3198d;

public final class C3371p implements Parcelable.Creator {

    public final int f11396a;

    public C3371p(int i6) {
        this.f11396a = i6;
    }

    @Override
    public final Object createFromParcel(Parcel parcel) {
        switch (this.f11396a) {
            case 0:
                int iM6447V = AbstractC3198d.m6447V(parcel);
                String strM6463k = null;
                String strM6463k2 = null;
                float fM6434I = 0.0f;
                int iM6436K = 0;
                int iM6436K2 = 0;
                int iM6436K3 = 0;
                int iM6436K4 = 0;
                int iM6436K5 = 0;
                int iM6436K6 = 0;
                int iM6436K7 = 0;
                int iM6436K8 = 0;
                int iM6436K9 = 0;
                while (parcel.dataPosition() < iM6447V) {
                    int i6 = parcel.readInt();
                    switch ((char) i6) {
                        case 2:
                            fM6434I = AbstractC3198d.m6434I(parcel, i6);
                            break;
                        case 3:
                            iM6436K = AbstractC3198d.m6436K(parcel, i6);
                            break;
                        case 4:
                            iM6436K2 = AbstractC3198d.m6436K(parcel, i6);
                            break;
                        case 5:
                            iM6436K3 = AbstractC3198d.m6436K(parcel, i6);
                            break;
                        case 6:
                            iM6436K4 = AbstractC3198d.m6436K(parcel, i6);
                            break;
                        case 7:
                            iM6436K5 = AbstractC3198d.m6436K(parcel, i6);
                            break;
                        case '\b':
                            iM6436K6 = AbstractC3198d.m6436K(parcel, i6);
                            break;
                        case '\t':
                            iM6436K7 = AbstractC3198d.m6436K(parcel, i6);
                            break;
                        case '\n':
                            strM6463k = AbstractC3198d.m6463k(parcel, i6);
                            break;
                        case 11:
                            iM6436K8 = AbstractC3198d.m6436K(parcel, i6);
                            break;
                        case '\f':
                            iM6436K9 = AbstractC3198d.m6436K(parcel, i6);
                            break;
                        case '\r':
                            strM6463k2 = AbstractC3198d.m6463k(parcel, i6);
                            break;
                        default:
                            AbstractC3198d.m6445T(parcel, i6);
                            break;
                    }
                }
                AbstractC3198d.m6470r(parcel, iM6447V);
                return new TextTrackStyle(fM6434I, iM6436K, iM6436K2, iM6436K3, iM6436K4, iM6436K5, iM6436K6, iM6436K7, strM6463k, iM6436K8, iM6436K9, strM6463k2);
            case 1:
                int iM6447V2 = AbstractC3198d.m6447V(parcel);
                String strM6463k3 = null;
                String strM6463k4 = null;
                while (parcel.dataPosition() < iM6447V2) {
                    int i10 = parcel.readInt();
                    char c5 = (char) i10;
                    if (c5 == 2) {
                        strM6463k3 = AbstractC3198d.m6463k(parcel, i10);
                    } else if (c5 != 3) {
                        AbstractC3198d.m6445T(parcel, i10);
                    } else {
                        strM6463k4 = AbstractC3198d.m6463k(parcel, i10);
                    }
                }
                AbstractC3198d.m6470r(parcel, iM6447V2);
                return new VastAdsRequest(strM6463k3, strM6463k4);
            case 2:
                int iM6447V3 = AbstractC3198d.m6447V(parcel);
                int iM6436K10 = 0;
                int iM6436K11 = 0;
                int iM6436K12 = 0;
                while (parcel.dataPosition() < iM6447V3) {
                    int i11 = parcel.readInt();
                    char c8 = (char) i11;
                    if (c8 == 2) {
                        iM6436K10 = AbstractC3198d.m6436K(parcel, i11);
                    } else if (c8 == 3) {
                        iM6436K11 = AbstractC3198d.m6436K(parcel, i11);
                    } else if (c8 != 4) {
                        AbstractC3198d.m6445T(parcel, i11);
                    } else {
                        iM6436K12 = AbstractC3198d.m6436K(parcel, i11);
                    }
                }
                AbstractC3198d.m6470r(parcel, iM6447V3);
                return new VideoInfo(iM6436K10, iM6436K11, iM6436K12);
            case 3:
                int iM6447V4 = AbstractC3198d.m6447V(parcel);
                String strM6463k5 = null;
                String strM6463k6 = null;
                String strM6463k7 = null;
                String strM6463k8 = null;
                String strM6463k9 = null;
                ArrayList arrayListM6468p = null;
                String strM6463k10 = null;
                String strM6463k11 = null;
                String strM6463k12 = null;
                byte[] bArrM6459g = null;
                String strM6463k13 = null;
                zzaa zzaaVar = null;
                Integer numValueOf = null;
                Boolean boolM6432G = null;
                int iM6436K13 = 0;
                int iM6436K14 = 0;
                int iM6436K15 = -1;
                int iM6436K16 = 0;
                boolean zM6431F = false;
                while (parcel.dataPosition() < iM6447V4) {
                    int i12 = parcel.readInt();
                    switch ((char) i12) {
                        case 2:
                            strM6463k5 = AbstractC3198d.m6463k(parcel, i12);
                            break;
                        case 3:
                            strM6463k6 = AbstractC3198d.m6463k(parcel, i12);
                            break;
                        case 4:
                            strM6463k7 = AbstractC3198d.m6463k(parcel, i12);
                            break;
                        case 5:
                            strM6463k8 = AbstractC3198d.m6463k(parcel, i12);
                            break;
                        case 6:
                            strM6463k9 = AbstractC3198d.m6463k(parcel, i12);
                            break;
                        case 7:
                            iM6436K13 = AbstractC3198d.m6436K(parcel, i12);
                            break;
                        case '\b':
                            arrayListM6468p = AbstractC3198d.m6468p(parcel, i12, WebImage.CREATOR);
                            break;
                        case '\t':
                            iM6436K14 = AbstractC3198d.m6436K(parcel, i12);
                            break;
                        case '\n':
                            iM6436K15 = AbstractC3198d.m6436K(parcel, i12);
                            break;
                        case 11:
                            strM6463k10 = AbstractC3198d.m6463k(parcel, i12);
                            break;
                        case '\f':
                            strM6463k11 = AbstractC3198d.m6463k(parcel, i12);
                            break;
                        case '\r':
                            iM6436K16 = AbstractC3198d.m6436K(parcel, i12);
                            break;
                        case 14:
                            strM6463k12 = AbstractC3198d.m6463k(parcel, i12);
                            break;
                        case 15:
                            bArrM6459g = AbstractC3198d.m6459g(parcel, i12);
                            break;
                        case 16:
                            strM6463k13 = AbstractC3198d.m6463k(parcel, i12);
                            break;
                        case 17:
                            zM6431F = AbstractC3198d.m6431F(parcel, i12);
                            break;
                        case 18:
                            zzaaVar = (zzaa) AbstractC3198d.m6462j(parcel, i12, zzaa.CREATOR);
                            break;
                        case 19:
                            int iM6439N = AbstractC3198d.m6439N(parcel, i12);
                            if (iM6439N != 0) {
                                AbstractC3198d.m6451Z(parcel, iM6439N, 4);
                                numValueOf = Integer.valueOf(parcel.readInt());
                            } else {
                                numValueOf = null;
                            }
                            break;
                        case 20:
                            boolM6432G = AbstractC3198d.m6432G(parcel, i12);
                            break;
                        default:
                            AbstractC3198d.m6445T(parcel, i12);
                            break;
                    }
                }
                AbstractC3198d.m6470r(parcel, iM6447V4);
                return new CastDevice(strM6463k5, strM6463k6, strM6463k7, strM6463k8, strM6463k9, iM6436K13, arrayListM6468p, iM6436K14, iM6436K15, strM6463k10, strM6463k11, iM6436K16, strM6463k12, bArrM6459g, strM6463k13, zM6431F, zzaaVar, numValueOf, boolM6432G);
            case 4:
                int iM6447V5 = AbstractC3198d.m6447V(parcel);
                boolean zM6431F2 = false;
                while (parcel.dataPosition() < iM6447V5) {
                    int i13 = parcel.readInt();
                    if (((char) i13) != 2) {
                        AbstractC3198d.m6445T(parcel, i13);
                    } else {
                        zM6431F2 = AbstractC3198d.m6431F(parcel, i13);
                    }
                }
                AbstractC3198d.m6470r(parcel, iM6447V5);
                return new zzj(zM6431F2);
            case 5:
                int iM6447V6 = AbstractC3198d.m6447V(parcel);
                int iM6436K17 = 0;
                while (parcel.dataPosition() < iM6447V6) {
                    int i14 = parcel.readInt();
                    if (((char) i14) != 2) {
                        AbstractC3198d.m6445T(parcel, i14);
                    } else {
                        iM6436K17 = AbstractC3198d.m6436K(parcel, i14);
                    }
                }
                AbstractC3198d.m6470r(parcel, iM6447V6);
                return new zzl(iM6436K17);
            case 6:
                int iM6447V7 = AbstractC3198d.m6447V(parcel);
                String strM6463k14 = null;
                ArrayList arrayListM6466n = null;
                LaunchOptions launchOptions = null;
                CastMediaOptions castMediaOptions = null;
                ArrayList arrayListM6466n2 = null;
                zzj zzjVar = null;
                zzl zzlVar = null;
                double dM6433H = 0.0d;
                boolean zM6431F3 = false;
                boolean zM6431F4 = false;
                boolean zM6431F5 = false;
                boolean zM6431F6 = false;
                boolean zM6431F7 = false;
                boolean zM6431F8 = false;
                boolean zM6431F9 = false;
                boolean zM6431F10 = false;
                boolean zM6431F11 = false;
                boolean zM6431F12 = false;
                while (parcel.dataPosition() < iM6447V7) {
                    int i15 = parcel.readInt();
                    switch ((char) i15) {
                        case 2:
                            strM6463k14 = AbstractC3198d.m6463k(parcel, i15);
                            break;
                        case 3:
                            arrayListM6466n = AbstractC3198d.m6466n(parcel, i15);
                            break;
                        case 4:
                            zM6431F3 = AbstractC3198d.m6431F(parcel, i15);
                            break;
                        case 5:
                            launchOptions = (LaunchOptions) AbstractC3198d.m6462j(parcel, i15, LaunchOptions.CREATOR);
                            break;
                        case 6:
                            zM6431F4 = AbstractC3198d.m6431F(parcel, i15);
                            break;
                        case 7:
                            castMediaOptions = (CastMediaOptions) AbstractC3198d.m6462j(parcel, i15, CastMediaOptions.CREATOR);
                            break;
                        case '\b':
                            zM6431F5 = AbstractC3198d.m6431F(parcel, i15);
                            break;
                        case '\t':
                            dM6433H = AbstractC3198d.m6433H(parcel, i15);
                            break;
                        case '\n':
                            zM6431F6 = AbstractC3198d.m6431F(parcel, i15);
                            break;
                        case 11:
                            zM6431F7 = AbstractC3198d.m6431F(parcel, i15);
                            break;
                        case '\f':
                            zM6431F8 = AbstractC3198d.m6431F(parcel, i15);
                            break;
                        case '\r':
                            arrayListM6466n2 = AbstractC3198d.m6466n(parcel, i15);
                            break;
                        case 14:
                            zM6431F9 = AbstractC3198d.m6431F(parcel, i15);
                            break;
                        case 15:
                            AbstractC3198d.m6436K(parcel, i15);
                            break;
                        case 16:
                            zM6431F10 = AbstractC3198d.m6431F(parcel, i15);
                            break;
                        case 17:
                            zzjVar = (zzj) AbstractC3198d.m6462j(parcel, i15, zzj.CREATOR);
                            break;
                        case 18:
                            zzlVar = (zzl) AbstractC3198d.m6462j(parcel, i15, zzl.CREATOR);
                            break;
                        case 19:
                            zM6431F11 = AbstractC3198d.m6431F(parcel, i15);
                            break;
                        case 20:
                            zM6431F12 = AbstractC3198d.m6431F(parcel, i15);
                            break;
                        default:
                            AbstractC3198d.m6445T(parcel, i15);
                            break;
                    }
                }
                AbstractC3198d.m6470r(parcel, iM6447V7);
                return new CastOptions(strM6463k14, arrayListM6466n, zM6431F3, launchOptions, zM6431F4, castMediaOptions, zM6431F5, dM6433H, zM6431F6, zM6431F7, zM6431F8, arrayListM6466n2, zM6431F9, zM6431F10, zzjVar, zzlVar, zM6431F11, zM6431F12);
            case 7:
                int iM6447V8 = AbstractC3198d.m6447V(parcel);
                String strM6463k15 = null;
                String strM6463k16 = null;
                IBinder iBinderM6435J = null;
                NotificationOptions notificationOptions = null;
                boolean zM6431F13 = false;
                boolean zM6431F14 = false;
                while (parcel.dataPosition() < iM6447V8) {
                    int i16 = parcel.readInt();
                    switch ((char) i16) {
                        case 2:
                            strM6463k15 = AbstractC3198d.m6463k(parcel, i16);
                            break;
                        case 3:
                            strM6463k16 = AbstractC3198d.m6463k(parcel, i16);
                            break;
                        case 4:
                            iBinderM6435J = AbstractC3198d.m6435J(parcel, i16);
                            break;
                        case 5:
                            notificationOptions = (NotificationOptions) AbstractC3198d.m6462j(parcel, i16, NotificationOptions.CREATOR);
                            break;
                        case 6:
                            zM6431F13 = AbstractC3198d.m6431F(parcel, i16);
                            break;
                        case 7:
                            zM6431F14 = AbstractC3198d.m6431F(parcel, i16);
                            break;
                        default:
                            AbstractC3198d.m6445T(parcel, i16);
                            break;
                    }
                }
                AbstractC3198d.m6470r(parcel, iM6447V8);
                return new CastMediaOptions(strM6463k15, strM6463k16, iBinderM6435J, notificationOptions, zM6431F13, zM6431F14);
            case 8:
                int iM6447V9 = AbstractC3198d.m6447V(parcel);
                int iM6436K18 = 0;
                int iM6436K19 = 0;
                int iM6436K20 = 0;
                while (parcel.dataPosition() < iM6447V9) {
                    int i17 = parcel.readInt();
                    char c10 = (char) i17;
                    if (c10 == 2) {
                        iM6436K18 = AbstractC3198d.m6436K(parcel, i17);
                    } else if (c10 == 3) {
                        iM6436K19 = AbstractC3198d.m6436K(parcel, i17);
                    } else if (c10 != 4) {
                        AbstractC3198d.m6445T(parcel, i17);
                    } else {
                        iM6436K20 = AbstractC3198d.m6436K(parcel, i17);
                    }
                }
                AbstractC3198d.m6470r(parcel, iM6447V9);
                return new ImageHints(iM6436K18, iM6436K19, iM6436K20);
            case 9:
                int iM6447V10 = AbstractC3198d.m6447V(parcel);
                String strM6463k17 = null;
                String strM6463k18 = null;
                int iM6436K21 = 0;
                while (parcel.dataPosition() < iM6447V10) {
                    int i18 = parcel.readInt();
                    char c11 = (char) i18;
                    if (c11 == 2) {
                        strM6463k17 = AbstractC3198d.m6463k(parcel, i18);
                    } else if (c11 == 3) {
                        iM6436K21 = AbstractC3198d.m6436K(parcel, i18);
                    } else if (c11 != 4) {
                        AbstractC3198d.m6445T(parcel, i18);
                    } else {
                        strM6463k18 = AbstractC3198d.m6463k(parcel, i18);
                    }
                }
                AbstractC3198d.m6470r(parcel, iM6447V10);
                return new NotificationAction(strM6463k17, iM6436K21, strM6463k18);
            case 10:
                int iM6447V11 = AbstractC3198d.m6447V(parcel);
                ArrayList arrayListM6466n3 = null;
                int[] iArrM6460h = null;
                String strM6463k19 = null;
                IBinder iBinderM6435J2 = null;
                long jM6438M = 0;
                int iM6436K22 = 0;
                int iM6436K23 = 0;
                int iM6436K24 = 0;
                int iM6436K25 = 0;
                int iM6436K26 = 0;
                int iM6436K27 = 0;
                int iM6436K28 = 0;
                int iM6436K29 = 0;
                int iM6436K30 = 0;
                int iM6436K31 = 0;
                int iM6436K32 = 0;
                int iM6436K33 = 0;
                int iM6436K34 = 0;
                int iM6436K35 = 0;
                int iM6436K36 = 0;
                int iM6436K37 = 0;
                int iM6436K38 = 0;
                int iM6436K39 = 0;
                int iM6436K40 = 0;
                int iM6436K41 = 0;
                int iM6436K42 = 0;
                int iM6436K43 = 0;
                int iM6436K44 = 0;
                int iM6436K45 = 0;
                int iM6436K46 = 0;
                int iM6436K47 = 0;
                int iM6436K48 = 0;
                boolean zM6431F15 = false;
                boolean zM6431F16 = false;
                while (parcel.dataPosition() < iM6447V11) {
                    int i19 = parcel.readInt();
                    switch ((char) i19) {
                        case 2:
                            arrayListM6466n3 = AbstractC3198d.m6466n(parcel, i19);
                            break;
                        case 3:
                            iArrM6460h = AbstractC3198d.m6460h(parcel, i19);
                            break;
                        case 4:
                            jM6438M = AbstractC3198d.m6438M(parcel, i19);
                            break;
                        case 5:
                            strM6463k19 = AbstractC3198d.m6463k(parcel, i19);
                            break;
                        case 6:
                            iM6436K22 = AbstractC3198d.m6436K(parcel, i19);
                            break;
                        case 7:
                            iM6436K23 = AbstractC3198d.m6436K(parcel, i19);
                            break;
                        case '\b':
                            iM6436K24 = AbstractC3198d.m6436K(parcel, i19);
                            break;
                        case '\t':
                            iM6436K25 = AbstractC3198d.m6436K(parcel, i19);
                            break;
                        case '\n':
                            iM6436K26 = AbstractC3198d.m6436K(parcel, i19);
                            break;
                        case 11:
                            iM6436K27 = AbstractC3198d.m6436K(parcel, i19);
                            break;
                        case '\f':
                            iM6436K28 = AbstractC3198d.m6436K(parcel, i19);
                            break;
                        case '\r':
                            iM6436K29 = AbstractC3198d.m6436K(parcel, i19);
                            break;
                        case 14:
                            iM6436K30 = AbstractC3198d.m6436K(parcel, i19);
                            break;
                        case 15:
                            iM6436K31 = AbstractC3198d.m6436K(parcel, i19);
                            break;
                        case 16:
                            iM6436K32 = AbstractC3198d.m6436K(parcel, i19);
                            break;
                        case 17:
                            iM6436K33 = AbstractC3198d.m6436K(parcel, i19);
                            break;
                        case 18:
                            iM6436K34 = AbstractC3198d.m6436K(parcel, i19);
                            break;
                        case 19:
                            iM6436K35 = AbstractC3198d.m6436K(parcel, i19);
                            break;
                        case 20:
                            iM6436K36 = AbstractC3198d.m6436K(parcel, i19);
                            break;
                        case 21:
                            iM6436K37 = AbstractC3198d.m6436K(parcel, i19);
                            break;
                        case 22:
                            iM6436K38 = AbstractC3198d.m6436K(parcel, i19);
                            break;
                        case 23:
                            iM6436K39 = AbstractC3198d.m6436K(parcel, i19);
                            break;
                        case 24:
                            iM6436K40 = AbstractC3198d.m6436K(parcel, i19);
                            break;
                        case 25:
                            iM6436K41 = AbstractC3198d.m6436K(parcel, i19);
                            break;
                        case 26:
                            iM6436K42 = AbstractC3198d.m6436K(parcel, i19);
                            break;
                        case 27:
                            iM6436K43 = AbstractC3198d.m6436K(parcel, i19);
                            break;
                        case 28:
                            iM6436K44 = AbstractC3198d.m6436K(parcel, i19);
                            break;
                        case 29:
                            iM6436K45 = AbstractC3198d.m6436K(parcel, i19);
                            break;
                        case 30:
                            iM6436K46 = AbstractC3198d.m6436K(parcel, i19);
                            break;
                        case 31:
                            iM6436K47 = AbstractC3198d.m6436K(parcel, i19);
                            break;
                        case ' ':
                            iM6436K48 = AbstractC3198d.m6436K(parcel, i19);
                            break;
                        case '!':
                            iBinderM6435J2 = AbstractC3198d.m6435J(parcel, i19);
                            break;
                        case '\"':
                            zM6431F15 = AbstractC3198d.m6431F(parcel, i19);
                            break;
                        case '#':
                            zM6431F16 = AbstractC3198d.m6431F(parcel, i19);
                            break;
                        default:
                            AbstractC3198d.m6445T(parcel, i19);
                            break;
                    }
                }
                AbstractC3198d.m6470r(parcel, iM6447V11);
                return new NotificationOptions(arrayListM6466n3, iArrM6460h, jM6438M, strM6463k19, iM6436K22, iM6436K23, iM6436K24, iM6436K25, iM6436K26, iM6436K27, iM6436K28, iM6436K29, iM6436K30, iM6436K31, iM6436K32, iM6436K33, iM6436K34, iM6436K35, iM6436K36, iM6436K37, iM6436K38, iM6436K39, iM6436K40, iM6436K41, iM6436K42, iM6436K43, iM6436K44, iM6436K45, iM6436K46, iM6436K47, iM6436K48, iBinderM6435J2, zM6431F15, zM6431F16);
            case 11:
                int iM6447V12 = AbstractC3198d.m6447V(parcel);
                String strM6463k20 = null;
                String strM6463k21 = null;
                String strM6463k22 = null;
                String strM6463k23 = null;
                String strM6463k24 = null;
                int iM6436K49 = 0;
                boolean zM6431F17 = false;
                boolean zM6431F18 = false;
                boolean zM6431F19 = false;
                while (parcel.dataPosition() < iM6447V12) {
                    int i20 = parcel.readInt();
                    switch ((char) i20) {
                        case 2:
                            iM6436K49 = AbstractC3198d.m6436K(parcel, i20);
                            break;
                        case 3:
                            zM6431F17 = AbstractC3198d.m6431F(parcel, i20);
                            break;
                        case 4:
                            zM6431F18 = AbstractC3198d.m6431F(parcel, i20);
                            break;
                        case 5:
                            strM6463k20 = AbstractC3198d.m6463k(parcel, i20);
                            break;
                        case 6:
                            strM6463k21 = AbstractC3198d.m6463k(parcel, i20);
                            break;
                        case 7:
                            strM6463k22 = AbstractC3198d.m6463k(parcel, i20);
                            break;
                        case '\b':
                            strM6463k23 = AbstractC3198d.m6463k(parcel, i20);
                            break;
                        case '\t':
                            strM6463k24 = AbstractC3198d.m6463k(parcel, i20);
                            break;
                        case '\n':
                            zM6431F19 = AbstractC3198d.m6431F(parcel, i20);
                            break;
                        default:
                            AbstractC3198d.m6445T(parcel, i20);
                            break;
                    }
                }
                AbstractC3198d.m6470r(parcel, iM6447V12);
                return new zzaa(iM6436K49, zM6431F17, zM6431F18, strM6463k20, strM6463k21, strM6463k22, strM6463k23, strM6463k24, zM6431F19);
            case 12:
                int iM6447V13 = AbstractC3198d.m6447V(parcel);
                double dM6433H2 = 0.0d;
                ApplicationMetadata applicationMetadata = null;
                zzat zzatVar = null;
                boolean zM6431F20 = false;
                int iM6436K50 = 0;
                int iM6436K51 = 0;
                double dM6433H3 = 0.0d;
                while (parcel.dataPosition() < iM6447V13) {
                    int i21 = parcel.readInt();
                    switch ((char) i21) {
                        case 2:
                            dM6433H2 = AbstractC3198d.m6433H(parcel, i21);
                            break;
                        case 3:
                            zM6431F20 = AbstractC3198d.m6431F(parcel, i21);
                            break;
                        case 4:
                            iM6436K50 = AbstractC3198d.m6436K(parcel, i21);
                            break;
                        case 5:
                            applicationMetadata = (ApplicationMetadata) AbstractC3198d.m6462j(parcel, i21, ApplicationMetadata.CREATOR);
                            break;
                        case 6:
                            iM6436K51 = AbstractC3198d.m6436K(parcel, i21);
                            break;
                        case 7:
                            zzatVar = (zzat) AbstractC3198d.m6462j(parcel, i21, zzat.CREATOR);
                            break;
                        case '\b':
                            dM6433H3 = AbstractC3198d.m6433H(parcel, i21);
                            break;
                        default:
                            AbstractC3198d.m6445T(parcel, i21);
                            break;
                    }
                }
                AbstractC3198d.m6470r(parcel, iM6447V13);
                zzac zzacVar = new zzac();
                zzacVar.f4956a = dM6433H2;
                zzacVar.f4957b = zM6431F20;
                zzacVar.f4958c = iM6436K50;
                zzacVar.f4959d = applicationMetadata;
                zzacVar.f4960e = iM6436K51;
                zzacVar.f4961f = zzatVar;
                zzacVar.f4962g = dM6433H3;
                return zzacVar;
            case 13:
                int iM6447V14 = AbstractC3198d.m6447V(parcel);
                String strM6463k25 = null;
                while (parcel.dataPosition() < iM6447V14) {
                    int i22 = parcel.readInt();
                    if (((char) i22) != 2) {
                        AbstractC3198d.m6445T(parcel, i22);
                    } else {
                        strM6463k25 = AbstractC3198d.m6463k(parcel, i22);
                    }
                }
                AbstractC3198d.m6470r(parcel, iM6447V14);
                return new zza(strM6463k25);
            case 14:
                int iM6447V15 = AbstractC3198d.m6447V(parcel);
                Intent intent = null;
                int iM6436K52 = 0;
                int iM6436K53 = 0;
                while (parcel.dataPosition() < iM6447V15) {
                    int i23 = parcel.readInt();
                    char c12 = (char) i23;
                    if (c12 == 1) {
                        iM6436K52 = AbstractC3198d.m6436K(parcel, i23);
                    } else if (c12 == 2) {
                        iM6436K53 = AbstractC3198d.m6436K(parcel, i23);
                    } else if (c12 != 3) {
                        AbstractC3198d.m6445T(parcel, i23);
                    } else {
                        intent = (Intent) AbstractC3198d.m6462j(parcel, i23, Intent.CREATOR);
                    }
                }
                AbstractC3198d.m6470r(parcel, iM6447V15);
                return new zaa(iM6436K52, iM6436K53, intent);
            case 15:
                int iM6447V16 = AbstractC3198d.m6447V(parcel);
                ArrayList arrayListM6466n4 = null;
                String strM6463k26 = null;
                while (parcel.dataPosition() < iM6447V16) {
                    int i24 = parcel.readInt();
                    char c13 = (char) i24;
                    if (c13 == 1) {
                        arrayListM6466n4 = AbstractC3198d.m6466n(parcel, i24);
                    } else if (c13 != 2) {
                        AbstractC3198d.m6445T(parcel, i24);
                    } else {
                        strM6463k26 = AbstractC3198d.m6463k(parcel, i24);
                    }
                }
                AbstractC3198d.m6470r(parcel, iM6447V16);
                return new zag(arrayListM6466n4, strM6463k26);
            case 16:
                int iM6447V17 = AbstractC3198d.m6447V(parcel);
                zat zatVar = null;
                int iM6436K54 = 0;
                while (parcel.dataPosition() < iM6447V17) {
                    int i25 = parcel.readInt();
                    char c14 = (char) i25;
                    if (c14 == 1) {
                        iM6436K54 = AbstractC3198d.m6436K(parcel, i25);
                    } else if (c14 != 2) {
                        AbstractC3198d.m6445T(parcel, i25);
                    } else {
                        zatVar = (zat) AbstractC3198d.m6462j(parcel, i25, zat.CREATOR);
                    }
                }
                AbstractC3198d.m6470r(parcel, iM6447V17);
                return new zai(iM6436K54, zatVar);
            case 17:
                int iM6447V18 = AbstractC3198d.m6447V(parcel);
                ConnectionResult connectionResult = null;
                zav zavVar = null;
                int iM6436K55 = 0;
                while (parcel.dataPosition() < iM6447V18) {
                    int i26 = parcel.readInt();
                    char c15 = (char) i26;
                    if (c15 == 1) {
                        iM6436K55 = AbstractC3198d.m6436K(parcel, i26);
                    } else if (c15 == 2) {
                        connectionResult = (ConnectionResult) AbstractC3198d.m6462j(parcel, i26, ConnectionResult.CREATOR);
                    } else if (c15 != 3) {
                        AbstractC3198d.m6445T(parcel, i26);
                    } else {
                        zavVar = (zav) AbstractC3198d.m6462j(parcel, i26, zav.CREATOR);
                    }
                }
                AbstractC3198d.m6470r(parcel, iM6447V18);
                return new zak(iM6436K55, connectionResult, zavVar);
            case 18:
                boolean z7 = parcel.readInt() == 1;
                ObservableBoolean observableBoolean = new ObservableBoolean();
                observableBoolean.f1694b = z7;
                return observableBoolean;
            case 19:
                byte b8 = parcel.readByte();
                ObservableByte observableByte = new ObservableByte();
                observableByte.f1695b = b8;
                return observableByte;
            case 20:
                char c16 = (char) parcel.readInt();
                ObservableChar observableChar = new ObservableChar();
                observableChar.f1696b = c16;
                return observableChar;
            case 21:
                double d = parcel.readDouble();
                ObservableDouble observableDouble = new ObservableDouble();
                observableDouble.f1697b = d;
                return observableDouble;
            case 22:
                float f = parcel.readFloat();
                ObservableFloat observableFloat = new ObservableFloat();
                observableFloat.f1698b = f;
                return observableFloat;
            case 23:
                int i27 = parcel.readInt();
                ObservableInt observableInt = new ObservableInt();
                observableInt.f1699b = i27;
                return observableInt;
            case 24:
                long j10 = parcel.readLong();
                ObservableLong observableLong = new ObservableLong();
                observableLong.f1700b = j10;
                return observableLong;
            case 25:
                short s10 = (short) parcel.readInt();
                ObservableShort observableShort = new ObservableShort();
                observableShort.f1702b = s10;
                return observableShort;
            case 26:
                int iM6447V19 = AbstractC3198d.m6447V(parcel);
                PendingIntent pendingIntent = null;
                String strM6463k27 = null;
                int iM6436K56 = 0;
                int iM6436K57 = 0;
                while (parcel.dataPosition() < iM6447V19) {
                    int i28 = parcel.readInt();
                    char c17 = (char) i28;
                    if (c17 == 1) {
                        iM6436K56 = AbstractC3198d.m6436K(parcel, i28);
                    } else if (c17 == 2) {
                        iM6436K57 = AbstractC3198d.m6436K(parcel, i28);
                    } else if (c17 == 3) {
                        pendingIntent = (PendingIntent) AbstractC3198d.m6462j(parcel, i28, PendingIntent.CREATOR);
                    } else if (c17 != 4) {
                        AbstractC3198d.m6445T(parcel, i28);
                    } else {
                        strM6463k27 = AbstractC3198d.m6463k(parcel, i28);
                    }
                }
                AbstractC3198d.m6470r(parcel, iM6447V19);
                return new ConnectionResult(iM6436K56, iM6436K57, pendingIntent, strM6463k27);
            case 27:
                int iM6447V20 = AbstractC3198d.m6447V(parcel);
                long jM6438M2 = -1;
                int iM6436K58 = 0;
                String strM6463k28 = null;
                while (parcel.dataPosition() < iM6447V20) {
                    int i29 = parcel.readInt();
                    char c18 = (char) i29;
                    if (c18 == 1) {
                        strM6463k28 = AbstractC3198d.m6463k(parcel, i29);
                    } else if (c18 == 2) {
                        iM6436K58 = AbstractC3198d.m6436K(parcel, i29);
                    } else if (c18 != 3) {
                        AbstractC3198d.m6445T(parcel, i29);
                    } else {
                        jM6438M2 = AbstractC3198d.m6438M(parcel, i29);
                    }
                }
                AbstractC3198d.m6470r(parcel, iM6447V20);
                return new Feature(strM6463k28, iM6436K58, jM6438M2);
            case 28:
                int iM6447V21 = AbstractC3198d.m6447V(parcel);
                String strM6463k29 = null;
                IBinder iBinderM6435J3 = null;
                boolean zM6431F21 = false;
                boolean zM6431F22 = false;
                boolean zM6431F23 = false;
                boolean zM6431F24 = false;
                while (parcel.dataPosition() < iM6447V21) {
                    int i30 = parcel.readInt();
                    switch ((char) i30) {
                        case 1:
                            strM6463k29 = AbstractC3198d.m6463k(parcel, i30);
                            break;
                        case 2:
                            zM6431F21 = AbstractC3198d.m6431F(parcel, i30);
                            break;
                        case 3:
                            zM6431F22 = AbstractC3198d.m6431F(parcel, i30);
                            break;
                        case 4:
                            iBinderM6435J3 = AbstractC3198d.m6435J(parcel, i30);
                            break;
                        case 5:
                            zM6431F23 = AbstractC3198d.m6431F(parcel, i30);
                            break;
                        case 6:
                            zM6431F24 = AbstractC3198d.m6431F(parcel, i30);
                            break;
                        default:
                            AbstractC3198d.m6445T(parcel, i30);
                            break;
                    }
                }
                AbstractC3198d.m6470r(parcel, iM6447V21);
                return new zzo(strM6463k29, zM6431F21, zM6431F22, iBinderM6435J3, zM6431F23, zM6431F24);
            default:
                int iM6447V22 = AbstractC3198d.m6447V(parcel);
                boolean zM6431F25 = false;
                String strM6463k30 = null;
                int iM6436K59 = 0;
                int iM6436K60 = 0;
                while (parcel.dataPosition() < iM6447V22) {
                    int i31 = parcel.readInt();
                    char c19 = (char) i31;
                    if (c19 == 1) {
                        zM6431F25 = AbstractC3198d.m6431F(parcel, i31);
                    } else if (c19 == 2) {
                        strM6463k30 = AbstractC3198d.m6463k(parcel, i31);
                    } else if (c19 == 3) {
                        iM6436K59 = AbstractC3198d.m6436K(parcel, i31);
                    } else if (c19 != 4) {
                        AbstractC3198d.m6445T(parcel, i31);
                    } else {
                        iM6436K60 = AbstractC3198d.m6436K(parcel, i31);
                    }
                }
                AbstractC3198d.m6470r(parcel, iM6447V22);
                return new zzq(strM6463k30, iM6436K59, iM6436K60, zM6431F25);
        }
    }

    @Override
    public final Object[] newArray(int i6) {
        switch (this.f11396a) {
            case 0:
                return new TextTrackStyle[i6];
            case 1:
                return new VastAdsRequest[i6];
            case 2:
                return new VideoInfo[i6];
            case 3:
                return new CastDevice[i6];
            case 4:
                return new zzj[i6];
            case 5:
                return new zzl[i6];
            case 6:
                return new CastOptions[i6];
            case 7:
                return new CastMediaOptions[i6];
            case 8:
                return new ImageHints[i6];
            case 9:
                return new NotificationAction[i6];
            case 10:
                return new NotificationOptions[i6];
            case 11:
                return new zzaa[i6];
            case 12:
                return new zzac[i6];
            case 13:
                return new zza[i6];
            case 14:
                return new zaa[i6];
            case 15:
                return new zag[i6];
            case 16:
                return new zai[i6];
            case 17:
                return new zak[i6];
            case 18:
                return new ObservableBoolean[i6];
            case 19:
                return new ObservableByte[i6];
            case 20:
                return new ObservableChar[i6];
            case 21:
                return new ObservableDouble[i6];
            case 22:
                return new ObservableFloat[i6];
            case 23:
                return new ObservableInt[i6];
            case 24:
                return new ObservableLong[i6];
            case 25:
                return new ObservableShort[i6];
            case 26:
                return new ConnectionResult[i6];
            case 27:
                return new Feature[i6];
            case 28:
                return new zzo[i6];
            default:
                return new zzq[i6];
        }
    }
}
