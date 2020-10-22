package com.design.demo.behavior.observer_module;

import com.design.pattern.behavior.observer_module.eventbus.Subscribe;

public class StringEventObserver {
    @Subscribe
    public void handleSubscribeSuccess(String event) {
        System.out.println("StringEventObserver: handleSubscribeSuccess , event "+ event);
    }

}
