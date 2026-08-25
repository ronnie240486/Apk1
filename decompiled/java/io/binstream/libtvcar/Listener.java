package io.binstream.libtvcar;

public interface Listener {
    void onInfo(String str);

    void onInited(String str);

    void onPrepared(String str);

    void onQuit(String str);

    void onStart(String str);

    void onStop(String str);
}
