package androidx.core.app;

import android.os.AsyncTask;
import com.alibaba.fastjson.JSONReader;
import com.tencent.mars.xlog.Log;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import org.bitspark.android.beans.ChannelBean;
import org.bitspark.android.utils.AbstractC3331m;
import p000a.RunnableC0005f;
import p003a2.AbstractC0032a;
import p029c7.C1419o;
import p063fa.C2569x0;
import p116ka.ViewOnKeyListenerC2932m0;

public final class AsyncTaskC0330h extends AsyncTask {

    public final int f1500a = 0;

    public final Object f1501b;

    public AsyncTaskC0330h(JobIntentService jobIntentService) {
        this.f1501b = jobIntentService;
    }

    @Override
    public final Object doInBackground(Object[] objArr) {
        InterfaceC0336k interfaceC0336kM986a;
        switch (this.f1500a) {
            case 0:
                while (true) {
                    JobIntentService jobIntentService = (JobIntentService) this.f1501b;
                    JobServiceEngineC0340m jobServiceEngineC0340m = jobIntentService.f1460a;
                    if (jobServiceEngineC0340m != null) {
                        interfaceC0336kM986a = jobServiceEngineC0340m.m986a();
                    } else {
                        synchronized (jobIntentService.f1464e) {
                            try {
                                interfaceC0336kM986a = jobIntentService.f1464e.size() > 0 ? (InterfaceC0336k) jobIntentService.f1464e.remove(0) : null;
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    }
                    if (interfaceC0336kM986a == null) {
                        return null;
                    }
                    JobIntentService jobIntentService2 = (JobIntentService) this.f1501b;
                    interfaceC0336kM986a.getIntent();
                    jobIntentService2.m939b();
                    interfaceC0336kM986a.mo972a();
                }
                break;
            default:
                String str = ((String[]) objArr)[0];
                try {
                    AbstractC0032a.m165s("OGvb1PFtrAcLaP7z+Hy2DBw=\n", "bgS/l5kMwmk=\n");
                    AbstractC0032a.m165s("VbMyxnt9NbFXvQXhMmouqG2eF+l5aTOOdrISoiIn\n", "A9x2ihIOQeE=\n");
                    JSONReader jSONReader = new JSONReader(new StringReader(str));
                    jSONReader.startArray();
                    while (jSONReader.hasNext() && !isCancelled()) {
                        publishProgress((ChannelBean) jSONReader.readObject(ChannelBean.class));
                    }
                    AbstractC0032a.m165s("sT42om1HmoiCPROFZFaAg5U=\n", "51FS4QUm9OY=\n");
                    AbstractC0032a.m165s("bt3uVmV13Eds09lxLGLHXlbwy3lnYdp4TdzOMj0viA==\n", "OLKqGgwGqBc=\n");
                    break;
                } catch (Exception e5) {
                    String strM165s = AbstractC0032a.m165s("Py3T3NyFkEIMLvb71ZSKSRs=\n", "aUK3n7Tk/iw=\n");
                    String string = e5.toString();
                    boolean z7 = AbstractC3331m.f11244b;
                    Log.m5049i(strM165s, string);
                }
                return null;
        }
    }

    @Override
    public void onCancelled(Object obj) {
        switch (this.f1500a) {
            case 0:
                ((JobIntentService) this.f1501b).m940c();
                break;
            default:
                super.onCancelled(obj);
                break;
        }
    }

    @Override
    public final void onPostExecute(Object obj) {
        switch (this.f1500a) {
            case 0:
                ((JobIntentService) this.f1501b).m940c();
                break;
            default:
                super.onPostExecute((List) obj);
                AbstractC0032a.m165s("ipmboZBAOoW5mr6GmVEgjq4=\n", "3Pb/4vghVOs=\n");
                AbstractC0032a.m165s("QrIlJewXJahAvBICpQs/qHuuFSz9ATKNYLhJQKhJfNU55w==\n", "FN1haYVkUfg=\n");
                C2569x0 c2569x0 = (C2569x0) this.f1501b;
                int i6 = c2569x0.f8934l;
                if (i6 == -10 || i6 >= 0) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.addAll(c2569x0.f8932j);
                    C1419o c1419o = ViewOnKeyListenerC2932m0.f9953H0;
                    c1419o.f4320a.put(String.valueOf(c2569x0.f8934l), arrayList);
                }
                break;
        }
    }

    @Override
    public void onProgressUpdate(Object[] objArr) {
        switch (this.f1500a) {
            case 1:
                ChannelBean[] channelBeanArr = (ChannelBean[]) objArr;
                super.onProgressUpdate(channelBeanArr);
                C2569x0 c2569x0 = (C2569x0) this.f1501b;
                c2569x0.f8932j.add(channelBeanArr[0]);
                c2569x0.f8878e.post(new RunnableC0005f(16, this));
                break;
            default:
                super.onProgressUpdate(objArr);
                break;
        }
    }

    public AsyncTaskC0330h(C2569x0 c2569x0) {
        this.f1501b = c2569x0;
    }

    @Override
    public void onCancelled() {
        switch (this.f1500a) {
            case 1:
                super.onCancelled();
                AbstractC0032a.m165s("F1c/l/SwqKQkVBqw/aGyrzM=\n", "QThb1JzRxso=\n");
                AbstractC0032a.m165s("tgJ84F6va8K0DEvHF79+/IMIVIQe\n", "4G04rDfcH5I=\n");
                break;
            default:
                super.onCancelled();
                break;
        }
    }
}
