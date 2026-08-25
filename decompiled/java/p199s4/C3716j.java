package p199s4;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.Log;
import androidx.media3.common.C0565C;
import androidx.media3.exoplayer.Renderer;
import androidx.media3.exoplayer.smoothstreaming.SsMediaSource;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaMetadata;
import com.google.android.gms.cast.MediaQueueItem;
import com.google.android.gms.cast.MediaStatus;
import com.google.android.gms.cast.framework.CastOptions;
import com.google.android.gms.cast.framework.ReconnectionService;
import com.google.android.gms.cast.framework.media.CastMediaOptions;
import com.google.android.gms.cast.framework.media.MediaIntentReceiver;
import com.google.android.gms.cast.framework.media.NotificationAction;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.internal.cast.AbstractC1722x0;
import com.google.android.gms.internal.cast.BinderC1703v;
import com.google.android.gms.internal.cast.HandlerC1731y0;
import com.p2serv.android.p032ds.R;
import java.util.ArrayList;
import p018b5.AbstractC1312l;
import p025c2.C1381b;
import p124l6.C2982h;
import p173q1.RunnableC3431n1;
import p176q4.C3473b;
import p176q4.C3474b0;
import p176q4.C3482h;
import p187r4.AbstractC3612b;
import p187r4.C3616f;
import p187r4.C3632v;
import p230v4.AbstractC3987a;
import p230v4.C3988b;

public final class C3716j {

    public static final C3988b f12448v = new C3988b("MediaSessionManager", null);

    public final Context f12449a;

    public final CastOptions f12450b;

    public final BinderC1703v f12451c;

    public final C3482h f12452d;

    public final NotificationOptions f12453e;

    public final ComponentName f12454f;

    public final ComponentName f12455g;

    public final C1381b f12456h;

    public final C1381b f12457i;

    public final C3713g f12458j;

    public final HandlerC1731y0 f12459k;

    public final RunnableC3431n1 f12460l;

    public final C3474b0 f12461m;

    public C3616f f12462n;

    public CastDevice f12463o;

    public MediaSessionCompat f12464p;

    public boolean f12465q;

    public PlaybackStateCompat.CustomAction f12466r;

    public PlaybackStateCompat.CustomAction f12467s;

    public PlaybackStateCompat.CustomAction f12468t;

    public PlaybackStateCompat.CustomAction f12469u;

    public C3716j(Context context, CastOptions castOptions, BinderC1703v binderC1703v) {
        NotificationOptions notificationOptions;
        this.f12449a = context;
        this.f12450b = castOptions;
        this.f12451c = binderC1703v;
        C3988b c3988b = C3473b.f11740k;
        AbstractC1312l.m3195b("Must be called from the main thread.");
        C3473b c3473b = C3473b.f11742m;
        C3713g c3713g = null;
        this.f12452d = c3473b != null ? c3473b.m7102a() : null;
        CastMediaOptions castMediaOptions = castOptions.f4768f;
        this.f12453e = castMediaOptions == null ? null : castMediaOptions.f4836d;
        this.f12461m = new C3474b0(2, this);
        String str = castMediaOptions == null ? null : castMediaOptions.f4834b;
        this.f12454f = !TextUtils.isEmpty(str) ? new ComponentName(context, str) : null;
        String str2 = castMediaOptions == null ? null : castMediaOptions.f4833a;
        this.f12455g = !TextUtils.isEmpty(str2) ? new ComponentName(context, str2) : null;
        C1381b c1381b = new C1381b(context);
        this.f12456h = c1381b;
        c1381b.f4202f = new C3714h(this, 0);
        C1381b c1381b2 = new C1381b(context);
        this.f12457i = c1381b2;
        c1381b2.f4202f = new C3714h(this, 1);
        this.f12459k = new HandlerC1731y0(Looper.getMainLooper(), 0);
        C3988b c3988b2 = C3713g.f12424u;
        CastMediaOptions castMediaOptions2 = castOptions.f4768f;
        if (castMediaOptions2 != null && (notificationOptions = castMediaOptions2.f4836d) != null) {
            C3632v c3632v = notificationOptions.f4852F;
            if (c3632v == null) {
                c3713g = new C3713g(context);
            } else {
                ArrayList arrayListM7482a = AbstractC3717k.m7482a(c3632v);
                int[] iArrM7483b = AbstractC3717k.m7483b(c3632v);
                int size = arrayListM7482a == null ? 0 : arrayListM7482a.size();
                C3988b c3988b3 = C3713g.f12424u;
                if (arrayListM7482a == null || arrayListM7482a.isEmpty()) {
                    Log.e(c3988b3.f13521a, c3988b3.m7977d(AbstractC3612b.class.getSimpleName().concat(" doesn't provide any action."), new Object[0]));
                } else if (arrayListM7482a.size() > 5) {
                    Log.e(c3988b3.f13521a, c3988b3.m7977d(AbstractC3612b.class.getSimpleName().concat(" provides more than 5 actions."), new Object[0]));
                } else if (iArrM7483b == null || (iArrM7483b.length) == 0) {
                    Log.e(c3988b3.f13521a, c3988b3.m7977d(AbstractC3612b.class.getSimpleName().concat(" doesn't provide any actions for compact view."), new Object[0]));
                } else {
                    for (int i6 : iArrM7483b) {
                        if (i6 < 0 || i6 >= size) {
                            Log.e(c3988b3.f13521a, c3988b3.m7977d(AbstractC3612b.class.getSimpleName().concat("provides a compact view action whose index is out of bounds."), new Object[0]));
                        }
                    }
                    c3713g = new C3713g(context);
                }
            }
        }
        this.f12458j = c3713g;
        this.f12460l = new RunnableC3431n1(1, this);
    }

