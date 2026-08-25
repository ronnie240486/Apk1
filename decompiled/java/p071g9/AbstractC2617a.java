package p071g9;

import com.bumptech.glide.AbstractC1465c;
import java.io.File;
import p103j9.AbstractC2796i;
import p192r9.AbstractC3648f;

public abstract class AbstractC2617a extends AbstractC1465c {
    public static File m5625p(File file) {
        int length;
        File file2;
        int iM7380b0;
        File file3 = new File("image_cache");
        String path = file3.getPath();
        AbstractC2796i.m5784e(path, "getPath(...)");
        char c5 = File.separatorChar;
        int iM7380b1 = AbstractC3648f.m7380b0(path, c5, 0, false, 4);
        if (iM7380b1 == 0) {
            if (path.length() <= 1 || path.charAt(1) != c5 || (iM7380b0 = AbstractC3648f.m7380b0(path, c5, 2, false, 4)) < 0) {
                length = 1;
            } else {
                int iM7380b2 = AbstractC3648f.m7380b0(path, c5, iM7380b0 + 1, false, 4);
                length = iM7380b2 >= 0 ? iM7380b2 + 1 : path.length();
            }
        } else if (iM7380b1 <= 0 || path.charAt(iM7380b1 - 1) != ':') {
            length = (iM7380b1 == -1 && AbstractC3648f.m7377Y(path, ':')) ? path.length() : 0;
        } else {
            length = iM7380b1 + 1;
        }
        if (length > 0) {
            return file3;
        }
        String string = file.toString();
        AbstractC2796i.m5784e(string, "toString(...)");
        if ((string.length() == 0) || AbstractC3648f.m7377Y(string, c5)) {
            file2 = new File(string + file3);
        } else {
            file2 = new File(string + c5 + file3);
        }
        return file2;
    }
}
