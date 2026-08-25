package androidx.media3.exoplayer.rtsp;

final class TransferRtpDataChannelFactory implements RtpDataChannel.Factory {
    private static final int INTERLEAVED_CHANNELS_PER_TRACK = 2;
    private final long timeoutMs;

    public TransferRtpDataChannelFactory(long j10) {
        this.timeoutMs = j10;
    }

    @Override
    public RtpDataChannel createAndOpenDataChannel(int i6) {
        TransferRtpDataChannel transferRtpDataChannel = new TransferRtpDataChannel(this.timeoutMs);
        transferRtpDataChannel.open(RtpUtils.getIncomingRtpDataSpec(i6 * 2));
        return transferRtpDataChannel;
    }

    @Override
    public final RtpDataChannel.Factory createFallbackDataChannelFactory() {
        return AbstractC0862a.m2422a(this);
    }
}
