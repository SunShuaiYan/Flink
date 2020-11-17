package com.atguigu.wc;

import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.operators.AggregateOperator;
import org.apache.flink.api.java.operators.DataSource;
import org.apache.flink.api.java.tuple.Tuple2;

/**
 * @ClassName:   WordCount  
 * @Package:     com.atguigu.wc   
 * @Description: 批处理
 * @author:      不羁的风    
 * @date:        2020/11/15 14:29   
 * @version      V1.0 
 */
public class WordCount {
    public static void main(String[] args) throws Exception {
        //创建环境
        ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();

        //从文件中读取数据
        String inputPath = "files/hello.txt";
        DataSource<String> inputDateSet = env.readTextFile(inputPath);

        //空格分词打散之后，对单词进行groupBy分组，然后用sum进行聚合
        DataSet<Tuple2<String,Integer>> wordCountDataSet  =  inputDateSet.flatMap(new MyFlatMapper()).groupBy(0).sum(1);

        //打印输出
        wordCountDataSet.print();





    }
}
