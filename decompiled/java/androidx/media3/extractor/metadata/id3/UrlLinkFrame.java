package androidx.media3.extractor.metadata.id3;

import androidx.media3.common.util.UnstableApi;
import java.util.Objects;
import p000a.AbstractC0004e;

@UnstableApi
public final class UrlLinkFrame extends Id3Frame {
    public final String description;
    public final String url;

    public UrlLinkFrame(String str, String str2, String str3) {
        super(str);
        this.description = str2;
        this.url = str3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || UrlLinkFrame.class != obj.getClass()) {
            return false;
        }
        UrlLinkFrame urlLinkFrame = (UrlLinkFrame) obj;
        return this.f3093id.equals(urlLinkFrame.f3093id) && Objects.equals(this.description, urlLinkFrame.description) && Objects.equals(this.url, urlLinkFrame.url);
    }

    public int hashCode() {
        int iM14h = AbstractC0004e.m14h(527, 31, this.f3093id);
        String str = this.description;
        int iHashCode = (iM14h + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.url;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    @Override
    public String toString() {
        return this.f3093id + ": url=" + this.url;
    }
}
