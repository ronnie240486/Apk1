package androidx.media3.common.util;

import android.os.Bundle;
import android.util.SparseArray;
import com.google.android.material.internal.ParcelableSparseArray;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p020b7.InterfaceC1346i;
import p041d7.AbstractC2301u1;
import p041d7.AbstractC2331z1;
import p041d7.C2215h5;
import p041d7.C2288s1;

@UnstableApi
public final class BundleCollectionUtil {
    private BundleCollectionUtil() {
    }

    public static HashMap<String, String> bundleToStringHashMap(Bundle bundle) {
        HashMap<String, String> map = new HashMap<>();
        if (bundle == Bundle.EMPTY) {
            return map;
        }
        for (String str : bundle.keySet()) {
            String string = bundle.getString(str);
            if (string != null) {
                map.put(str, string);
            }
        }
        return map;
    }

    public static AbstractC2331z1 bundleToStringImmutableMap(Bundle bundle) {
        return bundle == Bundle.EMPTY ? C2215h5.f7927g : AbstractC2331z1.m5296b(bundleToStringHashMap(bundle));
    }

    public static void ensureClassLoader(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader((ClassLoader) Util.castNonNull(BundleCollectionUtil.class.getClassLoader()));
        }
    }

    public static <T> AbstractC2301u1 fromBundleList(InterfaceC1346i interfaceC1346i, List<Bundle> list) {
        C2288s1 c2288s1M5269k = AbstractC2301u1.m5269k();
        for (int i6 = 0; i6 < list.size(); i6++) {
            c2288s1M5269k.m5255a(interfaceC1346i.apply((Bundle) Assertions.checkNotNull(list.get(i6))));
        }
        return c2288s1M5269k.m5262g();
    }

    public static <T> SparseArray<T> fromBundleSparseArray(InterfaceC1346i interfaceC1346i, SparseArray<Bundle> sparseArray) {
        ParcelableSparseArray parcelableSparseArray = (SparseArray<T>) new SparseArray(sparseArray.size());
        for (int i6 = 0; i6 < sparseArray.size(); i6++) {
            parcelableSparseArray.put(sparseArray.keyAt(i6), interfaceC1346i.apply(sparseArray.valueAt(i6)));
        }
        return parcelableSparseArray;
    }

    public static Bundle getBundleWithDefault(Bundle bundle, String str, Bundle bundle2) {
        Bundle bundle3 = bundle.getBundle(str);
        return bundle3 != null ? bundle3 : bundle2;
    }

    public static ArrayList<Integer> getIntegerArrayListWithDefault(Bundle bundle, String str, ArrayList<Integer> arrayList) {
        ArrayList<Integer> integerArrayList = bundle.getIntegerArrayList(str);
        return integerArrayList != null ? integerArrayList : arrayList;
    }

    public static Bundle stringMapToBundle(Map<String, String> map) {
        Bundle bundle = new Bundle();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            bundle.putString(entry.getKey(), entry.getValue());
        }
        return bundle;
    }

    public static <T> ArrayList<Bundle> toBundleArrayList(Collection<T> collection, InterfaceC1346i interfaceC1346i) {
        ArrayList<Bundle> arrayList = new ArrayList<>(collection.size());
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add((Bundle) interfaceC1346i.apply(it.next()));
        }
        return arrayList;
    }

    public static <T> AbstractC2301u1 toBundleList(List<T> list, InterfaceC1346i interfaceC1346i) {
        C2288s1 c2288s1M5269k = AbstractC2301u1.m5269k();
        for (int i6 = 0; i6 < list.size(); i6++) {
            c2288s1M5269k.m5255a((Bundle) interfaceC1346i.apply(list.get(i6)));
        }
        return c2288s1M5269k.m5262g();
    }

    public static <T> SparseArray<Bundle> toBundleSparseArray(SparseArray<T> sparseArray, InterfaceC1346i interfaceC1346i) {
        SparseArray<Bundle> sparseArray2 = new SparseArray<>(sparseArray.size());
        for (int i6 = 0; i6 < sparseArray.size(); i6++) {
            sparseArray2.put(sparseArray.keyAt(i6), (Bundle) interfaceC1346i.apply(sparseArray.valueAt(i6)));
        }
        return sparseArray2;
    }
}
