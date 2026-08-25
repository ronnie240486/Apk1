package androidx.media3.extractor.metadata.id3;

import androidx.media3.common.MediaMetadata;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import p000a.AbstractC0004e;
import p041d7.AbstractC2301u1;
import p187r4.AbstractC3612b;

@UnstableApi
public final class TextInformationFrame extends Id3Frame {
    public final String description;

    @Deprecated
    public final String value;
    public final AbstractC2301u1 values;

    public TextInformationFrame(String str, String str2, List<String> list) {
        super(str);
        Assertions.checkArgument(!list.isEmpty());
        this.description = str2;
        AbstractC2301u1 abstractC2301u1M5272n = AbstractC2301u1.m5272n(list);
        this.values = abstractC2301u1M5272n;
        this.value = (String) abstractC2301u1M5272n.get(0);
    }

    private static List<Integer> parseId3v2point4TimestampFrameForDate(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            if (str.length() >= 10) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(0, 4))));
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(5, 7))));
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(8, 10))));
            } else if (str.length() >= 7) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(0, 4))));
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(5, 7))));
            } else if (str.length() >= 4) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(0, 4))));
            }
            return arrayList;
        } catch (NumberFormatException unused) {
            return new ArrayList();
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || TextInformationFrame.class != obj.getClass()) {
            return false;
        }
        TextInformationFrame textInformationFrame = (TextInformationFrame) obj;
        return Objects.equals(this.f3093id, textInformationFrame.f3093id) && Objects.equals(this.description, textInformationFrame.description) && this.values.equals(textInformationFrame.values);
    }

    public int hashCode() {
        int iM14h = AbstractC0004e.m14h(527, 31, this.f3093id);
        String str = this.description;
        return this.values.hashCode() + ((iM14h + (str != null ? str.hashCode() : 0)) * 31);
    }

    @Override
    public void populateMediaMetadata(MediaMetadata.Builder builder) {
        String str = this.f3093id;
        str.getClass();
        byte b8 = -1;
        switch (str.hashCode()) {
            case 82815:
                if (str.equals("TAL")) {
                    b8 = 0;
                }
                break;
            case 82878:
                if (str.equals("TCM")) {
                    b8 = 1;
                }
                break;
            case 82897:
                if (str.equals("TDA")) {
                    b8 = 2;
                }
                break;
            case 83253:
                if (str.equals("TP1")) {
                    b8 = 3;
                }
                break;
            case 83254:
                if (str.equals("TP2")) {
                    b8 = 4;
                }
                break;
            case 83255:
                if (str.equals("TP3")) {
                    b8 = 5;
                }
                break;
            case 83341:
                if (str.equals("TRK")) {
                    b8 = 6;
                }
                break;
            case 83378:
                if (str.equals("TT2")) {
                    b8 = 7;
                }
                break;
            case 83536:
                if (str.equals("TXT")) {
                    b8 = 8;
                }
                break;
            case 83552:
                if (str.equals("TYE")) {
                    b8 = 9;
                }
                break;
            case 2567331:
                if (str.equals("TALB")) {
                    b8 = 10;
                }
                break;
            case 2569357:
                if (str.equals("TCOM")) {
                    b8 = 11;
                }
                break;
            case 2569358:
                if (str.equals("TCON")) {
                    b8 = 12;
                }
                break;
            case 2569891:
                if (str.equals("TDAT")) {
                    b8 = 13;
                }
                break;
            case 2570401:
                if (str.equals("TDRC")) {
                    b8 = 14;
                }
                break;
            case 2570410:
                if (str.equals("TDRL")) {
                    b8 = 15;
                }
                break;
            case 2571565:
                if (str.equals("TEXT")) {
                    b8 = 16;
                }
                break;
            case 2575251:
                if (str.equals("TIT2")) {
                    b8 = 17;
                }
                break;
            case 2581512:
                if (str.equals("TPE1")) {
                    b8 = 18;
                }
                break;
            case 2581513:
                if (str.equals("TPE2")) {
                    b8 = 19;
                }
                break;
            case 2581514:
                if (str.equals("TPE3")) {
                    b8 = 20;
                }
                break;
            case 2583398:
                if (str.equals("TRCK")) {
                    b8 = 21;
                }
                break;
            case 2590194:
                if (str.equals("TYER")) {
                    b8 = 22;
                }
                break;
        }
        try {
            switch (b8) {
                case 0:
                case 10:
                    builder.setAlbumTitle((CharSequence) this.values.get(0));
                    break;
                case 1:
                case 11:
                    builder.setComposer((CharSequence) this.values.get(0));
                    break;
                case 2:
                case 13:
                    String str2 = (String) this.values.get(0);
                    builder.setRecordingMonth(Integer.valueOf(Integer.parseInt(str2.substring(2, 4)))).setRecordingDay(Integer.valueOf(Integer.parseInt(str2.substring(0, 2))));
                    break;
                case 3:
                case 18:
                    builder.setArtist((CharSequence) this.values.get(0));
                    break;
                case 4:
                case 19:
                    builder.setAlbumArtist((CharSequence) this.values.get(0));
                    break;
                case 5:
                case 20:
                    builder.setConductor((CharSequence) this.values.get(0));
                    break;
                case 6:
                case 21:
                    String[] strArrSplit = Util.split((String) this.values.get(0), "/");
                    builder.setTrackNumber(Integer.valueOf(Integer.parseInt(strArrSplit[0]))).setTotalTrackCount(strArrSplit.length > 1 ? Integer.valueOf(Integer.parseInt(strArrSplit[1])) : null);
                    break;
                case 7:
                case 17:
                    builder.setTitle((CharSequence) this.values.get(0));
                    break;
                case 8:
                case 16:
                    builder.setWriter((CharSequence) this.values.get(0));
                    break;
                case 9:
                case 22:
                    builder.setRecordingYear(Integer.valueOf(Integer.parseInt((String) this.values.get(0))));
                    break;
                case 12:
                    Integer numM7259P = AbstractC3612b.m7259P((String) this.values.get(0));
                    if (numM7259P != null) {
                        String strResolveV1Genre = Id3Util.resolveV1Genre(numM7259P.intValue());
                        if (strResolveV1Genre != null) {
                            builder.setGenre(strResolveV1Genre);
                        }
                    } else {
                        builder.setGenre((CharSequence) this.values.get(0));
                    }
                    break;
                case 14:
                    List<Integer> id3v2point4TimestampFrameForDate = parseId3v2point4TimestampFrameForDate((String) this.values.get(0));
                    int size = id3v2point4TimestampFrameForDate.size();
                    if (size != 1) {
                        if (size != 2) {
                            if (size == 3) {
                                builder.setRecordingDay(id3v2point4TimestampFrameForDate.get(2));
                            }
                        }
                        builder.setRecordingMonth(id3v2point4TimestampFrameForDate.get(1));
                    }
                    builder.setRecordingYear(id3v2point4TimestampFrameForDate.get(0));
                    break;
                case 15:
                    List<Integer> id3v2point4TimestampFrameForDate2 = parseId3v2point4TimestampFrameForDate((String) this.values.get(0));
                    int size2 = id3v2point4TimestampFrameForDate2.size();
                    if (size2 != 1) {
                        if (size2 != 2) {
                            if (size2 == 3) {
                                builder.setReleaseDay(id3v2point4TimestampFrameForDate2.get(2));
                            }
                        }
                        builder.setReleaseMonth(id3v2point4TimestampFrameForDate2.get(1));
                    }
                    builder.setReleaseYear(id3v2point4TimestampFrameForDate2.get(0));
                    break;
            }
        } catch (NumberFormatException | StringIndexOutOfBoundsException unused) {
        }
    }

    @Override
    public String toString() {
        return this.f3093id + ": description=" + this.description + ": values=" + this.values;
    }

    @Deprecated
    public TextInformationFrame(String str, String str2, String str3) {
        this(str, str2, AbstractC2301u1.m5275r(str3));
    }
}
