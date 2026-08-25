package androidx.media3.common.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.List;

final class SystemHandlerWrapper implements HandlerWrapper {
    private static final int MAX_POOL_SIZE = 50;
    private static final List<SystemMessage> messagePool = new ArrayList(50);
    private final Handler handler;

    public static final class SystemMessage implements HandlerWrapper.Message {
        private SystemHandlerWrapper handler;
        private Message message;

        private SystemMessage() {
        }

        private void recycle() {
            this.message = null;
            this.handler = null;
            SystemHandlerWrapper.recycleMessage(this);
        }

        @Override
        public HandlerWrapper getTarget() {
            return (HandlerWrapper) Assertions.checkNotNull(this.handler);
        }

        public boolean sendAtFrontOfQueue(Handler handler) {
            boolean zSendMessageAtFrontOfQueue = handler.sendMessageAtFrontOfQueue((Message) Assertions.checkNotNull(this.message));
            recycle();
            return zSendMessageAtFrontOfQueue;
        }

        @Override
        public void sendToTarget() {
            ((Message) Assertions.checkNotNull(this.message)).sendToTarget();
            recycle();
        }

        public SystemMessage setMessage(Message message, SystemHandlerWrapper systemHandlerWrapper) {
            this.message = message;
            this.handler = systemHandlerWrapper;
            return this;
        }
    }

    public SystemHandlerWrapper(Handler handler) {
        this.handler = handler;
    }

    private static SystemMessage obtainSystemMessage() {
        SystemMessage systemMessage;
        List<SystemMessage> list = messagePool;
        synchronized (list) {
            try {
                systemMessage = list.isEmpty() ? new SystemMessage() : list.remove(list.size() - 1);
            } catch (Throwable th) {
                throw th;
            }
        }
        return systemMessage;
    }

    public static void recycleMessage(SystemMessage systemMessage) {
        List<SystemMessage> list = messagePool;
        synchronized (list) {
            try {
                if (list.size() < 50) {
                    list.add(systemMessage);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override
    public Looper getLooper() {
        return this.handler.getLooper();
    }

    @Override
    public boolean hasMessages(int i6) {
        Assertions.checkArgument(i6 != 0);
        return this.handler.hasMessages(i6);
    }

    @Override
    public HandlerWrapper.Message obtainMessage(int i6) {
        return obtainSystemMessage().setMessage(this.handler.obtainMessage(i6), this);
    }

    @Override
    public boolean post(Runnable runnable) {
        return this.handler.post(runnable);
    }

    @Override
    public boolean postAtFrontOfQueue(Runnable runnable) {
        return this.handler.postAtFrontOfQueue(runnable);
    }

    @Override
    public boolean postDelayed(Runnable runnable, long j10) {
        return this.handler.postDelayed(runnable, j10);
    }

    @Override
    public void removeCallbacksAndMessages(Object obj) {
        this.handler.removeCallbacksAndMessages(obj);
    }

    @Override
    public void removeMessages(int i6) {
        Assertions.checkArgument(i6 != 0);
        this.handler.removeMessages(i6);
    }

    @Override
    public boolean sendEmptyMessage(int i6) {
        return this.handler.sendEmptyMessage(i6);
    }

    @Override
    public boolean sendEmptyMessageAtTime(int i6, long j10) {
        return this.handler.sendEmptyMessageAtTime(i6, j10);
    }

    @Override
    public boolean sendEmptyMessageDelayed(int i6, int i10) {
        return this.handler.sendEmptyMessageDelayed(i6, i10);
    }

    @Override
    public boolean sendMessageAtFrontOfQueue(HandlerWrapper.Message message) {
        return ((SystemMessage) message).sendAtFrontOfQueue(this.handler);
    }

    @Override
    public HandlerWrapper.Message obtainMessage(int i6, Object obj) {
        return obtainSystemMessage().setMessage(this.handler.obtainMessage(i6, obj), this);
    }

    @Override
    public HandlerWrapper.Message obtainMessage(int i6, int i10, int i11) {
        return obtainSystemMessage().setMessage(this.handler.obtainMessage(i6, i10, i11), this);
    }

    @Override
    public HandlerWrapper.Message obtainMessage(int i6, int i10, int i11, Object obj) {
        return obtainSystemMessage().setMessage(this.handler.obtainMessage(i6, i10, i11, obj), this);
    }
}
