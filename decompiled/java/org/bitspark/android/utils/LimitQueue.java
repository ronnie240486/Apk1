package org.bitspark.android.utils;

import com.nmmedit.protect.NativeUtil;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class LimitQueue<E> implements Queue<E>, Serializable {
    private static final long serialVersionUID = -8734287124637627118L;
    private int limit;
    Queue<E> queue = new LinkedList();

    static {
        NativeUtil.classesInit0(63);
    }

    public LimitQueue(int i6) {
        this.limit = i6;
    }

    @Override
    public native boolean add(E e5);

    @Override
    public native boolean addAll(Collection<? extends E> collection);

    @Override
    public native void clear();

    @Override
    public native boolean contains(Object obj);

    @Override
    public native boolean containsAll(Collection<?> collection);

    @Override
    public native E element();

    public native int getLimit();

    public native Queue<E> getQueue();

    @Override
    public native boolean isEmpty();

    @Override
    public native Iterator<E> iterator();

    @Override
    public native boolean offer(E e5);

    @Override
    public native E peek();

    @Override
    public native E poll();

    @Override
    public native E remove();

    @Override
    public native boolean remove(Object obj);

    @Override
    public native boolean removeAll(Collection<?> collection);

    @Override
    public native boolean retainAll(Collection<?> collection);

    public native void set(int i6, E e5);

    @Override
    public native int size();

    @Override
    public native Object[] toArray();

    @Override
    public native <T> T[] toArray(T[] tArr);
}
