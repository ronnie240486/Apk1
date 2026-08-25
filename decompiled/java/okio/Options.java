package okio;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.RandomAccess;
import p055ea.AbstractC2460q;
import p103j9.AbstractC2793f;
import p103j9.AbstractC2796i;
import p253x8.AbstractC4142e;
import p253x8.AbstractC4152o;
import p253x8.C4144g;

public final class Options extends AbstractC4142e implements RandomAccess {
    public static final Companion Companion = new Companion(null);
    private final ByteString[] byteStrings;
    private final int[] trie;

    public static final class Companion {
        public Companion(AbstractC2793f abstractC2793f) {
            this();
        }

        private final void buildTrieRecursive(long j10, Buffer buffer, int i6, List<? extends ByteString> list, int i10, int i11, List<Integer> list2) throws IOException {
            int i12;
            int i13;
            int i14;
            int i15 = i6;
            if (i10 >= i11) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            for (int i16 = i10; i16 < i11; i16++) {
                if (list.get(i16).size() < i15) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
            }
            ByteString byteString = list.get(i10);
            ByteString byteString2 = list.get(i11 - 1);
            if (i15 == byteString.size()) {
                int iIntValue = list2.get(i10).intValue();
                int i17 = i10 + 1;
                ByteString byteString3 = list.get(i17);
                i12 = i17;
                i13 = iIntValue;
                byteString = byteString3;
            } else {
                i12 = i10;
                i13 = -1;
            }
            if (byteString.getByte(i15) == byteString2.getByte(i15)) {
                int iMin = Math.min(byteString.size(), byteString2.size());
                int i18 = 0;
                for (int i19 = i15; i19 < iMin && byteString.getByte(i19) == byteString2.getByte(i19); i19++) {
                    i18++;
                }
                long intCount = j10 + getIntCount(buffer) + ((long) 2) + ((long) i18) + 1;
                buffer.writeInt(-i18);
                buffer.writeInt(i13);
                int i20 = i18 + i15;
                while (i15 < i20) {
                    buffer.writeInt(byteString.getByte(i15) & 255);
                    i15++;
                }
                if (i12 + 1 == i11) {
                    if (i20 != list.get(i12).size()) {
                        throw new IllegalStateException("Check failed.");
                    }
                    buffer.writeInt(list2.get(i12).intValue());
                    return;
                } else {
                    Buffer buffer2 = new Buffer();
                    buffer.writeInt(((int) (getIntCount(buffer2) + intCount)) * (-1));
                    buildTrieRecursive(intCount, buffer2, i20, list, i12, i11, list2);
                    buffer.writeAll(buffer2);
                    return;
                }
            }
            int i21 = 1;
            for (int i22 = i12 + 1; i22 < i11; i22++) {
                if (list.get(i22 - 1).getByte(i15) != list.get(i22).getByte(i15)) {
                    i21++;
                }
            }
            long intCount2 = j10 + getIntCount(buffer) + ((long) 2) + ((long) (i21 * 2));
            buffer.writeInt(i21);
            buffer.writeInt(i13);
            for (int i23 = i12; i23 < i11; i23++) {
                byte b8 = list.get(i23).getByte(i15);
                if (i23 == i12 || b8 != list.get(i23 - 1).getByte(i15)) {
                    buffer.writeInt(b8 & 255);
                }
            }
            Buffer buffer3 = new Buffer();
            while (i12 < i11) {
                byte b10 = list.get(i12).getByte(i15);
                int i24 = i12 + 1;
                int i25 = i24;
                while (true) {
                    if (i25 >= i11) {
                        i14 = i11;
                        break;
                    } else {
                        if (b10 != list.get(i25).getByte(i15)) {
                            i14 = i25;
                            break;
                        }
                        i25++;
                    }
                }
                if (i24 == i14 && i15 + 1 == list.get(i12).size()) {
                    buffer.writeInt(list2.get(i12).intValue());
                } else {
                    buffer.writeInt(((int) (intCount2 + getIntCount(buffer3))) * (-1));
                    buildTrieRecursive(intCount2, buffer3, i15 + 1, list, i12, i14, list2);
                }
                buffer3 = buffer3;
                i12 = i14;
            }
            buffer.writeAll(buffer3);
        }

        public static void buildTrieRecursive$default(Companion companion, long j10, Buffer buffer, int i6, List list, int i10, int i11, List list2, int i12, Object obj) throws IOException {
            companion.buildTrieRecursive((i12 & 1) != 0 ? 0L : j10, buffer, (i12 & 4) != 0 ? 0 : i6, list, (i12 & 16) != 0 ? 0 : i10, (i12 & 32) != 0 ? list.size() : i11, list2);
        }

        private final long getIntCount(Buffer buffer) {
            return buffer.size() / ((long) 4);
        }

