package p063fa;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Message;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.mediarouter.app.HandlerC1080c;
import androidx.recyclerview.widget.AbstractC1174p1;
import com.p2serv.android.p032ds.R;
import com.tencent.mars.xlog.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import org.bitspark.android.Spark;
import org.bitspark.android.beans.Group;
import org.bitspark.android.utils.AbstractC3331m;
import org.bitspark.android.utils.C3332n;
import p000a.AbstractC0004e;
import p003a2.AbstractC0032a;

public final class C2523f1 extends AbstractC2551p {

    public static final String f8790l = AbstractC0032a.m165s("EHpd2hXQ2sUHcVjtE9rd\n", "RhU5nWe/r7U=\n");

    public final FragmentActivity f8791g;

    public final SparseArray f8792h;

    public final ArrayList f8793i;

    public int f8794j;

    public final HandlerC1080c f8795k;

    public C2523f1(SparseArray sparseArray, FragmentActivity fragmentActivity, HandlerC1080c handlerC1080c) {
        super(2);
        this.f8792h = new SparseArray();
        this.f8793i = new ArrayList();
        this.f8794j = 0;
        this.f8791g = fragmentActivity;
        this.f8795k = handlerC1080c;
        for (int i6 = 0; i6 < sparseArray.size(); i6++) {
            this.f8792h.put(sparseArray.keyAt(i6), (Group) sparseArray.valueAt(i6));
        }
        HashSet hashSet = new HashSet();
        for (int i10 = 0; i10 < sparseArray.size(); i10++) {
            hashSet.add(Integer.valueOf(sparseArray.keyAt(i10)));
        }
        this.f8793i.addAll(hashSet);
        Collections.sort(this.f8793i);
    }

    @Override
    public final int getItemCount() {
        return this.f8792h.size();
    }

    @Override
    public final void onBindViewHolder(AbstractC1174p1 abstractC1174p1, int i6) {
        C2520e1 c2520e1 = (C2520e1) abstractC1174p1;
        boolean z7 = i6 == this.f8884a;
        if (z7) {
            int i10 = this.f8885b;
        }
        c2520e1.itemView.setSelected(z7);
        Integer num = (Integer) this.f8793i.get(i6);
        int iIntValue = num.intValue();
        StringBuilder sb = new StringBuilder();
        sb.append(AbstractC0032a.m165s("wqWnHm+aMGrLua0HUrgoMYU=\n", "pdfIax/ZWAs=\n"));
        SparseArray sparseArray = this.f8792h;
        sb.append(sparseArray.size());
        sb.append(AbstractC0032a.m165s("a+HoMrDAILpxpg==\n", "S4aaXcWwad4=\n"));
        sb.append(iIntValue);
        sb.append(AbstractC0032a.m165s("ykcw3nP56FCHRXiR\n", "6iBCsQaJpjE=\n"));
        sb.append(((Group) sparseArray.get(iIntValue)).name);
        String string = sb.toString();
        boolean z10 = AbstractC3331m.f11244b;
        Log.m5049i(f8790l, string);
        String strReplaceAll = ((Group) sparseArray.get(iIntValue)).name.replaceAll(AbstractC0032a.m165s("iGdThw==\n", "pk0PqHzv/DY=\n"), "");
        String str = ((Group) sparseArray.get(iIntValue)).url;
        ImageView imageView = c2520e1.f8781a;
        imageView.setVisibility(0);
        if (((Group) sparseArray.get(iIntValue)).restrictedAccess) {
            if (Spark.f11007c2) {
                imageView.setImageResource(R.mipmap.group_type_lock_0);
            } else {
                imageView.setImageResource(R.mipmap.group_type_lock_1);
            }
        } else if (((Group) sparseArray.get(iIntValue)).type == -5) {
            imageView.setImageResource(R.mipmap.group_type_favorite);
        } else {
            imageView.setVisibility(8);
        }
        TextView textView = c2520e1.f8782b;
        textView.setText(strReplaceAll);
        textView.setTag(num);
        ImageView imageView2 = c2520e1.f8783c;
        if (z7) {
            if (this.f8885b >= 0) {
                imageView2.setImageResource(R.mipmap.underline);
                textView.setTag(R.id.scale_animator_id, Boolean.TRUE);
                textView.animate().cancel();
                textView.setVisibility(0);
                ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(textView, AbstractC0032a.m165s("PodmJTkd\n", "TeQHSVxFTds=\n"), 1.0f, 1.25f);
                objectAnimatorOfFloat.setDuration(220L);
                ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(textView, AbstractC0032a.m165s("1DrcxIXo\n", "p1m9qOCxulE=\n"), 1.0f, 1.25f);
                objectAnimatorOfFloat2.setDuration(220L);
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
                ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(textView, AbstractC0032a.m165s("qvad358n\n", "2ZX8s/p/GWc=\n"), 1.25f, 1.1f);
                objectAnimatorOfFloat3.setDuration(100L);
                ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(textView, AbstractC0032a.m165s("noAOTCJF\n", "7eNvIEccSn8=\n"), 1.25f, 1.1f);
                objectAnimatorOfFloat4.setDuration(100L);
                AnimatorSet animatorSet2 = new AnimatorSet();
                animatorSet2.playTogether(objectAnimatorOfFloat3, objectAnimatorOfFloat4);
                AnimatorSet animatorSet3 = new AnimatorSet();
                animatorSet3.playSequentially(animatorSet, animatorSet2);
                animatorSet3.start();
                animatorSet.addListener(new C3332n(textView));
            } else {
                imageView2.setImageResource(R.mipmap.underline_gray);
                textView.setScaleY(1.0f);
                textView.setScaleX(1.0f);
            }
            textView.setTextColor(-1);
            if (this.f8794j != this.f8884a) {
                HandlerC1080c handlerC1080c = this.f8795k;
                handlerC1080c.removeMessages(3);
                Message messageObtain = Message.obtain(handlerC1080c, 3, iIntValue, 0);
                messageObtain.obj = str;
                handlerC1080c.sendMessage(messageObtain);
                this.f8794j = this.f8884a;
            }
        } else {
            textView.setTextColor(-1879048193);
            imageView2.setImageResource(0);
        }
        c2520e1.itemView.setOnClickListener(new ViewOnClickListenerC2514c1(this, iIntValue, c2520e1));
    }

    @Override
    public final AbstractC1174p1 onCreateViewHolder(ViewGroup viewGroup, int i6) {
        View viewM15i = AbstractC0004e.m15i(viewGroup, R.layout.vod_group_item, viewGroup, false);
        C2520e1 c2520e1 = new C2520e1(viewM15i);
        c2520e1.f8781a = (ImageView) viewM15i.findViewById(R.id.group_type_icon);
        c2520e1.f8782b = (TextView) viewM15i.findViewById(R.id.group_name);
        c2520e1.f8783c = (ImageView) viewM15i.findViewById(R.id.underline);
        c2520e1.f8784d = viewM15i.findViewById(R.id.root_vod_child);
        return c2520e1;
    }
}
