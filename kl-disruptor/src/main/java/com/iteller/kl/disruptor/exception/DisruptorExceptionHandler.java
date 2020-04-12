package com.iteller.kl.disruptor.exception;

import com.iteller.kl.disruptor.event.DisruptorEvent;
import com.lmax.disruptor.ExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/4/3 15:52
 * description:事件处理异常捕获
 */
public class DisruptorExceptionHandler implements ExceptionHandler<DisruptorEvent> {

    private static final Logger LOGGER = LoggerFactory.getLogger(DisruptorExceptionHandler.class);

    public void handleEventException(Throwable ex, long sequence, DisruptorEvent event) {
        LOGGER.error("ignore process error, sequence:{}, event:{}!", sequence, event, ex);
    }

    public void handleOnStartException(Throwable ex) {
        LOGGER.error("start meet error!", ex);
    }

    public void handleOnShutdownException(Throwable ex) {
        LOGGER.error("stop meet error!", ex);
    }
}
