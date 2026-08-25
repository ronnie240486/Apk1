package p173q1;

import android.graphics.Bitmap;
import android.util.Log;
import androidx.core.widget.InterfaceC0378k;
import androidx.core.widget.NestedScrollView;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import p187r4.C3621k;
import p198s3.InterfaceC3703a;
import p207t1.InterfaceC3791c;
import p228v2.InterfaceC3978e;
import p247x2.C4101w;
import p259y2.InterfaceC4238a;
import p269z2.InterfaceC4300a;

public class C3406f0 implements InterfaceC3703a, InterfaceC0378k, InterfaceC3791c, InterfaceC4238a, InterfaceC4300a {

    public final int f11472a;

    @Override
    public void mo6880b(int i6, Serializable serializable) {
        String str;
        switch (i6) {
            case 1:
                str = "RESULT_INSTALL_SUCCESS";
                break;
            case 2:
                str = "RESULT_ALREADY_INSTALLED";
                break;
            case 3:
                str = "RESULT_UNSUPPORTED_ART_VERSION";
                break;
            case 4:
                str = "RESULT_NOT_WRITABLE";
                break;
            case 5:
                str = "RESULT_DESIRED_FORMAT_UNSUPPORTED";
                break;
            case 6:
                str = "RESULT_BASELINE_PROFILE_NOT_FOUND";
                break;
            case 7:
                str = "RESULT_IO_EXCEPTION";
                break;
            case 8:
                str = "RESULT_PARSE_EXCEPTION";
                break;
            case 9:
            default:
                str = "";
                break;
            case 10:
                str = "RESULT_INSTALL_SKIP_FILE_SUCCESS";
                break;
            case 11:
                str = "RESULT_DELETE_SKIP_FILE_SUCCESS";
                break;
        }
        if (i6 == 6 || i6 == 7 || i6 == 8) {
            Log.e("ProfileInstaller", str, (Throwable) serializable);
        } else {
            Log.d("ProfileInstaller", str);
        }
    }

    @Override
    public Bitmap mo6924d(int i6, int i10, Bitmap.Config config) {
        return Bitmap.createBitmap(i6, i10, config);
    }

    @Override
    public Bitmap mo6925e(int i6, int i10, Bitmap.Config config) {
        return Bitmap.createBitmap(i6, i10, config);
    }

    public void mo5434f(Bitmap bitmap) {
        bitmap.recycle();
    }

    @Override
    public Object mo6882g() {
        switch (this.f11472a) {
            case 1:
                return new ArrayList();
            default:
                return new C4101w();
        }
    }

    @Override
    public File mo6926h(InterfaceC3978e interfaceC3978e) {
        return null;
    }

    @Override
    public void mo6883i() {
        Log.d("ProfileInstaller", "DIAGNOSTIC_PROFILE_IS_COMPRESSED");
    }

    @Override
    public void mo6927j() {
    }

    @Override
    public void mo6922a(int i6) {
    }

    @Override
    public void mo1139k(NestedScrollView nestedScrollView) {
    }

    @Override
    public void mo6923c(InterfaceC3978e interfaceC3978e, C3621k c3621k) {
    }
}
