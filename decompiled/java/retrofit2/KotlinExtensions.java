package retrofit2;

import com.bumptech.glide.AbstractC1466d;
import java.lang.reflect.Method;
import p008a9.InterfaceC0074d;
import p021b9.EnumC1367a;
import p030c9.AbstractC1433c;
import p030c9.InterfaceC1435e;
import p103j9.AbstractC2796i;
import p156o9.AbstractC3280d;
import p213t9.AbstractC3819b0;
import p213t9.C3827e;
import p243w8.C4060b;
import p243w8.C4070l;

public final class KotlinExtensions {

    @InterfaceC1435e(m3333c = "retrofit2.KotlinExtensions", m3334f = "KotlinExtensions.kt", m3335l = {113}, m3336m = "suspendAndThrow")
    public static final class C36701 extends AbstractC1433c {
        Object L$0;
        int label;
        Object result;

        public C36701(InterfaceC0074d interfaceC0074d) {
            super(interfaceC0074d);
        }

        @Override
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return KotlinExtensions.suspendAndThrow(null, this);
        }
    }

    public static final <T> Object await(Call<T> call, InterfaceC0074d<? super T> interfaceC0074d) {
        final C3827e c3827e = new C3827e(AbstractC1466d.m3499r(interfaceC0074d), 1);
        c3827e.m7660p(new C3666x19835f10(call));
        call.enqueue(new Callback<T>() {
            @Override
            public void onFailure(Call<T> call2, Throwable th) {
                AbstractC2796i.m5786g(call2, "call");
                AbstractC2796i.m5786g(th, "t");
                ((C3827e) c3827e).resumeWith(AbstractC3280d.m6588f(th));
            }

            @Override
            public void onResponse(Call<T> call2, Response<T> response) {
                AbstractC2796i.m5786g(call2, "call");
                AbstractC2796i.m5786g(response, "response");
                if (!response.isSuccessful()) {
                    ((C3827e) c3827e).resumeWith(AbstractC3280d.m6588f(new HttpException(response)));
                    return;
                }
                T tBody = response.body();
                if (tBody != null) {
                    ((C3827e) c3827e).resumeWith(tBody);
                    return;
                }
                Object objTag = call2.request().tag(Invocation.class);
                if (objTag == null) {
                    C4060b c4060b = new C4060b();
                    AbstractC2796i.m5789j(c4060b, AbstractC2796i.class.getName());
                    throw c4060b;
                }
                Method method = ((Invocation) objTag).method();
                StringBuilder sb = new StringBuilder("Response from ");
                AbstractC2796i.m5781b(method, "method");
                Class<?> declaringClass = method.getDeclaringClass();
                AbstractC2796i.m5781b(declaringClass, "method.declaringClass");
                sb.append(declaringClass.getName());
                sb.append('.');
                sb.append(method.getName());
                sb.append(" was null but response body type was declared as non-null");
                C4060b c4060b2 = new C4060b(sb.toString());
                ((C3827e) c3827e).resumeWith(AbstractC3280d.m6588f(c4060b2));
            }
        });
        return c3827e.m7657m();
    }

    public static final <T> Object awaitNullable(Call<T> call, InterfaceC0074d<? super T> interfaceC0074d) {
        final C3827e c3827e = new C3827e(AbstractC1466d.m3499r(interfaceC0074d), 1);
        c3827e.m7660p(new C3667x19835f11(call));
        call.enqueue(new Callback<T>() {
            @Override
            public void onFailure(Call<T> call2, Throwable th) {
                AbstractC2796i.m5786g(call2, "call");
                AbstractC2796i.m5786g(th, "t");
                ((C3827e) c3827e).resumeWith(AbstractC3280d.m6588f(th));
            }

            @Override
            public void onResponse(Call<T> call2, Response<T> response) {
                AbstractC2796i.m5786g(call2, "call");
                AbstractC2796i.m5786g(response, "response");
                if (response.isSuccessful()) {
                    ((C3827e) c3827e).resumeWith(response.body());
                } else {
                    ((C3827e) c3827e).resumeWith(AbstractC3280d.m6588f(new HttpException(response)));
                }
            }
        });
        return c3827e.m7657m();
    }

    public static final <T> Object awaitResponse(Call<T> call, InterfaceC0074d<? super Response<T>> interfaceC0074d) {
        final C3827e c3827e = new C3827e(AbstractC1466d.m3499r(interfaceC0074d), 1);
        c3827e.m7660p(new C3668xc95e9eb1(call));
        call.enqueue(new Callback<T>() {
            @Override
            public void onFailure(Call<T> call2, Throwable th) {
                AbstractC2796i.m5786g(call2, "call");
                AbstractC2796i.m5786g(th, "t");
                ((C3827e) c3827e).resumeWith(AbstractC3280d.m6588f(th));
            }

            @Override
            public void onResponse(Call<T> call2, Response<T> response) {
                AbstractC2796i.m5786g(call2, "call");
                AbstractC2796i.m5786g(response, "response");
                c3827e.resumeWith(response);
            }
        });
        return c3827e.m7657m();
    }

    public static final <T> T create(Retrofit retrofit) {
        AbstractC2796i.m5786g(retrofit, "$this$create");
        throw new UnsupportedOperationException("This function has a reified type parameter and thus can only be inlined at compilation time, not called directly.");
    }

    public static final Object suspendAndThrow(final Exception exc, InterfaceC0074d<?> interfaceC0074d) {
        final C36701 c36701;
        if (interfaceC0074d instanceof C36701) {
            c36701 = (C36701) interfaceC0074d;
            int i6 = c36701.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                c36701.label = i6 - Integer.MIN_VALUE;
            } else {
                c36701 = new C36701(interfaceC0074d);
            }
        } else {
            c36701 = new C36701(interfaceC0074d);
        }
        Object obj = c36701.result;
        EnumC1367a enumC1367a = EnumC1367a.f4179a;
        int i10 = c36701.label;
        if (i10 != 0) {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC3280d.m6570I(obj);
            return C4070l.f13734a;
        }
        AbstractC3280d.m6570I(obj);
        c36701.L$0 = exc;
        c36701.label = 1;
        AbstractC3819b0.f12901a.mo7665d(c36701.getContext(), new Runnable() {
            @Override
            public final void run() {
                AbstractC1466d.m3499r(c36701).resumeWith(AbstractC3280d.m6588f(exc));
            }
        });
        return enumC1367a;
    }
}
