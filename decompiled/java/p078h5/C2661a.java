package p078h5;

import android.accounts.Account;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import coil.memory.MemoryCache$Key;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable;
import com.google.android.gms.cast.AdBreakClipInfo;
import com.google.android.gms.cast.AdBreakInfo;
import com.google.android.gms.cast.AdBreakStatus;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.cast.CredentialsData;
import com.google.android.gms.cast.LaunchOptions;
import com.google.android.gms.cast.MediaError;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaLiveSeekableRange;
import com.google.android.gms.cast.MediaLoadRequestData;
import com.google.android.gms.cast.MediaMetadata;
import com.google.android.gms.cast.MediaQueueContainerMetadata;
import com.google.android.gms.cast.MediaQueueData;
import com.google.android.gms.cast.MediaQueueItem;
import com.google.android.gms.cast.MediaStatus;
import com.google.android.gms.cast.MediaTrack;
import com.google.android.gms.cast.SessionState;
import com.google.android.gms.cast.TextTrackStyle;
import com.google.android.gms.cast.VastAdsRequest;
import com.google.android.gms.cast.VideoInfo;
import com.google.android.gms.cast.zzar;
import com.google.android.gms.cast.zzat;
import com.google.android.gms.cast.zzbs;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.server.converter.StringToIntConverter;
import com.google.android.gms.common.server.converter.zac;
import com.google.android.gms.common.server.response.FastJsonResponse$Field;
import com.google.android.gms.common.server.response.SafeParcelResponse;
import com.google.android.gms.common.server.response.zal;
import com.google.android.gms.common.server.response.zam;
import com.google.android.gms.common.server.response.zan;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import p103j9.AbstractC2796i;
import p143n5.AbstractC3198d;
import p230v4.AbstractC3987a;

public final class C2661a implements Parcelable.Creator {

    public final int f9290a;

    public C2661a(int i6) {
        this.f9290a = i6;
    }

