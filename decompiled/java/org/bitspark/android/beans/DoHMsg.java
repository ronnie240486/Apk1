package org.bitspark.android.beans;

import com.nmmedit.protect.NativeUtil;
import java.util.List;

public class DoHMsg {

    private boolean f11171ad;
    private List<Answer> answer;

    private boolean f11172cd;

    private boolean f11173ra;

    private boolean f11174rd;
    private int status;

    private boolean f11175tc;

    public class Answer {
        private String data;
        private String name;
        private int ttl;
        private int type;

        static {
            NativeUtil.classesInit0(60);
        }

        public Answer() {
        }

        public native String getData();

        public native String getName();

        public native int getTtl();

        public native int getType();

        public native void setData(String str);

        public native void setName(String str);

        public native void setTtl(int i6);

        public native void setType(int i6);
    }

    static {
        NativeUtil.classesInit0(21);
    }

    public native boolean getAd();

    public native List<Answer> getAnswer();

    public native boolean getCd();

    public native boolean getRa();

    public native boolean getRd();

    public native int getStatus();

    public native boolean getTc();

    public native void setAd(boolean z7);

    public native void setAnswer(List<Answer> list);

    public native void setCd(boolean z7);

    public native void setRa(boolean z7);

    public native void setRd(boolean z7);

    public native void setStatus(int i6);

    public native void setTc(boolean z7);
}
