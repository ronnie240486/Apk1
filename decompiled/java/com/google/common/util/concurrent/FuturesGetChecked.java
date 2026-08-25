package com.google.common.util.concurrent;

import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import p020b7.AbstractC1332b;
import p041d7.AbstractC2173b5;
import p041d7.AbstractC2182d0;
import p041d7.C2166a5;
import p041d7.C2175c0;
import p041d7.C2236k5;
import p041d7.C2266p0;

@ElementTypesAreNonnullByDefault
final class FuturesGetChecked {
    private static final AbstractC2173b5 ORDERING_BY_CONSTRUCTOR_PARAMETER_LIST;
    private static final AbstractC2173b5 WITH_STRING_PARAM_THEN_WITH_THROWABLE_PARAM;

    public interface GetCheckedTypeValidator {
        void validateClass(Class<? extends Exception> cls);
    }

    public static class GetCheckedTypeValidatorHolder {
        static final GetCheckedTypeValidator BEST_VALIDATOR = getBestValidator();

        public enum WeakSetValidator implements GetCheckedTypeValidator {
            INSTANCE;

            private static final Set<WeakReference<Class<? extends Exception>>> validClasses = new CopyOnWriteArraySet();

            @Override
            public void validateClass(Class<? extends Exception> cls) {
                Iterator<WeakReference<Class<? extends Exception>>> it = validClasses.iterator();
                while (it.hasNext()) {
                    if (cls.equals(it.next().get())) {
                        return;
                    }
                }
                FuturesGetChecked.checkExceptionClassValidity(cls);
                Set<WeakReference<Class<? extends Exception>>> set = validClasses;
                if (set.size() > 1000) {
                    set.clear();
                }
                set.add(new WeakReference<>(cls));
            }
        }

        public static GetCheckedTypeValidator getBestValidator() {
            return FuturesGetChecked.weakSetValidator();
        }
    }

    static {
        C2166a5 c2166a5 = C2166a5.f7831a;
        C1969m c1969m = new C1969m(0);
        c2166a5.getClass();
        C2236k5 c2236k5 = new C2236k5(new C2266p0(new C2175c0(c1969m, c2166a5), new C2175c0(new C1969m(1), c2166a5)));
        ORDERING_BY_CONSTRUCTOR_PARAMETER_LIST = c2236k5;
        WITH_STRING_PARAM_THEN_WITH_THROWABLE_PARAM = new C2175c0(new C1969m(2), c2236k5);
    }

    private FuturesGetChecked() {
    }

    private static GetCheckedTypeValidator bestGetCheckedTypeValidator() {
        return GetCheckedTypeValidatorHolder.BEST_VALIDATOR;
    }

    public static void checkExceptionClassValidity(Class<? extends Exception> cls) {
        AbstractC1332b.m3212c(cls, "Futures.getChecked exception type (%s) must not be a RuntimeException", isCheckedException(cls));
        AbstractC1332b.m3212c(cls, "Futures.getChecked exception type (%s) must be an accessible class with an accessible constructor whose parameters (if any) must be of type String and/or Throwable", hasConstructorUsableByGetChecked(cls));
    }

    @ParametricNullness
    public static <V, X extends Exception> V getChecked(Future<V> future, Class<X> cls) throws Exception {
        return (V) getChecked(bestGetCheckedTypeValidator(), future, cls);
    }

    private static boolean hasConstructorUsableByGetChecked(Class<? extends Exception> cls) {
        try {
            newWithCause(cls, new Exception());
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean isCheckedException(Class<? extends Exception> cls) {
        return !RuntimeException.class.isAssignableFrom(cls);
    }

    public static Comparable lambda$static$0(List list) {
        return Boolean.valueOf(list.contains(String.class));
    }

    public static Comparable lambda$static$1(List list) {
        return Boolean.valueOf(list.contains(Throwable.class));
    }

    public static List lambda$static$2(Constructor constructor) {
        return Arrays.asList(constructor.getParameterTypes());
    }

    private static <X> X newFromConstructor(Constructor<X> constructor, Throwable th) {
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        Object[] objArr = new Object[parameterTypes.length];
        for (int i6 = 0; i6 < parameterTypes.length; i6++) {
            Class<?> cls = parameterTypes[i6];
            if (cls.equals(String.class)) {
                objArr[i6] = th.toString();
            } else {
                if (!cls.equals(Throwable.class)) {
                    return null;
                }
                objArr[i6] = th;
            }
        }
        try {
            return constructor.newInstance(objArr);
        } catch (IllegalAccessException | IllegalArgumentException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    private static <X extends Exception> X newWithCause(Class<X> cls, Throwable th) {
        Iterator it = preferringStringsThenThrowables(Arrays.asList(cls.getConstructors())).iterator();
        while (it.hasNext()) {
            X x10 = (X) newFromConstructor((Constructor) it.next(), th);
            if (x10 != null) {
                if (x10.getCause() == null) {
                    x10.initCause(th);
                }
                return x10;
            }
        }
        throw new IllegalArgumentException("No appropriate constructor for exception of type " + cls + " in response to chained exception", th);
    }

    private static <X extends Exception> List<Constructor<X>> preferringStringsThenThrowables(List<Constructor<X>> list) {
        AbstractC2173b5 abstractC2173b5 = WITH_STRING_PARAM_THEN_WITH_THROWABLE_PARAM;
        abstractC2173b5.getClass();
        if (!(list instanceof Collection)) {
            list = AbstractC2182d0.m5156s(list.iterator());
        }
        Object[] array = list.toArray();
        Arrays.sort(array, abstractC2173b5);
        List listAsList = Arrays.asList(array);
        listAsList.getClass();
        return new ArrayList(listAsList);
    }

    public static GetCheckedTypeValidator weakSetValidator() {
        return GetCheckedTypeValidatorHolder.WeakSetValidator.INSTANCE;
    }

    private static <X extends Exception> void wrapAndThrowExceptionOrError(Throwable th, Class<X> cls) throws Exception {
        if (th instanceof Error) {
            throw new ExecutionError((Error) th);
        }
        if (!(th instanceof RuntimeException)) {
            throw newWithCause(cls, th);
        }
        throw new UncheckedExecutionException(th);
    }

    @ParametricNullness
    public static <V, X extends Exception> V getChecked(GetCheckedTypeValidator getCheckedTypeValidator, Future<V> future, Class<X> cls) throws Exception {
        getCheckedTypeValidator.validateClass(cls);
        try {
            return future.get();
        } catch (InterruptedException e5) {
            Thread.currentThread().interrupt();
            throw newWithCause(cls, e5);
        } catch (ExecutionException e10) {
            wrapAndThrowExceptionOrError(e10.getCause(), cls);
            throw new AssertionError();
        }
    }

    @ParametricNullness
    public static <V, X extends Exception> V getChecked(Future<V> future, Class<X> cls, long j10, TimeUnit timeUnit) throws Exception {
        bestGetCheckedTypeValidator().validateClass(cls);
        try {
            return future.get(j10, timeUnit);
        } catch (InterruptedException e5) {
            Thread.currentThread().interrupt();
            throw newWithCause(cls, e5);
        } catch (ExecutionException e10) {
            wrapAndThrowExceptionOrError(e10.getCause(), cls);
            throw new AssertionError();
        } catch (TimeoutException e11) {
            throw newWithCause(cls, e11);
        }
    }
}
