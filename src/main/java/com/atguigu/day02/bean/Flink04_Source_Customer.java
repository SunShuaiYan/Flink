package com.atguigu.day02.bean;

import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.source.SourceFunction;

import java.util.HashMap;
import java.util.Random;
/**
 * @ClassName:   Flink04_Source_Customer  
 * @Package:     com.atguigu.day02.bean   
 * @Description: TODO
 * @author:      不羁的风    
 * @date:        2020/11/17 15:13   
 * @version      V1.0 
 */
public class Flink04_Source_Customer {

    public static void main(String[] args) {

        //获取执行环境
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setParallelism(1);

        //从自定义的Source中读取数据
        DataStreamSource<SensorReading> mySourceDS = env.addSource(new CustomerSource());

        //打印

    }

    public static class CustomerSource implements SourceFunction<SensorReading>{

        //定义标志位控制数据接收
        private boolean running  = true;

        Random random = new Random();


        public void run(SourceContext ctx) throws Exception {

          //定义Map
          HashMap<String, Object> tempMap = new HashMap();

        }

        public void cancel() {

        }
    }

}
