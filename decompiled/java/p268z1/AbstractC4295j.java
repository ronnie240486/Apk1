package p268z1;

import com.bumptech.glide.AbstractC1466d;
import p056f0.C2483f;

public abstract class AbstractC4295j extends AbstractC4294i {

    public C2483f[] f14552a;

    public String f14553b;

    public int f14554c;

    public AbstractC4295j() {
        this.f14552a = null;
        this.f14554c = 0;
    }

    public C2483f[] getPathData() {
        return this.f14552a;
    }

    public String getPathName() {
        return this.f14553b;
    }

    public void setPathData(C2483f[] c2483fArr) {
        if (!AbstractC1466d.m3486a(this.f14552a, c2483fArr)) {
            this.f14552a = AbstractC1466d.m3490h(c2483fArr);
            return;
        }
        C2483f[] c2483fArr2 = this.f14552a;
        for (int i6 = 0; i6 < c2483fArr.length; i6++) {
            c2483fArr2[i6].f8686a = c2483fArr[i6].f8686a;
            int i10 = 0;
            while (true) {
                float[] fArr = c2483fArr[i6].f8687b;
                if (i10 < fArr.length) {
                    c2483fArr2[i6].f8687b[i10] = fArr[i10];
                    i10++;
                }
            }
        }
    }

    public AbstractC4295j(AbstractC4295j abstractC4295j) {
        this.f14552a = null;
        this.f14554c = 0;
        this.f14553b = abstractC4295j.f14553b;
        this.f14552a = AbstractC1466d.m3490h(abstractC4295j.f14552a);
    }
}
