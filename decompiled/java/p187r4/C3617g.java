package p187r4;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TabHost;
import androidx.fragment.app.DialogInterfaceOnCancelListenerC0415m;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaStatus;
import com.google.android.gms.cast.MediaTrack;
import com.p2serv.android.p032ds.R;
import java.util.ArrayList;
import java.util.Locale;
import p116ka.DialogInterfaceOnClickListenerC2943x;
import p176q4.C3473b;
import p176q4.C3475c;

public class C3617g extends DialogInterfaceOnCancelListenerC0415m {

    public boolean f12158k0;

    public ArrayList f12159l0;

    public ArrayList f12160m0;

    public long[] f12161n0;

    public AlertDialog f12162o0;

    public C3616f f12163p0;

    @Deprecated
    public C3617g() {
    }

    public static int m7322T(ArrayList arrayList, long[] jArr, int i6) {
        if (jArr != null && arrayList != null) {
            for (int i10 = 0; i10 < arrayList.size(); i10++) {
                for (long j10 : jArr) {
                    if (j10 == ((MediaTrack) arrayList.get(i10)).f4728a) {
                        return i10;
                    }
                }
            }
        }
        return i6;
    }

    @Override
    public final Dialog mo1275R() {
        int iM7322T = m7322T(this.f12159l0, this.f12161n0, 0);
        int iM7322T2 = m7322T(this.f12160m0, this.f12161n0, -1);
        ViewOnClickListenerC3631u viewOnClickListenerC3631u = new ViewOnClickListenerC3631u(m1319h(), this.f12159l0, iM7322T);
        ViewOnClickListenerC3631u viewOnClickListenerC3631u2 = new ViewOnClickListenerC3631u(m1319h(), this.f12160m0, iM7322T2);
        AlertDialog.Builder builder = new AlertDialog.Builder(m1319h());
        View viewInflate = m1319h().getLayoutInflater().inflate(R.layout.cast_tracks_chooser_dialog_layout, (ViewGroup) null);
        ListView listView = (ListView) viewInflate.findViewById(R.id.text_list_view);
        ListView listView2 = (ListView) viewInflate.findViewById(R.id.audio_list_view);
        TabHost tabHost = (TabHost) viewInflate.findViewById(R.id.tab_host);
        tabHost.setup();
        if (viewOnClickListenerC3631u.getCount() == 0) {
            listView.setVisibility(4);
        } else {
            listView.setAdapter((ListAdapter) viewOnClickListenerC3631u);
            TabHost.TabSpec tabSpecNewTabSpec = tabHost.newTabSpec("textTab");
            tabSpecNewTabSpec.setContent(R.id.text_list_view);
            tabSpecNewTabSpec.setIndicator(String.format(Locale.ROOT, m1319h().getString(R.string.cast_tracks_chooser_dialog_subtitles), new Object[0]));
            tabHost.addTab(tabSpecNewTabSpec);
        }
        if (viewOnClickListenerC3631u2.getCount() <= 1) {
            listView2.setVisibility(4);
        } else {
            listView2.setAdapter((ListAdapter) viewOnClickListenerC3631u2);
            TabHost.TabSpec tabSpecNewTabSpec2 = tabHost.newTabSpec("audioTab");
            tabSpecNewTabSpec2.setContent(R.id.audio_list_view);
            tabSpecNewTabSpec2.setIndicator(String.format(Locale.ROOT, m1319h().getString(R.string.cast_tracks_chooser_dialog_audio), new Object[0]));
            tabHost.addTab(tabSpecNewTabSpec2);
        }
        AlertDialog.Builder view = builder.setView(viewInflate);
        Locale locale = Locale.ROOT;
        view.setPositiveButton(String.format(locale, m1319h().getString(R.string.cast_tracks_chooser_dialog_ok), new Object[0]), new DialogInterfaceOnClickListenerC3629s(this, viewOnClickListenerC3631u, viewOnClickListenerC3631u2)).setNegativeButton(String.format(locale, m1319h().getString(R.string.cast_tracks_chooser_dialog_cancel), new Object[0]), new DialogInterfaceOnClickListenerC2943x(1, this));
        AlertDialog alertDialog = this.f12162o0;
        if (alertDialog != null) {
            alertDialog.cancel();
            this.f12162o0 = null;
        }
        AlertDialog alertDialogCreate = builder.create();
        this.f12162o0 = alertDialogCreate;
        return alertDialogCreate;
    }

    @Override
    public final void mo1279s(Bundle bundle) {
        super.mo1279s(bundle);
        this.f12158k0 = true;
        this.f12160m0 = new ArrayList();
        this.f12159l0 = new ArrayList();
        this.f12161n0 = new long[0];
        C3475c c3475cM7142c = C3473b.m7099b(m1321j()).m7102a().m7142c();
        if (c3475cM7142c != null && c3475cM7142c.m7136a()) {
            C3616f c3616fM7125f = c3475cM7142c.m7125f();
            this.f12163p0 = c3616fM7125f;
            if (c3616fM7125f != null && c3616fM7125f.m7305i() && this.f12163p0.m7301e() != null) {
                C3616f c3616f = this.f12163p0;
                MediaStatus mediaStatusM7302f = c3616f.m7302f();
                if (mediaStatusM7302f != null) {
                    this.f12161n0 = mediaStatusM7302f.f4714k;
                }
                MediaInfo mediaInfoM7301e = c3616f.m7301e();
                if (mediaInfoM7301e == null) {
                    this.f12158k0 = false;
                    return;
                }
                ArrayList<MediaTrack> arrayList = mediaInfoM7301e.f4643f;
                if (arrayList == null) {
                    this.f12158k0 = false;
                    return;
                }
                ArrayList arrayList2 = new ArrayList();
                for (MediaTrack mediaTrack : arrayList) {
                    if (mediaTrack.f4729b == 2) {
                        arrayList2.add(mediaTrack);
                    }
                }
                this.f12160m0 = arrayList2;
                ArrayList arrayList3 = new ArrayList();
                for (MediaTrack mediaTrack2 : arrayList) {
                    if (mediaTrack2.f4729b == 1) {
                        arrayList3.add(mediaTrack2);
                    }
                }
                this.f12159l0 = arrayList3;
                if (arrayList3.isEmpty()) {
                    return;
                }
                this.f12159l0.add(0, new MediaTrack(-1L, 1, "", null, String.format(Locale.ROOT, m1319h().getString(R.string.cast_tracks_chooser_dialog_none), new Object[0]), null, 2, null, null));
                return;
            }
        }
        this.f12158k0 = false;
    }

    @Override
    public final void mo1280v() {
        Dialog dialog = this.f1908f0;
        if (dialog != null && this.f1947B) {
            dialog.setDismissMessage(null);
        }
        super.mo1280v();
    }
}
