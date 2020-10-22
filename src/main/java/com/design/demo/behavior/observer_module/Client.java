package com.design.demo.behavior.observer_module;

import com.design.demo.behavior.observer_module.eventbus.EventBus;

public class Client {
    public static void main(String[] args) {
        Client client = new Client();
        client.register(new LongEventObserver());
        client.register(new StringEventObserver());
        client.notifyLong(12l);
        client.notifyString("hello");
    }

    private EventBus eventBus = new EventBus();

    public void register(Object observer) {
        eventBus.register(observer);
    }

    public void notifyLong(Long message) {
        eventBus.post(message);
    }

    public void notifyString(String message) {
        eventBus.post(message);
    }
}
