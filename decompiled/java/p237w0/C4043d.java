package p237w0;

import android.accounts.Account;
import android.app.PendingIntent;
import android.database.CursorWindow;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.IntentSenderRequest;
import androidx.databinding.ObservableParcelable;
import androidx.versionedparcelable.ParcelImpl;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.BinderWrapper;
import com.google.android.gms.common.internal.ClientIdentity;
import com.google.android.gms.common.internal.ConnectionTelemetryConfiguration;
import com.google.android.gms.common.internal.GetServiceRequest;
import com.google.android.gms.common.internal.MethodInvocation;
import com.google.android.gms.common.internal.RootTelemetryConfiguration;
import com.google.android.gms.common.internal.TelemetryData;
import com.google.android.gms.common.internal.zat;
import com.google.android.gms.common.internal.zav;
import com.google.android.gms.common.internal.zax;
import com.google.android.gms.common.internal.zzal;
import com.google.android.gms.common.internal.zzk;
import com.google.android.gms.common.moduleinstall.ModuleAvailabilityResponse;
import com.google.android.gms.common.moduleinstall.ModuleInstallIntentResponse;
import com.google.android.gms.common.moduleinstall.ModuleInstallResponse;
import com.google.android.gms.common.moduleinstall.ModuleInstallStatusUpdate;
import com.google.android.gms.common.moduleinstall.internal.ApiFeatureRequest;
import com.google.android.gms.common.server.FavaDiagnosticsEntity;
import com.google.android.gms.common.server.converter.StringToIntConverter;
import com.google.android.gms.common.server.converter.zaa;
import com.google.android.material.internal.ParcelableSparseBooleanArray;
import com.google.android.material.internal.ParcelableSparseIntArray;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import java.util.ArrayList;
import p143n5.AbstractC3198d;
import p156o9.AbstractC3280d;

public final class C4043d implements Parcelable.Creator {

    public final int f13692a;

    public C4043d(int i6) {
        this.f13692a = i6;
    }

    public static void m8045a(GetServiceRequest getServiceRequest, Parcel parcel, int i6) {
        int iM6583V = AbstractC3280d.m6583V(parcel, 20293);
        int i10 = getServiceRequest.f5038a;
        AbstractC3280d.m6585X(parcel, 1, 4);
        parcel.writeInt(i10);
        AbstractC3280d.m6585X(parcel, 2, 4);
        parcel.writeInt(getServiceRequest.f5039b);
        AbstractC3280d.m6585X(parcel, 3, 4);
        parcel.writeInt(getServiceRequest.f5040c);
        AbstractC3280d.m6579R(parcel, 4, getServiceRequest.f5041d);
        AbstractC3280d.m6575N(parcel, 5, getServiceRequest.f5042e);
        AbstractC3280d.m6581T(parcel, 6, getServiceRequest.f5043f, i6);
        AbstractC3280d.m6574M(parcel, 7, getServiceRequest.f5044g);
        AbstractC3280d.m6578Q(parcel, 8, getServiceRequest.f5045h, i6);
        AbstractC3280d.m6581T(parcel, 10, getServiceRequest.f5046i, i6);
        AbstractC3280d.m6581T(parcel, 11, getServiceRequest.f5047j, i6);
        AbstractC3280d.m6585X(parcel, 12, 4);
        parcel.writeInt(getServiceRequest.f5048k ? 1 : 0);
        AbstractC3280d.m6585X(parcel, 13, 4);
        parcel.writeInt(getServiceRequest.f5049l);
        boolean z7 = getServiceRequest.f5050m;
        AbstractC3280d.m6585X(parcel, 14, 4);
        parcel.writeInt(z7 ? 1 : 0);
        AbstractC3280d.m6579R(parcel, 15, getServiceRequest.f5051n);
        AbstractC3280d.m6584W(parcel, iM6583V);
    }

