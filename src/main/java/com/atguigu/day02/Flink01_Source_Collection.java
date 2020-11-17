package com.atguigu.day02;

import com.atguigu.day02.bean.SensorReading;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

import java.util.Arrays;

/**
 * @ClassName:   Flink01_Source_Collection  
 * @Package:     com.atguigu.day02   
 * @Description: TODO
 * @author:      不羁的风    
 * @date:        2020/11/17 14:19   
 * @version      V1.0 
 */
public class Flink01_Source_Collection {
    public static void main(String[] args) throws Exception {

        //获取执行环境
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setParallelism(1);

        //读取集合数据创建流
        DataStreamSource<SensorReading> sensorDS = env.fromCollection(Arrays.asList(
                new SensorReading("sensor_1", 1547718199L, 35.8),
                new SensorReading("sensor_6", 1547718201L, 15.4),
                new SensorReading("sensor_7", 1547718202L, 6.7),
                new SensorReading("sensor_10", 1547718205L, 38.1)
        ));

        //打印
        sensorDS.print();

        //启动任务
        env.execute("Flink01_Source_Collection");

    }
}
