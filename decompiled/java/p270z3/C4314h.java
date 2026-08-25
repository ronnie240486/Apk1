package p270z3;

import p000a.AbstractC0004e;

public final class C4314h extends AbstractC4307a {

    public final Integer f14647a;

    public final String f14648b;

    public final String f14649c;

    public final String f14650d;

    public final String f14651e;

    public final String f14652f;

    public final String f14653g;

    public final String f14654h;

    public final String f14655i;

    public final String f14656j;

    public final String f14657k;

    public final String f14658l;

    public C4314h(Integer num, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        this.f14647a = num;
        this.f14648b = str;
        this.f14649c = str2;
        this.f14650d = str3;
        this.f14651e = str4;
        this.f14652f = str5;
        this.f14653g = str6;
        this.f14654h = str7;
        this.f14655i = str8;
        this.f14656j = str9;
        this.f14657k = str10;
        this.f14658l = str11;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC4307a)) {
            return false;
        }
        AbstractC4307a abstractC4307a = (AbstractC4307a) obj;
        Integer num = this.f14647a;
        if (num != null ? num.equals(((C4314h) abstractC4307a).f14647a) : ((C4314h) abstractC4307a).f14647a == null) {
            String str = this.f14648b;
            if (str != null ? str.equals(((C4314h) abstractC4307a).f14648b) : ((C4314h) abstractC4307a).f14648b == null) {
                String str2 = this.f14649c;
                if (str2 != null ? str2.equals(((C4314h) abstractC4307a).f14649c) : ((C4314h) abstractC4307a).f14649c == null) {
                    String str3 = this.f14650d;
                    if (str3 != null ? str3.equals(((C4314h) abstractC4307a).f14650d) : ((C4314h) abstractC4307a).f14650d == null) {
                        String str4 = this.f14651e;
                        if (str4 != null ? str4.equals(((C4314h) abstractC4307a).f14651e) : ((C4314h) abstractC4307a).f14651e == null) {
                            String str5 = this.f14652f;
                            if (str5 != null ? str5.equals(((C4314h) abstractC4307a).f14652f) : ((C4314h) abstractC4307a).f14652f == null) {
                                String str6 = this.f14653g;
                                if (str6 != null ? str6.equals(((C4314h) abstractC4307a).f14653g) : ((C4314h) abstractC4307a).f14653g == null) {
                                    String str7 = this.f14654h;
                                    if (str7 != null ? str7.equals(((C4314h) abstractC4307a).f14654h) : ((C4314h) abstractC4307a).f14654h == null) {
                                        String str8 = this.f14655i;
                                        if (str8 != null ? str8.equals(((C4314h) abstractC4307a).f14655i) : ((C4314h) abstractC4307a).f14655i == null) {
                                            String str9 = this.f14656j;
                                            if (str9 != null ? str9.equals(((C4314h) abstractC4307a).f14656j) : ((C4314h) abstractC4307a).f14656j == null) {
                                                String str10 = this.f14657k;
                                                if (str10 != null ? str10.equals(((C4314h) abstractC4307a).f14657k) : ((C4314h) abstractC4307a).f14657k == null) {
                                                    String str11 = this.f14658l;
                                                    if (str11 == null) {
                                                        if (((C4314h) abstractC4307a).f14658l == null) {
                                                            return true;
                                                        }
                                                    } else if (str11.equals(((C4314h) abstractC4307a).f14658l)) {
                                                        return true;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        Integer num = this.f14647a;
        int iHashCode = ((num == null ? 0 : num.hashCode()) ^ 1000003) * 1000003;
        String str = this.f14648b;
        int iHashCode2 = (iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.f14649c;
        int iHashCode3 = (iHashCode2 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f14650d;
        int iHashCode4 = (iHashCode3 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.f14651e;
        int iHashCode5 = (iHashCode4 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        String str5 = this.f14652f;
        int iHashCode6 = (iHashCode5 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003;
        String str6 = this.f14653g;
        int iHashCode7 = (iHashCode6 ^ (str6 == null ? 0 : str6.hashCode())) * 1000003;
        String str7 = this.f14654h;
        int iHashCode8 = (iHashCode7 ^ (str7 == null ? 0 : str7.hashCode())) * 1000003;
        String str8 = this.f14655i;
        int iHashCode9 = (iHashCode8 ^ (str8 == null ? 0 : str8.hashCode())) * 1000003;
        String str9 = this.f14656j;
        int iHashCode10 = (iHashCode9 ^ (str9 == null ? 0 : str9.hashCode())) * 1000003;
        String str10 = this.f14657k;
        int iHashCode11 = (iHashCode10 ^ (str10 == null ? 0 : str10.hashCode())) * 1000003;
        String str11 = this.f14658l;
        return (str11 != null ? str11.hashCode() : 0) ^ iHashCode11;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("AndroidClientInfo{sdkVersion=");
        sb.append(this.f14647a);
        sb.append(", model=");
        sb.append(this.f14648b);
        sb.append(", hardware=");
        sb.append(this.f14649c);
        sb.append(", device=");
        sb.append(this.f14650d);
        sb.append(", product=");
        sb.append(this.f14651e);
        sb.append(", osBuild=");
        sb.append(this.f14652f);
        sb.append(", manufacturer=");
        sb.append(this.f14653g);
        sb.append(", fingerprint=");
        sb.append(this.f14654h);
        sb.append(", locale=");
        sb.append(this.f14655i);
        sb.append(", country=");
        sb.append(this.f14656j);
        sb.append(", mccMnc=");
        sb.append(this.f14657k);
        sb.append(", applicationBuild=");
        return AbstractC0004e.m26t(sb, this.f14658l, "}");
    }
}
