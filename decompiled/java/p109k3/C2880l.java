package p109k3;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.ComponentCallbacks2C1464b;
import com.bumptech.glide.ComponentCallbacks2C1491o;
import p007a7.C0069f;
import p049e3.C2404v;
import p186r3.AbstractC3610n;
import p221u6.C3905e;
import p249x4.C4112e;

public final class C2880l implements Handler.Callback {

    public static final C3905e f9812d = new C3905e(18);

    public volatile ComponentCallbacks2C1491o f9813a;

    public final InterfaceC2874f f9814b;

    public final C0069f f9815c = new C0069f(f9812d);

    public C2880l() {
        this.f9814b = (C2404v.f8382f && C2404v.f8381e) ? new C2873e() : new C4112e(16);
    }

    public static Activity m5863a(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return m5863a(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    public final ComponentCallbacks2C1491o m5864b(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("You cannot start a load on a null Context");
        }
        char[] cArr = AbstractC3610n.f12112a;
        if (Looper.myLooper() == Looper.getMainLooper() && !(context instanceof Application)) {
            if (context instanceof FragmentActivity) {
                return m5865c((FragmentActivity) context);
            }
            if (context instanceof ContextWrapper) {
                ContextWrapper contextWrapper = (ContextWrapper) context;
                if (contextWrapper.getBaseContext().getApplicationContext() != null) {
                    return m5864b(contextWrapper.getBaseContext());
                }
            }
        }
        if (this.f9813a == null) {
            synchronized (this) {
                try {
                    if (this.f9813a == null) {
                        this.f9813a = new ComponentCallbacks2C1491o(ComponentCallbacks2C1464b.m3461a(context.getApplicationContext()), new C4112e(15), new C3905e(17), context.getApplicationContext());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.f9813a;
    }

    public final ComponentCallbacks2C1491o m5865c(FragmentActivity fragmentActivity) {
        char[] cArr = AbstractC3610n.f12112a;
        if (!(Looper.myLooper() == Looper.getMainLooper())) {
            return m5864b(fragmentActivity.getApplicationContext());
        }
        if (fragmentActivity.isDestroyed()) {
            throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
        }
        this.f9814b.mo5860a(fragmentActivity);
        Activity activityM5863a = m5863a(fragmentActivity);
        return this.f9815c.m220C(fragmentActivity, ComponentCallbacks2C1464b.m3461a(fragmentActivity.getApplicationContext()), fragmentActivity.f228d, fragmentActivity.m1184k(), activityM5863a == null || !activityM5863a.isFinishing());
    }

    @Override
    public final boolean handleMessage(Message message) {
        return false;
    }
}
