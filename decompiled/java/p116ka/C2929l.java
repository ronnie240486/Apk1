package p116ka;

import java.util.Comparator;
import org.bitspark.android.beans.ChannelBean;

public final class C2929l implements Comparator {
    @Override
    public final int compare(Object obj, Object obj2) {
        return ((ChannelBean) obj).getName().getInit().compareTo(((ChannelBean) obj2).getName().getInit()) >= 0 ? 1 : -1;
    }
}
