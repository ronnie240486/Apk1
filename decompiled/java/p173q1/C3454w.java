package p173q1;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.lzy.okgo.cookie.SerializableCookie;
import com.lzy.okgo.model.Progress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public final class C3454w {

    public final Bundle f11701a;

    public C3454w(Bundle bundle) {
        this.f11701a = bundle;
    }

    public final HashSet m7084a() {
        Bundle bundle = this.f11701a;
        return !bundle.containsKey("allowedPackages") ? new HashSet() : new HashSet(bundle.getStringArrayList("allowedPackages"));
    }

    public final ArrayList m7085b() {
        Bundle bundle = this.f11701a;
        return !bundle.containsKey("controlFilters") ? new ArrayList() : new ArrayList(bundle.getParcelableArrayList("controlFilters"));
    }

    public final int m7086c() {
        return this.f11701a.getInt("deviceType");
    }

    public final ArrayList m7087d() {
        Bundle bundle = this.f11701a;
        return !bundle.containsKey("groupMemberIds") ? new ArrayList() : new ArrayList(bundle.getStringArrayList("groupMemberIds"));
    }

    public final Uri m7088e() {
        String string = this.f11701a.getString("iconUri");
        if (string == null) {
            return null;
        }
        return Uri.parse(string);
    }

    public final String m7089f() {
        return this.f11701a.getString(TtmlNode.ATTR_ID);
    }

    public final String m7090g() {
        return this.f11701a.getString(SerializableCookie.NAME);
    }

    public final int m7091h() {
        return this.f11701a.getInt("volume");
    }

    public final int m7092i() {
        return this.f11701a.getInt("volumeHandling", 0);
    }

    public final int m7093j() {
        return this.f11701a.getInt("volumeMax");
    }

    public final boolean m7094k() {
        return (TextUtils.isEmpty(m7089f()) || TextUtils.isEmpty(m7090g()) || m7085b().contains(null)) ? false : true;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("MediaRouteDescriptor{ id=");
        sb.append(m7089f());
        sb.append(", groupMemberIds=");
        sb.append(m7087d());
        sb.append(", name=");
        sb.append(m7090g());
        sb.append(", description=");
        Bundle bundle = this.f11701a;
        sb.append(bundle.getString(Progress.STATUS));
        sb.append(", iconUri=");
        sb.append(m7088e());
        sb.append(", isEnabled=");
        sb.append(bundle.getBoolean("enabled", true));
        sb.append(", isSystemRoute=");
        sb.append(bundle.getBoolean("isSystemRoute", false));
        sb.append(", connectionState=");
        sb.append(bundle.getInt("connectionState", 0));
        sb.append(", controlFilters=");
        sb.append(Arrays.toString(m7085b().toArray()));
        sb.append(", playbackType=");
        sb.append(bundle.getInt("playbackType", 1));
        sb.append(", playbackStream=");
        sb.append(bundle.getInt("playbackStream", -1));
        sb.append(", deviceType=");
        sb.append(m7086c());
        sb.append(", volume=");
        sb.append(m7091h());
        sb.append(", volumeMax=");
        sb.append(m7093j());
        sb.append(", volumeHandling=");
        sb.append(m7092i());
        sb.append(", presentationDisplayId=");
        sb.append(bundle.getInt("presentationDisplayId", -1));
        sb.append(", extras=");
        sb.append(bundle.getBundle("extras"));
        sb.append(", isValid=");
        sb.append(m7094k());
        sb.append(", minClientVersion=");
        sb.append(bundle.getInt("minClientVersion", 1));
        sb.append(", maxClientVersion=");
        sb.append(bundle.getInt("maxClientVersion", Integer.MAX_VALUE));
        sb.append(", isVisibilityPublic=");
        sb.append(bundle.getBoolean("isVisibilityPublic", true));
        sb.append(", allowedPackages=");
        sb.append(Arrays.toString(m7084a().toArray()));
        sb.append(" }");
        return sb.toString();
    }
}
