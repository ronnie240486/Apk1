package p063fa;

import android.os.Message;
import android.view.View;
import ba.C1371d;
import com.p2serv.android.p032ds.R;
import ga.C2626i;
import ga.C2632o;
import java.util.Iterator;
import org.bitspark.android.Spark;
import org.bitspark.android.beans.ChannelBean;
import p044da.C2340c;
import p055ea.EnumC2434d;
import p116ka.ViewOnKeyListenerC2932m0;

public final class ViewOnLongClickListenerC2561t0 implements View.OnLongClickListener {

    public final ChannelBean f8907a;

    public final int f8908b;

    public final int f8909c;

    public final C2569x0 f8910d;

    public ViewOnLongClickListenerC2561t0(C2569x0 c2569x0, ChannelBean channelBean, int i6, int i10) {
        this.f8910d = c2569x0;
        this.f8907a = channelBean;
        this.f8908b = i6;
        this.f8909c = i10;
    }

    @Override
    public final boolean onLongClick(View view) throws Throwable {
        if (this.f8907a.getLevel() >= 18) {
            return true;
        }
        if (C2632o.f9152e.contains("" + this.f8908b)) {
            C1371d.m3242a(this.f8910d.f8874a, 0, this.f8907a.getName().getInit() + " " + this.f8910d.f8874a.getString(R.string.remove_fav)).show();
            C2626i c2626i = Spark.f11003Y1;
            ChannelBean channelBean = this.f8907a;
            synchronized (c2626i) {
                Iterator it = C2626i.f9126g.iterator();
                while (it.hasNext()) {
                    if (((ChannelBean) it.next()).getChid() == channelBean.getChid()) {
                        it.remove();
                    }
                }
            }
            C2632o.m5653a();
            C2569x0 c2569x0 = this.f8910d;
            int i6 = c2569x0.f8934l;
            if (i6 == -5 || i6 == -20) {
                c2569x0.f8932j.clear();
                this.f8910d.f8932j.addAll(Spark.f11003Y1.m5635b());
                this.f8910d.notifyItemRemoved(this.f8909c);
                this.f8910d.notifyDataSetChanged();
                int i10 = this.f8909c;
                int i11 = i10 - 1;
                if (i10 == 0 && !this.f8910d.f8932j.isEmpty()) {
                    i11 = 0;
                }
                if (i11 >= 0) {
                    this.f8910d.notifyItemChanged(i11);
                    C2569x0 c2569x1 = this.f8910d;
                    c2569x1.f8877d = i11;
                    c2569x1.f8875b = i11;
                    c2569x1.notifyItemChanged(i11);
                } else {
                    ViewOnKeyListenerC2932m0.f9950E0.removeMessages(3);
                    ViewOnKeyListenerC2932m0.f9950E0.sendMessage(Message.obtain(ViewOnKeyListenerC2932m0.f9950E0, 3, -5, 0));
                    Spark.f11002X1.sendEmptyMessage(108);
                    ViewOnKeyListenerC2932m0.f9951F0 = EnumC2434d.f8532d;
                }
            } else {
                c2569x0.notifyItemChanged(c2569x0.f8875b);
                C2569x0 c2569x2 = this.f8910d;
                c2569x2.f8877d = c2569x2.f8878e.getChildLayoutPosition(view);
                C2569x0 c2569x3 = this.f8910d;
                c2569x3.f8875b = c2569x3.f8878e.getChildLayoutPosition(view);
                C2569x0 c2569x4 = this.f8910d;
                c2569x4.notifyItemChanged(c2569x4.f8875b);
            }
        } else {
            C1371d.m3242a(this.f8910d.f8874a, 0, this.f8907a.getName().getInit() + " " + this.f8910d.f8874a.getString(R.string.favorited)).show();
            C2626i c2626i2 = Spark.f11003Y1;
            ChannelBean channelBean2 = this.f8907a;
            c2626i2.getClass();
            C2626i.f9126g.offer(channelBean2);
            C2340c c2340c = Spark.f11008d2;
            String str = C2626i.f9123d;
            c2340c.m5311g(str);
            Spark.f11008d2.m5308d(str, C2626i.f9126g, 315360000);
            C2632o.m5653a();
            C2569x0 c2569x5 = this.f8910d;
            if (c2569x5.f8934l == -5) {
                c2569x5.notifyDataSetChanged();
            }
            C2569x0 c2569x6 = this.f8910d;
            c2569x6.notifyItemChanged(c2569x6.f8875b);
            C2569x0 c2569x7 = this.f8910d;
            c2569x7.f8877d = c2569x7.f8878e.getChildLayoutPosition(view);
            C2569x0 c2569x8 = this.f8910d;
            c2569x8.f8875b = c2569x8.f8878e.getChildLayoutPosition(view);
            C2569x0 c2569x9 = this.f8910d;
            c2569x9.notifyItemChanged(c2569x9.f8875b);
        }
        ViewOnKeyListenerC2932m0.f9951F0 = EnumC2434d.f8533e;
        return true;
    }
}
