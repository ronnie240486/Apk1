package p063fa;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;
import com.p2serv.android.p032ds.R;
import ga.C2621d;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.bitspark.android.SpkApplication;
import org.bitspark.android.beans.ChannelBean;
import org.bitspark.android.beans.EpgBeans;
import org.bitspark.android.utils.AbstractC3331m;
import p003a2.AbstractC0032a;
import p055ea.AbstractC2442h;
import p055ea.AbstractC2460q;
import p116ka.C2933n;
import p116ka.ViewOnKeyListenerC2937r;

public final class C2536k extends BaseExpandableListAdapter {

    public static String f8833n;

    public final HashMap f8834a;

    public final ExpandableListView f8835b;

    public final ArrayList f8836c;

    public final String[] f8837d;

    public int f8838e;

    public boolean f8839f;

    public final int f8840g;

    public final SimpleDateFormat f8841h = new SimpleDateFormat(AbstractC0032a.m165s("N3RYNUyBwBoWVQ==\n", "cjEdGWzMjTc=\n"), Locale.getDefault());

    public final long f8842i;

    public final HashMap f8843j;

    public final ViewOnKeyListenerC2937r f8844k;

    public final HashMap f8845l;

    public final C2933n f8846m;

    static {
        AbstractC0032a.m165s("ewfDPdN7UllbBQ==\n", "PnekfLcaIi0=\n");
        f8833n = "";
    }

