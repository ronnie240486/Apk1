package p270z3;

import android.util.JsonReader;
import android.util.JsonToken;
import java.io.BufferedReader;
import java.io.IOException;
import p000a.AbstractC0004e;

public final class C4319m {

    public final long f14674a;

    public C4319m(long j10) {
        this.f14674a = j10;
    }

    public static C4319m m8355a(BufferedReader bufferedReader) throws IOException {
        JsonReader jsonReader = new JsonReader(bufferedReader);
        try {
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                if (jsonReader.nextName().equals("nextRequestWaitMillis")) {
                    if (jsonReader.peek() == JsonToken.STRING) {
                        C4319m c4319m = new C4319m(Long.parseLong(jsonReader.nextString()));
                        jsonReader.close();
                        return c4319m;
                    }
                    C4319m c4319m2 = new C4319m(jsonReader.nextLong());
                    jsonReader.close();
                    return c4319m2;
                }
                jsonReader.skipValue();
            }
            throw new IOException("Response is missing nextRequestWaitMillis field.");
        } catch (Throwable th) {
            jsonReader.close();
            throw th;
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C4319m) {
            return this.f14674a == ((C4319m) obj).f14674a;
        }
        return false;
    }

    public final int hashCode() {
        long j10 = this.f14674a;
        return 1000003 ^ ((int) ((j10 >>> 32) ^ j10));
    }

    public final String toString() {
        return AbstractC0004e.m25s(new StringBuilder("LogResponse{nextRequestWaitMillis="), this.f14674a, "}");
    }
}
