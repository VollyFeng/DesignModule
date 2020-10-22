package com.design.demo.behavior.observer_module;


import com.design.demo.behavior.observer_module.eventbus.Subscribe;

public class LongEventObserver {

    @Subscribe
    public void handleSubscribeSuccess(Long event) {
        System.out.println("LongEventObserver: handleSubscribeSuccess , event " + event);
    }

}
