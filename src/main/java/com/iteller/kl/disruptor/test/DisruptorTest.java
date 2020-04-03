package com.iteller.kl.disruptor.test;

import com.iteller.kl.disruptor.event.DisruptorEvent;
import com.iteller.kl.disruptor.exception.DisruptorExceptionHandler;
import com.iteller.kl.disruptor.factory.DisruptorEventFactory;
import com.iteller.kl.disruptor.handler.DisruptorEventHandler;
import com.lmax.disruptor.BusySpinWaitStrategy;
import com.lmax.disruptor.EventTranslator;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.util.concurrent.ThreadFactory;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/4/3 16:04
 * description:
 */
public class DisruptorTest {

    public static void main(String[] args){
        int ringBufferSize = 16; // must pow of 2
        Disruptor<DisruptorEvent> disruptor = new Disruptor<DisruptorEvent>(
                new DisruptorEventFactory(),//事件工厂
                ringBufferSize,//数组大小
                new ThreadFactory() {
                    public Thread newThread(Runnable r) {
                        return new Thread(r);
                    }
                },
                ProducerType.SINGLE,//生产类型
                new BusySpinWaitStrategy());//阻塞策略

        disruptor.setDefaultExceptionHandler(new DisruptorExceptionHandler());//异常处理

        disruptor.handleEventsWith(new DisruptorEventHandler());//事件消费

        disruptor.start();

        for(int i = 0; i < 100; i++){
            disruptor.publishEvent(new EventTranslator<DisruptorEvent>() {//事件发布
                public void translateTo(DisruptorEvent event, long sequence) {//事件传递
                    event.setMsg("this is test msg.");
                    event.setMsg(event.getMsg() + ":" + sequence);
                }
            });
        }

        disruptor.shutdown();
    }
}
