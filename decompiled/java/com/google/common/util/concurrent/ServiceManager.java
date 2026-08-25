package com.google.common.util.concurrent;

import java.lang.ref.WeakReference;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import p002a1.C0026b;
import p020b7.AbstractC1332b;
import p020b7.C1337d0;
import p020b7.C1357q;
import p020b7.C1358r;
import p020b7.C1359s;
import p020b7.C1360t;
import p020b7.EnumC1365y;
import p020b7.InterfaceC1346i;
import p041d7.AbstractC2182d0;
import p041d7.AbstractC2233k2;
import p041d7.AbstractC2274q1;
import p041d7.AbstractC2292s5;
import p041d7.AbstractC2301u1;
import p041d7.AbstractC2331z1;
import p041d7.C2166a5;
import p041d7.C2175c0;
import p041d7.C2203g0;
import p041d7.C2204g1;
import p041d7.C2217i0;
import p041d7.C2226j2;
import p041d7.C2240l2;
import p041d7.C2254n2;
import p041d7.C2277q4;
import p041d7.C2280r0;
import p041d7.C2281r1;
import p041d7.C2291s4;
import p041d7.C2325y1;
import p041d7.InterfaceC2243l5;
import p041d7.InterfaceC2310v4;

@ElementTypesAreNonnullByDefault
public final class ServiceManager implements ServiceManagerBridge {
    private final AbstractC2301u1 services;
    private final ServiceManagerState state;
    private static final LazyLogger logger = new LazyLogger(ServiceManager.class);
    private static final ListenerCallQueue.Event<Listener> HEALTHY_EVENT = new ListenerCallQueue.Event<Listener>() {
        public String toString() {
            return "healthy()";
        }

        @Override
        public void call(Listener listener) {
            listener.healthy();
        }
    };
    private static final ListenerCallQueue.Event<Listener> STOPPED_EVENT = new ListenerCallQueue.Event<Listener>() {
        public String toString() {
            return "stopped()";
        }

        @Override
        public void call(Listener listener) {
            listener.stopped();
        }
    };

    public static final class EmptyServiceManagerWarning extends Throwable {
        private EmptyServiceManagerWarning() {
        }
    }

    public static final class FailedService extends Throwable {
        public FailedService(Service service) {
            super(service.toString(), service.failureCause(), false, false);
        }
    }

    public static final class NoOpService extends AbstractService {
        private NoOpService() {
        }

        @Override
        public void doStart() throws Exception {
            notifyStarted();
        }

        @Override
        public void doStop() throws Exception {
            notifyStopped();
        }
    }

    public static final class ServiceListener extends Service.Listener {
        final Service service;
        final WeakReference<ServiceManagerState> state;

        public ServiceListener(Service service, WeakReference<ServiceManagerState> weakReference) {
            this.service = service;
            this.state = weakReference;
        }

        @Override
        public void failed(Service.State state, Throwable th) throws Exception {
            ServiceManagerState serviceManagerState = this.state.get();
            if (serviceManagerState != null) {
                if ((!(this.service instanceof NoOpService)) & (state != Service.State.STARTING)) {
                    ServiceManager.logger.get().log(Level.SEVERE, "Service " + this.service + " has failed in the " + state + " state.", th);
                }
                serviceManagerState.transitionService(this.service, state, Service.State.FAILED);
            }
        }

        @Override
        public void running() throws Exception {
            ServiceManagerState serviceManagerState = this.state.get();
            if (serviceManagerState != null) {
                serviceManagerState.transitionService(this.service, Service.State.STARTING, Service.State.RUNNING);
            }
        }

        @Override
        public void starting() throws Exception {
            ServiceManagerState serviceManagerState = this.state.get();
            if (serviceManagerState != null) {
                serviceManagerState.transitionService(this.service, Service.State.NEW, Service.State.STARTING);
                if (this.service instanceof NoOpService) {
                    return;
                }
                ServiceManager.logger.get().log(Level.FINE, "Starting {0}.", this.service);
            }
        }

        @Override
        public void stopping(Service.State state) throws Exception {
            ServiceManagerState serviceManagerState = this.state.get();
            if (serviceManagerState != null) {
                serviceManagerState.transitionService(this.service, state, Service.State.STOPPING);
            }
        }

