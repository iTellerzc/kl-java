package com.kl.java.util.function;

import java.util.function.Consumer;

/**
 * @author iTeller_zc (zhangchao@elextec.com)
 * @date 2020/8/3 10:04
 * description
 **/
public class MyConsumer implements Consumer<String> {

    @Override
    public void accept(String s) {
        System.out.println("consume input:" + s);
    }
}
