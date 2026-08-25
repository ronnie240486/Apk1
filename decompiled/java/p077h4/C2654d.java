package p077h4;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.PersistableBundle;
import android.util.Base64;
import android.util.Log;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService;
import com.lzy.okgo.model.Progress;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Set;
import java.util.zip.Adler32;
import p005a4.C0051j;
import p087i4.C2702g;
import p087i4.InterfaceC2699d;
import p122l4.AbstractC2972a;
import p156o9.AbstractC3280d;
import p248x3.EnumC4107c;

public final class C2654d {

    public final Context f9259a;

    public final InterfaceC2699d f9260b;

    public final C2652b f9261c;

    public C2654d(Context context, InterfaceC2699d interfaceC2699d, C2652b c2652b) {
        this.f9259a = context;
        this.f9260b = interfaceC2699d;
        this.f9261c = c2652b;
    }

    public final void m5668a(C0051j c0051j, int i6, boolean z7) {
        Context context = this.f9259a;
        ComponentName componentName = new ComponentName(context, (Class<?>) JobInfoSchedulerService.class);
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        Adler32 adler32 = new Adler32();
        adler32.update(context.getPackageName().getBytes(Charset.forName("UTF-8")));
        adler32.update(c0051j.f151a.getBytes(Charset.forName("UTF-8")));
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
        EnumC4107c enumC4107c = c0051j.f153c;
        adler32.update(byteBufferAllocate.putInt(AbstractC2972a.m6008a(enumC4107c)).array());
        byte[] bArr = c0051j.f152b;
        if (bArr != null) {
            adler32.update(bArr);
        }
        int value = (int) adler32.getValue();
        if (!z7) {
            for (JobInfo jobInfo : jobScheduler.getAllPendingJobs()) {
                int i10 = jobInfo.getExtras().getInt("attemptNumber");
                if (jobInfo.getId() == value) {
                    if (i10 < i6) {
                        break;
                    }
                    AbstractC3280d.m6591i("JobInfoScheduler", "Upload for context %s is already scheduled. Returning...", c0051j);
                    return;
                }
            }
        }
        SQLiteDatabase sQLiteDatabaseM5697a = ((C2702g) this.f9260b).m5697a();
        String strValueOf = String.valueOf(AbstractC2972a.m6008a(enumC4107c));
        String str = c0051j.f151a;
        Cursor cursorRawQuery = sQLiteDatabaseM5697a.rawQuery("SELECT next_request_ms FROM transport_contexts WHERE backend_name = ? and priority = ?", new String[]{str, strValueOf});
        try {
            Long lValueOf = cursorRawQuery.moveToNext() ? Long.valueOf(cursorRawQuery.getLong(0)) : 0L;
            cursorRawQuery.close();
            long jLongValue = lValueOf.longValue();
            JobInfo.Builder builder = new JobInfo.Builder(value, componentName);
            C2652b c2652b = this.f9261c;
            Long l9 = lValueOf;
            builder.setMinimumLatency(c2652b.m5667a(enumC4107c, jLongValue, i6));
            Set set = ((C2653c) c2652b.f9255b.get(enumC4107c)).f9258c;
            if (set.contains(EnumC2655e.f9262a)) {
                builder.setRequiredNetworkType(2);
            } else {
                builder.setRequiredNetworkType(1);
            }
            if (set.contains(EnumC2655e.f9264c)) {
                builder.setRequiresCharging(true);
            }
            if (set.contains(EnumC2655e.f9263b)) {
                builder.setRequiresDeviceIdle(true);
            }
            PersistableBundle persistableBundle = new PersistableBundle();
            persistableBundle.putInt("attemptNumber", i6);
            persistableBundle.putString("backendName", str);
            persistableBundle.putInt(Progress.PRIORITY, AbstractC2972a.m6008a(enumC4107c));
            if (bArr != null) {
                persistableBundle.putString("extras", Base64.encodeToString(bArr, 0));
            }
            builder.setExtras(persistableBundle);
            Log.d("TransportRuntime.".concat("JobInfoScheduler"), String.format("Scheduling upload for context %s with jobId=%d in %dms(Backend next call timestamp %d). Attempt %d", c0051j, Integer.valueOf(value), Long.valueOf(c2652b.m5667a(enumC4107c, jLongValue, i6)), l9, Integer.valueOf(i6)));
            jobScheduler.schedule(builder.build());
        } catch (Throwable th) {
            cursorRawQuery.close();
            throw th;
        }
    }
}
