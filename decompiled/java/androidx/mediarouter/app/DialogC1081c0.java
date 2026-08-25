package androidx.mediarouter.app;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.ContextThemeWrapper;
import android.widget.ImageButton;
import androidx.appcompat.app.AbstractDialogC0139i0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.p2serv.android.p032ds.R;
import java.util.ArrayList;
import java.util.Collections;
import p143n5.AbstractC3198d;
import p156o9.AbstractC3280d;
import p173q1.C3424l0;
import p173q1.C3445s0;
import p173q1.C3451u0;
import p222u7.AbstractC3928d;

public final class DialogC1081c0 extends AbstractDialogC0139i0 {

    public final C3451u0 f3194e;

    public final C1093i0 f3195f;

    public final Context f3196g;

    public C3424l0 f3197h;

    public ArrayList f3198i;

    public C1079b0 f3199j;

    public RecyclerView f3200k;

    public boolean f3201l;

    public C3445s0 f3202m;

    public final long f3203n;

    public long f3204o;

    public final HandlerC1080c f3205p;

    public DialogC1081c0(Context context) {
        ContextThemeWrapper contextThemeWrapperM6589g = AbstractC3280d.m6589g(context, false);
        super(contextThemeWrapperM6589g, AbstractC3280d.m6590h(contextThemeWrapperM6589g));
        this.f3197h = C3424l0.f11567c;
        this.f3205p = new HandlerC1080c(1, this);
        Context context2 = getContext();
        this.f3194e = C3451u0.m7069d(context2);
        this.f3195f = new C1093i0(this, 4);
        this.f3196g = context2;
        this.f3203n = context2.getResources().getInteger(R.integer.mr_update_routes_delay_ms);
    }

    public final void m2740i() {
        if (this.f3202m == null && this.f3201l) {
            this.f3194e.getClass();
            C3451u0.m7067b();
            ArrayList arrayList = new ArrayList(C3451u0.m7068c().f11496i);
            int size = arrayList.size();
            while (true) {
                int i6 = size - 1;
                if (size <= 0) {
                    break;
                }
                C3445s0 c3445s0 = (C3445s0) arrayList.get(i6);
                if (c3445s0.m7021d() || !c3445s0.f11658g || !c3445s0.m7025h(this.f3197h)) {
                    arrayList.remove(i6);
                }
                size = i6;
            }
            Collections.sort(arrayList, C1084e.f3214c);
            long jUptimeMillis = SystemClock.uptimeMillis() - this.f3204o;
            long j10 = this.f3203n;
            if (jUptimeMillis < j10) {
                HandlerC1080c handlerC1080c = this.f3205p;
                handlerC1080c.removeMessages(1);
                handlerC1080c.sendMessageAtTime(handlerC1080c.obtainMessage(1, arrayList), this.f3204o + j10);
            } else {
                this.f3204o = SystemClock.uptimeMillis();
                this.f3198i.clear();
                this.f3198i.addAll(arrayList);
                this.f3199j.m2738a();
            }
        }
    }

    public final void m2741j(C3424l0 c3424l0) {
        if (c3424l0 == null) {
            throw new IllegalArgumentException("selector must not be null");
        }
        if (this.f3197h.equals(c3424l0)) {
            return;
        }
        this.f3197h = c3424l0;
        if (this.f3201l) {
            C3451u0 c3451u0 = this.f3194e;
            C1093i0 c1093i0 = this.f3195f;
            c3451u0.m7075h(c1093i0);
            c3451u0.m7074a(c3424l0, c1093i0, 1);
        }
        m2740i();
    }

    @Override
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f3201l = true;
        this.f3194e.m7074a(this.f3197h, this.f3195f, 1);
        m2740i();
    }

    @Override
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.mr_picker_dialog);
        Context context = this.f3196g;
        getWindow().getDecorView().setBackgroundColor(AbstractC3928d.m7847i(context, AbstractC3280d.m6602t(context) ? R.color.mr_dynamic_dialog_background_light : R.color.mr_dynamic_dialog_background_dark));
        this.f3198i = new ArrayList();
        ((ImageButton) findViewById(R.id.mr_picker_close_button)).setOnClickListener(new ViewOnClickListenerC1089g0(2, this));
        this.f3199j = new C1079b0(this);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.mr_picker_list);
        this.f3200k = recyclerView;
        recyclerView.setAdapter(this.f3199j);
        this.f3200k.setLayoutManager(new LinearLayoutManager(1));
        Context context2 = this.f3196g;
        getWindow().setLayout(!context2.getResources().getBoolean(R.bool.is_tablet) ? -1 : AbstractC3198d.m6473v(context2), context2.getResources().getBoolean(R.bool.is_tablet) ? -2 : -1);
    }

    @Override
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f3201l = false;
        this.f3194e.m7075h(this.f3195f);
        this.f3205p.removeMessages(1);
    }
}