    @Override
    public final Object createFromParcel(Parcel parcel) {
        switch (this.f13692a) {
            case 0:
                Parcelable parcelable = parcel.readParcelable(C4043d.class.getClassLoader());
                ObservableParcelable observableParcelable = new ObservableParcelable();
                observableParcelable.f1701b = parcelable;
                return observableParcelable;
            case 1:
                return new ParcelImpl(parcel);
            case 2:
                int iM6447V = AbstractC3198d.m6447V(parcel);
                int iM6436K = 0;
                ParcelFileDescriptor parcelFileDescriptor = null;
                int iM6436K2 = 0;
                while (parcel.dataPosition() < iM6447V) {
                    int i6 = parcel.readInt();
                    char c5 = (char) i6;
                    if (c5 == 1) {
                        iM6436K = AbstractC3198d.m6436K(parcel, i6);
                    } else if (c5 == 2) {
                        parcelFileDescriptor = (ParcelFileDescriptor) AbstractC3198d.m6462j(parcel, i6, ParcelFileDescriptor.CREATOR);
                    } else if (c5 != 3) {
                        AbstractC3198d.m6445T(parcel, i6);
                    } else {
                        iM6436K2 = AbstractC3198d.m6436K(parcel, i6);
                    }
                }
                AbstractC3198d.m6470r(parcel, iM6447V);
                return new BitmapTeleporter(iM6436K, parcelFileDescriptor, iM6436K2);
            case 3:
                int iM6447V2 = AbstractC3198d.m6447V(parcel);
                String[] strArrM6464l = null;
                CursorWindow[] cursorWindowArr = null;
                Bundle bundleM6458f = null;
                int iM6436K3 = 0;
                int iM6436K4 = 0;
                while (parcel.dataPosition() < iM6447V2) {
                    int i10 = parcel.readInt();
                    char c8 = (char) i10;
                    if (c8 == 1) {
                        strArrM6464l = AbstractC3198d.m6464l(parcel, i10);
                    } else if (c8 == 2) {
                        cursorWindowArr = (CursorWindow[]) AbstractC3198d.m6467o(parcel, i10, CursorWindow.CREATOR);
                    } else if (c8 == 3) {
                        iM6436K4 = AbstractC3198d.m6436K(parcel, i10);
                    } else if (c8 == 4) {
                        bundleM6458f = AbstractC3198d.m6458f(parcel, i10);
                    } else if (c8 != 1000) {
                        AbstractC3198d.m6445T(parcel, i10);
                    } else {
                        iM6436K3 = AbstractC3198d.m6436K(parcel, i10);
                    }
                }
                AbstractC3198d.m6470r(parcel, iM6447V2);
                DataHolder dataHolder = new DataHolder(iM6436K3, strArrM6464l, cursorWindowArr, iM6436K4, bundleM6458f);
                dataHolder.f5016c = new Bundle();
                int i11 = 0;
                while (true) {
                    String[] strArr = dataHolder.f5015b;
                    if (i11 >= strArr.length) {
                        CursorWindow[] cursorWindowArr2 = dataHolder.f5017d;
                        dataHolder.f5020g = new int[cursorWindowArr2.length];
                        int numRows = 0;
                        for (int i12 = 0; i12 < cursorWindowArr2.length; i12++) {
                            dataHolder.f5020g[i12] = numRows;
                            numRows += cursorWindowArr2[i12].getNumRows() - (numRows - cursorWindowArr2[i12].getStartPosition());
                        }
                        return dataHolder;
                    }
                    dataHolder.f5016c.putInt(strArr[i11], i11);
                    i11++;
                }
                break;
            case 4:
                return new StrategyBean(parcel);
            case 5:
                int iM6447V3 = AbstractC3198d.m6447V(parcel);
                String strM6463k = null;
                int iM6436K5 = 0;
                while (parcel.dataPosition() < iM6447V3) {
                    int i13 = parcel.readInt();
                    char c10 = (char) i13;
                    if (c10 == 1) {
                        iM6436K5 = AbstractC3198d.m6436K(parcel, i13);
                    } else if (c10 != 2) {
                        AbstractC3198d.m6445T(parcel, i13);
                    } else {
                        strM6463k = AbstractC3198d.m6463k(parcel, i13);
                    }
                }
                AbstractC3198d.m6470r(parcel, iM6447V3);
                return new ClientIdentity(iM6436K5, strM6463k);
            case 6:
                int iM6447V4 = AbstractC3198d.m6447V(parcel);
                ArrayList arrayListM6468p = null;
                int iM6436K6 = 0;
                while (parcel.dataPosition() < iM6447V4) {
                    int i14 = parcel.readInt();
                    char c11 = (char) i14;
                    if (c11 == 1) {
                        iM6436K6 = AbstractC3198d.m6436K(parcel, i14);
                    } else if (c11 != 2) {
                        AbstractC3198d.m6445T(parcel, i14);
                    } else {
                        arrayListM6468p = AbstractC3198d.m6468p(parcel, i14, MethodInvocation.CREATOR);
                    }
                }
                AbstractC3198d.m6470r(parcel, iM6447V4);
                return new TelemetryData(iM6436K6, arrayListM6468p);
            case 7:
                int iM6447V5 = AbstractC3198d.m6447V(parcel);
                String strM6463k2 = null;
                String strM6463k3 = null;
                long jM6438M = 0;
                long jM6438M2 = 0;
                int iM6436K7 = 0;
                int iM6436K8 = 0;
                int iM6436K9 = 0;
                int iM6436K10 = 0;
                int iM6436K11 = -1;
                while (parcel.dataPosition() < iM6447V5) {
                    int i15 = parcel.readInt();
                    switch ((char) i15) {
                        case 1:
                            iM6436K7 = AbstractC3198d.m6436K(parcel, i15);
                            break;
                        case 2:
                            iM6436K8 = AbstractC3198d.m6436K(parcel, i15);
                            break;
                        case 3:
                            iM6436K9 = AbstractC3198d.m6436K(parcel, i15);
                            break;
                        case 4:
                            jM6438M = AbstractC3198d.m6438M(parcel, i15);
                            break;
                        case 5:
                            jM6438M2 = AbstractC3198d.m6438M(parcel, i15);
                            break;
                        case 6:
                            strM6463k2 = AbstractC3198d.m6463k(parcel, i15);
                            break;
                        case 7:
                            strM6463k3 = AbstractC3198d.m6463k(parcel, i15);
                            break;
                        case '\b':
                            iM6436K10 = AbstractC3198d.m6436K(parcel, i15);
                            break;
                        case '\t':
                            iM6436K11 = AbstractC3198d.m6436K(parcel, i15);
                            break;
                        default:
                            AbstractC3198d.m6445T(parcel, i15);
                            break;
                    }
                }
                AbstractC3198d.m6470r(parcel, iM6447V5);
                return new MethodInvocation(iM6436K7, iM6436K8, iM6436K9, jM6438M, jM6438M2, strM6463k2, strM6463k3, iM6436K10, iM6436K11);
            case 8:
                int iM6447V6 = AbstractC3198d.m6447V(parcel);
                Account account = null;
                GoogleSignInAccount googleSignInAccount = null;
                int iM6436K12 = 0;
                int iM6436K13 = 0;
                while (parcel.dataPosition() < iM6447V6) {
                    int i16 = parcel.readInt();
                    char c12 = (char) i16;
                    if (c12 == 1) {
                        iM6436K12 = AbstractC3198d.m6436K(parcel, i16);
                    } else if (c12 == 2) {
                        account = (Account) AbstractC3198d.m6462j(parcel, i16, Account.CREATOR);
                    } else if (c12 == 3) {
                        iM6436K13 = AbstractC3198d.m6436K(parcel, i16);
                    } else if (c12 != 4) {
                        AbstractC3198d.m6445T(parcel, i16);
                    } else {
                        googleSignInAccount = (GoogleSignInAccount) AbstractC3198d.m6462j(parcel, i16, GoogleSignInAccount.CREATOR);
                    }
                }
                AbstractC3198d.m6470r(parcel, iM6447V6);
                return new zat(iM6436K12, account, iM6436K13, googleSignInAccount);
            case 9:
                int iM6447V7 = AbstractC3198d.m6447V(parcel);
                IBinder iBinderM6435J = null;
                ConnectionResult connectionResult = null;
                int iM6436K14 = 0;
                boolean zM6431F = false;
                boolean zM6431F2 = false;
                while (parcel.dataPosition() < iM6447V7) {
                    int i17 = parcel.readInt();
                    char c13 = (char) i17;
                    if (c13 == 1) {
                        iM6436K14 = AbstractC3198d.m6436K(parcel, i17);
                    } else if (c13 == 2) {
                        iBinderM6435J = AbstractC3198d.m6435J(parcel, i17);
                    } else if (c13 == 3) {
                        connectionResult = (ConnectionResult) AbstractC3198d.m6462j(parcel, i17, ConnectionResult.CREATOR);
                    } else if (c13 == 4) {
                        zM6431F = AbstractC3198d.m6431F(parcel, i17);
                    } else if (c13 != 5) {
                        AbstractC3198d.m6445T(parcel, i17);
                    } else {
                        zM6431F2 = AbstractC3198d.m6431F(parcel, i17);
                    }
                }
                AbstractC3198d.m6470r(parcel, iM6447V7);
                return new zav(iM6436K14, iBinderM6435J, connectionResult, zM6431F, zM6431F2);
            case 10:
                int iM6447V8 = AbstractC3198d.m6447V(parcel);
                Scope[] scopeArr = null;
                int iM6436K15 = 0;
                int iM6436K16 = 0;
                int iM6436K17 = 0;
                while (parcel.dataPosition() < iM6447V8) {
                    int i18 = parcel.readInt();
                    char c14 = (char) i18;
                    if (c14 == 1) {
                        iM6436K15 = AbstractC3198d.m6436K(parcel, i18);
                    } else if (c14 == 2) {
                        iM6436K16 = AbstractC3198d.m6436K(parcel, i18);
                    } else if (c14 == 3) {
                        iM6436K17 = AbstractC3198d.m6436K(parcel, i18);
                    } else if (c14 != 4) {
                        AbstractC3198d.m6445T(parcel, i18);
                    } else {
                        scopeArr = (Scope[]) AbstractC3198d.m6467o(parcel, i18, Scope.CREATOR);
                    }
                }
                AbstractC3198d.m6470r(parcel, iM6447V8);
                return new zax(iM6436K15, iM6436K16, iM6436K17, scopeArr);
            case 11:
                int iM6447V9 = AbstractC3198d.m6447V(parcel);
                int iM6436K18 = 0;
                boolean zM6431F3 = false;
                boolean zM6431F4 = false;
                int iM6436K19 = 0;
                int iM6436K20 = 0;
                while (parcel.dataPosition() < iM6447V9) {
                    int i19 = parcel.readInt();
                    char c15 = (char) i19;
                    if (c15 == 1) {
                        iM6436K18 = AbstractC3198d.m6436K(parcel, i19);
                    } else if (c15 == 2) {
                        zM6431F3 = AbstractC3198d.m6431F(parcel, i19);
                    } else if (c15 == 3) {
                        zM6431F4 = AbstractC3198d.m6431F(parcel, i19);
                    } else if (c15 == 4) {
                        iM6436K19 = AbstractC3198d.m6436K(parcel, i19);
                    } else if (c15 != 5) {
                        AbstractC3198d.m6445T(parcel, i19);
                    } else {
                        iM6436K20 = AbstractC3198d.m6436K(parcel, i19);
                    }
                }
                AbstractC3198d.m6470r(parcel, iM6447V9);
                return new RootTelemetryConfiguration(iM6436K18, zM6431F3, zM6431F4, iM6436K19, iM6436K20);
            case 12:
                int iM6447V10 = AbstractC3198d.m6447V(parcel);
                int iM6436K21 = 0;
                while (parcel.dataPosition() < iM6447V10) {
                    int i20 = parcel.readInt();
                    if (((char) i20) != 1) {
                        AbstractC3198d.m6445T(parcel, i20);
                    } else {
                        iM6436K21 = AbstractC3198d.m6436K(parcel, i20);
                    }
                }
                AbstractC3198d.m6470r(parcel, iM6447V10);
                return new zzal(iM6436K21);
            case 13:
                return new BinderWrapper(parcel);
            case 14:
                int iM6447V11 = AbstractC3198d.m6447V(parcel);
                Bundle bundleM6458f2 = null;
                Feature[] featureArr = null;
                ConnectionTelemetryConfiguration connectionTelemetryConfiguration = null;
                int iM6436K22 = 0;
                while (parcel.dataPosition() < iM6447V11) {
                    int i21 = parcel.readInt();
                    char c16 = (char) i21;
                    if (c16 == 1) {
                        bundleM6458f2 = AbstractC3198d.m6458f(parcel, i21);
                    } else if (c16 == 2) {
                        featureArr = (Feature[]) AbstractC3198d.m6467o(parcel, i21, Feature.CREATOR);
                    } else if (c16 == 3) {
                        iM6436K22 = AbstractC3198d.m6436K(parcel, i21);
                    } else if (c16 != 4) {
                        AbstractC3198d.m6445T(parcel, i21);
                    } else {
                        connectionTelemetryConfiguration = (ConnectionTelemetryConfiguration) AbstractC3198d.m6462j(parcel, i21, ConnectionTelemetryConfiguration.CREATOR);
                    }
                }
                AbstractC3198d.m6470r(parcel, iM6447V11);
                zzk zzkVar = new zzk();
                zzkVar.f5107a = bundleM6458f2;
                zzkVar.f5108b = featureArr;
                zzkVar.f5109c = iM6436K22;
                zzkVar.f5110d = connectionTelemetryConfiguration;
                return zzkVar;
            case 15:
                int iM6447V12 = AbstractC3198d.m6447V(parcel);
                RootTelemetryConfiguration rootTelemetryConfiguration = null;
                int[] iArrM6460h = null;
                int[] iArrM6460h2 = null;
                boolean zM6431F5 = false;
                boolean zM6431F6 = false;
                int iM6436K23 = 0;
                while (parcel.dataPosition() < iM6447V12) {
                    int i22 = parcel.readInt();
                    switch ((char) i22) {
                        case 1:
                            rootTelemetryConfiguration = (RootTelemetryConfiguration) AbstractC3198d.m6462j(parcel, i22, RootTelemetryConfiguration.CREATOR);
                            break;
                        case 2:
                            zM6431F5 = AbstractC3198d.m6431F(parcel, i22);
                            break;
                        case 3:
                            zM6431F6 = AbstractC3198d.m6431F(parcel, i22);
                            break;
                        case 4:
                            iArrM6460h = AbstractC3198d.m6460h(parcel, i22);
                            break;
                        case 5:
                            iM6436K23 = AbstractC3198d.m6436K(parcel, i22);
                            break;
                        case 6:
                            iArrM6460h2 = AbstractC3198d.m6460h(parcel, i22);
                            break;
                        default:
                            AbstractC3198d.m6445T(parcel, i22);
                            break;
                    }
                }
                AbstractC3198d.m6470r(parcel, iM6447V12);
                return new ConnectionTelemetryConfiguration(rootTelemetryConfiguration, zM6431F5, zM6431F6, iArrM6460h, iM6436K23, iArrM6460h2);
            case 16:
                int iM6447V13 = AbstractC3198d.m6447V(parcel);
                Scope[] scopeArr2 = GetServiceRequest.f5036o;
                Bundle bundle = new Bundle();
                Feature[] featureArr2 = GetServiceRequest.f5037p;
                Feature[] featureArr3 = featureArr2;
                String strM6463k4 = null;
                IBinder iBinderM6435J2 = null;
                Account account2 = null;
                String strM6463k5 = null;
                int iM6436K24 = 0;
                int iM6436K25 = 0;
                int iM6436K26 = 0;
                boolean zM6431F7 = false;
                int iM6436K27 = 0;
                boolean zM6431F8 = false;
                while (parcel.dataPosition() < iM6447V13) {
                    int i23 = parcel.readInt();
                    switch ((char) i23) {
                        case 1:
                            iM6436K24 = AbstractC3198d.m6436K(parcel, i23);
                            break;
                        case 2:
                            iM6436K25 = AbstractC3198d.m6436K(parcel, i23);
                            break;
                        case 3:
                            iM6436K26 = AbstractC3198d.m6436K(parcel, i23);
                            break;
                        case 4:
                            strM6463k4 = AbstractC3198d.m6463k(parcel, i23);
                            break;
                        case 5:
                            iBinderM6435J2 = AbstractC3198d.m6435J(parcel, i23);
                            break;
                        case 6:
                            scopeArr2 = (Scope[]) AbstractC3198d.m6467o(parcel, i23, Scope.CREATOR);
                            break;
                        case 7:
                            bundle = AbstractC3198d.m6458f(parcel, i23);
                            break;
                        case '\b':
                            account2 = (Account) AbstractC3198d.m6462j(parcel, i23, Account.CREATOR);
                            break;
                        case '\t':
                        default:
                            AbstractC3198d.m6445T(parcel, i23);
                            break;
                        case '\n':
                            featureArr2 = (Feature[]) AbstractC3198d.m6467o(parcel, i23, Feature.CREATOR);
                            break;
                        case 11:
                            featureArr3 = (Feature[]) AbstractC3198d.m6467o(parcel, i23, Feature.CREATOR);
                            break;
                        case '\f':
                            zM6431F7 = AbstractC3198d.m6431F(parcel, i23);
                            break;
                        case '\r':
                            iM6436K27 = AbstractC3198d.m6436K(parcel, i23);
                            break;
                        case 14:
                            zM6431F8 = AbstractC3198d.m6431F(parcel, i23);
                            break;
                        case 15:
                            strM6463k5 = AbstractC3198d.m6463k(parcel, i23);
                            break;
                    }
                }
                AbstractC3198d.m6470r(parcel, iM6447V13);
                return new GetServiceRequest(iM6436K24, iM6436K25, iM6436K26, strM6463k4, iBinderM6435J2, scopeArr2, bundle, account2, featureArr2, featureArr3, zM6431F7, iM6436K27, zM6431F8, strM6463k5);
            case 17:
                return new CrashDetailBean(parcel);
            case 18:
                return new ActivityResult(parcel);
            case 19:
                return new IntentSenderRequest(parcel);
            case 20:
                int iM6447V14 = AbstractC3198d.m6447V(parcel);
                int iM6436K28 = 0;
                Uri uri = null;
                int iM6436K29 = 0;
                int iM6436K30 = 0;
                while (parcel.dataPosition() < iM6447V14) {
                    int i24 = parcel.readInt();
                    char c17 = (char) i24;
                    if (c17 == 1) {
                        iM6436K28 = AbstractC3198d.m6436K(parcel, i24);
                    } else if (c17 == 2) {
                        uri = (Uri) AbstractC3198d.m6462j(parcel, i24, Uri.CREATOR);
                    } else if (c17 == 3) {
                        iM6436K29 = AbstractC3198d.m6436K(parcel, i24);
                    } else if (c17 != 4) {
                        AbstractC3198d.m6445T(parcel, i24);
                    } else {
                        iM6436K30 = AbstractC3198d.m6436K(parcel, i24);
                    }
                }
                AbstractC3198d.m6470r(parcel, iM6447V14);
                return new WebImage(iM6436K28, uri, iM6436K29, iM6436K30);
            case 21:
                int i25 = parcel.readInt();
                ParcelableSparseBooleanArray parcelableSparseBooleanArray = new ParcelableSparseBooleanArray(i25);
                int[] iArr = new int[i25];
                boolean[] zArr = new boolean[i25];
                parcel.readIntArray(iArr);
                parcel.readBooleanArray(zArr);
                for (int i26 = 0; i26 < i25; i26++) {
                    parcelableSparseBooleanArray.put(iArr[i26], zArr[i26]);
                }
                return parcelableSparseBooleanArray;
            case 22:
                int i27 = parcel.readInt();
                ParcelableSparseIntArray parcelableSparseIntArray = new ParcelableSparseIntArray(i27);
                int[] iArr2 = new int[i27];
                int[] iArr3 = new int[i27];
                parcel.readIntArray(iArr2);
                parcel.readIntArray(iArr3);
                for (int i28 = 0; i28 < i27; i28++) {
                    parcelableSparseIntArray.put(iArr2[i28], iArr3[i28]);
                }
                return parcelableSparseIntArray;
            case 23:
                int iM6447V15 = AbstractC3198d.m6447V(parcel);
                boolean zM6431F9 = false;
                int iM6436K31 = 0;
                while (parcel.dataPosition() < iM6447V15) {
                    int i29 = parcel.readInt();
                    char c18 = (char) i29;
                    if (c18 == 1) {
                        zM6431F9 = AbstractC3198d.m6431F(parcel, i29);
                    } else if (c18 != 2) {
                        AbstractC3198d.m6445T(parcel, i29);
                    } else {
                        iM6436K31 = AbstractC3198d.m6436K(parcel, i29);
                    }
                }
                AbstractC3198d.m6470r(parcel, iM6447V15);
                return new ModuleAvailabilityResponse(zM6431F9, iM6436K31);
            case 24:
                int iM6447V16 = AbstractC3198d.m6447V(parcel);
                PendingIntent pendingIntent = null;
                while (parcel.dataPosition() < iM6447V16) {
                    int i30 = parcel.readInt();
                    if (((char) i30) != 1) {
                        AbstractC3198d.m6445T(parcel, i30);
                    } else {
                        pendingIntent = (PendingIntent) AbstractC3198d.m6462j(parcel, i30, PendingIntent.CREATOR);
                    }
                }
                AbstractC3198d.m6470r(parcel, iM6447V16);
                return new ModuleInstallIntentResponse(pendingIntent);
            case 25:
                int iM6447V17 = AbstractC3198d.m6447V(parcel);
                int iM6436K32 = 0;
                boolean zM6431F10 = false;
                while (parcel.dataPosition() < iM6447V17) {
                    int i31 = parcel.readInt();
                    char c19 = (char) i31;
                    if (c19 == 1) {
                        iM6436K32 = AbstractC3198d.m6436K(parcel, i31);
                    } else if (c19 != 2) {
                        AbstractC3198d.m6445T(parcel, i31);
                    } else {
                        zM6431F10 = AbstractC3198d.m6431F(parcel, i31);
                    }
                }
                AbstractC3198d.m6470r(parcel, iM6447V17);
                return new ModuleInstallResponse(iM6436K32, zM6431F10);
            case 26:
                int iM6447V18 = AbstractC3198d.m6447V(parcel);
                Long lValueOf = null;
                Long lValueOf2 = null;
                int iM6436K33 = 0;
                int iM6436K34 = 0;
                int iM6436K35 = 0;
                while (parcel.dataPosition() < iM6447V18) {
                    int i32 = parcel.readInt();
                    char c20 = (char) i32;
                    if (c20 == 1) {
                        iM6436K33 = AbstractC3198d.m6436K(parcel, i32);
                    } else if (c20 == 2) {
                        iM6436K34 = AbstractC3198d.m6436K(parcel, i32);
                    } else if (c20 == 3) {
                        int iM6439N = AbstractC3198d.m6439N(parcel, i32);
                        if (iM6439N == 0) {
                            lValueOf = null;
                        } else {
                            AbstractC3198d.m6451Z(parcel, iM6439N, 8);
                            lValueOf = Long.valueOf(parcel.readLong());
                        }
                    } else if (c20 == 4) {
                        int iM6439N2 = AbstractC3198d.m6439N(parcel, i32);
                        if (iM6439N2 == 0) {
                            lValueOf2 = null;
                        } else {
                            AbstractC3198d.m6451Z(parcel, iM6439N2, 8);
                            lValueOf2 = Long.valueOf(parcel.readLong());
                        }
                    } else if (c20 != 5) {
                        AbstractC3198d.m6445T(parcel, i32);
                    } else {
                        iM6436K35 = AbstractC3198d.m6436K(parcel, i32);
                    }
                }
                AbstractC3198d.m6470r(parcel, iM6447V18);
                return new ModuleInstallStatusUpdate(iM6436K33, iM6436K34, lValueOf, lValueOf2, iM6436K35);
            case 27:
                int iM6447V19 = AbstractC3198d.m6447V(parcel);
                ArrayList arrayListM6468p2 = null;
                String strM6463k6 = null;
                String strM6463k7 = null;
                boolean zM6431F11 = false;
                while (parcel.dataPosition() < iM6447V19) {
                    int i33 = parcel.readInt();
                    char c21 = (char) i33;
                    if (c21 == 1) {
                        arrayListM6468p2 = AbstractC3198d.m6468p(parcel, i33, Feature.CREATOR);
                    } else if (c21 == 2) {
                        zM6431F11 = AbstractC3198d.m6431F(parcel, i33);
                    } else if (c21 == 3) {
                        strM6463k6 = AbstractC3198d.m6463k(parcel, i33);
                    } else if (c21 != 4) {
                        AbstractC3198d.m6445T(parcel, i33);
                    } else {
                        strM6463k7 = AbstractC3198d.m6463k(parcel, i33);
                    }
                }
                AbstractC3198d.m6470r(parcel, iM6447V19);
                return new ApiFeatureRequest(arrayListM6468p2, zM6431F11, strM6463k6, strM6463k7);
            case 28:
                int iM6447V20 = AbstractC3198d.m6447V(parcel);
                int iM6436K36 = 0;
                String strM6463k8 = null;
                int iM6436K37 = 0;
                while (parcel.dataPosition() < iM6447V20) {
                    int i34 = parcel.readInt();
                    char c22 = (char) i34;
                    if (c22 == 1) {
                        iM6436K36 = AbstractC3198d.m6436K(parcel, i34);
                    } else if (c22 == 2) {
                        strM6463k8 = AbstractC3198d.m6463k(parcel, i34);
                    } else if (c22 != 3) {
                        AbstractC3198d.m6445T(parcel, i34);
                    } else {
                        iM6436K37 = AbstractC3198d.m6436K(parcel, i34);
                    }
                }
                AbstractC3198d.m6470r(parcel, iM6447V20);
                return new FavaDiagnosticsEntity(iM6436K36, iM6436K37, strM6463k8);
            default:
                int iM6447V21 = AbstractC3198d.m6447V(parcel);
                StringToIntConverter stringToIntConverter = null;
                int iM6436K38 = 0;
                while (parcel.dataPosition() < iM6447V21) {
                    int i35 = parcel.readInt();
                    char c23 = (char) i35;
                    if (c23 == 1) {
                        iM6436K38 = AbstractC3198d.m6436K(parcel, i35);
                    } else if (c23 != 2) {
                        AbstractC3198d.m6445T(parcel, i35);
                    } else {
                        stringToIntConverter = (StringToIntConverter) AbstractC3198d.m6462j(parcel, i35, StringToIntConverter.CREATOR);
                    }
                }
                AbstractC3198d.m6470r(parcel, iM6447V21);
                return new zaa(iM6436K38, stringToIntConverter);
        }
    }

