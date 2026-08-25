package p171q;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.google.android.material.internal.AbstractC1811a0;
import com.google.android.material.tabs.TabLayout;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import p198s3.InterfaceC3703a;
import p207t1.InterfaceC3791c;
import p228v2.InterfaceC3979f;
import p251x6.C4132k;
import p262y5.AbstractC4268a;
import p269z2.C4306g;

public class C3388b implements InterfaceC3791c, InterfaceC3979f, InterfaceC3703a {

    public static C3388b f11424b;

    public final int f11425a;

    public C3388b(int i6) {
        this.f11425a = i6;
    }

    public static RectF m6878c(TabLayout tabLayout, View view) {
        if (view == null) {
            return new RectF();
        }
        if (tabLayout.f6691B || !(view instanceof C4132k)) {
            return new RectF(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
        C4132k c4132k = (C4132k) view;
        int contentWidth = c4132k.getContentWidth();
        int contentHeight = c4132k.getContentHeight();
        int iM4245e = (int) AbstractC1811a0.m4245e(c4132k.getContext(), 24);
        if (contentWidth < iM4245e) {
            contentWidth = iM4245e;
        }
        int right = (c4132k.getRight() + c4132k.getLeft()) / 2;
        int bottom = (c4132k.getBottom() + c4132k.getTop()) / 2;
        int i6 = contentWidth / 2;
        return new RectF(right - i6, bottom - (contentHeight / 2), i6 + right, (right / 2) + bottom);
    }

    public void mo6881e(TabLayout tabLayout, View view, View view2, float f, Drawable drawable) {
        RectF rectFM6878c = m6878c(tabLayout, view);
        RectF rectFM6878c2 = m6878c(tabLayout, view2);
        drawable.setBounds(AbstractC4268a.m8311c(f, (int) rectFM6878c.left, (int) rectFM6878c2.left), drawable.getBounds().top, AbstractC4268a.m8311c(f, (int) rectFM6878c.right, (int) rectFM6878c2.right), drawable.getBounds().bottom);
    }

    @Override
    public Object mo6882g() {
        try {
            return new C4306g(MessageDigest.getInstance("SHA-256"));
        } catch (NoSuchAlgorithmException e5) {
            throw new RuntimeException(e5);
        }
    }

    @Override
    public void mo6883i() {
    }

    private final void m6879d(Object obj) {
    }

    @Override
    public void mo6880b(int i6, Serializable serializable) {
    }

    @Override
    public void mo5416a(byte[] bArr, Object obj, MessageDigest messageDigest) {
    }
}
