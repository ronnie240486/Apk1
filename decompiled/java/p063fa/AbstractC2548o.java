package p063fa;

import android.content.Context;
import androidx.appcompat.app.ViewOnClickListenerC0122a;
import androidx.recyclerview.widget.AbstractC1158k0;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mars.xlog.Log;
import org.bitspark.android.utils.AbstractC3331m;
import p003a2.AbstractC0032a;
import p055ea.AbstractC2442h;
import p055ea.EnumC2434d;

public abstract class AbstractC2548o extends AbstractC1158k0 {

    public static final String f8873i = AbstractC0032a.m165s("OlWx9LLfUuweS73ittNU4jxDueCU30M=\n", "fSfYkOC6MZU=\n");

    public final Context f8874a;

    public int f8875b = 0;

    public int f8876c = -100;

    public int f8877d = -1;

    public RecyclerView f8878e;

    public final EnumC2434d f8879f;

    public int f8880g;

    public InterfaceC2546n0 f8881h;

    public AbstractC2548o(Context context, EnumC2434d enumC2434d) {
        this.f8880g = 5;
        this.f8874a = context;
        this.f8879f = enumC2434d;
        if (enumC2434d == EnumC2434d.f8533e) {
            this.f8880g = AbstractC2442h.f8611q;
        } else if (enumC2434d == EnumC2434d.f8535g) {
            this.f8880g = AbstractC2442h.f8614t;
        }
    }

    public final boolean m5558a(int i6) {
        this.f8877d = this.f8875b + i6;
        String str = AbstractC0032a.m165s("8iwwArCXsfT7NiELuM7l\n", "n39VbtX0xZE=\n") + this.f8875b + AbstractC0032a.m165s("JoRB8WhlZ+FjiVDAaFNvtyY=\n", "BuokiRw2Ao0=\n") + this.f8877d;
        boolean z7 = AbstractC3331m.f11244b;
        Log.m5049i(f8873i, str);
        int i10 = this.f8877d;
        if (i10 < 0) {
            notifyItemChanged(this.f8875b);
            return false;
        }
        if (i10 < 0 || i10 >= getItemCount()) {
            return this.f8877d >= getItemCount();
        }
        notifyItemChanged(this.f8875b);
        this.f8876c = this.f8875b;
        int i11 = this.f8877d;
        this.f8875b = i11;
        notifyItemChanged(i11);
        this.f8878e.scrollToPosition(this.f8875b);
        return true;
    }

    @Override
    public final void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.f8878e = recyclerView;
        int i6 = 0;
        recyclerView.setOnKeyListener(new ViewOnKeyListenerC2539l(this, i6, recyclerView));
        recyclerView.setOnLongClickListener(new ViewOnLongClickListenerC2542m(this, i6));
        recyclerView.setOnClickListener(new ViewOnClickListenerC0122a(10, this));
        recyclerView.setOnFocusChangeListener(new ViewOnFocusChangeListenerC2545n(this, recyclerView));
    }
}