    public C2536k(HashMap map, ViewOnKeyListenerC2937r viewOnKeyListenerC2937r, ExpandableListView expandableListView, boolean z7, int i6, C2933n c2933n) {
        HashMap map2 = new HashMap();
        this.f8845l = map2;
        map2.clear();
        this.f8846m = c2933n;
        this.f8840g = i6;
        this.f8835b = expandableListView;
        this.f8839f = z7;
        this.f8844k = viewOnKeyListenerC2937r;
        this.f8834a = map;
        expandableListView.setOnGroupExpandListener(new C2515d(this));
        expandableListView.setOnGroupCollapseListener(new C2518e(this));
        ArrayList arrayList = new ArrayList(map.keySet());
        long time = new Date().getTime() + AbstractC3331m.f11243a;
        this.f8842i = AbstractC3331m.m6753c(time);
        String str = AbstractC2442h.f8595a;
        Collections.sort(arrayList);
        HashMap map3 = new HashMap();
        if (C2621d.f9109c == null || C2621d.f9109c.get(Integer.valueOf(i6)) == null || !((ChannelBean) C2621d.f9109c.get(Integer.valueOf(i6))).isHasPlayBack()) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Long l9 = (Long) it.next();
                if (l9.longValue() < this.f8842i) {
                    it.remove();
                } else {
                    List list = (List) map.get(l9);
                    ArrayList arrayList2 = new ArrayList();
                    for (int i10 = 0; i10 < list.size(); i10++) {
                        EpgBeans.EpgBean epgBean = (EpgBeans.EpgBean) list.get(i10);
                        if (epgBean.getEndTime() != null) {
                            if (epgBean.getEndTime().longValue() < time) {
                                arrayList2.add(Integer.valueOf(i10));
                            }
                        } else if (epgBean.getTime().longValue() < time) {
                            arrayList2.add(Integer.valueOf(i10));
                        }
                    }
                    map3.put(l9, arrayList2);
                }
            }
        }
        this.f8836c = arrayList;
        this.f8837d = new String[arrayList.size()];
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            this.f8837d[i11] = this.f8841h.format(this.f8836c.get(i11));
        }
        this.f8843j = map3;
    }

    @Override
    public final Object getChild(int i6, int i10) {
        return ((List) this.f8834a.get(this.f8836c.get(i6))).get(i10);
    }

    @Override
    public final long getChildId(int i6, int i10) {
        return i10;
    }

    @Override
    public final View getChildView(int i6, int i10, boolean z7, View view, ViewGroup viewGroup) {
        if (this.f8836c.get(i6) != null && this.f8843j.get(this.f8836c.get(i6)) != null) {
            Iterator it = ((ArrayList) this.f8843j.get(this.f8836c.get(i6))).iterator();
            while (it.hasNext()) {
                if (((Integer) it.next()).intValue() <= i10) {
                    i10++;
                }
            }
        }
        List list = (List) this.f8834a.get(this.f8836c.get(i6));
        String playbackUrl = ((EpgBeans.EpgBean) list.get(i10)).getPlaybackUrl();
        if (view == null) {
            view = (C2621d.f9109c == null || C2621d.f9109c.get(Integer.valueOf(this.f8840g)) == null || !((ChannelBean) C2621d.f9109c.get(Integer.valueOf(this.f8840g))).isHasPlayBack()) ? View.inflate(viewGroup.getContext(), R.layout.epg_item_1line, null) : View.inflate(viewGroup.getContext(), R.layout.epg_item, null);
        }
        view.setOnKeyListener(new ViewOnKeyListenerC2530i(this, i6, z7));
        view.setOnClickListener(new ViewOnClickListenerC2524g(1));
        view.setOnTouchListener(new ViewOnTouchListenerC2533j(this, i6, i10));
        TextView textView = (TextView) view.findViewById(R.id.epg_item_name);
        TextView textView2 = (TextView) view.findViewById(R.id.epg_item_time);
        ImageView imageView = (ImageView) view.findViewById(R.id.epg_item_icon);
        if (list.size() > 0) {
            if (C2621d.f9109c == null || C2621d.f9109c.get(Integer.valueOf(this.f8840g)) == null || ((ChannelBean) C2621d.f9109c.get(Integer.valueOf(this.f8840g))).isHasPlayBack()) {
                textView.setText(((EpgBeans.EpgBean) list.get(i10)).getName());
                if (imageView == null || textView2 == null) {
                    view.setTag(R.id.chid, Integer.valueOf(this.f8840g));
                } else {
                    if (playbackUrl == null || playbackUrl.equals("")) {
                        imageView.setVisibility(8);
                        textView.setTextColor(SpkApplication.f11160c.getApplicationContext().getResources().getColor(R.color.channel_epg_no_addr_txt));
                        textView2.setTextColor(SpkApplication.f11160c.getApplicationContext().getResources().getColor(R.color.channel_epg_no_addr_txt));
                    } else {
                        imageView.setVisibility(0);
                        textView.setTextColor(SpkApplication.f11160c.getApplicationContext().getResources().getColor(R.color.white));
                        textView2.setTextColor(SpkApplication.f11160c.getApplicationContext().getResources().getColor(R.color.channel_epg_sub_txt));
                        ImageView imageView2 = (ImageView) view.findViewById(R.id.epg_item_icon);
                        if (((EpgBeans.EpgBean) list.get(i10)).getId().equals(f8833n)) {
                            imageView2.setImageResource(R.mipmap.live_play);
                        } else {
                            imageView2.setImageResource(R.mipmap.live);
                        }
                    }
                    String strM6758h = AbstractC3331m.m6758h(((EpgBeans.EpgBean) list.get(i10)).getTime());
                    String strM6758h2 = AbstractC3331m.m6758h(((EpgBeans.EpgBean) list.get(i10)).getEndTime());
                    StringBuilder sbM5498l = AbstractC2460q.m5498l(strM6758h);
                    sbM5498l.append(AbstractC0032a.m165s("1w==\n", "+jr9VNdmivk=\n"));
                    sbM5498l.append(strM6758h2);
                    textView2.setText(sbM5498l.toString());
                    view.setTag(list.get(i10));
                }
            } else {
                textView.setTextColor(SpkApplication.f11160c.getApplicationContext().getResources().getColor(R.color.channel_epg_no_addr_txt));
                textView.setText(AbstractC3331m.m6758h(((EpgBeans.EpgBean) list.get(i10)).getTime()) + " " + ((EpgBeans.EpgBean) list.get(i10)).getName());
            }
            view.setTag(R.id.chid, Integer.valueOf(this.f8840g));
        }
        return view;
    }

    @Override
    public final int getChildrenCount(int i6) {
        ArrayList arrayList = this.f8836c;
        List list = (List) this.f8834a.get(arrayList.get(i6));
        if (list == null || list.size() <= 0) {
            return 0;
        }
        HashMap map = this.f8843j;
        return list.size() - (map.get(arrayList.get(i6)) != null ? ((ArrayList) map.get(arrayList.get(i6))).size() : 0);
    }

    @Override
    public final Object getGroup(int i6) {
        return this.f8836c.get(i6);
    }

    @Override
    public final int getGroupCount() {
        ArrayList arrayList = this.f8836c;
        if (arrayList.size() > 0) {
            return arrayList.size();
        }
        return 0;
    }

    @Override
    public final long getGroupId(int i6) {
        return i6;
    }

    @Override
    public final View getGroupView(int i6, boolean z7, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = View.inflate(viewGroup.getContext(), R.layout.epg_day_item, null);
        }
        view.setOnKeyListener(new ViewOnKeyListenerC2521f(i6, 0, this));
        view.setOnClickListener(new ViewOnClickListenerC2524g(0));
        view.setOnTouchListener(new ViewOnTouchListenerC2527h(i6, 0, this));
        TextView textView = (TextView) view.findViewById(R.id.epg_day_text);
        ArrayList arrayList = this.f8836c;
        if (arrayList.get(i6) != null && arrayList.size() > 0) {
            textView.setText(this.f8837d[i6]);
            ImageView imageView = (ImageView) view.findViewById(R.id.epg_group_arrow);
            if (this.f8842i == ((Long) arrayList.get(i6)).longValue()) {
                boolean z10 = this.f8839f;
                ExpandableListView expandableListView = this.f8835b;
                if (z10) {
                    expandableListView.expandGroup(i6);
                } else {
                    expandableListView.collapseGroup(i6);
                }
                this.f8838e = i6;
            }
            HashMap map = this.f8845l;
            if (map.get(Integer.valueOf(i6)) != null) {
                if (((Boolean) map.get(Integer.valueOf(i6))).booleanValue()) {
                    imageView.setImageResource(R.mipmap.up);
                } else {
                    imageView.setImageResource(R.mipmap.down);
                }
            } else if (z7) {
                imageView.setImageResource(R.mipmap.down);
            } else {
                imageView.setImageResource(R.mipmap.up);
            }
        }
        return view;
    }

    @Override
    public final boolean hasStableIds() {
        return false;
    }

    @Override
    public final boolean isChildSelectable(int i6, int i10) {
        return true;
    }
}
