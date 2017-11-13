package com.example.demo.bean;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * Created by zhuxl on 2017/11/6.
 */
@Document(indexName = "user", type = "user", shards = 1, replicas = 0, refreshInterval = "-1")
public class Order {
    @Id
    private Long id;
    private String name;
    private Integer orderNum;
    private String remark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", orderNum=" + orderNum +
                ", remark='" + remark + '\'' +
                '}';
    }
}
