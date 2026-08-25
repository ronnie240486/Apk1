package com.lzy.okgo.model;

import androidx.media3.exoplayer.hls.playlist.HlsMediaPlaylist;

public enum HttpMethod {
    GET("GET"),
    POST(HlsMediaPlaylist.Interstitial.CUE_TRIGGER_POST),
    PUT("PUT"),
    DELETE("DELETE"),
    HEAD("HEAD"),
    PATCH("PATCH"),
    OPTIONS("OPTIONS"),
    TRACE("TRACE");

    private final String value;

    public static class C20031 {
        static final int[] $SwitchMap$com$lzy$okgo$model$HttpMethod;

        static {
            int[] iArr = new int[HttpMethod.values().length];
            $SwitchMap$com$lzy$okgo$model$HttpMethod = iArr;
            try {
                iArr[HttpMethod.POST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$lzy$okgo$model$HttpMethod[HttpMethod.PUT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$lzy$okgo$model$HttpMethod[HttpMethod.PATCH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$lzy$okgo$model$HttpMethod[HttpMethod.DELETE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$lzy$okgo$model$HttpMethod[HttpMethod.OPTIONS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    HttpMethod(String str) {
        this.value = str;
    }

    public boolean hasBody() {
        int i6 = C20031.$SwitchMap$com$lzy$okgo$model$HttpMethod[ordinal()];
        return i6 == 1 || i6 == 2 || i6 == 3 || i6 == 4 || i6 == 5;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
