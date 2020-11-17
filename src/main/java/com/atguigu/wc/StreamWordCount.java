package com.atguigu.wc;


import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.api.java.utils.ParameterTool;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

/**
 * @ClassName:   StreamWordCount  
 * @Package:     com.atguigu.wc   
 * @Description: Flink无界流处理
 * @author:      不羁的风    
 * @date:        2020/11/15 15:31   
 * @version      V1.0 
 */
public class StreamWordCount {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        ParameterTool parameterTool = ParameterTool.fromArgs(args);
        String host = parameterTool.get("127.0.0.1");
        int port = parameterTool.getInt("7777");

        DataStream<String> inputDataStream = env.socketTextStream(host, port);
        DataStream<Tuple2<String, Integer>> wordCountDataStream = inputDataStream.flatMap(new MyFlatMapper()).keyBy(0).sum(1);

        wordCountDataStream.print().setParallelism(1);
        env.execute();
    }
}
