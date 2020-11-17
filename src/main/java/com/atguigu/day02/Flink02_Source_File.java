package com.atguigu.day02;

import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

/**
 * @ClassName:   Flink02_Source_File  
 * @Package:     com.atguigu.day02   
 * @Description: TODO
 * @author:      不羁的风    
 * @date:        2020/11/17 14:33   
 * @version      V1.0 
 */
public class Flink02_Source_File {
    public static void main(String[] args) throws Exception {

        //获取执行环境
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setParallelism(1);

        //从文件中读取数据
        DataStreamSource<String> sensorDS = env.readTextFile("files/sensor");

        //打印
        sensorDS.print();

        //启动任务
        env.execute("Flink02_Source_File");

    }
}
