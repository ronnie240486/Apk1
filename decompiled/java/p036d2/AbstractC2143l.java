package p036d2;

import androidx.media3.common.MimeTypes;
import java.util.LinkedHashSet;
import p253x8.AbstractC4158u;

public abstract class AbstractC2143l {

    public static final LinkedHashSet f7776a;

    static {
        String[] strArr = {MimeTypes.IMAGE_JPEG, MimeTypes.IMAGE_WEBP, MimeTypes.IMAGE_HEIC, MimeTypes.IMAGE_HEIF};
        LinkedHashSet linkedHashSet = new LinkedHashSet(AbstractC4158u.m8196p(4));
        for (int i6 = 0; i6 < 4; i6++) {
            linkedHashSet.add(strArr[i6]);
        }
        f7776a = linkedHashSet;
    }
}
