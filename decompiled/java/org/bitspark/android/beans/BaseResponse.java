package org.bitspark.android.beans;

import com.nmmedit.protect.NativeUtil;

public class BaseResponse<T> {
    int code;
    T data;
    String message;

    static {
        NativeUtil.classesInit0(58);
    }

    public native int getCode();

    public native T getData();

    public native String getMessage();

    public native void setCode(int i6);

    public native void setData(T t5);

    public native void setMessage(String str);
}
