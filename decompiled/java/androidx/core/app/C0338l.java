package androidx.core.app;

import android.app.job.JobParameters;
import android.app.job.JobWorkItem;
import android.content.Intent;

public final class C0338l implements InterfaceC0336k {

    public final JobWorkItem f1519a;

    public final JobServiceEngineC0340m f1520b;

    public C0338l(JobServiceEngineC0340m jobServiceEngineC0340m, JobWorkItem jobWorkItem) {
        this.f1520b = jobServiceEngineC0340m;
        this.f1519a = jobWorkItem;
    }

    @Override
    public final void mo972a() {
        synchronized (this.f1520b.f1522b) {
            try {
                JobParameters jobParameters = this.f1520b.f1523c;
                if (jobParameters != null) {
                    jobParameters.completeWork(this.f1519a);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override
    public final Intent getIntent() {
        return this.f1519a.getIntent();
    }
}
