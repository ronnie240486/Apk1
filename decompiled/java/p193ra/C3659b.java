package p193ra;

import android.net.Uri;
import androidx.media3.common.MediaItem;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.p011ui.PlayerView;
import java.util.HashMap;
import p003a2.AbstractC0032a;
import p156o9.AbstractC3280d;

public final class C3659b implements InterfaceC3658a {

    public ExoPlayer f12257a;

    public PlayerView f12258b;

    static {
        AbstractC0032a.m165s("kkug+uURDMymV5c=\n", "3zLlgopBYK0=\n");
    }

    @Override
    public final void mo7405a() {
        this.f12257a.clearMediaItems();
        AbstractC0032a.m165s("aKZvQbTQ\n", "G84ANo7wMUc=\n");
        this.f12258b.setVisibility(0);
    }

    @Override
    public final void mo7406b() {
        AbstractC0032a.m165s("YUOgYyTmNFtVX5c7OdMsSFUAxStlhg==\n", "LDrlG0u2WDo=\n");
        ExoPlayer exoPlayer = this.f12257a;
        MediaItem currentMediaItem = exoPlayer.getCurrentMediaItem();
        if (currentMediaItem == null) {
            return;
        }
        AbstractC0032a.m165s("C9FoL8ntIhc/zV931Ng6BD+SDWeIjG4=\n", "RqgtV6a9TnY=\n");
        exoPlayer.setMediaItem(currentMediaItem);
        exoPlayer.prepare();
        exoPlayer.setPlayWhenReady(true);
        AbstractC0032a.m165s("bPYB9AogKUowolU=\n", "HpN1hnMaCXs=\n");
    }

    @Override
    public final void mo7407c() {
        AbstractC0032a.m165s("/2nIWL/F0F3ufMRD1YlWjTY=\n", "jB2nKO+psSQ=\n");
    }

    @Override
    public final void mo7408d() {
        this.f12257a.setPlayWhenReady(true);
    }

    @Override
    public final void mo7409e() {
        AbstractC0032a.m165s("eDYVSBnv\n", "C0J6OCPPk5o=\n");
        this.f12257a.stop();
    }

    @Override
    public final void mo7410f() {
        AbstractC3280d.m6606y(this.f12258b);
    }

    @Override
    public final void mo7411g(Uri uri, HashMap map) {
        AbstractC0032a.m165s("woMYy3WJyPHktCWnPAoEJA==\n", "seZsnRztrZ4=\n");
    }

    @Override
    public final int getBufferedPercentage() {
        return this.f12257a.getBufferedPercentage();
    }

    @Override
    public final long getCurrentPosition() {
        return this.f12257a.getCurrentPosition();
    }

    @Override
    public final long getDuration() {
        return this.f12257a.getDuration();
    }

    @Override
    public final boolean getPlayWhenReady() {
        return this.f12257a.getPlayWhenReady();
    }

    @Override
    public final void mo7412h(String str) {
        AbstractC0032a.m165s("uvb9huo6ZEmZ8v24uX7mj3M=\n", "yZOJ0INeASY=\n");
    }

    @Override
    public final boolean mo7413i(int i6) {
        PlayerView playerView = this.f12258b;
        return playerView != null && i6 == playerView.getId();
    }

    @Override
    public final boolean isPlaying() {
        ExoPlayer exoPlayer = this.f12257a;
        return exoPlayer.getPlayWhenReady() && (exoPlayer.getPlaybackState() == 3 || exoPlayer.getPlaybackState() == 2);
    }

    @Override
    public final boolean isVisible() {
        AbstractC0032a.m165s("6wAkRPbbITznSVI=\n", "gnNyLYWyQ1A=\n");
        return this.f12258b.getVisibility() == 0;
    }

    @Override
    public final void mo7414j() {
        AbstractC0032a.m165s("I5+3SkCR\n", "S/bTL3qxJFg=\n");
        this.f12258b.setVisibility(8);
    }

    @Override
    public final void pause() {
        this.f12257a.setPlayWhenReady(false);
    }

    @Override
    public final void prepare() {
        AbstractC0032a.m165s("UKIGuZh04YwA\n", "INBjyfkGhLY=\n");
        this.f12257a.prepare();
    }

    @Override
    public final void release() {
        AbstractC0032a.m165s("NaxBZa8MDNRn\n", "R8ktAM5/ae4=\n");
        this.f12257a.release();
    }

    @Override
    public final void seekTo(long j10) {
        this.f12257a.seekTo(j10);
    }

    @Override
    public final void setPlayWhenReady(boolean z7) {
        this.f12257a.setPlayWhenReady(z7);
    }

    @Override
    public final void start() {
        this.f12257a.setPlayWhenReady(true);
    }

    @Override
    public final void stop() {
        AbstractC0032a.m165s("FKkBncoX\n", "Z91u7fA3szw=\n");
        this.f12257a.stop();
    }
}
