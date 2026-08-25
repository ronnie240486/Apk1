package androidx.mediarouter.app;

import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.method.LinkMovementMethod;
import android.view.ContextThemeWrapper;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AbstractDialogC0139i0;
import androidx.appcompat.app.C0125b0;
import com.p2serv.android.p032ds.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import p123l5.AbstractC2973a;
import p143n5.AbstractC3198d;
import p156o9.AbstractC3280d;
import p173q1.C3424l0;
import p173q1.C3445s0;
import p173q1.C3451u0;

public final class DialogC1086f extends AbstractDialogC0139i0 {

    public final C3451u0 f3221e;

    public final C1093i0 f3222f;

    public C3424l0 f3223g;

    public ArrayList f3224h;

    public TextView f3225i;

    public TextView f3226j;

    public RelativeLayout f3227k;

    public TextView f3228l;

    public TextView f3229m;

    public LinearLayout f3230n;

    public Button f3231o;

    public ProgressBar f3232p;

    public ListView f3233q;

    public C1082d f3234r;

    public final C0125b0 f3235s;

    public boolean f3236t;

    public long f3237u;

    public final HandlerC1080c f3238v;

    public DialogC1086f(Context context) {
        ContextThemeWrapper contextThemeWrapperM6589g = AbstractC3280d.m6589g(context, false);
        super(contextThemeWrapperM6589g, AbstractC3280d.m6590h(contextThemeWrapperM6589g));
        this.f3223g = C3424l0.f11567c;
        this.f3238v = new HandlerC1080c(0, this);
        this.f3221e = C3451u0.m7069d(getContext());
        this.f3222f = new C1093i0(this, 2);
        this.f3235s = new C0125b0(1, this);
    }

    @Override
    public final void dismiss() {
        try {
            getContext().unregisterReceiver(this.f3235s);
        } catch (IllegalArgumentException unused) {
        }
        super.dismiss();
    }

    public final void m2743i(List list) {
        this.f3237u = SystemClock.uptimeMillis();
        this.f3224h.clear();
        this.f3224h.addAll(list);
        this.f3234r.notifyDataSetChanged();
        HandlerC1080c handlerC1080c = this.f3238v;
        handlerC1080c.removeMessages(3);
        handlerC1080c.removeMessages(2);
        if (!list.isEmpty()) {
            m2746l(1);
        } else {
            m2746l(0);
            handlerC1080c.sendMessageDelayed(handlerC1080c.obtainMessage(2), 5000L);
        }
    }

    public final void m2744j() {
        if (this.f3236t) {
            this.f3221e.getClass();
            C3451u0.m7067b();
            ArrayList arrayList = new ArrayList(C3451u0.m7068c().f11496i);
            int size = arrayList.size();
            while (true) {
                int i6 = size - 1;
                if (size <= 0) {
                    break;
                }
                C3445s0 c3445s0 = (C3445s0) arrayList.get(i6);
                if (c3445s0.m7021d() || !c3445s0.f11658g || !c3445s0.m7025h(this.f3223g)) {
                    arrayList.remove(i6);
                }
                size = i6;
            }
            Collections.sort(arrayList, C1084e.f3213b);
            if (SystemClock.uptimeMillis() - this.f3237u >= 300) {
                m2743i(arrayList);
                return;
            }
            HandlerC1080c handlerC1080c = this.f3238v;
            handlerC1080c.removeMessages(1);
            handlerC1080c.sendMessageAtTime(handlerC1080c.obtainMessage(1, arrayList), this.f3237u + 300);
        }
    }

    public final void m2745k(C3424l0 c3424l0) {
        if (c3424l0 == null) {
            throw new IllegalArgumentException("selector must not be null");
        }
        if (this.f3223g.equals(c3424l0)) {
            return;
        }
        this.f3223g = c3424l0;
        if (this.f3236t) {
            C3451u0 c3451u0 = this.f3221e;
            C1093i0 c1093i0 = this.f3222f;
            c3451u0.m7075h(c1093i0);
            c3451u0.m7074a(c3424l0, c1093i0, 1);
        }
        m2744j();
    }

    public final void m2746l(int i6) {
        if (i6 == 0) {
            setTitle(R.string.mr_chooser_title);
            this.f3233q.setVisibility(8);
            this.f3226j.setVisibility(0);
            this.f3232p.setVisibility(0);
            this.f3230n.setVisibility(8);
            this.f3231o.setVisibility(8);
            this.f3229m.setVisibility(8);
            this.f3227k.setVisibility(8);
            return;
        }
        if (i6 == 1) {
            setTitle(R.string.mr_chooser_title);
            this.f3233q.setVisibility(0);
            this.f3226j.setVisibility(8);
            this.f3232p.setVisibility(8);
            this.f3230n.setVisibility(8);
            this.f3231o.setVisibility(8);
            this.f3229m.setVisibility(8);
            this.f3227k.setVisibility(8);
            return;
        }
        if (i6 == 2) {
            setTitle(R.string.mr_chooser_title);
            this.f3233q.setVisibility(8);
            this.f3226j.setVisibility(8);
            this.f3232p.setVisibility(0);
            this.f3230n.setVisibility(8);
            this.f3231o.setVisibility(8);
            this.f3229m.setVisibility(4);
            this.f3227k.setVisibility(0);
            return;
        }
        if (i6 != 3) {
            return;
        }
        setTitle(R.string.mr_chooser_zero_routes_found_title);
        this.f3233q.setVisibility(8);
        this.f3226j.setVisibility(8);
        this.f3232p.setVisibility(8);
        this.f3230n.setVisibility(0);
        this.f3231o.setVisibility(0);
        this.f3229m.setVisibility(0);
        this.f3227k.setVisibility(0);
    }

