package com.kl.flink;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.common.functions.ReduceFunction;
import org.apache.flink.api.java.utils.ParameterTool;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.apache.flink.util.Collector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * author:18060903(iTeller_zc)
 * date:2019/10/21 15:30
 * description:
 */
public class SocketWindowWordCount {

    private static final Logger LOGGER = LoggerFactory.getLogger(SocketWindowWordCount.class);

    public static void main(String[] args) throws Exception {

        final int port;

        ParameterTool parameterTool =  ParameterTool.fromArgs(args);
        port = parameterTool.getInt("port", 9000);


        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        DataStream<String> text = env.socketTextStream("localhost", port, "\n");
        DataStream<WordWithCount> windowCounts = text.flatMap(new FlatMapFunction<String, WordWithCount>() {
            public void flatMap(String value, Collector<WordWithCount> collector) throws Exception {
                for(String s : value.split("\\s")){
                    collector.collect(new WordWithCount(s, 1l));
                }
            }
        }).keyBy("word")
        .timeWindow(Time.seconds(5), Time.seconds(1))
        .reduce(new ReduceFunction<WordWithCount>() {
            public WordWithCount reduce(WordWithCount a, WordWithCount b) throws Exception {
                return new WordWithCount(a.word, a.count + b.count);
            }
        });

        windowCounts.print().setParallelism(1);

        LOGGER.info("Socket Window WordCount");
        env.execute("Socket Window WordCount");
    }
}