    @Override
    public final Object createFromParcel(Parcel parcel) {
        switch (this.f9290a) {
            case 0:
                int iM6447V = AbstractC3198d.m6447V(parcel);
                ArrayList arrayListM6468p = null;
                int iM6436K = 0;
                while (parcel.dataPosition() < iM6447V) {
                    int i6 = parcel.readInt();
                    char c5 = (char) i6;
                    if (c5 == 1) {
                        iM6436K = AbstractC3198d.m6436K(parcel, i6);
                    } else if (c5 != 2) {
                        AbstractC3198d.m6445T(parcel, i6);
                    } else {
                        arrayListM6468p = AbstractC3198d.m6468p(parcel, i6, zac.CREATOR);
                    }
                }
                AbstractC3198d.m6470r(parcel, iM6447V);
                return new StringToIntConverter(iM6436K, arrayListM6468p);
            case 1:
                int iM6447V2 = AbstractC3198d.m6447V(parcel);
                int iM6436K2 = 0;
                String strM6463k = null;
                int iM6436K3 = 0;
                while (parcel.dataPosition() < iM6447V2) {
                    int i10 = parcel.readInt();
                    char c8 = (char) i10;
                    if (c8 == 1) {
                        iM6436K2 = AbstractC3198d.m6436K(parcel, i10);
                    } else if (c8 == 2) {
                        strM6463k = AbstractC3198d.m6463k(parcel, i10);
                    } else if (c8 != 3) {
                        AbstractC3198d.m6445T(parcel, i10);
                    } else {
                        iM6436K3 = AbstractC3198d.m6436K(parcel, i10);
                    }
                }
                AbstractC3198d.m6470r(parcel, iM6447V2);
                return new zac(iM6436K2, iM6436K3, strM6463k);
            case 2:
                int iM6447V3 = AbstractC3198d.m6447V(parcel);
                String strM6463k2 = null;
                FastJsonResponse$Field fastJsonResponse$Field = null;
                int iM6436K4 = 0;
                while (parcel.dataPosition() < iM6447V3) {
                    int i11 = parcel.readInt();
                    char c10 = (char) i11;
                    if (c10 == 1) {
                        iM6436K4 = AbstractC3198d.m6436K(parcel, i11);
                    } else if (c10 == 2) {
                        strM6463k2 = AbstractC3198d.m6463k(parcel, i11);
                    } else if (c10 != 3) {
                        AbstractC3198d.m6445T(parcel, i11);
                    } else {
                        fastJsonResponse$Field = (FastJsonResponse$Field) AbstractC3198d.m6462j(parcel, i11, FastJsonResponse$Field.CREATOR);
                    }
                }
                AbstractC3198d.m6470r(parcel, iM6447V3);
                return new zam(iM6436K4, strM6463k2, fastJsonResponse$Field);
            case 3:
                int iM6447V4 = AbstractC3198d.m6447V(parcel);
                ArrayList arrayListM6468p2 = null;
                String strM6463k3 = null;
                int iM6436K5 = 0;
                while (parcel.dataPosition() < iM6447V4) {
                    int i12 = parcel.readInt();
                    char c11 = (char) i12;
                    if (c11 == 1) {
                        iM6436K5 = AbstractC3198d.m6436K(parcel, i12);
                    } else if (c11 == 2) {
                        arrayListM6468p2 = AbstractC3198d.m6468p(parcel, i12, zal.CREATOR);
                    } else if (c11 != 3) {
                        AbstractC3198d.m6445T(parcel, i12);
                    } else {
                        strM6463k3 = AbstractC3198d.m6463k(parcel, i12);
                    }
                }
                AbstractC3198d.m6470r(parcel, iM6447V4);
                return new zan(iM6436K5, strM6463k3, arrayListM6468p2);
            case 4:
                int iM6447V5 = AbstractC3198d.m6447V(parcel);
                String strM6463k4 = null;
                ArrayList arrayListM6468p3 = null;
                int iM6436K6 = 0;
                while (parcel.dataPosition() < iM6447V5) {
                    int i13 = parcel.readInt();
                    char c12 = (char) i13;
                    if (c12 == 1) {
                        iM6436K6 = AbstractC3198d.m6436K(parcel, i13);
                    } else if (c12 == 2) {
                        strM6463k4 = AbstractC3198d.m6463k(parcel, i13);
                    } else if (c12 != 3) {
                        AbstractC3198d.m6445T(parcel, i13);
                    } else {
                        arrayListM6468p3 = AbstractC3198d.m6468p(parcel, i13, zam.CREATOR);
                    }
                }
                AbstractC3198d.m6470r(parcel, iM6447V5);
                return new zal(iM6436K6, strM6463k4, arrayListM6468p3);
            case 5:
                int iM6447V6 = AbstractC3198d.m6447V(parcel);
                int iM6436K7 = 0;
                Parcel parcel2 = null;
                zan zanVar = null;
                while (parcel.dataPosition() < iM6447V6) {
                    int i14 = parcel.readInt();
                    char c13 = (char) i14;
                    if (c13 == 1) {
                        iM6436K7 = AbstractC3198d.m6436K(parcel, i14);
                    } else if (c13 == 2) {
                        int iM6439N = AbstractC3198d.m6439N(parcel, i14);
                        int iDataPosition = parcel.dataPosition();
                        if (iM6439N == 0) {
                            parcel2 = null;
                        } else {
                            Parcel parcelObtain = Parcel.obtain();
                            parcelObtain.appendFrom(parcel, iDataPosition, iM6439N);
                            parcel.setDataPosition(iDataPosition + iM6439N);
                            parcel2 = parcelObtain;
                        }
                    } else if (c13 != 3) {
                        AbstractC3198d.m6445T(parcel, i14);
                    } else {
                        zanVar = (zan) AbstractC3198d.m6462j(parcel, i14, zan.CREATOR);
                    }
                }
                AbstractC3198d.m6470r(parcel, iM6447V6);
                return new SafeParcelResponse(iM6436K7, parcel2, zanVar);
            case 6:
                String string = parcel.readString();
                AbstractC2796i.m5782c(string);
                int i15 = parcel.readInt();
                LinkedHashMap linkedHashMap = new LinkedHashMap(i15);
                for (int i16 = 0; i16 < i15; i16++) {
                    String string2 = parcel.readString();
                    AbstractC2796i.m5782c(string2);
                    String string3 = parcel.readString();
                    AbstractC2796i.m5782c(string3);
                    linkedHashMap.put(string2, string3);
                }
                return new MemoryCache$Key(string, linkedHashMap);
            case 7:
                int iM6447V7 = AbstractC3198d.m6447V(parcel);
                String strM6463k5 = null;
                String strM6463k6 = null;
                String strM6463k7 = null;
                String strM6463k8 = null;
                Uri uri = null;
                String strM6463k9 = null;
                String strM6463k10 = null;
                ArrayList arrayListM6468p4 = null;
                String strM6463k11 = null;
                String strM6463k12 = null;
                long jM6438M = 0;
                int iM6436K8 = 0;
                while (parcel.dataPosition() < iM6447V7) {
                    int i17 = parcel.readInt();
                    switch ((char) i17) {
                        case 1:
                            iM6436K8 = AbstractC3198d.m6436K(parcel, i17);
                            break;
                        case 2:
                            strM6463k5 = AbstractC3198d.m6463k(parcel, i17);
                            break;
                        case 3:
                            strM6463k6 = AbstractC3198d.m6463k(parcel, i17);
                            break;
                        case 4:
                            strM6463k7 = AbstractC3198d.m6463k(parcel, i17);
                            break;
                        case 5:
                            strM6463k8 = AbstractC3198d.m6463k(parcel, i17);
                            break;
                        case 6:
                            uri = (Uri) AbstractC3198d.m6462j(parcel, i17, Uri.CREATOR);
                            break;
                        case 7:
                            strM6463k9 = AbstractC3198d.m6463k(parcel, i17);
                            break;
                        case '\b':
                            jM6438M = AbstractC3198d.m6438M(parcel, i17);
                            break;
                        case '\t':
                            strM6463k10 = AbstractC3198d.m6463k(parcel, i17);
                            break;
                        case '\n':
                            arrayListM6468p4 = AbstractC3198d.m6468p(parcel, i17, Scope.CREATOR);
                            break;
                        case 11:
                            strM6463k11 = AbstractC3198d.m6463k(parcel, i17);
                            break;
                        case '\f':
                            strM6463k12 = AbstractC3198d.m6463k(parcel, i17);
                            break;
                        default:
                            AbstractC3198d.m6445T(parcel, i17);
                            break;
                    }
                }
                AbstractC3198d.m6470r(parcel, iM6447V7);
                return new GoogleSignInAccount(iM6436K8, strM6463k5, strM6463k6, strM6463k7, strM6463k8, uri, strM6463k9, jM6438M, strM6463k10, arrayListM6468p4, strM6463k11, strM6463k12);
            case 8:
                int iM6447V8 = AbstractC3198d.m6447V(parcel);
                ArrayList<GoogleSignInOptionsExtensionParcelable> arrayListM6468p5 = null;
                ArrayList arrayListM6468p6 = null;
                Account account = null;
                String strM6463k13 = null;
                String strM6463k14 = null;
                String strM6463k15 = null;
                int iM6436K9 = 0;
                boolean zM6431F = false;
                boolean zM6431F2 = false;
                boolean zM6431F3 = false;
                while (parcel.dataPosition() < iM6447V8) {
                    int i18 = parcel.readInt();
                    switch ((char) i18) {
                        case 1:
                            iM6436K9 = AbstractC3198d.m6436K(parcel, i18);
                            break;
                        case 2:
                            arrayListM6468p6 = AbstractC3198d.m6468p(parcel, i18, Scope.CREATOR);
                            break;
                        case 3:
                            account = (Account) AbstractC3198d.m6462j(parcel, i18, Account.CREATOR);
                            break;
                        case 4:
                            zM6431F = AbstractC3198d.m6431F(parcel, i18);
                            break;
                        case 5:
                            zM6431F2 = AbstractC3198d.m6431F(parcel, i18);
                            break;
                        case 6:
                            zM6431F3 = AbstractC3198d.m6431F(parcel, i18);
                            break;
                        case 7:
                            strM6463k13 = AbstractC3198d.m6463k(parcel, i18);
                            break;
                        case '\b':
                            strM6463k14 = AbstractC3198d.m6463k(parcel, i18);
                            break;
                        case '\t':
                            arrayListM6468p5 = AbstractC3198d.m6468p(parcel, i18, GoogleSignInOptionsExtensionParcelable.CREATOR);
                            break;
                        case '\n':
                            strM6463k15 = AbstractC3198d.m6463k(parcel, i18);
                            break;
                        default:
                            AbstractC3198d.m6445T(parcel, i18);
                            break;
                    }
                }
                AbstractC3198d.m6470r(parcel, iM6447V8);
                HashMap map = new HashMap();
                if (arrayListM6468p5 != null) {
                    for (GoogleSignInOptionsExtensionParcelable googleSignInOptionsExtensionParcelable : arrayListM6468p5) {
                        map.put(Integer.valueOf(googleSignInOptionsExtensionParcelable.f4562b), googleSignInOptionsExtensionParcelable);
                    }
                }
                return new GoogleSignInOptions(iM6436K9, arrayListM6468p6, account, zM6431F, zM6431F2, zM6431F3, strM6463k13, strM6463k14, map, strM6463k15);
            case 9:
                int iM6447V9 = AbstractC3198d.m6447V(parcel);
                Bundle bundleM6458f = null;
                int iM6436K10 = 0;
                int iM6436K11 = 0;
                while (parcel.dataPosition() < iM6447V9) {
                    int i19 = parcel.readInt();
                    char c14 = (char) i19;
                    if (c14 == 1) {
                        iM6436K10 = AbstractC3198d.m6436K(parcel, i19);
                    } else if (c14 == 2) {
                        iM6436K11 = AbstractC3198d.m6436K(parcel, i19);
                    } else if (c14 != 3) {
                        AbstractC3198d.m6445T(parcel, i19);
                    } else {
                        bundleM6458f = AbstractC3198d.m6458f(parcel, i19);
                    }
                }
                AbstractC3198d.m6470r(parcel, iM6447V9);
                return new GoogleSignInOptionsExtensionParcelable(iM6436K10, iM6436K11, bundleM6458f);
            case 10:
                int iM6447V10 = AbstractC3198d.m6447V(parcel);
                String strM6463k16 = null;
                String strM6463k17 = null;
                String strM6463k18 = null;
                String strM6463k19 = null;
                String strM6463k20 = null;
                String strM6463k21 = null;
                String strM6463k22 = null;
                String strM6463k23 = null;
                String strM6463k24 = null;
                VastAdsRequest vastAdsRequest = null;
                long jM6438M2 = 0;
                long jM6438M3 = 0;
                while (parcel.dataPosition() < iM6447V10) {
                    int i20 = parcel.readInt();
                    switch ((char) i20) {
                        case 2:
                            strM6463k16 = AbstractC3198d.m6463k(parcel, i20);
                            break;
                        case 3:
                            strM6463k17 = AbstractC3198d.m6463k(parcel, i20);
                            break;
                        case 4:
                            jM6438M2 = AbstractC3198d.m6438M(parcel, i20);
                            break;
                        case 5:
                            strM6463k18 = AbstractC3198d.m6463k(parcel, i20);
                            break;
                        case 6:
                            strM6463k19 = AbstractC3198d.m6463k(parcel, i20);
                            break;
                        case 7:
                            strM6463k20 = AbstractC3198d.m6463k(parcel, i20);
                            break;
                        case '\b':
                            strM6463k21 = AbstractC3198d.m6463k(parcel, i20);
                            break;
                        case '\t':
                            strM6463k22 = AbstractC3198d.m6463k(parcel, i20);
                            break;
                        case '\n':
                            strM6463k23 = AbstractC3198d.m6463k(parcel, i20);
                            break;
                        case 11:
                            jM6438M3 = AbstractC3198d.m6438M(parcel, i20);
                            break;
                        case '\f':
                            strM6463k24 = AbstractC3198d.m6463k(parcel, i20);
                            break;
                        case '\r':
                            vastAdsRequest = (VastAdsRequest) AbstractC3198d.m6462j(parcel, i20, VastAdsRequest.CREATOR);
                            break;
                        default:
                            AbstractC3198d.m6445T(parcel, i20);
                            break;
                    }
                }
                AbstractC3198d.m6470r(parcel, iM6447V10);
                return new AdBreakClipInfo(strM6463k16, strM6463k17, jM6438M2, strM6463k18, strM6463k19, strM6463k20, strM6463k21, strM6463k22, strM6463k23, jM6438M3, strM6463k24, vastAdsRequest);
            case 11:
                int iM6447V11 = AbstractC3198d.m6447V(parcel);
                String strM6463k25 = null;
                String strM6463k26 = null;
                while (parcel.dataPosition() < iM6447V11) {
                    int i21 = parcel.readInt();
                    char c15 = (char) i21;
                    if (c15 == 1) {
                        strM6463k25 = AbstractC3198d.m6463k(parcel, i21);
                    } else if (c15 != 2) {
                        AbstractC3198d.m6445T(parcel, i21);
                    } else {
                        strM6463k26 = AbstractC3198d.m6463k(parcel, i21);
                    }
                }
                AbstractC3198d.m6470r(parcel, iM6447V11);
                return new CredentialsData(strM6463k25, strM6463k26);
            case 12:
                int iM6447V12 = AbstractC3198d.m6447V(parcel);
                float fM6434I = 0.0f;
                float fM6434I2 = 0.0f;
                float fM6434I3 = 0.0f;
                while (parcel.dataPosition() < iM6447V12) {
                    int i22 = parcel.readInt();
                    char c16 = (char) i22;
                    if (c16 == 2) {
                        fM6434I = AbstractC3198d.m6434I(parcel, i22);
                    } else if (c16 == 3) {
                        fM6434I2 = AbstractC3198d.m6434I(parcel, i22);
                    } else if (c16 != 4) {
                        AbstractC3198d.m6445T(parcel, i22);
                    } else {
                        fM6434I3 = AbstractC3198d.m6434I(parcel, i22);
                    }
                }
                AbstractC3198d.m6470r(parcel, iM6447V12);
                return new zzar(fM6434I, fM6434I2, fM6434I3);
            case 13:
                int iM6447V13 = AbstractC3198d.m6447V(parcel);
                zzar zzarVar = null;
                zzar zzarVar2 = null;
                while (parcel.dataPosition() < iM6447V13) {
                    int i23 = parcel.readInt();
                    char c17 = (char) i23;
                    if (c17 == 2) {
                        zzarVar = (zzar) AbstractC3198d.m6462j(parcel, i23, zzar.CREATOR);
                    } else if (c17 != 3) {
                        AbstractC3198d.m6445T(parcel, i23);
                    } else {
                        zzarVar2 = (zzar) AbstractC3198d.m6462j(parcel, i23, zzar.CREATOR);
                    }
                }
                AbstractC3198d.m6470r(parcel, iM6447V13);
                return new zzat(zzarVar, zzarVar2);
            case 14:
                int iM6447V14 = AbstractC3198d.m6447V(parcel);
                String strM6463k27 = null;
                String[] strArrM6464l = null;
                long jM6438M4 = 0;
                long jM6438M5 = 0;
                boolean zM6431F4 = false;
                boolean zM6431F5 = false;
                boolean zM6431F6 = false;
                while (parcel.dataPosition() < iM6447V14) {
                    int i24 = parcel.readInt();
                    switch ((char) i24) {
                        case 2:
                            jM6438M4 = AbstractC3198d.m6438M(parcel, i24);
                            break;
                        case 3:
                            strM6463k27 = AbstractC3198d.m6463k(parcel, i24);
                            break;
                        case 4:
                            jM6438M5 = AbstractC3198d.m6438M(parcel, i24);
                            break;
                        case 5:
                            zM6431F4 = AbstractC3198d.m6431F(parcel, i24);
                            break;
                        case 6:
                            strArrM6464l = AbstractC3198d.m6464l(parcel, i24);
                            break;
                        case 7:
                            zM6431F5 = AbstractC3198d.m6431F(parcel, i24);
                            break;
                        case '\b':
                            zM6431F6 = AbstractC3198d.m6431F(parcel, i24);
                            break;
                        default:
                            AbstractC3198d.m6445T(parcel, i24);
                            break;
                    }
                }
                AbstractC3198d.m6470r(parcel, iM6447V14);
                return new AdBreakInfo(jM6438M4, strM6463k27, jM6438M5, zM6431F4, strArrM6464l, zM6431F5, zM6431F6);
            case 15:
                int iM6447V15 = AbstractC3198d.m6447V(parcel);
                int iM6436K12 = 0;
                while (parcel.dataPosition() < iM6447V15) {
                    int i25 = parcel.readInt();
                    if (((char) i25) != 2) {
                        AbstractC3198d.m6445T(parcel, i25);
                    } else {
                        iM6436K12 = AbstractC3198d.m6436K(parcel, i25);
                    }
                }
                AbstractC3198d.m6470r(parcel, iM6447V15);
                return new zzbs(iM6436K12);
            case 16:
                int iM6447V16 = AbstractC3198d.m6447V(parcel);
                String strM6463k28 = null;
                CredentialsData credentialsData = null;
                boolean zM6431F7 = false;
                boolean zM6431F8 = false;
                while (parcel.dataPosition() < iM6447V16) {
                    int i26 = parcel.readInt();
                    char c18 = (char) i26;
                    if (c18 == 2) {
                        zM6431F7 = AbstractC3198d.m6431F(parcel, i26);
                    } else if (c18 == 3) {
                        strM6463k28 = AbstractC3198d.m6463k(parcel, i26);
                    } else if (c18 == 4) {
                        zM6431F8 = AbstractC3198d.m6431F(parcel, i26);
                    } else if (c18 != 5) {
                        AbstractC3198d.m6445T(parcel, i26);
                    } else {
                        credentialsData = (CredentialsData) AbstractC3198d.m6462j(parcel, i26, CredentialsData.CREATOR);
                    }
                }
                AbstractC3198d.m6470r(parcel, iM6447V16);
                return new LaunchOptions(zM6431F7, strM6463k28, zM6431F8, credentialsData);
            case 17:
                int iM6447V17 = AbstractC3198d.m6447V(parcel);
                String strM6463k29 = null;
                Integer numValueOf = null;
                String strM6463k30 = null;
                long jM6438M6 = 0;
                String strM6463k31 = null;
                while (parcel.dataPosition() < iM6447V17) {
                    int i27 = parcel.readInt();
                    char c19 = (char) i27;
                    if (c19 == 2) {
                        strM6463k29 = AbstractC3198d.m6463k(parcel, i27);
                    } else if (c19 == 3) {
                        jM6438M6 = AbstractC3198d.m6438M(parcel, i27);
                    } else if (c19 == 4) {
                        int iM6439N2 = AbstractC3198d.m6439N(parcel, i27);
                        if (iM6439N2 == 0) {
                            numValueOf = null;
                        } else {
                            AbstractC3198d.m6451Z(parcel, iM6439N2, 4);
                            numValueOf = Integer.valueOf(parcel.readInt());
                        }
                    } else if (c19 == 5) {
                        strM6463k30 = AbstractC3198d.m6463k(parcel, i27);
                    } else if (c19 != 6) {
                        AbstractC3198d.m6445T(parcel, i27);
                    } else {
                        strM6463k31 = AbstractC3198d.m6463k(parcel, i27);
                    }
                }
                AbstractC3198d.m6470r(parcel, iM6447V17);
                return new MediaError(strM6463k29, jM6438M6, numValueOf, strM6463k30, AbstractC3987a.m7968a(strM6463k31));
            case 18:
                int iM6447V18 = AbstractC3198d.m6447V(parcel);
                String strM6463k32 = null;
                String strM6463k33 = null;
                MediaMetadata mediaMetadata = null;
                ArrayList arrayListM6468p7 = null;
                TextTrackStyle textTrackStyle = null;
                String strM6463k34 = null;
                ArrayList arrayListM6468p8 = null;
                ArrayList arrayListM6468p9 = null;
                String strM6463k35 = null;
                VastAdsRequest vastAdsRequest2 = null;
                String strM6463k36 = null;
                String strM6463k37 = null;
                String strM6463k38 = null;
                String strM6463k39 = null;
                long jM6438M7 = 0;
                long jM6438M8 = 0;
                int iM6436K13 = 0;
                while (parcel.dataPosition() < iM6447V18) {
                    int i28 = parcel.readInt();
                    switch ((char) i28) {
                        case 2:
                            strM6463k32 = AbstractC3198d.m6463k(parcel, i28);
                            break;
                        case 3:
                            iM6436K13 = AbstractC3198d.m6436K(parcel, i28);
                            break;
                        case 4:
                            strM6463k33 = AbstractC3198d.m6463k(parcel, i28);
                            break;
                        case 5:
                            mediaMetadata = (MediaMetadata) AbstractC3198d.m6462j(parcel, i28, MediaMetadata.CREATOR);
                            break;
                        case 6:
                            jM6438M7 = AbstractC3198d.m6438M(parcel, i28);
                            break;
                        case 7:
                            arrayListM6468p7 = AbstractC3198d.m6468p(parcel, i28, MediaTrack.CREATOR);
                            break;
                        case '\b':
                            textTrackStyle = (TextTrackStyle) AbstractC3198d.m6462j(parcel, i28, TextTrackStyle.CREATOR);
                            break;
                        case '\t':
                            strM6463k34 = AbstractC3198d.m6463k(parcel, i28);
                            break;
                        case '\n':
                            arrayListM6468p8 = AbstractC3198d.m6468p(parcel, i28, AdBreakInfo.CREATOR);
                            break;
                        case 11:
                            arrayListM6468p9 = AbstractC3198d.m6468p(parcel, i28, AdBreakClipInfo.CREATOR);
                            break;
                        case '\f':
                            strM6463k35 = AbstractC3198d.m6463k(parcel, i28);
                            break;
                        case '\r':
                            vastAdsRequest2 = (VastAdsRequest) AbstractC3198d.m6462j(parcel, i28, VastAdsRequest.CREATOR);
                            break;
                        case 14:
                            jM6438M8 = AbstractC3198d.m6438M(parcel, i28);
                            break;
                        case 15:
                            strM6463k36 = AbstractC3198d.m6463k(parcel, i28);
                            break;
                        case 16:
                            strM6463k37 = AbstractC3198d.m6463k(parcel, i28);
                            break;
                        case 17:
                            strM6463k38 = AbstractC3198d.m6463k(parcel, i28);
                            break;
                        case 18:
                            strM6463k39 = AbstractC3198d.m6463k(parcel, i28);
                            break;
                        default:
                            AbstractC3198d.m6445T(parcel, i28);
                            break;
                    }
                }
                AbstractC3198d.m6470r(parcel, iM6447V18);
                return new MediaInfo(strM6463k32, iM6436K13, strM6463k33, mediaMetadata, jM6438M7, arrayListM6468p7, textTrackStyle, strM6463k34, arrayListM6468p8, arrayListM6468p9, strM6463k35, vastAdsRequest2, jM6438M8, strM6463k36, strM6463k37, strM6463k38, strM6463k39);
            case 19:
                int iM6447V19 = AbstractC3198d.m6447V(parcel);
                long jM6438M9 = 0;
                long jM6438M10 = 0;
                boolean zM6431F9 = false;
                boolean zM6431F10 = false;
                while (parcel.dataPosition() < iM6447V19) {
                    int i29 = parcel.readInt();
                    char c20 = (char) i29;
                    if (c20 == 2) {
                        jM6438M9 = AbstractC3198d.m6438M(parcel, i29);
                    } else if (c20 == 3) {
                        jM6438M10 = AbstractC3198d.m6438M(parcel, i29);
                    } else if (c20 == 4) {
                        zM6431F9 = AbstractC3198d.m6431F(parcel, i29);
                    } else if (c20 != 5) {
                        AbstractC3198d.m6445T(parcel, i29);
                    } else {
                        zM6431F10 = AbstractC3198d.m6431F(parcel, i29);
                    }
                }
                AbstractC3198d.m6470r(parcel, iM6447V19);
                return new MediaLiveSeekableRange(jM6438M9, jM6438M10, zM6431F9, zM6431F10);
            case 20:
                int iM6447V20 = AbstractC3198d.m6447V(parcel);
                long jM6438M11 = 0;
                long jM6438M12 = 0;
                long jM6438M13 = 0;
                String strM6463k40 = null;
                String strM6463k41 = null;
                while (parcel.dataPosition() < iM6447V20) {
                    int i30 = parcel.readInt();
                    char c21 = (char) i30;
                    if (c21 == 2) {
                        jM6438M11 = AbstractC3198d.m6438M(parcel, i30);
                    } else if (c21 == 3) {
                        jM6438M12 = AbstractC3198d.m6438M(parcel, i30);
                    } else if (c21 == 4) {
                        strM6463k40 = AbstractC3198d.m6463k(parcel, i30);
                    } else if (c21 == 5) {
                        strM6463k41 = AbstractC3198d.m6463k(parcel, i30);
                    } else if (c21 != 6) {
                        AbstractC3198d.m6445T(parcel, i30);
                    } else {
                        jM6438M13 = AbstractC3198d.m6438M(parcel, i30);
                    }
                }
                AbstractC3198d.m6470r(parcel, iM6447V20);
                return new AdBreakStatus(jM6438M11, jM6438M12, strM6463k40, strM6463k41, jM6438M13);
            case 21:
                int iM6447V21 = AbstractC3198d.m6447V(parcel);
                String strM6463k42 = null;
                long jM6438M14 = 0;
                long jM6438M15 = 0;
                MediaInfo mediaInfo = null;
                MediaQueueData mediaQueueData = null;
                Boolean boolM6432G = null;
                long[] jArrM6461i = null;
                String strM6463k43 = null;
                String strM6463k44 = null;
                String strM6463k45 = null;
                String strM6463k46 = null;
                double dM6433H = 0.0d;
                while (parcel.dataPosition() < iM6447V21) {
                    int i31 = parcel.readInt();
                    switch ((char) i31) {
                        case 2:
                            mediaInfo = (MediaInfo) AbstractC3198d.m6462j(parcel, i31, MediaInfo.CREATOR);
                            break;
                        case 3:
                            mediaQueueData = (MediaQueueData) AbstractC3198d.m6462j(parcel, i31, MediaQueueData.CREATOR);
                            break;
                        case 4:
                            boolM6432G = AbstractC3198d.m6432G(parcel, i31);
                            break;
                        case 5:
                            jM6438M14 = AbstractC3198d.m6438M(parcel, i31);
                            break;
                        case 6:
                            dM6433H = AbstractC3198d.m6433H(parcel, i31);
                            break;
                        case 7:
                            jArrM6461i = AbstractC3198d.m6461i(parcel, i31);
                            break;
                        case '\b':
                            strM6463k42 = AbstractC3198d.m6463k(parcel, i31);
                            break;
                        case '\t':
                            strM6463k43 = AbstractC3198d.m6463k(parcel, i31);
                            break;
                        case '\n':
                            strM6463k44 = AbstractC3198d.m6463k(parcel, i31);
                            break;
                        case 11:
                            strM6463k45 = AbstractC3198d.m6463k(parcel, i31);
                            break;
                        case '\f':
                            strM6463k46 = AbstractC3198d.m6463k(parcel, i31);
                            break;
                        case '\r':
                            jM6438M15 = AbstractC3198d.m6438M(parcel, i31);
                            break;
                        default:
                            AbstractC3198d.m6445T(parcel, i31);
                            break;
                    }
                }
                AbstractC3198d.m6470r(parcel, iM6447V21);
                return new MediaLoadRequestData(mediaInfo, mediaQueueData, boolM6432G, jM6438M14, dM6433H, jArrM6461i, AbstractC3987a.m7968a(strM6463k42), strM6463k43, strM6463k44, strM6463k45, strM6463k46, jM6438M15);
            case 22:
                int iM6447V22 = AbstractC3198d.m6447V(parcel);
                int iM6436K14 = 0;
                ArrayList arrayListM6468p10 = null;
                Bundle bundleM6458f2 = null;
                while (parcel.dataPosition() < iM6447V22) {
                    int i32 = parcel.readInt();
                    char c22 = (char) i32;
                    if (c22 == 2) {
                        arrayListM6468p10 = AbstractC3198d.m6468p(parcel, i32, WebImage.CREATOR);
                    } else if (c22 == 3) {
                        bundleM6458f2 = AbstractC3198d.m6458f(parcel, i32);
                    } else if (c22 != 4) {
                        AbstractC3198d.m6445T(parcel, i32);
                    } else {
                        iM6436K14 = AbstractC3198d.m6436K(parcel, i32);
                    }
                }
                AbstractC3198d.m6470r(parcel, iM6447V22);
                return new MediaMetadata(arrayListM6468p10, bundleM6458f2, iM6436K14);
            case 23:
                int iM6447V23 = AbstractC3198d.m6447V(parcel);
                double dM6433H2 = 0.0d;
                String strM6463k47 = null;
                ArrayList arrayListM6468p11 = null;
                ArrayList arrayListM6468p12 = null;
                int iM6436K15 = 0;
                while (parcel.dataPosition() < iM6447V23) {
                    int i33 = parcel.readInt();
                    char c23 = (char) i33;
                    if (c23 == 2) {
                        iM6436K15 = AbstractC3198d.m6436K(parcel, i33);
                    } else if (c23 == 3) {
                        strM6463k47 = AbstractC3198d.m6463k(parcel, i33);
                    } else if (c23 == 4) {
                        arrayListM6468p11 = AbstractC3198d.m6468p(parcel, i33, MediaMetadata.CREATOR);
                    } else if (c23 == 5) {
                        arrayListM6468p12 = AbstractC3198d.m6468p(parcel, i33, WebImage.CREATOR);
                    } else if (c23 != 6) {
                        AbstractC3198d.m6445T(parcel, i33);
                    } else {
                        dM6433H2 = AbstractC3198d.m6433H(parcel, i33);
                    }
                }
                AbstractC3198d.m6470r(parcel, iM6447V23);
                MediaQueueContainerMetadata mediaQueueContainerMetadata = new MediaQueueContainerMetadata();
                mediaQueueContainerMetadata.f4680a = iM6436K15;
                mediaQueueContainerMetadata.f4681b = strM6463k47;
                mediaQueueContainerMetadata.f4682c = arrayListM6468p11;
                mediaQueueContainerMetadata.f4683d = arrayListM6468p12;
                mediaQueueContainerMetadata.f4684e = dM6433H2;
                return mediaQueueContainerMetadata;
            case 24:
                int iM6447V24 = AbstractC3198d.m6447V(parcel);
                int iM6436K16 = 0;
                long jM6438M16 = 0;
                String strM6463k48 = null;
                String strM6463k49 = null;
                String strM6463k50 = null;
                MediaQueueContainerMetadata mediaQueueContainerMetadata2 = null;
                ArrayList arrayListM6468p13 = null;
                int iM6436K17 = 0;
                int iM6436K18 = 0;
                boolean zM6431F11 = false;
                while (parcel.dataPosition() < iM6447V24) {
                    int i34 = parcel.readInt();
                    switch ((char) i34) {
                        case 2:
                            strM6463k48 = AbstractC3198d.m6463k(parcel, i34);
                            break;
                        case 3:
                            strM6463k49 = AbstractC3198d.m6463k(parcel, i34);
                            break;
                        case 4:
                            iM6436K16 = AbstractC3198d.m6436K(parcel, i34);
                            break;
                        case 5:
                            strM6463k50 = AbstractC3198d.m6463k(parcel, i34);
                            break;
                        case 6:
                            mediaQueueContainerMetadata2 = (MediaQueueContainerMetadata) AbstractC3198d.m6462j(parcel, i34, MediaQueueContainerMetadata.CREATOR);
                            break;
                        case 7:
                            iM6436K17 = AbstractC3198d.m6436K(parcel, i34);
                            break;
                        case '\b':
                            arrayListM6468p13 = AbstractC3198d.m6468p(parcel, i34, MediaQueueItem.CREATOR);
                            break;
                        case '\t':
                            iM6436K18 = AbstractC3198d.m6436K(parcel, i34);
                            break;
                        case '\n':
                            jM6438M16 = AbstractC3198d.m6438M(parcel, i34);
                            break;
                        case 11:
                            zM6431F11 = AbstractC3198d.m6431F(parcel, i34);
                            break;
                        default:
                            AbstractC3198d.m6445T(parcel, i34);
                            break;
                    }
                }
                AbstractC3198d.m6470r(parcel, iM6447V24);
                MediaQueueData mediaQueueData2 = new MediaQueueData();
                mediaQueueData2.f4685a = strM6463k48;
                mediaQueueData2.f4686b = strM6463k49;
                mediaQueueData2.f4687c = iM6436K16;
                mediaQueueData2.f4688d = strM6463k50;
                mediaQueueData2.f4689e = mediaQueueContainerMetadata2;
                mediaQueueData2.f4690f = iM6436K17;
                mediaQueueData2.f4691g = arrayListM6468p13;
                mediaQueueData2.f4692h = iM6436K18;
                mediaQueueData2.f4693i = jM6438M16;
                mediaQueueData2.f4694j = zM6431F11;
                return mediaQueueData2;
            case 25:
                int iM6447V25 = AbstractC3198d.m6447V(parcel);
                MediaInfo mediaInfo2 = null;
                long[] jArrM6461i2 = null;
                String strM6463k51 = null;
                double dM6433H3 = 0.0d;
                double dM6433H4 = 0.0d;
                double dM6433H5 = 0.0d;
                int iM6436K19 = 0;
                boolean zM6431F12 = false;
                while (parcel.dataPosition() < iM6447V25) {
                    int i35 = parcel.readInt();
                    switch ((char) i35) {
                        case 2:
                            mediaInfo2 = (MediaInfo) AbstractC3198d.m6462j(parcel, i35, MediaInfo.CREATOR);
                            break;
                        case 3:
                            iM6436K19 = AbstractC3198d.m6436K(parcel, i35);
                            break;
                        case 4:
                            zM6431F12 = AbstractC3198d.m6431F(parcel, i35);
                            break;
                        case 5:
                            dM6433H3 = AbstractC3198d.m6433H(parcel, i35);
                            break;
                        case 6:
                            dM6433H4 = AbstractC3198d.m6433H(parcel, i35);
                            break;
                        case 7:
                            dM6433H5 = AbstractC3198d.m6433H(parcel, i35);
                            break;
                        case '\b':
                            jArrM6461i2 = AbstractC3198d.m6461i(parcel, i35);
                            break;
                        case '\t':
                            strM6463k51 = AbstractC3198d.m6463k(parcel, i35);
                            break;
                        default:
                            AbstractC3198d.m6445T(parcel, i35);
                            break;
                    }
                }
                AbstractC3198d.m6470r(parcel, iM6447V25);
                return new MediaQueueItem(mediaInfo2, iM6436K19, zM6431F12, dM6433H3, dM6433H4, dM6433H5, jArrM6461i2, strM6463k51);
            case 26:
                int iM6447V26 = AbstractC3198d.m6447V(parcel);
                MediaInfo mediaInfo3 = null;
                long[] jArrM6461i3 = null;
                String strM6463k52 = null;
                ArrayList arrayListM6468p14 = null;
                AdBreakStatus adBreakStatus = null;
                VideoInfo videoInfo = null;
                MediaLiveSeekableRange mediaLiveSeekableRange = null;
                MediaQueueData mediaQueueData3 = null;
                double dM6433H6 = 0.0d;
                double dM6433H7 = 0.0d;
                long jM6438M17 = 0;
                long jM6438M18 = 0;
                long jM6438M19 = 0;
                int iM6436K20 = 0;
                int iM6436K21 = 0;
                int iM6436K22 = 0;
                boolean zM6431F13 = false;
                int iM6436K23 = 0;
                int iM6436K24 = 0;
                int iM6436K25 = 0;
                boolean zM6431F14 = false;
                while (parcel.dataPosition() < iM6447V26) {
                    int i36 = parcel.readInt();
                    switch ((char) i36) {
                        case 2:
                            mediaInfo3 = (MediaInfo) AbstractC3198d.m6462j(parcel, i36, MediaInfo.CREATOR);
                            break;
                        case 3:
                            jM6438M17 = AbstractC3198d.m6438M(parcel, i36);
                            break;
                        case 4:
                            iM6436K20 = AbstractC3198d.m6436K(parcel, i36);
                            break;
                        case 5:
                            dM6433H6 = AbstractC3198d.m6433H(parcel, i36);
                            break;
                        case 6:
                            iM6436K21 = AbstractC3198d.m6436K(parcel, i36);
                            break;
                        case 7:
                            iM6436K22 = AbstractC3198d.m6436K(parcel, i36);
                            break;
                        case '\b':
                            jM6438M18 = AbstractC3198d.m6438M(parcel, i36);
                            break;
                        case '\t':
                            jM6438M19 = AbstractC3198d.m6438M(parcel, i36);
                            break;
                        case '\n':
                            dM6433H7 = AbstractC3198d.m6433H(parcel, i36);
                            break;
                        case 11:
                            zM6431F13 = AbstractC3198d.m6431F(parcel, i36);
                            break;
                        case '\f':
                            jArrM6461i3 = AbstractC3198d.m6461i(parcel, i36);
                            break;
                        case '\r':
                            iM6436K23 = AbstractC3198d.m6436K(parcel, i36);
                            break;
                        case 14:
                            iM6436K24 = AbstractC3198d.m6436K(parcel, i36);
                            break;
                        case 15:
                            strM6463k52 = AbstractC3198d.m6463k(parcel, i36);
                            break;
                        case 16:
                            iM6436K25 = AbstractC3198d.m6436K(parcel, i36);
                            break;
                        case 17:
                            arrayListM6468p14 = AbstractC3198d.m6468p(parcel, i36, MediaQueueItem.CREATOR);
                            break;
                        case 18:
                            zM6431F14 = AbstractC3198d.m6431F(parcel, i36);
                            break;
                        case 19:
                            adBreakStatus = (AdBreakStatus) AbstractC3198d.m6462j(parcel, i36, AdBreakStatus.CREATOR);
                            break;
                        case 20:
                            videoInfo = (VideoInfo) AbstractC3198d.m6462j(parcel, i36, VideoInfo.CREATOR);
                            break;
                        case 21:
                            mediaLiveSeekableRange = (MediaLiveSeekableRange) AbstractC3198d.m6462j(parcel, i36, MediaLiveSeekableRange.CREATOR);
                            break;
                        case 22:
                            mediaQueueData3 = (MediaQueueData) AbstractC3198d.m6462j(parcel, i36, MediaQueueData.CREATOR);
                            break;
                        default:
                            AbstractC3198d.m6445T(parcel, i36);
                            break;
                    }
                }
                AbstractC3198d.m6470r(parcel, iM6447V26);
                return new MediaStatus(mediaInfo3, jM6438M17, iM6436K20, dM6433H6, iM6436K21, iM6436K22, jM6438M18, jM6438M19, dM6433H7, zM6431F13, jArrM6461i3, iM6436K23, iM6436K24, strM6463k52, iM6436K25, arrayListM6468p14, zM6431F14, adBreakStatus, videoInfo, mediaLiveSeekableRange, mediaQueueData3);
            case 27:
                int iM6447V27 = AbstractC3198d.m6447V(parcel);
                String strM6463k53 = null;
                String strM6463k54 = null;
                String strM6463k55 = null;
                String strM6463k56 = null;
                String strM6463k57 = null;
                ArrayList arrayListM6466n = null;
                long jM6438M20 = 0;
                int iM6436K26 = 0;
                int iM6436K27 = 0;
                while (parcel.dataPosition() < iM6447V27) {
                    int i37 = parcel.readInt();
                    switch ((char) i37) {
                        case 2:
                            jM6438M20 = AbstractC3198d.m6438M(parcel, i37);
                            break;
                        case 3:
                            iM6436K26 = AbstractC3198d.m6436K(parcel, i37);
                            break;
                        case 4:
                            strM6463k54 = AbstractC3198d.m6463k(parcel, i37);
                            break;
                        case 5:
                            strM6463k55 = AbstractC3198d.m6463k(parcel, i37);
                            break;
                        case 6:
                            strM6463k56 = AbstractC3198d.m6463k(parcel, i37);
                            break;
                        case 7:
                            strM6463k57 = AbstractC3198d.m6463k(parcel, i37);
                            break;
                        case '\b':
                            iM6436K27 = AbstractC3198d.m6436K(parcel, i37);
                            break;
                        case '\t':
                            arrayListM6466n = AbstractC3198d.m6466n(parcel, i37);
                            break;
                        case '\n':
                            strM6463k53 = AbstractC3198d.m6463k(parcel, i37);
                            break;
                        default:
                            AbstractC3198d.m6445T(parcel, i37);
                            break;
                    }
                }
                AbstractC3198d.m6470r(parcel, iM6447V27);
                return new MediaTrack(jM6438M20, iM6436K26, strM6463k54, strM6463k55, strM6463k56, strM6463k57, iM6436K27, arrayListM6466n, AbstractC3987a.m7968a(strM6463k53));
            case 28:
                int iM6447V28 = AbstractC3198d.m6447V(parcel);
                String strM6463k58 = null;
                String strM6463k59 = null;
                ArrayList arrayListM6466n2 = null;
                String strM6463k60 = null;
                Uri uri2 = null;
                String strM6463k61 = null;
                String strM6463k62 = null;
                Boolean boolM6432G2 = null;
                Boolean boolM6432G3 = null;
                int iM6436K28 = 0;
                while (parcel.dataPosition() < iM6447V28) {
                    int i38 = parcel.readInt();
                    switch ((char) i38) {
                        case 2:
                            strM6463k58 = AbstractC3198d.m6463k(parcel, i38);
                            break;
                        case 3:
                            strM6463k59 = AbstractC3198d.m6463k(parcel, i38);
                            break;
                        case 4:
                            AbstractC3198d.m6468p(parcel, i38, WebImage.CREATOR);
                            break;
                        case 5:
                            arrayListM6466n2 = AbstractC3198d.m6466n(parcel, i38);
                            break;
                        case 6:
                            strM6463k60 = AbstractC3198d.m6463k(parcel, i38);
                            break;
                        case 7:
                            uri2 = (Uri) AbstractC3198d.m6462j(parcel, i38, Uri.CREATOR);
                            break;
                        case '\b':
                            strM6463k61 = AbstractC3198d.m6463k(parcel, i38);
                            break;
                        case '\t':
                            strM6463k62 = AbstractC3198d.m6463k(parcel, i38);
                            break;
                        case '\n':
                            boolM6432G2 = AbstractC3198d.m6432G(parcel, i38);
                            break;
                        case 11:
                            boolM6432G3 = AbstractC3198d.m6432G(parcel, i38);
                            break;
                        case '\f':
                            iM6436K28 = AbstractC3198d.m6436K(parcel, i38);
                            break;
                        default:
                            AbstractC3198d.m6445T(parcel, i38);
                            break;
                    }
                }
                AbstractC3198d.m6470r(parcel, iM6447V28);
                return new ApplicationMetadata(strM6463k58, strM6463k59, arrayListM6466n2, strM6463k60, uri2, strM6463k61, strM6463k62, boolM6432G2, boolM6432G3, iM6436K28);
            default:
                int iM6447V29 = AbstractC3198d.m6447V(parcel);
                MediaLoadRequestData mediaLoadRequestData = null;
                String strM6463k63 = null;
                while (parcel.dataPosition() < iM6447V29) {
                    int i39 = parcel.readInt();
                    char c24 = (char) i39;
                    if (c24 == 2) {
                        mediaLoadRequestData = (MediaLoadRequestData) AbstractC3198d.m6462j(parcel, i39, MediaLoadRequestData.CREATOR);
                    } else if (c24 != 3) {
                        AbstractC3198d.m6445T(parcel, i39);
                    } else {
                        strM6463k63 = AbstractC3198d.m6463k(parcel, i39);
                    }
                }
                AbstractC3198d.m6470r(parcel, iM6447V29);
                return new SessionState(mediaLoadRequestData, AbstractC3987a.m7968a(strM6463k63));
        }
    }

