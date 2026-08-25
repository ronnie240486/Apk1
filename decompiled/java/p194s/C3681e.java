package p194s;

import android.util.Log;
import java.util.Arrays;

public class C3681e {

    public static final C3681e f12321b = new C3681e();

    public static final String[] f12322c = {"standard", "accelerate", "decelerate", "linear"};

    public String f12323a = "identity";

    public static C3681e m7432c(String str) {
        if (str == null) {
            return null;
        }
        if (str.startsWith("cubic")) {
            return new C3680d(str);
        }
        switch (str) {
            case "accelerate":
                return new C3680d("cubic(0.4, 0.05, 0.8, 0.7)");
            case "decelerate":
                return new C3680d("cubic(0.0, 0.0, 0.2, 0.95)");
            case "linear":
                return new C3680d("cubic(1, 1, 0, 0)");
            case "standard":
                return new C3680d("cubic(0.4, 0.0, 0.2, 1)");
            default:
                Log.e("ConstraintSet", "transitionEasing syntax error syntax:transitionEasing=\"cubic(1.0,0.5,0.0,0.6)\" or " + Arrays.toString(f12322c));
                return f12321b;
        }
    }

    public double mo7429b(double d) {
        return 1.0d;
    }

    public final String toString() {
        return this.f12323a;
    }

    public double mo7428a(double d) {
        return d;
    }
}