        @Override
        public void terminated(Service.State state) throws Exception {
            ServiceManagerState serviceManagerState = this.state.get();
            if (serviceManagerState != null) {
                if (!(this.service instanceof NoOpService)) {
                    ServiceManager.logger.get().log(Level.FINE, "Service {0} has terminated. Previous state was: {1}", new Object[]{this.service, state});
                }
                serviceManagerState.transitionService(this.service, state, Service.State.TERMINATED);
            }
        }
    }

    public ServiceManager(Iterable<? extends Service> iterable) {
        AbstractC2301u1 abstractC2301u1M5271m = AbstractC2301u1.m5271m(iterable);
        if (abstractC2301u1M5271m.isEmpty()) {
            logger.get().log(Level.WARNING, "ServiceManager configured with no services.  Is your application configured properly?", (Throwable) new EmptyServiceManagerWarning());
            abstractC2301u1M5271m = AbstractC2301u1.m5275r(new NoOpService());
        }
        ServiceManagerState serviceManagerState = new ServiceManagerState(abstractC2301u1M5271m);
        this.state = serviceManagerState;
        this.services = abstractC2301u1M5271m;
        WeakReference weakReference = new WeakReference(serviceManagerState);
        C2204g1 c2204g1ListIterator = abstractC2301u1M5271m.listIterator(0);
        while (c2204g1ListIterator.hasNext()) {
            Service service = (Service) c2204g1ListIterator.next();
            service.addListener(new ServiceListener(service, weakReference), MoreExecutors.directExecutor());
            AbstractC1332b.m3212c(service, "Can only manage NEW services, %s", service.state() == Service.State.NEW);
        }
        this.state.markReady();
    }

    public void addListener(Listener listener, Executor executor) {
        this.state.addListener(listener, executor);
    }

    public void awaitHealthy() {
        this.state.awaitHealthy();
    }

    public void awaitStopped() {
        this.state.awaitStopped();
    }

    public boolean isHealthy() {
        C2204g1 c2204g1ListIterator = this.services.listIterator(0);
        while (c2204g1ListIterator.hasNext()) {
            if (!((Service) c2204g1ListIterator.next()).isRunning()) {
                return false;
            }
        }
        return true;
    }

    public ServiceManager startAsync() {
        C2204g1 c2204g1ListIterator = this.services.listIterator(0);
        while (c2204g1ListIterator.hasNext()) {
            AbstractC1332b.m3222m(this, "Not all services are NEW, cannot start %s", ((Service) c2204g1ListIterator.next()).state() == Service.State.NEW);
        }
        C2204g1 c2204g1ListIterator2 = this.services.listIterator(0);
        while (c2204g1ListIterator2.hasNext()) {
            Service service = (Service) c2204g1ListIterator2.next();
            try {
                this.state.tryStartTiming(service);
                service.startAsync();
            } catch (IllegalStateException e5) {
                logger.get().log(Level.WARNING, "Unable to start Service " + service, (Throwable) e5);
            }
        }
        return this;
    }

    public AbstractC2331z1 startupTimes() {
        return this.state.startupTimes();
    }

    public ServiceManager stopAsync() {
        C2204g1 c2204g1ListIterator = this.services.listIterator(0);
        while (c2204g1ListIterator.hasNext()) {
            ((Service) c2204g1ListIterator.next()).stopAsync();
        }
        return this;
    }

    public String toString() {
        C0026b c0026b = new C0026b("ServiceManager");
        c0026b.m127d(AbstractC2182d0.m5148k(this.services, new C1360t(new C1358r(NoOpService.class))), "services");
        return c0026b.toString();
    }

    public static final class ServiceManagerState {
        final Monitor.Guard awaitHealthGuard;
        final ListenerCallQueue<Listener> listeners;
        final Monitor monitor = new Monitor();
        final int numberOfServices;
        boolean ready;
        final InterfaceC2243l5 servicesByState;
        final IdentityHashMap<Service, C1337d0> startupTimers;
        final InterfaceC2310v4 states;
        final Monitor.Guard stoppedGuard;
        boolean transitioned;

