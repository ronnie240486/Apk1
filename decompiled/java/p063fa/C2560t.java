package p063fa;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import androidx.recyclerview.widget.AbstractC1174p1;
import com.p2serv.android.p032ds.R;
import ga.C2621d;
import ga.C2625h;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import org.bitspark.android.Constants$VIDEO_TYPE;
import org.bitspark.android.R$drawable;
import org.bitspark.android.beans.ChannelBean;
import org.bitspark.android.beans.EpgBeans;
import org.bitspark.android.beans.HistoryBean;
import org.bitspark.android.utils.AbstractC3331m;
import p000a.AbstractC0004e;
import p003a2.AbstractC0032a;

public final class C2560t extends AbstractC2562u implements Filterable {

    public List f8903g;

    public InterfaceC2549o0 f8904h;

    public final Constants$VIDEO_TYPE f8905i;

    public final SimpleDateFormat f8906j;

    static {
        AbstractC0032a.m165s("IyW2QBKhxvoPLbVAGKE=\n", "a0zFNH3Tv7s=\n");
    }

    public C2560t(List list, Constants$VIDEO_TYPE constants$VIDEO_TYPE) {
        super(constants$VIDEO_TYPE);
        this.f8906j = new SimpleDateFormat(AbstractC0032a.m165s("YbXiLVNMDiU/+MI=\n", "BZWvYB5sRm0=\n"), Locale.getDefault());
        this.f8905i = constants$VIDEO_TYPE;
        this.f8903g = list;
        new C2556r(this).filter(null);
    }

    @Override
    public final Filter getFilter() {
        return new C2556r(this);
    }

    @Override
    public final int getItemCount() {
        List list = this.f8903g;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override
    public final void onBindViewHolder(AbstractC1174p1 abstractC1174p1, int i6) {
        C2558s c2558s = (C2558s) abstractC1174p1;
        boolean z7 = i6 == this.f8914b;
        boolean z10 = z7 && this.f8915c >= 0;
        c2558s.itemView.setSelected(z7);
        HistoryBean historyBean = (HistoryBean) this.f8903g.get(i6);
        c2558s.f8902c.setText(this.f8906j.format(historyBean.date));
        c2558s.f8900a.setText(historyBean.name);
        if (historyBean.type != Constants$VIDEO_TYPE.BSLIVE || C2621d.f9109c == null || C2621d.f9109c.get(Integer.valueOf(historyBean.chid)) == null) {
            TextView textView = c2558s.f8901b;
            StringBuilder sb = new StringBuilder();
            Long lValueOf = Long.valueOf(historyBean.lastPosition);
            boolean z11 = AbstractC3331m.f11244b;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(AbstractC0032a.m165s("h9Fs6+x1cw==\n", "z+sBhtYGAGY=\n"), Locale.CHINESE);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone(AbstractC0032a.m165s("RgmeLnDDrdw=\n", "AUTKBUD5new=\n")));
            sb.append(simpleDateFormat.format(lValueOf));
            sb.append(" ");
            sb.append(historyBean.subTitle);
            textView.setText(sb.toString());
        } else {
            int epgSameAs = ((ChannelBean) C2621d.f9109c.get(Integer.valueOf(historyBean.chid))).getEpgSameAs() > 0 ? ((ChannelBean) C2621d.f9109c.get(Integer.valueOf(historyBean.chid))).getEpgSameAs() : historyBean.chid;
            TextView textView2 = c2558s.f8901b;
            ArrayList arrayListM5630c = C2625h.m5630c(epgSameAs);
            textView2.setText((arrayListM5630c == null || arrayListM5630c.isEmpty()) ? "" : ((EpgBeans.EpgBean) arrayListM5630c.get(0)).getName());
        }
        if (z10) {
            c2558s.f8900a.setTextColor(-1);
            c2558s.itemView.setBackgroundResource(R$drawable.history_focus_bg);
        } else {
            c2558s.f8900a.setTextColor(-1342177281);
            c2558s.itemView.setBackgroundResource(R$drawable.history_unfocus_bg);
        }
        c2558s.itemView.setOnClickListener(new ViewOnClickListenerC2554q(this, i6, 0));
    }

    @Override
    public final AbstractC1174p1 onCreateViewHolder(ViewGroup viewGroup, int i6) {
        View viewM15i = AbstractC0004e.m15i(viewGroup, R.layout.history_item, viewGroup, false);
        C2558s c2558s = new C2558s(viewM15i);
        c2558s.f8900a = (TextView) viewM15i.findViewById(R.id.history_name);
        c2558s.f8901b = (TextView) viewM15i.findViewById(R.id.program_now);
        c2558s.f8902c = (TextView) viewM15i.findViewById(R.id.visit_at);
        return c2558s;
    }
}
