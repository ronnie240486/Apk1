package p063fa;

import android.os.Bundle;
import android.os.Message;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.ViewOnClickListenerC0122a;
import androidx.fragment.app.FragmentActivity;
import androidx.mediarouter.app.HandlerC1080c;
import androidx.recyclerview.widget.AbstractC1174p1;
import com.p2serv.android.p032ds.R;
import com.tencent.mars.xlog.Log;
import java.util.Arrays;
import java.util.HashSet;
import org.bitspark.android.R$drawable;
import org.bitspark.android.beans.GroupL1;
import org.bitspark.android.utils.AbstractC3331m;
import p000a.AbstractC0004e;
import p003a2.AbstractC0032a;

public final class C2535j1 extends AbstractC2551p {

    public static final String f8827l = AbstractC0032a.m165s("hqXGeThfXvCc++NaK0Bf5aKc\n", "0MqiPkowK4A=\n");

    public final SparseArray f8828g;

    public final Integer[] f8829h;

    public int f8830i;

    public final HandlerC1080c f8831j;

    public int f8832k;

    public C2535j1(SparseArray sparseArray, FragmentActivity fragmentActivity, HandlerC1080c handlerC1080c) {
        super(11);
        this.f8830i = 0;
        this.f8832k = 0;
        fragmentActivity.getResources().getDrawable(R$drawable.group_l1_bg);
        this.f8831j = handlerC1080c;
        this.f8828g = sparseArray;
        HashSet hashSet = new HashSet();
        for (int i6 = 0; i6 < sparseArray.size(); i6++) {
            hashSet.add(Integer.valueOf(sparseArray.keyAt(i6)));
            AbstractC0032a.m165s("5Cj3zYwXrLn+dtLunwitrMAR\n", "skeTiv542ck=\n");
            AbstractC0032a.m165s("PlNKF0Q8YdZjAQ==\n", "WSElYjR3BK8=\n");
            sparseArray.keyAt(i6);
        }
        Integer[] numArr = (Integer[]) hashSet.toArray(new Integer[hashSet.size()]);
        this.f8829h = numArr;
        Arrays.sort(numArr);
        String strM165s = AbstractC0032a.m165s("k8F7nGW8VVKJn16/dqNUR7f4\n", "xa4f2xfTICI=\n");
        String str = AbstractC0032a.m165s("DMHOsZUP5wcqwdOlnH6i\n", "a7OhxOVEgn4=\n") + numArr.length;
        boolean z7 = AbstractC3331m.f11244b;
        Log.m5049i(strM165s, str);
    }

    public final void m5557b() {
        HandlerC1080c handlerC1080c = this.f8831j;
        handlerC1080c.removeMessages(2);
        Message message = new Message();
        message.what = 2;
        Bundle bundle = new Bundle();
        bundle.putSerializable(AbstractC0032a.m165s("c6tsnwViDnU=\n", "FNkD6nUxawE=\n"), ((GroupL1) this.f8828g.get(this.f8832k)).groups);
        message.setData(bundle);
        handlerC1080c.sendMessage(message);
        this.f8830i = this.f8884a;
    }

    @Override
    public final int getItemCount() {
        return this.f8828g.size();
    }

    @Override
    public final void onBindViewHolder(AbstractC1174p1 abstractC1174p1, int i6) {
        C2532i1 c2532i1 = (C2532i1) abstractC1174p1;
        boolean z7 = i6 == this.f8884a;
        c2532i1.itemView.setSelected(z7);
        this.f8832k = this.f8829h[i6].intValue();
        StringBuilder sb = new StringBuilder();
        sb.append(AbstractC0032a.m165s("SYGGE07j234cvogWBI8=\n", "LvPpZj6v6jI=\n"));
        SparseArray sparseArray = this.f8828g;
        sb.append(sparseArray.size());
        sb.append(AbstractC0032a.m165s("TKTm+SiFU1BW4w==\n", "bMOUll31GjQ=\n"));
        sb.append(this.f8832k);
        sb.append(AbstractC0032a.m165s("VvDdk3BmfUwb8pXc\n", "dpev/AUWMy0=\n"));
        sb.append(((GroupL1) sparseArray.get(this.f8832k)).name);
        String string = sb.toString();
        boolean z10 = AbstractC3331m.f11244b;
        Log.m5049i(f8827l, string);
        String str = ((GroupL1) sparseArray.get(this.f8832k)).name;
        TextView textView = c2532i1.f8819a;
        textView.setText(str);
        textView.setTag(Integer.valueOf(this.f8832k));
        if (z7) {
            textView.setTextColor(-1);
            if (this.f8885b >= 0) {
                textView.setBackgroundResource(R$drawable.dialog_btn_bg_focused);
            } else {
                textView.setBackgroundResource(R$drawable.dialog_btn_bg_last_focus);
            }
            if (this.f8830i != this.f8884a) {
                m5557b();
            }
        } else {
            textView.setTextColor(-1879048193);
            textView.setBackgroundResource(R$drawable.group_l1_bg);
        }
        c2532i1.itemView.setOnClickListener(new ViewOnClickListenerC0122a(13, this));
    }

    @Override
    public final AbstractC1174p1 onCreateViewHolder(ViewGroup viewGroup, int i6) {
        View viewM15i = AbstractC0004e.m15i(viewGroup, R.layout.vod_group_l1_v_item, viewGroup, false);
        C2532i1 c2532i1 = new C2532i1(viewM15i);
        c2532i1.f8819a = (TextView) viewM15i.findViewById(R.id.group_l1_v_name);
        return c2532i1;
    }
}