        public final class AwaitHealthGuard extends Monitor.Guard {
            public AwaitHealthGuard() {
                super(ServiceManagerState.this.monitor);
            }

            @Override
            public boolean isSatisfied() {
                int iCount = ServiceManagerState.this.states.count(Service.State.RUNNING);
                ServiceManagerState serviceManagerState = ServiceManagerState.this;
                return iCount == serviceManagerState.numberOfServices || serviceManagerState.states.contains(Service.State.STOPPING) || ServiceManagerState.this.states.contains(Service.State.TERMINATED) || ServiceManagerState.this.states.contains(Service.State.FAILED);
            }
        }

        public final class StoppedGuard extends Monitor.Guard {
            public StoppedGuard() {
                super(ServiceManagerState.this.monitor);
            }

            @Override
            public boolean isSatisfied() {
                return ServiceManagerState.this.states.count(Service.State.FAILED) + ServiceManagerState.this.states.count(Service.State.TERMINATED) == ServiceManagerState.this.numberOfServices;
            }
        }

        public ServiceManagerState(AbstractC2274q1 abstractC2274q1) {
            AbstractC2182d0.m5141d(2, "expectedValuesPerKey");
            EnumMap enumMap = new EnumMap(Service.State.class);
            C2277q4 c2277q4 = new C2277q4(1);
            C2291s4 c2291s4 = new C2291s4(enumMap);
            c2291s4.f8055h = c2277q4;
            this.servicesByState = c2291s4;
            this.states = c2291s4.mo5174f();
            this.startupTimers = new IdentityHashMap<>();
            this.awaitHealthGuard = new AwaitHealthGuard();
            this.stoppedGuard = new StoppedGuard();
            this.listeners = new ListenerCallQueue<>();
            this.numberOfServices = abstractC2274q1.size();
            c2291s4.m5286n(abstractC2274q1, Service.State.NEW);
        }

        public void addListener(Listener listener, Executor executor) {
            this.listeners.addListener(listener, executor);
        }

        public void awaitHealthy() {
            this.monitor.enterWhenUninterruptibly(this.awaitHealthGuard);
            try {
                checkHealthy();
            } finally {
                this.monitor.leave();
            }
        }

        public void awaitStopped() {
            this.monitor.enterWhenUninterruptibly(this.stoppedGuard);
            this.monitor.leave();
        }

        public void checkHealthy() {
            InterfaceC2310v4 interfaceC2310v4 = this.states;
            Service.State state = Service.State.RUNNING;
            if (interfaceC2310v4.count(state) != this.numberOfServices) {
                StringBuilder sb = new StringBuilder("Expected to be healthy after starting. The following services are not running: ");
                sb.append(AbstractC2182d0.m5150m(this.servicesByState, new C1360t(state == null ? EnumC1365y.f4176a : new C1359s(state))));
                IllegalStateException illegalStateException = new IllegalStateException(sb.toString());
                Iterator it = this.servicesByState.get((Object) Service.State.FAILED).iterator();
                while (it.hasNext()) {
                    illegalStateException.addSuppressed(new FailedService((Service) it.next()));
                }
                throw illegalStateException;
            }
        }

        public void dispatchListenerEvents() throws Exception {
            AbstractC1332b.m3223n("It is incorrect to execute listeners with the monitor held.", !this.monitor.isOccupiedByCurrentThread());
            this.listeners.dispatch();
        }

        public void enqueueFailedEvent(final Service service) {
            this.listeners.enqueue(new ListenerCallQueue.Event<Listener>(this) {
                final ServiceManagerState this$0;

                {
                    this.this$0 = this;
                }

                public String toString() {
                    return "failed({service=" + service + "})";
                }

                @Override
                public void call(Listener listener) {
                    listener.failure(service);
                }
            });
        }

        public void enqueueHealthyEvent() {
            this.listeners.enqueue(ServiceManager.HEALTHY_EVENT);
        }

        public void enqueueStoppedEvent() {
            this.listeners.enqueue(ServiceManager.STOPPED_EVENT);
        }

