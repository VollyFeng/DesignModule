package com.design.demo.behavior.observer_module.eventbus;

import com.google.common.util.concurrent.MoreExecutors;

import java.util.List;
import java.util.concurrent.Executor;

public class EventBus {

    private Executor executor;
    private ObserverRegistry registry = new ObserverRegistry();

    public EventBus() {
        this(MoreExecutors.directExecutor());
    }

    public EventBus(Executor executor) {
        this.executor = executor;
    }

    public void register(Object observer) {
        this.registry.register(observer);
    }

    public void post(Object event) {
        List<ObserverAction> observerActions = this.registry.getMatchedObserverActions(event);
        for (ObserverAction action : observerActions) {
            this.executor.execute(new Runnable() {
                @Override
                public void run() {
                    action.execute(event);
                }
            });
        }
    }
}
