package p186r3;

import java.util.concurrent.Executor;

public final class ExecutorC3601e implements Executor {

    public final int f12097a;

    @Override
    public final void execute(Runnable runnable) {
        switch (this.f12097a) {
            case 0:
                AbstractC3610n.m7238f().post(runnable);
                break;
            default:
                runnable.run();
                break;
        }
    }
}
