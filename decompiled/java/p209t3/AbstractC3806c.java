package p209t3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.ViewOnClickListenerC0122a;
import androidx.recyclerview.widget.AbstractC1158k0;
import androidx.recyclerview.widget.AbstractC1174p1;
import androidx.recyclerview.widget.AbstractC1197x0;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.p2serv.android.p032ds.R;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import p157oa.C3286a;
import p173q1.C3406f0;

public abstract class AbstractC3806c extends AbstractC1158k0 {

    public C3406f0 f12844a;

    public LayoutInflater f12845b;

    public List f12846c;

    public abstract void mo6117a(C3807d c3807d, Object obj);

    public final C3807d m7582b(View view) {
        C3807d c3807d;
        C3807d c3807d2;
        Class cls;
        C3807d c3807d3 = null;
        Class cls2 = null;
        for (Class<?> superclass = getClass(); cls2 == null && superclass != null; superclass = superclass.getSuperclass()) {
            Type genericSuperclass = superclass.getGenericSuperclass();
            if (genericSuperclass instanceof ParameterizedType) {
                Type[] actualTypeArguments = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
                int length = actualTypeArguments.length;
                int i6 = 0;
                while (true) {
                    if (i6 < length) {
                        Type type = actualTypeArguments[i6];
                        if (type instanceof Class) {
                            cls = (Class) type;
                            if (C3807d.class.isAssignableFrom(cls)) {
                                cls2 = cls;
                            } else {
                                i6++;
                            }
                        } else {
                            if (type instanceof ParameterizedType) {
                                Type rawType = ((ParameterizedType) type).getRawType();
                                if (rawType instanceof Class) {
                                    cls = (Class) rawType;
                                    if (C3807d.class.isAssignableFrom(cls)) {
                                        cls2 = cls;
                                    }
                                } else {
                                    continue;
                                }
                            } else {
                                continue;
                            }
                            i6++;
                        }
                    } else {
                        cls2 = null;
                    }
                }
            } else {
                cls2 = null;
            }
        }
        if (cls2 == null) {
            c3807d = new C3807d(view);
        } else {
            try {
                if (!cls2.isMemberClass() || Modifier.isStatic(cls2.getModifiers())) {
                    Constructor declaredConstructor = cls2.getDeclaredConstructor(View.class);
                    declaredConstructor.setAccessible(true);
                    c3807d2 = (C3807d) declaredConstructor.newInstance(view);
                } else {
                    Constructor declaredConstructor2 = cls2.getDeclaredConstructor(getClass(), View.class);
                    declaredConstructor2.setAccessible(true);
                    c3807d2 = (C3807d) declaredConstructor2.newInstance(this, view);
                }
                c3807d3 = c3807d2;
            } catch (IllegalAccessException e5) {
                e5.printStackTrace();
            } catch (InstantiationException e10) {
                e10.printStackTrace();
            } catch (NoSuchMethodException e11) {
                e11.printStackTrace();
            } catch (InvocationTargetException e12) {
                e12.printStackTrace();
            }
            c3807d = c3807d3;
        }
        return c3807d != null ? c3807d : new C3807d(view);
    }

    @Override
    public final int getItemCount() {
        return this.f12846c.size();
    }

    @Override
    public final long getItemId(int i6) {
        return i6;
    }

    @Override
    public final int getItemViewType(int i6) {
        if (i6 < 0) {
            return 273;
        }
        int size = this.f12846c.size();
        if (i6 >= size) {
            return i6 - size < 0 ? 819 : 546;
        }
        Object obj = ((AbstractC3804a) this).f12846c.get(i6);
        if (obj instanceof C3286a) {
            return ((C3286a) obj).f10998b;
        }
        return -255;
    }

    @Override
    public final void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        AbstractC1197x0 layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            gridLayoutManager.f3451g = new C3805b(this, gridLayoutManager);
        }
    }

    @Override
    public final void onBindViewHolder(AbstractC1174p1 abstractC1174p1, int i6) {
        C3807d c3807d = (C3807d) abstractC1174p1;
        int itemViewType = c3807d.getItemViewType();
        if (itemViewType == 0) {
            List list = this.f12846c;
            mo6117a(c3807d, i6 < list.size() ? list.get(i6) : null);
            return;
        }
        if (itemViewType != 273) {
            if (itemViewType == 546) {
                this.f12844a.getClass();
                c3807d.m7584c(R.id.load_more_loading_view, false);
                c3807d.m7584c(R.id.load_more_load_fail_view, false);
                c3807d.m7584c(R.id.load_more_load_end_view, false);
                return;
            }
            if (itemViewType == 819 || itemViewType == 1365) {
                return;
            }
            List list2 = this.f12846c;
            mo6117a(c3807d, i6 < list2.size() ? list2.get(i6) : null);
        }
    }

    @Override
    public final AbstractC1174p1 onCreateViewHolder(ViewGroup viewGroup, int i6) {
        this.f12845b = LayoutInflater.from(viewGroup.getContext());
        if (i6 == 273) {
            return m7582b(null);
        }
        if (i6 == 546) {
            this.f12844a.getClass();
            C3807d c3807dM7582b = m7582b(this.f12845b.inflate(R.layout.quick_view_load_more, viewGroup, false));
            c3807dM7582b.itemView.setOnClickListener(new ViewOnClickListenerC0122a(20, this));
            return c3807dM7582b;
        }
        if (i6 == 819) {
            return m7582b(null);
        }
        if (i6 == 1365) {
            return m7582b(null);
        }
        AbstractC3804a abstractC3804a = (AbstractC3804a) this;
        return abstractC3804a.m7582b(abstractC3804a.f12845b.inflate(abstractC3804a.f12841d.get(i6, -404), viewGroup, false));
    }

    @Override
    public final void onViewAttachedToWindow(AbstractC1174p1 abstractC1174p1) {
        C3807d c3807d = (C3807d) abstractC1174p1;
        super.onViewAttachedToWindow(c3807d);
        int itemViewType = c3807d.getItemViewType();
        if ((itemViewType == 1365 || itemViewType == 273 || itemViewType == 819 || itemViewType == 546) && (c3807d.itemView.getLayoutParams() instanceof StaggeredGridLayoutManager.LayoutParams)) {
            ((StaggeredGridLayoutManager.LayoutParams) c3807d.itemView.getLayoutParams()).f3495f = true;
        }
    }
}
