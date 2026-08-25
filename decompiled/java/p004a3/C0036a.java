package p004a3;

import android.os.Process;

public final class C0036a extends Thread {

    public final int f106a = 0;

    public C0036a(Runnable runnable) {
        super(runnable);
    }

    @Override
    public void run() {
        switch (this.f106a) {
            case 0:
                Process.setThreadPriority(9);
                super.run();
                return;
            case 1:
                Process.setThreadPriority(19);
                synchronized (this) {
                    while (true) {
                        try {
                            wait();
                        } catch (InterruptedException unused) {
                            return;
                        }
                    }
                }
                break;
            default:
                super.run();
                return;
        }
    }

    public C0036a(Runnable runnable, String str) {
        super(runnable, str);
    }

    public C0036a(ThreadGroup threadGroup, String str) {
        super(threadGroup, str);
    }
}
