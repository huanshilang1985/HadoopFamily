package com.zh.hadoop.logs;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * @Author zhanghe
 * @Desc: 根据想要的结果的kv类型 手机号 流量总和(上行+下行) 自定义类
 * @Date 2019/2/13 23:37
 */
public class FlowCountMapper extends Mapper<LongWritable, Text, Text, FlowBean> {

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        //1. 接入数据
        String line = value.toString();
        //2. 切割 \t
        String[] fields = line.split("\t");
        //3. 拿到关键字段：手机号 上行流量 下行流量
        String phoneNr = fields[1];
        long upFlow = Long.parseLong(fields[fields.length - 3]);
        long dfFlow = Long.parseLong(fields[fields.length - 2]);
        //4. 写出到reducer
        context.write(new Text(phoneNr), new FlowBean(upFlow, dfFlow));
    }
}
