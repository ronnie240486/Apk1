package androidx.mediarouter.app;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.AbstractC1158k0;
import androidx.recyclerview.widget.AbstractC1174p1;
import com.p2serv.android.p032ds.R;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import p156o9.AbstractC3280d;
import p173q1.C3445s0;

public final class C1079b0 extends AbstractC1158k0 {

    public final ArrayList f3185a = new ArrayList();

    public final LayoutInflater f3186b;

    public final Drawable f3187c;

    public final Drawable f3188d;

    public final Drawable f3189e;

    public final Drawable f3190f;

    public final DialogC1081c0 f3191g;

    public C1079b0(DialogC1081c0 dialogC1081c0) {
        this.f3191g = dialogC1081c0;
        this.f3186b = LayoutInflater.from(dialogC1081c0.f3196g);
        Context context = dialogC1081c0.f3196g;
        this.f3187c = AbstractC3280d.m6597o(context, R.attr.mediaRouteDefaultIconDrawable);
        this.f3188d = AbstractC3280d.m6597o(context, R.attr.mediaRouteTvIconDrawable);
        this.f3189e = AbstractC3280d.m6597o(context, R.attr.mediaRouteSpeakerIconDrawable);
        this.f3190f = AbstractC3280d.m6597o(context, R.attr.mediaRouteSpeakerGroupIconDrawable);
        m2738a();
    }

    public final void m2738a() {
        ArrayList arrayList = this.f3185a;
        arrayList.clear();
        DialogC1081c0 dialogC1081c0 = this.f3191g;
        arrayList.add(new C1120y(dialogC1081c0.f3196g.getString(R.string.mr_chooser_title)));
        Iterator it = dialogC1081c0.f3198i.iterator();
        while (it.hasNext()) {
            arrayList.add(new C1120y((C3445s0) it.next()));
        }
        notifyDataSetChanged();
    }

    @Override
    public final int getItemCount() {
        return this.f3185a.size();
    }

    @Override
    public final int getItemViewType(int i6) {
        return ((C1120y) this.f3185a.get(i6)).f3433b;
    }

    @Override
    public final void onBindViewHolder(AbstractC1174p1 abstractC1174p1, int i6) {
        Drawable drawableCreateFromStream;
        int i10;
        Drawable drawable;
        int itemViewType = getItemViewType(i6);
        C1120y c1120y = (C1120y) this.f3185a.get(i6);
        if (itemViewType == 1) {
            C1119x c1119x = (C1119x) abstractC1174p1;
            c1119x.getClass();
            c1119x.f3431a.setText(c1120y.f3432a.toString());
            return;
        }
        if (itemViewType != 2) {
            Log.w("RecyclerAdapter", "Cannot bind item to ViewHolder because of wrong view type");
            return;
        }
        C1077a0 c1077a0 = (C1077a0) abstractC1174p1;
        c1077a0.getClass();
        C3445s0 c3445s0 = (C3445s0) c1120y.f3432a;
        View view = c1077a0.f3178a;
        view.setVisibility(0);
        c1077a0.f3180c.setVisibility(4);
        view.setOnClickListener(new ViewOnClickListenerC1121z(c1077a0, 0, c3445s0));
        c1077a0.f3181d.setText(c3445s0.f11655d);
        C1079b0 c1079b0 = c1077a0.f3182e;
        c1079b0.getClass();
        Uri uri = c3445s0.f11657f;
        if (uri != null) {
            try {
                drawableCreateFromStream = Drawable.createFromStream(c1079b0.f3191g.f3196g.getContentResolver().openInputStream(uri), null);
                if (drawableCreateFromStream == null) {
                    i10 = c3445s0.f11665n;
                    if (i10 != 1) {
                        drawable = c1079b0.f3188d;
                    } else if (i10 != 2) {
                        drawable = c1079b0.f3189e;
                    } else if (c3445s0.m7022e()) {
                        drawable = c1079b0.f3190f;
                    } else {
                        drawable = c1079b0.f3187c;
                    }
                    drawableCreateFromStream = drawable;
                }
            } catch (IOException e5) {
                Log.w("RecyclerAdapter", "Failed to load " + uri, e5);
            }
        } else {
            i10 = c3445s0.f11665n;
            if (i10 != 1) {
                drawable = c1079b0.f3188d;
            } else if (i10 != 2) {
                drawable = c1079b0.f3189e;
            } else if (c3445s0.m7022e()) {
                drawable = c1079b0.f3190f;
            } else {
                drawable = c1079b0.f3187c;
            }
            drawableCreateFromStream = drawable;
        }
        c1077a0.f3179b.setImageDrawable(drawableCreateFromStream);
    }

    @Override
    public final AbstractC1174p1 onCreateViewHolder(ViewGroup viewGroup, int i6) {
        LayoutInflater layoutInflater = this.f3186b;
        if (i6 != 1) {
            if (i6 == 2) {
                return new C1077a0(this, layoutInflater.inflate(R.layout.mr_picker_route_item, viewGroup, false));
            }
            throw new IllegalStateException();
        }
        View viewInflate = layoutInflater.inflate(R.layout.mr_picker_header_item, viewGroup, false);
        C1119x c1119x = new C1119x(viewInflate);
        c1119x.f3431a = (TextView) viewInflate.findViewById(R.id.mr_picker_header_name);
        return c1119x;
    }
}
