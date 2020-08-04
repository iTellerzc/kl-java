package com.kl.disruptor.handler;

import com.kl.disruptor.event.DisruptorEvent;
import com.lmax.disruptor.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.*;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/4/3 17:50
 * description:
 */
public class DisruptorEventHandler2 implements EventHandler<DisruptorEvent> {

    private static final Logger LOGGER = LoggerFactory.getLogger(DisruptorEventHandler2.class);

    private CompletionService<String> completionService;

    public DisruptorEventHandler2(CompletionService<String> completionService){
        this.completionService = completionService;
    }

    public void onEvent(DisruptorEvent event, final long sequence, boolean endOfBatch) throws Exception {
        LOGGER.info("second consumer consume event:{}, sequence:{}, endOfBatch:{}.", event, sequence, endOfBatch);
        Future<String> futureTask = completionService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                TimeUnit.SECONDS.sleep(2);
                return "hello:" + sequence;
            }
        });
        //block waitting
        //System.out.println("seq:" + sequence + " result:" + futureTask.get());
    }
}
