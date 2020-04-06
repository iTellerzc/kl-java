package com.iteller.kl.disruptor.handler;

import com.iteller.kl.disruptor.event.DisruptorEvent;
import com.lmax.disruptor.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/4/3 17:50
 * description:
 */
public class DisruptorEventHandler2 implements EventHandler<DisruptorEvent> {

    private static final Logger LOGGER = LoggerFactory.getLogger(DisruptorEventHandler2.class);

    public void onEvent(DisruptorEvent event, long sequence, boolean endOfBatch) throws Exception {
        LOGGER.info("second consumer consume event:{}, sequence:{}, endOfBatch:{}.", event, sequence, endOfBatch);
    }
}
