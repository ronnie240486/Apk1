package ga;

import java.util.Comparator;
import org.bitspark.android.beans.ChannelBean;

public final class C2631n implements Comparator {
    @Override
    public final int compare(Object obj, Object obj2) {
        return Integer.compare(((ChannelBean.TagsBean) obj).getId(), ((ChannelBean.TagsBean) obj2).getId());
    }
}