        public final Options m6650of(ByteString... byteStringArr) throws IOException {
            int i6;
            AbstractC2796i.m5785f(byteStringArr, "byteStrings");
            AbstractC2793f abstractC2793f = null;
            if (byteStringArr.length == 0) {
                return new Options(new ByteString[0], new int[]{0, -1}, abstractC2793f);
            }
            ArrayList arrayList = new ArrayList(new C4144g(byteStringArr, false));
            AbstractC4152o.m8194R(arrayList);
            int size = arrayList.size();
            ArrayList arrayList2 = new ArrayList(size);
            for (int i10 = 0; i10 < size; i10++) {
                arrayList2.add(-1);
            }
            int length = byteStringArr.length;
            int i11 = 0;
            int i12 = 0;
            while (i11 < length) {
                ByteString byteString = byteStringArr[i11];
                int i13 = i12 + 1;
                int size2 = arrayList.size();
                int size3 = arrayList.size();
                if (size2 < 0) {
                    throw new IllegalArgumentException(AbstractC2460q.m5492f(size2, "fromIndex (0) is greater than toIndex (", ")."));
                }
                if (size2 > size3) {
                    throw new IndexOutOfBoundsException("toIndex (" + size2 + ") is greater than size (" + size3 + ").");
                }
                int i14 = size2 - 1;
                int i15 = 0;
                while (true) {
                    if (i15 > i14) {
                        i6 = -(i15 + 1);
                        break;
                    }
                    int iCompareTo = 1;
                    i6 = (i15 + i14) >>> 1;
                    Comparable comparable = (Comparable) arrayList.get(i6);
                    if (comparable == byteString) {
                        iCompareTo = 0;
                    } else if (comparable == null) {
                        iCompareTo = -1;
                    } else if (byteString != null) {
                        iCompareTo = comparable.compareTo(byteString);
                    }
                    if (iCompareTo >= 0) {
                        if (iCompareTo <= 0) {
                            break;
                        }
                        i14 = i6 - 1;
                    } else {
                        i15 = i6 + 1;
                    }
                }
                arrayList2.set(i6, Integer.valueOf(i12));
                i11++;
                i12 = i13;
            }
            if (((ByteString) arrayList.get(0)).size() <= 0) {
                throw new IllegalArgumentException("the empty byte string is not a supported option");
            }
            int i16 = 0;
            while (i16 < arrayList.size()) {
                ByteString byteString2 = (ByteString) arrayList.get(i16);
                int i17 = i16 + 1;
                int i18 = i17;
                while (i18 < arrayList.size()) {
                    ByteString byteString3 = (ByteString) arrayList.get(i18);
                    if (!byteString3.startsWith(byteString2)) {
                        break;
                    }
                    if (byteString3.size() == byteString2.size()) {
                        throw new IllegalArgumentException(("duplicate option: " + byteString3).toString());
                    }
                    if (((Number) arrayList2.get(i18)).intValue() > ((Number) arrayList2.get(i16)).intValue()) {
                        arrayList.remove(i18);
                        arrayList2.remove(i18);
                    } else {
                        i18++;
                    }
                }
                i16 = i17;
            }
            Buffer buffer = new Buffer();
            buildTrieRecursive$default(this, 0L, buffer, 0, arrayList, 0, 0, arrayList2, 53, null);
            int intCount = (int) getIntCount(buffer);
            int[] iArr = new int[intCount];
            for (int i19 = 0; i19 < intCount; i19++) {
                iArr[i19] = buffer.readInt();
            }
            Object[] objArrCopyOf = Arrays.copyOf(byteStringArr, byteStringArr.length);
            AbstractC2796i.m5784e(objArrCopyOf, "copyOf(...)");
            return new Options((ByteString[]) objArrCopyOf, iArr, abstractC2793f);
        }

        private Companion() {
        }
    }

    public Options(ByteString[] byteStringArr, int[] iArr, AbstractC2793f abstractC2793f) {
        this(byteStringArr, iArr);
    }

    public static final Options m6649of(ByteString... byteStringArr) {
        return Companion.m6650of(byteStringArr);
    }

    @Override
    public final boolean contains(Object obj) {
        if (obj instanceof ByteString) {
            return contains((ByteString) obj);
        }
        return false;
    }

    public final ByteString[] getByteStrings$okio() {
        return this.byteStrings;
    }

    @Override
    public int getSize() {
        return this.byteStrings.length;
    }

    public final int[] getTrie$okio() {
        return this.trie;
    }

    @Override
    public final int indexOf(Object obj) {
        if (obj instanceof ByteString) {
            return indexOf((ByteString) obj);
        }
        return -1;
    }

    @Override
    public final int lastIndexOf(Object obj) {
        if (obj instanceof ByteString) {
            return lastIndexOf((ByteString) obj);
        }
        return -1;
    }

    private Options(ByteString[] byteStringArr, int[] iArr) {
        this.byteStrings = byteStringArr;
        this.trie = iArr;
    }

    public boolean contains(ByteString byteString) {
        return super.contains((Object) byteString);
    }

    @Override
    public ByteString get(int i6) {
        return this.byteStrings[i6];
    }

    public int indexOf(ByteString byteString) {
        return super.indexOf((Object) byteString);
    }

    public int lastIndexOf(ByteString byteString) {
        return super.lastIndexOf((Object) byteString);
    }
}
