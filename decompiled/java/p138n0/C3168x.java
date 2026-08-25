package p138n0;

import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import p103j9.C2788a;
import p115k9.InterfaceC2905a;
import p181q9.C3552j;
import p253x8.AbstractC4147j;
import p253x8.AbstractC4148k;

public final class C3168x implements Iterator, InterfaceC2905a {

    public final int f10656a;

    public Iterator f10657b;

    public final Object f10658c;

    public C3168x(C2788a c2788a) {
        this.f10656a = 0;
        this.f10658c = new ArrayList();
        this.f10657b = c2788a;
    }

    @Override
    public final boolean hasNext() {
        switch (this.f10656a) {
            case 0:
                break;
        }
        return this.f10657b.hasNext();
    }

    @Override
    public final Object next() {
        switch (this.f10656a) {
            case 0:
                Object next = this.f10657b.next();
                View view = (View) next;
                ViewGroup viewGroup = view instanceof ViewGroup ? (ViewGroup) view : null;
                C2788a c2788a = viewGroup != null ? new C2788a(1, viewGroup) : null;
                ArrayList arrayList = (ArrayList) this.f10658c;
                if (c2788a == null || !c2788a.hasNext()) {
                    while (!this.f10657b.hasNext() && !arrayList.isEmpty()) {
                        this.f10657b = (Iterator) AbstractC4147j.m8185Y(arrayList);
                        if (arrayList.isEmpty()) {
                            throw new NoSuchElementException("List is empty.");
                        }
                        arrayList.remove(AbstractC4148k.m8191O(arrayList));
                    }
                } else {
                    arrayList.add(this.f10657b);
                    this.f10657b = c2788a;
                }
                return next;
            default:
                return ((C3552j) this.f10658c).f11955b.invoke(this.f10657b.next());
        }
    }

    @Override
    public final void remove() {
        switch (this.f10656a) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public C3168x(C3552j c3552j) {
        this.f10656a = 1;
        this.f10658c = c3552j;
        this.f10657b = c3552j.f11954a.iterator();
    }
}
