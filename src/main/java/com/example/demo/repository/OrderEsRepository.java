package com.example.demo.repository;

import com.example.demo.bean.Order;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * ES操作
 * Created by zhuxl on 2017/11/6.
 */
public interface OrderEsRepository extends ElasticsearchRepository<Order, Long> {
}
