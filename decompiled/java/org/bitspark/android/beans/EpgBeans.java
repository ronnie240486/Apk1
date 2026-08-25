package org.bitspark.android.beans;

import com.nmmedit.protect.NativeUtil;
import java.io.Serializable;
import java.util.List;

public class EpgBeans implements Serializable {
    private static final long serialVersionUID = -8577710898966539448L;
    private List<EpgBean> epg;
    private boolean hasPlayBack;

    private int f11176id;

    public static class EpgBean implements Serializable {
        private static final long serialVersionUID = -8577710121266539448L;
        private Long endTime;

        private String f11177id;
        private String name;
        private String playbackUrl;
        private Long time;

        static {
            NativeUtil.classesInit0(64);
        }

        public native Long getEndTime();

        public native String getId();

        public native String getName();

        public native String getPlaybackUrl();

        public native Long getTime();

        public native void setEndTime(Long l9);

        public native void setId(String str);

        public native void setName(String str);

        public native void setPlaybackUrl(String str);

        public native void setTime(Long l9);
    }

    static {
        NativeUtil.classesInit0(27);
    }

    public native List<EpgBean> getEpg();

    public native int getId();

    public native boolean isHasPlayBack();

    public native void setEpg(List<EpgBean> list);

    public native void setHasPlayBack(boolean z7);

    public native void setId(int i6);
}
