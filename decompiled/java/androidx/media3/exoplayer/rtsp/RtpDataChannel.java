package androidx.media3.exoplayer.rtsp;

import androidx.media3.datasource.DataSource;
import java.io.IOException;

interface RtpDataChannel extends DataSource {

    public interface Factory {
        RtpDataChannel createAndOpenDataChannel(int i6) throws IOException;

        Factory createFallbackDataChannelFactory();
    }

    RtspMessageChannel.InterleavedBinaryDataListener getInterleavedBinaryDataListener();

    int getLocalPort();

    String getTransport();

    boolean needsClosingOnLoadCompletion();
}
