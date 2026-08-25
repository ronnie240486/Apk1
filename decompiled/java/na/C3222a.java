package na;

import android.view.View;
import androidx.appcompat.widget.RunnableC0261r0;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.bitspark.android.keyboard.custom.MyKeyBoardView;

public final class C3222a {

    public final MyKeyBoardView f10824a;

    public C3222a(MyKeyBoardView myKeyBoardView) {
        this.f10824a = myKeyBoardView;
    }

    public void m6507a(View view, int i6, boolean z7) {
        MyKeyBoardView myKeyBoardView = this.f10824a;
        if (z7) {
            ScheduledExecutorService scheduledExecutorServiceNewSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
            myKeyBoardView.f11198m = scheduledExecutorServiceNewSingleThreadScheduledExecutor;
            scheduledExecutorServiceNewSingleThreadScheduledExecutor.scheduleWithFixedDelay(new RunnableC0261r0(this, i6, view, 9), 0L, 50L, TimeUnit.MILLISECONDS);
        } else {
            ScheduledExecutorService scheduledExecutorService = myKeyBoardView.f11198m;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.shutdownNow();
                myKeyBoardView.f11198m = null;
            }
        }
    }
}
