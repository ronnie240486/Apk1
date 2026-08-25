package androidx.media3.exoplayer;

public final class RunnableC0731b implements Runnable {

    public final int f2796a;

    public final Object f2797b;

    public RunnableC0731b(int i6, Object obj) {
        this.f2796a = i6;
        this.f2797b = obj;
    }

    @Override
    public final void run() {
        switch (this.f2796a) {
            case 0:
                ((AudioBecomingNoisyManager.AudioBecomingNoisyReceiver) this.f2797b).callListenerIfEnabled();
                break;
            case 1:
                ((DefaultSuitableOutputChecker.ImplApi23) this.f2797b).lambda$disable$2();
                break;
            case 2:
                ((DefaultSuitableOutputChecker.ImplApi35) this.f2797b).lambda$disable$2();
                break;
            case 3:
                ((ExoPlayerImpl) this.f2797b).lambda$new$3();
                break;
            default:
                ((StreamVolumeManager.VolumeChangeReceiver) this.f2797b).lambda$onReceive$0();
                break;
        }
    }
}