        public void markReady() {
            this.monitor.enter();
            try {
                if (!this.transitioned) {
                    this.ready = true;
                    this.monitor.leave();
                    return;
                }
                ArrayList arrayList = new ArrayList();
                AbstractC2292s5 it = servicesByState().m5179r().iterator();
                while (it.hasNext()) {
                    Service service = (Service) it.next();
                    if (service.state() != Service.State.NEW) {
                        arrayList.add(service);
                    }
                }
                throw new IllegalArgumentException("Services started transitioning asynchronously before the ServiceManager was constructed: " + arrayList);
            } catch (Throwable th) {
                this.monitor.leave();
                throw th;
            }
        }

        public C2254n2 servicesByState() {
            C2240l2 c2240l2 = new C2240l2();
            this.monitor.enter();
            try {
                for (Map.Entry entry : this.servicesByState.mo5108a()) {
                    if (!(entry.getValue() instanceof NoOpService)) {
                        c2240l2.mo5120d(entry.getKey(), entry.getValue());
                    }
                }
                this.monitor.leave();
                C2217i0 c2217i0 = (C2217i0) c2240l2.f7850a;
                if (c2217i0 == null) {
                    return C2280r0.f8037j;
                }
                Collection collectionEntrySet = c2217i0.entrySet();
                if (((AbstractCollection) collectionEntrySet).isEmpty()) {
                    return C2280r0.f8037j;
                }
                C2203g0<Map.Entry> c2203g0 = (C2203g0) collectionEntrySet;
                C2325y1 c2325y1 = new C2325y1(((C2217i0) c2203g0.f7904b).size());
                int size = 0;
                for (Map.Entry entry2 : c2203g0) {
                    Object key = entry2.getKey();
                    AbstractC2233k2 abstractC2233k2M5236l = AbstractC2233k2.m5236l(((C2226j2) entry2.getValue()).m5224i());
                    if (!abstractC2233k2M5236l.isEmpty()) {
                        c2325y1.m5292b(key, abstractC2233k2M5236l);
                        size = abstractC2233k2M5236l.size() + size;
                    }
                }
                return new C2254n2(c2325y1.m5291a(), size);
            } catch (Throwable th) {
                this.monitor.leave();
                throw th;
            }
        }

        public AbstractC2331z1 startupTimes() {
            this.monitor.enter();
            try {
                ArrayList arrayListM5157t = AbstractC2182d0.m5157t(this.startupTimers.size());
                for (Map.Entry<Service, C1337d0> entry : this.startupTimers.entrySet()) {
                    Service key = entry.getKey();
                    C1337d0 value = entry.getValue();
                    boolean z7 = value.f4151a;
                    if (!z7 && !(key instanceof NoOpService)) {
                        arrayListM5157t.add(new C2281r1(key, Long.valueOf(TimeUnit.MILLISECONDS.convert(z7 ? (System.nanoTime() - value.f4153c) + value.f4152b : value.f4152b, TimeUnit.NANOSECONDS))));
                    }
                }
                this.monitor.leave();
                C2166a5 c2166a5 = C2166a5.f7831a;
                InterfaceC1346i interfaceC1346i = new InterfaceC1346i() {
                    @Override
                    public Long apply(Map.Entry<Service, Long> entry2) {
                        return entry2.getValue();
                    }
                };
                c2166a5.getClass();
                Collections.sort(arrayListM5157t, new C2175c0(interfaceC1346i, c2166a5));
                return AbstractC2331z1.m5297c(arrayListM5157t);
            } catch (Throwable th) {
                this.monitor.leave();
                throw th;
            }
        }

