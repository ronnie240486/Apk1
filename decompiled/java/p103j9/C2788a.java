package p103j9;

import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;
import java.util.NoSuchElementException;
import p115k9.InterfaceC2905a;
import p181q9.C3544b;
import p253x8.AbstractC4142e;

public class C2788a implements Iterator, InterfaceC2905a {

    public final int f9520a;

    public int f9521b;

    public final Object f9522c;

    public C2788a(int i6, Object obj) {
        this.f9520a = i6;
        this.f9522c = obj;
    }

    @Override
    public final boolean hasNext() {
        Iterator it;
        switch (this.f9520a) {
            case 0:
                return this.f9521b < ((Object[]) this.f9522c).length;
            case 1:
                return this.f9521b < ((ViewGroup) this.f9522c).getChildCount();
            case 2:
                break;
            default:
                return this.f9521b < ((AbstractC4142e) this.f9522c).size();
        }
        while (true) {
            int i6 = this.f9521b;
            it = (Iterator) this.f9522c;
            if (i6 > 0 && it.hasNext()) {
                it.next();
                this.f9521b--;
            }
        }
        return it.hasNext();
    }

    @Override
    public final Object next() {
        Iterator it;
        switch (this.f9520a) {
            case 0:
                try {
                    Object[] objArr = (Object[]) this.f9522c;
                    int i6 = this.f9521b;
                    this.f9521b = i6 + 1;
                    return objArr[i6];
                } catch (ArrayIndexOutOfBoundsException e5) {
                    this.f9521b--;
                    throw new NoSuchElementException(e5.getMessage());
                }
            case 1:
                int i10 = this.f9521b;
                this.f9521b = i10 + 1;
                View childAt = ((ViewGroup) this.f9522c).getChildAt(i10);
                if (childAt != null) {
                    return childAt;
                }
                throw new IndexOutOfBoundsException();
            case 2:
                break;
            default:
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                int i11 = this.f9521b;
                this.f9521b = i11 + 1;
                return ((AbstractC4142e) this.f9522c).get(i11);
        }
        while (true) {
            int i12 = this.f9521b;
            it = (Iterator) this.f9522c;
            if (i12 > 0 && it.hasNext()) {
                it.next();
                this.f9521b--;
            }
        }
        return it.next();
    }

    @Override
    public final void remove() {
        switch (this.f9520a) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            case 1:
                int i6 = this.f9521b - 1;
                this.f9521b = i6;
                ((ViewGroup) this.f9522c).removeViewAt(i6);
                return;
            case 2:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public C2788a(Object[] objArr) {
        this.f9520a = 0;
        AbstractC2796i.m5785f(objArr, "array");
        this.f9522c = objArr;
    }

    public C2788a(C3544b c3544b) {
        this.f9520a = 2;
        this.f9522c = c3544b.f11945a.iterator();
        this.f9521b = c3544b.f11946b;
    }
}
