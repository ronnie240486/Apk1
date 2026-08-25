package androidx.media3.exoplayer;

public abstract class AbstractC0947u0 {
    public static int m2577c(int i6) {
        return m2579e(i6, 0, 0, 0);
    }

    public static int m2578d(int i6, int i10, int i11) {
        return m2581g(i6, i10, i11, 0, 128, 0);
    }

    public static int m2579e(int i6, int i10, int i11, int i12) {
        return m2581g(i6, i10, i11, 0, 128, i12);
    }

    public static int m2580f(int i6, int i10, int i11, int i12, int i13) {
        return m2581g(i6, i10, i11, i12, i13, 0);
    }

    public static int m2581g(int i6, int i10, int i11, int i12, int i13, int i14) {
        return i6 | i10 | i11 | i12 | i13 | i14;
    }

    public static int m2582h(int i6) {
        return i6 & 24;
    }

    public static int m2583i(int i6) {
        return i6 & RendererCapabilities.AUDIO_OFFLOAD_SUPPORT_MASK;
    }

    public static int m2584j(int i6) {
        return i6 & RendererCapabilities.DECODER_SUPPORT_MASK;
    }

    public static int m2585k(int i6) {
        return i6 & 7;
    }

    public static int m2586l(int i6) {
        return i6 & 64;
    }

    public static int m2587m(int i6) {
        return i6 & 32;
    }

    public static boolean m2588n(int i6, boolean z7) {
        int iM2585k = m2585k(i6);
        return iM2585k == 4 || (z7 && iM2585k == 3);
    }

    public static void m2575a(RendererCapabilities rendererCapabilities) {
    }

    public static void m2576b(RendererCapabilities rendererCapabilities, RendererCapabilities.Listener listener) {
    }
}
