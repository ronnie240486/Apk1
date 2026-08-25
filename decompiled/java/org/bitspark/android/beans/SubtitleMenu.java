package org.bitspark.android.beans;

import com.nmmedit.protect.NativeUtil;
import p003a2.AbstractC0032a;
import p103j9.AbstractC2793f;
import p103j9.AbstractC2796i;

public class SubtitleMenu extends Menu {
    private int groupIndex;
    private boolean isSelected;
    private String label;
    private String language;
    private int rendererIndex;
    private int trackIndex;

    static {
        NativeUtil.classesInit0(19);
    }

    public SubtitleMenu(String str, String str2, int i6, int i10, int i11, boolean z7, int i12, AbstractC2793f abstractC2793f) {
        this(str, str2, i6, i10, i11, (i12 & 32) != 0 ? false : z7);
    }

    public final native int getGroupIndex();

    public final native String getLabel();

    public final native String getLanguage();

    public final native int getRendererIndex();

    public final native int getTrackIndex();

    @Override
    public native boolean isSelected();

    public final native void setGroupIndex(int i6);

    public final native void setLabel(String str);

    public final native void setLanguage(String str);

    public final native void setRendererIndex(int i6);

    @Override
    public native void setSelected(boolean z7);

    public final native void setTrackIndex(int i6);

    public SubtitleMenu(String str, String str2, int i6, int i10, int i11, boolean z7) {
        super(str, z7);
        AbstractC2796i.m5785f(str, AbstractC0032a.m165s("S2XJMkIBR60=\n", "JwSnVTdgIMg=\n"));
        AbstractC2796i.m5785f(str2, AbstractC0032a.m165s("BRZE/Sg=\n", "aXcmmER58jM=\n"));
        this.language = str;
        this.label = str2;
        this.rendererIndex = i6;
        this.groupIndex = i10;
        this.trackIndex = i11;
        this.isSelected = z7;
    }
}
