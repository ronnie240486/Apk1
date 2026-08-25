package p193ra;

import android.net.Uri;
import android.widget.VideoView;
import java.util.HashMap;
import p003a2.AbstractC0032a;
import p156o9.AbstractC3280d;

public final class C3660c implements InterfaceC3658a {

    public VideoView f12259a;

    static {
        AbstractC0032a.m165s("QjKuo62WqYdmLo8=\n", "D0v4ysnzxtE=\n");
    }

    @Override
    public final void mo7405a() {
        AbstractC0032a.m165s("m7VJ4hf+\n", "6N0mlS3eLk8=\n");
        this.f12259a.setVisibility(0);
    }

    @Override
    public final void mo7406b() {
        AbstractC0032a.m165s("9tIk9E9cSpEtDQ==\n", "hLdQhjZmanY=\n");
    }

    @Override
    public final void mo7407c() {
        this.f12259a.stopPlayback();
        AbstractC0032a.m165s("sIvtkF6owzuhnuGLNA==\n", "w/+C4A7EokI=\n");
    }

    @Override
    public final void mo7408d() {
        this.f12259a.resume();
        AbstractC0032a.m165s("f1GNADLeiaI=\n", "DTT+dV+7s4I=\n");
    }

    @Override
    public final void mo7409e() {
        AbstractC0032a.m165s("kfVVqn2hugdY\n", "4oE62keBXa4=\n");
    }

    @Override
    public final void mo7410f() {
        AbstractC3280d.m6606y(this.f12259a);
    }

    @Override
    public final void mo7411g(Uri uri, HashMap map) {
        AbstractC0032a.m165s("366VRLTwLKT5mago/Q==\n", "rMvhEt2UScs=\n");
        this.f12259a.setVideoURI(uri, map);
    }

    @Override
    public final int getBufferedPercentage() {
        AbstractC0032a.m165s("JjIRNrLoP0MzMgEkovw6Qy8jBBOitHnB6O0=\n", "QVdldMeOWSY=\n");
        return 0;
    }

    @Override
    public final long getCurrentPosition() {
        return this.f12259a.getCurrentPosition();
    }

    @Override
    public final long getDuration() {
        return this.f12259a.getDuration();
    }

    @Override
    public final boolean getPlayWhenReady() {
        AbstractC0032a.m165s("tunmdY8vhyG56fx3hi+aD+usdYxZ\n", "0YySJeNO/nY=\n");
        return false;
    }

    @Override
    public final void mo7412h(String str) {
        this.f12259a.setVideoPath(str);
        AbstractC0032a.m165s("4qXTOJ3eUmDBodMGzpo=\n", "kcCnbvS6Nw8=\n");
    }

    @Override
    public final boolean mo7413i(int i6) {
        VideoView videoView = this.f12259a;
        return videoView != null && i6 == videoView.getId();
    }

    @Override
    public final boolean isPlaying() {
        return this.f12259a.isPlaying();
    }

    @Override
    public final boolean isVisible() {
        AbstractC0032a.m165s("yAxT6FDmpcfERSU=\n", "oX8FgSOPx6s=\n");
        VideoView videoView = this.f12259a;
        videoView.getVisibility();
        return videoView.getVisibility() == 0;
    }

    @Override
    public final void mo7414j() {
        AbstractC0032a.m165s("loOuTwjl\n", "/urKKjLFBAA=\n");
        this.f12259a.setVisibility(8);
    }

    @Override
    public final void pause() {
        AbstractC0032a.m165s("ByFn7ro7mg==\n", "d0ASnd8Bunw=\n");
        this.f12259a.pause();
    }

    @Override
    public final void prepare() {
        AbstractC0032a.m165s("GDXinJdDRZVIoC5W\n", "aEeH7PYxIK8=\n");
    }

    @Override
    public final void release() {
        AbstractC0032a.m165s("/FdJ9R4nyJOu1Ywq\n", "jjIlkH9Urak=\n");
    }

    @Override
    public final void seekTo(long j10) {
        this.f12259a.seekTo((int) j10);
    }

    @Override
    public final void setPlayWhenReady(boolean z7) {
        AbstractC0032a.m165s("Bvs6LpkvK0Md+yAskC82bU++qddP\n", "dZ5OfvVOUhQ=\n");
    }

    @Override
    public final void start() {
        this.f12259a.start();
        AbstractC0032a.m165s("6Pid8znS5A==\n", "m4z8gU3oxJw=\n");
    }

    @Override
    public final void stop() {
        AbstractC0032a.m165s("4bXy/Ce+TXIo\n", "ksGdjB2eqts=\n");
    }
}
