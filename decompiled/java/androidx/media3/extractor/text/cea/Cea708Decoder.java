package androidx.media3.extractor.text.cea;

import android.graphics.Color;
import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import androidx.media3.common.text.Cue;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.CodecSpecificDataUtil;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableBitArray;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.extractor.text.Subtitle;
import androidx.media3.extractor.text.SubtitleDecoderException;
import androidx.media3.extractor.text.SubtitleInputBuffer;
import androidx.media3.extractor.text.SubtitleOutputBuffer;
import com.alibaba.fastjson.asm.Opcodes;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import okio.Utf8;
import p000a.AbstractC0004e;

@UnstableApi
public final class Cea708Decoder extends CeaDecoder {
    private static final int CC_VALID_FLAG = 4;
    private static final int CHARACTER_BIG_CARONS = 42;
    private static final int CHARACTER_BIG_OE = 44;
    private static final int CHARACTER_BOLD_BULLET = 53;
    private static final int CHARACTER_CLOSE_DOUBLE_QUOTE = 52;
    private static final int CHARACTER_CLOSE_SINGLE_QUOTE = 50;
    private static final int CHARACTER_DIAERESIS_Y = 63;
    private static final int CHARACTER_ELLIPSIS = 37;
    private static final int CHARACTER_FIVE_EIGHTHS = 120;
    private static final int CHARACTER_HORIZONTAL_BORDER = 125;
    private static final int CHARACTER_LOWER_LEFT_BORDER = 124;
    private static final int CHARACTER_LOWER_RIGHT_BORDER = 126;
    private static final int CHARACTER_MN = 127;
    private static final int CHARACTER_NBTSP = 33;
    private static final int CHARACTER_ONE_EIGHTH = 118;
    private static final int CHARACTER_OPEN_DOUBLE_QUOTE = 51;
    private static final int CHARACTER_OPEN_SINGLE_QUOTE = 49;
    private static final int CHARACTER_SEVEN_EIGHTHS = 121;
    private static final int CHARACTER_SM = 61;
    private static final int CHARACTER_SMALL_CARONS = 58;
    private static final int CHARACTER_SMALL_OE = 60;
    private static final int CHARACTER_SOLID_BLOCK = 48;
    private static final int CHARACTER_THREE_EIGHTHS = 119;
    private static final int CHARACTER_TM = 57;
    private static final int CHARACTER_TSP = 32;
    private static final int CHARACTER_UPPER_LEFT_BORDER = 127;
    private static final int CHARACTER_UPPER_RIGHT_BORDER = 123;
    private static final int CHARACTER_VERTICAL_BORDER = 122;
    private static final int COMMAND_BS = 8;
    private static final int COMMAND_CLW = 136;
    private static final int COMMAND_CR = 13;
    private static final int COMMAND_CW0 = 128;
    private static final int COMMAND_CW1 = 129;
    private static final int COMMAND_CW2 = 130;
    private static final int COMMAND_CW3 = 131;
    private static final int COMMAND_CW4 = 132;
    private static final int COMMAND_CW5 = 133;
    private static final int COMMAND_CW6 = 134;
    private static final int COMMAND_CW7 = 135;
    private static final int COMMAND_DF0 = 152;
    private static final int COMMAND_DF1 = 153;
    private static final int COMMAND_DF2 = 154;
    private static final int COMMAND_DF3 = 155;
    private static final int COMMAND_DF4 = 156;
    private static final int COMMAND_DF5 = 157;
    private static final int COMMAND_DF6 = 158;
    private static final int COMMAND_DF7 = 159;
    private static final int COMMAND_DLC = 142;
    private static final int COMMAND_DLW = 140;
    private static final int COMMAND_DLY = 141;
    private static final int COMMAND_DSW = 137;
    private static final int COMMAND_ETX = 3;
    private static final int COMMAND_EXT1 = 16;
    private static final int COMMAND_EXT1_END = 23;
    private static final int COMMAND_EXT1_START = 17;
    private static final int COMMAND_FF = 12;
    private static final int COMMAND_HCR = 14;
    private static final int COMMAND_HDW = 138;
    private static final int COMMAND_NUL = 0;
    private static final int COMMAND_P16_END = 31;
    private static final int COMMAND_P16_START = 24;
    private static final int COMMAND_RST = 143;
    private static final int COMMAND_SPA = 144;
    private static final int COMMAND_SPC = 145;
    private static final int COMMAND_SPL = 146;
    private static final int COMMAND_SWA = 151;
    private static final int COMMAND_TGW = 139;
    private static final int DTVCC_PACKET_DATA = 2;
    private static final int DTVCC_PACKET_START = 3;
    private static final int GROUP_C0_END = 31;
    private static final int GROUP_C1_END = 159;
    private static final int GROUP_C2_END = 31;
    private static final int GROUP_C3_END = 159;
    private static final int GROUP_G0_END = 127;
    private static final int GROUP_G1_END = 255;
    private static final int GROUP_G2_END = 127;
    private static final int GROUP_G3_END = 255;
    private static final int NUM_WINDOWS = 8;
    private static final String TAG = "Cea708Decoder";
    private final CueInfoBuilder[] cueInfoBuilders;
    private List<Cue> cues;
    private CueInfoBuilder currentCueInfoBuilder;
    private DtvCcPacket currentDtvCcPacket;
    private int currentWindow;
    private final boolean isWideAspectRatio;
    private List<Cue> lastCues;
    private final int selectedServiceNumber;
    private final ParsableByteArray ccData = new ParsableByteArray();
    private final ParsableBitArray captionChannelPacketData = new ParsableBitArray();
    private int previousSequenceNumber = -1;

