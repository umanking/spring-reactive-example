package com.example.springreactiveexample;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class MyMonoSubscriber implements Subscriber<String> {

    @Override
    public void onSubscribe(Subscription subscription) {
        System.out.println("onSubscribe");
        subscription.request(1); // 요청을 해야함

    }

    @Override
    public void onNext(String s) {
        System.out.println("onNext: " + s);

    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println("onError : " + throwable.getMessage());
    }

    @Override
    public void onComplete() {
        System.out.println("onComplete");

    }
}
