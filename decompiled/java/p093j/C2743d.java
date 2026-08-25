package p093j;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.view.LayoutInflater;
import com.p2serv.android.p032ds.R;

public final class C2743d extends ContextWrapper {

    public static Configuration f9409f;

    public int f9410a;

    public Resources.Theme f9411b;

    public LayoutInflater f9412c;

    public Configuration f9413d;

    public Resources f9414e;

    public C2743d(Context context, int i6) {
        super(context);
        this.f9410a = i6;
    }

    public final void m5708a(Configuration configuration) {
        if (this.f9414e != null) {
            throw new IllegalStateException("getResources() or getAssets() has already been called");
        }
        if (this.f9413d != null) {
            throw new IllegalStateException("Override configuration has already been set");
        }
        this.f9413d = new Configuration(configuration);
    }

    @Override
    public final void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public final void m5709b() {
        if (this.f9411b == null) {
            this.f9411b = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f9411b.setTo(theme);
            }
        }
        this.f9411b.applyStyle(this.f9410a, true);
    }

    @Override
    public final AssetManager getAssets() {
        return getResources().getAssets();
    }

    @Override
    public final Resources getResources() {
        if (this.f9414e == null) {
            Configuration configuration = this.f9413d;
            if (configuration == null) {
                this.f9414e = super.getResources();
            } else {
                if (Build.VERSION.SDK_INT >= 26) {
                    if (f9409f == null) {
                        Configuration configuration2 = new Configuration();
                        configuration2.fontScale = 0.0f;
                        f9409f = configuration2;
                    }
                    if (configuration.equals(f9409f)) {
                        this.f9414e = super.getResources();
                    }
                }
                this.f9414e = AbstractC2742c.m5707a(this, this.f9413d).getResources();
            }
        }
        return this.f9414e;
    }

    @Override
    public final Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.f9412c == null) {
            this.f9412c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.f9412c;
    }

    @Override
    public final Resources.Theme getTheme() {
        Resources.Theme theme = this.f9411b;
        if (theme != null) {
            return theme;
        }
        if (this.f9410a == 0) {
            this.f9410a = R.style.Theme_AppCompat_Light;
        }
        m5709b();
        return this.f9411b;
    }

    @Override
    public final void setTheme(int i6) {
        if (this.f9410a != i6) {
            this.f9410a = i6;
            m5709b();
        }
    }
}
