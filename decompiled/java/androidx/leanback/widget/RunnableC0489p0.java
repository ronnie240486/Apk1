package androidx.leanback.widget;

import android.os.SystemClock;
import android.view.MotionEvent;

public final class RunnableC0489p0 implements Runnable {

    public final int f2386a;

    public final SearchBar f2387b;

    public RunnableC0489p0(SearchBar searchBar, int i6) {
        this.f2386a = i6;
        this.f2387b = searchBar;
    }

    @Override
    public final void run() {
        switch (this.f2386a) {
            case 0:
                SearchBar searchBar = this.f2387b;
                searchBar.setSearchQueryInternal(searchBar.f2224a.getText().toString());
                break;
            default:
                SearchBar searchBar2 = this.f2387b;
                searchBar2.f2224a.requestFocusFromTouch();
                searchBar2.f2224a.dispatchTouchEvent(MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 0, searchBar2.f2224a.getWidth(), searchBar2.f2224a.getHeight(), 0));
                searchBar2.f2224a.dispatchTouchEvent(MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 1, searchBar2.f2224a.getWidth(), searchBar2.f2224a.getHeight(), 0));
                break;
        }
    }
}