    @Override
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f3236t = true;
        this.f3221e.m7074a(this.f3223g, this.f3222f, 1);
        m2744j();
        HandlerC1080c handlerC1080c = this.f3238v;
        handlerC1080c.removeMessages(2);
        handlerC1080c.removeMessages(3);
        handlerC1080c.removeMessages(1);
        handlerC1080c.sendMessageDelayed(handlerC1080c.obtainMessage(2), 5000L);
    }

    @Override
    public final void onCreate(Bundle bundle) {
        String string;
        boolean z7;
        super.onCreate(bundle);
        setContentView(R.layout.mr_chooser_dialog);
        this.f3224h = new ArrayList();
        this.f3234r = new C1082d(getContext(), this.f3224h);
        this.f3225i = (TextView) findViewById(R.id.mr_chooser_title);
        this.f3226j = (TextView) findViewById(R.id.mr_chooser_searching);
        this.f3227k = (RelativeLayout) findViewById(R.id.mr_chooser_wifi_warning_container);
        this.f3228l = (TextView) findViewById(R.id.mr_chooser_wifi_warning_description);
        this.f3229m = (TextView) findViewById(R.id.mr_chooser_wifi_learn_more);
        this.f3230n = (LinearLayout) findViewById(R.id.mr_chooser_ok_button_container);
        this.f3231o = (Button) findViewById(R.id.mr_chooser_ok_button);
        this.f3232p = (ProgressBar) findViewById(R.id.mr_chooser_search_progress_bar);
        Context context = getContext();
        boolean z10 = false;
        if (AbstractC2973a.f10179g == null) {
            if (AbstractC2973a.m6024z(context)) {
                z7 = false;
            } else {
                PackageManager packageManager = context.getPackageManager();
                if (AbstractC2973a.f10183k == null) {
                    AbstractC2973a.f10183k = Boolean.valueOf(packageManager.hasSystemFeature("android.hardware.type.watch"));
                }
                if (AbstractC2973a.f10183k.booleanValue() || AbstractC2973a.m6022x(context) || AbstractC2973a.m6010A(context)) {
                    z7 = false;
                } else {
                    z7 = true;
                }
            }
            AbstractC2973a.f10179g = Boolean.valueOf(z7);
        }
        if (AbstractC2973a.f10179g.booleanValue()) {
            string = context.getString(R.string.mr_chooser_wifi_warning_description_phone);
        } else {
            if (AbstractC2973a.f10181i == null) {
                SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
                if (Build.VERSION.SDK_INT >= 30 && sensorManager != null && sensorManager.getDefaultSensor(36) != null) {
                    z10 = true;
                }
                AbstractC2973a.f10181i = Boolean.valueOf(z10);
            }
            if (AbstractC2973a.f10181i.booleanValue()) {
                string = context.getString(R.string.mr_chooser_wifi_warning_description_phone);
            } else if (AbstractC2973a.m6024z(context) || AbstractC2973a.m6023y(context.getResources())) {
                string = context.getString(R.string.mr_chooser_wifi_warning_description_tablet);
            } else if (AbstractC2973a.m6010A(context)) {
                string = context.getString(R.string.mr_chooser_wifi_warning_description_tv);
            } else {
                PackageManager packageManager2 = context.getPackageManager();
                if (AbstractC2973a.f10183k == null) {
                    AbstractC2973a.f10183k = Boolean.valueOf(packageManager2.hasSystemFeature("android.hardware.type.watch"));
                }
                if (AbstractC2973a.f10183k.booleanValue()) {
                    string = context.getString(R.string.mr_chooser_wifi_warning_description_watch);
                } else {
                    string = AbstractC2973a.m6022x(context) ? context.getString(R.string.mr_chooser_wifi_warning_description_car) : context.getString(R.string.mr_chooser_wifi_warning_description_unknown);
                }
            }
        }
        this.f3228l.setText(string);
        this.f3229m.setMovementMethod(LinkMovementMethod.getInstance());
        this.f3231o.setOnClickListener(new ViewOnClickListenerC1078b(0, this));
        ListView listView = (ListView) findViewById(R.id.mr_chooser_list);
        this.f3233q = listView;
        listView.setAdapter((ListAdapter) this.f3234r);
        this.f3233q.setOnItemClickListener(this.f3234r);
        this.f3233q.setEmptyView(findViewById(android.R.id.empty));
        getWindow().setLayout(AbstractC3198d.m6473v(getContext()), -2);
        getContext().registerReceiver(this.f3235s, new IntentFilter("android.intent.action.SCREEN_OFF"));
    }

    @Override
    public final void onDetachedFromWindow() {
        this.f3236t = false;
        this.f3221e.m7075h(this.f3222f);
        HandlerC1080c handlerC1080c = this.f3238v;
        handlerC1080c.removeMessages(1);
        handlerC1080c.removeMessages(2);
        handlerC1080c.removeMessages(3);
        super.onDetachedFromWindow();
    }

    @Override
    public final void setTitle(CharSequence charSequence) {
        this.f3225i.setText(charSequence);
    }

    @Override
    public final void setTitle(int i6) {
        this.f3225i.setText(i6);
    }
}
