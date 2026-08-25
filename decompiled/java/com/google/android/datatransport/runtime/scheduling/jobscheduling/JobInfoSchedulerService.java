package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Base64;
import androidx.appcompat.app.RunnableC0147m0;
import com.lzy.okgo.model.Progress;
import p002a1.C0026b;
import p005a4.C0051j;
import p005a4.C0061t;
import p077h4.C2659i;
import p077h4.RunnableC2656f;
import p122l4.AbstractC2972a;

public class JobInfoSchedulerService extends JobService {

    public static final int f4537a = 0;

    @Override
    public final boolean onStartJob(JobParameters jobParameters) {
        String string = jobParameters.getExtras().getString("backendName");
        String string2 = jobParameters.getExtras().getString("extras");
        int i6 = jobParameters.getExtras().getInt(Progress.PRIORITY);
        int i10 = jobParameters.getExtras().getInt("attemptNumber");
        C0061t.m207b(getApplicationContext());
        C0026b c0026bM203a = C0051j.m203a();
        c0026bM203a.m121G(string);
        c0026bM203a.f56d = AbstractC2972a.m6009b(i6);
        if (string2 != null) {
            c0026bM203a.f55c = Base64.decode(string2, 0);
        }
        C2659i c2659i = C0061t.m206a().f174d;
        C0051j c0051jM130h = c0026bM203a.m130h();
        RunnableC0147m0 runnableC0147m0 = new RunnableC0147m0(this, 13, jobParameters);
        c2659i.getClass();
        c2659i.f9281e.execute(new RunnableC2656f(c2659i, c0051jM130h, i10, runnableC0147m0));
        return true;
    }

    @Override
    public final boolean onStopJob(JobParameters jobParameters) {
        return true;
    }
}
