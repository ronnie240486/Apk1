package androidx.media3.exoplayer.hls;

import android.net.Uri;
import android.util.JsonReader;
import android.util.JsonToken;
import androidx.media3.common.C0565C;
import androidx.media3.exoplayer.upstream.ParsingLoadable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Objects;
import p041d7.AbstractC2182d0;
import p041d7.AbstractC2267p1;
import p041d7.AbstractC2301u1;
import p041d7.C2180c5;
import p041d7.C2204g1;
import p041d7.C2288s1;

final class AssetListParser implements ParsingLoadable.Parser<AssetList> {
    private static final String ASSET_LIST_JSON_NAME_ASSET_ARRAY = "ASSETS";
    private static final String ASSET_LIST_JSON_NAME_DURATION = "DURATION";
    private static final String ASSET_LIST_JSON_NAME_URI = "URI";

    public static final class Asset {
        public final long durationUs;
        public final Uri uri;

        public Asset(Uri uri, long j10) {
            this.uri = uri;
            this.durationUs = j10;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Asset)) {
                return false;
            }
            Asset asset = (Asset) obj;
            return this.durationUs == asset.durationUs && Objects.equals(this.uri, asset.uri);
        }

        public int hashCode() {
            return Objects.hash(this.uri, Long.valueOf(this.durationUs));
        }
    }

    public static final class AssetList {
        private static final AssetList EMPTY;
        public final AbstractC2301u1 assets;
        public final AbstractC2301u1 stringAttributes;

        static {
            C2204g1 c2204g1 = AbstractC2301u1.f8069b;
            C2180c5 c2180c5 = C2180c5.f7862e;
            EMPTY = new AssetList(c2180c5, c2180c5);
        }

        public AssetList(AbstractC2301u1 abstractC2301u1, AbstractC2301u1 abstractC2301u2) {
            this.assets = abstractC2301u1;
            this.stringAttributes = abstractC2301u2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AssetList)) {
                return false;
            }
            AssetList assetList = (AssetList) obj;
            return Objects.equals(this.assets, assetList.assets) && Objects.equals(this.stringAttributes, assetList.stringAttributes);
        }

        public int hashCode() {
            return Objects.hash(this.assets, this.stringAttributes);
        }
    }

    public static final class StringAttribute {
        public final String name;
        public final String value;

        public StringAttribute(String str, String str2) {
            this.name = str;
            this.value = str2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof StringAttribute)) {
                return false;
            }
            StringAttribute stringAttribute = (StringAttribute) obj;
            return Objects.equals(this.name, stringAttribute.name) && Objects.equals(this.value, stringAttribute.value);
        }

        public int hashCode() {
            return Objects.hash(this.name, this.value);
        }
    }

    private static void parseAssetArray(JsonReader jsonReader, C2288s1 c2288s1) throws IOException {
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            if (jsonReader.peek() == JsonToken.BEGIN_OBJECT) {
                parseAssetObject(jsonReader, c2288s1);
            }
        }
        jsonReader.endArray();
    }

    private static void parseAssetObject(JsonReader jsonReader, C2288s1 c2288s1) throws IOException {
        jsonReader.beginObject();
        String strNextString = null;
        long jNextDouble = -9223372036854775807L;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            if (strNextName.equals(ASSET_LIST_JSON_NAME_URI) && jsonReader.peek() == JsonToken.STRING) {
                strNextString = jsonReader.nextString();
            } else if (strNextName.equals(ASSET_LIST_JSON_NAME_DURATION) && jsonReader.peek() == JsonToken.NUMBER) {
                jNextDouble = (long) (jsonReader.nextDouble() * 1000000.0d);
            } else {
                jsonReader.skipValue();
            }
        }
        if (strNextString != null && jNextDouble != C0565C.TIME_UNSET) {
            c2288s1.m5255a(new Asset(Uri.parse(strNextString), jNextDouble));
        }
        jsonReader.endObject();
    }

    @Override
    public AssetList parse(Uri uri, InputStream inputStream) throws IOException {
        JsonReader jsonReader = new JsonReader(new InputStreamReader(inputStream));
        try {
            if (jsonReader.peek() != JsonToken.BEGIN_OBJECT) {
                AssetList assetList = AssetList.EMPTY;
                jsonReader.close();
                return assetList;
            }
            C2288s1 c2288s1 = new C2288s1(4);
            AbstractC2182d0.m5141d(4, "initialCapacity");
            Object[] objArrCopyOf = new Object[4];
            jsonReader.beginObject();
            int i6 = 0;
            while (jsonReader.hasNext()) {
                if (jsonReader.peek().equals(JsonToken.NAME)) {
                    String strNextName = jsonReader.nextName();
                    if (strNextName.equals(ASSET_LIST_JSON_NAME_ASSET_ARRAY) && jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
                        parseAssetArray(jsonReader, c2288s1);
                    } else if (jsonReader.peek() == JsonToken.STRING) {
                        StringAttribute stringAttribute = new StringAttribute(strNextName, jsonReader.nextString());
                        int i10 = i6 + 1;
                        int iM5254f = AbstractC2267p1.m5254f(objArrCopyOf.length, i10);
                        if (iM5254f > objArrCopyOf.length) {
                            objArrCopyOf = Arrays.copyOf(objArrCopyOf, iM5254f);
                        }
                        objArrCopyOf[i6] = stringAttribute;
                        i6 = i10;
                    } else {
                        jsonReader.skipValue();
                    }
                }
            }
            AssetList assetList2 = new AssetList(c2288s1.m5262g(), AbstractC2301u1.m5268j(objArrCopyOf, i6));
            jsonReader.close();
            return assetList2;
        } catch (Throwable th) {
            try {
                jsonReader.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }
}
