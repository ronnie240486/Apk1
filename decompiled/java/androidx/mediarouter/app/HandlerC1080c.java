package androidx.mediarouter.app;

import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.SystemClock;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.os.ResultReceiver;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import androidx.media.MediaBrowserServiceCompat;
import androidx.media3.common.C0565C;
import androidx.mediarouter.media.MediaRouteProviderService;
import com.p2serv.android.p032ds.R;
import com.tencent.mars.xlog.Log;
import ga.C2630m;
import ga.C2632o;
import ga.EnumC2629l;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import org.bitspark.android.SpkApplication;
import org.bitspark.android.beans.ChannelBean;
import org.bitspark.android.beans.Group;
import org.bitspark.android.beans.GroupBeanModel;
import org.bitspark.android.keyboard.custom.MyKeyBoardView;
import org.bitspark.android.utils.AbstractC3331m;
import p003a2.AbstractC0032a;
import p063fa.C2523f1;
import p101j7.C2782c;
import p105k.RunnableC2828d;
import p116ka.C2909b;
import p116ka.ViewOnKeyListenerC2932m0;
import p116ka.ViewOnKeyListenerC2937r;
import p129m1.C3044p;
import p129m1.RunnableC3039k;
import p129m1.RunnableC3040l;
import p129m1.RunnableC3041m;
import p129m1.RunnableC3042n;
import p129m1.RunnableC3043o;
import p173q1.AbstractC3403e0;
import p173q1.AbstractC3433o0;
import p173q1.C3418j0;
import p173q1.C3421k0;
import p173q1.C3423l;
import p222u7.AbstractC3928d;

public final class HandlerC1080c extends Handler {

    public final int f3192a;

    public final Object f3193b;

    public HandlerC1080c(int i6, Object obj) {
        this.f3192a = i6;
        this.f3193b = obj;
    }

    public void m2739a(Runnable runnable) {
        if (Thread.currentThread() == getLooper().getThread()) {
            runnable.run();
        } else {
            post(runnable);
        }
    }

