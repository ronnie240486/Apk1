package p206t0;

import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import androidx.appcompat.widget.C0175a2;
import androidx.appcompat.widget.ViewOnClickListenerC0204f3;
import p000a.AbstractC0004e;
import p063fa.C2565v0;

public abstract class AbstractC3788b extends BaseAdapter implements Filterable {

    public boolean f12750a;

    public boolean f12751b;

    public Cursor f12752c;

    public int f12753d;

    public C3787a f12754e;

    public C0175a2 f12755f;

    public C2565v0 f12756g;

    public abstract void mo663a(View view, Cursor cursor);

    public void mo664b(Cursor cursor) {
        Cursor cursor2 = this.f12752c;
        if (cursor == cursor2) {
            cursor2 = null;
        } else {
            if (cursor2 != null) {
                C3787a c3787a = this.f12754e;
                if (c3787a != null) {
                    cursor2.unregisterContentObserver(c3787a);
                }
                C0175a2 c0175a2 = this.f12755f;
                if (c0175a2 != null) {
                    cursor2.unregisterDataSetObserver(c0175a2);
                }
            }
            this.f12752c = cursor;
            if (cursor != null) {
                C3787a c3787a2 = this.f12754e;
                if (c3787a2 != null) {
                    cursor.registerContentObserver(c3787a2);
                }
                C0175a2 c0175a3 = this.f12755f;
                if (c0175a3 != null) {
                    cursor.registerDataSetObserver(c0175a3);
                }
                this.f12753d = cursor.getColumnIndexOrThrow("_id");
                this.f12750a = true;
                notifyDataSetChanged();
            } else {
                this.f12753d = -1;
                this.f12750a = false;
                notifyDataSetInvalidated();
            }
        }
        if (cursor2 != null) {
            cursor2.close();
        }
    }

    public abstract String mo665c(Cursor cursor);

    public abstract View mo666d(ViewGroup viewGroup);

    @Override
    public final int getCount() {
        Cursor cursor;
        if (!this.f12750a || (cursor = this.f12752c) == null) {
            return 0;
        }
        return cursor.getCount();
    }

    @Override
    public View getDropDownView(int i6, View view, ViewGroup viewGroup) {
        if (!this.f12750a) {
            return null;
        }
        this.f12752c.moveToPosition(i6);
        if (view == null) {
            ViewOnClickListenerC0204f3 viewOnClickListenerC0204f3 = (ViewOnClickListenerC0204f3) this;
            view = viewOnClickListenerC0204f3.f907j.inflate(viewOnClickListenerC0204f3.f906i, viewGroup, false);
        }
        mo663a(view, this.f12752c);
        return view;
    }

    @Override
    public final Filter getFilter() {
        if (this.f12756g == null) {
            C2565v0 c2565v0 = new C2565v0();
            c2565v0.f8923b = this;
            this.f12756g = c2565v0;
        }
        return this.f12756g;
    }

    @Override
    public final Object getItem(int i6) {
        Cursor cursor;
        if (!this.f12750a || (cursor = this.f12752c) == null) {
            return null;
        }
        cursor.moveToPosition(i6);
        return this.f12752c;
    }

    @Override
    public final long getItemId(int i6) {
        Cursor cursor;
        if (this.f12750a && (cursor = this.f12752c) != null && cursor.moveToPosition(i6)) {
            return this.f12752c.getLong(this.f12753d);
        }
        return 0L;
    }

    @Override
    public View getView(int i6, View view, ViewGroup viewGroup) {
        if (!this.f12750a) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        }
        if (!this.f12752c.moveToPosition(i6)) {
            throw new IllegalStateException(AbstractC0004e.m20n(i6, "couldn't move cursor to position "));
        }
        if (view == null) {
            view = mo666d(viewGroup);
        }
        mo663a(view, this.f12752c);
        return view;
    }
}
