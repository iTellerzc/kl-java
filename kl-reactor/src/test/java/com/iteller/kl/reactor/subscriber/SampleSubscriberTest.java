package com.iteller.kl.reactor.subscriber;

import org.testng.annotations.Test;
import reactor.core.publisher.Flux;

/**
 * @author iTeller_zc (zhangchao@elextec.com)
 * @date 2020/7/30 11:28
 * description
 **/
public class SampleSubscriberTest {

    @Test
    public void testBaseSubscriber(){
        SampleSubscriber<Integer> sampleSubscriber = new SampleSubscriber<>();
        Flux<Integer> flux = Flux.range(1, 4);
        flux.subscribe(
                i -> System.out.println(i),
                error -> System.err.println(error),
                () -> System.out.println("done"),
                s -> s.request(10)
        );
        flux.subscribe(sampleSubscriber);
    }
}