        public void transitionService(Service service, Service.State state, Service.State state2) throws Exception {
            service.getClass();
            AbstractC1332b.m3215f(state != state2);
            this.monitor.enter();
            try {
                this.transitioned = true;
                if (!this.ready) {
                    this.monitor.leave();
                    dispatchListenerEvents();
                    return;
                }
                if (!this.servicesByState.remove(state, service)) {
                    throw new IllegalStateException(AbstractC1332b.m3228s("Service %s not at the expected location in the state map %s", service, state));
                }
                if (!this.servicesByState.put(state2, service)) {
                    throw new IllegalStateException(AbstractC1332b.m3228s("Service %s in the state map unexpectedly at %s", service, state2));
                }
                C1337d0 c1337d0 = this.startupTimers.get(service);
                if (c1337d0 == null) {
                    c1337d0 = new C1337d0();
                    AbstractC1332b.m3223n("This stopwatch is already running.", !c1337d0.f4151a);
                    c1337d0.f4151a = true;
                    c1337d0.f4153c = System.nanoTime();
                    this.startupTimers.put(service, c1337d0);
                }
                Service.State state3 = Service.State.RUNNING;
                if (state2.compareTo(state3) >= 0 && c1337d0.f4151a) {
                    long jNanoTime = System.nanoTime();
                    AbstractC1332b.m3223n("This stopwatch is already stopped.", c1337d0.f4151a);
                    c1337d0.f4151a = false;
                    c1337d0.f4152b = (jNanoTime - c1337d0.f4153c) + c1337d0.f4152b;
                    if (!(service instanceof NoOpService)) {
                        ServiceManager.logger.get().log(Level.FINE, "Started {0} in {1}.", new Object[]{service, c1337d0});
                    }
                }
                Service.State state4 = Service.State.FAILED;
                if (state2 == state4) {
                    enqueueFailedEvent(service);
                }
                if (this.states.count(state3) == this.numberOfServices) {
                    enqueueHealthyEvent();
                } else if (this.states.count(Service.State.TERMINATED) + this.states.count(state4) == this.numberOfServices) {
                    enqueueStoppedEvent();
                }
                this.monitor.leave();
                dispatchListenerEvents();
            } catch (Throwable th) {
                this.monitor.leave();
                dispatchListenerEvents();
                throw th;
            }
        }

        public void tryStartTiming(Service service) {
            this.monitor.enter();
            try {
                if (this.startupTimers.get(service) == null) {
                    IdentityHashMap<Service, C1337d0> identityHashMap = this.startupTimers;
                    C1337d0 c1337d0 = new C1337d0();
                    AbstractC1332b.m3223n("This stopwatch is already running.", !c1337d0.f4151a);
                    c1337d0.f4151a = true;
                    c1337d0.f4153c = System.nanoTime();
                    identityHashMap.put(service, c1337d0);
                }
            } finally {
                this.monitor.leave();
            }
        }

        public void awaitStopped(long j10, TimeUnit timeUnit) throws TimeoutException {
            this.monitor.enter();
            try {
                if (!this.monitor.waitForUninterruptibly(this.stoppedGuard, j10, timeUnit)) {
                    throw new TimeoutException("Timeout waiting for the services to stop. The following services have not stopped: " + AbstractC2182d0.m5150m(this.servicesByState, new C1360t(new C1357q(EnumSet.of(Service.State.TERMINATED, Service.State.FAILED)))));
                }
                this.monitor.leave();
            } catch (Throwable th) {
                this.monitor.leave();
                throw th;
            }
        }

        public void awaitHealthy(long j10, TimeUnit timeUnit) throws TimeoutException {
            this.monitor.enter();
            try {
                if (!this.monitor.waitForUninterruptibly(this.awaitHealthGuard, j10, timeUnit)) {
                    throw new TimeoutException("Timeout waiting for the services to become healthy. The following services have not started: " + AbstractC2182d0.m5150m(this.servicesByState, new C1357q(AbstractC2233k2.m5235k(new Object[]{Service.State.NEW, Service.State.STARTING}, 2))));
                }
                checkHealthy();
                this.monitor.leave();
            } catch (Throwable th) {
                this.monitor.leave();
                throw th;
            }
        }
    }

    public void awaitHealthy(long j10, TimeUnit timeUnit) throws TimeoutException {
        this.state.awaitHealthy(j10, timeUnit);
    }

    public void awaitStopped(long j10, TimeUnit timeUnit) throws TimeoutException {
        this.state.awaitStopped(j10, timeUnit);
    }

    @Override
    public C2254n2 servicesByState() {
        return this.state.servicesByState();
    }

    public static abstract class Listener {
        public void healthy() {
        }

        public void stopped() {
        }

        public void failure(Service service) {
        }
    }
}
