package p063fa;

import android.view.KeyEvent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mars.xlog.Log;
import org.bitspark.android.Constants$VIDEO_TYPE;
import org.bitspark.android.Spark;
import org.bitspark.android.utils.AbstractC3331m;
import p003a2.AbstractC0032a;
import p007a7.C0069f;
import p055ea.AbstractC2442h;
import p055ea.EnumC2434d;
import p116ka.C2924i0;
import p116ka.ViewOnKeyListenerC2915e;
import p116ka.ViewOnKeyListenerC2932m0;
import p251x6.C4129h;

public final class ViewOnKeyListenerC2539l implements View.OnKeyListener {

    public final int f8855a;

    public final Object f8856b;

    public final Object f8857c;

    public ViewOnKeyListenerC2539l(Object obj, int i6, Object obj2) {
        this.f8855a = i6;
        this.f8857c = obj;
        this.f8856b = obj2;
    }

    @Override
    public final boolean onKey(View view, int i6, KeyEvent keyEvent) {
        int keyCode;
        Object obj = this.f8856b;
        Object obj2 = this.f8857c;
        switch (this.f8855a) {
            case 0:
                ((RecyclerView) obj).getLayoutManager();
                String str = AbstractC2548o.f8873i;
                String str2 = AbstractC0032a.m165s("07IcHiag2/DTshwDJqDb8NOyHB4moNvwzuBPaH7k3A==\n", "7o8hIxud5s0=\n") + i6 + AbstractC0032a.m165s("+nH5YtBoEw==\n", "2hSPB74cKTo=\n") + keyEvent;
                boolean z7 = AbstractC3331m.f11244b;
                Log.m5049i(str, str2);
                AbstractC2548o abstractC2548o = (AbstractC2548o) obj2;
                if (i6 == 4) {
                    if (keyEvent.getAction() != 0) {
                        Log.m5049i(str, AbstractC0032a.m165s("nF5axrp7OeicXlrbuns56JxeWsa6eznogSgCgsIwYbvVTSa40w9Lm/42N8GnNGGh1BEJ2/M0cbA=\n", "oWNn+4dGBNU=\n"));
                        return false;
                    }
                    EnumC2434d enumC2434d = abstractC2548o.f8879f;
                    if (enumC2434d == EnumC2434d.f8533e) {
                        abstractC2548o.f8881h.mo233j();
                    } else if (enumC2434d == EnumC2434d.f8535g) {
                        Spark.f11002X1.sendEmptyMessage(106);
                    } else {
                        Log.m5049i(str, AbstractC0032a.m165s("W9lsi4gBv5ls2GKQthM=\n", "KLED/Nl01u0=\n"));
                        AbstractC3331m.m6766p(abstractC2548o.f8874a);
                    }
                } else {
                    if (keyEvent.getAction() != 0) {
                        return false;
                    }
                    if (i6 == 22) {
                        return abstractC2548o.m5558a(1);
                    }
                    if (i6 == 21) {
                        if (abstractC2548o.f8875b % abstractC2548o.f8880g != 0) {
                            return abstractC2548o.m5558a(-1);
                        }
                        EnumC2434d enumC2434d2 = abstractC2548o.f8879f;
                        EnumC2434d enumC2434d3 = EnumC2434d.f8533e;
                        if (enumC2434d2 == enumC2434d3 && !ViewOnKeyListenerC2932m0.f9952G0) {
                            Spark.f11002X1.sendEmptyMessage(120);
                            ViewOnKeyListenerC2932m0.f9951F0 = enumC2434d3;
                        } else if (enumC2434d2 == EnumC2434d.f8535g) {
                            Spark.f11002X1.sendEmptyMessage(106);
                        } else if (enumC2434d2 == enumC2434d3 && ViewOnKeyListenerC2932m0.f9952G0) {
                            Spark.f11002X1.sendEmptyMessage(107);
                            ViewOnKeyListenerC2932m0.f9951F0 = enumC2434d3;
                        }
                        abstractC2548o.f8877d = -1;
                        abstractC2548o.f8876c = 1;
                    } else {
                        if (i6 != 19) {
                            if (i6 == 20) {
                                return abstractC2548o.m5558a(abstractC2548o.f8880g);
                            }
                            return false;
                        }
                        if (abstractC2548o.f8879f != EnumC2434d.f8535g || abstractC2548o.f8875b > abstractC2548o.f8880g) {
                            return abstractC2548o.m5558a(-abstractC2548o.f8880g);
                        }
                    }
                }
                return true;
            case 1:
                ((RecyclerView) obj).getLayoutManager();
                AbstractC2551p abstractC2551p = (AbstractC2551p) obj2;
                if (keyEvent.getAction() == 0 && i6 == 4) {
                    C0069f c0069f = abstractC2551p.f8888e;
                    if (c0069f != null) {
                        c0069f.mo233j();
                    }
                } else if (keyEvent.getAction() == 0) {
                    int keyCode2 = keyEvent.getKeyCode();
                    if (keyCode2 == 23 || keyCode2 == 66 || keyCode2 == 96) {
                        if ((keyEvent.getFlags() & 128) != 128) {
                            keyEvent.startTracking();
                        } else if (abstractC2551p.f8886c.findViewHolderForAdapterPosition(abstractC2551p.f8884a) != null) {
                            abstractC2551p.f8886c.findViewHolderForAdapterPosition(abstractC2551p.f8884a).itemView.performLongClick();
                        }
                    } else {
                        if (i6 == 19) {
                            if (abstractC2551p.f8887d == 11) {
                                return AbstractC2551p.m5559a(abstractC2551p, -1);
                            }
                            abstractC2551p.f8885b = -1;
                            return false;
                        }
                        if (i6 == 20) {
                            int i10 = abstractC2551p.f8887d;
                            if (i10 == 11) {
                                return AbstractC2551p.m5559a(abstractC2551p, 1);
                            }
                            ViewOnKeyListenerC2932m0.f9951F0 = EnumC2434d.f8533e;
                            abstractC2551p.f8885b = -1;
                            if (i10 != 2 || ViewOnKeyListenerC2932m0.f9948C0.getVisibility() != 8) {
                                return false;
                            }
                        } else {
                            if (i6 == 22) {
                                if (abstractC2551p.f8887d != 11) {
                                    return AbstractC2551p.m5559a(abstractC2551p, 1);
                                }
                                abstractC2551p.f8885b = -1;
                                return false;
                            }
                            if (i6 != 21) {
                                return false;
                            }
                            if (abstractC2551p.f8887d != 11) {
                                return AbstractC2551p.m5559a(abstractC2551p, -1);
                            }
                            Spark.f11002X1.sendEmptyMessage(105);
                        }
                    }
                } else {
                    if (keyEvent.getAction() != 1) {
                        return false;
                    }
                    int keyCode3 = keyEvent.getKeyCode();
                    if ((keyCode3 != 23 && keyCode3 != 66 && keyCode3 != 96) || (keyEvent.getFlags() & 128) == 128) {
                        return false;
                    }
                    if (abstractC2551p.f8886c.findViewHolderForAdapterPosition(abstractC2551p.f8884a) != null) {
                        abstractC2551p.f8886c.findViewHolderForAdapterPosition(abstractC2551p.f8884a).itemView.performClick();
                    }
                }
                return true;
            case 2:
                ((RecyclerView) obj).getLayoutManager();
                if (keyEvent.getAction() != 0 || i6 != 4) {
                    AbstractC2562u abstractC2562u = (AbstractC2562u) obj2;
                    if (keyEvent.getAction() == 0) {
                        int keyCode4 = keyEvent.getKeyCode();
                        if (keyCode4 != 23 && keyCode4 != 66 && keyCode4 != 96) {
                            Constants$VIDEO_TYPE constants$VIDEO_TYPE = abstractC2562u.f8913a;
                            Constants$VIDEO_TYPE constants$VIDEO_TYPE2 = Constants$VIDEO_TYPE.BSLIVE;
                            if (constants$VIDEO_TYPE != constants$VIDEO_TYPE2) {
                                Constants$VIDEO_TYPE constants$VIDEO_TYPE3 = Constants$VIDEO_TYPE.BSVOD;
                                if (constants$VIDEO_TYPE == constants$VIDEO_TYPE3) {
                                    if (i6 == 22) {
                                        return AbstractC2562u.m5560a(abstractC2562u, 1);
                                    }
                                    if (i6 == 21) {
                                        if (abstractC2562u.f8914b % AbstractC2442h.f8612r != 0) {
                                            return AbstractC2562u.m5560a(abstractC2562u, -1);
                                        }
                                        Spark.f11002X1.sendEmptyMessage(112);
                                        ViewOnKeyListenerC2915e.f9878k0 = constants$VIDEO_TYPE3;
                                        abstractC2562u.f8915c = -1;
                                    } else {
                                        if (i6 == 19) {
                                            return AbstractC2562u.m5560a(abstractC2562u, -5);
                                        }
                                        if (i6 == 20) {
                                            return AbstractC2562u.m5560a(abstractC2562u, 5);
                                        }
                                    }
                                }
                                return false;
                            }
                            if (i6 == 22) {
                                return AbstractC2562u.m5560a(abstractC2562u, 1);
                            }
                            if (i6 == 21) {
                                if (abstractC2562u.f8914b != 0) {
                                    return AbstractC2562u.m5560a(abstractC2562u, -1);
                                }
                                Spark.f11002X1.sendEmptyMessage(112);
                                ViewOnKeyListenerC2915e.f9878k0 = constants$VIDEO_TYPE2;
                                abstractC2562u.f8915c = -1;
                            } else if (i6 != 19) {
                                if (i6 == 20) {
                                    return AbstractC2562u.m5560a(abstractC2562u, (-abstractC2562u.f8914b) - 1);
                                }
                                return false;
                            }
                        } else if ((keyEvent.getFlags() & 128) != 128) {
                            keyEvent.startTracking();
                        } else if (abstractC2562u.f8916d.findViewHolderForAdapterPosition(abstractC2562u.f8914b) != null && abstractC2562u.f8916d.findViewHolderForAdapterPosition(abstractC2562u.f8914b).itemView != null) {
                            abstractC2562u.f8916d.findViewHolderForAdapterPosition(abstractC2562u.f8914b).itemView.performLongClick();
                        }
                    } else {
                        if (keyEvent.getAction() != 1 || (!((keyCode = keyEvent.getKeyCode()) == 23 || keyCode == 66 || keyCode == 96) || (keyEvent.getFlags() & 128) == 128)) {
                            if (i6 == 4) {
                                if (AbstractC2562u.f8912f > 0) {
                                    AbstractC2562u.f8912f = 0;
                                } else {
                                    Spark.f11002X1.sendEmptyMessage(112);
                                }
                            }
                            return false;
                        }
                        if (abstractC2562u.f8916d.findViewHolderForAdapterPosition(abstractC2562u.f8914b) != null && abstractC2562u.f8916d.findViewHolderForAdapterPosition(abstractC2562u.f8914b).itemView != null) {
                            abstractC2562u.f8916d.findViewHolderForAdapterPosition(abstractC2562u.f8914b).itemView.performClick();
                        }
                    }
                }
                return true;
            default:
                C2924i0 c2924i0 = (C2924i0) obj2;
                if (i6 != 4) {
                    C4129h c4129h = (C4129h) obj;
                    if ((i6 != 21 || c4129h.f14030d != 0) && ((i6 != 22 || c4129h.f14030d != c2924i0.f9915X.getTabCount() - 1) && i6 != 19)) {
                        return false;
                    }
                } else if (keyEvent.getAction() == 1) {
                    c2924i0.f9912U.m7736f();
                }
                return true;
        }
    }
}
