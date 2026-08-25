package p063fa;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.AbstractC1174p1;
import com.bumptech.glide.ComponentCallbacks2C1464b;
import com.p2serv.android.p032ds.R;
import com.tencent.mars.xlog.Log;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import org.bitspark.android.Spark;
import org.bitspark.android.beans.Group;
import org.bitspark.android.utils.AbstractC3331m;
import p000a.AbstractC0004e;
import p003a2.AbstractC0032a;
import p116ka.C2933n;

public final class C2525g0 extends AbstractC2531i0 {

    public static final String f8797i = AbstractC0032a.m165s("tIkhOdAZyWWdkRY/2h4=\n", "+fBmS79suSQ=\n");

    public LinkedHashMap f8798c;

    public ArrayList f8799d;

    public View f8800e;

    public C2933n f8801f;

    public boolean f8802g;

    public boolean f8803h;

    public final void m5554a(int i6, View view) {
        String str = AbstractC0032a.m165s("lesCj7cxa6uS6xKKuzh58sY=\n", "5o523NJdDsg=\n") + view + AbstractC0032a.m165s("s9HpwsQ=\n", "juzU//mbA6Y=\n") + i6;
        boolean z7 = AbstractC3331m.f11244b;
        Log.m5049i(f8797i, str);
        this.f8800e = view;
        if (view != null) {
            view.setSelected(true);
        }
    }

    @Override
    public final int getItemCount() {
        return this.f8798c.size();
    }

    @Override
    public final void onBindViewHolder(AbstractC1174p1 abstractC1174p1, int i6) {
        C2522f0 c2522f0 = (C2522f0) abstractC1174p1;
        int absoluteAdapterPosition = c2522f0.getAbsoluteAdapterPosition();
        ImageView imageView = c2522f0.f8789b;
        imageView.setVisibility(0);
        int i10 = 2;
        c2522f0.itemView.setOnKeyListener(new ViewOnKeyListenerC2521f(absoluteAdapterPosition, i10, this));
        c2522f0.itemView.setOnTouchListener(new ViewOnTouchListenerC2527h(i6, i10, this));
        c2522f0.itemView.setOnClickListener(new ViewOnClickListenerC2554q(this, i6, i10));
        c2522f0.itemView.setOnLongClickListener(new ViewOnLongClickListenerC2542m(this, absoluteAdapterPosition));
        ArrayList arrayList = this.f8799d;
        if (arrayList.size() > i6) {
            Integer num = (Integer) arrayList.get(i6);
            int iIntValue = num.intValue();
            LinkedHashMap linkedHashMap = this.f8798c;
            c2522f0.f8788a.setText(((Group) linkedHashMap.get(num)).name);
            if (((Group) linkedHashMap.get(num)).restrictedAccess) {
                if (Spark.f11007c2) {
                    imageView.setImageResource(R.mipmap.group_type_lock_0);
                } else {
                    imageView.setImageResource(R.mipmap.group_type_lock_1);
                }
            } else if (((Group) linkedHashMap.get(num)).type == -5) {
                imageView.setImageResource(R.mipmap.group_type_favorite);
            } else if (((Group) linkedHashMap.get(num)).type == -4 || ((Group) linkedHashMap.get(num)).type == 104) {
                imageView.setImageResource(R.mipmap.group_type_playback);
            } else if (((Group) linkedHashMap.get(num)).type == -3) {
                imageView.setImageResource(R.mipmap.group_type_all);
            } else {
                imageView.setVisibility(8);
            }
            c2522f0.itemView.setTag(num);
            c2522f0.itemView.setOnFocusChangeListener(new ViewOnFocusChangeListenerC2519e0(this, c2522f0, iIntValue, absoluteAdapterPosition));
        }
    }

    @Override
    public final AbstractC1174p1 onCreateViewHolder(ViewGroup viewGroup, int i6) {
        View viewM15i = AbstractC0004e.m15i(viewGroup, R.layout.group_item, viewGroup, false);
        C2522f0 c2522f0 = new C2522f0(viewM15i);
        c2522f0.f8788a = (TextView) viewM15i.findViewById(R.id.group_name);
        c2522f0.f8789b = (ImageView) viewM15i.findViewById(R.id.group_type_icon);
        return c2522f0;
    }

    @Override
    public final void onViewRecycled(AbstractC1174p1 abstractC1174p1) {
        C2522f0 c2522f0 = (C2522f0) abstractC1174p1;
        super.onViewRecycled(c2522f0);
        ComponentCallbacks2C1464b.m3464e(c2522f0.itemView.getContext()).m3568k(c2522f0.f8789b);
    }
}