    @Override
    public final Object[] newArray(int i6) {
        switch (this.f9290a) {
            case 0:
                return new StringToIntConverter[i6];
            case 1:
                return new zac[i6];
            case 2:
                return new zam[i6];
            case 3:
                return new zan[i6];
            case 4:
                return new zal[i6];
            case 5:
                return new SafeParcelResponse[i6];
            case 6:
                return new MemoryCache$Key[i6];
            case 7:
                return new GoogleSignInAccount[i6];
            case 8:
                return new GoogleSignInOptions[i6];
            case 9:
                return new GoogleSignInOptionsExtensionParcelable[i6];
            case 10:
                return new AdBreakClipInfo[i6];
            case 11:
                return new CredentialsData[i6];
            case 12:
                return new zzar[i6];
            case 13:
                return new zzat[i6];
            case 14:
                return new AdBreakInfo[i6];
            case 15:
                return new zzbs[i6];
            case 16:
                return new LaunchOptions[i6];
            case 17:
                return new MediaError[i6];
            case 18:
                return new MediaInfo[i6];
            case 19:
                return new MediaLiveSeekableRange[i6];
            case 20:
                return new AdBreakStatus[i6];
            case 21:
                return new MediaLoadRequestData[i6];
            case 22:
                return new MediaMetadata[i6];
            case 23:
                return new MediaQueueContainerMetadata[i6];
            case 24:
                return new MediaQueueData[i6];
            case 25:
                return new MediaQueueItem[i6];
            case 26:
                return new MediaStatus[i6];
            case 27:
                return new MediaTrack[i6];
            case 28:
                return new ApplicationMetadata[i6];
            default:
                return new SessionState[i6];
        }
    }
}
