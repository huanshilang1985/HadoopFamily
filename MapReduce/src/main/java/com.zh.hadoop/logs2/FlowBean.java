package com.zh.hadoop.logs2;

import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * @Author zhanghe
 * @Desc: hadoop数据类型实现了序列化接口，如果自定义需要实现这个序列化接口
 * @Date 2019/2/13 23:25
 */
public class FlowBean implements Writable {

    //上行流量
    private long upFlow;
    //下行流量
    private long dfFlow;
    //总流量总和
    private long flowsum;

    public FlowBean() {

    }

    public FlowBean(long upFlow, long dfFlow) {
        this.upFlow = upFlow;
        this.dfFlow = dfFlow;
        this.flowsum = upFlow + dfFlow;
    }

    public long getUpFlow() {
        return upFlow;
    }

    public void setUpFlow(long upFlow) {
        this.upFlow = upFlow;
    }

    public long getDfFlow() {
        return dfFlow;
    }

    public void setDfFlow(long dfFlow) {
        this.dfFlow = dfFlow;
    }

    public long getFlowsum() {
        return flowsum;
    }

    public void setFlowsum(long flowsum) {
        this.flowsum = flowsum;
    }

    //序列化
    public void write(DataOutput out) throws IOException {
        out.writeLong(upFlow);
        out.writeLong(dfFlow);
        out.writeLong(flowsum);
    }

    //反序列化
    public void readFields(DataInput in) throws IOException {
        upFlow = in.readLong();
        dfFlow = in.readLong();
        flowsum = in.readLong();
    }

    @Override
    public String toString() {
        return upFlow + "\t" + dfFlow + "\t" + flowsum;
    }
}
