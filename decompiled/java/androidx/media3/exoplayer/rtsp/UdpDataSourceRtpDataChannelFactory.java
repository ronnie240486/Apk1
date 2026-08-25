package androidx.media3.exoplayer.rtsp;

import androidx.media3.datasource.DataSourceUtil;
import java.io.IOException;

final class UdpDataSourceRtpDataChannelFactory implements RtpDataChannel.Factory {
    private final long socketTimeoutMs;

    public UdpDataSourceRtpDataChannelFactory(long j10) {
        this.socketTimeoutMs = j10;
    }

    @Override
    public RtpDataChannel createAndOpenDataChannel(int i6) throws IOException {
        UdpDataSourceRtpDataChannel udpDataSourceRtpDataChannel = new UdpDataSourceRtpDataChannel(this.socketTimeoutMs);
        UdpDataSourceRtpDataChannel udpDataSourceRtpDataChannel2 = new UdpDataSourceRtpDataChannel(this.socketTimeoutMs);
        try {
            udpDataSourceRtpDataChannel.open(RtpUtils.getIncomingRtpDataSpec(0));
            int localPort = udpDataSourceRtpDataChannel.getLocalPort();
            boolean z7 = localPort % 2 == 0;
            udpDataSourceRtpDataChannel2.open(RtpUtils.getIncomingRtpDataSpec(z7 ? localPort + 1 : localPort - 1));
            if (z7) {
                udpDataSourceRtpDataChannel.setRtcpChannel(udpDataSourceRtpDataChannel2);
                return udpDataSourceRtpDataChannel;
            }
            udpDataSourceRtpDataChannel2.setRtcpChannel(udpDataSourceRtpDataChannel);
            return udpDataSourceRtpDataChannel2;
        } catch (IOException e5) {
            DataSourceUtil.closeQuietly(udpDataSourceRtpDataChannel);
            DataSourceUtil.closeQuietly(udpDataSourceRtpDataChannel2);
            throw e5;
        }
    }

    @Override
    public RtpDataChannel.Factory createFallbackDataChannelFactory() {
        return new TransferRtpDataChannelFactory(this.socketTimeoutMs);
    }
}
