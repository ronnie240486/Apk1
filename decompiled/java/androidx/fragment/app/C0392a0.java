package androidx.fragment.app;

import android.util.Log;
import androidx.activity.result.ActivityResult;
import java.util.ArrayList;
import java.util.Map;
import p002a1.C0026b;

public final class C0392a0 {

    public final int f1820a;

    public final AbstractC0410j0 f1821b;

    public C0392a0(AbstractC0410j0 abstractC0410j0, int i6) {
        this.f1820a = i6;
        this.f1821b = abstractC0410j0;
    }

    public final void m1196a(Object obj) {
        switch (this.f1820a) {
            case 0:
                ActivityResult activityResult = (ActivityResult) obj;
                AbstractC0410j0 abstractC0410j0 = this.f1821b;
                FragmentManager$LaunchedFragmentInfo fragmentManager$LaunchedFragmentInfo = (FragmentManager$LaunchedFragmentInfo) abstractC0410j0.f1883w.pollFirst();
                if (fragmentManager$LaunchedFragmentInfo == null) {
                    Log.w("FragmentManager", "No IntentSenders were started for " + this);
                } else {
                    C0026b c0026b = abstractC0410j0.f1863c;
                    String str = fragmentManager$LaunchedFragmentInfo.f1774a;
                    AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427sM134m = c0026b.m134m(str);
                    if (abstractComponentCallbacksC0427sM134m == null) {
                        Log.w("FragmentManager", "Intent Sender result delivered for unknown Fragment " + str);
                    } else {
                        abstractComponentCallbacksC0427sM134m.m1327p(fragmentManager$LaunchedFragmentInfo.f1775b, activityResult.f241a, activityResult.f242b);
                    }
                }
                break;
            case 1:
                Map map = (Map) obj;
                ArrayList arrayList = new ArrayList(map.values());
                int[] iArr = new int[arrayList.size()];
                for (int i6 = 0; i6 < arrayList.size(); i6++) {
                    iArr[i6] = ((Boolean) arrayList.get(i6)).booleanValue() ? 0 : -1;
                }
                AbstractC0410j0 abstractC0410j1 = this.f1821b;
                FragmentManager$LaunchedFragmentInfo fragmentManager$LaunchedFragmentInfo2 = (FragmentManager$LaunchedFragmentInfo) abstractC0410j1.f1883w.pollFirst();
                if (fragmentManager$LaunchedFragmentInfo2 == null) {
                    Log.w("FragmentManager", "No permissions were requested for " + this);
                } else {
                    C0026b c0026b2 = abstractC0410j1.f1863c;
                    String str2 = fragmentManager$LaunchedFragmentInfo2.f1774a;
                    if (c0026b2.m134m(str2) == null) {
                        Log.w("FragmentManager", "Permission request result delivered for unknown Fragment " + str2);
                    }
                }
                break;
            default:
                ActivityResult activityResult2 = (ActivityResult) obj;
                AbstractC0410j0 abstractC0410j2 = this.f1821b;
                FragmentManager$LaunchedFragmentInfo fragmentManager$LaunchedFragmentInfo3 = (FragmentManager$LaunchedFragmentInfo) abstractC0410j2.f1883w.pollFirst();
                if (fragmentManager$LaunchedFragmentInfo3 == null) {
                    Log.w("FragmentManager", "No Activities were started for result for " + this);
                } else {
                    C0026b c0026b3 = abstractC0410j2.f1863c;
                    String str3 = fragmentManager$LaunchedFragmentInfo3.f1774a;
                    AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427sM134m2 = c0026b3.m134m(str3);
                    if (abstractComponentCallbacksC0427sM134m2 == null) {
                        Log.w("FragmentManager", "Activity result delivered for unknown Fragment " + str3);
                    } else {
                        abstractComponentCallbacksC0427sM134m2.m1327p(fragmentManager$LaunchedFragmentInfo3.f1775b, activityResult2.f241a, activityResult2.f242b);
                    }
                }
                break;
        }
    }
}