    @Override
    public final Object[] newArray(int i6) {
        switch (this.f13692a) {
            case 0:
                return new ObservableParcelable[i6];
            case 1:
                return new ParcelImpl[i6];
            case 2:
                return new BitmapTeleporter[i6];
            case 3:
                return new DataHolder[i6];
            case 4:
                return new StrategyBean[i6];
            case 5:
                return new ClientIdentity[i6];
            case 6:
                return new TelemetryData[i6];
            case 7:
                return new MethodInvocation[i6];
            case 8:
                return new zat[i6];
            case 9:
                return new zav[i6];
            case 10:
                return new zax[i6];
            case 11:
                return new RootTelemetryConfiguration[i6];
            case 12:
                return new zzal[i6];
            case 13:
                return new BinderWrapper[i6];
            case 14:
                return new zzk[i6];
            case 15:
                return new ConnectionTelemetryConfiguration[i6];
            case 16:
                return new GetServiceRequest[i6];
            case 17:
                return new CrashDetailBean[i6];
            case 18:
                return new ActivityResult[i6];
            case 19:
                return new IntentSenderRequest[i6];
            case 20:
                return new WebImage[i6];
            case 21:
                return new ParcelableSparseBooleanArray[i6];
            case 22:
                return new ParcelableSparseIntArray[i6];
            case 23:
                return new ModuleAvailabilityResponse[i6];
            case 24:
                return new ModuleInstallIntentResponse[i6];
            case 25:
                return new ModuleInstallResponse[i6];
            case 26:
                return new ModuleInstallStatusUpdate[i6];
            case 27:
                return new ApiFeatureRequest[i6];
            case 28:
                return new FavaDiagnosticsEntity[i6];
            default:
                return new zaa[i6];
        }
    }
}
