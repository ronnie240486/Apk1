package com.google.android.gms.internal.cast;

import com.google.android.gms.cast.ApplicationMetadata;
import java.util.HashSet;
import java.util.Iterator;
import p176q4.C3475c;

public final class C1602k0 {

    public final int f5379a;

    public final Object f5380b;

    public C1602k0(int i6, Object obj) {
        this.f5379a = i6;
        this.f5380b = obj;
    }

    public void m3904a(int i6) {
        switch (this.f5379a) {
            case 1:
                Iterator it = new HashSet(((C3475c) this.f5380b).f11757d).iterator();
                while (it.hasNext()) {
                    ((C1602k0) it.next()).m3904a(i6);
                }
                break;
        }
    }

    public void m3906c(int i6) {
        switch (this.f5379a) {
            case 1:
                C3475c c3475c = (C3475c) this.f5380b;
                C3475c.m7122h(c3475c, i6);
                c3475c.m7137b(i6);
                Iterator it = new HashSet(c3475c.f11757d).iterator();
                while (it.hasNext()) {
                    ((C1602k0) it.next()).m3906c(i6);
                }
                break;
        }
    }

    public void m3908e(ApplicationMetadata applicationMetadata) {
        switch (this.f5379a) {
            case 1:
                Iterator it = new HashSet(((C3475c) this.f5380b).f11757d).iterator();
                while (it.hasNext()) {
                    ((C1602k0) it.next()).m3908e(applicationMetadata);
                }
                break;
        }
    }

    public void m3910g() {
        switch (this.f5379a) {
            case 1:
                Iterator it = new HashSet(((C3475c) this.f5380b).f11757d).iterator();
                while (it.hasNext()) {
                    ((C1602k0) it.next()).m3910g();
                }
                break;
        }
    }

    public void m3913j(int i6) {
        switch (this.f5379a) {
            case 1:
                Iterator it = new HashSet(((C3475c) this.f5380b).f11757d).iterator();
                while (it.hasNext()) {
                    ((C1602k0) it.next()).m3913j(i6);
                }
                break;
        }
    }

    public void m3915l() {
        switch (this.f5379a) {
            case 0:
                ((C1592j0) this.f5380b).m3872f();
                break;
            case 1:
                Iterator it = new HashSet(((C3475c) this.f5380b).f11757d).iterator();
                while (it.hasNext()) {
                    ((C1602k0) it.next()).m3915l();
                }
                break;
        }
    }

    public final void m3911h() {
    }

    public final void m3912i() {
    }

    public final void m3916m() {
    }

    public final void m3905b(int i6) {
    }

    public final void m3907d(int i6) {
    }

    public final void m3909f(ApplicationMetadata applicationMetadata) {
    }

    public final void m3914k(int i6) {
    }
}
