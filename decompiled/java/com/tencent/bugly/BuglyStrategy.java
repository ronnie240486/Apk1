package com.tencent.bugly;

import com.tencent.bugly.proguard.C2018aa;
import java.util.Map;

public class BuglyStrategy {

    private String f7019c;

    private String f7020d;

    private String f7021e;

    private long f7022f;

    private String f7023g;

    private String f7024h;

    private String f7025i;

    private C2006a f7037u;

    private boolean f7026j = true;

    private boolean f7027k = true;

    private boolean f7028l = true;

    private boolean f7029m = false;

    private boolean f7030n = true;

    private Class<?> f7031o = null;

    private boolean f7032p = true;

    private boolean f7033q = true;

    private boolean f7034r = true;

    private boolean f7035s = true;

    private boolean f7036t = false;

    protected int f7017a = 31;

    protected boolean f7018b = false;

    private boolean f7038v = false;

    public static class C2006a {
        public static final int CRASHTYPE_ANR = 4;
        public static final int CRASHTYPE_BLOCK = 7;
        public static final int CRASHTYPE_COCOS2DX_JS = 5;
        public static final int CRASHTYPE_COCOS2DX_LUA = 6;
        public static final int CRASHTYPE_JAVA_CATCH = 1;
        public static final int CRASHTYPE_JAVA_CRASH = 0;
        public static final int CRASHTYPE_NATIVE = 2;
        public static final int CRASHTYPE_U3D = 3;
        public static final int MAX_USERDATA_KEY_LENGTH = 100;
        public static final int MAX_USERDATA_VALUE_LENGTH = 100000;

        public synchronized Map<String, String> onCrashHandleStart(int i6, String str, String str2, String str3) {
            return null;
        }

        public synchronized byte[] onCrashHandleStart2GetExtraDatas(int i6, String str, String str2, String str3) {
            return null;
        }
    }

    public synchronized String getAppChannel() {
        String str = this.f7020d;
        if (str != null) {
            return str;
        }
        return C2018aa.m4509b().f7243s;
    }

    public synchronized String getAppPackageName() {
        String str = this.f7021e;
        if (str != null) {
            return str;
        }
        return C2018aa.m4509b().f7227c;
    }

    public synchronized long getAppReportDelay() {
        return this.f7022f;
    }

    public synchronized String getAppVersion() {
        String str = this.f7019c;
        if (str != null) {
            return str;
        }
        return C2018aa.m4509b().f7239o;
    }

    public synchronized int getCallBackType() {
        return this.f7017a;
    }

    public synchronized boolean getCloseErrorCallback() {
        return this.f7018b;
    }

    public synchronized C2006a getCrashHandleCallback() {
        return this.f7037u;
    }

    public synchronized String getDeviceID() {
        return this.f7024h;
    }

    public synchronized String getDeviceModel() {
        return this.f7025i;
    }

    public synchronized String getLibBuglySOFilePath() {
        return this.f7023g;
    }

    public synchronized Class<?> getUserInfoActivity() {
        return this.f7031o;
    }

    public synchronized boolean isBuglyLogUpload() {
        return this.f7032p;
    }

    public synchronized boolean isEnableANRCrashMonitor() {
        return this.f7027k;
    }

    public synchronized boolean isEnableCatchAnrTrace() {
        return this.f7028l;
    }

    public synchronized boolean isEnableNativeCrashMonitor() {
        return this.f7026j;
    }

    public boolean isEnableRecordAnrMainStack() {
        return this.f7029m;
    }

    public synchronized boolean isEnableUserInfo() {
        return this.f7030n;
    }

    public boolean isMerged() {
        return this.f7038v;
    }

    public boolean isReplaceOldChannel() {
        return this.f7033q;
    }

    public synchronized boolean isUploadProcess() {
        return this.f7034r;
    }

    public synchronized boolean isUploadSpotCrash() {
        return this.f7035s;
    }

    public synchronized boolean recordUserInfoOnceADay() {
        return this.f7036t;
    }

    public synchronized BuglyStrategy setAppChannel(String str) {
        this.f7020d = str;
        return this;
    }

    public synchronized BuglyStrategy setAppPackageName(String str) {
        this.f7021e = str;
        return this;
    }

    public synchronized BuglyStrategy setAppReportDelay(long j10) {
        this.f7022f = j10;
        return this;
    }

    public synchronized BuglyStrategy setAppVersion(String str) {
        this.f7019c = str;
        return this;
    }

    public synchronized BuglyStrategy setBuglyLogUpload(boolean z7) {
        this.f7032p = z7;
        return this;
    }

    public synchronized void setCallBackType(int i6) {
        this.f7017a = i6;
    }

    public synchronized void setCloseErrorCallback(boolean z7) {
        this.f7018b = z7;
    }

    public synchronized BuglyStrategy setCrashHandleCallback(C2006a c2006a) {
        this.f7037u = c2006a;
        return this;
    }

    public synchronized BuglyStrategy setDeviceID(String str) {
        this.f7024h = str;
        return this;
    }

    public synchronized BuglyStrategy setDeviceModel(String str) {
        this.f7025i = str;
        return this;
    }

    public synchronized BuglyStrategy setEnableANRCrashMonitor(boolean z7) {
        this.f7027k = z7;
        return this;
    }

    public void setEnableCatchAnrTrace(boolean z7) {
        this.f7028l = z7;
    }

    public synchronized BuglyStrategy setEnableNativeCrashMonitor(boolean z7) {
        this.f7026j = z7;
        return this;
    }

    public void setEnableRecordAnrMainStack(boolean z7) {
        this.f7029m = z7;
    }

    public synchronized BuglyStrategy setEnableUserInfo(boolean z7) {
        this.f7030n = z7;
        return this;
    }

    public synchronized BuglyStrategy setLibBuglySOFilePath(String str) {
        this.f7023g = str;
        return this;
    }

    @Deprecated
    public void setMerged(boolean z7) {
        this.f7038v = z7;
    }

    public synchronized BuglyStrategy setRecordUserInfoOnceADay(boolean z7) {
        this.f7036t = z7;
        return this;
    }

    public void setReplaceOldChannel(boolean z7) {
        this.f7033q = z7;
    }

    public synchronized BuglyStrategy setUploadProcess(boolean z7) {
        this.f7034r = z7;
        return this;
    }

    public synchronized void setUploadSpotCrash(boolean z7) {
        this.f7035s = z7;
    }

    public synchronized BuglyStrategy setUserInfoActivity(Class<?> cls) {
        this.f7031o = cls;
        return this;
    }
}
