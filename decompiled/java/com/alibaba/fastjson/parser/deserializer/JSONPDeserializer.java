package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONPObject;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexerBase;
import java.lang.reflect.Type;
import p055ea.AbstractC2460q;

public class JSONPDeserializer implements ObjectDeserializer {
    public static final JSONPDeserializer instance = new JSONPDeserializer();

    @Override
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        int i6;
        JSONLexerBase jSONLexerBase = (JSONLexerBase) defaultJSONParser.getLexer();
        String strScanSymbolUnQuoted = jSONLexerBase.scanSymbolUnQuoted(defaultJSONParser.getSymbolTable());
        jSONLexerBase.nextToken();
        int i10 = jSONLexerBase.token();
        if (i10 == 25) {
            String strScanSymbolUnQuoted2 = jSONLexerBase.scanSymbolUnQuoted(defaultJSONParser.getSymbolTable());
            strScanSymbolUnQuoted = AbstractC2460q.m5494h(strScanSymbolUnQuoted, ".") + strScanSymbolUnQuoted2;
            jSONLexerBase.nextToken();
            i10 = jSONLexerBase.token();
        }
        ?? r10 = (T) new JSONPObject(strScanSymbolUnQuoted);
        if (i10 != 10) {
            throw new JSONException("illegal jsonp : " + jSONLexerBase.info());
        }
        jSONLexerBase.nextToken();
        while (true) {
            r10.addParameter(defaultJSONParser.parse());
            i6 = jSONLexerBase.token();
            if (i6 != 16) {
                break;
            }
            jSONLexerBase.nextToken();
        }
        if (i6 != 11) {
            throw new JSONException("illegal jsonp : " + jSONLexerBase.info());
        }
        jSONLexerBase.nextToken();
        if (jSONLexerBase.token() == 24) {
            jSONLexerBase.nextToken();
        }
        return r10;
    }

    @Override
    public int getFastMatchToken() {
        return 0;
    }
}
