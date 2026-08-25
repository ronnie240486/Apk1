package p210t4;

import android.view.View;
import com.google.android.gms.cast.framework.media.widget.ExpandedControllerActivity;
import com.google.android.gms.internal.cast.C1670r2;
import com.google.android.gms.internal.cast.EnumC1679s2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import p018b5.AbstractC1312l;
import p176q4.AbstractC3481g;
import p176q4.C3473b;
import p176q4.C3475c;
import p176q4.C3482h;
import p176q4.InterfaceC3483i;
import p187r4.C3616f;
import p187r4.C3626p;
import p187r4.InterfaceC3614d;
import p219u4.C3897e;
import p230v4.C3988b;

public final class C3809b implements InterfaceC3614d, InterfaceC3483i {

    public static final C3988b f12850h = new C3988b("UIMediaController", null);

    public final ExpandedControllerActivity f12851a;

    public final C3482h f12852b;

    public final HashMap f12853c = new HashMap();

    public final HashSet f12854d = new HashSet();

    public final C3626p f12855e = new C3626p();

    public C3897e f12856f;

    public C3616f f12857g;

    public C3809b(ExpandedControllerActivity expandedControllerActivity) {
        this.f12851a = expandedControllerActivity;
        C3473b c3473bM7100c = C3473b.m7100c(expandedControllerActivity);
        C1670r2.m3989a(EnumC1679s2.UI_MEDIA_CONTROLLER);
        C3482h c3482hM7102a = c3473bM7100c != null ? c3473bM7100c.m7102a() : null;
        this.f12852b = c3482hM7102a;
        if (c3482hM7102a != null) {
            c3482hM7102a.m7140a(this);
            m7587r(c3482hM7102a.m7142c());
        }
    }

    @Override
    public final void mo3717a(AbstractC3481g abstractC3481g, int i6) {
        m7586q();
    }

    @Override
    public final void mo7283b() {
        m7589t();
        C3897e c3897e = this.f12856f;
        if (c3897e != null) {
            c3897e.mo7283b();
        }
    }

    @Override
    public final void mo7284c() {
        m7589t();
    }

    @Override
    public final void mo3718d(AbstractC3481g abstractC3481g, boolean z7) {
        m7587r((C3475c) abstractC3481g);
    }

    @Override
    public final void mo7285e() {
        m7589t();
        C3897e c3897e = this.f12856f;
        if (c3897e != null) {
            c3897e.mo7285e();
        }
    }

    @Override
    public final void mo7286f() {
        Iterator it = this.f12853c.values().iterator();
        while (it.hasNext()) {
            Iterator it2 = ((List) it.next()).iterator();
            while (it2.hasNext()) {
                ((AbstractC3808a) it2.next()).mo3833c();
            }
        }
        C3897e c3897e = this.f12856f;
        if (c3897e != null) {
            c3897e.mo7286f();
        }
    }

    @Override
    public final void mo3719g(AbstractC3481g abstractC3481g, int i6) {
    }

    @Override
    public final void mo3720h(AbstractC3481g abstractC3481g, String str) {
        m7587r((C3475c) abstractC3481g);
    }

    @Override
    public final void mo3721i(AbstractC3481g abstractC3481g, int i6) {
        m7586q();
    }

    @Override
    public final void mo7287j() {
        m7589t();
        C3897e c3897e = this.f12856f;
        if (c3897e != null) {
            c3897e.mo7287j();
        }
    }

    @Override
    public final void mo3722k(AbstractC3481g abstractC3481g, String str) {
    }

    @Override
    public final void mo3723l(AbstractC3481g abstractC3481g) {
    }

    @Override
    public final void mo3724m(AbstractC3481g abstractC3481g, int i6) {
        m7586q();
    }

    @Override
    public final void mo3725n(AbstractC3481g abstractC3481g) {
    }

    @Override
    public final void mo7288o() {
        m7589t();
    }

    public final C3616f m7585p() {
        AbstractC1312l.m3195b("Must be called from the main thread.");
        return this.f12857g;
    }

    public final void m7586q() {
        AbstractC1312l.m3195b("Must be called from the main thread.");
        if (this.f12857g != null) {
            this.f12855e.f12186a = null;
            Iterator it = this.f12853c.values().iterator();
            while (it.hasNext()) {
                Iterator it2 = ((List) it.next()).iterator();
                while (it2.hasNext()) {
                    ((AbstractC3808a) it2.next()).mo3835e();
                }
            }
            AbstractC1312l.m3198e(this.f12857g);
            C3616f c3616f = this.f12857g;
            c3616f.getClass();
            AbstractC1312l.m3195b("Must be called from the main thread.");
            c3616f.f12154g.remove(this);
            this.f12857g = null;
        }
    }

    public final void m7587r(AbstractC3481g abstractC3481g) {
        AbstractC1312l.m3195b("Must be called from the main thread.");
        if (this.f12857g == null && abstractC3481g != null && abstractC3481g.m7136a()) {
            C3475c c3475c = (C3475c) abstractC3481g;
            C3616f c3616fM7125f = c3475c.m7125f();
            this.f12857g = c3616fM7125f;
            if (c3616fM7125f != null) {
                AbstractC1312l.m3195b("Must be called from the main thread.");
                c3616fM7125f.f12154g.add(this);
                C3626p c3626p = this.f12855e;
                AbstractC1312l.m3198e(c3626p);
                c3626p.f12186a = c3475c.m7125f();
                Iterator it = this.f12853c.values().iterator();
                while (it.hasNext()) {
                    Iterator it2 = ((List) it.next()).iterator();
                    while (it2.hasNext()) {
                        ((AbstractC3808a) it2.next()).mo3834d(c3475c);
                    }
                }
                m7589t();
            }
        }
    }

    public final void m7588s(View view, AbstractC3808a abstractC3808a) {
        C3482h c3482h = this.f12852b;
        if (c3482h == null) {
            return;
        }
        HashMap map = this.f12853c;
        List arrayList = (List) map.get(view);
        if (arrayList == null) {
            arrayList = new ArrayList();
            map.put(view, arrayList);
        }
        arrayList.add(abstractC3808a);
        AbstractC1312l.m3195b("Must be called from the main thread.");
        if (this.f12857g != null) {
            C3475c c3475cM7142c = c3482h.m7142c();
            AbstractC1312l.m3198e(c3475cM7142c);
            abstractC3808a.mo3834d(c3475cM7142c);
            m7589t();
        }
    }

    public final void m7589t() {
        Iterator it = this.f12853c.values().iterator();
        while (it.hasNext()) {
            Iterator it2 = ((List) it.next()).iterator();
            while (it2.hasNext()) {
                ((AbstractC3808a) it2.next()).mo3832b();
            }
        }
    }
}
