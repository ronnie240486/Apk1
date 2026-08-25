package p102j8;

import com.bumptech.glide.AbstractC1466d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import p114k8.C2902b;
import p160p.C3343g;
import p180q8.RunnableC3538m;
import p191r8.AbstractC3642a;

public final class C2786a implements InterfaceC2787b {

    public final int f9517a;

    public volatile boolean f9518b;

    public Object f9519c;

    public C2786a(int i6) {
        this.f9517a = i6;
    }

    private final boolean m5770c(InterfaceC2787b interfaceC2787b) {
        if (!this.f9518b) {
            synchronized (this) {
                try {
                    if (!this.f9518b) {
                        C3343g c3343g = (C3343g) this.f9519c;
                        if (c3343g == null) {
                            c3343g = new C3343g();
                            int iNumberOfLeadingZeros = 1 << (32 - Integer.numberOfLeadingZeros(15));
                            c3343g.f11318a = iNumberOfLeadingZeros - 1;
                            c3343g.f11320c = (int) (0.75f * iNumberOfLeadingZeros);
                            c3343g.f11321d = new Object[iNumberOfLeadingZeros];
                            this.f9519c = c3343g;
                        }
                        c3343g.m6785a(interfaceC2787b);
                        return true;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        interfaceC2787b.mo5675a();
        return false;
    }

    private final boolean m5771f(InterfaceC2787b interfaceC2787b) {
        Object obj;
        if (this.f9518b) {
            return false;
        }
        synchronized (this) {
            try {
                if (this.f9518b) {
                    return false;
                }
                C3343g c3343g = (C3343g) this.f9519c;
                if (c3343g != null) {
                    Object[] objArr = c3343g.f11321d;
                    int i6 = c3343g.f11318a;
                    int iHashCode = interfaceC2787b.hashCode() * (-1640531527);
                    int i10 = (iHashCode ^ (iHashCode >>> 16)) & i6;
                    Object obj2 = objArr[i10];
                    if (obj2 != null) {
                        if (obj2.equals(interfaceC2787b)) {
                            c3343g.m6787c(objArr, i10, i6);
                        } else {
                            do {
                                i10 = (i10 + 1) & i6;
                                obj = objArr[i10];
                                if (obj == null) {
                                }
                            } while (!obj.equals(interfaceC2787b));
                            c3343g.m6787c(objArr, i10, i6);
                        }
                        return true;
                    }
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void m5772g() {
        if (this.f9518b) {
            return;
        }
        synchronized (this) {
            try {
                if (this.f9518b) {
                    return;
                }
                this.f9518b = true;
                C3343g c3343g = (C3343g) this.f9519c;
                ArrayList arrayList = null;
                this.f9519c = null;
                if (c3343g == null) {
                    return;
                }
                for (Object obj : c3343g.f11321d) {
                    if (obj instanceof InterfaceC2787b) {
                        try {
                            ((InterfaceC2787b) obj).mo5675a();
                        } catch (Throwable th) {
                            AbstractC1466d.m3484G(th);
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                            }
                            arrayList.add(th);
                        }
                    }
                }
                if (arrayList != null) {
                    if (arrayList.size() != 1) {
                        throw new C2902b(arrayList);
                    }
                    throw AbstractC3642a.m7373b((Throwable) arrayList.get(0));
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override
    public final void mo5675a() {
        switch (this.f9517a) {
            case 0:
                m5772g();
                return;
            default:
                if (this.f9518b) {
                    return;
                }
                synchronized (this) {
                    try {
                        if (!this.f9518b) {
                            this.f9518b = true;
                            LinkedList linkedList = (LinkedList) this.f9519c;
                            ArrayList arrayList = null;
                            this.f9519c = null;
                            if (linkedList != null) {
                                Iterator it = linkedList.iterator();
                                while (it.hasNext()) {
                                    try {
                                        ((InterfaceC2787b) it.next()).mo5675a();
                                    } catch (Throwable th) {
                                        AbstractC1466d.m3484G(th);
                                        if (arrayList == null) {
                                            arrayList = new ArrayList();
                                        }
                                        arrayList.add(th);
                                    }
                                }
                                if (arrayList != null) {
                                    if (arrayList.size() != 1) {
                                        throw new C2902b(arrayList);
                                    }
                                    throw AbstractC3642a.m7373b((Throwable) arrayList.get(0));
                                }
                            }
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                return;
        }
    }

    public final boolean m5773b(InterfaceC2787b interfaceC2787b) {
        switch (this.f9517a) {
            case 0:
                return m5770c(interfaceC2787b);
            default:
                if (!this.f9518b) {
                    synchronized (this) {
                        try {
                            if (!this.f9518b) {
                                LinkedList linkedList = (LinkedList) this.f9519c;
                                if (linkedList == null) {
                                    linkedList = new LinkedList();
                                    this.f9519c = linkedList;
                                }
                                linkedList.add(interfaceC2787b);
                                return true;
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
                interfaceC2787b.mo5675a();
                return false;
        }
    }

    public final boolean m5774d(InterfaceC2787b interfaceC2787b) {
        switch (this.f9517a) {
            case 0:
                return m5771f(interfaceC2787b);
            default:
                boolean z7 = false;
                if (!this.f9518b) {
                    synchronized (this) {
                        try {
                            if (!this.f9518b) {
                                LinkedList linkedList = (LinkedList) this.f9519c;
                                if (linkedList != null && linkedList.remove(interfaceC2787b)) {
                                    z7 = true;
                                }
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    break;
                }
                return z7;
        }
    }

    public final boolean m5775h(InterfaceC2787b interfaceC2787b) {
        switch (this.f9517a) {
            case 0:
                if (!m5774d(interfaceC2787b)) {
                    return false;
                }
                interfaceC2787b.mo5675a();
                return true;
            default:
                if (!m5774d(interfaceC2787b)) {
                    return false;
                }
                ((RunnableC3538m) interfaceC2787b).mo5675a();
                return true;
        }
    }
}
