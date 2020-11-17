package com.atguigu.wc;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.util.Collector;

/**
 * @ClassName:   MyFlatMapper  
 * @Package:     com.atguigu.wc   
 * @Description: TODO
 * @author:      不羁的风    
 * @date:        2020/11/15 14:35   
 * @version      V1.0 
 */
public class MyFlatMapper implements FlatMapFunction<String, Tuple2<String,Integer>>{

    public void flatMap(String value, Collector<Tuple2<String, Integer>> out) throws Exception {
        String[] words = value.split(" ");
        for (String word : words) {
            out.collect(new Tuple2<String, Integer>(word,1));
        }
    }
}
