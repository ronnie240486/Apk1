package p015b2;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import androidx.fragment.app.AbstractComponentCallbacksC0427s;
import androidx.viewpager.widget.ViewPager;

public abstract class AbstractC1249a {

    public final DataSetObservable f3970a = new DataSetObservable();

    public DataSetObserver f3971b;

    public abstract void mo1283a(AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s);

    public abstract void mo1284b();

    public abstract int mo3131c();

    public final void m3132d() {
        synchronized (this) {
            try {
                DataSetObserver dataSetObserver = this.f3971b;
                if (dataSetObserver != null) {
                    dataSetObserver.onChanged();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f3970a.notifyChanged();
    }

    public abstract void mo1285e(ViewPager viewPager, int i6, AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s);

    public final void m3133f(DataSetObserver dataSetObserver) {
        synchronized (this) {
            this.f3971b = dataSetObserver;
        }
    }

    public abstract void mo1286g(ViewPager viewPager);
}
