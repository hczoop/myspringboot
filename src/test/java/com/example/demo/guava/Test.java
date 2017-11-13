package com.example.demo.guava;

import com.example.demo.bean.User;
import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.primitives.Ints;

import java.util.List;
import java.util.Map;

/**
 * guava工具类
 */
public class Test {
    public static void main(String[] args) {
        Map<String, String> eurPriceMap = Maps.newHashMap();
        eurPriceMap.put("aaa", "111");
        eurPriceMap.put("bbbb","4444");


        Map<String, Map<String, String>> map = Maps.newHashMap();
        List<List<Map<String, String>>> lists = Lists.newArrayList();
        Map<String,User> userMap= Maps.newHashMap();

        List<String> list = Lists.newArrayList("one","two","three");
        for(String str:list){
            System.out.println(str);
        }

        String interfacesStr= Joiner.on(";").join(list);
        System.out.println(interfacesStr);

        Map params = ImmutableMap.of("name","zhangsan", "age", 20);

        int compare = Ints.compare(10, 12);
        System.out.println(compare);

    }
}
