package p165p4;

import com.google.android.gms.common.Feature;
import p124l6.C2982h;

public abstract class AbstractC3365j {

    public static final Feature f11356a;

    public static final Feature f11357b;

    public static final Feature f11358c;

    public static final Feature f11359d;

    public static final Feature[] f11360e;

    static {
        Feature feature = new Feature("client_side_logging");
        Feature feature2 = new Feature("cxless_client_minimal");
        f11356a = feature2;
        Feature feature3 = new Feature("cxless_caf_control");
        Feature feature4 = new Feature("module_flag_control");
        f11357b = feature4;
        Feature feature5 = new Feature("discovery_hint_supply");
        Feature feature6 = new Feature("relay_casting_set_active_account");
        Feature feature7 = new Feature("analytics_proto_enum_translation");
        f11358c = feature7;
        Feature feature8 = new Feature("integer_to_integer_map");
        f11359d = feature8;
        f11360e = new Feature[]{feature, feature2, feature3, feature4, feature5, feature6, feature7, feature8, new Feature("relay_casting_set_remote_casting_mode"), new Feature("get_relay_access_token"), new Feature("get_cast_settings"), new Feature("set_bundle_setting"), new Feature("get_client_updated_info"), new Feature("device_suggestions")};
    }

    public static String m6840a(String str) {
        if (str != null) {
            return C2982h.m6037D(new C2982h(str, null));
        }
        throw new IllegalArgumentException("applicationId cannot be null");
    }
}