    public static final class Cea708CueInfo {
        private static final Comparator<Cea708CueInfo> LEAST_IMPORTANT_FIRST = new C1029a();
        public final Cue cue;
        public final int priority;

        public Cea708CueInfo(CharSequence charSequence, Layout.Alignment alignment, float f, int i6, int i10, float f3, int i11, float f4, boolean z7, int i12, int i13) {
            Cue.Builder size = new Cue.Builder().setText(charSequence).setTextAlignment(alignment).setLine(f, i6).setLineAnchor(i10).setPosition(f3).setPositionAnchor(i11).setSize(f4);
            if (z7) {
                size.setWindowColor(i12);
            }
            this.cue = size.build();
            this.priority = i13;
        }

        public static int lambda$static$0(Cea708CueInfo cea708CueInfo, Cea708CueInfo cea708CueInfo2) {
            return Integer.compare(cea708CueInfo2.priority, cea708CueInfo.priority);
        }
    }

    public static final class CueInfoBuilder {
        private static final int BORDER_AND_EDGE_TYPE_NONE = 0;
        private static final int BORDER_AND_EDGE_TYPE_UNIFORM = 3;
        public static final int COLOR_SOLID_BLACK;
        public static final int COLOR_SOLID_WHITE = getArgbColorFromCeaColor(2, 2, 2, 0);
        public static final int COLOR_TRANSPARENT;
        private static final int DEFAULT_PRIORITY = 4;
        private static final int DIRECTION_BOTTOM_TO_TOP = 3;
        private static final int DIRECTION_LEFT_TO_RIGHT = 0;
        private static final int DIRECTION_RIGHT_TO_LEFT = 1;
        private static final int DIRECTION_TOP_TO_BOTTOM = 2;
        private static final int HORIZONTAL_SIZE = 209;
        private static final int JUSTIFICATION_CENTER = 2;
        private static final int JUSTIFICATION_FULL = 3;
        private static final int JUSTIFICATION_LEFT = 0;
        private static final int JUSTIFICATION_RIGHT = 1;
        private static final int MAXIMUM_ROW_COUNT = 15;
        private static final int PEN_FONT_STYLE_DEFAULT = 0;
        private static final int PEN_FONT_STYLE_MONOSPACED_WITHOUT_SERIFS = 3;
        private static final int PEN_FONT_STYLE_MONOSPACED_WITH_SERIFS = 1;
        private static final int PEN_FONT_STYLE_PROPORTIONALLY_SPACED_WITHOUT_SERIFS = 4;
        private static final int PEN_FONT_STYLE_PROPORTIONALLY_SPACED_WITH_SERIFS = 2;
        private static final int PEN_OFFSET_NORMAL = 1;
        private static final int PEN_SIZE_STANDARD = 1;
        private static final int[] PEN_STYLE_BACKGROUND;
        private static final int[] PEN_STYLE_EDGE_TYPE;
        private static final int[] PEN_STYLE_FONT_STYLE;
        private static final int RELATIVE_CUE_SIZE = 99;
        private static final int VERTICAL_SIZE = 74;
        private static final int[] WINDOW_STYLE_FILL;
        private static final int[] WINDOW_STYLE_JUSTIFICATION;
        private static final int[] WINDOW_STYLE_PRINT_DIRECTION;
        private static final int[] WINDOW_STYLE_SCROLL_DIRECTION;
        private static final boolean[] WINDOW_STYLE_WORD_WRAP;
        private int anchorId;
        private int backgroundColor;
        private int backgroundColorStartPosition;
        private boolean defined;
        private int foregroundColor;
        private int foregroundColorStartPosition;
        private int horizontalAnchor;
        private int italicsStartPosition;
        private int justification;
        private int penStyleId;
        private int priority;
        private boolean relativePositioning;
        private int row;
        private int rowCount;
        private int underlineStartPosition;
        private int verticalAnchor;
        private boolean visible;
        private int windowFillColor;
        private int windowStyleId;
        private final List<SpannableString> rolledUpCaptions = new ArrayList();
        private final SpannableStringBuilder captionStringBuilder = new SpannableStringBuilder();

        static {
            int argbColorFromCeaColor = getArgbColorFromCeaColor(0, 0, 0, 0);
            COLOR_SOLID_BLACK = argbColorFromCeaColor;
            int argbColorFromCeaColor2 = getArgbColorFromCeaColor(0, 0, 0, 3);
            COLOR_TRANSPARENT = argbColorFromCeaColor2;
            WINDOW_STYLE_JUSTIFICATION = new int[]{0, 0, 0, 0, 0, 2, 0};
            WINDOW_STYLE_PRINT_DIRECTION = new int[]{0, 0, 0, 0, 0, 0, 2};
            WINDOW_STYLE_SCROLL_DIRECTION = new int[]{3, 3, 3, 3, 3, 3, 1};
            WINDOW_STYLE_WORD_WRAP = new boolean[]{false, false, false, true, true, true, false};
            WINDOW_STYLE_FILL = new int[]{argbColorFromCeaColor, argbColorFromCeaColor2, argbColorFromCeaColor, argbColorFromCeaColor, argbColorFromCeaColor2, argbColorFromCeaColor, argbColorFromCeaColor};
            PEN_STYLE_FONT_STYLE = new int[]{0, 1, 2, 3, 4, 3, 4};
            PEN_STYLE_EDGE_TYPE = new int[]{0, 0, 0, 0, 0, 3, 3};
            PEN_STYLE_BACKGROUND = new int[]{argbColorFromCeaColor, argbColorFromCeaColor, argbColorFromCeaColor, argbColorFromCeaColor, argbColorFromCeaColor, argbColorFromCeaColor2, argbColorFromCeaColor2};
        }