    public final void m7472a(C3616f c3616f, CastDevice castDevice) {
        ComponentName componentName;
        CastOptions castOptions = this.f12450b;
        CastMediaOptions castMediaOptions = castOptions == null ? null : castOptions.f4768f;
        if (this.f12465q || castOptions == null || castMediaOptions == null || this.f12453e == null || c3616f == null || castDevice == null || (componentName = this.f12455g) == null) {
            f12448v.m7975b("skip attaching media session", new Object[0]);
            return;
        }
        this.f12462n = c3616f;
        AbstractC1312l.m3195b("Must be called from the main thread.");
        C3474b0 c3474b0 = this.f12461m;
        if (c3474b0 != null) {
            c3616f.f12155h.add(c3474b0);
        }
        this.f12463o = castDevice;
        Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
        intent.setComponent(componentName);
        int i6 = AbstractC1722x0.f5722a;
        Context context = this.f12449a;
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, intent, i6);
        if (castMediaOptions.f4838f) {
            MediaSessionCompat mediaSessionCompat = new MediaSessionCompat(context, "CastMediaSession", componentName, broadcast);
            this.f12464p = mediaSessionCompat;
            m7481j(0, null);
            CastDevice castDevice2 = this.f12463o;
            if (castDevice2 != null && !TextUtils.isEmpty(castDevice2.f4603d)) {
                mediaSessionCompat.setMetadata(new MediaMetadataCompat.Builder().putString(MediaMetadataCompat.METADATA_KEY_ALBUM_ARTIST, context.getResources().getString(R.string.cast_casting_to_device, this.f12463o.f4603d)).build());
            }
            mediaSessionCompat.setCallback(new C3715i(this));
            mediaSessionCompat.setActive(true);
            this.f12451c.m4029x(mediaSessionCompat);
        }
        this.f12465q = true;
        m7474c();
    }

    public final void m7473b(Bitmap bitmap, int i6) {
        MediaSessionCompat mediaSessionCompat = this.f12464p;
        if (mediaSessionCompat == null) {
            return;
        }
        if (bitmap == null || bitmap.getWidth() <= 1 || bitmap.getHeight() <= 1) {
            bitmap = Bitmap.createBitmap(2, 2, Bitmap.Config.ARGB_8888);
            bitmap.eraseColor(0);
        }
        MediaSessionCompat mediaSessionCompat2 = this.f12464p;
        MediaMetadataCompat metadata = mediaSessionCompat2 == null ? null : mediaSessionCompat2.getController().getMetadata();
        mediaSessionCompat.setMetadata((metadata == null ? new MediaMetadataCompat.Builder() : new MediaMetadataCompat.Builder(metadata)).putBitmap(i6 == 0 ? MediaMetadataCompat.METADATA_KEY_DISPLAY_ICON : MediaMetadataCompat.METADATA_KEY_ALBUM_ART, bitmap).build());
    }

    public final void m7474c() {
        MediaInfo mediaInfoM7301e;
        MediaMetadata mediaMetadata;
        boolean z7;
        boolean z10;
        MediaQueueItem mediaQueueItemM7300d;
        MediaInfo mediaInfo;
        C3616f c3616f = this.f12462n;
        if (c3616f == null) {
            return;
        }
        int iM7319w = c3616f.m7319w();
        MediaInfo mediaInfoM7301e2 = c3616f.m7301e();
        if (c3616f.m7308l() && (mediaQueueItemM7300d = c3616f.m7300d()) != null && (mediaInfo = mediaQueueItemM7300d.f4695a) != null) {
            mediaInfoM7301e2 = mediaInfo;
        }
        m7481j(iM7319w, mediaInfoM7301e2);
        if (!c3616f.m7305i()) {
            m7479h();
            m7480i();
            return;
        }
        if (iM7319w != 0) {
            C3713g c3713g = this.f12458j;
            if (c3713g != null) {
                f12448v.m7975b("Update media notification.", new Object[0]);
                CastDevice castDevice = this.f12463o;
                C3616f c3616f2 = this.f12462n;
                MediaSessionCompat mediaSessionCompat = this.f12464p;
                if (castDevice != null && c3616f2 != null && mediaSessionCompat != null && (mediaInfoM7301e = c3616f2.m7301e()) != null && (mediaMetadata = mediaInfoM7301e.f4641d) != null) {
                    MediaStatus mediaStatusM7302f = c3616f2.m7302f();
                    if (mediaStatusM7302f == null) {
                        z7 = false;
                        z10 = false;
                    } else {
                        int i6 = mediaStatusM7302f.f4719p;
                        if (i6 == 1 || i6 == 2 || i6 == 3) {
                            z7 = true;
                            z10 = true;
                        } else {
                            Integer num = (Integer) mediaStatusM7302f.f4727x.get(mediaStatusM7302f.f4706c);
                            if (num != null) {
                                z10 = num.intValue() > 0;
                                z7 = num.intValue() < mediaStatusM7302f.f4720q.size() + (-1);
                            } else {
                                z7 = false;
                                z10 = false;
                            }
                        }
                    }
                    boolean z11 = c3616f2.m7303g() == 2;
                    MediaMetadata.m3593j(1, "com.google.android.gms.cast.metadata.TITLE");
                    String string = mediaMetadata.f4678b.getString("com.google.android.gms.cast.metadata.TITLE");
                    MediaSessionCompat.Token sessionToken = mediaSessionCompat.getSessionToken();
                    int i10 = mediaInfoM7301e.f4639b;
                    String str = castDevice.f4603d;
                    C3712f c3712f = new C3712f(z11, i10, string, str, sessionToken, z7, z10);
                    C3712f c3712f2 = c3713g.f12435k;
                    if (c3712f2 == null || z11 != c3712f2.f12418b || i10 != c3712f2.f12419c || !AbstractC3987a.m7972e(string, c3712f2.f12420d) || !AbstractC3987a.m7972e(str, c3712f2.f12421e) || z7 != c3712f2.f12422f || z10 != c3712f2.f12423g) {
                        c3713g.f12435k = c3712f;
                        c3713g.m7471b();
                    }
                    ArrayList arrayList = mediaMetadata.f4677a;
                    C2982h c2982h = new C2982h((arrayList == null || arrayList.isEmpty()) ? null : (WebImage) arrayList.get(0));
                    C2982h c2982h2 = c3713g.f12436l;
                    Uri uri = (Uri) c2982h.f10225b;
                    if (c2982h2 == null || !AbstractC3987a.m7972e(uri, (Uri) c2982h2.f10225b)) {
                        C2982h c2982h3 = new C2982h(c3713g, 8, c2982h);
                        C1381b c1381b = c3713g.f12433i;
                        c1381b.f4202f = c2982h3;
                        c1381b.m3259i(uri);
                    }
                }
            }
            if (c3616f.m7308l()) {
                return;
            }
            m7478g(true);
        }
    }

    public final long m7475d(String str, int i6, Bundle bundle) {
        byte b8;
        long j10;
        int iHashCode = str.hashCode();
        if (iHashCode != -945151566) {
            if (iHashCode != -945080078) {
                if (iHashCode == 235550565 && str.equals(MediaIntentReceiver.ACTION_TOGGLE_PLAYBACK)) {
                    b8 = 0;
                } else {
                    b8 = -1;
                }
            } else if (str.equals(MediaIntentReceiver.ACTION_SKIP_PREV)) {
                b8 = 1;
            } else {
                b8 = -1;
            }
        } else if (str.equals(MediaIntentReceiver.ACTION_SKIP_NEXT)) {
            b8 = 2;
        } else {
            b8 = -1;
        }
        if (b8 == 0) {
            if (i6 == 3) {
                j10 = 514;
                i6 = 3;
            } else {
                j10 = 512;
            }
            if (i6 != 2) {
                return j10;
            }
            return 516L;
        }
        if (b8 == 1) {
            C3616f c3616f = this.f12462n;
            if (c3616f != null && c3616f.m7292B()) {
                return 16L;
            }
            bundle.putBoolean("android.media.playback.ALWAYS_RESERVE_SPACE_FOR.ACTION_SKIP_TO_PREVIOUS", true);
            return 0L;
        }
        if (b8 != 2) {
            return 0L;
        }
        C3616f c3616f2 = this.f12462n;
        if (c3616f2 != null && c3616f2.m7291A()) {
            return 32L;
        }
        bundle.putBoolean("android.media.playback.ALWAYS_RESERVE_SPACE_FOR.ACTION_SKIP_TO_NEXT", true);
        return 0L;
    }

    public final Uri m7476e(MediaMetadata mediaMetadata) {
        CastMediaOptions castMediaOptions = this.f12450b.f4768f;
        if (castMediaOptions != null) {
            castMediaOptions.m3622j();
        }
        ArrayList arrayList = mediaMetadata.f4677a;
        WebImage webImage = arrayList != null && !arrayList.isEmpty() ? (WebImage) mediaMetadata.f4677a.get(0) : null;
        if (webImage == null) {
            return null;
        }
        return webImage.f5023b;
    }

    public final void m7477f(PlaybackStateCompat.Builder builder, String str, NotificationAction notificationAction) {
        byte b8;
        PlaybackStateCompat.CustomAction customActionBuild;
        long j10;
        int i6;
        int i10;
        long j11;
        int i11;
        int i12;
        switch (str) {
            case "com.google.android.gms.cast.framework.action.REWIND":
                b8 = 1;
                break;
            case "com.google.android.gms.cast.framework.action.STOP_CASTING":
                b8 = 2;
                break;
            case "com.google.android.gms.cast.framework.action.DISCONNECT":
                b8 = 3;
                break;
            case "com.google.android.gms.cast.framework.action.FORWARD":
                b8 = 0;
                break;
            default:
                b8 = -1;
                break;
        }
        Context context = this.f12449a;
        NotificationOptions notificationOptions = this.f12453e;
        if (b8 == 0) {
            if (this.f12466r == null && notificationOptions != null) {
                C3988b c3988b = AbstractC3717k.f12470a;
                long j12 = notificationOptions.f4857c;
                if (j12 == Renderer.DEFAULT_DURATION_TO_PROGRESS_US) {
                    i6 = notificationOptions.f4880z;
                    j10 = SsMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_MS;
                } else {
                    j10 = SsMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_MS;
                    i6 = j12 != SsMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_MS ? notificationOptions.f4879y : notificationOptions.f4847A;
                }
                if (j12 == Renderer.DEFAULT_DURATION_TO_PROGRESS_US) {
                    i10 = notificationOptions.f4866l;
                } else {
                    i10 = j12 != j10 ? notificationOptions.f4865k : notificationOptions.f4867m;
                }
                this.f12466r = new PlaybackStateCompat.CustomAction.Builder(MediaIntentReceiver.ACTION_FORWARD, context.getResources().getString(i6), i10).build();
            }
            customActionBuild = this.f12466r;
        } else if (b8 == 1) {
            if (this.f12467s == null && notificationOptions != null) {
                C3988b c3988b2 = AbstractC3717k.f12470a;
                long j13 = notificationOptions.f4857c;
                if (j13 == Renderer.DEFAULT_DURATION_TO_PROGRESS_US) {
                    i11 = notificationOptions.f4849C;
                    j11 = SsMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_MS;
                } else {
                    j11 = SsMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_MS;
                    i11 = j13 != SsMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_MS ? notificationOptions.f4848B : notificationOptions.f4850D;
                }
                if (j13 == Renderer.DEFAULT_DURATION_TO_PROGRESS_US) {
                    i12 = notificationOptions.f4869o;
                } else {
                    i12 = j13 != j11 ? notificationOptions.f4868n : notificationOptions.f4870p;
                }
                this.f12467s = new PlaybackStateCompat.CustomAction.Builder(MediaIntentReceiver.ACTION_REWIND, context.getResources().getString(i11), i12).build();
            }
            customActionBuild = this.f12467s;
        } else if (b8 == 2) {
            if (this.f12468t == null && notificationOptions != null) {
                this.f12468t = new PlaybackStateCompat.CustomAction.Builder(MediaIntentReceiver.ACTION_STOP_CASTING, context.getResources().getString(notificationOptions.f4851E), notificationOptions.f4871q).build();
            }
            customActionBuild = this.f12468t;
        } else if (b8 != 3) {
            customActionBuild = notificationAction != null ? new PlaybackStateCompat.CustomAction.Builder(str, notificationAction.f4844c, notificationAction.f4843b).build() : null;
        } else {
            if (this.f12469u == null && notificationOptions != null) {
                this.f12469u = new PlaybackStateCompat.CustomAction.Builder(MediaIntentReceiver.ACTION_DISCONNECT, context.getResources().getString(notificationOptions.f4851E), notificationOptions.f4871q).build();
            }
            customActionBuild = this.f12469u;
        }
        if (customActionBuild != null) {
            builder.addCustomAction(customActionBuild);
        }
    }

    public final void m7478g(boolean z7) {
        if (this.f12450b.f4769g) {
            RunnableC3431n1 runnableC3431n1 = this.f12460l;
            HandlerC1731y0 handlerC1731y0 = this.f12459k;
            if (runnableC3431n1 != null) {
                handlerC1731y0.removeCallbacks(runnableC3431n1);
            }
            Context context = this.f12449a;
            Intent intent = new Intent(context, (Class<?>) ReconnectionService.class);
            intent.setPackage(context.getPackageName());
            try {
                context.startService(intent);
            } catch (IllegalStateException unused) {
                if (z7) {
                    handlerC1731y0.postDelayed(runnableC3431n1, 1000L);
                }
            }
        }
    }

    public final void m7479h() {
        C3713g c3713g = this.f12458j;
        if (c3713g != null) {
            f12448v.m7975b("Stopping media notification.", new Object[0]);
            C1381b c1381b = c3713g.f12433i;
            c1381b.m3260j();
            c1381b.f4202f = null;
            NotificationManager notificationManager = c3713g.f12426b;
            if (notificationManager != null) {
                notificationManager.cancel("castMediaNotification", 1);
            }
        }
    }

    public final void m7480i() {
        if (this.f12450b.f4769g) {
            this.f12459k.removeCallbacks(this.f12460l);
            Context context = this.f12449a;
            Intent intent = new Intent(context, (Class<?>) ReconnectionService.class);
            intent.setPackage(context.getPackageName());
            context.stopService(intent);
        }
    }

    public final void m7481j(int i6, MediaInfo mediaInfo) {
        PlaybackStateCompat playbackStateCompatBuild;
        MediaSessionCompat mediaSessionCompat;
        MediaMetadata mediaMetadata;
        PendingIntent activity;
        MediaSessionCompat mediaSessionCompat2 = this.f12464p;
        if (mediaSessionCompat2 == null) {
            return;
        }
        Bundle bundle = new Bundle();
        PlaybackStateCompat.Builder builder = new PlaybackStateCompat.Builder();
        C3616f c3616f = this.f12462n;
        NotificationOptions notificationOptions = this.f12453e;
        if (c3616f == null || this.f12458j == null) {
            playbackStateCompatBuild = builder.build();
        } else {
            builder.setState(i6, (c3616f.m7319w() == 0 || c3616f.m7307k()) ? 0L : c3616f.m7299c(), 1.0f);
            if (i6 == 0) {
                playbackStateCompatBuild = builder.build();
            } else {
                C3632v c3632v = notificationOptions != null ? notificationOptions.f4852F : null;
                C3616f c3616f2 = this.f12462n;
                long jM7475d = (c3616f2 == null || c3616f2.m7307k() || this.f12462n.m7311o()) ? 0L : 256L;
                if (c3632v != null) {
                    ArrayList<NotificationAction> arrayListM7482a = AbstractC3717k.m7482a(c3632v);
                    if (arrayListM7482a != null) {
                        for (NotificationAction notificationAction : arrayListM7482a) {
                            String str = notificationAction.f4842a;
                            if (TextUtils.equals(str, MediaIntentReceiver.ACTION_TOGGLE_PLAYBACK) || TextUtils.equals(str, MediaIntentReceiver.ACTION_SKIP_PREV) || TextUtils.equals(str, MediaIntentReceiver.ACTION_SKIP_NEXT)) {
                                jM7475d = m7475d(str, i6, bundle) | jM7475d;
                            } else {
                                m7477f(builder, str, notificationAction);
                            }
                        }
                    }
                } else if (notificationOptions != null) {
                    for (String str2 : notificationOptions.f4855a) {
                        if (TextUtils.equals(str2, MediaIntentReceiver.ACTION_TOGGLE_PLAYBACK) || TextUtils.equals(str2, MediaIntentReceiver.ACTION_SKIP_PREV) || TextUtils.equals(str2, MediaIntentReceiver.ACTION_SKIP_NEXT)) {
                            jM7475d = m7475d(str2, i6, bundle) | jM7475d;
                        } else {
                            m7477f(builder, str2, null);
                        }
                    }
                }
                playbackStateCompatBuild = builder.setActions(jM7475d).build();
            }
        }
        mediaSessionCompat2.setPlaybackState(playbackStateCompatBuild);
        if (notificationOptions != null && notificationOptions.f4853G) {
            bundle.putBoolean("android.media.playback.ALWAYS_RESERVE_SPACE_FOR.ACTION_SKIP_TO_PREVIOUS", true);
        }
        if (notificationOptions != null && notificationOptions.f4854H) {
            bundle.putBoolean("android.media.playback.ALWAYS_RESERVE_SPACE_FOR.ACTION_SKIP_TO_NEXT", true);
        }
        if (bundle.containsKey("android.media.playback.ALWAYS_RESERVE_SPACE_FOR.ACTION_SKIP_TO_PREVIOUS") || bundle.containsKey("android.media.playback.ALWAYS_RESERVE_SPACE_FOR.ACTION_SKIP_TO_NEXT")) {
            mediaSessionCompat2.setExtras(bundle);
        }
        if (i6 == 0) {
            mediaSessionCompat2.setMetadata(new MediaMetadataCompat.Builder().build());
            return;
        }
        if (this.f12462n != null) {
            ComponentName componentName = this.f12454f;
            if (componentName == null) {
                activity = null;
            } else {
                Intent intent = new Intent();
                intent.setComponent(componentName);
                activity = PendingIntent.getActivity(this.f12449a, 0, intent, AbstractC1722x0.f5722a | C0565C.BUFFER_FLAG_FIRST_SAMPLE);
            }
            if (activity != null) {
                mediaSessionCompat2.setSessionActivity(activity);
            }
        }
        C3616f c3616f3 = this.f12462n;
        if (c3616f3 == null || (mediaSessionCompat = this.f12464p) == null || mediaInfo == null || (mediaMetadata = mediaInfo.f4641d) == null) {
            return;
        }
        long j10 = c3616f3.m7307k() ? 0L : mediaInfo.f4642e;
        MediaMetadata.m3593j(1, "com.google.android.gms.cast.metadata.TITLE");
        Bundle bundle2 = mediaMetadata.f4678b;
        String string = bundle2.getString("com.google.android.gms.cast.metadata.TITLE");
        MediaMetadata.m3593j(1, "com.google.android.gms.cast.metadata.SUBTITLE");
        String string2 = bundle2.getString("com.google.android.gms.cast.metadata.SUBTITLE");
        MediaSessionCompat mediaSessionCompat3 = this.f12464p;
        MediaMetadataCompat metadata = mediaSessionCompat3 == null ? null : mediaSessionCompat3.getController().getMetadata();
        MediaMetadataCompat.Builder builderPutLong = (metadata == null ? new MediaMetadataCompat.Builder() : new MediaMetadataCompat.Builder(metadata)).putLong(MediaMetadataCompat.METADATA_KEY_DURATION, j10);
        if (string != null) {
            builderPutLong.putString(MediaMetadataCompat.METADATA_KEY_TITLE, string);
            builderPutLong.putString(MediaMetadataCompat.METADATA_KEY_DISPLAY_TITLE, string);
        }
        if (string2 != null) {
            builderPutLong.putString(MediaMetadataCompat.METADATA_KEY_DISPLAY_SUBTITLE, string2);
        }
        mediaSessionCompat.setMetadata(builderPutLong.build());
        Uri uriM7476e = m7476e(mediaMetadata);
        if (uriM7476e != null) {
            this.f12456h.m3259i(uriM7476e);
        } else {
            m7473b(null, 0);
        }
        Uri uriM7476e2 = m7476e(mediaMetadata);
        if (uriM7476e2 != null) {
            this.f12457i.m3259i(uriM7476e2);
        } else {
            m7473b(null, 3);
        }
    }
}
