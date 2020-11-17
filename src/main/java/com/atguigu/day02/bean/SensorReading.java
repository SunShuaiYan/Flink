package com.atguigu.day02.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName:   SensorReading  
 * @Package:     com.atguigu.day02.bean   
 * @Description: TODO
 * @author:      不羁的风    
 * @date:        2020/11/17 14:22   
 * @version      V1.0 
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SensorReading {
    private String id;
    private Long ts;
    private Double temp;

    @Override
    public String toString() {
        return id + ", " + ts + ", " + temp;
    }
}