        public CueInfoBuilder() {
            reset();
        }

        public static int getArgbColorFromCeaColor(int i6, int i10, int i11) {
            return getArgbColorFromCeaColor(i6, i10, i11, 0);
        }

        public void append(char c5) {
            if (c5 != '\n') {
                this.captionStringBuilder.append(c5);
                return;
            }
            this.rolledUpCaptions.add(buildSpannableString());
            this.captionStringBuilder.clear();
            if (this.italicsStartPosition != -1) {
                this.italicsStartPosition = 0;
            }
            if (this.underlineStartPosition != -1) {
                this.underlineStartPosition = 0;
            }
            if (this.foregroundColorStartPosition != -1) {
                this.foregroundColorStartPosition = 0;
            }
            if (this.backgroundColorStartPosition != -1) {
                this.backgroundColorStartPosition = 0;
            }
            while (true) {
                if (this.rolledUpCaptions.size() < this.rowCount && this.rolledUpCaptions.size() < 15) {
                    this.row = this.rolledUpCaptions.size();
                    return;
                }
                this.rolledUpCaptions.remove(0);
            }
        }

        public void backspace() {
            int length = this.captionStringBuilder.length();
            if (length > 0) {
                this.captionStringBuilder.delete(length - 1, length);
            }
        }

        public Cea708CueInfo build() {
            Layout.Alignment alignment;
            float f;
            float f3;
            if (isEmpty()) {
                return null;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            for (int i6 = 0; i6 < this.rolledUpCaptions.size(); i6++) {
                spannableStringBuilder.append((CharSequence) this.rolledUpCaptions.get(i6));
                spannableStringBuilder.append('\n');
            }
            spannableStringBuilder.append((CharSequence) buildSpannableString());
            int i10 = this.justification;
            if (i10 == 0) {
                alignment = Layout.Alignment.ALIGN_NORMAL;
            } else if (i10 == 1) {
                alignment = Layout.Alignment.ALIGN_OPPOSITE;
            } else if (i10 != 2) {
                if (i10 != 3) {
                    throw new IllegalArgumentException("Unexpected justification value: " + this.justification);
                }
                alignment = Layout.Alignment.ALIGN_NORMAL;
            } else {
                alignment = Layout.Alignment.ALIGN_CENTER;
            }
            Layout.Alignment alignment2 = alignment;
            if (this.relativePositioning) {
                f = this.horizontalAnchor / 99.0f;
                f3 = this.verticalAnchor / 99.0f;
            } else {
                f = this.horizontalAnchor / 209.0f;
                f3 = this.verticalAnchor / 74.0f;
            }
            float f4 = (f * 0.9f) + 0.05f;
            float f5 = (f3 * 0.9f) + 0.05f;
            int i11 = this.anchorId;
            int i12 = i11 / 3 == 0 ? 0 : i11 / 3 == 1 ? 1 : 2;
            int i13 = i11 % 3 == 0 ? 0 : i11 % 3 == 1 ? 1 : 2;
            int i14 = this.windowFillColor;
            return new Cea708CueInfo(spannableStringBuilder, alignment2, f5, 0, i12, f4, i13, -3.4028235E38f, i14 != COLOR_SOLID_BLACK, i14, this.priority);
        }

        public SpannableString buildSpannableString() {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.captionStringBuilder);
            int length = spannableStringBuilder.length();
            if (length > 0) {
                if (this.italicsStartPosition != -1) {
                    spannableStringBuilder.setSpan(new StyleSpan(2), this.italicsStartPosition, length, 33);
                }
                if (this.underlineStartPosition != -1) {
                    spannableStringBuilder.setSpan(new UnderlineSpan(), this.underlineStartPosition, length, 33);
                }
                if (this.foregroundColorStartPosition != -1) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.foregroundColor), this.foregroundColorStartPosition, length, 33);
                }
                if (this.backgroundColorStartPosition != -1) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(this.backgroundColor), this.backgroundColorStartPosition, length, 33);
                }
            }
            return new SpannableString(spannableStringBuilder);
        }

        public void clear() {
            this.rolledUpCaptions.clear();
            this.captionStringBuilder.clear();
            this.italicsStartPosition = -1;
            this.underlineStartPosition = -1;
            this.foregroundColorStartPosition = -1;
            this.backgroundColorStartPosition = -1;
            this.row = 0;
        }

        public void defineWindow(boolean z7, int i6, boolean z10, int i10, int i11, int i12, int i13, int i14, int i15) {
            this.defined = true;
            this.visible = z7;
            this.priority = i6;
            this.relativePositioning = z10;
            this.verticalAnchor = i10;
            this.horizontalAnchor = i11;
            this.anchorId = i13;
            int i16 = i12 + 1;
            if (this.rowCount != i16) {
                this.rowCount = i16;
                while (true) {
                    if (this.rolledUpCaptions.size() < this.rowCount && this.rolledUpCaptions.size() < 15) {
                        break;
                    } else {
                        this.rolledUpCaptions.remove(0);
                    }
                }
            }
            if (i14 != 0 && this.windowStyleId != i14) {
                this.windowStyleId = i14;
                int i17 = i14 - 1;
                setWindowAttributes(WINDOW_STYLE_FILL[i17], COLOR_TRANSPARENT, WINDOW_STYLE_WORD_WRAP[i17], 0, WINDOW_STYLE_PRINT_DIRECTION[i17], WINDOW_STYLE_SCROLL_DIRECTION[i17], WINDOW_STYLE_JUSTIFICATION[i17]);
            }
            if (i15 == 0 || this.penStyleId == i15) {
                return;
            }
            this.penStyleId = i15;
            int i18 = i15 - 1;
            setPenAttributes(0, 1, 1, false, false, PEN_STYLE_EDGE_TYPE[i18], PEN_STYLE_FONT_STYLE[i18]);
            setPenColor(COLOR_SOLID_WHITE, PEN_STYLE_BACKGROUND[i18], COLOR_SOLID_BLACK);
        }

        public boolean isDefined() {
            return this.defined;
        }

        public boolean isEmpty() {
            return !isDefined() || (this.rolledUpCaptions.isEmpty() && this.captionStringBuilder.length() == 0);
        }

        public boolean isVisible() {
            return this.visible;
        }

        public void reset() {
            clear();
            this.defined = false;
            this.visible = false;
            this.priority = 4;
            this.relativePositioning = false;
            this.verticalAnchor = 0;
            this.horizontalAnchor = 0;
            this.anchorId = 0;
            this.rowCount = 15;
            this.justification = 0;
            this.windowStyleId = 0;
            this.penStyleId = 0;
            int i6 = COLOR_SOLID_BLACK;
            this.windowFillColor = i6;
            this.foregroundColor = COLOR_SOLID_WHITE;
            this.backgroundColor = i6;
        }

        public void setPenAttributes(int i6, int i10, int i11, boolean z7, boolean z10, int i12, int i13) {
            if (this.italicsStartPosition != -1) {
                if (!z7) {
                    this.captionStringBuilder.setSpan(new StyleSpan(2), this.italicsStartPosition, this.captionStringBuilder.length(), 33);
                    this.italicsStartPosition = -1;
                }
            } else if (z7) {
                this.italicsStartPosition = this.captionStringBuilder.length();
            }
            if (this.underlineStartPosition == -1) {
                if (z10) {
                    this.underlineStartPosition = this.captionStringBuilder.length();
                }
            } else {
                if (z10) {
                    return;
                }
                this.captionStringBuilder.setSpan(new UnderlineSpan(), this.underlineStartPosition, this.captionStringBuilder.length(), 33);
                this.underlineStartPosition = -1;
            }
        }

        public void setPenColor(int i6, int i10, int i11) {
            if (this.foregroundColorStartPosition != -1 && this.foregroundColor != i6) {
                this.captionStringBuilder.setSpan(new ForegroundColorSpan(this.foregroundColor), this.foregroundColorStartPosition, this.captionStringBuilder.length(), 33);
            }
            if (i6 != COLOR_SOLID_WHITE) {
                this.foregroundColorStartPosition = this.captionStringBuilder.length();
                this.foregroundColor = i6;
            }
            if (this.backgroundColorStartPosition != -1 && this.backgroundColor != i10) {
                this.captionStringBuilder.setSpan(new BackgroundColorSpan(this.backgroundColor), this.backgroundColorStartPosition, this.captionStringBuilder.length(), 33);
            }
            if (i10 != COLOR_SOLID_BLACK) {
                this.backgroundColorStartPosition = this.captionStringBuilder.length();
                this.backgroundColor = i10;
            }
        }

        public void setPenLocation(int i6, int i10) {
            if (this.row != i6) {
                append('\n');
            }
            this.row = i6;
        }

        public void setVisibility(boolean z7) {
            this.visible = z7;
        }

        public void setWindowAttributes(int i6, int i10, boolean z7, int i11, int i12, int i13, int i14) {
            this.windowFillColor = i6;
            this.justification = i14;
        }

        public static int getArgbColorFromCeaColor(int i6, int i10, int i11, int i12) {
            int i13;
            Assertions.checkIndex(i6, 0, 4);
            Assertions.checkIndex(i10, 0, 4);
            Assertions.checkIndex(i11, 0, 4);
            Assertions.checkIndex(i12, 0, 4);
            if (i12 == 0 || i12 == 1) {
                i13 = 255;
            } else if (i12 == 2) {
                i13 = 127;
            } else if (i12 != 3) {
                i13 = 255;
            } else {
                i13 = 0;
            }
            return Color.argb(i13, i6 > 1 ? 255 : 0, i10 > 1 ? 255 : 0, i11 > 1 ? 255 : 0);
        }
    }

    public static final class DtvCcPacket {
        int currentIndex = 0;
        public final byte[] packetData;
        public final int packetSize;
        public final int sequenceNumber;

        public DtvCcPacket(int i6, int i10) {
            this.sequenceNumber = i6;
            this.packetSize = i10;
            this.packetData = new byte[(i10 * 2) - 1];
        }
    }

    public Cea708Decoder(int i6, List<byte[]> list) {
        this.selectedServiceNumber = i6 == -1 ? 1 : i6;
        this.isWideAspectRatio = list != null && CodecSpecificDataUtil.parseCea708InitializationData(list);
        this.cueInfoBuilders = new CueInfoBuilder[8];
        for (int i10 = 0; i10 < 8; i10++) {
            this.cueInfoBuilders[i10] = new CueInfoBuilder();
        }
        this.currentCueInfoBuilder = this.cueInfoBuilders[0];
    }

    private void finalizeCurrentPacket() {
        if (this.currentDtvCcPacket == null) {
            return;
        }
        processCurrentPacket();
        this.currentDtvCcPacket = null;
    }

    private List<Cue> getDisplayCues() {
        Cea708CueInfo cea708CueInfoBuild;
        ArrayList arrayList = new ArrayList();
        for (int i6 = 0; i6 < 8; i6++) {
            if (!this.cueInfoBuilders[i6].isEmpty() && this.cueInfoBuilders[i6].isVisible() && (cea708CueInfoBuild = this.cueInfoBuilders[i6].build()) != null) {
                arrayList.add(cea708CueInfoBuild);
            }
        }
        Collections.sort(arrayList, Cea708CueInfo.LEAST_IMPORTANT_FIRST);
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            arrayList2.add(((Cea708CueInfo) arrayList.get(i10)).cue);
        }
        return Collections.unmodifiableList(arrayList2);
    }

    private void handleC0Command(int i6) {
        if (i6 != 0) {
            if (i6 == 3) {
                this.cues = getDisplayCues();
            }
            if (i6 == 8) {
                this.currentCueInfoBuilder.backspace();
                return;
            }
            switch (i6) {
                case 12:
                    resetCueBuilders();
                    break;
                case 13:
                    this.currentCueInfoBuilder.append('\n');
                    break;
                case 14:
                    break;
                default:
                    if (i6 >= 17 && i6 <= 23) {
                        AbstractC0004e.m31y(i6, "Currently unsupported COMMAND_EXT1 Command: ", TAG);
                        this.captionChannelPacketData.skipBits(8);
                    } else if (i6 >= 24 && i6 <= 31) {
                        AbstractC0004e.m31y(i6, "Currently unsupported COMMAND_P16 Command: ", TAG);
                        this.captionChannelPacketData.skipBits(16);
                    } else {
                        AbstractC0004e.m31y(i6, "Invalid C0 command: ", TAG);
                    }
                    break;
            }
        }
    }

    private void handleC1Command(int i6) {
        int i10 = 1;
        switch (i6) {
            case 128:
            case 129:
            case 130:
            case COMMAND_CW3:
            case COMMAND_CW4:
            case COMMAND_CW5:
            case 134:
            case 135:
                int i11 = i6 - 128;
                if (this.currentWindow != i11) {
                    this.currentWindow = i11;
                    this.currentCueInfoBuilder = this.cueInfoBuilders[i11];
                }
                break;
            case 136:
                while (i10 <= 8) {
                    if (this.captionChannelPacketData.readBit()) {
                        this.cueInfoBuilders[8 - i10].clear();
                    }
                    i10++;
                }
                break;
            case COMMAND_DSW:
                for (int i12 = 1; i12 <= 8; i12++) {
                    if (this.captionChannelPacketData.readBit()) {
                        this.cueInfoBuilders[8 - i12].setVisibility(true);
                    }
                }
                break;
            case 138:
                while (i10 <= 8) {
                    if (this.captionChannelPacketData.readBit()) {
                        this.cueInfoBuilders[8 - i10].setVisibility(false);
                    }
                    i10++;
                }
                break;
            case 139:
                for (int i13 = 1; i13 <= 8; i13++) {
                    if (this.captionChannelPacketData.readBit()) {
                        CueInfoBuilder cueInfoBuilder = this.cueInfoBuilders[8 - i13];
                        cueInfoBuilder.setVisibility(!cueInfoBuilder.isVisible());
                    }
                }
                break;
            case COMMAND_DLW:
                while (i10 <= 8) {
                    if (this.captionChannelPacketData.readBit()) {
                        this.cueInfoBuilders[8 - i10].reset();
                    }
                    i10++;
                }
                break;
            case COMMAND_DLY:
                this.captionChannelPacketData.skipBits(8);
                break;
            case COMMAND_DLC:
                break;
            case COMMAND_RST:
                resetCueBuilders();
                break;
            case COMMAND_SPA:
                if (this.currentCueInfoBuilder.isDefined()) {
                    handleSetPenAttributes();
                } else {
                    this.captionChannelPacketData.skipBits(16);
                }
                break;
            case COMMAND_SPC:
                if (this.currentCueInfoBuilder.isDefined()) {
                    handleSetPenColor();
                } else {
                    this.captionChannelPacketData.skipBits(24);
                }
                break;
            case COMMAND_SPL:
                if (this.currentCueInfoBuilder.isDefined()) {
                    handleSetPenLocation();
                } else {
                    this.captionChannelPacketData.skipBits(16);
                }
                break;
            case 147:
            case Opcodes.LCMP:
            case Opcodes.FCMPL:
            case 150:
            default:
                AbstractC0004e.m31y(i6, "Invalid C1 command: ", TAG);
                break;
            case 151:
                if (this.currentCueInfoBuilder.isDefined()) {
                    handleSetWindowAttributes();
                } else {
                    this.captionChannelPacketData.skipBits(32);
                }
                break;
            case COMMAND_DF0:
            case 153:
            case 154:
            case COMMAND_DF3:
            case COMMAND_DF4:
            case COMMAND_DF5:
            case 158:
            case Opcodes.IF_ICMPEQ:
                int i14 = i6 - 152;
                handleDefineWindow(i14);
                if (this.currentWindow != i14) {
                    this.currentWindow = i14;
                    this.currentCueInfoBuilder = this.cueInfoBuilders[i14];
                }
                break;
        }
    }

    private void handleC2Command(int i6) {
        if (i6 <= 7) {
            return;
        }
        if (i6 <= 15) {
            this.captionChannelPacketData.skipBits(8);
        } else if (i6 <= 23) {
            this.captionChannelPacketData.skipBits(16);
        } else if (i6 <= 31) {
            this.captionChannelPacketData.skipBits(24);
        }
    }

    private void handleC3Command(int i6) {
        if (i6 <= 135) {
            this.captionChannelPacketData.skipBits(32);
            return;
        }
        if (i6 <= COMMAND_RST) {
            this.captionChannelPacketData.skipBits(40);
        } else if (i6 <= 159) {
            this.captionChannelPacketData.skipBits(2);
            this.captionChannelPacketData.skipBits(this.captionChannelPacketData.readBits(6) * 8);
        }
    }

    private void handleDefineWindow(int i6) {
        CueInfoBuilder cueInfoBuilder = this.cueInfoBuilders[i6];
        this.captionChannelPacketData.skipBits(2);
        boolean bit = this.captionChannelPacketData.readBit();
        this.captionChannelPacketData.skipBits(2);
        int bits = this.captionChannelPacketData.readBits(3);
        boolean bit2 = this.captionChannelPacketData.readBit();
        int bits2 = this.captionChannelPacketData.readBits(7);
        int bits3 = this.captionChannelPacketData.readBits(8);
        int bits4 = this.captionChannelPacketData.readBits(4);
        int bits5 = this.captionChannelPacketData.readBits(4);
        this.captionChannelPacketData.skipBits(2);
        this.captionChannelPacketData.skipBits(6);
        this.captionChannelPacketData.skipBits(2);
        cueInfoBuilder.defineWindow(bit, bits, bit2, bits2, bits3, bits5, bits4, this.captionChannelPacketData.readBits(3), this.captionChannelPacketData.readBits(3));
    }

    private void handleG0Character(int i6) {
        if (i6 == 127) {
            this.currentCueInfoBuilder.append((char) 9835);
        } else {
            this.currentCueInfoBuilder.append((char) (i6 & 255));
        }
    }

    private void handleG1Character(int i6) {
        this.currentCueInfoBuilder.append((char) (i6 & 255));
    }

    private void handleG2Character(int i6) {
        if (i6 == 32) {
            this.currentCueInfoBuilder.append(' ');
        }
        if (i6 == 33) {
            this.currentCueInfoBuilder.append((char) 160);
            return;
        }
        if (i6 == CHARACTER_ELLIPSIS) {
            this.currentCueInfoBuilder.append((char) 8230);
            return;
        }
        if (i6 == 42) {
            this.currentCueInfoBuilder.append((char) 352);
            return;
        }
        if (i6 == CHARACTER_BIG_OE) {
            this.currentCueInfoBuilder.append((char) 338);
            return;
        }
        if (i6 == CHARACTER_DIAERESIS_Y) {
            this.currentCueInfoBuilder.append((char) 376);
            return;
        }
        if (i6 == 57) {
            this.currentCueInfoBuilder.append((char) 8482);
            return;
        }
        if (i6 == 58) {
            this.currentCueInfoBuilder.append((char) 353);
            return;
        }
        if (i6 == CHARACTER_SMALL_OE) {
            this.currentCueInfoBuilder.append((char) 339);
            return;
        }
        if (i6 == CHARACTER_SM) {
            this.currentCueInfoBuilder.append((char) 8480);
            return;
        }
        switch (i6) {
            case 48:
                this.currentCueInfoBuilder.append((char) 9608);
                break;
            case 49:
                this.currentCueInfoBuilder.append((char) 8216);
                break;
            case 50:
                this.currentCueInfoBuilder.append((char) 8217);
                break;
            case CHARACTER_OPEN_DOUBLE_QUOTE:
                this.currentCueInfoBuilder.append((char) 8220);
                break;
            case CHARACTER_CLOSE_DOUBLE_QUOTE:
                this.currentCueInfoBuilder.append((char) 8221);
                break;
            case CHARACTER_BOLD_BULLET:
                this.currentCueInfoBuilder.append((char) 8226);
                break;
            default:
                switch (i6) {
                    case CHARACTER_ONE_EIGHTH:
                        this.currentCueInfoBuilder.append((char) 8539);
                        break;
                    case CHARACTER_THREE_EIGHTHS:
                        this.currentCueInfoBuilder.append((char) 8540);
                        break;
                    case CHARACTER_FIVE_EIGHTHS:
                        this.currentCueInfoBuilder.append((char) 8541);
                        break;
                    case CHARACTER_SEVEN_EIGHTHS:
                        this.currentCueInfoBuilder.append((char) 8542);
                        break;
                    case CHARACTER_VERTICAL_BORDER:
                        this.currentCueInfoBuilder.append((char) 9474);
                        break;
                    case CHARACTER_UPPER_RIGHT_BORDER:
                        this.currentCueInfoBuilder.append((char) 9488);
                        break;
                    case CHARACTER_LOWER_LEFT_BORDER:
                        this.currentCueInfoBuilder.append((char) 9492);
                        break;
                    case CHARACTER_HORIZONTAL_BORDER:
                        this.currentCueInfoBuilder.append((char) 9472);
                        break;
                    case 126:
                        this.currentCueInfoBuilder.append((char) 9496);
                        break;
                    case 127:
                        this.currentCueInfoBuilder.append((char) 9484);
                        break;
                    default:
                        AbstractC0004e.m31y(i6, "Invalid G2 character: ", TAG);
                        break;
                }
                break;
        }
    }

    private void handleG3Character(int i6) {
        if (i6 == 160) {
            this.currentCueInfoBuilder.append((char) 13252);
        } else {
            AbstractC0004e.m31y(i6, "Invalid G3 character: ", TAG);
            this.currentCueInfoBuilder.append('_');
        }
    }

    private void handleSetPenAttributes() {
        this.currentCueInfoBuilder.setPenAttributes(this.captionChannelPacketData.readBits(4), this.captionChannelPacketData.readBits(2), this.captionChannelPacketData.readBits(2), this.captionChannelPacketData.readBit(), this.captionChannelPacketData.readBit(), this.captionChannelPacketData.readBits(3), this.captionChannelPacketData.readBits(3));
    }

    private void handleSetPenColor() {
        int argbColorFromCeaColor = CueInfoBuilder.getArgbColorFromCeaColor(this.captionChannelPacketData.readBits(2), this.captionChannelPacketData.readBits(2), this.captionChannelPacketData.readBits(2), this.captionChannelPacketData.readBits(2));
        int argbColorFromCeaColor2 = CueInfoBuilder.getArgbColorFromCeaColor(this.captionChannelPacketData.readBits(2), this.captionChannelPacketData.readBits(2), this.captionChannelPacketData.readBits(2), this.captionChannelPacketData.readBits(2));
        this.captionChannelPacketData.skipBits(2);
        this.currentCueInfoBuilder.setPenColor(argbColorFromCeaColor, argbColorFromCeaColor2, CueInfoBuilder.getArgbColorFromCeaColor(this.captionChannelPacketData.readBits(2), this.captionChannelPacketData.readBits(2), this.captionChannelPacketData.readBits(2)));
    }

    private void handleSetPenLocation() {
        this.captionChannelPacketData.skipBits(4);
        int bits = this.captionChannelPacketData.readBits(4);
        this.captionChannelPacketData.skipBits(2);
        this.currentCueInfoBuilder.setPenLocation(bits, this.captionChannelPacketData.readBits(6));
    }

    private void handleSetWindowAttributes() {
        int argbColorFromCeaColor = CueInfoBuilder.getArgbColorFromCeaColor(this.captionChannelPacketData.readBits(2), this.captionChannelPacketData.readBits(2), this.captionChannelPacketData.readBits(2), this.captionChannelPacketData.readBits(2));
        int bits = this.captionChannelPacketData.readBits(2);
        int argbColorFromCeaColor2 = CueInfoBuilder.getArgbColorFromCeaColor(this.captionChannelPacketData.readBits(2), this.captionChannelPacketData.readBits(2), this.captionChannelPacketData.readBits(2));
        if (this.captionChannelPacketData.readBit()) {
            bits |= 4;
        }
        boolean bit = this.captionChannelPacketData.readBit();
        int bits2 = this.captionChannelPacketData.readBits(2);
        int bits3 = this.captionChannelPacketData.readBits(2);
        int bits4 = this.captionChannelPacketData.readBits(2);
        this.captionChannelPacketData.skipBits(8);
        this.currentCueInfoBuilder.setWindowAttributes(argbColorFromCeaColor, argbColorFromCeaColor2, bit, bits, bits2, bits3, bits4);
    }

    private void processCurrentPacket() {
        DtvCcPacket dtvCcPacket = this.currentDtvCcPacket;
        if (dtvCcPacket.currentIndex != (dtvCcPacket.packetSize * 2) - 1) {
            Log.m1713d(TAG, "DtvCcPacket ended prematurely; size is " + ((this.currentDtvCcPacket.packetSize * 2) - 1) + ", but current index is " + this.currentDtvCcPacket.currentIndex + " (sequence number " + this.currentDtvCcPacket.sequenceNumber + ");");
        }
        ParsableBitArray parsableBitArray = this.captionChannelPacketData;
        DtvCcPacket dtvCcPacket2 = this.currentDtvCcPacket;
        parsableBitArray.reset(dtvCcPacket2.packetData, dtvCcPacket2.currentIndex);
        boolean z7 = false;
        while (this.captionChannelPacketData.bitsLeft() > 0) {
            int bits = this.captionChannelPacketData.readBits(3);
            int bits2 = this.captionChannelPacketData.readBits(5);
            if (bits == 7) {
                this.captionChannelPacketData.skipBits(2);
                bits = this.captionChannelPacketData.readBits(6);
                if (bits < 7) {
                    AbstractC0004e.m31y(bits, "Invalid extended service number: ", TAG);
                }
            }
            if (bits2 == 0) {
                if (bits == 0) {
                    break;
                }
                Log.m1719w(TAG, "serviceNumber is non-zero (" + bits + ") when blockSize is 0");
                break;
            }
            if (bits != this.selectedServiceNumber) {
                this.captionChannelPacketData.skipBytes(bits2);
            } else {
                int position = (bits2 * 8) + this.captionChannelPacketData.getPosition();
                while (this.captionChannelPacketData.getPosition() < position) {
                    int bits3 = this.captionChannelPacketData.readBits(8);
                    if (bits3 == 16) {
                        int bits4 = this.captionChannelPacketData.readBits(8);
                        if (bits4 <= 31) {
                            handleC2Command(bits4);
                        } else {
                            if (bits4 <= 127) {
                                handleG2Character(bits4);
                            } else if (bits4 <= 159) {
                                handleC3Command(bits4);
                            } else if (bits4 <= 255) {
                                handleG3Character(bits4);
                            } else {
                                AbstractC0004e.m31y(bits4, "Invalid extended command: ", TAG);
                            }
                            z7 = true;
                        }
                    } else if (bits3 <= 31) {
                        handleC0Command(bits3);
                    } else {
                        if (bits3 <= 127) {
                            handleG0Character(bits3);
                        } else if (bits3 <= 159) {
                            handleC1Command(bits3);
                        } else if (bits3 <= 255) {
                            handleG1Character(bits3);
                        } else {
                            AbstractC0004e.m31y(bits3, "Invalid base command: ", TAG);
                        }
                        z7 = true;
                    }
                }
            }
        }
        if (z7) {
            this.cues = getDisplayCues();
        }
    }

    private void resetCueBuilders() {
        for (int i6 = 0; i6 < 8; i6++) {
            this.cueInfoBuilders[i6].reset();
        }
    }

    @Override
    public Subtitle createSubtitle() {
        List<Cue> list = this.cues;
        this.lastCues = list;
        return new CeaSubtitle((List) Assertions.checkNotNull(list));
    }

    @Override
    public void decode(SubtitleInputBuffer subtitleInputBuffer) {
        ByteBuffer byteBuffer = (ByteBuffer) Assertions.checkNotNull(subtitleInputBuffer.data);
        this.ccData.reset(byteBuffer.array(), byteBuffer.limit());
        while (this.ccData.bytesLeft() >= 3) {
            int unsignedByte = this.ccData.readUnsignedByte();
            int i6 = unsignedByte & 3;
            boolean z7 = (unsignedByte & 4) == 4;
            byte unsignedByte2 = (byte) this.ccData.readUnsignedByte();
            byte unsignedByte3 = (byte) this.ccData.readUnsignedByte();
            if (i6 == 2 || i6 == 3) {
                if (z7) {
                    if (i6 == 3) {
                        finalizeCurrentPacket();
                        int i10 = (unsignedByte2 & 192) >> 6;
                        int i11 = this.previousSequenceNumber;
                        if (i11 != -1 && i10 != (i11 + 1) % 4) {
                            resetCueBuilders();
                            Log.m1719w(TAG, "Sequence number discontinuity. previous=" + this.previousSequenceNumber + " current=" + i10);
                        }
                        this.previousSequenceNumber = i10;
                        int i12 = unsignedByte2 & Utf8.REPLACEMENT_BYTE;
                        if (i12 == 0) {
                            i12 = 64;
                        }
                        DtvCcPacket dtvCcPacket = new DtvCcPacket(i10, i12);
                        this.currentDtvCcPacket = dtvCcPacket;
                        byte[] bArr = dtvCcPacket.packetData;
                        int i13 = dtvCcPacket.currentIndex;
                        dtvCcPacket.currentIndex = i13 + 1;
                        bArr[i13] = unsignedByte3;
                    } else {
                        Assertions.checkArgument(i6 == 2);
                        DtvCcPacket dtvCcPacket2 = this.currentDtvCcPacket;
                        if (dtvCcPacket2 == null) {
                            Log.m1715e(TAG, "Encountered DTVCC_PACKET_DATA before DTVCC_PACKET_START");
                        } else {
                            byte[] bArr2 = dtvCcPacket2.packetData;
                            int i14 = dtvCcPacket2.currentIndex;
                            int i15 = i14 + 1;
                            dtvCcPacket2.currentIndex = i15;
                            bArr2[i14] = unsignedByte2;
                            dtvCcPacket2.currentIndex = i14 + 2;
                            bArr2[i15] = unsignedByte3;
                        }
                    }
                    DtvCcPacket dtvCcPacket3 = this.currentDtvCcPacket;
                    if (dtvCcPacket3.currentIndex == (dtvCcPacket3.packetSize * 2) - 1) {
                        finalizeCurrentPacket();
                    }
                }
            }
        }
    }

    @Override
    public SubtitleInputBuffer dequeueInputBuffer() throws SubtitleDecoderException {
        return super.dequeueInputBuffer();
    }

    @Override
    public SubtitleOutputBuffer dequeueOutputBuffer() throws SubtitleDecoderException {
        return super.dequeueOutputBuffer();
    }

    @Override
    public void flush() {
        super.flush();
        this.cues = null;
        this.lastCues = null;
        this.currentWindow = 0;
        this.currentCueInfoBuilder = this.cueInfoBuilders[0];
        resetCueBuilders();
        this.currentDtvCcPacket = null;
    }

    @Override
    public String getName() {
        return TAG;
    }

    @Override
    public boolean isNewSubtitleDataAvailable() {
        return this.cues != this.lastCues;
    }

    @Override
    public void queueInputBuffer(SubtitleInputBuffer subtitleInputBuffer) throws SubtitleDecoderException {
        super.queueInputBuffer(subtitleInputBuffer);
    }

    @Override
    public void release() {
        super.release();
    }

    @Override
    public void setPositionUs(long j10) {
        super.setPositionUs(j10);
    }
}
