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

public final class C2529h1 extends AbstractC2551p {

    public final SparseArray f8809g;

    public final Integer[] f8810h;

    public int f8811i;

    public final HandlerC1080c f8812j;

    public int f8813k;

    static {
        AbstractC0032a.m165s("BrsYfLOfND0c5T1foIA1KCI=\n", "UNR8O8HwQU0=\n");
    }

    public C2529h1(SparseArray sparseArray, FragmentActivity fragmentActivity, HandlerC1080c handlerC1080c) {
        super(1);
        this.f8811i = 0;
        this.f8813k = 0;
        fragmentActivity.getResources().getDrawable(R$drawable.group_l1_bg);
        this.f8812j = handlerC1080c;
        this.f8809g = sparseArray;
        HashSet hashSet = new HashSet();
        for (int i6 = 0; i6 < sparseArray.size(); i6++) {
            hashSet.add(Integer.valueOf(sparseArray.keyAt(i6)));
            AbstractC0032a.m165s("jBNS6DSOFTqWTXfLJ5EUL6g=\n", "2nw2r0bhYEo=\n");
            AbstractC0032a.m165s("9lVcxsP8pBerBw==\n", "kSczs7O3wW4=\n");
            sparseArray.keyAt(i6);
        }
        Integer[] numArr = (Integer[]) hashSet.toArray(new Integer[hashSet.size()]);
        this.f8810h = numArr;
        Arrays.sort(numArr);
        String strM165s = AbstractC0032a.m165s("q/NIUIclzS6xrW1zlDrMO48=\n", "/ZwsF/VKuF4=\n");
        String str = AbstractC0032a.m165s("7OHXZowFhATK4cpyhXTB\n", "i5O4E/xO4X0=\n") + numArr.length;
        boolean z7 = AbstractC3331m.f11244b;
        Log.m5049i(strM165s, str);
    }

    public final void m5556b() {
        HandlerC1080c handlerC1080c = this.f8812j;
        handlerC1080c.removeMessages(2);
        Message message = new Message();
        message.what = 2;
        Bundle bundle = new Bundle();
        bundle.putSerializable(AbstractC0032a.m165s("j4ieA7DReyM=\n", "6PrxdsCCHlc=\n"), ((GroupL1) this.f8809g.get(this.f8813k)).groups);
        message.setData(bundle);
        handlerC1080c.sendMessage(message);
        this.f8811i = this.f8884a;
    }

    @Override
    public final int getItemCount() {
        return this.f8809g.size();
    }

    @Override
    public final void onBindViewHolder(AbstractC1174p1 abstractC1174p1, int i6) {
        C2526g1 c2526g1 = (C2526g1) abstractC1174p1;
        boolean z7 = i6 == this.f8884a;
        if (z7) {
            int i10 = this.f8885b;
        }
        c2526g1.itemView.setSelected(z7);
        this.f8813k = this.f8810h[i6].intValue();
        AbstractC0032a.m165s("TlSOfVhSXbEba4B4Ej4=\n", "KSbhCCgebP0=\n");
        SparseArray sparseArray = this.f8809g;
        sparseArray.size();
        AbstractC0032a.m165s("G80+Yqu93BMBig==\n", "O6pMDd7NlXc=\n");
        AbstractC0032a.m165s("Asm1fPXDwu9Py/0z\n", "Iq7HE4CzjI4=\n");
        String str = ((GroupL1) sparseArray.get(this.f8813k)).name;
        String str2 = ((GroupL1) sparseArray.get(this.f8813k)).name;
        TextView textView = c2526g1.f8804a;
        textView.setText(str2);
        textView.setTag(Integer.valueOf(this.f8813k));
        if (z7) {
            textView.setTextColor(-1);
            if (this.f8885b >= 0) {
                textView.setBackgroundResource(R$drawable.dialog_btn_bg_focused);
            } else {
                textView.setBackgroundResource(R$drawable.dialog_btn_bg_last_focus);
            }
            if (this.f8811i != this.f8884a) {
                m5556b();
            }
        } else {
            textView.setTextColor(-1879048193);
            textView.setBackgroundResource(R$drawable.group_l1_bg);
        }
        c2526g1.itemView.setOnClickListener(new ViewOnClickListenerC0122a(12, this));
    }

    @Override
    public final AbstractC1174p1 onCreateViewHolder(ViewGroup viewGroup, int i6) {
        View viewM15i = AbstractC0004e.m15i(viewGroup, R.layout.vod_group_l1_item, viewGroup, false);
        C2526g1 c2526g1 = new C2526g1(viewM15i);
        c2526g1.f8804a = (TextView) viewM15i.findViewById(R.id.group_l1_name);
        return c2526g1;
    }
}
