package p106k0;

import android.os.Process;

public final class C2860h extends Thread {

    public final int f9787a;

    public C2860h(Runnable runnable) {
        super(runnable, "fonts-androidx");
        this.f9787a = 10;
    }

    @Override
    public final void run() {
        Process.setThreadPriority(this.f9787a);
        super.run();
    }
}
