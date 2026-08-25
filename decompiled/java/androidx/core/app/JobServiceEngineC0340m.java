package androidx.core.app;

import android.app.job.JobParameters;
import android.app.job.JobServiceEngine;
import android.app.job.JobWorkItem;

public final class JobServiceEngineC0340m extends JobServiceEngine {

    public final JobIntentService f1521a;

    public final Object f1522b;

    public JobParameters f1523c;

    public JobServiceEngineC0340m(JobIntentService jobIntentService) {
        super(jobIntentService);
        this.f1522b = new Object();
        this.f1521a = jobIntentService;
    }

    public final C0338l m986a() {
        synchronized (this.f1522b) {
            try {
                JobParameters jobParameters = this.f1523c;
                if (jobParameters == null) {
                    return null;
                }
                JobWorkItem jobWorkItemDequeueWork = jobParameters.dequeueWork();
                if (jobWorkItemDequeueWork == null) {
                    return null;
                }
                jobWorkItemDequeueWork.getIntent().setExtrasClassLoader(this.f1521a.getClassLoader());
                return new C0338l(this, jobWorkItemDequeueWork);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override
    public final boolean onStartJob(JobParameters jobParameters) {
        this.f1523c = jobParameters;
        this.f1521a.m938a(false);
        return true;
    }

    @Override
    public final boolean onStopJob(JobParameters jobParameters) {
        AsyncTaskC0330h asyncTaskC0330h = this.f1521a.f1462c;
        if (asyncTaskC0330h != null) {
            asyncTaskC0330h.cancel(false);
        }
        synchronized (this.f1522b) {
            this.f1523c = null;
        }
        return true;
    }
}
