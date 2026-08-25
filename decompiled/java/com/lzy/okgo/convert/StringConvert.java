package com.lzy.okgo.convert;

import okhttp3.Response;
import okhttp3.ResponseBody;

public class StringConvert implements Converter<String> {
    @Override
    public String convertResponse(Response response) throws Throwable {
        ResponseBody responseBodyBody = response.body();
        if (responseBodyBody == null) {
            return null;
        }
        return responseBodyBody.string();
    }
}
