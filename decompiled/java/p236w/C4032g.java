package p236w;

import java.util.ArrayList;
import java.util.Iterator;

public class C4032g implements InterfaceC4030e {

    public final AbstractC4039n f13666d;

    public int f13668f;

    public int f13669g;

    public AbstractC4039n f13663a = null;

    public boolean f13664b = false;

    public boolean f13665c = false;

    public int f13667e = 1;

    public int f13670h = 1;

    public C4033h f13671i = null;

    public boolean f13672j = false;

    public final ArrayList f13673k = new ArrayList();

    public final ArrayList f13674l = new ArrayList();

    public C4032g(AbstractC4039n abstractC4039n) {
        this.f13666d = abstractC4039n;
    }

    @Override
    public final void mo8013a(InterfaceC4030e interfaceC4030e) {
        ArrayList<C4032g> arrayList = this.f13674l;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (!((C4032g) it.next()).f13672j) {
                return;
            }
        }
        this.f13665c = true;
        AbstractC4039n abstractC4039n = this.f13663a;
        if (abstractC4039n != null) {
            abstractC4039n.mo8013a(this);
        }
        if (this.f13664b) {
            this.f13666d.mo8013a(this);
            return;
        }
        C4032g c4032g = null;
        int i6 = 0;
        for (C4032g c4032g2 : arrayList) {
            if (!(c4032g2 instanceof C4033h)) {
                i6++;
                c4032g = c4032g2;
            }
        }
        if (c4032g != null && i6 == 1 && c4032g.f13672j) {
            C4033h c4033h = this.f13671i;
            if (c4033h != null) {
                if (!c4033h.f13672j) {
                    return;
                } else {
                    this.f13668f = this.f13670h * c4033h.f13669g;
                }
            }
            mo8030d(c4032g.f13669g + this.f13668f);
        }
        AbstractC4039n abstractC4039n2 = this.f13663a;
        if (abstractC4039n2 != null) {
            abstractC4039n2.mo8013a(this);
        }
    }

    public final void m8028b(AbstractC4039n abstractC4039n) {
        this.f13673k.add(abstractC4039n);
        if (this.f13672j) {
            abstractC4039n.mo8013a(abstractC4039n);
        }
    }

    public final void m8029c() {
        this.f13674l.clear();
        this.f13673k.clear();
        this.f13672j = false;
        this.f13669g = 0;
        this.f13665c = false;
        this.f13664b = false;
    }

    public void mo8030d(int i6) {
        if (this.f13672j) {
            return;
        }
        this.f13672j = true;
        this.f13669g = i6;
        for (InterfaceC4030e interfaceC4030e : this.f13673k) {
            interfaceC4030e.mo8013a(interfaceC4030e);
        }
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f13666d.f13682b.f13348Y);
        sb.append(":");
        switch (this.f13667e) {
            case 1:
                str = "UNKNOWN";
                break;
            case 2:
                str = "HORIZONTAL_DIMENSION";
                break;
            case 3:
                str = "VERTICAL_DIMENSION";
                break;
            case 4:
                str = "LEFT";
                break;
            case 5:
                str = "RIGHT";
                break;
            case 6:
                str = "TOP";
                break;
            case 7:
                str = "BOTTOM";
                break;
            case 8:
                str = "BASELINE";
                break;
            default:
                str = "null";
                break;
        }
        sb.append(str);
        sb.append("(");
        sb.append(this.f13672j ? Integer.valueOf(this.f13669g) : "unresolved");
        sb.append(") <t=");
        sb.append(this.f13674l.size());
        sb.append(":d=");
        sb.append(this.f13673k.size());
        sb.append(">");
        return sb.toString();
    }
}
