package androidx.mediarouter.app;

import android.util.Log;
import android.view.View;
import androidx.recyclerview.widget.AbstractC1174p1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import p173q1.AbstractC3394b0;
import p173q1.AbstractC3397c0;
import p173q1.C3411h;
import p173q1.C3436p0;
import p173q1.C3445s0;
import p173q1.C3451u0;
import p173q1.C3460z;

public final class ViewOnClickListenerC1089g0 implements View.OnClickListener {

    public final int f3243a;

    public final Object f3244b;

    public ViewOnClickListenerC1089g0(int i6, Object obj) {
        this.f3243a = i6;
        this.f3244b = obj;
    }

    @Override
    public final void onClick(View view) {
        int iMax;
        switch (this.f3243a) {
            case 0:
                AbstractC1091h0 abstractC1091h0 = (AbstractC1091h0) this.f3244b;
                DialogC1109q0 dialogC1109q0 = abstractC1091h0.f3249d;
                if (dialogC1109q0.f3343v != null) {
                    dialogC1109q0.f3338q.removeMessages(2);
                }
                C3445s0 c3445s0 = abstractC1091h0.f3246a;
                DialogC1109q0 dialogC1109q1 = abstractC1091h0.f3249d;
                dialogC1109q1.f3343v = c3445s0;
                boolean zIsActivated = view.isActivated();
                boolean z7 = !zIsActivated;
                if (zIsActivated) {
                    Integer num = (Integer) dialogC1109q1.f3344w.get(abstractC1091h0.f3246a.f11654c);
                    iMax = num == null ? 1 : Math.max(1, num.intValue());
                } else {
                    iMax = 0;
                }
                abstractC1091h0.m2749c(z7);
                abstractC1091h0.f3248c.setProgress(iMax);
                abstractC1091h0.f3246a.m7027j(iMax);
                dialogC1109q1.f3338q.sendEmptyMessageDelayed(2, 500L);
                return;
            case 1:
                MediaRouteExpandCollapseButton mediaRouteExpandCollapseButton = (MediaRouteExpandCollapseButton) this.f3244b;
                boolean z10 = mediaRouteExpandCollapseButton.f3167h;
                mediaRouteExpandCollapseButton.f3167h = !z10;
                if (z10) {
                    mediaRouteExpandCollapseButton.setImageDrawable(mediaRouteExpandCollapseButton.f3164e);
                    mediaRouteExpandCollapseButton.f3164e.start();
                    mediaRouteExpandCollapseButton.setContentDescription(mediaRouteExpandCollapseButton.f3165f);
                } else {
                    mediaRouteExpandCollapseButton.setImageDrawable(mediaRouteExpandCollapseButton.f3163d);
                    mediaRouteExpandCollapseButton.f3163d.start();
                    mediaRouteExpandCollapseButton.setContentDescription(mediaRouteExpandCollapseButton.f3166g);
                }
                View.OnClickListener onClickListener = mediaRouteExpandCollapseButton.f3168i;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                    return;
                }
                return;
            case 2:
                ((DialogC1081c0) this.f3244b).dismiss();
                return;
            case 3:
                C1095j0 c1095j0 = (C1095j0) this.f3244b;
                C3451u0 c3451u0 = c1095j0.f3260g.f3299j.f3326e;
                C3445s0 c3445s1 = c1095j0.f3259f;
                c3451u0.getClass();
                if (c3445s1 == null) {
                    throw new NullPointerException("route must not be null");
                }
                C3451u0.m7067b();
                C3411h c3411hM7068c = C3451u0.m7068c();
                C3436p0 c3436p0M7019a = c3411hM7068c.f11491d.m7019a();
                if (c3436p0M7019a == null) {
                    Log.w("AxMediaRouter", "Ignoring attempt to transfer for a selected non-group route");
                } else {
                    List<C3445s0> listSingletonList = Collections.singletonList(c3445s1);
                    ArrayList arrayList = new ArrayList();
                    for (C3445s0 c3445s2 : listSingletonList) {
                        C3460z c3460z = (C3460z) c3436p0M7019a.f11621x.get(c3445s2.f11654c);
                        if (c3460z == null || !c3460z.f11723e) {
                            Log.w("AxMediaRouter", "Ignoring attempt to update the group with a non-transferable route: " + c3445s2);
                        } else {
                            arrayList.add(c3445s2.f11653b);
                        }
                    }
                    if (arrayList.isEmpty()) {
                        Log.w("AxMediaRouter", "Ignoring attempt to update the group with non-transferable routes");
                    } else if (c3436p0M7019a.m7024g()) {
                        AbstractC3397c0 abstractC3397c0 = c3411hM7068c.f11492e;
                        if (!(abstractC3397c0 instanceof AbstractC3394b0)) {
                            throw new IllegalStateException("There is no currently selected dynamic group route.");
                        }
                        ((AbstractC3394b0) abstractC3397c0).mo6892p(arrayList);
                    } else if (c3436p0M7019a.m7013n()) {
                        c3411hM7068c.m6938e();
                        Log.w("AxMediaRouter", "Ignoring attempt to update routes for a non-available connected route: " + c3436p0M7019a);
                    } else {
                        Log.w("AxMediaRouter", "Ignoring attempt to update routes for an unsupported group route:" + c3436p0M7019a);
                    }
                }
                c1095j0.f3255b.setVisibility(4);
                c1095j0.f3256c.setVisibility(0);
                return;
            default:
                C1103n0 c1103n0 = (C1103n0) this.f3244b;
                boolean zM2760d = c1103n0.m2760d(c1103n0.f3246a);
                boolean z11 = !zM2760d;
                boolean zM7022e = c1103n0.f3246a.m7022e();
                C1105o0 c1105o0 = c1103n0.f3287n;
                if (zM2760d) {
                    C3451u0 c3451u1 = c1105o0.f3299j.f3326e;
                    C3445s0 c3445s3 = c1103n0.f3246a;
                    c3451u1.getClass();
                    if (c3445s3 == null) {
                        throw new NullPointerException("route must not be null");
                    }
                    C3451u0.m7067b();
                    C3411h c3411hM7068c2 = C3451u0.m7068c();
                    C3436p0 c3436p0M7019a2 = c3411hM7068c2.f11491d.m7019a();
                    if (c3436p0M7019a2 == null) {
                        Log.w("AxMediaRouter", "Ignoring attempt to remove a member route from a selected non-group route");
                    } else {
                        C3460z c3460z2 = (C3460z) c3436p0M7019a2.f11621x.get(c3445s3.f11654c);
                        if (c3460z2 == null || !c3460z2.f11721c) {
                            Log.w("AxMediaRouter", "Ignoring attempt to remove a non-unselectable member route: " + c3445s3);
                        } else if (!Collections.unmodifiableList(c3436p0M7019a2.f11673v).contains(c3445s3)) {
                            Log.w("AxMediaRouter", "Ignoring attempt to remove a non-in-group member route: " + c3445s3);
                        } else if (Collections.unmodifiableList(c3436p0M7019a2.f11673v).size() <= 1) {
                            Log.w("AxMediaRouter", "Ignoring attempt to remove the last member route.");
                        } else if (c3436p0M7019a2.m7024g()) {
                            AbstractC3397c0 abstractC3397c1 = c3411hM7068c2.f11492e;
                            if (!(abstractC3397c1 instanceof AbstractC3394b0)) {
                                throw new IllegalStateException("There is no currently selected dynamic group route.");
                            }
                            ((AbstractC3394b0) abstractC3397c1).mo6891o(c3445s3.f11653b);
                        } else if (c3436p0M7019a2.m7013n()) {
                            c3411hM7068c2.m6938e();
                            Log.w("AxMediaRouter", "Ignoring attempt to update routes for a non-available connected route: " + c3436p0M7019a2);
                        } else {
                            Log.w("AxMediaRouter", "Ignoring attempt to remove a route from an unsupported group route:" + c3436p0M7019a2);
                        }
                    }
                } else {
                    C3451u0 c3451u2 = c1105o0.f3299j.f3326e;
                    C3445s0 c3445s4 = c1103n0.f3246a;
                    c3451u2.getClass();
                    if (c3445s4 == null) {
                        throw new NullPointerException("route must not be null");
                    }
                    C3451u0.m7067b();
                    C3411h c3411hM7068c3 = C3451u0.m7068c();
                    C3436p0 c3436p0M7019a3 = c3411hM7068c3.f11491d.m7019a();
                    if (c3436p0M7019a3 == null) {
                        Log.w("AxMediaRouter", "Ignoring attempt to add a member route to a selected non-group route");
                    } else if (!c3436p0M7019a3.m7014o(c3445s4)) {
                        Log.w("AxMediaRouter", "Ignoring attempt to add a non-groupable member route: " + c3445s4);
                    } else if (Collections.unmodifiableList(c3436p0M7019a3.f11673v).contains(c3445s4)) {
                        Log.w("AxMediaRouter", "Ignoring attempt to add an existing member route: " + c3445s4);
                    } else if (c3436p0M7019a3.m7024g()) {
                        AbstractC3397c0 abstractC3397c2 = c3411hM7068c3.f11492e;
                        if (!(abstractC3397c2 instanceof AbstractC3394b0)) {
                            throw new IllegalStateException("There is no currently selected dynamic group route.");
                        }
                        ((AbstractC3394b0) abstractC3397c2).mo6890n(c3445s4.f11653b);
                    } else if (c3436p0M7019a3.m7013n()) {
                        c3411hM7068c3.m6938e();
                        Log.w("AxMediaRouter", "Ignoring attempt to add a route to a non-available connected route: " + c3436p0M7019a3);
                    } else {
                        Log.w("AxMediaRouter", "Ignoring attempt to add a route to an unsupported group route:" + c3436p0M7019a3);
                    }
                }
                c1103n0.m2761e(z11, !zM7022e);
                if (zM7022e) {
                    List listUnmodifiableList = Collections.unmodifiableList(c1105o0.f3299j.f3329h.f11673v);
                    for (C3445s0 c3445s5 : Collections.unmodifiableList(c1103n0.f3246a.f11673v)) {
                        if (listUnmodifiableList.contains(c3445s5) != z11) {
                            AbstractC1091h0 abstractC1091h1 = (AbstractC1091h0) c1105o0.f3299j.f3342u.get(c3445s5.f11654c);
                            if (abstractC1091h1 instanceof C1103n0) {
                                ((C1103n0) abstractC1091h1).m2761e(z11, true);
                            }
                        }
                    }
                }
                C3445s0 c3445s6 = c1103n0.f3246a;
                DialogC1109q0 dialogC1109q2 = c1105o0.f3299j;
                List listUnmodifiableList2 = Collections.unmodifiableList(dialogC1109q2.f3329h.f11673v);
                int iMax2 = Math.max(1, listUnmodifiableList2.size());
                if (c3445s6.m7022e()) {
                    Iterator it = Collections.unmodifiableList(c3445s6.f11673v).iterator();
                    while (it.hasNext()) {
                        if (listUnmodifiableList2.contains((C3445s0) it.next()) != z11) {
                            iMax2 += !zM2760d ? 1 : -1;
                        }
                    }
                } else {
                    iMax2 += zM2760d ? -1 : 1;
                }
                DialogC1109q0 dialogC1109q3 = c1105o0.f3299j;
                boolean z12 = dialogC1109q3.f3325R && Collections.unmodifiableList(dialogC1109q3.f3329h.f11673v).size() > 1;
                boolean z13 = dialogC1109q2.f3325R && iMax2 >= 2;
                if (z12 != z13) {
                    AbstractC1174p1 abstractC1174p1FindViewHolderForAdapterPosition = dialogC1109q2.f3339r.findViewHolderForAdapterPosition(0);
                    if (abstractC1174p1FindViewHolderForAdapterPosition instanceof C1097k0) {
                        C1097k0 c1097k0 = (C1097k0) abstractC1174p1FindViewHolderForAdapterPosition;
                        c1105o0.m2767a(z13 ? c1097k0.f3264f : 0, c1097k0.itemView);
                        return;
                    }
                    return;
                }
                return;
        }
    }
}
