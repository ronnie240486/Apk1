package p187r4;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.cast.MediaTrack;
import com.p2serv.android.p032ds.R;
import java.util.ArrayList;
import java.util.Locale;
import p018b5.AbstractC1312l;

public final class ViewOnClickListenerC3631u extends ArrayAdapter implements View.OnClickListener {

    public final FragmentActivity f12199a;

    public int f12200b;

    public ViewOnClickListenerC3631u(FragmentActivity fragmentActivity, ArrayList arrayList, int i6) {
        super(fragmentActivity, R.layout.cast_tracks_chooser_dialog_row_layout, arrayList == null ? new ArrayList() : arrayList);
        this.f12199a = fragmentActivity;
        this.f12200b = i6;
    }

    @Override
    public final View getView(int i6, View view, ViewGroup viewGroup) {
        C3630t c3630t;
        FragmentActivity fragmentActivity = this.f12199a;
        if (view == null) {
            LayoutInflater layoutInflater = (LayoutInflater) fragmentActivity.getSystemService("layout_inflater");
            AbstractC1312l.m3198e(layoutInflater);
            view = layoutInflater.inflate(R.layout.cast_tracks_chooser_dialog_row_layout, viewGroup, false);
            c3630t = new C3630t((TextView) view.findViewById(R.id.text), (RadioButton) view.findViewById(R.id.radio));
            view.setTag(c3630t);
        } else {
            c3630t = (C3630t) view.getTag();
            AbstractC1312l.m3198e(c3630t);
        }
        Integer numValueOf = Integer.valueOf(i6);
        RadioButton radioButton = c3630t.f12198b;
        radioButton.setTag(numValueOf);
        radioButton.setChecked(this.f12200b == i6);
        view.setOnClickListener(this);
        MediaTrack mediaTrack = (MediaTrack) getItem(i6);
        AbstractC1312l.m3198e(mediaTrack);
        String str = mediaTrack.f4733f;
        Locale localeForLanguageTag = TextUtils.isEmpty(str) ? null : Locale.forLanguageTag(str);
        String string = mediaTrack.f4732e;
        if (TextUtils.isEmpty(string)) {
            if (mediaTrack.f4734g == 2) {
                string = fragmentActivity.getString(R.string.cast_tracks_chooser_dialog_closed_captions);
            } else if (localeForLanguageTag != null) {
                string = localeForLanguageTag.getDisplayLanguage();
                if (TextUtils.isEmpty(string)) {
                    string = fragmentActivity.getString(R.string.cast_tracks_chooser_dialog_default_track_name, Integer.valueOf(i6 + 1));
                }
            } else {
                string = fragmentActivity.getString(R.string.cast_tracks_chooser_dialog_default_track_name, Integer.valueOf(i6 + 1));
            }
        }
        c3630t.f12197a.setText(string);
        return view;
    }

    @Override
    public final void onClick(View view) {
        C3630t c3630t = (C3630t) view.getTag();
        AbstractC1312l.m3198e(c3630t);
        Object tag = c3630t.f12198b.getTag();
        AbstractC1312l.m3198e(tag);
        this.f12200b = ((Integer) tag).intValue();
        notifyDataSetChanged();
    }
}