    @Override
    public final void handleMessage(Message message) {
        C3421k0 c3421k0;
        int iM6995c;
        int i6 = 0;
        int i10 = 1;
        switch (this.f3192a) {
            case 0:
                int i11 = message.what;
                DialogC1086f dialogC1086f = (DialogC1086f) this.f3193b;
                if (i11 == 1) {
                    dialogC1086f.m2743i((List) message.obj);
                    return;
                }
                if (i11 == 2) {
                    if (dialogC1086f.f3224h.isEmpty()) {
                        dialogC1086f.m2746l(2);
                        HandlerC1080c handlerC1080c = dialogC1086f.f3238v;
                        handlerC1080c.removeMessages(2);
                        handlerC1080c.removeMessages(3);
                        handlerC1080c.sendMessageDelayed(handlerC1080c.obtainMessage(3), C0565C.DEFAULT_SEEK_FORWARD_INCREMENT_MS);
                        return;
                    }
                    return;
                }
                if (i11 == 3 && dialogC1086f.f3224h.isEmpty()) {
                    dialogC1086f.m2746l(3);
                    HandlerC1080c handlerC1080c2 = dialogC1086f.f3238v;
                    handlerC1080c2.removeMessages(2);
                    handlerC1080c2.removeMessages(3);
                    handlerC1080c2.removeMessages(1);
                    dialogC1086f.f3221e.m7075h(dialogC1086f.f3222f);
                    return;
                }
                return;
            case 1:
                if (message.what != 1) {
                    return;
                }
                List list = (List) message.obj;
                DialogC1081c0 dialogC1081c0 = (DialogC1081c0) this.f3193b;
                dialogC1081c0.getClass();
                dialogC1081c0.f3204o = SystemClock.uptimeMillis();
                dialogC1081c0.f3198i.clear();
                dialogC1081c0.f3198i.addAll(list);
                dialogC1081c0.f3199j.m2738a();
                return;
            case 2:
                int i12 = message.what;
                DialogC1109q0 dialogC1109q0 = (DialogC1109q0) this.f3193b;
                if (i12 == 1) {
                    dialogC1109q0.m2779p();
                    return;
                } else {
                    if (i12 == 2 && dialogC1109q0.f3343v != null) {
                        dialogC1109q0.f3343v = null;
                        dialogC1109q0.m2780q();
                        return;
                    }
                    return;
                }
            case 3:
                int i13 = message.what;
                ViewOnKeyListenerC2937r viewOnKeyListenerC2937r = (ViewOnKeyListenerC2937r) this.f3193b;
                if (i13 == 1) {
                    viewOnKeyListenerC2937r.m5953Z();
                } else if (i13 == 2) {
                    int i14 = message.arg1;
                    if (viewOnKeyListenerC2937r.m1319h() == null || viewOnKeyListenerC2937r.m1319h().getCurrentFocus() == null || viewOnKeyListenerC2937r.m1319h().getCurrentFocus().getId() != R.id.group_ch_search) {
                        viewOnKeyListenerC2937r.m5952Y(i14);
                    } else {
                        viewOnKeyListenerC2937r.f10019q0 = Boolean.FALSE;
                    }
                }
                super.handleMessage(message);
                return;
            case 4:
                int i15 = message.what;
                if (i15 == 0) {
                    int i16 = message.arg1;
                    String strM165s = AbstractC0032a.m165s("AS/kVKU=\n", "Q3yyO8En0ek=\n");
                    String str = AbstractC0032a.m165s("LactNKk2kdMlvj4/oiCX0yXR\n", "aPFoev1pw5Y=\n") + i16;
                    boolean z7 = AbstractC3331m.f11244b;
                    Log.m5049i(strM165s, str);
                    ViewOnKeyListenerC2932m0 viewOnKeyListenerC2932m0 = (ViewOnKeyListenerC2932m0) this.f3193b;
                    viewOnKeyListenerC2932m0.f9965d0.f8932j.clear();
                    viewOnKeyListenerC2932m0.f9965d0.f8932j.addAll(((Group) C2632o.f9150c.get(-1)).channnels);
                    viewOnKeyListenerC2932m0.f9965d0.notifyItemRemoved(i16);
                    viewOnKeyListenerC2932m0.f9965d0.notifyDataSetChanged();
                } else if (i15 == 1) {
                    String strM165s2 = AbstractC0032a.m165s("gbH3ih0=\n", "w+Kh5Xl3qPs=\n");
                    String strM165s3 = AbstractC0032a.m165s("+sU6KXy+6zbY/gQBE7r5LNH4FBgM2w==\n", "lqpbTVz7vXM=\n");
                    boolean z10 = AbstractC3331m.f11244b;
                    Log.m5049i(strM165s2, strM165s3);
                    ((ViewOnKeyListenerC2932m0) this.f3193b).m5934X();
                } else if (i15 == 2) {
                    HashSet hashSet = (HashSet) message.getData().getSerializable(AbstractC0032a.m165s("2j+rVGfFm94=\n", "vU3EIReW/qo=\n"));
                    String strM165s4 = AbstractC0032a.m165s("nKjQmeo=\n", "3vuG9o6eKLo=\n");
                    String str2 = AbstractC0032a.m165s("mjNqSafkwybd\n", "/UEFPNe3plI=\n") + hashSet;
                    boolean z11 = AbstractC3331m.f11244b;
                    Log.m5049i(strM165s4, str2);
                    ViewOnKeyListenerC2932m0 viewOnKeyListenerC2932m1 = (ViewOnKeyListenerC2932m0) this.f3193b;
                    viewOnKeyListenerC2932m1.getClass();
                    SparseArray sparseArray = new SparseArray();
                    if (hashSet != null) {
                        for (GroupBeanModel groupBeanModel : C2632o.f9153f) {
                            if (hashSet.contains(Integer.valueOf(groupBeanModel.group_id))) {
                                for (ChannelBean.TagsBean tagsBean : groupBeanModel.items) {
                                    Group group = new Group();
                                    group.name = tagsBean.getName().getInit();
                                    group.f11178id = tagsBean.getId();
                                    group.url = tagsBean.url;
                                    group.restrictedAccess = tagsBean.isRestrictedAccess();
                                    sparseArray.put(group.f11178id, group);
                                }
                            }
                        }
                        if (sparseArray.size() == 0) {
                            Group group2 = new Group();
                            group2.name = SpkApplication.f11160c.getApplicationContext().getString(R.string.Popular);
                            group2.f11178id = -10;
                            sparseArray.put(-10, group2);
                            Group group3 = new Group();
                            group3.name = SpkApplication.f11160c.getApplicationContext().getString(R.string.Favorites);
                            group3.f11178id = -5;
                            sparseArray.put(-5, group3);
                        }
                    }
                    C2523f1 c2523f1 = viewOnKeyListenerC2932m1.f9964c0;
                    if (c2523f1 == null) {
                        viewOnKeyListenerC2932m1.f9964c0 = new C2523f1(sparseArray, viewOnKeyListenerC2932m1.m1319h(), ViewOnKeyListenerC2932m0.f9950E0);
                        viewOnKeyListenerC2932m1.m5938b0();
                    } else {
                        SparseArray sparseArray2 = c2523f1.f8792h;
                        sparseArray2.clear();
                        c2523f1.f8884a = 0;
                        for (int i17 = 0; i17 < sparseArray.size(); i17++) {
                            sparseArray2.put(sparseArray.keyAt(i17), (Group) sparseArray.valueAt(i17));
                        }
                        HashSet hashSet2 = new HashSet();
                        for (int i18 = 0; i18 < sparseArray.size(); i18++) {
                            hashSet2.add(Integer.valueOf(sparseArray.keyAt(i18)));
                        }
                        ArrayList arrayList = c2523f1.f8793i;
                        arrayList.clear();
                        arrayList.addAll(hashSet2);
                        Collections.sort(arrayList);
                        viewOnKeyListenerC2932m1.f9964c0.notifyDataSetChanged();
                        if (viewOnKeyListenerC2932m1.f9979r0) {
                            viewOnKeyListenerC2932m1.f9959W.smoothScrollToPosition(0);
                        } else {
                            viewOnKeyListenerC2932m1.f9961Y.smoothScrollToPosition(0);
                        }
                    }
                    String str3 = ViewOnKeyListenerC2932m0.f9947B0;
                    String str4 = AbstractC0032a.m165s("TFKkbAISzSBFTq51PzDVb1hJsXxIcQ==\n", "KyDLGXJRpUE=\n") + sparseArray.size() + AbstractC0032a.m165s("j4+rce1fYfKGk6Fo0H15qcg=\n", "6P3EBJ0cCZM=\n") + sparseArray;
                    boolean z12 = AbstractC3331m.f11244b;
                    Log.m5049i(str3, str4);
                    C2523f1 c2523f2 = viewOnKeyListenerC2932m1.f9964c0;
                    if (c2523f2 != null) {
                        if (viewOnKeyListenerC2932m1.f9979r0) {
                            viewOnKeyListenerC2932m1.f9959W.swapAdapter(c2523f2, false);
                        } else {
                            viewOnKeyListenerC2932m1.f9961Y.swapAdapter(c2523f2, false);
                        }
                        ArrayList arrayList2 = viewOnKeyListenerC2932m1.f9964c0.f8793i;
                        if (arrayList2 != null && arrayList2.size() > 0) {
                            viewOnKeyListenerC2932m1.m5935Y(((Integer) viewOnKeyListenerC2932m1.f9964c0.f8793i.get(0)).intValue(), "");
                        }
                    }
                } else if (i15 == 3) {
                    int i19 = message.arg1;
                    String str5 = (String) message.obj;
                    if (i19 == -20) {
                        ViewOnKeyListenerC2932m0 viewOnKeyListenerC2932m2 = (ViewOnKeyListenerC2932m0) this.f3193b;
                        String strM5648e = C2630m.m5648e(C2630m.m5649h(EnumC2629l.f9138i) + AbstractC0032a.m165s("xg==\n", "6bZVF14p5ps=\n") + (-20));
                        String str6 = ViewOnKeyListenerC2932m0.f9947B0;
                        viewOnKeyListenerC2932m2.m5935Y(-20, strM5648e);
                    } else {
                        ViewOnKeyListenerC2932m0 viewOnKeyListenerC2932m3 = (ViewOnKeyListenerC2932m0) this.f3193b;
                        String str7 = ViewOnKeyListenerC2932m0.f9947B0;
                        viewOnKeyListenerC2932m3.m5935Y(i19, str5);
                    }
                }
                super.handleMessage(message);
                return;
            case 5:
                Bundle data = message.getData();
                int i20 = message.what;
                C2782c c2782c = (C2782c) this.f3193b;
                switch (i20) {
                    case 1:
                        Bundle bundle = data.getBundle("data_root_hints");
                        MediaSessionCompat.ensureClassLoader(bundle);
                        String string = data.getString("data_package_name");
                        int i21 = data.getInt("data_calling_pid");
                        int i22 = data.getInt("data_calling_uid");
                        C3044p c3044p = new C3044p(message.replyTo);
                        MediaBrowserServiceCompat mediaBrowserServiceCompat = (MediaBrowserServiceCompat) c2782c.f9501b;
                        if (string != null) {
                            String[] packagesForUid = mediaBrowserServiceCompat.getPackageManager().getPackagesForUid(i22);
                            int length = packagesForUid.length;
                            while (i6 < length) {
                                if (packagesForUid[i6].equals(string)) {
                                    mediaBrowserServiceCompat.f2575e.m2739a(new RunnableC3039k(i21, i22, bundle, c2782c, string, c3044p));
                                    return;
                                }
                                i6++;
                            }
                        } else {
                            mediaBrowserServiceCompat.getClass();
                        }
                        throw new IllegalArgumentException("Package/uid mismatch: uid=" + i22 + " package=" + string);
                    case 2:
                        ((MediaBrowserServiceCompat) c2782c.f9501b).f2575e.m2739a(new RunnableC3040l(c2782c, new C3044p(message.replyTo), i6));
                        return;
                    case 3:
                        Bundle bundle2 = data.getBundle("data_options");
                        MediaSessionCompat.ensureClassLoader(bundle2);
                        ((MediaBrowserServiceCompat) c2782c.f9501b).f2575e.m2739a(new RunnableC3041m(c2782c, new C3044p(message.replyTo), data.getString("data_media_item_id"), data.getBinder("data_callback_token"), bundle2));
                        return;
                    case 4:
                        ((MediaBrowserServiceCompat) c2782c.f9501b).f2575e.m2739a(new RunnableC2828d(c2782c, new C3044p(message.replyTo), data.getString("data_media_item_id"), data.getBinder("data_callback_token"), 1));
                        return;
                    case 5:
                        String string2 = data.getString("data_media_item_id");
                        ResultReceiver resultReceiver = (ResultReceiver) data.getParcelable("data_result_receiver");
                        C3044p c3044p2 = new C3044p(message.replyTo);
                        c2782c.getClass();
                        if (TextUtils.isEmpty(string2) || resultReceiver == null) {
                            return;
                        }
                        ((MediaBrowserServiceCompat) c2782c.f9501b).f2575e.m2739a(new RunnableC3042n(c2782c, c3044p2, string2, resultReceiver));
                        return;
                    case 6:
                        Bundle bundle3 = data.getBundle("data_root_hints");
                        MediaSessionCompat.ensureClassLoader(bundle3);
                        ((MediaBrowserServiceCompat) c2782c.f9501b).f2575e.m2739a(new RunnableC3043o(data.getInt("data_calling_uid"), data.getInt("data_calling_pid"), bundle3, c2782c, data.getString("data_package_name"), new C3044p(message.replyTo)));
                        return;
                    case 7:
                        ((MediaBrowserServiceCompat) c2782c.f9501b).f2575e.m2739a(new RunnableC3040l(c2782c, new C3044p(message.replyTo), i10));
                        return;
                    case 8:
                        Bundle bundle4 = data.getBundle("data_search_extras");
                        MediaSessionCompat.ensureClassLoader(bundle4);
                        String string3 = data.getString("data_search_query");
                        ResultReceiver resultReceiver2 = (ResultReceiver) data.getParcelable("data_result_receiver");
                        C3044p c3044p3 = new C3044p(message.replyTo);
                        c2782c.getClass();
                        if (TextUtils.isEmpty(string3) || resultReceiver2 == null) {
                            return;
                        }
                        ((MediaBrowserServiceCompat) c2782c.f9501b).f2575e.m2739a(new RunnableC3042n(c2782c, c3044p3, string3, bundle4, resultReceiver2));
                        return;
                    case 9:
                        Bundle bundle5 = data.getBundle("data_custom_action_extras");
                        MediaSessionCompat.ensureClassLoader(bundle5);
                        String string4 = data.getString("data_custom_action");
                        ResultReceiver resultReceiver3 = (ResultReceiver) data.getParcelable("data_result_receiver");
                        C3044p c3044p4 = new C3044p(message.replyTo);
                        c2782c.getClass();
                        if (TextUtils.isEmpty(string4) || resultReceiver3 == null) {
                            return;
                        }
                        ((MediaBrowserServiceCompat) c2782c.f9501b).f2575e.m2739a(new RunnableC3041m(c2782c, c3044p4, string4, bundle5, resultReceiver3));
                        return;
                    default:
                        android.util.Log.w("MBServiceCompat", "Unhandled message: " + message + "\n  Service version: 2\n  Client version: " + message.arg1);
                        return;
                }
            case 6:
                MyKeyBoardView.m6734a((MyKeyBoardView) this.f3193b, (View) message.obj, message.what);
                return;
            case 7:
                int i23 = message.what;
                int i24 = message.arg1;
                Object obj = message.obj;
                Bundle bundlePeekData = message.peekData();
                C3423l c3423l = (C3423l) this.f3193b;
                AbstractC3433o0 abstractC3433o0 = (AbstractC3433o0) c3423l.f11560j.get(i24);
                if (abstractC3433o0 == null) {
                    android.util.Log.w("MR2Provider", "Pending callback not found for control request.");
                    return;
                }
                c3423l.f11560j.remove(i24);
                if (i23 == 3) {
                    abstractC3433o0.mo6960b((Bundle) obj);
                    return;
                } else {
                    if (i23 != 4) {
                        return;
                    }
                    abstractC3433o0.mo6959a(bundlePeekData != null ? bundlePeekData.getString("error") : null, (Bundle) obj);
                    return;
                }
            case 8:
                int i25 = message.what;
                AbstractC3403e0 abstractC3403e0 = (AbstractC3403e0) this.f3193b;
                if (i25 != 1) {
                    if (i25 != 2) {
                        return;
                    }
                    abstractC3403e0.f11455f = false;
                    abstractC3403e0.mo6906e(abstractC3403e0.f11454e);
                    return;
                }
                abstractC3403e0.f11457h = false;
                AbstractC3928d abstractC3928d = abstractC3403e0.f11453d;
                if (abstractC3928d != null) {
                    abstractC3928d.mo6921w(abstractC3403e0, abstractC3403e0.f11456g);
                    return;
                }
                return;
            default:
                if (message.what == 1 && (iM6995c = (c3421k0 = ((MediaRouteProviderService) this.f3193b).f3442e).m6995c((Messenger) message.obj)) >= 0) {
                    C3418j0 c3418j0 = (C3418j0) c3421k0.f11539b.remove(iM6995c);
                    c3421k0.m6997e();
                    int i26 = MediaRouteProviderService.f3437f;
                    c3418j0.mo6931d();
                    return;
                }
                return;
        }
    }

    @Override
    public boolean sendMessageAtTime(Message message, long j10) {
        switch (this.f3192a) {
            case 5:
                Bundle data = message.getData();
                data.setClassLoader(MediaBrowserCompat.class.getClassLoader());
                data.putInt("data_calling_uid", Binder.getCallingUid());
                int callingPid = Binder.getCallingPid();
                if (callingPid > 0) {
                    data.putInt("data_calling_pid", callingPid);
                } else if (!data.containsKey("data_calling_pid")) {
                    data.putInt("data_calling_pid", -1);
                }
                break;
        }
        return super.sendMessageAtTime(message, j10);
    }

    public HandlerC1080c(C2909b c2909b, Looper looper, int i6) {
        super(looper);
        this.f3192a = i6;
        this.f3193b = c2909b;
    }

    public HandlerC1080c(MediaBrowserServiceCompat mediaBrowserServiceCompat) {
        this.f3192a = 5;
        this.f3193b = new C2782c(13, mediaBrowserServiceCompat);
    }

    public HandlerC1080c(C3423l c3423l) {
        super(Looper.getMainLooper());
        this.f3192a = 7;
        this.f3193b = c3423l;
    }
}
