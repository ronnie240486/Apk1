package coil.memory;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Map;
import p078h5.C2661a;
import p103j9.AbstractC2796i;

public final class MemoryCache$Key implements Parcelable {

    @Deprecated
    public static final Parcelable.Creator<MemoryCache$Key> CREATOR = new C2661a(6);

    public final String f4373a;

    public final Map f4374b;

    public MemoryCache$Key(String str, Map map) {
        this.f4373a = str;
        this.f4374b = map;
    }

    @Override
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MemoryCache$Key) {
            MemoryCache$Key memoryCache$Key = (MemoryCache$Key) obj;
            if (AbstractC2796i.m5780a(this.f4373a, memoryCache$Key.f4373a) && AbstractC2796i.m5780a(this.f4374b, memoryCache$Key.f4374b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f4374b.hashCode() + (this.f4373a.hashCode() * 31);
    }

    public final String toString() {
        return "Key(key=" + this.f4373a + ", extras=" + this.f4374b + ')';
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i6) {
        parcel.writeString(this.f4373a);
        Map map = this.f4374b;
        parcel.writeInt(map.size());
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            String str2 = (String) entry.getValue();
            parcel.writeString(str);
            parcel.writeString(str2);
        }
    }
}
