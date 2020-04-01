package me.mehedee.accounts;

import org.junit.Test;

import java.util.concurrent.Executors;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class RxTests {

    @Test
    public void rxJavaTest() {

        Observable<String> myObs = Observable.just("1", "2", "3", "4");

        System.out.println("no sub yet");

        myObs.observeOn(Schedulers.from(Executors.newSingleThreadExecutor())).subscribe(s -> {
            System.out.println("Got: " + s);
            Thread.sleep(1000);
        }, Throwable::printStackTrace, () -> System.out.println("Complete"), s -> System.out.println("Got subbed"));
        System.out.println("lalala");
        myObs.subscribe(s -> System.out.println("Got2: " + s), Throwable::printStackTrace, () -> System.out.println("Complete2"), s -> System.out.println("Got subbed2"));


    }
}
