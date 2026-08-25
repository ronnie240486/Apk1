package androidx.mediarouter.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.bumptech.glide.AbstractC1465c;
import com.p2serv.android.p032ds.R;
import java.io.IOException;
import java.util.ArrayList;
import p173q1.C3445s0;

public final class C1082d extends ArrayAdapter implements AdapterView.OnItemClickListener {

    public final LayoutInflater f3206a;

    public final Drawable f3207b;

    public final Drawable f3208c;

    public final Drawable f3209d;

    public final Drawable f3210e;

    public C1082d(Context context, ArrayList arrayList) {
        super(context, 0, arrayList);
        this.f3206a = LayoutInflater.from(context);
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(new int[]{R.attr.mediaRouteDefaultIconDrawable, R.attr.mediaRouteTvIconDrawable, R.attr.mediaRouteSpeakerIconDrawable, R.attr.mediaRouteSpeakerGroupIconDrawable});
        this.f3207b = AbstractC1465c.m3473h(context, typedArrayObtainStyledAttributes.getResourceId(0, 0));
        this.f3208c = AbstractC1465c.m3473h(context, typedArrayObtainStyledAttributes.getResourceId(1, 0));
        this.f3209d = AbstractC1465c.m3473h(context, typedArrayObtainStyledAttributes.getResourceId(2, 0));
        this.f3210e = AbstractC1465c.m3473h(context, typedArrayObtainStyledAttributes.getResourceId(3, 0));
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override
    public final boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public final View getView(int i6, View view, ViewGroup viewGroup) {
        Drawable drawableCreateFromStream;
        int i10;
        Drawable drawable;
        if (view == null) {
            view = this.f3206a.inflate(R.layout.mr_chooser_list_item, viewGroup, false);
        }
        C3445s0 c3445s0 = (C3445s0) getItem(i6);
        TextView textView = (TextView) view.findViewById(R.id.mr_chooser_route_name);
        TextView textView2 = (TextView) view.findViewById(R.id.mr_chooser_route_desc);
        textView.setText(c3445s0.f11655d);
        String str = c3445s0.f11656e;
        int i11 = c3445s0.f11660i;
        if ((i11 == 2 || i11 == 1) && !TextUtils.isEmpty(str)) {
            textView.setGravity(80);
            textView2.setVisibility(0);
            textView2.setText(str);
        } else {
            textView.setGravity(16);
            textView2.setVisibility(8);
            textView2.setText("");
        }
        view.setEnabled(c3445s0.f11658g);
        ImageView imageView = (ImageView) view.findViewById(R.id.mr_chooser_route_icon);
        if (imageView != null) {
            Uri uri = c3445s0.f11657f;
            if (uri != null) {
                try {
                    drawableCreateFromStream = Drawable.createFromStream(getContext().getContentResolver().openInputStream(uri), null);
                    if (drawableCreateFromStream == null) {
                        i10 = c3445s0.f11665n;
                        if (i10 != 1) {
                            drawable = this.f3208c;
                        } else if (i10 != 2) {
                            drawable = this.f3209d;
                        } else if (c3445s0.m7022e()) {
                            drawable = this.f3210e;
                        } else {
                            drawable = this.f3207b;
                        }
                        drawableCreateFromStream = drawable;
                    }
                } catch (IOException e5) {
                    Log.w("MediaRouteChooserDialog", "Failed to load " + uri, e5);
                }
            } else {
                i10 = c3445s0.f11665n;
                if (i10 != 1) {
                    drawable = this.f3208c;
                } else if (i10 != 2) {
                    drawable = this.f3209d;
                } else if (c3445s0.m7022e()) {
                    drawable = this.f3210e;
                } else {
                    drawable = this.f3207b;
                }
                drawableCreateFromStream = drawable;
            }
            imageView.setImageDrawable(drawableCreateFromStream);
        }
        return view;
    }

    @Override
    public final boolean isEnabled(int i6) {
        return ((C3445s0) getItem(i6)).f11658g;
    }

    @Override
    public final void onItemClick(AdapterView adapterView, View view, int i6, long j10) {
        C3445s0 c3445s0 = (C3445s0) getItem(i6);
        ImageView imageView = (ImageView) view.findViewById(R.id.mr_chooser_route_icon);
        ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.mr_chooser_route_progress_bar);
        if (imageView != null && progressBar != null) {
            imageView.setVisibility(8);
            progressBar.setVisibility(0);
        }
        c3445s0.m7029l(true);
    }
}
