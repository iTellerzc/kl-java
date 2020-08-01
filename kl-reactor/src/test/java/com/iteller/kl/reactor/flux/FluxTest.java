package com.iteller.kl.reactor.flux;

import org.testng.annotations.Test;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;

/**
 * @author iTeller_zc (zhangchao@elextec.com)
 * @date 2020/7/29 17:02
 * description
 **/
public class FluxTest {

    @Test
    public void testSimpleFlux(){
        Flux<Integer> flux = Flux.range(1, 3);
        flux.subscribe(i ->
            System.out.println(i)
        );
    }

    @Test
    public void testErrorFlux(){
        Flux<Integer> flux = Flux.range(1, 4)
        .map(i -> {
            if(i <= 3){
                return i;
            }
            throw new RuntimeException("gt 3");
        });
        flux.subscribe(i ->
                System.out.println(i),
                error -> System.out.println(error));
    }

    @Test
    public void testDoneFlux(){
        Flux<Integer> flux = Flux.range(1, 4);
               /* .map(i -> {
                    if(i <= 3){
                        return i;
                    }
                    throw new RuntimeException("gt 3");
                });*/
        flux.subscribe(i ->
                        System.out.println(i),
                error -> System.out.println(error),
                () -> System.out.println("done"));
    }

    @Test
    public void testSubFlux(){
        Flux<Integer> flux = Flux.range(1, 4);
        flux.subscribe(i ->
                        System.out.println(i),
                error -> System.out.println(error),
                () -> System.out.println("done"),
                sub -> sub.request(10));
    }

    @Test
    public void testFromIterable(){
       Flux<String> seq1 =  Flux.just("a", "b", "c");
       System.out.println(seq1.blockFirst());
       System.out.println(seq1);
       List<String> iterable = Arrays.asList("a", "b", "c");
       Flux<String> seq2 = Flux.fromIterable(iterable);
       System.out.println(seq2.blockFirst());
       System.out.println(seq2);
    }
}
