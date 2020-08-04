package com.kl.disruptor.factory;

import com.kl.disruptor.event.DisruptorEvent;
import com.lmax.disruptor.EventFactory;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/4/3 15:47
 * description:事件工厂
 */
public class DisruptorEventFactory implements EventFactory<DisruptorEvent> {

    public DisruptorEvent newInstance() {
        return new DisruptorEvent();
    }
}
