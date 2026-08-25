package okio;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import p103j9.AbstractC2796i;

final class SocketAsyncTimeout extends AsyncTimeout {
    private final Socket socket;

    public SocketAsyncTimeout(Socket socket) {
        AbstractC2796i.m5785f(socket, "socket");
        this.socket = socket;
    }

    @Override
    public IOException newTimeoutException(IOException iOException) {
        SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
        if (iOException != null) {
            socketTimeoutException.initCause(iOException);
        }
        return socketTimeoutException;
    }

    @Override
    public void timedOut() {
        try {
            this.socket.close();
        } catch (AssertionError e5) {
            if (!Okio.isAndroidGetsocknameError(e5)) {
                throw e5;
            }
            Okio__JvmOkioKt.logger.log(Level.WARNING, "Failed to close timed out socket " + this.socket, (Throwable) e5);
        } catch (Exception e10) {
            Okio__JvmOkioKt.logger.log(Level.WARNING, "Failed to close timed out socket " + this.socket, (Throwable) e10);
        }
    }
}
