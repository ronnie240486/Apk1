package androidx.media3.extractor.avi;

import androidx.media3.common.util.ParsableByteArray;
import java.util.Arrays;
import p041d7.AbstractC2182d0;
import p041d7.AbstractC2267p1;
import p041d7.AbstractC2301u1;
import p041d7.C2204g1;

final class ListChunk implements AviChunk {
    public final AbstractC2301u1 children;
    private final int type;

    private ListChunk(int i6, AbstractC2301u1 abstractC2301u1) {
        this.type = i6;
        this.children = abstractC2301u1;
    }

    private static AviChunk createBox(int i6, int i10, ParsableByteArray parsableByteArray) {
        switch (i6) {
            case AviExtractor.FOURCC_strf:
                return StreamFormatChunk.parseFrom(i10, parsableByteArray);
            case AviExtractor.FOURCC_avih:
                return AviMainHeaderChunk.parseFrom(parsableByteArray);
            case AviExtractor.FOURCC_strh:
                return AviStreamHeaderChunk.parseFrom(parsableByteArray);
            case AviExtractor.FOURCC_strn:
                return StreamNameChunk.parseFrom(parsableByteArray);
            default:
                return null;
        }
    }

    public static ListChunk parseFrom(int i6, ParsableByteArray parsableByteArray) {
        AbstractC2182d0.m5141d(4, "initialCapacity");
        Object[] objArrCopyOf = new Object[4];
        int iLimit = parsableByteArray.limit();
        int i10 = 0;
        int trackType = -2;
        while (parsableByteArray.bytesLeft() > 8) {
            int littleEndianInt = parsableByteArray.readLittleEndianInt();
            int position = parsableByteArray.getPosition() + parsableByteArray.readLittleEndianInt();
            parsableByteArray.setLimit(position);
            AviChunk from = littleEndianInt == 1414744396 ? parseFrom(parsableByteArray.readLittleEndianInt(), parsableByteArray) : createBox(littleEndianInt, trackType, parsableByteArray);
            if (from != null) {
                if (from.getType() == 1752331379) {
                    trackType = ((AviStreamHeaderChunk) from).getTrackType();
                }
                int i11 = i10 + 1;
                int iM5254f = AbstractC2267p1.m5254f(objArrCopyOf.length, i11);
                if (iM5254f > objArrCopyOf.length) {
                    objArrCopyOf = Arrays.copyOf(objArrCopyOf, iM5254f);
                }
                objArrCopyOf[i10] = from;
                i10 = i11;
            }
            parsableByteArray.setPosition(position);
            parsableByteArray.setLimit(iLimit);
        }
        return new ListChunk(i6, AbstractC2301u1.m5268j(objArrCopyOf, i10));
    }

    public <T extends AviChunk> T getChild(Class<T> cls) {
        C2204g1 c2204g1ListIterator = this.children.listIterator(0);
        while (c2204g1ListIterator.hasNext()) {
            T t5 = (T) c2204g1ListIterator.next();
            if (t5.getClass() == cls) {
                return t5;
            }
        }
        return null;
    }

    @Override
    public int getType() {
        return this.type;
    }
}
