package p116ka;

import java.util.Comparator;
import org.bitspark.android.beans.ChannelBean;

public final class C2936q implements Comparator {
    @Override
    public final int compare(Object obj, Object obj2) {
        return ((ChannelBean) obj).getName().getInit().compareToIgnoreCase(((ChannelBean) obj2).getName().getInit());
    }
}
