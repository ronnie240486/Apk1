package p063fa;

import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.AbstractC1158k0;
import androidx.recyclerview.widget.AbstractC1174p1;
import com.p2serv.android.p032ds.R;
import ma.C3091a;
import na.C3222a;
import org.bitspark.android.keyboard.custom.MyKeyBoardView;
import p004a3.RunnableC0038c;
import p209t3.C3807d;

public final class ViewOnTouchListenerC2534j0 implements View.OnTouchListener {

    public final int f8823a;

    public final int f8824b;

    public final AbstractC1174p1 f8825c;

    public final AbstractC1158k0 f8826d;

    public ViewOnTouchListenerC2534j0(AbstractC1158k0 abstractC1158k0, AbstractC1174p1 abstractC1174p1, int i6, int i10) {
        this.f8823a = i10;
        this.f8826d = abstractC1158k0;
        this.f8825c = abstractC1174p1;
        this.f8824b = i6;
    }

    @Override
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        InterfaceC2549o0 interfaceC2549o0;
        InterfaceC2549o0 interfaceC2549o1;
        InterfaceC2549o0 interfaceC2549o2;
        InterfaceC2549o0 interfaceC2549o3;
        switch (this.f8823a) {
            case 0:
                if (motionEvent.getAction() == 1 && (interfaceC2549o0 = ((C2543m0) this.f8826d).f8863a) != null) {
                    interfaceC2549o0.mo5482a(this.f8824b, ((C2540l0) this.f8825c).itemView);
                }
                return false;
            case 1:
                if (motionEvent.getAction() == 1 && (interfaceC2549o1 = ((C2511b1) this.f8826d).f8754g) != null) {
                    interfaceC2549o1.mo5482a(this.f8824b, ((C2508a1) this.f8825c).itemView);
                }
                return false;
            case 2:
                if (motionEvent.getAction() == 1 && (interfaceC2549o2 = ((C2544m1) this.f8826d).f8754g) != null) {
                    interfaceC2549o2.mo5482a(this.f8824b, ((C2541l1) this.f8825c).itemView);
                }
                return false;
            case 3:
                if (motionEvent.getAction() == 1 && (interfaceC2549o3 = ((C2550o1) this.f8826d).f8754g) != null) {
                    interfaceC2549o3.mo5482a(this.f8824b, ((C2553p1) this.f8825c).itemView);
                }
                return false;
            default:
                long eventTime = motionEvent.getEventTime();
                C3091a c3091a = (C3091a) this.f8826d;
                c3091a.f10558i = eventTime;
                int action = motionEvent.getAction();
                C3807d c3807d = (C3807d) this.f8825c;
                if (action != 0) {
                    int i6 = this.f8824b;
                    if (action == 1 || action == 3) {
                        c3091a.f10563n.removeCallbacksAndMessages(null);
                        if (c3091a.f10560k) {
                            c3091a.f10560k = false;
                            c3091a.f10561l = false;
                        }
                        c3807d.m7583b(view.getId()).setBackgroundResource(R.color.white);
                        C3222a c3222a = c3091a.f10555f;
                        if (c3222a != null) {
                            c3222a.m6507a(view, i6, false);
                        }
                    } else {
                        if (!c3091a.f10560k) {
                            c3091a.f10560k = c3091a.f10558i - c3091a.f10557h >= c3091a.f10559j;
                        }
                        if (c3091a.f10560k && !c3091a.f10561l) {
                            c3091a.f10563n.removeCallbacksAndMessages(null);
                            c3091a.f10561l = true;
                            C3222a c3222a2 = c3091a.f10555f;
                            if (c3222a2 != null) {
                                c3222a2.m6507a(view, i6, true);
                            }
                        }
                    }
                } else {
                    c3091a.f10557h = motionEvent.getDownTime();
                    C3222a c3222a3 = c3091a.f10554e;
                    if (c3222a3 != null) {
                        MyKeyBoardView.m6734a(c3222a3.f10824a, view, c3807d.getLayoutPosition());
                    }
                    c3807d.m7583b(view.getId()).setBackgroundResource(R.color.greySelectedText);
                    c3091a.f10563n.postDelayed(new RunnableC0038c(this, 23, view), 500L);
                }
                return true;
        }
    }
}
