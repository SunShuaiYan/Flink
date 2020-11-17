package com.atguigu.wordcount;

import com.atguigu.wc.MyFlatMapper;
import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.operators.AggregateOperator;
import org.apache.flink.api.java.operators.DataSource;
import org.apache.flink.api.java.operators.FlatMapOperator;
import org.apache.flink.api.java.operators.UnsortedGrouping;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.util.Collector;

/**
 * @ClassName:   Flink01_WordCount_Batch  
 * @Package:     com.atguigu.wordcount   
 * @Description: Flink实现批处理Wordcount
 * @author:      不羁的风    
 * @date:        2020/11/16 14:45   
 * @version      V1.0 
 */
public class Flink01_WordCount_Batch {
    public static void main(String[] args) throws Exception {

        //创建执行环境
        ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();

        //读取文件数据
        DataSource<String> lineDS = env.readTextFile("files/hello.txt");

        //压平操作
        FlatMapOperator<String, Tuple2<String, Integer>> wordToOneDS = lineDS.flatMap(new MyFlatMapFunc());

        //分组
        UnsortedGrouping<Tuple2<String, Integer>> groupBy = wordToOneDS.groupBy(0);

        //聚合计算
        AggregateOperator<Tuple2<String, Integer>> result = groupBy.sum(1);

        //打印结果
        result.print();

    }

    public static class MyFlatMapFunc implements FlatMapFunction<String,Tuple2<String,Integer>>{

        public void flatMap(String value, Collector<Tuple2<String, Integer>> out) throws Exception {
            //按空格进行切分
            String[] words = value.split(" ");
            //遍历words输出数据
            for(String word:words){
                out.collect(new Tuple2<String, Integer>(word,1));
            }
        }
    }


}
