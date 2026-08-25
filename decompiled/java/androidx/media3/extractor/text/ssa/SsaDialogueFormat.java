package androidx.media3.extractor.text.ssa;

import android.text.TextUtils;
import androidx.media3.common.util.Assertions;
import p020b7.AbstractC1332b;

final class SsaDialogueFormat {
    public final int endTimeIndex;
    public final int length;
    public final int startTimeIndex;
    public final int styleIndex;
    public final int textIndex;

    private SsaDialogueFormat(int i6, int i10, int i11, int i12, int i13) {
        this.startTimeIndex = i6;
        this.endTimeIndex = i10;
        this.styleIndex = i11;
        this.textIndex = i12;
        this.length = i13;
    }

    public static SsaDialogueFormat fromFormatLine(String str) {
        Assertions.checkArgument(str.startsWith("Format:"));
        String[] strArrSplit = TextUtils.split(str.substring(7), ",");
        int i6 = -1;
        int i10 = -1;
        int i11 = -1;
        int i12 = -1;
        for (int i13 = 0; i13 < strArrSplit.length; i13++) {
            String strM3231v = AbstractC1332b.m3231v(strArrSplit[i13].trim());
            strM3231v.getClass();
            switch (strM3231v) {
                case "end":
                    i10 = i13;
                    break;
                case "text":
                    i12 = i13;
                    break;
                case "start":
                    i6 = i13;
                    break;
                case "style":
                    i11 = i13;
                    break;
            }
        }
        if (i6 == -1 || i10 == -1 || i12 == -1) {
            return null;
        }
        return new SsaDialogueFormat(i6, i10, i11, i12, strArrSplit.length);
    }
}
