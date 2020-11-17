package com.atguigu.wc;

import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

/**
 * @ClassName:   WordCount_Bounded  
 * @Package:     com.atguigu.wc   
 * @Description: TODO
 * @author:      不羁的风    
 * @date:        2020/11/16 09:10   
 * @version      V1.0 
 */
public class WordCount_Bounded {
    public static void main(String[] args) throws Exception {

        //创建流程序运行环境
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        //读取文件数据创建流
        DataStreamSource<String> lineDataStream = env.readTextFile("files/hello.txt");

        //将每行数据切分为单词，转换为元祖并计算
        SingleOutputStreamOperator<Tuple2<String, Integer>> result = lineDataStream.flatMap(new MyFlatMapper()).keyBy(0).sum(1);

        //打印数据结果
        result.print();

        //启动任务
        env.execute("WordCount_Bounded");
    }
}
