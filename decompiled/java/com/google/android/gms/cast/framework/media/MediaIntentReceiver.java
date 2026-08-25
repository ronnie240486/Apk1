package com.google.android.gms.cast.framework.media;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import androidx.annotation.Keep;
import p018b5.AbstractC1312l;
import p176q4.AbstractC3481g;
import p176q4.C3473b;
import p176q4.C3475c;
import p176q4.C3482h;
import p187r4.C3616f;
import p230v4.C3988b;

@Keep
public class MediaIntentReceiver extends BroadcastReceiver {
    public static final String ACTION_DISCONNECT = "com.google.android.gms.cast.framework.action.DISCONNECT";
    public static final String ACTION_FORWARD = "com.google.android.gms.cast.framework.action.FORWARD";
    public static final String ACTION_REWIND = "com.google.android.gms.cast.framework.action.REWIND";
    public static final String ACTION_SKIP_NEXT = "com.google.android.gms.cast.framework.action.SKIP_NEXT";
    public static final String ACTION_SKIP_PREV = "com.google.android.gms.cast.framework.action.SKIP_PREV";
    public static final String ACTION_STOP_CASTING = "com.google.android.gms.cast.framework.action.STOP_CASTING";
    public static final String ACTION_TOGGLE_PLAYBACK = "com.google.android.gms.cast.framework.action.TOGGLE_PLAYBACK";
    public static final String EXTRA_SKIP_STEP_MS = "googlecast-extra_skip_step_ms";
    private static final String TAG = "MediaIntentReceiver";
    private static final C3988b log = new C3988b(TAG, null);

    private static C3616f getRemoteMediaClient(C3475c c3475c) {
        if (c3475c == null || !c3475c.m7136a()) {
            return null;
        }
        return c3475c.m7125f();
    }

    private void seek(C3475c c3475c, long j10) {
        C3616f remoteMediaClient;
        if (j10 == 0 || (remoteMediaClient = getRemoteMediaClient(c3475c)) == null || remoteMediaClient.m7307k() || remoteMediaClient.m7311o()) {
            return;
        }
        remoteMediaClient.m7317u(remoteMediaClient.m7299c() + j10);
    }

    private void togglePlayback(C3475c c3475c) {
        C3616f remoteMediaClient = getRemoteMediaClient(c3475c);
        if (remoteMediaClient == null) {
            return;
        }
        remoteMediaClient.m7318v();
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        C3482h c3482hM7102a;
        AbstractC3481g abstractC3481gM7143d;
        String action = intent.getAction();
        log.m7975b("onReceive action: %s", action);
        if (action == null || (abstractC3481gM7143d = (c3482hM7102a = C3473b.m7099b(context).m7102a()).m7143d()) == null) {
            return;
        }
        switch (action) {
            case "com.google.android.gms.cast.framework.action.TOGGLE_PLAYBACK":
                onReceiveActionTogglePlayback(abstractC3481gM7143d);
                break;
            case "com.google.android.gms.cast.framework.action.SKIP_NEXT":
                onReceiveActionSkipNext(abstractC3481gM7143d);
                break;
            case "com.google.android.gms.cast.framework.action.SKIP_PREV":
                onReceiveActionSkipPrev(abstractC3481gM7143d);
                break;
            case "com.google.android.gms.cast.framework.action.FORWARD":
                onReceiveActionForward(abstractC3481gM7143d, intent.getLongExtra(EXTRA_SKIP_STEP_MS, 0L));
                break;
            case "com.google.android.gms.cast.framework.action.REWIND":
                onReceiveActionRewind(abstractC3481gM7143d, intent.getLongExtra(EXTRA_SKIP_STEP_MS, 0L));
                break;
            case "com.google.android.gms.cast.framework.action.STOP_CASTING":
                c3482hM7102a.m7141b(true);
                break;
            case "com.google.android.gms.cast.framework.action.DISCONNECT":
                c3482hM7102a.m7141b(false);
                break;
            case "android.intent.action.MEDIA_BUTTON":
                onReceiveActionMediaButton(abstractC3481gM7143d, intent);
                break;
            default:
                onReceiveOtherAction(context, action, intent);
                break;
        }
    }

    public void onReceiveActionForward(AbstractC3481g abstractC3481g, long j10) {
        if (abstractC3481g instanceof C3475c) {
            seek((C3475c) abstractC3481g, j10);
        }
    }

    public void onReceiveActionMediaButton(AbstractC3481g abstractC3481g, Intent intent) {
        if ((abstractC3481g instanceof C3475c) && intent.hasExtra("android.intent.extra.KEY_EVENT")) {
            Bundle extras = intent.getExtras();
            AbstractC1312l.m3198e(extras);
            KeyEvent keyEvent = (KeyEvent) extras.get("android.intent.extra.KEY_EVENT");
            if (keyEvent != null && keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 85) {
                togglePlayback((C3475c) abstractC3481g);
            }
        }
    }

    public void onReceiveActionRewind(AbstractC3481g abstractC3481g, long j10) {
        if (abstractC3481g instanceof C3475c) {
            seek((C3475c) abstractC3481g, -j10);
        }
    }

    public void onReceiveActionSkipNext(AbstractC3481g abstractC3481g) {
        C3616f remoteMediaClient;
        if (!(abstractC3481g instanceof C3475c) || (remoteMediaClient = getRemoteMediaClient((C3475c) abstractC3481g)) == null || remoteMediaClient.m7311o()) {
            return;
        }
        remoteMediaClient.m7313q();
    }

    public void onReceiveActionSkipPrev(AbstractC3481g abstractC3481g) {
        C3616f remoteMediaClient;
        if (!(abstractC3481g instanceof C3475c) || (remoteMediaClient = getRemoteMediaClient((C3475c) abstractC3481g)) == null || remoteMediaClient.m7311o()) {
            return;
        }
        remoteMediaClient.m7314r();
    }

    public void onReceiveActionTogglePlayback(AbstractC3481g abstractC3481g) {
        if (abstractC3481g instanceof C3475c) {
            togglePlayback((C3475c) abstractC3481g);
        }
    }

    public void onReceiveOtherAction(Context context, String str, Intent intent) {
    }

    @Deprecated
    public void onReceiveOtherAction(String str, Intent intent) {
        onReceiveOtherAction(null, str, intent);
    }
}
