package com.google.android.gms.flags.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.util.Log;
import com.google.android.gms.common.util.DynamiteApi;
import p132m5.BinderC3079b;
import p132m5.InterfaceC3078a;
import p153o5.AbstractBinderC3258b;
import p156o9.AbstractC3281e;
import p166p5.CallableC3372a;
import p222u7.AbstractC3928d;

@DynamiteApi
public class FlagProviderImpl extends AbstractBinderC3258b {

    public boolean f5192c;

    public SharedPreferences f5193d;

    public FlagProviderImpl() {
        attachInterface(this, "com.google.android.gms.flags.IFlagProvider");
        this.f5192c = false;
    }

    @Override
    public boolean getBooleanFlagValue(String str, boolean z7, int i6) {
        if (!this.f5192c) {
            return z7;
        }
        SharedPreferences sharedPreferences = this.f5193d;
        Boolean boolValueOf = Boolean.valueOf(z7);
        try {
            boolValueOf = (Boolean) AbstractC3928d.m7839A(new CallableC3372a(sharedPreferences, str, boolValueOf, 0));
        } catch (Exception e5) {
            String strValueOf = String.valueOf(e5.getMessage());
            Log.w("FlagDataUtils", strValueOf.length() != 0 ? "Flag value not available, returning default: ".concat(strValueOf) : new String("Flag value not available, returning default: "));
        }
        return boolValueOf.booleanValue();
    }

    @Override
    public int getIntFlagValue(String str, int i6, int i10) {
        if (!this.f5192c) {
            return i6;
        }
        SharedPreferences sharedPreferences = this.f5193d;
        Integer numValueOf = Integer.valueOf(i6);
        try {
            numValueOf = (Integer) AbstractC3928d.m7839A(new CallableC3372a(sharedPreferences, str, numValueOf, 1));
        } catch (Exception e5) {
            String strValueOf = String.valueOf(e5.getMessage());
            Log.w("FlagDataUtils", strValueOf.length() != 0 ? "Flag value not available, returning default: ".concat(strValueOf) : new String("Flag value not available, returning default: "));
        }
        return numValueOf.intValue();
    }

    @Override
    public long getLongFlagValue(String str, long j10, int i6) {
        if (!this.f5192c) {
            return j10;
        }
        SharedPreferences sharedPreferences = this.f5193d;
        Long lValueOf = Long.valueOf(j10);
        try {
            lValueOf = (Long) AbstractC3928d.m7839A(new CallableC3372a(sharedPreferences, str, lValueOf, 2));
        } catch (Exception e5) {
            String strValueOf = String.valueOf(e5.getMessage());
            Log.w("FlagDataUtils", strValueOf.length() != 0 ? "Flag value not available, returning default: ".concat(strValueOf) : new String("Flag value not available, returning default: "));
        }
        return lValueOf.longValue();
    }

    @Override
    public String getStringFlagValue(String str, String str2, int i6) {
        if (!this.f5192c) {
            return str2;
        }
        try {
            return (String) AbstractC3928d.m7839A(new CallableC3372a(this.f5193d, str, str2, 3));
        } catch (Exception e5) {
            String strValueOf = String.valueOf(e5.getMessage());
            Log.w("FlagDataUtils", strValueOf.length() != 0 ? "Flag value not available, returning default: ".concat(strValueOf) : new String("Flag value not available, returning default: "));
            return str2;
        }
    }

    @Override
    public void init(InterfaceC3078a interfaceC3078a) {
        Context context = (Context) BinderC3079b.m6112y(interfaceC3078a);
        if (this.f5192c) {
            return;
        }
        try {
            this.f5193d = AbstractC3281e.m6614J(context.createPackageContext("com.google.android.gms", 0));
            this.f5192c = true;
        } catch (PackageManager.NameNotFoundException unused) {
        } catch (Exception e5) {
            String strValueOf = String.valueOf(e5.getMessage());
            Log.w("FlagProviderImpl", strValueOf.length() != 0 ? "Could not retrieve sdk flags, continuing with defaults: ".concat(strValueOf) : new String("Could not retrieve sdk flags, continuing with defaults: "));
        }
    }
}
