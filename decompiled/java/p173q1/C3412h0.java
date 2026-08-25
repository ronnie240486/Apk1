package p173q1;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.MediaRoute2Info;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Messenger;
import android.text.TextUtils;
import androidx.appcompat.app.C0157r0;
import androidx.media3.common.C0628x;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import androidx.mediarouter.app.AbstractC1115t0;
import androidx.mediarouter.media.MediaRouteProviderService;
import com.lzy.okgo.model.Progress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import p160p.C3337a;
import p160p.C3340d;
import p160p.C3341e;

public final class C3412h0 extends C3421k0 {

    public C3452v f11514i;

    public final C0628x f11515j;

    public C3412h0(MediaRouteProviderService mediaRouteProviderService) {
        super(mediaRouteProviderService);
        this.f11515j = new C0628x(18, this);
    }

    @Override
    public final void mo6950a(Context context) {
        C3452v c3452v = this.f11514i;
        if (c3452v != null) {
            c3452v.attachBaseContext(context);
        }
    }

    @Override
    public final C3418j0 mo6951b(Messenger messenger, int i6, String str) {
        return new C3409g0(this, messenger, i6, str);
    }

    @Override
    public final IBinder mo6952f(Intent intent) {
        MediaRouteProviderService mediaRouteProviderService = this.f11538a;
        mediaRouteProviderService.m2807b();
        if (this.f11514i == null) {
            this.f11514i = new C3452v(this);
            if (mediaRouteProviderService.getBaseContext() != null) {
                this.f11514i.attachBaseContext(mediaRouteProviderService);
            }
        }
        IBinder iBinderMo6952f = super.mo6952f(intent);
        return iBinderMo6952f != null ? iBinderMo6952f : this.f11514i.onBind(intent);
    }

