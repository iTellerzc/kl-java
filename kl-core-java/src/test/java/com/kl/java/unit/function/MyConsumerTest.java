package com.kl.java.unit.function;

import com.kl.java.util.function.MyConsumer;
import org.testng.annotations.Test;

/**
 * @author iTeller_zc (zhangchao@elextec.com)
 * @date 2020/8/3 10:05
 * description
 **/
public class MyConsumerTest {

    @Test
    public void testAccept(){
        MyConsumer myConsumer = new MyConsumer();
        myConsumer.accept("hello, function interface!");
    }
}
