package p199s4;

import android.app.BroadcastOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.media.session.MediaSessionCompat;
import android.view.KeyEvent;
import p165p4.C3362g;
import p176q4.C3482h;
import p187r4.C3616f;

public final class C3715i extends MediaSessionCompat.Callback {

    public final C3716j f12447a;

    public C3715i(C3716j c3716j) {
        this.f12447a = c3716j;
    }

    @Override
    public final void onCustomAction(String str, Bundle bundle) {
        byte b8;
        C3716j.f12448v.m7975b("onCustomAction with action = %s", str);
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
        C3716j c3716j = this.f12447a;
        if (b8 == 0) {
            long j10 = c3716j.f12453e.f4857c;
            C3616f c3616f = c3716j.f12462n;
            if (c3616f == null) {
                return;
            }
            long jMin = Math.min(c3616f.m7304h(), Math.max(0L, c3616f.m7299c() + j10));
            C3616f c3616f2 = c3716j.f12462n;
            if (c3616f2 == null) {
                return;
            }
            c3616f2.m7316t(new C3362g(jMin, false));
            return;
        }
        if (b8 == 1) {
            long j11 = -c3716j.f12453e.f4857c;
            C3616f c3616f3 = c3716j.f12462n;
            if (c3616f3 == null) {
                return;
            }
            long jMin2 = Math.min(c3616f3.m7304h(), Math.max(0L, c3616f3.m7299c() + j11));
            C3616f c3616f4 = c3716j.f12462n;
            if (c3616f4 == null) {
                return;
            }
            c3616f4.m7316t(new C3362g(jMin2, false));
            return;
        }
        if (b8 == 2) {
            C3482h c3482h = c3716j.f12452d;
            if (c3482h != null) {
                c3482h.m7141b(true);
                return;
            }
            return;
        }
        if (b8 == 3) {
            C3482h c3482h2 = c3716j.f12452d;
            if (c3482h2 != null) {
                c3482h2.m7141b(false);
                return;
            }
            return;
        }
        Intent intent = new Intent(str);
        intent.setComponent(c3716j.f12455g);
        int i6 = Build.VERSION.SDK_INT;
        Context context = c3716j.f12449a;
        if (i6 < 34) {
            context.sendBroadcast(intent);
        } else {
            context.sendBroadcast(intent, null, BroadcastOptions.makeBasic().setShareIdentityEnabled(true).toBundle());
        }
    }

    @Override
    public final boolean onMediaButtonEvent(Intent intent) {
        C3616f c3616f;
        C3716j.f12448v.m7975b("onMediaButtonEvent", new Object[0]);
        KeyEvent keyEvent = (KeyEvent) intent.getParcelableExtra("android.intent.extra.KEY_EVENT");
        if (keyEvent == null) {
            return true;
        }
        if ((keyEvent.getKeyCode() != 127 && keyEvent.getKeyCode() != 126) || (c3616f = this.f12447a.f12462n) == null) {
            return true;
        }
        c3616f.m7318v();
        return true;
    }

    @Override
    public final void onPause() {
        C3716j.f12448v.m7975b("onPause", new Object[0]);
        C3616f c3616f = this.f12447a.f12462n;
        if (c3616f != null) {
            c3616f.m7318v();
        }
    }

    @Override
    public final void onPlay() {
        C3716j.f12448v.m7975b("onPlay", new Object[0]);
        C3616f c3616f = this.f12447a.f12462n;
        if (c3616f != null) {
            c3616f.m7318v();
        }
    }

    @Override
    public final void onSeekTo(long j10) {
        C3716j.f12448v.m7975b("onSeekTo %d", Long.valueOf(j10));
        C3616f c3616f = this.f12447a.f12462n;
        if (c3616f == null) {
            return;
        }
        c3616f.m7316t(new C3362g(j10, false));
    }

    @Override
    public final void onSkipToNext() {
        C3716j.f12448v.m7975b("onSkipToNext", new Object[0]);
        C3616f c3616f = this.f12447a.f12462n;
        if (c3616f != null) {
            c3616f.m7313q();
        }
    }

    @Override
    public final void onSkipToPrevious() {
        C3716j.f12448v.m7975b("onSkipToPrevious", new Object[0]);
        C3616f c3616f = this.f12447a.f12462n;
        if (c3616f != null) {
            c3616f.m7314r();
        }
    }
}
