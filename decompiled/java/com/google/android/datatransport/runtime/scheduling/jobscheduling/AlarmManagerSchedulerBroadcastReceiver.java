package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import com.lzy.okgo.model.Progress;
import p002a1.C0026b;
import p005a4.C0051j;
import p005a4.C0061t;
import p077h4.C2659i;
import p077h4.RunnableC2651a;
import p077h4.RunnableC2656f;
import p122l4.AbstractC2972a;

public class AlarmManagerSchedulerBroadcastReceiver extends BroadcastReceiver {

    public static final int f4536a = 0;

    @Override
    public final void onReceive(Context context, Intent intent) {
        String queryParameter = intent.getData().getQueryParameter("backendName");
        String queryParameter2 = intent.getData().getQueryParameter("extras");
        int iIntValue = Integer.valueOf(intent.getData().getQueryParameter(Progress.PRIORITY)).intValue();
        int i6 = intent.getExtras().getInt("attemptNumber");
        C0061t.m207b(context);
        C0026b c0026bM203a = C0051j.m203a();
        c0026bM203a.m121G(queryParameter);
        c0026bM203a.f56d = AbstractC2972a.m6009b(iIntValue);
        if (queryParameter2 != null) {
            c0026bM203a.f55c = Base64.decode(queryParameter2, 0);
        }
        C2659i c2659i = C0061t.m206a().f174d;
        C0051j c0051jM130h = c0026bM203a.m130h();
        RunnableC2651a runnableC2651a = new RunnableC2651a();
        c2659i.getClass();
        c2659i.f9281e.execute(new RunnableC2656f(c2659i, c0051jM130h, i6, runnableC2651a));
    }
}
