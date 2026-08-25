package p116ka;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.AbstractC0410j0;
import com.p2serv.android.p032ds.R;
import com.tencent.mars.xlog.Log;
import java.util.ArrayList;
import la.ViewOnClickListenerC3017d;
import la.ViewOnKeyListenerC3018e;
import org.bitspark.android.utils.AbstractC3331m;
import org.bitspark.android.view.MyViewPager;
import p003a2.AbstractC0032a;
import p055ea.AbstractC2440g;
import p063fa.C2557r0;

public class ViewOnTouchListenerC2945z extends C2909b implements View.OnTouchListener {

    public static final String f10109Y = AbstractC0032a.m165s("4bY84Fen7AzC\n", "o+VpkzLVqn4=\n");

    public ArrayList f10110U;

    public ViewOnClickListenerC3017d f10111V;

    public ViewOnKeyListenerC3018e f10112W;

    public MyViewPager f10113X;

    @Override
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return true;
    }

    @Override
    public final View mo1329t(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_user, (ViewGroup) null);
        this.f10113X = (MyViewPager) viewInflate.findViewById(R.id.page_login);
        this.f10111V = new ViewOnClickListenerC3017d();
        this.f10112W = new ViewOnKeyListenerC3018e();
        ArrayList arrayList = new ArrayList();
        this.f10110U = arrayList;
        Integer[] numArr = AbstractC2440g.f8565n;
        arrayList.add(numArr[0].intValue(), this.f10111V);
        this.f10110U.add(numArr[1].intValue(), this.f10112W);
        AbstractC0410j0 abstractC0410j0M1320i = m1320i();
        ArrayList arrayList2 = this.f10110U;
        C2557r0 c2557r0 = new C2557r0(abstractC0410j0M1320i);
        c2557r0.f8899g = arrayList2;
        this.f10113X.setAdapter(c2557r0);
        this.f10113X.setOffscreenPageLimit(2);
        StringBuilder sb = new StringBuilder();
        sb.append(AbstractC0032a.m165s("LPZ57zaN/lIV8V/qc4DlUCr2Gv48iO8X\n", "Q5g6nVPsijc=\n"));
        String str = AbstractC2440g.f8552a;
        sb.append(AbstractC3331m.m6756f(-65535, str));
        Log.m5049i(f10109Y, sb.toString());
        if (AbstractC3331m.m6756f(-65535, str).intValue() == 0 || AbstractC3331m.m6756f(-65535, str).intValue() == -12) {
            this.f10113X.setCurrentItem(numArr[1].intValue());
        } else {
            this.f10113X.setCurrentItem(numArr[0].intValue());
        }
        return viewInflate;
    }
}
