package com.example.demo.run;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * 服务启动执行
 * @author xing
 */
@Component
//@Order(value=2) 设置运行顺序
public class MyStartupRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		 System.out.println(">>>>>服务启动执行，执行加载数据等操作<<<<<<<<<<<<<");
	}

}
