package com.iteller.kl.disruptor.handler;

import com.iteller.kl.disruptor.event.DisruptorEvent;
import com.lmax.disruptor.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/4/3 16:01
 * description:事件消费处理
 */
public class DisruptorEventHandler implements EventHandler<DisruptorEvent> {

    private static final Logger LOGGER = LoggerFactory.getLogger(DisruptorEventHandler.class);

    public void onEvent(DisruptorEvent event, long sequence, boolean endOfBatch) throws Exception {
        //common here is async operation
        /*if(sequence % 8 == 0){
            TimeUnit.SECONDS.sleep(8);
            throw new RuntimeException("hit 8 magic");
        }*/
        LOGGER.info("first consumer consume event:{}, sequence:{}, endOfBatch:{}.", event, sequence, endOfBatch);
    }
}
