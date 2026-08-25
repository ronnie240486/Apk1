package p138n0;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.view.InputDevice;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Objects;

public final class C3121h {

    public final Context f10602a;

    public final InterfaceC3124i f10603b;

    public VelocityTracker f10604c;

    public float f10605d;

    public int f10606e = -1;

    public int f10607f = -1;

    public int f10608g = -1;

    public final int[] f10609h = {Integer.MAX_VALUE, 0};

    public C3121h(Context context, InterfaceC3124i interfaceC3124i) {
        this.f10602a = context;
        this.f10603b = interfaceC3124i;
    }

    public final void m6188a(MotionEvent motionEvent, int i6) {
        int scaledMinimumFlingVelocity;
        int scaledMaximumFlingVelocity;
        char c5;
        boolean z7;
        float yVelocity;
        long j10;
        C3101a0 c3101a0;
        float fSqrt;
        C3101a0 c3101a1;
        int i10;
        int source = motionEvent.getSource();
        int deviceId = motionEvent.getDeviceId();
        int i11 = this.f10607f;
        int[] iArr = this.f10609h;
        if (i11 == source && this.f10608g == deviceId && this.f10606e == i6) {
            c5 = 0;
            z7 = false;
        } else {
            Context context = this.f10602a;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            int deviceId2 = motionEvent.getDeviceId();
            int source2 = motionEvent.getSource();
            int i12 = Build.VERSION.SDK_INT;
            if (i12 >= 34) {
                Method method = AbstractC3167w0.f10655a;
                scaledMinimumFlingVelocity = AbstractC3164v0.m6360b(viewConfiguration, deviceId2, i6, source2);
            } else {
                Method method2 = AbstractC3167w0.f10655a;
                InputDevice device = InputDevice.getDevice(deviceId2);
                if (device == null || device.getMotionRange(i6, source2) == null) {
                    scaledMinimumFlingVelocity = Integer.MAX_VALUE;
                } else {
                    Resources resources = context.getResources();
                    int identifier = (source2 == 4194304 && i6 == 26) ? resources.getIdentifier("config_viewMinRotaryEncoderFlingVelocity", "dimen", "android") : -1;
                    Objects.requireNonNull(viewConfiguration);
                    if (identifier == -1) {
                        scaledMinimumFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
                    } else if (identifier == 0 || (scaledMinimumFlingVelocity = resources.getDimensionPixelSize(identifier)) < 0) {
                        scaledMinimumFlingVelocity = Integer.MAX_VALUE;
                    }
                }
            }
            iArr[0] = scaledMinimumFlingVelocity;
            int deviceId3 = motionEvent.getDeviceId();
            int source3 = motionEvent.getSource();
            if (i12 >= 34) {
                scaledMaximumFlingVelocity = AbstractC3164v0.m6359a(viewConfiguration, deviceId3, i6, source3);
            } else {
                InputDevice device2 = InputDevice.getDevice(deviceId3);
                if ((device2 == null || device2.getMotionRange(i6, source3) == null) ? false : true) {
                    Resources resources2 = context.getResources();
                    int identifier2 = (source3 == 4194304 && i6 == 26) ? resources2.getIdentifier("config_viewMaxRotaryEncoderFlingVelocity", "dimen", "android") : -1;
                    Objects.requireNonNull(viewConfiguration);
                    if (identifier2 == -1) {
                        scaledMaximumFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
                    } else if (identifier2 != 0) {
                        int dimensionPixelSize = resources2.getDimensionPixelSize(identifier2);
                        scaledMaximumFlingVelocity = dimensionPixelSize >= 0 ? dimensionPixelSize : Integer.MIN_VALUE;
                    } else {
                        scaledMaximumFlingVelocity = Integer.MIN_VALUE;
                    }
                } else {
                    scaledMaximumFlingVelocity = Integer.MIN_VALUE;
                }
            }
            iArr[1] = scaledMaximumFlingVelocity;
            this.f10607f = source;
            this.f10608g = deviceId;
            this.f10606e = i6;
            c5 = 0;
            z7 = true;
        }
        if (iArr[c5] == Integer.MAX_VALUE) {
            VelocityTracker velocityTracker = this.f10604c;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.f10604c = null;
                return;
            }
            return;
        }
        if (this.f10604c == null) {
            this.f10604c = VelocityTracker.obtain();
        }
        VelocityTracker velocityTracker2 = this.f10604c;
        Map map = AbstractC3172z.f10662a;
        velocityTracker2.addMovement(motionEvent);
        float f = 0.0f;
        if (Build.VERSION.SDK_INT < 34 && motionEvent.getSource() == 4194304) {
            Map map2 = AbstractC3172z.f10662a;
            if (!map2.containsKey(velocityTracker2)) {
                map2.put(velocityTracker2, new C3101a0());
            }
            C3101a0 c3101a2 = (C3101a0) map2.get(velocityTracker2);
            c3101a2.getClass();
            long eventTime = motionEvent.getEventTime();
            int i13 = c3101a2.f10572d;
            long[] jArr = c3101a2.f10570b;
            if (i13 != 0 && eventTime - jArr[c3101a2.f10573e] > 40) {
                c3101a2.f10572d = 0;
                c3101a2.f10571c = 0.0f;
            }
            int i14 = (c3101a2.f10573e + 1) % 20;
            c3101a2.f10573e = i14;
            int i15 = c3101a2.f10572d;
            if (i15 != 20) {
                c3101a2.f10572d = i15 + 1;
            }
            c3101a2.f10569a[i14] = motionEvent.getAxisValue(26);
            jArr[c3101a2.f10573e] = eventTime;
        }
        int i16 = 1000;
        velocityTracker2.computeCurrentVelocity(1000, Float.MAX_VALUE);
        C3101a0 c3101a3 = (C3101a0) AbstractC3172z.f10662a.get(velocityTracker2);
        if (c3101a3 != null) {
            int i17 = c3101a3.f10572d;
            if (i17 < 2) {
                c3101a0 = c3101a3;
                fSqrt = 0.0f;
            } else {
                int i18 = c3101a3.f10573e;
                int i19 = ((i18 + 20) - (i17 - 1)) % 20;
                long[] jArr2 = c3101a3.f10570b;
                long j11 = jArr2[i18];
                while (true) {
                    j10 = jArr2[i19];
                    if (j11 - j10 <= 100) {
                        break;
                    }
                    c3101a3.f10572d--;
                    i19 = (i19 + 1) % 20;
                }
                int i20 = c3101a3.f10572d;
                if (i20 < 2) {
                    c3101a0 = c3101a3;
                    fSqrt = 0.0f;
                } else {
                    float[] fArr = c3101a3.f10569a;
                    if (i20 == 2) {
                        int i21 = (i19 + 1) % 20;
                        long j12 = jArr2[i21];
                        if (j10 == j12) {
                            c3101a0 = c3101a3;
                            fSqrt = 0.0f;
                        } else {
                            fSqrt = fArr[i21] / (j12 - j10);
                            c3101a0 = c3101a3;
                        }
                    } else {
                        int i22 = 0;
                        int i23 = 0;
                        float fAbs = 0.0f;
                        while (true) {
                            if (i22 >= c3101a3.f10572d - 1) {
                                break;
                            }
                            int i24 = i22 + i19;
                            long j13 = jArr2[i24 % 20];
                            int i25 = (i24 + 1) % 20;
                            if (jArr2[i25] == j13) {
                                c3101a1 = c3101a3;
                                i10 = 1;
                            } else {
                                i23++;
                                float fSqrt2 = (fAbs < f ? -1.0f : 1.0f) * ((float) Math.sqrt(Math.abs(fAbs) * 2.0f));
                                c3101a1 = c3101a3;
                                float f3 = fArr[i25] / (jArr2[i25] - j13);
                                fAbs += Math.abs(f3) * (f3 - fSqrt2);
                                i10 = 1;
                                if (i23 == 1) {
                                    fAbs *= 0.5f;
                                }
                            }
                            i22 += i10;
                            c3101a3 = c3101a1;
                            f = 0.0f;
                        }
                        c3101a0 = c3101a3;
                        fSqrt = (fAbs < 0.0f ? -1.0f : 1.0f) * ((float) Math.sqrt(Math.abs(fAbs) * 2.0f));
                        i16 = 1000;
                    }
                }
            }
            float f4 = fSqrt * i16;
            c3101a0.f10571c = f4;
            if (f4 < (-Math.abs(Float.MAX_VALUE))) {
                c3101a0.f10571c = -Math.abs(Float.MAX_VALUE);
            } else if (c3101a0.f10571c > Math.abs(Float.MAX_VALUE)) {
                c3101a0.f10571c = Math.abs(Float.MAX_VALUE);
            }
        }
        if (Build.VERSION.SDK_INT >= 34) {
            yVelocity = AbstractC3170y.m6365a(velocityTracker2, i6);
        } else if (i6 == 0) {
            yVelocity = velocityTracker2.getXVelocity();
        } else if (i6 == 1) {
            yVelocity = velocityTracker2.getYVelocity();
        } else {
            C3101a0 c3101a4 = (C3101a0) AbstractC3172z.f10662a.get(velocityTracker2);
            yVelocity = (c3101a4 == null || i6 != 26) ? 0.0f : c3101a4.f10571c;
        }
        InterfaceC3124i interfaceC3124i = this.f10603b;
        float fMo96m = interfaceC3124i.mo96m() * yVelocity;
        float fSignum = Math.signum(fMo96m);
        if (z7 || (fSignum != Math.signum(this.f10605d) && fSignum != 0.0f)) {
            interfaceC3124i.mo98o();
        }
        if (Math.abs(fMo96m) < iArr[0]) {
            return;
        }
        int i26 = iArr[1];
        float fMax = Math.max(-i26, Math.min(fMo96m, i26));
        this.f10605d = interfaceC3124i.mo91g(fMax) ? fMax : 0.0f;
    }
}
