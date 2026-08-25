package p063fa;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.AbstractC1174p1;
import com.bumptech.glide.ComponentCallbacks2C1464b;
import com.p2serv.android.p032ds.R;
import com.tencent.mars.xlog.Log;
import ga.C2621d;
import ga.C2625h;
import java.util.ArrayList;
import org.bitspark.android.beans.ChannelBean;
import org.bitspark.android.beans.EpgBeans;
import org.bitspark.android.utils.AbstractC3331m;
import p000a.AbstractC0004e;
import p003a2.AbstractC0032a;
import p055ea.AbstractC2442h;
import p116ka.C2933n;
import p193ra.C3663f;

public final class C2516d0 extends AbstractC2531i0 {

    public static final String f8765i = AbstractC0032a.m165s("QV1iGx2KFKpgZUUSDJAfvQ==\n", "DCQhc3zkes8=\n");

    public int f8766c;

    public final ArrayList f8767d;

    public View f8768e;

    public final C2933n f8769f;

    public boolean f8770g;

    public boolean f8771h;

    public C2516d0(int i6, C2933n c2933n, ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList();
        this.f8767d = arrayList2;
        this.f8770g = true;
        this.f8771h = false;
        this.f8766c = i6;
        arrayList2.addAll(arrayList);
        this.f8769f = c2933n;
    }

    public final int m5550a() {
        int i6 = this.f8766c;
        int i10 = C3663f.m7415b().f12277j;
        String str = f8765i;
        if (i6 != i10) {
            String strM165s = AbstractC0032a.m165s("M09kRDZN0wawhYbW3bxQi90d447S4Sy4ZAcr\n", "VD0LMUYEtyY=\n");
            boolean z7 = AbstractC3331m.f11244b;
            Log.m5049i(str, strM165s);
            return 0;
        }
        int iIndexOf = this.f8767d.indexOf(C3663f.m7415b().f12272e);
        String str2 = AbstractC0032a.m165s("AcVK1awscTAIx27qsyR8MAnOBKU=\n", "ZqA+hcBNCFk=\n") + iIndexOf;
        boolean z10 = AbstractC3331m.f11244b;
        Log.m5049i(str, str2);
        return iIndexOf;
    }

    public final void m5551b(View view) {
        String str = AbstractC0032a.m165s("aX3CXfIFyUpufdJY/gzbEzo=\n", "Ghi2DpdprCk=\n") + view;
        boolean z7 = AbstractC3331m.f11244b;
        Log.m5049i(f8765i, str);
        this.f8768e = view;
    }

    @Override
    public final int getItemCount() {
        return this.f8767d.size();
    }

    @Override
    public final void onBindViewHolder(AbstractC1174p1 abstractC1174p1, int i6) {
        int i10 = 1;
        C2513c0 c2513c0 = (C2513c0) abstractC1174p1;
        int absoluteAdapterPosition = c2513c0.getAbsoluteAdapterPosition();
        ChannelBean channelBean = (ChannelBean) this.f8767d.get(absoluteAdapterPosition);
        int iM5631d = C2625h.m5631d(channelBean);
        String init = channelBean.getName().getInit();
        ArrayList arrayListM5630c = C2625h.m5630c(iM5631d);
        String name = (arrayListM5630c == null || arrayListM5630c.isEmpty()) ? "" : ((EpgBeans.EpgBean) arrayListM5630c.get(0)).getName();
        boolean zIsEmpty = TextUtils.isEmpty(name);
        String str = AbstractC2442h.f8595a;
        c2513c0.f8758c.setVisibility(8);
        c2513c0.itemView.setOnFocusChangeListener(new ViewOnFocusChangeListenerC2507a0(this, absoluteAdapterPosition, channelBean));
        c2513c0.itemView.setOnClickListener(new ViewOnClickListenerC2554q(this, i6, i10));
        c2513c0.itemView.setOnTouchListener(new ViewOnTouchListenerC2527h(i6, i10, this));
        c2513c0.itemView.setOnLongClickListener(new ViewOnLongClickListenerC2510b0(this, absoluteAdapterPosition));
        c2513c0.itemView.setOnKeyListener(new ViewOnKeyListenerC2521f(absoluteAdapterPosition, i10, this));
        ChannelBean.LogoBean.ImageBean image = channelBean.getLogo().getImage();
        if (TextUtils.isEmpty(image.getBig())) {
            image.getSmall();
        } else {
            image.getBig();
        }
        if (this.f8766c != -3 && channelBean.getSid() > 0) {
            init = channelBean.getSid() + AbstractC0032a.m165s("FA==\n", "Ot+sv26+NRI=\n") + init;
        }
        c2513c0.f8756a.setText(init);
        if (zIsEmpty) {
            c2513c0.f8757b.setVisibility(8);
            c2513c0.f8760e.setVisibility(0);
        } else {
            c2513c0.f8757b.setVisibility(0);
            c2513c0.f8760e.setVisibility(8);
            c2513c0.f8757b.setText(name);
        }
        c2513c0.itemView.setTag(channelBean);
        if (C2621d.f9112f.contains("" + channelBean.getChid())) {
            c2513c0.f8759d.setVisibility(0);
        } else {
            c2513c0.f8759d.setVisibility(8);
        }
    }

    @Override
    public final AbstractC1174p1 onCreateViewHolder(ViewGroup viewGroup, int i6) {
        View viewM15i = AbstractC0004e.m15i(viewGroup, R.layout.my_channel_item, viewGroup, false);
        C2513c0 c2513c0 = new C2513c0(viewM15i);
        c2513c0.f8759d = (ImageView) viewM15i.findViewById(R.id.channel_type_icon);
        c2513c0.f8756a = (TextView) viewM15i.findViewById(R.id.channel_name);
        c2513c0.f8760e = (TextView) viewM15i.findViewById(R.id.topView);
        c2513c0.f8757b = (TextView) viewM15i.findViewById(R.id.program_item);
        c2513c0.f8758c = (ImageView) viewM15i.findViewById(R.id.channel_logo);
        return c2513c0;
    }

    @Override
    public final void onViewRecycled(AbstractC1174p1 abstractC1174p1) {
        C2513c0 c2513c0 = (C2513c0) abstractC1174p1;
        super.onViewRecycled(c2513c0);
        ComponentCallbacks2C1464b.m3464e(c2513c0.itemView.getContext()).m3568k(c2513c0.f8759d);
        ComponentCallbacks2C1464b.m3464e(c2513c0.itemView.getContext()).m3568k(c2513c0.f8758c);
    }
}