    @Override
    public final void mo6953g(C0157r0 c0157r0) {
        MediaRoute2Info mediaRoute2InfoBuild;
        int i6;
        int i10 = 0;
        super.mo6953g(c0157r0);
        C3452v c3452v = this.f11514i;
        c3452v.f11695e = c0157r0;
        List<C3454w> listEmptyList = c0157r0 == null ? Collections.emptyList() : (List) c0157r0.f429c;
        C3341e c3341e = new C3341e(0);
        for (C3454w c3454w : listEmptyList) {
            if (c3454w != null) {
                c3341e.put(c3454w.m7089f(), c3454w);
            }
        }
        ArrayList<C3450u> arrayList = new ArrayList();
        synchronized (c3452v.f11691a) {
            try {
                Iterator it = ((C3340d) c3452v.f11693c.values()).iterator();
                while (true) {
                    C3337a c3337a = (C3337a) it;
                    if (!c3337a.hasNext()) {
                        break;
                    }
                    C3450u c3450u = (C3450u) c3337a.next();
                    if ((c3450u.f11679d & 4) == 0) {
                        arrayList.add(c3450u);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        for (C3450u c3450u2 : arrayList) {
            C3441r c3441r = (C3441r) c3450u2.f11677b;
            if (c3341e.containsKey(c3441r.f11641f)) {
                c3450u2.m7066d((C3454w) c3341e.get(c3441r.f11641f), null);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it2 = ((C3340d) c3341e.values()).iterator();
        while (true) {
            C3337a c3337a2 = (C3337a) it2;
            if (!c3337a2.hasNext()) {
                c3452v.notifyRoutes(arrayList2);
                return;
            }
            C3454w c3454w2 = (C3454w) c3337a2.next();
            if (c3454w2 == null || TextUtils.isEmpty(c3454w2.m7089f()) || TextUtils.isEmpty(c3454w2.m7090g())) {
                mediaRoute2InfoBuild = null;
            } else {
                AbstractC3447t.m7046l();
                MediaRoute2Info.Builder volumeMax = AbstractC3447t.m7040f(c3454w2.m7089f(), c3454w2.m7090g()).setDescription(c3454w2.f11701a.getString(Progress.STATUS)).setConnectionState(c3454w2.f11701a.getInt("connectionState", i10)).setVolumeHandling(c3454w2.m7092i()).setVolume(c3454w2.m7091h()).setVolumeMax(c3454w2.m7093j());
                ArrayList<IntentFilter> arrayListM7085b = c3454w2.m7085b();
                HashSet hashSet = new HashSet();
                for (IntentFilter intentFilter : arrayListM7085b) {
                    int iCountCategories = intentFilter.countCategories();
                    for (int i11 = 0; i11 < iCountCategories; i11++) {
                        String category = intentFilter.getCategory(i11);
                        category.getClass();
                        switch (category) {
                            case "android.media.intent.category.REMOTE_PLAYBACK":
                                category = "android.media.route.feature.REMOTE_PLAYBACK";
                                break;
                            case "android.media.intent.category.LIVE_AUDIO":
                                category = "android.media.route.feature.LIVE_AUDIO";
                                break;
                            case "android.media.intent.category.LIVE_VIDEO":
                                category = "android.media.route.feature.LIVE_VIDEO";
                                break;
                            case "android.media.intent.category.REMOTE_AUDIO_PLAYBACK":
                                category = "android.media.route.feature.REMOTE_AUDIO_PLAYBACK";
                                break;
                            case "android.media.intent.category.REMOTE_VIDEO_PLAYBACK":
                                category = "android.media.route.feature.REMOTE_VIDEO_PLAYBACK";
                                break;
                        }
                        hashSet.add(category);
                    }
                }
                MediaRoute2Info.Builder iconUri = volumeMax.addFeatures(hashSet).setIconUri(c3454w2.m7088e());
                if (Build.VERSION.SDK_INT >= 34) {
                    ArrayList<String> stringArrayList = c3454w2.f11701a.getStringArrayList("deduplicationIds");
                    AbstractC1115t0.m2785d(iconUri, stringArrayList != null ? Collections.unmodifiableSet(new HashSet(stringArrayList)) : Collections.emptySet());
                    AbstractC1115t0.m2782a(iconUri, c3454w2);
                    int iM7086c = c3454w2.m7086c();
                    if (iM7086c != 1000) {
                        switch (iM7086c) {
                            case 1:
                                i6 = 1001;
                                break;
                            case 2:
                                i6 = 1002;
                                break;
                            case 3:
                                i6 = 8;
                                break;
                            case 4:
                                i6 = 1003;
                                break;
                            case 5:
                                i6 = 1004;
                                break;
                            case 6:
                                i6 = 1005;
                                break;
                            case 7:
                                i6 = AnalyticsListener.EVENT_BANDWIDTH_ESTIMATE;
                                break;
                            case 8:
                                i6 = AnalyticsListener.EVENT_AUDIO_ENABLED;
                                break;
                            case 9:
                                i6 = AnalyticsListener.EVENT_AUDIO_DECODER_INITIALIZED;
                                break;
                            case 10:
                                i6 = AnalyticsListener.EVENT_AUDIO_INPUT_FORMAT_CHANGED;
                                break;
                            case 11:
                                i6 = AnalyticsListener.EVENT_AUDIO_POSITION_ADVANCING;
                                break;
                            case 12:
                                i6 = 2;
                                break;
                            case 13:
                                i6 = 3;
                                break;
                            case 14:
                                i6 = 4;
                                break;
                            default:
                                switch (iM7086c) {
                                    case 16:
                                        i6 = 9;
                                        break;
                                    case 17:
                                        i6 = 11;
                                        break;
                                    case 18:
                                        i6 = 12;
                                        break;
                                    case 19:
                                        i6 = 13;
                                        break;
                                    case 20:
                                        i6 = 22;
                                        break;
                                    case 21:
                                        i6 = 23;
                                        break;
                                    case 22:
                                        i6 = 26;
                                        break;
                                    case 23:
                                        i6 = 10;
                                        break;
                                    case 24:
                                        i6 = 29;
                                        break;
                                    default:
                                        i6 = 0;
                                        break;
                                }
                                break;
                        }
                    } else {
                        i6 = 2000;
                    }
                    AbstractC1115t0.m2786e(iconUri, i6);
                }
                int iM7086c2 = c3454w2.m7086c();
                if (iM7086c2 != 1) {
                    if (iM7086c2 == 2) {
                    }
                    if (!c3454w2.m7087d().isEmpty()) {
                        iconUri.addFeature("android.media.route.feature.REMOTE_GROUP_PLAYBACK");
                    }
                    Bundle bundle = new Bundle();
                    bundle.putBundle("androidx.mediarouter.media.KEY_EXTRAS", c3454w2.f11701a.getBundle("extras"));
                    bundle.putParcelableArrayList("androidx.mediarouter.media.KEY_CONTROL_FILTERS", new ArrayList<>(c3454w2.m7085b()));
                    bundle.putInt("androidx.mediarouter.media.KEY_DEVICE_TYPE", c3454w2.m7086c());
                    bundle.putInt("androidx.mediarouter.media.KEY_PLAYBACK_TYPE", c3454w2.f11701a.getInt("playbackType", 1));
                    bundle.putString("androidx.mediarouter.media.KEY_ORIGINAL_ROUTE_ID", c3454w2.m7089f());
                    iconUri.setExtras(bundle);
                    if (c3454w2.m7085b().isEmpty()) {
                        iconUri.addFeature("android.media.route.feature.EMPTY");
                    }
                    mediaRoute2InfoBuild = iconUri.build();
                } else {
                    iconUri.addFeature("android.media.route.feature.REMOTE_VIDEO_PLAYBACK");
                }
                iconUri.addFeature("android.media.route.feature.REMOTE_AUDIO_PLAYBACK");
                if (!c3454w2.m7087d().isEmpty()) {
                    iconUri.addFeature("android.media.route.feature.REMOTE_GROUP_PLAYBACK");
                }
                Bundle bundle2 = new Bundle();
                bundle2.putBundle("androidx.mediarouter.media.KEY_EXTRAS", c3454w2.f11701a.getBundle("extras"));
                bundle2.putParcelableArrayList("androidx.mediarouter.media.KEY_CONTROL_FILTERS", new ArrayList<>(c3454w2.m7085b()));
                bundle2.putInt("androidx.mediarouter.media.KEY_DEVICE_TYPE", c3454w2.m7086c());
                bundle2.putInt("androidx.mediarouter.media.KEY_PLAYBACK_TYPE", c3454w2.f11701a.getInt("playbackType", 1));
                bundle2.putString("androidx.mediarouter.media.KEY_ORIGINAL_ROUTE_ID", c3454w2.m7089f());
                iconUri.setExtras(bundle2);
                if (c3454w2.m7085b().isEmpty()) {
                    iconUri.addFeature("android.media.route.feature.EMPTY");
                }
                mediaRoute2InfoBuild = iconUri.build();
            }
            if (mediaRoute2InfoBuild != null) {
                arrayList2.add(mediaRoute2InfoBuild);
            }
            i10 = 0;
        }
    }
}
