package p034d0;

import android.net.Uri;
import androidx.core.content.FileProvider;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public final class C2121g {

    public final String f7726a;

    public final HashMap f7727b = new HashMap();

    public C2121g(String str) {
        this.f7726a = str;
    }

    public static boolean m5078a(String str, String str2) {
        String strM1079a = FileProvider.m1079a(str);
        String strM1079a2 = FileProvider.m1079a(str2);
        if (!strM1079a.equals(strM1079a2)) {
            if (!strM1079a.startsWith(strM1079a2 + '/')) {
                return false;
            }
        }
        return true;
    }

    public final File m5079b(Uri uri) {
        String encodedPath = uri.getEncodedPath();
        int iIndexOf = encodedPath.indexOf(47, 1);
        String strDecode = Uri.decode(encodedPath.substring(1, iIndexOf));
        String strDecode2 = Uri.decode(encodedPath.substring(iIndexOf + 1));
        File file = (File) this.f7727b.get(strDecode);
        if (file == null) {
            throw new IllegalArgumentException("Unable to find configured root for " + uri);
        }
        File file2 = new File(file, strDecode2);
        try {
            File canonicalFile = file2.getCanonicalFile();
            if (m5078a(canonicalFile.getPath(), file.getPath())) {
                return canonicalFile;
            }
            throw new SecurityException("Resolved path jumped beyond configured root");
        } catch (IOException unused) {
            throw new IllegalArgumentException("Failed to resolve canonical path for " + file2);
        }
    }
}
